/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3047ShokanServicePlan200904;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3047ShokanServicePlan200904.hiHokenshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3047ShokanServicePlan200904.jigyoshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3047ShokanServicePlan200904.meisaiNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3047ShokanServicePlan200904.seiriNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3047ShokanServicePlan200904.serviceCode;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3047ShokanServicePlan200904.serviceTeikyoYM;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3047ShokanServicePlan200904.yoshikiNo;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3047ShokanServicePlan200904Entity;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.syokanbaraikettejoho.SyokanbaraiketteJohoParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
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
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.not;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 償還払請求サービス計画200904のデータアクセスクラスです。
 *
 * @reamsid_L DBC-9999-021 zuotao
 */
public class DbT3047ShokanServicePlan200904Dac implements ISaveable<DbT3047ShokanServicePlan200904Entity> {

    private static final int 件数_1 = 1;
    private static final RString 定数_被保険者番号 = new RString("被保険者番号");
    private static final RString 定数_サービス提供年月 = new RString("サービス提供年月");
    private static final RString 定数_整理番号 = new RString("整理番号");
    private static final RString 定数_事業者番号 = new RString("事業者番号");
    @InjectSession
    private SqlSession session;

    /**
     * 主キーで償還払請求サービス計画200904を取得します。
     *
     * @param 被保険者番号 HiHokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 整理番号 SeiriNo
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 YoshikiNo
     * @param 明細番号 MeisaiNo
     * @param 連番 Renban
     * @return DbT3047ShokanServicePlan200904Entity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3047ShokanServicePlan200904Entity selectByKey(
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
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage("様式番号"));
        requireNonNull(明細番号, UrSystemErrorMessages.値がnull.getReplacedMessage("明細番号"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3047ShokanServicePlan200904.class).
                where(and(
                        eq(hiHokenshaNo, 被保険者番号),
                        eq(serviceTeikyoYM, サービス提供年月),
                        eq(seiriNo, 整理番号),
                        eq(jigyoshaNo, 事業者番号),
                        eq(yoshikiNo, 様式番号)
                //                                eq(meisaiNo, 明細番号),
                //                                eq(renban, 連番)
                )).
                toObject(DbT3047ShokanServicePlan200904Entity.class);
    }

    /**
     * 主キーで償還払請求サービス計画200904を取得します。
     *
     * @param 被保険者番号 HiHokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 整理番号 SeiriNo
     * @param 事業者番号 JigyoshaNo
     * @param サービスコード ServiceCode
     * @return List<DbT3047ShokanServicePlan200904Entity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT3047ShokanServicePlan200904Entity> selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            ServiceCode サービスコード) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_被保険者番号.toString()));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_サービス提供年月.toString()));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_整理番号.toString()));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_事業者番号.toString()));
        requireNonNull(サービスコード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービスコード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3047ShokanServicePlan200904.class).
                where(and(
                        eq(hiHokenshaNo, 被保険者番号),
                        eq(serviceTeikyoYM, サービス提供年月),
                        eq(seiriNo, 整理番号),
                        eq(jigyoshaNo, 事業者番号),
                        eq(serviceCode, サービスコード))).
                toList(DbT3047ShokanServicePlan200904Entity.class);
    }

    /**
     * 償還払請求サービス計画200904を全件返します。
     *
     * @return List<DbT3047ShokanServicePlan200904Entity>
     */
    @Transaction
    public List<DbT3047ShokanServicePlan200904Entity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3047ShokanServicePlan200904.class).
                toList(DbT3047ShokanServicePlan200904Entity.class);
    }

    /**
     * DbT3047ShokanServicePlan200904Entityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3047ShokanServicePlan200904Entity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払請求サービス計画200904エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * DbT3047ShokanServicePlan200904Entityを登録します。delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    public int delete(DbT3047ShokanServicePlan200904Entity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払請求サービス計画200904エンティティ"));
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * サービス提供年月により、決定理由情報などを抽出します。
     *
     * @param parameter 償還払決定一覧検索用MyBatisパラメータ
     * @return 決定理由情報
     */
    @Transaction
    public DbT3047ShokanServicePlan200904Entity select決定理由情報(SyokanbaraiketteJohoParameter parameter) {
        requireNonNull(parameter.getHiHokenshaNo(), UrSystemErrorMessages.値がnull.getReplacedMessage(定数_被保険者番号.toString()));
        requireNonNull(parameter.getServiceTeikyoYM(), UrSystemErrorMessages.値がnull.getReplacedMessage(定数_サービス提供年月.toString()));
        requireNonNull(parameter.getSeiriNo(), UrSystemErrorMessages.値がnull.getReplacedMessage(定数_整理番号.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3047ShokanServicePlan200904.class).
                where(and(
                        eq(hiHokenshaNo, parameter.getHiHokenshaNo()),
                        eq(serviceTeikyoYM, parameter.getServiceTeikyoYM()),
                        eq(seiriNo, parameter.getSeiriNo())))
                .order(by(DbT3047ShokanServicePlan200904.jigyoshaNo, Order.DESC),
                        by(DbT3047ShokanServicePlan200904.yoshikiNo, Order.DESC)).limit(件数_1).
                toObject(DbT3047ShokanServicePlan200904Entity.class);
    }

    /**
     * 取得された件数を返却する
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @return 取得された件数
     * @throws NullPointerException Exception
     */
    public int selectデータ件数(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_被保険者番号.toString()));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_サービス提供年月.toString()));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_整理番号.toString()));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_事業者番号.toString()));
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage("様式番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3047ShokanServicePlan200904.class).
                where(and(
                        eq(hiHokenshaNo, 被保険者番号),
                        eq(serviceTeikyoYM, サービス提供年月),
                        eq(seiriNo, 整理番号),
                        eq(jigyoshaNo, 事業者番号),
                        eq(yoshikiNo, 様式番号))).getCount();
    }

    /**
     * 取得された件数を返却する
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @return 取得された件数
     * @throws NullPointerException Exception
     */
    public int selectデータ件数2(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_被保険者番号.toString()));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_サービス提供年月.toString()));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_整理番号.toString()));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_事業者番号.toString()));
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage("様式番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3047ShokanServicePlan200904.class).
                where(and(
                        eq(hiHokenshaNo, 被保険者番号),
                        eq(serviceTeikyoYM, サービス提供年月),
                        not(eq(seiriNo, 整理番号)),
                        eq(jigyoshaNo, 事業者番号),
                        eq(yoshikiNo, 様式番号))).getCount();
    }

    /**
     * サービス計画費情報件数を返却する
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
     * @return サービス計画費情報件数
     * @throws NullPointerException Exception
     */
    public int selectサービス計画費情報件数(
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
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage("様式番号"));
        requireNonNull(明細番号, UrSystemErrorMessages.値がnull.getReplacedMessage("明細番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3047ShokanServicePlan200904.class).
                where(and(
                        eq(hiHokenshaNo, 被保険者番号),
                        eq(serviceTeikyoYM, サービス提供年月),
                        eq(seiriNo, 整理番号),
                        eq(jigyoshaNo, 事業者番号),
                        eq(yoshikiNo, 様式番号),
                        eq(meisaiNo, 明細番号))).getCount();
    }

    /**
     * 償還払請求サービス計画200904を全件返します。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
     * @return List<DbT3047ShokanServicePlan200904Entity>
     */
    @Transaction
    public List<DbT3047ShokanServicePlan200904Entity> select証明書削除(
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
                table(DbT3047ShokanServicePlan200904.class).
                where(iTrueFalseCriteria).
                toList(DbT3047ShokanServicePlan200904Entity.class);
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
     * 償還払請求サービス計画を取得します。
     *
     * @param 被保険者番号 HiHokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 整理番号 SeiriNo
     * @return List<DbT3047ShokanServicePlan200904Entity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT3047ShokanServicePlan200904Entity> get償還払請求サービス計画(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_被保険者番号.toString()));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_サービス提供年月.toString()));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_整理番号.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3047ShokanServicePlan200904.class).
                where(and(
                        eq(hiHokenshaNo, 被保険者番号),
                        eq(serviceTeikyoYM, サービス提供年月),
                        eq(seiriNo, 整理番号)
                )).
                toList(DbT3047ShokanServicePlan200904Entity.class);
    }
}
