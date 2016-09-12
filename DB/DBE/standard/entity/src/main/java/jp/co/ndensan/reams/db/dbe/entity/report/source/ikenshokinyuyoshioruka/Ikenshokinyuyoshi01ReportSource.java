package jp.co.ndensan.reams.db.dbe.entity.report.source.ikenshokinyuyoshioruka;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 主治医意見書（オルカ）のReportSourceクラスです。
 *
 * @reamsid_L DBE-1600-020 lishengli
 */
public class Ikenshokinyuyoshi01ReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "hihokenshaKana", length = 30, order = 1)
    public RString hihokenshaKana;
    @ReportItem(name = "yubinNo", length = 8, order = 2)
    public RString yubinNo;
    @ReportItem(name = "seibetsuMan", length = 2, order = 3)
    public RString seibetsuMan;
    @ReportItem(name = "jusho", length = 70, order = 4)
    public RString jusho;
    @ReportItem(name = "hihokenshaName", length = 30, order = 5)
    public RString hihokenshaName;
    @ReportItem(name = "seibetsuWoman", length = 2, order = 6)
    public RString seibetsuWoman;
    @ReportItem(name = "hihokenshaTel", length = 13, order = 7)
    public RString hihokenshaTel;
    @ReportItem(name = "birthGengoMeiji", length = 2, order = 8)
    public RString birthGengoMeiji;
    @ReportItem(name = "birthGengoTaisho", length = 2, order = 9)
    public RString birthGengoTaisho;
    @ReportItem(name = "birthGengoShowa", length = 2, order = 10)
    public RString birthGengoShowa;
    @ReportItem(name = "age", length = 3, order = 11)
    public RString age;
    @ReportItem(name = "birthYY", length = 2, order = 12)
    public RString birthYY;
    @ReportItem(name = "birthMM", length = 2, order = 13)
    public RString birthMM;
    @ReportItem(name = "birthDD", length = 2, order = 14)
    public RString birthDD;
    @ReportItem(name = "shujiiName", length = 30, order = 15)
    public RString shujiiName;
    @ReportItem(name = "iryokikanName", length = 40, order = 16)
    public RString iryokikanName;
    @ReportItem(name = "iryokikanNameTel", length = 13, order = 17)
    public RString iryokikanNameTel;
    @ReportItem(name = "iryokikanFax", length = 13, order = 18)
    public RString iryokikanFax;
    @ReportItem(name = "iryokikanAdress", length = 50, order = 19)
    public RString iryokikanAdress;
    @ReportItem(name = "kinyuYMD", length = 8, order = 20)
    public RString kinyuYMD;
    @ReportItem(name = "timeStamp", length = 18, order = 21)
    public RString timeStamp;
    @ReportItem(name = "iryokikanNo", length = 10, order = 22)
    public RString iryokikanNo;
    @ReportItem(name = "iraiNo", length = 10, order = 23)
    public RString iraiNo;
    @ReportItem(name = "sofuYMD", length = 8, order = 24)
    public RString sofuYMD;
    @ReportItem(name = "hokenshaNo", length = 6, order = 25)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 40, order = 26)
    public RString hokenshaName;
    @ReportItem(name = "sakuseiYMD", length = 8, order = 27)
    public RString sakuseiYMD;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 28)
    public RString hihokenshaNo;
    @ReportItem(name = "shinseiYMD", length = 8, order = 29)
    public RString shinseiYMD;
    @ReportItem(name = "hihokenshaKana1", length = 30, order = 30)
    public RString hihokenshaKana1;
    @ReportItem(name = "yubinNo1", length = 8, order = 31)
    public RString yubinNo1;
    @ReportItem(name = "jusho1", length = 50, order = 32)
    public RString jusho1;
    @ReportItem(name = "seibetsu", length = 1, order = 33)
    public RString seibetsu;
    @ReportItem(name = "hihokenshaName1", length = 15, order = 34)
    public RString hihokenshaName1;
    @ReportItem(name = "seinengappi", length = 8, order = 35)
    public RString seinengappi;
    @ReportItem(name = "hihokenshaTel1", length = 15, order = 36)
    public RString hihokenshaTel1;
    @ReportItem(name = "age1", length = 3, order = 37)
    public RString age1;
    @ReportItem(name = "doiAri", length = 1, order = 38)
    public RString doiAri;
    @ReportItem(name = "doiNashi", length = 1, order = 39)
    public RString doiNashi;
    @ReportItem(name = "ishiNo", length = 10, order = 40)
    public RString ishiNo;
    @ReportItem(name = "shujiiName1", length = 15, order = 41)
    public RString shujiiName1;
    @ReportItem(name = "iryokikanName1", length = 30, order = 42)
    public RString iryokikanName1;
    @ReportItem(name = "iryokikanNameTel1", length = 15, order = 43)
    public RString iryokikanNameTel1;
    @ReportItem(name = "iryokikanFax1", length = 15, order = 44)
    public RString iryokikanFax1;
    @ReportItem(name = "iryokikanYubinNo", length = 8, order = 45)
    public RString iryokikanYubinNo;
    @ReportItem(name = "iryokikanAdress1", length = 45, order = 46)
    public RString iryokikanAdress1;
    @ReportItem(name = "saishuShinsatsuYMD", length = 8, order = 47)
    public RString saishuShinsatsuYMD;
    @ReportItem(name = "sakuseiKaisu", length = 1, order = 48)
    public RString sakuseiKaisu;
    @ReportItem(name = "shubetsuZaitaku", length = 1, order = 49)
    public RString shubetsuZaitaku;
    @ReportItem(name = "shubetsuShisetsu", length = 1, order = 50)
    public RString shubetsuShisetsu;
    @ReportItem(name = "takajushinAri", length = 1, order = 51)
    public RString takajushinAri;
    @ReportItem(name = "takajushinNashi", length = 1, order = 52)
    public RString takajushinNashi;
    @ReportItem(name = "taNaika", length = 1, order = 53)
    public RString taNaika;
    @ReportItem(name = "taNoshinkeigeka", length = 1, order = 54)
    public RString taNoshinkeigeka;
    @ReportItem(name = "taHinyokika", length = 1, order = 55)
    public RString taHinyokika;
    @ReportItem(name = "taHifuka", length = 1, order = 56)
    public RString taHifuka;
    @ReportItem(name = "taGeka", length = 1, order = 57)
    public RString taGeka;
    @ReportItem(name = "taSeishinka", length = 1, order = 58)
    public RString taSeishinka;
    @ReportItem(name = "taSeikeigeka", length = 1, order = 59)
    public RString taSeikeigeka;
    @ReportItem(name = "taGanka", length = 1, order = 60)
    public RString taGanka;
    @ReportItem(name = "taRihabirika", length = 1, order = 61)
    public RString taRihabirika;
    @ReportItem(name = "taSonota", length = 1, order = 62)
    public RString taSonota;
    @ReportItem(name = "taFujinka", length = 1, order = 63)
    public RString taFujinka;
    @ReportItem(name = "taJibiinkoka", length = 1, order = 64)
    public RString taJibiinkoka;
    @ReportItem(name = "taShika", length = 1, order = 65)
    public RString taShika;
    @ReportItem(name = "taSonotakamei", length = 8, order = 66)
    public RString taSonotakamei;
    @ReportItem(name = "shindamName1", length = 30, order = 67)
    public RString shindamName1;
    @ReportItem(name = "hasshoYMD1", length = 12, order = 68)
    public RString hasshoYMD1;
    @ReportItem(name = "shindamName2", length = 30, order = 69)
    public RString shindamName2;
    @ReportItem(name = "hasshoYMD2", length = 12, order = 70)
    public RString hasshoYMD2;
    @ReportItem(name = "shindamName3", length = 30, order = 71)
    public RString shindamName3;
    @ReportItem(name = "hasshoYMD3", length = 12, order = 72)
    public RString hasshoYMD3;
    @ReportItem(name = "byojoFuantei", length = 1, order = 73)
    public RString byojoFuantei;
    @ReportItem(name = "byojoAntei", length = 1, order = 74)
    public RString byojoAntei;
    @ReportItem(name = "byojoFumei", length = 1, order = 75)
    public RString byojoFumei;
    @ReportItem(name = "gutaitekiJokyo", length = 30, order = 76)
    public RString gutaitekiJokyo;
    @ReportItem(name = "chiryonaiyo", length = 560, order = 77)
    public RString chiryonaiyo;
    @ReportItem(name = "tokubetsuTenteki", length = 1, order = 78)
    public RString tokubetsuTenteki;
    @ReportItem(name = "tokubetsuEiyo", length = 1, order = 79)
    public RString tokubetsuEiyo;
    @ReportItem(name = "tokubetsuToseki", length = 1, order = 80)
    public RString tokubetsuToseki;
    @ReportItem(name = "tokubetsuSutoma", length = 1, order = 81)
    public RString tokubetsuSutoma;
    @ReportItem(name = "tokubetsuSanso", length = 1, order = 82)
    public RString tokubetsuSanso;
    @ReportItem(name = "tokubetsuResupireta", length = 1, order = 83)
    public RString tokubetsuResupireta;
    @ReportItem(name = "tokubetsuKikansekkai", length = 1, order = 84)
    public RString tokubetsuKikansekkai;
    @ReportItem(name = "tokubetsuTotsu", length = 1, order = 85)
    public RString tokubetsuTotsu;
    @ReportItem(name = "tokubetsuKeikaneiyo", length = 1, order = 86)
    public RString tokubetsuKeikaneiyo;
    @ReportItem(name = "tokubetsuMonita", length = 1, order = 87)
    public RString tokubetsuMonita;
    @ReportItem(name = "tokubetsuJokuso", length = 1, order = 88)
    public RString tokubetsuJokuso;
    @ReportItem(name = "tokubetsuKateteru", length = 1, order = 89)
    public RString tokubetsuKateteru;
    @ReportItem(name = "shogaiJiritsu", length = 1, order = 90)
    public RString shogaiJiritsu;
    @ReportItem(name = "shogaiJ1", length = 1, order = 91)
    public RString shogaiJ1;
    @ReportItem(name = "shogaiJ2", length = 1, order = 92)
    public RString shogaiJ2;
    @ReportItem(name = "shogaiA1", length = 1, order = 93)
    public RString shogaiA1;
    @ReportItem(name = "shogaiA2", length = 1, order = 94)
    public RString shogaiA2;
    @ReportItem(name = "shogaiB1", length = 1, order = 95)
    public RString shogaiB1;
    @ReportItem(name = "shogaiB2", length = 1, order = 96)
    public RString shogaiB2;
    @ReportItem(name = "shogaiC1", length = 1, order = 97)
    public RString shogaiC1;
    @ReportItem(name = "shogaiC2", length = 1, order = 98)
    public RString shogaiC2;
    @ReportItem(name = "ninchisho1", length = 1, order = 99)
    public RString ninchisho1;
    @ReportItem(name = "ninchisho2a", length = 1, order = 100)
    public RString ninchisho2a;
    @ReportItem(name = "ninchisho2b", length = 1, order = 101)
    public RString ninchisho2b;
    @ReportItem(name = "ninchisho3a", length = 1, order = 102)
    public RString ninchisho3a;
    @ReportItem(name = "ninchisho3b", length = 1, order = 103)
    public RString ninchisho3b;
    @ReportItem(name = "ninchisho4", length = 1, order = 104)
    public RString ninchisho4;
    @ReportItem(name = "ninchishoM", length = 1, order = 105)
    public RString ninchishoM;
    @ReportItem(name = "ninchishoJiritsu", length = 1, order = 106)
    public RString ninchishoJiritsu;
    @ReportItem(name = "tankikiokuNashi", length = 1, order = 107)
    public RString tankikiokuNashi;
    @ReportItem(name = "tankikiokuAri", length = 1, order = 108)
    public RString tankikiokuAri;
    @ReportItem(name = "ninchinoryokuJiritsu", length = 1, order = 109)
    public RString ninchinoryokuJiritsu;
    @ReportItem(name = "ninchinoryokuKonnan", length = 1, order = 110)
    public RString ninchinoryokuKonnan;
    @ReportItem(name = "ninchinoryokuHitsuyo", length = 1, order = 111)
    public RString ninchinoryokuHitsuyo;
    @ReportItem(name = "ninchinoryokuDekinai", length = 1, order = 112)
    public RString ninchinoryokuDekinai;
    @ReportItem(name = "dentatsuDekiru", length = 1, order = 113)
    public RString dentatsuDekiru;
    @ReportItem(name = "dentatsuKonnan", length = 1, order = 114)
    public RString dentatsuKonnan;
    @ReportItem(name = "dentatsuGentei", length = 1, order = 115)
    public RString dentatsuGentei;
    @ReportItem(name = "dentatsuDekinai", length = 1, order = 116)
    public RString dentatsuDekinai;
    @ReportItem(name = "shuhenjokyoTeiko", length = 1, order = 117)
    public RString shuhenjokyoTeiko;
    @ReportItem(name = "shuhenjokyoGyakuten", length = 1, order = 118)
    public RString shuhenjokyoGyakuten;
    @ReportItem(name = "shuhenjokyoHaikai", length = 1, order = 119)
    public RString shuhenjokyoHaikai;
    @ReportItem(name = "shuhenjokyoAri", length = 1, order = 120)
    public RString shuhenjokyoAri;
    @ReportItem(name = "shuhenjokyoGenshi", length = 1, order = 121)
    public RString shuhenjokyoGenshi;
    @ReportItem(name = "shuhenjokyoBoko", length = 1, order = 122)
    public RString shuhenjokyoBoko;
    @ReportItem(name = "shuhenjokyoMoso", length = 1, order = 123)
    public RString shuhenjokyoMoso;
    @ReportItem(name = "shuhenjokyoBogen", length = 1, order = 124)
    public RString shuhenjokyoBogen;
    @ReportItem(name = "shuhenjokyoNashi", length = 1, order = 125)
    public RString shuhenjokyoNashi;
    @ReportItem(name = "shuhenjoSonota", length = 1, order = 126)
    public RString shuhenjoSonota;
    @ReportItem(name = "shuhenjoHi", length = 1, order = 127)
    public RString shuhenjoHi;
    @ReportItem(name = "shuhenjoIshoku", length = 1, order = 128)
    public RString shuhenjoIshoku;
    @ReportItem(name = "shuhenjoFuketsu", length = 1, order = 129)
    public RString shuhenjoFuketsu;
    @ReportItem(name = "shuhenjoSeiteki", length = 1, order = 130)
    public RString shuhenjoSeiteki;
    @ReportItem(name = "shuhenjoSonotaKisai", length = 10, order = 131)
    public RString shuhenjoSonotaKisai;
    @ReportItem(name = "semmonijushinAri", length = 1, order = 132)
    public RString semmonijushinAri;
    @ReportItem(name = "semmonijushinNashi", length = 1, order = 133)
    public RString semmonijushinNashi;
    @ReportItem(name = "seishinAri", length = 1, order = 134)
    public RString seishinAri;
    @ReportItem(name = "semmonijushinName", length = 15, order = 135)
    public RString semmonijushinName;
    @ReportItem(name = "seishinNashi", length = 1, order = 136)
    public RString seishinNashi;
    @ReportItem(name = "seishinName", length = 30, order = 137)
    public RString seishinName;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>

    @ReportPerson(id = "X")
    public ShikibetsuCode shikibetuCode;
    @ReportExpandedInfo(id = "X")
    public ExpandedInformation shinseishoKanriNo;
}
