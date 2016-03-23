/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.choteibo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 調定簿作成帳票段階合計特徴Item
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChoteiboDankaiGokeiTokuchoItem {

    private final RString listTokuchoGokei_1;
    private final RString listTokuchoGokei_2;
    private final RString listTokuchoGokei_3;
    private final RString listTokuchoGokei_4;
    private final RString listTokuchoGokei_5;
    private final RString listTokuchoGokei_6;
    private final RString listTokuchoGokei_7;
    private final RString listTokuchoGokei_8;
    private final RString listTokuchoGokei_9;
    private final RString tokuchoTogetsuSuKome;
    private final RString tokuchoTogetsuGakuKome;

    /**
     * コンストラクタです。
     *
     * @param listTokuchoGokei_1 listTokuchoGokei_1
     * @param listTokuchoGokei_2 listTokuchoGokei_2
     * @param listTokuchoGokei_3 listTokuchoGokei_3
     * @param listTokuchoGokei_4 listTokuchoGokei_4
     * @param listTokuchoGokei_5 listTokuchoGokei_5
     * @param listTokuchoGokei_6 listTokuchoGokei_6
     * @param listTokuchoGokei_7 listTokuchoGokei_7
     * @param listTokuchoGokei_8 listTokuchoGokei_8
     * @param listTokuchoGokei_9 listTokuchoGokei_9
     * @param tokuchoTogetsuSuKome tokuchoTogetsuSuKome
     * @param tokuchoTogetsuGakuKome tokuchoTogetsuGakuKome
     */
    public ChoteiboDankaiGokeiTokuchoItem(
            RString listTokuchoGokei_1,
            RString listTokuchoGokei_2,
            RString listTokuchoGokei_3,
            RString listTokuchoGokei_4,
            RString listTokuchoGokei_5,
            RString listTokuchoGokei_6,
            RString listTokuchoGokei_7,
            RString listTokuchoGokei_8,
            RString listTokuchoGokei_9,
            RString tokuchoTogetsuSuKome,
            RString tokuchoTogetsuGakuKome) {
        this.listTokuchoGokei_1 = listTokuchoGokei_1;
        this.listTokuchoGokei_2 = listTokuchoGokei_2;
        this.listTokuchoGokei_3 = listTokuchoGokei_3;
        this.listTokuchoGokei_4 = listTokuchoGokei_4;
        this.listTokuchoGokei_5 = listTokuchoGokei_5;
        this.listTokuchoGokei_6 = listTokuchoGokei_6;
        this.listTokuchoGokei_7 = listTokuchoGokei_7;
        this.listTokuchoGokei_8 = listTokuchoGokei_8;
        this.listTokuchoGokei_9 = listTokuchoGokei_9;
        this.tokuchoTogetsuSuKome = tokuchoTogetsuSuKome;
        this.tokuchoTogetsuGakuKome = tokuchoTogetsuGakuKome;
    }

}
