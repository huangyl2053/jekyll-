/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA7010001;

import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho.HizukeChushutsuKubun;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolisthihokenshadaicho.HanyoListHihokenshadaichoBatchParameter;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA7010001.DvHihokenshaDaichoParamDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA7010001.DvHihokenshaDaichoParamDivHandler;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA7010001.DvHihokenshaDaichoParamDivValidationHandler;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 汎用リスト被保険者台帳のクラスです。
 *
 * @reamsid_L DBA-1610-010 linghuhang
 */
public class DvHihokenshaDaichoParam {

    /**
     * 汎用リスト被保険者台帳に初期化を設定します。
     *
     * @param div 汎用リスト被保険者台帳Div
     * @return {@code ResponseData<DvHihokenshaDaichoParamDiv>}
     */
    public ResponseData<DvHihokenshaDaichoParamDiv> onLoad(DvHihokenshaDaichoParamDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 日付抽出エリア内の表示制御を設定します。
     *
     * @param div 汎用リスト被保険者台帳Div
     * @return {@code ResponseData<DvHihokenshaDaichoParamDiv>}
     */
    public ResponseData<DvHihokenshaDaichoParamDiv> onClick_radChushutsu(DvHihokenshaDaichoParamDiv div) {
        DvHihokenshaDaichoParamDivHandler handler = getHandler(div);
        HizukeChushutsuKubun kubun = handler.get日付抽出区分();
        handler.set日付抽出区分FromCode(kubun == null ? RString.EMPTY : kubun.getコード());
        return ResponseData.of(div).respond();
    }

    /**
     * 資格抽出エリア内の表示制御を設定します。
     *
     * @param div 汎用リスト被保険者台帳Div
     * @return {@code ResponseData<DvHihokenshaDaichoParamDiv>}
     */
    public ResponseData<DvHihokenshaDaichoParamDiv> onClick_radShikakuJokyo(DvHihokenshaDaichoParamDiv div) {
        getHandler(div).set抽出対象資格状況(div.getRadShikakuJokyo().getSelectedKey());
        return ResponseData.of(div).respond();
    }

    /**
     * 選択したバッチパラメータから画面項目を設定する。
     *
     * @param div 汎用リスト被保険者台帳Div
     * @return {@code ResponseData<DvHihokenshaDaichoParamDiv>}
     */
    public ResponseData<DvHihokenshaDaichoParamDiv> onClick_btnParamRestore(DvHihokenshaDaichoParamDiv div) {
        getHandler(div).restoreBatchParameter();
        return ResponseData.of(div).respond();
    }

    /**
     * 画面項目の設定値をバッチパラメータに設定、更新する。
     *
     * @param div 汎用リスト被保険者台帳Div
     * @return {@code ResponseData<BatchParameterMap>}
     */
    public ResponseData<BatchParameterMap> onClick_btnParamSave(DvHihokenshaDaichoParamDiv div) {
        ResponseData<BatchParameterMap> responseData = new ResponseData<>();
        responseData.data = new BatchParameterMap(getHandler(div).createBatchParameter());
        return responseData;
    }

    /**
     * 「実行する」を押下場合、入力チェックを実行します。
     *
     * @param div 汎用リスト被保険者台帳Div
     * @return {@code ResponseData<DvHihokenshaDaichoParamDiv>}
     */
    public ResponseData<DvHihokenshaDaichoParamDiv> onClick_btnCheck(DvHihokenshaDaichoParamDiv div) {

        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForAction();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 実行するボタンを押下する場合、バッチ起動する。
     *
     * @param div 汎用リスト被保険者台帳Div
     * @return {@code ResponseData<HanyoListHihokenshadaichoBatchParameter>}
     */
    public ResponseData<HanyoListHihokenshadaichoBatchParameter> onClick_btnExecute(DvHihokenshaDaichoParamDiv div) {
        return ResponseData.of(getHandler(div).createBatchParameter()).respond();
    }

    private DvHihokenshaDaichoParamDivHandler getHandler(DvHihokenshaDaichoParamDiv div) {
        return new DvHihokenshaDaichoParamDivHandler(div);
    }

    private DvHihokenshaDaichoParamDivValidationHandler getValidationHandler(DvHihokenshaDaichoParamDiv div) {
        return new DvHihokenshaDaichoParamDivValidationHandler(div);
    }
}
