package jp.co.yomerecipe.test.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.yomerecipe.test.dto.TestDto;
import jp.co.yomerecipe.test.dto.TestValidationDto;
import yang.framework.action.BasicAction;
import yang.framework.jdbc.JdbcManager;

public class TestCRAction extends BasicAction{

	public TestDto test;

	public TestValidationDto testVDto;

	public String execute(HttpServletRequest request,
            HttpServletResponse response) {
		testVDto = new TestValidationDto();
		testVDto.id = (long) 100;
		test = JdbcManager.getInstance().selectBySqlFile(TestDto.class, "/sqls/test.sql", testVDto)
					.getSingleResult();
		System.out.println(test.id);
		System.out.println(test.name);
        //request.setAttribute("msg", "test");
        return "/index.jsp";
    }
}
