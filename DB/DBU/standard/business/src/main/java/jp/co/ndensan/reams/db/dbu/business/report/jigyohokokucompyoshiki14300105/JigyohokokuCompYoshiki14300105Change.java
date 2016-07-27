/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki14300105;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護事業状況報告年報（様式1-4）の一覧項目定義クラスです。
 *
 * @reamsid_L DBU-5600-140 lishengli
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyohokokuCompYoshiki14300105Change {

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
     * @param list_1 介護老人福祉施設_食費
     * @param list_2 介護老人福祉施設_居住費
     * @param list_3 介護老人保健施設_食費
     * @param list_4 介護老人保健施設_居住費
     * @param list_5 介護療養型医療施設_食費
     * @param list_6 介護療養型医療施設_居住費
     * @param list_7 地域密着型介護老人福祉施設入居者生活介護_食費
     * @param list_8 地域密着型介護老人福祉施設入居者生活介護_居住費
     * @param list_9 その他_食費
     * @param list_10 その他_居住費
     * @param list_11 合計_食費
     * @param list_12 合計_居住費
     */
    public JigyohokokuCompYoshiki14300105Change(RString list_1,
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
