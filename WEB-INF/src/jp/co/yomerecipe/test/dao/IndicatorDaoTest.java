package jp.co.yomerecipe.test.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;

import jp.co.yomerecipe.dao.IndicatorDao;
import jp.co.yomerecipe.dto.IndicatorDto;
import jp.co.yomerecipe.dto.form.CommonIntForm;

import org.junit.Before;
import org.junit.Test;

import yang.framework.servlet.AutoloadServlet;

public class IndicatorDaoTest {

	ArrayList<IndicatorDto> testListData = new ArrayList<IndicatorDto>();
	IndicatorDao indicatorDao = new IndicatorDao();

	@Before
	public void setUp() throws Exception {
		AutoloadServlet autoload = new AutoloadServlet();
		autoload.init();
		IndicatorDto indicator = new IndicatorDto((long)1, "indicator1", 1, 0, (long)100001, (long)1, (long)100001, (long)1);
		testListData.add(indicator);
		indicator = new IndicatorDto((long)2, "indicator2", 2, 0, (long)100002, (long)2, (long)100002, (long)2);
		testListData.add(indicator);
		indicator = new IndicatorDto((long)3, "indicator3", 3, 0, (long)100003, (long)3, (long)100003, (long)3);
		testListData.add(indicator);
		indicator = new IndicatorDto((long)4, "indicator4", 3, 1, (long)100004, (long)4, (long)100004, (long)4);
		testListData.add(indicator);
	}

	@Test
	public void testGetAllIndicator() {
		ArrayList<IndicatorDto> result = indicatorDao.getAllIndicator();
		ArrayList<IndicatorDto> expire = new ArrayList<IndicatorDto>();
		expire.add(testListData.get(0));
		expire.add(testListData.get(1));
		expire.add(testListData.get(2));
		assertTrue(result.containsAll(expire)&&result.size()==expire.size());
	}

	@Test
	public void testGetIndicatorByType() {
		CommonIntForm form = new CommonIntForm(1);
		ArrayList<IndicatorDto> result = indicatorDao.getIndicatorByType(form );
		ArrayList<IndicatorDto> expire = new ArrayList<IndicatorDto>();
		expire.add(testListData.get(0));
		assertTrue(result.containsAll(expire)&&result.size()==expire.size());
	}

	@Test
	public void testGetIndicatorByRecipe(){
		ArrayList<IndicatorDto> result = indicatorDao.getIndicatorByRecipe((long)1);
		ArrayList<IndicatorDto> expire = new ArrayList<IndicatorDto>();
		expire.add(testListData.get(0));
		expire.add(testListData.get(1));
		expire.add(testListData.get(2));
		assertTrue(result.containsAll(expire)&&result.size()==expire.size());
	}

}
