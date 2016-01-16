/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0520011;

import jp.co.ndensan.reams.db.dbu.definition.core.kyokaisogaitoshabatchparameter.KyokaisoKanriMasterListBatchParameter;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0520011.KyokaisouKanriMasterListPanelDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0520011.KyokaisouKanriMasterListPanelHandler;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0520011.KyokaisouKanriMasterListValidatisonHandler;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoBunruiKanriManager;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 境界層管理マスタリストのコントローラです。
 *
 */
public class KyokaisouKanriMasterListPanel {

    /**
     * onLoadの処理を行います。
     *
     * @param div 境界層管理マスタリストDiv
     * @return ResponseData
     */
    public ResponseData<KyokaisouKanriMasterListPanelDiv> onLoad(KyokaisouKanriMasterListPanelDiv div) {
        getHandler(div).initialize(ChohyoBunruiKanriManager.createInstance().get帳票分類管理(SubGyomuCode.DBA介護資格, new ReportId("DBA200005_KyokaisoKanriMasterList")));
        return ResponseData.of(div).respond();

    }

    /**
     * 「基準日」を選択した時、コントロールの制御。
     *
     * @param div 境界層管理マスタリストDiv
     * @return ResponseData
     */
    public ResponseData<KyokaisouKanriMasterListPanelDiv> onClick_radKijunbi(KyokaisouKanriMasterListPanelDiv div) {
        getHandler(div).setKijunbiState();
        return ResponseData.of(div).respond();
    }

    /**
     * 「範囲」を選択した時、コントロールの制御。
     *
     * @param div 境界層管理マスタリストDiv
     * @return ResponseData
     */
    public ResponseData<KyokaisouKanriMasterListPanelDiv> onClick_radHani(KyokaisouKanriMasterListPanelDiv div) {
        getHandler(div).setHaniState();
        return ResponseData.of(div).respond();
    }

    /**
     * 「指定無し」を選択した時、コントロールの制御
     *
     * @param div 境界層管理マスタリストDiv
     * @return ResponseData
     */
    public ResponseData<KyokaisouKanriMasterListPanelDiv> onClick_radShiteiNashi(KyokaisouKanriMasterListPanelDiv div) {
        getHandler(div).setShiteiNashiState();
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」を押下時のチェックです。
     *
     * @param div 境界層管理マスタリストDiv
     * @return ResponseData
     */
    public ResponseData<KyokaisouKanriMasterListPanelDiv> onClick_tituku(KyokaisouKanriMasterListPanelDiv div) {

        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        if (validate(div, pairs)) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return ResponseData.of(div).respond();

    }

    /**
     * 「実行する」を押下時、バッチパラメータを引き渡し、バッチを起動する。
     *
     * @param div 境界層管理マスタリストDiv
     * @return ResponseData
     */
    public ResponseData onClick_jiko(KyokaisouKanriMasterListPanelDiv div) {
        ResponseData<KyokaisoKanriMasterListBatchParameter> response = new ResponseData<>();
        response.data = getHandler(div).setBatchParameter();
        return response;
    }

    private KyokaisouKanriMasterListPanelHandler getHandler(KyokaisouKanriMasterListPanelDiv div) {
        return new KyokaisouKanriMasterListPanelHandler(div);
    }

    private KyokaisouKanriMasterListValidatisonHandler getValidationHandler() {
        return new KyokaisouKanriMasterListValidatisonHandler();
    }

    private boolean validate(KyokaisouKanriMasterListPanelDiv div, ValidationMessageControlPairs pairs) {
        boolean チェック結果 = false;
        if (div.getKyokaisoKariParam().getRadHaniRadio().getSelectedIndex() == 0
                && div.getKyokaisoKariParam().getTxtHaniChushutsu().getFromValue() == null
                && div.getKyokaisoKariParam().getTxtHaniChushutsu().getToValue() == null) {
            チェック結果 = true;
            pairs.add(getValidationHandler().範囲抽出必須入力チェック());
            return チェック結果;
        }
        return チェック結果;
    }
}
