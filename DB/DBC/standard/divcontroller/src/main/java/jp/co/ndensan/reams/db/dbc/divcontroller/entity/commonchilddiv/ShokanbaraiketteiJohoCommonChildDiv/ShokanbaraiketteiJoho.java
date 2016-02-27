/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShokanbaraiketteiJohoCommonChildDiv;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShokanbaraiketteiJoho.ShokanbaraiketteiJohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShokanbaraiketteiJoho.ShokanbaraiketteiJohoHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 償還払決定一覧クラスです。
 */
public class ShokanbaraiketteiJoho {

    /**
     * 償還払決定一覧取得を取得します。
     *
     * @param div ShokanbaraiketteiJohoDiv
     * @return ShokanbaraiketteiJohoDivのResponseData
     */
    public ResponseData<ShokanbaraiketteiJohoDiv> onload(ShokanbaraiketteiJohoDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * データグリッドの差額金額を合計して、差額支払金額合計に設定します。
     *
     * @param div ShokanbaraiketteiJohoDiv
     * @return ShokanbaraiketteiJohoDivのResponseData
     */
    public ResponseData<ShokanbaraiketteiJohoDiv> onChange_defaultDataName6(ShokanbaraiketteiJohoDiv div) {

        createHandlerOf(div).onChange_defaultDataName6();
        return ResponseData.of(div).respond();
    }

    /**
     * 支給区分変更に設定します。
     *
     * @param div ShokanbaraiketteiJohoDiv
     * @return ShokanbaraiketteiJohoDivのResponseData
     */
    public ResponseData<ShokanbaraiketteiJohoDiv> onChange_rdoShikyukubun(ShokanbaraiketteiJohoDiv div) {
        createHandlerOf(div).onChange_rdoShikyukubun();
        return ResponseData.of(div).respond();
    }

    private ShokanbaraiketteiJohoHandler createHandlerOf(ShokanbaraiketteiJohoDiv requestDiv) {
        return new ShokanbaraiketteiJohoHandler(requestDiv);
    }
}
