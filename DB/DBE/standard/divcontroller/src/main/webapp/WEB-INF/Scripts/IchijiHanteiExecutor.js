new Uz.ServerToClientDownload().start(new Uz.ServerToClientDownloadMessage("dbe", "dll/IchijiHanteiExecutor.dll"));

new Uz.ServerToClientDownload().start(new Uz.ServerToClientDownloadMessage("dbe", "dll/NCC10_09.dll"));

var arg = "";

Uz.GyomuJSHelper.registOriginalEvent("onClick_btnIchijiHantei", function (control) {
    var commonChildDiv = Uz.JSControlUtil.getJSControl("_dialog_DBE_IchijiHanteiKekkaJoho_IchijiHanteiKekkaJoho");
    arg = commonChildDiv.hiddenInput[0].value;

    new Uz.ClientDllInvoker(function (result) {
        commonChildDiv.hiddenInput[1].value = result;
        $("#_dialog_DBE_IchijiHanteiKekkaJoho_btnAfterIchijiHantei").trigger("click");
    }).invoke(new Uz.ClientDllInvokeMessage("IchijiHanteiExecutor.dll", "IchijiHanteiExecutor.IchijiHanteiExecutor", "execute", arg));
});
