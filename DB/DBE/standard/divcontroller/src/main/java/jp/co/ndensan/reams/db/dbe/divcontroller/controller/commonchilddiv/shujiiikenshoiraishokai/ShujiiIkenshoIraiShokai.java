/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.commonchilddiv.shujiiikenshoiraishokai;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ShujiiIkenshoIraiShokai.ShujiiIkenshoIraiShokai.ShujiiIkenshoIraiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ShujiiIkenshoIraiShokai.ShujiiIkenshoIraiShokai.ShujiiIkenshoIraiShokaiDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 主治医意見書作成依頼情報Divの処理を表します。
 *
 * @reamsid_L DBE-0200-030 zhangzhiming
 */
public class ShujiiIkenshoIraiShokai {

    /**
     * 初期化の処理を表します。
     *
     * @param div 主治医意見書作成依頼情報Div
     * @return ResponseData
     */
    public ResponseData initialize(ShujiiIkenshoIraiShokaiDiv div) {
        createHandlerOf(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 「戻る」ボタン押下時の処理を表します。
     *
     * @param div 主治医意見書作成依頼情報Div
     * @return ResponseData
     */
    public ResponseData onClick_btnReturn(ShujiiIkenshoIraiShokaiDiv div) {
        return ResponseData.of(div).respond();
    }

    private ShujiiIkenshoIraiHandler createHandlerOf(ShujiiIkenshoIraiShokaiDiv requestDiv) {
        return new ShujiiIkenshoIraiHandler(requestDiv);
    }
}
