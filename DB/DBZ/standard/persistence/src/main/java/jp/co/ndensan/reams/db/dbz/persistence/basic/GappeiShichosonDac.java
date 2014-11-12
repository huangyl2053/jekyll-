/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7056GappeiShichoson;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7056GappeiShichosonEntity;
import jp.co.ndensan.reams.db.dbz.model.gappei.GappeiShichosonModel;
import jp.co.ndensan.reams.db.dbz.model.gappei.IGappeiShichoson;
import jp.co.ndensan.reams.db.dbz.model.util.items.IItemList;
import jp.co.ndensan.reams.db.dbz.model.util.items.ItemList;
import jp.co.ndensan.reams.db.dbz.persistence.IDeletable;
import jp.co.ndensan.reams.db.dbz.persistence.IReplaceable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7056GappeiShichoson.*;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;

/**
 * 合併市町村のデータアクセスクラスです。
 *
 * @author N8156 宮本 康
 */
public class GappeiShichosonDac implements IReplaceable<DbT7056GappeiShichosonEntity>, IDeletable<DbT7056GappeiShichosonEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 全合併市町村を取得します。
     *
     * @return 合併市町村リスト
     */
    @Transaction
    public IItemList<IGappeiShichoson> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT7056GappeiShichosonEntity> entityList = accessor.
                select().
                table(DbT7056GappeiShichoson.class).
                order(by(gappeiYMD, Order.ASC)).
                toList(DbT7056GappeiShichosonEntity.class);
        return getModelList(entityList);
    }

    /**
     * 指定した検索条件に合致する合併市町村を取得します。
     *
     * @param 検索条件 検索条件
     * @return 合併情報リスト
     */
    @Transaction
    public IItemList<IGappeiShichoson> select(ITrueFalseCriteria 検索条件) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT7056GappeiShichosonEntity> entityList = accessor.
                select().
                table(DbT7056GappeiShichoson.class).
                where(検索条件).
                order(by(gappeiYMD, Order.ASC)).
                toList(DbT7056GappeiShichosonEntity.class);
        return getModelList(entityList);
    }

    private IItemList<IGappeiShichoson> getModelList(List<DbT7056GappeiShichosonEntity> entityList) {
        List<IGappeiShichoson> list = new ArrayList<>();
        for (DbT7056GappeiShichosonEntity entity : entityList) {
            list.add(new GappeiShichosonModel(entity));
        }
        return ItemList.of(list);
    }

    @Override
    public int insertOrUpdate(DbT7056GappeiShichosonEntity entity) {
        return getMatchRowCount(entity) == 0 ? insert(entity) : update(entity);
    }

    @Override
    public int insert(DbT7056GappeiShichosonEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Override
    public int update(DbT7056GappeiShichosonEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Override
    public int delete(DbT7056GappeiShichosonEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    private int getMatchRowCount(DbT7056GappeiShichosonEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select()
                .table(DbT7056GappeiShichoson.class)
                .where(and(
                                eq(gappeiYMD, entity.getGappeiYMD()),
                                eq(chiikiNo, entity.getChiikiNo()),
                                eq(kyuShichosonCode, entity.getKyuShichosonCode())))
                .getCount();
    }
}
