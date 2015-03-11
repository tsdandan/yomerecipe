package jp.co.yomerecipe.test.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;

import jp.co.yomerecipe.dao.TypeRecipeDao;
import jp.co.yomerecipe.dto.TypeRecipeDto;

import org.junit.Before;
import org.junit.Test;

import yang.framework.servlet.AutoloadServlet;

public class RecipeIndicatorDaoTest {

	ArrayList<TypeRecipeDto> testListData = new ArrayList<TypeRecipeDto>();

	@Before
	public void setUp() throws Exception {
		AutoloadServlet autoload = new AutoloadServlet();
		autoload.init();
		TypeRecipeDto recipeIndicator = new TypeRecipeDto((long)1,(long)1,1,0,(long)100001,(long)1,(long)100001,(long)1);
		testListData.add(recipeIndicator);
		recipeIndicator = new TypeRecipeDto((long)2,(long)1,1,0,(long)100002,(long)2,(long)100002,(long)2);
		testListData.add(recipeIndicator);
		recipeIndicator = new TypeRecipeDto((long)1,(long)2,1,0,(long)100003,(long)3,(long)100003,(long)3);
		testListData.add(recipeIndicator);
		recipeIndicator = new TypeRecipeDto((long)1,(long)3,1,0,(long)100004,(long)4,(long)100004,(long)4);
		testListData.add(recipeIndicator);
		recipeIndicator = new TypeRecipeDto((long)2,(long)2,1,0,(long)100005,(long)5,(long)100005,(long)5);
		testListData.add(recipeIndicator);
		recipeIndicator = new TypeRecipeDto((long)3,(long)2,1,0,(long)100006,(long)6,(long)100006,(long)6);
		testListData.add(recipeIndicator);
		recipeIndicator = new TypeRecipeDto((long)3,(long)1,1,1,(long)100007,(long)7,(long)100007,(long)7);
		testListData.add(recipeIndicator);
		recipeIndicator = new TypeRecipeDto((long)3,(long)4,1,0,(long)100008,(long)8,(long)100008,(long)8);
		testListData.add(recipeIndicator);
	}

	@Test
	public void testGetRecipeIndicator() {
		TypeRecipeDto result = TypeRecipeDao.getTypeRecipe((long)1, (long)1);
		TypeRecipeDto expire = testListData.get(0);
		assertTrue(result.equals(expire));
	}

	@Test
	public void testGetRecipeIndicator1() {
		TypeRecipeDto result = TypeRecipeDao.getTypeRecipe((long)2, (long)1);
		TypeRecipeDto expire = testListData.get(1);
		assertTrue(result.equals(expire));
	}

}
