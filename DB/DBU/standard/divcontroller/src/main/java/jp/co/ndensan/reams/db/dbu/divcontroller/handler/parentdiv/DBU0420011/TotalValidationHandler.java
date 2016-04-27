/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0420011;

import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0420011.TotalDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 被保険者証・資格者証管理チェッククラスです。
 *
 * @reamsid_L DBU-0490-010 zhangzhiming
 */
public class TotalValidationHandler {

    private final TotalDiv div;
    private static final RString MENUID_DBUMN12001 = new RString("DBUMN12001");
    private static final RString MENUID_DBUMN12002 = new RString("DBUMN12002");
    private static final RString MENUID_DBUMN12003 = new RString("DBUMN12003");

    /**
     * コンストラクタです。
     *
     * @param div 地区認定Div
     */
    public TotalValidationHandler(TotalDiv div) {
        this.div = div;
    }

    /**
     * 入力チェック実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateCheck() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (MENUID_DBUMN12001.equals(ResponseHolder.getMenuID()) && (div.getShikakuShaShoHakko()
                .getCcdHihokenshaShikakuHakko().getYukoKigenInfo().getTxtKofuDate().getValue().isEmpty()
                || div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getYukoKigenInfo().getTxtKofuDate().getValue() == null)) {
            validationMessages.add(new ValidationMessageControlPair(new TotalValidationHandler.RRVMessages(
                    UrErrorMessages.必須, "交付日")));
        }
        if (MENUID_DBUMN12002.equals(ResponseHolder.getMenuID())) {
            if (div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getYukoKigenInfo().getTxtYukoKigen().getValue() == null) {
                validationMessages.add(new ValidationMessageControlPair(new TotalValidationHandler.RRVMessages(
                        UrErrorMessages.必須, "有効期限")));
            }
            if (div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getYukoKigenInfo().getTxtKofuDate().getValue().isEmpty()
                    || div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getYukoKigenInfo().getTxtKofuDate().getValue() == null) {
                validationMessages.add(new ValidationMessageControlPair(new TotalValidationHandler.RRVMessages(
                        UrErrorMessages.必須, "交付日")));
            }
        }
        if (MENUID_DBUMN12003.equals(ResponseHolder.getMenuID()) && (RString.isNullOrEmpty(div
                .getJukyuSikakuShomeiHakko().getCcdJukyuSikakuShomeishoHakko()
                .getJukyuSikakuShomeishoHakkoDiv().getPnlJukyushaJoho1().getTxtKofubi().getValue()))) {
            validationMessages.add(new ValidationMessageControlPair(new TotalValidationHandler.RRVMessages(
                    UrErrorMessages.必須, "交付日")));
        }
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
