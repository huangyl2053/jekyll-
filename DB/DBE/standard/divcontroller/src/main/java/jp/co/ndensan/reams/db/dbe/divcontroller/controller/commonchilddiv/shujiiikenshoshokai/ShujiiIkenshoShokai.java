/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.commonchilddiv.shujiiikenshoshokai;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ShujiiIkenshoShokai.ShujiiIkenshoShokai.ShujiiIkenshoShokaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ShujiiIkenshoShokai.ShujiiIkenshoShokai.ShujiiIkenshoShokaiHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 *
 * @author n3509
 */
public class ShujiiIkenshoShokai {

    /**
     * 初期化の処理を表します。
     *
     * @param div 主治医意見書照会Div
     * @return ResponseData
     */
    public ResponseData initialize(ShujiiIkenshoShokaiDiv div) {
        createHandlerOf(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 「閉じる」ボタン押下時の処理を表します。
     *
     * @param div 主治医意見書作成依頼情報Div
     * @return ResponseData
     */
    public ResponseData onClick_btnClose(ShujiiIkenshoShokaiDiv div) {
        return ResponseData.of(div).respond();
    }

    private ShujiiIkenshoShokaiHandler createHandlerOf(ShujiiIkenshoShokaiDiv requestDiv) {
        return new ShujiiIkenshoShokaiHandler(requestDiv);
    }
}
