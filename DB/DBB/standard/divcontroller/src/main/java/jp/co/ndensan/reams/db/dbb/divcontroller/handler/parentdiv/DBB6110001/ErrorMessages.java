/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB6110001;

import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * DBBのインフォメーションメッセージ定義列挙型です。
 *
 * @reamsid_L DBB-1640-010 jiangzongyue
 */
public enum ErrorMessages implements IMessageGettable {

    /**
     * 連帯納付義務者として登録.
     */
    連帯納付義務者として登録(1, "被保険者本人を連帯納付義務者として登録することはできません。");
    private final Message message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private ErrorMessages(int no, String message) {
        this.message = new ErrorMessage(toCode("DBBE", no), message);
    }

    @Override
    public Message getMessage() {
        return this.message;
    }
}
