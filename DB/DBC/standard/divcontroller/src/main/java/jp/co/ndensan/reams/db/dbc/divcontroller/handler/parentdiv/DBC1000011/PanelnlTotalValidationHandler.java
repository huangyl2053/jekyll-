/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1000011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000011.PanelnlTotalDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 償還払い支給（不支給）決定通知書一括作成の抽象ValidationHandlerクラスです。
 *
 * @reamsid_L DBC-1000-010 zhangzhiming
 */
public class PanelnlTotalValidationHandler {

    private final PanelnlTotalDiv div;
    private static final RString キー = new RString("key0");
    private static final RString 更新する = new RString("key1");

    /**
     * コンストラクタです。
     *
     * @param div 地区認定Div
     */
    public PanelnlTotalValidationHandler(PanelnlTotalDiv div) {
        this.div = div;
    }

    /**
     * 実行するボタン押下の場合、入力チェック実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateCheck() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (キー.equals(div.getRadUketsukebi().getSelectedKey()) && (div.getTxtUketsukebi().getFromValue() == null
                && div.getTxtUketsukebi().getToValue() == null)) {
            validationMessages.add(new ValidationMessageControlPair(new PanelnlTotalValidationHandler.RRVMessages(
                    UrErrorMessages.必須, "受付日"), div.getTxtUketsukebi()));
        }
        if (キー.equals(div.getRadKetteibi().getSelectedKey()) && (div.getTxtKeteibiJoken().getFromValue() == null
                && div.getTxtKeteibiJoken().getToValue() == null)) {
            validationMessages.add(new ValidationMessageControlPair(new PanelnlTotalValidationHandler.RRVMessages(
                    UrErrorMessages.必須, "抽出条件決定日"), div.getTxtKeteibiJoken()));
        }
        if (キー.equals(div.getRadKetteishaUketsukeYM().getSelectedKey()) && div.getTxtKeteishaUketsukeYM().getDomain() == null) {
            validationMessages.add(new ValidationMessageControlPair(new PanelnlTotalValidationHandler.RRVMessages(
                    UrErrorMessages.必須, "決定者受付年月"), div.getTxtKeteishaUketsukeYM()));
        }
        if (更新する.equals(div.getPnlShokanbaraiShikyuKeteiTuchisho().getRadKeteibiIkatsuKoushinnKubun().getSelectedKey())
                && div.getPnlShokanbaraiShikyuKeteiTuchisho().getTxtKeteibiTuchisho().getValue() == null) {
            validationMessages.add(new ValidationMessageControlPair(new PanelnlTotalValidationHandler.RRVMessages(
                    UrErrorMessages.必須, "決定通知書決定日"), div.getPnlShokanbaraiShikyuKeteiTuchisho().getTxtKeteibiTuchisho()));
        }
        if (div.getTxtUketsukebi().getFromValue() != null && div.getTxtUketsukebi().getToValue() != null
                && div.getTxtUketsukebi().getToValue()
                .isBefore(div.getTxtUketsukebi().getFromValue())) {
            validationMessages.add(new ValidationMessageControlPair(new PanelnlTotalValidationHandler.RRVMessages(
                    UrErrorMessages.必須, "受付日From", "受付日To"), div.getTxtUketsukebi()));
        }
        if (div.getTxtKeteibiJoken().getFromValue() != null && div.getTxtKeteibiJoken().getToValue() != null
                && div.getTxtKeteibiJoken().getToValue()
                .isBefore(div.getTxtKeteibiJoken().getFromValue())) {
            validationMessages.add(new ValidationMessageControlPair(new PanelnlTotalValidationHandler.RRVMessages(
                    UrErrorMessages.必須, "抽出条件決定日From", "抽出条件決定日To"), div.getTxtKeteibiJoken()));
        }
        validationMessages.add(div.getKogakuShikyuKetteiTsuchiSakuseishoPaymentMethod().getCheckMessage());
        return validationMessages;
    }

    private static final class RRVMessages implements IValidationMessage {

        private final Message message;

        private RRVMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
