/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki152;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護事業状況報告月報・一般状況（様式1-5）_新様式のReportSourceクラスです。
 *
 * @reamsid_L DBU-5540-050 dangjingjing
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyohokokuCompYoshiki152Change {

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
    private final RString list2_2;
    private final RString list2_3;
    private final RString list2_4;
    private final RString list2_5;
    private final RString list2_6;
    private final RString list2_7;
    private final RString list2_8;
    private final RString list2_9;
    private final RString list2_10;
    private final RString list2_11;
    private final RString list2_12;

    /**
     *
     * @param list1_1 居宅介護_要支援1
     * @param list1_2 居宅介護_要支援2
     * @param list1_3 居宅介護_要支援合計
     * @param list1_4 居宅介護_経過的要介護
     * @param list1_5 居宅介護_要介護1
     * @param list1_6 居宅介護_要介護2
     * @param list1_7 居宅介護_要介護3
     * @param list1_8 居宅介護_要介護4
     * @param list1_9 居宅介護_要介護5
     * @param list1_10 居宅介護_要介護合計
     * @param list1_11 居宅介護_サービス受給者数合計
     * @param list1_12 予備
     * @param list2_1 地域密着型_要支援1
     * @param list2_2 地域密着型_要支援2
     * @param list2_3 地域密着型_要支援合計
     * @param list2_4 地域密着型_経過的要介護
     * @param list2_5 地域密着型_要介護1
     * @param list2_6 地域密着型_要介護2
     * @param list2_7 地域密着型_要介護3
     * @param list2_8 地域密着型_要介護4
     * @param list2_9 地域密着型_要介護5
     * @param list2_10 地域密着型_その他
     * @param list2_11 地域密着型_要介護合計
     * @param list2_12 地域密着型_サービス受給者数合計
     */
    public JigyohokokuCompYoshiki152Change(RString list1_1,
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
            RString list2_2,
            RString list2_3,
            RString list2_4,
            RString list2_5,
            RString list2_6,
            RString list2_7,
            RString list2_8,
            RString list2_9,
            RString list2_10,
            RString list2_11,
            RString list2_12) {
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
        this.list2_2 = list2_2;
        this.list2_3 = list2_3;
        this.list2_4 = list2_4;
        this.list2_5 = list2_5;
        this.list2_6 = list2_6;
        this.list2_7 = list2_7;
        this.list2_8 = list2_8;
        this.list2_9 = list2_9;
        this.list2_10 = list2_10;
        this.list2_11 = list2_11;
        this.list2_12 = list2_12;
    }
}
