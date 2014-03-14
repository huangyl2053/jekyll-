/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5011ShujiiIkenshoIraiJoho;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5011ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;

/**
 * 主治医意見書作成依頼情報を管理するクラスです。
 *
 * @author N8187 久保田 英男
 */
public class ShujiiIkenshoIraiJohoDac implements IShujiiIkenshoIraiJohoDac {

    @InjectSession
    private SqlSession session;

    @Override
    public DbT5011ShujiiIkenshoIraiJohoEntity select(ShinseishoKanriNo 申請書管理番号, int 主治医意見書作成依頼履歴番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor
                .select()
                .table(DbT5011ShujiiIkenshoIraiJoho.class)
                .where(and(eq(DbT5011ShujiiIkenshoIraiJoho.shinseishoKanriNo, 申請書管理番号),
                eq(DbT5011ShujiiIkenshoIraiJoho.ikenshoIraiRirekiNo, 主治医意見書作成依頼履歴番号)))
                .toObject(DbT5011ShujiiIkenshoIraiJohoEntity.class);
    }
}
