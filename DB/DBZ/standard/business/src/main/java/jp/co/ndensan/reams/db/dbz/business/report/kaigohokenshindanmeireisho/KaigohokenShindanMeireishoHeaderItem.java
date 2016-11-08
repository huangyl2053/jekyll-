/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.kaigohokenshindanmeireisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護保険診断命令書のITEMです。
 *
 * @reamsid_L DBE-0080-070 wangxiaodong
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigohokenShindanMeireishoHeaderItem {

    private RString hakkoYMD;
    private RString denshiKoin;
    private RString ninshoshaYakushokuMei;
    private RString ninshoshaYakushokuMei2;
    private RString ninshoshaYakushokuMei1;
    private RString ninshoshaShimeiKakenai;
    private RString ninshoshaShimeiKakeru;
    private RString koinMojiretsu;
    private RString koinShoryaku;
    private RString yubinNo;
    private RString jushoText;
    private RString hihokenshaName;
    private RString title;
    private RString meishoFuyo;
    private RString customerBarCode;
    private RString sonota;
    private RString tsuchibun1;
    private RString hihokenshaNo;
    private RString iryokikanName;
    private RString tantoIshiName;
    private RString iryokikanJusho;
    private RString telNo;
    private RString jushinKikan;
    private RString jushinArea;
    private RString tsuchibun2;

    /**
     * インスタンスを生成します。
     */
    public KaigohokenShindanMeireishoHeaderItem() {
    }

    /**
     * インスタンスを生成します。
     *
     * @param hakkoYMD 証明発行YMD
     * @param denshiKoin 電子公印
     * @param ninshoshaYakushokuMei 認証者役職名
     * @param ninshoshaYakushokuMei2 認証者役職名２
     * @param ninshoshaYakushokuMei1 認証者役職名１
     * @param ninshoshaShimeiKakenai 首長名公印掛けない
     * @param ninshoshaShimeiKakeru 首長名公印掛ける
     * @param koinMojiretsu 公印文字列
     * @param koinShoryaku 公印省略
     * @param yubinNo 郵便番号
     * @param jushoText 住所
     * @param hihokenshaName 被保険者名
     * @param meishoFuyo 名称付与
     * @param customerBarCode customerBarCode
     * @param sonota その他
     * @param tsuchibun1 通知文1
     * @param hihokenshaNo 被保険者番号
     * @param iryokikanName 名称
     * @param tantoIshiName 担当医師名
     * @param iryokikanJusho 所在地
     * @param telNo 電話番号
     * @param jushinKikan 診断を受ける日時
     * @param jushinArea 診断を受ける場所
     * @param tsuchibun2 通知文2
     * @param title 帳票名
     */
    public KaigohokenShindanMeireishoHeaderItem(
            RString hakkoYMD,
            RString denshiKoin,
            RString ninshoshaYakushokuMei,
            RString ninshoshaYakushokuMei2,
            RString ninshoshaYakushokuMei1,
            RString ninshoshaShimeiKakenai,
            RString ninshoshaShimeiKakeru,
            RString koinMojiretsu,
            RString koinShoryaku,
            RString yubinNo,
            RString jushoText,
            RString hihokenshaName,
            RString meishoFuyo,
            RString customerBarCode,
            RString sonota,
            RString tsuchibun1,
            RString hihokenshaNo,
            RString iryokikanName,
            RString tantoIshiName,
            RString iryokikanJusho,
            RString telNo,
            RString jushinKikan,
            RString jushinArea,
            RString tsuchibun2,
            RString title) {
        this.hakkoYMD = hakkoYMD;
        this.denshiKoin = denshiKoin;
        this.ninshoshaYakushokuMei = ninshoshaYakushokuMei;
        this.ninshoshaYakushokuMei2 = ninshoshaYakushokuMei2;
        this.ninshoshaYakushokuMei1 = ninshoshaYakushokuMei1;
        this.ninshoshaShimeiKakenai = ninshoshaShimeiKakenai;
        this.ninshoshaShimeiKakeru = ninshoshaShimeiKakeru;
        this.koinMojiretsu = koinMojiretsu;
        this.koinShoryaku = koinShoryaku;
        this.yubinNo = yubinNo;
        this.jushoText = jushoText;
        this.hihokenshaName = hihokenshaName;
        this.meishoFuyo = meishoFuyo;
        this.customerBarCode = customerBarCode;
        this.sonota = sonota;
        this.tsuchibun1 = tsuchibun1;
        this.hihokenshaNo = hihokenshaNo;
        this.iryokikanName = iryokikanName;
        this.tantoIshiName = tantoIshiName;
        this.iryokikanJusho = iryokikanJusho;
        this.telNo = telNo;
        this.jushinKikan = jushinKikan;
        this.jushinArea = jushinArea;
        this.tsuchibun2 = tsuchibun2;
        this.title = title;
    }
}
