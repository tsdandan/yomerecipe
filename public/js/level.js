/**
 *
 */
function showWrap(name){
	$(".wrap").hide();
	$("#wrap_"+name).show();
	$(".btn_menu").attr("class","btn_menu btn_white_large");
	$("#btn_menu_"+name).attr("class","btn_menu btn_pink_large");
}

function showhis(x,y){
	$(".his"+x).hide();
	$("#his"+x+"_"+y).show();
	$(".indmark"+x).hide();
	$("#indmark"+x+"_"+y).show();
	$(".indlink"+x).attr("class","indlink"+x);
	$("#indlink"+x+"_"+y).attr("class","selected indlink"+x);
}