/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.message;

import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;

/**
 * DBDの質問メッセージ定義列挙型です。
 *
 * @reamsid_L DBD-9999-023 liangbc
 */
public enum DbdQuestionMessages implements IMessageGettable {

    負担限度額一括認定_テスト結果承認確認(1, "表示中のテスト結果を認定結果として登録します。よろしいですか？"),
    負担限度額一括認定_修正反映確認(2, "修正した内容を認定結果として登録します。よろしいですか？"),
    受給者台帳異動チェックリスト出力確認(3, "?より前のデータをすべて発行してもよろしいでしょうか？"),
    //受給者台帳異動チェックリスト出力確認(4, "?より後のデータをすべて発行してもよろしいでしょうか？"),
    //受給者台帳異動チェックリスト出力確認(5, "全件発行処理してもよろしいでしょうか？"),
    編集破棄確認(6, "編集されています。\\n未更新の情報は反映されませんが、よろしいですか？"),
    新規登録確認(7, "被保険者に関連付け済みの情報のため、「検索」から指定してください。"
            + "\\n他市町村からの照会結果など、同一年金について新規登録の必要がある場合登録してください。新規登録しますか？"),
    被保険者関連解除確認(8, "非課税年金対象者情報の、表示中の被保険者との関連づけを解除します。よろしいですか？");

    private final Message message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private DbdQuestionMessages(int no, String message) {
        this.message = new QuestionMessage(toCode("DBDQ", no), message);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
