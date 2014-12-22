/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.validation;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.model.validations.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 施設入退所履歴のバリデーションメッセージを定義した列挙体です。
 *
 * @author N8223　朴義一
 */
public enum ShisetsuNyutaishoValidationMessage implements IValidationMessage {

    /**
     * 入所日
     */
    入所日が未入力(DbzErrorMessages.必須項目を入力_追加メッセージあり),
    /**
     * 退所日
     */
    退所日が未入力(DbzErrorMessages.必須項目を入力_追加メッセージあり),
    /**
     * 日付の前後関係が逆転
     */
    入所年月日より前(DbzErrorMessages.入力値が不正_追加メッセージあり),
    /**
     * 退所日と次の履歴データの入所日の期間が重複
     */
    退所日と次の履歴データの入所日の期間が重複(DbzErrorMessages.入力値が不正_追加メッセージあり),
    /**
     * 入所日と前の履歴データの退所日の期間が重複
     */
    入所日と前の履歴データの退所日の期間が重複(DbzErrorMessages.入力値が不正_追加メッセージあり),
    /**
     * 入所日と期間が重複する履歴がある
     */
    入所日と期間が重複する履歴がある(DbzErrorMessages.入力値が不正_追加メッセージあり),
    /**
     * 退所日と期間が重複する履歴がある
     */
    退所日と期間が重複する履歴がある(DbzErrorMessages.入力値が不正_追加メッセージあり);

    private final Message message;

    private ShisetsuNyutaishoValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
