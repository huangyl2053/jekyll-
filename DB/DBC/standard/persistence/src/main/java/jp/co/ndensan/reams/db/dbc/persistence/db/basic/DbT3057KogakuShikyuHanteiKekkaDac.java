/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.definition.core.shinsahoho.ShinsaHohoKubun;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3057KogakuShikyuHanteiKekka;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3057KogakuShikyuHanteiKekka.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3057KogakuShikyuHanteiKekka.ketteiYMD;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3057KogakuShikyuHanteiKekka.rirekiNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3057KogakuShikyuHanteiKekka.serviceTeikyoYM;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3057KogakuShikyuHanteiKekka.shinsaHohoKubun;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3057KogakuShikyuHanteiKekka.shoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3057KogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.not;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.or;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 高額介護サービス費支給判定結果のデータアクセスクラスです。
 *
 * @reamsid_L DBC-9999-012 quxiaodong
 */
public class DbT3057KogakuShikyuHanteiKekkaDac implements ISaveable<DbT3057KogakuShikyuHanteiKekkaEntity> {

    @InjectSession
    private SqlSession session;
    private static final RString 被保番号 = new RString("被保険者番号");
    private static final RString サービス年月 = new RString("サービス提供年月");

    /**
     * 主キーで高額介護サービス費支給判定結果を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 履歴番号 RirekiNo
     * @return DbT3057KogakuShikyuHanteiKekkaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3057KogakuShikyuHanteiKekkaEntity selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            HokenshaNo 証記載保険者番号,
            int 履歴番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保番号.toString()));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage(サービス年月.toString()));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3057KogakuShikyuHanteiKekka.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT3057KogakuShikyuHanteiKekkaEntity.class);
    }

    /**
     * 高額介護サービス費支給判定結果を全件返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @return DbT3057KogakuShikyuHanteiKekkaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT3057KogakuShikyuHanteiKekkaEntity> selectAllByKey(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保番号.toString()));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage(サービス年月.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3057KogakuShikyuHanteiKekka.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, サービス提供年月))).
                toList(DbT3057KogakuShikyuHanteiKekkaEntity.class);
    }

    /**
     * サービス提供年月を取得する。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return List<DbT3057KogakuShikyuHanteiKekkaEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT3057KogakuShikyuHanteiKekkaEntity> selectサービス提供年月(HihokenshaNo 被保険者番号)
            throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保番号.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT3057KogakuShikyuHanteiKekka.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                not(eq(ketteiYMD, FlexibleDate.EMPTY)),
                                or(eq(shinsaHohoKubun, ShinsaHohoKubun.審査依頼.getコード()),
                                        eq(shinsaHohoKubun, ShinsaHohoKubun.審査済み.getコード())
                                ))).
                order(by(serviceTeikyoYM, Order.DESC)).
                toList(DbT3057KogakuShikyuHanteiKekkaEntity.class);
    }

    /**
     * 管理番号を取得する。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @return List<DbT3057KogakuShikyuHanteiKekkaEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT3057KogakuShikyuHanteiKekkaEntity> select管理番号(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月)
            throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保番号.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT3057KogakuShikyuHanteiKekka.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                not(eq(ketteiYMD, FlexibleDate.EMPTY)),
                                eq(serviceTeikyoYM, サービス提供年月),
                                or(eq(shinsaHohoKubun, ShinsaHohoKubun.審査依頼.getコード()),
                                        eq(shinsaHohoKubun, ShinsaHohoKubun.審査済み.getコード())))).
                order(by(rirekiNo, Order.DESC)).
                toList(DbT3057KogakuShikyuHanteiKekkaEntity.class);
    }

    /**
     * 前回発行日を取得する。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param 履歴番号 int
     * @return DbT3057KogakuShikyuHanteiKekkaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3057KogakuShikyuHanteiKekkaEntity select前回発行日(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            int 履歴番号)
            throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保番号.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT3057KogakuShikyuHanteiKekka.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                not(eq(ketteiYMD, FlexibleDate.EMPTY)),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(rirekiNo, 履歴番号),
                                or(eq(shinsaHohoKubun, ShinsaHohoKubun.審査依頼.getコード()),
                                        eq(shinsaHohoKubun, ShinsaHohoKubun.審査済み.getコード())))).
                toObject(DbT3057KogakuShikyuHanteiKekkaEntity.class);
    }

    /**
     * 高額介護サービス費支給判定結果を全件返します。
     *
     * @return List<DbT3057KogakuShikyuHanteiKekkaEntity>
     */
    @Transaction
    public List<DbT3057KogakuShikyuHanteiKekkaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3057KogakuShikyuHanteiKekka.class).
                toList(DbT3057KogakuShikyuHanteiKekkaEntity.class);
    }

    /**
     * DbT3057KogakuShikyuHanteiKekkaEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3057KogakuShikyuHanteiKekkaEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("高額介護サービス費支給判定結果エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * DbT3057KogakuShikyuHanteiKekkaEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    public int delete(DbT3057KogakuShikyuHanteiKekkaEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("高額介護サービス費支給判定結果エンティティ"));
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }
}
