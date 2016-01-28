/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.validation;

import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 施設入退所履歴のバリデーションメッセージを定義した列挙体です。
 *
 * @author N8223　朴義一
 */
public enum ShisetsuNyutaishoValidationMessage implements IValidationMessage {

    /**
     * 終了日（退所日）なし
     */
    終了日設定なし(_Message.終了日設定なし),
    /**
     * 入所日
     */
    入所日が未入力(_Message.入所日が未入力),
    /**
     * 入所施設コード
     */
    入所施設コードが未入力(_Message.入所施設コードが未入力),
    /**
     * 入所施設
     */
    入所施設名称が未入力(_Message.入所施設名称が未入力),
    /**
     * 日付の前後関係が逆転
     */
    入所年月日より前(_Message.入所年月日より前),
    /**
     * 退所日と次の履歴データの入所日の期間が重複
     */
    退所日と次の履歴データの入所日の期間が重複(_Message.退所日と次の履歴データの入所日の期間が重複),
    /**
     * 入所日と前の履歴データの退所日の期間が重複
     */
    入所日と前の履歴データの退所日の期間が重複(_Message.入所日と前の履歴データの退所日の期間が重複),
    /**
     * 入所日と期間が重複する履歴がある
     */
    入所日と期間が重複する履歴がある(_Message.入所日と期間が重複する履歴がある),
    /**
     * 退所日と期間が重複する履歴がある
     */
    退所日と期間が重複する履歴がある(_Message.退所日と期間が重複する履歴がある);

    private final Message message;

    private ShisetsuNyutaishoValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    @Override
    public Message getMessage() {
        return message;
    }

    private enum _Message implements IMessageGettable {

        /**
         * 終了日（退所日）なし
         */
        終了日設定なし(DbzErrorMessages.入力値が不正_追加メッセージあり.getMessage().replace("前履歴の退所日が未設定")),
        /**
         * 入所日
         */
        入所日が未入力(DbzErrorMessages.必須項目を入力_追加メッセージあり.getMessage().replace("入所日")),
        /**
         * 入所施設
         */
        入所施設コードが未入力(DbzErrorMessages.必須項目を入力_追加メッセージあり.getMessage().replace("入所施設情報コード")),
        /**
         * 入所施設
         */
        入所施設名称が未入力(DbzErrorMessages.必須項目を入力_追加メッセージあり.getMessage().replace("入所施設情報名称")),
        /**
         * 日付の前後関係が逆転
         */
        入所年月日より前(DbzErrorMessages.入力値が不正_追加メッセージあり.getMessage().replace("入所年月日よりも前")),
        /**
         * 退所日と次の履歴データの入所日の期間が重複
         */
        退所日と次の履歴データの入所日の期間が重複(DbzErrorMessages.入力値が不正_追加メッセージあり.getMessage().replace("入退所期間が重複")), //NOPMD Enumでチェックする必要性がないためチェックしない
        /**
         * 入所日と前の履歴データの退所日の期間が重複
         */
        入所日と前の履歴データの退所日の期間が重複(DbzErrorMessages.入力値が不正_追加メッセージあり.getMessage().replace("入退所期間が重複")), //NOPMD Enumでチェックする必要性がないためチェックしない
        /**
         * 入所日と期間が重複する履歴がある
         */
        入所日と期間が重複する履歴がある(DbzErrorMessages.入力値が不正_追加メッセージあり.getMessage().replace("入退所期間が重複")), //NOPMD Enumでチェックする必要性がないためチェックしない
        /**
         * 退所日と期間が重複する履歴がある
         */
        退所日と期間が重複する履歴がある(DbzErrorMessages.入力値が不正_追加メッセージあり.getMessage().replace("入退所期間が重複")); //NOPMD Enumでチェックする必要性がないためチェックしない

        private Message message;

        private _Message(Message message) {
            this.message = message;
        }

        @Override
        public Message getMessage() {
            return message;
        }

        /**
         * @param message the message to set
         */
        public void setMessage(Message message) {
            this.message = message;
        }
    }
}
