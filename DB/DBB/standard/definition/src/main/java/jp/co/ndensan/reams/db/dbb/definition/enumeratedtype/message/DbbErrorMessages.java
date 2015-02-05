/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.enumeratedtype.message;

import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.Message;
import static jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.message.MessageCreateHelper.toCode;

/**
 * DBBのエラーメッセージ定義列挙型です。
 *
 * @author N9606 漢那 憲作
 */
public enum DbbErrorMessages implements IMessageGettable {

    比較対象データなし(1, "比較対象のデータがありません。");

    private final int no;
    private final String message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private DbbErrorMessages(int no, String message) {
        this.no = no;
        this.message = message;
    }

    @Override
    public Message getMessage() {
        return new ErrorMessage(toCode("E", no), message);
    }
}
