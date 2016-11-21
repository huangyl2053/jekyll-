/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820031;

import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 償還払い費支給申請決定_サービス提供証明書(社福軽減額）のエラーメッセージクラスです。
 *
 * @reamsid_L DBC-1030-080 huangyang
 */
public class ShafukuKeigenGakuPanelErrorMessage implements IValidationMessage {

    private final Message message;

    /**
     * コンストラクス。
     *
     * @param message Message
     */
    public ShafukuKeigenGakuPanelErrorMessage(Message message) {
        this.message = message;
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
