/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3027KyufujissekiJutakuKaishuhi;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3027KyufujissekiJutakuKaishuhiEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.InputShikibetsuNoCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ToshiNo;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import static jp.co.ndensan.reams.db.dbc.entity.basic.DbT3027KyufujissekiJutakuKaishuhi.*;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;

/**
 * 給付実績の住宅改修費情報のデータアクセスクラスです。
 *
 * @author N8223　朴義一
 */
public class KyufuJissekiJutakuKaishuhiDac implements IKyufuJissekiJutakuKaishuhiDac {

    @InjectSession
    private SqlSession session;

    @Override
    public List<DbT3027KyufujissekiJutakuKaishuhiEntity> select(
            KokanShikibetsuNo 交換情報識別番号,
            InputShikibetsuNoCode 入力識別番号,
            ShoKisaiHokenshaNo 証記載保険者番号,
            KaigoHihokenshaNo 被保番号,
            FlexibleYearMonth サービス提供年月,
            JigyoshaNo 事業所番号,
            ToshiNo 通番) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select()
                .table(DbT3027KyufujissekiJutakuKaishuhi.class)
                .where(and(
                                eq(kokanJohoShikibetsuNo, 交換情報識別番号),
                                eq(inputShikibetsuNo, 入力識別番号.value()),
                                eq(shokisaiHokenshaNo, 証記載保険者番号),
                                eq(hiHokenshaNo, 被保番号),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(jigyoshoNo, 事業所番号),
                                eq(toshiNo, 通番)))
                .toList(DbT3027KyufujissekiJutakuKaishuhiEntity.class);
    }

    @Override
    public int insertOrUpdate(DbT3027KyufujissekiJutakuKaishuhiEntity entity) {
        return getMatchRowCount(entity) == 0 ? insert(entity) : update(entity);
    }

    @Override
    public int insert(DbT3027KyufujissekiJutakuKaishuhiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Override
    public int update(DbT3027KyufujissekiJutakuKaishuhiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Override
    public int delete(DbT3027KyufujissekiJutakuKaishuhiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    private int getMatchRowCount(DbT3027KyufujissekiJutakuKaishuhiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select()
                .table(DbT3027KyufujissekiJutakuKaishuhi.class)
                .where(and(
                                eq(kokanJohoShikibetsuNo, entity.getKokanJohoShikibetsuNo()),
                                eq(inputShikibetsuNo, entity.getInputShikibetsuNo()),
                                eq(recodeShubetsuCode, entity.getRecodeShubetsuCode()),
                                eq(shokisaiHokenshaNo, entity.getShokisaiHokenshaNo()),
                                eq(hiHokenshaNo, entity.getHiHokenshaNo()),
                                eq(serviceTeikyoYM, entity.getServiceTeikyoYM()),
                                eq(jigyoshoNo, entity.getJigyoshoNo()),
                                eq(toshiNo, entity.getToshiNo())))
                .getCount();
    }
}
