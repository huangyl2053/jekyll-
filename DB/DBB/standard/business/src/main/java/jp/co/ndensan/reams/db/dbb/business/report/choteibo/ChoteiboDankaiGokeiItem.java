/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.choteibo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 調定簿作成帳票段階合計Item
 */
@Getter
public class ChoteiboDankaiGokeiItem {

    private final RString listDankaiBetsuGokei_1;
    private final RString listDankaiBetsuGokei_2;
    private final RString listDankaiBetsuGokei_3;
    private final RString listDankaiBetsuGokei_4;
    private final RString listFuchoGokei_1;
    private final RString listFuchoGokei_2;
    private final RString listFuchoGokei_3;
    private final RString listFuchoGokei_4;
    private final RString listFuchoGokei_5;
    private final RString listFuchoGokei_6;
    private final RString listFuchoGokei_7;
    private final RString listFuchoGokei_8;
    private final RString listFuchoGokei_9;
    private final RString listTokuchoGokei_1;
    private final RString listTokuchoGokei_2;
    private final RString listTokuchoGokei_3;
    private final RString listTokuchoGokei_4;
    private final RString listTokuchoGokei_5;
    private final RString listTokuchoGokei_6;
    private final RString listTokuchoGokei_7;
    private final RString listTokuchoGokei_8;
    private final RString listTokuchoGokei_9;
    private final RString mongon;
    private final RString heichoShaSuKome;
    private final RString fuchoShaSuKome;
    private final RString fuchoTogetsuGakuKome;
    private final RString fuchoTogetsuSuKome;
    private final RString tokuchoTogetsuGakuKome;
    private final RString tokuchoTogetsuSuKome;
    private final RString tokuchoshaShaSuKome;

    /**
     *
     * @param listDankaiBetsuGokei_1 RString
     * @param listDankaiBetsuGokei_2 RString
     * @param listDankaiBetsuGokei_3 RString
     * @param listDankaiBetsuGokei_4 RString
     * @param listFuchoGokei_1 RString
     * @param listFuchoGokei_2 RString
     * @param listFuchoGokei_3 RString
     * @param listFuchoGokei_4 RString
     * @param listFuchoGokei_5 RString
     * @param listFuchoGokei_6 RString
     * @param listFuchoGokei_7 RString
     * @param listFuchoGokei_8 RString
     * @param listFuchoGokei_9 RString
     * @param listTokuchoGokei_1 RString
     * @param listTokuchoGokei_2 RString
     * @param listTokuchoGokei_3 RString
     * @param listTokuchoGokei_4 RString
     * @param listTokuchoGokei_5 RString
     * @param listTokuchoGokei_6 RString
     * @param listTokuchoGokei_7 RString
     * @param listTokuchoGokei_8 RString
     * @param listTokuchoGokei_9 RString
     * @param mongon RString
     * @param heichoShaSuKome RString
     * @param fuchoShaSuKome RString
     * @param fuchoTogetsuGakuKome RString
     * @param fuchoTogetsuSuKome RString
     * @param tokuchoTogetsuGakuKome RString
     * @param tokuchoTogetsuSuKome RString
     * @param tokuchoshaShaSuKome RString
     */
    public ChoteiboDankaiGokeiItem(
            RString listDankaiBetsuGokei_1,
            RString listDankaiBetsuGokei_2,
            RString listDankaiBetsuGokei_3,
            RString listDankaiBetsuGokei_4,
            RString listFuchoGokei_1,
            RString listFuchoGokei_2,
            RString listFuchoGokei_3,
            RString listFuchoGokei_4,
            RString listFuchoGokei_5,
            RString listFuchoGokei_6,
            RString listFuchoGokei_7,
            RString listFuchoGokei_8,
            RString listFuchoGokei_9,
            RString listTokuchoGokei_1,
            RString listTokuchoGokei_2,
            RString listTokuchoGokei_3,
            RString listTokuchoGokei_4,
            RString listTokuchoGokei_5,
            RString listTokuchoGokei_6,
            RString listTokuchoGokei_7,
            RString listTokuchoGokei_8,
            RString listTokuchoGokei_9,
            RString mongon,
            RString heichoShaSuKome,
            RString fuchoShaSuKome,
            RString fuchoTogetsuGakuKome,
            RString fuchoTogetsuSuKome,
            RString tokuchoTogetsuGakuKome,
            RString tokuchoTogetsuSuKome,
            RString tokuchoshaShaSuKome) {
        this.listDankaiBetsuGokei_1 = listDankaiBetsuGokei_1;
        this.listDankaiBetsuGokei_2 = listDankaiBetsuGokei_2;
        this.listDankaiBetsuGokei_3 = listDankaiBetsuGokei_3;
        this.listDankaiBetsuGokei_4 = listDankaiBetsuGokei_4;
        this.listFuchoGokei_1 = listFuchoGokei_1;
        this.listFuchoGokei_2 = listFuchoGokei_2;
        this.listFuchoGokei_3 = listFuchoGokei_3;
        this.listFuchoGokei_4 = listFuchoGokei_4;
        this.listFuchoGokei_5 = listFuchoGokei_5;
        this.listFuchoGokei_6 = listFuchoGokei_6;
        this.listFuchoGokei_7 = listFuchoGokei_7;
        this.listFuchoGokei_8 = listFuchoGokei_8;
        this.listFuchoGokei_9 = listFuchoGokei_9;
        this.listTokuchoGokei_1 = listTokuchoGokei_1;
        this.listTokuchoGokei_2 = listTokuchoGokei_2;
        this.listTokuchoGokei_3 = listTokuchoGokei_3;
        this.listTokuchoGokei_4 = listTokuchoGokei_4;
        this.listTokuchoGokei_5 = listTokuchoGokei_5;
        this.listTokuchoGokei_6 = listTokuchoGokei_6;
        this.listTokuchoGokei_7 = listTokuchoGokei_7;
        this.listTokuchoGokei_8 = listTokuchoGokei_8;
        this.listTokuchoGokei_9 = listTokuchoGokei_9;
        this.mongon = mongon;
        this.heichoShaSuKome = heichoShaSuKome;
        this.fuchoShaSuKome = fuchoShaSuKome;
        this.fuchoTogetsuGakuKome = fuchoTogetsuGakuKome;
        this.fuchoTogetsuSuKome = fuchoTogetsuSuKome;
        this.tokuchoTogetsuGakuKome = tokuchoTogetsuGakuKome;
        this.tokuchoTogetsuSuKome = tokuchoTogetsuSuKome;
        this.tokuchoshaShaSuKome = tokuchoshaShaSuKome;
    }
}
