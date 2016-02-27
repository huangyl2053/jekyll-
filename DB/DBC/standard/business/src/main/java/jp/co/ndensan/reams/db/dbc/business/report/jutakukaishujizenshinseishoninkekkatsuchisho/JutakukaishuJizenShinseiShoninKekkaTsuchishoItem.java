/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jutakukaishujizenshinseishoninkekkatsuchisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 住宅改修事前申請承認結果通知書のITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JutakukaishuJizenShinseiShoninKekkaTsuchishoItem {

    private final RString bunshoNo;
    private final RString title;
    private final RString tsuchibun1;
    private final RString hihokenshaName;
    private final RString hihokenshaNo;
    private final RString uketsukeYMD;
    private final RString shoninKbn;
    private final RString shoninYMD;
    private final RString fushoninRiyu;
    private final RString kyufuShurui;
    private final RString jigyoshaName;
    private final RString jigyoshaYubinNo;
    private final RString jigyoshoJusho;
    private final RString jigyoshoTelNo;
    private final RString riyushoSakuseisha;
    private final RString hiyogakuGokei;
    private final RString hokenHiyogaku;
    private final RString riyoFutangaku;
    private final RString hokenKyufuhigaku;
    private final RString tsuchibun2;
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
     * @param bunshoNo 文章番号
     * @param title タイトル
     * @param tsuchibun1 通知文
     * @param hihokenshaName 被保険者氏名
     * @param hihokenshaNo 被保険者番号
     * @param uketsukeYMD 受付日
     * @param shoninKbn 承認区分
     * @param shoninYMD 承認年月日
     * @param fushoninRiyu 不承認の理由
     * @param kyufuShurui 給付の種類
     * @param jigyoshaName 事業者名
     * @param jigyoshaYubinNo 事業者郵便番号
     * @param jigyoshoJusho 事業者住所
     * @param jigyoshoTelNo 事業者電話番号
     * @param riyushoSakuseisha 理由書作成者
     * @param hiyogakuGokei 費用額合計
     * @param hokenHiyogaku 保険対象費用額
     * @param riyoFutangaku 理由負担額
     * @param hokenKyufuhigaku 保険給付費額
     * @param tsuchibun2 注意文
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
     * @param gyoseiku1 行政区1
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
    public JutakukaishuJizenShinseiShoninKekkaTsuchishoItem(RString bunshoNo, RString title, RString tsuchibun1,
            RString hihokenshaName, RString hihokenshaNo, RString uketsukeYMD, RString shoninKbn, RString shoninYMD,
            RString fushoninRiyu, RString kyufuShurui, RString jigyoshaName, RString jigyoshaYubinNo, RString jigyoshoJusho,
            RString jigyoshoTelNo, RString riyushoSakuseisha, RString hiyogakuGokei, RString hokenHiyogaku, RString riyoFutangaku,
            RString hokenKyufuhigaku, RString tsuchibun2, RString hakkoYMD, RString denshiKoin, RString ninshoshaYakushokuMei,
            RString ninshoshaYakushokuMei1, RString koinMojiretsu, RString ninshoshaYakushokuMei2, RString ninshoshaShimeiKakenai,
            RString ninshoshaShimeiKakeru, RString koinShoryaku, RString yubinNo, RString gyoseiku1, RString jusho4, RString jushoText,
            RString jusho5, RString jusho6, RString katagakiText, RString katagaki3, RString katagakiSmall2, RString katagaki4,
            RString katagakiSmall1, RString shimei5, RString shimeiSmall2, RString shimeiText, RString meishoFuyo2, RString shimeiSmall1,
            RString dainoKubunMei, RString shimei6, RString meishoFuyo1, RString samabunShimeiText, RString samaBun2, RString kakkoLeft2,
            RString samabunShimei2, RString samabunShimeiSmall2, RString kakkoRight2, RString kakkoLeft1, RString samabunShimei1,
            RString samaBun1, RString kakkoRight1, RString samabunShimeiSmall1, RString customerBarCode) {

        this.bunshoNo = bunshoNo;
        this.title = title;
        this.tsuchibun1 = tsuchibun1;
        this.hihokenshaName = hihokenshaName;
        this.hihokenshaNo = hihokenshaNo;
        this.uketsukeYMD = uketsukeYMD;
        this.shoninKbn = shoninKbn;
        this.shoninYMD = shoninYMD;
        this.fushoninRiyu = fushoninRiyu;
        this.kyufuShurui = kyufuShurui;
        this.jigyoshaName = jigyoshaName;
        this.jigyoshaYubinNo = jigyoshaYubinNo;
        this.jigyoshoJusho = jigyoshoJusho;
        this.jigyoshoTelNo = jigyoshoTelNo;
        this.riyushoSakuseisha = riyushoSakuseisha;
        this.hiyogakuGokei = hiyogakuGokei;
        this.hokenHiyogaku = hokenHiyogaku;
        this.riyoFutangaku = riyoFutangaku;
        this.hokenKyufuhigaku = hokenKyufuhigaku;
        this.tsuchibun2 = tsuchibun2;
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
