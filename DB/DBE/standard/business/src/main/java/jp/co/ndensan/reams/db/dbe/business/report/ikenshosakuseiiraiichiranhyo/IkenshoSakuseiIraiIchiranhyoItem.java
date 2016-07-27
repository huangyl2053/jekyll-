/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshosakuseiiraiichiranhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 主治医意見書作成依頼一覧のITEMです。
 *
 * @reamsid_L DBE-0080-090 zhangzhiming
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IkenshoSakuseiIraiIchiranhyoItem {

    private RString hakkoYMD;
    private RString denshiKoin;
    private RString ninshoshaYakushokuMei1;
    private RString ninshoshaYakushokuMei;
    private RString ninshoshaYakushokuMei2;
    private RString ninshoshaShimeiKakeru;
    private RString ninshoshaShimeiKakenai;
    private RString koinMojiretsu;
    private RString koinShoryaku;
    private RString yubinNo1;
    private RString jushoText;
    private RString kikanNameText;
    private RString shimeiText;
    private RString meishoFuyo;
    private RString printTimeStamp;
    private RString tsuchibun1;
    private RString listIchiranhyo_2;
    private RString listIchiranhyo_3;
    private RString listIchiranhyo_4;
    private RString listIchiranhyo_5;
    private RString listIchiranhyo_6;
    private RString listIchiranhyo_7;
    private RString listIchiranhyo_8;
    private RString listIchiranhyo_9;
    private RString shujiiIryokikanCode;

    /**
     * コンストラクタを作成します。
     */
    public IkenshoSakuseiIraiIchiranhyoItem() {
    }

    /**
     * コンストラクタを作成します。
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
     * @param listIchiranhyo_2 担当医
     * @param listIchiranhyo_3 被保険者番号
     * @param listIchiranhyo_4 被保険者名
     * @param listIchiranhyo_5 被保険者名（カナ）
     * @param listIchiranhyo_6 住所
     * @param listIchiranhyo_7 生年月日
     * @param listIchiranhyo_8 性別
     * @param listIchiranhyo_9 提出期限
     * @param shujiiIryokikanCode 主治医医療機関コード
     */
    public IkenshoSakuseiIraiIchiranhyoItem(RString hakkoYMD, RString denshiKoin, RString ninshoshaYakushokuMei1,
            RString ninshoshaYakushokuMei, RString ninshoshaYakushokuMei2, RString ninshoshaShimeiKakeru,
            RString ninshoshaShimeiKakenai, RString koinMojiretsu, RString koinShoryaku, RString yubinNo1,
            RString jushoText, RString kikanNameText, RString shimeiText, RString meishoFuyo, RString printTimeStamp,
            RString tsuchibun1, RString listIchiranhyo_2, RString listIchiranhyo_3, RString listIchiranhyo_4,
            RString listIchiranhyo_5, RString listIchiranhyo_6, RString listIchiranhyo_7, RString listIchiranhyo_8,
            RString listIchiranhyo_9,
            RString shujiiIryokikanCode) {
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
        this.listIchiranhyo_2 = listIchiranhyo_2;
        this.listIchiranhyo_3 = listIchiranhyo_3;
        this.listIchiranhyo_4 = listIchiranhyo_4;
        this.listIchiranhyo_5 = listIchiranhyo_5;
        this.listIchiranhyo_6 = listIchiranhyo_6;
        this.listIchiranhyo_7 = listIchiranhyo_7;
        this.listIchiranhyo_8 = listIchiranhyo_8;
        this.listIchiranhyo_9 = listIchiranhyo_9;
        this.shujiiIryokikanCode = shujiiIryokikanCode;
    }
}
