/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.choteibo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 調定簿作成帳票期月Item
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChoteiboKitsukiItem {

    private final ChoteiboKitsukiTokuchoItem tokuChoItem;
    private final ChoteiboKitsukiFuchoItem fuChoItem;
    private final RString genmenGaku;
    private final RString genmenSu;
    private final RString nofuGakuSokei;
    private final RString nendoTitle;

    /**
     * コンストラクタです
     *
     * @param tokuChoItem tokuChoItem
     * @param fuChoItem fuChoItem
     * @param genmenGaku genmenGaku
     * @param genmenSu genmenSu
     * @param nofuGakuSokei nofuGakuSokei
     * @param nendoTitle nendoTitle
     */
    public ChoteiboKitsukiItem(
            ChoteiboKitsukiTokuchoItem tokuChoItem,
            ChoteiboKitsukiFuchoItem fuChoItem,
            RString genmenGaku,
            RString genmenSu,
            RString nofuGakuSokei,
            RString nendoTitle) {
        this.tokuChoItem = tokuChoItem;
        this.fuChoItem = fuChoItem;
        this.genmenGaku = genmenGaku;
        this.genmenSu = genmenSu;
        this.nofuGakuSokei = nofuGakuSokei;
        this.nendoTitle = nendoTitle;
    }
}
