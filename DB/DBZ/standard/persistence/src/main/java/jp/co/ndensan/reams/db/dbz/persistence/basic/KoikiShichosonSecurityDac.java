/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7057KoikiShichosonSecurity;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7057KoikiShichosonSecurityEntity;
import jp.co.ndensan.reams.db.dbz.model.KoikiShichosonSecurityModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.persistence.IDeletable;
import jp.co.ndensan.reams.db.dbz.persistence.IReplaceable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7057KoikiShichosonSecurity.*;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;

/**
 * 広域市町村セキュリティのデータアクセスクラスです。
 *
 * @author N8156 宮本 康
 */
public class KoikiShichosonSecurityDac
        implements IReplaceable<DbT7057KoikiShichosonSecurityEntity>, IDeletable<DbT7057KoikiShichosonSecurityEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 指定した検索条件に合致する広域市町村セキュリティを取得します。
     *
     * @param 検索条件 検索条件
     * @return 広域市町村セキュリティリスト
     */
    @Transaction
    public IItemList<KoikiShichosonSecurityModel> select(ITrueFalseCriteria 検索条件) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT7057KoikiShichosonSecurityEntity> entityList = accessor.
                select().
                table(DbT7057KoikiShichosonSecurity.class).
                where(検索条件).
                order(by(groupID, Order.ASC)).
                toList(DbT7057KoikiShichosonSecurityEntity.class);
        return getModelList(entityList);
    }

    private IItemList<KoikiShichosonSecurityModel> getModelList(List<DbT7057KoikiShichosonSecurityEntity> entityList) {
        List<KoikiShichosonSecurityModel> list = new ArrayList<>();
        for (DbT7057KoikiShichosonSecurityEntity entity : entityList) {
            list.add(new KoikiShichosonSecurityModel(entity));
        }
        return ItemList.of(list);
    }

    @Override
    public int insertOrUpdate(DbT7057KoikiShichosonSecurityEntity entity) {
        return getMatchRowCount(entity) == 0 ? insert(entity) : update(entity);
    }

    @Override
    public int insert(DbT7057KoikiShichosonSecurityEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Override
    public int update(DbT7057KoikiShichosonSecurityEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Override
    public int delete(DbT7057KoikiShichosonSecurityEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    private int getMatchRowCount(DbT7057KoikiShichosonSecurityEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select()
                .table(DbT7057KoikiShichosonSecurity.class)
                .where(eq(groupID, entity.getGroupID()))
                .getCount();
    }
}
