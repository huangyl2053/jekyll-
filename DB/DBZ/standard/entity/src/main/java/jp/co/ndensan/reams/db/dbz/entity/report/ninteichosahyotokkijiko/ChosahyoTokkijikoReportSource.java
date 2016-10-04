package jp.co.ndensan.reams.db.dbz.entity.report.ninteichosahyotokkijiko;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 要介護認定調査票（特記事項）のReportSourceです。
 *
 * @reamsid_L DBE-0080-040 xuyannan
 */
public class ChosahyoTokkijikoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "hokenshaNo4", length = 2, order = 1)
    public RString hokenshaNo4;
    @ReportItem(name = "shinseiYY1", length = 2, order = 2)
    public RString shinseiYY1;
    @ReportItem(name = "shinseiYY2", length = 2, order = 3)
    public RString shinseiYY2;
    @ReportItem(name = "shinseiMM1", length = 2, order = 4)
    public RString shinseiMM1;
    @ReportItem(name = "shinseiMM2", length = 2, order = 5)
    public RString shinseiMM2;
    @ReportItem(name = "shinseiDD1", length = 2, order = 6)
    public RString shinseiDD1;
    @ReportItem(name = "shinseiDD2", length = 2, order = 7)
    public RString shinseiDD2;
    @ReportItem(name = "hokenshaNo1", length = 2, order = 8)
    public RString hokenshaNo1;
    @ReportItem(name = "hokenshaNo2", length = 2, order = 9)
    public RString hokenshaNo2;
    @ReportItem(name = "hokenshaNo3", length = 2, order = 10)
    public RString hokenshaNo3;
    @ReportItem(name = "hokenshaNo5", length = 2, order = 11)
    public RString hokenshaNo5;
    @ReportItem(name = "hokenshaNo6", length = 2, order = 12)
    public RString hokenshaNo6;
    @ReportItem(name = "hihokenshaNo1", length = 2, order = 13)
    public RString hihokenshaNo1;
    @ReportItem(name = "hihokenshaNo3", length = 2, order = 14)
    public RString hihokenshaNo3;
    @ReportItem(name = "hihokenshaNo4", length = 2, order = 15)
    public RString hihokenshaNo4;
    @ReportItem(name = "hihokenshaNo5", length = 2, order = 16)
    public RString hihokenshaNo5;
    @ReportItem(name = "hihokenshaNo6", length = 2, order = 17)
    public RString hihokenshaNo6;
    @ReportItem(name = "hihokenshaNo7", length = 2, order = 18)
    public RString hihokenshaNo7;
    @ReportItem(name = "hihokenshaNo8", length = 2, order = 19)
    public RString hihokenshaNo8;
    @ReportItem(name = "hihokenshaNo9", length = 2, order = 20)
    public RString hihokenshaNo9;
    @ReportItem(name = "hihokenshaNo10", length = 2, order = 21)
    public RString hihokenshaNo10;
    @ReportItem(name = "hihokenshaNo2", length = 2, order = 22)
    public RString hihokenshaNo2;
    @ReportItem(name = "hihokenshaName", length = 20, order = 23)
    public RString hihokenshaName;
    @ReportItem(name = "shinseiYY1", length = 2, order = 31)
    public RString oCR_shinseiYY1;
    @ReportItem(name = "shinseiYY2", length = 2, order = 32)
    public RString oCR_shinseiYY2;
    @ReportItem(name = "shinseiMM1", length = 2, order = 33)
    public RString oCR_shinseiMM1;
    @ReportItem(name = "shinseiMM2", length = 2, order = 34)
    public RString oCR_shinseiMM2;
    @ReportItem(name = "shinseiDD1", length = 2, order = 35)
    public RString oCR_shinseiDD1;
    @ReportItem(name = "shinseiDD2", length = 2, order = 36)
    public RString oCR_shinseiDD2;
    @ReportItem(name = "hokenshaNo1", length = 2, order = 37)
    public RString oCR_hokenshaNo1;
    @ReportItem(name = "hokenshaNo2", length = 2, order = 38)
    public RString oCR_hokenshaNo2;
    @ReportItem(name = "hokenshaNo3", length = 2, order = 39)
    public RString oCR_hokenshaNo3;
    @ReportItem(name = "hokenshaNo4", length = 2, order = 40)
    public RString oCR_hokenshaNo4;
    @ReportItem(name = "hokenshaNo5", length = 2, order = 41)
    public RString oCR_hokenshaNo5;
    @ReportItem(name = "hokenshaNo6", length = 2, order = 42)
    public RString oCR_hokenshaNo6;
    @ReportItem(name = "shinseishaName", length = 20, order = 43)
    public RString oCR_shinseishaName;
    @ReportItem(name = "hishokenshaNo7", length = 2, order = 44)
    public RString oCR_hishokenshaNo7;
    @ReportItem(name = "hishokenshaNo8", length = 2, order = 45)
    public RString oCR_hishokenshaNo8;
    @ReportItem(name = "hishokenshaNo9", length = 2, order = 46)
    public RString oCR_hishokenshaNo9;
    @ReportItem(name = "hishokenshaNo10", length = 2, order = 47)
    public RString oCR_hishokenshaNo10;
    @ReportItem(name = "hishokenshaNo1", length = 2, order = 48)
    public RString oCR_hishokenshaNo1;
    @ReportItem(name = "hishokenshaNo2", length = 2, order = 49)
    public RString oCR_hishokenshaNo2;
    @ReportItem(name = "hishokenshaNo3", length = 2, order = 50)
    public RString oCR_hishokenshaNo3;
    @ReportItem(name = "hishokenshaNo4", length = 2, order = 51)
    public RString oCR_hishokenshaNo4;
    @ReportItem(name = "hishokenshaNo5", length = 2, order = 52)
    public RString oCR_hishokenshaNo5;
    @ReportItem(name = "hishokenshaNo6", length = 2, order = 53)
    public RString oCR_hishokenshaNo6;
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
