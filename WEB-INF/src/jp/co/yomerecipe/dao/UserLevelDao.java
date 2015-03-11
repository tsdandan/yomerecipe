package jp.co.yomerecipe.dao;

import java.util.ArrayList;
import java.util.List;

import yang.framework.jdbc.JdbcManager;
import jp.co.yomerecipe.dto.UserLevelDto;
import jp.co.yomerecipe.dto.form.CommonIdForm;
import jp.co.yomerecipe.dto.form.servlet.UserLevelForm;

public class UserLevelDao {

	/**
	 * ユーザーのインディケーターのレベルをゲットする
	 * @param uid
	 * @param iids
	 * @return
	 */
	public static ArrayList<UserLevelDto> getUserLevels(Long uid,ArrayList<Long> iids){
		ArrayList<UserLevelDto> result = new ArrayList<UserLevelDto>();
		for (Long iid : iids){
			UserLevelDto userLevel = (UserLevelDto)JdbcManager.getInstance()
					.selectBySqlFile(UserLevelDto.class,
							"sqls/get_userlevel_by_user_indicator.sql",
							new CommonIdForm(uid),
							new CommonIdForm(iid))
					.getSingleResult();
			if (userLevel!=null)
				result.add(userLevel);

		}
		return result;
	}

	/**
	 * ユーザーとインディケーターを指定したレベルを取得
	 * @param uid
	 * @param indicatorid
	 * @return
	 */
	public static UserLevelDto getUserLevel(Long uid,Long indicatorid){
		return JdbcManager.getInstance()
					.selectBySqlFile(UserLevelDto.class,
							"sqls/get_userlevel_by_user_indicator.sql",
							new CommonIdForm(uid),
							new CommonIdForm(indicatorid))
					.getSingleResult();
	}

	/**
	 * ユーザーレベルを更新
	 * @param userLevel
	 * @return
	 */
	public static int updateUserLevel(UserLevelForm userLevel){
		return JdbcManager.getInstance()
				.updateBySqlFile("sqls/update_userlevel.sql",
						userLevel,
						new CommonIdForm(userLevel.user_id),
						new CommonIdForm(userLevel.indicator_id))
				.excute();
	}

	/**
	 *　ユーザーレベルを追加
	 * @param userLevel
	 * @return
	 */
	public static int insertUserLevel(UserLevelForm userLevel){
		return JdbcManager.getInstance()
				.updateBySqlFile("sqls/insert_userlevel.sql",
						userLevel)
				.excute();
	}

	/**
	 * ユーザーの全てのレベルを取得
	 * @param userid
	 * @return
	 */
	public ArrayList<UserLevelDto> getUserLevel(Long userid){
		return (ArrayList<UserLevelDto>) JdbcManager.getInstance()
				.selectBySqlFile(UserLevelDto.class,
						"sqls/get_userlevel_by_user.sql",
						new CommonIdForm(userid))
				.getResultList();
	}

	public static int insertListUserLevel(ArrayList<UserLevelForm> userLevels){
		List<String> sqls = new ArrayList<String>();
		List<List<Object>> datas = new ArrayList<List<Object>>();
		for (int i = 0; i < userLevels.size(); i++){
			sqls.add("sqls/insert_userlevel.sql");
			List<Object> tData = new ArrayList<Object>();
			tData.add(userLevels.get(i));
			datas.add(tData);
		}
		return JdbcManager.getInstance().updateBySqlFileWithTransaction(sqls, datas).excute();
	}
}
