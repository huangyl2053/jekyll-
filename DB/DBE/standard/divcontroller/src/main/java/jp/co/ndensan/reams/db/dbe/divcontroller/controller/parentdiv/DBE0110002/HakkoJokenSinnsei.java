/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE0110002;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE011001.DBE011001_ShinseiInfoPrintParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0110002.HakkoJokenSinnseiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0110002.HakkoJokenSinnseiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0110002.HakkoJokenSinnseiValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameterAccessor;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameters;

/**
 * 申請に関する帳票発行画面クラスです
 *
 * @reamsid_L DBE-1390-050 xuyongchao
 */
public class HakkoJokenSinnsei {

    private static final RString SELECT_KEY0 = new RString("key0");
    private static final RString KEY = new RString("key");
    private static final RString VALUE_BATCH = new RString("Batch1");

    /**
     * 画面初期化処理です。
     *
     * @param div 画面情報
     * @return ResponseData<HakkoJokenSinnseiDiv>
     */
    public ResponseData<HakkoJokenSinnseiDiv> onLoad(HakkoJokenSinnseiDiv div) {
        boolean 要介護認定申請モニタリストフラグ = ViewStateHolder.get(ViewStateKeys.要介護認定申請モニタリストフラグ,
                Boolean.class);
        boolean 要支援認定等申請者一覧フラグ = ViewStateHolder.get(ViewStateKeys.要支援認定等申請者一覧フラグ,
                Boolean.class);
        getHandler(div).onLoad(要介護認定申請モニタリストフラグ, 要支援認定等申請者一覧フラグ);
        return ResponseData.of(div).respond();
    }

    /**
     * 要介護認定申請モニタリスト帳票チェックボックス処理です。
     *
     * @param div 画面情報
     * @return ResponseData<HakkoJokenSinnseiDiv>
     */
    public ResponseData<HakkoJokenSinnseiDiv> onClick_ChkMonitror(HakkoJokenSinnseiDiv div) {

        if (div.getMonitorJoken().getChkMonitror().getSelectedKeys().contains(SELECT_KEY0)) {
            div.getMonitorJoken().getRadMonitorJoken().setDisabled(false);
            onClick_radMonitorJoken(div);
        } else {
            div.getMonitorJoken().getRadMonitorJoken().setDisabled(true);
            div.getMonitorJoken().getTxtMonitorShinseiYMD().clearFromValue();
            div.getMonitorJoken().getTxtMonitorShinseiYMD().clearToValue();
            div.getMonitorJoken().getTxtMonitorShinseiYMD().setDisabled(true);
            div.getMonitorJoken().getTxtMonitorShoriYMD().clearFromValue();
            div.getMonitorJoken().getTxtMonitorShoriYMD().clearToValue();
            div.getMonitorJoken().getTxtMonitorShoriYMD().setDisabled(true);
            div.getMonitorJoken().setIsOpen(false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 要介護認定・要支援認定申請者一覧帳票チェックボックス処理です。
     *
     * @param div 画面情報
     * @return ResponseData<HakkoJokenSinnseiDiv>
     */
    public ResponseData<HakkoJokenSinnseiDiv> onClick_ChkShinseisha(HakkoJokenSinnseiDiv div) {

        if (div.getShinseishaIchiranJoken().getChkShinseishaIchiran().getSelectedKeys().contains(SELECT_KEY0)) {
            div.getShinseishaIchiranJoken().getRadShinseishaJoken().setDisabled(false);
            onClick_radShinseishaJyoken(div);
        } else {
            div.getShinseishaIchiranJoken().getRadShinseishaJoken().setDisabled(true);
            div.getShinseishaIchiranJoken().getTxtShinseishaShinseiYMD().clearFromValue();
            div.getShinseishaIchiranJoken().getTxtShinseishaShinseiYMD().clearToValue();
            div.getShinseishaIchiranJoken().getTxtShinseishaShinseiYMD().setDisabled(true);
            div.getShinseishaIchiranJoken().getTxtShinseishaShoriYMD().clearFromValue();
            div.getShinseishaIchiranJoken().getTxtShinseishaShoriYMD().clearToValue();
            div.getShinseishaIchiranJoken().getTxtShinseishaShoriYMD().setDisabled(true);
            div.getShinseishaIchiranJoken().setIsOpen(false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 作成条件ラジオボタン処理です。
     *
     * @param div 画面情報
     * @return ResponseData<HakkoJokenSinnseiDiv>
     */
    public ResponseData<HakkoJokenSinnseiDiv> onClick_radMonitorJoken(HakkoJokenSinnseiDiv div) {
        if (div.getMonitorJoken().getRadMonitorJoken().getSelectedKey().contains(SELECT_KEY0)) {
            div.getMonitorJoken().getTxtMonitorShoriYMD().setDisabled(false);
            div.getMonitorJoken().getTxtMonitorShinseiYMD().clearFromValue();
            div.getMonitorJoken().getTxtMonitorShinseiYMD().clearToValue();
            div.getMonitorJoken().getTxtMonitorShinseiYMD().setDisabled(true);
        } else {
            div.getMonitorJoken().getTxtMonitorShinseiYMD().setDisabled(false);
            div.getMonitorJoken().getTxtMonitorShoriYMD().clearFromValue();
            div.getMonitorJoken().getTxtMonitorShoriYMD().clearToValue();
            div.getMonitorJoken().getTxtMonitorShoriYMD().setDisabled(true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 作成条件ラジオボタン処理です。
     *
     * @param div 画面情報
     * @return ResponseData<HakkoJokenSinnseiDiv>
     */
    public ResponseData<HakkoJokenSinnseiDiv> onClick_radShinseishaJyoken(HakkoJokenSinnseiDiv div) {
        if (div.getShinseishaIchiranJoken().getRadShinseishaJoken().getSelectedKey().contains(SELECT_KEY0)) {
            div.getShinseishaIchiranJoken().getTxtShinseishaShoriYMD().setDisabled(false);
            div.getShinseishaIchiranJoken().getTxtShinseishaShinseiYMD().clearFromValue();
            div.getShinseishaIchiranJoken().getTxtShinseishaShinseiYMD().clearToValue();
            div.getShinseishaIchiranJoken().getTxtShinseishaShinseiYMD().setDisabled(true);
        } else {
            div.getShinseishaIchiranJoken().getTxtShinseishaShinseiYMD().setDisabled(false);
            div.getShinseishaIchiranJoken().getTxtShinseishaShoriYMD().clearFromValue();
            div.getShinseishaIchiranJoken().getTxtShinseishaShoriYMD().clearToValue();
            div.getShinseishaIchiranJoken().getTxtShinseishaShoriYMD().setDisabled(true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 実行ボタン処理です。
     *
     * @param div 画面情報
     * @return ResponseData<HakkoJokenSinnseiDiv>
     */
    public ResponseData<DBE011001_ShinseiInfoPrintParameter> onClick_Jikkou(HakkoJokenSinnseiDiv div) {
        FlowParameters fp = FlowParameters.of(KEY, VALUE_BATCH);
        FlowParameterAccessor.merge(fp);
        return ResponseData.of(getHandler(div).setBatchParameter()).respond();
    }

    /**
     * 入力チェックです。
     *
     * @param div 画面情報
     * @return ResponseData<HakkoJokenSinnseiDiv>
     */
    public ResponseData<HakkoJokenSinnseiDiv> onClick_Check(HakkoJokenSinnseiDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        ValidationMessageControlPairs validPairs = getValidationHandler(div).未選択チェック(validationMessages);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        validPairs = getValidationHandler(div).要介護認定申請モニタリスト未入力チェック(validationMessages);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        validPairs = getValidationHandler(div).要介護認定要支援認定等申請者一覧未入力チェック(validationMessages);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        validPairs = getValidationHandler(div).要介護認定申請モニタリスト申請日入力チェック(validationMessages);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        validPairs = getValidationHandler(div).要介護認定要支援認定等申請者一覧申請日入力チェック(validationMessages);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    private HakkoJokenSinnseiValidationHandler getValidationHandler(HakkoJokenSinnseiDiv div) {
        return new HakkoJokenSinnseiValidationHandler(div);
    }

    private HakkoJokenSinnseiHandler getHandler(HakkoJokenSinnseiDiv div) {
        return new HakkoJokenSinnseiHandler(div);
    }
}
