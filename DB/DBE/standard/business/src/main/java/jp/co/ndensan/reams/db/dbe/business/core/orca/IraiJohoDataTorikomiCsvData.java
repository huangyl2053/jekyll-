/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.orca;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.CheckForNull;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 依頼情報データ受取（オルカ）のクラスです。
 *
 * @reamsid_L DBE-1600-010 lishengli
 */
@SuppressWarnings("PMD.UnusedPrivateField")
public class IraiJohoDataTorikomiCsvData implements Serializable, Iterable<IraiJohoDataTorikomiCsvEntity> {

    private static final long serialVersionUID = -1979429572032170708L;
    private final Map<Key, IraiJohoDataTorikomiCsvEntity> elements;

    public IraiJohoDataTorikomiCsvData(List<IraiJohoDataTorikomiCsvEntity> elements) {
        Map<Key, IraiJohoDataTorikomiCsvEntity> map = new HashMap<>();
        for (IraiJohoDataTorikomiCsvEntity e : elements) {
            map.put(new Key(e.get保険者番号(), e.get被保険者番号(), e.get申請日()), e);
        }
        this.elements = Collections.unmodifiableMap(map);
    }

    /**
     * @param shoKisaiHokenshaNo 保険者番号
     * @param hihokenshaNo 被保険者番号
     * @param shinseiYmd 申請日
     * @return 指定の値を持つ{@link IraiJohoDataTorikomiCsvEntity}
     */
    @CheckForNull
    public IraiJohoDataTorikomiCsvEntity getOrNull(RString shoKisaiHokenshaNo, RString hihokenshaNo, FlexibleDate shinseiYmd) {
        return this.elements.get(new Key(shoKisaiHokenshaNo, hihokenshaNo, shinseiYmd));
    }

    /**
     * @return 保持する要素が空の場合、{@code true}.
     */
    public boolean isEmpty() {
        return this.elements.isEmpty();
    }

    @Override
    public Iterator<IraiJohoDataTorikomiCsvEntity> iterator() {
        return this.elements.values().iterator();
    }

    //<editor-fold defaultstate="collapsed" desc="private static final class Key {...}">
    private static final class Key implements Serializable {

        private final RString shoKisaiHokenshaNo, hihokenshaNo;
        private final FlexibleDate shinseiYmd;

        private Key(RString shoKisaiHokenshaNo, RString hihokenshaNo, FlexibleDate shinseiYmd) {
            this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
            this.hihokenshaNo = hihokenshaNo;
            this.shinseiYmd = shinseiYmd;
        }

        private Key(RString shoKisaiHokenshaNo, RString hihokenshaNo, RString shinseiYmdValue) {
            this(shoKisaiHokenshaNo, hihokenshaNo, new FlexibleDate(shinseiYmdValue));
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 47 * hash + Objects.hashCode(this.shoKisaiHokenshaNo);
            hash = 47 * hash + Objects.hashCode(this.hihokenshaNo);
            hash = 47 * hash + Objects.hashCode(this.shinseiYmd);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Key other = (Key) obj;
            if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
                return false;
            }
            if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
                return false;
            }
            return Objects.equals(this.shinseiYmd, other.shinseiYmd);
        }

    }
    //</editor-fold>
}
