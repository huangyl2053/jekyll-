/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD8010002;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010002.HikazeiNenkinTaishoshaJohoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD8010002.HikazeiNenkinTaishoshaJohoHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD8010002.HikazeiNenkinTaishoshaJohoValidationHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 非課税年金対象者情報取込画面のDivControllerです。
 *
 * @reamsid_L DBD-4910-010 huangh
 */
public class HikazeiNenkinTaishoshaJoho {

    /**
     * 画面初期化処理です。
     *
     * @param div JissiJyokyohyoDiv
     * @return ResponseData<JissiJyokyohyoDiv>
     */
    public ResponseData<HikazeiNenkinTaishoshaJohoDiv> onLoad(HikazeiNenkinTaishoshaJohoDiv div) {
        getHandler(div).onLoad(div);
        return ResponseData.of(div).respond();
    }

    private HikazeiNenkinTaishoshaJohoHandler getHandler(HikazeiNenkinTaishoshaJohoDiv div) {
        return new HikazeiNenkinTaishoshaJohoHandler(div);
    }

    private HikazeiNenkinTaishoshaJohoValidationHandler getValidationHandler(HikazeiNenkinTaishoshaJohoDiv div) {
        return new HikazeiNenkinTaishoshaJohoValidationHandler(div);
    }
}
