/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.ZenkaiNinteiKekkaJoho;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ZenkaiNinteiKekkaJoho.ZenkaiNinteiKekkaJoho.ZenkaiNinteiKekkaJohoDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 前回結果情報の画面Controllerクラスです。
 *
 * @reamsid_L DBE-3000-020 dongyabin
 */
public class ZenkaiNinteiKekkaJoho {

    /**
     * 「前回の認定内容を照会する」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<ZenkaiNinteiKekkaJohoDiv>
     */
    public ResponseData<ZenkaiNinteiKekkaJohoDiv> onBefore_Dialog(ZenkaiNinteiKekkaJohoDiv div) {
        return ResponseData.of(div).respond();
    }
}
