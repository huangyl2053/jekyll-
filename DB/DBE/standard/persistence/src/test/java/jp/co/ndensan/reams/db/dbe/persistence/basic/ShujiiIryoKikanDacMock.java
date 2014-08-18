/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7011ShujiiIryoKikanJoho;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT7011ShujiiIryoKikanJoho.*;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7011ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessor;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;

/**
 * 主治医医療機関DACのテスト用selecterです。
 *
 * @author n8178 城間篤人
 */
public class ShujiiIryoKikanDacMock implements IShujiiIryoKikanDacMock {

    @InjectSession
    private SqlSession session;

    @Override
    public DbT7011ShujiiIryoKikanJohoEntity select(LasdecCode 市町村コード, KaigoIryoKikanCode 介護医療機関コード) {
        DbAccessor accessor = new DbAccessor(session);
        return accessor.select().table(DbT7011ShujiiIryoKikanJoho.class).
                where(and(eq(shichosonCode, 市町村コード), eq(kaigoIryokikanCode, 介護医療機関コード))).
                toObject(DbT7011ShujiiIryoKikanJohoEntity.class);
    }
}
