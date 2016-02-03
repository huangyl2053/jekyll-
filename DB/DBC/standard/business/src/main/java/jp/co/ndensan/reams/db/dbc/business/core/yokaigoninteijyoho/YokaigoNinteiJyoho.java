/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.business.core.yokaigoninteijyoho;

import jp.co.ndensan.reams.db.dbc.entity.db.yokaigoninteijyoho.YokaigoNinteiJyohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;

/**
 *
 * @author sunhui
 */
public class YokaigoNinteiJyoho {
    private Code 要介護認定状態区分コード;
    private boolean 旧措置者フラグ;

    public YokaigoNinteiJyoho(Code 要介護認定状態区分コード, boolean 旧措置者フラグ) {
        this.要介護認定状態区分コード = 要介護認定状態区分コード;
        this.旧措置者フラグ = 旧措置者フラグ;
    }
    
    public YokaigoNinteiJyoho(DbT4001JukyushaDaichoEntity entity) {
        this.要介護認定状態区分コード = entity.getYokaigoJotaiKubunCode();
        this.旧措置者フラグ = entity.getChokkinFlag();
    }
    public Code get要介護認定状態区分コード(){
        return 要介護認定状態区分コード;
    }
    public void set要介護認定状態区分コード(Code 要介護認定状態区分コード){
        this.要介護認定状態区分コード=要介護認定状態区分コード;
        
    }
    public boolean get旧措置者フラグ(){
        return 旧措置者フラグ;
    }
    public void set旧措置者フラグ(boolean 旧措置者フラグ){
        this.旧措置者フラグ=旧措置者フラグ;
    }
}
