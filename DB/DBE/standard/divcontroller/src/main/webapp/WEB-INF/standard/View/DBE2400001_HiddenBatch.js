$("#btnCheck").find(".CommonButtonImg").attr("src", "/uz/uza/image/UZ__CommonButton_Exe.png");
$("#onClick_btnBatchRegister").css("display","none");

var callBackHandler = Uz._LoadInOrder.prototype.requestSequenceCallbackHandler;
Uz._LoadInOrder.prototype.requestSequenceCallbackHandler = function(eventName){
  callBackHandler.call(this,eventName);
  if(eventName === "btnCheck_onClick_btnCheck" && $("#UzErrorAndWarningDiv").css('display') == 'none'){
      $("#onClick_btnBatchRegister").click();
  }
  $("#onClick_btnBatchRegister").css("display","none");
  $("#btnCheck").find(".CommonButtonImg").attr("src", "/uz/uza/image/UZ__CommonButton_Exe.png");
};
