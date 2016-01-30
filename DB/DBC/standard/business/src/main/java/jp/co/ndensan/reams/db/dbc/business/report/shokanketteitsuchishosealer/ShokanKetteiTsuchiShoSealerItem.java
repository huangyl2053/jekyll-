/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishosealer;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 償還払支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ）のITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanKetteiTsuchiShoSealerItem {

    private final RString tsuban;
    private final RString title1;
    private final RString bunshoNo;
    private final RString page;
    private final RString pages;
    private final RString title;
    private final RString title2;
    private final RString hihokenshaName2;
    private final RString hihokenshaNo;
    private final RString hihokenshaName;
    private final RString tsuchibun1;
    private final RString ketteiYMD;
    private final RString shiharaiGaku;
    private final RString shiharaiYoteiYMD;
    private final RString kyufuShurui1;
    private final RString taishoYM1;
    private final RString shikyuGaku1;
    private final RString yen1;
    private final RString info;
    private final RString kyufuShurui2;
    private final RString taishoYM2;
    private final RString shikyuGaku2;
    private final RString yen2;
    private final RString kyufuShurui3;
    private final RString taishoYM3;
    private final RString shikyuGaku3;
    private final RString yen3;
    private final RString kyufuShurui4;
    private final RString taishoYM4;
    private final RString shikyuGaku4;
    private final RString yen4;
    private final RString bankName;
    private final RString branchBankName;
    private final RString shumokuTitle;
    private final RString kouzaShu;
    private final RString bangoTitle;
    private final RString kouzaNo;
    private final RString kouzaMeigi;
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
    private final RString gyoseiku1;
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
    private final RString samaBun2;
    private final RString kakkoLeft2;
    private final RString samabunShimei2;
    private final RString samabunShimeiSmall2;
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
     * @param tsuban 通番
     * @param title1 タイトル1
     * @param bunshoNo 文章番号
     * @param page 当ページ
     * @param pages ページ総数
     * @param title タイトル
     * @param title2 タイトル2
     * @param hihokenshaName2 被保険者氏名2
     * @param hihokenshaNo 被保険者番号
     * @param hihokenshaName 被保険者氏名
     * @param tsuchibun1 通知文
     * @param ketteiYMD 決定年月日
     * @param shiharaiGaku 支払額
     * @param shiharaiYoteiYMD 支払予定日
     * @param kyufuShurui1 給付種類1
     * @param taishoYM1 対象年月1
     * @param shikyuGaku1 支給額１
     * @param yen1 円1
     * @param info 情報文
     * @param kyufuShurui2 給付種類2
     * @param taishoYM2 対象年月2
     * @param shikyuGaku2 支給額2
     * @param yen2 円2
     * @param kyufuShurui3 給付種類3
     * @param taishoYM3 対象年月3
     * @param shikyuGaku3 支給額3
     * @param yen3 円3
     * @param kyufuShurui4 給付種類４
     * @param taishoYM4 対象年月4
     * @param shikyuGaku4 支給額4
     * @param yen4 円4
     * @param bankName 金融機関
     * @param branchBankName 支店
     * @param shumokuTitle 種別タイトル
     * @param kouzaShu 口座種別
     * @param bangoTitle 番号タイトル
     * @param kouzaNo 口座番号
     * @param kouzaMeigi 口座名義
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
     * @param gyoseiku1 行政区2
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
     * @param samaBun2 様文2
     * @param kakkoLeft2 左括弧2
     * @param samabunShimei2 様文氏名2
     * @param samabunShimeiSmall2 様文氏名小2
     * @param kakkoRight2 右括弧2
     * @param kakkoLeft1 左括弧1
     * @param samabunShimei1 様文氏名1
     * @param samaBun1 様文1
     * @param kakkoRight1 右括弧1
     * @param samabunShimeiSmall1 様文氏名小1
     * @param customerBarCode カスタマーバーコード
     */
    public ShokanKetteiTsuchiShoSealerItem(RString tsuban, RString title1, RString bunshoNo, RString page, RString pages, RString title,
            RString title2, RString hihokenshaName2, RString hihokenshaNo, RString hihokenshaName, RString tsuchibun1, RString ketteiYMD,
            RString shiharaiGaku, RString shiharaiYoteiYMD, RString kyufuShurui1, RString taishoYM1, RString shikyuGaku1, RString yen1,
            RString info, RString kyufuShurui2, RString taishoYM2, RString shikyuGaku2, RString yen2, RString kyufuShurui3, RString taishoYM3,
            RString shikyuGaku3, RString yen3, RString kyufuShurui4, RString taishoYM4, RString shikyuGaku4, RString yen4, RString bankName,
            RString branchBankName, RString shumokuTitle, RString kouzaShu, RString bangoTitle, RString kouzaNo, RString kouzaMeigi,
            RString hakkoYMD, RString denshiKoin, RString ninshoshaYakushokuMei, RString ninshoshaYakushokuMei1, RString koinMojiretsu,
            RString ninshoshaYakushokuMei2, RString ninshoshaShimeiKakenai, RString ninshoshaShimeiKakeru, RString koinShoryaku,
            RString yubinNo, RString gyoseiku1, RString jusho4, RString jushoText, RString jusho5, RString jusho6, RString katagakiText,
            RString katagaki3, RString katagakiSmall2, RString katagaki4, RString katagakiSmall1, RString shimei5, RString shimeiSmall2,
            RString shimeiText, RString meishoFuyo2, RString shimeiSmall1, RString dainoKubunMei, RString shimei6, RString meishoFuyo1,
            RString samabunShimeiText, RString samaBun2, RString kakkoLeft2, RString samabunShimei2, RString samabunShimeiSmall2,
            RString kakkoRight2, RString kakkoLeft1, RString samabunShimei1, RString samaBun1, RString kakkoRight1, RString samabunShimeiSmall1,
            RString customerBarCode) {
        this.tsuban = tsuban;
        this.title1 = title1;
        this.bunshoNo = bunshoNo;
        this.page = page;
        this.pages = pages;
        this.title = title;
        this.title2 = title2;
        this.hihokenshaName2 = hihokenshaName2;
        this.hihokenshaNo = hihokenshaNo;
        this.hihokenshaName = hihokenshaName;
        this.tsuchibun1 = tsuchibun1;
        this.ketteiYMD = ketteiYMD;
        this.shiharaiGaku = shiharaiGaku;
        this.shiharaiYoteiYMD = shiharaiYoteiYMD;
        this.kyufuShurui1 = kyufuShurui1;
        this.taishoYM1 = taishoYM1;
        this.shikyuGaku1 = shikyuGaku1;
        this.yen1 = yen1;
        this.info = info;
        this.kyufuShurui2 = kyufuShurui2;
        this.taishoYM2 = taishoYM2;
        this.shikyuGaku2 = shikyuGaku2;
        this.yen2 = yen2;
        this.kyufuShurui3 = kyufuShurui3;
        this.taishoYM3 = taishoYM3;
        this.shikyuGaku3 = shikyuGaku3;
        this.yen3 = yen3;
        this.kyufuShurui4 = kyufuShurui4;
        this.taishoYM4 = taishoYM4;
        this.shikyuGaku4 = shikyuGaku4;
        this.yen4 = yen4;
        this.bankName = bankName;
        this.branchBankName = branchBankName;
        this.shumokuTitle = shumokuTitle;
        this.kouzaShu = kouzaShu;
        this.bangoTitle = bangoTitle;
        this.kouzaNo = kouzaNo;
        this.kouzaMeigi = kouzaMeigi;
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
        this.gyoseiku1 = gyoseiku1;
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
        this.samaBun2 = samaBun2;
        this.kakkoLeft2 = kakkoLeft2;
        this.samabunShimei2 = samabunShimei2;
        this.samabunShimeiSmall2 = samabunShimeiSmall2;
        this.kakkoRight2 = kakkoRight2;
        this.kakkoLeft1 = kakkoLeft1;
        this.samabunShimei1 = samabunShimei1;
        this.samaBun1 = samaBun1;
        this.kakkoRight1 = kakkoRight1;
        this.samabunShimeiSmall1 = samabunShimeiSmall1;
        this.customerBarCode = customerBarCode;
    }
}
