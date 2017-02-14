/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbz.business.core.kihonchosainput;

import java.util.Comparator;

/**
 *
 * @author n3423
 */
public class KihonChosaInputComparator implements Comparator<KihonChosaInput>{
    
    /**
     * 連番でソートします。
     * @param a 基本調査項目
     * @param b 基本調査項目
     * @return 比較結果
     */
    @Override
    public int compare(KihonChosaInput a, KihonChosaInput b) {
        int no1 = a.get調査連番();
        int no2 = b.get調査連番();

        if (no1 > no2) {
            return 1;
        } else if (no1 == no2) {
            return 0;
        } else {
            return -1;
        }
    }
}
