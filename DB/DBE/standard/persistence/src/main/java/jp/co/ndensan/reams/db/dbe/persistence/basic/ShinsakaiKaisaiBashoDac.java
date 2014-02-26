/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiBashoCode;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5104ShinsakaiKaisaiBashoJoho;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT5104ShinsakaiKaisaiBashoJoho.*;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5104ShinsakaiKaisaiBashoJohoEntity;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;

/**
 * 介護認定審査会開催場所テーブルの情報を扱うデータアクセスクラスのインターフェースです。
 *
 * @author n8178 城間篤人
 */
public class ShinsakaiKaisaiBashoDac implements IShinsakaiKaisaiBashoDac {

    @InjectSession
    SqlSession session;

    @Override
    public DbT5104ShinsakaiKaisaiBashoJohoEntity select(ShinsakaiKaisaiBashoCode 審査会開催場所コード) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().table(DbT5104ShinsakaiKaisaiBashoJoho.class).
                where(eq(shinsakaiKaisaiBashoCode, 審査会開催場所コード.value())).
                toObject(DbT5104ShinsakaiKaisaiBashoJohoEntity.class);
    }

    @Override
    public int insert(DbT5104ShinsakaiKaisaiBashoJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }
}
