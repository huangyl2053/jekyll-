/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3074KogakuGassanShikyuFushikyuKettei;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3074KogakuGassanShikyuFushikyuKettei.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3074KogakuGassanShikyuFushikyuKettei.hokenshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3074KogakuGassanShikyuFushikyuKettei.isDeleted;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3074KogakuGassanShikyuFushikyuKettei.rirekiNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3074KogakuGassanShikyuFushikyuKettei.shikyuSeiriNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3074KogakuGassanShikyuFushikyuKettei.taishoNendo;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3074KogakuGassanShikyuFushikyuKetteiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 高額合算支給不支給決定のデータアクセスクラスです。
 *
 * @reamsid_L DBC-9999-012 quxiaodong
 */
public class DbT3074KogakuGassanShikyuFushikyuKetteiDac implements ISaveable<DbT3074KogakuGassanShikyuFushikyuKetteiEntity> {

    @InjectSession
    private SqlSession session;
    private static final RString 被保番号 = new RString("被保険者番号");
    private static final RString 対象の年度 = new RString("対象年度");
    private static final RString 保険番号 = new RString("保険者番号");
    private static final RString 支給整理番号 = new RString("支給申請書整理番号");
    private static final RString 履歴の番号 = new RString("履歴番号");
    private static final RString 高額合算支給不支給決定エンティティ = new RString("高額合算支給不支給決定エンティティ");
    private static final RString メッセージ_支給申請書整理番号 = new RString("支給申請書整理番号");

    /**
     * 主キーで高額合算支給不支給決定を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年度 TaishoNendo
     * @param 保険者番号 HokenshaNo
     * @param 支給申請書整理番号 ShikyuSeiriNo
     * @param 履歴番号 RirekiNo
     * @return DbT3074KogakuGassanShikyuFushikyuKetteiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3074KogakuGassanShikyuFushikyuKetteiEntity selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            HokenshaNo 保険者番号,
            RString 支給申請書整理番号,
            int 履歴番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保番号.toString()));
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage(対象の年度.toString()));
        requireNonNull(保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(保険番号.toString()));
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(支給整理番号.toString()));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage(履歴の番号.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3074KogakuGassanShikyuFushikyuKettei.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(taishoNendo, 対象年度),
                                eq(hokenshaNo, 保険者番号),
                                eq(shikyuSeiriNo, 支給申請書整理番号),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT3074KogakuGassanShikyuFushikyuKetteiEntity.class);
    }

    /**
     * 高額合算支給不支給決定を全件返します。
     *
     * @return List<DbT3074KogakuGassanShikyuFushikyuKetteiEntity>
     */
    @Transaction
    public List<DbT3074KogakuGassanShikyuFushikyuKetteiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3074KogakuGassanShikyuFushikyuKettei.class).
                toList(DbT3074KogakuGassanShikyuFushikyuKetteiEntity.class);
    }

    /**
     * DbT3074KogakuGassanShikyuFushikyuKetteiEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3074KogakuGassanShikyuFushikyuKetteiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage(高額合算支給不支給決定エンティティ.toString()));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * DbT3074KogakuGassanShikyuFushikyuKetteiEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    public int delete(DbT3074KogakuGassanShikyuFushikyuKetteiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage(高額合算支給不支給決定エンティティ.toString()));
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 高額合算支給不支給決定を全件返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return List<DbT3074KogakuGassanShikyuFushikyuKetteiEntity>
     */
    @Transaction
    public List<DbT3074KogakuGassanShikyuFushikyuKetteiEntity> selectAll(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保番号.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3074KogakuGassanShikyuFushikyuKettei.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(isDeleted, false))).
                order(by(taishoNendo, Order.DESC), by(shikyuSeiriNo, Order.DESC), by(rirekiNo, Order.DESC)).
                toList(DbT3074KogakuGassanShikyuFushikyuKetteiEntity.class);
    }

    /**
     * 高額合算支給不支給決定を全件返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年度 TaishoNendo
     * @param 保険者番号 HokenshaNo
     * @param 支給申請書整理番号 ShikyuSeiriNo
     * @return DbT3074KogakuGassanShikyuFushikyuKetteiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT3074KogakuGassanShikyuFushikyuKetteiEntity> getAll(
            HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            HokenshaNo 保険者番号,
            RString 支給申請書整理番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保番号.toString()));
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage(対象の年度.toString()));
        requireNonNull(保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(保険番号.toString()));
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(支給整理番号.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3074KogakuGassanShikyuFushikyuKettei.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(taishoNendo, 対象年度),
                                eq(hokenshaNo, 保険者番号),
                                eq(shikyuSeiriNo, 支給申請書整理番号))).
                order(by(shikyuSeiriNo, Order.DESC), by(rirekiNo, Order.DESC)).
                toList(DbT3074KogakuGassanShikyuFushikyuKetteiEntity.class);
    }

    /**
     * 高額合算支給不支給決定を全件返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年度 TaishoNendo
     * @param 保険者番号 HokenshaNo
     * @param 支給申請書整理番号 ShikyuSeiriNo
     * @return DbT3074KogakuGassanShikyuFushikyuKetteiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3074KogakuGassanShikyuFushikyuKetteiEntity getMax履歴番号のentity(
            HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            HokenshaNo 保険者番号,
            RString 支給申請書整理番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保番号.toString()));
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage(対象の年度.toString()));
        requireNonNull(保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(保険番号.toString()));
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(支給整理番号.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3074KogakuGassanShikyuFushikyuKettei.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(taishoNendo, 対象年度),
                                eq(hokenshaNo, 保険者番号),
                                eq(shikyuSeiriNo, 支給申請書整理番号),
                                eq(isDeleted, false))).
                order(by(rirekiNo, Order.DESC)).limit(1).
                toObject(DbT3074KogakuGassanShikyuFushikyuKetteiEntity.class);
    }

    /**
     * 高額合算支給不支給決定データを取得します。
     *
     * @param 支給申請書整理番号 RString
     * @return List<DbT3075KogakuGassanKyufuJissekiEntity>
     */
    @Transaction
    public List<DbT3074KogakuGassanShikyuFushikyuKetteiEntity> get高額合算支給不支給決定データ(RString 支給申請書整理番号) {
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_支給申請書整理番号.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT3074KogakuGassanShikyuFushikyuKettei.class).
                where(eq(shikyuSeiriNo, 支給申請書整理番号)).
                toList(DbT3074KogakuGassanShikyuFushikyuKetteiEntity.class);
    }

    /**
     * 高額合算支給不支給決定を全件返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年度 FlexibleYear
     * @param 保険者番号 HokenshaNo
     * @param 支給申請書整理番号 RString
     * @return List<DbT3074KogakuGassanShikyuFushikyuKetteiEntity>
     */
    @Transaction
    public List<DbT3074KogakuGassanShikyuFushikyuKetteiEntity> getAllByKey(HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            HokenshaNo 保険者番号,
            RString 支給申請書整理番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<ITrueFalseCriteria> criteria = new ArrayList<>();
        criteria.add(eq(hihokenshaNo, 被保険者番号));
        if (対象年度 != null && !対象年度.isEmpty()) {
            criteria.add(eq(taishoNendo, 対象年度));
        }
        if (保険者番号 != null && !保険者番号.isEmpty()) {
            criteria.add(eq(hokenshaNo, 保険者番号));
        }
        if (支給申請書整理番号 != null && !支給申請書整理番号.isEmpty()) {
            criteria.add(eq(shikyuSeiriNo, 支給申請書整理番号));
        }
        return accessor.select().
                table(DbT3074KogakuGassanShikyuFushikyuKettei.class).
                where(and(criteria)).
                order(by(taishoNendo, Order.DESC), by(hihokenshaNo, Order.DESC),
                        by(shikyuSeiriNo, Order.DESC), by(rirekiNo, Order.DESC)).
                toList(DbT3074KogakuGassanShikyuFushikyuKetteiEntity.class);
    }

}
