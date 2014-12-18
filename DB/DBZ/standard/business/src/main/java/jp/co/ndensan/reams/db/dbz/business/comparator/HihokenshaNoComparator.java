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
 */
public final class HihokenshaNoComparator implements Comparator<IHihokenshaNoGettable> {

    /**
     * 昇順ソート用のHihokenshaNoComparatorです。
     */
    public static final HihokenshaNoComparator ASC;
    /**
     * 降順ソート用のHihokenshaNoComparatorです。
     */
    public static final HihokenshaNoComparator DESC;

    static {
        ASC = new HihokenshaNoComparator(SortOrder.ASC);
        DESC = new HihokenshaNoComparator(SortOrder.DESC);
    }
    private final SortOrder order;

    /**
     * ソート順を指定して、HihokenshaNoComparatorを生成します。<br />
     * {@link SortOrder#ASC SortOrder.ASC}のときは、昇順ソート用のComparatorを、
     * {@link SortOrder#DESC SortOrder.DESC}のときは、降順ソート用のComparatorを生成します。
     *
     * @param order {@link SortOrder ソート順}
     */
    private HihokenshaNoComparator(SortOrder order) {
        this.order = order;
    }

    @Override
    public int compare(IHihokenshaNoGettable o1, IHihokenshaNoGettable o2) {
        return o1.get被保険者番号().compareTo(o2.get被保険者番号()) * order.rate();
    }
}
