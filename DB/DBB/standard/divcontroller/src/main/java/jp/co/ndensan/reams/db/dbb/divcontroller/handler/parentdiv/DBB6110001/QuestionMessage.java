/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB6110001;

import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * DBBのインフォメーションメッセージ定義列挙型です。
 *
 * @reamsid_L DBB-1640-010 jiangzongyue
 */
public enum QuestionMessage implements IMessageGettable {

    /**
     * 同一世帯コード.
     */
    同一世帯コード(3, "対象者は被保険者と世帯コードが異なります。よろしいですか？"),
    /**
     * 連帯納付義務者の住民種別.
     */
    連帯納付義務者の住民種別(4, "対象者は住民ではありません。よろしいですか？");

    private final Message message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private QuestionMessage(int no, String message) {
        this.message = new jp.co.ndensan.reams.uz.uza.message.QuestionMessage(toCode("DBBQ", no), message);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
