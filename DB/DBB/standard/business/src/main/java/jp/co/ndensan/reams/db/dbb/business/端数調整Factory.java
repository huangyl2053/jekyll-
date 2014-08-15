/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbb.business;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * @author n3336
 */
public class 端数調整Factory {
    public I端数調整 getIncetance( 保険料段階判定input input){
       
       List<端数調整判定> list = new ArrayList<>();
       list.add(new 段階が4月_翌3月まで変更無いか());
       list.add(new ランクが4月_翌3月まで変更無いか());
       list.add(new 資格取得日が4月1日か判定());
       list.add(new 資格喪失日が年度内に存在するか判定());
       
       boolean chousei = false;
       
       for( 端数調整判定 list_hantei : list  ){
           if( list_hantei.JudgeHasuu(input) == true ){
               chousei = true;
               break;
           }
       }
       
       if(chousei == false){
           return new 端数調整しない();
       }
       
        端数調整判定 rankChange = new ランクが4月_翌3月まで変更無いか();
        String chouseiHouhou;
        Decimal choseiTanni;
        if( rankChange.JudgeHasuu(input) == true ){
            chouseiHouhou = input.get年額制御情報().get端数調整方法_ランク用();
            choseiTanni    = input.get年額制御情報().get端数単位_ランク用();               
        }
        else{
            chouseiHouhou = input.get年額制御情報().get端数調整方法();
            choseiTanni    = input.get年額制御情報().get端数単位();
        }
        
        switch(chouseiHouhou){
            case("切り上げ"):
                return new 端数調整_切り上げ(choseiTanni.toString());
                
            case("切捨て"):
                return new 端数調整_切捨て(choseiTanni.toString());
                
            case("四捨五入"):
                return new 端数調整_四捨五入(choseiTanni.toString());
                
            default:
                return new 端数調整しない();
        } 
            
    }
    
}
