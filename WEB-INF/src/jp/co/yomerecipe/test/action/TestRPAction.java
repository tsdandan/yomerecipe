package jp.co.yomerecipe.test.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.yomerecipe.test.dto.TestDto;
import jp.co.yomerecipe.test.dto.TestValidationDto;
import yang.framework.action.BasicAction;
import yang.framework.annotation.Session;
import yang.framework.jdbc.JdbcManager;

public class TestRPAction extends BasicAction{

	@Session
	public TestDto test;

	public TestValidationDto testVDto;

	public String execute(HttpServletRequest request,
            HttpServletResponse response) {
		testVDto = new TestValidationDto();
		testVDto.id = (long) 1;
		test = JdbcManager.getInstance().selectBySqlFile(TestDto.class, "/sqls/testnor.sql", null)
					.getSingleResult();
        //request.setAttribute("msg", "test");
        return "/index.jsp";
    }
}
