<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="CommonHeader.jsp" flush="true"/>
<title>料理レベルテスト結果ー嫁レシピ</title>
<meta name="keywordｓ" content="料理, 結婚, 婚活, レシピ, 嫁, 料理, 美味しい, 簡単">
<meta name="description" content="あなたの料理レベル">
<link rel="stylesheet" href="public/css/testresult.css" type="text/css">
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
	</div>
</header>
<section class="main">
	<section class="center_wrap">
	<jsp:include page="Reg.jsp" flush="true"/>
	<div class="titles bold text_center">
		<h1>あなたの料理レベル</h1>
	</div>
	<div class="question_wrap border_pink ">
		<c:forEach var="indicator" items="${tempIndicatorss}" varStatus="flag1">
		<div class="result_wrap">
			<div class="pink bold">
				食材の処理能力
			</div>
			<div class="line_noalpha">
			</div>
			<div class="level left">
				<table class="leveltable">
					<c:forEach var="ind" items="${indicator}" varStatus="flag2">
					<tr>
						<td><c:out value="${ind.name}" /></td>
						<c:forEach var="level" begin="1" end="${tempUserLevelss[flag1.index][flag2.index].cooklevel}">
							<td><img src="public/img/icon_heart_full.png" alt="ハートの画像"/></td>
						</c:forEach>
						<c:forEach var="level" begin="1" end="${5-tempUserLevelss[flag1.index][flag2.index].cooklevel}">
							<td><img src="public/img/icon_heart_blank.png" alt="空のハートの画像"/></td>
						</c:forEach>
					</tr>
					</c:forEach>
				</table>
			</div>
			<div class="advise left">
				<div class="pink title_normal">
					今のアドバイス
				</div>
				<div class="descripe_normal">
					野菜の料理を練習しよう！野菜の料理を練習しよう！野菜の料理を練習しよう！野菜の料理を練習しよう！野菜の料理を練習しよう！
				</div>
			</div>
		</div>
		</c:forEach>
		<a href="Action/Index" id="btn_top" class="btn_gray_large">トップページに戻る</a>
		<c:choose>
			<c:when test="${user!=null}">
				<a href="Action/TodaysRecipe?id=<c:out value='${user.id }'/>" id="btn_next" class="btn_pink_large">今から練習しよう</a>
			</c:when>
			<c:otherwise>
				<a href="javascript:showreg()" id="btn_next" class="btn_pink_large">今から練習しよう</a>
			</c:otherwise>
		</c:choose>
	</div>
<section class="clear">
</section>
	</section>
</section>
<jsp:include page="Footer.jsp" flush="true"/>
</body>
</html>