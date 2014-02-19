/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5010NinteichosaTokkijikoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5010NinteichosaTokkijiko;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT5010NinteichosaTokkijiko.*;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;

/**
 * 認定調査特記事項テーブルの情報を取得するDACです
 *
 * @author n8178 城間篤人
 */
public class NinteichosaTokkijikoDac implements INinteichosaTokkijikoDac {

    @InjectSession
    private SqlSession session;

    @Override
    public DbT5010NinteichosaTokkijikoEntity select(ShinseishoKanriNo 申請書管理番号, NinteichosaIraiRirekiNo 認定調査依頼履歴番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().table(DbT5010NinteichosaTokkijiko.class)
                .where(and(eq(shinseishoKanriNo, 申請書管理番号), eq(ninteichosaRirekiNo, 認定調査依頼履歴番号)))
                .toObject(DbT5010NinteichosaTokkijikoEntity.class);
    }

    @Override
    public List<DbT5010NinteichosaTokkijikoEntity> select(ShinseishoKanriNo 申請書管理番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().table(DbT5010NinteichosaTokkijiko.class)
                .where(eq(shinseishoKanriNo, 申請書管理番号))
                .order(by(shinseishoKanriNo, Order.ASC), by(ninteichosaRirekiNo, Order.DESC), by(ninteichosaTokkijikoNo, Order.ASC))
                .toList(DbT5010NinteichosaTokkijikoEntity.class);
    }

    @Override
    public int insert(DbT5010NinteichosaTokkijikoEntity data) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(data).execute();
    }

    @Override
    public int update(DbT5010NinteichosaTokkijikoEntity data) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(data).execute();
    }

    @Override
    public int delete(DbT5010NinteichosaTokkijikoEntity data) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(data).execute();
    }

    @Override
    public int insertOrUpdate(DbT5010NinteichosaTokkijikoEntity data) {
        //TODO n8178 城間篤人 どのように実装するか未定。updateCountを取得できるようになってから実装予定 2014年2月末
        int updateCount = 0;
        return updateCount == 0 ? insert(data) : update(data);
    }
}
