/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2002Fuka;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbz.model.FukaModel;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT2002Fuka.fukaNendo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT2002Fuka.hihokenshaNo;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;

// TODO N8156 宮本 康 別ブランチで対応中。マージ時にメソッドを追加する。
public class FukaDac {

    @InjectSession
    private SqlSession session;

    /**
     * 条件に該当する介護賦課マスタを取得する。
     *
     * @param 被保険者番号 被保険者番号
     * @return 介護賦課マスタ
     */
    @Transaction
    public IItemList<FukaModel> select(HihokenshaNo 被保険者番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return toModelList(accessor.select().
                table(DbT2002Fuka.class).
                where(eq(hihokenshaNo, 被保険者番号)).
                toList(DbT2002FukaEntity.class));
    }

    /**
     * 条件に該当する介護賦課マスタを取得する。
     *
     * @param 被保険者番号 被保険者番号
     * @param 賦課年度 賦課年度
     * @return 介護賦課マスタ
     */
    @Transaction
    public IItemList<FukaModel> select(HihokenshaNo 被保険者番号, FlexibleYear 賦課年度) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return toModelList(accessor.select().
                table(DbT2002Fuka.class).
                where(and(eq(hihokenshaNo, 被保険者番号), eq(fukaNendo, 賦課年度))).
                toList(DbT2002FukaEntity.class));
    }

    private IItemList<FukaModel> toModelList(List<DbT2002FukaEntity> entityList) {
        List<FukaModel> modelList = new ArrayList<>();
        for (DbT2002FukaEntity entity : entityList) {
            modelList.add(new FukaModel(entity));
        }
        return ItemList.of(modelList);
    }
}
