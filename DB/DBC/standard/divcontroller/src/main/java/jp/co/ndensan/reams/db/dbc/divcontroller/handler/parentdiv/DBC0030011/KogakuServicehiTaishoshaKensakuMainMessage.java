/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0030011;

import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 「該当者を検索する」ボタンを押下時の入力チェックエラーメッセージです。
 *
 * @reamsid_L DBC-3000-010 gongliang
 */
public enum KogakuServicehiTaishoshaKensakuMainMessage implements IValidationMessage {

    /**
     * 被保番号、提供年月、申請年月、決定年月の最小限に一つが入力必要
     */
    被保険者を指定入力チェック(DbzErrorMessages.最低限の入力なし, "被保険者番号、提供年月、申請年月、決定年月"),
    /**
     * 提供年月、申請年月、決定年月の最小限に一つが入力必要
     */
    年月を指定入力チェック(DbzErrorMessages.最低限の入力なし, "提供年月、申請年月、決定年月");

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

    private KogakuServicehiTaishoshaKensakuMainMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }
}
