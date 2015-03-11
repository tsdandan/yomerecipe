package jp.co.yomerecipe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yang.framework.action.BasicAction;

public class IndexAction extends BasicAction {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO 自動生成されたメソッド・スタブ
		return "/WEB-INF/YRS000_Index.jsp";
	}

}
