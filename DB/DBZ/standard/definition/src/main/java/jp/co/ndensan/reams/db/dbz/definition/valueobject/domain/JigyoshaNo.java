/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject.domain;

import java.io.Serializable;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.util.Comparators;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 事業者番号を表すクラスです。
 *
 * @author N3317 塚田 萌
 */
public final class JigyoshaNo implements IValueObject, Comparable<JigyoshaNo>, IDbColumnMappable, Serializable {

    /**
     * 空の JigyoshaNo です。{@link #value() value()}で{@link RString#EMPTY}を返します。
     */
    public static final JigyoshaNo EMPTY;

    static {
        EMPTY = new JigyoshaNo(RString.EMPTY);
    }

    private final RString 事業者番号;

    /**
     * コンストラクタです。
     *
     * @param 事業者番号 事業者番号
     */
    public JigyoshaNo(String 事業者番号) {
        this.事業者番号 = (事業者番号 == null) ? null : new RString(事業者番号);
    }

    /**
     * コンストラクタです。
     *
     * @param 事業者番号 事業者番号
     */
    public JigyoshaNo(RString 事業者番号) {
        this.事業者番号 = 事業者番号;
    }

    @Override
    public RString value() {
        return 事業者番号;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null) {
            return false;
        }
        if (!(比較対象 instanceof JigyoshaNo)) {
            return false;
        }
        return Objects.equals(((JigyoshaNo) 比較対象).事業者番号, 事業者番号);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.事業者番号);
        return hash;
    }

    /**
     * 事業者番号を取得します。
     *
     * @return 事業者番号
     */
    @Override
    public RString getColumnValue() {
        return 事業者番号;
    }

    @Override
    public int compareTo(JigyoshaNo 比較対象) {
        return Objects.compare(this.事業者番号, 比較対象.事業者番号, Comparators.NaturalOrderComparator.ASC.getInstance());
    }
}
