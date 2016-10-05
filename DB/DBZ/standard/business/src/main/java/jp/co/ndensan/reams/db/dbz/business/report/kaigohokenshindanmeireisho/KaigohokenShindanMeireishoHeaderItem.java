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
    private RString bunshoNo;
    private RString yubinNo;
    private RString jushoText;
    private RString hihokenshaName1;
    private RString meishoFuyo;
    private RString customerBarCode;
    private RString atenaRenban;
    private RString sonota;
    private RString tsuchibun1;
    private RString hihokenshaName2;
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
     * @param koinMojiretsu 印
     * @param koinShoryaku 公印省略
     * @param bunshoNo 文書番号
     * @param yubinNo 郵便番号
     * @param jushoText 所在地
     * @param hihokenshaName1 被保険者名1
     * @param meishoFuyo 様
     * @param customerBarCode customerBarCode
     * @param atenaRenban 連番
     * @param sonota その他
     * @param tsuchibun1 通知文1
     * @param hihokenshaName2 被保険者名2
     * @param hihokenshaNo 被保険者番号
     * @param iryokikanName 名称
     * @param tantoIshiName 担当医師名
     * @param iryokikanJusho 所在地
     * @param telNo 電話番号
     * @param jushinKikan 診断を受ける日時
     * @param jushinArea 診断を受ける場所
     * @param tsuchibun2 通知文2
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
            RString bunshoNo,
            RString yubinNo,
            RString jushoText,
            RString hihokenshaName1,
            RString meishoFuyo,
            RString customerBarCode,
            RString atenaRenban,
            RString sonota,
            RString tsuchibun1,
            RString hihokenshaName2,
            RString hihokenshaNo,
            RString iryokikanName,
            RString tantoIshiName,
            RString iryokikanJusho,
            RString telNo,
            RString jushinKikan,
            RString jushinArea,
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
        this.bunshoNo = bunshoNo;
        this.yubinNo = yubinNo;
        this.jushoText = jushoText;
        this.hihokenshaName1 = hihokenshaName1;
        this.meishoFuyo = meishoFuyo;
        this.customerBarCode = customerBarCode;
        this.atenaRenban = atenaRenban;
        this.sonota = sonota;
        this.tsuchibun1 = tsuchibun1;
        this.hihokenshaName2 = hihokenshaName2;
        this.hihokenshaNo = hihokenshaNo;
        this.iryokikanName = iryokikanName;
        this.tantoIshiName = tantoIshiName;
        this.iryokikanJusho = iryokikanJusho;
        this.telNo = telNo;
        this.jushinKikan = jushinKikan;
        this.jushinArea = jushinArea;
        this.tsuchibun2 = tsuchibun2;
    }
}
