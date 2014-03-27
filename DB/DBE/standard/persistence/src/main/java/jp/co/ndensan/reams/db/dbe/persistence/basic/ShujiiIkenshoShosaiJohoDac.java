/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5013ShujiiIkenshoShosaiJoho;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT5013ShujiiIkenshoShosaiJoho.*;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5013ShujiiIkenshoShosaiJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;
import static jp.co.ndensan.reams.uz.uza.util.db.Order.*;

/**
 * 主治医意見書の詳細情報を取得するDacです。
 *
 * @author n8178 城間篤人
 */
public class ShujiiIkenshoShosaiJohoDac {

    @InjectSession
    private SqlSession session;

    /**
     * 申請書管理番号を指定し、主治医意見書詳細情報の最新を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 主治医意見書詳細情報
     */
    @Transaction
    public DbT5013ShujiiIkenshoShosaiJohoEntity select(ShinseishoKanriNo 申請書管理番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT5013ShujiiIkenshoShosaiJohoEntity> list = accessor.select().table(DbT5013ShujiiIkenshoShosaiJoho.class)
                .where(eq(shinseishoKanriNo, 申請書管理番号))
                .order(by(ikenshoIraiRirekiNo, DESC))
                .toList(DbT5013ShujiiIkenshoShosaiJohoEntity.class);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
}
