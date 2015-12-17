/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.dbe5910001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 主治医医療機関・主治医一覧表ボディのITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IkenshoShujiiIchiranBodyItem {

    private final RString listIchiranhyoUpper_1;
    private final RString listIchiranhyoUpper_2;
    private final RString listIchiranhyoUpper_3;
    private final RString listIchiranhyoUpper_4;
    private final RString listIchiranhyoUpper_5;
    private final boolean listIchiranhyoUpper_6;
    private final RString listIchiranhyoUpper_7;
    private final RString listIchiranhyoUpper_8;
    private final RString listIchiranhyoUpper_9;
    private final boolean listIchiranhyoUpper_10;
    private final RString listIchiranhyoLower1_1;
    private final RString listIchiranhyoLower1_2;
    private final RString listIchiranhyoLower1_3;
    private final RString listIchiranhyoLower2_1;
    private final RString listIchiranhyoLower2_2;

    /**
     * インスタンスを生成します。
     *
     * @param listIchiranhyoUpper_1 医療機関ｺｰﾄﾞ
     * @param listIchiranhyoUpper_2 医療機関名称(ｶﾅ)
     * @param listIchiranhyoUpper_3 代表者名(ｶﾅ)
     * @param listIchiranhyoUpper_4 郵便番号
     * @param listIchiranhyoUpper_5 連絡先
     * @param listIchiranhyoUpper_6 医療機関状況
     * @param listIchiranhyoUpper_7 主治医ｺｰﾄﾞ
     * @param listIchiranhyoUpper_8 主治医氏名(ｶﾅ)
     * @param listIchiranhyoUpper_9 性別
     * @param listIchiranhyoUpper_10 主治医状況
     * @param listIchiranhyoLower1_1 医療機関名称
     * @param listIchiranhyoLower1_2 代表者名
     * @param listIchiranhyoLower1_3 住所
     * @param listIchiranhyoLower2_1 主治医氏名
     * @param listIchiranhyoLower2_2 所属名
     */
    public IkenshoShujiiIchiranBodyItem(
            RString listIchiranhyoUpper_1,
            RString listIchiranhyoUpper_2,
            RString listIchiranhyoUpper_3,
            RString listIchiranhyoUpper_4,
            RString listIchiranhyoUpper_5,
            boolean listIchiranhyoUpper_6,
            RString listIchiranhyoUpper_7,
            RString listIchiranhyoUpper_8,
            RString listIchiranhyoUpper_9,
            boolean listIchiranhyoUpper_10,
            RString listIchiranhyoLower1_1,
            RString listIchiranhyoLower1_2,
            RString listIchiranhyoLower1_3,
            RString listIchiranhyoLower2_1,
            RString listIchiranhyoLower2_2) {

        this.listIchiranhyoUpper_1 = listIchiranhyoUpper_1;
        this.listIchiranhyoUpper_2 = listIchiranhyoUpper_2;
        this.listIchiranhyoUpper_3 = listIchiranhyoUpper_3;
        this.listIchiranhyoUpper_4 = listIchiranhyoUpper_4;
        this.listIchiranhyoUpper_5 = listIchiranhyoUpper_5;
        this.listIchiranhyoUpper_6 = listIchiranhyoUpper_6;
        this.listIchiranhyoUpper_7 = listIchiranhyoUpper_7;
        this.listIchiranhyoUpper_8 = listIchiranhyoUpper_8;
        this.listIchiranhyoUpper_9 = listIchiranhyoUpper_9;
        this.listIchiranhyoUpper_10 = listIchiranhyoUpper_10;
        this.listIchiranhyoLower1_1 = listIchiranhyoLower1_1;
        this.listIchiranhyoLower1_2 = listIchiranhyoLower1_2;
        this.listIchiranhyoLower1_3 = listIchiranhyoLower1_3;
        this.listIchiranhyoLower2_1 = listIchiranhyoLower2_1;
        this.listIchiranhyoLower2_2 = listIchiranhyoLower2_2;
    }
}
