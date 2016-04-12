/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.dbe223001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 要介護認定調査督促状表情報です。
 *
 * @reamsid_L DBE-0030-020 xuyue
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiChosaTokusokujoBodyItem {

    private final RString hakkoYMD;
    private final RString denshiKoin;
    private final RString koinMojiretsu;
    private final RString koinShoryaku;
    private final RString ninshoshaYakushokuMei;
    private final RString ninshoshaYakushokuMei1;
    private final RString ninshoshaYakushokuMei2;
    private final RString ninshoshaShimeiKakenai;
    private final RString ninshoshaShimeiKakeru;
    private final RString bunshoNo;
    private final RString tsuchibun1;
    private final RString shinseiKubun;
    private final RString hokenshaNo1;
    private final RString hokenshaNo2;
    private final RString hokenshaNo3;
    private final RString hokenshaNo4;
    private final RString hokenshaNo5;
    private final RString hokenshaNo6;
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
    private final RString shinseiYMD;
    private final RString hihokenshaNameKana;
    private final RString seibetsuMan;
    private final RString seibetsuWoman;
    private final RString hihokenshaName;
    private final RString birthGengoMeiji;
    private final RString birthGengoTaisho;
    private final RString birthGengoShowa;
    private final RString birthYMD;
    private final RString yubinNo;
    private final RString jusho;
    private final RString tsuchibun2;
    private final RString yubinNo1;
    private final RString jushoText;
    private final RString kikanNameText;
    private final RString shimeiText;
    private final RString meishoFuyo;
    private final RString customerBarCode;
    private final RString sonota;
    private final RString title;

    /**
     * 要介護認定調査督促状表情報を生成します。
     *
     * @param hakkoYMD 発行日
     * @param denshiKoin 電子公印
     * @param koinMojiretsu 公印文字列
     * @param koinShoryaku 公印省略
     * @param ninshoshaYakushokuMei 認証者役職名
     * @param ninshoshaYakushokuMei1 認証者役職名1
     * @param ninshoshaYakushokuMei2 認証者役職名2
     * @param ninshoshaShimeiKakenai 認証者氏名(公印に掛けない)
     * @param ninshoshaShimeiKakeru 認証者氏名(公印に掛ける)
     * @param bunshoNo 文書番号
     * @param tsuchibun1 通知文定型文1
     * @param shinseiKubun 申請区分
     * @param hokenshaNo1 保険者番号1
     * @param hokenshaNo2 保険者番号2
     * @param hokenshaNo3 保険者番号3
     * @param hokenshaNo4 保険者番号4
     * @param hokenshaNo5 保険者番号5
     * @param hokenshaNo6 保険者番号6
     * @param hihokenshaNo1 被保険者番号1
     * @param hihokenshaNo2 被保険者番号2
     * @param hihokenshaNo3 被保険者番号3
     * @param hihokenshaNo4 被保険者番号4
     * @param hihokenshaNo5 被保険者番号5
     * @param hihokenshaNo6 被保険者番号6
     * @param hihokenshaNo7 被保険者番号7
     * @param hihokenshaNo8 被保険者番号8
     * @param hihokenshaNo9 被保険者番号9
     * @param hihokenshaNo10 被保険者番号10
     * @param shinseiYMD 申請日
     * @param hihokenshaNameKana 被保険者氏名カナ
     * @param seibetsuMan 性別男
     * @param seibetsuWoman 性別女
     * @param hihokenshaName 被保険者氏名
     * @param birthGengoMeiji 誕生日明治
     * @param birthGengoTaisho 誕生日大正
     * @param birthGengoShowa 誕生日昭和
     * @param birthYMD 生年月日
     * @param yubinNo 住所郵便
     * @param jusho 住所
     * @param tsuchibun2 通知文問合せ
     * @param yubinNo1 宛名郵便番号
     * @param jushoText 宛名住所
     * @param kikanNameText 宛名機関名
     * @param shimeiText 宛名氏名
     * @param meishoFuyo 宛名名称付与
     * @param customerBarCode カスタマーバーコード
     * @param sonota 宛名その他
     * @param title タイトル
     */
    public NinteiChosaTokusokujoBodyItem(RString hakkoYMD,
            RString denshiKoin,
            RString koinMojiretsu,
            RString koinShoryaku,
            RString ninshoshaYakushokuMei,
            RString ninshoshaYakushokuMei1,
            RString ninshoshaYakushokuMei2,
            RString ninshoshaShimeiKakenai,
            RString ninshoshaShimeiKakeru,
            RString bunshoNo,
            RString tsuchibun1,
            RString shinseiKubun,
            RString hokenshaNo1,
            RString hokenshaNo2,
            RString hokenshaNo3,
            RString hokenshaNo4,
            RString hokenshaNo5,
            RString hokenshaNo6,
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
            RString shinseiYMD,
            RString hihokenshaNameKana,
            RString seibetsuMan,
            RString seibetsuWoman,
            RString hihokenshaName,
            RString birthGengoMeiji,
            RString birthGengoTaisho,
            RString birthGengoShowa,
            RString birthYMD,
            RString yubinNo,
            RString jusho,
            RString tsuchibun2,
            RString yubinNo1,
            RString jushoText,
            RString kikanNameText,
            RString shimeiText,
            RString meishoFuyo,
            RString customerBarCode,
            RString sonota,
            RString title
    ) {
        this.hakkoYMD = hakkoYMD;
        this.denshiKoin = denshiKoin;
        this.ninshoshaYakushokuMei = ninshoshaYakushokuMei;
        this.ninshoshaYakushokuMei2 = ninshoshaYakushokuMei2;
        this.ninshoshaYakushokuMei1 = ninshoshaYakushokuMei1;
        this.koinMojiretsu = koinMojiretsu;
        this.ninshoshaShimeiKakenai = ninshoshaShimeiKakenai;
        this.ninshoshaShimeiKakeru = ninshoshaShimeiKakeru;
        this.koinShoryaku = koinShoryaku;
        this.bunshoNo = bunshoNo;
        this.tsuchibun1 = tsuchibun1;
        this.shinseiKubun = shinseiKubun;
        this.hokenshaNo1 = hokenshaNo1;
        this.hokenshaNo2 = hokenshaNo2;
        this.hokenshaNo3 = hokenshaNo3;
        this.hokenshaNo4 = hokenshaNo4;
        this.hokenshaNo5 = hokenshaNo5;
        this.hokenshaNo6 = hokenshaNo6;
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
        this.shinseiYMD = shinseiYMD;
        this.hihokenshaNameKana = hihokenshaNameKana;
        this.seibetsuMan = seibetsuMan;
        this.seibetsuWoman = seibetsuWoman;
        this.hihokenshaName = hihokenshaName;
        this.birthGengoMeiji = birthGengoMeiji;
        this.birthGengoTaisho = birthGengoTaisho;
        this.birthGengoShowa = birthGengoShowa;
        this.birthYMD = birthYMD;
        this.yubinNo = yubinNo;
        this.jusho = jusho;
        this.tsuchibun2 = tsuchibun2;
        this.yubinNo1 = yubinNo1;
        this.jushoText = jushoText;
        this.kikanNameText = kikanNameText;
        this.shimeiText = shimeiText;
        this.meishoFuyo = meishoFuyo;
        this.customerBarCode = customerBarCode;
        this.sonota = sonota;
        this.title = title;
    }
}
