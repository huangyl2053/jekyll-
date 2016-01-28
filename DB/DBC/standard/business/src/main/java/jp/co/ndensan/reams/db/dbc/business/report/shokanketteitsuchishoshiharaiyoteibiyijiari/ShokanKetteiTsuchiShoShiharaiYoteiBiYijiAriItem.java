/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishoshiharaiyoteibiyijiari;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 償還払い支給（不支給）決定通知書(支払予定日あり）のITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem {

    private final RString bunshoNo;
    private final RString title;
    private final RString title2_1;
    private final RString title2_2_1;
    private final RString title2_2_2;
    private final RString title2_3_1;
    private final RString title2_3_2;
    private final RString title2_4;
    private final RString tsuchibun1;
    private final RString hihokenshaName;
    private final RString hihokenshaNo1;
    private final RString hihokenshaNo2;
    private final RString hihokenshaNo3;
    private final RString hihokenshaNo4;
    private final RString hihokenshaNo5;
    private final RString hihokenshaNo6;
    private final RString hihokenshaNo7;
    private final RString hihokenshaNo8;
    private final RString hihokenshaNo9;
    private final RString hihokenshaNo10;
    private final RString uketsukeYMD;
    private final RString ketteiYMD;
    private final RString honninShiharaiGaku;
    private final RString taishoYM;
    private final RString kyufuShu1;
    private final RString kyufuShu2;
    private final RString kyufuShu3;
    private final RString kekka;
    private final RString shikyuGaku;
    private final RString riyuTitle;
    private final RString riyu1;
    private final RString riyu2;
    private final RString riyu3;
    private final RString torikeshi1;
    private final RString torikeshi2;
    private final RString mochimono1;
    private final RString bankName;
    private final RString torikeshiMochimono1;
    private final RString branchBankName;
    private final RString mochimono2;
    private final RString torikeshiMochimono2;
    private final RString mochimono3;
    private final RString shiharaiBasho;
    private final RString torikeshiShiharaibasho;
    private final RString shumokuTitle;
    private final RString kouzaShu;
    private final RString bangoTitle;
    private final RString kouzaNo;
    private final RString kouzaMeigi;
    private final RString shiharaiStartYMD;
    private final RString torikeshiShiharaikikan;
    private final RString shiharaiEndYMD;
    private final RString karaFugo;
    private final RString shiharaiStartHMS;
    private final RString shiharaiEndHMS;
    private final RString sihaYoYmd;
    private final RString tsuchibun２;
    private final RString seirino;
    private final RString tsuchino;
    private final RString remban;
    private final RString tsuchibunLarge;
    private final RString tsuchibunMix1;
    private final RString tsuchibunMix2;
    private final RString tsuchibunMixtwo1;
    private final RString tsuchibunMixtwo2;
    private final RString hakkoYMD;
    private final RString denshiKoin;
    private final RString ninshoshaYakushokuMei;
    private final RString ninshoshaYakushokuMei1;
    private final RString koinMojiretsu;
    private final RString ninshoshaYakushokuMei2;
    private final RString ninshoshaShimeiKakenai;
    private final RString ninshoshaShimeiKakeru;
    private final RString koinShoryaku;
    private final RString yubinNo;
    private final RString gyoseiku2;
    private final RString jusho4;
    private final RString jushoText;
    private final RString jusho5;
    private final RString jusho6;
    private final RString katagakiText;
    private final RString katagaki3;
    private final RString katagakiSmall2;
    private final RString katagaki4;
    private final RString katagakiSmall1;
    private final RString shimei5;
    private final RString shimeiSmall2;
    private final RString shimeiText;
    private final RString meishoFuyo2;
    private final RString shimeiSmall1;
    private final RString dainoKubunMei;
    private final RString shimei6;
    private final RString meishoFuyo1;
    private final RString samabunShimeiText;
    private final RString kakkoLeft2;
    private final RString samabunShimei2;
    private final RString samabunShimeiSmall2;
    private final RString samaBun2;
    private final RString kakkoRight2;
    private final RString kakkoLeft1;
    private final RString samabunShimei1;
    private final RString samaBun1;
    private final RString kakkoRight1;
    private final RString samabunShimeiSmall1;
    private final RString customerBarCode;

    /**
     * インスタンスを生成します。
     *
     * @param bunshoNo 文章番号
     * @param title タイトル
     * @param title2_1 タイトル2_1
     * @param title2_2_1 タイトル2_2_1
     * @param title2_2_2 タイトル2_2_2
     * @param title2_3_1 タイトル2_3_1
     * @param title2_3_2 タイトル2_3_2
     * @param title2_4 タイトル2_4
     * @param tsuchibun1 通知文1
     * @param hihokenshaName 被保険者氏名
     * @param hihokenshaNo1 被保険者番号1
     * @param hihokenshaNo2 被保険者番号2
     * @param hihokenshaNo3 被保険者番号3
     * @param hihokenshaNo4 被保険者番号4
     * @param hihokenshaNo5 被保険者番号5
     * @param hihokenshaNo6 被保険者番号6
     * @param hihokenshaNo7 被保険者番号7
     * @param hihokenshaNo8 被保険者番号8
     * @param hihokenshaNo9 被保険者番号9
     * @param hihokenshaNo10 被保険者番号10
     * @param uketsukeYMD 受付年月日
     * @param ketteiYMD 決定年月日
     * @param honninShiharaiGaku 本人支払額
     * @param taishoYM 対象年月
     * @param kyufuShu1 給付の種類１
     * @param kyufuShu2 給付の種類２
     * @param kyufuShu3 給付の種類３
     * @param kekka 支給結果
     * @param shikyuGaku 支給金額
     * @param riyuTitle 増減の理由1
     * @param riyu1 増減の理由タイトル
     * @param riyu2 増減の理由2
     * @param riyu3 増減の理由3
     * @param torikeshi1 取消1
     * @param torikeshi2 取消2
     * @param mochimono1 金融機関名
     * @param bankName もちもの１
     * @param torikeshiMochimono1 取消もちもの1
     * @param branchBankName 支店名
     * @param mochimono2 もちもの２
     * @param torikeshiMochimono2 取消もちもの2
     * @param mochimono3 もちもの３
     * @param shiharaiBasho 支払場所
     * @param torikeshiShiharaibasho 取消支払場所
     * @param shumokuTitle 種別タイトル
     * @param kouzaShu 口座種別
     * @param bangoTitle 番号タイトル
     * @param kouzaNo 口座番号
     * @param kouzaMeigi 支払期間開始年月日
     * @param shiharaiStartYMD 口座名義
     * @param torikeshiShiharaikikan 取消支払期間
     * @param shiharaiEndYMD 支払期間終了年月日
     * @param karaFugo ~
     * @param shiharaiStartHMS 支払窓口開始時間
     * @param shiharaiEndHMS 支払窓口終了時間
     * @param sihaYoYmd 支払予定日
     * @param tsuchibun２ 通知文２
     * @param seirino 整理番号
     * @param tsuchino 通知番号
     * @param remban 連番
     * @param tsuchibunLarge 通知文3大
     * @param tsuchibunMix1 通知文4（上小）
     * @param tsuchibunMix2 通知文5（下大）
     * @param tsuchibunMixtwo1 通知文6（上大）
     * @param tsuchibunMixtwo2 通知文7（下小）
     * @param hakkoYMD 発行日
     * @param denshiKoin 電子公印
     * @param ninshoshaYakushokuMei 認証者役職名
     * @param ninshoshaYakushokuMei1 認証者役職名1
     * @param koinMojiretsu 公印文字列
     * @param ninshoshaYakushokuMei2 認証者役職名2
     * @param ninshoshaShimeiKakenai 認証者氏名掛けない
     * @param ninshoshaShimeiKakeru 認証者氏名掛ける
     * @param koinShoryaku 公印省略
     * @param yubinNo 郵便番号
     * @param gyoseiku2 行政区2
     * @param jusho4 住所4
     * @param jushoText 住所
     * @param jusho5 住所5
     * @param jusho6 住所6
     * @param katagakiText 方書
     * @param katagaki3 方書3
     * @param katagakiSmall2 方書小2
     * @param katagaki4 方書4
     * @param katagakiSmall1 方書小1
     * @param shimei5 氏名5
     * @param shimeiSmall2 氏名小2
     * @param shimeiText 氏名
     * @param meishoFuyo2 名称付与2
     * @param shimeiSmall1 氏名小1
     * @param dainoKubunMei 代納人区分
     * @param shimei6 氏名6
     * @param meishoFuyo1 名称付与1
     * @param samabunShimeiText 様文氏名
     * @param kakkoLeft2 様文2
     * @param samabunShimei2 左括弧2
     * @param samabunShimeiSmall2 様文氏名2
     * @param samaBun2 様文氏名小2
     * @param kakkoRight2 右括弧2
     * @param kakkoLeft1 左括弧1
     * @param samabunShimei1 様文氏名1
     * @param samaBun1 様文1
     * @param kakkoRight1 右括弧1
     * @param samabunShimeiSmall1 様文氏名小1
     * @param customerBarCode カスタマーバーコード
     */
    public ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem(RString bunshoNo, RString title, RString title2_1, RString title2_2_1,
            RString title2_2_2, RString title2_3_1, RString title2_3_2, RString title2_4, RString tsuchibun1, RString hihokenshaName,
            RString hihokenshaNo1, RString hihokenshaNo2, RString hihokenshaNo3, RString hihokenshaNo4, RString hihokenshaNo5,
            RString hihokenshaNo6, RString hihokenshaNo7, RString hihokenshaNo8, RString hihokenshaNo9, RString hihokenshaNo10,
            RString uketsukeYMD, RString ketteiYMD, RString honninShiharaiGaku, RString taishoYM, RString kyufuShu1, RString kyufuShu2,
            RString kyufuShu3, RString kekka, RString shikyuGaku, RString riyuTitle, RString riyu1, RString riyu2, RString riyu3,
            RString torikeshi1, RString torikeshi2, RString mochimono1, RString bankName, RString torikeshiMochimono1,
            RString branchBankName, RString mochimono2, RString torikeshiMochimono2, RString mochimono3, RString shiharaiBasho,
            RString torikeshiShiharaibasho, RString shumokuTitle, RString kouzaShu, RString bangoTitle, RString kouzaNo,
            RString kouzaMeigi, RString shiharaiStartYMD, RString torikeshiShiharaikikan, RString shiharaiEndYMD, RString karaFugo,
            RString shiharaiStartHMS, RString shiharaiEndHMS, RString sihaYoYmd, RString tsuchibun２, RString seirino, RString tsuchino,
            RString remban, RString tsuchibunLarge, RString tsuchibunMix1, RString tsuchibunMix2, RString tsuchibunMixtwo1,
            RString tsuchibunMixtwo2, RString hakkoYMD, RString denshiKoin, RString ninshoshaYakushokuMei, RString ninshoshaYakushokuMei1,
            RString koinMojiretsu, RString ninshoshaYakushokuMei2, RString ninshoshaShimeiKakenai, RString ninshoshaShimeiKakeru,
            RString koinShoryaku, RString yubinNo, RString gyoseiku2, RString jusho4, RString jushoText, RString jusho5, RString jusho6,
            RString katagakiText, RString katagaki3, RString katagakiSmall2, RString katagaki4, RString katagakiSmall1, RString shimei5,
            RString shimeiSmall2, RString shimeiText, RString meishoFuyo2, RString shimeiSmall1, RString dainoKubunMei, RString shimei6,
            RString meishoFuyo1, RString samabunShimeiText, RString kakkoLeft2, RString samabunShimei2, RString samabunShimeiSmall2,
            RString samaBun2, RString kakkoRight2, RString kakkoLeft1, RString samabunShimei1, RString samaBun1, RString kakkoRight1,
            RString samabunShimeiSmall1, RString customerBarCode) {
        this.bunshoNo = bunshoNo;
        this.title = title;
        this.title2_1 = title2_1;
        this.title2_2_1 = title2_2_1;
        this.title2_2_2 = title2_2_2;
        this.title2_3_1 = title2_3_1;
        this.title2_3_2 = title2_3_2;
        this.title2_4 = title2_4;
        this.tsuchibun1 = tsuchibun1;
        this.hihokenshaName = hihokenshaName;
        this.hihokenshaNo1 = hihokenshaNo1;
        this.hihokenshaNo2 = hihokenshaNo2;
        this.hihokenshaNo3 = hihokenshaNo3;
        this.hihokenshaNo4 = hihokenshaNo4;
        this.hihokenshaNo5 = hihokenshaNo5;
        this.hihokenshaNo6 = hihokenshaNo6;
        this.hihokenshaNo7 = hihokenshaNo7;
        this.hihokenshaNo8 = hihokenshaNo8;
        this.hihokenshaNo9 = hihokenshaNo9;
        this.hihokenshaNo10 = hihokenshaNo10;
        this.uketsukeYMD = uketsukeYMD;
        this.ketteiYMD = ketteiYMD;
        this.honninShiharaiGaku = honninShiharaiGaku;
        this.taishoYM = taishoYM;
        this.kyufuShu1 = kyufuShu1;
        this.kyufuShu2 = kyufuShu2;
        this.kyufuShu3 = kyufuShu3;
        this.kekka = kekka;
        this.shikyuGaku = shikyuGaku;
        this.riyuTitle = riyuTitle;
        this.riyu1 = riyu1;
        this.riyu2 = riyu2;
        this.riyu3 = riyu3;
        this.torikeshi1 = torikeshi1;
        this.torikeshi2 = torikeshi2;
        this.mochimono1 = mochimono1;
        this.bankName = bankName;
        this.torikeshiMochimono1 = torikeshiMochimono1;
        this.branchBankName = branchBankName;
        this.mochimono2 = mochimono2;
        this.torikeshiMochimono2 = torikeshiMochimono2;
        this.mochimono3 = mochimono3;
        this.shiharaiBasho = shiharaiBasho;
        this.torikeshiShiharaibasho = torikeshiShiharaibasho;
        this.shumokuTitle = shumokuTitle;
        this.kouzaShu = kouzaShu;
        this.bangoTitle = bangoTitle;
        this.kouzaNo = kouzaNo;
        this.kouzaMeigi = kouzaMeigi;
        this.shiharaiStartYMD = shiharaiStartYMD;
        this.torikeshiShiharaikikan = torikeshiShiharaikikan;
        this.shiharaiEndYMD = shiharaiEndYMD;
        this.karaFugo = karaFugo;
        this.shiharaiStartHMS = shiharaiStartHMS;
        this.shiharaiEndHMS = shiharaiEndHMS;
        this.sihaYoYmd = sihaYoYmd;
        this.tsuchibun２ = tsuchibun２;
        this.seirino = seirino;
        this.tsuchino = tsuchino;
        this.remban = remban;
        this.tsuchibunLarge = tsuchibunLarge;
        this.tsuchibunMix1 = tsuchibunMix1;
        this.tsuchibunMix2 = tsuchibunMix2;
        this.tsuchibunMixtwo1 = tsuchibunMixtwo1;
        this.tsuchibunMixtwo2 = tsuchibunMixtwo2;
        this.hakkoYMD = hakkoYMD;
        this.denshiKoin = denshiKoin;
        this.ninshoshaYakushokuMei = ninshoshaYakushokuMei;
        this.ninshoshaYakushokuMei1 = ninshoshaYakushokuMei1;
        this.koinMojiretsu = koinMojiretsu;
        this.ninshoshaYakushokuMei2 = ninshoshaYakushokuMei2;
        this.ninshoshaShimeiKakenai = ninshoshaShimeiKakenai;
        this.ninshoshaShimeiKakeru = ninshoshaShimeiKakeru;
        this.koinShoryaku = koinShoryaku;
        this.yubinNo = yubinNo;
        this.gyoseiku2 = gyoseiku2;
        this.jusho4 = jusho4;
        this.jushoText = jushoText;
        this.jusho5 = jusho5;
        this.jusho6 = jusho6;
        this.katagakiText = katagakiText;
        this.katagaki3 = katagaki3;
        this.katagakiSmall2 = katagakiSmall2;
        this.katagaki4 = katagaki4;
        this.katagakiSmall1 = katagakiSmall1;
        this.shimei5 = shimei5;
        this.shimeiSmall2 = shimeiSmall2;
        this.shimeiText = shimeiText;
        this.meishoFuyo2 = meishoFuyo2;
        this.shimeiSmall1 = shimeiSmall1;
        this.dainoKubunMei = dainoKubunMei;
        this.shimei6 = shimei6;
        this.meishoFuyo1 = meishoFuyo1;
        this.samabunShimeiText = samabunShimeiText;
        this.kakkoLeft2 = kakkoLeft2;
        this.samabunShimei2 = samabunShimei2;
        this.samabunShimeiSmall2 = samabunShimeiSmall2;
        this.samaBun2 = samaBun2;
        this.kakkoRight2 = kakkoRight2;
        this.kakkoLeft1 = kakkoLeft1;
        this.samabunShimei1 = samabunShimei1;
        this.samaBun1 = samaBun1;
        this.kakkoRight1 = kakkoRight1;
        this.samabunShimeiSmall1 = samabunShimeiSmall1;
        this.customerBarCode = customerBarCode;
    }
}
