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
 * 証記載保険者番号です。<db />
 * 被保険者証等に記載される、保険者の番号です。 DBの列に対してマッピング可能な業務ドメイン型です。
 *
 * @author N3327 三浦 凌
 */
public class ShoKisaiHokenshaNo implements IValueObject<RString>, Comparable<ShoKisaiHokenshaNo>, IDbColumnMappable {

    private static final int PERMISSIBLE_LENGTH = 6;
    private final RString 証記載保険者番号;

    /**
     * 指定の値を持った、ShoKisaiHokenshaNoを生成します。
     *
     * @param value 証記載保険者番号に相当するRString
     * @throws NullPointerException 指定のRStringがnullのとき。
     * @throws IllegalArgumentException 指定のRStringが6桁でないとき。
     */
    public ShoKisaiHokenshaNo(RString value) throws NullPointerException, IllegalArgumentException {
        requireNonNull(value, Messages.E00003.replace("value", getClass().getName()).getMessage());
        validate(value);
        this.証記載保険者番号 = value;
    }

    @Override
    public RString value() {
        return this.証記載保険者番号;
    }

    @Override
    public int compareTo(ShoKisaiHokenshaNo target) {
        return this.証記載保険者番号.compareTo(target.value());
    }

    @Override
    public RString getColumnValue() {
        return this.証記載保険者番号;
    }

    @Override
    public boolean equals(Object target) {
        if (isNull(target) || isNotSameClass(target.getClass())) {
            return false;
        }
        return hasSameValue((ShoKisaiHokenshaNo) target);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.証記載保険者番号);
        return hash;
    }

    private void validate(RString value) throws IllegalArgumentException {
        if (value.length() != PERMISSIBLE_LENGTH) {
            throw new IllegalArgumentException(Messages.E00013.replace("証記載保険者番号", PERMISSIBLE_LENGTH + "桁").getMessage());
        }
    }

    private boolean isNull(Object target) {
        return target == null;
    }

    private boolean isNotSameClass(Class clazz) {
        return clazz != this.getClass();
    }

    private boolean hasSameValue(ShoKisaiHokenshaNo target) {
        return target.value().equals(this.証記載保険者番号);
    }
}
