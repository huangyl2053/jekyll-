/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic.helper;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5009NinteichosahyoJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5013ShujiiIkenshoShosaiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IInsertable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;

/**
 * 主治医意見書詳細情報Entityを保存する、テスト用Dacです。
 *
 * @author n8178 城間篤人
 */
public class ShujiIkenshoShosaiJohoInserter implements IInsertable<DbT5013ShujiiIkenshoShosaiJohoEntity> {

    @InjectSession
    SqlSession session;

    @Override
    public int insert(DbT5013ShujiiIkenshoShosaiJohoEntity data) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(data).execute();
    }
}
