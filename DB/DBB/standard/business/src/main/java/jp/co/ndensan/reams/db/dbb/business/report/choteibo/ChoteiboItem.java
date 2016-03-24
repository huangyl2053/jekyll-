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

    /**
     * 帳票のヘッダ
     */
    private final ChoteiboHeaderItem headerItem;
    /**
     * 帳票の期月データ
     */
    private final ChoteiboKitsukiItem kitsukiItem;
    /**
     * 帳票の段階明細データリスト
     */
    private final List<ChoteiboDankaiItem> dankaiItemList;
    /**
     * 帳票の段階合計データ
     */
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
     * @param headerItem headerItem
     * @param kitsukiItem kitsukiItem
     * @param dankaiItemList dankaiItemList
     * @param dankaiGokeiItem dankaiGokeiItem
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
