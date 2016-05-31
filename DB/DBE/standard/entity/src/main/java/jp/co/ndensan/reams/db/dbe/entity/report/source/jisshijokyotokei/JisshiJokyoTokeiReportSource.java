package jp.co.ndensan.reams.db.dbe.entity.report.source.jisshijokyotokei;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 要介護認定実施状況統計のReportSourceクラスです。
 *
 * @reamsid_L DBE-1450-040 dongyabin
 */
public class JisshiJokyoTokeiReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 15, order = 1)
    public RString title;
    @ReportItem(name = "printTimeStamp", length = 34, order = 2)
    public RString printTimeStamp;
    @ReportItem(name = "kaisaiKaishiYMD", length = 13, order = 3)
    public RString kaisaiKaishiYMD;
    @ReportItem(name = "kaisaiShuryoYMD", length = 13, order = 4)
    public RString kaisaiShuryoYMD;
    @ReportItem(name = "hokenshaNo", length = 6, order = 5)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 20, order = 6)
    public RString hokenshaName;
    @ReportItem(name = "listJisshiTokei_1", length = 10, order = 7)
    public RString listJisshiTokei_1;
    @ReportItem(name = "listJisshiTokei_2", length = 10, order = 8)
    public RString listJisshiTokei_2;
    @ReportItem(name = "listJisshiTokei_3", length = 10, order = 9)
    public RString listJisshiTokei_3;
    @ReportItem(name = "listJisshiTokei_4", length = 10, order = 10)
    public RString listJisshiTokei_4;
    @ReportItem(name = "listJisshiTokei_5", length = 10, order = 11)
    public RString listJisshiTokei_5;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
    @ReportPerson(id = "X")
    public ShikibetsuCode shikibetuCode;
    @ReportExpandedInfo(id = "X")
    public ExpandedInformation hishokenshaNo;

    /**
     * 改ページ条件のキーです。
     */
    public enum ReportSourceFields {

        hokenshaNo
    }
}
