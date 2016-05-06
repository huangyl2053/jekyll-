/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.message;

import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * DBCのインフォメーションメッセージ定義列挙型です。
 *
 * @reamsid_L DBB-9999-013 wangchao
 */
public enum DbcInformationMessages implements IMessageGettable {

    限度額チェック前(1, "画面のデータを変更するため、限度額をチェックしてください。");

    private final Message message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private DbcInformationMessages(int no, String message) {
        this.message = new InformationMessage(toCode("I", no), message);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
