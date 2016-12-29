/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.syujiyikenshosakuseyiraihakou;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 主治医意見書作成依頼発行一覧表ボディのITEMです。
 *
 * @reamsid_L DBE-0080-100 lizhuoxuan
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SyujiyikenshosakuseyiraihakouBodyItem {

    private final RString listHakkoIchiranhyo_2;
    private final RString listHakkoIchiranhyo_3;
    private final RString listHakkoIchiranhyo_4;
    private final RString listHakkoIchiranhyo_5;
    private final RString listHakkoIchiranhyo_6;
    private final RString listHakkoIchiranhyo_7;
    private final RString listHakkoIchiranhyo_8;
    private final RString listHakkoIchiranhyo_9;
    private final RString listHakkoIchiranhyo_10;
    private final RString listHakkoIchiranhyo_1_1;
    private final RString listHakkoIchiranhyo_1_2;
    private final RString listHakkoIchiranhyo_1_3;
    private final RString listHakkoIchiranhyo_1_4;
    private final RString listHakkoIchiranhyo_1_5;

    /**
     * インスタンスを生成します。
     *
     * @param listHakkoIchiranhyo_2 被保険者番号
     * @param listHakkoIchiranhyo_3 被保険者氏名
     * @param listHakkoIchiranhyo_4 依頼日
     * @param listHakkoIchiranhyo_5 医療機関名称
     * @param listHakkoIchiranhyo_6 代表者名
     * @param listHakkoIchiranhyo_7 連絡先
     * @param listHakkoIchiranhyo_8 主治医名
     * @param listHakkoIchiranhyo_9 未発行理由
     * @param listHakkoIchiranhyo_10 未発行理由
     * @param listHakkoIchiranhyo_1_1 依頼書作成日
     * @param listHakkoIchiranhyo_1_2 依頼書提出期限
     * @param listHakkoIchiranhyo_1_3 市町村コード
     * @param listHakkoIchiranhyo_1_4 市町村名称
     * @param listHakkoIchiranhyo_1_5 証記載保険者番号
     */
    public SyujiyikenshosakuseyiraihakouBodyItem(
            RString listHakkoIchiranhyo_2,
            RString listHakkoIchiranhyo_3,
            RString listHakkoIchiranhyo_4,
            RString listHakkoIchiranhyo_5,
            RString listHakkoIchiranhyo_6,
            RString listHakkoIchiranhyo_7,
            RString listHakkoIchiranhyo_8,
            RString listHakkoIchiranhyo_9,
            RString listHakkoIchiranhyo_10,
            RString listHakkoIchiranhyo_1_1,
            RString listHakkoIchiranhyo_1_2,
            RString listHakkoIchiranhyo_1_3,
            RString listHakkoIchiranhyo_1_4,
            RString listHakkoIchiranhyo_1_5) {

        this.listHakkoIchiranhyo_2 = listHakkoIchiranhyo_2;
        this.listHakkoIchiranhyo_3 = listHakkoIchiranhyo_3;
        this.listHakkoIchiranhyo_4 = listHakkoIchiranhyo_4;
        this.listHakkoIchiranhyo_5 = listHakkoIchiranhyo_5;
        this.listHakkoIchiranhyo_6 = listHakkoIchiranhyo_6;
        this.listHakkoIchiranhyo_7 = listHakkoIchiranhyo_7;
        this.listHakkoIchiranhyo_8 = listHakkoIchiranhyo_8;
        this.listHakkoIchiranhyo_9 = listHakkoIchiranhyo_9;
        this.listHakkoIchiranhyo_10 = listHakkoIchiranhyo_10;
        this.listHakkoIchiranhyo_1_1 = listHakkoIchiranhyo_1_1;
        this.listHakkoIchiranhyo_1_2 = listHakkoIchiranhyo_1_2;
        this.listHakkoIchiranhyo_1_3 = listHakkoIchiranhyo_1_3;
        this.listHakkoIchiranhyo_1_4 = listHakkoIchiranhyo_1_4;
        this.listHakkoIchiranhyo_1_5 = listHakkoIchiranhyo_1_5;
    }
}
