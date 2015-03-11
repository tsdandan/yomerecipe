<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="CommonHeader.jsp" flush="true"/>
<title>嫁レシピ</title>
<meta name="keywords" content="結婚, 婚活, レシピ, 花嫁修業, 料理, 美味しい, 簡単">
<meta name="description" content="あなたの婚活をサポートするレシピレコメンドサイト">
<link rel="stylesheet" href="public/css/index.css" type="text/css">
<link rel="stylesheet" href="public/css/login.css" type="text/css">
<script type="text/javascript" src="public/js/slide.js"></script>
<script type="text/javascript" src="public/js/popup.js"></script>
</head>
<body>
<section id="shade" class="hidden">
</section>
<header>
	<div class="header-content">
		<div class="logo_index">
			<a href="Action/Index"><img src="public/img/logo.png" height="70" alt="嫁レシピ"/></a>
		</div>
		<div class="login_area right">
			<a href="javascript:showlogin();" id="btn_login"></a>
			<a href="javascript:showreg();" id="btn_reg"></a>
		</div>
	</div>
</header>
<div class="headline clear" >
</div>
<section class="main">
	<jsp:include page="Reg.jsp" flush="true"/>
	<jsp:include page="Login.jsp" flush="true"/>
	<section class="slide_wrap">
	<section class="slide_area text_center  slide_first"  id="slider1">
		<article class="slider">
			<img src="public/img/banner1.jpg"/ alt="スライダーー嫁レシピ">
		</article>
		<a id="btn_slide_reg1" href="javascript:showreg();"></a>
	</section>
	<section class="slide_area text_center slide_second"  id="sliderhide">
		<article class="slider">
			<img src="public/img/banner2.jpg"　alt="スライダーー嫁レシピ"/>
		</article>
		<a id="btn_slide_reg2" href="javascript:showreg();"></a>
	</section>
	<section class="slide_area text_center slide_first hidden"  id="slider2">
		<article class="slider">
			<img src="public/img/banner2.jpg"　alt="スライダーー嫁レシピ"/>
		</article>
		<a id="btn_slide_reg2" href="javascript:showreg();"></a>
	</section>
	<section class="slide_area text_center slide_first hidden"  id="slider3">
		<article class="slider">
			<img src="public/img/banner3.jpg"　alt="スライダーー嫁レシピ"/>
		</article>
		<a id="btn_slide_reg3" href="javascript:showreg();"></a>
	</section>
	</section>
	<section class="intro">
		<section class="center_wrap">
			<section class="intro_recipe left">
				<img src="public/img/banner_recommend.png" alt="レシピのレコメンド"/>
			</section>
			<section class="intro_level left">
				<img src="public/img/banner_levelup.png" alt="レベルアップ"/>
			</section>
			<section class="intro_test left">
				<a href="Action/CookTest" id="btn_gotest">
					<img src="public/img/button_test.png" alt="テストから始める"/>
				</a>
			</section>
		</section>
	</section>
</section>
<section class="clear">
</section>
<jsp:include page="Footer.jsp" flush="true"/>
</body>
</html>