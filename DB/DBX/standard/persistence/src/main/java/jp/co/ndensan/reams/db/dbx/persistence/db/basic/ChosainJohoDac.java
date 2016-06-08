/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.ChosainJoho;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.ChosainJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;

/**
 * 調査員情報Dacクラスです。
 *
 * @author N2204 三井 沙織
 * @jpName 調査員情報Dac
 * @bizDomain 介護
 * @category 認定調査員
 * @subCategory
 * @mainClass
 * @reference
 */
public class ChosainJohoDac {

    @InjectSession
    private SqlSession session;

    /**
     * @param 介護調査員番号 介護調査員番号
     * @return ChosainJohoEntity
     */
    public ChosainJohoEntity selectByNumber(RString 介護調査員番号) {
        ITrueFalseCriteria 条件 = eq(ChosainJoho.介護調査員番号, 介護調査員番号);
        List<ChosainJohoEntity> result = select(条件);
        return result.size() == 1 ? result.get(0) : null;
    }

    /**
     * @param 介護事業者番号 介護事業者番号
     * @return ChosainJohoEntity list
     */
    public List<ChosainJohoEntity> selectByJigyoshaCode(KaigoJigyoshaNo 介護事業者番号) {
        ITrueFalseCriteria 条件 = eq(ChosainJoho.介護事業者番号, 介護事業者番号);
        return select(条件);
    }

    /**
     * @param 市町村コード 市町村コード
     * @param 介護事業者番号 介護事業者番号
     * @param 介護調査員番号 介護調査員番号
     * @return ChosainJohoEntity
     */
    public ChosainJohoEntity selectByAllKey(RString 市町村コード, KaigoJigyoshaNo 介護事業者番号, RString 介護調査員番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(ChosainJoho.class).
                where(and(eq(ChosainJoho.市町村コード, 市町村コード),
                          eq(ChosainJoho.介護事業者番号, 介護事業者番号),
                          eq(ChosainJoho.介護調査員番号, 介護調査員番号))).
                toObject(ChosainJohoEntity.class);
    }

    private List<ChosainJohoEntity> select(ITrueFalseCriteria 条件) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(ChosainJoho.class).
                where(条件).
                order(by(ChosainJoho.介護調査員番号, Order.ASC)).
                toList(ChosainJohoEntity.class);
    }
}
