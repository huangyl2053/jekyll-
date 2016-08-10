/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki153300007;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 介護事業状況報告年報・一般状況（様式1-5）の一覧項目定義クラスです。
 *
 * @reamsid_L DBU-5600-170 wangrenze
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyohokokuCompYoshiki15307BodyData {

    private final RString listList_1;
    private final RString listList_2;
    private final RString listList_3;
    private final RString listList_4;
    private final RString listList_5;
    private final RString listList_6;
    private final RString listList_7;
    private final RString listList_8;
    private final RString listList_9;
    private final RString listList_10;
    private final RString listList_11;
    private final RString listList_12;

    /**
     *
     * @param listList_1 要支援１
     * @param listList_2 要支援２
     * @param listList_3 要支援計
     * @param listList_4 経過的要介護
     * @param listList_5 要介護１
     * @param listList_6 要介護２
     * @param listList_7 要介護３
     * @param listList_8 要介護４
     * @param listList_9 要介護５
     * @param listList_10 その他
     * @param listList_11 要介護計
     * @param listList_12 合計
     */
    public JigyohokokuCompYoshiki15307BodyData(
            RString listList_1,
            RString listList_2,
            RString listList_3,
            RString listList_4,
            RString listList_5,
            RString listList_6,
            RString listList_7,
            RString listList_8,
            RString listList_9,
            RString listList_10,
            RString listList_11,
            RString listList_12) {
        this.listList_1 = listList_1;
        this.listList_2 = listList_2;
        this.listList_3 = listList_3;
        this.listList_4 = listList_4;
        this.listList_5 = listList_5;
        this.listList_6 = listList_6;
        this.listList_7 = listList_7;
        this.listList_8 = listList_8;
        this.listList_9 = listList_9;
        this.listList_10 = listList_10;
        this.listList_11 = listList_11;
        this.listList_12 = listList_12;
    }
}
