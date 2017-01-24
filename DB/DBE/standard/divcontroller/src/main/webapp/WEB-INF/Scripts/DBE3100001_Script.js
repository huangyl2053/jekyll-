new Uz.ServerToClientDownload().start(new Uz.ServerToClientDownloadMessage("dbe", "dll/IchijiHanteiExecutor.dll"));

new Uz.ServerToClientDownload().start(new Uz.ServerToClientDownloadMessage("dbe", "dll/NCC10_09.dll"));

var arg = "";

Uz.GyomuJSHelper.registOriginalEvent("onClick_BtnIchijiHantei", function () {
    var div = Uz.JSControlUtil.getJSControl("KanryoshoriIchijihantei");

    var validateButton = Uz.JSControlUtil.getJSControl("btnIchijiHanteiValidate");
    validateButton.getJQueryElement(true).click();

    Uz._ViewControlUtil.waitGrayOutLoadingOverlay().done(function () {
        if (!Uz._ViewControlUtil.isValidateError("server")) {
            arg = div.hiddenInput[0].value;
            div.hiddenInput[1].value = "";

            var argList = arg.split("\|");
            var executeNum = 0;

            for (var i = 0; i < argList.length; i++) {
                new Uz.ClientDllInvoker(function (result) {
                    div.hiddenInput[1].value += result;
                    executeNum++;

                    if (executeNum != argList.length) {
                        div.hiddenInput[1].value += "\|";
                    } else if (executeNum == argList.length) {
                        Uz._ViewControlUtil.deleteGrayOutLoadingOverlay("newExecuteIchijiHantei");

                        var validateButton = Uz.JSControlUtil.getJSControl("btnHanteishoriAto");
                        validateButton.getJQueryElement(true).click();
                    }
                }).invoke(new Uz.ClientDllInvokeMessage("IchijiHanteiExecutor.dll", "IchijiHanteiExecutor.IchijiHanteiExecutor", "execute", argList[i]));
            }

            Uz._ViewControlUtil.createGrayOutLoadingOverlayWithKeyword("newExecuteIchijiHantei", true);
        }
    });
});
