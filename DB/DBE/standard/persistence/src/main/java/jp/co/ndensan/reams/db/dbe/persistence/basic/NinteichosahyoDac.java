/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5009NinteichosahyoJoho;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT5009NinteichosahyoJoho.*;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5009NinteichosahyoJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;
import static jp.co.ndensan.reams.uz.uza.util.db.Order.*;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査票の情報を取得するDacです。
 *
 * @author n8178 城間篤人
 */
public class NinteichosahyoDac {

    @InjectSession
    private SqlSession session;

    /**
     * 申請書管理番号を指定し、該当する認定調査票情報の最新を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 最新の認定調査票情報
     */
    @Transaction
    public DbT5009NinteichosahyoJohoEntity select(ShinseishoKanriNo 申請書管理番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT5009NinteichosahyoJohoEntity> list = accessor.select().table(DbT5009NinteichosahyoJoho.class)
                .where(eq(shinseishoKanriNo, 申請書管理番号))
                .order(by(ninteichosaRirekiNo, DESC))
                .toList(DbT5009NinteichosahyoJohoEntity.class);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
}
