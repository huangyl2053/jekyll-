/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.commonchilddiv.shunoJoho;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.shunojoho.ShunoJoho.ShunoJohoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.shunojoho.ShunoJoho.ShunoJohoHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 収納情報【共有子Div】のクラスです。
 *
 * @reamsid_L DBB-5710-010 xuxin
 */
public class ShunoJoho {

    private ShunoJohoHandler getHandler(ShunoJohoDiv div) {
        return new ShunoJohoHandler(div);
    }

    /**
     * 初期化処理のメソッドです。
     *
     * @param div ShunoJohoDiv
     * @return ResponseData
     */
    public ResponseData<ShunoJohoDiv> onLoad(ShunoJohoDiv div) {
        getHandler(div).setDDL初期化();
        return ResponseData.of(div).respond();
    }
}
