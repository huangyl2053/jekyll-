/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.HanyoListAtenaSelect;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hanyolistatenaselect.HanyoListAtenaSelect.HanyoListAtenaSelectDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hanyolistatenaselect.HanyoListAtenaSelect.HanyoListAtenaSelectHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 汎用リスト宛名抽出条件のクラス。
 *
 * @reamsid_L DBA-1610-040 dingyi
 */
public class HanyoListAtenaSelect {

    /**
     * 「宛名検索条件」ラジオボタン連動処理をします。
     *
     * @param div 汎用リスト宛名抽出条件Div
     * @return ResponseData<HanyoListAtenaSelectDiv>
     */
    public ResponseData<HanyoListAtenaSelectDiv> onChange_SelectKijun(HanyoListAtenaSelectDiv div) {
        getHandler(div).onChange_SelectKijun();
        return ResponseData.of(div).respond();
    }

    /**
     * 「地区」DDL連動処理をします。
     *
     * @param div 汎用リスト宛名抽出条件Div
     * @return ResponseData<HanyoListAtenaSelectDiv>
     */
    public ResponseData<HanyoListAtenaSelectDiv> onChange_SelectChiku(HanyoListAtenaSelectDiv div) {
        getHandler(div).onChange_SelectChiku();
        return ResponseData.of(div).respond();
    }

    private HanyoListAtenaSelectHandler getHandler(HanyoListAtenaSelectDiv div) {
        return new HanyoListAtenaSelectHandler(div);
    }

}
