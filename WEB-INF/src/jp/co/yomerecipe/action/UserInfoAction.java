package jp.co.yomerecipe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.yomerecipe.dao.UserDao;
import jp.co.yomerecipe.dto.UserDto;
import jp.co.yomerecipe.dto.form.CommonIdForm;
import yang.framework.action.BasicAction;
import yang.framework.annotation.Authority;
import yang.framework.annotation.Resource;
import yang.framework.annotation.Session;

public class UserInfoAction extends BasicAction{

	@Session
	public int pagetype=3;

	@Resource
	public CommonIdForm idForm;

	@Session
	public UserDto user;

	@Session
	public String ageWord;

	@Override
	@Authority(type={"user","admin"},key_id="id")
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		user = UserDao.getUserById(idForm);

		switch (user.age){
			case 1: ageWord = "20~25歳";
				break;
			case 2: ageWord = "25~30歳";
				break;
			case 3: ageWord = "30~35歳";
				break;
			case 4: ageWord = "35歳以上";
				break;
		}
		return "/WEB-INF/YRS010_UserInfo.jsp";
	}


}
