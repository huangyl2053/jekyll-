/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD6010001;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * システム管理登録（認定結果通知書文言変更）画面の入力チェックのメッセージクラスです。
 *
 * @reamsid_L DBD-3760-010 tz_chengpeng
 */
public enum SystemKanriNinteiKekkaTotalValidationMessage implements IValidationMessage {

    /**
     * 更新対象のデータがない。 メッセージ：「いずれの項目も変更されていません。」
     */
    更新対象のデータがない(UrErrorMessages.更新対象のデータがない);

    private final Message message;

    SystemKanriNinteiKekkaTotalValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    SystemKanriNinteiKekkaTotalValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
