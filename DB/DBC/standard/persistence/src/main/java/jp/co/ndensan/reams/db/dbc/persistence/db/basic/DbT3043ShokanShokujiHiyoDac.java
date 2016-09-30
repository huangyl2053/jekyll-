/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3043ShokanShokujiHiyo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3043ShokanShokujiHiyo.hiHokenshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3043ShokanShokujiHiyo.jigyoshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3043ShokanShokujiHiyo.meisaiNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3043ShokanShokujiHiyo.renban;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3043ShokanShokujiHiyo.seiriNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3043ShokanShokujiHiyo.serviceTeikyoYM;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3043ShokanShokujiHiyo.yoshikiNo;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3043ShokanShokujiHiyoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
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
 * 償還払請求食事費用のデータアクセスクラスです。
 *
 * @reamsid_L DBC-9999-012 xicongwang
 */
public class DbT3043ShokanShokujiHiyoDac implements ISaveable<DbT3043ShokanShokujiHiyoEntity> {

    @InjectSession
    private SqlSession session;

    private final RString 定数_被保険者番号 = new RString("被保険者番号");
    private final RString 定数_サービス提供年月 = new RString("サービス提供年月");
    private final RString 定数_整理番号 = new RString("整理番号");
    private final RString 定数_事業者番号 = new RString("事業者番号");
    private final RString 定数_様式番号 = new RString("様式番号");
    private final RString 定数_明細番号 = new RString("明細番号");
    private final RString 定数_連番 = new RString("連番");

    /**
     * 主キーで償還払請求食事費用を取得します。
     *
     * @param 被保険者番号 HiHokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 整理番号 SeiriNp
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 YoshikiNo
     * @param 明細番号 MeisaiNo
     * @param 連番 Renban
     * @return DbT3043ShokanShokujiHiyoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3043ShokanShokujiHiyoEntity selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 連番) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_被保険者番号.toString()));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_サービス提供年月.toString()));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_整理番号.toString()));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_事業者番号.toString()));
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_様式番号.toString()));
        requireNonNull(明細番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_明細番号.toString()));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_連番.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3043ShokanShokujiHiyo.class).
                where(and(
                                eq(hiHokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(seiriNo, 整理番号),
                                eq(jigyoshaNo, 事業者番号),
                                eq(yoshikiNo, 様式番号),
                                eq(meisaiNo, 明細番号),
                                eq(renban, 連番))).
                toObject(DbT3043ShokanShokujiHiyoEntity.class);
    }

    /**
     * 償還払請求食事費用を全件返します。
     *
     * @return List<DbT3043ShokanShokujiHiyoEntity>
     */
    @Transaction
    public List<DbT3043ShokanShokujiHiyoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3043ShokanShokujiHiyo.class).
                toList(DbT3043ShokanShokujiHiyoEntity.class);
    }

    /**
     * DbT3043ShokanShokujiHiyoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3043ShokanShokujiHiyoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払請求食事費用エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * DbT3043ShokanShokujiHiyoEntityを登録します。delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    public int delete(DbT3043ShokanShokujiHiyoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払請求食事費用エンティティ"));
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 指定キーで償還払請求食事費用を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 RString
     * @param 明細番号 RString
     * @param 連番 RString
     * @return DbT3043ShokanShokujiHiyoEntity
     * @throws NullPointerException Exception
     */
    @Transaction
    public DbT3043ShokanShokujiHiyoEntity selectByKeyOrder(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 連番) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_被保険者番号.toString()));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_サービス提供年月.toString()));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_整理番号.toString()));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_事業者番号.toString()));
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_様式番号.toString()));
        requireNonNull(明細番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_明細番号.toString()));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_連番.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3043ShokanShokujiHiyo.class).
                where(and(
                                eq(hiHokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(seiriNo, 整理番号),
                                eq(jigyoshaNo, 事業者番号),
                                eq(yoshikiNo, 様式番号),
                                eq(meisaiNo, 明細番号),
                                eq(renban, 連番)))
                .order(by(DbT3043ShokanShokujiHiyo.renban, Order.DESC)).
                toObject(DbT3043ShokanShokujiHiyoEntity.class);
    }

    /**
     * 指定キーで償還払請求食事費用を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 RString
     * @param 明細番号 RString
     * @return List<DbT3043ShokanShokujiHiyoEntity>
     * @throws NullPointerException Exception
     */
    @Transaction
    public List<DbT3043ShokanShokujiHiyoEntity> selectByKeyOrder(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_被保険者番号.toString()));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_サービス提供年月.toString()));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_整理番号.toString()));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_事業者番号.toString()));
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_様式番号.toString()));
        requireNonNull(明細番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_明細番号.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3043ShokanShokujiHiyo.class).
                where(and(
                                eq(hiHokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(seiriNo, 整理番号),
                                eq(jigyoshaNo, 事業者番号),
                                eq(yoshikiNo, 様式番号),
                                eq(meisaiNo, 明細番号)))
                .order(by(DbT3043ShokanShokujiHiyo.renban, Order.DESC)).
                toList(DbT3043ShokanShokujiHiyoEntity.class);
    }

    /**
     * キーで償還払請求食事費用を取得します。
     *
     * @param 被保険者番号 HiHokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 RString
     * @param 明細番号 RString
     * @return DbT3043ShokanShokujiHiyoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT3043ShokanShokujiHiyoEntity> selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_被保険者番号.toString()));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_サービス提供年月.toString()));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_整理番号.toString()));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_事業者番号.toString()));
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_様式番号.toString()));
        requireNonNull(明細番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_明細番号.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3043ShokanShokujiHiyo.class).
                where(and(
                                eq(hiHokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(seiriNo, 整理番号),
                                eq(jigyoshaNo, 事業者番号),
                                eq(yoshikiNo, 様式番号),
                                eq(meisaiNo, 明細番号))).
                toList(DbT3043ShokanShokujiHiyoEntity.class);
    }

    /**
     * 償還払請求食事費用からデータを抽出します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 事業者番号 JigyoshaNo
     * @return List<DbT3043ShokanShokujiHiyoEntity>
     * @throws NullPointerException Exception
     */
    @Transaction
    public List<DbT3043ShokanShokujiHiyoEntity> selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_被保険者番号.toString()));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_サービス提供年月.toString()));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_整理番号.toString()));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_事業者番号.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3043ShokanShokujiHiyo.class).
                where(and(
                                eq(hiHokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(seiriNo, 整理番号),
                                eq(jigyoshaNo, 事業者番号))).
                toList(DbT3043ShokanShokujiHiyoEntity.class);
    }

    /**
     * 食事費用情報件数取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 RString
     * @param 明細番号 RString
     * @return 食事費用情報件数
     * @throws NullPointerException Exception
     */
    @Transaction
    public int select件数(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_被保険者番号.toString()));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_サービス提供年月.toString()));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_整理番号.toString()));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_事業者番号.toString()));
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_様式番号.toString()));
        requireNonNull(明細番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_明細番号.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3043ShokanShokujiHiyo.class).
                where(and(
                                eq(hiHokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(seiriNo, 整理番号),
                                eq(jigyoshaNo, 事業者番号),
                                eq(yoshikiNo, 様式番号),
                                eq(meisaiNo, 明細番号))).getCount();
    }

    /**
     * 指定キーで償還払請求食事費用を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 RString
     * @param 明細番号 RString
     * @return List<DbT3043ShokanShokujiHiyoEntity>
     */
    @Transaction
    public List<DbT3043ShokanShokujiHiyoEntity> select証明書削除(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        ITrueFalseCriteria iTrueFalseCriteria
                = getiTrueFalseCriteria(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);

        return accessor.select().
                table(DbT3043ShokanShokujiHiyo.class).
                where(iTrueFalseCriteria).
                toList(DbT3043ShokanShokujiHiyoEntity.class);
    }

    private ITrueFalseCriteria getiTrueFalseCriteria(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号) {
        ITrueFalseCriteria iTrueFalseCriteria;
        if (事業者番号 == null && 様式番号 == null && 明細番号 == null) {
            iTrueFalseCriteria = and(
                    eq(hiHokenshaNo, 被保険者番号),
                    eq(serviceTeikyoYM, サービス提供年月),
                    eq(seiriNo, 整理番号));
        } else {
            iTrueFalseCriteria = and(
                    eq(hiHokenshaNo, 被保険者番号),
                    eq(serviceTeikyoYM, サービス提供年月),
                    eq(seiriNo, 整理番号),
                    eq(jigyoshaNo, 事業者番号),
                    eq(yoshikiNo, 様式番号),
                    eq(meisaiNo, 明細番号));
        }
        return iTrueFalseCriteria;
    }

    /**
     * 償還払請求食事費用を検索します。
     *
     * @param 被保険者番号 HiHokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 整理番号 SeiriNo
     * @return List<DbT3043ShokanShokujiHiyoEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT3043ShokanShokujiHiyoEntity> select償還払請求食事費用(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_被保険者番号.toString()));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_サービス提供年月.toString()));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_整理番号.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3043ShokanShokujiHiyo.class).
                where(and(
                                eq(hiHokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(seiriNo, 整理番号)
                        )).
                toList(DbT3043ShokanShokujiHiyoEntity.class);
    }
}
