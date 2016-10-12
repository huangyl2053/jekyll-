/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1050021;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1050021.HihokenshaShisakuPanalDiv;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 資格詳細画面の資格喪失情報の入力を検査します。
 *
 * @author n8178
 */
class ShikakuSoshitsuValidator implements IValidatable {

    private HihokenshaShisakuPanalDiv div;

    public ShikakuSoshitsuValidator(HihokenshaShisakuPanalDiv div) {
        this.div = div;
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();

        if (ShikakuSoshitsuSpec.喪失情報が全て入力されていない.apply(div)) {
            return messages;
        }

        messages.add(ValidateChain.validateStart(div)
                .ifNot(ShikakuSoshitsuSpec.資格喪失日が入力されている)
                .thenAdd(ShikakuSoshitsuValidationMessage.資格喪失日未入力)
                .messages());

        messages.add(ValidateChain.validateStart(div)
                .ifNot(ShikakuSoshitsuSpec.入力された取得日と喪失日の関係性が正しい)
                .thenAdd(ShikakuSoshitsuValidationMessage.資格得喪日不整合)
                .messages());

        messages.add(ValidateChain.validateStart(div)
                .ifNot(ShikakuSoshitsuSpec.資格喪失届出日が入力されている)
                .thenAdd(ShikakuSoshitsuValidationMessage.資格喪失届出日未入力)
                .messages());

        messages.add(ValidateChain.validateStart(div)
                .ifNot(ShikakuSoshitsuSpec.資格喪失事由が入力されている)
                .thenAdd(ShikakuSoshitsuValidationMessage.資格喪失事由未入力)
                .messages());

        return messages;
    }

    /**
     * 資格喪失情報入力検査の際に表示されるバリデーションメッセージです。
     */
    enum ShikakuSoshitsuValidationMessage implements IValidationMessage {

        資格喪失日未入力(UrErrorMessages.必須, "資格喪失日"),
        資格喪失届出日未入力(UrErrorMessages.必須, "資格喪失届出日"),
        資格喪失事由未入力(UrErrorMessages.必須, "資格喪失事由"),
        資格得喪日不整合(DbzErrorMessages.期間が不正_過去日付不可, "資格喪失日", "資格取得日");
        private final Message message;

        private ShikakuSoshitsuValidationMessage(IMessageGettable message, String... replace) {
            this.message = message.getMessage().replace(replace);
        }

        @Override
        public Message getMessage() {
            return message;
        }

    }

}
