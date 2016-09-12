var callBackHandler = Uz._LoadInOrder.prototype.requestSequenceCallbackHandler;
Uz._LoadInOrder.prototype.requestSequenceCallbackHandler = function(eventName) {
    $(document).on("click", ".ui-dialog-buttonset button", function(event) {
        var page = Uz.JSControlUtil.getJSControl('Page');
        page.isReRequest = false;
        Uz._ViewControlUtil.deleteAllButtonLoadingOverlay();
        var $span = $(event.target);
        if ($span.text() === "はい") {
            if (eventName === "ccdShokanShinseiList_btnAdd_onClick_InsertButton") {
                $("#btnInsert").click();
            }
            if (eventName === "ccdShokanShinseiList_dgShinseiList_onClick_ModifyButton") {
                $("#btnUpdate").click();
            }
            if (eventName === "ccdShokanShinseiList_dgShinseiList_onClick_DeleteButton") {
                $("#btnDelete").click();
            }
        }
        if ($span.text() === "無視して続行する") {
            $("#btnInsert").click();
        }
    });
    callBackHandler.call(this,eventName);
};