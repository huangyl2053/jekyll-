/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsukibetsusuiihyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 月別推移表ボディのITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TsukibetsuSuiihyoBodyItem {

    public final RString list_1;
    public final RString list_2;
    public final RString list_3;
    public final RString list_4;
    public final RString list_5;
    public final RString list_6;
    public final RString list_7;
    public final RString list_8;
    public final RString list_9;
    public final RString list_10;
    public final RString list_11;
    public final RString list_12;
    public final RString list_13;
    public final RString list_14;
    public final RString list_15;
    public final RString list_16;

    /**
     * インスタンスを生成します。
     *
     * @param list_1
     * @param list_2
     * @param list_3
     * @param list_4
     * @param list_5
     * @param list_6
     * @param list_7
     * @param list_8
     * @param list_9
     * @param list_10
     * @param list_11
     * @param list_12
     * @param list_13
     * @param list_14
     * @param list_15
     * @param list_16
     */
    public TsukibetsuSuiihyoBodyItem(
            RString list_1,
            RString list_2,
            RString list_3,
            RString list_4,
            RString list_5,
            RString list_6,
            RString list_7,
            RString list_8,
            RString list_9,
            RString list_10,
            RString list_11,
            RString list_12,
            RString list_13,
            RString list_14,
            RString list_15,
            RString list_16) {
        this.list_1 = list_1;
        this.list_2 = list_2;
        this.list_3 = list_3;
        this.list_4 = list_4;
        this.list_5 = list_5;
        this.list_6 = list_6;
        this.list_7 = list_7;
        this.list_8 = list_8;
        this.list_9 = list_9;
        this.list_10 = list_10;
        this.list_11 = list_11;
        this.list_12 = list_12;
        this.list_13 = list_13;
        this.list_14 = list_14;
        this.list_15 = list_15;
        this.list_16 = list_16;
    }
}
