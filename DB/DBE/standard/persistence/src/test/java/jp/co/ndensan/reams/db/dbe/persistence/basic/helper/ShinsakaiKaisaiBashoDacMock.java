/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic.helper;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5104ShinsakaiKaisaiBashoJohoEntity;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessor;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;

/**
 * 審査会開催場所情報DACのテスト用モッククラスです。
 *
 * @author N1013
 */
public class ShinsakaiKaisaiBashoDacMock implements IShinsakaiKaisaiBashoDacMock {

    @InjectSession
    private SqlSession session;

    @Override
    public int insert(DbT5104ShinsakaiKaisaiBashoJohoEntity entity) {
        DbAccessor accessor = new DbAccessor(session);
        return accessor.insert(entity).execute();
    }
}
