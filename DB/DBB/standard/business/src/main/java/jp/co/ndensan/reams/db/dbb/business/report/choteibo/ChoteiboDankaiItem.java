/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.choteibo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 調定簿作成帳票段階Item
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChoteiboDankaiItem {

    private final RString listDankaiBetsu_1;
    private final RString listDankaiBetsu_2;
    private final RString listDankaiBetsu_3;
    private final RString listDankaiBetsu_4;
    private final ChoteiboDankaiFuchoItem fuChoItem;
    private final ChoteiboDankaiTokuchoItem tokuChoItem;

    /**
     * コンストラクタです
     *
     * @param listDankaiBetsu_1 listDankaiBetsu_1
     * @param listDankaiBetsu_2 listDankaiBetsu_2
     * @param listDankaiBetsu_3 listDankaiBetsu_3
     * @param listDankaiBetsu_4 listDankaiBetsu_4
     * @param fuChoItem fuChoItem
     * @param tokuChoItem tokuChoItem
     */
    public ChoteiboDankaiItem(
            RString listDankaiBetsu_1,
            RString listDankaiBetsu_2,
            RString listDankaiBetsu_3,
            RString listDankaiBetsu_4,
            ChoteiboDankaiFuchoItem fuChoItem,
            ChoteiboDankaiTokuchoItem tokuChoItem) {
        this.listDankaiBetsu_1 = listDankaiBetsu_1;
        this.listDankaiBetsu_2 = listDankaiBetsu_2;
        this.listDankaiBetsu_3 = listDankaiBetsu_3;
        this.listDankaiBetsu_4 = listDankaiBetsu_4;
        this.fuChoItem = fuChoItem;
        this.tokuChoItem = tokuChoItem;
    }
}
