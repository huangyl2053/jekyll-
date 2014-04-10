/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5005NinteiShinchokuJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IUpdatable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;

/**
 * 要介護認定進捗情報のデータアクセスクラスです。
 *
 * @author N8187 久保田 英男
 */
public class NinteiShinchokuJohoDac implements IUpdatable<DbT5005NinteiShinchokuJohoEntity> {

    @InjectSession
    private SqlSession session;

    @Override
    public int update(DbT5005NinteiShinchokuJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }
}
