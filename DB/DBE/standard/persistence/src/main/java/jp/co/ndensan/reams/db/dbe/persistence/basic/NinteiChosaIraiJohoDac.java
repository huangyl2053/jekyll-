/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteiChosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5006NinteichosaIraiJoho;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5006NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessor;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;

/**
 * 認定調査依頼情報を管理するクラスです。
 *
 * @author N8187 久保田 英男
 */
public class NinteiChosaIraiJohoDac implements INinteiChosaIraiJohoDac {

    @InjectSession
    private SqlSession session;

    @Override
    public DbT5006NinteichosaIraiJohoEntity select(RString 申請書管理番号, NinteiChosaIraiRirekiNo 認定調査依頼履歴番号) {
        DbAccessor accessor = new DbAccessor(session);
        List<DbT5006NinteichosaIraiJohoEntity> list = accessor
                .select()
                .table(DbT5006NinteichosaIraiJoho.class)
                .where(and(eq(DbT5006NinteichosaIraiJoho.shinseishoKanriNo, 申請書管理番号),
                eq(DbT5006NinteichosaIraiJoho.ninteichosaIraiRirekiNo, 認定調査依頼履歴番号.value())))
                .toList(DbT5006NinteichosaIraiJohoEntity.class);

        return (!list.isEmpty()) ? list.get(0) : null;
    }
}
