/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.KanryoDialog;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KanryoDialog.KanryoDialogDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 完了ダイアログのコントローラです。
 */
public class KanryoDialog {

    /**
     * コンストラクタです。
     *
     */
    public KanryoDialog() {
    }

    /**
     * 完了ダイアログ初期化処理です。
     *
     * @param div 完了ダイアログDiv
     * @return ResponseData<KanryoDialogDiv>
     */
    public ResponseData<KanryoDialogDiv> onLoad(KanryoDialogDiv div) {
        div.getLblMessageMain().setText(RString.isNullOrEmpty(
                div.getHdnKanryoMsg()) ? new RString("処理は正常に行われました。") : div.getHdnKanryoMsg());
        return ResponseData.of(div).respond();
    }

    /**
     * 完了ダイアログは閉じです。
     *
     * @param div 完了ダイアログDiv
     * @return ResponseData<KanryoDialogDiv>
     */
    public ResponseData<KanryoDialogDiv> onClick_btnClose(KanryoDialogDiv div) {
        return ResponseData.of(div).respond();
    }
}
