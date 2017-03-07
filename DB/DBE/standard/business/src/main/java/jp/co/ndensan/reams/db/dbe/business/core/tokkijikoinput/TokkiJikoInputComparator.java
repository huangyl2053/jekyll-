/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.business.core.tokkijikoinput;

import java.util.Comparator;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n3423
 */
public class TokkiJikoInputComparator implements Comparator<TokkiJikoInputModel> {
    
    /**
     * 連番でソートします。
     * @param a 特記事項番号＋特記事項連番
     * @param b 特記事項番号＋特記事項連番
     * @return 比較結果
     */
    @Override
    public int compare(TokkiJikoInputModel a, TokkiJikoInputModel b) {
        int no1 = Integer.parseInt(a.get特記事項番号().concat(new RString(a.get特記連番())).toString());
        int no2 = Integer.parseInt(b.get特記事項番号().concat(new RString(b.get特記連番())).toString());

        if (no1 > no2) {
            return 1;
        } else if (no1 == no2) {
            return 0;
        } else {
            return -1;
        }
    }
}
