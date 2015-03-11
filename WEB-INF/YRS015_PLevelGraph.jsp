<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="CommonHeader.jsp" flush="true"/>
<title>料理レベルー嫁レシピ</title>
<meta name="keywords" content="会員情報, レコメンド, 料理の腕, 結婚, 婚活 , 嫁, 料理, 美味しい, 簡単">
<meta name="description" content="<c:out value='${user.name }'/>さんの料理レベルです">
<link rel="stylesheet" href="public/css/userinfo.css" type="text/css">
<script type="text/javascript" src="public/js/level.js"></script>
</head>
<body>
<jsp:include page="Header.jsp" flush="true"/>
<section class="main">
<div class="center_wrap">
<nav class="sidenav">
	<div class="userinfo">
		<a href="#">
			<img class="radius" src="public/img/<c:out value='${user.img_url }'/>" alt="<c:out value='${user.name }'/>さんの画像"/>
		</a>
		<div class="info">
			<a href="#"><c:out value='${user.name }'/>さん</a>
		</div>
		<div class="side_shadow">
		</div>
	</div>
	<div class="sidemenu">
		<div class="titles bold ">
			会員メニュー
		</div>
		<div class="menu_content ">
			<a id="btn_menu_info" class="btn_white_large btn_menu" href="Action/UserInfo?id=<c:out value='${user.id }' />">会員情報</a>
			<a id="btn_menu_level" class="btn_pink_large btn_menu" >料理レベル</a>
		</div>
		<div class="side_shadow">
		</div>
	</div>
</nav>
<section class="content">
	<section class="wrap" id="wrap_level">
		<div class="titles bold  nomargin">
				<h1>料理レベル</h1>
		</div>
		<div class="wrap_content  border_pink">
			<c:forEach var="indicator" items="${indicators}" varStatus="flag1">
			<div class="level_list">
			<div class="pink bold">
				食材の処理能力
			</div>
			<div class="line_noalpha">
			</div>
			<div class="level left">
				<div class="leveltable">
					<c:forEach var="ind" items="${indicator}" varStatus="flag2">
					<div class="indmark<c:out value='${flag1.index}'/> mark left <c:if test='${flag2.index!=0 }'> hidden </c:if>" id="indmark<c:out value='${flag1.index}'/>_<c:out value='${flag2.index}'/>" >
					</div>
					<a class="indlink<c:out value='${flag1.index}'/> <c:if test='${flag2.index==0 }'> selected </c:if>" id="indlink<c:out value='${flag1.index}'/>_<c:out value='${flag2.index}'/>" href="javascript:showhis(<c:out value='${flag1.index}'/>,<c:out value='${flag2.index}'/>)" class="selected" >
						<c:out value="${ind.name}" />
						<c:forEach var="level" begin="1" end="${5-userLevels[flag1.index][flag2.index].cooklevel}">
							<img src="public/img/icon_heart_blank.png" alt="ハートの画像"/>
						</c:forEach>
						<c:forEach var="level" begin="1" end="${userLevels[flag1.index][flag2.index].cooklevel}">
							<img src="public/img/icon_heart_full.png" alt="空のハートの画像"/>
						</c:forEach>
					</a>
					<div class="mark left hidden">
					</div>
					</c:forEach>
					</div>
			</div>
			<div class="hline_noalpha level_devide">
			</div>
			<div class="advise left">
				<div class="pink title_normal">
					今のアドバイス
				</div>
				<div class="descripe_normal">
					<c:out value="${adWords[flag1.index] }"/>
				</div>
			</div>
			<div class="clear">
			</div>
			<c:forEach var="ind" items="${indicator}" varStatus="flag2">
				<div id="his<c:out value='${flag1.index}'/>_<c:out value='${flag2.index }'/>" class="level_recipe_list his<c:out value='${flag1.index}'/> <c:if test='${flag2.index>0 }'>hidden </c:if>">
					<c:forEach var="recipe" items="${userRecipe[flag1.index][flag2.index]}" varStatus="flag3">
					<c:if test="${flag3.index==0 }">
						<div class="pink bold">
						作った<span class="pink"><c:out value="${ind.name}" /></span>の料理
						</div>
					</c:if>
					<div class="level_recipe left">
						<img src="public/img/<c:out value="${recipe.img_url}" />" alt="<c:out value='${recipe.name }'/>の画像"/>
						<span class="title_small center"><c:out value="${recipe.name}" /></span>
					</div>
					</c:forEach>
				</div>
			</c:forEach>
			</div>
			<div class="clear">
			</div>
			</c:forEach>
		</div>
	</section>
</section>
		<div class="side_shadow">
		</div>
	<div class="clear">
	</div>
</div>
</section>
<jsp:include page="Footer.jsp" flush="true"/>
</body>
</html>