/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.ninteichosahyogaikyochosa;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 要介護認定調査票（概況調査）のItemです。
 *
 * @reamsid_L DBE-0080-030 xuyannan
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosahyoGaikyochosaItem {

    private final RString hokenshaNo1;
    private final RString hokenshaNo2;
    private final RString hokenshaNo3;
    private final RString hokenshaNo4;
    private final RString hokenshaNo5;
    private final RString hokenshaNo6;
    private final RString shinseiYY1;
    private final RString shinseiYY2;
    private final RString shinseiMM1;
    private final RString shinseiMM2;
    private final RString shinseiDD1;
    private final RString shinseiDD2;
    private final RString hishokenshaNo1;
    private final RString hishokenshaNo2;
    private final RString hishokenshaNo3;
    private final RString hishokenshaNo4;
    private final RString hishokenshaNo5;
    private final RString hishokenshaNo6;
    private final RString hishokenshaNo7;
    private final RString hishokenshaNo8;
    private final RString hishokenshaNo9;
    private final RString hishokenshaNo10;
    private final RString homonChosainNo1;
    private final RString homonChosainNo2;
    private final RString homonChosainNo3;
    private final RString homonChosainNo4;
    private final RString homonChosainNo5;
    private final RString homonChosainNo6;
    private final RString homonChosainNo7;
    private final RString homonChosainNo8;
    private final RString homonChosainName;
    private final RString homonChosasakiNo1;
    private final RString homonChosasakiNo2;
    private final RString homonChosasakiNo3;
    private final RString homonChosasakiNo4;
    private final RString homonChosasakiNo5;
    private final RString homonChosasakiNo6;
    private final RString homonChosasakiNo7;
    private final RString homonChosasakiNo8;
    private final RString homonChosasakiNo9;
    private final RString homonChosasakiNo10;
    private final RString homonChosasakiNo11;
    private final RString homonChosasakiNo12;
    private final RString jigyoshaMeisho;
    private final RString shinseishaNameKana;
    private final RString shinseishaName;
    private final RString seibetsuMan;
    private final RString seibetsuWoman;
    private final RString shinseishaJusho;
    private final RString shinseishaYubinNo;
    private final RString shinseishTelNo;
    private final RString meiji;
    private final RString taisho;
    private final RString showa;
    private final RString birthYY;
    private final RString birthMM;
    private final RString birthDD;
    private final RString age;
    private final RString kazokuRenrakusakiJusho;
    private final RString kazokuRenrakusakiYubinNo;
    private final RString kazokuRenrakusakiTel1;
    private final RString kazokuRenrakusakiTel2;
    private final RString kazokuRenrakusakiName;
    private final RString shinseishatonoKankei;
    private final RString shokai;
    private final RString nikaime;
    private final RString zenkaiNinteiYYYY;
    private final RString zenkaiNinteiMM;
    private final RString zenkaiNinteiDD;
    private final RString higaito;
    private final RString yoshien;
    private final RString yoshiendo;
    private final RString yokaigo;
    private final RString yokaigodo;

    /**
     * コンストラクタです。
     *
     * @param hokenshaNo1 保険者番号1
     * @param hokenshaNo2 保険者番号2
     * @param hokenshaNo3 保険者番号3
     * @param hokenshaNo4 保険者番号4
     * @param hokenshaNo5 保険者番号5
     * @param hokenshaNo6 保険者番号6
     * @param shinseiYY1 申請日．年1
     * @param shinseiYY2 申請日．年2
     * @param shinseiMM1 申請日．月1
     * @param shinseiMM2 申請日．月2
     * @param shinseiDD1 申請日．日1
     * @param shinseiDD2 申請日．日2
     * @param hishokenshaNo1 被保険者番号1
     * @param hishokenshaNo2 被保険者番号2
     * @param hishokenshaNo3 被保険者番号3
     * @param hishokenshaNo4 被保険者番号4
     * @param hishokenshaNo5 被保険者番号5
     * @param hishokenshaNo6 被保険者番号6
     * @param hishokenshaNo7 被保険者番号7
     * @param hishokenshaNo8 被保険者番号8
     * @param hishokenshaNo9 被保険者番号9
     * @param hishokenshaNo10 被保険者番号10
     * @param homonChosainNo1 記入者コード1
     * @param homonChosainNo2 記入者コード2
     * @param homonChosainNo3 記入者コード3
     * @param homonChosainNo4 記入者コード4
     * @param homonChosainNo5 記入者コード5
     * @param homonChosainNo6 記入者コード6
     * @param homonChosainNo7 記入者コード7
     * @param homonChosainNo8 記入者コード8
     * @param homonChosainName 記入者．氏名
     * @param homonChosasakiNo1 所属機関コード1
     * @param homonChosasakiNo2 所属機関コード2
     * @param homonChosasakiNo3 所属機関コード3
     * @param homonChosasakiNo4 所属機関コード4
     * @param homonChosasakiNo5 所属機関コード5
     * @param homonChosasakiNo6 所属機関コード6
     * @param homonChosasakiNo7 所属機関コード7
     * @param homonChosasakiNo8 所属機関コード8
     * @param homonChosasakiNo9 所属機関コード9
     * @param homonChosasakiNo10 所属機関コード10
     * @param homonChosasakiNo11 所属機関コード11
     * @param homonChosasakiNo12 所属機関コード12
     * @param jigyoshaMeisho 所属機関名
     * @param shinseishaNameKana 対象者氏名．ふりがな
     * @param shinseishaName 対象者氏名
     * @param seibetsuMan 男
     * @param seibetsuWoman 女
     * @param shinseishaJusho 現住所
     * @param shinseishaYubinNo 現住所．〒
     * @param shinseishTelNo 現住所．電話
     * @param meiji 明治
     * @param taisho 大正
     * @param showa 昭和
     * @param birthYY 年
     * @param birthMM 月
     * @param birthDD 日
     * @param age 歳
     * @param kazokuRenrakusakiJusho 家族等連絡先
     * @param kazokuRenrakusakiYubinNo 家族等連絡先．〒
     * @param kazokuRenrakusakiTel1 家族等連絡先．電話１
     * @param kazokuRenrakusakiTel2 家族等連絡先．電話２
     * @param kazokuRenrakusakiName 家族等連絡先．氏名
     * @param shinseishatonoKankei 家族等連絡先．調査対象者との関係
     * @param shokai 初回
     * @param nikaime ２回め以降
     * @param zenkaiNinteiYYYY 前回認定．年
     * @param zenkaiNinteiMM 前回認定．月
     * @param zenkaiNinteiDD 前回認定．日
     * @param higaito 非該当
     * @param yoshien 要支援
     * @param yoshiendo 要支援詳細
     * @param yokaigo 要介護
     * @param yokaigodo 要介護詳細
     */
    public ChosahyoGaikyochosaItem(
            RString hokenshaNo1,
            RString hokenshaNo2,
            RString hokenshaNo3,
            RString hokenshaNo4,
            RString hokenshaNo5,
            RString hokenshaNo6,
            RString shinseiYY1,
            RString shinseiYY2,
            RString shinseiMM1,
            RString shinseiMM2,
            RString shinseiDD1,
            RString shinseiDD2,
            RString hishokenshaNo1,
            RString hishokenshaNo2,
            RString hishokenshaNo3,
            RString hishokenshaNo4,
            RString hishokenshaNo5,
            RString hishokenshaNo6,
            RString hishokenshaNo7,
            RString hishokenshaNo8,
            RString hishokenshaNo9,
            RString hishokenshaNo10,
            RString homonChosainNo1,
            RString homonChosainNo2,
            RString homonChosainNo3,
            RString homonChosainNo4,
            RString homonChosainNo5,
            RString homonChosainNo6,
            RString homonChosainNo7,
            RString homonChosainNo8,
            RString homonChosainName,
            RString homonChosasakiNo1,
            RString homonChosasakiNo2,
            RString homonChosasakiNo3,
            RString homonChosasakiNo4,
            RString homonChosasakiNo5,
            RString homonChosasakiNo6,
            RString homonChosasakiNo7,
            RString homonChosasakiNo8,
            RString homonChosasakiNo9,
            RString homonChosasakiNo10,
            RString homonChosasakiNo11,
            RString homonChosasakiNo12,
            RString jigyoshaMeisho,
            RString shinseishaNameKana,
            RString shinseishaName,
            RString seibetsuMan,
            RString seibetsuWoman,
            RString shinseishaJusho,
            RString shinseishaYubinNo,
            RString shinseishTelNo,
            RString meiji,
            RString taisho,
            RString showa,
            RString birthYY,
            RString birthMM,
            RString birthDD,
            RString age,
            RString kazokuRenrakusakiJusho,
            RString kazokuRenrakusakiYubinNo,
            RString kazokuRenrakusakiTel1,
            RString kazokuRenrakusakiTel2,
            RString kazokuRenrakusakiName,
            RString shinseishatonoKankei,
            RString shokai,
            RString nikaime,
            RString zenkaiNinteiYYYY,
            RString zenkaiNinteiMM,
            RString zenkaiNinteiDD,
            RString higaito,
            RString yoshien,
            RString yoshiendo,
            RString yokaigo,
            RString yokaigodo) {
        this.hokenshaNo1 = hokenshaNo1;
        this.hokenshaNo2 = hokenshaNo2;
        this.hokenshaNo3 = hokenshaNo3;
        this.hokenshaNo4 = hokenshaNo4;
        this.hokenshaNo5 = hokenshaNo5;
        this.hokenshaNo6 = hokenshaNo6;
        this.shinseiYY1 = shinseiYY1;
        this.shinseiYY2 = shinseiYY2;
        this.shinseiMM1 = shinseiMM1;
        this.shinseiMM2 = shinseiMM2;
        this.shinseiDD1 = shinseiDD1;
        this.shinseiDD2 = shinseiDD2;
        this.hishokenshaNo1 = hishokenshaNo1;
        this.hishokenshaNo2 = hishokenshaNo2;
        this.hishokenshaNo3 = hishokenshaNo3;
        this.hishokenshaNo4 = hishokenshaNo4;
        this.hishokenshaNo5 = hishokenshaNo5;
        this.hishokenshaNo6 = hishokenshaNo6;
        this.hishokenshaNo7 = hishokenshaNo7;
        this.hishokenshaNo8 = hishokenshaNo8;
        this.hishokenshaNo9 = hishokenshaNo9;
        this.hishokenshaNo10 = hishokenshaNo10;
        this.homonChosainNo1 = homonChosainNo1;
        this.homonChosainNo2 = homonChosainNo2;
        this.homonChosainNo3 = homonChosainNo3;
        this.homonChosainNo4 = homonChosainNo4;
        this.homonChosainNo5 = homonChosainNo5;
        this.homonChosainNo6 = homonChosainNo6;
        this.homonChosainNo7 = homonChosainNo7;
        this.homonChosainNo8 = homonChosainNo8;
        this.homonChosainName = homonChosainName;
        this.homonChosasakiNo1 = homonChosasakiNo1;
        this.homonChosasakiNo2 = homonChosasakiNo2;
        this.homonChosasakiNo3 = homonChosasakiNo3;
        this.homonChosasakiNo4 = homonChosasakiNo4;
        this.homonChosasakiNo5 = homonChosasakiNo5;
        this.homonChosasakiNo6 = homonChosasakiNo6;
        this.homonChosasakiNo7 = homonChosasakiNo7;
        this.homonChosasakiNo8 = homonChosasakiNo8;
        this.homonChosasakiNo9 = homonChosasakiNo9;
        this.homonChosasakiNo10 = homonChosasakiNo10;
        this.homonChosasakiNo11 = homonChosasakiNo11;
        this.homonChosasakiNo12 = homonChosasakiNo12;
        this.jigyoshaMeisho = jigyoshaMeisho;
        this.shinseishaNameKana = shinseishaNameKana;
        this.shinseishaName = shinseishaName;
        this.seibetsuMan = seibetsuMan;
        this.seibetsuWoman = seibetsuWoman;
        this.shinseishaJusho = shinseishaJusho;
        this.shinseishaYubinNo = shinseishaYubinNo;
        this.shinseishTelNo = shinseishTelNo;
        this.meiji = meiji;
        this.taisho = taisho;
        this.showa = showa;
        this.birthYY = birthYY;
        this.birthMM = birthMM;
        this.birthDD = birthDD;
        this.age = age;
        this.kazokuRenrakusakiJusho = kazokuRenrakusakiJusho;
        this.kazokuRenrakusakiYubinNo = kazokuRenrakusakiYubinNo;
        this.kazokuRenrakusakiTel1 = kazokuRenrakusakiTel1;
        this.kazokuRenrakusakiTel2 = kazokuRenrakusakiTel2;
        this.kazokuRenrakusakiName = kazokuRenrakusakiName;
        this.shinseishatonoKankei = shinseishatonoKankei;
        this.shokai = shokai;
        this.nikaime = nikaime;
        this.zenkaiNinteiYYYY = zenkaiNinteiYYYY;
        this.zenkaiNinteiMM = zenkaiNinteiMM;
        this.zenkaiNinteiDD = zenkaiNinteiDD;
        this.higaito = higaito;
        this.yoshien = yoshien;
        this.yoshiendo = yoshiendo;
        this.yokaigo = yokaigo;
        this.yokaigodo = yokaigodo;
    }
}
