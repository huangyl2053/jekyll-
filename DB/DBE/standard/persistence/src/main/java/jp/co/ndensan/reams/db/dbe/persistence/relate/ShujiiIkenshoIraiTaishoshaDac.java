/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.YokaigoninteiDateConstants;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5005NinteiShinchokuJoho;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5005NinteiShinchokuJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;

/**
 * 主治医意見書作成依頼対象者を取得するクラスです。
 *
 * @author N8187 久保田 英男
 */
public class ShujiiIkenshoIraiTaishoshaDac implements IShujiiIkenshoIraiTaishoshaDac {

    @InjectSession
    private SqlSession session;

    @Override
    public List<DbT5005NinteiShinchokuJohoEntity> select主治医意見書作成依頼対象者(ShichosonCode 市町村コード) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor
                .select()
                .table(DbT5005NinteiShinchokuJoho.class)
                .innerJoin(DbT5001NinteiShinseiJoho.class,
                using(DbT5001NinteiShinseiJoho.shinseishoKanriNo, DbT5005NinteiShinchokuJoho.shinseishoKanriNo))
                .where(and(eq(DbT5001NinteiShinseiJoho.shichosonCode, 市町村コード),
                eq(DbT5005NinteiShinchokuJoho.ikenshoSakuseiIraiKanryoYMD, YokaigoninteiDateConstants.主治医意見書作成依頼未完了年月日)))
                .order(by(DbT5005NinteiShinchokuJoho.shinseishoKanriNo, Order.ASC))
                .toList(DbT5005NinteiShinchokuJohoEntity.class);
    }

    @Override
    public List<DbT5005NinteiShinchokuJohoEntity> select主治医意見書作成依頼対象者(ShichosonCode 市町村コード, RString 支所コード) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor
                .select()
                .table(DbT5005NinteiShinchokuJoho.class)
                .innerJoin(DbT5001NinteiShinseiJoho.class,
                using(DbT5001NinteiShinseiJoho.shinseishoKanriNo, DbT5005NinteiShinchokuJoho.shinseishoKanriNo))
                .where(and(eq(DbT5001NinteiShinseiJoho.shichosonCode, 市町村コード),
                eq(DbT5001NinteiShinseiJoho.shishoCode, 支所コード),
                eq(DbT5005NinteiShinchokuJoho.ikenshoSakuseiIraiKanryoYMD, YokaigoninteiDateConstants.主治医意見書作成依頼未完了年月日)))
                .order(by(DbT5005NinteiShinchokuJoho.shinseishoKanriNo, Order.ASC))
                .toList(DbT5005NinteiShinchokuJohoEntity.class);
    }
}
