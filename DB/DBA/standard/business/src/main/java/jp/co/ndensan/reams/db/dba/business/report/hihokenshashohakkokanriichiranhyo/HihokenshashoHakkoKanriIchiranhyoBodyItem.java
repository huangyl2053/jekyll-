/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.hihokenshashohakkokanriichiranhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 被保険者証発行管理一覧表ボディのITEMです。
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshashoHakkoKanriIchiranhyoBodyItem {

    private final RString listUpper_1;
    private final RString listUpper_2;
    private final RString listUpper_3;
    private final RString listUpper_4;
    private final RString listUpper_5;
    private final RString listUpper_6;
    private final RString listUpper_7;
    private final RString listUpper_8;
    private final RString listLower_1;
    private final RString listLower_2;
    private final RString listLower_3;
    private final RString listLower_4;
    private final RString listLower_5;
    private final RString listLower_6;
    private final RString listLower_7;

    /**
     * インスタンスを生成します。
     *
     * @param listUpper_1 被保険者番号
     * @param listUpper_2 識別コード
     * @param listUpper_3 氏名
     * @param listUpper_4 交付年月日
     * @param listUpper_5 交付事由コード
     * @param listUpper_6 交付事由名称
     * @param listUpper_7 交付事由略称
     * @param listUpper_8 有効期限
     * @param listLower_1 市町村コード
     * @param listLower_2 郵便番号
     * @param listLower_3 住所
     * @param listLower_4 回収年月日
     * @param listLower_5 回収事由コード
     * @param listLower_6 回収事由名称
     * @param listLower_7 様式
     */
    public HihokenshashoHakkoKanriIchiranhyoBodyItem(
            RString listUpper_1,
            RString listUpper_2,
            RString listUpper_3,
            RString listUpper_4,
            RString listUpper_5,
            RString listUpper_6,
            RString listUpper_7,
            RString listUpper_8,
            RString listLower_1,
            RString listLower_2,
            RString listLower_3,
            RString listLower_4,
            RString listLower_5,
            RString listLower_6,
            RString listLower_7) {
        this.listUpper_1 = listUpper_1;
        this.listUpper_2 = listUpper_2;
        this.listUpper_3 = listUpper_3;
        this.listUpper_4 = listUpper_4;
        this.listUpper_5 = listUpper_5;
        this.listUpper_6 = listUpper_6;
        this.listUpper_7 = listUpper_7;
        this.listUpper_8 = listUpper_8;
        this.listLower_1 = listLower_1;
        this.listLower_2 = listLower_2;
        this.listLower_3 = listLower_3;
        this.listLower_4 = listLower_4;
        this.listLower_5 = listLower_5;
        this.listLower_6 = listLower_6;
        this.listLower_7 = listLower_7;

    }
}
