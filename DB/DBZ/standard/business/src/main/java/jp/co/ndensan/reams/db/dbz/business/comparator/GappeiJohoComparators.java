/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.comparator;

import java.util.Comparator;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.SortOrder;
import jp.co.ndensan.reams.db.dbz.model.gappei.IGappeiJoho;

/**
 * 合併情報で使用するコンパレータクラスです。
 *
 * @author N8156 宮本 康
 */
public final class GappeiJohoComparators implements Comparator<IGappeiJoho> {

    /**
     * 昇順ソート用のGappeiJohoComparatorsです。
     */
    public static final GappeiJohoComparators ASC;
    /**
     * 降順ソート用のGappeiJohoComparatorsです。
     */
    public static final GappeiJohoComparators DESC;

    static {
        ASC = new GappeiJohoComparators(SortOrder.ASC);
        DESC = new GappeiJohoComparators(SortOrder.DESC);
    }
    private final SortOrder order;

    /**
     * ソート順を指定して、GappeiJohoComparatorsを生成します。<br /> {@link SortOrder#ASC SortOrder.ASC}のときは、昇順ソート用のComparatorを、
     * {@link SortOrder#DESC SortOrder.DESC}のときは、降順ソート用のComparatorを生成します。
     *
     * @param order {@link SortOrder ソート順}
     */
    private GappeiJohoComparators(SortOrder order) {
        this.order = order;
    }

    @Override
    public int compare(IGappeiJoho o1, IGappeiJoho o2) {
        return o1.get地域番号().compareTo(o2.get地域番号()) * order.getRate();
    }
}
