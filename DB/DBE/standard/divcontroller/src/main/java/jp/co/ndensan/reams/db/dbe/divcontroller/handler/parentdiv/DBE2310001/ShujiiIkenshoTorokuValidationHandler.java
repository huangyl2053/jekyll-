/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2310001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2310001.ShujiiIkenshoTorokuTotalDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 主治医意見書登録のValidationHandlerクラスです。
 *
 * @reamsid_L DBE-0070-010 chengsanyuan
 */
public class ShujiiIkenshoTorokuValidationHandler {

    private final ShujiiIkenshoTorokuTotalDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 主治医意見書登録Div
     */
    public ShujiiIkenshoTorokuValidationHandler(ShujiiIkenshoTorokuTotalDiv div) {
        this.div = div;
    }

    /**
     * 「削除」ボタンを押下する場合、主治医意見書イメージファイル存在チェックを実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 主治医意見書イメージファイル存在チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(RRVMessages.主治医意見書存在しない));
        return validationMessages;
    }

    /**
     * 「削除」ボタンを押下する場合、主治医意見書報酬支払年月日チェックを実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 主治医意見書報酬支払年月日チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(RRVMessages.主治医意見書削除不可));
        return validationMessages;
    }

    /**
     * 「削除」ボタンを押下する場合、イメージファイル存在チェックを実行します。
     *
     * @param 存在したイメージファイル名 存在したイメージファイル名
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs イメージファイル存在チェック(List<RString> 存在したイメージファイル名) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (存在したイメージファイル名 == null || 存在したイメージファイル名.isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(RRVMessages.存在しない));
        }
        return validationMessages;
    }

    public ValidationMessageControlPairs validate対象データ() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(RRVMessages.対象データなし));
        return validationMessages;
    }

    private static enum RRVMessages implements IValidationMessage {

        存在しない(UrErrorMessages.存在しない, "イメージファイル"),
        主治医意見書存在しない(UrErrorMessages.存在しない, "主治医意見書のイメージファイル"),
        主治医意見書削除不可(UrErrorMessages.削除不可, "主治医意見書報酬が支払われた"),
        対象データなし(UrErrorMessages.対象データなし);

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
