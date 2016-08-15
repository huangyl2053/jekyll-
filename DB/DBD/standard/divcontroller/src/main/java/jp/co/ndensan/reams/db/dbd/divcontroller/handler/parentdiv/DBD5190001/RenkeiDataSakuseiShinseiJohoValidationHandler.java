/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5190001;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5190001.RenkeiDataSakuseiShinseiJohoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5190001.RenkeiDataSakuseiShinseiJohoDivSpec;
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
 * 要介護認定申請連携データ作成画面ののバリデーションハンドラークラスです。
 *
 * @reamsid_L DBD-1480-010 zhuxiaojun
 */
public class RenkeiDataSakuseiShinseiJohoValidationHandler {

    /**
     * 今回開始時間の非空チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div RenkeiDataSakuseiShinseiJohoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor今回開始時間の非空チェック(ValidationMessageControlPairs pairs, RenkeiDataSakuseiShinseiJohoDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(RenkeiDataSakuseiShinseiJohoDivSpec.今回開始時間の非空チェック)
                .thenAdd(NoInputMessages.今回開始日時の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.今回開始日時の必須入力, div).build().check(messages));
        return pairs;
    }

    /**
     * 今回終了時間の非空チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div RenkeiDataSakuseiShinseiJohoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor今回終了時間の非空チェック(ValidationMessageControlPairs pairs, RenkeiDataSakuseiShinseiJohoDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(RenkeiDataSakuseiShinseiJohoDivSpec.今回終了時間の非空チェック)
                .thenAdd(NoInputMessages.今回終了日時の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.今回終了日時の必須入力, div).build().check(messages));
        return pairs;
    }

    /**
     * 保険者の非空チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div RenkeiDataSakuseiShinseiJohoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor保険者の非空チェック(ValidationMessageControlPairs pairs, RenkeiDataSakuseiShinseiJohoDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(RenkeiDataSakuseiShinseiJohoDivSpec.保険者の非空チェック)
                .thenAdd(NoInputMessages.保険者の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.保険者の必須入力, div).build().check(messages));
        return pairs;
    }

    /**
     * 対象期間時間チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div RenkeiDataSakuseiShinseiJohoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor対象期間時間チェック(ValidationMessageControlPairs pairs, RenkeiDataSakuseiShinseiJohoDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(RenkeiDataSakuseiShinseiJohoDivSpec.対象期間時間チェック)
                .thenAdd(NoInputMessages.時間の入力は間違いです).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.時間の入力は間違いです, div).build().check(messages));
        return pairs;
    }

    /**
     * 被保険者番号の非空チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div RenkeiDataSakuseiShinseiJohoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor被保険者番号の非空チェック(ValidationMessageControlPairs pairs, RenkeiDataSakuseiShinseiJohoDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(RenkeiDataSakuseiShinseiJohoDivSpec.被保険者番号の非空チェック)
                .thenAdd(NoInputMessages.被保険者番号の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.被保険者番号の必須入力, div).build().check(messages));
        return pairs;
    }

    /**
     * 対象者一覧選択チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div RenkeiDataSakuseiShinseiJohoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor対象者一覧選択チェック(ValidationMessageControlPairs pairs, RenkeiDataSakuseiShinseiJohoDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(RenkeiDataSakuseiShinseiJohoDivSpec.対象者一覧選択チェック)
                .thenAdd(NoInputMessages.対象者を選択).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.対象者を選択, div).build().check(messages));
        return pairs;
    }

    /**
     * 最大件数のチェック。
     *
     * @param pairs バリデーションコントロール
     * @param div RenkeiDataSakuseiShinseiJohoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor最大件数チェック(ValidationMessageControlPairs pairs, RenkeiDataSakuseiShinseiJohoDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(RenkeiDataSakuseiShinseiJohoDivSpec.最大件数のチェック)
                .thenAdd(NoInputMessages.最大件数の規則).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.最大件数の規則, div).build().check(messages));
        return pairs;
    }

    /**
     * 最大件数のチェック。
     *
     * @param pairs バリデーションコントロール
     * @param div RenkeiDataSakuseiShinseiJohoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateForデータない(ValidationMessageControlPairs pairs, RenkeiDataSakuseiShinseiJohoDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(RenkeiDataSakuseiShinseiJohoDivSpec.データない)
                .thenAdd(NoInputMessages.データ検索).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.データ検索, div).build().check(messages));
        return pairs;
    }

    private static enum NoInputMessages implements IValidationMessage {

        保険者の必須入力(UrErrorMessages.必須, "保険者"),
        今回開始日時の必須入力(UrErrorMessages.不正, "今回開始日時"),
        今回終了日時の必須入力(UrErrorMessages.不正, "今回終了日時"),
        時間の入力は間違いです(UrErrorMessages.終了日が開始日以前),
        被保険者番号の必須入力(UrErrorMessages.必須, "被保険者番号"),
        対象者を選択(UrErrorMessages.対象者を選択),
        最大件数の規則(UrErrorMessages.不正, "最大件数"),
        データ検索(UrErrorMessages.該当データなし);

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
