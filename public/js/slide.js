/**
 *
 */
var slideIndex = 1;
$(function(){
	window.setTimeout("slide()",2000);
});

function slide(){
	if (slideIndex == 1){
		$("#sliderhide").css("background","#a86779");
	}
	if (slideIndex == 2){
		$("#sliderhide").css("background","#d4c3b0");
	}
	if (slideIndex == 3){
		$("#sliderhide").css("background","#E5E7E6");
	}
	o = $("#slider"+slideIndex);
	slideIndex++;
	if (slideIndex>3) {
		slideIndex-=3;
	}
	second = $("#sliderhide");
	$($(second.children()[0]).children()[0]).attr("src","public/img/banner"+slideIndex+".jpg");
	$(second.children()[1]).attr("background-img","url(../img/button_fastlogin"+slideIndex+".png)");
	o.fadeOut(2000);
	$("#slider"+slideIndex).fadeIn(2000);
	window.setTimeout("slide()",4000);
}