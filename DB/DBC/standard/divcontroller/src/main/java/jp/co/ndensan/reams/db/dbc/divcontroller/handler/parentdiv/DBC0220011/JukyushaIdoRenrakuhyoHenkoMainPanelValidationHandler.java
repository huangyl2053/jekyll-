/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0220011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0220011.JukyushaIdoRenrakuhyoHenkoMainPanelDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBCMN81002_受給者訂正連絡票登録（対象者検索）
 *
 * @reamsid_L DBC-2101-010 quxiaodong
 */
public class JukyushaIdoRenrakuhyoHenkoMainPanelValidationHandler {

    private final JukyushaIdoRenrakuhyoHenkoMainPanelDiv div;
    private static final RString 定値_メッセージ = new RString("(異動日From、異動日To)、または被保番号");

    /**
     * 初期化です。
     *
     * @param div JukyushaIdoRenrakuhyoHenkoMainPanelDiv
     */
    public JukyushaIdoRenrakuhyoHenkoMainPanelValidationHandler(JukyushaIdoRenrakuhyoHenkoMainPanelDiv div) {
        this.div = div;
    }

    /**
     * 入力チェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs get入力チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel().getTxtIdoDateRange().getFromValue() != null
                && div.getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel().getTxtIdoDateRange().getToValue() != null
                && div.getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel().getTxtIdoDateRange().getToValue().
                isBefore(div.getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel().
                        getTxtIdoDateRange().getFromValue())) {
            validPairs.add(new ValidationMessageControlPair(
                    new JukyushaIdoRenrakuhyoHenkoMainPanelValidationHandler.IdocheckMessages(
                            UrErrorMessages.終了日が開始日以前)));
        }
        if (div.getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel().getTxtIdoDateRange().getFromValue() == null
                && div.getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel().getTxtIdoDateRange().getToValue() == null
                && (div.getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel().getTxtSearchHihoNo().getValue() == null
                || div.getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel().
                getTxtSearchHihoNo().getValue().isEmpty())) {
            validPairs.add(new ValidationMessageControlPair(
                    new JukyushaIdoRenrakuhyoHenkoMainPanelValidationHandler.IdocheckMessages(
                            UrErrorMessages.必須項目_追加メッセージあり, 定値_メッセージ.toString())));
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
