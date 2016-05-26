/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.hanyolisthihokenshadaicho;

import java.util.Comparator;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * {@link HanyoListHihokenshadaichoProcess}の資格取得判定のためのComparatorです。
 */
public final class ShikakShutokuHanteiComparator implements Comparator<ShikakShutokuHantei> {

    private static final int DESC = -1;

    @Override
    public int compare(ShikakShutokuHantei o1, ShikakShutokuHantei o2) {

        FlexibleDate p1 = o1.getTekiyoYMD();
        FlexibleDate p2 = o2.getTekiyoYMD();

        if (p1 == null && p2 == null) {
            return 0;
        } else if (p1 == null) {
            return 1;
        } else if (p2 == null) {
            return -1;
        }

        if (p1.isEmpty() && p2.isEmpty()) {
            return 0;
        } else if (p1.isEmpty()) {
            return 1;
        } else if (p2.isEmpty()) {
            return -1;
        }

        return p1.compareTo(p2) * DESC;
    }
}
