/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2070001;

import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 完了処理・主治医意見書入手のValidationHandlerクラスです。
 *
 * @reamsid_L DBE-0330-010 lishengli
 */
public class IkenshogetValidationHandler {

    /**
     * コンストラクタです。
     */
    public IkenshogetValidationHandler() {
    }

    /**
     * 主治医意見書入手一覧データの存在チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 主治医意見書入手一覧データの存在チェック(ValidationMessageControlPairs pairs) {
        pairs.add(new ValidationMessageControlPair(IkenshogetMessages.主治医意見書入手一覧データの存在チェック));
        return pairs;
    }

    /**
     * 主治医意見書入手一覧データの行選択チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 主治医意見書入手一覧データの行選択チェック(ValidationMessageControlPairs pairs) {
        pairs.add(new ValidationMessageControlPair(IkenshogetMessages.主治医意見書入手一覧データの行選択チェック));
        return pairs;
    }

    /**
     * 主治医意見書入手一覧データの複数行選択チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 主治医意見書入手一覧データの複数行選択チェック(ValidationMessageControlPairs pairs) {
        pairs.add(new ValidationMessageControlPair(IkenshogetMessages.主治医意見書入手一覧データの複数行選択チェック));
        return pairs;
    }

    /**
     * 主治医意見書入手一覧選択行の完了処理事前チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 主治医意見書入手一覧選択行の完了処理事前チェック(ValidationMessageControlPairs pairs) {
        pairs.add(new ValidationMessageControlPair(IkenshogetMessages.主治医意見書入手一覧選択行の完了処理事前チェック));
        return pairs;
    }

    /**
     * 主治医意見書入手一覧選択行の完了処理チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 主治医意見書入手一覧選択行の完了処理チェック(ValidationMessageControlPairs pairs) {
        pairs.add(new ValidationMessageControlPair(IkenshogetMessages.主治医意見書入手一覧選択行の完了処理チェック));
        return pairs;
    }

    private static enum IkenshogetMessages implements IValidationMessage {

        主治医意見書入手一覧データの存在チェック(UrErrorMessages.該当データなし),
        主治医意見書入手一覧データの行選択チェック(UrErrorMessages.対象行を選択),
        主治医意見書入手一覧データの複数行選択チェック(DbeErrorMessages.複数選択不可, "主治医意見書入手一覧"),
        主治医意見書入手一覧選択行の完了処理事前チェック(DbzErrorMessages.理由付き完了不可, "意見書未入手"),
        主治医意見書入手一覧選択行の完了処理チェック(DbzErrorMessages.理由付き完了不可, "完了済みデータ");
        private final Message message;

        private IkenshogetMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
