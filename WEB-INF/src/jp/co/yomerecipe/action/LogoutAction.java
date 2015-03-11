package jp.co.yomerecipe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yang.framework.action.BasicAction;
import yang.framework.annotation.Session;

public class LogoutAction extends BasicAction {

	@Override
	@Session(type="destroy")
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		return "/WEB-INF/YRS017_Logout.jsp";
	}

}
