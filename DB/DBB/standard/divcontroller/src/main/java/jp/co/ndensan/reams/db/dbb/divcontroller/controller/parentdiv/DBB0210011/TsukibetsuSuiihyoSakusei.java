/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0210011;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.createtsukibetsusuiihyo.CreateTsukibetsuSuiihyoBatchParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0210011.TsukibetsuSuiihyoSakuseiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0210011.TsukibetsuSuiihyoSakuseiHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0210011.TsukibetsuSuiihyoSakuseiValidationHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 月別推移表Divのコントローラです。
 *
 * @reamsid_L DBB-0760-010 zhangguopeng
 */
public class TsukibetsuSuiihyoSakusei {

    /**
     * コントロールdivが「生成」された際の処理です。
     *
     * @param div コントロールdiv
     * @return ResponseData<TsukibetsuSuiihyoSakuseiDiv>
     */
    public ResponseData<TsukibetsuSuiihyoSakuseiDiv> onLoad(TsukibetsuSuiihyoSakuseiDiv div) {
        getHandler(div).onload();
        return ResponseData.of(div).respond();
    }

    /**
     * バッチパラメータ保存ボタンの処理です。
     *
     * @param div コントロールdiv
     * @return ResponseData<TsukibetsuSuiihyoSakuseiDiv>
     */
    public ResponseData<TsukibetsuSuiihyoSakuseiDiv> onClick_btnParameterSave(TsukibetsuSuiihyoSakuseiDiv div) {
//        getHandler(div).batchParameter();
        return ResponseData.of(div).respond();
    }

    /**
     * コバッチパラメータ復元ボタンの処理です。
     *
     * @param div コントロールdiv
     * @return ResponseData<TsukibetsuSuiihyoSakuseiDiv>
     */
    public ResponseData<TsukibetsuSuiihyoSakuseiDiv> onClick_btnParameterRestore(TsukibetsuSuiihyoSakuseiDiv div) {
//        getHandler(div).batchParameter();
        return ResponseData.of(div).respond();
    }

    /**
     * 月別推移表作成を「実行する」を押下チェックする。<br/>
     *
     * @param div
     * {@link KobetsuJikoRenkeiInfoSakuseiDiv 介護住民票個別事項連携情報作成【他社住基】情報Div}
     * @return 介護住民票個別事項連携情報作成【他社住基】情報Divを持つResponseData
     */
    public ResponseData<TsukibetsuSuiihyoSakuseiDiv> onClick_btnJikkouBefore(TsukibetsuSuiihyoSakuseiDiv div) {
        ValidationMessageControlPairs validationMessages = getValidationHandler(div).validate();
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタン押下時の処理です。<br/>
     *
     * @param div {@link TsukibetsuSuiihyoSakuseiDiv  資格得喪履歴Div}
     * @return 月別推移表作成Divを持つResponseData
     */
    public ResponseData<CreateTsukibetsuSuiihyoBatchParameter> onClick_btnJikou(TsukibetsuSuiihyoSakuseiDiv div) {
        return ResponseData.of(getHandler(div).batchParameter()).respond();
    }

    private TsukibetsuSuiihyoSakuseiHandler getHandler(TsukibetsuSuiihyoSakuseiDiv div) {
        return new TsukibetsuSuiihyoSakuseiHandler(div);
    }

    private TsukibetsuSuiihyoSakuseiValidationHandler getValidationHandler(TsukibetsuSuiihyoSakuseiDiv div) {
        return new TsukibetsuSuiihyoSakuseiValidationHandler(div);
    }
}
