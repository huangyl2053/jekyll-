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
 * 介護保険被保険者番号です。<br />
 * DBの列に対してマッピング可能な業務ドメイン型です。
 *
 * @author N3327 三浦 凌
 */
public class KaigoHihokenshaNo implements IValueObject<RString>, Comparable<KaigoHihokenshaNo>, IDbColumnMappable {

    private static final int PERMISSIBLE_LENGTH = 10;
    private final RString 被保険者番号;

    /**
     * 指定した値から、被保険者番号を生成します。
     *
     * @param value 被保険者番号に相当するRString
     * @throws NullPointerException 指定のRStringがnullのとき
     * @throws IllegalArgumentException 指定のRStringが10桁でないとき
     */
    public KaigoHihokenshaNo(RString value) throws NullPointerException, IllegalArgumentException {
        requireNonNull(value, Messages.E00003.replace("value", getClass().getName()).getMessage());
        validate(value);
        this.被保険者番号 = value;

    }

    /**
     * 被保険者番号の値を取得します。
     *
     * @return 被保険者番号の値
     * @deprecated {@link KaigoHihokenshaNo#value() value()}を使用してください。
     */
    @Deprecated
    public RString getValue() {
        return 被保険者番号;
    }

    /**
     * 被保険者番号の値を取得します。
     *
     * @return 被保険者番号
     */
    @Override
    public RString value() {
        return this.被保険者番号;
    }

    /**
     * 他の被保険者番号と比較をします。<br />
     * 数字だけの被保険者番号の場合、数値的に小さいものを、小さい番号と判断します。<br />
     * ‘H’から始まる被保険者番号との比較にも対応しており、数字だけのものと比較した場合は、それらは大きい番号と判断されます。
     *
     * @param target 比較対象の被保険者番号
     * @return 被保険者番号が同じ値のときは0。比較対象の方が大きければ、0より小さい値。比較対象の方が小さければ、0より大きい値。
     */
    @Override
    public int compareTo(KaigoHihokenshaNo target) {
        return value().compareTo(target.value());
    }

    @Override
    public String toString() {
        return this.被保険者番号.toString();
    }

    @Override
    public boolean equals(Object target) {
        if (isNull(target)) {
            return false;
        }
        if (isNotSameClass(target.getClass())) {
            return false;
        }
        return hasSameValue((KaigoHihokenshaNo) target);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.value());
        return hash;
    }

    @Override
    public RString getColumnValue() {
        return this.被保険者番号;
    }

    private void validate(RString value) throws IllegalArgumentException {
        if (value.length() != PERMISSIBLE_LENGTH) {
            throw new IllegalArgumentException(Messages.E00013.replace("被保険者番号", PERMISSIBLE_LENGTH + "桁").getMessage());
        }
    }

    private boolean isNull(Object target) {
        return target == null;
    }

    private boolean isNotSameClass(Class clazz) {
        return clazz != this.getClass();
    }

    private boolean hasSameValue(KaigoHihokenshaNo target) {
        return target.value().equals(this.被保険者番号);
    }
}
