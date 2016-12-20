/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.message;

import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;

/**
 * DBZの質問メッセージ定義列挙型です。
 *
 * @reamsid_L DBZ-9999-023 liangbc
 */
public enum DbzQuestionMessages implements IMessageGettable {

    最大表示件数超過確認(1, "検索された件数は入力された最大表示件数より大きいです、画面に表示しますか。"),
    変更未保存の確認(2, "変更が保存されていません。よろしいですか？"),
    保存の確認_追加メッセージあり(3, "?保存します。よろしいですか？"),
    内容変更なし処理中止確認(4, "内容に変更がありません。処理を中止しますか？"),
    判断基準より前の日付(5, "?に?より前の日付が設定されています。よろしいですか？"),
    画面遷移確認(6, "画面遷移してもよろしいですか？");

    private final Message message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private DbzQuestionMessages(int no, String message) {
        this.message = new QuestionMessage(toCode("DBZQ", no), message);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
