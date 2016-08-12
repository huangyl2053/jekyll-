/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5810001;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5810001.JissiJyokyohyoDiv;
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
 * 要介護認定実施状況表（統計表）画面ののバリデーションハンドラークラスです。
 *
 * @reamsid_L DBD-1771-010 chenxin
 */
public class JissiJyokyohyoValidationHandler {

    /**
     * 行政区大小関係チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div JissiJyokyohyoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor行政区大小関係チェック(ValidationMessageControlPairs pairs, JissiJyokyohyoDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(JissiJyokyohyoSpec.行政区大小関係チェック)
                .thenAdd(NoInputMessages.行政区大小関係チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.行政区大小関係チェック,
                div.getJokenPanel()).build().check(messages));
        return pairs;

    }

    /**
     * 地区２大小関係チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div JissiJyokyohyoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor地区２大小関係チェック(ValidationMessageControlPairs pairs, JissiJyokyohyoDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(JissiJyokyohyoSpec.地区２大小関係チェック)
                .thenAdd(NoInputMessages.地区大小関係チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.地区大小関係チェック,
                div.getJokenPanel()).build().check(messages));
        return pairs;

    }

    /**
     * 住所大小関係チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div JissiJyokyohyoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor住所大小関係チェック(ValidationMessageControlPairs pairs, JissiJyokyohyoDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(JissiJyokyohyoSpec.住所大小関係チェック)
                .thenAdd(NoInputMessages.住所大小関係チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.住所大小関係チェック,
                div.getJokenPanel()).build().check(messages));
        return pairs;

    }

    /**
     * 年齢の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div JissiJyokyohyoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor年齢の未入力チェック(ValidationMessageControlPairs pairs, JissiJyokyohyoDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(JissiJyokyohyoSpec.年齢の未入力チェック)
                .thenAdd(NoInputMessages.年齢の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.年齢の必須入力,
                div.getJokenPanel().getTxtNenrei(), div.getJokenPanel().getTxtNenreikijyun()).build().check(messages));
        return pairs;

    }

    /**
     * 生年月日の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div JissiJyokyohyoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor生年月日の未入力チェック(ValidationMessageControlPairs pairs, JissiJyokyohyoDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(JissiJyokyohyoSpec.生年月日の未入力チェック)
                .thenAdd(NoInputMessages.生年月日の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.生年月日の必須入力,
                div.getJokenPanel().getTxtSeinen()).build().check(messages));
        return pairs;

    }

    private static enum NoInputMessages implements IValidationMessage {

        行政区大小関係チェック(UrErrorMessages.大小関係が不正, "行政区"),
        地区大小関係チェック(UrErrorMessages.大小関係が不正, "地区"),
        住所大小関係チェック(UrErrorMessages.大小関係が不正, "住所"),
        年齢の必須入力(UrErrorMessages.必須, "年齢"),
        生年月日の必須入力(UrErrorMessages.必須, "生年月日");

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
