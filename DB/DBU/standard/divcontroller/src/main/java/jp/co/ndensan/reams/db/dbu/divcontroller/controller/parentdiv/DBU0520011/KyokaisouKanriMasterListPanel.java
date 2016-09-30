/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0520011;

import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU060010.DBU060010_KyokaisoKanriMasterListParameter;
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
 * @reamsid_L DBU-1050-010 wanghui
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

        ValidationMessageControlPairs validationMessageControlPairs = getValidationHandler(div).範囲抽出必須入力チェック();
        if (validationMessageControlPairs.iterator().hasNext()) {

            return ResponseData.of(div).addValidationMessages(validationMessageControlPairs).respond();
        }
        return ResponseData.of(div).respond();

    }

    /**
     * 「実行する」を押下時、バッチパラメータを引き渡し、バッチを起動する。
     *
     * @param div 境界層管理マスタリストDiv
     * @return ResponseData
     */
    public ResponseData<DBU060010_KyokaisoKanriMasterListParameter> onClick_jiko(KyokaisouKanriMasterListPanelDiv div) {
        return ResponseData.of(getHandler(div).setBatchParameter()).respond();
    }

    private KyokaisouKanriMasterListPanelHandler getHandler(KyokaisouKanriMasterListPanelDiv div) {
        return new KyokaisouKanriMasterListPanelHandler(div);
    }

    private KyokaisouKanriMasterListValidatisonHandler getValidationHandler(KyokaisouKanriMasterListPanelDiv div) {
        return new KyokaisouKanriMasterListValidatisonHandler(div);
    }
}
