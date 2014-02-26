/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5107GogitaiWariateIinJohoEntity;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;

/**
 * 合議体割当テーブルの情報を扱うデータアクセスクラスです。
 *
 * @author n8178 城間篤人
 */
public class GogitaiWariateDac implements IGogitaiWariateDac {

    @InjectSession
    SqlSession session;

    @Override
    public int insertOrUpdate(DbT5107GogitaiWariateIinJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        //TODO n8178 城間篤人 updateCountを扱えるようになってから改めて実装 2014年3月
        int updateCount = 1;
        return updateCount == 0 ? insert(entity) : update(entity);
    }

    @Override
    public int insert(DbT5107GogitaiWariateIinJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Override
    public int update(DbT5107GogitaiWariateIinJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Override
    public int delete(DbT5107GogitaiWariateIinJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }
}
