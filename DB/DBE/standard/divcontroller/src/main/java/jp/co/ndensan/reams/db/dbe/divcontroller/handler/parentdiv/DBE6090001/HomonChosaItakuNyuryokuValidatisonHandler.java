/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6090001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6090001.HomonChosaItakuNyuryokuDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 認定調査委託料入力クラスです。
 *
 * @reamsid_L DBE-1970-010 wanghui
 */
public class HomonChosaItakuNyuryokuValidatisonHandler {

    private final HomonChosaItakuNyuryokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 認定調査スケジュール情報Div
     */
    public HomonChosaItakuNyuryokuValidatisonHandler(HomonChosaItakuNyuryokuDiv div) {
        this.div = div;
    }

    /**
     * 調査員一覧の件数が空の場合、エラーとする。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs データ空のチェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        データ空チェック(validPairs);
        return validPairs;
    }

    /**
     * 調査実績一覧の件数が空の場合、エラーとする。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 調査実績一覧のチェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        実績一覧データ空チェック(validPairs);
        return validPairs;
    }

    /**
     * 調査実績一覧の件数が空の場合、エラーとする。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 必須入力チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validateForMaxCount(validPairs);
        return validPairs;
    }

    /**
     * データ空チェック
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs データ空チェック(ValidationMessageControlPairs validPairs) {
        if (div.getDgChosain().getDataSource() == null
                || div.getDgChosain().getDataSource().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.Validate対象者一覧未表示,
                    div.getDgChosain()));
        }
        return validPairs;
    }

    /**
     * 最大表示件数の必須入力チェックを実施します。
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs validateForMaxCount(ValidationMessageControlPairs validPairs) {
        if (div.getTextBoxNum().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.Validate最大表示件数の必須入力チェック,
                    div.getTextBoxNum()));
        }
        return validPairs;
    }

    /**
     * 実績一覧データ空チェック
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 実績一覧データ空チェック(ValidationMessageControlPairs validPairs) {
        if (div.getDgShinsakaiIin().getDataSource() == null
                || div.getDgShinsakaiIin().getDataSource().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.Validate調査実績一覧未表示,
                    div.getDgShinsakaiIin()));
        }
        return validPairs;
    }

    private static enum RRVMessages implements IValidationMessage {

        Validate対象者一覧未表示(UrErrorMessages.該当データなし),
        Validate最大表示件数の必須入力チェック(UrErrorMessages.必須, "最大表示件数"),
        Validate調査実績一覧未表示(UrErrorMessages.該当データなし);
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
