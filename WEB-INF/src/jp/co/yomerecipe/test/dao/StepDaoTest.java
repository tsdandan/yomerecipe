package jp.co.yomerecipe.test.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;

import jp.co.yomerecipe.dao.StepDao;
import jp.co.yomerecipe.dto.StepDto;

import org.junit.Before;
import org.junit.Test;

import yang.framework.servlet.AutoloadServlet;

public class StepDaoTest {

	ArrayList<StepDto> testListData = new ArrayList<StepDto>();
	StepDao stepDao = new StepDao();
	@Before
	public void setUp() throws Exception {
		AutoloadServlet autoload = new AutoloadServlet();
		autoload.init();
		StepDto step = new StepDto((long)1,(long)1,"step1","detail","http",0,(long)100001,(long)1,(long)100001,(long)1);
		testListData.add(step);
		step = new StepDto((long)2,(long)1,"step2","detail","http",0,(long)100002,(long)2,(long)100002,(long)2);
		testListData.add(step);
		step = new StepDto((long)3,(long)1,"step3","detail","http",0,(long)100003,(long)3,(long)100003,(long)3);
		testListData.add(step);
		step = new StepDto((long)4,(long)2,"step4","detail","http",0,(long)100004,(long)4,(long)100004,(long)4);
		testListData.add(step);
		step = new StepDto((long)5,(long)2,"step5","detail","http",0,(long)100005,(long)5,(long)100005,(long)5);
		testListData.add(step);
		step = new StepDto((long)6,(long)3,"step6","detail","http",0,(long)100006,(long)6,(long)100006,(long)6);
		testListData.add(step);
		step = new StepDto((long)7,(long)3,"step7","detail","http",1,(long)100007,(long)7,(long)100007,(long)7);
		testListData.add(step);

	}

	@Test
	public void testGetStep() {
		ArrayList<StepDto> result = stepDao.getStep((long)1);
		ArrayList<StepDto> expire = new ArrayList<StepDto>();
		expire.add(testListData.get(0));
		expire.add(testListData.get(1));
		expire.add(testListData.get(2));
		assertTrue(result.containsAll(expire)&&result.size()==expire.size());
	}

}
