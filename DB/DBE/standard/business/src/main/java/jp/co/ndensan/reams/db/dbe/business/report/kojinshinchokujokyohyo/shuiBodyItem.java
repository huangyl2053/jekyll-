/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.kojinshinchokujokyohyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 要介護認定個人進捗状況票のITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class shuiBodyItem {

    private final RString listShujii_1;
    private final RString listShujii_2;
    private final RString listShujii_3;

    /**
     * インスタンスを生成します。
     *
     * @param listShujii_1 今回医療機関名称
     * @param listShujii_2 今回主治医名
     * @param listShujii_3 今回主治医電話番号
     */
    public shuiBodyItem(
            RString listShujii_1,
            RString listShujii_2,
            RString listShujii_3) {
        this.listShujii_1 = listShujii_1;
        this.listShujii_2 = listShujii_2;
        this.listShujii_3 = listShujii_3;
    }
}
