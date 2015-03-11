package jp.co.yomerecipe.dao;

import java.util.ArrayList;

import yang.framework.jdbc.JdbcManager;
import jp.co.yomerecipe.dto.StepDto;
import jp.co.yomerecipe.dto.form.CommonIdForm;

public class StepDao {

	public static ArrayList<StepDto> getStep(Long recipeid){
		return (ArrayList<StepDto>) JdbcManager.getInstance()
				.selectBySqlFile(StepDto.class, "sqls/get_step_by_recipe.sql",
						new CommonIdForm(recipeid))
				.getResultList();
	}

	public static CommonIdForm getMaxId(){
		return (CommonIdForm) JdbcManager.getInstance()
				.selectBySqlFile(CommonIdForm.class, "sqls/get_max_step_id.sql")
				.getSingleResult();
	}

}
