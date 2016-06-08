/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1070011;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1070011.TennyuTenshutsuHoryuTaishoshaIchiranDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 転入転出保留対象者管理ValidationHandlerクラスです。
 *
 * @reamsid_L DBA-0470-030 wangxiaodong
 */
public class TennyuTenshutsuHoryuTaishoshaIchiranValidationHandler {

    private final TennyuTenshutsuHoryuTaishoshaIchiranDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 調査委託先/調査員入力共有子のエンティティ
     */
    public TennyuTenshutsuHoryuTaishoshaIchiranValidationHandler(TennyuTenshutsuHoryuTaishoshaIchiranDiv div) {
        this.div = div;
    }

    /**
     * 画面側バリデーションを実施します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs doCheck() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (div.getDgTenshutsu().getSelectedItems().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(IdoValidationMessage.必須));
        }
        return validationMessages;
    }

    private enum IdoValidationMessage implements IValidationMessage {

        必須(UrErrorMessages.必須, "選択チェックボックス");

        private final Message message;

        private IdoValidationMessage(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
