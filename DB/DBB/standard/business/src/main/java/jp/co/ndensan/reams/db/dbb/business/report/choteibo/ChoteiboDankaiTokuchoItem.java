/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.choteibo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 調定簿作成帳票段階特徴Item
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChoteiboDankaiTokuchoItem {

    private final RString listTokuchoDankaiBetsu_1;
    private final RString listTokuchoDankaiBetsu_2;
    private final RString listTokuchoDankaiBetsu_3;
    private final RString listTokuchoDankaiBetsu_4;
    private final RString listTokuchoDankaiBetsu_5;
    private final RString listTokuchoDankaiBetsu_6;
    private final RString listTokuchoDankaiBetsu_7;
    private final RString listTokuchoDankaiBetsu_8;
    private final RString listTokuchoDankaiBetsu_9;

    /**
     * コンストラクタです
     *
     * @param listTokuchoDankaiBetsu_1 listTokuchoDankaiBetsu_1
     * @param listTokuchoDankaiBetsu_2 listTokuchoDankaiBetsu_2
     * @param listTokuchoDankaiBetsu_3 listTokuchoDankaiBetsu_3
     * @param listTokuchoDankaiBetsu_4 listTokuchoDankaiBetsu_4
     * @param listTokuchoDankaiBetsu_5 listTokuchoDankaiBetsu_5
     * @param listTokuchoDankaiBetsu_6 listTokuchoDankaiBetsu_6
     * @param listTokuchoDankaiBetsu_7 listTokuchoDankaiBetsu_7
     * @param listTokuchoDankaiBetsu_8 listTokuchoDankaiBetsu_8
     * @param listTokuchoDankaiBetsu_9 listTokuchoDankaiBetsu_9
     */
    public ChoteiboDankaiTokuchoItem(
            RString listTokuchoDankaiBetsu_1,
            RString listTokuchoDankaiBetsu_2,
            RString listTokuchoDankaiBetsu_3,
            RString listTokuchoDankaiBetsu_4,
            RString listTokuchoDankaiBetsu_5,
            RString listTokuchoDankaiBetsu_6,
            RString listTokuchoDankaiBetsu_7,
            RString listTokuchoDankaiBetsu_8,
            RString listTokuchoDankaiBetsu_9) {
        this.listTokuchoDankaiBetsu_1 = listTokuchoDankaiBetsu_1;
        this.listTokuchoDankaiBetsu_2 = listTokuchoDankaiBetsu_2;
        this.listTokuchoDankaiBetsu_3 = listTokuchoDankaiBetsu_3;
        this.listTokuchoDankaiBetsu_4 = listTokuchoDankaiBetsu_4;
        this.listTokuchoDankaiBetsu_5 = listTokuchoDankaiBetsu_5;
        this.listTokuchoDankaiBetsu_6 = listTokuchoDankaiBetsu_6;
        this.listTokuchoDankaiBetsu_7 = listTokuchoDankaiBetsu_7;
        this.listTokuchoDankaiBetsu_8 = listTokuchoDankaiBetsu_8;
        this.listTokuchoDankaiBetsu_9 = listTokuchoDankaiBetsu_9;
    }

}
