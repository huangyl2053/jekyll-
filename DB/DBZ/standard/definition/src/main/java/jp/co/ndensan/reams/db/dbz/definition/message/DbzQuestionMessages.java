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
 * @author N9606 漢那 憲作
 */
public enum DbzQuestionMessages implements IMessageGettable {

    最大表示件数超過確認(1, "検索された件数は入力された最大表示件数より大きいです、画面に表示しますか。");

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
