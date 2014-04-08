/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5101ShinsakaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5106ShinsakaiWariateIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.basic.ShinsakaiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.basic.ShinsakaiWariateIinJohoDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 審査会と、それに割り当てられている審査会委員の情報を更新または削除するためのDacです。
 *
 * @author n8178 城間篤人
 */
public class ShinsakaiAndShinskaiWariateIinDac {

    private ShinsakaiWariateIinJohoDac wariateDac;
    private ShinsakaiJohoDac shinsakaiDac;

    /**
     * 審査会Entityと、それに割り当てられている委員Entityを受け取り、データの挿入または更新を行います。
     *
     * @param 審査会情報Entity 審査会情報Entity
     * @param 審査会割当委員情報EntityList 割当委員EntityList
     * @return 更新件数
     */
    @Transaction
    public int insertOrUpdate(DbT5101ShinsakaiJohoEntity 審査会情報Entity,
            List<DbT5106ShinsakaiWariateIinJohoEntity> 審査会割当委員情報EntityList) {
        wariateDac = InstanceProvider.create(ShinsakaiWariateIinJohoDac.class);
        shinsakaiDac = InstanceProvider.create(ShinsakaiJohoDac.class);

        int 更新件数 = 0;

        更新件数 += shinsakaiDac.insertOrUpdate(審査会情報Entity);
        for (DbT5106ShinsakaiWariateIinJohoEntity 割当委員Entity : 審査会割当委員情報EntityList) {
            更新件数 += wariateDac.insertOrUpdate(割当委員Entity);
        }

        return 更新件数;
    }

    /**
     * 審査会Entityと、それに割り当てられている委員Entityを受け取り、データの削除を行います。
     *
     * @param 審査会情報Entity 審査会情報Entity
     * @param 審査会割当委員情報EntityList 審査会割当委員情報EntityList
     * @return 削除件数
     */
    @Transaction
    public int delete(DbT5101ShinsakaiJohoEntity 審査会情報Entity,
            List<DbT5106ShinsakaiWariateIinJohoEntity> 審査会割当委員情報EntityList) {
        wariateDac = InstanceProvider.create(ShinsakaiWariateIinJohoDac.class);
        shinsakaiDac = InstanceProvider.create(ShinsakaiJohoDac.class);

        int 削除件数 = 0;

        削除件数 += shinsakaiDac.delete(審査会情報Entity);
        for (DbT5106ShinsakaiWariateIinJohoEntity 割当委員Entity : 審査会割当委員情報EntityList) {
            削除件数 += wariateDac.delete(割当委員Entity);
        }

        return 削除件数;
    }
}
