<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<header>
	<nav class="headbar">
		<div class="center_wrap">
		<ul>
			<li><a href="Action/Logout">ログアウト</a></li>
			<li><a href="Action/UserInfo?id=<c:out value='${user.id }'/>"><c:out value="${user.name}"/>さん</a></li>
		</ul>
		</div>
	</nav>
	<nav class="navbar">
		<div class="center_wrap">
			<div class="logo">
				<a href="Action/Index"><img src="public/img/logo.png" alt="嫁レシピ"/></a>
			</div>
			<div class="topnav">
				<div class="navdivide"></div>
				<a href="Action/TodaysRecipe?id=<c:out value='${user.id }'/>" class="topnavlink nav_home<c:if test="${pagetype==1}">_select</c:if>">
					<span>HOME</span>
				</a>
				<div class="navdivide"></div>
				<a href="Action/HistoryRecipe?id=<c:out value='${user.id }'/>" class="topnavlink nav_history<c:if test="${pagetype==2}">_select</c:if>">
					<span>HISTORY</span>
				</a>
				<div class="navdivide"></div>
				<a href="Action/UserInfo?id=<c:out value='${user.id }'/>" class="topnavlink nav_mypage<c:if test="${pagetype==3}">_select</c:if>">
					<span>MYPAGE</span>
				</a>
			</div>
		</div>
	</nav>
</header>
<div class="top_shadow">
</div>