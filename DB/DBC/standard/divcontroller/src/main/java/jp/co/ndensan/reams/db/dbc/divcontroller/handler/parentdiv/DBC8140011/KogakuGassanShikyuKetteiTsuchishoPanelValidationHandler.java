/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC8140011;

import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcWarningMessages;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBCMNN2003_事業分高額合算支給決定通知書（単）のバリデーションハンドラークラス。
 *
 * @reamsid_L DBC-4850-010 chenyadong
 */
public class KogakuGassanShikyuKetteiTsuchishoPanelValidationHandler {

    private static final RString 支払予定日 = new RString("支払予定日");

    /**
     * 受給共通_受給者登録なしチェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 受給共通_受給者登録なしチェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                DbdErrorMessages.受給共通_受給者_事業対象者登録なし)));
        return validPairs;
    }

    /**
     * 受給共通_受給者登録なしチェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 高額合算支給不支給マスタデータなしチェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                DbcErrorMessages.高額合算支給不支給マスタデータなし)));
        return validPairs;
    }

    /**
     * 未入力チェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 未入力チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                UrWarningMessages.未入力, 支払予定日.toString())));
        return validPairs;
    }

    /**
     * 高額合算支給情報存在エラーチェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 高額合算支給情報存在エラーチェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                DbcErrorMessages.高額合算支給情報存在エラー)));
        return validPairs;
    }

    /**
     * 高額合算支給決定通知書発行済チェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 高額合算支給決定通知書発行済チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                DbcWarningMessages.高額合算支給決定通知書発行済)));
        return validPairs;
    }

    private static class IdocheckMessages implements IValidationMessage {

        private final Message message;

        public IdocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
