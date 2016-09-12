/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD4030011;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4030011.ShogaishaKoujoTaishoNinteiShoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4030011.ShogaishaKoujoTaishoNinteiShoDivSpec;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 障がい者控除対象者認定書一括発行のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBD-3860-010 donghj
 */
public class ShogaishaKoujoTaishoNinteiShoValidationHandler {

    /**
     * 対象年度の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div ShogaishaKoujoTaishoNinteiShoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor対象年度の必須入力(ValidationMessageControlPairs pairs, ShogaishaKoujoTaishoNinteiShoDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(ShogaishaKoujoTaishoNinteiShoDivSpec.対象年度の未入力チェック)
                .thenAdd(NoInputMessages.対象年度の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.対象年度の必須入力,
                div.getTyusyutuJyokenPanel().getTxtTaishoNendo()).build().check(messages));
        return pairs;

    }

    /**
     * 喪失日_終了日が開始日以前チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div ShogaishaKoujoTaishoNinteiShoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor喪失日_終了日が開始日以前(ValidationMessageControlPairs pairs, ShogaishaKoujoTaishoNinteiShoDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(ShogaishaKoujoTaishoNinteiShoDivSpec.喪失日_終了日が開始日以前チェック)
                .thenAdd(NoInputMessages.喪失日_終了日が開始日以前).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.喪失日_終了日が開始日以前,
                div.getTyusyutuJyokenPanel().getTxtSoshituDay()).build().check(messages));
        return pairs;

    }

    /**
     * 決定日_終了日が開始日以前チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div ShogaishaKoujoTaishoNinteiShoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor決定日_終了日が開始日以前(ValidationMessageControlPairs pairs, ShogaishaKoujoTaishoNinteiShoDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(ShogaishaKoujoTaishoNinteiShoDivSpec.決定日_終了日が開始日以前チェック)
                .thenAdd(NoInputMessages.決定日_終了日が開始日以前).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.決定日_終了日が開始日以前,
                div.getTyusyutuJyokenPanel().getTxtKeteiDay()).build().check(messages));
        return pairs;

    }

    /**
     * 出力順序必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div ShogaishaKoujoTaishoNinteiShoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor出力順序の必須入力(ValidationMessageControlPairs pairs, ShogaishaKoujoTaishoNinteiShoDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(ShogaishaKoujoTaishoNinteiShoDivSpec.出力順序必須入力チェック)
                .thenAdd(NoInputMessages.出力順序の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.出力順序の必須入力,
                div.getShogaishaKojoNinteishoOutput()).build().check(messages));
        div.getShogaishaKojoNinteishoOutput().getCcdChohyoShutsuryokujun().get出力順ID();
        return pairs;

    }

    private static enum NoInputMessages implements IValidationMessage {

        対象年度の必須入力(UrErrorMessages.必須.getMessage(), "対象年度"),
        喪失日_終了日が開始日以前(UrErrorMessages.終了日が開始日以前.getMessage()),
        決定日_終了日が開始日以前(UrErrorMessages.終了日が開始日以前.getMessage()),
        出力順序の必須入力(UrErrorMessages.出力順序を指定.getMessage());
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
