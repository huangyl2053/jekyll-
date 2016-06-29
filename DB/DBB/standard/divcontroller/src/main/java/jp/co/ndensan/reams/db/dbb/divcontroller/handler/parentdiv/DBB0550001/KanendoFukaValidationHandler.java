/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0550001;

import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0550001.KanendoFukaDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * @reamsid_L DBB-1760-010 quxiaodong
 */
public class KanendoFukaValidationHandler {

    private final KanendoFukaDiv div;
    private final RString 決定通知書の発行日 = new RString("決定通知書の発行日");
    private final RString 変更通知書の発行日 = new RString("変更通知書の発行日");
    private final RString 納入通知書の発行日 = new RString("納入通知書の発行日");
    private final RString 通知書チェックボックス = new RString("通知書チェックボックス");
    private final RString 対象者 = new RString("対象者");

    /**
     * 初期化
     *
     * @param div YoguKonyuhiShikyuShinseiPnlTotalDiv
     */
    public KanendoFukaValidationHandler(KanendoFukaDiv div) {
        this.div = div;
    }

    /**
     * 実行チェック
     *
     * @return validPairs
     */
    public ValidationMessageControlPairs 実行チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getTxtKetteiTsuchiHakkoYMD().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.必須, 決定通知書の発行日.toString())));
        }
        if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getTxtHenkoTsuchiHakkoYMD().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.必須, 変更通知書の発行日.toString())));
        }
        if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getTxtNotsuHakkoYMD().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.必須, 納入通知書の発行日.toString())));
        }
        if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkNotsuTaishosha().getSelectedKeys() == null
                || div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkNotsuTaishosha().getSelectedKeys().isEmpty()
                || div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkHenkoTsuchiTaishosha().getSelectedKeys() == null
                || div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().
                getChkHenkoTsuchiTaishosha().getSelectedKeys().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.必須, 対象者.toString())));
        }
        if (!div.getKanendoShoriNaiyo().getDdlShoritsuki().getSelectedValue().
                equals(div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getDdlNotsuShutsuryokuKi().getSelectedValue())) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    DbbErrorMessages.賦課処理対象月と通知書出力月の不整合)));
        }
        if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkKetteiTsuchi().getSelectedKeys().isEmpty()
                || div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkKetteiTsuchi().getSelectedKeys() == null
                || div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkHenkoTsuchi().getSelectedKeys().isEmpty()
                || div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkHenkoTsuchi().getSelectedKeys() == null) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.必須, 通知書チェックボックス.toString())));
        }
        if (div.getCcdChohyoIchiran().getSelected帳票IdAnd出力順Id().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    DbbErrorMessages.帳票ID取得不可のため処理不可)));
        }
        return validPairs;
    }

    private static class IdocheckMessages implements IValidationMessage {

        private final Message message;

        public IdocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

}
