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

    申請者と介護認定審査会委員に関係(1, "申請者と介護認定審査会委員に関係がありますがよろしいですか？"),
    既に開催結果が登録されています_上書き確認(2, "既に開催結果が登録されています。上書きしますか？"),
    既に基本調査値が存在します_上書き確認(3, "既に基本調査値が存在します。上書きしますか？"),
    自宅内で施設(4, "実施場所は”自宅内”ですが概況調査場所が”施設”です。よろしいですか？"),
    自宅外で在宅(5, "実施場所は”自宅外”ですが概況調査場所が”在宅”です。よろしいですか？"),
    施設で自宅内(6, "概況調査場所は”施設”ですが実施場所が”自宅内”です。よろしいですか？"),
    在宅で自宅外(7, "概況調査場所は”在宅”ですが実施場所が”自宅外”です。よろしいですか？"),
    既に他のグループで調査地区コードが登録(8, "既に他のグループで調査地区コードが登録されていますがよろしいですか？"),
    保存確認(9, "?になって保存します。よろしいですか？"),
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
