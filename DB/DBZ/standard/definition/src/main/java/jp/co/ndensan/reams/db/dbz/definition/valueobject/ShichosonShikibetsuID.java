/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject;

import java.util.Objects;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import static java.util.Objects.requireNonNull;

/**
 * 市町村識別IDです。
 *
 * @author N8156 宮本 康
 */
public class ShichosonShikibetsuID implements IValueObject<RString>, Comparable<ShichosonShikibetsuID>, IDbColumnMappable {

    private final RString 市町村識別ID;

    /**
     * 指定の値をもった、ShichosonShikibetsuIDを生成します。
     *
     * @param value 市町村識別IDに相当するString
     * @throws NullPointerException 指定のStringがnullのとき。
     */
    public ShichosonShikibetsuID(String value) throws NullPointerException {
        this(new RString(value));
    }

    /**
     * 指定の値をもった、ShichosonShikibetsuIDを生成します。
     *
     * @param value 市町村識別IDに相当するRString
     * @throws NullPointerException 指定のRStringがnullのとき。
     */
    public ShichosonShikibetsuID(RString value) throws NullPointerException {
        this.市町村識別ID = requireNonNull(value, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村識別ID"));
    }

    @Override
    public RString value() {
        return this.市町村識別ID;
    }

    @Override
    public boolean equals(Object target) {
        if (isNull(target) || isNotSameClass(target.getClass())) {
            return false;
        }
        return hasSameValue((ShichosonShikibetsuID) target);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.市町村識別ID);
        return hash;
    }

    @Override
    public int compareTo(ShichosonShikibetsuID target) {
        return this.市町村識別ID.compareTo(target.value());
    }

    @Override
    public RString getColumnValue() {
        return this.市町村識別ID;
    }

    private boolean isNull(Object target) {
        return target == null;
    }

    private boolean isNotSameClass(Class clazz) {
        return clazz != this.getClass();
    }

    private boolean hasSameValue(ShichosonShikibetsuID target) {
        return target.value().equals(this.市町村識別ID);
    }
}
