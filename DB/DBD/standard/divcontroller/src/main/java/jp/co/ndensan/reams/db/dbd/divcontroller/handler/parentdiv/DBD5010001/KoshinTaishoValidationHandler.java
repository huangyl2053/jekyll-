/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5010001;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5010001.KoshinTaishoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5010001.KoshinTaishoDivSpec;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBD5010001_完了処理・更新管理のバリデーションハンドラークラスです。
 *
 * @author_L DBD-2030-010 x_youyj
 */
public class KoshinTaishoValidationHandler {

    /**
     * 更新管理完了対象者一覧データの存在チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div KoshinTaishoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 更新管理完了対象者一覧データの存在チェック(
            ValidationMessageControlPairs pairs, KoshinTaishoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(KoshinTaishoDivSpec.更新管理完了対象者一覧データの存在チェック)
                .thenAdd(NoInputMessages.存在チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.存在チェック, div).build().check(messages));
        return pairs;
    }

    /**
     * 更新管理完了対象者一覧データの行選択チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div KoshinTaishoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 更新管理完了対象者一覧データの行選択チェック(
            ValidationMessageControlPairs pairs, KoshinTaishoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(KoshinTaishoDivSpec.更新管理完了対象者一覧データの行選択チェック)
                .thenAdd(NoInputMessages.行選択チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.行選択チェック, div).build().check(messages));
        return pairs;
    }

    /**
     * 更新管理完了対象者一覧選択行の完了処理事前チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div KoshinTaishoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 更新管理完了対象者一覧選択行の完了処理事前チェック(
            ValidationMessageControlPairs pairs, KoshinTaishoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(KoshinTaishoDivSpec.更新管理完了対象者一覧選択行の完了処理事前チェック)
                .thenAdd(NoInputMessages.完了処理事前チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.完了処理事前チェック, div).build().check(messages));
        return pairs;
    }

    private static enum NoInputMessages implements IValidationMessage {

        存在チェック(UrErrorMessages.該当データなし.getMessage()),
        行選択チェック(UrErrorMessages.対象行を選択.getMessage()),
        完了処理事前チェック(UrErrorMessages.更新不可_汎用.getMessage(), "通知年月日が未設定");
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
