/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.message;

import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.WarningMessage;
import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;

/**
 * DBDの警告メッセージ定義列挙型です。
 *
 * @author N9606 漢那 憲作
 */
public enum DbdWarningMessages implements IMessageGettable {

    社会福祉法人減免_非生活保護者_軽減率100(1, "生活保護登録者ではありませんが、軽減率１００％です。"),
    社会福祉法人減免_軽減率_特例措置期間(2, "平21.04.01から平23.03.31は特例措置期間です。軽減率を確認してください。");

    private final Message message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private DbdWarningMessages(int no, String message) {
        this.message = new WarningMessage(toCode("W", no), message);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
