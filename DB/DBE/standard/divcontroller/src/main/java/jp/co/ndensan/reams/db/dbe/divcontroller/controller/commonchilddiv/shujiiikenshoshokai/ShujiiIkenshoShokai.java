/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.commonchilddiv.shujiiikenshoshokai;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ShujiiIkenshoShokai.ShujiiIkenshoShokaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ShujiiIkenshoShokai.ShujiiIkenshoShokaiHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
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
    public ResponseData<ShujiiIkenshoShokaiDiv> onLoad(ShujiiIkenshoShokaiDiv div) {
        ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(div.getHiddenShinseishoKanriNo());
        int 主治医意見書作成依頼履歴番号 = 0;
        if (!div.getHiddenIkenshoIraiRirekiNo().isEmpty() && div.getHiddenIkenshoIraiRirekiNo() != null) {
            主治医意見書作成依頼履歴番号 = Integer.parseInt(div.getHiddenIkenshoIraiRirekiNo().toString());
        } else {
            div.getCcdChosaTokkiShiryoShokai().setDisplayNone(true);
            return ResponseData.of(div).respond();
        }
        createHandlerOf(div).onLoad(申請書管理番号, 主治医意見書作成依頼履歴番号);
        return ResponseData.of(div).respond();
    }

    /**
     * 「戻る」ボタン押下時の処理を表します。
     *
     * @param div 主治医意見書作成依頼情報Div
     * @return ResponseData
     */
    public ResponseData<ShujiiIkenshoShokaiDiv> onClick_btnReturn(ShujiiIkenshoShokaiDiv div) {
        return ResponseData.of(div).respond();
    }

    private ShujiiIkenshoShokaiHandler createHandlerOf(ShujiiIkenshoShokaiDiv requestDiv) {
        return new ShujiiIkenshoShokaiHandler(requestDiv);
    }
}
