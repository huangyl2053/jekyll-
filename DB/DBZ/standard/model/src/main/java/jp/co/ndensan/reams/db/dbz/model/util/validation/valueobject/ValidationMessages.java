/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject;

import static jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages.必須;
import static jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages.項目に対する制約;
import jp.co.ndensan.reams.ur.urz.model.validations.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * ValueOjbectのチェックで用いるValidationMessageの一覧です。
 *
 * @author N3327 三浦 凌
 */
public enum ValidationMessages implements IValidationMessage {

    /**
     * 文字列が「半角数のみ」でなければならないことを通知するメッセージです。
     */
    半角数のみ(項目に対する制約),
    /**
     * 文字列が「半角英数のみ」でなければならないことを通知するメッセージです。
     */
    半角英数のみ(項目に対する制約),
    /**
     * 「必須入力項目」であることを通知するメッセージです。
     */
    必須入力項目(必須),
    /**
     * 文字列の長さが「指定文字数以上」でなければならないことを通知するメッセージです。
     */
    指定文字数以上(項目に対する制約),
    /**
     * 文字列の長さが「指定文字数以下」でなければならないことを通知するメッセージです。
     */
    指定文字数以下(項目に対する制約),
    /**
     * 文字列の長さが「指定文字数未満」でなければならないことを通知するメッセージです。
     */
    指定文字数未満(項目に対する制約),
    /**
     * 文字列の長さが「指定文字数と一致」しなければならないことを通知するメッセージです。
     */
    指定文字数と一致(項目に対する制約);
    private final Message message;

    private ValidationMessages(IMessageGettable message) {
        this.message = message.getMessage();
    }

    @Override
    public Message getMessage() {
        return this.message;
    }
}
