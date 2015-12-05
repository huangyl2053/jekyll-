/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.message;

import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.WarningMessage;

/**
 * DBEの警告メッセージ定義列挙型です。
 *
 * @author N9606 漢那 憲作
 */
public enum DbeWarningMessages implements IMessageGettable {

    申請者と介護認定審査会委員に関係(1, "申請者と介護認定審査会委員に関係がありますが、よろしいですか？"),
    既に開催結果が登録されています上書き確認(2, "既に開催結果が登録されています。上書きしますか？"),
    既に基本調査値が存在します上書き確認(3, "既に基本調査値が存在します。上書きしますか？"),
    実施場所は自宅内概況調査場所が施設(4, "実施場所は”自宅内”ですが、概況調査場所が”施設”です。よろしいですか？"),
    実施場所は自宅外概況調査場所が在宅(5, "実施場所は”自宅外”ですが、概況調査場所が”在宅”です。よろしいですか？"),
    概況調査場所は施設実施場所が自宅内(6, "概況調査場所は”施設”ですが、実施場所が”自宅内”です。よろしいですか？"),
    概況調査場所は在宅実施場所が自宅外(7, "概況調査場所は”在宅”ですが、実施場所が”自宅外”です。よろしいですか？"),
    既に他のグループで調査地区コードが登録(8, "既に他のグループで調査地区コードが登録されていますがよろしいですか？"),
    になって保存します(9, "?になって、保存します。よろしいですか？"),
    既に印刷済(10, "既に印刷済ですがよろしいですか？"),
    割付申請者人数が最大割付可能人数を超過(11, "割付申請者人数が最大割付可能人数を超えています。よろしいですか？");

    private final Message message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private DbeWarningMessages(int no, String message) {
        this.message = new WarningMessage(toCode("DBEW", no), message);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
