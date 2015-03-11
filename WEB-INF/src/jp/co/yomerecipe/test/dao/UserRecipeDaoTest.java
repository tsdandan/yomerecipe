package jp.co.yomerecipe.test.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;

import jp.co.yomerecipe.dao.UserRecipeDao;
import jp.co.yomerecipe.dto.RecipeDto;
import jp.co.yomerecipe.dto.UserRecipeDto;
import jp.co.yomerecipe.dto.form.servlet.UserRecipeForm;

import org.junit.Before;
import org.junit.Test;

import yang.framework.servlet.AutoloadServlet;

public class UserRecipeDaoTest {

	ArrayList<RecipeDto> testListData = new ArrayList<RecipeDto>();
	ArrayList<UserRecipeDto> testListData1 = new ArrayList<UserRecipeDto>();
	UserRecipeDao recipeDao = new UserRecipeDao();

	@Before
	public void setUp() throws Exception {
		AutoloadServlet autoload = new AutoloadServlet();
		autoload.init();
		RecipeDto recipeDto = new RecipeDto((long)1,"recipe1",3,1,1.0,"recipe one",0,(long)100001,(long)1,(long)100001,(long)1);
		testListData.add(recipeDto);
		recipeDto = new RecipeDto((long)2,"recipe2",5,2,1.5,"recipe two",0,(long)100002,(long)2,(long)100002,(long)2);
		testListData.add(recipeDto);
		recipeDto = new RecipeDto((long)3,"recipe3",3,1,1.0,"recipe three",0,(long)100003,(long)3,(long)100003,(long)3);
		testListData.add(recipeDto);
		recipeDto = new RecipeDto((long)4,"recipe4",3,1,1.5,"recipe four",1,(long)100004,(long)4,(long)100004,(long)4);
		testListData.add(recipeDto);

		UserRecipeDto userRecipeDto = new UserRecipeDto((long)1,(long)1,(long)100001,3,1,0,(long)100001,(long)1,(long)100001,(long)1);
		testListData1.add(userRecipeDto);
		userRecipeDto = new UserRecipeDto((long)2,(long)1,(long)100002,2,2,0,(long)100002,(long)2,(long)100002,(long)2);
		testListData1.add(userRecipeDto);
		userRecipeDto = new UserRecipeDto((long)3,(long)1,(long)100003,3,2,0,(long)100003,(long)3,(long)100003,(long)3);
		testListData1.add(userRecipeDto);
		userRecipeDto = new UserRecipeDto((long)1,(long)3,(long)100004,5,1,0,(long)100004,(long)4,(long)100004,(long)4);
		testListData1.add(userRecipeDto);
		userRecipeDto = new UserRecipeDto((long)1,(long)4,(long)100005,1,3,1,(long)100005,(long)5,(long)100005,(long)5);
		testListData1.add(userRecipeDto);
		userRecipeDto = new UserRecipeDto((long)1,(long)2,(long)100006,5,3,0,(long)100006,(long)6,(long)100006,(long)6);
		testListData1.add(userRecipeDto);

	}


	@Test
	public void testInsertUserRecipe(){
		UserRecipeForm userRecipe = new UserRecipeForm();
		userRecipe.user_id = (long)2;
		userRecipe.recipe_id = (long)2;
		userRecipe.last_feedback = (long)100007;
		userRecipe.fbcounts = 4;
		userRecipe.feedback = 3;
		userRecipe.is_deleted = 0;
		userRecipe.created_at = (long)100007;
		userRecipe.created_id = (long)1;
		userRecipe.updated_at = (long)100007;
		userRecipe.updated_id = (long)1;
		int ret = recipeDao.insertUserRecipe(userRecipe);
		UserRecipeDto expire = new UserRecipeDto((long)2,(long)2,(long)100007,4,3,0,(long)100007,(long)1,(long)100007,(long)1);
		UserRecipeDto result = recipeDao.getUserRecipe((long)2, (long)2);
		assertTrue(ret==1&&result.equals(expire));
	}

	@Test
	public void testGetUserRecipeLongLong(){
		UserRecipeDto result = recipeDao.getUserRecipe((long)2, (long)1);
		UserRecipeDto expire = testListData1.get(1);
		assertTrue(result.equals(expire));
	}

	@Test
	public void testUpdateUserRecipe(){
		UserRecipeForm userRecipe = new UserRecipeForm();
		userRecipe.user_id = (long)1;
		userRecipe.recipe_id = (long)1;
		userRecipe.last_feedback = (long)100007;
		userRecipe.fbcounts = 4;
		userRecipe.feedback = 3;
		userRecipe.is_deleted = 0;
		userRecipe.created_at = (long)100007;
		userRecipe.created_id = (long)1;
		userRecipe.updated_at = (long)100007;
		userRecipe.updated_id = (long)1;
		int ret = recipeDao.updateUserRecipe(userRecipe);
		UserRecipeDto expire = new UserRecipeDto((long)1,(long)1,(long)100007,4,3,0,(long)100007,(long)1,(long)100007,(long)1);
		UserRecipeDto result = recipeDao.getUserRecipe((long)1, (long)1);
		assertTrue(ret==1&&result.equals(expire));
	}

}
