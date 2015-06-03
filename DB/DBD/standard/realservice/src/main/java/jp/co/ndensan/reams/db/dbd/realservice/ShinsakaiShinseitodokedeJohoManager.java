/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbd.realservice;

import jp.co.ndensan.reams.db.dbd.business.IShinseitodokedeJoho;
import jp.co.ndensan.reams.db.dbd.business.ShinsakaiShinseitodokedeJoho;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT5120ShinseitodokedeJohoEntity;
import jp.co.ndensan.reams.db.dbd.persistence.basic.DbT5120ShinsakaiShinseitodokedeJohoDac;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 申請届出者情報を作成するクラスです。
 * 
 * @author n8223 
 */
public class ShinsakaiShinseitodokedeJohoManager extends ShinseitodokedeJohoManagerBase{
    
    private final DbT5120ShinsakaiShinseitodokedeJohoDac dac;

    /**
     * コンストラクタです。
     * 
     * 申請届出者情報を作成するインターフェースを生成します。
     */
    public ShinsakaiShinseitodokedeJohoManager() {
        this.dac = InstanceProvider.create(DbT5120ShinsakaiShinseitodokedeJohoDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     * @param dac 申請届出者情報Dac
     */
    ShinsakaiShinseitodokedeJohoManager(DbT5120ShinsakaiShinseitodokedeJohoDac dac) {
        this.dac = dac;
    }
    
    @Override
    public ItemList<IShinseitodokedeJoho> find申請届出者情報() {
        return to申請届出者情報(dac.selectAll());
    }

    
    public Optional<IShinseitodokedeJoho> find申請届出者情報(ShinseishoKanriNo 申請管理番号){
        return dac.selectByKey(申請管理番号)
                .map(new IFunction<DbT5120ShinseitodokedeJohoEntity, IShinseitodokedeJoho>() {
                    @Override
                    public IShinseitodokedeJoho apply(DbT5120ShinseitodokedeJohoEntity t) {
                        return new ShinsakaiShinseitodokedeJoho(t);
                    }
                });
    }
    
    
    private ItemList<IShinseitodokedeJoho> to申請届出者情報(ItemList<DbT5120ShinseitodokedeJohoEntity> entityList){
        ItemList<IShinseitodokedeJoho> shinseitodokedeJohoList = ItemList.empty();
        
        for(DbT5120ShinseitodokedeJohoEntity entity: entityList) {
            ShinsakaiShinseitodokedeJoho shinsakaiShinseitodokedeJoho  = new ShinsakaiShinseitodokedeJoho(entity);
            shinseitodokedeJohoList.added(shinsakaiShinseitodokedeJoho);
        }
        return shinseitodokedeJohoList;
    }

    
}
