/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic.helper;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5005NinteiShinchokuJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IInsertable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;

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
}
