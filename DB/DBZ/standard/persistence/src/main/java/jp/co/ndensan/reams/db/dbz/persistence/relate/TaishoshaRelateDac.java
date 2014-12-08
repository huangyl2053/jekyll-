/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbV7901ShikakuSearch;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbV7902FukaSearch;
import jp.co.ndensan.reams.db.dbz.entity.relate.FukaTaishoshaRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.relate.TaishoshaRelateEntity;
import jp.co.ndensan.reams.db.dbz.model.FukaTaishoshaModel;
import jp.co.ndensan.reams.db.dbz.model.TaishoshaModel;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorForAddType;
import jp.co.ndensan.reams.uz.uza.util.db.IPsmCriteria;
import jp.co.ndensan.reams.uz.uza.util.db.ITableClause;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.using;

/**
 * 対象者のデータアクセスクラスです。
 *
 * @author N8156 宮本 康
 */
public class TaishoshaRelateDac {

    @InjectSession
    private SqlSession session;

    /**
     * 条件に該当する資格対象者を検索します。
     *
     * @param 条件 介護の検索条件
     * @param psm 宛名psm
     * @param is内部結合 内部結合する場合はtrue、外部結合する場合はfalse
     * @param 最大件数 最大取得件数
     * @return 対象者
     */
    @Transaction
    public List<TaishoshaModel> select資格対象者(ITrueFalseCriteria 条件, IPsmCriteria psm, boolean is内部結合, int 最大件数) {
        DbAccessorForAddType accessor = new DbAccessorForAddType(session);
        ITableClause table = (is内部結合)
                ? accessor.select().table(psm).innerJoin(DbV7901ShikakuSearch.class, using(DbV7901ShikakuSearch.shikibetsuCode))
                : accessor.select().table(psm).leftJoin(DbV7901ShikakuSearch.class, using(DbV7901ShikakuSearch.shikibetsuCode));
        return to資格ModelList(((条件 != null) ? table.where(条件).limit(最大件数) : table.limit(最大件数)).toList(TaishoshaRelateEntity.class));
    }

    /**
     * 条件に該当する賦課対象者を検索します。
     *
     * @param 条件 介護の検索条件
     * @param psm 宛名psm
     * @param is内部結合 内部結合する場合はtrue、外部結合する場合はfalse
     * @param 最大件数 最大取得件数
     * @return 対象者
     */
    @Transaction
    public List<FukaTaishoshaModel> select賦課対象者(ITrueFalseCriteria 条件, IPsmCriteria psm, boolean is内部結合, int 最大件数) {
        DbAccessorForAddType accessor = new DbAccessorForAddType(session);
        ITableClause table = (is内部結合)
                ? accessor.select().table(psm).innerJoin(DbV7902FukaSearch.class, using(DbV7902FukaSearch.shikibetsuCode))
                : accessor.select().table(psm).leftJoin(DbV7902FukaSearch.class, using(DbV7902FukaSearch.shikibetsuCode));
        return to賦課ModelList(((条件 != null) ? table.where(条件).limit(最大件数) : table.limit(最大件数)).toList(FukaTaishoshaRelateEntity.class));
    }

    private List<TaishoshaModel> to資格ModelList(List<TaishoshaRelateEntity> entityList) {
        List<TaishoshaModel> modelList = new ArrayList<>();
        for (TaishoshaRelateEntity entity : entityList) {
            modelList.add(new TaishoshaModel(entity));
        }
        return modelList;
    }

    private List<FukaTaishoshaModel> to賦課ModelList(List<FukaTaishoshaRelateEntity> entityList) {
        List<FukaTaishoshaModel> modelList = new ArrayList<>();
        for (FukaTaishoshaRelateEntity entity : entityList) {
            modelList.add(new FukaTaishoshaModel(entity));
        }
        return modelList;
    }
}
