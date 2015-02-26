
(document).ready(function(){
  $("#num1").click(function(){

    $("#hello2").hide();
    $("#hello3").hide();
  });
  $("#num1").click(function(){
	$("#hello1").show();
	});
  $("#num2").click(function(){

	    $("#hello1").hide();
	    $("#hello3").hide();
	  });
	  $("#num2").click(function(){
		$("#hello2").show();
		});
	  $("#num3").click(function(){

		    $("#hello1").hide();
		    $("#hello2").hide();
		  });
		  $("#num3").click(function(){
			$("#hello3").show();
			});

});  


