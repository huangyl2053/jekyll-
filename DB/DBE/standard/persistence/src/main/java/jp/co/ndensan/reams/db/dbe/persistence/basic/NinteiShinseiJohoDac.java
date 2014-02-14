/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessor;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;

/**
 * 要介護認定申請情報を管理するクラスです
 *
 * @author N8187 久保田 英男
 */
public class NinteiShinseiJohoDac implements INinteiShinseiJohoDac {

    @InjectSession
    private SqlSession session;

    @Override
    public DbT5001NinteiShinseiJohoEntity select(ShinseishoKanriNo 申請書管理番号) {
        DbAccessor accessor = new DbAccessor(session);
        return accessor
                .select()
                .table(DbT5001NinteiShinseiJoho.class)
                .where(eq(DbT5001NinteiShinseiJoho.shinseishoKanriNo, 申請書管理番号))
                .toObject(DbT5001NinteiShinseiJohoEntity.class);
    }
}
