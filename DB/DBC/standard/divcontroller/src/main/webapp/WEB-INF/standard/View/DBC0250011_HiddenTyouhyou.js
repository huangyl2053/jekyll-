var callBackHandler = Uz._LoadInOrder.prototype.requestSequenceCallbackHandler;
Uz._LoadInOrder.prototype.requestSequenceCallbackHandler = function(eventName){
  callBackHandler.call(this,eventName);
      $(document).on("click", ".ui-dialog-buttonset button", function(event) {
          if(eventName === "btnSave_onClick_btnSave"){
            var $span = $(event.target);
            if ($span.text() === "はい" && $("#hdnFlag_core").val() === "1") {
                if ($("#chkRensakuhyoHakko_1").is(':checked')) {
                    $("#btnReportPublish").click();
                }
            }
          }
        });
};