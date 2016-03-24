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
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChoteiboDankaiGokeiItem {

    private final RString listDankaiBetsuGokei_1;
    private final RString listDankaiBetsuGokei_2;
    private final RString listDankaiBetsuGokei_3;
    private final RString listDankaiBetsuGokei_4;
    private final RString mongon;
    private final RString heichoShaSuKome;
    private final RString fuchoShaSuKome;
    private final RString tokuchoshaShaSuKome;
    private final ChoteiboDankaiGokeiFuchoItem dankaiGokeiFuchoItem;
    private final ChoteiboDankaiGokeiTokuchoItem dankaiGokeiTokuchoItem;

    /**
     * コンストラクタです。
     *
     * @param listDankaiBetsuGokei_1 listDankaiBetsuGokei_1
     * @param listDankaiBetsuGokei_2 listDankaiBetsuGokei_2
     * @param listDankaiBetsuGokei_3 listDankaiBetsuGokei_3
     * @param listDankaiBetsuGokei_4 listDankaiBetsuGokei_4
     * @param mongon mongon
     * @param heichoShaSuKome heichoShaSuKome
     * @param fuchoShaSuKome fuchoShaSuKome
     * @param tokuchoshaShaSuKome tokuchoshaShaSuKome
     * @param dankaiGokeiFuchoItem dankaiGokeiFuchoItem
     * @param dankaiGokeiTokuchoItem dankaiGokeiTokuchoItem
     */
    public ChoteiboDankaiGokeiItem(
            RString listDankaiBetsuGokei_1,
            RString listDankaiBetsuGokei_2,
            RString listDankaiBetsuGokei_3,
            RString listDankaiBetsuGokei_4,
            RString mongon,
            RString heichoShaSuKome,
            RString fuchoShaSuKome,
            RString tokuchoshaShaSuKome,
            ChoteiboDankaiGokeiFuchoItem dankaiGokeiFuchoItem,
            ChoteiboDankaiGokeiTokuchoItem dankaiGokeiTokuchoItem) {
        this.listDankaiBetsuGokei_1 = listDankaiBetsuGokei_1;
        this.listDankaiBetsuGokei_2 = listDankaiBetsuGokei_2;
        this.listDankaiBetsuGokei_3 = listDankaiBetsuGokei_3;
        this.listDankaiBetsuGokei_4 = listDankaiBetsuGokei_4;
        this.mongon = mongon;
        this.heichoShaSuKome = heichoShaSuKome;
        this.fuchoShaSuKome = fuchoShaSuKome;
        this.tokuchoshaShaSuKome = tokuchoshaShaSuKome;
        this.dankaiGokeiFuchoItem = dankaiGokeiFuchoItem;
        this.dankaiGokeiTokuchoItem = dankaiGokeiTokuchoItem;
    }
}
