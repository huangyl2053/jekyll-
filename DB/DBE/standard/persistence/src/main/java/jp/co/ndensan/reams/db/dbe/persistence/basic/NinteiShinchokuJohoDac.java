/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.YokaigoninteiDateConstants;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5005NinteiShinchokuJoho;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5005NinteiShinchokuJohoEntity;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;

/**
 * 要介護認定進捗情報のデータアクセスクラスです。
 *
 * @author N8187 久保田 英男
 */
public class NinteiShinchokuJohoDac implements INinteiShinchokuJohoDac {

    @InjectSession
    private SqlSession session;

    @Override
    public List<DbT5005NinteiShinchokuJohoEntity> select認定調査未完了() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor
                .select()
                .table(DbT5005NinteiShinchokuJoho.class)
                .where(eq(DbT5005NinteiShinchokuJoho.ninteichosaKanryoYMD, YokaigoninteiDateConstants.認定調査未完了年月日))
                .toList(DbT5005NinteiShinchokuJohoEntity.class);
    }

    @Override
    public List<DbT5005NinteiShinchokuJohoEntity> select主治医意見書作成依頼未完了() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor
                .select()
                .table(DbT5005NinteiShinchokuJoho.class)
                .where(eq(DbT5005NinteiShinchokuJoho.ikenshoSakuseiIraiKanryoYMD, YokaigoninteiDateConstants.主治医意見書作成依頼未完了年月日))
                .toList(DbT5005NinteiShinchokuJohoEntity.class);
    }

    @Override
    public int update(DbT5005NinteiShinchokuJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }
}
