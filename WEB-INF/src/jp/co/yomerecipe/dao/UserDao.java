package jp.co.yomerecipe.dao;

import java.util.ArrayList;

import yang.framework.jdbc.JdbcManager;
import jp.co.yomerecipe.dto.UserDto;
import jp.co.yomerecipe.dto.form.CommonIdForm;
import jp.co.yomerecipe.dto.form.servlet.RegisterCheckForm;
import jp.co.yomerecipe.dto.form.servlet.UserForm;


public class UserDao {

	public static ArrayList<UserDto> getAllUser(){
		return (ArrayList<UserDto>) JdbcManager.getInstance()
				.selectBySqlFile(UserDto.class, "sqls/get_user_all.sql")
				.getResultList();
	}

	public static UserDto getUserByMail(RegisterCheckForm form){
		return (UserDto) JdbcManager.getInstance()
				.selectBySqlFile(UserDto.class, "sqls/get_user_by_mail.sql", form)
				.getSingleResult();
	}

	public static UserDto getUserById(CommonIdForm form){
		return (UserDto) JdbcManager.getInstance()
				.selectBySqlFile(UserDto.class, "sqls/get_user_by_id.sql", form)
				.getSingleResult();
	}

	public static int updateUser(UserForm user, CommonIdForm form){
		return JdbcManager.getInstance()
				.updateBySqlFile("sqls/update_user.sql", user, form)
				.excute();
	}

	public static int insertUser(UserForm user){
		return JdbcManager.getInstance()
				.updateBySqlFile("sqls/insert_user.sql", user)
				.excute();
	}

	public static CommonIdForm getMaxId(){
		return (CommonIdForm) JdbcManager.getInstance()
				.selectBySqlFile(CommonIdForm.class, "sqls/get_max_user_id.sql")
				.getSingleResult();
	}
}
