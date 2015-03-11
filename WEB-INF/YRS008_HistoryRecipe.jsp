<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="CommonHeader.jsp" flush="true"/>
<title>レシピ履歴一覧ー嫁レシピ</title>
<meta name="keywords" content="レシピ, レコメンド, 履歴, 結婚, 婚活 , 花嫁修業, 料理, 美味しい, 簡単">
<meta name="description" content="今まで作ったレシピの一覧です">
<link rel="stylesheet" href="public/css/history.css" type="text/css">
</head>
<body>
<jsp:include page="Header.jsp" flush="true"/>
<section class="main">
<section class="center_wrap">
<nav class="sidenav">
	<div class="userinfo">
			<a href="Action/UserInfo?id=<c:out value='${user.id}'/>">
				<img src="public/img/<c:out value="${user.img_url}"/>" alt="<c:out value='${user.name }'/>さんの画像"/>
			</a>
			<div class="info">
				<a class="darkpink bold" href="Action/UserInfo?id=<c:out value='${user.id}'/>"><c:out value="${user.name}"/>さん</a>
			</div>
	</div>
</nav>
<section class="content">
	<section class="wrap">
		<div class="titles bold  nomargin">
				<h1>過去のレシピ</h1>
		</div>
		<div>
		<div id="sortarea">
			<div class="div_sort">
					<label class="title_sort">並び順</label>
					<label class="colon_sort">:</label>
					<select class="select_sort radius_small">
						<option>時間の近い順</option>
						<option>時間の遠い順</option>
					</select>
			</div>
			<div id="pagingarea">
				<label class="pageinfo"><c:out value="${startAt}"/>件~<c:out value="${endAt }"/>件（全<c:out value="${totalRecipeCount }"/>件）</label>

					<c:if test="${nowPage>1 }">
						<a href="#" class="pagearrow">
							<img src="public/img/arror_left.png" alt="前のページへ"/>
						</a>
					</c:if>
					<c:if test="${nowPage==1 }">
						<a href="#" class="pagearrow">
							<img src="public/img/arror_left.png" alt="次のページへ"/>
						</a>
					</c:if>
				<a href="#" class="black">1</a>
				<c:forEach var="pageNum" begin="2" end="${totalPage }">
					<label>|</label>
					<a href="#" class="pink"><c:out value="${pageNum }"/></a>
				</c:forEach>
				<c:if test="${nowPage<totalPage }">
					<a href="#" class="pagearrow">
						<img src="public/img/arror_right.png" alt="前のページへ"/>
					</a>
				</c:if>
				<c:if test="${nowPage==totalPage }">
					<a href="#" class="pagearrow">
						<img src="public/img/arror_right.png" alt="次のページへ"/>
					</a>
				</c:if>
			</div>
		</div>
		<div class="line">
		</div>
		<section id="list_area">
			<c:forEach var="recipe" items="${recipes}" varStatus="flag">
			<article class="list_menu">
				<a href="Action/RecipeDetail?user_id=<c:out value='${user.id}'/>&recipe_id=<c:out value='${recipe.id }'/>">
					<img class="radius_small imgshadow" src="public/img/<c:out value='${recipe.img_url }' />" alt="<c:out value='${recipe.name }'/>の画像"/>
				</a>
				<div class="menu_info">
					<a href="#" class="title_normal">
						<c:out value="${recipe.name }"/>
					</a>
					<div class="descripe_normal list_desc">
						<c:out value="${recipe.description }"/>
					</div>
					<div class="descripe_normal bold">
						前回作った日期　：<c:out value="${dates[flag.index]}"/>
					</div>
					<div class="descripe_normal bold">
						前回の結果　：<c:out value="${fbs[flag.index] }"/>
					</div>
				</div>
				<div class="clear">
				</div>
				<div class="line list_divider">
				</div>
			</article>
			</c:forEach>
		</section>
		</div>
	</section>
	<div class="clear">
	</div>
</section>
</section>
<section class="clear">
</section>
</section>
<jsp:include page="Footer.jsp" flush="true"/>
</body>
</html>