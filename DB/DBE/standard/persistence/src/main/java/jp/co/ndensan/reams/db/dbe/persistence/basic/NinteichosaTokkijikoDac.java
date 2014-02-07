/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5010NinteiChosaTokkijiko;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5010NinteiChosaTokkijikoEntity;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessor;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT5010NinteiChosaTokkijiko.*;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;

/**
 * 要介護認定調査特記情報のデータアクセスクラスです。
 *
 * @author N8156 宮本 康
 */
public class NinteichosaTokkijikoDac implements INinteichosaTokkijikoDac {

    @InjectSession
    private SqlSession session;

    @Override
    public DbT5010NinteiChosaTokkijikoEntity select(RString 申請書管理番号, int 認定調査履歴番号) {
        DbAccessor accessor = new DbAccessor(session);
        List<DbT5010NinteiChosaTokkijikoEntity> list = accessor.select()
                .table(DbT5010NinteiChosaTokkijiko.class)
                .where(and(
                eq(shinseishoKanriNo, 申請書管理番号),
                eq(ninteichosaRirekiNo, 認定調査履歴番号)))
                .toList(DbT5010NinteiChosaTokkijikoEntity.class);
        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    public int insertOrUpdate(DbT5010NinteiChosaTokkijikoEntity entity) {
        return getMatchRowCount(entity) == 0 ? insert(entity) : update(entity);
    }

    @Override
    public int insert(DbT5010NinteiChosaTokkijikoEntity entity) {
        DbAccessor accessor = new DbAccessor(session);
        return accessor.insert(entity).execute();
    }

    @Override
    public int update(DbT5010NinteiChosaTokkijikoEntity entity) {
        DbAccessor accessor = new DbAccessor(session);
        return accessor.update(entity).execute();
    }

    @Override
    public int delete(DbT5010NinteiChosaTokkijikoEntity entity) {
        DbAccessor accessor = new DbAccessor(session);
        return accessor.delete(entity).execute();
    }

    private int getMatchRowCount(DbT5010NinteiChosaTokkijikoEntity entity) {
        DbAccessor accessor = new DbAccessor(session);
        return accessor.select()
                .table(DbT5010NinteiChosaTokkijiko.class)
                .where(and(
                eq(shinseishoKanriNo, entity.getShinseishoKanriNo()),
                eq(ninteichosaRirekiNo, entity.getNinteichosaRirekiNo())))
                .getCount();
    }
}
