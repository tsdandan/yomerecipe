package jp.co.yomerecipe.test.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;

import jp.co.yomerecipe.dao.UserLevelDao;
import jp.co.yomerecipe.dto.UserLevelDto;
import jp.co.yomerecipe.dto.form.servlet.UserLevelForm;

import org.junit.Before;
import org.junit.Test;

import yang.framework.servlet.AutoloadServlet;

public class LevelDaoTest {

	ArrayList<UserLevelDto> testListData = new ArrayList<UserLevelDto>();
	UserLevelDao levelDao = new UserLevelDao();

	@Before
	public void setUp() throws Exception {
		AutoloadServlet autoload = new AutoloadServlet();
		autoload.init();
		UserLevelDto userLevel = new UserLevelDto((long)1,(long)1,1,10,0,(long)100001,(long)1,(long)100001,(long)1);
		testListData.add(userLevel);
		userLevel = new UserLevelDto((long)2,(long)1,2,20,0,(long)100002,(long)2,(long)100002,(long)2);
		testListData.add(userLevel);
		userLevel = new UserLevelDto((long)3,(long)1,3,30,0,(long)100003,(long)3,(long)100003,(long)3);
		testListData.add(userLevel);
		userLevel = new UserLevelDto((long)1,(long)2,1,10,0,(long)100004,(long)4,(long)100004,(long)4);
		testListData.add(userLevel);
		userLevel = new UserLevelDto((long)2,(long)3,1,15,0,(long)100005,(long)5,(long)100005,(long)5);
		testListData.add(userLevel);
		userLevel = new UserLevelDto((long)4,(long)1,1,10,1,(long)100006,(long)6,(long)100006,(long)6);
		testListData.add(userLevel);
	}

	@Test
	public void testGetUserLevel() {
		ArrayList<Long> iids = new ArrayList<Long>();
		iids.add((long)1);
		iids.add((long)2);
		ArrayList<UserLevelDto> result = UserLevelDao.getUserLevels((long)1, iids);
		ArrayList<UserLevelDto> expire = new ArrayList<UserLevelDto>();
		expire.add(testListData.get(0));
		expire.add(testListData.get(3));
		assertTrue(result.containsAll(expire)&&result.size()==expire.size());
	}

	@Test
	public void testUpdateUserLevel(){
		UserLevelForm userlevel = new UserLevelForm();
		userlevel.user_id = (long)1;
		userlevel.indicator_id = (long) 1;
		userlevel.cooklevel = 2;
		userlevel.score = 20;
		userlevel.is_deleted = 0;
		userlevel.created_at = (long)100001;
		userlevel.created_id = (long)1;
		userlevel.updated_at = (long)100007;
		userlevel.updated_id = (long)1;
		int ret = UserLevelDao.updateUserLevel(userlevel);
		UserLevelDto expire = new UserLevelDto((long)1,(long)1,2,20,0,(long)100001,(long)1,(long)100007,(long)1);
		ArrayList<Long> iids = new ArrayList<Long>();
		iids.add((long)1);
		UserLevelDto result = UserLevelDao.getUserLevels((long)1, iids).get(0);
		assertTrue(ret==1&&result.equals(expire));
	}

	@Test
	public void testInsertUserLevel(){
		UserLevelForm userlevel = new UserLevelForm();
		userlevel.user_id = (long)1;
		userlevel.indicator_id = (long) 3;
		userlevel.cooklevel = 3;
		userlevel.score = 35;
		userlevel.is_deleted = 0;
		userlevel.created_at = (long)100007;
		userlevel.created_id = (long)7;
		userlevel.updated_at = (long)100007;
		userlevel.updated_id = (long)7;
		int ret = UserLevelDao.insertUserLevel(userlevel);
		UserLevelDto expire = new UserLevelDto((long)1,(long)3,3,35,0,(long)100007,(long)7,(long)100007,(long)7);
		ArrayList<Long> iids = new ArrayList<Long>();
		iids.add((long)3);
		UserLevelDto result = UserLevelDao.getUserLevels((long)1, iids).get(0);
		assertTrue(ret==1&&result.equals(expire));
	}

	@Test
	public void testGetUserLevelLong(){
		ArrayList<UserLevelDto> result = levelDao.getUserLevel((long)2);
		ArrayList<UserLevelDto> expire = new ArrayList<UserLevelDto>();
		expire.add(testListData.get(1));
		expire.add(testListData.get(4));
		assertTrue(result.containsAll(expire)&&result.size()==expire.size());
	}
}
