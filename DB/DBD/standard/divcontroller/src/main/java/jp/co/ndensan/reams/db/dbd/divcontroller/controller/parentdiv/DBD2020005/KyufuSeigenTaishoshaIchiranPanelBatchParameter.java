/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD2020005;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD210010.DBD210010_KyufuSeigenTaishoshaListParameter;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2020005.KyufuSeigenTaishoshaIchiranPanelBatchParameterDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD2020005.KyufuSeigenTaishoshaIchiranPanelBatchParameterHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD2020005.KyufuSeigenTaishoshaIchiranPanelBatchParameterValidationHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 給付制限対象者一覧CSVのDivControllerです。
 *
 * @reamsid_L DBD-4300-010 xuejm
 */
public class KyufuSeigenTaishoshaIchiranPanelBatchParameter {

    private static final RString KEY1 = new RString("key1");

    /**
     * 給付制限対象者一覧CSVDivの初期化を表します。
     *
     * @param div KyufuSeigenTaishoshaIchiranPanelBatchParameterDiv
     * @return ResponseData
     */
    public ResponseData<KyufuSeigenTaishoshaIchiranPanelBatchParameterDiv> onLoad(KyufuSeigenTaishoshaIchiranPanelBatchParameterDiv div) {
        createHandler(div).onLaod();
        return ResponseData.of(div).respond();
    }

    /**
     * 給付制限種別を選択されたの処理です
     *
     * @param div KyufuSeigenTaishoshaIchiranPanelBatchParameterDiv
     * @return ResponseData
     */
    public ResponseData<KyufuSeigenTaishoshaIchiranPanelBatchParameterDiv> onClick_radKyuuhuSeigenShubetu(KyufuSeigenTaishoshaIchiranPanelBatchParameterDiv div) {
        createHandler(div).onClick_radKyuuhuSeigenShubetu();
        return ResponseData.of(div).respond();
    }

    /**
     * 実行するボタンを押下のチェック処理します。
     *
     * @param div KyufuSeigenTaishoshaIchiranPanelBatchParameterDiv のクラスファイル
     * @return ResponseData
     */
    public ResponseData<KyufuSeigenTaishoshaIchiranPanelBatchParameterDiv> onBeforeCilck_batchcheck(KyufuSeigenTaishoshaIchiranPanelBatchParameterDiv div) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        if (div.getRadKyuuhuSeigenShubetu().getSelectedKey().equals(KEY1)) {
            getValidationHandler().validateFor出力対象選択なしの入力チェック(pairs, div);
        }
        getValidationHandler().validateFor出力順未設定チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 実行するボタンを押下バッチパラメータの作成の処理です。
     *
     * @param div KyufuSeigenTaishoshaIchiranPanelBatchParameterDiv のクラスファイル
     * @return DBD210010_KyufuSeigenTaishoshaListParameter
     */
    public ResponseData<DBD210010_KyufuSeigenTaishoshaListParameter> onClick_btnBatchExecute(KyufuSeigenTaishoshaIchiranPanelBatchParameterDiv div) {
        DBD210010_KyufuSeigenTaishoshaListParameter parameter = new DBD210010_KyufuSeigenTaishoshaListParameter();
        createHandler(div).onClick_btnBatchExecute(div, parameter);
        return ResponseData.of(parameter).respond();
    }

    private KyufuSeigenTaishoshaIchiranPanelBatchParameterHandler createHandler(KyufuSeigenTaishoshaIchiranPanelBatchParameterDiv div) {
        return new KyufuSeigenTaishoshaIchiranPanelBatchParameterHandler(div);
    }

    private KyufuSeigenTaishoshaIchiranPanelBatchParameterValidationHandler getValidationHandler() {
        return new KyufuSeigenTaishoshaIchiranPanelBatchParameterValidationHandler();
    }
}
