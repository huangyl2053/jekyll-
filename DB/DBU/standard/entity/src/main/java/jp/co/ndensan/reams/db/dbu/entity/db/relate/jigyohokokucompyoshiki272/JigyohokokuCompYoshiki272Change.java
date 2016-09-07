/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki272;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護事業状況報告月報・保険給付決定状況（様式2-7）のChangeです。
 *
 * @reamsid_L DBU-5590-050 wanghuafeng
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyohokokuCompYoshiki272Change {

    private final RString listUpper_1;
    private final RString listLower_1;

    /**
     *
     * @param listUpper_1 件数
     * @param listLower_1 給付額
     */
    public JigyohokokuCompYoshiki272Change(RString listUpper_1,
            RString listLower_1) {
        this.listUpper_1 = listUpper_1;
        this.listLower_1 = listLower_1;
    }

}
