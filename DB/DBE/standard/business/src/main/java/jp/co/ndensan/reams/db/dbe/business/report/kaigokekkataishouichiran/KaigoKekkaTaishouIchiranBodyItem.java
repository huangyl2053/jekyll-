/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.kaigokekkataishouichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 要介護認定結果通知書対象者一覧表ボディのITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoKekkaTaishouIchiranBodyItem {

    private final RString listKekkatsuchi_2;
    private final RString listKekkatsuchi_3;
    private final RString listKekkatsuchi_4;
    private final RString listKekkatsuchi_5;
    private final RString listKekkatsuchi_6;
    private final RString listKekkatsuchi_7;
    private final RString listKekkatsuchi_8;
    private final RString listKekkatsuchi_9;
    private final RString listKekkatsuchi_10;

    /**
     * インスタンスを生成します。
     *
     * @param listKekkatsuchi_2　審査会番号
     * @param listKekkatsuchi_3　開催年月日
     * @param listKekkatsuchi_4　申請日
     * @param listKekkatsuchi_5　被保険者番号
     * @param listKekkatsuchi_6　氏名
     * @param listKekkatsuchi_7　氏名カナ
     * @param listKekkatsuchi_8　生年月日
     * @param listKekkatsuchi_9　性別
     * @param listKekkatsuchi_10　二次判定結果
     */
    public KaigoKekkaTaishouIchiranBodyItem(
            RString listKekkatsuchi_2,
            RString listKekkatsuchi_3,
            RString listKekkatsuchi_4,
            RString listKekkatsuchi_5,
            RString listKekkatsuchi_6,
            RString listKekkatsuchi_7,
            RString listKekkatsuchi_8,
            RString listKekkatsuchi_9,
            RString listKekkatsuchi_10) {

        this.listKekkatsuchi_2 = listKekkatsuchi_2;
        this.listKekkatsuchi_3 = listKekkatsuchi_3;
        this.listKekkatsuchi_4 = listKekkatsuchi_4;
        this.listKekkatsuchi_5 = listKekkatsuchi_5;
        this.listKekkatsuchi_6 = listKekkatsuchi_6;
        this.listKekkatsuchi_7 = listKekkatsuchi_7;
        this.listKekkatsuchi_8 = listKekkatsuchi_8;
        this.listKekkatsuchi_9 = listKekkatsuchi_9;
        this.listKekkatsuchi_10 = listKekkatsuchi_10;
    }
}
