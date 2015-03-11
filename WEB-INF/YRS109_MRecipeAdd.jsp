<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="CommonHeader.jsp" flush="true"/>
<title>レシピ追加ー嫁レシピ</title>
<meta name="keywords" content="レシピ, レコメンド, お勧め, 結婚, 婚活 , 花嫁修業, 料理, 美味しい, 簡単">
<meta name="description" content="レシピ追加">
<link rel="stylesheet" href="public/css/recipe.css" type="text/css">
<link rel="stylesheet" href="public/css/recipeadd.css" type="text/css">
<script type="text/javascript" src="public/js/add-recipe.js"></script>
<script type="text/javascript" src="public/js/img_preview.js"></script>
</head>
<body>
<jsp:include page="AdminHeader.jsp" flush="true"/>
<section class="main">
	<div class="center_wrap">
	<section class="recipe">
	<div class="titles bold ">
		<h1>レシピ追加</h1>
	</div>
	<div class="left recipe_detail ">
		<form action="Action/AddRecipeComplete" method="post" enctype="multipart/form-data">
		<div class="recipe_overview left">
			<div class="pink bold">
				<input type="text" class="input_normal radius" name="recipename" size=30 value="料理の名前を入力してください"/>
			</div>
			<div id="recipePreview"></div>
			<a href="javascript:recipeimgselect()"><img class="radius_small" id="recipeimg" src="public/img/add.png" alt="レシピの画像追加"/></a>
			<input class="hidden" name="recipeimg" id="recipeimgselect" type="file" onchange="PreviewImage(this,'recipeimg','recipePreview')"/>
			<div class="descripe_normal">
				<textarea class="textarea_des radius" name="recipedes">レシピの紹介を入力してください</textarea>
			</div>
			<div class="stuff_area">
				<label class="bold black">材料</label>
			</div>
			<div class="stuff_table">
			</div>
			<table class="table_add_stuff left">
				<tr>
					<td>
						材料名
					</td>
					<td>
						<input type="text" class="input_stuff radius" id="stuffname" value=""/>
					</td>
				</tr>
				<tr>
					<td>
						量
					</td>
					<td>
						<input type="text" class="input_stuff radius" id="stuffamount" value=""/>
					</td>
				</tr>
			</table>
			<input type="hidden" id="stuffcount" value=""/>
			<a href="javascript:stuffadd()" class="btn_addstuff left"><img class="btn_addstuff" src="public/img/add.png" alt="食材の追加"/></a>
			<table class="table_add_stuff left" id="indtable">
				<tr class="indform">
					<td>
						<select class="radius select_normal" name="indid1">　
							<c:forEach var="indicator" items="${indicators }">
								<option value="<c:out value='${indicator.id }'/>"><c:out value='${indicator.name }'/></option>
							</c:forEach>
						</select>
					</td>
					<td>
						<select class="radius select_normal" name="indlevel1"> 　
							<option value="1">LV1</option>
							<option value="2">LV2</option>
							<option value="3">LV3</option>
							<option value="4">LV4</option>
							<option value="5">LV5</option>
						</select>
					</td>
				</tr>
			</table>
			<input type="hidden" id="indcount" value=""/>
			<a href="javascript:indadd()" class="btn_addstuff left"><img class="btn_addstuff" src="public/img/add.png" alt="インディケーター追加"/></a>
			<table class="table_add_stuff left">
				<tr>
					<td>
						レシピレベル :
					</td>
					<td>
						<select class="radius select_normal" name="recipelevel"> 　
							<option value="1">LV1</option>
							<option value="2">LV2</option>
							<option value="3">LV3</option>
							<option value="4">LV4</option>
							<option value="5">LV5</option>
						</select>
					</td>
				</tr>
			</table>
		</div>
		<div class="recipe_detail_list left">
			<div class="recipe_step" id="step1">
				<div class="step_number_area">
					<label class="step_number bold white">1</label>
				</div>
				<div class="step_detail">
					<input type="text" class="input_normal radius" name="steptitle1" size=25 value="手順のタイトルを入力してください"/>
					<div class="line">
					</div>
					<div id="stepPreview1"></div>
					<a href="javascript:stepimgselect(1)"><img class="radius_small" id="stepimg1" src="public/img/add.png" alt="手順の画像追加"/></a>
					<input class="hidden" name="stepimg1" id="stepimgselect1" type="file" onchange="PreviewImage(this,'stepimg1','stepPreview1')"/>
					<div class="descripe_normal">
						<textarea class="radius_small textarea_des" name="stepdetail1">説明を入力してください。</textarea>
					</div>
				</div>
			</div>
			<div class="line_dash left">
			</div>
			<div class="recipe_step">
				<a onclick="javascript:stepadd(this)" class="link_addstep"><img class="radius_small"  src="public/img/add.png" alt="手順追加"/></a>
			</div>
			<input type="hidden" id="stepcount" value=""/>
			<div class="clear">
			</div>
		</div>
			<a href="Action/AdminTop" id="btn_return" class="btn_gray_normal">キャンセル</a>
			<a onclick="javascript:submit(this)" id="btn_confirm" class="btn_pink_normal">登録する</a>
			<input type="hidden" name="token" value="<c:out value='${token }'/>"/>
		</form>
	</div>
	<section class="clear">
	</section>
	</section>
	</div>
</section>
<jsp:include page="Footer.jsp" flush="true"/>
</body>
</html>