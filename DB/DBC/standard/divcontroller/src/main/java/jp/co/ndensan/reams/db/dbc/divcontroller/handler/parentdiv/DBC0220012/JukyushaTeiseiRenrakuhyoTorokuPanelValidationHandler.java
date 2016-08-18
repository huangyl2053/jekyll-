/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0220012;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0220012.JukyushaTeiseiRenrakuhyoTorokuPanelDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBCMN81002_受給者訂正連絡票登録
 *
 * @reamsid_L DBC-2101-020 quxiaodong
 */
public class JukyushaTeiseiRenrakuhyoTorokuPanelValidationHandler {

    private final JukyushaTeiseiRenrakuhyoTorokuPanelDiv div;
    private static final RString 発行日 = new RString("発行日");

    /**
     * 初期化です。
     *
     * @param div JukyushaTeiseiRenrakuhyoTorokuPanelDiv
     */
    public JukyushaTeiseiRenrakuhyoTorokuPanelValidationHandler(JukyushaTeiseiRenrakuhyoTorokuPanelDiv div) {
        this.div = div;
    }

    /**
     * 入力チェック
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs get入力チェック() {
        ValidationMessageControlPairs validPairs = div.getJukyushaIdoRenrakuhyo().validateCheck();
        //TODO
        if (div.getOutputJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoHenkoPrintSetting().toString().endsWith("0")) {
            validPairs.add(new ValidationMessageControlPair(
                    new JukyushaTeiseiRenrakuhyoTorokuPanelValidationHandler.IdocheckMessages(
                            UrErrorMessages.必須項目_追加メッセージあり, 発行日.toString())));
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
