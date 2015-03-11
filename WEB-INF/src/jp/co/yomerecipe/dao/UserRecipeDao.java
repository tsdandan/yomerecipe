package jp.co.yomerecipe.dao;

import java.util.ArrayList;

import yang.framework.jdbc.JdbcManager;
import jp.co.yomerecipe.dto.RecipeDto;
import jp.co.yomerecipe.dto.UserRecipeDto;
import jp.co.yomerecipe.dto.form.CommonIdForm;
import jp.co.yomerecipe.dto.form.servlet.UserRecipeForm;

public class UserRecipeDao {


	public static int insertUserRecipe(UserRecipeForm userRecipe){
		return JdbcManager.getInstance()
				.updateBySqlFile("sqls/insert_userrecipe.sql", userRecipe)
				.excute();
	}

	public static ArrayList<UserRecipeDto> getUserRecipe(Long userId){
		return (ArrayList<UserRecipeDto>) JdbcManager.getInstance()
				.selectBySqlFile(UserRecipeDto.class,
						"sqls/get_userrecipe_by_user.sql",
						new CommonIdForm(userId))
				.getResultList();
	}

	public static ArrayList<UserRecipeDto> getUserRecipe(Long userId,int page,int limit){
		return (ArrayList<UserRecipeDto>) JdbcManager.getInstance()
				.selectBySqlFile(UserRecipeDto.class,
						"sqls/get_userrecipe_by_user.sql",
						new CommonIdForm(userId))
				.page(page)
				.limit(limit)
				.getResultList();
	}

	public static UserRecipeDto getUserRecipe(Long userId, Long recipeId){
		return JdbcManager.getInstance()
				.selectBySqlFile(UserRecipeDto.class,
						"sqls/get_userrecipe_by_user_recipe.sql",
						new CommonIdForm(userId),
						new CommonIdForm(recipeId))
				.getSingleResult();
	}

	public static int updateUserRecipe(UserRecipeForm userRecipe){
		return JdbcManager.getInstance()
				.updateBySqlFile("sqls/update_userrecipe.sql",
						userRecipe,
						new CommonIdForm(userRecipe.user_id),
						new CommonIdForm(userRecipe.recipe_id))
				.excute();
	}
}
