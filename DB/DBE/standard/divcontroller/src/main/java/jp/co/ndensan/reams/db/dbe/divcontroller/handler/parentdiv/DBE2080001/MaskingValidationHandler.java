/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2080001;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 完了処理・マスキングのValidationHandlerクラスです。
 *
 * @reamsid_L DBE-2080-010 lishengli
 */
public class MaskingValidationHandler {

    /**
     * コンストラクタです。
     */
    public MaskingValidationHandler() {
    }

    /**
     * マスキング完了対象者一覧データの存在チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs マスキング完了対象者一覧データの存在チェック(ValidationMessageControlPairs pairs) {
        pairs.add(new ValidationMessageControlPair(MaskingMessages.マスキング完了対象者一覧データの存在チェック));
        return pairs;
    }

    /**
     * マスキング完了対象者一覧データの行選択チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs マスキング完了対象者一覧データの行選択チェック(ValidationMessageControlPairs pairs) {
        pairs.add(new ValidationMessageControlPair(MaskingMessages.マスキング完了対象者一覧データの行選択チェック));
        return pairs;
    }

    private static enum MaskingMessages implements IValidationMessage {

        マスキング完了対象者一覧データの存在チェック(UrErrorMessages.該当データなし),
        マスキング完了対象者一覧データの行選択チェック(UrErrorMessages.対象行を選択);
        private final Message message;

        private MaskingMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
