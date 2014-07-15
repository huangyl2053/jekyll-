/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject;

import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 交換情報識別番号を表すクラスです。
 *
 * @author n8223 朴 義一
 */
public class KokanShikibetsuNo implements IDbColumnMappable, IValueObject, Comparable<KokanShikibetsuNo> {

    private final RString kokanShikibetsuNo;

    /**
     * インスタンスを生成します。
     *
     * @param kokanShikibetsuNo 交換情報識別番号
     */
    public KokanShikibetsuNo(RString kokanShikibetsuNo) throws NullPointerException {
        this.kokanShikibetsuNo = kokanShikibetsuNo;
    }

    @Override
    public RString value() {
        return kokanShikibetsuNo;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null) {
            return false;
        }
        if (!(比較対象 instanceof KokanShikibetsuNo)) {
            return false;
        }
        return ((KokanShikibetsuNo) 比較対象).value().equals(kokanShikibetsuNo);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.kokanShikibetsuNo);
        return hash;
    }

    @Override
    public RString getColumnValue() {
        return kokanShikibetsuNo;
    }

    @Override
    public int compareTo(KokanShikibetsuNo 比較対象) {
        return value().compareTo(比較対象.value());
    }
}
