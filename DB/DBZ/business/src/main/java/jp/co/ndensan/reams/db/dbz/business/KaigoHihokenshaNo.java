/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護保険被保険者番号のクラスです。
 *
 * @author N3327 三浦 凌
 */
public class KaigoHihokenshaNo implements Comparable<KaigoHihokenshaNo> {

    private final RString 被保険者番号;

    /**
     * コンストラクタ
     *
     * @param 被保険者番号 被保険者番号に対応する文字列
     */
    public KaigoHihokenshaNo(RString 被保険者番号) {
        this.被保険者番号 = 被保険者番号;
    }

    /**
     * 被保険者番号の値を取得します。
     *
     * @return 被保険者番号の値
     */
    public RString getValue() {
        return 被保険者番号;
    }

    /**
     * 被保険者番号と比較をします。
     *
     * @param 比較対象 比較対象の被保険者番号
     * @return
     * 被保険者番号が同じ値のときは0。比較対象のほうが数値的に大きければ、0より小さい値。比較対象のほうが数値的に小さければ、0より大きい値。
     */
    @Override
    public int compareTo(KaigoHihokenshaNo 比較対象) {
        return getValue().compareTo(比較対象.getValue());
    }

    @Override
    public String toString() {
        return 被保険者番号.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof KaigoHihokenshaNo)) {
            return false;
        }
        KaigoHihokenshaNo 比較対象 = (KaigoHihokenshaNo) obj;
        return (this.compareTo(比較対象) == 0);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.getValue());
        return hash;
    }
}
