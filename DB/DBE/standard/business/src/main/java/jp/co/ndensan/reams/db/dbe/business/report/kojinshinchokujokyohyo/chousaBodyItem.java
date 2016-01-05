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
public class chousaBodyItem {

    private final RString chosain_1;
    private final RString chosain_2;
    private final RString chosain_3;

    /**
     * インスタンスを生成します。
     *
     * @param chosain_1 今回調査機関名
     * @param chosain_2 今回調査員名
     * @param chosain_3 今回査員名電話番号
     */
    public chousaBodyItem(
            RString chosain_1,
            RString chosain_2,
            RString chosain_3) {
        this.chosain_1 = chosain_1;
        this.chosain_2 = chosain_2;
        this.chosain_3 = chosain_3;
    }
}
