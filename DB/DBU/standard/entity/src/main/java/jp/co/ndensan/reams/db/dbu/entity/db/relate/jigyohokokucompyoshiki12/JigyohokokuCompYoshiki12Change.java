/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki12;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護事業状況報告月報・一般状況（様式1-2）の一覧項目定義クラスです。
 *
 * @reamsid_L DBU-5530-050 dongyabin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyohokokuCompYoshiki12Change {

    private final RString list1_1;
    private final RString list1_2;
    private final RString list1_3;
    private final RString list1_4;
    private final RString list1_5;
    private final RString list1_6;
    private final RString list1_7;
    private final RString list1_8;
    private final RString list1_9;
    private final RString list1_10;
    private final RString list1_11;
    private final RString list1_12;
    private final RString list2_1;
    private final RString list3Left_1;
    private final RString list3Left_2;
    private final RString list3Right_1;

    /**
     * コンストラクタです。
     *
     * @param list1_1 介護老人福祉施設_食費
     * @param list1_2 介護老人福祉施設_居住費
     * @param list1_3 介護老人保健施設_食費
     * @param list1_4 介護老人保健施設_居住費
     * @param list1_5 介護療養型医療施設_食費
     * @param list1_6 介護療養型医療施設_居住費
     * @param list1_7 地域密着型介護老人福祉施設入居者生活介護_食費
     * @param list1_8 地域密着型介護老人福祉施設入居者生活介護_居住費
     * @param list1_9 その他_食費
     * @param list1_10 その他_居住費
     * @param list1_11 合計_食費
     * @param list1_12 合計_居住費
     * @param list2_1 利用者負担減額・免除認定表の利用者負担
     * @param list3Left_1 介護老人福祉施設旧措置入所者に係る減額・減免認定表の特定負担限度額_食費
     * @param list3Left_2 介護老人福祉施設旧措置入所者に係る減額・減免認定表の特定負担限度額_居住費
     * @param list3Right_1 介護老人福祉施設旧措置入所者に係る減額・免除認定表の利用者負担
     */
    public JigyohokokuCompYoshiki12Change(RString list1_1,
            RString list1_2,
            RString list1_3,
            RString list1_4,
            RString list1_5,
            RString list1_6,
            RString list1_7,
            RString list1_8,
            RString list1_9,
            RString list1_10,
            RString list1_11,
            RString list1_12,
            RString list2_1,
            RString list3Left_1,
            RString list3Left_2,
            RString list3Right_1) {
        this.list1_1 = list1_1;
        this.list1_2 = list1_2;
        this.list1_3 = list1_3;
        this.list1_4 = list1_4;
        this.list1_5 = list1_5;
        this.list1_6 = list1_6;
        this.list1_7 = list1_7;
        this.list1_8 = list1_8;
        this.list1_9 = list1_9;
        this.list1_10 = list1_10;
        this.list1_11 = list1_11;
        this.list1_12 = list1_12;
        this.list2_1 = list2_1;
        this.list3Left_1 = list3Left_1;
        this.list3Left_2 = list3Left_2;
        this.list3Right_1 = list3Right_1;
    }
}
