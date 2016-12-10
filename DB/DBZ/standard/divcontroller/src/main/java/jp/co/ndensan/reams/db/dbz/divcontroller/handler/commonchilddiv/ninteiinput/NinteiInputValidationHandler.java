/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.ninteiinput;

import jp.co.ndensan.reams.db.dbz.business.core.dbt7202kaigoninteihokaiseikanri.DbT7202KaigoNinteiHokaiseiKanriBusiness;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiInput.NinteiInput.NinteiInputDiv;
import jp.co.ndensan.reams.db.dbz.service.core.ninteiinput.NinteiInputFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * DBZ.NinteiInput_認定情報のValidationHandlerです。
 *
 * @reamsid_L DBZ-1300-080 yaodongsheng
 */
public class NinteiInputValidationHandler {

    private final NinteiInputDiv div;

    /**
     * コンストラクタです。
     *
     * @param div NinteiInputDiv
     */
    public NinteiInputValidationHandler(NinteiInputDiv div) {
        this.div = div;
    }

    /**
     * 有効開始日checkを行う。
     *
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs 有効開始日check() {
        ValidationMessageControlPairs validationMessage = new ValidationMessageControlPairs();
        if (div.getTxtYukoKaishiYMD().getValue() == null) {
            validationMessage.add(new ValidationMessageControlPair(NinteiInputCheckMessages.validation有効開始日, div.getTxtYukoKaishiYMD()));
            return validationMessage;
        }

//        if (!div.getTxtYukoKaishiYMD().getValue().isValid()) {
//            validationMessage.add(new ValidationMessageControlPair(NinteiInputCheckMessages.validation不正な有効開始日, div.getTxtYukoKaishiYMD()));
//        }
        return validationMessage;
    }

    /**
     * 開始日checkを行う。
     *
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs 開始日check() {
        ValidationMessageControlPairs validationMessage = new ValidationMessageControlPairs();
        if (div.getTxtYukoKaishiYMD().getValue() == null) {
            validationMessage.add(new ValidationMessageControlPair(NinteiInputCheckMessages.validation有効開始日, div.getTxtYukoKaishiYMD()));
            return validationMessage;
        }

//        if (!div.getTxtYukoKaishiYMD().getValue().isValid()) {
//            validationMessage.add(new ValidationMessageControlPair(NinteiInputCheckMessages.validation不正な有効開始日, div.getTxtYukoKaishiYMD()));
//            return validationMessage;
//        }
        DbT7202KaigoNinteiHokaiseiKanriBusiness dbt7202 = NinteiInputFinder.createInstance().get最古法改正施行年月日();
        if (dbt7202 != null && dbt7202.get法改正施行年月日() != null && div.getTxtYukoKaishiYMD().getValue().isBefore(dbt7202.get法改正施行年月日().toRDate())) {
            validationMessage.add(new ValidationMessageControlPair(NinteiInputCheckMessages.validation開始日と法施行の前後順,
                    div.getTxtYukoKaishiYMD()));
        }
        return validationMessage;
    }

    /**
     * 終了日checkを行う。
     *
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs 終了日check() {
        ValidationMessageControlPairs validationMessage = new ValidationMessageControlPairs();
        if (div.getTxtYukoShuryoYMD().getValue() == null) {
            validationMessage.add(new ValidationMessageControlPair(NinteiInputCheckMessages.validation有効終了日, div.getTxtYukoShuryoYMD()));
            return validationMessage;
        }

//        if (!div.getTxtYukoShuryoYMD().getValue().isValid()) {
//            validationMessage.add(new ValidationMessageControlPair(NinteiInputCheckMessages.validation不正な有効終了日, div.getTxtYukoShuryoYMD()));
//            return validationMessage;
//        }
        return validationMessage;
    }

    /**
     * 認定年月日checkを行う。
     *
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs 認定年月日check() {
        ValidationMessageControlPairs validationMessage = new ValidationMessageControlPairs();
//        if (!div.getTxtYukoShuryoYMD().getValue().isEmpty() && !div.getTxtNinteiYMD().getValue().isValid()) {
//            validationMessage.add(new ValidationMessageControlPair(NinteiInputCheckMessages.validation不正な認定年月日, div.getTxtNinteiYMD()));
//        }
        if (div.getTxtYukoShuryoYMD().getValue() != null) {
            validationMessage.add(new ValidationMessageControlPair(NinteiInputCheckMessages.validation不正な認定年月日, div.getTxtNinteiYMD()));
        }
        return validationMessage;
    }

    /**
     * 開始終了日の前後順checkを行う(親画面check用)。
     *
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs 開始終了日前後順check() {
        ValidationMessageControlPairs validationMessage = new ValidationMessageControlPairs();
        if (div.getTxtYukoKaishiYMD().getValue() != null && div.getTxtYukoShuryoYMD().getValue() != null
                && div.getTxtYukoShuryoYMD().getValue().isBefore(div.getTxtYukoKaishiYMD().getValue())) {
            validationMessage.add(new ValidationMessageControlPair(NinteiInputCheckMessages.validation開始日と終了日の前後順,
                    div.getTxtYukoKaishiYMD(), div.getTxtYukoShuryoYMD()));
        }
        return validationMessage;
    }

    private static enum NinteiInputCheckMessages implements IValidationMessage {

        validation有効開始日(UrErrorMessages.未入力, "有効開始日"),
        validation有効終了日(UrErrorMessages.未入力, "有効終了日"),
        validation開始日と終了日の前後順(UrErrorMessages.終了日が開始日以前),
        validation開始日と法施行の前後順(UrWarningMessages.日付の前後関係逆転以降, "法施行日", "有効開始日"),
        validation不正な有効開始日(UrErrorMessages.不正, "有効開始日"),
        validation不正な有効終了日(UrErrorMessages.不正, "有効終了日"),
        validation不正な認定年月日(UrErrorMessages.不正, "認定年月日");
        private final Message message;

        private NinteiInputCheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
