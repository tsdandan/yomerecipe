package jp.co.yomerecipe.model;

import java.util.Date;

import yang.framework.jdbc.JdbcManager;
import yang.framework.util.ClassUtil;
import yang.framework.util.DigestUtil;
import yang.framework.util.StringUtil;
import jp.co.yomerecipe.dao.UserDao;
import jp.co.yomerecipe.dao.UserRecipeDao;
import jp.co.yomerecipe.dto.UserDto;
import jp.co.yomerecipe.dto.UserRecipeDto;
import jp.co.yomerecipe.dto.form.CommonIdForm;
import jp.co.yomerecipe.dto.form.servlet.RegisterForm;
import jp.co.yomerecipe.dto.form.servlet.UserForm;
import jp.co.yomerecipe.dto.form.servlet.UserRecipeForm;

public class UserModel {

	public static String default_user_img="user.jpg";

	public static UserForm fillNewForm(RegisterForm register){
    	DigestUtil digest = new DigestUtil(DigestUtil.SHA512);
    	register.password= digest.hex(register.password);
		UserForm user = (UserForm) ClassUtil.CreateAndCopy(UserForm.class, register);
		user.is_deleted = 0;
		user.type = "user";
		Long nowTime = new Date().getTime();
		user.created_at = nowTime;
		user.updated_at = nowTime;
		user.is_premium = 0;
		user.img_url = default_user_img;
		Long maxId = UserDao.getMaxId().id+1;
		user.id = maxId;
		user.created_id = maxId;
		user.updated_id = maxId;
		user.cooklevel = 1;
		return user;
	}

	public static int UpdateUser(UserForm src,CommonIdForm userId){

		UserDto user = UserDao.getUserById(userId);
		UserForm cUserForm = (UserForm) ClassUtil.CreateAndCopy(UserForm.class, user);
		cUserForm.name = src.name;
		cUserForm.age = src.age;
		cUserForm.updated_at = new Date().getTime();
		cUserForm.updated_id = userId.id;
		return UserDao.updateUser(cUserForm, userId);
	}

	public static void updateRecipeHistory(Long userId, Long recipeId, int fb){
		UserRecipeDto userRecipe = UserRecipeDao.getUserRecipe(userId, recipeId);
		Long nowTime = new Date().getTime();
		if (userRecipe == null){
			UserRecipeForm form  = new UserRecipeForm();
			form.user_id = userId;
			form.recipe_id = recipeId;
			form.fbcounts = 1;
			form.feedback = fb;
			form.is_deleted = 0;
			form.last_feedback = nowTime;
			form.created_at = nowTime;
			form.updated_at = nowTime;
			form.created_id = userId;
			form.updated_id = userId;
			UserRecipeDao.insertUserRecipe(form);
		} else {
			UserRecipeForm form = (UserRecipeForm) ClassUtil.CreateAndCopy(UserRecipeForm.class, userRecipe);
			form.fbcounts = form.fbcounts+1;
			form.updated_at = nowTime;
			form.updated_id = userId;
			form.feedback = fb;
			UserRecipeDao.updateUserRecipe(form);
		}
	}
}
