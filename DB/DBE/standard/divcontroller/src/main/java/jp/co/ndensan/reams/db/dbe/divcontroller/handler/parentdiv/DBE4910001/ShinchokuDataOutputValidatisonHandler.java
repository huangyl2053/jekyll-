/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE4910001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4910001.ShinchokuDataOutputDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 要介護認定進捗情報データ出力の処理です。
 *
 * @reamsid_L DBE-1500-010 wanghui
 */
public class ShinchokuDataOutputValidatisonHandler {

    private final ShinchokuDataOutputDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 要介護認定進捗情報データ出力Div
     */
    public ShinchokuDataOutputValidatisonHandler(ShinchokuDataOutputDiv div) {
        this.div = div;
    }

    /**
     * 対象者一覧データの件数が空の場合、エラーとする。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs データ空のチェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        データ空チェック(validPairs);
        return validPairs;
    }

    /**
     * 対象者一覧データの件数が空の場合、エラーとする。
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
        if (div.getDgShinchokuIchiran().getDataSource() == null
                || div.getDgShinchokuIchiran().getDataSource().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(ShinchokuDataOutputValidatisonHandler.RRVMessages.Validate対象者一覧未表示,
                    div.getDgShinchokuIchiran()));
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
        if (div.getTxtMaxKensu().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(ShinchokuDataOutputValidatisonHandler.RRVMessages.Validate最大表示件数の必須入力チェック,
                    div.getTxtMaxKensu()));
        }
        return validPairs;
    }

    /**
     * 対象者一覧データの行選択チェック。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 対象者一覧データの行選択チェック() {

        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getDgShinchokuIchiran().getSelectedItems().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(ShinchokuDataOutputValidatisonHandler.RRVMessages.対象者一覧データの行選択チェック,
                    div.getDgShinchokuIchiran()));
        }
        return validPairs;
    }

    private static enum RRVMessages implements IValidationMessage {

        Validate対象者一覧未表示(UrErrorMessages.該当データなし),
        対象者一覧データの行選択チェック(UrErrorMessages.対象行を選択),
        Validate最大表示件数の必須入力チェック(UrErrorMessages.必須, "最大表示件数");
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
