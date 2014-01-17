/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.JigyoshaNo;
import jp.co.ndensan.reams.db.dbe.business.KaigoJigyoshaNo;
import jp.co.ndensan.reams.db.dbe.entity.NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.NinteichosaItakusakiJoho;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessor;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;

/**
 * 認定調査委託先を管理するクラスです
 *
 * @author N1013 松本直樹
 */
public class NinteichosaItakusakiDac implements INinteichosaItakusakiDac {

    @InjectSession
    private SqlSession session;
    private final DbAccessor accessor = new DbAccessor(session);

    @Override
    public List<NinteichosaItakusakiJohoEntity> selectAll(RString 市町村コード, boolean 介護事業状況) {

        List<NinteichosaItakusakiJohoEntity> list = accessor.select()
                .table(NinteichosaItakusakiJoho.class)
                .where(and(eq(NinteichosaItakusakiJoho.SHICHOSON_CD, 市町村コード),
                eq(NinteichosaItakusakiJoho.KAIGO_JIGYOSHA_JOKYO, 介護事業状況)))
                .order(by(NinteichosaItakusakiJoho.KAIGO_JIGYOSHA_NO, Order.DESC))
                .toList(NinteichosaItakusakiJohoEntity.class);

        return (!list.isEmpty()) ? list : Collections.EMPTY_LIST;

    }

    @Override
    public List<NinteichosaItakusakiJohoEntity> selectAll(RString 市町村コード) {

        List<NinteichosaItakusakiJohoEntity> list = accessor.select()
                .table(NinteichosaItakusakiJoho.class)
                .where(eq(NinteichosaItakusakiJoho.SHICHOSON_CD, 市町村コード))
                .order(by(NinteichosaItakusakiJoho.KAIGO_JIGYOSHA_NO, Order.DESC))
                .toList(NinteichosaItakusakiJohoEntity.class);

        return (!list.isEmpty()) ? list : Collections.EMPTY_LIST;

    }

    @Override
    public NinteichosaItakusakiJohoEntity select(RString 市町村コード, KaigoJigyoshaNo 介護事業者番号, boolean 介護事業状況) {

        List<NinteichosaItakusakiJohoEntity> list = accessor.select()
                .table(NinteichosaItakusakiJoho.class)
                .where(and(eq(NinteichosaItakusakiJoho.SHICHOSON_CD, 市町村コード),
                eq(NinteichosaItakusakiJoho.KAIGO_JIGYOSHA_NO, 介護事業者番号),
                eq(NinteichosaItakusakiJoho.KAIGO_JIGYOSHA_JOKYO, 介護事業状況)))
                .order(by(NinteichosaItakusakiJoho.KAIGO_JIGYOSHA_NO, Order.DESC))
                .toList(NinteichosaItakusakiJohoEntity.class);

        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public NinteichosaItakusakiJohoEntity select(RString 市町村コード, JigyoshaNo 事業者番号, boolean 介護事業状況) {

        List<NinteichosaItakusakiJohoEntity> list = accessor.select()
                .table(NinteichosaItakusakiJoho.class)
                .where(and(eq(NinteichosaItakusakiJoho.SHICHOSON_CD, 市町村コード),
                eq(NinteichosaItakusakiJoho.JIGYOSHA_NO, 事業者番号),
                eq(NinteichosaItakusakiJoho.KAIGO_JIGYOSHA_JOKYO, 介護事業状況)))
                .order(by(NinteichosaItakusakiJoho.KAIGO_JIGYOSHA_NO, Order.DESC))
                .toList(NinteichosaItakusakiJohoEntity.class);

        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);

    }

    @Override
    public int insertOrUpdate(NinteichosaItakusakiJohoEntity entity) {

        if (getMatchRowCount(entity) == 0) {
            return insert(entity);
        } else {
            return update(entity);
        }
    }

    /**
     * 認定調査委託先を新規追加します
     *
     * @param data 認定調査委託先情報エンティティ
     * @return 追加結果
     */
    public int insert(NinteichosaItakusakiJohoEntity data) {
        return accessor.insert(data).execute();
    }

    /**
     * 認定調査委託先を更新します
     *
     * @param data 認定調査委託先情報エンティティ
     * @return 更新結果
     */
    public int update(NinteichosaItakusakiJohoEntity data) {
        return accessor.update(data).execute();
    }

    @Override
    public int delete(NinteichosaItakusakiJohoEntity data) {
        return accessor.delete(data).execute();
    }

    /**
     * 認定調査委託先の件数を取得します
     *
     * @param entity 認定調査委託先情報エンティティ
     * @return 取得件数
     */
    private int getMatchRowCount(NinteichosaItakusakiJohoEntity entity) {

        return accessor.
                select().
                table(NinteichosaItakusakiJoho.class).
                where(and(eq(NinteichosaItakusakiJoho.SHICHOSON_CD, entity.get市町村コード()),
                eq(NinteichosaItakusakiJoho.KAIGO_JIGYOSHA_NO, entity.get介護事業者番号()))).
                getCount();
    }
}
