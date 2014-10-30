/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbb.business;

import java.util.Calendar;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import static jp.co.ndensan.reams.uz.uza.lang.cast._CastDataTypeFactory.DataType.RDate;

/**
 *
 * @author n3336
 */
public class 資格喪失日が年度内に存在するか判定 implements 端数調整判定{

    @Override
    public boolean JudgeHasuu(保険料段階判定input input) {
        
//        Calendar 資格喪失日 = Calendar.getInstance();
//        Calendar 年度開始日 = Calendar.getInstance();
//        Calendar 年度終了日 = Calendar.getInstance();
//        
//        年度開始日.set(Integer.parseInt(input.get賦課年度()), 4, 1);
//        年度終了日.set(Integer.parseInt(input.get賦課年度()) + 1, 03, 31);
//        
//        年度開始日.set(Calendar.MILLISECOND,0);
//        年度終了日.set(Calendar.MILLISECOND,0);
//        
//        if( input.get年額賦課根拠().get資格喪失日() == null ){
//            return false;
//        }
//        
//        資格喪失日.setTime(input.get年額賦課根拠().get資格喪失日());
//        
//        if(資格喪失日.after(年度開始日) == true){
//            return true;
//        }
//        return false;
 
        if( input.get年額賦課根拠().get資格喪失日() == null ){
            return false;
        }        
        
        RDate 年度開始日 = new RDate(input.get賦課年度() + "0401");
        RDate 年度終了日 = new RDate( String.valueOf(Integer.parseInt(input.get賦課年度()) + 1) + "0331"  );
        
        if(input.get年額賦課根拠().get資格喪失日() == null){
            return false;
        }
        
        
        if(input.get年額賦課根拠().get資格喪失日().isBeforeOrEquals(年度開始日) == false ){
            if(input.get年額賦課根拠().get資格喪失日().isBeforeOrEquals(年度終了日) == true){
                return true;
            }
        }        
        return false;
        
    }
    
    
}
