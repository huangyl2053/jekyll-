/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5320001;

import jp.co.ndensan.reams.db.dbd.definition.message.DbdErrorMessages;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 *
 * 要介護認定通知書発行画面の入力チェックのメッセージクラスです。
 *
 * @reamsid_L DBD-1430-010 lit
 */
public enum NinteiTsuchishoHakkoValidationMessage implements IValidationMessage {

    /**
     * 個別印刷0件チェック。
     */
    個別印刷0件チェック(DbdErrorMessages.通知書印刷不可, "要介護認定通知書発行"),
    /**
     * 個別印刷選択0件チェック。
     */
    個別印刷選択0件チェック(DbzErrorMessages.対象者を選択),
    /**
     * 個別印刷選択複数件チェック。
     */
    個別印刷選択複数件チェック(DbdErrorMessages.複数選択不可, "一覧の対象者");

    private final Message message;

    NinteiTsuchishoHakkoValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    NinteiTsuchishoHakkoValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
