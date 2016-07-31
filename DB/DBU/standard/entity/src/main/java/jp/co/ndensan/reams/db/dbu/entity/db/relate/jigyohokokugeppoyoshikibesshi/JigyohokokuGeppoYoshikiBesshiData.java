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
 * 介護事業状況報告月報・一般状況（別紙） のパラメータクラスです。
 *
 * @reamsid_L DBU-5530-090 dangjingjing
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyohokokuGeppoYoshikiBesshiData {

    private RString 集計区分;
    private RString 作成日時;
    private RString 集計範囲;
    private RString 保険者番号;
    private RString 保険者名;
    private RString 項目標題列1;
    private RString 項目標題列2;
    private RString 項目標題列3;
    private RString 項目標題列4;
    private RString 前月末現在の集計結果値_1;
    private RString 当月中増の集計結果値_1;
    private RString 当月中減の集計結果値_1;
    private RString 当月末現在の集計結果値_1;

}
