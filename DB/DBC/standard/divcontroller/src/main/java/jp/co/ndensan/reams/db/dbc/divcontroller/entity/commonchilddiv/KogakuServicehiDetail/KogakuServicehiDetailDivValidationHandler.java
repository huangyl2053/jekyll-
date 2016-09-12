/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuServicehiDetail;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_KogakuServicehiDetail_高額サービス費詳細内容入力共有子Div
 *
 * @reamsid_L DBC-4380-010 quxiaodong
 */
public class KogakuServicehiDetailDivValidationHandler {

    private final KogakuServicehiDetailDiv div;
    private static final RString 受付日と決定日 = new RString("受付日と決定日");

    /**
     * コンストラクタです。
     *
     * @param div KogakuKyufuTaishoListDiv
     */
    public KogakuServicehiDetailDivValidationHandler(KogakuServicehiDetailDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div 画面DIV
     * @return KogakuKyufuTaishoListDiv
     */
    public static KogakuServicehiDetailDivValidationHandler of(KogakuServicehiDetailDiv div) {
        return new KogakuServicehiDetailDivValidationHandler(div);
    }

    /**
     * 受付日と決定日のチェックです。
     *
     * @return validPairs
     */
    public ValidationMessageControlPairs 受付日と決定日のチェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getTxtKetteiYMD().getValue() != null && div.getTxtUketsukeYMD().getValue() != null
                && div.getTxtKetteiYMD().getValue().compareTo(div.getTxtUketsukeYMD().getValue()) < 0) {
            validPairs.add(new ValidationMessageControlPair(
                    new KogakuServicehiDetailDivValidationHandler.IdocheckMessages(
                            UrErrorMessages.大小関係が不正, 受付日と決定日.toString())));
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
