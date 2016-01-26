/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.shokanfukushiyoguhanbaihi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3048ShokanFukushiYoguHanbaihi;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3048ShokanFukushiYoguHanbaihi.hiHokenshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3048ShokanFukushiYoguHanbaihi.hinmokuCode;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3048ShokanFukushiYoguHanbaihi.seiriNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3048ShokanFukushiYoguHanbaihi.serviceTeikyoYM;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3048ShokanFukushiYoguHanbaihiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.in;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.like;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.not;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 福祉用具購入費同一品目重複判定
 *
 * @author chenaoqi
 */
public class FukushiYoguKounyuhiDouituHinmokuChofukuHantei {

    @InjectSession
    private SqlSession session;

    /**
     * 品目コード重複チェック（支給単位）
     *
     * @param 品目コード
     * @param list
     * @return flag
     */
    public boolean chkHinmokuCodePerShinsei(RString 品目コード,
            List<DbT3048ShokanFukushiYoguHanbaihiEntity> list) {
        boolean flag = false;
        if (null == list || list.isEmpty()) {
            return flag;
        }
        for (DbT3048ShokanFukushiYoguHanbaihiEntity entity : list) {
            if (entity.getHinmokuCode().equals(品目コード) && !entity.getIsDeleted()) {
                flag = true;
                break;
            }
        }

        return flag;
    }

    /**
     * 品目コード重複チェック（年度単位）
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param list
     * @return flag
     */
    @Transaction
    public boolean chkHinmokuCodePerYear(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月,
            RString 整理番号, List<DbT3048ShokanFukushiYoguHanbaihiEntity> list) {
        boolean flag = false;

        if (null == list || list.isEmpty() || null == 被保険者番号 || null == サービス提供年月) {
            return flag;
        }
        Set<RString> sets = new HashSet<>();
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        for (DbT3048ShokanFukushiYoguHanbaihiEntity entity : list) {
            if (!entity.getIsDeleted()) {
                if (sets.contains(entity.getHinmokuCode())) {
                    flag = true;
                    break;
                } else {
                    sets.add(entity.getHinmokuCode());
                }
            }
        }
        List<RString> arrList = new ArrayList<>(sets);
        List<DbT3048ShokanFukushiYoguHanbaihiEntity> resultList = new ArrayList<>();
        if (!flag) {
            if (null == 整理番号) {
                resultList = accessor.select().
                        table(DbT3048ShokanFukushiYoguHanbaihi.class).
                        where(and(
                                        eq(hiHokenshaNo, 被保険者番号),
                                        like(serviceTeikyoYM, サービス提供年月.toString().substring(0, 4)),
                                        in(hinmokuCode, arrList)
                                )).
                        toList(DbT3048ShokanFukushiYoguHanbaihiEntity.class);
                if (resultList.size() > 0) {
                    flag = true;
                }
            } else {
                resultList = accessor.select().
                        table(DbT3048ShokanFukushiYoguHanbaihi.class).
                        where(and(
                                        eq(hiHokenshaNo, 被保険者番号),
                                        like(serviceTeikyoYM, サービス提供年月.toString().substring(0, 4)),
                                        // TODO div.整理番号不存在
                                        not(eq(seiriNo, 整理番号)),
                                        in(hinmokuCode, arrList)
                                )).
                        toList(DbT3048ShokanFukushiYoguHanbaihiEntity.class);
                if (resultList.size() > 0) {
                    flag = true;
                }
            }
        }
        return flag;
    }
}
