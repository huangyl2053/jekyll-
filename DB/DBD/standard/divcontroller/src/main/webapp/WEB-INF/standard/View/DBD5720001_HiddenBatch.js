$("#btnCheck").find(".CommonButtonImg").attr("src", "/uz/uza/image/UZ__CommonButton_Exe.png");
$("#btnBatchJiko").css("display", "none");
var callBackHandler = Uz._LoadInOrder.prototype.requestSequenceCallbackHandler;
Uz._LoadInOrder.prototype.requestSequenceCallbackHandler = function(eventName) {
     callBackHandler.call(this, eventName);
     if (eventName === "btnCheck_onBeforeOpenDialog_btnBatchJiko" && $("#UzErrorAndWarningDiv").css('display') == 'none') {
        $(document).on("click", ".ui-dialog-buttonset button", function(event) {
            var $span = $(event.target);
            if ($span.text() === "OK") {
                $("#btnBatchJiko").click();
            }
        });
    }
}