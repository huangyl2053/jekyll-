/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.mybatisorderbycreator;

import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.core.mybatisorderbycreator.ITableColumnMapping;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * MyBatis内で使用する、出力順指示用のOrderBy句を生成するクラスです。
 *
 * @reamsid_L DBZ-9999-021 duanzhanli
 */
public final class MyBatisOrderByCreator {

    private static RStringBuilder orderByClause;
    private static int commaCount;
    private static final RString SPACE = new RString(" ");
    private static final RString COMMA = new RString(",");
    private static final RString QUOTES = new RString("\"");
    private static final RString POINT = new RString(".");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private MyBatisOrderByCreator() {
    }

    /**
     * MyBatis内で指定するOrderBy句を生成します。
     *
     * @param tableName RString
     * @param outputOrder 出力順
     * @return MyBatis内で指定するOrderBy句
     */
    public static RString createWithOutOrderBy(RString tableName, IOutputOrder outputOrder) {
        if (null == outputOrder) {
            return RString.EMPTY;
        }
        orderByClause = new RStringBuilder("");
        return create(tableName, outputOrder.get設定項目リスト());
    }

    /**
     * MyBatis内で指定するOrderBy句を生成します。
     *
     * @param tableName RString
     * @param outputOrder 出力順
     * @return MyBatis内で指定するOrderBy句
     */
    public static RString createWithOrderBy(RString tableName, IOutputOrder outputOrder) {
        if (null == outputOrder) {
            return RString.EMPTY;
        }
        orderByClause = new RStringBuilder("ORDER BY");
        return create(tableName, outputOrder.get設定項目リスト());
    }

    /**
     * 複数テーブル時、MyBatis内で指定するOrderBy句を生成します。
     *
     * @param <T> {@link ITableColumnMapping}を実装した{@code enum}の型
     * @param table Class<T> {@link ITableColumnMapping}を実装した{@code enum}の{@code class}
     * @param outputOrder 出力順
     * @return MyBatis内で指定するOrderBy句
     */
    public static <T extends Enum<T> & ITableColumnMapping> RString createWithOrderBy(Class<T> table, IOutputOrder outputOrder) {
        if (null == outputOrder) {
            return RString.EMPTY;
        }
        orderByClause = new RStringBuilder("ORDER BY");
        return create(table, outputOrder.get設定項目リスト());
    }

    /**
     * 複数テーブル時、MyBatis内で指定するOrderBy句を生成します。
     *
     * @param <T> {@link ITableColumnMapping}を実装した{@code enum}の型
     * @param table Class<T> {@link ITableColumnMapping}を実装した{@code enum}の{@code class}
     * @param outputOrder 出力順
     * @return MyBatis内で指定するOrderBy句
     */
    public static <T extends Enum<T> & ITableColumnMapping> RString createWithOutOrderBy(Class<T> table, IOutputOrder outputOrder) {
        if (null == outputOrder) {
            return RString.EMPTY;
        }
        orderByClause = new RStringBuilder("");
        return create(table, outputOrder.get設定項目リスト());
    }

    private static RString create(RString tableName, List<ISetSortItem> setSortItems) {
        commaCount = 0;
        if (null == setSortItems || setSortItems.isEmpty()) {
            return RString.EMPTY;
        }
        for (ISetSortItem setSortItem : setSortItems) {
            if (commaCount != 0) {
                orderByClause = orderByClause.append(SPACE).append(COMMA);
            }
            orderByClause = orderByClause.append(SPACE).append(tableName)
                    .append(POINT).append(QUOTES).append(setSortItem.getDB項目名()).append(QUOTES)
                    .append(SPACE).append(setSortItem.get昇降順().getOrder());
            commaCount++;
        }

        return orderByClause.toRString();
    }

    private static <T extends Enum<T> & ITableColumnMapping> RString create(Class<T> table, List<ISetSortItem> setSortItems) {
        if (null == setSortItems || setSortItems.isEmpty()) {
            return RString.EMPTY;
        }
        commaCount = 0;
        ITableColumnMapping mapping = Arrays.<ITableColumnMapping>asList(table.getEnumConstants()).get(0);
        for (ISetSortItem setSortItem : setSortItems) {
            RString tableName = mapping.toValue(setSortItem.getDB項目名()).getTableName();
            if (commaCount != 0) {
                orderByClause = orderByClause.append(SPACE).append(COMMA);
            }
            if (!RString.isNullOrEmpty(tableName)) {
                orderByClause = orderByClause.append(SPACE).append(tableName)
                        .append(POINT).append(QUOTES).append(mapping.toValue(setSortItem.getDB項目名()).getItem()).append(QUOTES)
                        .append(SPACE).append(setSortItem.get昇降順().getOrder());
            } else {
                orderByClause = orderByClause.append(SPACE).append(QUOTES).
                        append(mapping.toValue(setSortItem.getDB項目名()).getItem()).append(QUOTES)
                        .append(SPACE).append(setSortItem.get昇降順().getOrder());
            }

            commaCount++;
        }
        return orderByClause.toRString();
    }

}
