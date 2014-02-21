/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoDoctorCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7012ShujiiJoho;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7012ShujiiJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT7012ShujiiJoho.*;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;

/**
 * 主治医情報のデータアクセスクラスです。
 *
 * @author N8156 宮本 康
 */
public class ShujiiDac implements IShujiiDac {

    @InjectSession
    private SqlSession session;

    @Override
    public DbT7012ShujiiJohoEntity select(
            ShichosonCode 市町村コード, KaigoIryoKikanCode 介護医療機関コード, KaigoDoctorCode 介護医師コード) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT7012ShujiiJohoEntity> list = accessor.select()
                .table(DbT7012ShujiiJoho.class)
                .where(and(
                eq(shichosonCode, 市町村コード),
                eq(kaigoIryokikanCode, 介護医療機関コード),
                eq(kaigoIshiCode, 介護医師コード)))
                .toList(DbT7012ShujiiJohoEntity.class);
        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    public int insertOrUpdate(DbT7012ShujiiJohoEntity entity) {
        return getMatchRowCount(entity) == 0 ? insert(entity) : update(entity);
    }

    @Override
    public int insert(DbT7012ShujiiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Override
    public int update(DbT7012ShujiiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Override
    public int delete(DbT7012ShujiiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    private int getMatchRowCount(DbT7012ShujiiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select()
                .table(DbT7012ShujiiJoho.class)
                .where(and(
                eq(shichosonCode, entity.getShichosonCode()),
                eq(kaigoIryokikanCode, entity.getKaigoIryokikanCode()),
                eq(kaigoIshiCode, entity.getKaigoIshiCode())))
                .getCount();
    }
}
