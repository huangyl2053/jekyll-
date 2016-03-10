$("#btnCheck1").find(".CommonButtonImg").attr("src", "/uz/uza/image/UZ__CommonButton_Exe.png");
$("#btnCheck2").find(".CommonButtonImg").attr("src", "/uz/uza/image/UZ__CommonButton_Exe.png");
var callBackHandler = Uz._LoadInOrder.prototype.requestSequenceCallbackHandler;
Uz._LoadInOrder.prototype.requestSequenceCallbackHandler = function(eventName){  
  callBackHandler.call(this,eventName);
  if((eventName === "btnCheck1_onClick_btnCheck" || eventName === "btnCheck2_onClick_btnCheck") && $("#UzErrorAndWarningDiv").css('display') == 'none'){
      alert("123");
        if(eventName === "btnCheck1_onClick_btnCheck"){
          $("#btnHanteikekkaOutput").click();
      }
      if(eventName === "btnCheck2_onClick_btnCheck") {
         $("#btnRenkeiDataOutput").click(); 
      }
        
 } 
}