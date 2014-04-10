/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ICodeWrapValueObject;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;

/**
 * 特定疾病区分コードを保持するクラスです。
 *
 * @author N8156 宮本 康
 */
public class TokuteiShippeiKubunCode implements ICodeWrapValueObject, Comparable<TokuteiShippeiKubunCode> {

    private final Code code;

    /**
     * 指定のコードを持った、TokuteiShippeiKubunCodeを生成します。
     *
     * @param code 値
     */
    public TokuteiShippeiKubunCode(Code code) {
        this.code = requireNonNull(code, Messages.E00003.replace("code", getClass().getName()).getMessage());
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
    public int compareTo(TokuteiShippeiKubunCode target) {
        return this.code.compareTo(target.asCode());
    }

    @Override
    public boolean equals(Object target) {
        if (isNull(target) || isNotSameClass(target.getClass())) {
            return false;
        }
        return hasSameValue((TokuteiShippeiKubunCode) target);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.code);
        return hash;
    }

    private boolean isNull(Object target) {
        return target == null;
    }

    private boolean isNotSameClass(Class clazz) {
        return clazz != this.getClass();
    }

    private boolean hasSameValue(TokuteiShippeiKubunCode target) {
        return target.asCode().equals(this.code);
    }
}
