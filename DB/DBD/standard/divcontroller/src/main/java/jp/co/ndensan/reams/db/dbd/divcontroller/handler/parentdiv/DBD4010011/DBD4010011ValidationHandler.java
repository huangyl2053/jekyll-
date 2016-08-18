/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD4010011;

import jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD4010011.ShogaishaKojoNinteiJohoDivSpec;
import jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD4010011.ShogaishaKojoTaishoshaHaakuJokenDivSpec;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4010011.DBD4010011Div;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 障がい者控除対象者认定のバリデーションハンドラークラスです。です。
 *
 * @reamsid_L DBD-3850-010 liuwei2
 */
public class DBD4010011ValidationHandler {

    /**
     * 基準日の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div DBD4010011Div
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 基準日の必須入力(ValidationMessageControlPairs pairs, DBD4010011Div div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(ShogaishaKojoTaishoshaHaakuJokenDivSpec.基準日の未入力チェック)
                .thenAdd(NoInputMessages.基準日の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.基準日の必須入力, div.getShogaishaKojoTaishoshaHaakuJoken().getTxtKijunYMD()).build().check(messages));
        return pairs;
    }

    /**
     * 対象年度の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div DBD4010011Div
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 対象年度の必須入力(ValidationMessageControlPairs pairs, DBD4010011Div div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(ShogaishaKojoNinteiJohoDivSpec.対象年度の未入力チェック)
                .thenAdd(NoInputMessages.対象年度の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.対象年度の必須入力, div.getShogaishaKojoNinteiJoho().getTaishoNendo()).build().check(messages));
        return pairs;
    }

    /**
     * 申請年月日の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div DBD4010011Div
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 申請年月日の必須入力(ValidationMessageControlPairs pairs, DBD4010011Div div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(ShogaishaKojoNinteiJohoDivSpec.申請年月日の未入力チェック)
                .thenAdd(NoInputMessages.申請年月日の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.申請年月日の必須入力, div.getShogaishaKojoNinteiJoho().getSinseiNengabi()).build().check(messages));
        return pairs;
    }

    /**
     * 決定年月日の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div DBD4010011Div
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 決定年月日の必須入力(ValidationMessageControlPairs pairs, DBD4010011Div div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(ShogaishaKojoNinteiJohoDivSpec.決定年月日の未入力チェック)
                .thenAdd(NoInputMessages.基準日の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.基準日の必須入力, div.getShogaishaKojoNinteiJoho().getKeteiNengabi()).build().check(messages));
        return pairs;
    }

    private static enum NoInputMessages implements IValidationMessage {

        基準日の必須入力(UrErrorMessages.必須.getMessage(), "基準日"),
        対象年度の必須入力(UrErrorMessages.必須.getMessage(), "対象年度"),
        申請年月日の必須入力(UrErrorMessages.必須.getMessage(), "申請年月日"),
        決定年月日の必須入力(UrErrorMessages.必須.getMessage(), "決定年月日");

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
