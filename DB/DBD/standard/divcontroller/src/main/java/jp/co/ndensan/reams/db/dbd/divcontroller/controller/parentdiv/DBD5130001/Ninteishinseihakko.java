/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD5130001;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5130001.NinteishinseihakkoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5130001.NinteishinseihakkoHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 要介護認定申請書発行画面のDivControllerです。
 *
 * @reamsid_L DBD-1400-010 tianyh
 */
public class Ninteishinseihakko {

    /**
     * 画面初期化
     *
     * @param div NinteishinseihakkoDiv
     * @return ResponseData<NinteishinseihakkoDiv>
     */
    public ResponseData<NinteishinseihakkoDiv> onLoad(NinteishinseihakkoDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    private NinteishinseihakkoHandler getHandler(NinteishinseihakkoDiv div) {
        return new NinteishinseihakkoHandler(div);
    }

}
