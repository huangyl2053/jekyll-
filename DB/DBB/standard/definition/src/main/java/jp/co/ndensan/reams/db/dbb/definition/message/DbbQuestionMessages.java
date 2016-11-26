/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.message;

import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;

/**
 * DBBの質問メッセージ定義列挙型です。
 *
 * @reamsid_L DBB-9999-023 liangbc
 */
public enum DbbQuestionMessages implements IMessageGettable {

    変更途中の内容破棄確認(1, "変更途中の内容を破棄しますが、よろしいですか？"),
    打分け方法名称の上書き確認(2, "同じ名称で既に打分け方法が登録されています。上書きしてよろしいですか？"),
    賦課データ削除確認(3, "選択した賦課データを削除します。よろしいですか。"),
    賦課データ確定確認(4, "一覧に表示した賦課データを確定します。よろしいですか。"),
    減免情報等更新確認(5, "?情報を?します。よろしいですか？"),
    再処理確認(6, "選択した処理は実施済みです。再処理することで出力対象が変わる可能性があります。処理を実行してもよろしいですか？");

    private final Message message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private DbbQuestionMessages(int no, String message) {
        this.message = new QuestionMessage(toCode("DBBQ", no), message);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
