/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.commonchilddiv.ShotokuJokyo;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShotokuJokyo.ShotokuJokyoDiv;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionary;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBC_ShotokuJokyo_所得状況のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBC-4620-030 zhouchuanlin
 */
public class ShotokuJokyoValidationHandler {

    private final ShotokuJokyoDiv div;
    private static final RString 追加メッセージ = new RString("基準日時点に64歳以下の住民が選択されています。そ");

    /**
     * コンストラクタです。
     *
     * @param div ShotokuJokyoDiv
     */
    public ShotokuJokyoValidationHandler(ShotokuJokyoDiv div) {
        this.div = div;
    }

    /**
     * 確定ボタンを押下するとき、バリデーションチェックを行う。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate() {
        IValidationMessages messages = new ControlValidator(div).validate();
        return createDictionary().check(messages);
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(ShotokuJokyoValidationMessages.選択した行のチェック,
                        div.getDgSteaiinShotoku())
                .build();
    }

    private static class ControlValidator {

        private final ShotokuJokyoDiv div;

        public ControlValidator(ShotokuJokyoDiv div) {
            this.div = div;
        }

        /**
         * 確定ボタンを押下するとき、バリデーションチェックを行う。
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages validate() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(ShotokuJokyoSpec.選択した行のチェック)
                    .thenAdd(ShotokuJokyoValidationMessages.選択した行のチェック)
                    .messages());
            return messages;
        }
    }

    private static enum ShotokuJokyoValidationMessages implements IValidationMessage {

        選択した行のチェック(DbzErrorMessages.理由付き確定不可, 追加メッセージ.toString());
        private final Message message;

        ShotokuJokyoValidationMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
