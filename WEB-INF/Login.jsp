<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<section id="login_wrap" class="hidden">
		<div class="login_content border_pink">
			<div class="title">
				<img src="public/img/title_login.png">
			</div>
			<form method="post" action="Action/Login">
			<table class="login_table">
				<tr>
					<td>メールアドレス:</td>
					<td><input type="text" name="username" class="input_normal radius" value=""/></td>
				</tr>
				<tr>
					<td>パスワード確認:</td>
					<td><input type="password" name="password" class="input_normal radius" value=""/></td>
				</tr>
				<tr>
					<td colspan=2  class="errormessage">
						<span id="errorlogin"><c:out value="${errorlogin }"/></span>
					</td>
				</tr>
			</table>
			<a onclick="javascript:submit(this)" id="btn_dologin" class="">
				<img src="public/img/popyp_login.png"/>
			</a>
			</form>
		</div>
	</section>