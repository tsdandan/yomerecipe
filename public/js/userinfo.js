/**
 *
 */
function showWrap(name){
	$(".wrap").hide();
	$("#wrap_"+name).show();
	$(".btn_menu").attr("class","btn_menu btn_white_large");
	$("#btn_menu_"+name).attr("class","btn_menu btn_pink_large");
}

function editname(){
	$("#namelabel").hide();
	$("#nameedit").show();
}

function editage(){
	$("#agelabel").hide();
	$("#ageedit").show();
}