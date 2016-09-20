/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0210001;

import jp.co.ndensan.reams.db.dbb.business.core.choteibo.ChoteiboSakuseiManager;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB021001.DBB021001_ChoteiboSakuseiParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0210001.ChoteiboSakuseiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0210001.ChoteiboSakuseiHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0210001.ChoteiboSakuseiValidationHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 調定簿作成Divのコントローラです。
 *
 * @reamsid_L DBB-0770-010 cuilin
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

    private ChoteiboSakuseiValidationHandler getChoteiboSakuseiValidationHandler(ChoteiboSakuseiDiv div) {
        return new ChoteiboSakuseiValidationHandler(div);
    }

    /**
     * バッチ実行と条件チェックイベントのバリデーション。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData onClick_batchCheck(ChoteiboSakuseiDiv div) {
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
    public ResponseData<DBB021001_ChoteiboSakuseiParameter> onClick_btnBatchRegister(ChoteiboSakuseiDiv div) {
        ResponseData<DBB021001_ChoteiboSakuseiParameter> responseData = new ResponseData<>();
        responseData.data = setBatchParameter(div);
        return responseData;
    }

    private DBB021001_ChoteiboSakuseiParameter setBatchParameter(ChoteiboSakuseiDiv div) {
        ChoteiboSakuseiManager manage = new ChoteiboSakuseiManager();
        DBB021001_ChoteiboSakuseiParameter parameter = manage.getChoteiboParameter(
                new FlexibleYear(new RDate(div.getDdlShoriNendo().getSelectedValue().toString()).seireki().getYear()),
                div.getTxtChushutsuStYMD().getValue(),
                div.getTxtChushutsuStTime().getValue(),
                div.getTxtChushutsuEdYMD().getValue(),
                div.getTxtChushutsuEdTime().getValue());
        return parameter;
    }
}
