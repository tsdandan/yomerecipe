<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
	<section id="reg_wrap" class="hidden">
		<div class="reg_content border_pink">
			<div class="title">
				<img src="public/img/title_enter.png">
			</div>
			<form action="Action/Register" method="post">
			<div class="line rline">
				</div>
			<div class="pink text_center title_small rtitle">
				基本情報
			</div>
			<table class="info_table">
				<tr>
					<td>名前:</td>
					<td><input type="text" name="name" class="input_normal radius" value=""/></td>
				</tr>
				<tr>
					<td>メールアドレス:</td>
					<td><input type="text" name="email" class="input_normal radius" value=""/></td>
				</tr>
				<tr>
					<td>年代:</td>
					<td>
						<select name="age" class="radius select_normal">
							<option value="1">20~25歳</option>
							<option value="2">25~30歳</option>
							<option value="3">30~35歳</option>
							<option value="4">35歳以上</option>
						</select>
					</td>
				</tr>
			</table>
			<div class="line rline">
				</div>
			<div class="pink text_center title_small rtitle">
				セキュリティー情報
			</div>
				<table class="info_table">
				<tr>
					<td>パスワード:</td>
					<td><input type="password" name="password" class="input_normal radius" value=""/></td>
				</tr>
				<tr>
					<td>パスワード確認:</td>
					<td><input type="password" name="passwordConfirm" class="input_normal radius" value=""/></td>
				</tr>
				<tr>
					<td colspan=2  class="errormessage">
						<span id="errorreg"><c:out value="${error }"/></span>
					</td>
				</tr>
			</table>
			<a href="javascript:hidepop()" id="btn_return">
				<img src="public/img/popup_cancel.png"/>
			</a>
			<a href="javascript:submit(btn_confirm)" id="btn_confirm">
				<img src="public/img/popup_enter.png"/>
			</a>
			</form>
		</div>
	</section>