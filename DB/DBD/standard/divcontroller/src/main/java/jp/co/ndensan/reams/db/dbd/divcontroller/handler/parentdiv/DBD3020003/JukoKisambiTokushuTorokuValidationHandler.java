/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD3020003;

import jp.co.ndensan.reams.db.dbd.definition.message.DbdErrorMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD3020003.JukoKisambiTokushuTorokuDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD3020003.JukoKisambiTokushuTorokuSpec;
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
 * 「時効起算日特殊登録」画面のValidationHandlerクラスです。
 *
 * @reamsid_L DBD-3820-010 huangh
 */
public class JukoKisambiTokushuTorokuValidationHandler {

    private final JukoKisambiTokushuTorokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div HikazeiNenkinTaishoshaJohoDiv
     */
    public JukoKisambiTokushuTorokuValidationHandler(JukoKisambiTokushuTorokuDiv div) {
        this.div = div;
    }

    /**
     * 一括用特殊時効起算日の必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor一括用特殊時効起算日の必須入力(ValidationMessageControlPairs pairs) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(JukoKisambiTokushuTorokuSpec.一括用特殊時効起算日必須チェック)
                .thenAdd(NoInputMessages.一括用特殊時効起算日必須チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.一括用特殊時効起算日必須チェック, div.getTxtTokushuJikoKisambi()).build().check(messages));
        return pairs;
    }

    /**
     * 一括用特殊時効起算日事由DDLの必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor一括用特殊時効起算日事由DDLの必須入力(ValidationMessageControlPairs pairs) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(JukoKisambiTokushuTorokuSpec.一括用特殊時効起算日事由DDL必須チェック)
                .thenAdd(NoInputMessages.一括用特殊時効起算日事由DDL必須チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.一括用特殊時効起算日事由DDL必須チェック, div.getDdlFukushaJikoKisambiJiyu()).build().check(messages));
        return pairs;
    }

    /**
     * 特殊時効起算日入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor特殊時効起算日入力(ValidationMessageControlPairs pairs) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(JukoKisambiTokushuTorokuSpec.特殊時効起算日入力チェック)
                .thenAdd(NoInputMessages.特殊時効起算日入力チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.特殊時効起算日入力チェック, div.getDgJikoKisambi()).build().check(messages));
        return pairs;
    }

    private static enum NoInputMessages implements IValidationMessage {

        一括用特殊時効起算日必須チェック(UrErrorMessages.必須項目_追加メッセージあり, "一括用特殊時効起算日"),
        一括用特殊時効起算日事由DDL必須チェック(UrErrorMessages.必須項目_追加メッセージあり, "一括用特殊時効起算日事由"),
        特殊時効起算日入力チェック(DbdErrorMessages.特殊時効起算日);

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
