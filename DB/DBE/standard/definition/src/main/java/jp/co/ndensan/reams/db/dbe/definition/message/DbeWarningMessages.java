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
 * @reamsid_L DBE-9999-023 liangbc
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
    割付申請者人数が最大割付可能人数を超過(11, "割付申請者人数が最大割付可能人数を超えています。よろしいですか？"),
    既に印刷済_複数選択時(13, "既に印刷済のデータが対象に含まれています。よろしいですか？"),
    年齢が40歳以上65歳未満(14, "年齢が40歳以上65歳未満ではありません。処理を続けますか？"),
    審査会最低定員数不足(15, "審査会最低定員数に達していませんが、よろしいですか？"),
    審査会委員定員数超過(16, "審査会委員定員数を超えていますが、よろしいですか？"),
    開催日が未来日(17, "開催日が未来日ですが、よろしいですか？"),
    予定定員を超過割付確認(18, "予定定員を超えていますが、割付しますか？"),
    審査会割当済のため処理不可(19, "審査会が割り当てられていますが、修正しますか？"),
    依頼済のため処理不可(20, "依頼の登録が完了していますが、修正しますか？"),
    市町村変更による再入力(21, "市町村が変更されたので、?の入力をクリアしました。<br>?を入力し直してください。");
    
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
