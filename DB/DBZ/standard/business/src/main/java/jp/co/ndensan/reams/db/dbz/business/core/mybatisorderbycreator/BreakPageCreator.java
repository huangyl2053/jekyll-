/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.mybatisorderbycreator;

import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.core.mybatisorderbycreator.IBreakPageColumnMapping;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 改頁指示用のOrderBy句を生成するクラスです。
 *
 * @reamsid_L DBZ-9999-021 duanzhanli
 */
public final class BreakPageCreator {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private BreakPageCreator() {
    }

    /**
     * 改頁項目を生成します。
     *
     * @param <T> {@link IBreakPageColumnMapping}を実装した{@code enum}の型
     * @param table Class<T> {@link IBreakPageColumnMapping}を実装した{@code enum}の{@code class}
     * @param breakPage 改頁
     * @return 改頁項目
     */
    public static <T extends Enum<T> & IBreakPageColumnMapping> RString getBreakPageName(Class<T> table, RString breakPage) {
        List<IBreakPageColumnMapping> mappingList = Arrays.<IBreakPageColumnMapping>asList(table.getEnumConstants());
        for (IBreakPageColumnMapping mapping : mappingList) {
            if (mapping.getItem().equals(breakPage)) {
                return mapping.toValue(breakPage).getBreakPageName();
            }
        }
        return RString.EMPTY;
    }
}
