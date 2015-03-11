package jp.co.yomerecipe.action;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.yomerecipe.dao.RecipeDao;
import jp.co.yomerecipe.dao.UserRecipeDao;
import jp.co.yomerecipe.dto.RecipeDto;
import jp.co.yomerecipe.dto.UserRecipeDto;
import jp.co.yomerecipe.dto.form.CommonCountForm;
import jp.co.yomerecipe.dto.form.CommonIdForm;
import jp.co.yomerecipe.dto.form.CommonPagingForm;
import jp.co.yomerecipe.util.ConfigUtil;
import yang.framework.action.BasicAction;
import yang.framework.annotation.Authority;
import yang.framework.annotation.Resource;
import yang.framework.annotation.Session;
import yang.framework.util.StringUtil;

public class HistoryRecipeAction extends BasicAction {

	@Session
	public int pagetype=2;

	@Resource
	public CommonIdForm idForm;

	@Resource
	public CommonPagingForm pagingForm;

	@Session
	public ArrayList<RecipeDto> recipes;

	@Session
	public ArrayList<String> dates;

	@Session
	public ArrayList<String> fbs;

	//ページング要素
	//トータルページ数
	@Session
	public int totalPage;

	//
	@Session
	public int totalRecipeCount;

	@Session
	public int nowPage;

	@Session
	public int startAt;

	@Session
	public int endAt;

	@Override
	@Authority(type={"user","admin"},key_id="id")
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {

		//ページング
		CommonCountForm countForm = RecipeDao.getCountUserRecipe(idForm.id);
		totalPage = (countForm.c-1)/5 + 1;
		totalRecipeCount = countForm.c;
		nowPage = pagingForm.page;
		startAt = (nowPage-1)*5+1;
		endAt = totalRecipeCount < nowPage*5 ? totalRecipeCount : nowPage*5;

		recipes = RecipeDao.getUserRecipe(idForm.id,pagingForm.page,5);

		//フィードバックとフィードバックの時間を取得
		ArrayList<UserRecipeDto> userRecipes;
		userRecipes = UserRecipeDao.getUserRecipe(idForm.id,pagingForm.page,5);

		if (userRecipes != null){
			fbs = new ArrayList<String>();
			dates = new ArrayList<String>();
			for (UserRecipeDto userRecipe : userRecipes){
				fbs.add(ConfigUtil.fbString[userRecipe.feedback]);
				dates.add(StringUtil.toString(new Date(userRecipe.last_feedback), "yyyy年MM月dd日"));
			}
		}

		return "/WEB-INF/YRS008_HistoryRecipe.jsp";
	}

}
