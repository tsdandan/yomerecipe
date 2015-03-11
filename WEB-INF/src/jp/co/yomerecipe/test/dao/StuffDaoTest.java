package jp.co.yomerecipe.test.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;

import jp.co.yomerecipe.dao.StuffDao;
import jp.co.yomerecipe.dto.StepDto;
import jp.co.yomerecipe.dto.StuffDto;

import org.junit.Before;
import org.junit.Test;

import yang.framework.servlet.AutoloadServlet;

public class StuffDaoTest {

	ArrayList<StuffDto> testListData = new ArrayList<StuffDto>();
	StuffDao stuffDao = new StuffDao();

	@Before
	public void setUp() throws Exception {
		AutoloadServlet autoload = new AutoloadServlet();
		autoload.init();
		StuffDto stuff = new StuffDto((long)1,(long)1,"stuff1","500g",0,(long)100001,(long)1,(long)100001,(long)1);
		testListData.add(stuff);
		stuff = new StuffDto((long)2,(long)1,"stuff2","500g",0,(long)100002,(long)2,(long)100002,(long)2);
		testListData.add(stuff);
		stuff = new StuffDto((long)3,(long)1,"stuff3","500g",0,(long)100003,(long)3,(long)100003,(long)3);
		testListData.add(stuff);
		stuff = new StuffDto((long)4,(long)2,"stuff4","500g",0,(long)100004,(long)4,(long)100004,(long)4);
		testListData.add(stuff);
		stuff = new StuffDto((long)5,(long)2,"stuff5","500g",0,(long)100005,(long)5,(long)100005,(long)5);
		testListData.add(stuff);
		stuff = new StuffDto((long)6,(long)3,"stuff6","500g",0,(long)100006,(long)6,(long)100006,(long)6);
		testListData.add(stuff);
		stuff = new StuffDto((long)7,(long)3,"stuff7","500g",1,(long)100007,(long)7,(long)100007,(long)7);
		testListData.add(stuff);
	}

	@Test
	public void testGetStuff() {
		ArrayList<StuffDto> result = stuffDao.getStuff((long)1);
		ArrayList<StuffDto> expire = new ArrayList<StuffDto>();
		expire.add(testListData.get(0));
		expire.add(testListData.get(1));
		expire.add(testListData.get(2));
		assertTrue(result.containsAll(expire)&&result.size()==expire.size());
	}

}
