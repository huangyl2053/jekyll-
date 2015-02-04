/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7051KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.model.koiki.IKoikiKoseiShichoson;
import jp.co.ndensan.reams.db.dbz.model.koiki.KoikiKoseiShichosonModel;
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
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7051KoseiShichosonMaster.*;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;

/**
 * 構成市町村マスタのデータアクセスクラスです。 <br/>
 * （※別チケットで対応）
 *
 * @author N8156 宮本 康
 */
public class KoseiShichosonMasterDac implements IReplaceable<DbT7051KoseiShichosonMasterEntity>, IDeletable<DbT7051KoseiShichosonMasterEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 指定した検索条件に合致する広域構成市町村を取得します。
     *
     * @param 検索条件 検索条件
     * @return 合併情報リスト
     */
    @Transaction
    public IItemList<IKoikiKoseiShichoson> select(ITrueFalseCriteria 検索条件) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT7051KoseiShichosonMasterEntity> entityList = accessor.
                select().
                table(DbT7051KoseiShichosonMaster.class).
                where(検索条件).
                order(by(kanyuYMD, Order.ASC)).
                toList(DbT7051KoseiShichosonMasterEntity.class);
        return getModelList(entityList);
    }

    private IItemList<IKoikiKoseiShichoson> getModelList(List<DbT7051KoseiShichosonMasterEntity> entityList) {
        List<IKoikiKoseiShichoson> list = new ArrayList<>();
        for (DbT7051KoseiShichosonMasterEntity entity : entityList) {
            list.add(new KoikiKoseiShichosonModel(entity));
        }
        return ItemList.of(list);
    }

    @Override
    public int insertOrUpdate(DbT7051KoseiShichosonMasterEntity entity) {
        return getMatchRowCount(entity) == 0 ? insert(entity) : update(entity);
    }

    @Override
    public int insert(DbT7051KoseiShichosonMasterEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Override
    public int update(DbT7051KoseiShichosonMasterEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Override
    public int delete(DbT7051KoseiShichosonMasterEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    private int getMatchRowCount(DbT7051KoseiShichosonMasterEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select()
                .table(DbT7051KoseiShichosonMaster.class)
                .where(and(
                                eq(shichosonShokibetsuID, entity.getShichosonShokibetsuID()),
                                eq(shichosonCode, entity.getShichosonCode()),
                                eq(shoKisaiHokenshaNo, entity.getShoKisaiHokenshaNo())))
                .getCount();
    }
}
