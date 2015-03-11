<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="CommonHeader.jsp" flush="true"/>
<link rel="stylesheet" href="public/css/login.css" type="text/css">
<link rel="stylesheet" href="public/css/index.css" type="text/css">
</head>
<body>
<header>
	<div class="header-content">
	<div class="logo_index">
		<img src="public/img/logo.png" height="70" alt="嫁レシピ"/>
	</div>
	<div class="line_noalpha clear" >
	</div>
	</div>
</header>
<section class="logout_main">
	<div class="center_wrap text_center">
		<c:forEach var="error" items="${errors}">
			<p><c:out value="${error}"/></p>
		</c:forEach>
	<a href="<c:out value='${backurl}'/>" id="btn_back" class="btn_pink_large">前のページに戻る</a>
	</div>
</section>
</body>
</html>