/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki153;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護事業状況報告月報・一般状況（様式1-5）_新様式 のReportSourceクラスです。
 *
 * @reamsid_L DBU-5540-060 dangjingjing
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyohokokuCompYoshiki153Change {

    private final RString list_1;
    private final RString list_2;
    private final RString list_3;
    private final RString list_4;
    private final RString list_5;
    private final RString list_6;
    private final RString list_7;
    private final RString list_8;
    private final RString list_9;
    private final RString list_10;
    private final RString list_11;
    private final RString list_12;

    /**
     * コンストラクタです。
     *
     *
     * @param list_1 要支援1
     * @param list_2 要支援2
     * @param list_3 要支援合計
     * @param list_4 経過的要介護
     * @param list_5 要介護1
     * @param list_6 要介護2
     * @param list_7 要介護3
     * @param list_8 要介護4
     * @param list_9 要介護5
     * @param list_10 その他
     * @param list_11 要介護合計
     * @param list_12 サービス受給者数合計
     */
    public JigyohokokuCompYoshiki153Change(RString list_1,
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
            RString list_12) {
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
    }

}
