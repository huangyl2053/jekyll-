/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7150001;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7150001.HanyoListParamKougakuGassanJikoFudanDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 汎用リスト(高額合算自己負担額情報)のValidationHandlerです。
 *
 * @reamsid_L DBC-3102-010 dingminghao
 */
public class HanyoListParamKougakuGassanJikoFudanValidationHandler {

    private final HanyoListParamKougakuGassanJikoFudanDiv div;
    private static final RString 交付申請書整理番号 = new RString("交付申請書整理番号");
    private static final RString 出力順 = new RString("出力順");

    /**
     * コンストラクタです。
     *
     * @param div 汎用リスト(高額合算自己負担額情報)画面のdiv
     */
    public HanyoListParamKougakuGassanJikoFudanValidationHandler(HanyoListParamKougakuGassanJikoFudanDiv div) {
        this.div = div;
    }

    /**
     * 入力チェックのメソッドです。
     *
     * @return ValidationMessageControlPairs
     *
     */
    public ValidationMessageControlPairs getCheckMessage() {

        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        RString 支給申請書整理番号From = div.getTxtSikyuSinseishoSeiriBangoKaishi().getValue();
        RString 支給申請書整理番号To = div.getTxtSikyuSinseishoSeiriBangoShuryo().getValue();
        if (null != 支給申請書整理番号From && null != 支給申請書整理番号To
                && RString.EMPTY != 支給申請書整理番号From && RString.EMPTY != 支給申請書整理番号To) {
            int 支給申請書整理番号F = Integer.parseInt(支給申請書整理番号From.toString());
            int 支給申請書整理番号T = Integer.parseInt(支給申請書整理番号To.toString());
            if (支給申請書整理番号T < 支給申請書整理番号F) {
                pairs.add(new ValidationMessageControlPair(
                        new IdocheckMessages(UrErrorMessages.大小関係が不正, 交付申請書整理番号.toString())));
            }
        }
        if (div.getCcdShutsuryokujun().get出力順ID() == null) {
            pairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.未指定, 出力順.toString())));
        }
        return pairs;
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
