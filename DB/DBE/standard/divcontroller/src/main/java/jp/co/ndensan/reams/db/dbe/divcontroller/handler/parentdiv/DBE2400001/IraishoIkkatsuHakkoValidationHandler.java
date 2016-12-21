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
    private static final RString KEY_1 = new RString("key1");

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
                    new IraishoIkkatsuHakkoMessages(UrErrorMessages.出力項目を指定)));
        }
        if (STATE_SHUJII.equals(div.getState()) && isShujiiNoSelected()) {
            validationMessages.add(new ValidationMessageControlPair(
                    new IraishoIkkatsuHakkoMessages(UrErrorMessages.出力項目を指定)));
        }

        return validationMessages;
    }
    
    private boolean isNinteiNoSelected() {
        boolean is調査書なし = div.getChkNinteiChosaIraiChohyo().getSelectedKeys().isEmpty();
        boolean is調査書以外なし = div.getChkchosairaihakko().getSelectedKeys().isEmpty()
                && div.getChkchosairaiRireki().getSelectedKeys().isEmpty();
        if (is調査書なし) {
            return is調査書以外なし;
        }
        return div.getChkChosaIrai().getSelectedKeys().isEmpty()
                && div.getChkNinteiChosahyoSonota().getSelectedKeys().isEmpty()
                && div.getChkChosaDesign().getSelectedKeys().isEmpty()
                && div.getChkTokkiDesign().getSelectedKeys().isEmpty()
                && div.getChkChosaOcr().getSelectedKeys().isEmpty()
                && div.getChkTokkiOcr().getSelectedKeys().isEmpty()
                && div.getChkSaiCheck().getSelectedKeys().isEmpty()
                && div.getChkGaikyoTokki().getSelectedKeys().isEmpty()
                && div.getChkTokkiKomokuAri().getSelectedKeys().isEmpty()
                && div.getChkTokkiKomokuNashi().getSelectedKeys().isEmpty()
                && div.getChkTokkiFree().getSelectedKeys().isEmpty()
                && div.getChkTokkijikoTenyuryoku().getSelectedKeys().isEmpty()
                && is調査書以外なし;

    }

    private boolean isShujiiNoSelected() {
        boolean is意見書なし = div.getChkShujiiIkenshoShutsuryoku().getSelectedKeys().isEmpty();
        boolean is意見書以外なし = div.getChkikenshiiraihakko().getSelectedKeys().isEmpty()
                && div.getChkikenshiiraiRireki().getSelectedKeys().isEmpty();
        if (is意見書なし) {
            return is意見書以外なし;
        }
        return div.getChkShujiiIkenshoSakuseiIraisho().getSelectedKeys().isEmpty()
                && div.getChkShujiiIkenshoSakuseiIraisho().getSelectedKeys().isEmpty()
                && div.getChkShujiIkenshoyoshi().getSelectedKeys().isEmpty()
                && div.getChkShujiiIkenshoyoshiOcr().getSelectedKeys().isEmpty()
                && div.getChkShujiiIkenshoyoshiDesign().getSelectedKeys().isEmpty()
                && div.getChkShujiiIkenshoSakuseiryoSeikyusho().getSelectedKeys().isEmpty()
                && div.getChkShindanMeireishoAndTeishutsuIraisho().getSelectedKeys().isEmpty()
                && is意見書以外なし;
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
