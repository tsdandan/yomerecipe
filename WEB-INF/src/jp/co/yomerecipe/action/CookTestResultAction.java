package jp.co.yomerecipe.action;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.yomerecipe.dao.IndicatorDao;
import jp.co.yomerecipe.dao.OptionDao;
import jp.co.yomerecipe.dao.OptionScoreDao;
import jp.co.yomerecipe.dao.QuestionDao;
import jp.co.yomerecipe.dao.QuestionScoreDao;
import jp.co.yomerecipe.dao.UserLevelDao;
import jp.co.yomerecipe.dto.IndicatorDto;
import jp.co.yomerecipe.dto.OptionDto;
import jp.co.yomerecipe.dto.OptionScoreDto;
import jp.co.yomerecipe.dto.QuestionDto;
import jp.co.yomerecipe.dto.QuestionScoreDto;
import jp.co.yomerecipe.dto.UserDto;
import jp.co.yomerecipe.dto.UserLevelDto;
import jp.co.yomerecipe.dto.form.CommonIntForm;
import jp.co.yomerecipe.dto.form.servlet.UserLevelForm;
import jp.co.yomerecipe.model.IndicatorModel;
import jp.co.yomerecipe.model.LevelModel;
import yang.framework.action.BasicAction;
import yang.framework.annotation.Resource;
import yang.framework.annotation.Session;
import yang.framework.util.ClassUtil;
import yang.framework.util.HttpServletUtil;
import yang.framework.util.IntegerUtil;
import yang.framework.util.StringUtil;

public class CookTestResultAction extends BasicAction {

	@Session
	public HashMap<Long,Integer> scores = new HashMap<Long,Integer>();

	@Session
	public ArrayList<ArrayList<IndicatorDto>> tempIndicatorss;

	@Session
	public ArrayList<ArrayList<UserLevelDto>> tempUserLevelss;

	@Session
	public ArrayList<UserLevelForm> userLevelDb;

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		ArrayList<QuestionDto> questions = QuestionDao.getQuestionAll();
		for (QuestionDto question: questions){
			String parName = "q"+StringUtil.toString(question.getId());
			int type = question.getType();
			if (type == 1){//redioの場合

				//リクエストからパラメータを取得
				Long answer = HttpServletUtil.getParameterLong(parName, request);
				ArrayList<QuestionScoreDto> cScores = QuestionScoreDao.getQuestionScoreByQuestion(question.getId());
				boolean isCorrect = false;

				if (answer != -1){
					OptionDto option = OptionDao.getOptionById(answer);

					if (option.is_correct == 1){
						isCorrect = true;
					}
				}
				//加点と減点を保存する
				for (QuestionScoreDto cScore : cScores){
					int tScore = 0;
					if (isCorrect){
						tScore = cScore.score_right;
					} else {
						tScore = cScore.score_wrong;
					}
					if (scores.containsKey(cScore.indicator_id)){
						tScore += scores.get(cScore.indicator_id);
					}
					scores.put(cScore.indicator_id, tScore);
				}
			} else{//checkboxの場合
				String[] answerStr = request.getParameterValues(parName);
				if (answerStr != null && answerStr.length > 0){
					for (int i = 0; i < answerStr.length; i++){
						Long optionId = IntegerUtil.toLong(answerStr[i]);
						ArrayList<OptionScoreDto> cScores = OptionScoreDao.getOptionScoreByOption(optionId);
						for (OptionScoreDto cScore : cScores){
							int tScore = cScore.score_right;
							if (scores.containsKey(cScore.indicator_id)){
								tScore += scores.get(cScore.indicator_id);
							}
							scores.put(cScore.indicator_id, tScore);
						}
					}
				}
			}
		}

		//レベルデーターを準備する
		//インディケーターを取得
		tempIndicatorss = new ArrayList<ArrayList<IndicatorDto>>();
		tempIndicatorss.add(IndicatorDao.getIndicatorByType(new CommonIntForm(1)));
		tempIndicatorss.add(IndicatorDao.getIndicatorByType(new CommonIntForm(2)));
		tempIndicatorss.add(IndicatorDao.getIndicatorByType(new CommonIntForm(3)));

		tempUserLevelss = new ArrayList<ArrayList<UserLevelDto>>();
		userLevelDb = new ArrayList<UserLevelForm>();
		HttpSession session = request.getSession();
		Long userId = (long)0;
		if (session.getAttribute("user")!=null){
			userId = ((UserDto) session.getAttribute("user")).getId();
		}
		for (int i = 0; i < 3; i++){
			ArrayList<UserLevelDto> tempUserLevels = new ArrayList<UserLevelDto>();
			for (IndicatorDto indicator : tempIndicatorss.get(i)){
				int score = IntegerUtil.toInt(scores.get(indicator.id));
				if (score < 0) {
					score = 0;
				}
				int level = LevelModel.getLevelFromScore(score);
				UserLevelDto userLevel = new UserLevelDto(userId,indicator.id,level,score);
				UserLevelForm userLevelForm = (UserLevelForm) ClassUtil.CreateAndCopy(UserLevelForm.class, userLevel);
				userLevelDb.add(userLevelForm);
				tempUserLevels.add(userLevel);
			}
			tempUserLevelss.add(tempUserLevels);
		}

		if (userId != 0){
			UserLevelDao.insertListUserLevel(userLevelDb);
		}

		return "/WEB-INF/YRS004_CookTestResult.jsp";
	}

}
