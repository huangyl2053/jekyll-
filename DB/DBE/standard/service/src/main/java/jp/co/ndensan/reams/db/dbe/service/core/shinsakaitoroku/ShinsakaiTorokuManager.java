/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shinsakaitoroku;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5105NinteiKanryoJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5105NinteiKanryoJohoDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 介護認定審査会登録のManagerです。
 *
 * @reamsid_L DBE-0340-010 linghuhang
 */
public class ShinsakaiTorokuManager {

    private final DbT5105NinteiKanryoJohoDac dbt5105Dac;

    ShinsakaiTorokuManager() {
        this.dbt5105Dac = InstanceProvider.create(DbT5105NinteiKanryoJohoDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param dbt5105Dac DbT5105NinteiKanryoJohoDac
     */
    ShinsakaiTorokuManager(DbT5105NinteiKanryoJohoDac dbt5105Dac) {
        this.dbt5105Dac = dbt5105Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShinsakaiTorokuManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link ShinsakaiTorokuManager}のインスタンス
     */
    public static ShinsakaiTorokuManager createInstance() {
        return InstanceProvider.create(ShinsakaiTorokuManager.class);
    }

    /**
     * 要介護認定完了情報の更新処理する。
     *
     * @param entity DbT5105NinteiKanryoJohoEntity
     */
    public void 要介護認定完了更新(DbT5105NinteiKanryoJohoEntity entity) {
        dbt5105Dac.save(entity);
    }
}
