/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshosakuseitokusokujo;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 主治医意見書提出督促状のITEMです。
 *
 * @reamsid_L DBE-0060-020 hezhenzhen
 *
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShujiiIkenshoSakuseiTokusokujoItem {

    private final RString bunshoNo;
    private final RString denshikoin;
    private final RString hakkoYMD1;
    private final RString koinMojiretsu;
    private final RString koinShoryaku;
    private final RString ninshoshaShimeiKakeru;
    private final RString ninshoshaYakushokuMei;
    private final RString ninshoshaShimeiKakenai;
    private final RString ninshoshaYakushokuMei1;
    private final RString ninshoshaYakushokuMei2;
    private final RString customerBarCode;
    private final RString yubinNo1;
    private final RString jushoText;
    private final RString kikanNameText;
    private final RString shimeiText;
    private final RString meishoFuyo;
    private final RString sonota;
    private final RString title;
    private final RString tsuchibun1;
    private final RString tsuchibun2;
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
    private final RString hokenshaNo1;
    private final RString hokenshaNo2;
    private final RString hokenshaNo3;
    private final RString hokenshaNo4;
    private final RString hokenshaNo5;
    private final RString hokenshaNo6;
    private final RString shinseiKubun;
    private final RString hihokenshaNameKana;
    private final RString hihokennsyaName;
    private final FlexibleDate ikenshoIraiYMD;
    private final RDate shinseiYMD;
    private final RString yubinNo;
    private final RString jusho;
    private final RDate birthYMD;
    private final RString remban;
    private final RString seyibenMan;
    private final RString seyibenWoman;
    private final RString birthGengoMeiji;
    private final RString birthGengoTaisho;
    private final RString birthGengoShowa;
    private final RString shoriName;

    /**
     * インスタンスを生成します
     *
     * @param bunshoNo 文書番号
     * @param denshikoin 電子公印
     * @param hakkoYMD1 発行年月日
     * @param koinMojiretsu 電子公印文字列
     * @param koinShoryaku 電子公印省略
     * @param ninshoshaShimeiKakeru 認証者氏名公印掛ける
     * @param ninshoshaYakushokuMei 認証者役職名
     * @param ninshoshaShimeiKakenai 認証者氏名公印掛けない
     * @param ninshoshaYakushokuMei1 認証者役職名1行目
     * @param ninshoshaYakushokuMei2 認証者役職名2行目
     * @param customerBarCode カスタマーバーコード
     * @param yubinNo1 宛名郵便番号
     * @param jushoText 宛名住所
     * @param kikanNameText 宛名機関名
     * @param shimeiText 宛名氏名
     * @param meishoFuyo 宛名名称付与
     * @param sonota 宛名その他
     * @param title タイトル
     * @param tsuchibun1 通知文1
     * @param tsuchibun2 通知文2
     * @param hihokenshaNo1 被保険者番号1
     * @param hihokenshaNo2 被保険者番号2
     * @param hihokenshaNo3 被保険者番号3
     * @param hihokenshaNo4 被保険者番号4
     * @param hihokenshaNo5 被保険者番号5
     * @param hihokenshaNo6 被保険者番号6
     * @param hihokenshaNo7 被保険者番号7
     * @param hihokenshaNo8 被保険者番号8
     * @param hihokenshaNo9 被保険者番号9
     * @param hihokenshaNo10 被保険者番号01
     * @param hokenshaNo1 保険者番号1
     * @param hokenshaNo2 保険者番号2
     * @param hokenshaNo3 保険者番号3
     * @param hokenshaNo4 保険者番号4
     * @param hokenshaNo5 保険者番号5
     * @param hokenshaNo6 保険者番号6
     * @param shinseiKubun 申請区分
     * @param hihokenshaNameKana 被保険者氏名カナ
     * @param hihokennsyaName 被保険者氏名
     * @param ikenshoIraiYMD 意見書依頼日
     * @param shinseiYMD 申請日
     * @param yubinNo 郵便番号
     * @param jusho 住所
     * @param birthYMD 誕生日
     * @param remban 連番
     * @param seyibenMan 性別男
     * @param seyibenWoman 性別女
     * @param birthGengoMeiji 誕生日明治birthGengoMeiji
     * @param birthGengoTaisho 誕生日大正
     * @param birthGengoShowa 誕生日昭和
     * @param shoriName 処理名
     */
    public ShujiiIkenshoSakuseiTokusokujoItem(RString bunshoNo, RString denshikoin, RString hakkoYMD1,
            RString koinMojiretsu, RString koinShoryaku, RString ninshoshaShimeiKakeru, RString ninshoshaYakushokuMei, RString ninshoshaShimeiKakenai,
            RString ninshoshaYakushokuMei1, RString ninshoshaYakushokuMei2, RString customerBarCode,
            RString yubinNo1, RString jushoText, RString kikanNameText, RString shimeiText, RString meishoFuyo, RString sonota,
            RString title, RString tsuchibun1,
            RString tsuchibun2, RString hihokenshaNo1, RString hihokenshaNo2, RString hihokenshaNo3,
            RString hihokenshaNo4, RString hihokenshaNo5, RString hihokenshaNo6, RString hihokenshaNo7,
            RString hihokenshaNo8, RString hihokenshaNo9, RString hihokenshaNo10, RString hokenshaNo1,
            RString hokenshaNo2, RString hokenshaNo3, RString hokenshaNo4, RString hokenshaNo5, RString hokenshaNo6,
            RString shinseiKubun, RString hihokenshaNameKana, RString hihokennsyaName, FlexibleDate ikenshoIraiYMD, RDate shinseiYMD,
            RString yubinNo, RString jusho, RDate birthYMD, RString remban,
            RString seyibenMan, RString seyibenWoman, RString birthGengoMeiji, RString birthGengoTaisho,
            RString birthGengoShowa, RString shoriName) {
        this.bunshoNo = bunshoNo;
        this.denshikoin = denshikoin;
        this.hakkoYMD1 = hakkoYMD1;
        this.koinMojiretsu = koinMojiretsu;
        this.koinShoryaku = koinShoryaku;
        this.ninshoshaShimeiKakeru = ninshoshaShimeiKakeru;
        this.ninshoshaYakushokuMei = ninshoshaYakushokuMei;
        this.ninshoshaShimeiKakenai = ninshoshaShimeiKakenai;
        this.ninshoshaYakushokuMei1 = ninshoshaYakushokuMei1;
        this.ninshoshaYakushokuMei2 = ninshoshaYakushokuMei2;
        this.customerBarCode = customerBarCode;
        this.yubinNo1 = yubinNo1;
        this.jushoText = jushoText;
        this.kikanNameText = kikanNameText;
        this.shimeiText = shimeiText;
        this.meishoFuyo = meishoFuyo;
        this.sonota = sonota;
        this.title = title;
        this.tsuchibun1 = tsuchibun1;
        this.tsuchibun2 = tsuchibun2;
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
        this.hokenshaNo1 = hokenshaNo1;
        this.hokenshaNo2 = hokenshaNo2;
        this.hokenshaNo3 = hokenshaNo3;
        this.hokenshaNo4 = hokenshaNo4;
        this.hokenshaNo5 = hokenshaNo5;
        this.hokenshaNo6 = hokenshaNo6;
        this.shinseiKubun = shinseiKubun;
        this.hihokenshaNameKana = hihokenshaNameKana;
        this.hihokennsyaName = hihokennsyaName;
        this.ikenshoIraiYMD = ikenshoIraiYMD;
        this.shinseiYMD = shinseiYMD;
        this.yubinNo = yubinNo;
        this.jusho = jusho;
        this.birthYMD = birthYMD;
        this.remban = remban;
        this.seyibenMan = seyibenMan;
        this.seyibenWoman = seyibenWoman;
        this.birthGengoMeiji = birthGengoMeiji;
        this.birthGengoTaisho = birthGengoTaisho;
        this.birthGengoShowa = birthGengoShowa;
        this.shoriName = shoriName;
    }

}
