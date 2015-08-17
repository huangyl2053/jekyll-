/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7064CareManeger;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7064CareManegerEntity;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessor;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;

/**
 * ケアマネージャDACクラスです。
 *
 * @author n9944 趙 春暉
 * @jpName ケアマネージャDac
 * @bizDomain 介護
 * @category ケアマネージャ
 * @subCategory
 * @mainClass
 * @reference
 */
public class DbT7064CareManegerDac implements IDbT7064CareManegerDac {

    @InjectSession
    private SqlSession session;

    @Override
    public DbT7064CareManegerEntity selectByNumber(RString 介護支援専門員番号) {
        ITrueFalseCriteria 条件 = eq(DbT7064CareManeger.kaigoShienSenmoninNo, 介護支援専門員番号);
        List<DbT7064CareManegerEntity> result = select(条件);
        return result.size() == 1 ? result.get(0) : null;
    }

    @Override
    public List<DbT7064CareManegerEntity> selectByJigyoshaCode(KaigoJigyoshaNo 介護事業者番号) {
        ITrueFalseCriteria 条件 = eq(DbT7064CareManeger.shozokuJigyoshaNo, 介護事業者番号);
        return select(条件);
    }

    private List<DbT7064CareManegerEntity> select(ITrueFalseCriteria 条件) {
        DbAccessor accessor = new DbAccessor(session);

        return accessor.
                select().
                table(DbT7064CareManeger.class).
                where(条件).
                order(by(DbT7064CareManeger.kaigoShienSenmoninNo, Order.ASC)).
                toList(DbT7064CareManegerEntity.class);
    }
}
