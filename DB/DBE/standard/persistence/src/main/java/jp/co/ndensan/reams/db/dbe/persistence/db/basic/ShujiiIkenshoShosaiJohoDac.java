/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.basic;

import jp.co.ndensan.reams.db.dbe.definition.core.valueobject.IkenshosakuseiIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5013ShujiiIkenshoShosaiJoho;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5013ShujiiIkenshoShosaiJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.persistence.IDeletable;
import jp.co.ndensan.reams.db.dbz.persistence.IReplaceable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5013ShujiiIkenshoShosaiJoho.*;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;

/**
 * 主治医意見書詳細情報のデータアクセスクラスです。
 *
 * @author N8156 宮本 康
 */
public class ShujiiIkenshoShosaiJohoDac implements IReplaceable<DbT5013ShujiiIkenshoShosaiJohoEntity>,
        IDeletable<DbT5013ShujiiIkenshoShosaiJohoEntity> {

    @InjectSession
    private SqlSession session;

    @Transaction
    public DbT5013ShujiiIkenshoShosaiJohoEntity select(ShinseishoKanriNo 申請書管理番号, IkenshosakuseiIraiRirekiNo 意見書履歴番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select()
                .table(DbT5013ShujiiIkenshoShosaiJoho.class)
                .where(and(
                                eq(shinseishoKanriNo, 申請書管理番号),
                                eq(ikenshoIraiRirekiNo, 意見書履歴番号.value())))
                .toObject(DbT5013ShujiiIkenshoShosaiJohoEntity.class);
    }

    @Override
    @Transaction
    public int insertOrUpdate(DbT5013ShujiiIkenshoShosaiJohoEntity entity) {
        return getMatchRowCount(entity) == 0 ? insert(entity) : update(entity);
    }

    @Override
    @Transaction
    public int insert(DbT5013ShujiiIkenshoShosaiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Override
    @Transaction
    public int update(DbT5013ShujiiIkenshoShosaiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Override
    @Transaction
    public int delete(DbT5013ShujiiIkenshoShosaiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    @Transaction
    private int getMatchRowCount(DbT5013ShujiiIkenshoShosaiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select()
                .table(DbT5013ShujiiIkenshoShosaiJoho.class)
                .where(and(
                                eq(shinseishoKanriNo, entity.getShinseishoKanriNo()),
                                eq(ikenshoIraiRirekiNo, entity.getIkenshoIraiRirekiNo())))
                .getCount();
    }
}
