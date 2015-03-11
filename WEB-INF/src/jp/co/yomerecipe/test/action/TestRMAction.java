package jp.co.yomerecipe.test.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.yomerecipe.test.dto.TestDto;
import jp.co.yomerecipe.test.dto.TestValidationDto;
import jp.co.yomerecipe.test.dto.TestValidationMultiDto;
import yang.framework.action.BasicAction;
import yang.framework.annotation.Resource;
import yang.framework.annotation.Session;
import yang.framework.jdbc.JdbcManager;

public class TestRMAction extends BasicAction{

	@Session
	public ArrayList<TestDto> tests;

	public TestValidationMultiDto testVDto;

	public String execute(HttpServletRequest request,
            HttpServletResponse response) {

		testVDto = new TestValidationMultiDto();
		testVDto.name = "aaa";
		tests = (ArrayList<TestDto>) JdbcManager.getInstance().selectBySqlFile(TestDto.class, "/sqls/test1.sql", testVDto)
				.getResultList();
        //request.setAttribute("msg", "test");
        return "/indexmulti.jsp";
    }
}
