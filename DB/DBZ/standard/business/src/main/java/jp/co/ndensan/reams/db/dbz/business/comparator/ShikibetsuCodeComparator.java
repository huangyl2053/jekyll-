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
 * @param <T> {@link IShikibetsuCodeGettable IShikibetsuCodeGettable}を継承したオブジェクト
 */
public class ShikibetsuCodeComparator<T extends IShikibetsuCodeGettable> implements Comparator<T> {

    private SortOrder order;

    /**
     * ソート順を指定して、ShikibetsuCodeComparatorを生成します。<br />
     * {@link SortOrder#ASC SortOrder.ASC}のときは、昇順ソート用のComparatorを、
     * {@link SortOrder#DESC SortOrder.DESC}のときは、降順ソート用のComparatorを生成します。
     *
     * @param order {@link SortOrder ソート順}
     */
    public ShikibetsuCodeComparator(SortOrder order) {
        this.order = order;
    }

    @Override
    public int compare(T o1, T o2) {
        return o1.get識別コード().compareTo(o2.get識別コード()) * order.getRate();
    }
}
