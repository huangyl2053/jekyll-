/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.YokaigoNinteiShinseiKubun;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 *
 * @author N2006 立野 啓子
 */
public class NinteiShinseiJohoValidate {
    
//申請区分（更新申請）のとき、申請日は前回有効終了日の60日前以降でなければならない
    public boolean validateShinseiKbn(RString ShinseiKbn , RDate ShinseiYMD , RString ZenkaiYukoKikanEnd){
        if (ShinseiKbn.equalsIgnoreCase(YokaigoNinteiShinseiKubun.更新申請.getCode()) ){
            if (ZenkaiYukoKikanEnd.isEmpty()) return true;
            if (ShinseiYMD.isBefore(new RDate(ZenkaiYukoKikanEnd.toString()).minusDay(60))) return true;        
        }
        return false;
    }
    //事業者
    public boolean validateJigyosha(RString JigyoshaCode , RString JigyoshaName){ 
        if (JigyoshaCode.isEmpty() && JigyoshaName.isEmpty()) return false;
        if (JigyoshaCode.isEmpty() || JigyoshaName.isEmpty()) return true;
        return false;
    }
    //医療機関
    public boolean validateIryokikan(RString IryokikanCode , RString IryokikanName){ 
        if (IryokikanCode.isEmpty() && IryokikanName.isEmpty()) return false;
        if (IryokikanCode.isEmpty() || IryokikanName.isEmpty()) return true;        
        return false;
    }
    //主治医
    public boolean validateShujii(RString ShujiiCode , RString ShujiiName){ 
        if (ShujiiCode.isEmpty() && ShujiiName.isEmpty()) return false;
        if (ShujiiCode.isEmpty() || ShujiiName.isEmpty()) return true;        
        return false;
    }
    
}

