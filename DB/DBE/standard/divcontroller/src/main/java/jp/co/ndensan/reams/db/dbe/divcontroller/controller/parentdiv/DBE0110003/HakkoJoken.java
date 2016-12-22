/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE0110003;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE012001.DBE012001_ChosaInfoPrintParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0110003.HakkoJokenDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0110003.HakkoJokenHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0110003.HakkoJokenValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameterAccessor;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameters;

/**
 * 認定調査に関する帳票発行画面クラスです
 *
 * @reamsid_L DBE-1390-060 xuyongchao
 */
public class HakkoJoken {

    private static final RString SELECT_KEY0 = new RString("key0");
    private static final RString SELECT_KEY1 = new RString("key1");
    private static final RString SELECT_KEY2 = new RString("key2");
    private static final RString KEY = new RString("key");
    private static final RString VALUE_BATCH = new RString("Batch2");

    /**
     * 画面初期化処理です。
     *
     * @param div 画面情報
     * @return ResponseData<HakkoJokenDiv>
     */
    public ResponseData<HakkoJokenDiv> onLoad(HakkoJokenDiv div) {
        boolean 認定調査予定未定者一覧フラグ = ViewStateHolder.get(ViewStateKeys.認定調査予定未定者一覧フラグ, Boolean.class);
        boolean 認定調査依頼先変更者一覧表フラグ = ViewStateHolder.get(ViewStateKeys.認定調査依頼先変更者一覧表フラグ, Boolean.class);
        boolean 認定調査結果と主治医意見書のチェックリストフラグ
                = ViewStateHolder.get(ViewStateKeys.認定調査結果と主治医意見書のチェックリストフラグ, Boolean.class);
        getHandler(div).onLoad(認定調査予定未定者一覧フラグ, 認定調査依頼先変更者一覧表フラグ, 認定調査結果と主治医意見書のチェックリストフラグ);
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査予定未定者一覧パネルイベント処理です。
     *
     * @param div HakkoJokenDiv
     * @return ResponseData<HakkoJokenDiv>
     */
    public ResponseData<HakkoJokenDiv> onClick_ChkYoteiMiteisha(HakkoJokenDiv div) {
        if (div.getChkNinteiChosaYoteiMiteishaIchiran().getSelectedKeys().contains(SELECT_KEY0)) {
            div.getNinteiChosaYoteiMiteishaIchiranJoken().getRadJoken1().setDisabled(false);
            onClick_ChkRadJoken1(div);
        } else {
            div.getNinteiChosaYoteiMiteishaIchiranJoken().getRadJoken1().setDisabled(true);
            div.getNinteiChosaYoteiMiteishaIchiranJoken().getTxtYoteiMiteishaShinseiYMD().clearFromValue();
            div.getNinteiChosaYoteiMiteishaIchiranJoken().getTxtYoteiMiteishaShinseiYMD().clearToValue();
            div.getNinteiChosaYoteiMiteishaIchiranJoken().getTxtYoteiMiteishaShinseiYMD().setDisabled(true);
            div.getNinteiChosaYoteiMiteishaIchiranJoken().setIsOpen(false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査依頼先変更者一覧表パネルイベント処理です。
     *
     * @param div 画面情報
     * @return ResponseData<HakkoJokenDiv>
     */
    public ResponseData<HakkoJokenDiv> onClick_ChkIraisakiHenkosha(HakkoJokenDiv div) {
        if (div.getChkNinteiChosaIraisakiHenkoshaIchiranhyoJoken().getSelectedKeys().contains(SELECT_KEY0)) {
            div.getNinteiChosaIraisakiHenkoshaIchiranhyoJoken().getTxtIraisakiHenkoshaIchiranShinseiYMD().setDisabled(false);
        } else {
            div.getNinteiChosaIraisakiHenkoshaIchiranhyoJoken().getTxtIraisakiHenkoshaIchiranShinseiYMD().clearFromValue();
            div.getNinteiChosaIraisakiHenkoshaIchiranhyoJoken().getTxtIraisakiHenkoshaIchiranShinseiYMD().clearToValue();
            div.getNinteiChosaIraisakiHenkoshaIchiranhyoJoken().getTxtIraisakiHenkoshaIchiranShinseiYMD().setDisabled(true);
            div.getNinteiChosaIraisakiHenkoshaIchiranhyoJoken().setIsOpen(false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査結果と主治医意見書のチェックリストパネルイベント処理です。
     *
     * @param div 画面情報
     * @return ResponseData<HakkoJokenDiv>
     */
    public ResponseData<HakkoJokenDiv> onClick_ChkKekkaShujiiIkensho(HakkoJokenDiv div) {
        if (div.getChkNinteiChosaKekkaShujiiIkenshoCheckListJoken().getSelectedKeys().contains(SELECT_KEY0)) {
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getRadJoken3().setDisabled(false);
            onClick_ChkRadJoken3(div);
        } else {
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getRadJoken3().setDisabled(true);
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtCheckListShinseiYMD().clearFromValue();
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtCheckListShinseiYMD().clearToValue();
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtShinsaYMD().clearValue();
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtShinsakai().clearValue();
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtCheckListShinseiYMD().setDisabled(true);
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtShinsaYMD().setDisabled(true);
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtShinsakai().setDisabled(true);
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().setIsOpen(false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査予定未定者一覧パネルのラジオボタンイベント処理です。
     *
     * @param div 画面情報
     * @return ResponseData<HakkoJokenDiv>
     */
    public ResponseData<HakkoJokenDiv> onClick_ChkRadJoken1(HakkoJokenDiv div) {
        if (div.getRadJoken1().getSelectedKey().contains(SELECT_KEY0)) {
            div.getNinteiChosaYoteiMiteishaIchiranJoken().getTxtYoteiMiteishaShinseiYMD().clearFromValue();
            div.getNinteiChosaYoteiMiteishaIchiranJoken().getTxtYoteiMiteishaShinseiYMD().clearToValue();
            div.getNinteiChosaYoteiMiteishaIchiranJoken().getTxtYoteiMiteishaShinseiYMD().setDisabled(true);
        } else {
            div.getNinteiChosaYoteiMiteishaIchiranJoken().getTxtYoteiMiteishaShinseiYMD().setDisabled(false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査結果と主治医意見書のチェックリストパネルのラジオボタンイベント処理です。
     *
     * @param div 画面情報
     * @return ResponseData<HakkoJokenDiv>
     */
    public ResponseData<HakkoJokenDiv> onClick_ChkRadJoken3(HakkoJokenDiv div) {
        if (div.getRadJoken3().getSelectedKey().contains(SELECT_KEY0)) {
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtCheckListShinseiYMD().clearFromValue();
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtCheckListShinseiYMD().clearToValue();
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtShinsaYMD().clearValue();
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtShinsakai().clearValue();
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtCheckListShinseiYMD().setDisabled(true);
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtShinsaYMD().setDisabled(true);
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtShinsakai().setDisabled(true);
        } else if (div.getRadJoken3().getSelectedKey().contains(SELECT_KEY1)) {
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtCheckListShinseiYMD().setDisabled(false);
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtShinsaYMD().clearValue();
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtShinsakai().clearValue();
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtShinsaYMD().setDisabled(true);
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtShinsakai().setDisabled(true);
        } else if (div.getRadJoken3().getSelectedKey().contains(SELECT_KEY2)) {
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtShinsaYMD().setDisabled(false);
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtCheckListShinseiYMD().clearFromValue();
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtCheckListShinseiYMD().clearToValue();
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtShinsakai().clearValue();
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtCheckListShinseiYMD().setDisabled(true);
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtShinsakai().setDisabled(true);
        } else {
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtShinsakai().setDisabled(false);
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtCheckListShinseiYMD().clearFromValue();
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtCheckListShinseiYMD().clearToValue();
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtShinsaYMD().clearValue();
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtCheckListShinseiYMD().setDisabled(true);
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtShinsaYMD().setDisabled(true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 実行ボタン処理です。
     *
     * @param div 画面情報
     * @return ResponseData<HakkoJokenDiv>
     */
    public ResponseData<DBE012001_ChosaInfoPrintParameter> onClick_Jikkou(HakkoJokenDiv div) {
        FlowParameters fp = FlowParameters.of(KEY, VALUE_BATCH);
        FlowParameterAccessor.merge(fp);
        return ResponseData.of(getHandler(div).setBatchParameter()).respond();
    }

    /**
     * 入力チェックです。
     *
     * @param div 画面情報
     * @return ResponseData<HakkoJokenDiv>
     */
    public ResponseData<HakkoJokenDiv> onClick_Check(HakkoJokenDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        ValidationMessageControlPairs validPairs = getValidationHandler(div).未選択チェック(validationMessages);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        validPairs = getValidationHandler(div).未入力チェック(validationMessages);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        validPairs = getValidationHandler(div).申請日入力チェック1(validationMessages);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        validPairs = getValidationHandler(div).申請日入力チェック2(validationMessages);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        validPairs = getValidationHandler(div).申請日入力チェック3(validationMessages);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    private HakkoJokenValidationHandler getValidationHandler(HakkoJokenDiv div) {
        return new HakkoJokenValidationHandler(div);
    }

    private HakkoJokenHandler getHandler(HakkoJokenDiv div) {
        return new HakkoJokenHandler(div);
    }
}
