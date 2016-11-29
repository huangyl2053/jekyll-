/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE0110004;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE013001.DBE013001_IkenshoInfoPrintParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0110004.HakkoJokenSyujiiIkensyoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0110004.HakkoJokenSyujiiIkensyoHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0110004.HakkoJokenSyujiiIkensyoValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameterAccessor;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameters;

/**
 * 画面設計_DBE0110004_主治医意見書に関する帳票発行画面クラスです
 *
 * @reamsid_L DBE-1390-070 xuyongchao
 */
public class HakkoJokenSyujiiIkensyo {

    private static final RString SELECT_KEY0 = new RString("key0");
    private static final RString KEY = new RString("key");
    private static final RString VALUE_BATCH = new RString("Batch3");

    /**
     * 画面初期化処理です。
     *
     * @param div 画面情報
     * @return ResponseData<HakkoJokenSyujiiIkensyoDiv>
     */
    public ResponseData<HakkoJokenSyujiiIkensyoDiv> onLoad(HakkoJokenSyujiiIkensyoDiv div) {
        boolean 主治医意見書未提出者一覧フラグ = ViewStateHolder.get(ViewStateKeys.主治医意見書未提出者一覧フラグ,
                Boolean.class);
        boolean 主治医意見書５項目確認一覧表フラグ = ViewStateHolder.get(ViewStateKeys.主治医意見書５項目確認一覧表フラグ,
                Boolean.class);
        boolean 主治医意見書依頼未処理者一覧表フラグ = ViewStateHolder.get(ViewStateKeys.主治医意見書依頼未処理者一覧表フラグ,
                Boolean.class);
        boolean 主治医意見書作成依頼変更者一覧表フラグ = ViewStateHolder.get(ViewStateKeys.主治医意見書作成依頼変更者一覧表フラグ,
                Boolean.class);
        boolean 主治医意見書依頼済み一覧表フラグ = ViewStateHolder.get(ViewStateKeys.主治医意見書依頼済み一覧表フラグ,
                Boolean.class);
        boolean 主治医意見書作成料請求一覧表フラグ = ViewStateHolder.get(ViewStateKeys.主治医意見書作成料請求一覧表フラグ,
                Boolean.class);
        getHandler(div).onLoad(主治医意見書未提出者一覧フラグ, 主治医意見書５項目確認一覧表フラグ, 主治医意見書依頼未処理者一覧表フラグ,
                主治医意見書作成依頼変更者一覧表フラグ, 主治医意見書依頼済み一覧表フラグ, 主治医意見書作成料請求一覧表フラグ);
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医意見書未提出者一覧条件パネルの処理です。
     *
     * @param div 画面情報
     * @return ResponseData<HakkoJokenSyujiiIkensyoDiv>
     */
    public ResponseData<HakkoJokenSyujiiIkensyoDiv> onClick_chkMiteishutsushaIchiran(HakkoJokenSyujiiIkensyoDiv div) {
        if (div.getChkMiteishutsushaIchiran().getSelectedKeys().contains(SELECT_KEY0)) {
            div.getRadJoken1().setDisabled(false);
            if (div.getRadJoken1().getSelectedKey().contains(SELECT_KEY0)) {
                div.getTxtIraiNisu().setDisabled(false);
                div.getTxtShinseiYMD1().clearFromValue();
                div.getTxtShinseiYMD1().clearToValue();
                div.getTxtShinseiYMD1().setDisabled(true);
            } else {
                div.getTxtIraiNisu().clearValue();
                div.getTxtIraiNisu().setDisabled(true);
                div.getTxtShinseiYMD1().setDisabled(false);
            }
        } else {
            div.getRadJoken1().setDisabled(true);
            div.getTxtIraiNisu().clearValue();
            div.getTxtIraiNisu().setDisabled(true);
            div.getTxtShinseiYMD1().clearFromValue();
            div.getTxtShinseiYMD1().clearToValue();
            div.getTxtShinseiYMD1().setDisabled(true);
            div.getMiteishutsushaIchiranJoken().setIsOpen(false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医意見書未提出者一覧条件ラジオボタンの処理です。
     *
     * @param div 画面情報
     * @return ResponseData<HakkoJokenSyujiiIkensyoDiv>
     */
    public ResponseData<HakkoJokenSyujiiIkensyoDiv> onClick_radJoken1(HakkoJokenSyujiiIkensyoDiv div) {
        if (div.getRadJoken1().getSelectedKey().contains(SELECT_KEY0)) {
            div.getTxtIraiNisu().setDisabled(false);
            div.getTxtShinseiYMD1().clearFromValue();
            div.getTxtShinseiYMD1().clearToValue();
            div.getTxtShinseiYMD1().setDisabled(true);
        } else {
            div.getTxtIraiNisu().clearValue();
            div.getTxtIraiNisu().setDisabled(true);
            div.getTxtShinseiYMD1().setDisabled(false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医意見書５項目確認一覧表条件パネルの処理です。
     *
     * @param div 画面情報
     * @return ResponseData<HakkoJokenSyujiiIkensyoDiv>
     */
    public ResponseData<HakkoJokenSyujiiIkensyoDiv> onClick_KakuninIchiranhyoJoken(HakkoJokenSyujiiIkensyoDiv div) {
        if (div.getChkKakuninIchiranhyo().getSelectedKeys().contains(SELECT_KEY0)) {
            div.getRadJoken2().setDisabled(false);
            if (div.getRadJoken2().getSelectedKey().contains(SELECT_KEY0)) {
                div.getTxtShinsakai2().clearValue();
                div.getTxtShinsakai2().setDisabled(true);
            } else {
                div.getTxtShinsakai2().setDisabled(false);
            }
        } else {
            div.getRadJoken2().setDisabled(true);
            div.getTxtShinsakai2().clearValue();
            div.getTxtShinsakai2().setDisabled(true);
            div.getKakuninIchiranhyoJoken().setIsOpen(false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医意見書５項目確認一覧表条件ラジオボタンの処理です。
     *
     * @param div 画面情報
     * @return ResponseData<HakkoJokenSyujiiIkensyoDiv>
     */
    public ResponseData<HakkoJokenSyujiiIkensyoDiv> onClick_radJoken2(HakkoJokenSyujiiIkensyoDiv div) {
        if (div.getRadJoken2().getSelectedKey().contains(SELECT_KEY0)) {
            div.getTxtShinsakai2().clearValue();
            div.getTxtShinsakai2().setDisabled(true);
        } else {
            div.getTxtShinsakai2().setDisabled(false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医意見書依頼未処理者一覧表条件パネルの処理です。
     *
     * @param div 画面情報
     * @return ResponseData<HakkoJokenSyujiiIkensyoDiv>
     */
    public ResponseData<HakkoJokenSyujiiIkensyoDiv> onClick_chkIraiMishorishaIchiranhyo(HakkoJokenSyujiiIkensyoDiv div) {
        if (div.getChkIraiMishorishaIchiranhyo().getSelectedKeys().contains(SELECT_KEY0)) {
            div.getRadJoken3().setDisabled(false);
            if (div.getRadJoken3().getSelectedKey().contains(SELECT_KEY0)) {
                div.getTxtShinsaYMD3().clearFromValue();
                div.getTxtShinsaYMD3().clearToValue();
                div.getTxtShinsaYMD3().setDisabled(true);
            }
        } else {
            div.getRadJoken3().setDisabled(true);
            div.getTxtShinsaYMD3().clearFromValue();
            div.getTxtShinsaYMD3().clearToValue();
            div.getTxtShinsaYMD3().setDisabled(true);
            div.getIraiMishorishaIchiranhyoJoken().setIsOpen(false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医意見書依頼未処理者一覧表条件ラジオボタンの処理です。
     *
     * @param div 画面情報
     * @return ResponseData<HakkoJokenSyujiiIkensyoDiv>
     */
    public ResponseData<HakkoJokenSyujiiIkensyoDiv> onClick_radJoken3(HakkoJokenSyujiiIkensyoDiv div) {
        if (div.getRadJoken3().getSelectedKey().contains(SELECT_KEY0)) {
            div.getTxtShinsaYMD3().clearFromValue();
            div.getTxtShinsaYMD3().clearToValue();
            div.getTxtShinsaYMD3().setDisabled(true);
        } else {
            div.getTxtShinsaYMD3().setDisabled(false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医意見書作成依頼変更者一覧表条件パネルの処理です。
     *
     * @param div 画面情報
     * @return ResponseData<HakkoJokenSyujiiIkensyoDiv>
     */
    public ResponseData<HakkoJokenSyujiiIkensyoDiv> onClick_chkSakuseiIraiHenkoushaIchiranhyoJoken(HakkoJokenSyujiiIkensyoDiv div) {
        if (div.getChkSakuseiIraiHenkoushaIchiranhyoJoken().getSelectedKeys().contains(SELECT_KEY0)) {
            div.getTxtShinseiYMD4().setDisabled(false);
        } else {
            div.getTxtShinseiYMD4().clearFromValue();
            div.getTxtShinseiYMD4().clearToValue();
            div.getTxtShinseiYMD4().setDisabled(true);
            div.getSakuseiIraiHenkoushaIchiranhyoJoken().setIsOpen(false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医意見書依頼済み一覧表条件パネルの処理です。
     *
     * @param div 画面情報
     * @return ResponseData<HakkoJokenSyujiiIkensyoDiv>
     */
    public ResponseData<HakkoJokenSyujiiIkensyoDiv> onClick_chkIraiZumiIchiranhyoJoken(HakkoJokenSyujiiIkensyoDiv div) {
        if (div.getChkIraiZumiIchiranhyoJoken().getSelectedKeys().contains(SELECT_KEY0)) {
            div.getRadJoken5().setDisabled(false);
            if (div.getRadJoken5().getSelectedKey().contains(SELECT_KEY0)) {
                div.getTxtShoriYMD5().setDisabled(false);
                div.getTxtShinseiYMD5().clearFromValue();
                div.getTxtShinseiYMD5().clearToValue();
                div.getTxtShinseiYMD5().setDisabled(true);
            } else {
                div.getTxtShinseiYMD5().setDisabled(false);
                div.getTxtShoriYMD5().clearFromValue();
                div.getTxtShoriYMD5().clearToValue();
                div.getTxtShoriYMD5().setDisabled(true);
            }
        } else {
            div.getRadJoken5().setDisabled(true);
            div.getTxtShoriYMD5().clearFromValue();
            div.getTxtShoriYMD5().clearToValue();
            div.getTxtShoriYMD5().setDisabled(true);
            div.getTxtShinseiYMD5().clearFromValue();
            div.getTxtShinseiYMD5().clearToValue();
            div.getTxtShinseiYMD5().setDisabled(true);
            div.getIraiZumiIchiranhyoJoken().setIsOpen(false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医意見書依頼済み一覧表条件ラジオボタンの処理です。
     *
     * @param div 画面情報
     * @return ResponseData<HakkoJokenSyujiiIkensyoDiv>
     */
    public ResponseData<HakkoJokenSyujiiIkensyoDiv> onClick_radJoken5(HakkoJokenSyujiiIkensyoDiv div) {
        if (div.getRadJoken5().getSelectedKey().contains(SELECT_KEY0)) {
            div.getTxtShoriYMD5().setDisabled(false);
            div.getTxtShinseiYMD5().clearFromValue();
            div.getTxtShinseiYMD5().clearToValue();
            div.getTxtShinseiYMD5().setDisabled(true);
        } else {
            div.getTxtShinseiYMD5().setDisabled(false);
            div.getTxtShoriYMD5().clearFromValue();
            div.getTxtShoriYMD5().clearToValue();
            div.getTxtShoriYMD5().setDisabled(true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医意見書作成料請求一覧表条件パネルの処理です。
     *
     * @param div 画面情報
     * @return ResponseData<HakkoJokenSyujiiIkensyoDiv>
     */
    public ResponseData<HakkoJokenSyujiiIkensyoDiv> onClick_chkSakuseiryoSeikyuIchiranhyo(HakkoJokenSyujiiIkensyoDiv div) {
        if (div.getChkSakuseiryoSeikyuIchiranhyo().getSelectedKeys().contains(SELECT_KEY0)) {
            div.getRadSeikyuIchiranJoken().setDisabled(false);
            if (div.getRadSeikyuIchiranJoken().getSelectedKey().contains(SELECT_KEY0)) {
                div.getTxtSeikyuIchiranShoriYMD().setDisabled(false);
                div.getTxtJuryoYMD().clearFromValue();
                div.getTxtJuryoYMD().clearToValue();
                div.getTxtJuryoYMD().setDisabled(true);
            } else {
                div.getTxtJuryoYMD().setDisabled(false);
                div.getTxtSeikyuIchiranShoriYMD().clearFromValue();
                div.getTxtSeikyuIchiranShoriYMD().clearToValue();
                div.getTxtSeikyuIchiranShoriYMD().setDisabled(true);
            }
        } else {
            div.getRadSeikyuIchiranJoken().setDisabled(true);
            div.getTxtSeikyuIchiranShoriYMD().clearFromValue();
            div.getTxtSeikyuIchiranShoriYMD().clearToValue();
            div.getTxtSeikyuIchiranShoriYMD().setDisabled(true);
            div.getTxtJuryoYMD().clearFromValue();
            div.getTxtJuryoYMD().clearToValue();
            div.getTxtJuryoYMD().setDisabled(true);
            div.getSakuseiryoSeikyuIchiranhyoJoken().setIsOpen(false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医意見書作成料請求一覧表条件ラジオボタンの処理です。
     *
     * @param div 画面情報
     * @return ResponseData<HakkoJokenSyujiiIkensyoDiv>
     */
    public ResponseData<HakkoJokenSyujiiIkensyoDiv> onClick_radSeikyuIchiranJoken(HakkoJokenSyujiiIkensyoDiv div) {
        if (div.getRadSeikyuIchiranJoken().getSelectedKey().contains(SELECT_KEY0)) {
            div.getTxtSeikyuIchiranShoriYMD().setDisabled(false);
            div.getTxtJuryoYMD().clearFromValue();
            div.getTxtJuryoYMD().clearToValue();
            div.getTxtJuryoYMD().setDisabled(true);
        } else {
            div.getTxtJuryoYMD().setDisabled(false);
            div.getTxtSeikyuIchiranShoriYMD().clearFromValue();
            div.getTxtSeikyuIchiranShoriYMD().clearToValue();
            div.getTxtSeikyuIchiranShoriYMD().setDisabled(true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 実行ボタン処理です。
     *
     * @param div 画面情報
     * @return ResponseData<HakkoJokenSyujiiIkensyoDiv>
     */
    public ResponseData<DBE013001_IkenshoInfoPrintParameter> onClick_Jikkou(HakkoJokenSyujiiIkensyoDiv div) {
        FlowParameters fp = FlowParameters.of(KEY, VALUE_BATCH);
        FlowParameterAccessor.merge(fp);
        return ResponseData.of(getHandler(div).setBatchParameter()).respond();
    }

    /**
     * 入力チェックです。
     *
     * @param div 画面情報
     * @return ResponseData<HakkoJokenSyujiiIkensyoDiv>
     */
    public ResponseData<HakkoJokenSyujiiIkensyoDiv> onClick_Check(HakkoJokenSyujiiIkensyoDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        ValidationMessageControlPairs validPairs = getValidationHandler(div).未選択チェック(validationMessages);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        validPairs = getValidationHandler(div).未入力チェック(validationMessages);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        validPairs = getValidationHandler(div).処理日範囲不正チェック1(validationMessages);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        validPairs = getValidationHandler(div).処理日範囲不正チェック2(validationMessages);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        validPairs = getValidationHandler(div).受領日範囲不正チェック(validationMessages);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        validPairs = getValidationHandler(div).申請日範囲不正チェック1(validationMessages);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        validPairs = getValidationHandler(div).申請日範囲不正チェック2(validationMessages);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        validPairs = getValidationHandler(div).申請日範囲不正チェック3(validationMessages);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        validPairs = getValidationHandler(div).申請日範囲不正チェック4(validationMessages);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    private HakkoJokenSyujiiIkensyoValidationHandler getValidationHandler(HakkoJokenSyujiiIkensyoDiv div) {
        return new HakkoJokenSyujiiIkensyoValidationHandler(div);
    }

    private HakkoJokenSyujiiIkensyoHandler getHandler(HakkoJokenSyujiiIkensyoDiv div) {
        return new HakkoJokenSyujiiIkensyoHandler(div);
    }
}
