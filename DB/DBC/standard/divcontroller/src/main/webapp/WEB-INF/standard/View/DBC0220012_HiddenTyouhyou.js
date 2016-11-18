var callBackHandler = Uz._LoadInOrder.prototype.requestSequenceCallbackHandler;
var flg = 1;
Uz._LoadInOrder.prototype.requestSequenceCallbackHandler = function (eventName) {
    callBackHandler.call(this, eventName);
    $(document).on("click", ".ui-dialog-buttonset button", function (event) {
        if (eventName === "btnUpdate_onClick_btnUpdate" && $("#UzErrorAndWarningDiv").css("display") === 'none') {
            var $span = $(event.target);
            if ($span.text() === "はい" && $("#hdnFlag_core").val() === "1" && flg === 1) {
                flg = 2;
                if ($("#chkJukyushaTeiseiRearakuhyoHakkou_1").is(':checked')) {
                    flg = 2;
                    $("#btnReportPublish").click();
                }
            }
            if ($span.text() === "はい" && $("#hdnFlag_core").val() === "0" && flg === 1) {
                flg = 2;
                $("#btnSave").click();
            }
        }
    });
};