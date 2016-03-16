$("#btnHakkouValidationCheck").find(".CommonButtonImg").attr("src", "/uz/uza/image/UZ__CommonButton_Report.png");
$("#btnHakkou").css("display","none");
var callBackHandler = Uz._LoadInOrder.prototype.requestSequenceCallbackHandler;
Uz._LoadInOrder.prototype.requestSequenceCallbackHandler = function(eventName){  
  callBackHandler.call(this,eventName);
  if(eventName === "btnHakkouValidationCheck_onClick_btnHakkouValidationCheck"  && $("#UzErrorAndWarningDiv").css('display') == 'none'){
          $("#btnHakkou").click();
 } 
}