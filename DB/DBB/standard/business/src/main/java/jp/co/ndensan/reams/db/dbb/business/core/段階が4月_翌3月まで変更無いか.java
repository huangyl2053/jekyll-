/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core;

import java.util.HashSet;
import java.util.Map;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n3336
 */
public class 段階が4月_翌3月まで変更無いか implements 端数調整判定 {

    @Override
    public boolean judgeHasuu(保険料段階判定input input) {
        Map<RString, HokenryoDankai> map = input.get年額賦課根拠().createHokenryoDankaiMap();

        HashSet<RString> set = new HashSet<>();

        for (Map.Entry<RString, HokenryoDankai> e : map.entrySet()) {
            set.add(e.getValue().getSystemDankai());
        }
        if (set.size() > 1) {
            return true;
        }
        return false;
    }

}
