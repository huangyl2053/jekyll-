/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 審査会開催場所が存在する地区コードを表すクラスです。
 *
 * @author N1013 松本直樹
 */
public class ShinsakaiKaisaiBashoChikuCode implements Comparable<ShinsakaiKaisaiBashoChikuCode>, IDbColumnMappable, IValueObject {

    private final RString shinsakaiKaisaiBashoChikuCode;

    /**
     * コンストラクタです。
     *
     * @param shinsakaiKaisaiBashoChikuCode shinsakaiKaisaiBashoChikuCode
     */
    public ShinsakaiKaisaiBashoChikuCode(RString 開催場所地区コード) {
        this.shinsakaiKaisaiBashoChikuCode = 開催場所地区コード;
    }

    /**
     * 開催場所地区コードを取得します。
     *
     * @return shinsakaiKaisaiBashoChikuCode
     */
    @Override
    public RString getColumnValue() {
        return shinsakaiKaisaiBashoChikuCode;
    }

    /**
     * 開催場所地区コードを取得します。
     *
     * @return shinsakaiKaisaiBashoChikuCode
     */
    @Override
    public RString value() {
        return shinsakaiKaisaiBashoChikuCode;
    }

    /**
     * 他の審査会開催場所地区コードと比較をします。
     *
     * @param 比較対象 比較対象の審査会開催場所地区コード
     * @return 被保険者番号が同じ値のときは0。比較対象の方が大きければ、0より小さい値。比較対象の方が小さければ、0より大きい値。
     */
    @Override
    public int compareTo(ShinsakaiKaisaiBashoChikuCode 比較対象) {
        return getValue().compareTo(比較対象.getValue());
    }

    private RString getValue() {
        return shinsakaiKaisaiBashoChikuCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ShinsakaiKaisaiBashoChikuCode)) {
            return false;
        }
        ShinsakaiKaisaiBashoChikuCode 比較対象 = (ShinsakaiKaisaiBashoChikuCode) obj;
        return (this.compareTo(比較対象) == 0);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.getValue());
        return hash;
    }
}
