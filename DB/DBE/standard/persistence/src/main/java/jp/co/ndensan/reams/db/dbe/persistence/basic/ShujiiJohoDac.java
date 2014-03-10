/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7012ShujiiJoho;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7012ShujiiJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoDoctorCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;

/**
 * 主治医情報を管理するクラスです。
 *
 * @author N8187 久保田 英男
 */
public class ShujiiJohoDac implements IShujiiJohoDac {

    @InjectSession
    private SqlSession session;

    @Override
    public DbT7012ShujiiJohoEntity select(ShichosonCode 市町村コード, KaigoIryoKikanCode 介護医療機関コード, KaigoDoctorCode 介護医師コード) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor
                .select()
                .table(DbT7012ShujiiJoho.class)
                .where(and(eq(DbT7012ShujiiJoho.shichosonCode, 市町村コード),
                eq(DbT7012ShujiiJoho.kaigoIryokikanCode, 介護医療機関コード),
                eq(DbT7012ShujiiJoho.kaigoIshiCode, 介護医師コード)))
                .toObject(DbT7012ShujiiJohoEntity.class);
    }
}
