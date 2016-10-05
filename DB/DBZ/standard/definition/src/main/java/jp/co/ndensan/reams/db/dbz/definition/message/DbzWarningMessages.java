/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.message;

import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.WarningMessage;
import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;

/**
 * DBZの警告メッセージ定義列挙型です。
 *
 * @reamsid_L DBZ-9999-023 liangbc
 */
public enum DbzWarningMessages implements IMessageGettable {

    確認(1, "?よろしいですか？"),
    文字切れ発行確認(2, "以下の項目で文字が切れています。発行してもよろしいですか？<br> %1");

    private final Message message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private DbzWarningMessages(int no, String message) {
        this.message = new WarningMessage(toCode("DBZW", no), message);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
