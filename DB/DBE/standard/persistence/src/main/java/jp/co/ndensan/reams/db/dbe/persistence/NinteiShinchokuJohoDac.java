/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5005NinteiShinchokuJoho;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5005NinteiShinchokuJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessor;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;

/**
 * 要介護認定進捗情報を管理するクラスです
 *
 * @author N8187 久保田 英男
 */
public class NinteiShinchokuJohoDac implements INinteiShinchokuJohoDac {

    @InjectSession
    private SqlSession session;
    private final RString 認定調査未完了年月日 = new RString("00000000");

    @Override
    public List<DbT5005NinteiShinchokuJohoEntity> selectChosaIraiTaisho(ShichosonCode 市町村コード) {
        DbAccessor accessor = new DbAccessor(session);

        List<DbT5005NinteiShinchokuJohoEntity> list = accessor
                .select()
                .table(DbT5005NinteiShinchokuJoho.class)
                .innerJoin(DbT5001NinteiShinseiJoho.class,
                using(DbT5001NinteiShinseiJoho.shinseishoKanriNo, DbT5005NinteiShinchokuJoho.shinseishoKanriNo))
                .where(and(eq(DbT5001NinteiShinseiJoho.shichosonCode, 市町村コード),
                eq(DbT5005NinteiShinchokuJoho.ninteichosaIraiKanryoYMD, 認定調査未完了年月日)))
                .order(by(DbT5005NinteiShinchokuJoho.shinseishoKanriNo, Order.ASC))
                .toList(DbT5005NinteiShinchokuJohoEntity.class);

        return (!list.isEmpty()) ? list : Collections.EMPTY_LIST;
    }

    @Override
    public List<DbT5005NinteiShinchokuJohoEntity> selectChosaIraiTaisho() {
        DbAccessor accessor = new DbAccessor(session);
        List<DbT5005NinteiShinchokuJohoEntity> list = accessor
                .select()
                .table(DbT5005NinteiShinchokuJoho.class)
                .where(eq(DbT5005NinteiShinchokuJoho.ninteichosaIraiKanryoYMD, 認定調査未完了年月日))
                .order(by(DbT5005NinteiShinchokuJoho.shinseishoKanriNo, Order.ASC))
                .toList(DbT5005NinteiShinchokuJohoEntity.class);

        return (!list.isEmpty()) ? list : Collections.EMPTY_LIST;
    }
}
