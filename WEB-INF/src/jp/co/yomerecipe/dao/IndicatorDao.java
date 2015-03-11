package jp.co.yomerecipe.dao;

import java.util.ArrayList;

import yang.framework.jdbc.JdbcManager;
import jp.co.yomerecipe.dto.IndicatorDto;
import jp.co.yomerecipe.dto.form.CommonIdForm;
import jp.co.yomerecipe.dto.form.CommonIntForm;

public class IndicatorDao {
	public static ArrayList<IndicatorDto> getAllIndicator(){
		return (ArrayList<IndicatorDto>) JdbcManager.getInstance()
				.selectBySqlFile(IndicatorDto.class, "sqls/get_indicator_all.sql")
				.getResultList();
	}

	public static ArrayList<IndicatorDto> getIndicatorByType(CommonIntForm form){
		return (ArrayList<IndicatorDto>) JdbcManager.getInstance()
				.selectBySqlFile(IndicatorDto.class,
						"sqls/get_indicator_by_type.sql",
						form)
						.getResultList();
	}

	public static ArrayList<IndicatorDto> getIndicatorByRecipe(Long recipeId){
		return (ArrayList<IndicatorDto>) JdbcManager.getInstance()
				.selectBySqlFile(IndicatorDto.class,
						"sqls/get_indicator_by_recipe.sql",
						new CommonIdForm(recipeId))
				.orderBy("id")
				.getResultList();
	}
}
