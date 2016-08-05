/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6910001;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxFlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 報酬マスタメンテナンス画面のValidationHandlerクラスです。
 *
 * @reamsid_L DBE-1710-010 dingyi
 */
public class HoshuMasutaKoshinValidationHandler {

    /**
     * コンストラクタです。
     */
    public HoshuMasutaKoshinValidationHandler() {
    }

    /**
     * 開始年月の必須入力チェックを実行します。
     *
     * @param 開始年月 開始年月
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check開始年月が必須(TextBoxFlexibleYearMonth 開始年月) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (開始年月 == null || 開始年月.getDomain() == null || 開始年月.getDomain().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(RRVMessages.開始年月が必須));
        }
        return validationMessages;
    }

    /**
     * 終了年月の必須入力チェックを実行します。
     *
     * @param 終了年月 終了年月
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check終了年月が必須(TextBoxFlexibleYearMonth 終了年月) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (終了年月 == null || 終了年月.getDomain() == null || 終了年月.getDomain().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(RRVMessages.終了年月が必須));
        }
        return validationMessages;
    }

    /**
     * 単価の必須入力チェックを実行します。
     *
     * @param 単価 単価
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check単価が必須(TextBoxNum 単価) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (単価 == null || 単価.getValue() == null) {
            validationMessages.add(new ValidationMessageControlPair(RRVMessages.単価が必須));
        }
        return validationMessages;
    }

    /**
     * 開始年月、終了年月期間が不正チェックを実行します。
     *
     * @param 開始年月 開始年月
     * @param 終了年月 終了年月
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check期間が不正(TextBoxFlexibleYearMonth 開始年月, TextBoxFlexibleYearMonth 終了年月) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (終了年月.getDomain().isBefore(開始年月.getDomain())) {
            validationMessages.add(new ValidationMessageControlPair(RRVMessages.期間が不正));
        }
        return validationMessages;
    }

    /**
     * 既に存在チェックを実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs checkデータが既に存在() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(RRVMessages.既に存在));
        return validationMessages;
    }

    /**
     * 審査委員コードの必須入力チェックを実行します。
     *
     * @param 審査委員コード 審査委員コード
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check審査委員コードが必須(RString 審査委員コード) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (RString.isNullOrEmpty(審査委員コード)) {
            validationMessages.add(new ValidationMessageControlPair(RRVMessages.審査委員コードが必須));
        }
        return validationMessages;
    }

    /**
     * 期間チェックを実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check期間が重複() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(RRVMessages.期間が重複));
        return validationMessages;
    }

    private static enum RRVMessages implements IValidationMessage {

        開始年月が必須(UrErrorMessages.必須, "開始年月"),
        終了年月が必須(UrErrorMessages.必須, "終了年月"),
        単価が必須(UrErrorMessages.必須, "単価"),
        期間が不正(UrErrorMessages.期間が不正_追加メッセージあり２, "開始年月", "終了年月"),
        既に存在(UrErrorMessages.既に存在, "データ"),
        審査委員コードが必須(UrErrorMessages.必須, "審査委員コード"),
        期間が重複(UrErrorMessages.期間が重複);

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
