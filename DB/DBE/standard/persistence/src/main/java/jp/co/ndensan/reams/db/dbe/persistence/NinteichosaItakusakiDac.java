/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
//import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7010NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7010NinteichosaItakusakiJoho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査委託先を管理するクラスです
 *
 * @author N1013 松本直樹
 */
public class NinteichosaItakusakiDac {

    @InjectSession
    private SqlSession session;

    /**
     * 指定した市町村コードで有効又は無効の認定調査委託先を取得します
     *
     * @param 市町村コード 市町村コード
     * @param 介護事業状況 介護事業状況
     * @return 認定調査委託先情報エンティティ
     */
    @Transaction
    public List<DbT7010NinteichosaItakusakiJohoEntity> selectAll(LasdecCode 市町村コード, boolean 介護事業状況) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT7010NinteichosaItakusakiJohoEntity> list = accessor.select()
                .table(DbT7010NinteichosaItakusakiJoho.class)
                .where(and(eq(DbT7010NinteichosaItakusakiJoho.shichosonCode, 市町村コード),
                                eq(DbT7010NinteichosaItakusakiJoho.kaigoJigyoshaJokyo, 介護事業状況)))
                .order(by(DbT7010NinteichosaItakusakiJoho.kaigoJigyoshaNo, Order.DESC))
                .toList(DbT7010NinteichosaItakusakiJohoEntity.class);

        return (!list.isEmpty()) ? list : Collections.EMPTY_LIST;

    }

    /**
     * 指定した市町村コードで登録されている全ての認定調査委託先を取得します
     *
     * @param 市町村コード 市町村コード
     * @return 認定調査委託先情報エンティティ
     */
    @Transaction
    public List<DbT7010NinteichosaItakusakiJohoEntity> selectAll(LasdecCode 市町村コード) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        List<DbT7010NinteichosaItakusakiJohoEntity> list = accessor.select()
                .table(DbT7010NinteichosaItakusakiJoho.class)
                .where(eq(DbT7010NinteichosaItakusakiJoho.shichosonCode, 市町村コード))
                .order(by(DbT7010NinteichosaItakusakiJoho.kaigoJigyoshaNo, Order.DESC))
                .toList(DbT7010NinteichosaItakusakiJohoEntity.class);

        return (!list.isEmpty()) ? list : Collections.EMPTY_LIST;

    }

    /**
     * 市町村・介護事業者番号・介護事業状況を指定して認定調査委託先を取得します
     *
     * @param 市町村コード 市町村コード
     * @param 介護事業者番号 介護事業者番号
     * @param 介護事業状況 介護事業状況
     * @return 認定調査委託先情報エンティティ
     */
    @Transaction
    public DbT7010NinteichosaItakusakiJohoEntity select(LasdecCode 市町村コード, KaigoJigyoshaNo 介護事業者番号, boolean 介護事業状況) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        List<DbT7010NinteichosaItakusakiJohoEntity> list = accessor.select()
                .table(DbT7010NinteichosaItakusakiJoho.class)
                .where(and(eq(DbT7010NinteichosaItakusakiJoho.shichosonCode, 市町村コード),
                                eq(DbT7010NinteichosaItakusakiJoho.kaigoJigyoshaNo, 介護事業者番号),
                                eq(DbT7010NinteichosaItakusakiJoho.kaigoJigyoshaJokyo, 介護事業状況)))
                .order(by(DbT7010NinteichosaItakusakiJoho.kaigoJigyoshaNo, Order.DESC))
                .toList(DbT7010NinteichosaItakusakiJohoEntity.class);

        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    /**
     * 市町村コード・事業者番号・介護事業状況を指定して認定調査委託先を取得します
     *
     * @param 市町村コード 市町村コード
     * @param 事業者番号 事業者番号
     * @param 介護事業状況 介護事業状況
     * @return 認定調査委託先情報エンティティ
     */
    @Transaction
    public DbT7010NinteichosaItakusakiJohoEntity select(LasdecCode 市町村コード, JigyoshaNo 事業者番号, boolean 介護事業状況) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        List<DbT7010NinteichosaItakusakiJohoEntity> list = accessor.select()
                .table(DbT7010NinteichosaItakusakiJoho.class)
                .where(and(eq(DbT7010NinteichosaItakusakiJoho.shichosonCode, 市町村コード),
                                eq(DbT7010NinteichosaItakusakiJoho.jigyoshaNo, 事業者番号),
                                eq(DbT7010NinteichosaItakusakiJoho.kaigoJigyoshaJokyo, 介護事業状況)))
                .order(by(DbT7010NinteichosaItakusakiJoho.kaigoJigyoshaNo, Order.DESC))
                .toList(DbT7010NinteichosaItakusakiJohoEntity.class);

        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);

    }

    /**
     * 認定調査委託先情報に対し追加・更新を行います
     *
     * @param entity 認定調査委託先情報エンティティ
     * @return 更新・追加結果
     */
    public int insertOrUpdate(DbT7010NinteichosaItakusakiJohoEntity entity) {

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
    @Transaction
    public int insert(DbT7010NinteichosaItakusakiJohoEntity data) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(data).execute();
    }

    /**
     * 認定調査委託先を更新します
     *
     * @param data 認定調査委託先情報エンティティ
     * @return 更新結果
     */
    @Transaction
    public int update(DbT7010NinteichosaItakusakiJohoEntity data) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(data).execute();
    }

    /**
     * 認定調査委託先を削除します
     *
     * @param data 認定調査委託先情報エンティティ
     * @return 削除結果
     */
    @Transaction
    public int delete(DbT7010NinteichosaItakusakiJohoEntity data) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(data).execute();
    }

    /**
     * 認定調査委託先の件数を取得します
     *
     * @param entity 認定調査委託先情報エンティティ
     * @return 取得件数
     */
    private int getMatchRowCount(DbT7010NinteichosaItakusakiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.
                select().
                table(DbT7010NinteichosaItakusakiJoho.class).
                where(and(eq(DbT7010NinteichosaItakusakiJoho.shichosonCode, entity.get市町村コード()),
                                eq(DbT7010NinteichosaItakusakiJoho.kaigoJigyoshaNo, entity.get介護事業者番号()))).
                getCount();
    }
}
