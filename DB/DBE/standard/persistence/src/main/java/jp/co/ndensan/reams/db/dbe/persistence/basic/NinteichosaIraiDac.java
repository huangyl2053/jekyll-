/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5006NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5006NinteichosaIraiJoho;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT5006NinteichosaIraiJoho.*;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;

/**
 * 認定調査依頼情報テーブルの情報を取得するためのデータアクセスクラスです。
 *
 * @author n8178 城間篤人
 */
public class NinteichosaIraiDac implements INinteichosaIraiDac {

    @InjectSession
    private SqlSession session;

    @Override
    public DbT5006NinteichosaIraiJohoEntity select(ShinseishoKanriNo 申請書管理番号, NinteichosaIraiRirekiNo 認定調査依頼履歴番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().table(DbT5006NinteichosaIraiJoho.class)
                .where(and(eq(shinseishoKanriNo, 申請書管理番号.getColumnValue()), eq(ninteichosaIraiRirekiNo, 認定調査依頼履歴番号)))
                .toObject(DbT5006NinteichosaIraiJohoEntity.class);
    }

    @Override
    public List<DbT5006NinteichosaIraiJohoEntity> select(ShinseishoKanriNo 申請書管理番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().table(DbT5006NinteichosaIraiJoho.class)
                .where(eq(shinseishoKanriNo, 申請書管理番号.getColumnValue()))
                .toList(DbT5006NinteichosaIraiJohoEntity.class);
    }

    @Override
    public int insert(DbT5006NinteichosaIraiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Override
    public int update(DbT5006NinteichosaIraiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Override
    public int insertOrUpdate(DbT5006NinteichosaIraiJohoEntity data) {
        //TODO n8178 城間篤人 insertかupdateかを判断する方法が提示されてから、テストとあわせて改めて実装を行う 2014年2月末
        return insert(data);
    }
}
