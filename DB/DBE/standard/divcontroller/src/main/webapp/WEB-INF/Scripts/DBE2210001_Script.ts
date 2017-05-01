//サブ業務コード dbe にある、WEB-INF/dll/XXX.dll が、クライアントマシンの tmp(C:\Users\xxxx\tmp) にダウンロードされる。
//jsPathCollectionに設定してあげれば読み込まれる。
//一次判定実行DLLを読込
new Uz.ServerToClientDownload().start(new Uz.ServerToClientDownloadMessage("dbe", "dll/IchijiHanteiExecutor.dll"));
//一次判定DLL本体の読込
new Uz.ServerToClientDownload().start(new Uz.ServerToClientDownloadMessage("dbe", "dll/NCC10_09.dll"));

var arg = "";


Uz.GyomuJSHelper.registOriginalEvent("onclick_btnChosaKekkaUpdate", function () {

    var div = Uz.JSControlUtil.getJSControl("NinnteiChousaKekkaTouroku1");

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

                        //独自に発生させたぐるぐるを排除する
                        Uz._ViewControlUtil.deleteGrayOutLoadingOverlay("newExecuteIchijiHantei");

                        //一次判定処理の後処理を実行する。
                        var validateButton = Uz.JSControlUtil.getJSControl("btnHanteishoriAto");
                        validateButton.getJQueryElement(true).click();
                    }
                }).invoke(new Uz.ClientDllInvokeMessage("IchijiHanteiExecutor.dll", "IchijiHanteiExecutor.IchijiHanteiExecutor", "execute", argList[i]));
            }

            //独自にオーバーレイ（画面上のぐるぐる）を発生させる
            Uz._ViewControlUtil.createGrayOutLoadingOverlayWithKeyword("newExecuteIchijiHantei", true);
        }
    });
});
