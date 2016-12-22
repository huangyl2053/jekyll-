/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2400001;

import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2400001.IraishoIkkatsuHakkoDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 依頼書一括発行の抽象ValidationHandlerクラスです。
 *
 * @reamsid_L DBE-0080-010 duanzhanli
 */
public class IraishoIkkatsuHakkoValidationHandler {

    private static final RString STATE_NINTEIO = new RString("1");
    private static final RString STATE_SHUJII = new RString("2");
    private static final RString KEY_2 = new RString("key2");

    private final IraishoIkkatsuHakkoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 依頼書一括発行Div
     */
    public IraishoIkkatsuHakkoValidationHandler(IraishoIkkatsuHakkoDiv div) {
        this.div = div;
    }

    /**
     *
     * 依頼日の前後順をチェックします。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs iraibiZengoJunCheck() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (STATE_NINTEIO.equals(div.getState())) {
            if (div.getTxtIraibiFrom().getValue() == null || div.getTxtIraibiTo().getValue() == null) {
                return validationMessages;
            }
            if (!div.getTxtIraibiFrom().getValue().isBeforeOrEquals(div.getTxtIraibiTo().getValue())) {
                validationMessages.add(new ValidationMessageControlPair(
                        new IraishoIkkatsuHakkoMessages(DbeErrorMessages.終了日が開始日以前), div.getTxtIraibiFrom()));
            }
        }
        if (STATE_SHUJII.equals(div.getState())) {
            if (div.getTxtShujiiIkenshoSakuseiIraibiFrom().getValue() == null
                    || div.getTxtShujiiIkenshoSakuseiIraibiTo().getValue() == null) {
                return validationMessages;
            }
            if (!div.getTxtShujiiIkenshoSakuseiIraibiFrom().getValue().isBeforeOrEquals(
                    div.getTxtShujiiIkenshoSakuseiIraibiTo().getValue())) {
                validationMessages.add(new ValidationMessageControlPair(
                        new IraishoIkkatsuHakkoMessages(DbeErrorMessages.終了日が開始日以前), div.getTxtIraibiFrom()));
            }
        }

        return validationMessages;
    }

    /**
     *
     * 依頼一覧をチェックします。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs iraiItiranCheck() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (STATE_NINTEIO.equals(div.getState())
                && div.getDgNinteiChosaIraiTaishoIchiran().getSelectedItems().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(
                    new IraishoIkkatsuHakkoMessages(UrErrorMessages.対象行を選択),
                    div.getDgNinteiChosaIraiTaishoIchiran()));
        }
        if (STATE_SHUJII.equals(div.getState())
                && div.getDgShujiiIkenshoSakuseiIraiTaishoIchiran().getSelectedItems().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(
                    new IraishoIkkatsuHakkoMessages(UrErrorMessages.対象行を選択),
                    div.getDgShujiiIkenshoSakuseiIraiTaishoIchiran()));
        }

        return validationMessages;
    }

    /**
     *
     * 印刷帳票選択チェックボックスをチェックします。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs printChouhyouSentakuCheck() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (STATE_NINTEIO.equals(div.getState()) && isNinteiNoSelected()) {
            validationMessages.add(new ValidationMessageControlPair(
                    new IraishoIkkatsuHakkoMessages(UrErrorMessages.出力項目を指定), div.getNinteiChosaInsatsuChohyoSentaku()));
        }
        if (STATE_SHUJII.equals(div.getState()) && isShujiiNoSelected()) {
            validationMessages.add(new ValidationMessageControlPair(
                    new IraishoIkkatsuHakkoMessages(UrErrorMessages.出力項目を指定), div.getShujiiIkenshoInsatsuChohyo()));
        }

        return validationMessages;
    }

    private boolean isNinteiNoSelected() {
        return is適用なし(div.getChkNinteiChosaIraiIchiran())
                && is適用なし(div.getChkChosaIrai())
                && is適用なし(div.getChkNinteiChosahyoSonota())
                && is適用なし(div.getChkChosaDesign())
                && is適用なし(div.getChkTokkiDesign())
                && is適用なし(div.getChkChosaOcr())
                && is適用なし(div.getChkTokkiOcr())
                && is適用なし(div.getChkSaiCheck())
                && is適用なし(div.getChkGaikyoTokki())
                && is適用なし(div.getChkTokkiKomokuAri())
                && is適用なし(div.getChkTokkiKomokuNashi())
                && is適用なし(div.getChkTokkiFree())
                && is適用なし(div.getChkTokkijikoTenyuryoku())
                && is適用なし(div.getChkchosairaihakko())
                && is適用なし(div.getChkchosairaiRireki());

    }

    private boolean is適用なし(CheckBoxList chk) {
        return !(!chk.getSelectedKeys().isEmpty() && !chk.isDisplayNone());
    }

    private boolean isShujiiNoSelected() {
        return is適用なし(div.getChkShujiiIkenshoSakuseiIrai())
                && is適用なし(div.getChkShujiiIkenshoSakuseiSeikyu())
                && is適用なし(div.getChkShujiiIkenshoSakuseiIraisho())
                && is適用なし(div.getChkShujiIkenshoyoshi())
                && is適用なし(div.getChkShujiiIkenshoyoshiOcr())
                && is適用なし(div.getChkShujiiIkenshoyoshiDesign())
                && is適用なし(div.getChkShujiiIkenshoSakuseiryoSeikyusho())
                && is適用なし(div.getChkShindanMeireishoAndTeishutsuIraisho())
                && is適用なし(div.getChkikenshiiraihakko())
                && is適用なし(div.getChkikenshiiraiRireki());
    }

    /**
     *
     * 共通日付テキストボックスをチェックします。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs commonDateCheck() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (KEY_2.equals(div.getRadTeishutsuKigen().getSelectedKey())
                && div.getTxtKyotsuHizuke().getValue() == null) {
            validationMessages.add(new ValidationMessageControlPair(
                    new IraishoIkkatsuHakkoMessages(UrErrorMessages.必須項目_追加メッセージあり, "共通日付"),
                    div.getTxtKyotsuHizuke()));
        }

        return validationMessages;
    }

    private static class IraishoIkkatsuHakkoMessages implements IValidationMessage {

        private final Message message;

        public IraishoIkkatsuHakkoMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

}
