package jp.co.yomerecipe.action;

import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.yomerecipe.dao.IndicatorDao;
import jp.co.yomerecipe.dto.IndicatorDto;
import jp.co.yomerecipe.dto.form.servlet.FeedbackForm;
import jp.co.yomerecipe.model.LevelModel;
import jp.co.yomerecipe.model.UserModel;
import yang.framework.action.BasicAction;
import yang.framework.annotation.Authority;
import yang.framework.annotation.Resource;
import yang.framework.annotation.ResponseType;
import yang.framework.validation.Operation;
import yang.framework.validation.ValidationManager;

@ResponseType(type="redirect")
public class FeedbackAction extends BasicAction {

	@Resource
	public FeedbackForm feedbackForm;

	@Override
	@Authority(type={"user","admin"},key_id="id")
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		Long recipeId = feedbackForm.recipeid;
		Long userId = feedbackForm.userid;
		int fb = feedbackForm.type;

		//ユーザーのフェードバックを更新
		UserModel.updateRecipeHistory(userId, recipeId, fb);

		//レシピに関するインディケーターを取得
		ArrayList<IndicatorDto>  indicators = IndicatorDao.getIndicatorByRecipe(recipeId);
		//ユーザーのスコアを更新する
		LevelModel.updateLevel(userId, recipeId, fb, indicators);

		return "RecipeDetail?user_id="+userId+"&recipe_id="+recipeId;
	}

}
