/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shokanketteissuchishosealer;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 償還払支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ2）のITEMです。
 *
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanKetteiTsuchiShoSealer2Item {

    private final RString bunshoNo;
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
    private final RString shiharaiGaku;
    private final RString taishoYM;
    private final RString kyufuShurui1;
    private final RString kyufuShurui2;
    private final RString kyufuShurui3;
    private final RString kekka;
    private final RString shikyuGaku;
    private final RString riyu1;
    private final RString riyu2;
    private final RString riyu3;
    private final RString shiharaiBasho;
    private final RString bankName;
    private final RString branchBankName;
    private final RString kouzaShu;
    private final RString kouzaNo;
    private final RString kouzaMeigi;
    private final RString 支払予定日;
    private final RString 整理番号;
    private final RString 決定通知書番号;
    private final RString shiharaiStartYMD;
    private final RString shiharaiEndYMD;
    private final RString shiharaiStartHMS;
    private final RString shiharaiEndHMS;
    private final RString karaFugo;
    private final RString tsuban;
    private final RString shumokuTitle;
    private final RString bangoTitle;
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
    private final RString title2_1;
    private final RString title2_2_1;
    private final RString title2_2_2;
    private final RString title2_3_1;
    private final RString title2_3_2;
    private final RString title2_4;
    private final RString torikeshi1;
    private final RString torikeshi2;
    private final RString mochimono1;
    private final RString torikeshiMochimono1;
    private final RString mochimono2;
    private final RString torikeshiMochimono2;
    private final RString mochimono3;
    private final RString shoHokenshaNo;
    private final RString serviceYM;
    private final RString tsuban2;
    private final RString torikeshiShiharaikikan;
    private final RString riyuTitle;
    private final RString 増減の理由;
    private final RString タイトル1;
    private final RString タイトル2;
    private final RString 当ページ;
    private final RString ページ総数;
    private final RString 被保険者氏名２;
    private final RString 通知文;
    private final RString 情報文;
    private final RString 円1;
    private final RString 円2;
    private final RString 円3;
    private final RString 円4;
    private final RString title;
    private final RString torikeshiShiharaibasho;
    private final RString hihokenshaNo21;
    private final RString gyoseiku2;

    /**
     *
     * @param bunshoNo 文章番号
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
     * @param shiharaiGaku 本人支払額
     * @param taishoYM 対象年月
     * @param kyufuShurui1 給付の種類１
     * @param kyufuShurui2 給付の種類２
     * @param kyufuShurui3 給付の種3３
     * @param kekka　支給結果
     * @param shikyuGaku 支給金額
     * @param riyu1 増減の理由1
     * @param riyu2 増減の理由2
     * @param riyu3 増減の理由3
     * @param shiharaiBasho 支払場所
     * @param bankName 金融機関名
     * @param branchBankName 支店名
     * @param kouzaShu 口座種別
     * @param kouzaNo 口座番号
     * @param kouzaMeigi 口座名義
     * @param 支払予定日 支払予定日
     * @param 整理番号 整理番号
     * @param 決定通知書番号 決定通知書番号
     * @param shiharaiStartYMD 支払期間開始年月日
     * @param shiharaiEndYMD 支払期間終了年月日
     * @param shiharaiStartHMS 支払窓口開始時間
     * @param shiharaiEndHMS 支払窓口終了時間
     * @param karaFugo ～
     * @param tsuban 通番
     * @param shumokuTitle 種別タイトル
     * @param bangoTitle 番号タイトル
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
     * @param title2_1 タイトル2
     * @param title2_2_1 タイトル2_2_1
     * @param title2_2_2 タイトル2_2_2
     * @param title2_3_1 タイトル2_3_1
     * @param title2_3_2 タイトル2_2_2
     * @param title2_4 タイトル2_4
     * @param torikeshi1 取消1
     * @param torikeshi2 取消2
     * @param mochimono1 もちもの１
     * @param torikeshiMochimono1 取消もちもの1
     * @param mochimono2 もちもの２
     * @param torikeshiMochimono2 取消もちもの2
     * @param mochimono3 もちもの３
     * @param shoHokenshaNo 保険者番号
     * @param serviceYM サービス年月
     * @param tsuban2 通番2
     * @param torikeshiShiharaikikan 取消支払期間
     * @param riyuTitle 増減の理由タイトル
     * @param 増減の理由 増減の理由
     * @param タイトル1 タイトル1
     * @param タイトル2 タイトル2
     * @param 当ページ 当ページ
     * @param 円2 円2
     * @param 被保険者氏名２ 被保険者氏名２
     * @param 通知文 通知文
     * @param ページ総数 ページ総数
     * @param 情報文 情報文
     * @param 円1 円1
     * @param 円3 円3
     * @param 円4 円4
     * @param title タイトル
     * @param torikeshiShiharaibasho 取消支払場所
     * @param hihokenshaNo21 被保険者番号
     * @param gyoseiku2 行政区2
     *
     */
    public ShokanKetteiTsuchiShoSealer2Item(RString bunshoNo, RString hihokenshaName, RString hihokenshaNo1,
            RString hihokenshaNo2, RString hihokenshaNo3, RString hihokenshaNo4, RString hihokenshaNo5,
            RString hihokenshaNo6, RString hihokenshaNo7, RString hihokenshaNo8, RString hihokenshaNo9,
            RString hihokenshaNo10, RString uketsukeYMD, RString ketteiYMD, RString shiharaiGaku,
            RString taishoYM, RString kyufuShurui1, RString kyufuShurui2, RString kyufuShurui3,
            RString kekka, RString shikyuGaku, RString riyu1, RString riyu2, RString riyu3,
            RString shiharaiBasho, RString bankName, RString branchBankName, RString kouzaShu,
            RString kouzaNo, RString kouzaMeigi, RString 支払予定日, RString 整理番号, RString 決定通知書番号,
            RString shiharaiStartYMD, RString shiharaiEndYMD, RString shiharaiStartHMS, RString shiharaiEndHMS,
            RString karaFugo, RString tsuban, RString shumokuTitle, RString bangoTitle, RString hakkoYMD,
            RString denshiKoin, RString ninshoshaYakushokuMei, RString ninshoshaYakushokuMei1, RString koinMojiretsu,
            RString ninshoshaYakushokuMei2, RString ninshoshaShimeiKakenai, RString ninshoshaShimeiKakeru,
            RString koinShoryaku, RString yubinNo, RString jusho4, RString jushoText, RString jusho5,
            RString jusho6, RString katagakiText, RString katagaki3, RString katagakiSmall2, RString katagaki4,
            RString katagakiSmall1, RString shimei5, RString shimeiSmall2, RString shimeiText, RString meishoFuyo2,
            RString shimeiSmall1, RString dainoKubunMei, RString shimei6, RString meishoFuyo1,
            RString samabunShimeiText, RString kakkoLeft2, RString samabunShimei2, RString samabunShimeiSmall2,
            RString samaBun2, RString kakkoRight2, RString kakkoLeft1, RString samabunShimei1, RString samaBun1,
            RString kakkoRight1, RString samabunShimeiSmall1, RString customerBarCode, RString title2_1,
            RString title2_2_1, RString title2_2_2, RString title2_3_1, RString title2_3_2, RString title2_4,
            RString torikeshi1, RString torikeshi2, RString mochimono1, RString torikeshiMochimono1,
            RString mochimono2, RString torikeshiMochimono2, RString mochimono3, RString shoHokenshaNo,
            RString serviceYM, RString tsuban2, RString torikeshiShiharaikikan, RString riyuTitle, RString 増減の理由,
            RString タイトル1, RString タイトル2, RString 当ページ, RString ページ総数, RString 被保険者氏名２,
            RString 通知文, RString 情報文, RString 円1, RString 円2, RString 円3, RString 円4, RString title,
            RString torikeshiShiharaibasho, RString hihokenshaNo21, RString gyoseiku2) {
        this.bunshoNo = bunshoNo;
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
        this.shiharaiGaku = shiharaiGaku;
        this.taishoYM = taishoYM;
        this.kyufuShurui1 = kyufuShurui1;
        this.kyufuShurui2 = kyufuShurui2;
        this.kyufuShurui3 = kyufuShurui3;
        this.kekka = kekka;
        this.shikyuGaku = shikyuGaku;
        this.riyu1 = riyu1;
        this.riyu2 = riyu2;
        this.riyu3 = riyu3;
        this.shiharaiBasho = shiharaiBasho;
        this.bankName = bankName;
        this.branchBankName = branchBankName;
        this.kouzaShu = kouzaShu;
        this.kouzaNo = kouzaNo;
        this.kouzaMeigi = kouzaMeigi;
        this.支払予定日 = 支払予定日;
        this.整理番号 = 整理番号;
        this.決定通知書番号 = 決定通知書番号;
        this.shiharaiStartYMD = shiharaiStartYMD;
        this.shiharaiEndYMD = shiharaiEndYMD;
        this.shiharaiStartHMS = shiharaiStartHMS;
        this.shiharaiEndHMS = shiharaiEndHMS;
        this.karaFugo = karaFugo;
        this.tsuban = tsuban;
        this.shumokuTitle = shumokuTitle;
        this.bangoTitle = bangoTitle;
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
        this.title2_1 = title2_1;
        this.title2_2_1 = title2_2_1;
        this.title2_2_2 = title2_2_2;
        this.title2_3_1 = title2_3_1;
        this.title2_3_2 = title2_3_2;
        this.title2_4 = title2_4;
        this.torikeshi1 = torikeshi1;
        this.torikeshi2 = torikeshi2;
        this.mochimono1 = mochimono1;
        this.torikeshiMochimono1 = torikeshiMochimono1;
        this.mochimono2 = mochimono2;
        this.torikeshiMochimono2 = torikeshiMochimono2;
        this.mochimono3 = mochimono3;
        this.shoHokenshaNo = shoHokenshaNo;
        this.serviceYM = serviceYM;
        this.tsuban2 = tsuban2;
        this.torikeshiShiharaikikan = torikeshiShiharaikikan;
        this.riyuTitle = riyuTitle;
        this.増減の理由 = 増減の理由;
        this.タイトル1 = タイトル1;
        this.タイトル2 = タイトル2;
        this.当ページ = 当ページ;
        this.ページ総数 = ページ総数;
        this.被保険者氏名２ = 被保険者氏名２;
        this.通知文 = 通知文;
        this.情報文 = 情報文;
        this.円1 = 円1;
        this.円2 = 円2;
        this.円3 = 円3;
        this.円4 = 円4;
        this.title = title;
        this.torikeshiShiharaibasho = torikeshiShiharaibasho;
        this.hihokenshaNo21 = hihokenshaNo21;
        this.gyoseiku2 = gyoseiku2;
    }
}
