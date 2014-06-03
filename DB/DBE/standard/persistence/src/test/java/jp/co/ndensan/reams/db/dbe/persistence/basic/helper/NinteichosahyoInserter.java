/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic.helper;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5009NinteichosahyoJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IInsertable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;

/**
 * 認定調査票Entityの情報を挿入する、テスト用Dacです。
 *
 * @author n8178 城間篤人
 */
public class NinteichosahyoInserter implements IInsertable<DbT5009NinteichosahyoJohoEntity> {

    @InjectSession
    SqlSession session;

    @Override
    public int insert(DbT5009NinteichosahyoJohoEntity data) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(data).execute();
    }
}
