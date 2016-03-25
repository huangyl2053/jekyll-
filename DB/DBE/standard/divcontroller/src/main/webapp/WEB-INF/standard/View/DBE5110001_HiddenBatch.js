var count = 0;
var callBackHandler = Uz._LoadInOrder.prototype.requestSequenceCallbackHandler;
Uz._LoadInOrder.prototype.requestSequenceCallbackHandler = function(eventName){
  callBackHandler.call(this,eventName);
  if(eventName === "btnKakunin_onClick_btnKakunin" && $("#btnRegistUploadFile").css('display') === 'none'&& count==0){
        $(document).on("click", ".ui-dialog-buttonset button", function(event) {
            var $span = $(event.target);
            if ($span.text() === "はい") {
                var page = Uz.JSControlUtil.getJSControl('Page');
                page.isReRequest = false;
                setTimeout('$("#btnRegistUploadFile").click()', 2000);
            }
        });
        count = 1;
    }
};
