/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject;

import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 支所コードです。<br />
 * DBの列に対してマッピング可能な業務ドメイン型です。
 *
 * @author N3327 三浦 凌
 */
public class ShishoCode implements IValueObject<RString>, Comparable<ShishoCode>, IDbColumnMappable {

    public static final ShishoCode NULL_VALUE;

    static {
        NULL_VALUE = new ShishoCode(RString.EMPTY);
    }

    private final RString 支所コード;

    /**
     * 指定の値を持った、ShishoCodeを生成します。
     *
     * @param value 支所コードに相当するRString
     * @throws NullPointerException 指定のRStringがnullのとき。
     */
    public ShishoCode(RString value) throws NullPointerException {
        requireNonNull(value, Messages.E00003.replace("value", getClass().getName()).getMessage());
        this.支所コード = value;
    }

    @Override
    public RString value() {
        return this.支所コード;
    }

    @Override
    public int compareTo(ShishoCode target) {
        return this.支所コード.compareTo(target.value());
    }

    @Override
    public RString getColumnValue() {
        return this.支所コード;
    }

    @Override
    public boolean equals(Object target) {
        if (isNull(target) || isNotSameClass(target.getClass())) {
            return false;
        }
        return hasSameValue((ShishoCode) target);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.支所コード);
        return hash;
    }

    private boolean isNull(Object target) {
        return target == null;
    }

    private boolean isNotSameClass(Class clazz) {
        return clazz != this.getClass();
    }

    private boolean hasSameValue(ShishoCode target) {
        return target.value().equals(this.支所コード);
    }
}
