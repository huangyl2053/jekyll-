/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.choteibo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 調定簿作成帳票段階普徴Item
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChoteiboDankaiFuchoItem {

    private final RString listFuchoDankaiBetsu_1;
    private final RString listFuchoDankaiBetsu_2;
    private final RString listFuchoDankaiBetsu_3;
    private final RString listFuchoDankaiBetsu_4;
    private final RString listFuchoDankaiBetsu_5;
    private final RString listFuchoDankaiBetsu_6;
    private final RString listFuchoDankaiBetsu_7;
    private final RString listFuchoDankaiBetsu_8;
    private final RString listFuchoDankaiBetsu_9;

    /**
     * コンストラクタです
     *
     * @param listFuchoDankaiBetsu_1 listFuchoDankaiBetsu_1
     * @param listFuchoDankaiBetsu_2 listFuchoDankaiBetsu_2
     * @param listFuchoDankaiBetsu_3 listFuchoDankaiBetsu_3
     * @param listFuchoDankaiBetsu_4 listFuchoDankaiBetsu_4
     * @param listFuchoDankaiBetsu_5 listFuchoDankaiBetsu_5
     * @param listFuchoDankaiBetsu_6 listFuchoDankaiBetsu_6
     * @param listFuchoDankaiBetsu_7 listFuchoDankaiBetsu_7
     * @param listFuchoDankaiBetsu_8 listFuchoDankaiBetsu_8
     * @param listFuchoDankaiBetsu_9 listFuchoDankaiBetsu_9
     */
    public ChoteiboDankaiFuchoItem(
            RString listFuchoDankaiBetsu_1,
            RString listFuchoDankaiBetsu_2,
            RString listFuchoDankaiBetsu_3,
            RString listFuchoDankaiBetsu_4,
            RString listFuchoDankaiBetsu_5,
            RString listFuchoDankaiBetsu_6,
            RString listFuchoDankaiBetsu_7,
            RString listFuchoDankaiBetsu_8,
            RString listFuchoDankaiBetsu_9) {
        this.listFuchoDankaiBetsu_1 = listFuchoDankaiBetsu_1;
        this.listFuchoDankaiBetsu_2 = listFuchoDankaiBetsu_2;
        this.listFuchoDankaiBetsu_3 = listFuchoDankaiBetsu_3;
        this.listFuchoDankaiBetsu_4 = listFuchoDankaiBetsu_4;
        this.listFuchoDankaiBetsu_5 = listFuchoDankaiBetsu_5;
        this.listFuchoDankaiBetsu_6 = listFuchoDankaiBetsu_6;
        this.listFuchoDankaiBetsu_7 = listFuchoDankaiBetsu_7;
        this.listFuchoDankaiBetsu_8 = listFuchoDankaiBetsu_8;
        this.listFuchoDankaiBetsu_9 = listFuchoDankaiBetsu_9;
    }

}
