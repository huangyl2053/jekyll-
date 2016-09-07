/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6210001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6210001.HoshushiharaiJumbiDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBE6210001_報酬支払い準備ValidationHandlerクラスです
 *
 * @reamsid_L DBE-1980-010 xuyongchao
 */
public class HoshushiharaiJumbiValidationHandler {

    private final HoshushiharaiJumbiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public HoshushiharaiJumbiValidationHandler(HoshushiharaiJumbiDiv div) {
        this.div = div;
    }

    /**
     * 未選択チェックです
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 出力帳票未指定チェック(ValidationMessageControlPairs validPairs) {
        if (div.getChkChosa().getSelectedKeys().isEmpty() && div.getChkShujii().getSelectedKeys().isEmpty()
                && div.getChkShinsakai().getSelectedKeys().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(HoshushiharaiJumbiValidationHandler.HoshushiharaiJumbiMessages.出力帳票未指定チェック));
        }
        return validPairs;
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
                validPairs.add(new ValidationMessageControlPair(HoshushiharaiJumbiValidationHandler.HoshushiharaiJumbiMessages.振込指定日チェック));
            }
        }
        return validPairs;
    }

    /**
     * 未選択チェックです
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 実績期間チェック(ValidationMessageControlPairs validPairs) {
        if (div.getTxtJissekiDateRange().getToValue().isBefore(div.getTxtJissekiDateRange().getFromValue())) {
            validPairs.add(new ValidationMessageControlPair(HoshushiharaiJumbiValidationHandler.HoshushiharaiJumbiMessages.実績期間チェック));
        }
        return validPairs;
    }

    private static enum HoshushiharaiJumbiMessages implements IValidationMessage {

        実績期間チェック(UrErrorMessages.終了日が開始日以前),
        振込指定日チェック(UrErrorMessages.期間が不正_追加メッセージあり１, "振込指定日", "実績期間終了日"),
        出力帳票未指定チェック(UrErrorMessages.選択されていない, "出力帳票が");
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
