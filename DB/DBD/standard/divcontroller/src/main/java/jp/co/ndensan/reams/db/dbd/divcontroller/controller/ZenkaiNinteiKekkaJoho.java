/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.ZenkaiNinteiKekkaJoho.ZenkaiNinteiKekkaJohoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.ZenkaiNinteiKekkaJoho.ZenkaiNinteiKekkaJohoHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 共有子Div「前回認定結果」のイベントを定義した共有子Divです。
 *
 * @author n8223 朴義一
 */
public class ZenkaiNinteiKekkaJoho {

    /**
     * 前回認定値を照会するのonClickイベントです。<br/>
     * 共有子Div上で入力された申請書管理お番号から前回認定結果の情報を取得します。
     *
     * @param div 前回認定結果div
     * @return 前回認定結果の情報
     */
    public ResponseData<ZenkaiNinteiKekkaJohoDiv> onClick_btn_ZenkaiShosai(ZenkaiNinteiKekkaJohoDiv div) {
        createHandOf(div).onClickBtnZenkaiJohoShosaiGuide();
        return createSettingData(div);
    }

    private ZenkaiNinteiKekkaJohoHandler createHandOf(ZenkaiNinteiKekkaJohoDiv div) {
        return new ZenkaiNinteiKekkaJohoHandler(div);
    }

    private <T> ResponseData<T> createSettingData(T settingData) {
        ResponseData<T> response = new ResponseData<>();
        response.data = settingData;
        return response;
    }

}
