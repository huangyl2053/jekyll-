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
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 調定簿作成Divのコントローラです。
 */
public class ChoteiboSakusei {

    private ChoteiboSakuseiValidationHandler getChoteiboSakuseiValidationHandler(ChoteiboSakuseiDiv div) {
        return new ChoteiboSakuseiValidationHandler(div);
    }

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
     * バッチ実行と条件保存イベントのバリデーション。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData batchCheck(ChoteiboSakuseiDiv div) {
        ValidationMessageControlPairs valid = getChoteiboSakuseiValidationHandler(div).validate();
        if (valid.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(valid).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * コントロールdivが「実行する」ボタンされた際の処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData onClick_btnBatchRegister(ChoteiboSakuseiDiv div) {
        ResponseData<ChoteiboBatchParameter> responseData = new ResponseData<>();
        ChoteiboSakuseiManager manage = new ChoteiboSakuseiManager();
        responseData.data = manage.getChoteiboParameter(
                new FlexibleYear(new RDate(div.getDdlShoriNendo().getSelectedValue().toString()).seireki().getYear()),
                div.getTxtChushutsuStYMD().getValue(),
                div.getTxtChushutsuStTime().getValue(),
                div.getTxtChushutsuEdYMD().getValue(),
                div.getTxtChushutsuEdTime().getValue());
        return responseData;
    }
}
