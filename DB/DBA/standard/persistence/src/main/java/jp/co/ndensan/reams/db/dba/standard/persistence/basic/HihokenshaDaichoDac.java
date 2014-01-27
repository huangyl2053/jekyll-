/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.standard.persistence.basic;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dba.standard.entity.basic.DbT1001HihokenshaDaicho;
import jp.co.ndensan.reams.db.dba.standard.entity.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.standard.definition.valueobject.KaigoHihokenshaNumber;
import jp.co.ndensan.reams.db.dbz.standard.definition.valueobject.ShichosonCode;
//TODO n3327 三浦凌 IShikibetsuCodeがdefinitionへ移動するまでは、ur.businessへの依存性を残す。( pom.xmlも修正の必要あり )
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessor;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;

/**
 * T1001HihokenshaDaichoのデータアクセス用クラスです。
 *
 * @author N3327 三浦 凌
 */
public class HihokenshaDaichoDac implements IHihokenshaDaichoDac {

    @InjectSession
    private SqlSession session;

    @Override
    public DbT1001HihokenshaDaichoEntity select(ShichosonCode 市町村コード, KaigoHihokenshaNumber 被保険者番号) {
        DbAccessor accessor = new DbAccessor(session);

        return accessor.select().table(DbT1001HihokenshaDaicho.class).
                where(and(
                eq(DbT1001HihokenshaDaicho.ShichosonCd, 市町村コード.getValue()),
                eq(DbT1001HihokenshaDaicho.HihokenshaNo, 被保険者番号.getValue()))).
                toObject(DbT1001HihokenshaDaichoEntity.class);
    }

    @Override
    public List<DbT1001HihokenshaDaichoEntity> select(KaigoHihokenshaNumber 被保険者番号) {
        DbAccessor accessor = new DbAccessor(session);

        List<DbT1001HihokenshaDaichoEntity> entities = accessor.
                select().table(DbT1001HihokenshaDaicho.class).
                where(
                eq(DbT1001HihokenshaDaicho.HihokenshaNo, 被保険者番号.getValue())).
                toList(DbT1001HihokenshaDaichoEntity.class);

        if (entities.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        return entities;
    }

    @Override
    public List<DbT1001HihokenshaDaichoEntity> select(ShichosonCode 市町村コード, IShikibetsuCode 識別コード) {
        DbAccessor accessor = new DbAccessor(session);

        List<DbT1001HihokenshaDaichoEntity> entities = accessor.
                select().table(DbT1001HihokenshaDaicho.class).
                where(and(
                eq(DbT1001HihokenshaDaicho.ShichosonCd, 市町村コード.getValue()),
                eq(DbT1001HihokenshaDaicho.ShikibetsuCode, 識別コード.getValue()))).
                toList(DbT1001HihokenshaDaichoEntity.class);

        if (entities.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        return entities;
    }

    @Override
    public List<DbT1001HihokenshaDaichoEntity> select(IShikibetsuCode 識別コード) {
        DbAccessor accessor = new DbAccessor(session);

        List<DbT1001HihokenshaDaichoEntity> entities = accessor.
                select().table(DbT1001HihokenshaDaicho.class).
                where(
                eq(DbT1001HihokenshaDaicho.ShikibetsuCode, 識別コード.getValue())).
                toList(DbT1001HihokenshaDaichoEntity.class);

        if (entities.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        return entities;
    }

    @Override
    public int insert(DbT1001HihokenshaDaichoEntity entity) {
        DbAccessor accessor = new DbAccessor(session);
        return accessor.insert(entity).execute();
    }

    @Override
    public int delete(DbT1001HihokenshaDaichoEntity entity) {
        DbAccessor accessor = new DbAccessor(session);
        return accessor.delete(entity).execute();
    }

    @Override
    public int update(DbT1001HihokenshaDaichoEntity entity) {
        DbAccessor accessor = new DbAccessor(session);
        return accessor.update(entity).execute();
    }

    @Override
    public int insertOrUpdate(DbT1001HihokenshaDaichoEntity entity) {
        return exists(entity) ? update(entity) : insert(entity);
    }

    private boolean exists(DbT1001HihokenshaDaichoEntity entity) {
        ShichosonCode 市町村コード = new ShichosonCode(entity.getShichosonCd());
        KaigoHihokenshaNumber 被保険者番号 = new KaigoHihokenshaNumber((entity.getHihokenshaNo()));
        return (select(市町村コード, 被保険者番号) != null);
    }
}
