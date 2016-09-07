/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6220001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6220001.HoshushiharaiJumbiDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBE6220001_報酬支払いValidationHandlerクラスです
 *
 * @reamsid_L DBE-1990-010 lizhuoxuan
 */
public class HoshushiharaiJumbiPanelValidationHandler {

    private final HoshushiharaiJumbiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public HoshushiharaiJumbiPanelValidationHandler(HoshushiharaiJumbiDiv div) {
        this.div = div;
    }

    /**
     * 未選択チェックです
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 振込指定日チェック(ValidationMessageControlPairs validPairs) {
        RDate jissekiDate = div.getTxtJissekiDateRange().getToValue();
        if (jissekiDate != null) {
            FlexibleDate jissekiflexibleDate = new FlexibleDate(jissekiDate.toDateString());
            if (div.getTxtFurikomiShiteiDay().getValue().isBefore(jissekiflexibleDate)) {
                validPairs.
                        add(new ValidationMessageControlPair(HoshushiharaiJumbiPanelValidationHandler.HoshushiharaiJumbiMessages.振込指定日チェック));
            }
        }
        return validPairs;
    }

    private static enum HoshushiharaiJumbiMessages implements IValidationMessage {

        振込指定日チェック(UrErrorMessages.期間が不正_追加メッセージあり１, "振込指定日", "実績期間終了日");
        private final Message message;

        private HoshushiharaiJumbiMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
