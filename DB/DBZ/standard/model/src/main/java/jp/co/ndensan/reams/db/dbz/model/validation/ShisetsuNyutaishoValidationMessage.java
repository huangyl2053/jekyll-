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
     * 日付の前後関係が逆転
     */
    日付の前後関係逆転(DbzErrorMessages.入力値が不正_追加メッセージあり),
    /**
     * 退所日と次の履歴データの入所日の期間が重複
     */
    退所日と次の履歴データの入所日の期間が重複(DbzErrorMessages.期間が重複),
    /**
     * 入所日と前の履歴データの退所日の期間が重複
     */
    入所日と前の履歴データの退所日の期間が重複(DbzErrorMessages.期間が重複);

    private final Message message;

    private ShisetsuNyutaishoValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
