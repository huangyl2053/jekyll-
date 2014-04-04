/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ICodeWrapValueObject;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護状態区分コードを保持するクラスです。
 *
 * @author N8156 宮本 康
 */
public class YokaigoJotaiKubunCode implements ICodeWrapValueObject, Comparable<YokaigoJotaiKubunCode> {

    private final Code code;

    /**
     * 指定のコードを持った、YokaigoJotaiKubunCodeを生成します。
     *
     * @param code 値
     */
    public YokaigoJotaiKubunCode(Code code) {
        this.code = code;
    }

    @Override
    public Code asCode() {
        return this.code;
    }

    @Override
    public RString value() {
        return this.code.value();
    }

    @Override
    public int compareTo(YokaigoJotaiKubunCode target) {
        return this.code.compareTo(target.asCode());
    }

    @Override
    public boolean equals(Object target) {
        if (isNull(target) || isNotSameClass(target.getClass())) {
            return false;
        }
        return hasSameValue((YokaigoJotaiKubunCode) target);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.code);
        return hash;
    }

    private boolean isNull(Object target) {
        return target == null;
    }

    private boolean isNotSameClass(Class clazz) {
        return clazz != this.getClass();
    }

    private boolean hasSameValue(YokaigoJotaiKubunCode target) {
        return target.asCode().equals(this.code);
    }
}
