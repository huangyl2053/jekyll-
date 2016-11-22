/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7160001;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 汎用リスト出力(高額合算計算結果連絡票情報)のバリデーションです。
 *
 * @reamsid_L DBC-3100-010 zhengshenlei
 */
public enum HanyoListkougakugasSannKeiSuukekkaValidationMessage implements IValidationMessage {

    /**
     * 出力順未指定チェック
     */
    出力順未指定チェック(UrErrorMessages.出力順序を指定);

    private final Message message;

    private HanyoListkougakugasSannKeiSuukekkaValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    private HanyoListkougakugasSannKeiSuukekkaValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    /**
     * メッセージを取得します。
     *
     * @return メッセージ
     */
    @Override
    public Message getMessage() {
        return message;
    }
}
