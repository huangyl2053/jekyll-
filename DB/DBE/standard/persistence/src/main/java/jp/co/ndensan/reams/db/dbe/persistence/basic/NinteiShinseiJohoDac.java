/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJoho;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJoho.*;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorForAddType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;

/**
 * 認定申請情報テーブルから情報を取得するクラスです。
 *
 * @author n8178 城間篤人
 */
public class NinteiShinseiJohoDac implements INinteiShinseiJohoDac {

    @InjectSession
    private SqlSession session;

    @Override
    public DbT5001NinteiShinseiJohoEntity select(ShinseishoKanriNo 申請書管理番号) {
        DbAccessorForAddType accessor = new DbAccessorForAddType(session);
        return accessor.select()
                .table(DbT5001NinteiShinseiJoho.class)
                .where(eq(shinseishoKanriNo, 申請書管理番号))
                .toObject(DbT5001NinteiShinseiJohoEntity.class);
    }

    @Override
    public List<DbT5001NinteiShinseiJohoEntity> selectAllBy認定申請年月日(ShoKisaiHokenshaNo 証記載保険者番号, Range<RDate> 認定申請年月日範囲) {
        DbAccessorForAddType accessor = new DbAccessorForAddType(session);
        return accessor.select()
                .table(DbT5001NinteiShinseiJoho.class)
                .where(and(eq(shoKisaiHokenshaNo, 証記載保険者番号),
                eq(torisageYMD, FlexibleDate.MIN),
                leq(認定申請年月日範囲.getFrom().toDateString(), ninteiShinseiYMD),
                leq(ninteiShinseiYMD, 認定申請年月日範囲.getTo().toDateString())))
                .toList(DbT5001NinteiShinseiJohoEntity.class);
    }

    @Override
    public List<DbT5001NinteiShinseiJohoEntity> selectAllBy取下げ年月日(ShoKisaiHokenshaNo 証記載保険者番号, Range<RDate> 取下げ年月日範囲) {
        DbAccessorForAddType accessor = new DbAccessorForAddType(session);
        return accessor.select()
                .table(DbT5001NinteiShinseiJoho.class)
                .where(and(eq(shoKisaiHokenshaNo, 証記載保険者番号),
                not(eq(torisageYMD, FlexibleDate.MIN)),
                leq(取下げ年月日範囲.getFrom().toDateString(), torisageYMD),
                leq(torisageYMD, 取下げ年月日範囲.getTo().toDateString())))
                .toList(DbT5001NinteiShinseiJohoEntity.class);
    }

//    @Override
//    public int update(DbT5001NinteiShinseiJohoEntity entity) {
//        DbAccessorForAddType accessor = new DbAccessorForAddType(session);
//        return accessor.update(entity).execute();
//    }
    @Override
    public int insert(DbT5001NinteiShinseiJohoEntity entity) {
        DbAccessorForAddType accessor = new DbAccessorForAddType(session);
        return accessor.insert(entity).execute();
    }
}
