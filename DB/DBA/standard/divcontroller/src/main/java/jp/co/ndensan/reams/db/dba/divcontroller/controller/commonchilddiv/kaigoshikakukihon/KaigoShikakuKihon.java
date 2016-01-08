/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.commonchilddiv.kaigoshikakukihon;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護資格基本commonchilddiv
 */
public class KaigoShikakuKihon {

    private static final RString 照会モード = new RString("shokai");

    /**
     * 連絡先DBZ.ShikakuTokusoRirekiを照会モードで呼び出す
     *
     * @param div 介護資格基本commonchilddiv
     * @return
     */
    public ResponseData<KaigoShikakuKihonDiv> onClick_BeforeOpenDialog(KaigoShikakuKihonDiv div) {
        div.setMode(照会モード);
        return ResponseData.of(div).respond();
    }
}
