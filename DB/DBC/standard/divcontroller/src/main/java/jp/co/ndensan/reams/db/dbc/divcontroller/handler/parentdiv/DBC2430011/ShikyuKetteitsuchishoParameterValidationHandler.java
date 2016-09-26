/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2430011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2430011.ShikyuKetteitsuchishoParameterDiv;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 住宅改修理由書作成手数料支給（不支給）決定通知書作成の検証ハンドラクラスです。
 *
 * @reamsid_L DBC-2850-010 chenxiangyu
 */
public class ShikyuKetteitsuchishoParameterValidationHandler {

    private final ShikyuKetteitsuchishoParameterDiv div;
    private static final RString 決定日開始 = new RString("決定日開始");
    private static final RString 決定日_開始日 = new RString("決定日（開始日）");
    private static final RString 決定日_終了日 = new RString("決定日（終了日）");
    private static final RString 前回決定日終了 = new RString("前回決定日終了");
    private static final RString 決定日 = new RString("決定日");
    private static final RString DDL事業者必須入力 = new RString("指定業者のみが選択されている場合、事業者");
    private static final RString 出力順必須設定 = new RString("出力順を");

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public ShikyuKetteitsuchishoParameterValidationHandler(ShikyuKetteitsuchishoParameterDiv div) {
        this.div = div;
    }

    /**
     * 決定日の必須入力チェックを実施します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check決定日の必須入力() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getTxtKetteiYMD().getFromValue() == null || div.getTxtKetteiYMD().getToValue() == null) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.必須, 決定日.toString())));
        }
        return validPairs;
    }

    /**
     * 決定日_開始日と決定日_終了日の比較チェックを実施します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check決定日_開始日と決定日_終了日の比較() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getTxtKetteiYMD().getToValue().isBefore(div.getTxtKetteiYMD().getFromValue())) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    DbzErrorMessages.期間が不正_未来日付不可,
                    決定日_開始日.toString(),
                    決定日_終了日.toString())));
        }
        return validPairs;
    }

    /**
     * 事業者DDLの必須入力チェックを実施します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check事業者DDLの必須入力() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getChkShiteiJigyoshaNomi().getSelectedItems() != null
                && !div.getChkShiteiJigyoshaNomi().getSelectedItems().isEmpty()
                && RString.isNullOrEmpty(div.getDdlJigyosha().getSelectedKey())) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.必須,
                    DDL事業者必須入力.toString())));
        }
        return validPairs;
    }

    /**
     * 出力順の必須設定チェックを実施します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check出力順の必須設定() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getCcdChohyoShutsuryokujun().get出力順ID() == null || div.getCcdChohyoShutsuryokujun().get出力順ID() == 0) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.未指定,
                    出力順必須設定.toString())));
        }
        return validPairs;
    }

    /**
     * 前回作成期間重複チェックを実施します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check前回作成期間重複() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getTxtZnkaiKetteiYMD().getToValue() != null
                && div.getTxtKetteiYMD().getFromValue().isBefore(div.getTxtZnkaiKetteiYMD().getToValue())) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    DbzErrorMessages.期間が不正_未来日付不可,
                    前回決定日終了.toString(),
                    決定日開始.toString())));
        }
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
