/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7055GappeiJoho;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7055GappeiJohoEntity;
import jp.co.ndensan.reams.db.dbz.model.gappei.GappeiJohoModel;
import jp.co.ndensan.reams.db.dbz.model.gappei.IGappeiJoho;
import jp.co.ndensan.reams.db.dbz.persistence.IDeletable;
import jp.co.ndensan.reams.db.dbz.persistence.IReplaceable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7055GappeiJoho.*;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;

/**
 * 合併情報のデータアクセスクラスです。
 *
 * @author N8156 宮本 康
 */
public class GappeiJohoDac implements IReplaceable<DbT7055GappeiJohoEntity>, IDeletable<DbT7055GappeiJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 全合併情報を取得します。
     *
     * @return 合併情報リスト
     */
    @Transaction
    public List<IGappeiJoho> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT7055GappeiJohoEntity> entityList = accessor.
                select().
                table(DbT7055GappeiJoho.class).
                toList(DbT7055GappeiJohoEntity.class);
        return getModelList(entityList);
    }

    /**
     * 指定した検索条件に合致する合併情報を取得します。
     *
     * @param 検索条件 検索条件
     * @return 合併情報リスト
     */
    @Transaction
    public List<IGappeiJoho> select(ITrueFalseCriteria 検索条件) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT7055GappeiJohoEntity> entityList = accessor.
                select().
                table(DbT7055GappeiJoho.class).
                where(検索条件).
                toList(DbT7055GappeiJohoEntity.class);
        return getModelList(entityList);
    }

    private List<IGappeiJoho> getModelList(List<DbT7055GappeiJohoEntity> entityList) {
        List<IGappeiJoho> list = new ArrayList<>();
        for (DbT7055GappeiJohoEntity entity : entityList) {
            list.add(new GappeiJohoModel(entity));
        }
        return list;
    }

    @Override
    public int insertOrUpdate(DbT7055GappeiJohoEntity entity) {
        return getMatchRowCount(entity) == 0 ? insert(entity) : update(entity);
    }

    @Override
    public int insert(DbT7055GappeiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Override
    public int update(DbT7055GappeiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Override
    public int delete(DbT7055GappeiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    private int getMatchRowCount(DbT7055GappeiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select()
                .table(DbT7055GappeiJoho.class)
                .where(and(
                                eq(gappeiYMD, entity.getGappeiYMD()),
                                eq(chiikiNo, entity.getChiikiNo())))
                .getCount();
    }
}
