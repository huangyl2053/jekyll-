/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd550002;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * サービス変更通知書のItemです。
 *
 * @reamsid_L DBD-1430-040 b_zhengs
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ServiceHenkoTshuchishoItem {

    private final RString bunshoNo;
    private final RString title;
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
    private final RString henkoYMD;
    private final RString maeService;
    private final RString atoService;
    private final RString riyu;
    private final RString tsuchibun2;
    private final RString tsuchibun3;
    private final RString tsuchibun4;
    private final RString tsuchibun5;
    private final RString tsuchibun6;
    private final RString tsuchibun7;
    private final RString denshiKoin;
    private final RString hakkoYMD;
    private final RString ninshoshaYakushokuMei;
    private final RString ninshoshaYakushokuMei1;
    private final RString ninshoshaYakushokuMei2;
    private final RString ninshoshaShimeiKakenai;
    private final RString ninshoshaShimeiKakeru;
    private final RString koinShoryaku;
    private final RString koinMojiretsu;
    private final RString yubinNo;
    private final RString gyoseiku;
    private final RString jushoText;
    private final RString jusho1;
    private final RString jusho2;
    private final RString jusho3;
    private final RString katagakiText;
    private final RString katagaki1;
    private final RString katagaki2;
    private final RString katagakiSmall1;
    private final RString katagakiSmall2;
    private final RString dainoKubunMei;
    private final RString shimeiText;
    private final RString shimei1;
    private final RString shimei2;
    private final RString shimeiSmall1;
    private final RString shimeiSmall2;
    private final RString samabunShimeiText;
    private final RString samabunShimei1;
    private final RString samabunShimei2;
    private final RString samabunShimeiSmall1;
    private final RString samabunShimeiSmall2;
    private final RString meishoFuyo1;
    private final RString meishoFuyo2;
    private final RString samaBun1;
    private final RString samaBun2;
    private final RString kakkoLeft1;
    private final RString kakkoLeft2;
    private final RString kakkoRight1;
    private final RString kakkoRight2;
    private final RString customerBarCode;

    /**
     * インスタンスを生成します。
     *
     * @param bunshoNo 文書番号
     * @param title タイトル
     * @param tsuchibun1 通知文1
     * @param hihokenshaName 被保険者名
     * @param hihokenshaNo1 被保険者番号1桁目
     * @param hihokenshaNo2 被保険者番号2桁目
     * @param hihokenshaNo3 被保険者番号3桁目
     * @param hihokenshaNo4 被保険者番号4桁目
     * @param hihokenshaNo5 被保険者番号5桁目
     * @param hihokenshaNo6 被保険者番号6桁目
     * @param hihokenshaNo7 被保険者番号7桁目
     * @param hihokenshaNo8 被保険者番号8桁目
     * @param hihokenshaNo9 被保険者番号9桁目
     * @param hihokenshaNo10 被保険者番号10桁目
     * @param henkoYMD 変更年月日
     * @param maeService 変更前サービス種類
     * @param atoService 変更後サービス種類
     * @param riyu 理由
     * @param tsuchibun2 通知文2
     * @param tsuchibun3 通知文3
     * @param tsuchibun4 通知文4
     * @param tsuchibun5 通知文5
     * @param tsuchibun6 通知文6
     * @param tsuchibun7 通知文7
     * @param denshiKoin 電子公印
     * @param hakkoYMD 発行日
     * @param ninshoshaYakushokuMei 認証者役職名
     * @param ninshoshaYakushokuMei1 認証者役職名1
     * @param ninshoshaYakushokuMei2 認証者役職名2
     * @param ninshoshaShimeiKakenai 認証者氏名(公印に掛けない)
     * @param ninshoshaShimeiKakeru 認証者氏名(公印に掛ける)
     * @param koinShoryaku 公印省略
     * @param koinMojiretsu 公印文字列
     * @param yubinNo 郵便番号
     * @param gyoseiku 行政区
     * @param jushoText 住所Text
     * @param jusho1 住所1
     * @param jusho2 住所2
     * @param jusho3 住所3
     * @param katagakiText 方書Text
     * @param katagaki1 方書1
     * @param katagaki2 方書2
     * @param katagakiSmall1 方書Small1
     * @param katagakiSmall2 方書Small2
     * @param dainoKubunMei 代納人区分
     * @param shimeiText 氏名Text
     * @param shimei1 氏名1
     * @param shimei2 氏名2
     * @param shimeiSmall1 氏名Small1
     * @param shimeiSmall2 氏名Small2
     * @param samabunShimeiText 氏名samabunText
     * @param samabunShimei1 氏名samabun1
     * @param samabunShimei2 氏名samabun2
     * @param samabunShimeiSmall1 氏名samabunSmall1
     * @param samabunShimeiSmall2 氏名samabunSmall2
     * @param meishoFuyo1 名称付与1
     * @param meishoFuyo2 名称付与2
     * @param samaBun1 様文1
     * @param samaBun2 様文2
     * @param kakkoLeft1 括弧Left1
     * @param kakkoLeft2 括弧Left2
     * @param kakkoRight1 括弧Right1
     * @param kakkoRight2 括弧Right2
     * @param customerBarCode カスタマバーコード
     */
    public ServiceHenkoTshuchishoItem(
            RString bunshoNo,
            RString title,
            RString tsuchibun1,
            RString hihokenshaName,
            RString hihokenshaNo1,
            RString hihokenshaNo2,
            RString hihokenshaNo3,
            RString hihokenshaNo4,
            RString hihokenshaNo5,
            RString hihokenshaNo6,
            RString hihokenshaNo7,
            RString hihokenshaNo8,
            RString hihokenshaNo9,
            RString hihokenshaNo10,
            RString henkoYMD,
            RString maeService,
            RString atoService,
            RString riyu,
            RString tsuchibun2,
            RString tsuchibun3,
            RString tsuchibun4,
            RString tsuchibun5,
            RString tsuchibun6,
            RString tsuchibun7,
            RString denshiKoin,
            RString hakkoYMD,
            RString ninshoshaYakushokuMei,
            RString ninshoshaYakushokuMei1,
            RString ninshoshaYakushokuMei2,
            RString ninshoshaShimeiKakenai,
            RString ninshoshaShimeiKakeru,
            RString koinShoryaku,
            RString koinMojiretsu,
            RString yubinNo,
            RString gyoseiku,
            RString jushoText,
            RString jusho1,
            RString jusho2,
            RString jusho3,
            RString katagakiText,
            RString katagaki1,
            RString katagaki2,
            RString katagakiSmall1,
            RString katagakiSmall2,
            RString dainoKubunMei,
            RString shimeiText,
            RString shimei1,
            RString shimei2,
            RString shimeiSmall1,
            RString shimeiSmall2,
            RString samabunShimeiText,
            RString samabunShimei1,
            RString samabunShimei2,
            RString samabunShimeiSmall1,
            RString samabunShimeiSmall2,
            RString meishoFuyo1,
            RString meishoFuyo2,
            RString samaBun1,
            RString samaBun2,
            RString kakkoLeft1,
            RString kakkoLeft2,
            RString kakkoRight1,
            RString kakkoRight2,
            RString customerBarCode) {
        this.bunshoNo = bunshoNo;
        this.title = title;
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
        this.henkoYMD = henkoYMD;
        this.maeService = maeService;
        this.atoService = atoService;
        this.riyu = riyu;
        this.tsuchibun2 = tsuchibun2;
        this.tsuchibun3 = tsuchibun3;
        this.tsuchibun4 = tsuchibun4;
        this.tsuchibun5 = tsuchibun5;
        this.tsuchibun6 = tsuchibun6;
        this.tsuchibun7 = tsuchibun7;
        this.denshiKoin = denshiKoin;
        this.hakkoYMD = hakkoYMD;
        this.ninshoshaYakushokuMei = ninshoshaYakushokuMei;
        this.ninshoshaYakushokuMei1 = ninshoshaYakushokuMei1;
        this.ninshoshaYakushokuMei2 = ninshoshaYakushokuMei2;
        this.ninshoshaShimeiKakenai = ninshoshaShimeiKakenai;
        this.ninshoshaShimeiKakeru = ninshoshaShimeiKakeru;
        this.koinShoryaku = koinShoryaku;
        this.koinMojiretsu = koinMojiretsu;
        this.yubinNo = yubinNo;
        this.gyoseiku = gyoseiku;
        this.jushoText = jushoText;
        this.jusho1 = jusho1;
        this.jusho2 = jusho2;
        this.jusho3 = jusho3;
        this.katagakiText = katagakiText;
        this.katagaki1 = katagaki1;
        this.katagaki2 = katagaki2;
        this.katagakiSmall1 = katagakiSmall1;
        this.katagakiSmall2 = katagakiSmall2;
        this.dainoKubunMei = dainoKubunMei;
        this.shimeiText = shimeiText;
        this.shimei1 = shimei1;
        this.shimei2 = shimei2;
        this.shimeiSmall1 = shimeiSmall1;
        this.shimeiSmall2 = shimeiSmall2;
        this.samabunShimeiText = samabunShimeiText;
        this.samabunShimei1 = samabunShimei1;
        this.samabunShimei2 = samabunShimei2;
        this.samabunShimeiSmall1 = samabunShimeiSmall1;
        this.samabunShimeiSmall2 = samabunShimeiSmall2;
        this.meishoFuyo1 = meishoFuyo1;
        this.meishoFuyo2 = meishoFuyo2;
        this.samaBun1 = samaBun1;
        this.samaBun2 = samaBun2;
        this.kakkoLeft1 = kakkoLeft1;
        this.kakkoLeft2 = kakkoLeft2;
        this.kakkoRight1 = kakkoRight1;
        this.kakkoRight2 = kakkoRight2;
        this.customerBarCode = customerBarCode;
    }

}
