/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.choteibo;

import java.util.List;
import lombok.Getter;

/**
 * 調定簿作成帳票内容
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ChoteiboItem {

    private final ChoteiboKitsukiItem kitsukiItem;
    private final List<ChoteiboDankaiItem> dankaiItemList;
    private final ChoteiboDankaiGokeiItem dankaiGokeiItem;

    private ChoteiboItem(
            ChoteiboKitsukiItem kitsukiItem,
            List<ChoteiboDankaiItem> dankaiItemList,
            ChoteiboDankaiGokeiItem dankaiGokeiItem) {
        this.kitsukiItem = kitsukiItem;
        this.dankaiItemList = dankaiItemList;
        this.dankaiGokeiItem = dankaiGokeiItem;
    }

    /**
     * 調定簿作成帳票内容作成
     *
     * @param kitsukiItem kitsukiItem
     * @param dankaiItemList dankaiItemList
     * @param dankaiGokeiItem dankaiGokeiItem
     * @return ChoteiboItem
     */
    public static ChoteiboItem createChoteiboItem(
            ChoteiboKitsukiItem kitsukiItem,
            List<ChoteiboDankaiItem> dankaiItemList,
            ChoteiboDankaiGokeiItem dankaiGokeiItem) {
        return new ChoteiboItem(kitsukiItem, dankaiItemList, dankaiGokeiItem);
    }

}
