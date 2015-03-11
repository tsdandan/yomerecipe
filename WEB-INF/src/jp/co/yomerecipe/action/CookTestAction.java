package jp.co.yomerecipe.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.yomerecipe.dao.OptionDao;
import jp.co.yomerecipe.dao.QuestionDao;
import jp.co.yomerecipe.dto.OptionDto;
import jp.co.yomerecipe.dto.QuestionDto;
import yang.framework.action.BasicAction;
import yang.framework.annotation.Session;

public class CookTestAction extends BasicAction {

	@Session
	public ArrayList<QuestionDto> questions;

	@Session
	public ArrayList<ArrayList<OptionDto>> options;

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		questions = QuestionDao.getQuestionAll();

		options = new ArrayList<ArrayList<OptionDto>>();
		for (QuestionDto question : questions){
			options.add(OptionDao.getOptionByQuestion(question.getId()));
		}
		return "/WEB-INF/YRS003_CookTest.jsp";
	}

}
