package jp.co.yomerecipe.action;

import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.yomerecipe.dao.UserDao;
import jp.co.yomerecipe.dao.UserLevelDao;
import jp.co.yomerecipe.dto.UserDto;
import jp.co.yomerecipe.dto.form.CommonIdForm;
import jp.co.yomerecipe.dto.form.servlet.RegisterCheckForm;
import jp.co.yomerecipe.dto.form.servlet.RegisterForm;
import jp.co.yomerecipe.dto.form.servlet.UserForm;
import jp.co.yomerecipe.dto.form.servlet.UserLevelForm;
import jp.co.yomerecipe.model.UserModel;
import yang.framework.action.BasicAction;
import yang.framework.annotation.Resource;
import yang.framework.annotation.ResponseType;
import yang.framework.annotation.Session;
import yang.framework.dto.AuthDto;
import yang.framework.model.AuthModel;
import yang.framework.util.MessageUtil;
import yang.framework.validation.Operation;
import yang.framework.validation.ValidationManager;

@ResponseType(type="redirect")
public class RegisterAction extends BasicAction {

	@Resource
	public RegisterForm registerForm;

	private UserForm userForm;

	@Session
	public AuthDto auth;

	RegisterCheckForm checkForm;

	@Session
	public UserDto user;

	@Session
	public String error = "";

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		checkForm = new RegisterCheckForm();
		//エラーメッセージを消す
		HttpSession session = request.getSession();
		session.removeAttribute("errorlogin");
		session.removeAttribute("error");

		//メールとパスワードと名前のバリテーション
		error = ValidationManager.validation(registerForm.name,
				"名前",	Operation.MaxLength(10))
				.addValidation(registerForm.name, "名前", Operation.Required()).validateError();
		if (error.length()!=0){
			return "Index";
		}
		error = ValidationManager.validation(registerForm.email,
				"メールアドレス", Operation.Required(), Operation.Pattern("の形が不正です", Pattern.compile("\\w+(.\\w+)*@\\w+(.\\w+)+")))
				.addValidation(registerForm.email, "メールアドレス").validateError();
		if (error.length()!=0){
			return "Index";
		}
		error = ValidationManager.validation(registerForm.password,
				"パスワード", Operation.Required(), Operation.Pattern("の形が不正です", Pattern.compile(".*[a-zA-Z].*"),
						Pattern.compile(".*[0-9].*"),
						Pattern.compile(".*[!\"#\\u0024%&'\\u0028\\u0029\\u002A\\u002B,-\\u002E/:; =>\\u003F@\\u005B\\]\\u005E_`\\u007B\\u007C}~].*"))
						,Operation.MinLength(8)
						).validateError();
		if (error.length()!=0){
			return "Index";
		}
		error = ValidationManager.validation(registerForm.age, "年代",
				Operation.Required(),
				Operation.Pattern("は数字ではありません", Pattern.compile("[1-4]"))).validateError();
		if (error.length()!=0){
			return "Index";
		}
		error = ValidationManager.validation(registerForm.passwordConfirm, "パスワード確認", Operation.Required()).validateError();
		if (error.length()!=0){
			return "Index";
		}

		if (!registerForm.password.equals(registerForm.passwordConfirm)){
			error="二回入力のパスワードは一致しません";
			return "Index";
		}

		checkForm.email = registerForm.email;
		userForm = UserModel.fillNewForm(registerForm);

		if (UserDao.getUserByMail(checkForm)!=null){
			error="このメールアドレスは既に登録されました";
			return "Index";
		} else {
			UserDao.insertUser(userForm);
			auth = AuthModel.createAuth(userForm.id, "user", request);
			user = UserDao.getUserById(new CommonIdForm(userForm.id));

			if (session.getAttribute("userLevelDb")!=null){
				ArrayList<UserLevelForm> userLevelDb = (ArrayList<UserLevelForm>) session.getAttribute("userLevelDb");
				for (UserLevelForm userLevel : userLevelDb){
					userLevel.user_id = user.getId();
				}
				UserLevelDao.insertListUserLevel(userLevelDb);
				return "TodaysRecipe?id="+user.getId();
			}
		}
		return "CookTest";

	}

}
