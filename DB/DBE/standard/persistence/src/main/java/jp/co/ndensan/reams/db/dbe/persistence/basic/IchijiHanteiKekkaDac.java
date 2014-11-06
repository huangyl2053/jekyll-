/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5016IchijiHanteiKekkaJoho;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT5016IchijiHanteiKekkaJoho.*;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5016IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.persistence.IDeletable;
import jp.co.ndensan.reams.db.dbz.persistence.IReplaceable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 一次判定結果情報を取得するDacです。
 *
 * @author n8178 城間篤人
 */
public class IchijiHanteiKekkaDac implements IReplaceable<DbT5016IchijiHanteiKekkaJohoEntity>,
        IDeletable<DbT5016IchijiHanteiKekkaJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 申請書管理番号を指定し、該当する一次判定結果情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 一次判定結果情報Entity
     */
    @Transaction
    public DbT5016IchijiHanteiKekkaJohoEntity select(ShinseishoKanriNo 申請書管理番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().table(DbT5016IchijiHanteiKekkaJoho.class)
                .where(eq(shinseishoKanriNo, 申請書管理番号))
                .toObject(DbT5016IchijiHanteiKekkaJohoEntity.class);
    }

    @Override
    public int insertOrUpdate(DbT5016IchijiHanteiKekkaJohoEntity data) {
        //TODO n8178 城間篤人 更新か新規作成かをどのように判断するか方針が決まって後修正予定 2014年3月
        int updateCount = 1;
        return updateCount == 1 ? update(data) : insert(data);
    }

    @Override
    public int insert(DbT5016IchijiHanteiKekkaJohoEntity data) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(data).execute();
    }

    @Override
    public int update(DbT5016IchijiHanteiKekkaJohoEntity data) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(data).execute();
    }

    @Override
    public int delete(DbT5016IchijiHanteiKekkaJohoEntity data) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(data).execute();
    }
}
