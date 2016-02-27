/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosairaiichiranhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 認定調査依頼一覧表ヘッダのITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaIraiIchiranhyoHeadItem {

    private final RString hakkoYMD;
    private final RString denshiKoin;
    private final RString ninshoshaYakushokuMei;
    private final RString ninshoshaYakushokuMei2;
    private final RString ninshoshaYakushokuMei1;
    private final RString ninshoshaShimeiKakenai;
    private final RString ninshoshaShimeiKakeru;
    private final RString koinMojiretsu;
    private final RString koinShoryaku;
    private final RString yubinNo1;
    private final RString jushoText;
    private final RString kikanNameText;
    private final RString shimeiText;
    private final RString meishoFuyo;
    private final RString jigyoshaNo;
    private final RString tsuchibun1;
    private final RString tsuchibun2;

    /**
     * インスタンスを生成します。
     *
     * @param hakkoYMD 発行YMD
     * @param denshiKoin 電子公印
     * @param ninshoshaYakushokuMei 認証者役職名
     * @param ninshoshaYakushokuMei2 認証者役職名2行目
     * @param ninshoshaYakushokuMei1 認証者役職名1行目
     * @param ninshoshaShimeiKakenai 認証者氏名公印掛けない
     * @param ninshoshaShimeiKakeru 認証者氏名公印掛ける
     * @param koinMojiretsu 電子公印文字列
     * @param koinShoryaku 電子公印省略
     * @param yubinNo1 宛名郵便番号
     * @param jushoText 宛名住所
     * @param kikanNameText 宛名機関名
     * @param shimeiText 宛名氏名
     * @param meishoFuyo 宛名名称付与
     * @param jigyoshaNo 事業所の番号
     * @param tsuchibun1 通知文1
     * @param tsuchibun2 通知文2
     */
    public ChosaIraiIchiranhyoHeadItem(
            RString hakkoYMD,
            RString denshiKoin,
            RString ninshoshaYakushokuMei,
            RString ninshoshaYakushokuMei2,
            RString ninshoshaYakushokuMei1,
            RString ninshoshaShimeiKakenai,
            RString ninshoshaShimeiKakeru,
            RString koinMojiretsu,
            RString koinShoryaku,
            RString yubinNo1,
            RString jushoText,
            RString kikanNameText,
            RString shimeiText,
            RString meishoFuyo,
            RString jigyoshaNo,
            RString tsuchibun1,
            RString tsuchibun2) {
        this.hakkoYMD = hakkoYMD;
        this.denshiKoin = denshiKoin;
        this.ninshoshaYakushokuMei = ninshoshaYakushokuMei;
        this.ninshoshaYakushokuMei2 = ninshoshaYakushokuMei2;
        this.ninshoshaYakushokuMei1 = ninshoshaYakushokuMei1;
        this.ninshoshaShimeiKakenai = ninshoshaShimeiKakenai;
        this.ninshoshaShimeiKakeru = ninshoshaShimeiKakeru;
        this.koinMojiretsu = koinMojiretsu;
        this.koinShoryaku = koinShoryaku;
        this.yubinNo1 = yubinNo1;
        this.jushoText = jushoText;
        this.kikanNameText = kikanNameText;
        this.shimeiText = shimeiText;
        this.meishoFuyo = meishoFuyo;
        this.jigyoshaNo = jigyoshaNo;
        this.tsuchibun1 = tsuchibun1;
        this.tsuchibun2 = tsuchibun2;
    }
}
