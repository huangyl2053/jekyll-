var callBackHandler = Uz._LoadInOrder.prototype.requestSequenceCallbackHandler;
Uz._LoadInOrder.prototype.requestSequenceCallbackHandler = function (eventName) {
    callBackHandler.call(this, eventName);
    $(document).on("click", ".ui-dialog-buttonset button", function (event) {
        if (eventName === "btnUpdate_onClick_btnUpdate" && $("#UzErrorAndWarningDiv").css("display") === 'none') {
            var $span = $(event.target);
            if ($span.text() === "はい" && $("#hdnFlag_core").val() === "1") {
                if ($("#chkJukyushaTeiseiRearakuhyoHakkou_1").is(':checked')) {
                    $("#btnReportPublish").click();
                }
            }
            if ($span.text() === "はい" && $("#hdnFlag_core").val() === "0") {
                $("#btnSave").click();
            }
        }
    });
};