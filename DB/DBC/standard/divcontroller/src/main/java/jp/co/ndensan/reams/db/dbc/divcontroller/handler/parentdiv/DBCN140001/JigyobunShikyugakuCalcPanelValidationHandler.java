/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBCN140001;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBCN140001.JigyobunShikyugakuCalcPanelDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBCMNN1004_事業分支給額計算
 *
 * @reamsid_L DBC-4830-010 quxiaodong
 */
public class JigyobunShikyugakuCalcPanelValidationHandler {

    private final JigyobunShikyugakuCalcPanelDiv div;

    /**
     * 初期化です。
     *
     * @param div JigyobunShikyugakuCalcPanelDiv
     */
    public JigyobunShikyugakuCalcPanelValidationHandler(JigyobunShikyugakuCalcPanelDiv div) {
        this.div = div;
    }

    /**
     * 入力チェック
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs get入力値の妥当性チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (!div.getCcdShutsuryokujun().isSelected()) {
            validPairs.add(new ValidationMessageControlPair(
                    new JigyobunShikyugakuCalcPanelValidationHandler.IdocheckMessages(
                            UrErrorMessages.出力順序を指定)));
        }
        if ((div.getKoshinNaiyo().getTxtKaishiDate().getValue() != null
                && !div.getKoshinNaiyo().getTxtKaishiDate().getValue().isEmpty())
                && (div.getKoshinNaiyo().getTxtShuryoDate().getValue() != null
                && !div.getKoshinNaiyo().getTxtShuryoDate().getValue().isEmpty())
                && (div.getKoshinNaiyo().getTxtShuryoDate().getValue().isBeforeOrEquals(
                        div.getKoshinNaiyo().getTxtKaishiDate().getValue()))) {
            validPairs.add(new ValidationMessageControlPair(
                    new JigyobunShikyugakuCalcPanelValidationHandler.IdocheckMessages(
                            UrErrorMessages.終了日が開始日以前)));
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
