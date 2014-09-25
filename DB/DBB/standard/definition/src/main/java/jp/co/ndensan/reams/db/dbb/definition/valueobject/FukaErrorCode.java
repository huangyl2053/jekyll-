/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.valueobject;

import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ICodeWrapValueObject;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 賦課のエラーコードを表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class FukaErrorCode implements ICodeWrapValueObject, Comparable<FukaErrorCode> {

    private final Code errorCode;

    /**
     * 指定の値を持った、FukaErrorCodeを生成します。
     *
     * @param errorCode 賦課エラーコード
     * @throws NullPointerException 賦課エラーコードにnullが渡されたとき
     */
    public FukaErrorCode(Code errorCode) throws NullPointerException {
        requireNonNull(errorCode, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("賦課エラーコード", getClass().getName()));
        this.errorCode = errorCode;
    }

    @Override
    public Code asCode() {
        return errorCode;
    }

    @Override
    public RString value() {
        return errorCode.value();
    }

    @Override
    public int compareTo(FukaErrorCode target) {
        return this.errorCode.compareTo(target.asCode());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.errorCode);
        return hash;
    }

    @Override
    public boolean equals(Object target) {
        if (isNull(target) || isNotSameClass(target.getClass())) {
            return false;
        }
        return hasSameValue((FukaErrorCode) target);
    }

    private boolean isNull(Object target) {
        return target == null;
    }

    private boolean isNotSameClass(Class clazz) {
        return clazz != this.getClass();
    }

    private boolean hasSameValue(FukaErrorCode target) {
        return target.value().equals(this.errorCode.value());
    }
}
