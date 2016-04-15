$("#btnCheck").find(".CommonButtonImg").attr("src", "/uz/uza/image/UZ__CommonButton_Report.png");
$("#btnCheck2").find(".CommonButtonImg").attr("src", "/uz/uza/image/UZ__CommonButton_Report.png");
$("#btnReportPubLish").css("display","none");
$("#btnReportPubLish2").css("display","none");
var callBackHandler = Uz._LoadInOrder.prototype.requestSequenceCallbackHandler;
Uz._LoadInOrder.prototype.requestSequenceCallbackHandler = function(eventName){
  callBackHandler.call(this,eventName);
  if(eventName === "btnCheck_onClick_Check"){
      $(document).on("click", ".ui-dialog-buttonset button", function(event) {
            var $span = $(event.target);
            if ($span.text() === "はい") {
                $("#btnReportPubLish").click();
            }
        });
    }
  if(eventName === "btnCheck2_onClick_Check"){
      $(document).on("click", ".ui-dialog-buttonset button", function(event) {
            var $span = $(event.target);
            if ($span.text() === "はい") {
                $("#btnReportPubLish2").click();
            }
        });
    } 
    $("#btnCheck").find(".CommonButtonImg").attr("src", "/uz/uza/image/UZ__CommonButton_Report.png");
    $("#btnCheck2").find(".CommonButtonImg").attr("src", "/uz/uza/image/UZ__CommonButton_Report.png");
    $("#btnReportPubLish").css("display","none");
    $("#btnReportPubLish2").css("display","none");
}