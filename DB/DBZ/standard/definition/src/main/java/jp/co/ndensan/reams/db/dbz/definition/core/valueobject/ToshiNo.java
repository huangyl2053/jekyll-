/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.valueobject;

import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 通番を表すクラスです。
 *
 * @author n8223 朴 義一
 */
public class ToshiNo implements IDbColumnMappable, IValueObject, Comparable<ToshiNo> {

    private final RString 通番;

    /**
     * インスタンスを生成します。
     *
     * @param 通番 通番
     */
    public ToshiNo(RString 通番) {
        this.通番 = 通番;
    }

    @Override
    public RString value() {
        return 通番;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null) {
            return false;
        }
        if (!(比較対象 instanceof ToshiNo)) {
            return false;
        }
        return ((ToshiNo) 比較対象).value().equals(通番);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.通番);
        return hash;
    }

    @Override
    public RString getColumnValue() {
        return 通番;
    }

    @Override
    public int compareTo(ToshiNo 比較対象) {
        return value().compareTo(比較対象.value());
    }
}
