/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050031;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 介護保険特別会計経理状況登録_様式４の２のチェッククラスです。
 */
public class ValidationHandler {

    private final KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div div;

    /**
     * コンストラクタです。
     *
     * @param div 介護保険特別会計経理状況登録_様式４の２入力ガイド
     */
    public ValidationHandler(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div div) {
        this.div = div;
    }

    public void 報告年度の必須チェック(ValidationMessageControlPairs validPairs) {
        if (div.getYoshikiyonMeisai().getTxthokokuYM().getValue() == null || div.getYoshikiyonMeisai().getTxthokokuYM().getValue().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.Validate報告年度必須));
        }
    }

    private static enum RRVMessages implements IValidationMessage {

        Validate報告年度必須(UrErrorMessages.必須, "報告年度");
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
