/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0490011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0490011.ShikyuketteituchishoSakuseiJyokenDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBCMN43002_高額サービス費支給決定通知書作成です。
 *
 * @reamsid_L DBC-2000-010 chenhui
 */
public class ShikyuketteituchishoSakuseiJyokenValidationHandler {

    private final ShikyuketteituchishoSakuseiJyokenDiv div;

    private static final RString KEY1 = new RString("key1");

    /**
     * 初期化
     *
     * @param div ShikyuketteituchishoSakuseiJyokenDiv
     */
    public ShikyuketteituchishoSakuseiJyokenValidationHandler(ShikyuketteituchishoSakuseiJyokenDiv div) {
        this.div = div;
    }

    /**
     * 入力チェック
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs get入力チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validPairs.add(div.getCcdShiharaiHoho().getCheckMessage());
        if (KEY1.equals(div.getShikyuKetteiTsuchisho().getRadKetteibiIkkatsuKoshinKubun().getSelectedKey())
                && RString.isNullOrEmpty(div.getShikyuKetteiTsuchisho().getTxtketteibi2().getText())) {
            validPairs.add(new ValidationMessageControlPair(
                    new IdocheckMessages(UrErrorMessages.未入力, "決定日"),
                    div.getShikyuKetteiTsuchisho().getTxtketteibi2()));
        }
        if (div.getCcdShutsuryokujun().get出力順ID() == null) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.出力順序を指定)));
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
