/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KekkaShosaiJoho.KekkaShosaiJoho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 結果詳細情報画面のValidationHandlerです。
 *
 * @reamsid_L DBZ-1320-020 zuotao
 */
public class KekkaShosaiJohoValidationHandler {

    private static final int MAX_COUNT = 31;
    private final KekkaShosaiJohoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div NinteiInputDiv
     */
    public KekkaShosaiJohoValidationHandler(KekkaShosaiJohoDiv div) {
        this.div = div;
    }

    /**
     * 有効開始日checkを行う。
     *
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs check有効開始日() {
        ValidationMessageControlPairs validationMessage = new ValidationMessageControlPairs();
        if (div.getCcdNinteiInput().getNaiyo().get有効開始年月日() == null
                || div.getCcdNinteiInput().getNaiyo().get有効開始年月日().equals(FlexibleDate.EMPTY)) {
            validationMessage.add(new ValidationMessageControlPair(KekkaShosaiJohoCheckMessages.validation有効開始日,
                    div.getCcdNinteiInput().getNinteiJoho().getTxtYukoKaishiYMD()));
        }
//        else if (!div.getCcdNinteiInput().getNaiyo().get有効開始年月日().isValid()) {
//            validationMessage.add(new ValidationMessageControlPair(KekkaShosaiJohoCheckMessages.validation不正な有効開始日,
//                    div.getCcdNinteiInput().getNinteiJoho().getTxtYukoKaishiYMD()));
//        }
        return validationMessage;
    }

    /**
     * 有効終了日checkを行う。
     *
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs check有効終了日() {
        ValidationMessageControlPairs validationMessage = new ValidationMessageControlPairs();
        if (div.getCcdNinteiInput().getNaiyo().get有効終了年月日() == null
                || div.getCcdNinteiInput().getNaiyo().get有効終了年月日() == null) {
            validationMessage.add(new ValidationMessageControlPair(KekkaShosaiJohoCheckMessages.validation有効終了日,
                    div.getCcdNinteiInput().getNinteiJoho().getTxtYukoShuryoYMD()));
        }
//        else if (!div.getCcdNinteiInput().getNaiyo().get有効終了年月日().isValid()) {
//            validationMessage.add(new ValidationMessageControlPair(KekkaShosaiJohoCheckMessages.validation不正な有効終了日,
//                    div.getCcdNinteiInput().getNinteiJoho().getTxtYukoShuryoYMD()));
//        }
        return validationMessage;
    }

    /**
     * 認定年月日checkを行う。
     *
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs check認定年月日() {
        ValidationMessageControlPairs validationMessage = new ValidationMessageControlPairs();
        if (div.getCcdNinteiInput().getNaiyo().get認定年月日() == null
                || div.getCcdNinteiInput().getNaiyo().get認定年月日() == null) {
            validationMessage.add(new ValidationMessageControlPair(KekkaShosaiJohoCheckMessages.validation認定年月日,
                    div.getCcdNinteiInput().getNinteiJoho().getTxtNinteiYMD()));
        }
//        else if (!div.getCcdNinteiInput().getNaiyo().get認定年月日().isValid()) {
//            validationMessage.add(new ValidationMessageControlPair(KekkaShosaiJohoCheckMessages.validation不正な認定年月日,
//                    div.getCcdNinteiInput().getNinteiJoho().getTxtNinteiYMD()));
//        }
        return validationMessage;
    }

    /**
     * サービス区分checkを行う。
     *
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs checkサービス区分() {
        ValidationMessageControlPairs validationMessage = new ValidationMessageControlPairs();
        if (MAX_COUNT < div.getCcdNinteiInput().getServiceRow().size()) {
            validationMessage.add(new ValidationMessageControlPair(KekkaShosaiJohoCheckMessages.validationサービス区分));
        }
        return validationMessage;
    }

    private static enum KekkaShosaiJohoCheckMessages implements IValidationMessage {

        validation有効開始日(UrErrorMessages.必須項目_追加メッセージあり, "開始日"),
        validation有効終了日(UrErrorMessages.必須項目_追加メッセージあり, "終了日"),
        validation認定年月日(UrErrorMessages.必須項目_追加メッセージあり, "認定年月日"),
        validationサービス区分(UrErrorMessages.入力値が不正_追加メッセージあり, "サービス区分が31項目以上選択されています。"),
        validation不正な有効開始日(UrErrorMessages.不正, "有効開始日"),
        validation不正な有効終了日(UrErrorMessages.不正, "有効終了日"),
        validation不正な認定年月日(UrErrorMessages.不正, "認定年月日");

        private final Message message;

        private KekkaShosaiJohoCheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
