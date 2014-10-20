/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.messagemapping;

import jp.co.ndensan.reams.ur.urz.business.internalreport.InternalReportValidationMessage;
import jp.co.ndensan.reams.ur.urz.business.validations.IValidationMessage;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.IValidationMessageMapping;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 賦課エラー一覧内部帳票画面で使用する、バリデーションメッセージをマッピングするための列挙値です。
 *
 * @author n8178 城間篤人
 */
public enum FukaErrorValidationMessageMapping implements IValidationMessageMapping {

    エラー処理対象が未処理でない(InternalReportValidationMessage.更正対象が未処理状態ではないため実行不可, "dgFukaErrorList");

    private final IValidationMessage message;
    private final String fieldName;

    private FukaErrorValidationMessageMapping(IValidationMessage message, String fieldName) {
        this.message = message;
        this.fieldName = fieldName;
    }

    @Override
    public IValidationMessage getValidationMessage() {
        return message;
    }

    @Override
    public Message getMessage() {
        return message.getMessage();
    }

    @Override
    public String getFieldName() {
        return fieldName;
    }

}
