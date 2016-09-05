/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC7080001;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710080.DBC710080_HanyoListKyufuKanriHyoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7080001.HanyoListParamKyoufuKannrihyouDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7080001.HanyoListParamKyoufuKannrihyouHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 汎用リスト出力(給付管理票)
 *
 * @reamsid_L DBC-3096-010 zhengshenlei
 */
public class HanyoListParamKyoufuKannrihyou {

    /**
     * 画面初期化です。
     *
     * @param div HanyoListParamKyoufuKannrihyouDiv
     * @return ResponseData<HanyoListParamDiv>
     */
    public ResponseData<HanyoListParamKyoufuKannrihyouDiv> onload(HanyoListParamKyoufuKannrihyouDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタンのメソッドです。
     *
     * @param div HanyoListParamKyoufuKannrihyouDiv
     * @return ResponseData
     */
    public ResponseData<DBC710080_HanyoListKyufuKanriHyoParameter> onclick_btBatch(HanyoListParamKyoufuKannrihyouDiv div) {
        DBC710080_HanyoListKyufuKanriHyoParameter parameter = getHandler(div).バッチ実行();
        return ResponseData.of(parameter).respond();
    }

    private HanyoListParamKyoufuKannrihyouHandler getHandler(HanyoListParamKyoufuKannrihyouDiv div) {
        return new HanyoListParamKyoufuKannrihyouHandler(div);
    }
}
