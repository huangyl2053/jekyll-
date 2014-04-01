/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.comparator;

import jp.co.ndensan.reams.db.dbz.business.IHihokenshaNoGettable;
import java.util.Comparator;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.SortOrder;

/**
 * {@link IHihokenshaNoGettable 被保険者番号を取得可能なオブジェクト}専用のComparatorです。
 *
 * @author N3327 三浦 凌
 * @param <T> {@link IHihokenshaNoGettable IHihokenshaNoGettable}を継承したオブジェクト
 */
public class HihokenshaNoComparator<T extends IHihokenshaNoGettable> implements Comparator<T> {

    private SortOrder order;

    /**
     * ソート順を指定して、HihokenshaNoComparatorを生成します。<br />
     * {@link SortOrder#ASC SortOrder.ASC}のときは、昇順ソート用のComparatorを、
     * {@link SortOrder#DESC SortOrder.DESC}のときは、降順ソート用のComparatorを生成します。
     *
     * @param order {@link SortOrder ソート順}
     */
    public HihokenshaNoComparator(SortOrder order) {
        this.order = order;
    }

    @Override
    public int compare(T o1, T o2) {
        return o1.get被保険者番号().compareTo(o2.get被保険者番号()) * order.getRate();
    }
}
