/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3052ShokanShoteiShikkanShisetsuRyoyo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3052ShokanShoteiShikkanShisetsuRyoyo.hiHokenshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3052ShokanShoteiShikkanShisetsuRyoyo.jigyoshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3052ShokanShoteiShikkanShisetsuRyoyo.meisaiNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3052ShokanShoteiShikkanShisetsuRyoyo.renban;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3052ShokanShoteiShikkanShisetsuRyoyo.seiriNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3052ShokanShoteiShikkanShisetsuRyoyo.serviceTeikyoYM;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3052ShokanShoteiShikkanShisetsuRyoyo.yoshikiNo;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 償還払請求所定疾患施設療養費等のデータアクセスクラスです。
 */
public class DbT3052ShokanShoteiShikkanShisetsuRyoyoDac implements ISaveable<DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで償還払請求所定疾患施設療養費等を取得します。
     *
     * @param 被保険者番号 HiHokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 整理番号 SeiriNo
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 YoshikiNo
     * @param 明細番号 MeisaiNo
     * @param 連番 Renban
     * @return DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 連番) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage("様式番号"));
        requireNonNull(明細番号, UrSystemErrorMessages.値がnull.getReplacedMessage("明細番号"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3052ShokanShoteiShikkanShisetsuRyoyo.class).
                where(and(
                                eq(hiHokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(seiriNo, 整理番号),
                                eq(jigyoshaNo, 事業者番号),
                                eq(yoshikiNo, 様式番号),
                                eq(meisaiNo, 明細番号),
                                eq(renban, 連番))).
                toObject(DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity.class);
    }

    @Transaction
    public DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity selectByKeyOrder(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 連番) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage("様式番号"));
        requireNonNull(明細番号, UrSystemErrorMessages.値がnull.getReplacedMessage("明細番号"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3052ShokanShoteiShikkanShisetsuRyoyo.class).
                where(and(
                                eq(hiHokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(seiriNo, 整理番号),
                                eq(jigyoshaNo, 事業者番号),
                                eq(yoshikiNo, 様式番号),
                                eq(meisaiNo, 明細番号),
                                eq(renban, 連番)))
                .order(by(DbT3052ShokanShoteiShikkanShisetsuRyoyo.renban, Order.DESC)).
                toObject(DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity.class);
    }

    @Transaction
    public List<DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity> selectByKeyOrder(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage("様式番号"));
        requireNonNull(明細番号, UrSystemErrorMessages.値がnull.getReplacedMessage("明細番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3052ShokanShoteiShikkanShisetsuRyoyo.class).
                where(and(
                                eq(hiHokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(seiriNo, 整理番号),
                                eq(jigyoshaNo, 事業者番号),
                                eq(yoshikiNo, 様式番号),
                                eq(meisaiNo, 明細番号)))
                .order(by(DbT3052ShokanShoteiShikkanShisetsuRyoyo.renban, Order.DESC)).
                toList(DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity.class);
    }

    /**
     * 償還払請求所定疾患施設療養費等を全件返します。
     *
     * @return List<DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity>
     */
    @Transaction
    public List<DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3052ShokanShoteiShikkanShisetsuRyoyo.class).
                toList(DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity.class);
    }

    /**
     * DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払請求所定疾患施設療養費等エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
