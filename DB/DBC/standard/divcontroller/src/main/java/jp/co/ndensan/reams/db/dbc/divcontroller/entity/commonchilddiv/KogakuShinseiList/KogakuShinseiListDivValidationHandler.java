/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuShinseiList;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBCKD00005_高額申請一覧共有子Div
 *
 * @reamsid_L DBC-2020-010 quxiaodong
 */
public class KogakuShinseiListDivValidationHandler {

    private final KogakuShinseiListDiv div;

    /**
     * コンストラクタです。
     *
     * @param div KogakuKyufuTaishoListDiv
     */
    public KogakuShinseiListDivValidationHandler(KogakuShinseiListDiv div) {
        this.div = div;
    }

    /**
     * 入力チェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 入力チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getTxtServiceYMFrom().getDomain() == null && div.getTxtServiceYMTo().getDomain() == null) {
            validPairs.add(new ValidationMessageControlPair(
                    new KogakuShinseiListDivValidationHandler.IdocheckMessages(
                            UrErrorMessages.期間が不正)));
        }
        if (div.getTxtServiceYMFrom().getDomain() != null && div.getTxtServiceYMTo().getDomain() != null
                && div.getTxtServiceYMTo().getDomain().compareTo(div.getTxtServiceYMFrom().getDomain()) < 0) {
            validPairs.add(new ValidationMessageControlPair(
                    new KogakuShinseiListDivValidationHandler.IdocheckMessages(
                            UrErrorMessages.期間が不正_追加メッセージあり２,
                            div.getTxtServiceYMFrom().getDomain().toString(),
                            div.getTxtServiceYMTo().getDomain().toString())));
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
