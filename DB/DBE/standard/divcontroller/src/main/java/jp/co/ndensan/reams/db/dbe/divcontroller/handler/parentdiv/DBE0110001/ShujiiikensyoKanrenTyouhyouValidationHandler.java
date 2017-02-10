/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0110001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0110001.ShujiiikensyoKanrenTyouhyouDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 要介護認定申請・依頼業務照会のバリデーションハンドラークラスです。
 */
public class ShujiiikensyoKanrenTyouhyouValidationHandler {
    
    private final ShujiiikensyoKanrenTyouhyouDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public ShujiiikensyoKanrenTyouhyouValidationHandler(ShujiiikensyoKanrenTyouhyouDiv div) {
        this.div = div;
    }

    /**
     * 帳票選択チェックを行う。
     *
     * @param validationMessages validationMessages
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs check帳票選択(ValidationMessageControlPairs validationMessages) {
        if (div.getChkShinsei().getSelectedItems().isEmpty()
                && div.getChkNinteiChosa().getSelectedItems().isEmpty()
                && div.getChkShujiiIkensho().getSelectedItems().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(new CheckMessages(UrErrorMessages.選択されていない, "帳票")));
        }
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
