/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.basic;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dba.entity.T1001HihokenshaDaicho;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;
import jp.co.ndensan.reams.db.dba.entity.T1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.business.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.ShichosonCode;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessor;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * T1001HihokenshaDaichoのデータアクセス用クラスです。
 *
 * @author N3327 三浦 凌
 */
public class HihokenshaDaichoDac implements IHihokenshaDaichoDac {

    @InjectSession
    private SqlSession session;

    @Override
    public T1001HihokenshaDaichoEntity select(ShichosonCode 市町村コード, KaigoHihokenshaNo 介護保険被保険者番号) {
        DbAccessor accessor = new DbAccessor(session);

        return accessor.select().table(T1001HihokenshaDaicho.class).
                where(and(
                eq(T1001HihokenshaDaicho.ShichosonCd, 市町村コード.getCode()),
                eq(T1001HihokenshaDaicho.HihokenshaNo, 介護保険被保険者番号.getValue()))).
                toObject(T1001HihokenshaDaichoEntity.class);
    }

    @Override
    public List<T1001HihokenshaDaichoEntity> select(KaigoHihokenshaNo 介護保険被保険者番号) {
        DbAccessor accessor = new DbAccessor(session);

        List<T1001HihokenshaDaichoEntity> entities = accessor.
                select().table(T1001HihokenshaDaicho.class).
                where(
                eq(T1001HihokenshaDaicho.HihokenshaNo, 介護保険被保険者番号.getValue())).
                toList(T1001HihokenshaDaichoEntity.class);

        if (entities.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        return entities;
    }

    @Override
    @Transaction
    public List<T1001HihokenshaDaichoEntity> select(ShichosonCode 市町村コード, IShikibetsuCode 識別コード) {
        DbAccessor accessor = new DbAccessor(session);

        List<T1001HihokenshaDaichoEntity> entities = accessor.
                select().table(T1001HihokenshaDaicho.class).
                where(and(
                eq(T1001HihokenshaDaicho.ShichosonCd, 市町村コード.getCode()),
                eq(T1001HihokenshaDaicho.ShikibetsuCode, 識別コード.getValue()))).
                toList(T1001HihokenshaDaichoEntity.class);

        if (entities.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        return entities;
    }

    @Override
    @Transaction
    public List<T1001HihokenshaDaichoEntity> select(IShikibetsuCode 識別コード) {
        DbAccessor accessor = new DbAccessor(session);

        List<T1001HihokenshaDaichoEntity> entities = accessor.
                select().table(T1001HihokenshaDaicho.class).
                where(
                eq(T1001HihokenshaDaicho.ShikibetsuCode, 識別コード.getValue())).
                toList(T1001HihokenshaDaichoEntity.class);

        if (entities.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        return entities;
    }

    @Override
    @Transaction
    public int insert(T1001HihokenshaDaichoEntity entity) {
        DbAccessor accessor = new DbAccessor(session);
        return accessor.insert(entity).execute();
    }

    @Override
    @Transaction
    public int delete(T1001HihokenshaDaichoEntity entity) {
        DbAccessor accessor = new DbAccessor(session);
        return accessor.delete(entity).execute();
    }

    @Override
    @Transaction
    public int update(T1001HihokenshaDaichoEntity entity) {
        DbAccessor accessor = new DbAccessor(session);
        return accessor.update(entity).execute();
    }
}
