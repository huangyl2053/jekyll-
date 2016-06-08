// @reamsid_L DBA-0500-030 zuotao
$("#btnKakutei").find(".CommonButtonImg").attr("src", "/uz/uza/image/UZ__CommonButton_Report.png");
$("#btnPublish").css("display", "none");
var callBackHandler = Uz._LoadInOrder.prototype.requestSequenceCallbackHandler;
Uz._LoadInOrder.prototype.requestSequenceCallbackHandler = function(eventName) {
    callBackHandler.call(this, eventName);
    if (eventName === "btnKakutei_onClick_btnKakutei" && $("#UzErrorAndWarningDiv").css('display') == 'none') {
        $(document).on("click", ".ui-dialog-buttonset button", function(event) {
            var $span = $(event.target);
            if ($span.text() === "はい") {
                $("#btnPublish").click();
            }
        });
    }
}