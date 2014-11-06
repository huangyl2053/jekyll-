/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.persistence.IDeletable;
import jp.co.ndensan.reams.db.dbz.persistence.IReplaceable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;

/**
 * DBT5001SNinteiShinseiJohoへのDACです。
 *
 * @author N3327 三浦 凌
 */
public class YokaigoNinteiShinseiDac implements IReplaceable<DbT5001NinteiShinseiJohoEntity>,
        IDeletable<DbT5001NinteiShinseiJohoEntity> {

    @InjectSession
    private SqlSession session;

    @Transaction
    public DbT5001NinteiShinseiJohoEntity selectFromKey(ShinseishoKanriNo shinseishoKanriNo) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(DbT5001NinteiShinseiJoho.class).
                where(eq(DbT5001NinteiShinseiJoho.shinseishoKanriNo, shinseishoKanriNo)).
                toObject(DbT5001NinteiShinseiJohoEntity.class);
    }

    @Override
    @Transaction
    public int insertOrUpdate(DbT5001NinteiShinseiJohoEntity data) {
        return isNull(selectFromKey(data.getShinseishoKanriNo())) ? insert(data) : update(data);
    }

    private boolean isNull(Object target) {
        return target == null;
    }

    @Override
    @Transaction
    public int insert(DbT5001NinteiShinseiJohoEntity data) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(data).execute();
    }

    @Override
    @Transaction
    public int update(DbT5001NinteiShinseiJohoEntity data) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(data).execute();
    }

    @Override
    @Transaction
    public int delete(DbT5001NinteiShinseiJohoEntity data) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(data).execute();
    }

}
