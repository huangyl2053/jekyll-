/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2040001;

import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 完了処理・主治医意見書依頼のValidationHandlerクラスです。
 *
 * @reamsid_L DBE-0320-010 lishengli
 */
public class ShujiiIkenshoIraiTaishoIchiranValidationHandler {

    /**
     * コンストラクタです。
     */
    public ShujiiIkenshoIraiTaishoIchiranValidationHandler() {
    }

    /**
     * 主治医意見書作成依頼一覧データの存在チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 主治医意見書作成依頼一覧データの存在チェック(ValidationMessageControlPairs pairs) {
        pairs.add(new ValidationMessageControlPair(ShujiiIkenshoIraiTaishoIchiranMessages.主治医意見書作成依頼一覧データの存在チェック));
        return pairs;
    }

    /**
     * 主治医意見書作成依頼一覧データの行選択チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 主治医意見書作成依頼一覧データの行選択チェック(ValidationMessageControlPairs pairs) {
        pairs.add(new ValidationMessageControlPair(ShujiiIkenshoIraiTaishoIchiranMessages.主治医意見書作成依頼一覧データの行選択チェック));
        return pairs;
    }

    /**
     * 主治医意見書作成依頼一覧選択行の完了処理事前チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 主治医意見書作成依頼一覧選択行の完了処理事前チェック(ValidationMessageControlPairs pairs) {
        pairs.add(new ValidationMessageControlPair(ShujiiIkenshoIraiTaishoIchiranMessages.主治医意見書作成依頼一覧選択行の完了処理事前チェック));
        return pairs;
    }

    /**
     * 依頼期限が未確定の完了必須チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 依頼期限が未確定の完了必須チェック(ValidationMessageControlPairs pairs) {
        pairs.add(new ValidationMessageControlPair(ShujiiIkenshoIraiTaishoIchiranMessages.依頼期限が未確定の完了必須チェック));
        return pairs;
    }

    /**
     * 依頼日が未確定の完了必須チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 依頼日が未確定の完了必須チェック(ValidationMessageControlPairs pairs) {
        pairs.add(new ValidationMessageControlPair(ShujiiIkenshoIraiTaishoIchiranMessages.依頼日が未確定の完了必須チェック));
        return pairs;
    }

    /**
     * 意見書書発行日が未確定の完了必須チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 意見書書発行日が未確定の完了必須チェック(ValidationMessageControlPairs pairs) {
        pairs.add(new ValidationMessageControlPair(ShujiiIkenshoIraiTaishoIchiranMessages.意見書書発行日が未確定の完了必須チェック));
        return pairs;
    }

    /**
     * 意見書出力年月日が未確定の完了必須チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 意見書出力年月日が未確定の完了必須チェック(ValidationMessageControlPairs pairs) {
        pairs.add(new ValidationMessageControlPair(ShujiiIkenshoIraiTaishoIchiranMessages.意見書出力年月日が未確定の完了必須チェック));
        return pairs;
    }

    /**
     * 医療機関_主治医が割りつけられていないチェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 医療機関_主治医が割りつけられていないチェック(ValidationMessageControlPairs pairs) {
        pairs.add(new ValidationMessageControlPair(ShujiiIkenshoIraiTaishoIchiranMessages.医療機関_主治医が割りつけられていないチェック));
        return pairs;
    }

    /**
     * 主治医意見書作成依頼一覧データの複数行選択チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 主治医意見書作成依頼一覧データの複数行選択チェック(ValidationMessageControlPairs pairs) {
        pairs.add(new ValidationMessageControlPair(ShujiiIkenshoIraiTaishoIchiranMessages.主治医意見書作成依頼一覧データの複数行選択チェック));
        return pairs;
    }

    private static enum ShujiiIkenshoIraiTaishoIchiranMessages implements IValidationMessage {

        主治医意見書作成依頼一覧データの存在チェック(UrErrorMessages.該当データなし),
        主治医意見書作成依頼一覧データの行選択チェック(UrErrorMessages.対象行を選択),
        主治医意見書作成依頼一覧選択行の完了処理事前チェック(DbzErrorMessages.理由付き完了不可, "意見書作成依頼先が未確定"),
        依頼期限が未確定の完了必須チェック(DbzErrorMessages.理由付き完了不可,
                "依頼期限が未確定"),
        依頼日が未確定の完了必須チェック(DbzErrorMessages.理由付き完了不可,
                "依頼日が未確定"),
        意見書書発行日が未確定の完了必須チェック(DbzErrorMessages.理由付き完了不可,
                "意見書書発行日が未確定"),
        意見書出力年月日が未確定の完了必須チェック(DbzErrorMessages.理由付き完了不可,
                "意見書出力年月日が未確定"),
        医療機関_主治医が割りつけられていないチェック(DbeErrorMessages.帳票印刷不可, "医療機関・主治医が割りつけられていない"),
        主治医意見書作成依頼一覧データの複数行選択チェック(DbeErrorMessages.複数選択不可, "主治医意見書作成依頼一覧");
        private final Message message;

        private ShujiiIkenshoIraiTaishoIchiranMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
