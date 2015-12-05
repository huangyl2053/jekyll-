/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.message;

import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * DBEのインフォメーションメッセージ定義列挙型です。
 *
 * @author N9606 漢那 憲作
 */
public enum DbeInformationMessages implements IMessageGettable {

    割付申請者人数が最大割付可能人数を超過(1, "割付申請者人数が最大割付可能人数を超えています。"),
    審査会自動割付できない申請者(2, "審査会自動割付できない申請者がいます。");

    private final Message message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private DbeInformationMessages(int no, String message) {
        this.message = new InformationMessage(toCode("DBEI", no), message);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
