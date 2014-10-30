/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbb.business;

import java.util.HashSet;
import java.util.Map;

/**
 *
 * @author n3336
 */
public class ランクが4月_翌3月まで変更無いか implements 端数調整判定{
    
        @Override
    public boolean JudgeHasuu(保険料段階判定input input) {
        
        
        Map<String, String> map = input.get年額賦課根拠().createRankMap();
        
        HashSet<String> set = new HashSet<>();
        
        for(Map.Entry<String, String> e : map.entrySet()){
            set.add(e.getValue());
        }
        if(set.size() > 1)
        {
            return true;
        }
        return false;
    }
    
}
