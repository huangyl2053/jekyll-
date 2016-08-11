/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.kaigiatesakijushosettei;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatesakijushosettei.KaigoAtesakiJushoSettei.KaigoAtesakiJushoSetteiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatesakijushosettei.KaigoAtesakiJushoSettei.KaigoAtesakiJushoSetteiHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 介護宛先住所設定クラスです。
 *
 * @reamsid_L DBU-3990-030 wanghui
 */
public class KaigoAtesakiJushoSettei {

    /**
     * 介護宛先住所設定画面を設定します。
     *
     * @param div 介護宛先住所設定Div
     * @return ResponseData<KaigoAtesakiJushoSetteiDiv>
     */
    public ResponseData<KaigoAtesakiJushoSetteiDiv> onChange_radJushoSettei(KaigoAtesakiJushoSetteiDiv div) {
        getHandler(div).setradJushoSettei(div.getHdnサブ業務コード(), div.getHdn帳票分類ID());
        getHandler(div).宛先住所編集書式();
        return ResponseData.of(div).respond();
    }

    /**
     * 介護宛先住所設定画面を設定します。
     *
     * @param div 介護宛先住所設定Div
     * @return ResponseData<KaigoAtesakiJushoSetteiDiv>
     */
    public ResponseData<KaigoAtesakiJushoSetteiDiv> onOkClose_radJushoSettei(KaigoAtesakiJushoSetteiDiv div) {
        getHandler(div).宛先住所編集書式();
        return ResponseData.of(div).respond();
    }

    private KaigoAtesakiJushoSetteiHandler getHandler(KaigoAtesakiJushoSetteiDiv div) {
        return new KaigoAtesakiJushoSetteiHandler(div);
    }
}
