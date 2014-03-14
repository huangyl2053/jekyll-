/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5103GogitaiJoho;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT5103GogitaiJoho.*;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5103GogitaiJohoEntity;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;

/**
 * 合議体情報テーブルのデータを扱うクラスです。
 *
 * @author n8178 城間篤人
 */
public class GogitaiJohoDac implements IGogitaiJohoDac {

    @InjectSession
    private SqlSession session;

    @Override
    public List<DbT5103GogitaiJohoEntity> select(GogitaiNo 合議体番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().table(DbT5103GogitaiJoho.class).
                where(eq(gogitaiNo, 合議体番号.value())).
                toList(DbT5103GogitaiJohoEntity.class);
    }

    @Override
    public List<DbT5103GogitaiJohoEntity> select(FlexibleDate 年月日) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().table(DbT5103GogitaiJoho.class).
                where(and(leq(gogitaiYukoKikanKaishiYMD, 年月日), leq(年月日, gogitaiYukoKikanShuryoYMD))).
                toList(DbT5103GogitaiJohoEntity.class);
    }

    @Override
    public int insertOrUpdate(DbT5103GogitaiJohoEntity entity) {
        //TODO n8178 城間篤人 updateCountから更新か新規か判断できるまで保留 2014年3月
        int updateCount = 0;
        return updateCount == 0 ? insert(entity) : update(entity);
    }

    @Override
    public int insert(DbT5103GogitaiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Override
    public int update(DbT5103GogitaiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Override
    public int delete(DbT5103GogitaiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }
}
