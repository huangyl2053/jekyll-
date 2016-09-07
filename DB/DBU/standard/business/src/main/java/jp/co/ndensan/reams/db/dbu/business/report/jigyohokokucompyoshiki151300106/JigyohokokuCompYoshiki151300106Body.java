/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki151300106;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護事業状況報告年報（様式1-5）の一覧項目定義クラスです。
 *
 * @reamsid_L DBU-5600-150 lishengli
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyohokokuCompYoshiki151300106Body {

    private final RString list1_1;
    private final RString list1_2;
    private final RString list1_3;
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

    /**
     * コンストラクタです。
     *
     * @param list1_1 第1号被保険者
     * @param list1_2 第2号被保険者
     * @param list1_3 合計
     * @param list2_1 要支援１
     * @param list2_2 要支援２
     * @param list2_3 計
     * @param list2_4 経過的要介護
     * @param list2_5 要介護１
     * @param list2_6 要介護２
     * @param list2_7 要介護３
     * @param list2_8 要介護４
     * @param list2_9 要介護５
     * @param list2_10 計
     * @param list2_11 合計
     *
     */
    public JigyohokokuCompYoshiki151300106Body(RString list1_1,
            RString list1_2,
            RString list1_3,
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
            RString list2_11) {
        this.list1_1 = list1_1;
        this.list1_2 = list1_2;
        this.list1_3 = list1_3;
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

    }

}
