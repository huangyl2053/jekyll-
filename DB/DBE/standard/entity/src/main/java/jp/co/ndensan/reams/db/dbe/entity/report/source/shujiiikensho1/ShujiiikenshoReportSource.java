package jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikensho1;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 主治医意見書のReportSourceです。
 *
 * @reamsid_L DBE-0230-070 lizhuoxuan
 */
public class ShujiiikenshoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "hokenshaNo", length = 6, order = 2)
    public RString hokenshaNo;
    @ReportExpandedInfo
    @ReportItem(name = "hihokenshaNo", length = 10, order = 11)
    public RString hihokenshaNo;
    @ReportItem(name = "hihokenshaName", length = 30, order = 1)
    public RString hihokenshaName;
    @ReportItem(name = "shinseiGengo", length = 2, order = 3)
    public RString shinseiGengo;
    @ReportItem(name = "shinseiYY", length = 2, order = 4)
    public RString shinseiYY;
    @ReportItem(name = "shinseiMM", length = 2, order = 5)
    public RString shinseiMM;
    @ReportItem(name = "shinseiDD", length = 2, order = 6)
    public RString shinseiDD;
    @ReportItem(name = "sakuseiGengo", length = 2, order = 7)
    public RString sakuseiGengo;
    @ReportItem(name = "sakuseiYY", length = 2, order = 8)
    public RString sakuseiYY;
    @ReportItem(name = "sakuseiMM", length = 2, order = 9)
    public RString sakuseiMM;
    @ReportItem(name = "sakuseiDD", length = 2, order = 10)
    public RString sakuseiDD;
    @ReportItem(name = "chosaGengo", length = 2, order = 12)
    public RString chosaGengo;
    @ReportItem(name = "chosaYY", length = 2, order = 13)
    public RString chosaYY;
    @ReportItem(name = "chosaMM", length = 2, order = 14)
    public RString chosaMM;
    @ReportItem(name = "chosaDD", length = 2, order = 15)
    public RString chosaDD;
    @ReportItem(name = "shinsaGengo", length = 2, order = 16)
    public RString shinsaGengo;
    @ReportItem(name = "shinsaYY", length = 2, order = 17)
    public RString shinsaYY;
    @ReportItem(name = "shinsaMM", length = 2, order = 18)
    public RString shinsaMM;
    @ReportItem(name = "shinsaDD", length = 2, order = 19)
    public RString shinsaDD;
    @ReportItem(name = "imgIkensho1", order = 20)
    public RString imgIkensho1;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
