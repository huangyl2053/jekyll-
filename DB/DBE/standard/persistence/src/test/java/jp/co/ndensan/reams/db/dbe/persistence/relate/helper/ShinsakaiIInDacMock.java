/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.relate.helper;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5102ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;

/**
 * 合議体割当審査会委員Dacテストのための、審査会委員の情報をinsertするクラスのインターフェースです。
 *
 * @author n8178 城間篤人
 */
public class ShinsakaiIInDacMock implements IShinsakaiIInDacMock {

    @InjectSession
    SqlSession session;

    @Override
    public int insert(DbT5102ShinsakaiIinJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }
}
