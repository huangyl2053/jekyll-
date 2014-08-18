/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5014ShinsakaiIinJogaiJoho;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5014ShinsakaiIinJogaiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IDeletable;
import jp.co.ndensan.reams.db.dbz.persistence.IReplaceable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;

/**
 * 審査会委員除外情報の保存、削除を行うDacです。
 *
 * @author n8178 城間篤人
 */
public class ShinsakaiIinJogaiJohoDac implements IReplaceable<DbT5014ShinsakaiIinJogaiJohoEntity>, IDeletable<DbT5014ShinsakaiIinJogaiJohoEntity> {

    @InjectSession
    private SqlSession session;

    @Override
    public int insertOrUpdate(DbT5014ShinsakaiIinJogaiJohoEntity entity) {
        //TODO n8178 城間篤人 updateCount関連で修正の可能性有り 2014年9月
        return getMatchRowCount(entity) == 0 ? insert(entity) : update(entity);
    }

    @Override
    public int insert(DbT5014ShinsakaiIinJogaiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Override
    public int update(DbT5014ShinsakaiIinJogaiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Override
    public int delete(DbT5014ShinsakaiIinJogaiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    private int getMatchRowCount(DbT5014ShinsakaiIinJogaiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select()
                .table(DbT5014ShinsakaiIinJogaiJoho.class)
                .where(and(
                                eq(DbT5014ShinsakaiIinJogaiJoho.hihokenshaNo, entity.getHihokenshaNo()),
                                eq(DbT5014ShinsakaiIinJogaiJoho.kanriNo, entity.getKanriNo()),
                                eq(DbT5014ShinsakaiIinJogaiJoho.shoKisaiHokenshaNo, entity.getShoKisaiHokenshaNo())))
                .getCount();
    }

}
