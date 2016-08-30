/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7140001;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7140001.HanyoListParamForKougakuDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 汎用リスト出力(高額合算申請書情報)のValidationです。
 *
 * @reamsid_L DBC-3103-010 dingminghao
 */
public class HanyoListParamForKougakuValidationHandler {

    private final HanyoListParamForKougakuDiv div;
    private static final RString 交付申請書整理番号 = new RString("交付申請書整理番号");

    /**
     * コンストラクタです。
     *
     * @param div 汎用リスト出力(高額合算申請書情報)画面のdiv
     */
    public HanyoListParamForKougakuValidationHandler(HanyoListParamForKougakuDiv div) {
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
                return pairs;
            }
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
