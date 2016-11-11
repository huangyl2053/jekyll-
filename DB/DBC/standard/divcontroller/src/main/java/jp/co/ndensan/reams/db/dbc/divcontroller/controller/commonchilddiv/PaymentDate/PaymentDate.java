/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.commonchilddiv.PaymentDate;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.PaymentDate.PaymentDateDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.PaymentDate.PaymentDateHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * PaymentDate_支払日設定のcontrollerです。
 *
 * @reamsid_L DBC-4470-010 liwul
 */
public class PaymentDate {

    /**
     * 窓口払い一括更新区分画面控制
     *
     * @param div 画面Div
     * @return ResponseData<PaymentDateDiv>
     */
    public ResponseData<PaymentDateDiv> onClick_RadIkkatsuKoshinKubun(PaymentDateDiv div) {
        getHandler(div).窓口払い一括更新区分制御();
        return ResponseData.of(div).respond();
    }

    private PaymentDateHandler getHandler(PaymentDateDiv div) {
        return new PaymentDateHandler(div);
    }
}
