/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0071011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.taishoshakensakubusiness.TaishoshaKensakuRelateBusiness;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 「過誤申立決定情報照会」のValidationHandlerクラスです。
 *
 * @reamsid_L DBC-2940-010 jinjue
 */
public class KetteijohoValidationHandler {

    private final KetteijohoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div KetteijohoDiv
     */
    public KetteijohoValidationHandler(KetteijohoDiv div) {
        this.div = div;
    }

    /**
     * 取扱年月が未入力の場合、バリデーションチェックを行ます。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateForKakutei() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        RString 取扱年月 = new RString("取扱年月");
        if (div.getTxtToriatsukaiYM().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.必須, 取扱年月.toString())));
        }
        return validPairs;
    }

    /**
     * 過誤申立決定情報照会情報を取得します。
     *
     * @param 過誤申立決定情報照会 過誤申立決定情報照会
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 過誤申立決定情報照会(List<TaishoshaKensakuRelateBusiness> 過誤申立決定情報照会) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (過誤申立決定情報照会.isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(new KetteijohoValidationHandler.IdocheckMessages(
                    UrErrorMessages.データが存在しない)));
        }
        return validationMessages;
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
