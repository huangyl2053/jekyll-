/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbb.business;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 *
 * @author n3336
 */
public class 段階が4月_翌3月まで変更無いか implements 端数調整判定{

    @Override
    public boolean JudgeHasuu(保険料段階判定input input) {
        Map<String, HokenryoDankai> map = input.get年額賦課根拠().createHokenryoDankaiMap();
        
        HashSet<String> set = new HashSet<>();
        
        for(Map.Entry<String, HokenryoDankai> e : map.entrySet()){
            set.add(e.getValue().getSystemDankai());
        }
        if(set.size() > 1)
        {
            return true;
        }
        return false;
    }
    
    
}
