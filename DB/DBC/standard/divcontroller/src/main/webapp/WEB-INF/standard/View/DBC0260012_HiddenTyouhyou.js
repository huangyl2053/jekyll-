var callBackHandler = Uz._LoadInOrder.prototype.requestSequenceCallbackHandler;
Uz._LoadInOrder.prototype.requestSequenceCallbackHandler = function(eventName){
  callBackHandler.call(this,eventName);
  if(eventName === "btnSave_onClick_btnSave"){
      $(document).on("click", ".ui-dialog-buttonset button", function(event) {
            var $span = $(event.target);
            if ($span.text() === "はい") {
                if ($("#chkRensakuhyoHakko_1").is(':checked')) {
                    $("#btnReportPublish").click();
                }
            }
        });
    }
}