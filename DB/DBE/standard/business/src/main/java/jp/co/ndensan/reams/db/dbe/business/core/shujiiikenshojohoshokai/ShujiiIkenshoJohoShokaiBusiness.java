/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshojohoshokai;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshojohoshokai.ShujiiIkenshoJohoShokaiEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書情報照会Business
 * 
 * @author n3213
 */
public class ShujiiIkenshoJohoShokaiBusiness {
    
    private final ShujiiIkenshoJohoShokaiEntity entity;
    
    /**
     * コンストラクタ
     * 
     * @param entity 主治医意見書情報照会Entity
     */
    public ShujiiIkenshoJohoShokaiBusiness(ShujiiIkenshoJohoShokaiEntity entity) {
        this.entity = entity;
    }
    
    /**
     * 主治医医療機関コードを取得
     * 
     * @return 主治医医療機関コード
     */
    public RString getShujiiIryoKikanCode() {
        return entity.getShujiiIryoKikanCode();
    }
    
    /**
     * 主治医医療機関名称を取得
     * 
     * @return 主治医医療機関名称
     */
    public RString getIryoKikanMeisho() {
        return entity.getIryoKikanMeisho();
    }
    
    /**
     * 主治医コードを取得
     * 
     * @return 主治医コード
     */
    public RString getShujiiCode() {
        return entity.getShujiiCode();
    }
    
    /**
     * 主治医名称を取得
     * 
     * @return 主治医名称
     */
    public RString getShujiiName() {
        return entity.getShujiiName();
    }
    
}
