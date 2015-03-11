<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="CommonHeader.jsp" flush="true"/>
<title><c:out value='${recipe.name }'/>の詳細ー嫁レシピ</title>
<meta name="keywords" content="レシピ, <c:out value='${recipe.name }'/>, 結婚, 婚活 , 花嫁修業, 料理, 美味しい, 簡単">
<meta name="description" content="<c:out value='${recipe.name }'/>の詳細です、どうぞ練習してください">
<link rel="stylesheet" href="public/css/recipe.css" type="text/css">
</head>
<body>
<jsp:include page="Header.jsp" flush="true"/>
<section class="main">
	<div class="center_wrap">
	<section class="recipe left">
	<div class="titles bold ">
		<h1>レシピ詳細</h1>
	</div>
	<div class="left recipe_detail">
		<div class="recipe_overview left">
			<img class="imgshadow" src="public/img/<c:out value="${recipe.img_url}"/>" alt="<c:out value='${recipe.name }'/>の画像"/>
			<div class="overview">
			<div class="darkpink bold name"><c:out value="${recipe.name}"/></div>
			<div class="line"></div>
			<div class="descripe_pink desc">
				<c:out value="${recipe.description}"/>
			</div>
			<div class="stuff_area">
				<label class="bold black">材料</label>
			</div>
			<table class="stuff_table">
				<c:forEach var="stuff" items="${stuffs }" varStatus="flag">
					<c:choose>
						<c:when test="${flag.index % 2 == 0}">
							<tr>
							<td><c:out value="${stuff.name }"/><label class="right"><c:out value="${stuff.amount }"/></label></td>
						</c:when>
						<c:otherwise>
							<td><c:out value="${stuff.name }"/><label class="right"><c:out value="${stuff.amount }"/></label></td>
							</tr>
						</c:otherwise>
					</c:choose>
					<c:if test="${flag.last }">
						<c:if test="${flag.index % 2 == 0}">
							<td><label class="right"></label></td>
							</tr>
						</c:if>
					</c:if>
				</c:forEach>
			</table>
			<div class="sidelevel">
				<label class="bold black">この料理のレベル</label>
				<table class="leveltable leveltablerecipe">
					<c:forEach var="typerecipe" items="${typeRecipes}" varStatus="flag1">
					<tr>
						<td><c:out value="${recipeIndicators[flag1.index].name}" /></td>
						<c:forEach var="level" begin="1" end="${typerecipe.cooklevel}">
							<td><img src="public/img/icon_heart_full.png" alt="ハートの画像"/></td>
						</c:forEach>
						<c:forEach var="level" begin="1" end="${5-typerecipe.cooklevel}">
							<td><img src="public/img/icon_heart_blank.png" alt="空のハートの画像"/></td>
						</c:forEach>
					</tr>
					</c:forEach>
				</table>
			</div><!-- end of sidenavlevel -->
			</div>
		</div>
		<div class="recipe_detail_list left">
			<c:forEach var="step" items="${steps}" varStatus="flag">
			<div class="recipe_step">
				<div class="step_number_area">
					<label class="step_number bold white"><c:out value="${flag.index+1 }"/></label>
				</div>
				<div class="step_detail">
					<c:choose>
						<c:when test="${step.name==null }">
							<span class="title_normal darkpink">手順<c:out value="${flag.index+1 }"/></span>
						</c:when>
						<c:otherwise>
							<span class="title_normal darkpink"><c:out value="${step.name }"/></span>
						</c:otherwise>
					</c:choose>
					<c:if test="${step.img_url!=null }">
					<img class="imgshadow step_img" src="public/img/<c:out value="${step.img_url }"/>" alt="step${flag.index+1 }の画像"/>
					</c:if>
					<div class="descripe_normal step_desc">
						<c:out value="${step.detail}"/>
					</div>
				</div>
			</div>
			<c:choose>
				<c:when test="${flag.index%3 == 2}">
					<div class="line left">
					</div>
				</c:when>
				<c:otherwise>
					<div class="hline left step_devide">
					</div>
				</c:otherwise>
			</c:choose>
			</c:forEach>

			<div class="clear">
			</div>
			<div id="fb_area">
				<div class="titles bold">
						フィードバック
				</div>
				<div class="fbline">
					<c:choose>
						<c:when test="${userRecipe==null}">
							<label class="title_normal black bold ">初めての料理</label>
						</c:when>
						<c:otherwise>
							<label class="title_normal black bold ">前回の結果：</label>
							<label class="text_fb2">
								<c:out value="${fbwords }" />
							</label>
						</c:otherwise>
					</c:choose>
				</div>
				<div class="fbline">
					<label class="title_normal black bold label2">今回は：</label>
					<a href="Action/Feedback?userid=<c:out value='${user.id }'/>&recipeid=<c:out value='${recipe.id }'/>&type=2&token=<c:out value='${token }'/>"><img src="public/img/btn_fb1.png" alt="マスターした"/></a>
					<a href="Action/Feedback?userid=<c:out value='${user.id }'/>&recipeid=<c:out value='${recipe.id }'/>&type=1&token=<c:out value='${token }'/>"><img src="public/img/btn_fb2.png" alt="もうちょっと練習"/></a>
					<a href="Action/Feedback?userid=<c:out value='${user.id }'/>&recipeid=<c:out value='${recipe.id }'/>&type=0&token=<c:out value='${token }'/>"><img src="public/img/btn_fb3.png" alt="まだまだ"/></a>
				</div>
			</div>
		</div>
	</div>
	</section>
	<div class="clear"></div>
		<div class="normal_shadow">
		</div>
	<section class="premium">
	<section class="premium_wrap">
		<div class="titles bold">
			料理の腕
			<a href="Action/LevelGraph?id=<c:out value='${user.id }'/>" class="underline right nobold normal">詳細を見る</a>
		</div>
		<div class="premium_content border_pink left">
			<c:forEach var="indicator" items="${indicators}" varStatus="flag1">
				<table class="leveltable left">
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
			</c:forEach>
		</div>
	</section>
	</section>
	<section class="clear">
	</section>
	</div>
</section>
<jsp:include page="Footer.jsp" flush="true"/>
</body>
</html>