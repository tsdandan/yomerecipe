package jp.co.yomerecipe.model;

import java.util.ArrayList;
import java.util.HashMap;

import jp.co.yomerecipe.dto.RecipeDto;
import jp.co.yomerecipe.dto.TypeRecipeDto;
import jp.co.yomerecipe.dto.UserLevelDto;
import jp.co.yomerecipe.dto.UserRecipeDto;

public class RecipeModel {

	/**
	 *
	 * @return
	 */
	public static ArrayList<RecipeDto> todaysRecipe(ArrayList<RecipeDto> allrecipe,
			ArrayList<UserLevelDto> userLevels, ArrayList<Long> indicatorIds,
			ArrayList<ArrayList<TypeRecipeDto>> typeRecipes, ArrayList<UserRecipeDto> userRecipes){
		ArrayList<RecipeDto> result = new ArrayList<RecipeDto>();
		Double[] point = new Double[allrecipe.size()];

		//マッピングする
		HashMap<Long, RecipeDto> recipeMap = new HashMap<Long, RecipeDto>();
		HashMap<Long, UserRecipeDto> userRecipeMap = new HashMap<Long, UserRecipeDto>();
		HashMap<Long, UserLevelDto> userLevelMap = new HashMap<Long, UserLevelDto>();
		HashMap<Long, HashMap<Long, TypeRecipeDto>> typeRecipeMap = new HashMap<Long, HashMap<Long, TypeRecipeDto>>();

		if (allrecipe!=null){
			for (RecipeDto recipe : allrecipe){
				recipeMap.put(recipe.id, recipe);
			}
		}
		if (userRecipes!=null){
			for (UserRecipeDto userRecipe : userRecipes){
				userRecipeMap.put(userRecipe.recipe_id, userRecipe);
			}
		}
		if (userLevels!=null){
			for (UserLevelDto userLevel : userLevels){
				userLevelMap.put(userLevel.indicator_id, userLevel);
			}
		}

		if (typeRecipes!=null){
			for (ArrayList<TypeRecipeDto> typeRecipe : typeRecipes){
				HashMap<Long, TypeRecipeDto> temp = new HashMap<Long, TypeRecipeDto>();
				if (typeRecipe == null){
					continue;
				}
				for (TypeRecipeDto cTypeRecipe : typeRecipe){
					temp.put(cTypeRecipe.getIndicator_id(), cTypeRecipe);
				}
				typeRecipeMap.put(typeRecipe.get(0).getRecipe_id(), temp);
			}
		}

		//レシピのレコメンド度を計算する
		//point=sum((5-L(r,i)-L(u,i)*alpha)*beta
		//L(r,i)はインディケーターごとのレシピのレベル
		//L(u,i)はインディケーターごとのユーザーのレベル
		//alpha＝（10-L(u,i))/5、ユーザーのレベルが高いほど、alphaが低くなる
		//beta=(1-0.2*N(u,r))、ユーザーがこのレシピを作った回数、回数が多いほど、betaが低くなる
		for (int i = 0; i < point.length; i++){
			double temp = 0;
			Long rid = allrecipe.get(i).id;
			if (typeRecipeMap.containsKey(rid)){
				for (Long iid : indicatorIds){
					if (typeRecipeMap.get(rid).containsKey(iid)&&userLevelMap.containsKey(iid)){
						TypeRecipeDto tTypeRecipe = typeRecipeMap.get(rid).get(iid);
						UserLevelDto tUserLevel = userLevelMap.get(iid);
						int difflevel = tTypeRecipe.cooklevel-tUserLevel.cooklevel;
						if (difflevel<0){
							continue;
						}
						double alpha = (10-difflevel)/(double)5;
						double iPoint = (5-difflevel)*alpha;
						temp+=iPoint;
					}
				}
			}
			double beta = 1;
			if (userRecipeMap.containsKey(rid)){
				beta = 1-0.2*userRecipeMap.get(rid).fbcounts;
				if (beta<0) beta=0;
			}
			point[i] = temp*beta;
		}

		//pointが上位三個のレシピを返す
		Long[] rids = new Long[allrecipe.size()];
		for (int i = 0; i < allrecipe.size(); i++){
			rids[i] = allrecipe.get(i).id;
		}
		for (int i = 0; i < 3; i++){
			double max = 0;
			int maxj = i;
			for (int j = i; j < point.length; j++){
				if (point[j]>max) {
					max = point[j];
					maxj = j;
				}
			}
			double temp = point[maxj];
			point[maxj] = point[i];
			point[i] = temp;
			Long tempid = rids[maxj];
			rids[maxj] = rids[i];
			rids[i] = tempid;
			result.add(recipeMap.get(rids[i]));
		}
		return result;
	}
}
