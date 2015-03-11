package jp.co.yomerecipe.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.yomerecipe.dao.IndicatorDao;
import jp.co.yomerecipe.dao.TypeRecipeDao;
import jp.co.yomerecipe.dao.UserLevelDao;
import jp.co.yomerecipe.dao.RecipeDao;
import jp.co.yomerecipe.dao.UserRecipeDao;
import jp.co.yomerecipe.dto.IndicatorDto;
import jp.co.yomerecipe.dto.RecipeDto;
import jp.co.yomerecipe.dto.TypeRecipeDto;
import jp.co.yomerecipe.dto.UserLevelDto;
import jp.co.yomerecipe.dto.UserRecipeDto;
import jp.co.yomerecipe.dto.form.CommonIdForm;
import jp.co.yomerecipe.dto.form.CommonIntForm;
import jp.co.yomerecipe.model.IndicatorModel;
import jp.co.yomerecipe.model.RecipeModel;
import yang.framework.action.BasicAction;
import yang.framework.annotation.Authority;
import yang.framework.annotation.Resource;
import yang.framework.annotation.Session;

public class TodaysRecipeAction extends BasicAction {

	@Session
	public int pagetype=1;

	@Resource
	public CommonIdForm idForm;

	@Session
	public ArrayList<RecipeDto> todaysRecipe;

	@Session
	public ArrayList<ArrayList<IndicatorDto>> indicators;

	@Session
	public ArrayList<ArrayList<UserLevelDto>> userLevels;

	@Session
	public ArrayList<RecipeDto> userRecipe;

	@Override
	@Authority(type={"user","admin"},key_id="id")
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		indicators = new ArrayList<ArrayList<IndicatorDto>>();
		indicators.add(IndicatorDao.getIndicatorByType(new CommonIntForm(1)));
		indicators.add(IndicatorDao.getIndicatorByType(new CommonIntForm(2)));

		userLevels = new ArrayList<ArrayList<UserLevelDto>>();
		ArrayList<Long> iids = IndicatorModel.getIds(indicators.get(0));
		userLevels.add(UserLevelDao.getUserLevels(idForm.id, iids));
		iids = IndicatorModel.getIds(indicators.get(1));
		userLevels.add(UserLevelDao.getUserLevels(idForm.id, iids));

		userRecipe = RecipeDao.getUserRecipe(idForm.id);

		ArrayList<IndicatorDto> cIndicator = IndicatorDao.getAllIndicator();
		iids = IndicatorModel.getIds(cIndicator);
		ArrayList<RecipeDto> cRecipes = RecipeDao.getRecipeAll();
		ArrayList<UserLevelDto> cUserLevls = UserLevelDao.getUserLevels(idForm.id, iids);

		ArrayList<ArrayList<TypeRecipeDto>> cTypeRecipes = new ArrayList<ArrayList<TypeRecipeDto>>();
		for (RecipeDto recipe : cRecipes){
			ArrayList<TypeRecipeDto> typeRecipe = TypeRecipeDao.getTypeRecipeByRecipe(recipe.getId());
			cTypeRecipes.add(typeRecipe);
		}

		ArrayList<UserRecipeDto> userRecipes = UserRecipeDao.getUserRecipe(idForm.id);
		todaysRecipe = RecipeModel.todaysRecipe(cRecipes, cUserLevls, iids, cTypeRecipes, userRecipes);

		return "/WEB-INF/YRS006_UserTop.jsp";
	}


}
