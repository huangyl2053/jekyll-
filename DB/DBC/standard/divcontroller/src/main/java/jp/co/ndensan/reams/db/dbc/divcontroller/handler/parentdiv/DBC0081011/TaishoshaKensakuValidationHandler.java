/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0081011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.saisinsaketeijyohou.TaishoshaKensakuBusiness;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0081011.TaishoshaKensakuDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBCMN11004_高額介護サービス費照会のバリデーションクラスです。
 *
 * @reamsid_L DBC-3040-010 zhangzhiming
 */
public class TaishoshaKensakuValidationHandler {

    private final TaishoshaKensakuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public TaishoshaKensakuValidationHandler(TaishoshaKensakuDiv div) {
        this.div = div;
    }

    /**
     * 取扱年月未入力チェック実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 取扱年月未入力Check() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (div.getTxtToriatsukaiYM().getValue() == null) {
            validationMessages.add(new ValidationMessageControlPair(new TaishoshaKensakuValidationHandler.RRVMessages(
                    UrErrorMessages.必須項目)));
        }
        return validationMessages;
    }

    /**
     * 再審査決定情報を取得します。
     *
     * @param 再審査決定情報 再審査決定情報
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 再審査決定情報(List<TaishoshaKensakuBusiness> 再審査決定情報) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (再審査決定情報.isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(new TaishoshaKensakuValidationHandler.RRVMessages(
                    UrErrorMessages.データが存在しない)));
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
