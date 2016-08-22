/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC7080001;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.dbc710080.DBC710080_HanyoListKyufuKanriHyoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7080001.HanyoListParamDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7080001.HanyoListParamHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 汎用リスト出力(給付管理票)
 *
 * @reamsid_L DBC-3096-010 zhengshenlei
 */
public class HanyoListParam {

    /**
     * 画面初期化です。
     *
     * @param div 汎用リスト出力(給付管理票) の画面Div
     * @return ResponseData<NendoKirikaeDiv>
     */
    public ResponseData<HanyoListParamDiv> onload(HanyoListParamDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタンのメソッドです。
     *
     * @param div HanyoListParamDiv
     * @return ResponseData
     */
    public ResponseData<DBC710080_HanyoListKyufuKanriHyoParameter> onclick_btBatch(HanyoListParamDiv div) {
        if (!ResponseHolder.isReRequest()
                && new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            DBC710080_HanyoListKyufuKanriHyoParameter parameter = getHandler(div).バッチ実行();
            return ResponseData.of(parameter).respond();
        } else {
            return null;
        }
    }

    private HanyoListParamHandler getHandler(HanyoListParamDiv div) {
        return new HanyoListParamHandler(div);
    }
}
