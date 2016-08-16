/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2000023;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 「発行する」ボタンを押下時の入力チェックエラーメッセージです。
 * 
 * @reamsid_L DBC-5010-012 lijian
 */
public enum RiyoshaFutanWariaiKoushiConfValidationMessage implements IValidationMessage{
    
    /**
     * 発行日が入力必要
     */
    発行日チェック(UrErrorMessages.必須項目_追加メッセージあり, "発行日"),
    /**
     * 交付日が入力必要
     */
    交付日チェック(UrErrorMessages.必須項目_追加メッセージあり, "交付日"),
    /**
     * 交付事由選択必要
     */
    交付事由チェック(UrErrorMessages.必須項目_追加メッセージあり, "交付事由");

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

    private RiyoshaFutanWariaiKoushiConfValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }
}
