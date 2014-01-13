/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.Objects;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護事業者番号を表すクラスです
 * 
 * @author N1013
 */
public class KaigoJigyoshaNo {
    
    private final RString kaigoJigyoshaNo;

    /**
     * 
     * @param 介護事業者番号
     */
    KaigoJigyoshaNo(RString 介護事業者番号){
        kaigoJigyoshaNo = 介護事業者番号;
    }
    
    /**
     * 介護事業者番号を取得します
     * 
     * @return kaigoJigyoshaNo
     */
    public RString getNo() {
        return kaigoJigyoshaNo;
    }
    
}
