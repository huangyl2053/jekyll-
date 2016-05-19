/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.fukushiyogukonyuhishikyushisei;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanFukushiYoguHanbaihi;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3048ShokanFukushiYoguHanbaihiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3048ShokanFukushiYoguHanbaihiDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 福祉用具購入費同一品目重複判定
 *
 * @reamsid_L DBC-1020-070 chenaoqi
 */
public class FukushiYoguKounyuhiDouituHinmokuChofukuHantei {

    private final DbT3048ShokanFukushiYoguHanbaihiDac 償還払請求福祉用具販売費Dac;

    /**
     * コンストラクタです。
     */
    public FukushiYoguKounyuhiDouituHinmokuChofukuHantei() {
        this.償還払請求福祉用具販売費Dac = InstanceProvider.create(DbT3048ShokanFukushiYoguHanbaihiDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param 償還払請求福祉用具販売費Dac 償還払請求福祉用具販売費Dac
     */
    public FukushiYoguKounyuhiDouituHinmokuChofukuHantei(DbT3048ShokanFukushiYoguHanbaihiDac 償還払請求福祉用具販売費Dac) {
        this.償還払請求福祉用具販売費Dac = 償還払請求福祉用具販売費Dac;
    }

    /**
     * 品目コード重複チェック（支給単位）
     *
     * @param 品目コード 品目コード
     * @param list list
     * @return flag
     */
    public boolean chkHinmokuCodePerShinsei(RString 品目コード,
            List<DbT3048ShokanFukushiYoguHanbaihiEntity> list) {
        boolean flag = false;
        if (list == null || list.isEmpty() || 品目コード == null || 品目コード.isEmpty()) {
            return flag;
        }
        for (DbT3048ShokanFukushiYoguHanbaihiEntity entity : list) {
            if (品目コード.equals(entity.getHinmokuCode()) && !EntityDataState.Deleted.equals(entity.getState())) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * 品目コード重複チェック（年度単位）
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param list list
     * @return flag
     */
    public boolean chkHinmokuCodePerYear(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月,
            List<ShokanFukushiYoguHanbaihi> list, RString 整理番号) {
        boolean flag = false;

        if (list == null || list.isEmpty() || 被保険者番号 == null || サービス提供年月 == null) {
            return flag;
        }
        Set<RString> sets = new HashSet<>();
        for (ShokanFukushiYoguHanbaihi entity : list) {
            if (EntityDataState.Deleted.equals(entity.toEntity().getState())) {
                continue;
            }
            if (sets.contains(entity.toEntity().getHinmokuCode())) {
                flag = true;
                break;
            } else {
                sets.add(entity.toEntity().getHinmokuCode());
            }
        }
        if (!sets.isEmpty()) {
            List<RString> arrList = new ArrayList<>(sets);
            arrList.remove(null);
            if (arrList.isEmpty()) {
                return flag;
            }
            List<DbT3048ShokanFukushiYoguHanbaihiEntity> resultList = new ArrayList<>();
            if (!flag) {
                resultList = 償還払請求福祉用具販売費Dac.select品目コード(被保険者番号, サービス提供年月, arrList, 整理番号);
            }
            if (resultList != null && !resultList.isEmpty()) {
                flag = true;
            }
        }
        return flag;
    }
}
