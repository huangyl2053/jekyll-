/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.gemmen.shinseisho.hakko;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * MyBatis内で使用する、出力順指示用のOrderBy句を生成するクラスです。
 *
 * @reamsid_L DBD-3530-080 mawy
 */
public class Ddb102020MyBatisOrderByClauseCreator {

    private static RStringBuilder orderByClause;
    private static RString space;
    private static RString comma;
    private static RString quote;
    private static int commaCount;
    private static final int INDEX_5 = 5;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private Ddb102020MyBatisOrderByClauseCreator() {
    }

    /**
     * 出力順・改頁リスト及び、出力順・改頁項目管理Enumクラスを引数で指定することで、MyBatis内で指定するOrderBy句を生成します。
     *
     * @param <T> IReportItemsを実装したEnumクラス
     * @param clazz 出力順・改頁項目管理Enumクラス
     * @param outputOrder 出力順
     * @return MyBatis内で指定するOrderBy句
     */
    public static <T extends Enum<T> & IReportItems> RString create(Class<T> clazz, IOutputOrder outputOrder) {
        ReportItemsMap reportItems = new ReportItemsMap(Arrays.<IReportItems>asList(clazz.getEnumConstants()));
        orderByClause = new RStringBuilder("");
        space = new RString(" ");
        comma = new RString(",");
        quote = new RString("\"");
        commaCount = 0;
        if (outputOrder.get設定項目リスト().isEmpty()) {
            return RString.EMPTY;
        }
        for (ISetSortItem setSortItem : outputOrder.get設定項目リスト()) {

            if (!reportItems.is一時テーブルコラム存在(setSortItem.get項目ID())) {
                continue;
            }

            if (commaCount >= INDEX_5) {
                return orderByClause.toRString();
            }

            if (commaCount != 0) {
                orderByClause = orderByClause.append(space).append(comma).append(space).append(quote)
                        .append(reportItems.getMyBatis項目名(setSortItem.get項目ID())).append(quote).append(space).append(setSortItem.get昇降順().getOrder());

            } else {
                orderByClause = new RStringBuilder("order by").append(space).append(quote)
                        .append(reportItems.getMyBatis項目名(setSortItem.get項目ID())).append(quote).append(space).append(setSortItem.get昇降順().getOrder());
            }
            commaCount++;
        }

        return orderByClause.toRString();
    }

    private static class ReportItemsMap {

        private Map<RString, IReportItems> map;

        public ReportItemsMap(List<IReportItems> items) {
            this.map = new HashMap<>();
            for (IReportItems item : items) {
                this.map.put(item.get項目ID(), item);
            }
            this.map = Collections.unmodifiableMap(map);
        }

        RString getMyBatis項目名(RString 項目ID) throws IllegalArgumentException {
            if (this.map.containsKey(項目ID)) {
                return this.map.get(項目ID).getMyBatis項目名();
            } else {
                throw new IllegalArgumentException(UrErrorMessages.データが存在しない.toString());
            }
        }

        boolean is一時テーブルコラム存在(RString 項目ID) {
            if (this.map.containsKey(項目ID) && !this.map.get(項目ID).getMyBatis項目名().isEmpty()) {
                return true;
            }
            return false;
        }
    }
}
