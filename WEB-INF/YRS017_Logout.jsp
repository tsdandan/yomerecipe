<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="CommonHeader.jsp" flush="true"/>
<title>ログアウトー嫁レシピ</title>
<meta name="keywords" content="結婚, 婚活, レシピ, 花嫁修業, 料理, 美味しい, 簡単">
<meta name="description" content="あなたの婚活をサポートするレシピレコメンドサイト">
<link rel="stylesheet" href="public/css/index.css" type="text/css">
<link rel="stylesheet" href="public/css/login.css" type="text/css">
<script type="text/javascript" src="public/js/popup.js"></script>
</head>
<body>
<section id="shade" class="hidden">
</section>
<header>
	<div class="header-content">
	<div class="logo_index">
		<img src="public/img/logo.png" height="70" alt="嫁レシピ"/>
	</div>
	<div class="login_area right">
		<a href="javascript:showlogin()" id="btn_login"></a>
		<a href="javascript:showreg()" id="btn_reg"></a>
	</div>
	<div class="line_noalpha clear" >
	</div>
	</div>
</header>
<section class="logout_main">
	<section class="center_wrap">
	<jsp:include page="Reg.jsp" flush="true"/>
	<jsp:include page="Login.jsp" flush="true"/>
	<div class="text_center title_huge pink">
		ログアウトが成功しました
	</div>
	<a href="Action/Index" id="btn_top" class="btn_gray_large">トップページに戻る</a>
	<a href="javascript:showlogin()" id="btn_login_main" class="btn_pink_large">ログイン</a>
	</section>
<section class="clear">
</section>
</section>
<jsp:include page="Footer.jsp" flush="true"/>
</body>
</html>