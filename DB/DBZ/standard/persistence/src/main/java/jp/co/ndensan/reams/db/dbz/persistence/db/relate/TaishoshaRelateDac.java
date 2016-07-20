/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.relate;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV7901ShikakuSearch;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV7901ShikakuSearchEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV7902FukaSearch;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV7902FukaSearchEntity;
//import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV7901ShikakuSearch.shikibetsuCode;
//import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV7902FukaSearch.shikibetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.FukaTaishoshaRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.TaishoshaRelateEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorForAppendType;
import jp.co.ndensan.reams.uz.uza.util.db.IOrderClause;
import jp.co.ndensan.reams.uz.uza.util.db.IOrderable;
import jp.co.ndensan.reams.uz.uza.util.db.IPsmCriteria;
import jp.co.ndensan.reams.uz.uza.util.db.ITableClause;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import jp.co.ndensan.reams.uz.uza.util.db.NullsOrder;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import jp.co.ndensan.reams.uz.uza.util.db.OrderBy;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.using;

/**
 * 対象者のデータアクセスクラスです。
 *
 * @author N8156 宮本 康
 */
public class TaishoshaRelateDac {

    @InjectSession
    private SqlSession session;

    /**
     * 条件に該当する資格対象者数を返します。
     *
     * @param 条件 介護の検索条件
     * @param psm 宛名psm
     * @param is内部結合 内部結合する場合はtrue、外部結合する場合はfalse
     * @return 対象者数
     */
    @Transaction
    public int get資格対象者Count(ITrueFalseCriteria 条件, IPsmCriteria psm, boolean is内部結合) {
        ITableClause table = create資格対象者TableClause(psm, is内部結合);
        return ((条件 != null) ? table.where(条件) : table).getCount();
    }

    /**
     * 条件に該当する資格対象者識別コードリストを検索します。
     *
     * @param 条件 介護の検索条件
     * @return 対象者識別コードリスト
     */
    @Transaction
    public ItemList<ShikibetsuCode> get資格対象識別コードリスト(ITrueFalseCriteria 条件) {

        DbAccessorForAppendType accessor = new DbAccessorForAppendType(session);

        List<DbV7901ShikakuSearchEntity> list;

         list = accessor
                .select()
                .table(DbV7901ShikakuSearch.class).where(条件).toList(DbV7901ShikakuSearchEntity.class);
        List<ShikibetsuCode> modelList = new ArrayList<>();
        for (DbV7901ShikakuSearchEntity entity : list) {
            if (entity.getShikibetsuCode() != null) {
                modelList.add(entity.getShikibetsuCode());
            }
        }
        return ItemList.of(modelList);

    }

    /**
     * 条件に該当する賦課対象者識別コードリストを検索します。
     *
     * @param 条件 介護の検索条件
     * @return 対象者識別コードリスト
     */
    @Transaction
    public ItemList<ShikibetsuCode> get賦課対象識別コードリスト(ITrueFalseCriteria 条件) {
        DbAccessorForAppendType accessor = new DbAccessorForAppendType(session);

        List<DbV7902FukaSearchEntity> list;
            list = accessor
                    .select()
                    .table(DbV7902FukaSearch.class).where(条件).toList(DbV7902FukaSearchEntity.class);
        List<ShikibetsuCode> modelList = new ArrayList<>();
        for (DbV7902FukaSearchEntity entity : list) {
            if (entity.getShikibetsuCode() != null) {
                modelList.add(entity.getShikibetsuCode());
            }
        }
        return ItemList.of(modelList);

//        return ItemList.of(accessor
//                .selectSpecific(jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV7902FukaSearch.shikibetsuCode)
//                .table(DbV7902FukaSearch.class).where(条件).toList(ShikibetsuCode.class));
    }

    /**
     * 条件に該当する資格対象者を検索します。
     *
     * @param 条件 介護の検索条件
     * @param psm 宛名psm
     * @param is内部結合 内部結合する場合はtrue、外部結合する場合はfalse
     * @param 最大件数 最大取得件数
     * @return 対象者
     */
    @Transaction
    public IItemList<TaishoshaRelateEntity> select資格対象者(ITrueFalseCriteria 条件, IPsmCriteria psm, boolean is内部結合, int 最大件数) {
        ITableClause table = create資格対象者TableClause(psm, is内部結合);
        return to資格ModelList(((条件 != null) ? table.where(条件).limit(最大件数) : table.limit(最大件数)).toList(TaishoshaRelateEntity.class));
    }

    private ITableClause create資格対象者TableClause(IPsmCriteria psm, boolean is内部結合) {
        DbAccessorForAppendType accessor = new DbAccessorForAppendType(session);
        ITableClause table = (is内部結合)
                             ? accessor.select().table(psm).innerJoin(DbV7901ShikakuSearch.class, using(DbV7901ShikakuSearch.shikibetsuCode))
                             : accessor.select().table(psm).leftJoin(DbV7901ShikakuSearch.class, using(DbV7901ShikakuSearch.shikibetsuCode));
        return table;
    }

    /**
     * 条件に該当する賦課対象者数を返します。
     *
     * @param 条件 介護の検索条件
     * @param psm 宛名psm
     * @param is内部結合 内部結合する場合はtrue、外部結合する場合はfalse
     * @return 対象者数
     */
    @Transaction
    public int get賦課対象者Count(ITrueFalseCriteria 条件, IPsmCriteria psm, boolean is内部結合) {
        ITableClause table = create賦課対象者TableClause(psm, is内部結合);
        return ((条件 != null) ? table.where(条件) : table).getCount();
    }

    /**
     * 条件に該当する賦課対象者を検索します。
     *
     * @param 条件 介護の検索条件
     * @param psm 宛名psm
     * @param is内部結合 内部結合する場合はtrue、外部結合する場合はfalse
     * @param 最大件数 最大取得件数
     * @return 対象者
     */
    @Transaction
    public IItemList<FukaTaishoshaRelateEntity> select賦課対象者(ITrueFalseCriteria 条件, IPsmCriteria psm, boolean is内部結合, int 最大件数) {
        ITableClause table = create賦課対象者TableClause(psm, is内部結合);
        return to賦課ModelList(((条件 != null)
                              ? createOrderByClause(table.where(条件)).limit(最大件数)
                              : createOrderByClause(table).limit(最大件数)).toList(FukaTaishoshaRelateEntity.class));
    }

    private ITableClause create賦課対象者TableClause(IPsmCriteria psm, boolean is内部結合) {
        DbAccessorForAppendType accessor = new DbAccessorForAppendType(session);
        ITableClause table = (is内部結合)
                             ? accessor.select().table(psm).innerJoin(DbV7902FukaSearch.class, using(DbV7902FukaSearch.shikibetsuCode))
                             : accessor.select().table(psm).leftJoin(DbV7902FukaSearch.class, using(DbV7902FukaSearch.shikibetsuCode));
        return table;
    }

    private IOrderClause createOrderByClause(IOrderable table) {
        return table.order(new OrderBy(DbV7902FukaSearch.fukaNendo, Order.DESC, NullsOrder.LAST),
                new OrderBy(DbV7902FukaSearch.choteiNendo, Order.DESC, NullsOrder.LAST),
                new OrderBy(DbV7902FukaSearch.tsuchishoNo, Order.DESC, NullsOrder.LAST));
    }

    private IItemList<TaishoshaRelateEntity> to資格ModelList(List<TaishoshaRelateEntity> entityList) {
        List<TaishoshaRelateEntity> modelList = new ArrayList<>();
        for (TaishoshaRelateEntity entity : entityList) {
            modelList.add(entity);
        }
        return ItemList.of(modelList);
    }

    private IItemList<FukaTaishoshaRelateEntity> to賦課ModelList(List<FukaTaishoshaRelateEntity> entityList) {
        List<FukaTaishoshaRelateEntity> modelList = new ArrayList<>();
        for (FukaTaishoshaRelateEntity entity : entityList) {
            modelList.add(entity);
        }
        return ItemList.of(modelList);
    }
}
