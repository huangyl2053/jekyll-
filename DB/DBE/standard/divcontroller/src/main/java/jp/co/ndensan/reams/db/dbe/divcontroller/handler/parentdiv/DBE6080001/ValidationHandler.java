/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6080001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshosakuseiryonyuryoku.ShujiiJohoBusiness;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6080001.ShujiiIkenshoSakuseiryoNyuryokuDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 主治医意見書作成料入力のバリデーションチェッククラスです。
 *
 * @reamsid_L DBE-1960-010 xuyannan
 */
public class ValidationHandler {

    private final ShujiiIkenshoSakuseiryoNyuryokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 主治医意見書作成料入力Div
     */
    public ValidationHandler(ShujiiIkenshoSakuseiryoNyuryokuDiv div) {
        this.div = div;
    }

    /**
     * 最大表示件数の必須入力チェックを実施します。
     *
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs validateForMaxCount() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getShujiiKensakuJoken().getTxtMaxCount().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(
                    ValidationCheckMessages.Validate最大表示件数の必須入力チェック, div.getShujiiKensakuJoken().getTxtMaxCount()));
        }
        return validPairs;
    }

    /**
     * 主治医情報あり/なしチェックを実施します。
     *
     * @param businessList 主治医情報
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs validateData(List<ShujiiJohoBusiness> businessList) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (businessList == null || businessList.isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(
                    ValidationCheckMessages.Validate該当データなし, div.getShujii().getDgShujii()));
        }
        return validPairs;
    }

    private static enum ValidationCheckMessages implements IValidationMessage {

        Validate最大表示件数の必須入力チェック(UrErrorMessages.必須, "最大表示件数"),
        Validate該当データなし(UrErrorMessages.該当データなし);
        private final Message message;

        private ValidationCheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
