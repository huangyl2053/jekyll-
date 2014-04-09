/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5106ShinsakaiWariateIinJoho;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT5106ShinsakaiWariateIinJoho.*;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5106ShinsakaiWariateIinJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IDeletable;
import jp.co.ndensan.reams.db.dbz.persistence.IReplaceable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;
import static jp.co.ndensan.reams.uz.uza.util.db.Order.*;

/**
 * 審査会に割り当てられている委員の情報を取得するDacです。
 *
 * @author n8178 城間篤人
 */
public class ShinsakaiWariateIinJohoDac implements IReplaceable<DbT5106ShinsakaiWariateIinJohoEntity>,
        IDeletable<DbT5106ShinsakaiWariateIinJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 審査会開催番号と審査会開催年月日を指定して、審査会に割り当てられている審査会委員の情報を取得します。
     *
     * @param 審査会開催番号 審査会開催番号
     * @param 審査会開催年月日 審査会開催年月日
     * @return 審査会割当委員EntityList
     */
    @Transaction
    public List<DbT5106ShinsakaiWariateIinJohoEntity> select(ShinsakaiKaisaiNo 審査会開催番号, FlexibleDate 審査会開催年月日) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().table(DbT5106ShinsakaiWariateIinJoho.class)
                .where(and(eq(shinsakaiKaisaiNo, 審査会開催番号.value()), eq(shinsakaiKaisaiYMD, 審査会開催年月日)))
                .order(by(shinsakaiIinCode, ASC))
                .toList(DbT5106ShinsakaiWariateIinJohoEntity.class);
    }

    /**
     * 審査会開催年月日を指定して、その日に開催予定の審査会に割り当てられている委員を取得します。
     *
     * @param 審査会開催年月日 審査会開催年月日
     * @return 審査会割当委員EntityList
     */
    @Transaction
    public List<DbT5106ShinsakaiWariateIinJohoEntity> select(FlexibleDate 審査会開催年月日) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().table(DbT5106ShinsakaiWariateIinJoho.class)
                .where(eq(shinsakaiKaisaiYMD, 審査会開催年月日))
                .toList(DbT5106ShinsakaiWariateIinJohoEntity.class);
    }

    /**
     * 審査会に割り当てられている委員の情報を全件取得します。
     *
     * @return 審査会割当委員EntityList
     */
    @Transaction
    public List<DbT5106ShinsakaiWariateIinJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().table(DbT5106ShinsakaiWariateIinJoho.class)
                .toList(DbT5106ShinsakaiWariateIinJohoEntity.class);
    }

    @Transaction
    @Override
    public int insertOrUpdate(DbT5106ShinsakaiWariateIinJohoEntity data) {
        //TODO n8178 城間篤人 updateCountの取得法が決定した後に実装予定 2014年4月
        int updateCount = 1;
        return updateCount == 1 ? insert(data) : update(data);
    }

    @Transaction
    @Override
    public int insert(DbT5106ShinsakaiWariateIinJohoEntity data) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(data).execute();
    }

    @Transaction
    @Override
    public int update(DbT5106ShinsakaiWariateIinJohoEntity data) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(data).execute();
    }

    @Transaction
    @Override
    public int delete(DbT5106ShinsakaiWariateIinJohoEntity data) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(data).execute();
    }
}
