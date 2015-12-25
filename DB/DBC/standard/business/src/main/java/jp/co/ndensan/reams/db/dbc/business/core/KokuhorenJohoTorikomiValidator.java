/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.model.validation.IValidatable;
import jp.co.ndensan.reams.ur.urz.model.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;

/**
 *
 * @author N2810 久保 里史
 */
public class KokuhorenJohoTorikomiValidator implements IValidatable {

    private final CheckBoxList 同月過誤分;
    private final CheckBoxList 通常分;
    private final long 出力順;

    public KokuhorenJohoTorikomiValidator(CheckBoxList 同月過誤分, CheckBoxList 通常分, Long 出力順) {
        this.同月過誤分 = 同月過誤分;
        this.通常分 = 通常分;
        this.出力順 = 出力順;
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages validationMessages = ValidationMessagesFactory.createInstance();

        if (同月過誤分.getSelectedItems().isEmpty() && 通常分.getSelectedItems().isEmpty()) {
            validationMessages.add(KokuhorenJohoTorikomiValidationMessages.選択されていない);
        }

        return validationMessages;
    }

    private enum KokuhorenJohoTorikomiValidationMessages implements IValidationMessage {

        選択されていない(UrErrorMessages.選択されていない.getMessage());
        private final Message message;

        /**
         * コンストラクタです。
         *
         * @param no 番号
         * @param message メッセージ
         */
        private KokuhorenJohoTorikomiValidationMessages(Message message) {
            this.message = new ErrorMessage(message.getCode(), message.evaluate());
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
