/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.chosairaiichiranhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 認定調査依頼一覧表ボディのITEMです。
 *
 * @reamsid_L DBE-0010-030 lishengli
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaIraiIchiranhyoBodyItem {

    private final RString hakkoYMD;
    private final RString denshiKoin;
    private final RString ninshoshaYakushokuMei;
    private final RString ninshoshaYakushokuMei2;
    private final RString ninshoshaYakushokuMei1;
    private final RString ninshoshaShimeiKakenai;
    private final RString ninshoshaShimeiKakeru;
    private final RString koinMojiretsu;
    private final RString koinShoryaku;
    private final RString yubinNo1;
    private final RString jushoText;
    private final RString kikanNameText;
    private final RString shimeiText;
    private final RString meishoFuyo;
    private final RString jigyoshaNo;
    private final RString tsuchibun1;
    private final RString tsuchibun2;
    private final RString listIchiranhyo_1;
    private final RString listIchiranhyo_2;
    private final RString listIchiranhyo_3;
    private final RString listIchiranhyo_4;
    private final RString listIchiranhyo_5;
    private final RString listIchiranhyo_6;
    private final RString listIchiranhyo_7;
    private final RString listIchiranhyo_8;
    private final RString listIchiranhyo_9;
    private final RString listIchiranhyo_10;
    private final RString listIchiranhyo_11;
    private final RString listIchiranhyo_12;

    /**
     * インスタンスを生成します。
     *
     * @param hakkoYMD 発行YMD
     * @param denshiKoin 電子公印
     * @param ninshoshaYakushokuMei 認証者役職名
     * @param ninshoshaYakushokuMei2 認証者役職名2行目
     * @param ninshoshaYakushokuMei1 認証者役職名1行目
     * @param ninshoshaShimeiKakenai 認証者氏名公印掛けない
     * @param ninshoshaShimeiKakeru 認証者氏名公印掛ける
     * @param koinMojiretsu 電子公印文字列
     * @param koinShoryaku 電子公印省略
     * @param yubinNo1 宛名郵便番号
     * @param jushoText 宛名住所
     * @param kikanNameText 宛名機関名
     * @param shimeiText 宛名氏名
     * @param meishoFuyo 宛名名称付与
     * @param jigyoshaNo 事業者番号
     * @param tsuchibun1 通知文1
     * @param tsuchibun2 通知文2
     * @param listIchiranhyo_1 No.
     * @param listIchiranhyo_2 調査員名
     * @param listIchiranhyo_3 被保険者番号
     * @param listIchiranhyo_4 申請日
     * @param listIchiranhyo_5 申請区分
     * @param listIchiranhyo_6 被保険者名
     * @param listIchiranhyo_7 被保険者名(カナ)
     * @param listIchiranhyo_8 性別
     * @param listIchiranhyo_9 生年月日
     * @param listIchiranhyo_10 住所
     * @param listIchiranhyo_11 電話番号
     * @param listIchiranhyo_12 提出期限
     */
    public ChosaIraiIchiranhyoBodyItem(
            RString hakkoYMD,
            RString denshiKoin,
            RString ninshoshaYakushokuMei,
            RString ninshoshaYakushokuMei2,
            RString ninshoshaYakushokuMei1,
            RString ninshoshaShimeiKakenai,
            RString ninshoshaShimeiKakeru,
            RString koinMojiretsu,
            RString koinShoryaku,
            RString yubinNo1,
            RString jushoText,
            RString kikanNameText,
            RString shimeiText,
            RString meishoFuyo,
            RString jigyoshaNo,
            RString tsuchibun1,
            RString tsuchibun2,
            RString listIchiranhyo_1,
            RString listIchiranhyo_2,
            RString listIchiranhyo_3,
            RString listIchiranhyo_4,
            RString listIchiranhyo_5,
            RString listIchiranhyo_6,
            RString listIchiranhyo_7,
            RString listIchiranhyo_8,
            RString listIchiranhyo_9,
            RString listIchiranhyo_10,
            RString listIchiranhyo_11,
            RString listIchiranhyo_12) {
        this.hakkoYMD = hakkoYMD;
        this.denshiKoin = denshiKoin;
        this.ninshoshaYakushokuMei = ninshoshaYakushokuMei;
        this.ninshoshaYakushokuMei2 = ninshoshaYakushokuMei2;
        this.ninshoshaYakushokuMei1 = ninshoshaYakushokuMei1;
        this.ninshoshaShimeiKakenai = ninshoshaShimeiKakenai;
        this.ninshoshaShimeiKakeru = ninshoshaShimeiKakeru;
        this.koinMojiretsu = koinMojiretsu;
        this.koinShoryaku = koinShoryaku;
        this.yubinNo1 = yubinNo1;
        this.jushoText = jushoText;
        this.kikanNameText = kikanNameText;
        this.shimeiText = shimeiText;
        this.meishoFuyo = meishoFuyo;
        this.jigyoshaNo = jigyoshaNo;
        this.tsuchibun1 = tsuchibun1;
        this.tsuchibun2 = tsuchibun2;
        this.listIchiranhyo_1 = listIchiranhyo_1;
        this.listIchiranhyo_2 = listIchiranhyo_2;
        this.listIchiranhyo_3 = listIchiranhyo_3;
        this.listIchiranhyo_4 = listIchiranhyo_4;
        this.listIchiranhyo_5 = listIchiranhyo_5;
        this.listIchiranhyo_6 = listIchiranhyo_6;
        this.listIchiranhyo_7 = listIchiranhyo_7;
        this.listIchiranhyo_8 = listIchiranhyo_8;
        this.listIchiranhyo_9 = listIchiranhyo_9;
        this.listIchiranhyo_10 = listIchiranhyo_10;
        this.listIchiranhyo_11 = listIchiranhyo_11;
        this.listIchiranhyo_12 = listIchiranhyo_12;
    }

}
