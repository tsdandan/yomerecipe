package jp.co.yomerecipe.model;

import java.util.ArrayList;
import java.util.Date;

import yang.framework.util.ClassUtil;
import yang.framework.util.StringUtil;
import jp.co.yomerecipe.dao.UserLevelDao;
import jp.co.yomerecipe.dao.TypeRecipeDao;
import jp.co.yomerecipe.dto.IndicatorDto;
import jp.co.yomerecipe.dto.TypeRecipeDto;
import jp.co.yomerecipe.dto.UserLevelDto;
import jp.co.yomerecipe.dto.form.servlet.UserLevelForm;

public class LevelModel {

	final static int[] levelTable = {0,5,10,30,60,100};

	/**
	 * 各インディケーターに対するユーザーのスコアとレベルを更新する
	 * @param userId
	 * @param recipeId
	 * @param fb
	 * @param indicators
	 */
	public static void updateLevel(Long userId, Long recipeId, int fb, ArrayList<IndicatorDto> indicators){
		for (IndicatorDto indicator : indicators){
			TypeRecipeDto recipeIndicator = TypeRecipeDao.getTypeRecipe(recipeId, indicator.getId());
			int score = fb*recipeIndicator.cooklevel;
			UserLevelDto userLevel = UserLevelDao.getUserLevel(userId,indicator.getId());
			UserLevelForm levelForm = new UserLevelForm();
			if (userLevel == null){
				levelForm.user_id = userId;
				levelForm.indicator_id = indicator.getId();
				levelForm.score += score;
				levelForm.cooklevel = getLevelFromScore(score);
				Long nowTime = new Date().getTime();
				levelForm.created_at = nowTime;
				levelForm.updated_at = nowTime;
				levelForm.created_id = userId;
				levelForm.updated_id = userId;
				levelForm.is_deleted = 0;
				UserLevelDao.insertUserLevel(levelForm);
			} else {
				levelForm = (UserLevelForm) ClassUtil.CreateAndCopy(levelForm.getClass(), userLevel);
				levelForm.score += score;
				levelForm.cooklevel = getLevelFromScore(levelForm.score);
				Long nowTime = new Date().getTime();
				levelForm.updated_at = nowTime;
				levelForm.updated_id = userId;
				UserLevelDao.updateUserLevel(levelForm);
			}
		}
	}

	/**
	 * スコアからレベルを換算する；
	 * @param score
	 * @return
	 */
	public static int getLevelFromScore(int score){
		for (int i = 0; i < levelTable.length; i++){
			if (score < levelTable[i]){
				return i;
			}
		}
		if (score > levelTable[levelTable.length-1]){
			return levelTable.length-1;
		}
		return 0;
	}
}
