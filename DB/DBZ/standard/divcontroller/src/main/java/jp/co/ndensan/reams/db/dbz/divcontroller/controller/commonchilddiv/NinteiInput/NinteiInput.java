/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.NinteiInput;

import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiInput.NinteiInput.NinteiInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.ninteiinput.NinteiInputValidationHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * DBZ.NinteiInput_認定情報のdivControlerです。
 *
 * @reamsid_L DBZ-1300-080 yaodongsheng
 */
public class NinteiInput {

    private static final int MONTHPLUS6 = 6;
    private static final int MONTHPLUS12 = 12;
    private static final int MONTHPLUS18 = 18;
    private static final int MONTHPLUS24 = 24;
    private static final int INT1 = 1;

    /**
     * 認定区分radがonChangeです。
     *
     * @param div NinteiInputDiv
     * @return NinteiInputDivのResponseData
     */
    public ResponseData<NinteiInputDiv> onChange_radNinteiKubun(NinteiInputDiv div) {
        if (!new RString("NinteiMode").equals(new RString(div.getMode_ShoriType().toString()))) {
            return ResponseData.of(div).respond();
        }
        if (div.getNinteiJoho().getRadNinteiKubun().getSelectedValue().equals(new RString("認定"))) {
            div.getTxtNinteiYMD().setReadOnly(false);
            div.getTxtYokaigodoCode().setReadOnly(false);
            div.getTxtYukoKaishiYMD().setReadOnly(false);
            div.getTxtYukoShuryoYMD().setReadOnly(false);
            div.getTxtShinsakaiIken().setReadOnly(false);
        } else if (div.getNinteiJoho().getRadNinteiKubun().getSelectedValue().equals(new RString("却下"))) {
            div.getTxtNinteiYMD().setReadOnly(false);
            div.getTxtYokaigodoCode().setReadOnly(true);
            div.getTxtYukoKaishiYMD().setReadOnly(true);
            div.getTxtYukoShuryoYMD().setReadOnly(true);
            div.getTxtShinsakaiIken().setReadOnly(true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 要介護度ガイドボタンを押下しです。
     *
     * @param div JyutakugaisyunaiyoListDiv
     * @return JyutakugaisyunaiyoListDivのResponseData
     */
    public ResponseData<NinteiInputDiv> onClick_btnYokaigodoGuide(NinteiInputDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).認定年月日check();
        if (validPairs.iterator().hasNext()) {
            div.setHdnNinteiYmd(new RString(FlexibleDate.getNowDate().toString()));
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }

        if (div.getTxtNinteiYMD().getValue() == null || RString.isNullOrEmpty(new RString(div.getTxtNinteiYMD().getValue().toString()))) {
            div.setHdnNinteiYmd(new RString(FlexibleDate.getNowDate().toString()));
        } else {
            div.setHdnNinteiYmd(new RString(div.getTxtNinteiYMD().getValue().toString()));
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 6ヶ月ボタンを押下しです。
     *
     * @param div JyutakugaisyunaiyoListDiv
     * @return JyutakugaisyunaiyoListDivのResponseData
     */
    public ResponseData<NinteiInputDiv> onClick_btnAfter6Month(NinteiInputDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).有効開始日check();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        RDate date = div.getTxtYukoKaishiYMD().getValue().plusMonth(MONTHPLUS6);
        if (date.isAfter(date.getFirstDateOfTheMonth())) {
            div.getTxtYukoShuryoYMD().setValue(get当月末日(date.getYearMonth()));
            return ResponseData.of(div).respond();
        } else {
            div.getTxtYukoShuryoYMD().setValue(get当月末日(date.minusMonth(INT1).getYearMonth()));
            return ResponseData.of(div).respond();
        }
    }

    /**
     * 12ヶ月ボタンを押下しです。
     *
     * @param div JyutakugaisyunaiyoListDiv
     * @return JyutakugaisyunaiyoListDivのResponseData
     */
    public ResponseData<NinteiInputDiv> onClick_btnAfter12Month(NinteiInputDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).有効開始日check();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        RDate date = div.getTxtYukoKaishiYMD().getValue().plusMonth(MONTHPLUS12);
        if (date.isAfter(date.getFirstDateOfTheMonth())) {
            div.getTxtYukoShuryoYMD().setValue(get当月末日(date.getYearMonth()));
            return ResponseData.of(div).respond();
        } else {
            div.getTxtYukoShuryoYMD().setValue(get当月末日(date.minusMonth(INT1).getYearMonth()));
            return ResponseData.of(div).respond();
        }
    }

    /**
     * 18ヶ月ボタンを押下しです。
     *
     * @param div JyutakugaisyunaiyoListDiv
     * @return JyutakugaisyunaiyoListDivのResponseData
     */
    public ResponseData<NinteiInputDiv> onClick_btnAfter18Month(NinteiInputDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).有効開始日check();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        RDate date = div.getTxtYukoKaishiYMD().getValue().plusMonth(MONTHPLUS18);
        if (date.isAfter(date.getFirstDateOfTheMonth())) {
            div.getTxtYukoShuryoYMD().setValue(get当月末日(date.getYearMonth()));
            return ResponseData.of(div).respond();
        } else {
            div.getTxtYukoShuryoYMD().setValue(get当月末日(date.minusMonth(INT1).getYearMonth()));
            return ResponseData.of(div).respond();
        }
    }

    /**
     * 24ヶ月ボタンを押下しです。
     *
     * @param div JyutakugaisyunaiyoListDiv
     * @return JyutakugaisyunaiyoListDivのResponseData
     */
    public ResponseData<NinteiInputDiv> onClick_btnAfter24Month(NinteiInputDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).有効開始日check();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        RDate date = div.getTxtYukoKaishiYMD().getValue().plusMonth(MONTHPLUS24);
        if (date.isAfter(date.getFirstDateOfTheMonth())) {
            div.getTxtYukoShuryoYMD().setValue(get当月末日(date.getYearMonth()));
            return ResponseData.of(div).respond();
        } else {
            div.getTxtYukoShuryoYMD().setValue(get当月末日(date.minusMonth(INT1).getYearMonth()));
            return ResponseData.of(div).respond();
        }
    }

    private RDate get当月末日(RYearMonth 基準年月) {
        return new RDate(基準年月.getYearValue(), 基準年月.getMonthValue(), INT1).plusMonth(INT1).minusDay(INT1);
    }

    /**
     * 開始日がlostFocusです。
     *
     * @param div NinteiInputDiv
     * @return NinteiInputDiv
     */
    public ResponseData<NinteiInputDiv> onClick_kaishiLostFocus(NinteiInputDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).開始日check();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 終了日がlostFocusです。
     *
     * @param div NinteiInputDiv
     * @return NinteiInputDiv
     */
    public ResponseData<NinteiInputDiv> onClick_syuryoLostFocus(NinteiInputDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).終了日check();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }
    /**
     * 要介護度がlostFocusです。
     *
     * @param div NinteiInputDiv
     * @return NinteiInputDiv
     */
    public ResponseData<NinteiInputDiv> onBlur_yokaigodo(NinteiInputDiv div) {
        if (RString.isNullOrEmpty(div.getHdnNinteiYmd()) || !(new FlexibleDate(div.getHdnNinteiYmd()).isValid())) {
            div.setHdnNinteiYmd(new RString(FlexibleDate.getNowDate().toString()));
        }
        FlexibleYearMonth kijunbi = new FlexibleDate(div.getHdnNinteiYmd()).getYearMonth();
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        try {
            if (new FlexibleYearMonth("200004").isBefore(kijunbi)
                    && kijunbi.isBefore(new FlexibleYearMonth("200203"))) {
                div.getTxtYokaigodoName().setValue(YokaigoJotaiKubun99.toValue(div.getTxtYokaigodoCode().getValue()).get名称());
            }
            if (new FlexibleYearMonth("200204").isBefore(kijunbi)
                    && kijunbi.isBefore(new FlexibleYearMonth("200603"))) {
                div.getTxtYokaigodoName().setValue(YokaigoJotaiKubun02.toValue(div.getTxtYokaigodoCode().getValue()).get名称());
            }
            if (new FlexibleYearMonth("200604").isBefore(kijunbi)
                    && kijunbi.isBefore(new FlexibleYearMonth("200903"))) {
                div.getTxtYokaigodoName().setValue(YokaigoJotaiKubun06.toValue(div.getTxtYokaigodoCode().getValue()).get名称());
            }
            if (new FlexibleYearMonth("200904").isBefore(kijunbi)) {
                div.getTxtYokaigodoName().setValue(YokaigoJotaiKubun09.toValue(div.getTxtYokaigodoCode().getValue()).get名称());
            }
        } catch (IllegalArgumentException e) {
            validPairs = getValidationHandler(div).要介護状態区分コード変換不可();
        }
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    private NinteiInputValidationHandler getValidationHandler(NinteiInputDiv div) {
        return new NinteiInputValidationHandler(div);
    }
}
