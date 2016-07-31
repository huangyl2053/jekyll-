/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.parentdiv.DBZ5100001;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ5100001.KaigoNinteiShinseiKensakuDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 要介護認定申請情報検索クラスです。
 *
 * @reamsid_L DBZ-1300-150 houtianpeng
 */
public class KaigoNinteiValidatisonHandler {

    private final KaigoNinteiShinseiKensakuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 要介護認定申請情報検索Div
     */
    public KaigoNinteiValidatisonHandler(KaigoNinteiShinseiKensakuDiv div) {
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
     * データ空チェック
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs データ空チェック(ValidationMessageControlPairs validPairs) {
        if (div.getDgKensakuKekkaIchiran().getDataSource() == null
                || div.getDgKensakuKekkaIchiran().getDataSource().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.該当データなし,
                    div.getDgKensakuKekkaIchiran()));
        }
        return validPairs;
    }

    private static enum RRVMessages implements IValidationMessage {

        該当データなし(UrErrorMessages.該当データなし);
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
