/**
 *
 */
var stuffindex=1;
var stepIndex=2;
var indIndex=2;

function stuffdel(object){
	$(object).parent().remove();
}

function stuffadd(){
	name = $("#stuffname").val();
	amount = $("#stuffamount").val();
	if (name!=""&&amount!=""){
		htmlstr = "<div class='stuff_cell left'>"
		+"<a class='minus' onclick='javascript:stuffdel(this)'>"
		+"<img src='public/img/minus.png'/></a>"+name+"<label class='right'>"+amount+"</label>"
		+"<input type='hidden' value='" + name + "' name='stuffname" + stuffindex +"'/>"
		+"<input type='hidden' value='" + name + "' name='stuffamount" + stuffindex +"'/>"
		+"</div>"
		$(".stuff_table").append(htmlstr);
		stuffindex++;
		$("#stuffcount").val(stuffindex);
	}
}

function indadd(){
	indform = $($(".indform")[0]).clone();
	$(indform.children().children()[0]).attr("name","indid"+indIndex);
	$(indform.children().children()[1]).attr("name","indlevel"+indIndex);
	htmlstr = "<tr><td><select class='radius select_normal' name='indname1'>"
		+"<option></option>"
		+"</select></td>"
		+"<td><select class='radius select_normal'>" 　
		+"<option></option>"
		+"</select></td></tr>";
	indIndex++;
	$("#indtable").append(indform);
	$("#indcount").val(indIndex);
}

function stepadd(object){
	stepimgstr = "'stepimg"+stepIndex+"'";
	stepPreviewstr = "'stepPreview"+stepIndex+"'";
	htmlstr = "<div class='recipe_step' id='step" + stepIndex + "'>"
			+ "<div class='step_number_area'>"
			+ "<label class='step_number bold white'>"
			+ stepIndex + "</label>"
			+ "</div>"
			+ "<div class='step_detail'>"
			+ "<input type='text' class='input_normal radius' name='steptitle" + stepIndex + "' value='step'/>"
			+ "<div class='line'>"
			+ "</div>"
			+ "<div id='stepPreview" + stepIndex + "'></div>"
			+ "<a href='javascript:stepimgselect(" + stepIndex + ")'><img class='radius_small' id='stepimg" + stepIndex + "' src='public/img/add.png'/></a>"
			+ "<input class='hidden' name='stepimg" + stepIndex + "' id='stepimgselect" + stepIndex + "' type='file'"
			+ 'onchange="PreviewImage(this,' + stepimgstr + ',' + stepPreviewstr + ')"/>'
			+ "<div class='descripe_normal'>"
			+ "<textarea class='radius_small textarea_des' name='stepdetail" + stepIndex + "'>説明を入力してください。</textarea>"
			+ "</div>"
			+ "</div>"
			+ "</div>";
	$(object).parent().before(htmlstr);
	if (stepIndex %3 !=0){
		htmlstr = "<div class='line_dash left'></div>";
	} else {
		htmlstr = "<div class='hline_dash left'></div>";
	}
	$(object).parent().before(htmlstr);
	stepIndex++;
	$("#indcount").val(stepIndex);
}

function recipeimgselect(){
	$("#recipeimgselect").click();
}

function stepimgselect(i){
	$("#stepimgselect"+i).click();
}