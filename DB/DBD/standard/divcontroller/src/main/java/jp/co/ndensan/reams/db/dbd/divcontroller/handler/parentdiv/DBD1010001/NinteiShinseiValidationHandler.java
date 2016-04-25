/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1010001;

import jp.co.ndensan.reams.db.dbd.definition.message.DbdErrorMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010001.FutangendogakuShinseiDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010001.FutangendogakuShinseiDivSpec;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * @author liangbc
 */
public class NinteiShinseiValidationHandler {

    /**
     * 受給共通_受給者登録なしチェックです。
     *
     * @param pairs ValidationMessageControlPairs
     * @param div TaishouWaritsukeDiv
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 受給共通_受給者登録なしチェック(ValidationMessageControlPairs pairs, FutangendogakuShinseiDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(FutangendogakuShinseiDivSpec.受給共通_受給者登録なし)
                .thenAdd(NinteiShinseiValidationMessages.受給共通_受給者_事業対象者登録なし).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NinteiShinseiValidationMessages.受給共通_受給者_事業対象者登録なし).build().check(messages));
        return pairs;
    }

    /**
     * 変更有無チェックです。
     *
     * @param pairs ValidationMessageControlPairs
     * @param div TaishouWaritsukeDiv
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 変更有無チェック(ValidationMessageControlPairs pairs, FutangendogakuShinseiDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(FutangendogakuShinseiDivSpec.変更有無チェック)
                .thenAdd(NinteiShinseiValidationMessages.内容変更なしで保存不可).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NinteiShinseiValidationMessages.内容変更なしで保存不可).build().check(messages));
        return pairs;
    }

    private static enum NinteiShinseiValidationMessages implements IValidationMessage {

        受給共通_受給者_事業対象者登録なし(DbdErrorMessages.受給共通_受給者_事業対象者登録なし),
        内容変更なしで保存不可(DbzInformationMessages.内容変更なしで保存不可);
        private final Message message;

        private NinteiShinseiValidationMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
