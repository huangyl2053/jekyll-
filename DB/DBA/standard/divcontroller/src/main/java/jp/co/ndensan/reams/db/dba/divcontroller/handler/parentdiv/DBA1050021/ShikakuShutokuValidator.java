/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1050021;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1050021.HihokenshaShisakuPanalDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 資格詳細画面の資格取得情報の入力を検査します
 *
 * @author n8178
 */
class ShikakuShutokuValidator implements IValidatable {

    private final HihokenshaShisakuPanalDiv div;

    public ShikakuShutokuValidator(HihokenshaShisakuPanalDiv div) {
        this.div = div;
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(ShikakuShutokuSpec.資格取得日が入力されている)
                .thenAdd(ShikakuShutokuValidationMessage.資格取得日未入力)
                .messages());

        messages.add(ValidateChain.validateStart(div)
                .ifNot(ShikakuShutokuSpec.資格取得届出日が入力されている)
                .thenAdd(ShikakuShutokuValidationMessage.資格取得届出日未入力)
                .messages());

        messages.add(ValidateChain.validateStart(div)
                .ifNot(ShikakuShutokuSpec.資格取得事由が入力されている)
                .thenAdd(ShikakuShutokuValidationMessage.資格取得事由未入力)
                .messages());

        messages.add(ValidateChain.validateStart(div)
                .ifNot(ShikakuShutokuSpec.被保険者区分が入力されている)
                .thenAdd(ShikakuShutokuValidationMessage.被保険者区分未入力)
                .messages());

        if (!div.getDdlShutokuShozaiHokensha().isDisplayNone()) {
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(ShikakuShutokuSpec.所在保険者が入力されている)
                    .thenAdd(ShikakuShutokuValidationMessage.所在保険者未入力)
                    .messages());
        }

        if (!div.getDdlShutokuSochimotoHokensha().isDisplayNone()) {
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(ShikakuShutokuSpec.措置元保険者が入力されている)
                    .thenAdd(ShikakuShutokuValidationMessage.措置元保険者未入力)
                    .messages());
        }

        if (!div.getDdlShutokuKyuHokensha().isDisplayNone()) {
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(ShikakuShutokuSpec.旧保険者が入力されている)
                    .thenAdd(ShikakuShutokuValidationMessage.旧保険者未入力)
                    .messages());
        }
        return messages;
    }

    /**
     * 資格取得情報入力検査の際に表示されるバリデーションメッセージです。
     */
    enum ShikakuShutokuValidationMessage implements IValidationMessage {

        資格取得日未入力(UrErrorMessages.必須, "資格取得日"),
        資格取得届出日未入力(UrErrorMessages.必須, "資格取得届出日"),
        資格取得事由未入力(UrErrorMessages.必須, "資格取得事由"),
        被保険者区分未入力(UrErrorMessages.必須, "被保険者区分"),
        所在保険者未入力(UrErrorMessages.必須, "所在保険者"),
        措置元保険者未入力(UrErrorMessages.必須, "措置元保険者"),
        旧保険者未入力(UrErrorMessages.必須, "旧保険者");
        private final Message message;

        private ShikakuShutokuValidationMessage(IMessageGettable message, String... replace) {
            this.message = message.getMessage().replace(replace);
        }

        @Override
        public Message getMessage() {
            return message;
        }

    }

}
