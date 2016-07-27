/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppoyoshikibesshi;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護事業状況報告月報・一般状況（別紙） のReportSourceクラスです。
 *
 * @reamsid_L DBU-5530-090 dangjingjing
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyohokokuGeppoYoshikiBesshiChange {

    private final RString list_1;
    private final RString list_2;
    private final RString list_3;
    private final RString list_4;

    /**
     *
     * @param list_1 前月末現在の集計結果値
     * @param list_2 当月中増の集計結果値
     * @param list_3 当月中減の集計結果値
     * @param list_4 当月末現在の集計結果値
     */
    public JigyohokokuGeppoYoshikiBesshiChange(RString list_1,
            RString list_2,
            RString list_3,
            RString list_4) {
        this.list_1 = list_1;
        this.list_2 = list_2;
        this.list_3 = list_3;
        this.list_4 = list_4;
    }
}
