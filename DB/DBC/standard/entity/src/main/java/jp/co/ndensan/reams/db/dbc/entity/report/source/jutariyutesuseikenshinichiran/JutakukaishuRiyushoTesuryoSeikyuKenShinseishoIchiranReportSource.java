package jp.co.ndensan.reams.db.dbc.entity.report.source.jutariyutesuseikenshinichiran;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 住宅改修理由書作成手数料請求書兼申請書作成 のReportSourceです。
 *
 * @reamsid_L DBC-2860-050 dangjingjing
 */
public class JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "pageAll", length = 6, order = 1)
    public RString pageAll;
    @ReportItem(name = "kaishiYM", length = 11, order = 2)
    public RString kaishiYM;
    @ReportItem(name = "syuryoYM", length = 11, order = 3)
    public RString syuryoYM;
    @ReportItem(name = "jigyoshaMeisho", length = 15, order = 4)
    public RString jigyoshaMeisho;
    @ReportItem(name = "printTimeStamp", length = 21, order = 5)
    public RString printTimeStamp;
    @ReportItem(name = "list1_1", length = 3, order = 6)
    public RString list1_1;
    @ReportItem(name = "list1_2", length = 12, order = 7)
    public RString list1_2;
    @ReportItem(name = "list1_3", length = 10, order = 8)
    public RString list1_3;
    @ReportItem(name = "list1_4", length = 15, order = 9)
    public RString list1_4;
    @ReportItem(name = "list1_5", length = 45, order = 10)
    public RString list1_5;
    @ReportItem(name = "list1_6", length = 30, order = 11)
    public RString list1_6;
    @ReportItem(name = "list1_7", length = 15, order = 12)
    public RString list1_7;
    @ReportItem(name = "list1_8", length = 35, order = 13)
    public RString list1_8;
    @ReportPerson(id = "X")
    public ShikibetsuCode shikibetuCode;
    @ReportExpandedInfo(id = "X")
    public ExpandedInformation hihokenshaNo;
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

        jigyoshaMeisho
    }
}
