/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbb.business;

import java.util.Calendar;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 *
 * @author n3336
 */
public class 資格取得日が4月1日か判定 implements 端数調整判定{

    @Override
    public boolean JudgeHasuu(保険料段階判定input input) {
                
        RDate 年度開始日 = new RDate(input.get賦課年度() + "0401");
        RDate 年度終了日 = new RDate( String.valueOf(Integer.parseInt(input.get賦課年度()) + 1) + "0331"  );
        
        if(input.get年額賦課根拠().get資格取得日() == null){
            return false;
        }     
        
        
        if(input.get年額賦課根拠().get資格取得日().isBeforeOrEquals(年度開始日) == false){
            if( input.get年額賦課根拠().get資格取得日().isBeforeOrEquals(年度終了日) == true){
                return true;
            }
        }
        return false;
        
     
    }   
    
}
