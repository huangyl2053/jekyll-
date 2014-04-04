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
 * 要介護状態像例コードを保持するクラスです。
 *
 * @author N8156 宮本 康
 */
public class YokaigoJotaizoReiCode implements ICodeWrapValueObject, Comparable<YokaigoJotaizoReiCode> {

    private final Code code;

    /**
     * 指定のコードを持った、YokaigoJotaizoReiCodeを生成します。
     *
     * @param code 値
     */
    public YokaigoJotaizoReiCode(Code code) {
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
    public int compareTo(YokaigoJotaizoReiCode target) {
        return this.code.compareTo(target.asCode());
    }

    @Override
    public boolean equals(Object target) {
        if (isNull(target) || isNotSameClass(target.getClass())) {
            return false;
        }
        return hasSameValue((YokaigoJotaizoReiCode) target);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.code);
        return hash;
    }

    private boolean isNull(Object target) {
        return target == null;
    }

    private boolean isNotSameClass(Class clazz) {
        return clazz != this.getClass();
    }

    private boolean hasSameValue(YokaigoJotaizoReiCode target) {
        return target.asCode().equals(this.code);
    }
}
