var count = 0;
var callBackHandler = Uz._LoadInOrder.prototype.requestSequenceCallbackHandler;
Uz._LoadInOrder.prototype.requestSequenceCallbackHandler = function(eventName) {

    if (eventName === "btnKakunin_onClick_btnKakunin" && $("#btnRegistUploadFile").css('display') === 'none' && count === 0) {
        $(document).on("click", ".ui-dialog-buttonset button", function(event) {
            var $span = $(event.target);
            if ($span.text() === "はい") {
                var page = Uz.JSControlUtil.getJSControl('Page');
                page.isReRequest = false;
                Uz._ViewControlUtil.deleteAllButtonLoadingOverlay();
                $("#btnRegistUploadFile").click();
            }
        });
        count = 1;
    } else {
        callBackHandler.call(this, eventName);
    }
};
