/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyo.hiHokenshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyo.jigyoshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyo.meisaiNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyo.renban;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyo.seiriNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyo.serviceShuruiCode;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyo.serviceTeikyoYM;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyo.yoshikiNo;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
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
 * 償還払請求特定入所者介護サービス費用のデータアクセスクラスです。
 *
 * @reamsid_L DBC-9999-012 xicongwang
 */
public class DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoDac implements ISaveable<DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity> {

    @InjectSession
    private SqlSession session;

    private final RString 定数_被保険者番号 = new RString("被保険者番号");
    private final RString 定数_サービス提供年月 = new RString("サービス提供年月");
    private final RString 定数_整理番号 = new RString("整理番号");
    private final RString 定数_事業者番号 = new RString("事業者番号");
    private final RString 定数_様式番号 = new RString("様式番号");
    private final RString 定数_明細番号 = new RString("明細番号");
    private final RString 定数_連番 = new RString("連番");
    private final RString 定数_サービス種類コード = new RString("サービス種類コード");

    /**
     * 主キーで償還払請求特定入所者介護サービス費用を取得します。
     *
     * @param 被保険者番号 HiHokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 整理番号 SeiriNo
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 YoshikiNo
     * @param 明細番号 MeisaiNo
     * @param 連番 Renban
     * @return DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity selectByKey(
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
                table(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyo.class).
                where(and(
                                eq(hiHokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(seiriNo, 整理番号),
                                eq(jigyoshaNo, 事業者番号),
                                eq(yoshikiNo, 様式番号),
                                eq(meisaiNo, 明細番号),
                                eq(renban, 連番))).
                toObject(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity.class);
    }

    /**
     * 主キーで償還払請求特定入所者介護サービス費用を取得します。
     *
     * @param 被保険者番号 HiHokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 整理番号 SeiriNo
     * @param 事業者番号 JigyoshaNo
     * @param サービス種類コード ServiceShuruiCode
     * @return List<DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity> selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            ServiceShuruiCode サービス種類コード) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_被保険者番号.toString()));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_サービス提供年月.toString()));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_整理番号.toString()));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_事業者番号.toString()));
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_サービス種類コード.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyo.class).
                where(and(
                                eq(hiHokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(seiriNo, 整理番号),
                                eq(jigyoshaNo, 事業者番号),
                                eq(serviceShuruiCode, サービス種類コード))).
                toList(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity.class);
    }

    /**
     * 償還払請求特定入所者介護サービス費用を全件返します。
     *
     * @return List<DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity>
     */
    @Transaction
    public List<DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyo.class).
                toList(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity.class);
    }

    /**
     * DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払請求特定入所者介護サービス費用エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityを登録します。delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    public int delete(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払請求特定入所者介護サービス費用エンティティ"));
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 指定キーで償還払請求特定入所者介護サービス費用を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 RString
     * @param 明細番号 RString
     * @param 連番 RString
     * @return DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity
     * @throws NullPointerException Exception
     */
    @Transaction
    public DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity selectByKeyOrder(
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
                table(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyo.class).
                where(and(
                                eq(hiHokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(seiriNo, 整理番号),
                                eq(jigyoshaNo, 事業者番号),
                                eq(yoshikiNo, 様式番号),
                                eq(meisaiNo, 明細番号),
                                eq(renban, 連番)))
                .order(by(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyo.renban, Order.DESC)).
                toObject(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity.class);
    }

    /**
     * 指定キーで償還払請求特定入所者介護サービス費用を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 RString
     * @param 明細番号 RString
     * @return List<DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity>
     * @throws NullPointerException Exception
     */
    @Transaction
    public List<DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity> selectByKeyOrder(
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
                table(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyo.class).
                where(and(
                                eq(hiHokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(seiriNo, 整理番号),
                                eq(jigyoshaNo, 事業者番号),
                                eq(yoshikiNo, 様式番号),
                                eq(meisaiNo, 明細番号)))
                .order(by(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyo.renban, Order.DESC)).
                toList(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity.class);
    }

    /**
     * 特定入所者費用情報件数取得します。
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
                table(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyo.class).
                where(and(
                                eq(hiHokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(seiriNo, 整理番号),
                                eq(jigyoshaNo, 事業者番号),
                                eq(yoshikiNo, 様式番号),
                                eq(meisaiNo, 明細番号))).getCount();
    }

    /**
     * 指定キーで償還払請求特定入所者介護サービス費用を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 RString
     * @param 明細番号 RString
     * @return List<DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity>
     */
    @Transaction
    public List<DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity> select証明書削除(
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
                table(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyo.class).
                where(iTrueFalseCriteria).
                toList(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity.class);
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
     * 償還払請求特定入所者介護サービス費用を検索します。
     *
     * @param 被保険者番号 HiHokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 整理番号 SeiriNo
     * @return List<DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity> select償還払請求特定入所者介護サービス費用(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_被保険者番号.toString()));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_サービス提供年月.toString()));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_整理番号.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyo.class).
                where(and(
                                eq(hiHokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(seiriNo, 整理番号)
                        )).
                toList(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity.class);
    }
}
