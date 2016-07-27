/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppoyoshiki1;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護事業状況報告月報・一般状況（様式1） の一覧項目定義クラスです。
 *
 * @reamsid_L DBU-5530-040 dangjingjing
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyohokokuGeppoYoshiki1Change {

    private final RString list1_1;
    private final RString list1_2;
    private final RString list1_3;
    private final RString list1_4;

    private final RString list2Upper_1;
    private final RString list2Upper_2;
    private final RString list2Upper_3;
    private final RString list2Upper_4;
    private final RString list2Upper_5;
    private final RString list2Upper_6;

    private final RString list2Lower_1;
    private final RString list2Lower_2;
    private final RString list2Lower_3;
    private final RString list2Lower_4;
    private final RString list2Lower_5;
    private final RString list2Lower_6;

    /**
     *
     * @param list1_1 前月末現在
     * @param list1_2 当月中増_計
     * @param list1_3 当月中減_計
     * @param list1_4 当月末現在
     * @param list2Upper_1 転入/転出
     * @param list2Upper_2 職権復活/職権喪失
     * @param list2Upper_3 ６５歳到達/死亡
     * @param list2Upper_4 適用除外非該当/適用除外該当
     * @param list2Upper_5 その他
     * @param list2Upper_6 計
     * @param list2Lower_1 自特例適用/自特例解除
     * @param list2Lower_2 自特例転入
     * @param list2Lower_3 他特例居住/他特例適用
     * @param list2Lower_4 外国人申請/国籍喪失
     * @param list2Lower_5 帰化
     * @param list2Lower_6 左記以外
     *
     */
    public JigyohokokuGeppoYoshiki1Change(RString list1_1,
            RString list1_2,
            RString list1_3,
            RString list1_4,
            RString list2Upper_1,
            RString list2Upper_2,
            RString list2Upper_3,
            RString list2Upper_4,
            RString list2Upper_5,
            RString list2Upper_6,
            RString list2Lower_1,
            RString list2Lower_2,
            RString list2Lower_3,
            RString list2Lower_4,
            RString list2Lower_5,
            RString list2Lower_6) {
        this.list1_1 = list1_1;
        this.list1_2 = list1_2;
        this.list1_3 = list1_3;
        this.list1_4 = list1_4;

        this.list2Lower_1 = list2Lower_1;
        this.list2Lower_2 = list2Lower_2;
        this.list2Lower_3 = list2Lower_3;
        this.list2Lower_4 = list2Lower_4;
        this.list2Lower_5 = list2Lower_5;
        this.list2Lower_6 = list2Lower_6;

        this.list2Upper_1 = list2Upper_1;
        this.list2Upper_2 = list2Upper_2;
        this.list2Upper_3 = list2Upper_3;
        this.list2Upper_4 = list2Upper_4;
        this.list2Upper_5 = list2Upper_5;
        this.list2Upper_6 = list2Upper_6;
    }
}
