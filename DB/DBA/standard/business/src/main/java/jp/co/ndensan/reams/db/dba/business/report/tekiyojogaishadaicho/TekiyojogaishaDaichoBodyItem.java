/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tekiyojogaishadaicho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 適用除外者台帳ボディのITEMクラスです。
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TekiyojogaishaDaichoBodyItem {

    private final RString listNo_1;
    private final RString listUpper_1;
    private final RString listUpper_2;
    private final RString listUpper_3;
    private final RString listUpper_4;
    private final RString listUpper_5;
    private final RString listUpper_6;
    private final RString listUpper_7;
    private final RString listLower_1;
    private final RString listLower_2;
    private final RString listLower_3;
    private final RString listLower_4;
    private final RString listLower_5;
    private final RString listLower_6;
    private final RString listLower_7;

    /**
     * コンストラクタです。
     *
     * @param listNo_1 NO
     * @param listUpper_1 適用年月日
     * @param listUpper_2 適用届出年月日
     * @param listUpper_3 適用除外適用事由コード
     * @param listUpper_4 適用除外適用事由名称
     * @param listUpper_5 解除年月日
     * @param listUpper_6 解除届出年月日
     * @param listUpper_7 適用除外解除事由コード
     * @param listLower_1 適用除外解除事由名称
     * @param listLower_2 入所年月日
     * @param listLower_3 退所年月日
     * @param listLower_4 事業者名称
     * @param listLower_5 事業者住所
     * @param listLower_6 電話番号
     * @param listLower_7 郵便番号
     */
    public TekiyojogaishaDaichoBodyItem(
            RString listNo_1,
            RString listUpper_1,
            RString listUpper_2,
            RString listUpper_3,
            RString listUpper_4,
            RString listUpper_5,
            RString listUpper_6,
            RString listUpper_7,
            RString listLower_1,
            RString listLower_2,
            RString listLower_3,
            RString listLower_4,
            RString listLower_5,
            RString listLower_6,
            RString listLower_7) {
        this.listNo_1 = listNo_1;
        this.listUpper_1 = listUpper_1;
        this.listUpper_2 = listUpper_2;
        this.listUpper_3 = listUpper_3;
        this.listUpper_4 = listUpper_4;
        this.listUpper_5 = listUpper_5;
        this.listUpper_6 = listUpper_6;
        this.listUpper_7 = listUpper_7;
        this.listLower_1 = listLower_1;
        this.listLower_2 = listLower_2;
        this.listLower_3 = listLower_3;
        this.listLower_4 = listLower_4;
        this.listLower_5 = listLower_5;
        this.listLower_6 = listLower_6;
        this.listLower_7 = listLower_7;
    }
}
