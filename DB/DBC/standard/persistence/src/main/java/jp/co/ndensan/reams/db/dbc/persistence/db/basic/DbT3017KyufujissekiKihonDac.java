/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihon;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihon.hiHokenshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihon.inputShikibetsuNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihon.jigyoshoNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihon.kokanShikibetsuNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihon.kyufuJissekiKubunCode;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihon.kyufuSakuseiKubunCode;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihon.recodeShubetsuCode;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihon.seiriNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihon.serviceTeikyoYM;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihon.shinsaYM;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihon.shokisaiHokenshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihon.toshiNo;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Order.DESC;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.leq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 給付実績基本のデータアクセスクラスです。
 */
public class DbT3017KyufujissekiKihonDac implements ISaveable<DbT3017KyufujissekiKihonEntity> {

    @InjectSession
    private SqlSession session;
    private static final int INT_1 = 1;

    /**
     * 主キーで給付実績基本を取得します。
     *
     * @param 交換情報識別番号 KokanShikibetsuNo
     * @param 入力識別番号 InputShikibetsuNo
     * @param レコード種別コード RecodeShubetsuCode
     * @param 給付実績情報作成区分コード KyufuSakuseiKubunCode
     * @param 証記載保険者番号 HokenshaNo
     * @param 被保険者番号 HiHokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 給付実績区分コード KyufuJissekiKubunCode
     * @param 事業所番号 JigyoshoNo
     * @param 通し番号 ToshiNo
     * @return DbT3017KyufujissekiKihonEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3017KyufujissekiKihonEntity selectByKey(
            KokanShikibetsuNo 交換情報識別番号,
            NyuryokuShikibetsuNo 入力識別番号,
            RString レコード種別コード,
            RString 給付実績情報作成区分コード,
            HokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 給付実績区分コード,
            JigyoshaNo 事業所番号,
            RString 通し番号) throws NullPointerException {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号"));
        requireNonNull(レコード種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("レコード種別コード"));
        requireNonNull(給付実績情報作成区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績情報作成区分コード"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(給付実績区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績区分コード"));
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通し番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3017KyufujissekiKihon.class).
                where(and(
                                eq(kokanShikibetsuNo, 交換情報識別番号),
                                eq(inputShikibetsuNo, 入力識別番号),
                                eq(recodeShubetsuCode, レコード種別コード),
                                eq(kyufuSakuseiKubunCode, 給付実績情報作成区分コード),
                                eq(shokisaiHokenshaNo, 証記載保険者番号),
                                eq(hiHokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(kyufuJissekiKubunCode, 給付実績区分コード),
                                eq(jigyoshoNo, 事業所番号),
                                eq(toshiNo, 通し番号))).
                toObject(DbT3017KyufujissekiKihonEntity.class);
    }

    /**
     * 給付実績基本を全件返します。
     *
     * @return List<DbT3017KyufujissekiKihonEntity>
     */
    @Transaction
    public List<DbT3017KyufujissekiKihonEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3017KyufujissekiKihon.class).
                toList(DbT3017KyufujissekiKihonEntity.class);
    }

    /**
     * DbT3017KyufujissekiKihonEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3017KyufujissekiKihonEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績基本エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 給付実績基本情報リスト取得
     *
     * @param 様式番号 InputShikibetsuNo
     * @param 証記載保険者番号 HokenshaNo
     * @param 被保険者番号 HiHokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 給付実績区分コード KyufuJissekiKubunCode
     * @param 整理番号 seiriNo
     * @return List<DbT3017KyufujissekiKihonEntity>
     */
    @Transaction
    public List<DbT3017KyufujissekiKihonEntity> select給付実績基本情報(
            RString 様式番号,
            HokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 給付実績区分コード,
            RString 整理番号) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3017KyufujissekiKihon.class).
                where(and(
                                eq(inputShikibetsuNo, 様式番号),
                                eq(shokisaiHokenshaNo, 証記載保険者番号),
                                eq(hiHokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(kyufuJissekiKubunCode, 給付実績区分コード),
                                eq(seiriNo, 整理番号))).
                order(by(shinsaYM, DESC)).
                toList(DbT3017KyufujissekiKihonEntity.class);
    }

    /**
     * 被保険者番号、サービス提供年月により、給付実績基本情報を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @return DbT3017KyufujissekiKihonEntity
     */
    public DbT3017KyufujissekiKihonEntity get給付実績基本(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT3017KyufujissekiKihon.class).
                where(and(
                                eq(hiHokenshaNo, 被保険者番号),
                                leq(serviceTeikyoYM, サービス提供年月))).
                order(by(serviceTeikyoYM, DESC)).
                limit(INT_1).
                toObject(DbT3017KyufujissekiKihonEntity.class);
    }
}
