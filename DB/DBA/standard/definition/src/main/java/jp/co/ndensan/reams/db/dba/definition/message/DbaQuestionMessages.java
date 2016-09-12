/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.message;

import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;

/**
 * DBAの質問メッセージ定義列挙型です。
 *
 * @reamsid_L DBA-9999-023 liangbc
 */
public enum DbaQuestionMessages implements IMessageGettable {

    資格取得確認(3, "資格取得を行ってもよろしいですか？"),
    医療保険登録確認(4, "医療保険情報が登録されていません。よろしいですか？");

    private final Message message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private DbaQuestionMessages(int no, String message) {
        this.message = new QuestionMessage(toCode("DBAQ", no), message);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
