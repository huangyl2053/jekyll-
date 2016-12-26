//サブ業務コード dbe にある、WEB-INF/dll/XXX.dll が、クライアントマシンの tmp(C:\Users\xxxx\tmp) にダウンロードされる。
//jsPathCollectionに設定してあげれば読み込まれる。
//一次判定実行DLLを読込
new Uz.ServerToClientDownload().start(new Uz.ServerToClientDownloadMessage("dbe", "dll/IchijiHanteiExecutor.dll"));
//一次判定DLL本体の読込
new Uz.ServerToClientDownload().start(new Uz.ServerToClientDownloadMessage("dbe", "dll/NCC10_09.dll"));

var arg = "";

//一次判定実行DLLを起動する。
Uz.GyomuJSHelper.registOriginalEvent("onClick_btnIchijiHantei", function(control) {

    var commonChildDiv = Uz.JSControlUtil.getJSControl("_dialog_DBE_IchijiHanteiKekkaJoho_IchijiHanteiKekkaJoho");
    arg = commonChildDiv.hiddenInput[0].value;
    
    new Uz.ClientDllInvoker(function(result) {
        commonChildDiv.hiddenInput[1].value = result;       
        $("#_dialog_DBE_IchijiHanteiKekkaJoho_btnAfterIchijiHantei").trigger("click");
        
    }).invoke(new Uz.ClientDllInvokeMessage("IchijiHanteiExecutor.dll",
         "IchijiHanteiExecutor.IchijiHanteiExecutor", "execute", arg));
});
