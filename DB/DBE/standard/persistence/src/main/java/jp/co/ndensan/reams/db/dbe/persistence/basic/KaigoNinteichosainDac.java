/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosainJokyo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoNinteichosainNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoJigyoshaNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7013ChosainJoho;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7013ChosainJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT7013ChosainJoho.*;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;

/**
 * 介護認定調査員情報のデータアクセスクラスです。
 *
 * @author N8187 久保田 英男
 */
public class KaigoNinteichosainDac implements IKaigoNinteichosainDac {

    @InjectSession
    private SqlSession session;

    @Override
    public DbT7013ChosainJohoEntity select(ShoKisaiHokenshaNo 証記載保険者番号, KaigoJigyoshaNo 介護事業者番号, KaigoNinteichosainNo 介護調査員番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select()
                .table(DbT7013ChosainJoho.class)
                .where(and(
                eq(shichosonCode, 証記載保険者番号),
                eq(kaigoJigyoshaNo, 介護事業者番号),
                eq(kaigoChosainNo, 介護調査員番号)))
                .toObject(DbT7013ChosainJohoEntity.class);
    }

    @Override
    public DbT7013ChosainJohoEntity select(ShoKisaiHokenshaNo 証記載保険者番号, KaigoJigyoshaNo 介護事業者番号, KaigoNinteichosainNo 介護調査員番号, ChosainJokyo 調査員の状況) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select()
                .table(DbT7013ChosainJoho.class)
                .where(and(
                eq(shichosonCode, 証記載保険者番号),
                eq(kaigoJigyoshaNo, 介護事業者番号),
                eq(kaigoChosainNo, 介護調査員番号),
                eq(kaigoChosainJokyo, 調査員の状況)))
                .toObject(DbT7013ChosainJohoEntity.class);
    }

    @Override
    public List<DbT7013ChosainJohoEntity> selectAll(ShoKisaiHokenshaNo 証記載保険者番号, KaigoJigyoshaNo 介護事業者番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor
                .select()
                .table(DbT7013ChosainJoho.class)
                .where(and(
                eq(shichosonCode, 証記載保険者番号),
                eq(kaigoJigyoshaNo, 介護事業者番号)))
                .toList(DbT7013ChosainJohoEntity.class);
    }

    @Override
    public List<DbT7013ChosainJohoEntity> selectAll(ShoKisaiHokenshaNo 証記載保険者番号, KaigoJigyoshaNo 介護事業者番号, ChosainJokyo 調査員の状況) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor
                .select()
                .table(DbT7013ChosainJoho.class)
                .where(and(
                eq(shichosonCode, 証記載保険者番号),
                eq(kaigoJigyoshaNo, 介護事業者番号),
                eq(kaigoChosainJokyo, 調査員の状況)))
                .toList(DbT7013ChosainJohoEntity.class);
    }

    @Override
    public List<DbT7013ChosainJohoEntity> selectAll(ShoKisaiHokenshaNo 証記載保険者番号, ChosainJokyo 調査員の状況) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor
                .select()
                .table(DbT7013ChosainJoho.class)
                .where(and(
                eq(shichosonCode, 証記載保険者番号),
                eq(kaigoChosainJokyo, 調査員の状況)))
                .toList(DbT7013ChosainJohoEntity.class);
    }

    @Override
    public List<DbT7013ChosainJohoEntity> selectAll(ShoKisaiHokenshaNo 証記載保険者番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor
                .select()
                .table(DbT7013ChosainJoho.class)
                .where(eq(shichosonCode, 証記載保険者番号))
                .toList(DbT7013ChosainJohoEntity.class);
    }

    @Override
    public int insertOrUpdate(DbT7013ChosainJohoEntity entity) {
        return getMatchRowCount(entity) == 0 ? insert(entity) : update(entity);
    }

    @Override
    public int insert(DbT7013ChosainJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Override
    public int update(DbT7013ChosainJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Override
    public int delete(DbT7013ChosainJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    private int getMatchRowCount(DbT7013ChosainJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select()
                .table(DbT7013ChosainJoho.class)
                .where(and(
                eq(shichosonCode, entity.getShoKisaiHokenshaNo()),
                eq(kaigoJigyoshaNo, entity.getKaigoChosainNo()),
                eq(kaigoChosainNo, entity.getKaigoChosainNo())))
                .getCount();
    }
}
