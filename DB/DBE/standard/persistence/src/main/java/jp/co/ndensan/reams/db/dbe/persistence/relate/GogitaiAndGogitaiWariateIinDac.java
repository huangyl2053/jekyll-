/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5103GogitaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5107GogitaiWariateIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.basic.GogitaiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.basic.GogitaiWariateDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 合議体と合議体割当委員の情報を同じトランザクション内で更新するDACです。
 *
 * @author n8178 城間篤人
 */
public class GogitaiAndGogitaiWariateIinDac {

    private GogitaiJohoDac gogitaiDac;
    private GogitaiWariateDac gogitaiWariateDac;

    /**
     * 合議体と合議体に割り当てられた委員の情報に対して、insertかupdateのどちらかを状況に合わせて行います。
     *
     * @param 合議体Entity 合議体Entity
     * @param 合議体割当委員Entities 合議体割当委員Entities
     * @return 件数
     */
    @Transaction
    public int insertOrUpdate(DbT5103GogitaiJohoEntity 合議体Entity, List<DbT5107GogitaiWariateIinJohoEntity> 合議体割当委員Entities) {

        gogitaiDac = InstanceProvider.create(GogitaiJohoDac.class);
        gogitaiWariateDac = InstanceProvider.create(GogitaiWariateDac.class);

        int 総更新件数 = 0;
        総更新件数 += gogitaiDac.insertOrUpdate(合議体Entity);
        for (DbT5107GogitaiWariateIinJohoEntity 合議体割当委員Entity : 合議体割当委員Entities) {
            総更新件数 += gogitaiWariateDac.insertOrUpdate(合議体割当委員Entity);
        }

        return 総更新件数;
    }

    /**
     * 合議体と合議体に割り当てられた委員の情報をデータベースから削除します。
     *
     * @param 合議体Entity 合議体Entity
     * @param 合議体割当委員Entities 合議体割当委員Entities
     * @return 件数
     */
    @Transaction
    public int delete(DbT5103GogitaiJohoEntity 合議体Entity, List<DbT5107GogitaiWariateIinJohoEntity> 合議体割当委員Entities) {

        gogitaiDac = InstanceProvider.create(GogitaiJohoDac.class);
        gogitaiWariateDac = InstanceProvider.create(GogitaiWariateDac.class);

        int 総更新件数 = 0;
        総更新件数 += gogitaiDac.delete(合議体Entity);

        for (DbT5107GogitaiWariateIinJohoEntity 合議体割当Entity : 合議体割当委員Entities) {
            総更新件数 += gogitaiWariateDac.delete(合議体割当Entity);
        }
        return 総更新件数;
    }
}
