package jp.co.yomerecipe.test.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.yomerecipe.test.dto.TestDto;
import jp.co.yomerecipe.test.dto.TestValidationDto;
import yang.framework.action.BasicAction;
import yang.framework.annotation.Resource;
import yang.framework.jdbc.JdbcManager;

public class TestCAction extends BasicAction{

	public TestDto test;

	@Resource
	public TestValidationDto testVDto;

	public String execute(HttpServletRequest request,
            HttpServletResponse response) {
		test = JdbcManager.getInstance().selectBySqlFile(TestDto.class, "/sqls/test.sql", testVDto)
					.getSingleResult();
		System.out.println(test.id);
		System.out.println(test.name);
        //request.setAttribute("msg", "test");
        return "/index.jsp";
    }
}
