package jp.co.yomerecipe.dao;

import java.util.ArrayList;

import yang.framework.jdbc.JdbcManager;
import jp.co.yomerecipe.dto.TypeRecipeDto;
import jp.co.yomerecipe.dto.form.CommonIdForm;

public class TypeRecipeDao {

	public static TypeRecipeDto getTypeRecipe(Long recipeId, Long indicatorId){
		return JdbcManager.getInstance().selectBySqlFile(TypeRecipeDto.class,
				"sqls/get_type_recipe.sql",
				new CommonIdForm(recipeId),
				new CommonIdForm(indicatorId))
				.getSingleResult();
	}

	public static ArrayList<TypeRecipeDto> getTypeRecipeByRecipe(Long recipeId){
		return (ArrayList<TypeRecipeDto>)JdbcManager.getInstance().selectBySqlFile(TypeRecipeDto.class,
				"sqls/get_type_recipe_by_recipe.sql",
				new CommonIdForm(recipeId))
				.orderBy("indicator_id")
				.getResultList();
	}
}
