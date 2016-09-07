/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5710001;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5710001.JyukyushaDaichoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5710001.JyukyushaDaichoDivSpec;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 受給者台帳画面のValidationHandlerです。
 *
 * @reamsid_L DBD-1760-010 xuejm
 */
public class JyukyushaDaichoValidationHandler {

    /**
     * 必須チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div JyukyushaDaichoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor今回抽出対象期間今回の日付が非空(ValidationMessageControlPairs pairs, JyukyushaDaichoDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(JyukyushaDaichoDivSpec.今回抽出対象期間今回の日付が非空必須チェック)
                .thenAdd(NoInputMessages.今回抽出対象期間今回の日付が非空必須チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.今回抽出対象期間今回の日付が非空必須チェック, div.getChushutsuJyouken().getTaishouKikan().getTxtKonkaiymdtime()).build().check(messages));
        return pairs;
    }

    /**
     * 今回抽出対象終了日付が開始日付以前チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div JyukyushaDaichoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor今回抽出対象終了日付が開始日付以前チェック(ValidationMessageControlPairs pairs, JyukyushaDaichoDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(JyukyushaDaichoDivSpec.今回抽出対象終了日付が開始日付以前チェック)
                .thenAdd(NoInputMessages.今回抽出対象終了日付が開始日付以前チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.今回抽出対象終了日付が開始日付以前チェック,
                div.getChushutsuJyouken().getTaishouKikan().getTxtKonkaiymdtime()).build().check(messages));
        return pairs;
    }

    /**
     * 被保険者番号非空チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div JyukyushaDaichoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor被保険者番号非空チェック(ValidationMessageControlPairs pairs, JyukyushaDaichoDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(JyukyushaDaichoDivSpec.被保険者番号非空チェック)
                .thenAdd(NoInputMessages.被保険者番号非空チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.被保険者番号非空チェック, div.getChushutsuJyouken().getTaishouSha().getTxtHihokenshaBangou()).build().check(messages));
        return pairs;
    }

    /**
     * 被保険者番号ToがFrom以前チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div JyukyushaDaichoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor被保険者番号ToがFrom以前チェック(ValidationMessageControlPairs pairs, JyukyushaDaichoDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(JyukyushaDaichoDivSpec.被保険者番号ToがFrom以前チェック)
                .thenAdd(NoInputMessages.被保険者番号ToがFrom以前チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.被保険者番号ToがFrom以前チェック, div.getChushutsuJyouken().getTaishouSha().getTxtHihokenshaBangou()).build().check(messages));
        return pairs;
    }

    /**
     * 出力順未指定チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div JyukyushaDaichoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor出力順未指定チェック(ValidationMessageControlPairs pairs, JyukyushaDaichoDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(JyukyushaDaichoDivSpec.出力順未指定チェック)
                .thenAdd(NoInputMessages.出力順未指定チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.出力順未指定チェック, ((ChohyoShutsuryokujunDiv) div.getShutsuryokuSort()).getTxtSort()).build().check(messages));
        return pairs;
    }

    private static enum NoInputMessages implements IValidationMessage {

        今回抽出対象期間今回の日付が非空必須チェック(UrErrorMessages.必須, "今回"),
        今回抽出対象終了日付が開始日付以前チェック(UrErrorMessages.終了日が開始日以前),
        被保険者番号非空チェック(UrErrorMessages.必須, "被保険者番号非空"),
        被保険者番号ToがFrom以前チェック(UrErrorMessages.大小関係が不正, "被保険者番号ToがFrom以前"),
        出力順未指定チェック(UrErrorMessages.出力順序を指定);

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
