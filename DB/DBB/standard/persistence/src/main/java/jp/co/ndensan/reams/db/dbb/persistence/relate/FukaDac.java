/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.relate;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2002Fuka;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2002FukaEntity;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2006ChoshuYuyo.choteiNendo;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2006ChoshuYuyo.rirekiNo;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2010FukaErrorList.fukaNendo;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2010FukaErrorList.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2010FukaErrorList.tsuchishoNo;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2002FukaDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV2002Fuka;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.lt;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 賦課のデータアクセスクラスです。
 *
 * @author n3317 塚田 萌
 */
public class FukaDac implements IModifiable<DbT2002FukaEntity> {

    @InjectSession
    private SqlSession session;
    private final DbT2002FukaDac 介護賦課Dac = InstanceProvider.create(DbT2002FukaDac.class);

    /**
     * 賦課情報をキー検索で１件返します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 履歴番号 履歴番号
     * @return DbT2002FukaEntity
     */
    @Transaction
    public Optional<DbT2002FukaEntity> select賦課ByKey(FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号,
            int 履歴番号) {

        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        return Optional.ofNullable(createModel(介護賦課Dac.selectByKey(
                調定年度, 賦課年度, 通知書番号, 履歴番号)));
    }

    /**
     * 引数に該当するデータから直近の１件を取得します。<br/>
     * 直近とは以下の条件でソートした１件目です。<br/>
     * 通知書番号（降順）＞調定年度（降順）＞処理日時（降順）かつ　引数の処理日時　＞　対象データの処理日時
     *
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 履歴番号 履歴番号
     * @return 直近賦課情報
     * @throws NullPointerException 引数がnullの時
     */
    @Transaction
    public Optional<DbT2002FukaEntity> select賦課Recently(
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号,
            int 履歴番号) throws NullPointerException {

        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        List<DbT2002FukaEntity> entities = accessor.select().
                table(DbT2002Fuka.class).
                where(and(
                                eq(fukaNendo, 賦課年度),
                                eq(hihokenshaNo, 通知書番号),
                                lt(rirekiNo, 履歴番号))).
                order(
                        by(tsuchishoNo, Order.DESC),
                        by(choteiNendo, Order.DESC),
                        by(rirekiNo, Order.DESC)).
                toList(DbT2002FukaEntity.class);

        return Optional.ofNullable(createModel(entities.isEmpty() ? null : entities.get(0)));
    }

    /**
     * 引数の通知書番号に一致するデータで<br/>
     * 引数の処理日時より前で一番直近のデータを１件取得します。
     *
     * @param 通知書番号 通知書番号
     * @param 処理日時 処理日時
     * @return 直近賦課情報
     * @throws NullPointerException 引数がnullの時
     */
    @Transaction
    public Optional<DbT2002FukaEntity> select賦課Recently(
            TsuchishoNo 通知書番号,
            RDateTime 処理日時) throws NullPointerException {

        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        List<DbT2002FukaEntity> entities = accessor.select().
                table(DbT2002Fuka.class).
                where(and(
                                eq(tsuchishoNo, 通知書番号),
                                lt(rirekiNo, 処理日時))).
                order(
                        by(choteiNendo, Order.DESC),
                        by(fukaNendo, Order.DESC),
                        by(rirekiNo, Order.DESC)).
                toList(DbT2002FukaEntity.class);

        return Optional.ofNullable(createModel(entities.isEmpty() ? null : entities.get(0)));
    }

    /**
     * 条件に合致する介護賦課のリストを返します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @return IItemList<DbT2002FukaEntity>
     */
    @Transaction
    public IItemList<DbT2002FukaEntity> select介護賦課一覧(FlexibleYear 調定年度, FlexibleYear 賦課年度, TsuchishoNo 通知書番号) {

        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT2002FukaEntity> 介護賦課List = accessor.select().
                table(DbT2002Fuka.class).
                where(and(eq(DbT2002Fuka.choteiNendo, 調定年度),
                                eq(DbT2002Fuka.fukaNendo, 賦課年度),
                                eq(DbT2002Fuka.tsuchishoNo, 通知書番号))).
                order(by(rirekiNo, Order.DESC)).
                toList(DbT2002FukaEntity.class);

        List<DbT2002FukaEntity> list = new ArrayList<>();

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
     * @return Optional<DbT2002FukaEntity>
     */
    @Transaction
    public Optional<DbT2002FukaEntity> select最新介護賦課(FlexibleYear 賦課年度, TsuchishoNo 通知書番号) {

        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT2002FukaEntity> 介護賦課List = accessor.select().
                table(DbT2002Fuka.class).
                where(and(eq(DbT2002Fuka.fukaNendo, 賦課年度),
                                eq(DbT2002Fuka.tsuchishoNo, 通知書番号))).
                order(by(DbT2002Fuka.choteiNendo, Order.DESC), by(DbT2002Fuka.rirekiNo, Order.DESC)).
                toList(DbT2002FukaEntity.class);

        return Optional.ofNullable(!介護賦課List.isEmpty() ? createModel(介護賦課List.get(0)) : null);
    }

    /**
     * 条件に合致する介護賦課のリストを返します。
     *
     * @param 被保険者番号 被保険者番号
     * @return IItemList<DbT2002FukaEntity>
     */
    @Transaction
    public IItemList<DbT2002FukaEntity> select介護賦課一覧(HihokenshaNo 被保険者番号) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT2002FukaEntity> 介護賦課List = accessor.select().
                table(DbT2002Fuka.class).
                where(eq(DbT2002Fuka.hihokenshaNo, 被保険者番号)).
                toList(DbT2002FukaEntity.class);

        List<DbT2002FukaEntity> list = new ArrayList<>();

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
     * @return IItemList<DbT2002FukaEntity>
     */
    @Transaction
    public IItemList<DbT2002FukaEntity> select介護賦課一覧(HihokenshaNo 被保険者番号, FlexibleYear 賦課年度) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT2002FukaEntity> 介護賦課List = accessor.select().
                table(DbT2002Fuka.class).
                where(and(eq(DbT2002Fuka.hihokenshaNo, 被保険者番号),
                                eq(DbT2002Fuka.fukaNendo, 賦課年度))).
                toList(DbT2002FukaEntity.class);

        List<DbT2002FukaEntity> list = new ArrayList<>();

        for (DbT2002FukaEntity 介護賦課 : 介護賦課List) {
            list.add(createModel(介護賦課));
        }

        return ItemList.of(list);
    }

    /**
     * 賦課情報をキー検索で処理日時が直近の介護賦課を返します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @return DbT2002FukaEntity
     */
    @Transaction
    public IItemList<DbT2002FukaEntity> selectRecently賦課(FlexibleYear 調定年度, FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号) {

        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT2002FukaEntity> 介護賦課List = accessor.select().
                table(DbV2002Fuka.class).
                where(and(eq(DbV2002Fuka.choteiNendo, 調定年度),
                                eq(DbV2002Fuka.fukaNendo, 賦課年度),
                                eq(DbV2002Fuka.tsuchishoNo, 通知書番号))).
                order(by(DbV2002Fuka.choteiNendo, Order.DESC), by(DbV2002Fuka.fukaNendo, Order.DESC), by(DbV2002Fuka.tsuchishoNo, Order.DESC)).
                toList(DbT2002FukaEntity.class);

        List<DbT2002FukaEntity> list = new ArrayList<>();

        for (DbT2002FukaEntity 介護賦課 : 介護賦課List) {
            list.add(createModel(介護賦課));
        }

        return ItemList.of(list);

    }

    /**
     * 賦課情報をキー検索で処理日時が直近の介護賦課のリストを返します。
     *
     * @param 通知書番号 通知書番号
     * @return DbT2002FukaEntity
     */
    @Transaction
    public IItemList<DbT2002FukaEntity> selectRecently賦課一覧by通知書番号(TsuchishoNo 通知書番号) {

        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT2002FukaEntity> 介護賦課List = accessor.select().
                table(DbV2002Fuka.class).
                where(eq(DbV2002Fuka.tsuchishoNo, 通知書番号)).
                order(by(DbV2002Fuka.choteiNendo, Order.DESC), by(DbV2002Fuka.fukaNendo, Order.DESC), by(DbV2002Fuka.tsuchishoNo, Order.DESC)).
                toList(DbT2002FukaEntity.class);

        List<DbT2002FukaEntity> list = new ArrayList<>();

        for (DbT2002FukaEntity 介護賦課 : 介護賦課List) {
            list.add(createModel(介護賦課));
        }

        return ItemList.of(list);

    }

    private DbT2002FukaEntity createModel(DbT2002FukaEntity 介護賦課エンティティ) {
        if (介護賦課エンティティ == null) {
            return null;
        }
        return 介護賦課エンティティ;
    }

    @Override
    public int insert(DbT2002FukaEntity data) {
        if (data == null) {
            return 0;
        }
        return 介護賦課Dac.save(data);
    }

    @Override
    public int update(DbT2002FukaEntity data) {
        if (data == null) {
            return 0;
        }
        return 介護賦課Dac.save(data);
    }

    @Override
    public int delete(DbT2002FukaEntity data) {
        if (data == null) {
            return 0;
        }
        return 介護賦課Dac.save(data);
    }
}
