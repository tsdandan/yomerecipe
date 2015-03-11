package jp.co.yomerecipe.dao;

import java.util.ArrayList;

import jp.co.yomerecipe.dto.QuestionScoreDto;
import jp.co.yomerecipe.dto.form.CommonIdForm;
import yang.framework.jdbc.JdbcManager;

public class QuestionScoreDao {

	/**
	 * 問題IDから問題スコアを取る
	 * @param questionId
	 * @return
	 */
	public static ArrayList<QuestionScoreDto> getQuestionScoreByQuestion(Long questionId){
		return (ArrayList<QuestionScoreDto>) JdbcManager.getInstance()
				.selectBySqlFile(QuestionScoreDto.class, "sqls/get_question_score_by_question.sql",
						new CommonIdForm(questionId))
				.getResultList();
	}
}
