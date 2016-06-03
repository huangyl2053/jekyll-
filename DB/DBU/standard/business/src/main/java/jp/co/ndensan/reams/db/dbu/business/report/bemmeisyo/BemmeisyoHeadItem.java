
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.bemmeisyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 弁明書ヘッダのITEMです。
 *
 * @reamsid_L DBU-1080-150 linghuhang
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class BemmeisyoHeadItem {

    private final RString sofusakiYubinNo;
    private final RString sofusakiJusho;
    private final RString sofusakiName;
    private final RString midashi;
    private final RString bemmeisyoName;
    private final RString bemmeiNaiyo;
    private final RString hihokenshaNo;
    private final RString hihokenshaName;
    private final RString birthYMD;
    private final RString seibetsu;
    private final RString hihokenshaYubinNo;
    private final RString hihokenshaJusho;
    private final RString hakkoYMD;
    private final RString denshiKoin;
    private final RString ninshoshaYakushokuMei;
    private final RString koinMojiretsu;
    private final RString ninshoshaShimeiKakenai;
    private final RString ninshoshaShimeiKakeru;
    private final RString koinShoryaku;

    /**
     * インスタンスを生成します。
     *
     * @param sofusakiYubinNo 送付先郵便番号
     * @param sofusakiJusho 送付先住所
     * @param sofusakiName 送付先名称
     * @param midashi 見出し
     * @param bemmeisyoName 弁明書件名
     * @param bemmeiNaiyo 弁明内容
     * @param hihokenshaNo 被保険者番号
     * @param hihokenshaName 氏名
     * @param birthYMD 生年月日
     * @param seibetsu 性別
     * @param hihokenshaYubinNo 郵便番号
     * @param hihokenshaJusho 住所
     * @param hakkoYMD 発行日
     * @param denshiKoin 電子公印
     * @param ninshoshaYakushokuMei 認証者役職名
     * @param koinMojiretsu 公印文字列
     * @param ninshoshaShimeiKakenai 認証者氏名(公印に掛けない)
     * @param ninshoshaShimeiKakeru 認証者氏名(公印に掛ける)
     * @param koinShoryaku 公印省略
     *
     */
    public BemmeisyoHeadItem(
            RString sofusakiYubinNo,
            RString sofusakiJusho,
            RString sofusakiName,
            RString midashi,
            RString bemmeisyoName,
            RString bemmeiNaiyo,
            RString hihokenshaNo,
            RString hihokenshaName,
            RString birthYMD,
            RString seibetsu,
            RString hihokenshaYubinNo,
            RString hihokenshaJusho,
            RString hakkoYMD,
            RString denshiKoin,
            RString ninshoshaYakushokuMei,
            RString koinMojiretsu,
            RString ninshoshaShimeiKakenai,
            RString ninshoshaShimeiKakeru,
            RString koinShoryaku) {

        this.sofusakiYubinNo = sofusakiYubinNo;
        this.sofusakiJusho = sofusakiJusho;
        this.sofusakiName = sofusakiName;
        this.midashi = midashi;
        this.bemmeisyoName = bemmeisyoName;
        this.bemmeiNaiyo = bemmeiNaiyo;
        this.hihokenshaNo = hihokenshaNo;
        this.hihokenshaName = hihokenshaName;
        this.birthYMD = birthYMD;
        this.seibetsu = seibetsu;
        this.hihokenshaYubinNo = hihokenshaYubinNo;
        this.hihokenshaJusho = hihokenshaJusho;
        this.hakkoYMD = hakkoYMD;
        this.denshiKoin = denshiKoin;
        this.ninshoshaYakushokuMei = ninshoshaYakushokuMei;
        this.koinMojiretsu = koinMojiretsu;
        this.ninshoshaShimeiKakenai = ninshoshaShimeiKakenai;
        this.ninshoshaShimeiKakeru = ninshoshaShimeiKakeru;
        this.koinShoryaku = koinShoryaku;

    }
}
