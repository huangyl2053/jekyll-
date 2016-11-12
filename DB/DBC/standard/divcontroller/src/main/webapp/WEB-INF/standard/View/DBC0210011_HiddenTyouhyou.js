var callBackHandler = Uz._LoadInOrder.prototype.requestSequenceCallbackHandler;
var flag = false;
Uz._LoadInOrder.prototype.requestSequenceCallbackHandler = function(eventName){
  callBackHandler.call(this,eventName);
      $(document).on("click", ".ui-dialog-buttonset button", function(event) {
          if(eventName === "btnSave_onClick_btnSave"){
            var $span = $(event.target);
            if ($span.text() === "はい" && $("#hdnFlag_core").val() === "1") {
                if ($("#chkJukyushaIdoRearakuhyoHakkou_key0").is(':checked') && !flag) {
                    flag = true;
                    $("#btnHakkou").click();
                }
            }
          }
        });
};