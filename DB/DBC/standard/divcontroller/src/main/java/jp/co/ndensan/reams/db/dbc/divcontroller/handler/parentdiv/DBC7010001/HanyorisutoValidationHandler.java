/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7010001;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7010001.HanyorisutoPanelDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 汎用リスト 居宅サービス計画
 *
 * @reamsid_L DBC-3091-010 x_youyj
 */
public class HanyorisutoValidationHandler {

    /**
     * 出力順未設定チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div KoshinTaishoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 出力順未設定チェック(
            ValidationMessageControlPairs pairs, HanyorisutoPanelDiv div) {

        if (div.getCcdChohyoShutsuryokujun().get出力順ID() == null || div.getCcdChohyoShutsuryokujun().get出力順ID().toString().isEmpty()) {
            pairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.出力順序を指定)));
        }
        return pairs;
    }

    private static class IdocheckMessages implements IValidationMessage {

        private final Message message;

        public IdocheckMessages(IMessageGettable message, String... replacements) {
            if (replacements.length == 0) {
                this.message = message.getMessage();
            } else {
                this.message = message.getMessage().replace(replacements);
            }
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
