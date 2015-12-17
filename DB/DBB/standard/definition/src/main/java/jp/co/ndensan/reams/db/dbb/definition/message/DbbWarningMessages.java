/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.message;

import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.WarningMessage;

/**
 * DBBの警告メッセージ定義列挙型です。
 *
 * @author N9606 漢那 憲作
 */
public enum DbbWarningMessages implements IMessageGettable {

    特徴期割額端数不整合(1, "特別徴収%1は、%2円未満が0ではありません。必要に応じて見直してください。"),
    普徴期割額端数不整合(2, "普通徴収%1は、%2円未満が0ではありません。必要に応じて見直してください。");

    private final Message message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private DbbWarningMessages(int no, String message) {
        this.message = new WarningMessage(toCode("DBBW", no), message);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
