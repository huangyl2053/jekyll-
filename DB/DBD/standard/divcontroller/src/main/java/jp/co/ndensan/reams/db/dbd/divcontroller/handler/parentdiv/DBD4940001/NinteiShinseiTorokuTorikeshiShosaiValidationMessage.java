/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD4940001;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 *
 * 要介護認定取消画面の入力チェックのメッセージクラスです。
 *
 * @reamsid_L DBD-2090-010 lit
 */
public enum NinteiShinseiTorokuTorikeshiShosaiValidationMessage implements IValidationMessage {

    /**
     * 異動事由が未選択チェック。
     */
    異動事由が未選択チェック(UrErrorMessages.未指定, "異動事由"),
    /**
     * 認定日が未入力。
     */
    理由が未入力チェック(UrErrorMessages.未入力, "理由"),
    /**
     * 更新チェック。
     */
    更新チェック(UrErrorMessages.実行不可, "認定申請取消");

    private final Message message;

    NinteiShinseiTorokuTorikeshiShosaiValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    NinteiShinseiTorokuTorikeshiShosaiValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
