//$("#btnCheck1").find(".CommonButtonImg").attr("src", "/uz/uza/image/UZ__CommonButton_Exe.png");
//$("#btnCheck2").find(".CommonButtonImg").attr("src", "/uz/uza/image/UZ__CommonButton_Exe.png");
var callBackHandler = Uz._LoadInOrder.prototype.requestSequenceCallbackHandler;
Uz._LoadInOrder.prototype.requestSequenceCallbackHandler = function(eventName){  
  callBackHandler.call(this,eventName);
  if((eventName === "btnHanteikekkaOutput_onClick_btnCheck" || eventName === "btnRenkeiDataOutput_onClick_btnCheck") && $("#UzErrorAndWarningDiv").css('display') == 'none'){
        if(eventName === "btnHanteikekkaOutput_onClick_btnCheck"){
          $("#btnHanteikekkaOutput").click();
      }
      if(eventName === "btnRenkeiDataOutput_onClick_btnCheck") {
         $("#btnRenkeiDataOutput").click(); 
      }
        
 } 
}