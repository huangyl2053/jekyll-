/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2020001;

import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020001.NinteiChosaSchedulePanelDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxFlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 認定調査スケジュール登録1のチェッククラスです。
 *
 * @reamsid_L DBE-0020-010 lizhuoxuan
 */
public class ValidationHandler {

    private final NinteiChosaSchedulePanelDiv ninteidiv;

    /**
     * コンストラクタです。
     *
     * @param ninteidiv NinteiChosaSchedulePanelDiv
     */
    public ValidationHandler(NinteiChosaSchedulePanelDiv ninteidiv) {
        this.ninteidiv = ninteidiv;
    }

    /**
     * 一覧データなしチェックします。
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 一覧データなしチェック(ValidationMessageControlPairs validPairs) {
        validPairs.add(new ValidationMessageControlPair(RRVMessages.Validate対象者一覧未表示,
                ninteidiv.getDgNinteiChosaSchedule()));
        return validPairs;
    }
    
    /**
     * validationMessage和暦に変換不可を返す。
     *
     * @param textBoxFlexibleYearMonth TextBoxFlexibleYearMonth
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validate和暦に変換不可(TextBoxFlexibleYearMonth textBoxFlexibleYearMonth) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(RRVMessages.和暦に変換不可,
                textBoxFlexibleYearMonth));
        return validationMessages;
    }

    private static enum RRVMessages implements IValidationMessage {

        Validate対象者一覧未表示(UrErrorMessages.該当データなし),
        和暦に変換不可(DbeErrorMessages.和暦に変換不可);
        private final Message message;

        private RRVMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

}
