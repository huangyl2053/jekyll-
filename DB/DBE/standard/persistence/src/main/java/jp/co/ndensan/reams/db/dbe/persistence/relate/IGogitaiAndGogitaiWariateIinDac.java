/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5103GogitaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5107GogitaiWariateIinJohoEntity;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 合議体と合議体割当委員の情報を同じトランザクション内で更新するDACのインターフェースです。
 *
 * @author n8178 城間篤人
 */
public interface IGogitaiAndGogitaiWariateIinDac {

    /**
     * 合議体と合議体に割り当てられた委員の情報に対して、insertかupdateのどちらかを状況に合わせて行います。
     *
     * @param 合議体Entity 合議体Entity
     * @param 合議体割当Entities 合議体割当Entities
     * @return 件数
     */
    @Transaction
    int insertOrUpdate合議体割当審査会委員情報(DbT5103GogitaiJohoEntity 合議体Entity,
            List<DbT5107GogitaiWariateIinJohoEntity> 合議体割当委員Entities);

    /**
     * 合議体と合議体に割り当てられた委員の情報をデータベースから削除します。
     *
     * @param 合議体Entity 合議体Entity
     * @param 合議体割当Entities 合議体割当Entities
     * @return 件数
     */
    @Transaction
    int delete合議体割当審査会委員情報(DbT5103GogitaiJohoEntity 合議体Entity,
            List<DbT5107GogitaiWariateIinJohoEntity> 合議体割当委員Entities);
}
