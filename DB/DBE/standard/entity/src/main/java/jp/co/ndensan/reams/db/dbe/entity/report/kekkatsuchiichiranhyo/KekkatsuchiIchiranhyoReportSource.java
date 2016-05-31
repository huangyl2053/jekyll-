package jp.co.ndensan.reams.db.dbe.entity.report.kekkatsuchiichiranhyo;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 要介護認定結果通知一覧表のReportSourceです。
 *
 * @reamsid_L DBE-0180-020 xuyannan
 */
public class KekkatsuchiIchiranhyoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 30, order = 1)
    public RString title;
    @ReportItem(name = "shichosonName", length = 20, order = 2)
    public RString shichosonName;
    @ReportItem(name = "shinsakaiNo", length = 4, order = 3)
    public RString shinsakaiNo;
    @ReportItem(name = "shinsakaiKaisaiYMD", length = 9, order = 4)
    public RString shinsakaiKaisaiYMD;
    @ReportItem(name = "printTimeStamp", length = 34, order = 5)
    public RString printTimeStamp;
    @ReportItem(name = "listKekkatsuchitaisho_1", length = 2, order = 6)
    public RString listKekkatsuchitaisho_1;
    @ReportItem(name = "listKekkatsuchitaisho_2", length = 7, order = 7)
    public RString listKekkatsuchitaisho_2;
    @ReportItem(name = "listKekkatsuchitaisho_3", length = 9, order = 8)
    public RString listKekkatsuchitaisho_3;
    @ReportItem(name = "listKekkatsuchitaisho_4", length = 10, order = 9)
    public RString listKekkatsuchitaisho_4;
    @ReportItem(name = "listKekkatsuchitaisho_5", length = 30, order = 10)
    public RString listKekkatsuchitaisho_5;
    @ReportItem(name = "listKekkatsuchitaisho_6", length = 30, order = 11)
    public RString listKekkatsuchitaisho_6;
    @ReportItem(name = "listKekkatsuchitaisho_7", length = 9, order = 12)
    public RString listKekkatsuchitaisho_7;
    @ReportItem(name = "listKekkatsuchitaisho_8", length = 1, order = 13)
    public RString listKekkatsuchitaisho_8;
    @ReportItem(name = "listKekkatsuchitaisho_9", length = 4, order = 14)
    public RString listKekkatsuchitaisho_9;
    @ReportItem(name = "listKekkatsuchitaisho_10", length = 4, order = 15)
    public RString listKekkatsuchitaisho_10;
    @ReportItem(name = "listKekkatsuchitaisho_11", length = 19, order = 16)
    public RString listKekkatsuchitaisho_11;
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
