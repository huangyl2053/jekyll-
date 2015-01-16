/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.hokensha;

import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.util.Comparators;

/**
 * {@link IKoikiKoseiShichoson}とその実装クラスに適用できる{@link Comparator}です。
 *
 * @author N3327 三浦 凌
 */
public enum KoikiKoseiShichosonMasterComparator implements Comparator<IKoikiKoseiShichosonMaster> {

    /**
     * 加入日の昇順にソートする{@link Comparator}です。
     */
    orderBy加入日 {
                @Override
                public int compare(IKoikiKoseiShichosonMaster o1, IKoikiKoseiShichosonMaster o2) {
                    return Objects.compare(o1.get加入日(), o2.get加入日(), Comparators.naturalOrder());
                }
            };

    /**
     * 昇順ソート用の{@link Comparator}を返します。
     *
     * @return 昇順ソート用の{@link Comparator}
     */
    public Comparator<IKoikiKoseiShichosonMaster> asc() {
        return this;
    }

    /**
     * 降順ソート用の{@link Comparator}を返します。
     *
     * @return 降順ソート用の{@link Comparator}
     */
    public Comparator<IKoikiKoseiShichosonMaster> desc() {
        return Collections.reverseOrder(this);
    }
}
