/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.IkenshosakuseiIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5012ShujiiIkenshoJoho;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5012ShujiiIkenshoJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.persistence.IDeletable;
import jp.co.ndensan.reams.db.dbz.persistence.IReplaceable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT5012ShujiiIkenshoJoho.*;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;

/**
 * 主治医意見書情報のデータアクセスクラスです。
 *
 * @author N8156 宮本 康
 */
public class ShujiiIkenshoJohoDac implements IReplaceable<DbT5012ShujiiIkenshoJohoEntity>, IDeletable<DbT5012ShujiiIkenshoJohoEntity> {

    @InjectSession
    private SqlSession session;

    @Transaction
    public DbT5012ShujiiIkenshoJohoEntity select(ShinseishoKanriNo 申請書管理番号, IkenshosakuseiIraiRirekiNo 意見書履歴番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select()
                .table(DbT5012ShujiiIkenshoJoho.class)
                .where(and(
                eq(shinseishoKanriNo, 申請書管理番号),
                eq(ikenshoIraiRirekiNo, 意見書履歴番号.value())))
                .toObject(DbT5012ShujiiIkenshoJohoEntity.class);
    }

    @Override
    @Transaction
    public int insertOrUpdate(DbT5012ShujiiIkenshoJohoEntity entity) {
        return getMatchRowCount(entity) == 0 ? insert(entity) : update(entity);
    }

    @Override
    @Transaction
    public int insert(DbT5012ShujiiIkenshoJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Override
    @Transaction
    public int update(DbT5012ShujiiIkenshoJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Override
    @Transaction
    public int delete(DbT5012ShujiiIkenshoJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    @Transaction
    private int getMatchRowCount(DbT5012ShujiiIkenshoJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select()
                .table(DbT5012ShujiiIkenshoJoho.class)
                .where(and(
                eq(shinseishoKanriNo, entity.getShinseishoKanriNo()),
                eq(ikenshoIraiRirekiNo, entity.getIkenshoIraiRirekiNo())))
                .getCount();
    }
}
