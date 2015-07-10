/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7011ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IDeletable;
import jp.co.ndensan.reams.db.dbz.persistence.IReplaceable;

/**
 * 主治医医療機関Dacのインターフェースです。
 *
 * @author n8178 城間篤人
 */
public interface IShuJiiIryoKikanDac extends IReplaceable<DbT7011ShujiiIryoKikanJohoEntity>,
        IDeletable<DbT7011ShujiiIryoKikanJohoEntity> {

    @Override
    int insertOrUpdate(DbT7011ShujiiIryoKikanJohoEntity entity);

    @Override
    int insert(DbT7011ShujiiIryoKikanJohoEntity entity);

    @Override
    int update(DbT7011ShujiiIryoKikanJohoEntity entity);

    @Override
    int delete(DbT7011ShujiiIryoKikanJohoEntity entity);
}
