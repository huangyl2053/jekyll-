/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0550001;

import java.util.List;
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
    private final RString 口座振替者 = new RString("口座振替者");
    private final RString 生活保護対象者 = new RString("生活保護対象者");
    private final RString ページごとに山分け = new RString("ページごとに山分け");
    private final RString 対象賦課年度 = new RString("対象賦課年度");

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
     * @param 決定変更通知書Flag boolean
     * @param 納入通知書Flag boolean
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check実行(boolean 決定変更通知書Flag,
            boolean 納入通知書Flag) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (決定変更通知書Flag) {
            List<RString> 決定チェックボックス = div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().
                    getChkKetteiTsuchi().getSelectedKeys();
            List<RString> 変更チェックボックス = div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().
                    getChkHenkoTsuchi().getSelectedKeys();
            if ((決定チェックボックス == null || 決定チェックボックス.isEmpty())
                    && (変更チェックボックス == null || 変更チェックボックス.isEmpty())) {
                validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                        UrErrorMessages.必須, 通知書チェックボックス.toString())));
            }
            if (決定チェックボックス != null && !決定チェックボックス.isEmpty()) {
                check決定通知書(validPairs);
            }
            if (変更チェックボックス != null && !変更チェックボックス.isEmpty()) {
                check変更通知書(validPairs);
            }
        }
        if (納入通知書Flag) {
            check納入通知書(validPairs);
        }
        if (!div.getKanendoShoriNaiyo().getDdlShoritsuki().getSelectedKey().
                equals(div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getDdlNotsuShutsuryokuKi().getSelectedKey())) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    DbbErrorMessages.賦課処理対象月と通知書出力月の不整合)));
        }

        return validPairs;
    }

    private ValidationMessageControlPairs check決定通知書(ValidationMessageControlPairs validPairs) {
        if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getTxtKetteiTsuchiHakkoYMD().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.必須, 決定通知書の発行日.toString())));
        }
        if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkKetteiTsuchiTaishoNendo().getSelectedKeys() == null
                || div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().
                getChkKetteiTsuchiTaishoNendo().getSelectedKeys().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.必須, 対象賦課年度.toString())));
        }
        return validPairs;
    }

    private ValidationMessageControlPairs check変更通知書(ValidationMessageControlPairs validPairs) {
        if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getTxtHenkoTsuchiHakkoYMD().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.必須, 変更通知書の発行日.toString())));
        }
        if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkHenkoTsuchiTaishoFukaNendo().getSelectedKeys() == null
                || div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().
                getChkHenkoTsuchiTaishoFukaNendo().getSelectedKeys().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.必須, 対象賦課年度.toString())));
        }
        if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkHenkoTsuchiTaishosha().getSelectedKeys() == null
                || div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().
                getChkHenkoTsuchiTaishosha().getSelectedKeys().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.必須, 対象者.toString())));
        }
        return validPairs;
    }

    private ValidationMessageControlPairs check納入通知書(ValidationMessageControlPairs validPairs) {
        if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getTxtNotsuHakkoYMD().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.必須, 納入通知書の発行日.toString())));
        }
        if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkNotsuTaishoFukaNedno().getSelectedKeys() == null
                || div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().
                getChkNotsuTaishoFukaNedno().getSelectedKeys().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.必須, 対象賦課年度.toString())));
        }
        if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkNotsuTaishosha().getSelectedKeys() == null
                || div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().
                getChkNotsuTaishosha().getSelectedKeys().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.必須, 対象者.toString())));
        }
        if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getRadNotsuKozaShutsuryokuYoshiki().getSelectedKey() == null
                || div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().
                getRadNotsuKozaShutsuryokuYoshiki().getSelectedKey().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.必須, 口座振替者.toString())));
        }
        if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getRadNotsuSeikatsuHogo().getSelectedKey() == null
                || div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().
                getRadNotsuSeikatsuHogo().getSelectedKey().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.必須, 生活保護対象者.toString())));
        }
        if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getRadNotsuYamawake().getSelectedKey() == null
                || div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().
                getRadNotsuYamawake().getSelectedKey().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.必須, ページごとに山分け.toString())));
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
