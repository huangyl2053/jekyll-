/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.comparator;

import java.util.Comparator;
import jp.co.ndensan.reams.db.dbz.business.IShikibetsuCodeGettable;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.SortOrder;

/**
 * {@link IShikibetsuCodeGettable 識別コードが取得可能なオブジェクト}専用のComparatorです。
 *
 * @author N3327 三浦 凌
 */
public final class ShikibetsuCodeComparator implements Comparator<IShikibetsuCodeGettable> {

    /**
     * 昇順ソート用のShikibetsuCodeComparatorです。
     */
    public static final ShikibetsuCodeComparator ASC;
    /**
     * 降順ソート用のShikibetsuCodeComparatorです。
     */
    public static final ShikibetsuCodeComparator DESC;

    static {
        ASC = new ShikibetsuCodeComparator(SortOrder.ASC);
        DESC = new ShikibetsuCodeComparator(SortOrder.DESC);
    }
    private final SortOrder order;

    /**
     * ソート順を指定して、ShikibetsuCodeComparatorを生成します。<br />
     * {@link SortOrder#ASC SortOrder.ASC}のときは、昇順ソート用のComparatorを、
     * {@link SortOrder#DESC SortOrder.DESC}のときは、降順ソート用のComparatorを生成します。
     *
     * @param order {@link SortOrder ソート順}
     */
    private ShikibetsuCodeComparator(SortOrder order) {
        this.order = order;
    }

    @Override
    public int compare(IShikibetsuCodeGettable o1, IShikibetsuCodeGettable o2) {
        return o1.get識別コード().compareTo(o2.get識別コード()) * order.rate();
    }
}
