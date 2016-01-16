/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0520011;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * KyokaisouKanriMasterListValidationMessageバリデーションメッセージを定義している列挙型です。
 *
 * @author ludm
 */
public class KyokaisouKanriMasterListValidatisonHandler {

    /**
     * 「範囲」が選択されている場合に、開始日と終了日両者とも入力されていないとエラーにする。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 範囲抽出必須入力チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();

        validPairs.add(new ValidationMessageControlPair(RRVMessages.範囲抽出必須入力チェック));
        return validPairs;
    }

    private static enum RRVMessages implements IValidationMessage {

        範囲抽出必須入力チェック(UrErrorMessages.必須, "開始日と終了日のいずれか１つ以上入力");

        private final Message message;

        private RRVMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

}
