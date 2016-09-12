/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2250001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2250001.NinteishinseibiDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 認定調査データ取込（モバイル）のHandlerラスです。
 *
 * @reamsid_L DBE-1870-010 houtianpeng
 */
public class NinteishinseibiValidatisonHandler {

    private final NinteishinseibiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 認定調査データ取込Div
     */
    public NinteishinseibiValidatisonHandler(NinteishinseibiDiv div) {
        this.div = div;
    }

    /**
     * 抽出データの件数がNULLの場合、エラーとする。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs データ空のチェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        データ空チェック(validPairs);
        return validPairs;
    }

    /**
     * 認定調査一覧データの行選択チェック。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 認定調査一覧データの行選択チェック() {

        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getDgNinteiChosaData().getSelectedItems().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.認定調査一覧データの行選択チェック,
                    div.getDgNinteiChosaData()));
        }
        return validPairs;
    }

    /**
     * データ空チェック
     *
     * @param validPairs ValidationMessageControlPairs
     */
    public void データ空チェック(ValidationMessageControlPairs validPairs) {
        if (div.getDgNinteiChosaData().getDataSource() == null
                || div.getDgNinteiChosaData().getDataSource().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.該当データなし,
                    div.getDgNinteiChosaData()));
        }
    }

    /**
     * CSVデータを取込対象データ
     *
     * @param 取込対象フラグ 取込対象フラグ
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 取込対象データチェック(boolean 取込対象フラグ) {

        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (取込対象フラグ) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.CSVデータを取込対象データ));
        }
        return validPairs;
    }

    private static enum RRVMessages implements IValidationMessage {

        該当データなし(UrErrorMessages.該当データなし),
        CSVデータを取込対象データ(UrErrorMessages.存在しない, "CSVデータを取込対象データ"),
        認定調査一覧データの行選択チェック(UrErrorMessages.対象行を選択);
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
