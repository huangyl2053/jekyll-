/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5005NinteiShinchokuJoho;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5005NinteiShinchokuJohoEntity;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessor;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;

/**
 * 要介護認定進捗情報を管理するクラスです。
 *
 * @author N8187 久保田 英男
 */
public class NinteiShinchokuJohoDac implements INinteiShinchokuJohoDac {

    @InjectSession
    private SqlSession session;
    private final RString 認定調査未完了年月日 = new RString("00000000");

    @Override
    public List<DbT5005NinteiShinchokuJohoEntity> select認定調査未完了() {
        DbAccessor accessor = new DbAccessor(session);
        List<DbT5005NinteiShinchokuJohoEntity> list = accessor
                .select()
                .table(DbT5005NinteiShinchokuJoho.class)
                .where(eq(DbT5005NinteiShinchokuJoho.ninteichosaIraiKanryoYMD, 認定調査未完了年月日))
                .toList(DbT5005NinteiShinchokuJohoEntity.class);

        return (!list.isEmpty()) ? list : Collections.EMPTY_LIST;
    }
}
