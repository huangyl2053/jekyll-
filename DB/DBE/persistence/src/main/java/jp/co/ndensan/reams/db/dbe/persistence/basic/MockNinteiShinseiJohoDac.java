/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessor;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;

/**
 *
 * @author n8178 城間篤人
 */
public class MockNinteiShinseiJohoDac implements IMockNinteiShinseiJohoDac {

    @InjectSession
    private SqlSession session;

    @Override
    public int insert(DbT5001NinteiShinseiJohoEntity entity) {
        DbAccessor accessor = new DbAccessor(session);
        return accessor.insert(entity).execute();
    }
}
