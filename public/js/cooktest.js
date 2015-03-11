/**
 *
 */
	var current = 1;
	$(function(){
		$("#btn_prev").hide();
		$("#btn_submit").hide();
		for (i = 5; i < 15; i++){
			$("#q"+i).hide();
		}
	})

	function shownext(){
		for (i = 0; i < 15; i++){
			$("#q"+i).hide();
		}
		if (current==1){
			$("#btn_return").hide();
			$("#btn_prev").show();
		}
		if (current<3) current++;
		$("#count").html(current*5);
		if (current==3){
			$("#btn_next").hide();
			$("#btn_submit").show();
		}
		for (i = (current-1)*5; i < current*5; i++){
			$("#q"+i).show();
		}
		scroll(0,0);
	}

	function showprev(){
		for (i = 0; i < 15; i++){
			$("#q"+i).hide();
		}
		if (current==3){
			$("#btn_next").show();
			$("#btn_submit").hide();
		}
		if (current>1) current--;
		$("#count").html(current*5);
		if (current==1){
			$("#btn_return").show();
			$("#btn_prev").hide();
		}
		for (i = (current-1)*5; i < current*5; i++){
			$("#q"+i).show();
		}
		scroll(0,0);
	}