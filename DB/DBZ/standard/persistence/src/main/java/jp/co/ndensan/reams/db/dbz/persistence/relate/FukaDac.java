/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ChoteiNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT2002Fuka.choteiNendo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT2002Fuka.shoriTimestamp;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT2002Fuka.tsuchishoNo;
import jp.co.ndensan.reams.db.dbz.model.fuka.FukaModel;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT2002FukaDac;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2002Fuka;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT2002Fuka.fukaNendo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT2002Fuka.hihokenshaNo;

/**
 * 賦課のデータアクセスクラスです。
 *
 * @author n3317 塚田 萌
 */
public class FukaDac implements IModifiable<FukaModel> {

    @InjectSession
    private SqlSession session;
    private final DbT2002FukaDac 介護賦課Dac = InstanceProvider.create(DbT2002FukaDac.class);

    /**
     * 賦課情報をキー検索で１件返します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 処理日時 処理日時
     * @return FukaModel
     */
    @Transaction
    public Optional<FukaModel> select賦課ByKey(ChoteiNendo 調定年度, FukaNendo 賦課年度,
            TsuchishoNo 通知書番号, RDateTime 処理日時) {

        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        return Optional.ofNullable(createModel(介護賦課Dac.selectByKey(
                調定年度, 賦課年度, 通知書番号, 処理日時)));
    }

    /**
     * 引数に該当するデータから直近の１件を取得します。<br/>
     * 直近とは以下の条件でソートした１件目です。<br/>
     * 通知書番号（降順）＞調定年度（降順）＞処理日時（降順）かつ　引数の処理日時　＞　対象データの処理日時
     *
     * @param 賦課年度 賦課年度
     * @param 被保険者番号 被保険者番号
     * @param 処理日時 処理日時
     * @return 直近賦課情報
     * @throws NullPointerException 引数がnullの時
     */
    @Transaction
    public Optional<FukaModel> select賦課Recently(
            FukaNendo 賦課年度,
            HihokenshaNo 被保険者番号,
            RDateTime 処理日時) throws NullPointerException {

        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        List<DbT2002FukaEntity> entities = accessor.select().
                table(DbT2002Fuka.class).
                where(and(
                                eq(fukaNendo, 賦課年度.value()),
                                eq(hihokenshaNo, 被保険者番号),
                                lt(shoriTimestamp, 処理日時))).
                order(
                        by(tsuchishoNo, Order.DESC),
                        by(choteiNendo, Order.DESC),
                        by(shoriTimestamp, Order.DESC)).
                toList(DbT2002FukaEntity.class);

        return Optional.ofNullable(createModel(entities.isEmpty() ? null : entities.get(0)));
    }

    /**
     * 条件に合致する介護賦課のリストを返します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @return IItemList<FukaModel>
     */
    @Transaction
    public IItemList<FukaModel> select介護賦課一覧(ChoteiNendo 調定年度, FukaNendo 賦課年度, TsuchishoNo 通知書番号) {

        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT2002FukaEntity> 介護賦課List = accessor.select().
                table(DbT2002Fuka.class).
                where(and(eq(DbT2002Fuka.choteiNendo, 調定年度.value()),
                                eq(DbT2002Fuka.fukaNendo, 賦課年度.value()),
                                eq(DbT2002Fuka.tsuchishoNo, 通知書番号))).
                toList(DbT2002FukaEntity.class);

        List<FukaModel> list = new ArrayList<>();

        for (DbT2002FukaEntity 介護賦課 : 介護賦課List) {
            list.add(createModel(介護賦課));
        }

        return ItemList.of(list);
    }

    /**
     * 条件に合致する最新介護賦課を１件返します。
     *
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @return Optional<FukaModel>
     */
    @Transaction
    public Optional<FukaModel> select最新介護賦課(FukaNendo 賦課年度, TsuchishoNo 通知書番号) {

        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT2002FukaEntity> 介護賦課List = accessor.select().
                table(DbT2002Fuka.class).
                where(and(eq(DbT2002Fuka.fukaNendo, 賦課年度.value()),
                                eq(DbT2002Fuka.tsuchishoNo, 通知書番号))).
                order(by(DbT2002Fuka.choteiNendo, Order.DESC), by(DbT2002Fuka.shoriTimestamp, Order.DESC)).
                toList(DbT2002FukaEntity.class);

        return Optional.ofNullable(!介護賦課List.isEmpty() ? createModel(介護賦課List.get(0)) : null);
    }

    /**
     * 条件に合致する介護賦課のリストを返します。
     *
     * @param 被保険者番号 被保険者番号
     * @return IItemList<FukaModel>
     */
    @Transaction
    public IItemList<FukaModel> select介護賦課一覧(HihokenshaNo 被保険者番号) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT2002FukaEntity> 介護賦課List = accessor.select().
                table(DbT2002Fuka.class).
                where(eq(DbT2002Fuka.hihokenshaNo, 被保険者番号)).
                toList(DbT2002FukaEntity.class);

        List<FukaModel> list = new ArrayList<>();

        for (DbT2002FukaEntity 介護賦課 : 介護賦課List) {
            list.add(createModel(介護賦課));
        }

        return ItemList.of(list);
    }

    /**
     * 条件に合致する介護賦課のリストを返します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 賦課年度 賦課年度
     * @return IItemList<FukaModel>
     */
    @Transaction
    public IItemList<FukaModel> select介護賦課一覧(HihokenshaNo 被保険者番号, FukaNendo 賦課年度) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT2002FukaEntity> 介護賦課List = accessor.select().
                table(DbT2002Fuka.class).
                where(and(eq(DbT2002Fuka.hihokenshaNo, 被保険者番号),
                                eq(DbT2002Fuka.fukaNendo, 賦課年度.value()))).
                toList(DbT2002FukaEntity.class);

        List<FukaModel> list = new ArrayList<>();

        for (DbT2002FukaEntity 介護賦課 : 介護賦課List) {
            list.add(createModel(介護賦課));
        }

        return ItemList.of(list);
    }

    private FukaModel createModel(DbT2002FukaEntity 介護賦課エンティティ) {
        if (介護賦課エンティティ == null) {
            return null;
        }
        return new FukaModel(介護賦課エンティティ);
    }

    @Override
    public int insert(FukaModel data) {
        if (data == null) {
            return 0;
        }
        return 介護賦課Dac.insert(data.getEntity());
    }

    @Override
    public int update(FukaModel data) {
        if (data == null) {
            return 0;
        }
        return 介護賦課Dac.update(data.getEntity());
    }

    @Override
    public int delete(FukaModel data) {
        if (data == null) {
            return 0;
        }
        return 介護賦課Dac.delete(data.getEntity());
    }
}
