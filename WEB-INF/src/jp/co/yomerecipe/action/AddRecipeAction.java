package jp.co.yomerecipe.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.yomerecipe.dao.IndicatorDao;
import jp.co.yomerecipe.dto.IndicatorDto;
import yang.framework.action.BasicAction;
import yang.framework.annotation.Authority;
import yang.framework.annotation.Session;

/**
 * レシピ追加画面のアクション
 * @author VV000584
 *
 */
public class AddRecipeAction extends BasicAction {

	@Session
	public ArrayList<IndicatorDto> indicators;

	/**
	 *　管理者限定
	 */
	@Override
	@Authority(type="admin")
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		indicators = IndicatorDao.getAllIndicator();
		return "/WEB-INF/YRS109_MRecipeAdd.jsp";
	}

}
