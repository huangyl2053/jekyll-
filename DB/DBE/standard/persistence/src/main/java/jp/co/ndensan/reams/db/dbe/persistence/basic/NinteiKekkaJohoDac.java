/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5002NinteiKekkaJoho;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5002NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.persistence.IDeletable;
import jp.co.ndensan.reams.db.dbz.persistence.IInsertable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT5002NinteiKekkaJoho.*;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;

/**
 * 要介護認定結果情報のデータアクセスクラスです。
 *
 * @author N8156 宮本 康
 */
public class NinteiKekkaJohoDac implements IInsertable<DbT5002NinteiKekkaJohoEntity>, IDeletable<DbT5002NinteiKekkaJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 引数の条件に該当する要介護認定結果情報エンティティを取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 要介護認定結果情報エンティティ
     */
    @Transaction
    public DbT5002NinteiKekkaJohoEntity select(ShinseishoKanriNo 申請書管理番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select()
                .table(DbT5002NinteiKekkaJoho.class)
                .where(eq(shinseishoKanriNo, 申請書管理番号))
                .toObject(DbT5002NinteiKekkaJohoEntity.class);
    }

    @Override
    @Transaction
    public int insert(DbT5002NinteiKekkaJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Override
    @Transaction
    public int delete(DbT5002NinteiKekkaJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    @Transaction
    public int update(DbT5002NinteiKekkaJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }
}
