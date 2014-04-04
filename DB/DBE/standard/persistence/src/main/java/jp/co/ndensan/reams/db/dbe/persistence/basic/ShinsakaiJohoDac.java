/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiDate;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5101ShinsakaiJoho;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT5101ShinsakaiJoho.*;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5101ShinsakaiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IDeletable;
import jp.co.ndensan.reams.db.dbz.persistence.IReplaceable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;

/**
 * 審査会の詳細な情報を取得するDacです。
 *
 * @author n8178 城間篤人
 */
public class ShinsakaiJohoDac implements IReplaceable<DbT5101ShinsakaiJohoEntity>,
        IDeletable<DbT5101ShinsakaiJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 審査会開催番号と開催年月日を指定し、審査会の情報を一件取得します。
     *
     * @param 開催番号 開催番号
     * @param 開催年月日 開催年月日
     * @return 審査会Entity
     */
    @Transaction
    public DbT5101ShinsakaiJohoEntity select(ShinsakaiKaisaiNo 開催番号, ShinsakaiKaisaiDate 開催年月日) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().table(DbT5101ShinsakaiJoho.class)
                .where(and(eq(shinsakaiKaisaiNo, 開催番号.value()),
                eq(shinsakaiKaisaiYMD, 開催年月日.value())))
                .toObject(DbT5101ShinsakaiJohoEntity.class);
    }

    /**
     * 基準年月日を指定し、開催予定の審査会情報を取得します。
     *
     * @param 基準年月日 基準年月日
     * @return 審査会情報EntityList
     */
    @Transaction
    public List<DbT5101ShinsakaiJohoEntity> select開催予定審査会(FlexibleDate 基準年月日) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().table(DbT5101ShinsakaiJoho.class)
                .where(leq(基準年月日, shinsakaiKaisaiYMD))
                .toList(DbT5101ShinsakaiJohoEntity.class);
    }

    /**
     * 開催年月日を指定し、指定した日に開催される審査会の情報を取得します。
     *
     * @param 開催年月日 開催年月日
     * @return 審査会EntityList
     */
    @Transaction
    public List<DbT5101ShinsakaiJohoEntity> select開催審査会(ShinsakaiKaisaiDate 開催年月日) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().table(DbT5101ShinsakaiJoho.class)
                .where(eq(shinsakaiKaisaiYMD, 開催年月日.value()))
                .toList(DbT5101ShinsakaiJohoEntity.class);
    }

    /**
     * 審査会の情報を全件取得します。
     *
     * @return 審査会EntityList
     */
    @Transaction
    public List<DbT5101ShinsakaiJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().table(DbT5101ShinsakaiJoho.class).toList(DbT5101ShinsakaiJohoEntity.class);
    }

    @Override
    @Transaction
    public int insertOrUpdate(DbT5101ShinsakaiJohoEntity data) {
        //TODO n8178 城間篤人 updateCountの参照法が決定した後に実装予定 2014年4月
        int updateCount = 1;
        return updateCount == 1 ? insert(data) : update(data);
    }

    @Override
    @Transaction
    public int insert(DbT5101ShinsakaiJohoEntity data) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(data).execute();
    }

    @Override
    @Transaction
    public int update(DbT5101ShinsakaiJohoEntity data) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(data).execute();
    }

    @Override
    @Transaction
    public int delete(DbT5101ShinsakaiJohoEntity data) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(data).execute();
    }
}
