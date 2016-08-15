/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0220001;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0220001.HanyoListFukaDaichoParamDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * バッチ設計_DBBBT22001_汎用リスト 賦課台帳ValidationHandlerのクラス
 *
 * @reamsid_L DBB-1900-030 surun
 */
public class HanyoListFukaDaichoParamValidationHandler {

    private final HanyoListFukaDaichoParamDiv div;

    /**
     * コンストラクタです。
     *
     * @param div HanyoListFukaDaichoParamDiv
     */
    public HanyoListFukaDaichoParamValidationHandler(HanyoListFukaDaichoParamDiv div) {
        this.div = div;
    }

    /**
     * validateForAction
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateForAction() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (!div.getNendoKijumbiSitei().getChkKijyunbiSiteiUmu().isAllSelected() && div.getNendoKijumbiSitei().getTxtKijyunbi().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.必須項目),
                    div.getNendoKijumbiSitei().getTxtKijyunbi()));
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
