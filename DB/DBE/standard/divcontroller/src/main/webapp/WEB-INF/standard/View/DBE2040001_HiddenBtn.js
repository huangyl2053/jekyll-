$("#btnikenshoiraitaishooutput").find(".CommonButtonImg").attr("src", "/uz/uza/image/UZ__CommonButton_Report.png");
var callBackHandler = Uz._LoadInOrder.prototype.requestSequenceCallbackHandler;
Uz._LoadInOrder.prototype.requestSequenceCallbackHandler = function(eventName){
  callBackHandler.call(this,eventName);
    if (eventName === "btnikenshoiraitaishooutput_onClick_BtnYitiranSyuturyoku" && $("#UzErrorAndWarningDiv").css('display') === 'none') {
        $(document).on("click", ".ui-dialog-buttonset button", function(event) {
            var $span = $(event.target);
            if ($span.text() === "はい") {
                $("#CSVButtonDownLoad").click();
            }
        });
    }
}