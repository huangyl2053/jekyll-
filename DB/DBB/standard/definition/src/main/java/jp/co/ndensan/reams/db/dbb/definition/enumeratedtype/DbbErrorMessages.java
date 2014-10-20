/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 介護賦課業務のエラーをまとめた列挙クラスです。
 *
 * @author n8178 城間篤人
 */
public enum DbbErrorMessages implements IMessageGettable {

    /**
     * 賦課更正が必要な場合のエラーメッセージです。
     */
    賦課更正("01", "更正対象の賦課データに減免情報が登録されています。"),
    /**
     * 資格不整合の修正が必要な場合のエラーメッセージです。
     */
    資格不整合("02", "資格期間と住基情報に不整合があります。");
    private final Code errorCode;
    private final Message errorMessage;

    private DbbErrorMessages(String errorCode, String errorMessage) {
        this.errorCode = new Code(errorCode);
        this.errorMessage = new ErrorMessage(errorCode, errorMessage);
    }

    /**
     * エラーコードを返します。
     *
     * @return エラーコード
     */
    public Code getErrorCode() {
        return errorCode;
    }

    /**
     * エラーメッセージを返します。
     *
     * @return エラーメッセージ
     */
    @Override
    public Message getMessage() {
        return errorMessage;
    }

    /**
     * 引数にエラーコードを指定し、対応するエラーメッセージを返します。<br/>
     * 指定したエラーコードに対応するエラーメッセージが存在しない場合、例外が発生します。
     *
     * @param errorCode エラーコード
     * @return エラーメッセージ
     * @throws IllegalArgumentException 指定したエラーコードに対応するエラーメッセージが存在しない場合
     */
    public static DbbErrorMessages toValue(Code errorCode) throws IllegalArgumentException {
        for (DbbErrorMessages message : values()) {
            if (message.getErrorCode().equals(errorCode)) {
                return message;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("指定したコードに該当する賦課エラー").getMessage());
    }

}
