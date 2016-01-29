
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.bemmeisyo;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 弁明書ヘッダのITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class BemmeisyoHeadItem {

    private final RString ninshoshaYakushokuMei;
    // TODO rseファイルにninshoshaShimeiを存在しない。
//    private final RString ninshoshaShimei;
    private final RString denshiKoin;
    private final RString koinShoryaku;
    private final RString koinMojiretsu;
    private final RString sofusakiYubinNo;
    private final RString sofusakiJusho;
    private final RString sofusakiName;
    private final RString midashi;
    private final FlexibleDate bemmeisyoSakuseiYMD;
    private final RString bemmeisyoName;
    private final RString bemmeiNaiyo;
    private final RString hihokenshaNo;
    private final RString hihokenshaName;
    private final RString birthYMD;
    private final RString seibetsu;
    private final RString hihokenshaYubinNo;
    private final RString hihokenshaJusho;

    /**
     * インスタンスを生成します。
     *
     * @param ninshoshaYakushokuMei 認証者役職名
     * @param ninshoshaShimei 認証者氏名
     * @param denshiKoin 電子公印
     * @param koinShoryaku 公印省略
     * @param koinMojiretsu 公印文字列
     * @param sofusakiYubinNo 送付先郵便番号
     * @param sofusakiJusho 送付先住所
     * @param sofusakiName 送付先名称
     * @param midashi 見出し
     * @param bemmeisyoSakuseiYMD 弁明書作成日
     * @param bemmeisyoName 弁明書件名
     * @param bemmeiNaiyo 弁明内容
     * @param hihokenshaNo 被保険者番号
     * @param hihokenshaName 氏名
     * @param birthYMD 生年月日
     * @param seibetsu 性別
     * @param hihokenshaYubinNo 郵便番号
     * @param hihokenshaJusho 住所
     *
     */
    public BemmeisyoHeadItem(
            RString ninshoshaYakushokuMei,
            // TODO rseファイルにninshoshaShimeiを存在しない
            //            RString ninshoshaShimei,
            RString denshiKoin,
            RString koinShoryaku,
            RString koinMojiretsu,
            RString sofusakiYubinNo,
            RString sofusakiJusho,
            RString sofusakiName,
            RString midashi,
            FlexibleDate bemmeisyoSakuseiYMD,
            RString bemmeisyoName,
            RString bemmeiNaiyo,
            RString hihokenshaNo,
            RString hihokenshaName,
            RString birthYMD,
            RString seibetsu,
            RString hihokenshaYubinNo,
            RString hihokenshaJusho) {

        this.ninshoshaYakushokuMei = ninshoshaYakushokuMei;
        // TODO rseファイルにninshoshaShimeiを存在しない
//        this.ninshoshaShimei = ninshoshaShimei;
        this.denshiKoin = denshiKoin;
        this.koinShoryaku = koinShoryaku;
        this.koinMojiretsu = koinMojiretsu;
        this.sofusakiYubinNo = sofusakiYubinNo;
        this.sofusakiJusho = sofusakiJusho;
        this.sofusakiName = sofusakiName;
        this.midashi = midashi;
        this.bemmeisyoSakuseiYMD = bemmeisyoSakuseiYMD;
        this.bemmeisyoName = bemmeisyoName;
        this.bemmeiNaiyo = bemmeiNaiyo;
        this.hihokenshaNo = hihokenshaNo;
        this.hihokenshaName = hihokenshaName;
        this.birthYMD = birthYMD;
        this.seibetsu = seibetsu;
        this.hihokenshaYubinNo = hihokenshaYubinNo;
        this.hihokenshaJusho = hihokenshaJusho;
    }
}
