package jp.co.yomerecipe.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.yomerecipe.dao.UserDao;
import jp.co.yomerecipe.dto.UserDto;
import jp.co.yomerecipe.dto.form.servlet.LoginForm;
import yang.framework.action.BasicAction;
import yang.framework.annotation.Resource;
import yang.framework.annotation.ResponseType;
import yang.framework.annotation.Session;
import yang.framework.dto.AuthDto;
import yang.framework.model.AuthModel;
import yang.framework.util.DigestUtil;
import yang.framework.util.MessageUtil;
import yang.framework.util.StringUtil;
import yang.framework.validation.Operation;
import yang.framework.validation.ValidationManager;

@ResponseType(type="redirect")
public class LoginAction extends BasicAction {

	@Session
	public AuthDto auth;

	@Session
	public UserDto user;

	@Resource
	public LoginForm loginForm;

	@Session
	public String errorlogin = "";

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		ArrayList<UserDto> users = UserDao.getAllUser();
		//エラーメッセージを消す
		HttpSession session = request.getSession();
		session.removeAttribute("errorlogin");
		session.removeAttribute("error");

		//バリデーション
		errorlogin = ValidationManager.validation(loginForm.username,
				"メールアドレス",	Operation.Required()).validateError();
		if (errorlogin.length()!=0){
			return "Index";
		}
		errorlogin = ValidationManager.validation(loginForm.password,
				"パスワード",	Operation.Required()).validateError();
		if (errorlogin.length()!=0){
			return "Index";
		}

		//パスワードのハッシュ化
    	DigestUtil digest = new DigestUtil(DigestUtil.SHA512);
    	loginForm.password= digest.hex(loginForm.password);
		boolean correct = false;
		//ユーザー名とパスワードが正しいかどうかを判断
		for (UserDto cuser : users){
			if (cuser.getEmail().equals(loginForm.username)
					&&cuser.getPassword().equals(loginForm.password)){
				correct = true;
				auth = AuthModel.createAuth(cuser.id, cuser.type, request);
				user = cuser;
			}
		}
		if (!correct){
			MessageUtil.getInstance().addError("IDまたはPasswordが不正");
			return "error.jsp";
		}
		if (user.type.equals("admin")){
			return "AddRecipe";
		}
		return "TodaysRecipe?id="+StringUtil.toString(user.getId());
	}

}
