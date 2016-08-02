package jp.co.ndensan.reams.db.dbu.entity.report.ｊigyohokokucompyoshiki272;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 介護事業状況報告月報・保険給付決定状況（様式2-7） のレーポトソースです。
 *
 * @reamsid_L DBU-5590-050 wanghuafeng
 */
public class JigyohokokuCompYoshiki272ReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "shukeiKubun", length = 4, order = 2)
    public RString shukeiKubun;
    @ReportItem(name = "shuukeiHani", length = 40, order = 3)
    public RString shuukeiHani;
    @ReportItem(name = "hokenshaNo", length = 12, order = 4)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 13, order = 5)
    public RString hokenshaName;
    @ReportItem(name = "listUpper_1", length = 17, order = 6)
    public RString listUpper_1;
    @ReportItem(name = "listLower_1", length = 17, order = 7)
    public RString listLower_1;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
