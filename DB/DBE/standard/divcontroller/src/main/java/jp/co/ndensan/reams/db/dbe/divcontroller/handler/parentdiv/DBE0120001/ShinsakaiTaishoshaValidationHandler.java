/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0120001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaitaishosha.ShinsakaiTaishoshaBusiness;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0120001.ShinsakaiTaishoshaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0120001.dgTaishoshaIchiran_Row;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 審査会個人別状況照会画面のチェッククラスです。
 *
 * @reamsid_L DBE-1380-010 jinjue
 */
public class ShinsakaiTaishoshaValidationHandler {

    private final ShinsakaiTaishoshaDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ShinsakaiTaishoshaDiv
     */
    public ShinsakaiTaishoshaValidationHandler(ShinsakaiTaishoshaDiv div) {
        this.div = div;
    }

    /**
     * 審査会対象者一覧データグリッドが0件の場合、バリデーションチェックを行ます。
     *
     * @param 審査会対象者一覧 審査会対象者一覧データ
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateForKakutei(List<ShinsakaiTaishoshaBusiness> 審査会対象者一覧) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        List<dgTaishoshaIchiran_Row> ichiranList = div.getDgTaishoshaIchiran().getDataSource();
        if (ichiranList.isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.該当データなし)));
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
