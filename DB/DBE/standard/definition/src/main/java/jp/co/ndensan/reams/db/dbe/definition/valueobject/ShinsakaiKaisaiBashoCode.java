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
 * 開催場所コードを表すクラスです。
 *
 * @author N1013 松本直樹
 */
public class ShinsakaiKaisaiBashoCode implements Comparable<ShinsakaiKaisaiBashoCode>, IDbColumnMappable, IValueObject {

    private final RString 開催場所コード;

    /**
     * コンストラクタです。
     *
     * @param 開催場所コード 開催場所コード
     */
    public ShinsakaiKaisaiBashoCode(RString 開催場所コード) {
        this.開催場所コード = 開催場所コード;
    }

    /**
     * 開催場所コードを取得します。
     *
     * @return 開催場所コード
     */
    @Override
    public RString getColumnValue() {
        return 開催場所コード;
    }

    /**
     * 開催場所コードを返します。
     *
     * @return 開催場所コード
     */
    @Override
    public RString value() {
        return 開催場所コード;
    }

    /**
     * 他の審査会開催場所コードと比較をします。
     *
     * @param 比較対象 比較対象の審査会開催場所コード
     * @return 被保険者番号が同じ値のときは0。比較対象の方が大きければ、0より小さい値。比較対象の方が小さければ、0より大きい値。
     */
    @Override
    public int compareTo(ShinsakaiKaisaiBashoCode 比較対象) {
        return getValue().compareTo(比較対象.getValue());
    }

    private RString getValue() {
        return 開催場所コード;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ShinsakaiKaisaiBashoCode)) {
            return false;
        }
        ShinsakaiKaisaiBashoCode 比較対象 = (ShinsakaiKaisaiBashoCode) obj;
        return (this.compareTo(比較対象) == 0);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.getValue());
        return hash;
    }
}
