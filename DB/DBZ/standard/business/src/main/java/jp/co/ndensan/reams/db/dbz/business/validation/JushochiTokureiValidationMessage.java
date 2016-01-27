/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.validation;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 住所地特例異動処理で使用されるバリデーションメッセージです。
 *
 * @author n8178 城間篤人
 */
public enum JushochiTokureiValidationMessage implements IValidationMessage {

    /**
     * 住所地特例適用日が、最新履歴の取得日・変更日・住所地特例解除日より前します。
     */
    //TODO n8178 欲しいエラーがDBAのため見れない（DBAE00002）。対応を相談する。
    住所地特例適用日が_最新履歴の取得日_変更日_住所地特例解除日より前(UrErrorMessages.不正, "住所地特例適用日"),
    /**
     * 住所地特例解除日が、最新履歴の取得日・変更日・住所地特例適用日より前します。
     */
    //TODO n8178 欲しいエラーがDBAのため見れない（DBAE00002）。対応を相談する。
    住所地特例解除日が_最新履歴の取得日_変更日_住所地特例適用日より前(UrErrorMessages.不正, "住所地特例解除日"),
    /**
     * 日付の前後関係が逆転（適用日が解除日より前）します。
     */
    住特適用日が住特解除日より後(UrErrorMessages.大小関係が不正, "解除日　ー　適用日"),
    /**
     * 日付の前後関係が逆転（適用日が取得日より前）します。
     */
    住特適用日が資格取得日より前(UrErrorMessages.大小関係が不正, "適用日　－　取得日"),
    /**
     * 日付の前後関係が逆転（変更日が喪失日より後）します。
     */
    住特適用日が資格喪失日以降(UrErrorMessages.大小関係が不正, "適用日　ー　喪失日"),
    /**
     * 日付の前後関係が逆転（適用日が取得日より前）します。
     */
    住特解除日が資格取得日より前(UrErrorMessages.大小関係が不正, "解除日　－　取得日"),
    /**
     * 日付の前後関係が逆転（変更日が喪失日より後）します。
     */
    住特解除日が資格喪失日以降(UrErrorMessages.大小関係が不正, "解除日　ー　喪失日"),
    /**
     * 住所地特例期間に重複があるします。
     */
    住所地特例期間に重複がある(UrErrorMessages.期間が重複),
    /**
     * 住所地特例期間と他市町村住所地特例期間が重複する履歴があるします。
     */
    住所地特例期間と他市町村住所地特例期間が重複する履歴がある(UrErrorMessages.期間が重複),
    /**
     * 住所地特例期間と適用除外期間が重複する履歴があるします。
     */
    住所地特例期間と適用除外期間が重複する履歴がある(UrErrorMessages.期間が重複),
    /**
     * 住所地特例期間が不正になっている（適用日が解除日の後日になっている）します。
     */
    住所地特例期間が不正_適用日が解除日の後(UrErrorMessages.期間が不正_追加メッセージあり２, "適用日", "解除日");

    private final Message message;

    private JushochiTokureiValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }

}
