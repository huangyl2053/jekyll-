/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJoho;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJoho.shinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IDeletable;
import jp.co.ndensan.reams.db.dbz.persistence.IReplaceable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 審査会の詳細な情報を取得するDacです。
 *
 * @author n8178 城間篤人
 */
public class ShinsakaiJohoDac implements IReplaceable<DbT5101NinteiShinseiJohoEntity>,
        IDeletable<DbT5101NinteiShinseiJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 申請書管理番号を指定し、要介護認定申請情報を一件取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 審査会Entity
     */
    @Transaction
    public DbT5101NinteiShinseiJohoEntity select(ShinseishoKanriNo 申請書管理番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().table(DbT5101NinteiShinseiJoho.class)
                .where(eq(shinseishoKanriNo, 申請書管理番号.value()))
                .toObject(DbT5101NinteiShinseiJohoEntity.class);
    }
    
//    /**
//     * 審査会開催番号と審査会開催年月日を指定し、審査会の情報を一件取得します。
//     *
//     * @param 審査会開催番号 審査会開催番号
//     * @param 審査会開催年月日 審査会開催年月日
//     * @return 審査会Entity
//     */
//    @Transaction
//    public DbT5101NinteiShinseiJohoEntity select(ShinsakaiKaisaiNo 審査会開催番号, FlexibleDate 審査会開催年月日) {
//        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
//        return accessor.select().table(DbT5101NinteiShinseiJoho.class)
//                .where(and(eq(shinseishoKanriNo, 審査会開催番号.value()),
//                                eq(shinsakaiKaisaiYMD, 審査会開催年月日)))
//                .toObject(DbT5101NinteiShinseiJohoEntity.class);
//    }
//
//    /**
//     * 基準年月日を指定し、開催予定の審査会情報を取得します。
//     *
//     * @param 基準年月日 基準年月日
//     * @return 審査会情報EntityList
//     */
//    @Transaction
//    public List<DbT5101NinteiShinseiJohoEntity> select開催予定審査会(FlexibleDate 基準年月日) {
//        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
//        return accessor.select().table(DbT5101NinteiShinseiJoho.class)
//                .where(leq(基準年月日, shinsakaiKaisaiYMD))
//                .toList(DbT5101NinteiShinseiJohoEntity.class);
//    }
//
//    /**
//     * 開催年月日を指定し、指定した日に開催される審査会の情報を取得します。
//     *
//     * @param 開催年月日 開催年月日
//     * @return 審査会EntityList
//     */
//    @Transaction
//    public List<DbT5101NinteiShinseiJohoEntity> select開催審査会(FlexibleDate 開催年月日) {
//        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
//        return accessor.select().table(DbT5101NinteiShinseiJoho.class)
//                .where(eq(shinsakaiKaisaiYMD, 開催年月日))
//                .toList(DbT5101NinteiShinseiJohoEntity.class);
//    }

    /**
     * 審査会の情報を全件取得します。
     *
     * @return 審査会EntityList
     */
    @Transaction
    public List<DbT5101NinteiShinseiJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().table(DbT5101NinteiShinseiJoho.class).toList(DbT5101NinteiShinseiJohoEntity.class);
    }

    @Override
    @Transaction
    public int insertOrUpdate(DbT5101NinteiShinseiJohoEntity data) {
        //TODO n8178 城間篤人 updateCountの参照法が決定した後に実装予定 2014年4月
        int updateCount = 1;
        return updateCount == 1 ? insert(data) : update(data);
    }

    @Override
    @Transaction
    public int insert(DbT5101NinteiShinseiJohoEntity data) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(data).execute();
    }

    @Override
    @Transaction
    public int update(DbT5101NinteiShinseiJohoEntity data) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(data).execute();
    }

    @Override
    @Transaction
    public int delete(DbT5101NinteiShinseiJohoEntity data) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(data).execute();
    }
}
