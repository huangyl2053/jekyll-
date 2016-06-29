/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.message;

import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.WarningMessage;
import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;

/**
 * DBUの警告メッセージ定義列挙型です。
 *
 * @reamsid_L DBB-9999-023 wangchao
 */
public enum DbuWarningMessages implements IMessageGettable {

    年報集計を再処理(1, "指定した報告年月の年報集計は既に行われています。処理を継続する場合には、年報集計を再処理して下さい。 ");

    private final Message message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private DbuWarningMessages(int no, String message) {
        this.message = new WarningMessage(toCode("DBUW", no), message);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
