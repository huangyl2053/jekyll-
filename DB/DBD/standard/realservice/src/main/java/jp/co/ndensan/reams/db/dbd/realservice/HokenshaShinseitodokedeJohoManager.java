/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbd.realservice;

import jp.co.ndensan.reams.db.dbd.business.HokenshaShinseitodokedeJoho;
import jp.co.ndensan.reams.db.dbd.business.IShinseitodokedeJoho;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT4120ShinseitodokedeJohoEntity;
import jp.co.ndensan.reams.db.dbd.persistence.basic.DbT4120HokenshaShinseitodokedeJohoDac;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 申請届出者情報を作成するクラスです。
 * 
 * @author n8223 朴義一
 */
public class HokenshaShinseitodokedeJohoManager  extends ShinseitodokedeJohoManagerBase{
    
    private final DbT4120HokenshaShinseitodokedeJohoDac dac;

    /**
     * コンストラクタです。
     * 
     * 申請届出者情報を作成するインターフェースを生成します。
     */
    public HokenshaShinseitodokedeJohoManager() {
        this.dac = InstanceProvider.create(DbT4120HokenshaShinseitodokedeJohoDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     * @param dac 申請届出者情報Dac
     */
    HokenshaShinseitodokedeJohoManager(DbT4120HokenshaShinseitodokedeJohoDac dac) {
        this.dac = dac;
    }
    
    @Override
    public ItemList<IShinseitodokedeJoho> find申請届出者情報() {
        return to申請届出者情報(dac.selectAll());
    }

    
    @Override
    public Optional<IShinseitodokedeJoho> find申請届出者情報(ShinseishoKanriNo 申請管理番号){
        return dac.selectByKey(申請管理番号)
                .map(new IFunction<DbT4120ShinseitodokedeJohoEntity, IShinseitodokedeJoho>() {
                    @Override
                    public IShinseitodokedeJoho apply(DbT4120ShinseitodokedeJohoEntity t) {
                        return new HokenshaShinseitodokedeJoho(t);
                    }
                });
    }
    
    
    private ItemList<IShinseitodokedeJoho> to申請届出者情報(ItemList<DbT4120ShinseitodokedeJohoEntity> entityList){
        ItemList<IShinseitodokedeJoho> shinseitodokedeJohoList = ItemList.empty();
        
        for(DbT4120ShinseitodokedeJohoEntity entity: entityList) {
            HokenshaShinseitodokedeJoho hokenshaShinseitodokedeJoho  = new HokenshaShinseitodokedeJoho(entity);
            shinseitodokedeJohoList.added(hokenshaShinseitodokedeJoho);
        }
        return shinseitodokedeJohoList;
    }

    
    
    
    
    
}
