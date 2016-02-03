$("#btnCheck").find(".CommonButtonImg").attr("src", "/uz/uza/image/UZ__CommonButton_Report.png");

var callBackHandler = Uz._LoadInOrder.prototype.requestSequenceCallbackHandler;
Uz._LoadInOrder.prototype.requestSequenceCallbackHandler = function(eventName){
  callBackHandler.call(this,eventName);
  if(eventName === "btnCheck_onClick_btnKyotsu" && $("#UzErrorAndWarningDiv").css('display') == 'none'){
        $("#btnHakko").click();
        if($("#chkShinsakaiScheduleKagami_key0").prop("checked")) {
            $("#btnHakkoJin").click();
        }
  } 
};
