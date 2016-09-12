package jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki2711;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 *
 * 介護事業状況報告年報（様式2-7) のReportSourceです。
 *
 * @reamsid_L DBU-5600-280 guoqilin
 */
public class JigyohokokuCompYoshiki2711ReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "shuukeiHani", length = 40, order = 1)
    public RString shuukeiHani;
    @ReportItem(name = "shukeiKubun", length = 4, order = 2)
    public RString shukeiKubun;
    @ReportItem(name = "printTimeStamp", length = 26, order = 3)
    public RString printTimeStamp;
    @ReportItem(name = "hokenshaNo", length = 12, order = 4)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 13, order = 5)
    public RString hokenshaName;
    @ReportItem(name = "listUpper_1", length = 17, order = 6)
    public RString listUpper_1;
    @ReportItem(name = "listUpper_2", length = 17, order = 7)
    public RString listUpper_2;
    @ReportItem(name = "listUpper_3", length = 17, order = 8)
    public RString listUpper_3;
    @ReportItem(name = "listLower_1", length = 17, order = 9)
    public RString listLower_1;
    @ReportItem(name = "listLower_2", length = 17, order = 10)
    public RString listLower_2;
    @ReportItem(name = "listLower_3", length = 17, order = 11)
    public RString listLower_3;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
