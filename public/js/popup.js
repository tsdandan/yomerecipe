/**
 * ログインと会員登録のポップアップです
 */
$(function(){
	$("#shade").click(function(){
		hidepop();
	});
	if ($("#errorreg").html()!=""&&$("#errorreg").html()!=null){
		showreg();
	}
	if ($("#errorlogin").html()!=""&&$("#errorlogin").html()!=null){
		showlogin();
	}
});

function showreg(){
	$("#shade").show();
	$("#reg_wrap").show();
}

function showlogin(){
	$("#shade").show();
	$("#login_wrap").show();
}

function hidepop(){
	$("#shade").hide();
	$("#reg_wrap").hide();
	$("#login_wrap").hide();
}