//$("#btnOutputCsvCheck").find(".CommonButtonImg").attr("src", "/uz/uza/image/UZ__CommonButton_Report.png");
$("#btnOutputCsv").css("display", "none");
var callBackHandler = Uz._LoadInOrder.prototype.requestSequenceCallbackHandler;
Uz._LoadInOrder.prototype.requestSequenceCallbackHandler = function(eventName) {
    callBackHandler.call(this, eventName);
    if (eventName === "btnOutputCsvCheck_onBeforeDownlaod_btnOutputCsv" && $("#UzErrorAndWarningDiv").css('display') == 'none') {
                $("#btnOutputCsv").click();
    }
};