/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.kanryoDialog.KanryoDialogDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.KaigoKanryoMessage;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N3327 三浦 凌
 */
public class KanryoDialog {

    /**
     * onLoad
     *
     * @param div KanryoDialogDiv
     * @return ResponseData
     */
    public ResponseData<KanryoDialogDiv> onLoad(KanryoDialogDiv div) {
        KaigoKanryoMessage.setMessage(div.getKanryoMassage(),
                new RString("処理は正常に終了しました。"), RString.EMPTY, RString.EMPTY);
        div.setVisible(true);
        return _createResponseData(div);
    }

    private ResponseData<KanryoDialogDiv> _createResponseData(KanryoDialogDiv div) {
        ResponseData<KanryoDialogDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }
}
