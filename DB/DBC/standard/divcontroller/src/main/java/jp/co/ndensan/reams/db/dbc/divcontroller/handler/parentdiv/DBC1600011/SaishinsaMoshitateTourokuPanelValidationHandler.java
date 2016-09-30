/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1600011;

import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1600011.SaishinsaMoshitateTourokuPanelDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 介護給付費再審査申立書作成の検証ハンドラクラスです。
 *
 * @reamsid_L DBC-2230-010 chenxiangyu
 */
public class SaishinsaMoshitateTourokuPanelValidationHandler {

    private final SaishinsaMoshitateTourokuPanelDiv div;
    private static final RString 特定診療費 = new RString("20");
    private static final RString 必須項目1 = new RString("被保番号、支援事業者番号");
    private static final RString 必須項目2 = new RString("提供年月開始と提供年月終了");
    private static final RString 提供年月開始テキスト = new RString("提供年月開始");
    private static final RString 提供年月終了テキスト = new RString("提供年月終了");
    private static final RString 被保険者台帳 = new RString("被保険者台帳");
    private static final RString 送付済みチェック = new RString("送付済みの");
    private static final int TWO = 2;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public SaishinsaMoshitateTourokuPanelValidationHandler(SaishinsaMoshitateTourokuPanelDiv div) {
        this.div = div;
    }

    /**
     * 被保番号と支援事業者番号の入力関連チェックを実施します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check被保番号と支援事業者番号の入力関連() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (RString.isNullOrEmpty(div.getTxtHihoNo().getValue()) && RString.isNullOrEmpty(div.getCcdJigyoshaSentaku().getNyuryokuShisetsuKodo())) {
            validPairs.add(new ValidationMessageControlPair(
                    new IdocheckMessages(UrErrorMessages.必須項目_追加メッセージあり, 必須項目1.toString())));
        }
        return validPairs;
    }

    /**
     * 提供年月開始と提供年月終了の必須入力チェックを実施します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check提供年月開始と提供年月終了の必須入力() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getTxtTeikyoYMRange().getToValue() == null || div.getTxtTeikyoYMRange().getFromValue() == null) {
            validPairs.add(new ValidationMessageControlPair(
                    new IdocheckMessages(UrErrorMessages.必須項目_追加メッセージあり, 必須項目2.toString())));
        }
        return validPairs;
    }

    /**
     * 提供年月開始と提供年月終了の比較チェックを実施します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check提供年月開始と提供年月終了の比較() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getTxtTeikyoYMRange().getToValue().isBefore(div.getTxtTeikyoYMRange().getFromValue())) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.終了日が開始日以前,
                    提供年月開始テキスト.toString(),
                    提供年月終了テキスト.toString())));
        }
        return validPairs;
    }

    /**
     * 申立日の年月と提供年月の関連チェックを実施します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check申立日エラー() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getKagoMoshitatePanel().getTextBoxDate1().getValue().getYearMonth().isBefore(
                new RYearMonth(div.getKagoMoshitatePanel().getTextBox5().getValue()))) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(DbcErrorMessages.申立日エラー)));
        }
        return validPairs;
    }

    /**
     * 再審査特定診療識別チェック１を実施します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check再審査特定診療識別1() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (特定診療費.equals(div.getKagoMoshitatePanel().getDropDownList4().getSelectedKey())
                && TWO != div.getKagoMoshitatePanel().getRadioButton1().getSelectedIndex()) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(DbcErrorMessages.再審査特定診療識別チェック１)));
        }
        return validPairs;
    }

    /**
     * 再審査特定診療識別チェック２を実施します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check再審査特定診療識別2() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (特定診療費.equals(div.getKagoMoshitatePanel().getDropDownList4().getSelectedKey())
                && div.getKagoMoshitatePanel().getDropDownList7().getDataSource().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(DbcErrorMessages.再審査特定診療識別チェック２)));
        }
        return validPairs;
    }

    /**
     * 再審査サービス選択チェックを実施します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check再審査サービス選択() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (!特定診療費.equals(div.getKagoMoshitatePanel().getDropDownList4().getSelectedKey())
                && TWO == div.getKagoMoshitatePanel().getRadioButton1().getSelectedIndex()) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(DbcErrorMessages.再審査サービス選択チェック)));
        }
        return validPairs;
    }

    /**
     * 送付済みチェックを実施します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check送付済み() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (RString.isNullOrEmpty(div.getKagoMoshitatePanel().getTextBox6().getValue())) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.削除不可, 送付済みチェック.toString())));
        }
        return validPairs;
    }

    /**
     * 存在しないエラーメッセージを取得します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs get存在しないエラーメッセージ() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validPairs.add(new ValidationMessageControlPair(
                new IdocheckMessages(UrErrorMessages.存在しない, 被保険者台帳.toString())));
        return validPairs;
    }

    /**
     * 再審査対象なしエラーメッセージを取得します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs get再審査対象なしエラーメッセージ() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validPairs.add(new ValidationMessageControlPair(
                new IdocheckMessages(DbcErrorMessages.再審査対象なしエラー)));
        return validPairs;
    }

    /**
     * 排他_他のユーザが使用中エラーメッセージを取得します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs get他のユーザが使用中エラーメッセージ() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validPairs.add(new ValidationMessageControlPair(
                new IdocheckMessages(UrErrorMessages.排他_他のユーザが使用中)));
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
