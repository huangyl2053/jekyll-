/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.commonchilddiv.shunojoho;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.shunojoho.ShunoJoho.ShunoJohoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.shunojoho.ShunoJoho.ShunoJohoHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

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
     * 画面初期化処理のメソッドです。
     *
     * @param div ShunoJohoDiv
     * @return ResponseData<ShunoJohoDiv>
     */
    public ResponseData<ShunoJohoDiv> initialize(ShunoJohoDiv div) {
        getHandler(div).init();
        return ResponseData.of(div).respond();
    }

    /**
     * 「年度を変更する」ボタン押下時のイベントです。
     *
     * @param div ShunoJohoDiv
     * @return ResponseData<ShunoJohoDiv>
     */
    public ResponseData<ShunoJohoDiv> onClick(ShunoJohoDiv div) {

        getHandler(div).load(new FlexibleYear(div.getDdlChoteiNendo().getSelectedKey()),
                new FlexibleYear(div.getDdlFukaNendo().getSelectedKey()),
                new TsuchishoNo(div.getTxtTsuchiNo().getValue()));
        return ResponseData.of(div).respond();
    }

}
