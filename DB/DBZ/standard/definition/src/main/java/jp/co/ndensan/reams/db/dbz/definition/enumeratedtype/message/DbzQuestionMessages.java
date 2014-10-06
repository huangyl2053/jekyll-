/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.message;

import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import static jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.message.MessageCreateHelper.toCode;

/**
 * DBZの質問メッセージ定義列挙型です。
 *
 * @author N9606 漢那 憲作
 */
public enum DbzQuestionMessages implements IMessageGettable {

    保存の確認(1, "保存します。よろしいですか？"),
    メニュー遷移の確認(2, "編集されています。メニューへ遷移してもよろしいですか？"),
    検索画面遷移の確認(3, "編集されています。検索画面へ遷移してもよろしいですか？"),
    画面遷移の確認(4, "編集されています。画面遷移してもよろしいですか？"),
    処理実行の確認(5, "処理を実行してもよろしいですか？"),
    削除の確認(6, "削除します。よろしいですか？");

    private final Message message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private DbzQuestionMessages(int no, String message) {
        this.message = new QuestionMessage(toCode("Q", no), message);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
