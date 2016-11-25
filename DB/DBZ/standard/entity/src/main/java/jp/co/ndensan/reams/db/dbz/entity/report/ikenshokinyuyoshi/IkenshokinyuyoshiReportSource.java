package jp.co.ndensan.reams.db.dbz.entity.report.ikenshokinyuyoshi;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.report.saichekkuhyo.Layouts;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 要介護認定主治医意見書記入用紙のReportSourceです。
 *
 * @reamsid_L DBE-0050-030 xuyannan
 */
public class IkenshokinyuyoshiReportSource implements IReportSource {
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
    @ReportItem(name = "hokenshaNo1", length = 2, order = 21)
    public RString hokenshaNo1;
    @ReportItem(name = "hokenshaNo2", length = 2, order = 22)
    public RString hokenshaNo2;
    @ReportItem(name = "hokenshaNo3", length = 2, order = 23)
    public RString hokenshaNo3;
    @ReportItem(name = "hokenshaNo4", length = 2, order = 24)
    public RString hokenshaNo4;
    @ReportItem(name = "hokenshaNo5", length = 2, order = 25)
    public RString hokenshaNo5;
    @ReportItem(name = "hokenshaNo6", length = 2, order = 26)
    public RString hokenshaNo6;
    @ReportItem(name = "shinseiYMDNo1", length = 2, order = 27)
    public RString shinseiYMDNo1;
    @ReportItem(name = "shinseiYMDNo2", length = 2, order = 28)
    public RString shinseiYMDNo2;
    @ReportItem(name = "shinseiYMDNo3", length = 2, order = 29)
    public RString shinseiYMDNo3;
    @ReportItem(name = "shinseiYMDNo4", length = 2, order = 30)
    public RString shinseiYMDNo4;
    @ReportItem(name = "shinseiYMDNo5", length = 2, order = 31)
    public RString shinseiYMDNo5;
    @ReportItem(name = "shinseiYMDNo6", length = 2, order = 32)
    public RString shinseiYMDNo6;
    @ReportItem(name = "hihokenshaNo1", length = 2, order = 33)
    public RString hihokenshaNo1;
    @ReportItem(name = "hihokenshaNo2", length = 2, order = 34)
    public RString hihokenshaNo2;
    @ReportItem(name = "hihokenshaNo3", length = 2, order = 35)
    public RString hihokenshaNo3;
    @ReportItem(name = "hihokenshaNo4", length = 2, order = 36)
    public RString hihokenshaNo4;
    @ReportItem(name = "hihokenshaNo5", length = 2, order = 37)
    public RString hihokenshaNo5;
    @ReportItem(name = "hihokenshaNo6", length = 2, order = 38)
    public RString hihokenshaNo6;
    @ReportItem(name = "hihokenshaNo7", length = 2, order = 39)
    public RString hihokenshaNo7;
    @ReportItem(name = "hihokenshaNo8", length = 2, order = 40)
    public RString hihokenshaNo8;
    @ReportItem(name = "hihokenshaNo9", length = 2, order = 41)
    public RString hihokenshaNo9;
    @ReportItem(name = "hihokenshaNo10", length = 2, order = 42)
    public RString hihokenshaNo10;
    @ReportItem(name = "shinseiYY1", length = 2, order = 51)
    public RString shinseiYY1;
    @ReportItem(name = "shinseiYY2", length = 2, order = 52)
    public RString shinseiYY2;
    @ReportItem(name = "shinseiMM1", length = 2, order = 53)
    public RString shinseiMM1;
    @ReportItem(name = "shinseiMM2", length = 2, order = 54)
    public RString shinseiMM2;
    @ReportItem(name = "shinseiD1", length = 2, order = 55)
    public RString shinseiD1;
    @ReportItem(name = "shinseiDD2", length = 2, order = 56)
    public RString shinseiDD2;
    @ReportItem(name = "shinseishaNameKana", length = 30, order = 73)
    public RString shinseishaNameKana;
    @ReportItem(name = "shinseishaYubinNo", length = 8, order = 74)
    public RString shinseishaYubinNo;
    @ReportItem(name = "shinseishaTelNo", length = 13, order = 75)
    public RString shinseishaTelNo;
    @ReportItem(name = "shinseishaName", length = 35, order = 77)
    public RString shinseishaName;
    @ReportItem(name = "shinseishaJusho", length = 60, order = 78)
    public RString shinseishaJusho;
    @ReportItem(name = "meiji", length = 2, order = 80)
    public RString meiji;
    @ReportItem(name = "taisho", length = 2, order = 81)
    public RString taisho;
    @ReportItem(name = "showa", length = 2, order = 82)
    public RString showa;
    @ReportItem(name = "iryokikanTelNo", length = 13, order = 89)
    public RString iryokikanTelNo;
    @ReportItem(name = "iryokikanJusho", length = 55, order = 90)
    public RString iryokikanJusho;
    @ReportItem(name = "iryokikanFaxNo", length = 13, order = 91)
    public RString iryokikanFaxNo;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
    @ReportItem(name = "layout", order = 999)
    public Layouts layout;

    /**
     * レイアウトブレイク用キーの一覧です。
     */
    public static final List<RString> LAYOUT_BREAK_KEYS;

    static {
        LAYOUT_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(new RString("layout")));
    }
// </editor-fold>
}
