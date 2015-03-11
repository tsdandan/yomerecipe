package jp.co.yomerecipe.test.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;

import jp.co.yomerecipe.dao.UserDao;
import jp.co.yomerecipe.dto.UserDto;
import jp.co.yomerecipe.dto.form.CommonIdForm;
import jp.co.yomerecipe.dto.form.servlet.RegisterCheckForm;
import jp.co.yomerecipe.dto.form.servlet.UserForm;

import org.junit.Before;
import org.junit.Test;

import yang.framework.servlet.AutoloadServlet;

public class UserDaoTest {

	ArrayList<UserDto> testListData;
	static UserDao userDao = new UserDao();
	@Before
	public void setUp() throws Exception {
		AutoloadServlet autoload = new AutoloadServlet();
		autoload.init();
		UserDto user = new UserDto();
		testListData = new ArrayList<UserDto>();
		//test data 1
		user.setId((long) 1);
		user.setName("test1");
		user.setEmail("test1@gmail.com");
		user.setPassword("test");
		user.setType("user");
		user.setAge(1);
		user.setCooklevel(1);
		user.setIs_premium(0);
		user.setImg_url("user.jpg");
		user.setIs_deleted(0);
		user.setCreated_at((long)100001);
		user.setCreated_id((long) 1);
		user.setUpdated_at((long)100001);
		user.setUpdated_id((long) 1);
		testListData.add(user);

		//test data 2
		user = new UserDto();
		user.setId((long) 2);
		user.setName("test2");
		user.setEmail("test2@gmail.com");
		user.setPassword("test");
		user.setImg_url("user.jpg");
		user.setCooklevel(2);
		user.setIs_premium(1);
		user.setType("user");
		user.setIs_deleted(0);
		user.setCreated_at((long)100002);
		user.setCreated_id((long) 2);
		user.setUpdated_at((long)100002);
		user.setUpdated_id((long) 2);
		testListData.add(user);

		//test data 3
		user = new UserDto();
		user.setId((long) 3);
		user.setName("test3");
		user.setEmail("test3@gmail.com");
		user.setPassword("test");
		user.setType("user");
		user.setImg_url("user.jpg");
		user.setCooklevel(1);
		user.setIs_premium(1);
		user.setIs_deleted(1);
		user.setCreated_at((long)100003);
		user.setCreated_id((long) 3);
		user.setUpdated_at((long)100003);
		user.setUpdated_id((long) 3);
		testListData.add(user);

		//test data 4
		user = new UserDto();
		user.setId((long) 4);
		user.setName("test4");
		user.setEmail("test4@gmail.com");
		user.setPassword("test");
		user.setType("user");
		user.setAge(2);
		user.setCooklevel(2);
		user.setIs_premium(0);
		user.setImg_url("user.jpg");
		user.setIs_deleted(0);
		user.setCreated_at((long)100004);
		user.setCreated_id((long) 4);
		user.setUpdated_at((long)100004);
		user.setUpdated_id((long) 4);
		testListData.add(user);


		//test data 5
		user = new UserDto();
		user.setId((long) 5);
		user.setName("test5");
		user.setEmail("test5@gmail.com");
		user.setPassword("test");
		user.setType("user");
		user.setCooklevel(3);
		user.setIs_premium(0);
		user.setImg_url("user.jpg");
		user.setIs_deleted(0);
		user.setCreated_at((long)100005);
		user.setCreated_id((long) 5);
		user.setUpdated_at((long)100005);
		user.setUpdated_id((long) 5);
		testListData.add(user);
	}

	@Test
	public void testGetAllUser() {
		ArrayList<UserDto> result =	UserDao.getAllUser();
		ArrayList<UserDto> expire = new ArrayList<UserDto>();
		expire.add(this.testListData.get(0));
		expire.add(this.testListData.get(1));
		expire.add(this.testListData.get(3));
		expire.add(this.testListData.get(4));
		assertTrue(result.containsAll(expire)&&result.size()==expire.size());
	}

	@Test
	public void testGetUserByMail(){
		RegisterCheckForm form = new RegisterCheckForm();
		form.email = "test1@gmail.com";
		UserDto result = UserDao.getUserByMail(form);
		assertTrue(result.equals(testListData.get(0)));
	}

	@Test
	public void testGetUserById(){
		CommonIdForm form = new CommonIdForm();
		form.id = (long) 2;
		UserDto result = UserDao.getUserById(form);
		assertTrue(result.equals(testListData.get(1)));
	}

	@Test
	public void testInsertUser(){
		UserForm form = new UserForm();
		form.id = (long) 6;
		form.name ="test6";
		form.email = "test6@gmail.com";
		form.password = "test";
		form.type = "user";
		form.age = 1;
		form.is_deleted = 0;
		form.cooklevel = 4;
		form.is_premium = 0;
		form.img_url = "user.jpg";
		form.created_at = (long)100006;
		form.created_id = (long) 6;
		form.updated_at = (long)100006;
		form.updated_id = (long) 6;
		UserDao.insertUser(form);
		RegisterCheckForm cform = new RegisterCheckForm();
		cform.email = "test6@gmail.com";
		UserDto result = UserDao.getUserByMail(cform);
		UserDto user = new UserDto();
		user.setId((long) 6);
		user.setName("test6");
		user.setEmail("test6@gmail.com");
		user.setPassword("test");
		user.setType("user");
		user.setAge(1);
		user.setIs_deleted(0);
		user.setCooklevel(4);
		user.setIs_premium(0);
		user.setImg_url("user.jpg");
		user.setCreated_at((long)100006);
		user.setCreated_id((long) 6);
		user.setUpdated_at((long)100006);
		user.setUpdated_id((long) 6);
		assertTrue(user.equals(result));
	}

	@Test
	public void testUpdateUser(){
		UserForm form = new UserForm();
		form.id = (long) 5;
		form.name ="test5";
		form.email = "test5@gmail.com";
		form.password = "test";
		form.type = "user";
		form.is_deleted = 0;
		form.cooklevel = 9;
		form.is_premium = 0;
		form.img_url = "user.jpg";
		form.created_at = (long)100005;
		form.created_id = (long) 5;
		form.updated_at = (long)100015;
		form.updated_id = (long) 5;
		CommonIdForm idform = new CommonIdForm();
		idform.id = (long)5;
		UserDao.updateUser(form, idform);
		RegisterCheckForm cform = new RegisterCheckForm();
		cform.email = "test5@gmail.com";
		UserDto result = UserDao.getUserByMail(cform);
		UserDto user = new UserDto();
		user.setId((long) 5);
		user.setName("test5");
		user.setEmail("test5@gmail.com");
		user.setPassword("test");
		user.setType("user");
		user.setIs_deleted(0);
		user.setCooklevel(9);
		user.setIs_premium(0);
		user.setImg_url("user.jpg");
		user.setCreated_at((long)100006);
		user.setCreated_id((long) 5);
		user.setUpdated_at((long)100015);
		user.setUpdated_id((long) 5);
		assertTrue(user.equals(result));
		form.id = (long) 5;
		form.name ="test5";
		form.email = "test5@gmail.com";
		form.password = "test";
		form.type = "user";
		form.is_deleted = 0;
		form.cooklevel = 3;
		form.is_premium = 0;
		form.img_url = "user.jpg";
		form.created_at = (long)100005;
		form.created_id = (long) 5;
		form.updated_at = (long)100005;
		form.updated_id = (long) 5;
		UserDao.updateUser(form, idform);
	}

	@Test
	public void testGetMaxId(){
		CommonIdForm id = UserDao.getMaxId();
		assertTrue(id.id.equals((long)5));
	}
}
