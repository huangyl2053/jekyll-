/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3055KogakuKyufuTaishoshaGokei;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3055KogakuKyufuTaishoshaGokei.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3055KogakuKyufuTaishoshaGokei.rirekiNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3055KogakuKyufuTaishoshaGokei.serviceTeikyoYM;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3055KogakuKyufuTaishoshaGokei.setaiShuyakuNo;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3055KogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.leq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 高額介護サービス費給付対象者合計のデータアクセスクラスです。
 *
 * @reamsid_L DBA-0540-600 dongyabin
 */
public class DbT3055KogakuKyufuTaishoshaGokeiDac implements ISaveable<DbT3055KogakuKyufuTaishoshaGokeiEntity> {

    private static final RString 被保険者番号_MSG = new RString("被保険者番号");
    @InjectSession
    private SqlSession session;

    /**
     * 主キーで高額介護サービス費給付対象者合計を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 履歴番号 RirekiNo
     * @return DbT3055KogakuKyufuTaishoshaGokeiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3055KogakuKyufuTaishoshaGokeiEntity selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            Decimal 履歴番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号_MSG.toString()));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3055KogakuKyufuTaishoshaGokei.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT3055KogakuKyufuTaishoshaGokeiEntity.class);
    }

    /**
     * 高額介護サービス費給付対象者合計を全件返します。
     *
     * @return List<DbT3055KogakuKyufuTaishoshaGokeiEntity>
     */
    @Transaction
    public List<DbT3055KogakuKyufuTaishoshaGokeiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3055KogakuKyufuTaishoshaGokei.class).
                toList(DbT3055KogakuKyufuTaishoshaGokeiEntity.class);
    }

    /**
     * DbT3055KogakuKyufuTaishoshaGokeiEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3055KogakuKyufuTaishoshaGokeiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("高額介護サービス費給付対象者合計エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * DbT3055KogakuKyufuTaishoshaGokeiEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    public int delete(DbT3055KogakuKyufuTaishoshaGokeiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("高額介護サービス費給付対象者合計エンティティ"));
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 高額介護サービス費給付対象者合計の最新データを取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return DbT3055KogakuKyufuTaishoshaGokeiEntity
     */
    public List<DbT3055KogakuKyufuTaishoshaGokeiEntity> get高額介護サービス費給付対象者合計の最新データ(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号_MSG.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3055KogakuKyufuTaishoshaGokei.class).
                where((eq(hihokenshaNo, 被保険者番号))).
                order(by(serviceTeikyoYM, Order.DESC), by(rirekiNo, Order.DESC)).
                toList(DbT3055KogakuKyufuTaishoshaGokeiEntity.class);
    }

    /**
     * 高額介護サービス費給付対象者合計データを取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @return List<DbT3055KogakuKyufuTaishoshaGokeiEntity>
     */
    @Transaction
    public DbT3055KogakuKyufuTaishoshaGokeiEntity get高額介護サービス費給付対象者合計(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号_MSG.toString()));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3055KogakuKyufuTaishoshaGokei.class).
                where(and((eq(hihokenshaNo, 被保険者番号)),
                                leq(serviceTeikyoYM, サービス提供年月))).
                order(by(rirekiNo, Order.DESC)).
                limit(1).
                toObject(DbT3055KogakuKyufuTaishoshaGokeiEntity.class);
    }

    /**
     * 高額介護サービス費給付対象者合計データを取得します。
     *
     * @param 世帯集約番号 世帯集約番号
     * @param サービス提供年月 サービス提供年月
     * @return List<DbT3055KogakuKyufuTaishoshaGokeiEntity>
     */
    @Transaction
    public DbT3055KogakuKyufuTaishoshaGokeiEntity get高額介護サービス費給付対象者合計(FlexibleYearMonth サービス提供年月, RString 世帯集約番号) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(世帯集約番号, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯集約番号"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3055KogakuKyufuTaishoshaGokei.class).
                where(and((eq(serviceTeikyoYM, サービス提供年月)),
                                eq(setaiShuyakuNo, 世帯集約番号))).
                toObject(DbT3055KogakuKyufuTaishoshaGokeiEntity.class);
    }
}
