package jp.co.yomerecipe.dao;

import java.util.ArrayList;

import jp.co.yomerecipe.dto.StuffDto;
import jp.co.yomerecipe.dto.form.CommonIdForm;
import yang.framework.jdbc.JdbcManager;

public class StuffDao {

	public static ArrayList<StuffDto> getStuff(Long recipeid){
		return (ArrayList<StuffDto>) JdbcManager.getInstance()
				.selectBySqlFile(StuffDto.class, "sqls/get_stuff_by_recipe.sql",
						new CommonIdForm(recipeid))
				.getResultList();
	}

	public static CommonIdForm getMaxId(){
		return (CommonIdForm) JdbcManager.getInstance()
				.selectBySqlFile(CommonIdForm.class, "sqls/get_max_stuff_id.sql")
				.getSingleResult();
	}

}
