/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.message;

import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * DBZのインフォメーションメッセージ定義列挙型です。
 *
 * @author N9606 漢那 憲作
 */
public enum DbzInformationMessages implements IMessageGettable {

    // TODO 一つ目の要素が定義されたらこの要素は削除する。
    更新終了(4, "更新は正常に終了しました。"),
    削除終了(5, "削除は正常に終了しました。");

    private final Message message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private DbzInformationMessages(int no, String message) {
        this.message = new InformationMessage(toCode("I", no), message);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
