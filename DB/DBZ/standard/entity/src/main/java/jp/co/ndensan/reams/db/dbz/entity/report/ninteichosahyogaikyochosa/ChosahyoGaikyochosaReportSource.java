package jp.co.ndensan.reams.db.dbz.entity.report.ninteichosahyogaikyochosa;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 要介護認定調査票（概況調査）のReportSourceです。
 *
 * @reamsid_L DBE-0080-030 xuyannan
 */
public class ChosahyoGaikyochosaReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "shinseiYY1", length = 2, order = 1)
    public RString shinseiYY1;
    @ReportItem(name = "shinseiYY2", length = 2, order = 2)
    public RString shinseiYY2;
    @ReportItem(name = "shinseiMM1", length = 2, order = 3)
    public RString shinseiMM1;
    @ReportItem(name = "shinseiMM2", length = 2, order = 4)
    public RString shinseiMM2;
    @ReportItem(name = "shinseiDD1", length = 2, order = 5)
    public RString shinseiDD1;
    @ReportItem(name = "shinseiDD2", length = 2, order = 6)
    public RString shinseiDD2;
    @ReportItem(name = "hokenshaNo1", length = 2, order = 7)
    public RString hokenshaNo1;
    @ReportItem(name = "hokenshaNo2", length = 2, order = 8)
    public RString hokenshaNo2;
    @ReportItem(name = "hokenshaNo3", length = 2, order = 9)
    public RString hokenshaNo3;
    @ReportItem(name = "hokenshaNo4", length = 2, order = 10)
    public RString hokenshaNo4;
    @ReportItem(name = "hokenshaNo5", length = 2, order = 11)
    public RString hokenshaNo5;
    @ReportItem(name = "hokenshaNo6", length = 2, order = 12)
    public RString hokenshaNo6;
    @ReportItem(name = "hishokenshaNo7", length = 2, order = 13)
    public RString hishokenshaNo7;
    @ReportItem(name = "hishokenshaNo8", length = 2, order = 14)
    public RString hishokenshaNo8;
    @ReportItem(name = "hishokenshaNo9", length = 2, order = 15)
    public RString hishokenshaNo9;
    @ReportItem(name = "hishokenshaNo10", length = 2, order = 16)
    public RString hishokenshaNo10;
    @ReportItem(name = "hishokenshaNo1", length = 2, order = 17)
    public RString hishokenshaNo1;
    @ReportItem(name = "hishokenshaNo2", length = 2, order = 18)
    public RString hishokenshaNo2;
    @ReportItem(name = "hishokenshaNo3", length = 2, order = 19)
    public RString hishokenshaNo3;
    @ReportItem(name = "hishokenshaNo4", length = 2, order = 20)
    public RString hishokenshaNo4;
    @ReportItem(name = "hishokenshaNo5", length = 2, order = 21)
    public RString hishokenshaNo5;
    @ReportItem(name = "hishokenshaNo6", length = 2, order = 22)
    public RString hishokenshaNo6;
    @ReportItem(name = "再調査", length = 2, order = 23)
    public RString 再調査;
    @ReportItem(name = "新規", length = 2, order = 24)
    public RString 新規;
    @ReportItem(name = "homonChosainNo1", length = 2, order = 25)
    public RString homonChosainNo1;
    @ReportItem(name = "homonChosainNo2", length = 2, order = 26)
    public RString homonChosainNo2;
    @ReportItem(name = "homonChosainNo3", length = 2, order = 27)
    public RString homonChosainNo3;
    @ReportItem(name = "homonChosainNo4", length = 2, order = 28)
    public RString homonChosainNo4;
    @ReportItem(name = "homonChosainNo5", length = 2, order = 29)
    public RString homonChosainNo5;
    @ReportItem(name = "homonChosainNo6", length = 2, order = 30)
    public RString homonChosainNo6;
    @ReportItem(name = "homonChosainNo7", length = 2, order = 31)
    public RString homonChosainNo7;
    @ReportItem(name = "homonChosainNo8", length = 2, order = 32)
    public RString homonChosainNo8;
    @ReportItem(name = "homonChosainName", length = 40, order = 33)
    public RString homonChosainName;
    @ReportItem(name = "homonChosasakiNo1", length = 2, order = 34)
    public RString homonChosasakiNo1;
    @ReportItem(name = "homonChosasakiNo2", length = 2, order = 35)
    public RString homonChosasakiNo2;
    @ReportItem(name = "homonChosasakiNo3", length = 2, order = 36)
    public RString homonChosasakiNo3;
    @ReportItem(name = "homonChosasakiNo4", length = 2, order = 37)
    public RString homonChosasakiNo4;
    @ReportItem(name = "homonChosasakiNo5", length = 2, order = 38)
    public RString homonChosasakiNo5;
    @ReportItem(name = "homonChosasakiNo6", length = 2, order = 39)
    public RString homonChosasakiNo6;
    @ReportItem(name = "homonChosasakiNo7", length = 2, order = 40)
    public RString homonChosasakiNo7;
    @ReportItem(name = "homonChosasakiNo8", length = 2, order = 41)
    public RString homonChosasakiNo8;
    @ReportItem(name = "homonChosasakiNo9", length = 2, order = 42)
    public RString homonChosasakiNo9;
    @ReportItem(name = "homonChosasakiNo10", length = 2, order = 43)
    public RString homonChosasakiNo10;
    @ReportItem(name = "homonChosasakiNo11", length = 2, order = 44)
    public RString homonChosasakiNo11;
    @ReportItem(name = "homonChosasakiNo12", length = 2, order = 45)
    public RString homonChosasakiNo12;
    @ReportItem(name = "homonChosasakiName", length = 20, order = 46)
    public RString homonChosasakiName;
    @ReportItem(name = "shinseishaNameKana", length = 20, order = 47)
    public RString shinseishaNameKana;
    @ReportItem(name = "seibetsuMan", length = 2, order = 48)
    public RString seibetsuMan;
    @ReportItem(name = "shinseishaYubinNo", length = 8, order = 49)
    public RString shinseishaYubinNo;
    @ReportItem(name = "shinseishTelNo", length = 13, order = 50)
    public RString shinseishTelNo;
    @ReportItem(name = "shinseishaName", length = 20, order = 51)
    public RString shinseishaName;
    @ReportItem(name = "seibetsuWoman", length = 2, order = 52)
    public RString seibetsuWoman;
    @ReportItem(name = "shinseishaJusho", length = 60, order = 53)
    public RString shinseishaJusho;
    @ReportItem(name = "kazokuRenrakusakiTel1", length = 13, order = 54)
    public RString kazokuRenrakusakiTel1;
    @ReportItem(name = "meiji", length = 2, order = 55)
    public RString meiji;
    @ReportItem(name = "taisho", length = 2, order = 56)
    public RString taisho;
    @ReportItem(name = "showa", length = 2, order = 57)
    public RString showa;
    @ReportItem(name = "kazokuRenrakusakiYubinNo", length = 8, order = 58)
    public RString kazokuRenrakusakiYubinNo;
    @ReportItem(name = "kazokuRenrakusakiTel2", length = 13, order = 59)
    public RString kazokuRenrakusakiTel2;
    @ReportItem(name = "kazokuRenrakusakiJusho", length = 60, order = 60)
    public RString kazokuRenrakusakiJusho;
    @ReportItem(name = "birthMM", length = 2, order = 61)
    public RString birthMM;
    @ReportItem(name = "birthYY", length = 2, order = 62)
    public RString birthYY;
    @ReportItem(name = "birthDD", length = 2, order = 63)
    public RString birthDD;
    @ReportItem(name = "age", length = 3, order = 64)
    public RString age;
    @ReportItem(name = "shinseishatonoKankei", length = 10, order = 65)
    public RString shinseishatonoKankei;
    @ReportItem(name = "kazokuRenrakusakiName", length = 15, order = 66)
    public RString kazokuRenrakusakiName;
    @ReportItem(name = "nikaime", length = 2, order = 67)
    public RString nikaime;
    @ReportItem(name = "shokai", length = 2, order = 68)
    public RString shokai;
    @ReportItem(name = "higaito", length = 2, order = 69)
    public RString higaito;
    @ReportItem(name = "yoshien", length = 2, order = 70)
    public RString yoshien;
    @ReportItem(name = "yoshiendo", length = 2, order = 71)
    public RString yoshiendo;
    @ReportItem(name = "yokaigo", length = 2, order = 72)
    public RString yokaigo;
    @ReportItem(name = "yokaigodo", length = 3, order = 73)
    public RString yokaigodo;
    @ReportItem(name = "zenkaiNinteiYYYY", length = 4, order = 74)
    public RString zenkaiNinteiYYYY;
    @ReportItem(name = "zenkaiNinteiMM", length = 2, order = 75)
    public RString zenkaiNinteiMM;
    @ReportItem(name = "zenkaiNinteiDD", length = 2, order = 76)
    public RString zenkaiNinteiDD;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
    @ReportPerson(id = "X")
    public ShikibetsuCode shikibetuCode;
    @ReportExpandedInfo(id = "X")
    public ExpandedInformation hishokenshaNo;
// </editor-fold>
}
