/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.parentdiv.NinteiShinseiRenrakusakiJoho;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiRenrakusakiJoho.NinteiShinseiRenrakusakiJoho.NinteiShinseiRenrakusakiJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiRenrakusakiJoho.NinteiShinseiRenrakusakiJoho.dgRenrakusakiIchiran_Row;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 認定申請連絡先情報バリデーションチェックのメッセージクラスです。
 *
 * @reamsid_L DBZ-1300-100 dongyabin
 */
public class NinteiShinseiValidationHandler {

    /**
     * 前回情報が存在しないのチェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check_前回情報() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.対象データなし)));
        return validationMessages;
    }

    /**
     * 登録するボタン押し、バリデーションチェックを実行します。
     *
     * @param div 画面情報
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check_登録する(NinteiShinseiRenrakusakiJohoDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (div.getRenrakusakiNyuryoku().getTxtTelNo().getDomain().isEmpty()
                && div.getRenrakusakiNyuryoku().getTxtMobileNo().getDomain().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.必須項目_追加メッセージあり,
                    "自宅電話番号　または　携帯電話番号"),
                    div.getRenrakusakiNyuryoku().getTxtTelNo(), div.getRenrakusakiNyuryoku().getTxtMobileNo()));
        }
        if (!NinteiShinseiRenrakusakiJohoDiv.ShoriType.KoshinMode.equals(div.getMode_ShoriType())) {
            for (dgRenrakusakiIchiran_Row row : div.getDgRenrakusakiIchiran().getDataSource()) {
                if (row.getRenban().equals(div.getRenrakusakiNyuryoku().getTxtRenban().getValue())) {
                    validationMessages.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.既に登録済,
                            div.getTxtRenban().getValue().toString()), div.getTxtRenban()));
                }
            }
        }
        return validationMessages;
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
