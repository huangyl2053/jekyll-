/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshosakuseitokusokujo;

import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 主治医意見書提出督促状のITEMです。
 *
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShujiiIkenshoSakuseiTokusokujoItem {

    private final RString bunshoNo;
    private final RString denshikoin;
    private final RDate hakkoYMD;
    private final RString shomeiHakkoYMD;
    private final RString shichosonMei;
    private final RString shuchoMei;
    private final RString koinShoryaku;
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
    private final RDate shinseiYMD;
    private final RString yubinNo;
    private final RString jusho;
    private final RDate birthYMD;
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
    private final RString seyibenMan;
    private final RString seyibenWoman;
    private final RString birthYMDseyiji;
    private final RString birthYMDdayiseyi;
    private final RString birthYMDsyowa;

    /**
     * インスタンスを生成します
     *
     * @param bunshoNo 文書番号
     * @param denshikoin 電子公印
     * @param hakkoYMD 発行年月日
     * @param shomeiHakkoYMD 証明発行年月日
     * @param shichosonMei 市町村名称
     * @param shuchoMei 首長名
     * @param koinShoryaku 公印省略
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
     * @param shinseiYMD 申請日
     * @param yubinNo 郵便番号
     * @param jusho 住所
     * @param birthYMD 誕生日
     * @param tsuchibun3 通知文3
     * @param tsuchibun4 通知文4
     * @param tsuchibun5 通知文5
     * @param tsuchibun6 通知文6
     * @param tsuchibun7 通知文7
     * @param tsuchibun8 通知文8
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
     * @param seyibenMan 性別男
     * @param seyibenWoman 性別女
     * @param birthYMDseyiji 誕生日明治
     * @param birthYMDdayiseyi 誕生日大正
     * @param birthYMDsyowa 誕生日昭和
     */
    public ShujiiIkenshoSakuseiTokusokujoItem(RString bunshoNo, RString denshikoin, RDate hakkoYMD,
            RString shomeiHakkoYMD, RString shichosonMei, RString shuchoMei, RString koinShoryaku, RString tsuchibun1,
            RString tsuchibun2, RString hihokenshaNo1, RString hihokenshaNo2, RString hihokenshaNo3,
            RString hihokenshaNo4, RString hihokenshaNo5, RString hihokenshaNo6, RString hihokenshaNo7,
            RString hihokenshaNo8, RString hihokenshaNo9, RString hihokenshaNo10, RString hokenshaNo1,
            RString hokenshaNo2, RString hokenshaNo3, RString hokenshaNo4, RString hokenshaNo5, RString hokenshaNo6,
            RString shinseiKubun, RString hihokenshaNameKana, RString hihokennsyaName, RDate shinseiYMD,
            RString yubinNo, RString jusho, RDate birthYMD, RString tsuchibun3, RString tsuchibun4, RString tsuchibun5,
            RString tsuchibun6, RString tsuchibun7, RString tsuchibun8, RString tsuchibun9, RString tsuchibun10,
            RString tsuchibun11, RString tsuchibun12, RString tsuchibun13, RString tsuchibun14, RString tsuchibun15,
            RString tsuchibun16, RString tsuchibun17, RString tsuchibun18, RString tsuchibun19, RString remban,
            RString seyibenMan, RString seyibenWoman, RString birthYMDseyiji, RString birthYMDdayiseyi,
            RString birthYMDsyowa) {
        this.bunshoNo = bunshoNo;
        this.denshikoin = denshikoin;
        this.hakkoYMD = hakkoYMD;
        this.shomeiHakkoYMD = shomeiHakkoYMD;
        this.shichosonMei = shichosonMei;
        this.shuchoMei = shuchoMei;
        this.koinShoryaku = koinShoryaku;
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
        this.shinseiYMD = shinseiYMD;
        this.yubinNo = yubinNo;
        this.jusho = jusho;
        this.birthYMD = birthYMD;
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
        this.seyibenMan = seyibenMan;
        this.seyibenWoman = seyibenWoman;
        this.birthYMDseyiji = birthYMDseyiji;
        this.birthYMDdayiseyi = birthYMDdayiseyi;
        this.birthYMDsyowa = birthYMDsyowa;
    }

}
