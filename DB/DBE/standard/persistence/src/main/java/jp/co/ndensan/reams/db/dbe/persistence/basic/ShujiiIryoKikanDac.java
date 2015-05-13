/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7011ShujiiIryoKikanJoho;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT7011ShujiiIryoKikanJoho.*;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7011ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;

/**
 * 主治医医療機関テーブルの情報を扱うデータアクセスクラスです。
 *
 * @author n8178 城間篤人
 */
public class ShujiiIryoKikanDac implements IShuJiiIryoKikanDac {

    @InjectSession
    private SqlSession session;

    @Override
    public int insertOrUpdate(DbT7011ShujiiIryoKikanJohoEntity entity) {
        return getMatchRowCount(entity) == 0 ? insert(entity) : update(entity);
    }

    @Override
    public int insert(DbT7011ShujiiIryoKikanJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Override
    public int update(DbT7011ShujiiIryoKikanJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Override
    public int delete(DbT7011ShujiiIryoKikanJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    private int getMatchRowCount(DbT7011ShujiiIryoKikanJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7011ShujiiIryoKikanJoho.class).
                where(and(eq(shichosonCode, entity.getShichosonCode()),
                                eq(kaigoIryokikanCode, entity.getKaigoIryokikanCode()))).
                getCount();
    }
}
