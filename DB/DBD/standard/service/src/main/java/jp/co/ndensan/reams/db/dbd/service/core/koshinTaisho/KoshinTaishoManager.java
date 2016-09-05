/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.koshinTaisho;

import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4201NinteichosaIraiJohoDac;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 画面設計_DBD5010001_完了処理・更新管理のMapperです。
 *
 * @author_L DBD-2030-010 x_youyj
 */
public class KoshinTaishoManager {

    private final MapperProvider mapperProvider;
    private final DbT4201NinteichosaIraiJohoDac dac;

    /**
     * コンストラクタです。
     */
    KoshinTaishoManager() {
        mapperProvider = InstanceProvider.create(MapperProvider.class);
        dac = InstanceProvider.create(DbT4201NinteichosaIraiJohoDac.class);

    }

    /**
     * テスト用コンストラクタです。
     *
     * @@param mapperProvider MapperProvider
     */
    KoshinTaishoManager(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
        dac = InstanceProvider.create(DbT4201NinteichosaIraiJohoDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link YokaigoNinteiJohoManager}のインスタンスを返します。
     *
     * @return YokaigoNinteiJohoManager
     *
     */
    public static KoshinTaishoManager createInstance() {
        return InstanceProvider.create(KoshinTaishoManager.class);

    }

    /**
     * 認定調査依頼情報を更新する。
     *
     * @param 認定調査依頼情報 DbT4201NinteichosaIraiJohoEntity
     */
    @Transaction
    public void updateDbt4201johon(DbT4201NinteichosaIraiJohoEntity 認定調査依頼情報) {

        dac.updateDbt4201johon(認定調査依頼情報);
    }
    
    /**
     * 要介護認定申請情報を更新する。
     *
     * @param 認定申請情報 DbT4101NinteiShinseiJohoEntity
     */
    @Transaction
    public void updateDbt4101johon(DbT4101NinteiShinseiJohoEntity 認定申請情報) {

        dac.updateDbt4101johon(認定申請情報);
    }
}
