/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0100002;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0100002.ShinseishaDataOutputDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 要介護認定申請検索のバリデーションハンドラークラスです。
 *
 * @author N3212 竹内 和紀
 */
public class ShinseishaDataOutputValidationHandler {

    private final ShinseishaDataOutputDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ShinseishaDataOutputDiv
     */
    public ShinseishaDataOutputValidationHandler(ShinseishaDataOutputDiv div) {
        this.div = div;
    }

    /**
     * 申請検索状態の「CSV出力を実行する」ボタンクリック時のバリデーションチェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateBtnBatchRegister() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (div.getChkOutputCsv().getSelectedKeys().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(
                    ShinseishaDataOutputValidationHandler.RRVMessages.選択されていない, div.getChkOutputCsv()));
        }
        return validationMessages;
    }

    /**
     * 申請一覧状態の「CSV出力を実行する」ボタンクリック時のバリデーションチェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateBtnBatchRegister2() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (div.getChkOutputCsv().getSelectedKeys().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(
                    ShinseishaDataOutputValidationHandler.RRVMessages.選択されていない, div.getChkOutputCsv()));
        }
        if (div.getDgShinseiJoho().getSelectedItems() == null || div.getDgShinseiJoho().getSelectedItems().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(
                    ShinseishaDataOutputValidationHandler.RRVMessages.対象行を選択, div.getDgShinseiJoho()));
        }
        return validationMessages;
    }

    private static enum RRVMessages implements IValidationMessage {

        選択されていない(UrErrorMessages.選択されていない, "出力するCSVファイル"),
        対象行を選択(UrErrorMessages.対象行を選択);

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
