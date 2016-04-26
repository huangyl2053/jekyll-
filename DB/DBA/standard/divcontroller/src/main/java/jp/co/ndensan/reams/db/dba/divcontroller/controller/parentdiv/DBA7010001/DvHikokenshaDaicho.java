/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA7010001;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA7010001.DvHikokenshaDaichoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA7010001.DvHikokenshaDaichoDivHandler;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA7010001.DvHikokenshaDaichoDivValidationHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 汎用リスト被保険者台帳のクラスです。
 *
 * @reamsid_L DBA-1610-010 linghuhang
 */
public class DvHikokenshaDaicho {

    /**
     * 汎用リスト被保険者台帳に初期化を設定します。
     *
     * @param div 汎用リスト被保険者台帳Div
     * @return ResponseData<DvHikokenshaDaichoDiv>
     */
    public ResponseData<DvHikokenshaDaichoDiv> onLoad(DvHikokenshaDaichoDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 日付抽出エリア内の表示制御を設定します。
     *
     * @param div 汎用リスト被保険者台帳Div
     * @return ResponseData<DvHikokenshaDaichoDiv>
     */
    public ResponseData<DvHikokenshaDaichoDiv> onClick_Chushutsu(DvHikokenshaDaichoDiv div) {
        getHandler(div).onClick_Chushutsu(div.getRadChushutsu().getSelectedKey());
        return ResponseData.of(div).respond();
    }

    /**
     * 資格抽出エリア内の表示制御を設定します。
     *
     * @param div 汎用リスト被保険者台帳Div
     * @return ResponseData<DvHikokenshaDaichoDiv>
     */
    public ResponseData<DvHikokenshaDaichoDiv> onClick_ChushutsuKijun(DvHikokenshaDaichoDiv div) {
        getHandler(div).onClick_ChushutsuKijun(div.getRadChushutsuKijun().getSelectedKey());
        return ResponseData.of(div).respond();
    }

    /**
     * 選択したバッチパラメータから画面項目を設定する。
     *
     * @param div 汎用リスト被保険者台帳Div
     * @return ResponseData<DvHikokenshaDaichoDiv>
     */
    public ResponseData<DvHikokenshaDaichoDiv> onClick_btnKogakuParamRestore(DvHikokenshaDaichoDiv div) {
        getHandler(div).onClick_btnKogakuParamRestore();
        return ResponseData.of(div).respond();
    }

    /**
     * 画面項目の設定値をバッチパラメータに設定、更新する。
     *
     * @param div 汎用リスト被保険者台帳Div
     * @return ResponseData<DvHikokenshaDaichoDiv>
     */
    public ResponseData<DvHikokenshaDaichoDiv> onClick_btnKogakuParamSave(DvHikokenshaDaichoDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForAction();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        getHandler(div).onClick_btnKogakuParamSave();
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」を押下場合、入力チェックを実行します。
     *
     * @param div 汎用リスト被保険者台帳Div
     * @return ResponseData<DvHikokenshaDaichoDiv>
     */
    public ResponseData<DvHikokenshaDaichoDiv> onClick_btnCheck(DvHikokenshaDaichoDiv div) {

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
     * @return ResponseData<DvHikokenshaDaichoDiv>
     */
    public ResponseData<DvHikokenshaDaichoDiv> onClick_btnExecute(DvHikokenshaDaichoDiv div) {
        getHandler(div).onClick_btnKogakuParamSave();
        return ResponseData.of(div).respond();
    }

    private DvHikokenshaDaichoDivHandler getHandler(DvHikokenshaDaichoDiv div) {
        return new DvHikokenshaDaichoDivHandler(div);
    }

    private DvHikokenshaDaichoDivValidationHandler getValidationHandler(DvHikokenshaDaichoDiv div) {
        return new DvHikokenshaDaichoDivValidationHandler(div);
    }
}
