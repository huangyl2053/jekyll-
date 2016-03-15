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

    private final RString title;
    private final RString shoriMikomiKaishiYMD;
    private final RString shoriMikomiShuryoYMD;
    private final RString denshiKoin;
    private final RString hakkoYMD;
    private final RString koinMojiretsu;
    private final RString koinShoryaku;
    private final RString ninshoshaShimeiKakeru;
    private final RString ninshoshaShimeiKakenai;
    private final RString ninshoshaYakushokuMei;
    private final RString ninshoshaYakushokuMei1;
    private final RString ninshoshaYakushokuMei2;
    private final RString atenaRenban;
    private final RString customerBarCode;
    private final RString yubinNo;
    private final RString jushoText;
    private final RString kikanNameText;
    private final RString shimeiText;
    private final RString meishoFuyo;
    private final RString tsuchibun1;
    private final RString tsuchibun2;

    /**
     * インスタンスを生成します。
     *
     * @param title タイトル
     * @param shoriMikomiKaishiYMD 対象期間(開始)
     * @param shoriMikomiShuryoYMD 対象期間(終了)
     * @param denshiKoin 電子公印
     * @param hakkoYMD 発行年月日
     * @param koinMojiretsu 電子公印文字列
     * @param koinShoryaku 電子公印省略
     * @param ninshoshaShimeiKakeru 認証者氏名公印掛ける
     * @param ninshoshaShimeiKakenai 認証者氏名公印掛けない
     * @param ninshoshaYakushokuMei 認証者役職名
     * @param ninshoshaYakushokuMei1 認証者役職名1行目
     * @param ninshoshaYakushokuMei2 認証者役職名2行目
     * @param atenaRenban 宛名連番
     * @param customerBarCode カスタマーバーコード
     * @param yubinNo 宛名郵便番号
     * @param jushoText 宛名住所
     * @param kikanNameText 宛名機関名
     * @param shimeiText 宛名氏名
     * @param meishoFuyo 宛名名称付与
     * @param tsuchibun1 通知文1
     * @param tsuchibun2 通知文2
     */
    public ShinsaschedulekagamiItem(
            RString title,
            RString shoriMikomiKaishiYMD,
            RString shoriMikomiShuryoYMD,
            RString denshiKoin,
            RString hakkoYMD,
            RString koinMojiretsu,
            RString koinShoryaku,
            RString ninshoshaShimeiKakeru,
            RString ninshoshaShimeiKakenai,
            RString ninshoshaYakushokuMei,
            RString ninshoshaYakushokuMei1,
            RString ninshoshaYakushokuMei2,
            RString atenaRenban,
            RString customerBarCode,
            RString yubinNo,
            RString jushoText,
            RString kikanNameText,
            RString shimeiText,
            RString meishoFuyo,
            RString tsuchibun1,
            RString tsuchibun2
    ) {
        this.title = title;
        this.shoriMikomiKaishiYMD = shoriMikomiKaishiYMD;
        this.shoriMikomiShuryoYMD = shoriMikomiShuryoYMD;
        this.denshiKoin = denshiKoin;
        this.hakkoYMD = hakkoYMD;
        this.koinMojiretsu = koinMojiretsu;
        this.koinShoryaku = koinShoryaku;
        this.ninshoshaShimeiKakeru = ninshoshaShimeiKakeru;
        this.ninshoshaShimeiKakenai = ninshoshaShimeiKakenai;
        this.ninshoshaYakushokuMei = ninshoshaYakushokuMei;
        this.ninshoshaYakushokuMei1 = ninshoshaYakushokuMei1;
        this.ninshoshaYakushokuMei2 = ninshoshaYakushokuMei2;
        this.atenaRenban = atenaRenban;
        this.customerBarCode = customerBarCode;
        this.yubinNo = yubinNo;
        this.jushoText = jushoText;
        this.kikanNameText = kikanNameText;
        this.shimeiText = shimeiText;
        this.meishoFuyo = meishoFuyo;
        this.tsuchibun1 = tsuchibun1;
        this.tsuchibun2 = tsuchibun2;
    }
}
