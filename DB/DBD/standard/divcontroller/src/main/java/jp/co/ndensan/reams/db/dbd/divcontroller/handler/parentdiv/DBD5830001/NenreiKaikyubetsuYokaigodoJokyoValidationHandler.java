/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5830001;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5830001.NenreiKaikyubetsuYokaigodoJokyoDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 年齢階級別要介護度状況（統計表）画面のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBD-1790-010 donghj
 */
public class NenreiKaikyubetsuYokaigodoJokyoValidationHandler {

    /**
     * 行政区コード大小関係チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NenreiKaikyubetsuYokaigodoJokyoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor行政区コード大小関係チェック(ValidationMessageControlPairs pairs,
            NenreiKaikyubetsuYokaigodoJokyoDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NenreiKaikyubetsuYokaigodoJokyoSpec.行政区コード大小関係チェック)
                .thenAdd(NoInputMessages.行政区コード大小関係チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.行政区コード大小関係チェック,
                div).build().check(messages));
        return pairs;

    }

    /**
     * 組合コード大小関係チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NenreiKaikyubetsuYokaigodoJokyoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor組合コード大小関係チェック(ValidationMessageControlPairs pairs,
            NenreiKaikyubetsuYokaigodoJokyoDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NenreiKaikyubetsuYokaigodoJokyoSpec.組合コード大小関係チェック)
                .thenAdd(NoInputMessages.組合コード大小関係チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.組合コード大小関係チェック,
                div).build().check(messages));
        return pairs;

    }

    /**
     * 住所コード大小関係チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NenreiKaikyubetsuYokaigodoJokyoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor住所コード大小関係チェック(ValidationMessageControlPairs pairs,
            NenreiKaikyubetsuYokaigodoJokyoDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NenreiKaikyubetsuYokaigodoJokyoSpec.住所コード大小関係チェック)
                .thenAdd(NoInputMessages.住所コード大小関係チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.住所コード大小関係チェック,
                div).build().check(messages));
        return pairs;

    }

    private static enum NoInputMessages implements IValidationMessage {

        行政区コード大小関係チェック(UrErrorMessages.大小関係が不正, "終了行政区コード"),
        組合コード大小関係チェック(UrErrorMessages.大小関係が不正, "終了組合コード"),
        住所コード大小関係チェック(UrErrorMessages.大小関係が不正, "終了住所コード");

        private final Message message;

        private NoInputMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

}
