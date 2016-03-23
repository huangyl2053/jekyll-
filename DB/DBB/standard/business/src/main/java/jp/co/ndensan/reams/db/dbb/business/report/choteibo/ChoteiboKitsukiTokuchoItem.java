/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.choteibo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 調定簿作成帳票期月特徴Item
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChoteiboKitsukiTokuchoItem {

    private final RString tokuchoNofuGokei;
    private final RString tokuchoSaishutsuKanfuGaku;
    private final RString tokuchoSaishutsuKanpuSu;
    private final RString listTokuchoKi_1;
    private final RString listTokuchoKi_2;
    private final RString listTokuchoKi_3;
    private final RString listTokuchoKi_4;
    private final RString listTokuchoKi_5;
    private final RString listTokuchoKi_6;
    private final RString listTokuchoNofugaku_1;
    private final RString listTokuchoNofugaku_2;
    private final RString listTokuchoNofugaku_3;
    private final RString listTokuchoNofugaku_4;
    private final RString listTokuchoNofugaku_5;
    private final RString listTokuchoNofugaku_6;
    private final RString listTokuchoTsuki_1;
    private final RString listTokuchoTsuki_2;
    private final RString listTokuchoTsuki_3;
    private final RString listTokuchoTsuki_4;
    private final RString listTokuchoTsuki_5;
    private final RString listTokuchoTsuki_6;

    /**
     * コンストラクタです
     *
     * @param nendoTitle nendoTitle
     * @param tokuchoNofuGokei tokuchoNofuGokei
     * @param tokuchoSaishutsuKanfuGaku tokuchoSaishutsuKanfuGaku
     * @param tokuchoSaishutsuKanpuSu tokuchoSaishutsuKanpuSu
     * @param listTokuchoKi_1 listTokuchoKi_1
     * @param listTokuchoKi_2 listTokuchoKi_2
     * @param listTokuchoKi_3 listTokuchoKi_3
     * @param listTokuchoKi_4 listTokuchoKi_4
     * @param listTokuchoKi_5 listTokuchoKi_5
     * @param listTokuchoKi_6 listTokuchoKi_6
     * @param listTokuchoNofugaku_1 listTokuchoNofugaku_1
     * @param listTokuchoNofugaku_2 listTokuchoNofugaku_2
     * @param listTokuchoNofugaku_3 listTokuchoNofugaku_3
     * @param listTokuchoNofugaku_4 listTokuchoNofugaku_4
     * @param listTokuchoNofugaku_5 listTokuchoNofugaku_5
     * @param listTokuchoNofugaku_6 listTokuchoNofugaku_6
     * @param listTokuchoTsuki_1 listTokuchoTsuki_1
     * @param listTokuchoTsuki_2 listTokuchoTsuki_2
     * @param listTokuchoTsuki_3 listTokuchoTsuki_3
     * @param listTokuchoTsuki_4 listTokuchoTsuki_4
     * @param listTokuchoTsuki_5 listTokuchoTsuki_5
     * @param listTokuchoTsuki_6 listTokuchoTsuki_6
     */
    public ChoteiboKitsukiTokuchoItem(
            RString tokuchoNofuGokei, RString tokuchoSaishutsuKanfuGaku, RString tokuchoSaishutsuKanpuSu,
            RString listTokuchoKi_1, RString listTokuchoKi_2, RString listTokuchoKi_3,
            RString listTokuchoKi_4, RString listTokuchoKi_5, RString listTokuchoKi_6,
            RString listTokuchoNofugaku_1, RString listTokuchoNofugaku_2, RString listTokuchoNofugaku_3,
            RString listTokuchoNofugaku_4, RString listTokuchoNofugaku_5, RString listTokuchoNofugaku_6,
            RString listTokuchoTsuki_1, RString listTokuchoTsuki_2, RString listTokuchoTsuki_3,
            RString listTokuchoTsuki_4, RString listTokuchoTsuki_5, RString listTokuchoTsuki_6) {
        this.tokuchoNofuGokei = tokuchoNofuGokei;
        this.tokuchoSaishutsuKanfuGaku = tokuchoSaishutsuKanfuGaku;
        this.tokuchoSaishutsuKanpuSu = tokuchoSaishutsuKanpuSu;
        this.listTokuchoKi_1 = listTokuchoKi_1;
        this.listTokuchoKi_2 = listTokuchoKi_2;
        this.listTokuchoKi_3 = listTokuchoKi_3;
        this.listTokuchoKi_4 = listTokuchoKi_4;
        this.listTokuchoKi_5 = listTokuchoKi_5;
        this.listTokuchoKi_6 = listTokuchoKi_6;
        this.listTokuchoNofugaku_1 = listTokuchoNofugaku_1;
        this.listTokuchoNofugaku_2 = listTokuchoNofugaku_2;
        this.listTokuchoNofugaku_3 = listTokuchoNofugaku_3;
        this.listTokuchoNofugaku_4 = listTokuchoNofugaku_4;
        this.listTokuchoNofugaku_5 = listTokuchoNofugaku_5;
        this.listTokuchoNofugaku_6 = listTokuchoNofugaku_6;
        this.listTokuchoTsuki_1 = listTokuchoTsuki_1;
        this.listTokuchoTsuki_2 = listTokuchoTsuki_2;
        this.listTokuchoTsuki_3 = listTokuchoTsuki_3;
        this.listTokuchoTsuki_4 = listTokuchoTsuki_4;
        this.listTokuchoTsuki_5 = listTokuchoTsuki_5;
        this.listTokuchoTsuki_6 = listTokuchoTsuki_6;
    }
}
