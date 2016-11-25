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
    private static final RString SELECT_KEY1 = new RString("key1");
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
     * 作成帳票チェックボックス処理です。
     *
     * @param div 画面情報
     * @return ResponseData<HakkoJokenSinnseiDiv>
     */
    public ResponseData<HakkoJokenSinnseiDiv> onClick_chkSakuseiChohyo(HakkoJokenSinnseiDiv div) {
        if (div.getChkSakuseiChohyo().getSelectedKeys().contains(SELECT_KEY0) || div.getChkSakuseiChohyo().getSelectedKeys().contains(SELECT_KEY1)) {
            div.getRadHakoJyoken().setDisabled(false);
            div.getTxtShoriYMD().setDisabled(false);
            div.getTxtShinseibi().setDisabled(false);
            onClick_radHakoJyoken(div);
        } else {
            div.getRadHakoJyoken().setDisabled(true);
            div.getTxtShoriYMD().clearFromValue();
            div.getTxtShoriYMD().clearToValue();
            div.getTxtShoriYMD().setDisabled(true);
            div.getTxtShinseibi().clearFromValue();
            div.getTxtShinseibi().clearToValue();
            div.getTxtShinseibi().setDisabled(true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 作成条件ラジオボタン処理です。
     *
     * @param div 画面情報
     * @return ResponseData<HakkoJokenSinnseiDiv>
     */
    public ResponseData<HakkoJokenSinnseiDiv> onClick_radHakoJyoken(HakkoJokenSinnseiDiv div) {
        if (div.getRadHakoJyoken().getSelectedKey().contains(SELECT_KEY0)) {
            div.getTxtShoriYMD().setDisabled(false);
            div.getTxtShinseibi().clearFromValue();
            div.getTxtShinseibi().clearToValue();
            div.getTxtShinseibi().setDisabled(true);
        } else {
            div.getTxtShinseibi().setDisabled(false);
            div.getTxtShoriYMD().clearFromValue();
            div.getTxtShoriYMD().clearToValue();
            div.getTxtShoriYMD().setDisabled(true);
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
        validPairs = getValidationHandler(div).未入力チェック(validationMessages);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        validPairs = getValidationHandler(div).処理日範囲不正チェック(validationMessages);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        validPairs = getValidationHandler(div).申請日範囲不正チェック(validationMessages);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        validPairs = getValidationHandler(div).申請日入力チェック(validationMessages);
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
