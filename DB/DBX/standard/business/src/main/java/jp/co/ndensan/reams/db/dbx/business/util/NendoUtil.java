/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.util;

import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 年度変換共通クラスです。
 */
public class NendoUtil {

    private NendoUtil() {
    }

    private static final int NENDO_START_MONTH = 4;
    private static final int FIRST = 1;

    /**
     * 指定した年度の開始日(4月1日)を返却します。
     *
     * @param fYear 年度
     * @return 指定した年度の開始日(4月1日)
     * @throws NullPointerException 引数が{@code null}の場合
     * @throws IllegalArgumentException 引数の年度が不正な場合
     */
    public static RDate toNendoStartDate(FlexibleYear fYear) {
        Objects.requireNonNull(fYear);
        if (!fYear.isValid()) {
            throw new IllegalArgumentException("指定の年度が不正です。");
        }
        return new RDate(fYear.getYearValue(), NENDO_START_MONTH, FIRST);
    }
}
