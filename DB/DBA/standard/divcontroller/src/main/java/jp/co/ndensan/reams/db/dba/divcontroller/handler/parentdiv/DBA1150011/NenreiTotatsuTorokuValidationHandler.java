/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1150011;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1150011.nenreitotatsutorokuDiv;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 年齢到達登録者のバリデーションチェッククラスです。
 */
public class NenreiTotatsuTorokuValidationHandler {

    private final nenreitotatsutorokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 年齢到達登録者Div
     */
    public NenreiTotatsuTorokuValidationHandler(nenreitotatsutorokuDiv div) {
        this.div = div;
    }

    /**
     * 実行するボタンを押下するとき、バリデーションチェックを行う。
     *
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs validateForAction() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getBatchParamterInfo().getTxtkonkaikaishi().getValue().isEmpty()
                || div.getBatchParamterInfo().getTxtkonkaishuryo().getValue().isEmpty()) {
            if (div.getBatchParamterInfo().getTxtkonkaikaishi().getValue().isEmpty()) {
                validPairs.add(new ValidationMessageControlPair(
                        IdocheckMessages.Validate日付必須,
                        div.getBatchParamterInfo().getTxtkonkaikaishi()));
            } else if (div.getBatchParamterInfo().getTxtkonkaishuryo().getValue().isEmpty()) {
                validPairs.add(new ValidationMessageControlPair(
                        IdocheckMessages.Validate日付必須,
                        div.getBatchParamterInfo().getTxtkonkaishuryo()));
            } else {
                validPairs.add(new ValidationMessageControlPair(
                        IdocheckMessages.Validate日付必須,
                        div.getBatchParamterInfo().getTxtkonkaikaishi()));
            }
        } else {
            if (!div.getBatchParamterInfo().getTxtkonkaikaishi().getValue().isValid()
                    || !div.getBatchParamterInfo().getTxtkonkaishuryo().getValue().isValid()) {
                // TODO QA415
                if (!div.getBatchParamterInfo().getTxtkonkaikaishi().getValue().isValid()) {
                    validPairs.add(new ValidationMessageControlPair(
                            IdocheckMessages.Validate日付不正,
                            div.getBatchParamterInfo().getTxtkonkaikaishi()));
                } else if (!div.getBatchParamterInfo().getTxtkonkaishuryo().getValue().isValid()) {
                    validPairs.add(new ValidationMessageControlPair(
                            IdocheckMessages.Validate日付不正,
                            div.getBatchParamterInfo().getTxtkonkaishuryo()));
                } else {
                    validPairs.add(new ValidationMessageControlPair(
                            IdocheckMessages.Validate日付不正,
                            div.getBatchParamterInfo().getTxtkonkaikaishi()));
                }
            } else {
                if (div.getBatchParamterInfo().getTxtkonkaishuryo().getValue()
                        .isBefore(div.getBatchParamterInfo().getTxtkonkaikaishi().getValue())) {
                    validPairs.add(new ValidationMessageControlPair(
                            IdocheckMessages.Validate整合性,
                            div.getBatchParamterInfo().getTxtkonkaikaishi()));
                }
            }
        }
        return validPairs;
    }

    private static enum IdocheckMessages implements IValidationMessage {

        Validate日付必須(UrErrorMessages.必須, "今回開始日と終了日両方"),
        Validate日付不正(UrErrorMessages.不正, "日付"),
        Validate整合性(DbzErrorMessages.期間が不正_未来日付不可, "開始日", "終了日");
        private final Message message;

        private IdocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
