package jp.co.yomerecipe.test.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;

import jp.co.yomerecipe.dao.RecipeDao;
import jp.co.yomerecipe.dto.RecipeDto;

import org.junit.Before;
import org.junit.Test;

import yang.framework.servlet.AutoloadServlet;

public class RecipeDaoTest {

	ArrayList<RecipeDto> testListData = new ArrayList<RecipeDto>();
	RecipeDao recipeDao = new RecipeDao();

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
	}

	@Test
	public void testGetRecipeAll() {
		ArrayList<RecipeDto> result = RecipeDao.getRecipeAll();
		ArrayList<RecipeDto> expire = new ArrayList<RecipeDto>();
		expire.add(testListData.get(0));
		expire.add(testListData.get(1));
		expire.add(testListData.get(2));
		assertTrue(result.containsAll(expire)&&result.size()==expire.size());
	}

	@Test
	public void testGetRecipeById() {
		RecipeDto result = RecipeDao.getRecipeById((long)2);
		RecipeDto expire = testListData.get(1);
		assertTrue(result.equals(expire));
	}

	@Test
	public void testGetUserIndicatorRecipe() {
		ArrayList<RecipeDto> result = RecipeDao.getUserIndicatorRecipe((long)1, (long)2);
		ArrayList<RecipeDto> expire = new ArrayList<RecipeDto>();
		expire.add(testListData.get(0));
		expire.add(testListData.get(1));
		expire.add(testListData.get(2));
		assertTrue(result.containsAll(expire)&&result.size()==expire.size());
	}
}
