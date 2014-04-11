/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic.helper;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorForAddType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;

/**
 * 認定申請情報DACのテスト用モッククラスです。
 *
 * @author n8178 城間篤人
 */
public class NinteiShinseiJohoDacMock implements INinteiShinseiJohoDacMock {

    @InjectSession
    private SqlSession session;

    @Override
    public int insert(DbT5001NinteiShinseiJohoEntity entity) {
        DbAccessorForAddType accessor = new DbAccessorForAddType(session);
        return accessor.insert(entity).execute();
    }
}
