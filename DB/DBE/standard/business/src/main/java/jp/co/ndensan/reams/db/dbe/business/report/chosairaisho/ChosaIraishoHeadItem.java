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

    private final RString shomeiHakkoYMD;
    private final RString denshiKoin1;
    private final RString shichosonMei;
    private final RString shuchoMei;
    private final RString koinShoryaku;
    private final RString bunshoNo;
    private final RString hakkoYMD;
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
    private final RString tsuchibun1;
    private final RString tsuchibun2;
    private final RString tsuchibun3;
    private final RString tsuchibun4;
    private final RString tsuchibun5;
    private final RString tsuchibun6;
    private final RString tsuchibun7;
    private final RString tsuchibun8;
    private final RString tsuchibun9;
    private final RString tsuchibun10;
    private final RString tsuchibun11;
    private final RString tsuchibun12;
    private final RString tsuchibun13;
    private final RString tsuchibun14;
    private final RString tsuchibun15;
    private final RString tsuchibun16;
    private final RString tsuchibun17;
    private final RString tsuchibun18;
    private final RString tsuchibun19;
    private final RString remban;

    /**
     * インスタンスを生成します。
     *
     * @param shomeiHakkoYMD 証明発行YMD
     * @param denshiKoin1 電子公印
     * @param shichosonMei 市町村名
     * @param shuchoMei 首長名
     * @param koinShoryaku 公印省略
     * @param bunshoNo 文書番号
     * @param hakkoYMD 発行YMD
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
     * @param homonChosasakiJusho1 訪問調査先住所1
     * @param homonChosasakiJusho2 訪問調査先住所2
     * @param homonChosasakiJusho3 訪問調査先名称
     * @param homonChosasakiTelNo 訪問調査先電話番号
     * @param shinseiYMD 要介護認定（更新）申請日
     * @param teishutsuKigen 要介護認定調査表提出期限
     * @param tsuchibun1 通知文1
     * @param tsuchibun2 通知文2
     * @param tsuchibun3 通知文3
     * @param tsuchibun4 通知文4
     * @param tsuchibun5 通知文5
     * @param tsuchibun6 通知文6
     * @param tsuchibun7 通知文7
     * @param tsuchibun8 通知文7
     * @param tsuchibun9 通知文9
     * @param tsuchibun10 通知文10
     * @param tsuchibun11 通知文11
     * @param tsuchibun12 通知文12
     * @param tsuchibun13 通知文13
     * @param tsuchibun14 通知文14
     * @param tsuchibun15 通知文15
     * @param tsuchibun16 通知文16
     * @param tsuchibun17 通知文17
     * @param tsuchibun18 通知文18
     * @param tsuchibun19 通知文19
     * @param remban 連番
     */
    public ChosaIraishoHeadItem(
            RString shomeiHakkoYMD,
            RString denshiKoin1,
            RString shichosonMei,
            RString shuchoMei,
            RString koinShoryaku,
            RString bunshoNo,
            RString hakkoYMD,
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
            RString tsuchibun1,
            RString tsuchibun2,
            RString tsuchibun3,
            RString tsuchibun4,
            RString tsuchibun5,
            RString tsuchibun6,
            RString tsuchibun7,
            RString tsuchibun8,
            RString tsuchibun9,
            RString tsuchibun10,
            RString tsuchibun11,
            RString tsuchibun12,
            RString tsuchibun13,
            RString tsuchibun14,
            RString tsuchibun15,
            RString tsuchibun16,
            RString tsuchibun17,
            RString tsuchibun18,
            RString tsuchibun19,
            RString remban) {
        this.shomeiHakkoYMD = shomeiHakkoYMD;
        this.denshiKoin1 = denshiKoin1;
        this.shichosonMei = shichosonMei;
        this.shuchoMei = shuchoMei;
        this.koinShoryaku = koinShoryaku;
        this.bunshoNo = bunshoNo;
        this.hakkoYMD = hakkoYMD;
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
        this.tsuchibun1 = tsuchibun1;
        this.tsuchibun2 = tsuchibun2;
        this.tsuchibun3 = tsuchibun3;
        this.tsuchibun4 = tsuchibun4;
        this.tsuchibun5 = tsuchibun5;
        this.tsuchibun6 = tsuchibun6;
        this.tsuchibun7 = tsuchibun7;
        this.tsuchibun8 = tsuchibun8;
        this.tsuchibun9 = tsuchibun9;
        this.tsuchibun10 = tsuchibun10;
        this.tsuchibun11 = tsuchibun11;
        this.tsuchibun12 = tsuchibun12;
        this.tsuchibun13 = tsuchibun13;
        this.tsuchibun14 = tsuchibun14;
        this.tsuchibun15 = tsuchibun15;
        this.tsuchibun16 = tsuchibun16;
        this.tsuchibun17 = tsuchibun17;
        this.tsuchibun18 = tsuchibun18;
        this.tsuchibun19 = tsuchibun19;
        this.remban = remban;

    }
}
