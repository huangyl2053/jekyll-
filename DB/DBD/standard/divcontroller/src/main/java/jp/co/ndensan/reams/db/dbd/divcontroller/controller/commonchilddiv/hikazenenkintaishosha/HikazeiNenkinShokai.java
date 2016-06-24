/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.commonchilddiv.hikazenenkintaishosha;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.HikazeiNenkinShokai.HikazeiNenkinShokai.HikazeiNenkinShokaiDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.ShotokuJokyo.ShotokuJokyo.ShotokuJokyoDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 *
 * 【共有子Div】 非課税年金のDivControllerです。
 *
 * @reamsid_L DBD-3560-140 liangbc
 */
public class HikazeiNenkinShokai {

    /**
     * 初期化
     *
     * @param div ShotokuJokyoDiv
     * @return ResponseData<HikazeiNenkinShokaiDiv>
     */
    public ResponseData<HikazeiNenkinShokaiDiv> initialize(HikazeiNenkinShokaiDiv div) {
        div.initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 再表示
     *
     * @param div ShotokuJokyoDiv
     * @return ResponseData<HikazeiNenkinShokaiDiv>
     */
    public ResponseData<HikazeiNenkinShokaiDiv> onClick_btnSaiHyoji(HikazeiNenkinShokaiDiv div) {
        div.再表示();
        return ResponseData.of(div).respond();
    }

    /**
     * 所得状況画面を閉じる。
     *
     * @param div ShotokuJokyoDiv
     * @return ResponseData<ShotokuJokyoDiv>
     */
    public ResponseData<ShotokuJokyoDiv> onClick_btnClose(ShotokuJokyoDiv div) {
        return ResponseData.of(div).dialogOKClose();
    }
}
