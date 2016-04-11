/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.IryohokenRirekiCommonChildDiv;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 医療保険履歴のValidationHandlerクラスです。
 *
 * @reamsid_L DBA-0230-010 hezhenzhen
 */
public class IryohokenRirekiValidationHandler {

    private final IryohokenRirekiCommonChildDivDiv requestDiv;
    // private static final RString 種別 = new RString("種別");
    private static final RString 保険者番号 = new RString("保険者番号");
    //private static final RString 保険者名称 = new RString("保険者名称");
    //private static final RString 記号番号 = new RString("記号番号");

    public IryohokenRirekiValidationHandler(IryohokenRirekiCommonChildDivDiv requestDiv) {
        this.requestDiv = requestDiv;
    }

    public ValidationMessageControlPairs 種別と保険者番号と保険者名と称記号番号の有効性チェック(IryohokenRirekiCommonChildDivDiv requestDiv) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();

        if (RString.isNullOrEmpty(requestDiv.getPnlIryohokenJoho().getDdlSyubetsu().getSelectedItem())
                && RString.isNullOrEmpty(requestDiv.getPnlIryohokenJoho().getTxtHokensyaKodo().getValue())
                && RString.isNullOrEmpty(requestDiv.getPnlIryohokenJoho().getTxtHokensyaMeisho().getValue())
                && RString.isNullOrEmpty(requestDiv.getPnlIryohokenJoho().getTxtKigoBango().getValue())) {
            validPairs.add(new ValidationMessageControlPair(new IryohokenRirekiValidationHandler.RRVMessages(UrErrorMessages.必須項目, 保険者番号.toString()), requestDiv.getPnlIryohokenJoho().getTxtHokensyaKodo()));
        }

        return validPairs;

    }

    private static class RRVMessages implements IValidationMessage {

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
