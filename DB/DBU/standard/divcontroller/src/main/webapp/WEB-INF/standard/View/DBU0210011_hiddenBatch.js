$("#btnCheck").find(".CommonButtonImg").attr("src", "/uz/uza/image/UZ__CommonButton_Exe.png");
$("#btnJikko").css("display","none");
var callBackHandler = Uz._LoadInOrder.prototype.requestSequenceCallbackHandler;
Uz._LoadInOrder.prototype.requestSequenceCallbackHandler = function(eventName){
  callBackHandler.call(this,eventName); 
  if(eventName == "btnCheck_btnJikkoBefore" && $("#UzErrorAndWarningDiv").css('display') == 'none'){
  $("#btnJikko").click();
 } 
}
