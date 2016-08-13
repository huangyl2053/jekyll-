/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1080002;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1080002.ShinseishoIkkatsuHakkoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1080002.ShinseishoIkkatsuHakkoSpec;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 減免減額申請書一括発行のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBD-3530-050 liuyl
 */
public class ShinseishoIkkatsuHakkoValidationHandler {

    /**
     * 候補者を選択しない。
     *
     * @param pairs ValidationMessageControlPairs
     * @param div ShinseishoIkkatsuHakkoDiv
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 候補者を選択しない(ValidationMessageControlPairs pairs, ShinseishoIkkatsuHakkoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(ShinseishoIkkatsuHakkoSpec.候補者を選択しないチェック)
                .thenAdd(NoInputMessages.候補者を選択しない).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.候補者を選択しない, div.getGenmenShinseiHaakuList().getGenmenShinseiHaakuShinseisho()).build().check(messages));
        return pairs;
    }

    /**
     * 出力チェックボックスを選択しない。
     *
     * @param pairs ValidationMessageControlPairs
     * @param div ShinseishoIkkatsuHakkoDiv
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 出力チェックボックスを選択しない(ValidationMessageControlPairs pairs, ShinseishoIkkatsuHakkoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(ShinseishoIkkatsuHakkoSpec.出力チェックボックスを選択しないチェック)
                .thenAdd(NoInputMessages.出力チェックボックスを選択しない).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.出力チェックボックスを選択しない, div.getGenmenShinseiHaakuList().getGenmenShinseiHaakuShinseisho()).
                build().check(messages));
        return pairs;

    }

    /**
     * 処理日時必須入力。
     *
     * @param pairs ValidationMessageControlPairs
     * @param div ShinseishoIkkatsuHakkoDiv
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 処理日時必須入力(ValidationMessageControlPairs pairs, ShinseishoIkkatsuHakkoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(ShinseishoIkkatsuHakkoSpec.処理日時の非空チェック)
                .thenAdd(NoInputMessages.処理日時必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.処理日時必須入力, div.getGenmenShinseiHaakuList().getDdlShoriTimestamp()).
                build().check(messages));
        return pairs;
    }

    private static enum NoInputMessages implements IValidationMessage {

        出力チェックボックスを選択しない(UrErrorMessages.選択されていない.getMessage(), "出力対象"),
        候補者を選択しない(UrErrorMessages.選択されていない.getMessage(), "候補者"),
        処理日時必須入力(UrErrorMessages.必須.getMessage(), "処理日時");

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
