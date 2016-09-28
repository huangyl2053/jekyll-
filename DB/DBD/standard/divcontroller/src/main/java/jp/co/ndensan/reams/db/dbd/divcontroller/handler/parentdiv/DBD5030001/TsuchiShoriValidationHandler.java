/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5030001;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5030001.TsuchiShoriDiv;
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
 * 完了処理・通知書発行画面ののバリデーションハンドラークラスです。
 *
 * @reamsid_L DBD-2040-010 chenxin
 */
public class TsuchiShoriValidationHandler {

    /**
     * 通知書発行対象者一覧データの存在チェックを行います。
     *
     * @param pairs ValidationMessageControlPairs
     * @param div TsuchiShoriDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor通知書発行対象者一覧データの存在チェック(ValidationMessageControlPairs pairs, TsuchiShoriDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(TsuchiShoriSpec.通知書発行対象者一覧データの存在チェック)
                .thenAdd(NoInputMessages.通知書発行対象者一覧データの存在チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.通知書発行対象者一覧データの存在チェック,
                div.getDgtsuchishohakko()).build().check(messages));
        return pairs;
    }

    /**
     * 通知書発行対象者一覧データの行選択チェックを行います。
     *
     * @param pairs ValidationMessageControlPairs
     * @param div TsuchiShoriDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor通知書発行対象者一覧データの行選択チェック(ValidationMessageControlPairs pairs, TsuchiShoriDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(TsuchiShoriSpec.通知書発行対象者一覧データの行選択チェック)
                .thenAdd(NoInputMessages.通知書発行対象者一覧データの行選択チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.通知書発行対象者一覧データの行選択チェック,
                div.getDgtsuchishohakko()).build().check(messages));
        return pairs;
    }

    /**
     * 通知書発行対象者一覧選択行の完了処理事前チェックを行います。
     *
     * @param pairs ValidationMessageControlPairs
     * @param div TsuchiShoriDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor通知書発行対象者一覧選択行の完了処理事前チェック(ValidationMessageControlPairs pairs, TsuchiShoriDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(TsuchiShoriSpec.通知書発行対象者一覧選択行の完了処理事前チェック)
                .thenAdd(NoInputMessages.通知書発行対象者一覧選択行の完了処理事前チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.通知書発行対象者一覧選択行の完了処理事前チェック,
                div.getDgtsuchishohakko()).build().check(messages));
        return pairs;
    }

    private static enum NoInputMessages implements IValidationMessage {

        通知書発行対象者一覧データの存在チェック(UrErrorMessages.該当データなし),
        通知書発行対象者一覧データの行選択チェック(UrErrorMessages.対象行を選択),
        通知書発行対象者一覧選択行の完了処理事前チェック(UrErrorMessages.更新不可_汎用, "通知書発行日が未設定");

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
