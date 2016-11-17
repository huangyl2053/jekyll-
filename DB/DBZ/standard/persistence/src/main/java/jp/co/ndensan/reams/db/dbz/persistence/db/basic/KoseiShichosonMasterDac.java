/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMaster;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMaster.gappeiKyuShichosonKubun;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMaster.kanyuYMD;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMaster.shichosonCode;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMaster.shichosonShokibetsuID;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMaster.shoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.persistence.IDeletable;
import jp.co.ndensan.reams.db.dbz.persistence.IReplaceable;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 構成市町村マスタのデータアクセスクラスです。 <br/>
 * （※別チケットで対応）
 *
 * @author N8156 宮本 康
 */
public class KoseiShichosonMasterDac implements IReplaceable<DbT7051KoseiShichosonMasterEntity>, IDeletable<DbT7051KoseiShichosonMasterEntity> {

    @InjectSession
    private SqlSession session;

    private static final RString 最新の構成市町村 = new RString("0");

    /**
     * 指定した検索条件に合致する広域構成市町村を取得します。
     *
     * @param 検索条件 検索条件
     * @return 合併情報リスト
     */
    @Transaction
    public IItemList<DbT7051KoseiShichosonMasterEntity> select(ITrueFalseCriteria 検索条件) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT7051KoseiShichosonMasterEntity> entityList = accessor.
                select().
                table(DbT7051KoseiShichosonMaster.class).
                where(検索条件).
                order(by(kanyuYMD, Order.ASC)).
                toList(DbT7051KoseiShichosonMasterEntity.class);
        return ItemList.of(entityList);
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

    /**
     * 保険者情報を検索します。
     *
     * @param 市町村コード 市町村コード
     * @return 保険者情報
     */
    @Transaction
    public DbT7051KoseiShichosonMasterEntity select保険者情報(LasdecCode 市町村コード) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(DbT7051KoseiShichosonMaster.class).
                where(and(eq(shichosonCode, 市町村コード), eq(gappeiKyuShichosonKubun, 最新の構成市町村))).limit(1).
                toObject(DbT7051KoseiShichosonMasterEntity.class);
    }
}
