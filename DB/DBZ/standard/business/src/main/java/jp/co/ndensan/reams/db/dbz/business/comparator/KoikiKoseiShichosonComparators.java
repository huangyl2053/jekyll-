/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.comparator;

import java.util.Comparator;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.SortOrder;
import jp.co.ndensan.reams.db.dbz.model.koiki.IKoikiKoseiShichoson;

/**
 * 広域構成市町村で使用するコンパレータクラスです。
 *
 * @author N8156 宮本 康
 */
public final class KoikiKoseiShichosonComparators {

    /**
     * 地域番号用のコンパレータです。
     */
    public static final class ChiikiNoComparator implements Comparator<IKoikiKoseiShichoson> {

        /**
         * 昇順ソート用のChiikiNoComparatorです。
         */
        public static final ChiikiNoComparator ASC;
        /**
         * 降順ソート用のChiikiNoComparatorです。
         */
        public static final ChiikiNoComparator DESC;

        static {
            ASC = new ChiikiNoComparator(SortOrder.ASC);
            DESC = new ChiikiNoComparator(SortOrder.DESC);
        }
        private final SortOrder order;

        /**
         * ソート順を指定して、ChiikiNoComparatorを生成します。<br /> {@link SortOrder#ASC SortOrder.ASC}のときは、昇順ソート用のComparatorを、
         * {@link SortOrder#DESC SortOrder.DESC}のときは、降順ソート用のComparatorを生成します。
         *
         * @param order {@link SortOrder ソート順}
         */
        private ChiikiNoComparator(SortOrder order) {
            this.order = order;
        }

        @Override
        public int compare(IKoikiKoseiShichoson o1, IKoikiKoseiShichoson o2) {
            return o1.get合併情報地域番号().compareTo(o2.get合併情報地域番号()) * order.getRate();
        }
    }
}
