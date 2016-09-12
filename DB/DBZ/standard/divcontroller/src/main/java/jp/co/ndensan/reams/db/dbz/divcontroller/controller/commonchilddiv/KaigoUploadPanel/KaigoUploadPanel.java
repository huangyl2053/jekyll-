/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.KaigoUploadPanel;

import java.io.File;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoUploadPanel.KaigoUploadPanel.KaigoUploadHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoUploadPanel.KaigoUploadPanel.KaigoUploadPanelDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * アップロードダイアログのクラス。
 */
public class KaigoUploadPanel {

    /**
     * アップロードダイアログの初期化です。
     *
     * @param div 画面情報
     * @return ResponseData<KaigoUploadPanelDiv>
     */
    public ResponseData<KaigoUploadPanelDiv> onLoad(KaigoUploadPanelDiv div) {

        getHandler(div).initialize(DataPassingConverter.deserialize(div.get処理モード(), RString.class));
        return ResponseData.of(div).respond();
    }

    /**
     * アップロードダイアログ。<br/>
     *
     * @param div KaigoUploadPanelDiv
     * @param files FileData
     * @return ResponseData<KaigoUploadPanelDiv>
     */
    @SuppressWarnings("checkstyle:illegaltoken")
    public ResponseData<KaigoUploadPanelDiv> onclick_BtnUpload(KaigoUploadPanelDiv div, FileData[] files) {

        for (FileData file : files) {
            if (files.length == 1) {
                単一_copyFile(file, div);
            } else {
                複数_copyFile(file, div);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * アップロード後チェックイベント。<br/>
     *
     * @param div KaigoUploadPanelDiv
     * @return ResponseData<KaigoUploadPanelDiv>
     */
    public ResponseData<KaigoUploadPanelDiv> afterUploadCheck(KaigoUploadPanelDiv div) {
        return ResponseData.of(div).respond();
    }

    private boolean 単一_copyFile(FileData file, KaigoUploadPanelDiv div) {
        RString 出力先フォルダ = DataPassingConverter.deserialize(div.get出力先フォルダ(), RString.class);
        RString ファイル名称 = DataPassingConverter.deserialize(div.getファイル名称(), RString.class);
        File moveDir = new File(出力先フォルダ.toString());
        File tempFile = new File(file.getFilePath().toString());

        if (tempFile.exists() && moveDir.exists()) {
            return tempFile.renameTo(new File(moveDir, ファイル名称.toString()
                    + "." + file.getFileName().split("\\.").get(1)));
        }
        return true;
    }

    private boolean 複数_copyFile(FileData file, KaigoUploadPanelDiv div) {
        RString 出力先フォルダ = DataPassingConverter.deserialize(div.get出力先フォルダ(), RString.class);
        File moveDir = new File(出力先フォルダ.toString());
        File tempFile = new File(file.getFilePath().toString());

        if (tempFile.exists() && moveDir.exists()) {
            return tempFile.renameTo(new File(moveDir, file.getFileName().toString()));
        }
        return true;
    }

    private KaigoUploadHandler getHandler(KaigoUploadPanelDiv requestDiv) {
        return new KaigoUploadHandler(requestDiv);
    }
}
