/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3039ShokanMeisai;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3039ShokanMeisai.hiHokenshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3039ShokanMeisai.jigyoshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3039ShokanMeisai.meisaiNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3039ShokanMeisai.renban;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3039ShokanMeisai.seiriNp;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3039ShokanMeisai.serviceShuruiCode;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3039ShokanMeisai.serviceTeikyoYM;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3039ShokanMeisai.yoshikiNo;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3039ShokanMeisaiEntity;
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
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.not;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 償還払請求明細のデータアクセスクラスです。
 */
public class DbT3039ShokanMeisaiDac implements ISaveable<DbT3039ShokanMeisaiEntity> {

    @InjectSession
    private SqlSession session;

    private final RString 定数_被保険者番号 = new RString("被保険者番号");
    private final RString 定数_サービス提供年月 = new RString("サービス提供年月");
    private final RString 定数_整理番号 = new RString("整理番号");
    private final RString 定数_事業者番号 = new RString("事業者番号");
    private final RString 定数_様式番号 = new RString("様式番号");
    private final RString 定数_明細番号 = new RString("明細番号");
    private final RString 定数_連番 = new RString("連番");

    private static final RString 定数_50 = new RString("50");

    /**
     * 主キーで償還払請求明細を取得します。
     *
     * @param 被保険者番号 HiHokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 整理番号 SeiriNp
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 YoshikiNo
     * @param 明細番号 MeisaiNo
     * @param 連番 Renban
     * @return DbT3039ShokanMeisaiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3039ShokanMeisaiEntity selectByKey(
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
                table(DbT3039ShokanMeisai.class).
                where(and(
                                eq(hiHokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(seiriNp, 整理番号),
                                eq(jigyoshaNo, 事業者番号),
                                eq(yoshikiNo, 様式番号),
                                eq(meisaiNo, 明細番号),
                                eq(renban, 連番))).
                toObject(DbT3039ShokanMeisaiEntity.class);
    }

    /**
     * 償還払請求明細を全件返します。
     *
     * @return List<DbT3039ShokanMeisaiEntity>
     */
    @Transaction
    public List<DbT3039ShokanMeisaiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3039ShokanMeisai.class).
                toList(DbT3039ShokanMeisaiEntity.class);
    }

    /**
     * DbT3039ShokanMeisaiEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3039ShokanMeisaiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払請求明細エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 指定キーで償還払請求明細を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 RString
     * @param 明細番号 RString
     * @param 連番 RString
     * @return DbT3039ShokanMeisaiEntity
     * @throws NullPointerException Exception
     */
    @Transaction
    public DbT3039ShokanMeisaiEntity selectByKeyOrder(
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
                table(DbT3039ShokanMeisai.class).
                where(and(
                                eq(hiHokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(seiriNp, 整理番号),
                                eq(jigyoshaNo, 事業者番号),
                                eq(yoshikiNo, 様式番号),
                                eq(meisaiNo, 明細番号),
                                eq(renban, 連番),
                                eq(serviceShuruiCode, 定数_50)))
                .order(by(DbT3039ShokanMeisai.renban, Order.DESC)).
                toObject(DbT3039ShokanMeisaiEntity.class);
    }

    /**
     * 指定キーで償還払請求明細を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 RString
     * @param 明細番号 RString
     * @return List<DbT3039ShokanMeisaiEntity>
     * @throws NullPointerException Exception
     */
    @Transaction
    public List<DbT3039ShokanMeisaiEntity> selectByKeyOrder(
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
                table(DbT3039ShokanMeisai.class).
                where(and(
                                eq(hiHokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(seiriNp, 整理番号),
                                eq(jigyoshaNo, 事業者番号),
                                eq(yoshikiNo, 様式番号),
                                eq(meisaiNo, 明細番号),
                                eq(serviceShuruiCode, 定数_50)))
                .order(by(DbT3039ShokanMeisai.renban, Order.DESC)).
                toList(DbT3039ShokanMeisaiEntity.class);
    }

    /**
     * 取得された件数を返却する
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 RString
     * @param 明細番号 RString
     * @return 取得された件数
     * @throws NullPointerException Exception
     */
    @Transaction
    public int selectデータ件数(
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
                table(DbT3039ShokanMeisai.class).
                where(and(
                                eq(hiHokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(seiriNp, 整理番号),
                                eq(jigyoshaNo, 事業者番号),
                                eq(yoshikiNo, 様式番号),
                                eq(meisaiNo, 明細番号),
                                not(eq(serviceShuruiCode, new RString("50"))))).getCount();
    }

}
