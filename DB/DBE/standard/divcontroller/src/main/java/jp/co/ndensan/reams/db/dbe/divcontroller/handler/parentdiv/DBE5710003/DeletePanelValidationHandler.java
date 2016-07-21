/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5710003;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5710003.DeletePanelDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 要介護認定イメージ情報削除のValidationHandlerクラスです。
 *
 * @reamsid_L DBE-1670-012 dingyi
 */
public class DeletePanelValidationHandler {

    private final DeletePanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 要介護認定イメージ情報削除Div
     */
    public DeletePanelValidationHandler(DeletePanelDiv div) {
        this.div = div;
    }

    /**
     * 「削除」ボタンを押下する場合、入力チェックを実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 入力チェック_btnDelete() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        List<RString> 選択したイメージ対象 = div.getChkImage().getSelectedKeys();
        if (選択したイメージ対象 == null || 選択したイメージ対象.isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(RRVMessages.出力項目を指定));
        }
        return validationMessages;
    }

    /**
     * 「削除」ボタンを押下する場合、調査票(概況+調査票特記)のイメージファイル存在チェックを実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 調査票特記イメージファイル存在チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(RRVMessages.調査票特記存在しない));
        return validationMessages;
    }

    /**
     * 「削除」ボタンを押下する場合、調査票概況イメージファイル存在チェックを実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 調査票概況イメージファイル存在チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(RRVMessages.調査票概況存在しない));
        return validationMessages;
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
     * 「削除」ボタンを押下する場合、その他資料イメージファイル存在チェックを実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs その他資料イメージファイル存在チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(RRVMessages.その他資料存在しない));
        return validationMessages;
    }

    /**
     * 「削除」ボタンを押下する場合、調査票認定調査委託料支払年月日チェックを実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 認定調査委託料支払年月日チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(RRVMessages.調査票削除不可));
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

    private static enum RRVMessages implements IValidationMessage {

        調査票特記存在しない(UrErrorMessages.存在しない, "調査票(概況+調査票特記)のイメージファイル"),
        調査票概況存在しない(UrErrorMessages.存在しない, "調査票概況のイメージファイル"),
        主治医意見書存在しない(UrErrorMessages.存在しない, "主治医意見書のイメージファイル"),
        その他資料存在しない(UrErrorMessages.存在しない, "その他資料のイメージファイル"),
        出力項目を指定(UrErrorMessages.出力項目を指定),
        調査票削除不可(UrErrorMessages.削除不可, "認定調査委託料が支払されました"),
        主治医意見書削除不可(UrErrorMessages.削除不可, "主治医意見書報酬が支払されました");

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
