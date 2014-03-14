/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5103GogitaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5107GogitaiWariateIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.basic.IGogitaiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.basic.IGogitaiWariateDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceCreator;

/**
 * 合議体と合議体割当委員の情報を同じトランザクション内で更新するDACです。
 *
 * @author n8178 城間篤人
 */
public class GogitaiAndGogitaiWariateIinDac implements IGogitaiAndGogitaiWariateIinDac {

    @Override
    public int insertOrUpdate合議体割当審査会委員情報(DbT5103GogitaiJohoEntity 合議体Entity, List<DbT5107GogitaiWariateIinJohoEntity> 合議体割当委員Entities) {

        IGogitaiJohoDac gogitaiDac = InstanceCreator.create(IGogitaiJohoDac.class);
        IGogitaiWariateDac gogitaiWariateDac = InstanceCreator.create(IGogitaiWariateDac.class);

        int 総更新件数 = 0;
        総更新件数 += gogitaiDac.insertOrUpdate(合議体Entity);
        for (DbT5107GogitaiWariateIinJohoEntity 合議体割当委員Entity : 合議体割当委員Entities) {
            総更新件数 += gogitaiWariateDac.insertOrUpdate(合議体割当委員Entity);
        }

        return 総更新件数;
    }

    @Override
    public int delete合議体割当審査会委員情報(DbT5103GogitaiJohoEntity 合議体Entity, List<DbT5107GogitaiWariateIinJohoEntity> 合議体割当委員Entities) {

        IGogitaiJohoDac gogitaiDac = InstanceCreator.create(IGogitaiJohoDac.class);
        IGogitaiWariateDac gogitaiWariateDac = InstanceCreator.create(IGogitaiWariateDac.class);

        int 総更新件数 = 0;
        総更新件数 += gogitaiDac.delete(合議体Entity);

        for (DbT5107GogitaiWariateIinJohoEntity 合議体割当Entity : 合議体割当委員Entities) {
            総更新件数 += gogitaiWariateDac.delete(合議体割当Entity);
        }
        return 総更新件数;
    }
}
