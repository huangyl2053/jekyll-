/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD4920001;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4920001.DBD4920001StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4920001.YogaigoNinteiKekkaRenkeiDataTorikomiDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD4920001.YogaigoNinteiKekkaRenkeiDataTorikomiHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 要介護認定結果連携データ取込のコントローラです。
 *
 * @reamsid_L DBE_1510-010 miaojin
 */
public class YogaigoNinteiKekkaRenkeiDataTorikomi {

    /**
     * 初期化の設定します。
     *
     * @param div YogaigoNinteiKekkaRenkeiDataTorikomiDiv
     * @return ResponseData<YogaigoNinteiKekkaRenkeiDataTorikomiDiv>
     */
    public ResponseData<YogaigoNinteiKekkaRenkeiDataTorikomiDiv> onLoad(YogaigoNinteiKekkaRenkeiDataTorikomiDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).setState(DBD4920001StateName.初期表示);
    }

    private YogaigoNinteiKekkaRenkeiDataTorikomiHandler getHandler(YogaigoNinteiKekkaRenkeiDataTorikomiDiv div) {
        return new YogaigoNinteiKekkaRenkeiDataTorikomiHandler(div);
    }
}
