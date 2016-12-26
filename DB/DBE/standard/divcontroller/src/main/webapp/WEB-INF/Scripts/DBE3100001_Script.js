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

            new Uz.ClientDllInvoker(function (result) {
                div.hiddenInput[1].value = result;

                var validateButton = Uz.JSControlUtil.getJSControl("btnHanteishoriAto");
                validateButton.getJQueryElement(true).click();
            }).invoke(new Uz.ClientDllInvokeMessage("IchijiHanteiExecutor.dll", "IchijiHanteiExecutor.IchijiHanteiExecutor", "execute", arg));
        }
    });
});
