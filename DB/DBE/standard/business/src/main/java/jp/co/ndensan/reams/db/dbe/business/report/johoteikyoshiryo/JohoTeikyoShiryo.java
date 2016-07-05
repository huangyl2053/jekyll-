/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.johoteikyoshiryo;

import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 要介護認定結果情報提供票（主治医）のITEMです。
 *
 * @reamsid_L DBE-0220-020 wangkun
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JohoTeikyoShiryo {

    private final RDate hakkoYMD;
    private final RString tsuchibun1;
    private final RString title;
    private final RString hihokenshaName;
    private final RString jusho;
    private final RDate infoNijiDate;
    private final RString ninteiKekka;
    private final RDate yokaigoNiteiKaishoYMD;
    private final RDate yokaigoNinteiShuryoYMD;
    private final RString shinsakaiIken;
    private final RString denshiKoin;
    private final RString koinMojiretsu;
    private final RString koinShoryaku;
    private final RString ninshoshaShimeiKakeru;
    private final RString ninshoshaShimeiKakenai;
    private final RString ninshoshaYakushokuMei;
    private final RString ninshoshaYakushokuMei1;
    private final RString ninshoshaYakushokuMei2;
    private final RString bunshoNo;
    private final RString pageCount;
    private final RString customerBarCode;
    private final RString jushoText;
    private final RString kikanNameText;
    private final RString shimeiText;
    private final RString meishoFuyo;
    private final RString sonota;
    private final RString tsuchibun2;
    private final RString yubinNo;

    /**
     * インスタンスを生成します。
     *
     * @param hakkoYMD 発行日
     * @param title 帳票名
     * @param tsuchibun1 通知文１
     * @param hihokenshaName 氏名
     * @param jusho 住所
     * @param infoNijiDate 認定年月日
     * @param ninteiKekka 認定結果
     * @param yokaigoNiteiKaishoYMD 認定有効期間From
     * @param yokaigoNinteiShuryoYMD 認定有効期間To
     * @param shinsakaiIken 審査会意見
     * @param denshiKoin 電子公印
     * @param koinMojiretsu 電子公印文字列
     * @param koinShoryaku 電子公印省略
     * @param ninshoshaShimeiKakeru 認証者氏名公印掛ける
     * @param ninshoshaShimeiKakenai 認証者氏名公印掛けない
     * @param ninshoshaYakushokuMei 認証者役職名
     * @param ninshoshaYakushokuMei1 認証者役職名1行目
     * @param ninshoshaYakushokuMei2 認証者役職名2行目
     * @param bunshoNo 文書番号
     * @param pageCount ページ番号#2
     * @param customerBarCode カスタマーバーコード
     * @param jushoText 宛名住所
     * @param kikanNameText 宛名機関名
     * @param shimeiText 宛名氏名
     * @param meishoFuyo 宛名名称付与
     * @param sonota 宛名その他
     * @param tsuchibun2 通知文２
     * @param yubinNo 宛名郵便番号
     */
    public JohoTeikyoShiryo(RDate hakkoYMD,
            RString title,
            RString tsuchibun1,
            RString hihokenshaName,
            RString jusho,
            RDate infoNijiDate,
            RString ninteiKekka,
            RDate yokaigoNiteiKaishoYMD,
            RDate yokaigoNinteiShuryoYMD,
            RString shinsakaiIken,
            RString denshiKoin,
            RString koinMojiretsu,
            RString koinShoryaku,
            RString ninshoshaShimeiKakeru,
            RString ninshoshaShimeiKakenai,
            RString ninshoshaYakushokuMei,
            RString ninshoshaYakushokuMei1,
            RString ninshoshaYakushokuMei2,
            RString bunshoNo,
            RString pageCount,
            RString customerBarCode,
            RString jushoText,
            RString kikanNameText,
            RString shimeiText,
            RString meishoFuyo,
            RString sonota,
            RString tsuchibun2,
            RString yubinNo) {
        this.hakkoYMD = hakkoYMD;
        this.title = title;
        this.tsuchibun1 = tsuchibun1;
        this.hihokenshaName = hihokenshaName;
        this.jusho = jusho;
        this.infoNijiDate = infoNijiDate;
        this.ninteiKekka = ninteiKekka;
        this.yokaigoNiteiKaishoYMD = yokaigoNiteiKaishoYMD;
        this.yokaigoNinteiShuryoYMD = yokaigoNinteiShuryoYMD;
        this.shinsakaiIken = shinsakaiIken;
        this.denshiKoin = denshiKoin;
        this.koinMojiretsu = koinMojiretsu;
        this.koinShoryaku = koinShoryaku;
        this.ninshoshaShimeiKakeru = ninshoshaShimeiKakeru;
        this.ninshoshaShimeiKakenai = ninshoshaShimeiKakenai;
        this.ninshoshaYakushokuMei = ninshoshaYakushokuMei;
        this.ninshoshaYakushokuMei1 = ninshoshaYakushokuMei1;
        this.ninshoshaYakushokuMei2 = ninshoshaYakushokuMei2;
        this.bunshoNo = bunshoNo;
        this.pageCount = pageCount;
        this.customerBarCode = customerBarCode;
        this.jushoText = jushoText;
        this.kikanNameText = kikanNameText;
        this.shimeiText = shimeiText;
        this.meishoFuyo = meishoFuyo;
        this.sonota = sonota;
        this.tsuchibun2 = tsuchibun2;
        this.yubinNo = yubinNo;
    }
}
