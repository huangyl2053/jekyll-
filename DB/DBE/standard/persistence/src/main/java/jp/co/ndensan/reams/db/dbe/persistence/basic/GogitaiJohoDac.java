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
import jp.co.ndensan.reams.db.dbz.persistence.IDeletable;
import jp.co.ndensan.reams.db.dbz.persistence.IReplaceable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 合議体情報テーブルのデータを扱うクラスです。
 *
 * @author n8178 城間篤人
 */
public class GogitaiJohoDac implements IReplaceable<DbT5103GogitaiJohoEntity>, IDeletable<DbT5103GogitaiJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 指定した合議体番号に該当する合議体Entityのリストを取得します。
     *
     * @param 合議体番号 合議体番号
     * @return 合議体EntityのList
     */
    @Transaction
    public List<DbT5103GogitaiJohoEntity> select(GogitaiNo 合議体番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().table(DbT5103GogitaiJoho.class).
                where(eq(gogitaiNo, 合議体番号.value())).
                toList(DbT5103GogitaiJohoEntity.class);
    }

    /**
     * 指定した日付時点で有効な合議体の情報を取得します。
     *
     * @param 年月日 年月日
     * @return 合議体EntityのList
     */
    @Transaction
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
