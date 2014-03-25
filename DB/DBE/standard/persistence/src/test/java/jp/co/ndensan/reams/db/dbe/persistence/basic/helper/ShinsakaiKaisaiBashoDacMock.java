/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic.helper;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5104ShinsakaiKaisaiBashoJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IInsertable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;

/**
 * 審査会開催場所情報DACのテスト用モッククラスです。
 *
 * @author N1013
 */
public class ShinsakaiKaisaiBashoDacMock implements IInsertable<DbT5104ShinsakaiKaisaiBashoJohoEntity> {

    @InjectSession
    private SqlSession session;

    @Override
    public int insert(DbT5104ShinsakaiKaisaiBashoJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }
}
