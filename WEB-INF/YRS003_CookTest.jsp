<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="CommonHeader.jsp" flush="true"/>
<title>料理レベルテストー嫁レシピ</title>
<meta name="keywords" content="料理, テスト, 結婚, 婚活, レシピ,  料理, 美味しい, 簡単">
<meta name="description" content="料理の腕を5分のテストで分かる">
<link rel="stylesheet" href="public/css/cooktest.css" type="text/css">
<script type="text/javascript" src="public/js/cooktest.js"></script>
</head>
<body>
<%
	String[] optionNo = {"A.","B.","C.","D.","E.","F.","G.","H."};
%>
<header>
	<div class="header-content">
	<div class="logo_index">
		<img src="public/img/logo.png" height="70" alt="嫁レシピ"/>
	</div>
	</div>
	<div class="clear"></div>
</header>
<section class="main">
	<section class="center_wrap">
	<div class="titles bold text_center ">
		<h1>料理レベルテスト(<span id="count">5</span>問/15問)</h1>
	</div>
	<div class="question_wrap border_pink ">
		<form method="POST" action="Action/CookTestResult">
		<c:forEach var="question" items="${questions }" varStatus="flag">
		<div class="questions" id="q<c:out value='${flag.index }'/>">
			<div class="pink title_normal">
				<c:out value="${flag.index+1}"/>．<c:out value="${question.title }"/>
			</div>
			<div class="question_content">
				<c:if test="${question.imgurl!=null }">
				<img src="public/img/<c:out value='${question.imgurl }'/>" alt="問題${flag.index }の画像"/>
				</c:if>
				<div class="radios_line">
					<c:choose>
					<c:when  test="${question.type==1}">
					<c:forEach var="option" items="${options[flag.index] }" varStatus="flag1">
						<div class="radios"><input type="radio" name="q<c:out value='${question.id }'/>" value="<c:out value='${option.id}'/>"/><c:out value="${optionNo[flag1.index]}"/><c:out value="${option.content }"/></div>
						<c:if test="${flag1.index % 2 == 1}">
							</div>
							<div class="radios_line">
						</c:if>
					</c:forEach>
					</c:when>
					<c:otherwise>
						<c:forEach var="option" items="${options[flag.index] }" varStatus="flag1">
						<div class="radios"><input type="checkbox" name="q<c:out value='${question.id }'/>" value="<c:out value='${option.id}'/>"/><c:out value="${optionNo[flag1.index]}"/><c:out value="${option.content }"/></div>
						<c:if test="${flag1.index % 2 == 1}">
							</div>
							<div class="radios_line">
						</c:if>
					</c:forEach>
					</c:otherwise>
					</c:choose>

				</div>
			</div>
		</div>
		</c:forEach>
		<input type="hidden" name="token" value="<c:out value='${auth.sessionId }' />"/>
		<a href="Action/Index" id="btn_return" class="btn_gray_large">キャンセル</a>
		<a href="javascript:showprev()" id="btn_prev" class="btn_pink_large">前の5問へ</a>
		<a href="javascript:shownext()" id="btn_next" class="btn_pink_large">次の5問へ</a>
		<a onclick="javascript:submit(this)" id="btn_submit" class="btn_pink_large">提出</a>
		</form>
	</div>
	</section>
</section>
<div class="headline clear" >
</div>
<jsp:include page="Footer.jsp" flush="true"/>
</body>
</html>