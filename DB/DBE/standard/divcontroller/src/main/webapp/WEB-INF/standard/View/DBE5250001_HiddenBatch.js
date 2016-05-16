var callBackHandler = Uz._LoadInOrder.prototype.requestSequenceCallbackHandler;
Uz._LoadInOrder.prototype.requestSequenceCallbackHandler = function(eventName){  
  callBackHandler.call(this,eventName);
  if((eventName === "btnCheck_onClick_Check") && $("#UzErrorAndWarningDiv").css('display') == 'none'){
        if(eventName === "btnCheck_onClick_Check"){
          $("#btnHanteiKekkaIchiran").click();
      }
 } 
}