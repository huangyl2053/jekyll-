/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokugeppoyoshiki212016;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護事業状況報告月報・保険給付決定状況（様式2）の一覧項目定義クラスです。
 *
 * @reamsid_L DBU-5600-100 lishengli
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyohokokuGeppoYoshiki212016BodyData {

    private final RString listList1_1;
    private final RString listList1_2;
    private final RString listList1_3;
    private final RString listList1_4;
    private final RString listList1_5;
    private final RString listList1_6;
    private final RString listList1_7;
    private final RString listList1_8;
    private final RString listList1_9;
    private final RString listList1_10;
    private final RString listList1_11;
    private final RString listList1_12;

    /**
     * コンストラクタです。
     *
     * @param listList1_1 要支援１
     * @param listList1_2 要支援２
     * @param listList1_3 予防計
     * @param listList1_4 非該当
     * @param listList1_5 経過的要介護
     * @param listList1_6 要介護１
     * @param listList1_7 要介護２
     * @param listList1_8 要介護３
     * @param listList1_9 要介護４
     * @param listList1_10 要介護５
     * @param listList1_11 介護計
     * @param listList1_12 合計
     */
    public JigyohokokuGeppoYoshiki212016BodyData(
            RString listList1_1,
            RString listList1_2,
            RString listList1_3,
            RString listList1_4,
            RString listList1_5,
            RString listList1_6,
            RString listList1_7,
            RString listList1_8,
            RString listList1_9,
            RString listList1_10,
            RString listList1_11,
            RString listList1_12) {
        this.listList1_1 = listList1_1;
        this.listList1_2 = listList1_2;
        this.listList1_3 = listList1_3;
        this.listList1_4 = listList1_4;
        this.listList1_5 = listList1_5;
        this.listList1_6 = listList1_6;
        this.listList1_7 = listList1_7;
        this.listList1_8 = listList1_8;
        this.listList1_9 = listList1_9;
        this.listList1_10 = listList1_10;
        this.listList1_11 = listList1_11;
        this.listList1_12 = listList1_12;
    }
}
