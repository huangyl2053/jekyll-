/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject;

import java.util.Objects;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;

/**
 * 段階インデックスです。
 *
 * @author N8156 宮本 康
 */
public class DankaiIndex implements IValueObject<RString>, Comparable<DankaiIndex> {

    private final RString 段階インデックス;

    /**
     * 指定の値をもったDankaiIndexを生成します。
     *
     * @param value 段階インデックスに相当するRString
     * @throws NullPointerException 指定のRStringがnullのとき。
     */
    public DankaiIndex(RString value) throws NullPointerException {
        requireNonNull(value, UrSystemErrorMessages.値がnull.getReplacedMessage("段階インデックス"));
        this.段階インデックス = value;
    }

    @Override
    public RString value() {
        return this.段階インデックス;
    }

    @Override
    public boolean equals(Object target) {
        if (isNull(target) || isNotSameClass(target.getClass())) {
            return false;
        }
        return hasSameValue((DankaiIndex) target);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.段階インデックス);
        return hash;
    }

    @Override
    public int compareTo(DankaiIndex target) {
        return this.段階インデックス.compareTo(target.value());
    }

    private boolean isNull(Object target) {
        return target == null;
    }

    private boolean isNotSameClass(Class clazz) {
        return clazz != this.getClass();
    }

    private boolean hasSameValue(DankaiIndex target) {
        return target.value().equals(this.段階インデックス);
    }
}
