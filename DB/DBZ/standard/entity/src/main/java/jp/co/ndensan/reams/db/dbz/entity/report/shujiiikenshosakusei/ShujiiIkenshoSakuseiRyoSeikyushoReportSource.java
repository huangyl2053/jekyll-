package jp.co.ndensan.reams.db.dbz.entity.report.shujiiikenshosakusei;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 主治医意見書作成料請求書のReportSourceです。
 *
 * @reamsid_L DBE-0050-040 sunhaidi
 */
public class ShujiiIkenshoSakuseiRyoSeikyushoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "hihokenshaNo1", length = 1, order = 1)
    public RString hihokenshaNo1;
    @ReportItem(name = "hihokenshaNo2", length = 1, order = 2)
    public RString hihokenshaNo2;
    @ReportItem(name = "hihokenshaNo3", length = 1, order = 3)
    public RString hihokenshaNo3;
    @ReportItem(name = "hihokenshaNo4", length = 1, order = 4)
    public RString hihokenshaNo4;
    @ReportItem(name = "hihokenshaNo5", length = 1, order = 5)
    public RString hihokenshaNo5;
    @ReportItem(name = "hihokenshaNo6", length = 1, order = 6)
    public RString hihokenshaNo6;
    @ReportItem(name = "hihokenshaNo7", length = 1, order = 7)
    public RString hihokenshaNo7;
    @ReportItem(name = "hihokenshaNo8", length = 1, order = 8)
    public RString hihokenshaNo8;
    @ReportItem(name = "hihokenshaNo9", length = 1, order = 9)
    public RString hihokenshaNo9;
    @ReportItem(name = "hihokenshaNo10", length = 1, order = 10)
    public RString hihokenshaNo10;
    @ReportItem(name = "hihokenshaNameKana", order = 11)
    public RString hihokenshaNameKana;
    @ReportItem(name = "iryokikanName", order = 12)
    public RString iryokikanName;
    @ReportItem(name = "inkanMark", length = 1, order = 13)
    public RString inkanMark;
    @ReportItem(name = "hihokenshaName", order = 14)
    public RString hihokenshaName;
    @ReportItem(name = "iryokikanDaihyosha", order = 15)
    public RString iryokikanDaihyosha;
    @ReportItem(name = "yubinNo", length = 8, order = 16)
    public RString yubinNo;
    @ReportItem(name = "iryokikanJusho", order = 17)
    public RString iryokikanJusho;
    @ReportItem(name = "birthYMD", length = 12, order = 18)
    public RString birthYMD;
    @ReportItem(name = "seibetsu", length = 2, order = 19)
    public RString seibetsu;
    @ReportItem(name = "iryokikanTel", length = 20, order = 20)
    public RString iryokikanTel;
    @ReportItem(name = "ikenshoSakuseiRyo2", length = 1, order = 21)
    public RString ikenshoSakuseiRyo2;
    @ReportItem(name = "ikenshoSakuseiRyo4", length = 1, order = 22)
    public RString ikenshoSakuseiRyo4;
    @ReportItem(name = "ikenshoSakuseiRyo1", length = 1, order = 23)
    public RString ikenshoSakuseiRyo1;
    @ReportItem(name = "ikenshoSakuseiRyo3", length = 1, order = 24)
    public RString ikenshoSakuseiRyo3;
    @ReportItem(name = "shubetsuZaitaku", length = 1, order = 25)
    public RString shubetsuZaitaku;
    @ReportItem(name = "shubetsuKeizoku", length = 1, order = 26)
    public RString shubetsuKeizoku;
    @ReportItem(name = "shubetsuShisetsu", length = 1, order = 27)
    public RString shubetsuShisetsu;
    @ReportItem(name = "shubetsuShinki", length = 1, order = 28)
    public RString shubetsuShinki;
    @ReportItem(name = "seikyugakuIkenshoSakuseiRyo1", length = 1, order = 29)
    public RString seikyugakuIkenshoSakuseiRyo1;
    @ReportItem(name = "seikyugakuIkenshoSakuseiRyo2", length = 1, order = 30)
    public RString seikyugakuIkenshoSakuseiRyo2;
    @ReportItem(name = "seikyugakuIkenshoSakuseiRyo3", length = 1, order = 31)
    public RString seikyugakuIkenshoSakuseiRyo3;
    @ReportItem(name = "seikyugakuIkenshoSakuseiRyo4", length = 1, order = 32)
    public RString seikyugakuIkenshoSakuseiRyo4;
    @ReportItem(name = "gengo", length = 11, order = 33)
    public RString gengo;
    @ReportItem(name = "atesakiHokenshaName", length = 50, order = 34)
    public RString atesakiHokenshaName;
    @ReportItem(name = "shinkiShisetsuKingaku", length = 6, order = 35)
    public Decimal shinkiShisetsuKingaku;
    @ReportItem(name = "shinkiZaitakuKingaku", length = 6, order = 36)
    public Decimal shinkiZaitakuKingaku;
    @ReportItem(name = "keizokuZaitakuKingaku", length = 6, order = 37)
    public Decimal keizokuZaitakuKingaku;
    @ReportItem(name = "keizokuShisetsuKingaku", length = 6, order = 38)
    public Decimal keizokuShisetsuKingaku;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
    @ReportPerson(id = "X")
    public ShikibetsuCode shikibetuCode;
    @ReportExpandedInfo(id = "X")
    public ExpandedInformation shokenshaNo;
}
