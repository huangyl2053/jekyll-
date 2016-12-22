//サブ業務コード dbe にある、WEB-INF/dll/XXX.dll が、クライアントマシンの tmp(C:\Users\xxxx\tmp) にダウンロードされる。
//jsPathCollectionに設定してあげれば読み込まれる。
//一次判定実行DLLを読込
new Uz.ServerToClientDownload().start(new Uz.ServerToClientDownloadMessage("dbe", "dll/IchijiHanteiExecutor.dll"));
//一次判定DLL本体の読込
new Uz.ServerToClientDownload().start(new Uz.ServerToClientDownloadMessage("dbe", "dll/NCC10_09.dll"));

var arg = "";


Uz.GyomuJSHelper.registOriginalEvent("onClick_BtnIchijiHantei", () => {

    var div = Uz.JSControlUtil.getJSControl("KanryoshoriIchijihantei");

    var validateButton: Uz._ViewControl = Uz.JSControlUtil.getJSControl("btnIchijiHanteiValidate");
    validateButton.getJQueryElement(true).click();
    
    Uz._ViewControlUtil.waitGrayOutLoadingOverlay().done(() => {
    
        if (!Uz._ViewControlUtil.isValidateError("server")) {
        
            arg = div.hiddenInput[0].value;
            
            new Uz.ClientDllInvoker(function(result) {
                div.hiddenInput[1].value = result;
                
                var validateButton: Uz._ViewControl = Uz.JSControlUtil.getJSControl("btnHanteishoriAto");
                validateButton.getJQueryElement(true).click();
                    
                }).invoke(new Uz.ClientDllInvokeMessage("IchijiHanteiExecutor.dll",
                     "IchijiHanteiExecutor.IchijiHanteiExecutor", "execute", arg));
        }
    });
});
