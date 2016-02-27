$("#btnCheck").find(".CommonButtonImg").attr("src", "/uz/uza/image/UZ__CommonButton_Report.png");

var callBackHandler = Uz._LoadInOrder.prototype.requestSequenceCallbackHandler;
Uz._LoadInOrder.prototype.requestSequenceCallbackHandler = function(eventName){
  callBackHandler.call(this,eventName);
  if(eventName === "btnCheck_onClick_btnCheck" && $("#UzErrorAndWarningDiv").css('display') == 'none'){
        if($("#radTaishoSentaku_key0").prop("checked") && $("#Chkchosairaihakko_key0").prop("checked")) {
            $("#btnBatchRegister_NinteiChousa").click();
        }
        if($("#radTaishoSentaku_key1").prop("checked") && $("#Chkikenshiiraihakko_key0").prop("checked")) {
            $("#btnBatchRegister_ShuziiiSenshoSakusei").click();
        }
        if(!$("#Chkchosairaihakko_key0").prop("checked") || !$("#Chkikenshiiraihakko_key0").prop("checked")) {
            $("#btnBatchRegister_ShuziiiSenshoTeishutu").click();
            $("#btnBatchRegister_HoumonChousa").click();
        }
  } 
};
