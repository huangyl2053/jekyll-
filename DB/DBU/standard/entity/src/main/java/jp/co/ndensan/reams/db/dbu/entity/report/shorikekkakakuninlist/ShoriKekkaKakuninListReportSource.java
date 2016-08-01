package jp.co.ndensan.reams.db.dbu.entity.report.shorikekkakakuninlist;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 特記事項Sourceクラスです。
 *
 * @reamsid_L DBU-5590-040 wanghuafeng
 */
public class ShoriKekkaKakuninListReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "shichosonCode", length = 6, order = 2)
    public RString shichosonCode;
    @ReportItem(name = "shichosonName", length = 20, order = 3)
    public RString shichosonName;
    @ReportItem(name = "keyKomoku1", length = 7, order = 4)
    public RString keyKomoku1;
    @ReportItem(name = "keyKomoku2", length = 7, order = 5)
    public RString keyKomoku2;
    @ReportItem(name = "keyKomoku3", length = 7, order = 6)
    public RString keyKomoku3;
    @ReportItem(name = "keyKomoku4", length = 7, order = 7)
    public RString keyKomoku4;
    @ReportItem(name = "keyKomoku5", length = 7, order = 8)
    public RString keyKomoku5;
    @ReportItem(name = "listUpper_1", length = 15, order = 9)
    public RString listUpper_1;
    @ReportItem(name = "listUpper_2", length = 16, order = 10)
    public RString listUpper_2;
    @ReportItem(name = "listUpper_3", length = 16, order = 11)
    public RString listUpper_3;
    @ReportItem(name = "listUpper_4", length = 16, order = 12)
    public RString listUpper_4;
    @ReportItem(name = "listUpper_5", length = 16, order = 13)
    public RString listUpper_5;
    @ReportItem(name = "listUpper_6", length = 16, order = 14)
    public RString listUpper_6;
    @ReportItem(name = "listUpper_7", length = 35, order = 15)
    public RString listUpper_7;
    @ReportItem(name = "listLower_1", length = 11, order = 16)
    public RString listLower_1;
    @ReportItem(name = "listLower_2", length = 35, order = 17)
    public RString listLower_2;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
