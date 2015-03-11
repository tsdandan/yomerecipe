package jp.co.yomerecipe.dao;

import java.util.ArrayList;
import java.util.List;

import jp.co.yomerecipe.dto.RecipeDto;
import jp.co.yomerecipe.dto.form.CommonCountForm;
import jp.co.yomerecipe.dto.form.CommonIdForm;
import jp.co.yomerecipe.dto.form.servlet.RecipeForm;
import jp.co.yomerecipe.dto.form.servlet.StepForm;
import jp.co.yomerecipe.dto.form.servlet.StuffForm;
import jp.co.yomerecipe.dto.form.servlet.TypeRecipeForm;
import yang.framework.jdbc.JdbcManager;

public class RecipeDao {

	public static ArrayList<RecipeDto> getRecipeAll(){
		return (ArrayList<RecipeDto>) JdbcManager.getInstance()
					.selectBySqlFile(RecipeDto.class, "sqls/get_recipe_all.sql")
					.orderBy("id")
					.getResultList();
	}

	public static RecipeDto getRecipeById(Long recipeId){
		return JdbcManager.getInstance()
				.selectBySqlFile(RecipeDto.class, "sqls/get_recipe_by_id.sql",
						new CommonIdForm(recipeId))
				.getSingleResult();
	}

	/**
	 * ユーザーとレシピヒストリーリストを取る
	 * @param userId
	 * @param indicatorId
	 * @return
	 */
	public static ArrayList<RecipeDto> getUserRecipe(Long userId){
		CommonIdForm form1 = new CommonIdForm(userId);
		return (ArrayList<RecipeDto>) JdbcManager.getInstance()
				.selectBySqlFile(RecipeDto.class, "sqls/get_recipe_by_user.sql", form1)
				.getResultList();
	}

	/**
	 * ユーザーとレシピヒストリーリストを取る
	 * @param userId
	 * @param indicatorId
	 * @return
	 */
	public static ArrayList<RecipeDto> getUserRecipe(Long userId,int page,int limit){
		CommonIdForm form1 = new CommonIdForm(userId);
		return (ArrayList<RecipeDto>) JdbcManager.getInstance()
				.selectBySqlFile(RecipeDto.class, "sqls/get_recipe_by_user.sql", form1)
				.page(page)
				.limit(limit)
				.getResultList();
	}

	/**
	 * ユーザーとレシピヒストリーリストを取る
	 * @param userId
	 * @param indicatorId
	 * @return
	 */
	public static CommonCountForm getCountUserRecipe(Long userId){
		CommonIdForm form1 = new CommonIdForm(userId);
		return (CommonCountForm) JdbcManager.getInstance()
				.selectBySqlFile(CommonCountForm.class, "sqls/count_recipe_by_user.sql", form1)
				.getSingleResult();
	}

	/**
	 * ユーザーと項目を指定したのレシピヒストリーリストを取る
	 * @param userId
	 * @param indicatorId
	 * @returnI
	 */
	public static ArrayList<RecipeDto> getUserIndicatorRecipe(Long userId, Long indicatorId){
		CommonIdForm form1 = new CommonIdForm(userId);
		CommonIdForm form2 = new CommonIdForm(indicatorId);
		return (ArrayList<RecipeDto>) JdbcManager.getInstance()
				.selectBySqlFile(RecipeDto.class, "sqls/get_recipe_by_user_indicator.sql",
						form1, form2)
				.getResultList();
	}

	public static CommonIdForm getMaxId(){
		return (CommonIdForm) JdbcManager.getInstance()
				.selectBySqlFile(CommonIdForm.class, "sqls/get_max_recipe_id.sql")
				.getSingleResult();
	}

	public static int addRecipe(RecipeForm recipe, ArrayList<StuffForm> stuffs, ArrayList<StepForm> steps, ArrayList<TypeRecipeForm> typeRecipes){
		List<String> sqls = new ArrayList<String>();
		List<List<Object>> datas = new ArrayList<List<Object>>();

		//レシピフォーンとｓｑｌを組合せ
		sqls.add("sqls/insert_recipe.sql");
		List<Object> recipes = new ArrayList<Object>();
		recipes.add(recipe);
		datas.add(recipes);

		//stuffとｓｑｌを組合せ
		for (StuffForm stuff : stuffs){
			sqls.add("sqls/insert_stuff.sql");
			List<Object> temp = new ArrayList<Object>();
			temp.add(stuff);
			datas.add(temp);
		}

		//stepとｓｑｌを組合せ
		for (StepForm step : steps){
			sqls.add("sqls/insert_step.sql");
			List<Object> temp = new ArrayList<Object>();
			temp.add(step);
			datas.add(temp);
		}

		//typerecipeとｓｑｌを組合せ
		for (TypeRecipeForm typeRecipe : typeRecipes){
			sqls.add("sqls/insert_typerecipe.sql");
			List<Object> temp = new ArrayList<Object>();
			temp.add(typeRecipe);
			datas.add(temp);
		}

		return JdbcManager.getInstance().updateBySqlFileWithTransaction(sqls, datas).excute();
	}
}
