package jp.co.yomerecipe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.yomerecipe.dao.UserDao;
import jp.co.yomerecipe.dto.UserDto;
import jp.co.yomerecipe.dto.form.CommonIdForm;
import jp.co.yomerecipe.dto.form.servlet.UserForm;
import jp.co.yomerecipe.model.UserModel;
import yang.framework.action.BasicAction;
import yang.framework.annotation.Authority;
import yang.framework.annotation.Resource;
import yang.framework.annotation.ResponseType;
import yang.framework.annotation.Session;
import yang.framework.util.ClassUtil;

@ResponseType(type="redirect")
public class ModifyUserAction extends BasicAction {

	@Resource
	public CommonIdForm idForm;

	@Resource
	public UserForm userForm;

	@Session
	public UserDto user;

	@Override
	@Authority(type={"user","admin"},key_id="id")
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		user = UserDao.getUserById(idForm);
		int result = UserModel.UpdateUser(userForm,idForm);
		if (result==1){
			user = UserDao.getUserById(idForm);
		}
		return "Action/UserInfo?id=" + user.id;
	}

}
