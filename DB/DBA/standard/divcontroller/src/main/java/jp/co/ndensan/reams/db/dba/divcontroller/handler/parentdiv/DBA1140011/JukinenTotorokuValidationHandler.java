/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1140011;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1140011.jukinentotorokuDiv;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 住基連動登録者のバリデーションチェッククラスです。
 */
public class JukinenTotorokuValidationHandler {

    private final jukinentotorokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 住基連動登録者Div
     */
    public JukinenTotorokuValidationHandler(jukinentotorokuDiv div) {
        this.div = div;
    }

    /**
     * 実行するボタンを押下するとき、バリデーションチェックを行う。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateForAction() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();

        if (div.getBatchParamterInfo().getTxtkonkaikaishi().getValue().isEmpty()
                || div.getBatchParamterInfo().getTxtkonkaishuryo().getValue().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(
                    new IdocheckMessages(UrErrorMessages.必須, "今回開始日と終了日両方")));
        } else {
            if (!div.getBatchParamterInfo().getTxtkonkaikaishi().getValue().isValid()
                    || !div.getBatchParamterInfo().getTxtkonkaishuryo().getValue().isValid()) {
                // TODO QA415
                validPairs.add(new ValidationMessageControlPair(
                        new IdocheckMessages(UrErrorMessages.不正, "日付")));
            } else {
                if (div.getBatchParamterInfo().getTxtkonkaikaishi().getValue().isAfter(
                        div.getBatchParamterInfo().getTxtkonkaishuryo().getValue())) {
                    validPairs.add(new ValidationMessageControlPair(
                            new IdocheckMessages(DbzErrorMessages.期間が不正_未来日付不可, "開始日", "終了日")));
                }
            }
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
