/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.message;

import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.message.ButtonSelectPattern;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;

/**
 * URの質問メッセージを定義列挙型がDBにカブセウル化です。
 *
 * @reamsid_L DBX-9999-023 wangchao
 */
public enum DbQuestionMessages implements IMessageGettable, IValidationMessage {

    /**
     * "入力された値を破棄します。よろしいですか？"を定義しています。
     */
    入力内容の破棄(UrQuestionMessages.入力内容の破棄.getMessage(), ButtonSelectPattern.OKCancel),
    /**
     *
     */
    処理実行の確認(UrQuestionMessages.処理実行の確認.getMessage(), ButtonSelectPattern.OKCancel);

    private final Message message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private DbQuestionMessages(Message message) {
        this.message = new QuestionMessage(message.getCode(), message.evaluate());
    }

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private DbQuestionMessages(Message message, ButtonSelectPattern pattern) {
        this.message = new QuestionMessage(message.getCode(), message.evaluate(), pattern);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
