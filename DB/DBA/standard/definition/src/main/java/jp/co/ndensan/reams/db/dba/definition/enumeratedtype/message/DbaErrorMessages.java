/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.enumeratedtype.message;

import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.Message;
import static jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.message.MessageCreateHelper.toCode;

/**
 * DBAのエラーメッセージ定義列挙型です。
 *
 * @author N9606 漢那 憲作
 */
public enum DbaErrorMessages implements IMessageGettable {

    住所地特例適用対象者でない(4, "住所地特例の適用対象者ではありません。"),
    住所地特例として適用済(5, "住所地特例として適用されています。"),
    住所地特例として未適用(6, "住所地特例として適用されていません。");

    private final Message message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private DbaErrorMessages(int no, String message) {
        this.message = new ErrorMessage(toCode("E", no), message);
    }

    @Override
    public Message getMessage() {
        return message;
    }

}
