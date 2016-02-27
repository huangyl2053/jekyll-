/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaiiinwaritsuke;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 介護認定審査会スケジュール表かがみのItemです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsaschedulekagamiItem {

    private final RString hakkoYMD;
    private final RString ninshoshaYakushokuMei;
    private final RString koinShoryaku;
    private final RString denshiKoin;
    private final RString title;
    private final RString tsuchibun1;
    private final RString shoriMikomiKaishiYMD;
    private final RString shoriMikomiShuryoYMD;
    private final RString tsuchibun2;

    /**
     *
     * @param hakkoYMD 印刷日付
     * @param ninshoshaYakushokuMei 首長名
     * @param koinShoryaku 公印省略
     * @param denshiKoin 電子公印
     * @param title タイトル
     * @param tsuchibun1 定型文
     * @param shoriMikomiKaishiYMD 対象期間(開始)
     * @param shoriMikomiShuryoYMD 対象期間(終了)
     * @param tsuchibun2 通知文
     */
    public ShinsaschedulekagamiItem(
            RString hakkoYMD,
            RString ninshoshaYakushokuMei,
            RString koinShoryaku,
            RString denshiKoin,
            RString title,
            RString tsuchibun1,
            RString shoriMikomiKaishiYMD,
            RString shoriMikomiShuryoYMD,
            RString tsuchibun2) {
        this.hakkoYMD = hakkoYMD;
        this.ninshoshaYakushokuMei = ninshoshaYakushokuMei;
        this.koinShoryaku = koinShoryaku;
        this.denshiKoin = denshiKoin;
        this.title = title;
        this.tsuchibun1 = tsuchibun1;
        this.shoriMikomiKaishiYMD = shoriMikomiKaishiYMD;
        this.shoriMikomiShuryoYMD = shoriMikomiShuryoYMD;
        this.tsuchibun2 = tsuchibun2;
    }
}
