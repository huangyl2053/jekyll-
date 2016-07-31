/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0070011;

import jp.co.ndensan.reams.db.dbx.business.core.view.HihokenshaDaichoAlive;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 介護保険連絡票作成のハンドラークラスです。
 *
 * @reamsid_L DBA-1290-010 linghuhang
 */
public class RenrakuhyoDataCreatorValidationHandler {

    /**
     * コンストラクタです。
     */
    public RenrakuhyoDataCreatorValidationHandler() {
    }

    /**
     * 初期化するとき、バリデーションチェックを行う。
     *
     * @param 被保険者台帳情報 HihokenshaDaichoAlive
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs validateForAction(HihokenshaDaichoAlive 被保険者台帳情報) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (被保険者台帳情報 == null) {
            validPairs.add(new ValidationMessageControlPair(IdocheckMessages.対象者チェック));
        } else {
            if (被保険者台帳情報.get資格喪失年月日() != null && !被保険者台帳情報.get資格喪失年月日().isEmpty()) {
                validPairs.add(new ValidationMessageControlPair(IdocheckMessages.対象者チェック));
            }
        }
        return validPairs;
    }

    private static enum IdocheckMessages implements IValidationMessage {

        対象者チェック(DbzErrorMessages.実行不可, "処理対象者が被保険者では無い", "印刷は");
        private final Message message;

        private IdocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
