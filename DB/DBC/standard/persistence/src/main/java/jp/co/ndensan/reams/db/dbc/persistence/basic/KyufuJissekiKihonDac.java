/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3017KyufujissekiKihon;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.InputShikibetsuNoCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import static jp.co.ndensan.reams.db.dbc.entity.basic.DbT3017KyufujissekiKihon.*;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;

/**
 * 給付実績基本のデータアクセスクラスです。
 *
 * @author N8156 宮本 康
 */
public class KyufuJissekiKihonDac implements IKyufuJissekiKihonDac {

    @InjectSession
    private SqlSession session;

    @Override
    public DbT3017KyufujissekiKihonEntity select(
            KokanShikibetsuNo 交換情報識別番号,
            InputShikibetsuNoCode 入力識別番号,
            RString レコード種別コード,
            RString 給付実績情報作成区分コード,
            ShoKisaiHokenshaNo 証記載保険者番号,
            KaigoHihokenshaNo 被保番号,
            FlexibleYearMonth サービス提供年月,
            RString 給付実績区分コード,
            JigyoshaNo 事業所番号,
            RString 通番) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select()
                .table(DbT3017KyufujissekiKihon.class)
                .where(and(
                                eq(kokanShikibetsuNo, 交換情報識別番号),
                                eq(inputShikibetsuNo, 入力識別番号),
                                eq(recodeShubetsuCode, レコード種別コード),
                                eq(kyufuSakuseiKubunCode, 給付実績情報作成区分コード),
                                eq(hokenshaNo, 証記載保険者番号),
                                eq(hiHokenshaNo, 被保番号),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(kyufuJissekiKubunCode, 給付実績区分コード),
                                eq(jigyoshoNo, 事業所番号),
                                eq(toshiNo, 通番)))
                .toObject(DbT3017KyufujissekiKihonEntity.class);
    }
}
