/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5050RenrakusakiJoho;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT5050RenrakusakiJoho.*;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5050RenrakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IDeletable;
import jp.co.ndensan.reams.db.dbz.persistence.IReplaceable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 連絡先情報を取得するDacです。
 *
 * @author n9606 漢那 憲作
 */
public class RenrakusakiInfoDac implements IReplaceable<DbT5050RenrakusakiJohoEntity>,
        IDeletable<DbT5050RenrakusakiJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 指定した保険者番号、被保番号に該当する連絡先情報Entityのリストを取得します。
     *
     * @param hokenshaNo 保険者番号
     * @param hihoNo 被保番号
     * @return 連絡先情報EntityのList
     */
    @Transaction
    public List<DbT5050RenrakusakiJohoEntity> select(ShoKisaiHokenshaNo hokenshaNo,
            KaigoHihokenshaNo hihoNo) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().table(DbT5050RenrakusakiJoho.class).
                where(and(eq(shoKisaiHokenshaNo, hokenshaNo.getValue().toString()),
                                eq(hihokenshaNo, hihoNo.value().toString()))).
                order(by(renrakusakiKubunNo, Order.ASC)).
                toList(DbT5050RenrakusakiJohoEntity.class);
    }

    @Override
    @Transaction
    public int insertOrUpdate(DbT5050RenrakusakiJohoEntity entity) {
        if (getMatchRowCount(entity) == 0) {
            return insert(entity);
        } else {
            return update(entity);
        }
    }

    /**
     * 連絡先情報に対し、追加を行います。
     *
     * @param entity 連絡先情報Entity
     * @return 追加結果
     */
    @Override
    @Transaction
    public int insert(DbT5050RenrakusakiJohoEntity entity) {
        DbAccessorNormalType dbAccessor = new DbAccessorNormalType(session);
        return dbAccessor.insert(entity).execute();
    }

    /**
     * 連絡先情報に対し、更新を行います。
     *
     * @param entity 連絡先情報Entity
     * @return 更新結果
     */
    @Override
    @Transaction
    public int update(DbT5050RenrakusakiJohoEntity entity) {
        DbAccessorNormalType dbAccessor = new DbAccessorNormalType(session);
        return dbAccessor.update(entity).execute();
    }

    /**
     * 連絡先情報に対し、削除を行います。
     *
     * @param entity 連絡先情報Entity
     * @return 削除結果
     */
    @Override
    @Transaction
    public int delete(DbT5050RenrakusakiJohoEntity entity) {
        DbAccessorNormalType dbAccessor = new DbAccessorNormalType(session);
        return dbAccessor.deletePhysical(entity).execute();
    }

    /**
     * 連絡先情報の件数を取得します。
     *
     * @param entity 連絡先情報エンティティ
     * @return 取得件数
     */
    private int getMatchRowCount(DbT5050RenrakusakiJohoEntity entity) {
        DbAccessorNormalType dbAccessor = new DbAccessorNormalType(session);

        return dbAccessor.
                select().
                table(DbT5050RenrakusakiJoho.class).
                where(and(eq(DbT5050RenrakusakiJoho.shoKisaiHokenshaNo, entity.getShoKisaiHokenshaNo()),
                                eq(DbT5050RenrakusakiJoho.hihokenshaNo, entity.getHihokenshaNo()),
                                eq(DbT5050RenrakusakiJoho.renrakusakiKubunNo, entity.getRenrakusakiKubunNo()))).getCount();
    }
}
