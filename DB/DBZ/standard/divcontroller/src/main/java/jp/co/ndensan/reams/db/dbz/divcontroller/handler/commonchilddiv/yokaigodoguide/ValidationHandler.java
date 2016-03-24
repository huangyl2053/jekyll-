/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.yokaigodoguide;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.YokaigodoGuide.YokaigodoGuide.YokaigodoGuideDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 要介護度ガイドのチェッククラスです。
 */
public class ValidationHandler {

    private final YokaigodoGuideDiv godoDiv;

    /**
     * コンストラクタです。
     *
     * @param godoDiv YokaigodoGuideDiv
     */
    public ValidationHandler(YokaigodoGuideDiv godoDiv) {
        this.godoDiv = godoDiv;
    }

    /**
     * 一覧データなしチェックします。
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 一覧データなしチェック(ValidationMessageControlPairs validPairs) {
        if (godoDiv.getDgYokaigodoGuide().getDataSource().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.Validate対象者一覧未表示,
                    godoDiv.getDgYokaigodoGuide()));
        }
        return validPairs;
    }

    private static enum RRVMessages implements IValidationMessage {

        Validate対象者一覧未表示(UrErrorMessages.該当データなし);
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
