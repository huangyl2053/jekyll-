/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBAM010011;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBAM010011.FubanHohoMainDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 被保険者番号付番方法画面のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBA-1200-010 suguangjun
 */
public class FubanHohoMainValidationHandler {

    private final FubanHohoMainDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 被保険者番号付番方法Div
     */
    public FubanHohoMainValidationHandler(FubanHohoMainDiv div) {
        this.div = div;
    }

    /**
     * 確定するボタンを押下するとき、バリデーションチェックを行う。
     *
     * @return validPairs バリデーション結果
     */
    public ValidationMessageControlPairs validateForMaeFukaCode() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        Decimal maeFukaCode = div.getFubanHoho().getMaeFukaJoho().getTxtMaeFukaCode() == null ? Decimal.ZERO
                              : new Decimal(div.getFubanHoho().getMaeFukaJoho().getTxtMaeFukaCode().getValue().length());
        Decimal maeFukaKetasu = div.getFubanHoho().getMaeFukaJoho().getTxtMaeFukaKetasu() == null ? Decimal.ZERO
                                : div.getFubanHoho().getMaeFukaJoho().getTxtMaeFukaKetasu().getValue();
        Decimal atoFukaCode = div.getFubanHoho().getAtoFukaJoho().getTxtAtoFukaCode() == null ? Decimal.ZERO
                              : new Decimal(div.getFubanHoho().getAtoFukaJoho().getTxtAtoFukaCode().getValue().length());
        Decimal atoFukaKetasu = div.getFubanHoho().getAtoFukaJoho().getTxtAtoFukaKetasu() == null ? Decimal.ZERO
                                : div.getFubanHoho().getAtoFukaJoho().getTxtAtoFukaKetasu().getValue();
        if (!maeFukaCode.equals(maeFukaKetasu)) {
            validPairs.add(new ValidationMessageControlPair(new FubanHohoMainValidationHandler.IdocheckMessages(
                    UrErrorMessages.桁数が不正, "前付加コード", div.getFubanHoho().getMaeFukaJoho().getTxtMaeFukaKetasu().getValue().toString())));
        }
        if (!atoFukaCode.equals(atoFukaKetasu)) {
            validPairs.add(new ValidationMessageControlPair(new FubanHohoMainValidationHandler.IdocheckMessages(
                    UrErrorMessages.桁数が不正, "後付加コード", div.getFubanHoho().getAtoFukaJoho().getTxtAtoFukaKetasu().getValue().toString())));
        }
        return validPairs;
    }

    /**
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateForHenkouKakiKubun() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.更新不可, "被保険者番号付番方法は変更不可の設定")));
        return validPairs;
    }

    private static final class IdocheckMessages implements IValidationMessage {

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
