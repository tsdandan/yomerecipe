package jp.co.yomerecipe.dao;

import java.util.ArrayList;

import jp.co.yomerecipe.dto.OptionDto;
import jp.co.yomerecipe.dto.form.CommonIdForm;
import yang.framework.jdbc.JdbcManager;

public class OptionDao {

	/**
	 * 問題の選択肢を取得
	 * @param questionId
	 * @return
	 */
	public static ArrayList<OptionDto> getOptionByQuestion(Long questionId){
		return (ArrayList<OptionDto>) JdbcManager.getInstance()
				.selectBySqlFile(OptionDto.class, "sqls/get_option_by_question.sql",
						new CommonIdForm(questionId))
				.getResultList();
	}

	/**
	 * IDから選択肢を取得
	 * @param optionId
	 * @return
	 */
	public static OptionDto getOptionById(Long optionId){
		return JdbcManager.getInstance()
				.selectBySqlFile(OptionDto.class, "sqls/get_option_by_id.sql",
						new CommonIdForm(optionId))
				.getSingleResult();
	}
}
