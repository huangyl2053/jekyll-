$("#btnCheck").find(".CommonButtonImg").attr("src", "/uz/uza/image/UZ__CommonButton_Report.png");

$(document).ready(function(){
	$(document).on("click", ".ui-dialog-buttonset button", function(event1){		
  		var $span1 = $(event1.target);	
  		if($span1.text() === "はい" && $(".ui-dialog-title").text() === "質問"){	
 		printClick();
  	}
}); 
	function printClick(){
		$("#btnPrint").click();
	}
});