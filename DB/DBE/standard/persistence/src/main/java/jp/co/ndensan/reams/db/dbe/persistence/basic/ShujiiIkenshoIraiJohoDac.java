/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5011ShujiiIkenshoIraiJoho;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5011ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT5011ShujiiIkenshoIraiJoho.*;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;

/**
 * 主治医意見書作成依頼情報のデータアクセスクラスです。
 *
 * @author N8156 宮本 康
 */
public class ShujiiIkenshoIraiJohoDac implements IShujiiIkenshoIraiJohoDac {

    @InjectSession
    private SqlSession session;

    @Override
    public DbT5011ShujiiIkenshoIraiJohoEntity select(ShinseishoKanriNo 申請書管理番号, int 意見書作成依頼履歴番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select()
                .table(DbT5011ShujiiIkenshoIraiJoho.class)
                .where(and(
                eq(shinseishoKanriNo, 申請書管理番号),
                eq(ikenshoIraiRirekiNo, 意見書作成依頼履歴番号)))
                .toObject(DbT5011ShujiiIkenshoIraiJohoEntity.class);
    }

    @Override
    public List<DbT5011ShujiiIkenshoIraiJohoEntity> selectBy申請書管理番号(ShinseishoKanriNo 申請書管理番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select()
                .table(DbT5011ShujiiIkenshoIraiJoho.class)
                .where(eq(shinseishoKanriNo, 申請書管理番号))
                .order(by(shinseishoKanriNo, Order.ASC), by(ikenshoIraiRirekiNo, Order.DESC))
                .toList(DbT5011ShujiiIkenshoIraiJohoEntity.class);
    }

    @Override
    public List<DbT5011ShujiiIkenshoIraiJohoEntity> selectBy依頼年月日(FlexibleDate 意見書作成依頼年月日) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select()
                .table(DbT5011ShujiiIkenshoIraiJoho.class)
                .where(eq(ikenshoSakuseiIraiYMD, 意見書作成依頼年月日))
                .order(by(shinseishoKanriNo, Order.ASC), by(ikenshoIraiRirekiNo, Order.DESC))
                .toList(DbT5011ShujiiIkenshoIraiJohoEntity.class);
    }

    @Override
    public List<DbT5011ShujiiIkenshoIraiJohoEntity> selectBy主治医情報(RString 介護医療機関コード, RString 介護医師コード) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select()
                .table(DbT5011ShujiiIkenshoIraiJoho.class)
                .where(and(
                eq(kaigoIryokikanCode, 介護医療機関コード),
                eq(kaigoIshiCode, 介護医師コード)))
                .order(by(shinseishoKanriNo, Order.ASC), by(ikenshoIraiRirekiNo, Order.DESC))
                .toList(DbT5011ShujiiIkenshoIraiJohoEntity.class);
    }

    @Override
    public List<DbT5011ShujiiIkenshoIraiJohoEntity> selectBy督促年月日(FlexibleDate 意見書作成督促年月日) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select()
                .table(DbT5011ShujiiIkenshoIraiJoho.class)
                .where(eq(ikenshoSakuseiTokusokuYMD, 意見書作成督促年月日))
                .order(by(shinseishoKanriNo, Order.ASC), by(ikenshoIraiRirekiNo, Order.DESC))
                .toList(DbT5011ShujiiIkenshoIraiJohoEntity.class);
    }

    @Override
    public int insertOrUpdate(DbT5011ShujiiIkenshoIraiJohoEntity entity) {
        return getMatchRowCount(entity) == 0 ? insert(entity) : update(entity);
    }

    @Override
    public int insert(DbT5011ShujiiIkenshoIraiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Override
    public int update(DbT5011ShujiiIkenshoIraiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Override
    public int delete(DbT5011ShujiiIkenshoIraiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    private int getMatchRowCount(DbT5011ShujiiIkenshoIraiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select()
                .table(DbT5011ShujiiIkenshoIraiJoho.class)
                .where(and(
                eq(shinseishoKanriNo, entity.getShinseishoKanriNo()),
                eq(ikenshoIraiRirekiNo, entity.getIkenshoIraiRirekiNo())))
                .getCount();
    }
}
