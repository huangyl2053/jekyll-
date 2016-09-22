/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishoshiharaiyoteibiyijiari;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 償還払い支給（不支給）決定通知書(支払予定日あり）のITEMです。
 *
 * @reamsid_L DBC-1000-110 zuotao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem {

    private RString 定型文文字サイズ;
    private RString bunshoNo;
    private RString title;
    private RString title2_1;
    private RString title2_2_1;
    private RString title2_2_2;
    private RString title2_3_1;
    private RString title2_3_2;
    private RString title2_4;
    private RString tsuchibun1;
    private RString hihokenshaName;
    private RString hihokenshaNo1;
    private RString hihokenshaNo2;
    private RString hihokenshaNo3;
    private RString hihokenshaNo4;
    private RString hihokenshaNo5;
    private RString hihokenshaNo6;
    private RString hihokenshaNo7;
    private RString hihokenshaNo8;
    private RString hihokenshaNo9;
    private RString hihokenshaNo10;
    private RString uketsukeYMD;
    private RString ketteiYMD;
    private RString honninShiharaiGaku;
    private RString taishoYM;
    private RString kyufuShu1;
    private RString kyufuShu2;
    private RString kyufuShu3;
    private RString kekka;
    private RString shikyuGaku;
    private RString riyuTitle;
    private RString riyu1;
    private RString riyu2;
    private RString riyu3;
    private RString torikeshi1;
    private RString torikeshi2;
    private RString mochimono1;
    private RString bankName;
    private RString torikeshiMochimono1;
    private RString branchBankName;
    private RString mochimono2;
    private RString torikeshiMochimono2;
    private RString mochimono3;
    private RString shiharaiBasho;
    private RString torikeshiShiharaibasho;
    private RString shumokuTitle;
    private RString kouzaShu;
    private RString bangoTitle;
    private RString kouzaNo;
    private RString kouzaMeigi;
    private RString shiharaiStartYMD;
    private RString torikeshiShiharaikikan;
    private RString shiharaiEndYMD;
    private RString karaFugo;
    private RString shiharaiStartHMS;
    private RString shiharaiEndHMS;
    private RString sihaYoYmd;
    private RString tsuchibun２;
    private RString seirino;
    private RString tsuchino;
    private RString remban;
    private RString tsuchibunLarge;
    private RString tsuchibunMix1;
    private RString tsuchibunMix2;
    private RString tsuchibunMixtwo1;
    private RString tsuchibunMixtwo2;
    private RString hakkoYMD;
    private RString denshiKoin;
    private RString ninshoshaYakushokuMei;
    private RString ninshoshaYakushokuMei1;
    private RString koinMojiretsu;
    private RString ninshoshaYakushokuMei2;
    private RString ninshoshaShimeiKakenai;
    private RString ninshoshaShimeiKakeru;
    private RString koinShoryaku;
    private RString yubinNo;
    private RString gyoseiku2;
    private RString jusho4;
    private RString jushoText;
    private RString jusho5;
    private RString jusho6;
    private RString katagakiText;
    private RString katagaki3;
    private RString katagakiSmall2;
    private RString katagaki4;
    private RString katagakiSmall1;
    private RString shimei5;
    private RString shimeiSmall2;
    private RString shimeiText;
    private RString meishoFuyo2;
    private RString shimeiSmall1;
    private RString dainoKubunMei;
    private RString shimei6;
    private RString meishoFuyo1;
    private RString samabunShimeiText;
    private RString kakkoLeft2;
    private RString samabunShimei2;
    private RString samabunShimeiSmall2;
    private RString samaBun2;
    private RString kakkoRight2;
    private RString kakkoLeft1;
    private RString samabunShimei1;
    private RString samaBun1;
    private RString kakkoRight1;
    private RString samabunShimeiSmall1;
    private RString customerBarCode;

    /**
     * コンストラクタです。
     */
    public ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem() {
    }

    /**
     * コンストラクタです。
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
     * @param 定型文文字サイズ 定型文文字サイズ
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
            RString samabunShimeiSmall1, RString customerBarCode, RString 定型文文字サイズ) {
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
        this.定型文文字サイズ = 定型文文字サイズ;
    }
}
