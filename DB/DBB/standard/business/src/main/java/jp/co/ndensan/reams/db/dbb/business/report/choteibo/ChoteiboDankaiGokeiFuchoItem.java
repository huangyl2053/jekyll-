/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.choteibo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 調定簿作成帳票段階合計普徴Item
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChoteiboDankaiGokeiFuchoItem {

    private final RString listFuchoGokei_1;
    private final RString listFuchoGokei_2;
    private final RString listFuchoGokei_3;
    private final RString listFuchoGokei_4;
    private final RString listFuchoGokei_5;
    private final RString listFuchoGokei_6;
    private final RString listFuchoGokei_7;
    private final RString listFuchoGokei_8;
    private final RString listFuchoGokei_9;
    private final RString fuchoTogetsuGakuKome;
    private final RString fuchoTogetsuSuKome;

    /**
     * コンストラクタです。
     *
     * @param listFuchoGokei_1 listFuchoGokei_1
     * @param listFuchoGokei_2 listFuchoGokei_2
     * @param listFuchoGokei_3 listFuchoGokei_3
     * @param listFuchoGokei_4 listFuchoGokei_4
     * @param listFuchoGokei_5 listFuchoGokei_5
     * @param listFuchoGokei_6 listFuchoGokei_6
     * @param listFuchoGokei_7 listFuchoGokei_7
     * @param listFuchoGokei_8 listFuchoGokei_8
     * @param listFuchoGokei_9 listFuchoGokei_9
     * @param fuchoTogetsuGakuKome fuchoTogetsuGakuKome
     * @param fuchoTogetsuSuKome fuchoTogetsuSuKome
     */
    public ChoteiboDankaiGokeiFuchoItem(
            RString listFuchoGokei_1,
            RString listFuchoGokei_2,
            RString listFuchoGokei_3,
            RString listFuchoGokei_4,
            RString listFuchoGokei_5,
            RString listFuchoGokei_6,
            RString listFuchoGokei_7,
            RString listFuchoGokei_8,
            RString listFuchoGokei_9,
            RString fuchoTogetsuGakuKome,
            RString fuchoTogetsuSuKome) {
        this.listFuchoGokei_1 = listFuchoGokei_1;
        this.listFuchoGokei_2 = listFuchoGokei_2;
        this.listFuchoGokei_3 = listFuchoGokei_3;
        this.listFuchoGokei_4 = listFuchoGokei_4;
        this.listFuchoGokei_5 = listFuchoGokei_5;
        this.listFuchoGokei_6 = listFuchoGokei_6;
        this.listFuchoGokei_7 = listFuchoGokei_7;
        this.listFuchoGokei_8 = listFuchoGokei_8;
        this.listFuchoGokei_9 = listFuchoGokei_9;
        this.fuchoTogetsuGakuKome = fuchoTogetsuGakuKome;
        this.fuchoTogetsuSuKome = fuchoTogetsuSuKome;
    }
}
