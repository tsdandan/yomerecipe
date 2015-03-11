package jp.co.yomerecipe.dao;

import java.util.ArrayList;

import jp.co.yomerecipe.dto.QuestionDto;
import yang.framework.jdbc.JdbcManager;

public class QuestionDao {

	/**
	 * 全ての問題を取得
	 * @return
	 */
	public static ArrayList<QuestionDto> getQuestionAll(){
		return (ArrayList<QuestionDto>) JdbcManager.getInstance()
				.selectBySqlFile(QuestionDto.class, "sqls/get_question_all.sql")
				.getResultList();
	}

}
