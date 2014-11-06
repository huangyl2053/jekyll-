/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbV3016KyufujissekiShuruiDetail;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbV3016KyufujissekiShuruiDetailEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceTeikyoYM;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;
import static jp.co.ndensan.reams.db.dbc.entity.basic.DbV3016KyufujissekiShuruiDetail.*;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.leq;

/**
 * KyufuJissekiServiceのデータアクセスクラスです。
 *
 * @author N3317 塚田 萌
 */
public class KyufuJissekiServiceDac {

    @InjectSession
    private SqlSession session;

    /**
     * 引数の条件に合うentityを複数件取得します。
     *
     * @param 被保番号 被保番号
     * @param サービス提供年月 サービス提供年月
     * @return KyufuJissekiServiceエンティティリスト
     */
    @Transaction
    public List<DbV3016KyufujissekiShuruiDetailEntity> select(
            HihokenshaNo 被保番号, ServiceTeikyoYM サービス提供年月) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select()
                .table(DbV3016KyufujissekiShuruiDetail.class)
                .where(and(
                                eq(hiHokenshaNo, 被保番号),
                                eq(serviceTeikyoYM, サービス提供年月)))
                .toList(DbV3016KyufujissekiShuruiDetailEntity.class);
    }

    /**
     * 引数の条件に合うentityを複数件取得します。
     *
     * @param 被保番号 被保番号
     * @param サービス提供開始年月 サービス提供開始年月
     * @param サービス提供終了年月 サービス提供終了年月
     * @return KyufuJissekiServiceエンティティリスト
     */
    @Transaction
    public List<DbV3016KyufujissekiShuruiDetailEntity> select(
            HihokenshaNo 被保番号, ServiceTeikyoYM サービス提供開始年月, ServiceTeikyoYM サービス提供終了年月) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select()
                .table(DbV3016KyufujissekiShuruiDetail.class)
                .where(and(
                                eq(hiHokenshaNo, 被保番号),
                                leq(サービス提供開始年月, serviceTeikyoYM), leq(serviceTeikyoYM, サービス提供終了年月)))
                .order(by(serviceSyuruiCode, Order.ASC), by(serviceTeikyoYM, Order.ASC), by(jigyoshoNo, Order.ASC))
                .toList(DbV3016KyufujissekiShuruiDetailEntity.class);
    }
}
