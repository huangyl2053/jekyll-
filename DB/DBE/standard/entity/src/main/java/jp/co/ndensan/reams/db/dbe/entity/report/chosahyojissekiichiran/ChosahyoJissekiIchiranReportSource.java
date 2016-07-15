package jp.co.ndensan.reams.db.dbe.entity.report.chosahyojissekiichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 帳票出力用認定調査実績集計表のReportSourceクラスです。
 *
 * @reamsid_L DBE-1691-030 dangjingjing
 */
public class ChosahyoJissekiIchiranReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "listChosaJissekiIchiran_1", length = 12, order = 2)
    public RString listChosaJissekiIchiran_1;
    @ReportItem(name = "listChosaJissekiIchiran_2", length = 40, order = 3)
    public RString listChosaJissekiIchiran_2;
    @ReportItem(name = "listChosaJissekiIchiran_3", length = 20, order = 4)
    public RString listChosaJissekiIchiran_3;
    @ReportItem(name = "listChosaJissekiIchiran_4", length = 10, order = 5)
    public RString listChosaJissekiIchiran_4;
    @ReportItem(name = "listChosaJissekiIchiran_5", length = 20, order = 6)
    public RString listChosaJissekiIchiran_5;
    @ReportItem(name = "listChosaJissekiIchiran_6", length = 11, order = 7)
    public RString listChosaJissekiIchiran_6;
    @ReportItem(name = "listChosaJissekiIchiran_7", length = 4, order = 8)
    public RString listChosaJissekiIchiran_7;
    @ReportItem(name = "listChosaJissekiIchiran_8", length = 4, order = 9)
    public RString listChosaJissekiIchiran_8;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
