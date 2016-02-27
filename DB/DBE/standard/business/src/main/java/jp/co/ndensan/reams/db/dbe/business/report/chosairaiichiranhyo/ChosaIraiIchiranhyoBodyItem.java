/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosairaiichiranhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 認定調査依頼一覧表ボディのITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaIraiIchiranhyoBodyItem {

    private final RString listIchiranhyo_1;
    private final RString listIchiranhyo_2;
    private final RString listIchiranhyo_3;
    private final RString listIchiranhyo_4;
    private final RString listIchiranhyo_5;
    private final RString listIchiranhyo_6;
    private final RString listIchiranhyo_7;
    private final RString listIchiranhyo_8;
    private final RString listIchiranhyo_9;
    private final RString listIchiranhyo_10;
    private final RString listIchiranhyo_11;
    private final RString listIchiranhyo_12;

    /**
     * インスタンスを生成します。
     *
     * @param listIchiranhyo_1 No.
     * @param listIchiranhyo_2 調査員名
     * @param listIchiranhyo_3 被保険者番号
     * @param listIchiranhyo_4 申請日
     * @param listIchiranhyo_5 申請区分
     * @param listIchiranhyo_6 被保険者名
     * @param listIchiranhyo_7 被保険者名(カナ)
     * @param listIchiranhyo_8 性別
     * @param listIchiranhyo_9 生年月日
     * @param listIchiranhyo_10 住所
     * @param listIchiranhyo_11 電話番号
     * @param listIchiranhyo_12 提出期限
     */
    public ChosaIraiIchiranhyoBodyItem(
            RString listIchiranhyo_1,
            RString listIchiranhyo_2,
            RString listIchiranhyo_3,
            RString listIchiranhyo_4,
            RString listIchiranhyo_5,
            RString listIchiranhyo_6,
            RString listIchiranhyo_7,
            RString listIchiranhyo_8,
            RString listIchiranhyo_9,
            RString listIchiranhyo_10,
            RString listIchiranhyo_11,
            RString listIchiranhyo_12) {
        this.listIchiranhyo_1 = listIchiranhyo_1;
        this.listIchiranhyo_2 = listIchiranhyo_2;
        this.listIchiranhyo_3 = listIchiranhyo_3;
        this.listIchiranhyo_4 = listIchiranhyo_4;
        this.listIchiranhyo_5 = listIchiranhyo_5;
        this.listIchiranhyo_6 = listIchiranhyo_6;
        this.listIchiranhyo_7 = listIchiranhyo_7;
        this.listIchiranhyo_8 = listIchiranhyo_8;
        this.listIchiranhyo_9 = listIchiranhyo_9;
        this.listIchiranhyo_10 = listIchiranhyo_10;
        this.listIchiranhyo_11 = listIchiranhyo_11;
        this.listIchiranhyo_12 = listIchiranhyo_12;
    }

}
