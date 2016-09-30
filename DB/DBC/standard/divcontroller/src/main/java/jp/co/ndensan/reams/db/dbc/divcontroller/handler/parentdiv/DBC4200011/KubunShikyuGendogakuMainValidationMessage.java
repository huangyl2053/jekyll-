/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4200011;

import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 入力チェックエラーメッセージです。
 *
 * @reamsid_L DBC-3410-010 jianglaisheng
 */
public enum KubunShikyuGendogakuMainValidationMessage implements IValidationMessage {

    /**
     * 適用年月_重複_開始年月不正
     */
    適用年月_重複_開始年月不正(DbcErrorMessages.適用期間_重複_開始年月不正),
    /**
     * 適用期間_標準額と不一致
     */
    適用期間_標準額と不一致(DbcErrorMessages.適用期間_標準額と不一致);

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

    private KubunShikyuGendogakuMainValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }
}
