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
 *
 * @reamsid_L DBB-0770-050 zhangrui
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ChoteiboItem {

    private final ChoteiboHeaderItem headerItem;
    private final ChoteiboKitsukiItem kitsukiItem;
    private final List<ChoteiboDankaiItem> dankaiItemList;
    private final ChoteiboDankaiGokeiItem dankaiGokeiItem;

    private ChoteiboItem(
            ChoteiboHeaderItem headerItem,
            ChoteiboKitsukiItem kitsukiItem,
            List<ChoteiboDankaiItem> dankaiItemList,
            ChoteiboDankaiGokeiItem dankaiGokeiItem) {
        this.headerItem = headerItem;
        this.kitsukiItem = kitsukiItem;
        this.dankaiItemList = dankaiItemList;
        this.dankaiGokeiItem = dankaiGokeiItem;
    }

    /**
     * 調定簿作成帳票内容作成
     *
     * @param headerItem ChoteiboHeaderItem
     * @param kitsukiItem ChoteiboKitsukiItem
     * @param dankaiItemList List<ChoteiboDankaiItem>
     * @param dankaiGokeiItem ChoteiboDankaiGokeiItem
     * @return ChoteiboItem
     */
    public static ChoteiboItem createChoteiboItem(
            ChoteiboHeaderItem headerItem,
            ChoteiboKitsukiItem kitsukiItem,
            List<ChoteiboDankaiItem> dankaiItemList,
            ChoteiboDankaiGokeiItem dankaiGokeiItem) {
        return new ChoteiboItem(headerItem, kitsukiItem, dankaiItemList, dankaiGokeiItem);
    }
}
