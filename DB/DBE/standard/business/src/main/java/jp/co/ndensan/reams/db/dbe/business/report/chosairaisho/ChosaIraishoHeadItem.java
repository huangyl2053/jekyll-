/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosairaisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 要介護認定調査依頼書ヘッダのITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaIraishoHeadItem {

    private final RString hakkoYMD1;
    private final RString denshiKoin;
    private final RString ninshoshaYakushokuMei;
    private final RString ninshoshaYakushokuMei2;
    private final RString ninshoshaYakushokuMei1;
    private final RString koinMojiretsu;
    private final RString ninshoshaShimeiKakeru;
    private final RString ninshoshaShimeiKakenai;
    private final RString koinShoryaku;
    private final RString bunshoNo;
    private final RString yubinNo1;
    private final RString jushoText;
    private final RString kikanNameText;
    private final RString shimeiText;
    private final RString meishoFuyo;
    private final RString customerBarCode;
    private final RString sonota;
    private final RString atenaRenban;
    private final RString tsuchibun1;
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
    private final RString hihokenshaNameKana;
    private final RString birthGengoMeiji;
    private final RString birthGengoTaisho;
    private final RString birthGengoShowa;
    private final RString birthYMD;
    private final RString hihokenshaName;
    private final RString seibetsuMan;
    private final RString seibetsuWoman;
    private final RString yubinNo;
    private final RString jusho;
    private final RString telNo;
    private final RString homonChosasakiYubinNo;
    private final RString homonChosasakiJusho1;
    private final RString homonChosasakiJusho2;
    private final RString homonChosasakiJusho3;
    private final RString homonChosasakiTelNo;
    private final RString shinseiYMD;
    private final RString teishutsuKigen;
    private final RString tsuchibun2;
    private final RString remban;

    /**
     * インスタンスを生成します。
     *
     * @param hakkoYMD1 発行YMD
     * @param denshiKoin 電子公印
     * @param ninshoshaYakushokuMei 認証者役職名
     * @param ninshoshaYakushokuMei2 認証者役職名1行目
     * @param ninshoshaYakushokuMei1 認証者役職名1行目
     * @param koinMojiretsu 電子公印文字列
     * @param ninshoshaShimeiKakeru 認証者氏名公印掛ける
     * @param ninshoshaShimeiKakenai 認証者氏名公印掛けない
     * @param koinShoryaku 電子公印省略
     * @param bunshoNo 文書番号
     * @param yubinNo1 宛名郵便番号
     * @param jushoText 宛名住所
     * @param kikanNameText 宛名機関名
     * @param shimeiText 宛名氏名
     * @param meishoFuyo 宛名名称付与
     * @param customerBarCode カスタマーバーコード
     * @param sonota 宛名その他
     * @param atenaRenban 宛名連番
     * @param tsuchibun1 通知文1
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
     * @param hihokenshaNameKana 被保険者氏名フリガナ
     * @param birthGengoMeiji 誕生日明治
     * @param birthGengoTaisho 誕生日大正
     * @param birthGengoShowa 誕生日昭和
     * @param birthYMD 誕生日
     * @param hihokenshaName 被保険者氏名
     * @param seibetsuMan 性別男
     * @param seibetsuWoman 性別女
     * @param yubinNo 被保険者住所(郵便番号)
     * @param jusho 被保険者住所
     * @param telNo 被保険者電話番号
     * @param homonChosasakiYubinNo 訪問調査先住所(郵便番号)
     * @param homonChosasakiJusho1 訪問調査先住所1行目
     * @param homonChosasakiJusho2 訪問調査先住所2行目
     * @param homonChosasakiJusho3 訪問調査先名称
     * @param homonChosasakiTelNo 訪問調査先電話番号
     * @param shinseiYMD 要介護認定（更新）申請日
     * @param teishutsuKigen 要介護認定調査表提出期限
     * @param tsuchibun2 通知文2
     * @param remban 連番
     */
    public ChosaIraishoHeadItem(
            RString hakkoYMD1,
            RString denshiKoin,
            RString ninshoshaYakushokuMei,
            RString ninshoshaYakushokuMei2,
            RString ninshoshaYakushokuMei1,
            RString koinMojiretsu,
            RString ninshoshaShimeiKakeru,
            RString ninshoshaShimeiKakenai,
            RString koinShoryaku,
            RString bunshoNo,
            RString yubinNo1,
            RString jushoText,
            RString kikanNameText,
            RString shimeiText,
            RString meishoFuyo,
            RString customerBarCode,
            RString sonota,
            RString atenaRenban,
            RString tsuchibun1,
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
            RString hihokenshaNameKana,
            RString birthGengoMeiji,
            RString birthGengoTaisho,
            RString birthGengoShowa,
            RString birthYMD,
            RString hihokenshaName,
            RString seibetsuMan,
            RString seibetsuWoman,
            RString yubinNo,
            RString jusho,
            RString telNo,
            RString homonChosasakiYubinNo,
            RString homonChosasakiJusho1,
            RString homonChosasakiJusho2,
            RString homonChosasakiJusho3,
            RString homonChosasakiTelNo,
            RString shinseiYMD,
            RString teishutsuKigen,
            RString tsuchibun2,
            RString remban) {
        this.hakkoYMD1 = hakkoYMD1;
        this.denshiKoin = denshiKoin;
        this.ninshoshaYakushokuMei = ninshoshaYakushokuMei;
        this.ninshoshaYakushokuMei2 = ninshoshaYakushokuMei2;
        this.ninshoshaYakushokuMei1 = ninshoshaYakushokuMei1;
        this.koinMojiretsu = koinMojiretsu;
        this.ninshoshaShimeiKakeru = ninshoshaShimeiKakeru;
        this.ninshoshaShimeiKakenai = ninshoshaShimeiKakenai;
        this.koinShoryaku = koinShoryaku;
        this.bunshoNo = bunshoNo;
        this.yubinNo1 = yubinNo1;
        this.jushoText = jushoText;
        this.kikanNameText = kikanNameText;
        this.shimeiText = shimeiText;
        this.meishoFuyo = meishoFuyo;
        this.customerBarCode = customerBarCode;
        this.sonota = sonota;
        this.atenaRenban = atenaRenban;
        this.tsuchibun1 = tsuchibun1;
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
        this.hihokenshaNameKana = hihokenshaNameKana;
        this.birthGengoMeiji = birthGengoMeiji;
        this.birthGengoTaisho = birthGengoTaisho;
        this.birthGengoShowa = birthGengoShowa;
        this.birthYMD = birthYMD;
        this.hihokenshaName = hihokenshaName;
        this.seibetsuMan = seibetsuMan;
        this.seibetsuWoman = seibetsuWoman;
        this.yubinNo = yubinNo;
        this.jusho = jusho;
        this.telNo = telNo;
        this.homonChosasakiYubinNo = homonChosasakiYubinNo;
        this.homonChosasakiJusho1 = homonChosasakiJusho1;
        this.homonChosasakiJusho2 = homonChosasakiJusho2;
        this.homonChosasakiJusho3 = homonChosasakiJusho3;
        this.homonChosasakiTelNo = homonChosasakiTelNo;
        this.shinseiYMD = shinseiYMD;
        this.teishutsuKigen = teishutsuKigen;
        this.tsuchibun2 = tsuchibun2;
        this.remban = remban;
    }
}
