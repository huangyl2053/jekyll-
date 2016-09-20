/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0330011;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 *
 * @author Administrator
 */
public enum DvKogakuServiceJuryoIninValidationMessages implements IValidationMessage {

    /**
     * 承認しない理由チェック
     */
    承認しない理由必須(UrErrorMessages.必須, "承認しない理由"),
    /**
     * 利用者負担上限額チェック
     */
    利用者負担上限額必須(UrErrorMessages.必須, "利用者負担上限額"),
    /**
     * 文書番号チェック
     */
    文書番号必須(UrErrorMessages.必須, "文書番号"),
    /**
     * 文書番号チェック
     */
    承認終了日の入力値が不正(UrErrorMessages.入力値が不正_追加メッセージあり, "日付の指定に誤りがあります。[承認期間]");

    private final Message message;

    /**
     * エラーメッセージを取得する。
     *
     * @return エラーメッセージ
     */
    @Override
    public Message getMessage() {
        return message;
    }

    private DvKogakuServiceJuryoIninValidationMessages(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }
}
