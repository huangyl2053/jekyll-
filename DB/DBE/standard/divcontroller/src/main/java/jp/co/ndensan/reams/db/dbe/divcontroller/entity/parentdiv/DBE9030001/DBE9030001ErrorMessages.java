/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9030001;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 *
 * @author liangbc
 */
public enum DBE9030001ErrorMessages implements IMessageGettable, IValidationMessage {

    対象データなし(UrErrorMessages.対象データなし.getMessage()),
    編集なしで更新不可(UrErrorMessages.編集なしで更新不可.getMessage()),
    入力値が不正_追加メッセージあり(UrErrorMessages.入力値が不正_追加メッセージあり.getMessage().replace("市町村コード")),
    既に登録済(UrErrorMessages.既に登録済.getMessage());
    private final Message message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private DBE9030001ErrorMessages(Message message) {
        this.message = new ErrorMessage(message.getCode(), message.evaluate());
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
