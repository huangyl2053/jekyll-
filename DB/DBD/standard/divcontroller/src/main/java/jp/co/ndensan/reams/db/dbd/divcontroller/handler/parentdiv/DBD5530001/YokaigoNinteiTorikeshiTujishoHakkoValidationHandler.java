/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5530001;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5530001.YokaigoNinteiTorikeshiTujishoHakkoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5530001.YokaigoNinteiTorikeshiTujishoHakkoDivSpec;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 要介護認定取消通知書発行のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBD-1440-010 liuyl
 */
public class YokaigoNinteiTorikeshiTujishoHakkoValidationHandler {

    /**
     * 異動事由必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div KoshinShinseishaHaakuListDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 異動事由必須入力チェック(ValidationMessageControlPairs pairs, YokaigoNinteiTorikeshiTujishoHakkoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(YokaigoNinteiTorikeshiTujishoHakkoDivSpec.異動事由必須入力チェック)
                .thenAdd(NoInputMessages.異動事由必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.異動事由必須入力, div.getTujishoHakkoMeisai().getTxtIdoJiyu()).build().check(messages));
        return pairs;
    }

    /**
     * 期間大小関係チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div KoshinShinseishaHaakuListDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 期間大小関係チェック(ValidationMessageControlPairs pairs, YokaigoNinteiTorikeshiTujishoHakkoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(YokaigoNinteiTorikeshiTujishoHakkoDivSpec.期間大小関係チェック)
                .thenAdd(NoInputMessages.期間大小関係チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.期間大小関係チェック, div.getTujishoHakkoMeisai().getTxtYukoKigen2()).build().check(messages));
        return pairs;
    }

    private static enum NoInputMessages implements IValidationMessage {

        異動事由必須入力(UrErrorMessages.必須.getMessage(), "異動事由必須入力"),
        期間大小関係チェック(UrErrorMessages.期間が不正.getMessage());
        private final Message message;

        private NoInputMessages(Message message, String... replacements) {
            this.message = message.replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
