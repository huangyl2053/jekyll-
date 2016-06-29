/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.message;

import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;

/**
 * DBUの質問メッセージ定義列挙型です。
 *
 * @reamsid_L DBE-9999-023 wangchao
 */
public enum DbuQuestionMessages implements IMessageGettable {

    一括実行確認(1, "?一括処理を実行します。よろしいですか？");

    private final Message message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private DbuQuestionMessages(int no, String message) {
        this.message = new QuestionMessage(toCode("DBUQ", no), message);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
