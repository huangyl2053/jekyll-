/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import static java.util.Objects.requireNonNull;

/**
 * 認定有効期間月数を保持するクラスです。
 *
 * @author N8156 宮本 康
 */
public class NinteiYukoKikanTsukisu implements IValueObject<Integer>, Comparable<NinteiYukoKikanTsukisu> {

    private final Integer theValue;

    /**
     * 指定の値を持った、NinteiYukoKikanTsukisuを生成します。
     *
     * @param value 値
     * @throws NullPointerException
     */
    public NinteiYukoKikanTsukisu(Integer value) {
        requireNonNull(value, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("value", getClass().getName()));
        this.theValue = value;
    }

    @Override
    public Integer value() {
        return this.theValue;
    }

    @Override
    public int compareTo(NinteiYukoKikanTsukisu target) {
        return this.theValue.compareTo(target.value());
    }

    @Override
    public boolean equals(Object target) {
        if (isNull(target) || isNotSameClass(target.getClass())) {
            return false;
        }
        return hasSameValue((NinteiYukoKikanTsukisu) target);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + theValue;
        return hash;
    }

    private boolean isNull(Object target) {
        return target == null;
    }

    private boolean isNotSameClass(Class clazz) {
        return clazz != this.getClass();
    }

    private boolean hasSameValue(NinteiYukoKikanTsukisu target) {
        return target.value().equals(this.theValue);
    }
}
