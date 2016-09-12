/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0830011;

import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0830011.KoikiShichosonJohoKanriDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 広域システム管理のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBU-4010-010 duanzhanli
 */
public class KoikiShichosonJohoKanriValidationHandler {

    /**
     * 保存するボタンを押下するとき、期間チェックを行う。
     *
     * @param requestDiv KoikiShichosonJohoKanriDiv
     * @param 広域加入年月日 広域脱退年月日
     * @param 広域脱退年月日 広域脱退年月日
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor期間チェック(FlexibleDate 広域加入年月日, FlexibleDate 広域脱退年月日,
            KoikiShichosonJohoKanriDiv requestDiv) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(new CheckMessages(UrErrorMessages.期間が不正_追加メッセージあり２,
                広域加入年月日.toString(),
                広域脱退年月日.toString()), requestDiv.getTxtKanyuYMD(), requestDiv.getTxtDattaiYMD()));
        return validationMessages;
    }

    /**
     * 保存するボタンを押下するとき、更新内容チェックを行う。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor更新内容チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(new CheckMessages(UrErrorMessages.更新対象のデータがない)));
        return validationMessages;
    }

    private static class CheckMessages implements IValidationMessage {

        private final Message message;

        public CheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
