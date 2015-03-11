package jp.co.yomerecipe.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.yomerecipe.dao.IndicatorDao;
import jp.co.yomerecipe.dao.TypeRecipeDao;
import jp.co.yomerecipe.dao.UserLevelDao;
import jp.co.yomerecipe.dao.RecipeDao;
import jp.co.yomerecipe.dao.StepDao;
import jp.co.yomerecipe.dao.StuffDao;
import jp.co.yomerecipe.dao.UserRecipeDao;
import jp.co.yomerecipe.dto.IndicatorDto;
import jp.co.yomerecipe.dto.RecipeDto;
import jp.co.yomerecipe.dto.StepDto;
import jp.co.yomerecipe.dto.StuffDto;
import jp.co.yomerecipe.dto.TypeRecipeDto;
import jp.co.yomerecipe.dto.UserLevelDto;
import jp.co.yomerecipe.dto.UserRecipeDto;
import jp.co.yomerecipe.dto.form.CommonIntForm;
import jp.co.yomerecipe.dto.form.servlet.RecipeDetailForm;
import jp.co.yomerecipe.model.IndicatorModel;
import jp.co.yomerecipe.util.ConfigUtil;
import yang.framework.action.BasicAction;
import yang.framework.annotation.Authority;
import yang.framework.annotation.Resource;
import yang.framework.annotation.Session;
import yang.framework.util.MessageUtil;

/**
 * レシピ詳細画面のサーブレット
 * @author VV000584
 *
 */
public class RecipeDetailAction extends BasicAction{

	@Session
	public int pagetype=1;

	@Resource
	public RecipeDetailForm recipeDetailForm;

	@Session
	public RecipeDto recipe;

	@Session
	public ArrayList<StepDto> steps;

	@Session
	public ArrayList<StuffDto> stuffs;

	@Session
	public ArrayList<ArrayList<IndicatorDto>> indicators;

	@Session
	public ArrayList<ArrayList<UserLevelDto>> userLevels;

	@Session
	public UserRecipeDto userRecipe;

	@Session
	public ArrayList<TypeRecipeDto> typeRecipes;

	@Session
	public ArrayList<IndicatorDto> recipeIndicators;

	@Session
	public String fbwords;

	@Authority(type={"user","admin"})
	public String execute(HttpServletRequest request,
            HttpServletResponse response) {
		Long recipeId = recipeDetailForm.recipe_id;
		Long userId = recipeDetailForm.user_id;
		//レシピ詳細
		recipe = RecipeDao.getRecipeById(recipeId);
		if (recipe == null){
			MessageUtil.getInstance().addError("レシピが存在しない");
			return "";
		}

		//レシピの手順
		steps = StepDao.getStep(recipeId);

		//材料
		stuffs = StuffDao.getStuff(recipeId);

		//レベルの基準
		indicators = new ArrayList<ArrayList<IndicatorDto>>();
		indicators.add(IndicatorDao.getIndicatorByType(new CommonIntForm(1)));
		indicators.add(IndicatorDao.getIndicatorByType(new CommonIntForm(2)));
		indicators.add(IndicatorDao.getIndicatorByType(new CommonIntForm(3)));

		//ユーザーのレベル（基準ごと）
		userLevels = new ArrayList<ArrayList<UserLevelDto>>();
		ArrayList<Long> iids = IndicatorModel.getIds(indicators.get(0));
		userLevels.add(UserLevelDao.getUserLevels(userId, iids));
		iids = IndicatorModel.getIds(indicators.get(1));
		userLevels.add(UserLevelDao.getUserLevels(userId, iids));
		iids = IndicatorModel.getIds(indicators.get(2));
		userLevels.add(UserLevelDao.getUserLevels(userId, iids));

		//このレシピに対するユーザーの履歴
		userRecipe = UserRecipeDao.getUserRecipe(userId, recipeId);

		//レシピのレベル
		typeRecipes = TypeRecipeDao.getTypeRecipeByRecipe(recipeId);
		recipeIndicators = IndicatorDao.getIndicatorByRecipe(recipeId);

		if (userRecipe!=null){
			fbwords = ConfigUtil.fbString[userRecipe.feedback];
		}

        return "/WEB-INF/YRS009_RecipeDetail.jsp";
    }

}
