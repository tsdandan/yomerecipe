<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="CommonHeader.jsp" flush="true"/>
<title>会員情報ー嫁レシピ</title>
<meta name="keywords" content="会員情報, レコメンド, 料理の腕, 結婚, 婚活 , 嫁, 料理, 美味しい, 簡単">
<meta name="description" content="<c:out value='${user.name }'/>さんの情報です">
<link rel="stylesheet" href="public/css/userinfo.css" type="text/css">
<script type="text/javascript" src="public/js/userinfo.js"></script>
</head>
<body>
<jsp:include page="Header.jsp" flush="true"/>
<section class="main">
<div class="center_wrap">
<nav class="sidenav">
	<div class="userinfo">
		<img src="public/img/<c:out value='${user.img_url }'/>" alt="<c:out value='${user.name }'/>さんの画像"/>
		<div class="info bold darkpink">
			<c:out value='${user.name }'/>さん
		</div>
	</div>
	<div class="sidemenu">
		<div class="titles bold">
			会員メニュー
		</div>
		<div class="menu_content ">
			<a id="btn_menu_info" class="btn_pink_large btn_menu" href="Action/UserInfo?id=<c:out value='${user.id }'/>">会員情報</a>
			<a id="btn_menu_level" class="btn_white_large btn_menu" href="Action/LevelGraph?id=<c:out value='${user.id }'/>">料理レベル</a>
		</div>
	</div>
</nav>
<section class="content">
	<section class="wrap" id="wrap_info">
		<div class="titles bold ">
				<h1>会員情報</h1>
		</div>
		<div class="wrap_content border_pink">
			<form action="Action/ModifyUser?id=<c:out value='${user.id}'/>" method="post">
			<table class="info_table">
				<tr>
					<td>メールアドレス</td>
					<td>
						<span class="span_normal"><c:out value='${user.email }'/></span>
					</td>
				</tr>
				<tr>
					<td>名前</td>
					<td>
						<input type="text" id="namelabel" class="input_normal radius" value="<c:out value='${user.name}'/>" onclick="javascripe:editname()" readonly/>
						<input type="text" id="nameedit" name="name" class="input_editing radius hidden" value="<c:out value='${user.name}'/>"/>
					</td>
				</tr>
				<tr>
					<td>年代</td>
					<td>
						<input type="text" id="agelabel" class="input_normal radius" value="<c:out value='${ageWord }'/>" onclick="javascripe:editage()" readonly/>
						<select id="ageedit" name="age" class="radius select_editing hidden">
							<option value="1">20~25歳</option>
							<option value="2">25~30歳</option>
							<option value="3">30~35歳</option>
							<option value="4">35歳以上</option>
						</select>
					</td>
				</tr>
			</table>
			<input type="hidden" name="token" value="<c:out value='${token }'/>"/>
			<a href="javascript:submit(btn_info_confirm)" id="btn_info_confirm" class="btn_white_large left">確認</a>
			</form>
			<a href="Action/UserInfo?id=<c:out value='${user.id}'/>" id="btn_info_reset" class="btn_white_large left">リセット</a>

		</div>
	</section>
</section>
	<div class="clear">
	</div>
</div>
</section>
<section class="clear">
</section>
<jsp:include page="Footer.jsp" flush="true"/>
</body>
</html>