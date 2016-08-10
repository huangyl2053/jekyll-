/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki271;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護事業状況報告月報・保険給付決定状況（様式2-7）のchangeです。
 *
 * @reamsid_L DBU-5580-040 wanghuafeng
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyohokokuCompYoshiki271Change {

    private RString listUpper_1;
    private RString listUpper_2;
    private RString listUpper_3;
    private RString listLower_1;
    private RString listLower_2;
    private RString listLower_3;

    /**
     * コンストラクタです。
     *
     * @param listUpper_1 件数（世帯合算）
     * @param listUpper_2 件数（その他）
     * @param listUpper_3 件数（計）
     * @param listLower_1 給付額（世帯合算）
     * @param listLower_2 給付額（その他）
     * @param listLower_3 給付額（計）
     */
    public JigyohokokuCompYoshiki271Change(RString listUpper_1,
            RString listUpper_2,
            RString listUpper_3,
            RString listLower_1,
            RString listLower_2,
            RString listLower_3) {
        this.listUpper_1 = listUpper_1;
        this.listUpper_2 = listUpper_2;
        this.listUpper_3 = listUpper_3;
        this.listLower_1 = listLower_1;
        this.listLower_2 = listLower_2;
        this.listLower_3 = listLower_3;
    }
}
