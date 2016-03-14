/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshosakuseiiraiichiranhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 主治医意見書作成依頼一覧のITEMです。
 *
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IkenshoSakuseiIraiIchiranhyoHeadItem {

    private final RString hakkoYMD;
    private final RString denshiKoin;
    private final RString ninshoshaYakushokuMei1;
    private final RString ninshoshaYakushokuMei;
    private final RString ninshoshaYakushokuMei2;
    private final RString ninshoshaShimeiKakeru;
    private final RString ninshoshaShimeiKakenai;
    private final RString koinMojiretsu;
    private final RString koinShoryaku;
    private final RString yubinNo1;
    private final RString jushoText;
    private final RString kikanNameText;
    private final RString shimeiText;
    private final RString meishoFuyo;
    private final RString printTimeStamp;
    private final RString tsuchibun1;

    /**
     * インスタンスを生成します。
     *
     * @param hakkoYMD 発行日
     * @param denshiKoin 電子公印
     * @param ninshoshaYakushokuMei1 認証者役職名1
     * @param ninshoshaYakushokuMei 認証者役職名
     * @param ninshoshaYakushokuMei2 認証者役職名2
     * @param ninshoshaShimeiKakeru 認証者氏名(公印に掛ける)
     * @param ninshoshaShimeiKakenai 認証者氏名(公印に掛けない)
     * @param koinMojiretsu 公印文字列
     * @param koinShoryaku 公印省略
     * @param yubinNo1 郵便番号
     * @param jushoText 住所
     * @param kikanNameText 機関名称
     * @param shimeiText 氏名
     * @param meishoFuyo 名称付与
     * @param printTimeStamp 印刷時点
     * @param tsuchibun1 通知文
     */
    public IkenshoSakuseiIraiIchiranhyoHeadItem(RString hakkoYMD, RString denshiKoin, RString ninshoshaYakushokuMei1,
            RString ninshoshaYakushokuMei, RString ninshoshaYakushokuMei2, RString ninshoshaShimeiKakeru, RString ninshoshaShimeiKakenai,
            RString koinMojiretsu, RString koinShoryaku, RString yubinNo1, RString jushoText, RString kikanNameText, RString shimeiText,
            RString meishoFuyo, RString printTimeStamp, RString tsuchibun1) {
        this.hakkoYMD = hakkoYMD;
        this.denshiKoin = denshiKoin;
        this.ninshoshaYakushokuMei1 = ninshoshaYakushokuMei1;
        this.ninshoshaYakushokuMei = ninshoshaYakushokuMei;
        this.ninshoshaYakushokuMei2 = ninshoshaYakushokuMei2;
        this.ninshoshaShimeiKakeru = ninshoshaShimeiKakeru;
        this.ninshoshaShimeiKakenai = ninshoshaShimeiKakenai;
        this.koinMojiretsu = koinMojiretsu;
        this.koinShoryaku = koinShoryaku;
        this.yubinNo1 = yubinNo1;
        this.jushoText = jushoText;
        this.kikanNameText = kikanNameText;
        this.shimeiText = shimeiText;
        this.meishoFuyo = meishoFuyo;
        this.printTimeStamp = printTimeStamp;
        this.tsuchibun1 = tsuchibun1;
    }
}
