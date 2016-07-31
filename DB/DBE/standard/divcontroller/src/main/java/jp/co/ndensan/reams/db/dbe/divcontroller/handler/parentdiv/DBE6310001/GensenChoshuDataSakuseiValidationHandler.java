/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6310001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6310001.GensenChoshuDataSakuseiDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 「源泉徴収データ作成」のチェッククラスです。
 *
 * @reamsid_L DBE-2000-010 jinjue
 */
public class GensenChoshuDataSakuseiValidationHandler {

    private final GensenChoshuDataSakuseiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 「源泉徴収データ作成」の div
     */
    public GensenChoshuDataSakuseiValidationHandler(GensenChoshuDataSakuseiDiv div) {
        this.div = div;
    }

    /**
     * 未来日付のチェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateForKakutei() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (!RDate.getNowDate().getYear().equals(div.getTxtNendo().getValue().getYear())) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.期間が不正_追加メッセージあり１,
                    div.getTxtNendo().getValue().getYear().toString(), RDate.getNowDate().getYear().toString())));
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
