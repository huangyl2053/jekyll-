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
 * 調定事由コードです。
 *
 * @author N8156 宮本 康
 */
public class ChoteiJiyuCode implements IValueObject<RString>, Comparable<ChoteiJiyuCode> {

    private final RString 調定事由コード;

    /**
     * 指定の値をもったChoteiJiyuCodeを生成します。
     *
     * @param value 調定事由コードに相当するRString
     * @throws NullPointerException 指定のRStringがnullのとき。
     */
    public ChoteiJiyuCode(RString value) throws NullPointerException {
        this.調定事由コード = requireNonNull(value, UrSystemErrorMessages.値がnull.getReplacedMessage("value"));
    }

    @Override
    public RString value() {
        return this.調定事由コード;
    }

    @Override
    public boolean equals(Object target) {
        if (isNull(target) || isNotSameClass(target.getClass())) {
            return false;
        }
        return hasSameValue((ChoteiJiyuCode) target);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.調定事由コード);
        return hash;
    }

    @Override
    public int compareTo(ChoteiJiyuCode target) {
        return this.調定事由コード.compareTo(target.value());
    }

    private boolean isNull(Object target) {
        return target == null;
    }

    private boolean isNotSameClass(Class clazz) {
        return clazz != this.getClass();
    }

    private boolean hasSameValue(ChoteiJiyuCode target) {
        return target.value().equals(this.調定事由コード);
    }
}
