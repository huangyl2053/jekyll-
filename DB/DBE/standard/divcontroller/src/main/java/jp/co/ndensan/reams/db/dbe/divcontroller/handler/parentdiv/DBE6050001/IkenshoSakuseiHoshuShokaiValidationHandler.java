/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6050001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6050001.IkenshoSakuseiHoshuShokaiDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 意見書作成報酬照会のチェッククラスです。
 *
 * @reamsid_L DBE-1930-010 chenxiangyu
 */
public class IkenshoSakuseiHoshuShokaiValidationHandler {

    private final IkenshoSakuseiHoshuShokaiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div IkenshoSakuseiHoshuShokaiDiv
     */
    public IkenshoSakuseiHoshuShokaiValidationHandler(IkenshoSakuseiHoshuShokaiDiv div) {
        this.div = div;
    }

    /**
     * 作成依頼日の必須入力チェックを実施します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateForIraishoSakuseiIraiYMD() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getTxtSakuseiIraibi().getFromValue() == null || div.getTxtSakuseiIraibi().getToValue() == null) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.必須項目)));
        }
        return validPairs;
    }

    /**
     * データの必須選択チェックを実施します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateForCheckedDataCount() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getDgIkenshoSakuseiHoshu().getSelectedItems().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.対象行を選択)));
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
