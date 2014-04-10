/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic.helper;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5005NinteiShinchokuJoho;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5005NinteiShinchokuJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.persistence.IInsertable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;

/**
 * 要介護認定進捗情報のテスト用データアクセスクラスです。
 *
 * @author N8187 久保田 英男
 */
public class NinteiShinchokuJohoDacMock implements IInsertable<DbT5005NinteiShinchokuJohoEntity> {

    @InjectSession
    private SqlSession session;

    @Override
    public int insert(DbT5005NinteiShinchokuJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    public DbT5005NinteiShinchokuJohoEntity select申請書管理番号(ShinseishoKanriNo 申請書管理番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor
                .select()
                .table(DbT5005NinteiShinchokuJoho.class)
                .where(eq(DbT5005NinteiShinchokuJoho.shinseishoKanriNo, 申請書管理番号))
                .toObject(DbT5005NinteiShinchokuJohoEntity.class);
    }
}
