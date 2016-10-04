/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.util.report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票共通のビジネスクラスです。
 *
 * @reamsid_L DBZ-9999-020 xuyue
 */
public final class ChohyoUtil {

    private ChohyoUtil() {
    }

    private static final RString COMMA = new RString(",");

    /**
     * 指定個数の出力順より、OrderBy句を取得します。
     *
     * @param orderByClause 基盤のMyBatisOrderByClauseCreatorクラスから取得したMyBatis内で指定するOrderBy句
     * @param count 個数 個数=0の場合、そのまま返す
     * @return MyBatis内で指定するOrderBy句
     */
    public static RString get出力順OrderBy(RString orderByClause, int count) {
        if (orderByClause == null || orderByClause.isEmpty() || new RString("order by").equals(orderByClause.toLowerCase())) {
            return RString.EMPTY;
        }
        if (count == 0) {
            return orderByClause;
        }

        RString shutsuryokujun = RString.EMPTY;
        List<RString> shutsuryokujunArr = orderByClause.split(COMMA.toString());
        for (RString str : shutsuryokujunArr) {
            if (count > 0) {
                shutsuryokujun = shutsuryokujun.concat(str).concat(COMMA);
                count--;
            }
        }
        shutsuryokujun = shutsuryokujun.substring(0, shutsuryokujun.length() - 1);
        return shutsuryokujun;
    }

    /**
     * 改頁項目を取得します。
     *
     * @param outputOrder 出力順
     * @return 改頁項目Map
     */
    public static Map<Integer, ISetSortItem> get改頁項目Map(IOutputOrder outputOrder) {
        if (outputOrder == null) {
            return new HashMap<>();
        }
        List<ISetSortItem> 改頁項目List = outputOrder.get設定項目リスト();
        if (改頁項目List == null) {
            改頁項目List = new ArrayList<>();
        }

        int i = 1;
        Map<Integer, ISetSortItem> 改頁Map = new HashMap();
        for (ISetSortItem sortItem : 改頁項目List) {
            if (sortItem.is改頁項目()) {
                改頁Map.put(i, sortItem);
                i++;
            }
        }
        return 改頁Map;
    }

    /**
     * 出力順項目を取得します。
     *
     * @param outputOrder 出力順
     * @return 出力順Map
     */
    public static Map<Integer, ISetSortItem> get出力順項目Map(IOutputOrder outputOrder) {
        if (outputOrder == null) {
            return new HashMap<>();
        }
        List<ISetSortItem> 設定項目リスト = outputOrder.get設定項目リスト();
        if (設定項目リスト == null) {
            設定項目リスト = new ArrayList<>();
        }

        int i = 1;
        Map<Integer, ISetSortItem> 出力順Map = new HashMap();
        for (ISetSortItem sortItem : 設定項目リスト) {
            出力順Map.put(i, sortItem);
            i++;
        }
        return 出力順Map;
    }

}
