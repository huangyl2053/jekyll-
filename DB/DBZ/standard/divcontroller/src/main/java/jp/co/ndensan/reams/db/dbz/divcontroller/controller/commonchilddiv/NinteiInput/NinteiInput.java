/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.NinteiInput;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiInput.NinteiInput.NinteiInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.ninteiinput.NinteiInputValidationHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
        div.getTxtYokaigodoCode().setValue(div.getHdnKoroshoIfShikibetsuCode());
        if (div.getTxtNinteiYMD().getValue() == null) {
            div.setHdnNinteiYmd(RString.EMPTY);
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
        div.getTxtYukoShuryoYMD().setValue(div.getTxtYukoKaishiYMD().getValue().plusMonth(MONTHPLUS6));
        return ResponseData.of(div).respond();
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
        div.getTxtYukoShuryoYMD().setValue(div.getTxtYukoKaishiYMD().getValue().plusMonth(MONTHPLUS12));
        return ResponseData.of(div).respond();
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
        div.getTxtYukoShuryoYMD().setValue(div.getTxtYukoKaishiYMD().getValue().plusMonth(MONTHPLUS18));
        return ResponseData.of(div).respond();
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
        div.getTxtYukoShuryoYMD().setValue(div.getTxtYukoKaishiYMD().getValue().plusMonth(MONTHPLUS24));
        return ResponseData.of(div).respond();
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

    private NinteiInputValidationHandler getValidationHandler(NinteiInputDiv div) {
        return new NinteiInputValidationHandler(div);
    }
}
