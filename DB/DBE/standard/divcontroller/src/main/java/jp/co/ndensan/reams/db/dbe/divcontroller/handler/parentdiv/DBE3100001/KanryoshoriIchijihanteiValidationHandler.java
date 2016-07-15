/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE3100001;

import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 完了処理・一次判定のValidationHandlerクラスです。
 *
 * @reamsid_L DBE-2070-010 wangrenze
 */
public class KanryoshoriIchijihanteiValidationHandler {

    /**
     * コンストラクタです。
     */
    public KanryoshoriIchijihanteiValidationHandler() {
    }

    /**
     * 一次判定完了対象者一覧データの存在チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 一次判定完了対象者一覧データの存在チェック(ValidationMessageControlPairs pairs) {
        pairs.add(new ValidationMessageControlPair(KanryoshoriIchijihanteiMessages.一次判定完了対象者一覧データの存在チェック));
        return pairs;
    }

    /**
     * 一次判定完了対象者一覧データの行選択チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 一次判定完了対象者一覧データの行選択チェック(ValidationMessageControlPairs pairs) {
        pairs.add(new ValidationMessageControlPair(KanryoshoriIchijihanteiMessages.一次判定完了対象者一覧データの行選択チェック));
        return pairs;
    }

    /**
     * 一次判定完了対象者一覧選択行の完了処理チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 一次判定完了対象者一覧選択行の完了処理チェック(ValidationMessageControlPairs pairs) {
        pairs.add(new ValidationMessageControlPair(KanryoshoriIchijihanteiMessages.一次判定完了対象者一覧選択行の完了処理チェック));
        return pairs;
    }

    private static enum KanryoshoriIchijihanteiMessages implements IValidationMessage {

        一次判定完了対象者一覧データの存在チェック(UrErrorMessages.該当データなし),
        一次判定完了対象者一覧データの行選択チェック(UrErrorMessages.対象行を選択),
        一次判定完了対象者一覧選択行の完了処理チェック(DbzErrorMessages.理由付き完了不可, "完了済みデータ");
        private final Message message;

        private KanryoshoriIchijihanteiMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
