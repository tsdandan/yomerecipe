<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="CommonHeader.jsp" flush="true"/>
<title>今日のレシピー嫁レシピ</title>
<meta name="keywords" content="レシピ, レコメンド, お勧め, 結婚, 婚活 , 花嫁修業, 料理, 美味しい, 簡単">
<meta name="description" content="今日のおすすめレシピ、今日はこちらのレシピを練習してください">
<link rel="stylesheet" href="public/css/usertop.css" type="text/css">
</head>
<body>
<jsp:include page="Header.jsp" flush="true"/>
<section class="main">
<div class="center_wrap">
<nav class="sidenav left">
		<div class="userinfo">
			<a href="Action/UserInfo?id=<c:out value='${user.id}'/>">
				<img src="public/img/<c:out value="${user.img_url}"/>" alt="<c:out value='${user.name }'/>さんの画像"/>
			</a>
			<div class="info">
				<a class="darkpink bold" href="Action/UserInfo?id=<c:out value='${user.id}'/>"><c:out value="${user.name}"/>さん</a>
			</div>
		</div>
		<div class="side_shadow">
		</div>

		<div class="sidenavpremium">
			<div class="titles">
				<span>料理の腕</span>
				<a href="Action/LevelGraph?id=<c:out value='${user.id}'/>" class="underline right nobold normal">詳細を見る</a>
			</div>
			<div id="sidenavlevel">
				<c:forEach var="indicator" items="${indicators}" varStatus="flag1">
				<table class="leveltable">
					<c:forEach var="ind" items="${indicator}" varStatus="flag2">
					<tr>
						<td><c:out value="${ind.name}" /></td>
						<c:forEach var="level" begin="1" end="${userLevels[flag1.index][flag2.index].cooklevel}">
							<td><img src="public/img/icon_heart_full.png" alt="ハートの画像"/></td>
						</c:forEach>
						<c:forEach var="level" begin="1" end="${5-userLevels[flag1.index][flag2.index].cooklevel}">
							<td><img src="public/img/icon_heart_blank.png" alt="空のハートの画像"/></td>
						</c:forEach>
					</tr>
					</c:forEach>
				</table>
				<c:if test="${!flag1.last}">
				<div class="line">
				</div>
				</c:if>
				</c:forEach>
			</div><!-- end of sidenavlevel -->
		</div><!-- end of premium -->
		<div class="side_shadow">
		</div>
	</nav>
<section class="content left">
	<section class="wrap">
		<div class="titles nomargin">
				<h1>今日のレシピ</h1>
		</div>
		<div id="todaysmenu">
			<div id="todays_menu_up">
				<a href="Action/RecipeDetail?user_id=<c:out value='${user.id}'/>&recipe_id=<c:out value='${todaysRecipe[0].id }'/>">
					<img class="radius_small imgshadow" src="public/img/<c:out value='${todaysRecipe[0].img_url }'/>" alt="<c:out value='${todaysRecipe[0].name }'/>の画像"/>
					</a>
				<div id="todays_menu_info">
					<a href="Action/RecipeDetail?user_id=<c:out value='${user.id}'/>&recipe_id=<c:out value='${todaysRecipe[0].id }'/>" class="title_normal">
						<c:out value='${todaysRecipe[0].name}'/>
					</a>
					<div class="descripe_normal">
						<c:out value='${todaysRecipe[0].description}'/>
					</div>
				</div>
			</div>
			<div class="clear">
			</div>
			<div class="line  today_divide">
			</div>
			<div class="todays_menu_down">
				<a href="Action/RecipeDetail?user_id=<c:out value='${user.id}'/>&recipe_id=<c:out value='${todaysRecipe[1].id }'/>">
					<img class="radius_small imgshadow" src="public/img/<c:out value='${todaysRecipe[1].img_url}'/>" alt="<c:out value='${todaysRecipe[1].name }'/>の画像"/></a>
				<div class="todays_menu_title">
					<a href="Action/RecipeDetail?user_id=<c:out value='${user.id}'/>&recipe_id=<c:out value='${todaysRecipe[1].id }'/>" class="title_normal">
						<c:out value='${todaysRecipe[1].name}'/>
					</a>
					<div class="descripe_normal">
						<c:out value='${todaysRecipe[1].description}'/>
					</div>
				</div>
			</div>
			<div class="hline today_hline">
			</div>
			<div class="todays_menu_down">
				<a href="Action/RecipeDetail?user_id=<c:out value='${user.id}'/>&recipe_id=<c:out value='${todaysRecipe[2].id }'/>">
					<img class="radius_small imgshadow" src="public/img/<c:out value='${todaysRecipe[2].img_url}'/>" alt="<c:out value='${todaysRecipe[2].name }'/>の画像"/></a>
				<div class="todays_menu_title">
					<a href="Action/RecipeDetail?user_id=<c:out value='${user.id}'/>&recipe_id=<c:out value='${todaysRecipe[2].id }'/>" class="title_normal">
						<c:out value='${todaysRecipe[2].name}'/>
					</a>
					<div class="descripe_normal">
						<c:out value='${todaysRecipe[2].description}'/>
					</div>
				</div>
			</div>

			<div class="clear">
			</div>
		</div>
		<div class="clear">
		</div>
		<div class="main_shadow">
		</div>
	</section>
	</section>
	<section id="hisarea">
		<div class="titles bold nomargin">
				作ったレシピ
			<a href="Action/HistoryRecipe?id=<c:out value='${user.id }'/>" class="underline right white nobold small">詳細を見る</a>
		</div>
		<div id="hiswrap">
		<div id="hislist">
			<c:forEach var="recipe" items="${userRecipe}">
			<div class="historymenu">
				<a href="Action/RecipeDetail?user_id=<c:out value='${user.id}'/>&recipe_id=<c:out value='${recipe.id }'/>">
					<img class="radius_small imgshadow" src="public/img/<c:out value='${recipe.img_url}'/>" alt="<c:out value='${recipe.name }'/>の画像"/>
				</a>
				<div class="historymenutitle">
					<a href="Action/RecipeDetail?user_id=<c:out value='${user.id}'/>&recipe_id=<c:out value='${recipe.id }'/>" class="title_small">
						<c:out value='${recipe.name}'/>
					</a>
				</div>
			</div>
			<div class="hline history_hline">
			</div>
			</c:forEach>
		</div>
		</div>
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