package jp.co.yomerecipe.dao;

import java.util.ArrayList;

import jp.co.yomerecipe.dto.OptionScoreDto;
import jp.co.yomerecipe.dto.form.CommonIdForm;
import yang.framework.jdbc.JdbcManager;

public class OptionScoreDao {

	/**
	 * 選択肢のIDから選択肢のスコアを取る
	 * @param optionId
	 * @return
	 */
	public static ArrayList<OptionScoreDto> getOptionScoreByOption(Long optionId){
		return (ArrayList<OptionScoreDto>) JdbcManager.getInstance()
				.selectBySqlFile(OptionScoreDto.class, "sqls/get_option_score_by_option.sql",
						new CommonIdForm(optionId))
				.getResultList();
	}
}
