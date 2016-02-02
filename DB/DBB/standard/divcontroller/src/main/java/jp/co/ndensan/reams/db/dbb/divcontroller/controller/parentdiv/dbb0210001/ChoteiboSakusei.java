/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.dbb0210001;

import jp.co.ndensan.reams.db.dbb.business.core.choteibo.ChoteiboSakuseiManager;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.choteibo.ChoteiboBatchParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0210001.ChoteiboSakuseiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.dbb0210001.ChoteiboSakuseiHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.dbb0210001.ChoteiboSakuseiValidationHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 調定簿作成Divのコントローラです。
 */
public class ChoteiboSakusei {

    /**
     * コントロールdivが「生成」された際の処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ChoteiboSakuseiDiv> onLoad(ChoteiboSakuseiDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    private ChoteiboSakuseiHandler getHandler(ChoteiboSakuseiDiv div) {
        return ChoteiboSakuseiHandler.of(div);
    }

    /**
     * コントロールdivが「実行する」ボタンされた際の処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ChoteiboBatchParameter> onClick_btnBatchRegister(ChoteiboSakuseiDiv div) {
        ChoteiboSakuseiValidationHandler handler = new ChoteiboSakuseiValidationHandler(div);
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(handler.validateFor処理年度未入力());
        validationMessages.add(handler.validateFor抽出調定日時の開始年月日未入力());
        validationMessages.add(handler.validateFor抽出調定日時の終了年月日未入力());
        validationMessages.add(handler.validateFor抽出調定日時の終了時分秒未入力());
        ChoteiboBatchParameter parameter = new ChoteiboBatchParameter();
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(parameter).addValidationMessages(validationMessages).respond();
        }

        ChoteiboSakuseiManager manage = new ChoteiboSakuseiManager();
        parameter = manage.getChoteiboParameter(
                new FlexibleYear(div.getDdlShoriNendo().getSelectedValue()),
                div.getTxtChushutsuStYMD().getValue(),
                div.getTxtChushutsuStTime().getValue(),
                div.getTxtChushutsuEdYMD().getValue(),
                div.getTxtChushutsuEdTime().getValue());
        return ResponseData.of(parameter).respond();
    }
}
