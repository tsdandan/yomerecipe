package jp.co.yomerecipe.model;

import java.util.ArrayList;

import jp.co.yomerecipe.dto.IndicatorDto;

/**
 * インディケーターの処理をするロジッククラス
 * @author VV000584
 *
 */
public class IndicatorModel {

	/**
	 * インディケーターのリストからIDのリストを取得
	 * @param indicators
	 * @return
	 */
	public static ArrayList<Long> getIds(ArrayList<IndicatorDto> indicators){
		ArrayList<Long> result = new ArrayList<Long>();
		for (IndicatorDto indicator : indicators){
			result.add(indicator.getId());
		}
		return result;
	}
}
