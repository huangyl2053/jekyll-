/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2400011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2400011.TesuryoSeikyuKenShinseishoSakuseiParameterDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 住宅改修理由書作成手数料請求書兼申請書作成 のコントローラです。
 *
 * @reamsid_L DBC-2860-010 dangjingjing
 */
public class TesuryoSeikyuKenShinseishoSakuseiParameterValidationHandler {

    private final TesuryoSeikyuKenShinseishoSakuseiParameterDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 住宅改修理由書作成手数料請求書兼申請書作成Div
     */
    public TesuryoSeikyuKenShinseishoSakuseiParameterValidationHandler(TesuryoSeikyuKenShinseishoSakuseiParameterDiv div) {
        this.div = div;
    }

    /**
     * 作成申請年月日空白チェックを行う。
     *
     * @return validPairs バリデーション結果
     */
    public ValidationMessageControlPairs 作成申請年月日空白チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getChushutsuJokenPanel().getTxtRiyushoSakuseiShinseiYMD().getFromValue() == null
                || new RDate("").equals(div.getChushutsuJokenPanel().getTxtRiyushoSakuseiShinseiYMD().getFromValue())
                || div.getChushutsuJokenPanel().getTxtRiyushoSakuseiShinseiYMD().getToValue() == null) {
            validPairs.add(new ValidationMessageControlPair(new TesuryoSeikyuKenShinseishoSakuseiParameterValidationHandler.IdocheckMessages(
                    UrErrorMessages.必須, "作成申請年月日"), div.getChushutsuJokenPanel().getTxtRiyushoSakuseiShinseiYMD()));
        }
        return validPairs;
    }

    /**
     * 作成申請年月日比較チェックを行う。
     *
     * @return validPairs バリデーション結果
     */
    public ValidationMessageControlPairs 作成申請年月日比較チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getChushutsuJokenPanel().getTxtRiyushoSakuseiShinseiYMD().getToValue().
                isBefore(div.getChushutsuJokenPanel().getTxtRiyushoSakuseiShinseiYMD().getFromValue())) {
            RStringBuilder builder = new RStringBuilder();
            builder.append(div.getChushutsuJokenPanel().getTxtRiyushoSakuseiShinseiYMD().getToValue());
            builder.append("-");
            builder.append(div.getChushutsuJokenPanel().getTxtRiyushoSakuseiShinseiYMD().getFromValue());
            validPairs.add(new ValidationMessageControlPair(new TesuryoSeikyuKenShinseishoSakuseiParameterValidationHandler.IdocheckMessages(
                    UrErrorMessages.期間が不正_追加メッセージあり１, builder.toString()), div.getChushutsuJokenPanel().getTxtRiyushoSakuseiShinseiYMD()));
        }
        return validPairs;
    }

    /**
     * 作成申請年月日比較チェックを行う。
     *
     * @return validPairs バリデーション結果
     */
    public ValidationMessageControlPairs 前回作成期間重複チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getChushutsuJokenPanel().getTxtRiyushoSakuseiShinseiYMD().getFromValue().
                isBefore(div.getChushutsuJokenPanel().getTxtZenkaiRiyushoSakuseiShinseiYMD().getToValue())) {
            validPairs.add(new ValidationMessageControlPair(new TesuryoSeikyuKenShinseishoSakuseiParameterValidationHandler.IdocheckMessages(
                    UrWarningMessages.日付の前後関係逆転, div.getChushutsuJokenPanel().getTxtRiyushoSakuseiShinseiYMD().getFromValue().toString(),
                    div.getChushutsuJokenPanel().getTxtZenkaiRiyushoSakuseiShinseiYMD().getToValue().toString()),
                    div.getChushutsuJokenPanel().getTxtRiyushoSakuseiShinseiYMD()));
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
