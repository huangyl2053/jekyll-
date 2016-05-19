package jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishukeihyoshinsei;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 介護認定審査会集計表（申請区分別）のReportSourceクラスです。
 *
 * @reamsid_L DBE-1450-080 dongyabin
 */
public class ShinsakaiShukeihyoShinseiReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 30, order = 1)
    public RString title;
    @ReportItem(name = "shichosonName", length = 20, order = 2)
    public RString shichosonName;
    @ReportItem(name = "chushutsuKikan", length = 19, order = 3)
    public RString chushutsuKikan;
    @ReportItem(name = "printTimeStamp", length = 34, order = 4)
    public RString printTimeStamp;
    @ReportItem(name = "listShukeihyo1_1", length = 6, order = 5)
    public RString listShukeihyo1_1;
    @ReportItem(name = "listShukeihyo1_2", length = 6, order = 6)
    public RString listShukeihyo1_2;
    @ReportItem(name = "listShukeihyo1_3", length = 6, order = 7)
    public RString listShukeihyo1_3;
    @ReportItem(name = "listShukeihyo1_4", length = 6, order = 8)
    public RString listShukeihyo1_4;
    @ReportItem(name = "listShukeihyo1_5", length = 6, order = 9)
    public RString listShukeihyo1_5;
    @ReportItem(name = "listShukeihyo2_1", length = 6, order = 10)
    public RString listShukeihyo2_1;
    @ReportItem(name = "listShukeihyo2_2", length = 6, order = 11)
    public RString listShukeihyo2_2;
    @ReportItem(name = "listShukeihyo2_3", length = 6, order = 12)
    public RString listShukeihyo2_3;
    @ReportItem(name = "listShukeihyo2_4", length = 6, order = 13)
    public RString listShukeihyo2_4;
    @ReportItem(name = "listShukeihyo2_5", length = 6, order = 14)
    public RString listShukeihyo2_5;
    @ReportItem(name = "listShukeihyo3_1", length = 6, order = 15)
    public RString listShukeihyo3_1;
    @ReportItem(name = "listShukeihyo3_2", length = 6, order = 16)
    public RString listShukeihyo3_2;
    @ReportItem(name = "listShukeihyo3_3", length = 6, order = 17)
    public RString listShukeihyo3_3;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>

    /**
     * 改ページ条件のキーです。
     */
    public enum ReportSourceFields {

        shichosonName,
    }
}
