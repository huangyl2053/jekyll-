/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1060001;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1060001.GemmenGengakuShoIkkatsuMainDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1060001.GemmenGengakuShoIkkatsuMainDivSpec;
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
 * 減免減額帳票一括のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBD-3981-010 zhuxiaojun
 */
public class GemmenGengakuShoIkkatsuMainValidationHandler {

    /**
     * 出力の選択チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div GemmenGengakuShoIkkatsuMainDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor出力の選択チェック(ValidationMessageControlPairs pairs, GemmenGengakuShoIkkatsuMainDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(GemmenGengakuShoIkkatsuMainDivSpec.出力の選択チェック)
                .thenAdd(NoInputMessages.出力ボックスの必須選択).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.出力ボックスの必須選択, div).build().check(messages));
        return pairs;
    }

    /**
     * 交付日の非空チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div GemmenGengakuShoIkkatsuMainDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor交付日の非空チェック(ValidationMessageControlPairs pairs, GemmenGengakuShoIkkatsuMainDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(GemmenGengakuShoIkkatsuMainDivSpec.交付日の非空チェック)
                .thenAdd(NoInputMessages.交付日の必須非空).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.交付日の必須非空, div).build().check(messages));
        return pairs;
    }

    /**
     * 発行日の非空チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div GemmenGengakuShoIkkatsuMainDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor発行日の非空チェック(ValidationMessageControlPairs pairs, GemmenGengakuShoIkkatsuMainDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(GemmenGengakuShoIkkatsuMainDivSpec.発行日の非空チェック)
                .thenAdd(NoInputMessages.発行日の必須非空).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.発行日の必須非空, div).build().check(messages));
        return pairs;
    }

    /**
     * 文書番号の設定チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div GemmenGengakuShoIkkatsuMainDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor文書番号の設定チェック(ValidationMessageControlPairs pairs, GemmenGengakuShoIkkatsuMainDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(GemmenGengakuShoIkkatsuMainDivSpec.文書番号の設定チェック)
                .thenAdd(NoInputMessages.文書番号の必須設定).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.文書番号の必須設定, div).build().check(messages));
        return pairs;
    }

    /**
     * 対象日のチェック。
     *
     * @param pairs バリデーションコントロール
     * @param div GemmenGengakuShoIkkatsuMainDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor対象日のチェック(ValidationMessageControlPairs pairs, GemmenGengakuShoIkkatsuMainDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(GemmenGengakuShoIkkatsuMainDivSpec.対象日Fromの時間チェック)
                .thenAdd(NoInputMessages.対象日のチェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.対象日のチェック, div).build().check(messages));
        return pairs;
    }

    /**
     * 決定日のチェック。
     *
     * @param pairs バリデーションコントロール
     * @param div GemmenGengakuShoIkkatsuMainDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor決定日のチェック(ValidationMessageControlPairs pairs, GemmenGengakuShoIkkatsuMainDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(GemmenGengakuShoIkkatsuMainDivSpec.決定日Fromの時間チェック)
                .thenAdd(NoInputMessages.決定日のチェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.決定日のチェック, div).build().check(messages));
        return pairs;
    }

    private static enum NoInputMessages implements IValidationMessage {

        出力ボックスの必須選択(UrErrorMessages.選択されていない, "出力対象"),
        交付日の必須非空(UrErrorMessages.必須, "交付日"),
        発行日の必須非空(UrErrorMessages.必須, "発行日"),
        文書番号の必須設定(UrErrorMessages.必須, "文書番号"),
        対象日のチェック(UrErrorMessages.前後関係逆転, "対象日FROM", "対象日TO"),
        決定日のチェック(UrErrorMessages.前後関係逆転, "決定日FROM", "決定日TO");

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
