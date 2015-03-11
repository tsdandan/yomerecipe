package jp.co.yomerecipe.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.yomerecipe.dao.IndicatorDao;
import jp.co.yomerecipe.dao.UserLevelDao;
import jp.co.yomerecipe.dao.RecipeDao;
import jp.co.yomerecipe.dao.UserRecipeDao;
import jp.co.yomerecipe.dto.IndicatorDto;
import jp.co.yomerecipe.dto.RecipeDto;
import jp.co.yomerecipe.dto.UserLevelDto;
import jp.co.yomerecipe.dto.UserRecipeDto;
import jp.co.yomerecipe.dto.form.CommonIdForm;
import jp.co.yomerecipe.dto.form.CommonIntForm;
import jp.co.yomerecipe.model.IndicatorModel;
import yang.framework.action.BasicAction;
import yang.framework.annotation.Authority;
import yang.framework.annotation.Resource;
import yang.framework.annotation.Session;
import yang.framework.util.ConfigUtil;

/**
 * ユーザーの料理レベルを取得するアクション
 * @author VV000584
 *
 */
public class LevelGraphAction extends BasicAction {

	@Session
	public int pagetype=3;

	@Resource
	public CommonIdForm idForm;

	@Session
	public ArrayList<ArrayList<IndicatorDto>> indicators;

	@Session
	public ArrayList<ArrayList<UserLevelDto>> userLevels;

	@Session
	public ArrayList<ArrayList<ArrayList<RecipeDto>>> userRecipe;

	@Session
	public String[] adWords = new String[3];

	@Override
	@Authority(type={"user","admin"},key_id="id")
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		indicators = new ArrayList<ArrayList<IndicatorDto>>();
		indicators.add(IndicatorDao.getIndicatorByType(new CommonIntForm(1)));
		indicators.add(IndicatorDao.getIndicatorByType(new CommonIntForm(2)));
		indicators.add(IndicatorDao.getIndicatorByType(new CommonIntForm(3)));

		userLevels = new ArrayList<ArrayList<UserLevelDto>>();
		for (int i = 0; i < 3; i++){
			ArrayList<Long> iids = IndicatorModel.getIds(indicators.get(i));
			ArrayList<UserLevelDto> tUserLevels = UserLevelDao.getUserLevels(idForm.id, iids);
			if (tUserLevels!=null&&tUserLevels.size()!=0){
				userLevels.add(tUserLevels);
				int minlevel = 6;
				Long mini = (long)0;
				for (UserLevelDto userLevel : tUserLevels){
					if (userLevel.cooklevel < minlevel){
						minlevel = userLevel.cooklevel;
						mini = userLevel.getIndicator_id();
					}
				}
				adWords[i] = (String) ConfigUtil.getInstance().getValue("advise"+mini);
			} else{
				adWords[i] = (String) ConfigUtil.getInstance().getValue("advise"+(i*4+1));
			}
		}

		userRecipe = new ArrayList<ArrayList<ArrayList<RecipeDto>>>();
		ArrayList<ArrayList<RecipeDto>> cUserRecipe = new ArrayList<ArrayList<RecipeDto>>();
		cUserRecipe = new ArrayList<ArrayList<RecipeDto>>();
		for (IndicatorDto ind : indicators.get(0)){
			cUserRecipe.add(RecipeDao.getUserIndicatorRecipe(idForm.id, ind.id));
		}
		userRecipe.add(cUserRecipe);
		cUserRecipe = new ArrayList<ArrayList<RecipeDto>>();
		for (IndicatorDto ind : indicators.get(1)){
			cUserRecipe.add(RecipeDao.getUserIndicatorRecipe(idForm.id, ind.id));
		}
		userRecipe.add(cUserRecipe);
		cUserRecipe = new ArrayList<ArrayList<RecipeDto>>();
		for (IndicatorDto ind : indicators.get(2)){
			cUserRecipe.add(RecipeDao.getUserIndicatorRecipe(idForm.id, ind.id));
		}
		userRecipe.add(cUserRecipe);
		return "/WEB-INF/YRS015_PLevelGraph.jsp";
	}

}
