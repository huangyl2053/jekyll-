/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessor;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import jp.co.ndensan.reams.db.dbe.entity.HatsubanKanriJoho;
import jp.co.ndensan.reams.db.dbe.entity.HatsubanKanriJohoEntity;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;

/**
 * 発番管理情報を管理するクラスです
 *
 * @author N1013 松本直樹
 */
public class HatsubanKanriJohoDac implements IHatsubanKanriJohoDac {

    @InjectSession
    private SqlSession session;
    private final DbAccessor accessor = new DbAccessor(session);

    /**
     * 指定した項目区分と年度で発番情報を取得します
     *
     * @param 項目区分 項目年度
     * @param 年度 年度
     * @return 発番管理情報のエンティティ
     */
    @Override
    public HatsubanKanriJohoEntity select(RString 項目区分, RString 年度) {

        List<HatsubanKanriJohoEntity> list = accessor.select()
                .table(HatsubanKanriJoho.class)
                .where(and(eq(HatsubanKanriJoho.KOMOKU_KUBUN, 項目区分),
                eq(HatsubanKanriJoho.NENDO, 年度)))
                .order(by(HatsubanKanriJoho.HATSUBAN, Order.DESC))
                .toList(HatsubanKanriJohoEntity.class);

        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);

    }

    /**
     * 発番管理情報を更新します
     *
     * @param data 発番管理情報エンティティ
     * @return 更新結果
     */
    @Override
    public int update(HatsubanKanriJohoEntity data) {
        return accessor.update(data).execute();
    }
}
