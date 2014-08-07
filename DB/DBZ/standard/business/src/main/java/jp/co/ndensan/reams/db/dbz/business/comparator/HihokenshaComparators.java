/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.comparator;

import java.util.Comparator;
import jp.co.ndensan.reams.db.dbz.business.Hihokensha;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.SortOrder;

/**
 * {@link Hihokensha Hihokensha}専用のcomparatorを集めたクラスです。
 *
 * @author N3327 三浦 凌
 */
public final class HihokenshaComparators {

    /**
     * 被保険者台帳登録日時用のcomparatorです。
     */
    public static final class RegisterDateTimeComparator implements Comparator<Hihokensha> {

        private final SortOrder order;
        /**
         * 被保険者台帳登録日時の昇順ソート用comparatorです。
         */
        public static final RegisterDateTimeComparator ASC;
        /**
         * 被保険者台帳登録日時の降順ソート用comparatorです。
         */
        public static final RegisterDateTimeComparator DESC;

        static {
            ASC = new RegisterDateTimeComparator(SortOrder.ASC);
            DESC = new RegisterDateTimeComparator(SortOrder.DESC);
        }

        private RegisterDateTimeComparator(SortOrder order) {
            this.order = order;
        }

        @Override
        public int compare(Hihokensha hihokensha1, Hihokensha hihokensha2) {
            return hihokensha1.get処理日時().compareTo(hihokensha2.get処理日時()) * order.getRate();
        }
    }

    /**
     * 地方公共団体コード用のcomparatorです。
     */
    public static final class ShichosonCodeComparator implements Comparator<Hihokensha> {

        private final SortOrder order;
        /**
         * 地方公共団体コードの昇順ソート用comparatorです。
         */
        public static final ShichosonCodeComparator ASC;
        /**
         * 地方公共団体コードの降順ソート用comparatorです。
         */
        public static final ShichosonCodeComparator DESC;

        static {
            ASC = new ShichosonCodeComparator(SortOrder.ASC);
            DESC = new ShichosonCodeComparator(SortOrder.DESC);
        }

        private ShichosonCodeComparator(SortOrder order) {
            this.order = order;
        }

        @Override
        public int compare(Hihokensha hihokensha1, Hihokensha hihokensha2) {
            return hihokensha1.get市町村コード().compareTo(hihokensha2.get市町村コード()) * order.getRate();
        }
    }
}
