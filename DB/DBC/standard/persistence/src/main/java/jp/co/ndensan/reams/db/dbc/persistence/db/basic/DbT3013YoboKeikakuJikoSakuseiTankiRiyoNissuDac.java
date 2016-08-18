/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissu;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissu.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissu.rirekiNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissu.riyoYM;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissu.taishoYM;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 予防給付計画自己作成短期利用日数のデータアクセスクラスです。
 */
public class DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuDac
        implements ISaveable<DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで予防給付計画自己作成短期利用日数を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年月 TaishoYM
     * @param 履歴番号 RirekiNo
     * @return DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月,
            Decimal 履歴番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissu.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(taishoYM, 対象年月),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity.class);
    }

    /**
     * 予防給付計画自己作成短期利用日数を全件返します。
     *
     * @return List<DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity>
     */
    @Transaction
    public List<DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissu.class).
                toList(DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity.class);
    }

    /**
     * DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("予防給付計画自己作成短期利用日数エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntityを削除します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    public int delete(DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("予防給付計画自己作成短期利用日数エンティティ"));
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 予防給付計画自己作成短期利用日数を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年月 TaishoYM
     * @param 履歴番号 RirekiNo
     * @param 利用年月 RiyoYM
     * @return DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity select予防短期入所情報(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月,
            int 履歴番号,
            FlexibleYearMonth 利用年月) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(利用年月, UrSystemErrorMessages.値がnull.getReplacedMessage("利用年月"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissu.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(taishoYM, 対象年月),
                                eq(rirekiNo, 履歴番号),
                                eq(riyoYM, 利用年月))).
                toObject(DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity.class);
    }
}
