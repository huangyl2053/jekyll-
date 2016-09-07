/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0210011;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.createtsukibetsusuiihyo.CreateTsukibetsuSuiihyoBatchParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0210011.TsukibetsuSuiihyoSakuseiParameterDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0210011.TsukibetsuSuiihyoSakuseiParameterHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0210011.TsukibetsuSuiihyoSakuseiParameterValidationHandler;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 月別推移表Divのコントローラです。
 *
 * @reamsid_L DBB-0760-010 zhangguopeng
 */
public class TsukibetsuSuiihyoSakuseiParameter {

    /**
     * コントロールdivが「生成」された際の処理です。
     *
     * @param div 月別推移表Div
     * @return ResponseData<TsukibetsuSuiihyoSakuseiParameterDiv>
     */
    public ResponseData<TsukibetsuSuiihyoSakuseiParameterDiv> onLoad(TsukibetsuSuiihyoSakuseiParameterDiv div) {
        getHandler(div).onload();
        return ResponseData.of(div).respond();
    }

    /**
     * バッチパラメータ保存ボタンの処理です。
     *
     * @param div 月別推移表Div
     * @return ResponseData<BatchParameterMap>
     */
    public ResponseData<BatchParameterMap> onClick_btnParameterSave(TsukibetsuSuiihyoSakuseiParameterDiv div) {
        ResponseData<BatchParameterMap> responseData = new ResponseData<>();
        responseData.data = new BatchParameterMap(getHandler(div).batchParameter());
        return responseData;
    }

    /**
     * 生年月日ラジオボタンを選択する場合、生年月日の処理します。
     *
     * @param div 月別推移表Div
     * @return ResponseData<TsukibetsuSuiihyoSakuseiParameterDiv>
     */
    public ResponseData<TsukibetsuSuiihyoSakuseiParameterDiv> onClick_onChange(TsukibetsuSuiihyoSakuseiParameterDiv div) {
        if (div.getRadUmareYMD().getSelectedKey() != null && !div.getRadUmareYMD().getSelectedKey().isEmpty()) {
            div.getTxtUmareSt().setDisabled(false);
            div.getTxtUmareEd().setDisabled(false);
        } else {
            div.getTxtUmareSt().setDisabled(true);
            div.getTxtUmareEd().setDisabled(true);
        }
        if (div.getRadNenrei().getSelectedKey() != null && !div.getRadNenrei().getSelectedKey().isEmpty()) {
            div.getTxtNenreiSt().setDisabled(false);
            div.getTxtNenreiEd().setDisabled(false);
            div.getTxtNenreiKijunYMD().setDisabled(false);
        } else {
            div.getTxtNenreiSt().setDisabled(true);
            div.getTxtNenreiEd().setDisabled(true);
            div.getTxtNenreiKijunYMD().setDisabled(true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * コバッチパラメータ復元ボタンの処理です。
     *
     * @param div 月別推移表Div
     * @return ResponseData<TsukibetsuSuiihyoSakuseiParameterDiv>
     */
    public ResponseData<TsukibetsuSuiihyoSakuseiParameterDiv> onClick_btnParameterRestore(TsukibetsuSuiihyoSakuseiParameterDiv div) {
        getHandler(div).onClick_btnKogakuParamRestore();
        return ResponseData.of(div).respond();
    }

    /**
     * 月別推移表作成を「実行する」を押下チェックする。<br/>
     *
     * @param div 月別推移表Div
     * @return ResponseData<TsukibetsuSuiihyoSakuseiParameterDiv>
     */
    public ResponseData<TsukibetsuSuiihyoSakuseiParameterDiv> onClick_btnJikkouBefore(TsukibetsuSuiihyoSakuseiParameterDiv div) {
        ValidationMessageControlPairs validationMessages = getValidationHandler(div).validate();
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタン押下時の処理です。<br/>
     *
     * @param div {@link TsukibetsuSuiihyoSakuseiParameterDiv  月別推移表Div}
     * @return 月別推移表作成Divを持つResponseData
     */
    public ResponseData<CreateTsukibetsuSuiihyoBatchParameter> onClick_btnJikou(TsukibetsuSuiihyoSakuseiParameterDiv div) {
        return ResponseData.of(getHandler(div).batchParameter()).respond();
    }

    private TsukibetsuSuiihyoSakuseiParameterHandler getHandler(TsukibetsuSuiihyoSakuseiParameterDiv div) {
        return new TsukibetsuSuiihyoSakuseiParameterHandler(div);
    }

    private TsukibetsuSuiihyoSakuseiParameterValidationHandler getValidationHandler(TsukibetsuSuiihyoSakuseiParameterDiv div) {
        return new TsukibetsuSuiihyoSakuseiParameterValidationHandler(div);
    }
}
