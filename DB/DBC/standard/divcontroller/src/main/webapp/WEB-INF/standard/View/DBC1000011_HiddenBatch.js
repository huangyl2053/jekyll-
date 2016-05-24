$("#btnCheck").find(".CommonButtonImg").attr("src", "/uz/uza/image/UZ__CommonButton_Exe.png");
$("#btnbatch").css("display","none");
var callBackHandler = Uz._LoadInOrder.prototype.requestSequenceCallbackHandler;
Uz._LoadInOrder.prototype.requestSequenceCallbackHandler = function(eventName){
  callBackHandler.call(this,eventName);
      $(document).on("click", ".ui-dialog-buttonset button", function(event) {
            var $span = $(event.target);
            if ($span.text() === "はい") {
              if (eventName === "btnCheck_onClick_btnJikou" && $("#UzErrorAndWarningDiv").css('display') === 'none') {
                $("#btnbatch").click();
            }
        }
    });
};