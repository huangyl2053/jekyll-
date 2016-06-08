/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.messagemapping;

import jp.co.ndensan.reams.ur.urz.business.core.internalreportoutput.InternalReportValidationMessage;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 賦課エラー一覧内部帳票画面で使用する、バリデーションメッセージをマッピングするための列挙値です。
 *
 * @author n8178 城間篤人
 */
//TODO n8223 バリデーションの構成が変更があり、その対応必要。
public enum FukaErrorValidationMessageMapping {

//    エラー処理対象が未処理でない((IValidationMessage) InternalReportValidationMessage.更正対象が未処理状態ではないため実行不可.getMessage(), "dgFukaErrorList");
    //更正対象が未処理状態ではないため実行不可→修正対象が未処理状態ではないため実行不可 へ変更
    /**
     * エラー処理対象が未処理でない。
     */
    エラー処理対象が未処理でない((IValidationMessage) InternalReportValidationMessage.修正対象が未処理状態ではないため実行不可.getMessage(), new RString("dgFukaErrorList"));

    private final IValidationMessage message;
    private final RString fieldName;

    private FukaErrorValidationMessageMapping(IValidationMessage message, RString fieldName) {
        this.message = message;
        this.fieldName = fieldName;
    }

    /**
     * ValidationMessageを返します。
     *
     * @return IValidationMessage
     */
    public IValidationMessage getValidationMessage() {
        return message;
    }

    /**
     * Messageを返します。
     *
     * @return Message
     */
    public Message getMessage() {
        return message.getMessage();
    }

    /**
     * FieldNameを返します。
     *
     * @return FieldName
     */
    public RString getFieldName() {
        return fieldName;
    }
}
