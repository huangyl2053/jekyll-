package jp.co.ndensan.reams.db.dbc.entity.report.kogakujigyoshinseishohakkoichiransource;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 帳票設計_DBC200091_高額総合事業サービス費申請書発行一覧表のSourceクラスです。
 *
 * @reamsid_L DBC-4770-120 jianglaisheng
 */
public class KogakuJigyoShinseishoHakkoIchiranSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "shichosonNo", length = 6, order = 2)
    public RString shichosonNo;
    @ReportItem(name = "shichosonName", length = 12, order = 3)
    public RString shichosonName;
    @ReportItem(name = "shutsuryokujun1", length = 10, order = 4)
    public RString shutsuryokujun1;
    @ReportItem(name = "shutsuryokujun2", length = 10, order = 5)
    public RString shutsuryokujun2;
    @ReportItem(name = "shutsuryokujun3", length = 10, order = 6)
    public RString shutsuryokujun3;
    @ReportItem(name = "shutsuryokujun4", length = 10, order = 7)
    public RString shutsuryokujun4;
    @ReportItem(name = "shutsuryokujun5", length = 10, order = 8)
    public RString shutsuryokujun5;
    @ReportItem(name = "kaipage1", length = 20, order = 9)
    public RString kaipage1;
    @ReportItem(name = "kaipage2", length = 20, order = 10)
    public RString kaipage2;
    @ReportItem(name = "kaipage3", length = 20, order = 11)
    public RString kaipage3;
    @ReportItem(name = "kaipage4", length = 20, order = 12)
    public RString kaipage4;
    @ReportItem(name = "kaipage5", length = 20, order = 13)
    public RString kaipage5;
    @ReportItem(name = "listHakkoTaishosha_1", length = 4, order = 14)
    public RString listHakkoTaishosha_1;
    @ReportItem(name = "listHakkoTaishosha_2", length = 10, order = 15)
    @ReportExpandedInfo(id = "X")
    public RString listHakkoTaishosha_2;
    @ReportItem(name = "listHakkoTaishosha_3", length = 6, order = 16)
    public RString listHakkoTaishosha_3;
    @ReportItem(name = "listHakkoTaishosha_4", length = 10, order = 17)
    public RString listHakkoTaishosha_4;
    @ReportItem(name = "listHakkoTaishosha_5", length = 10, order = 18)
    public RString listHakkoTaishosha_5;
    @ReportItem(name = "listHakkoTaishosha_6", length = 15, order = 19)
    public RString listHakkoTaishosha_6;
    @ReportItem(name = "listHakkoTaishosha_7", length = 9, order = 20)
    public RString listHakkoTaishosha_7;
    @ReportItem(name = "listHakkoTaishosha_8", length = 14, order = 21)
    public RString listHakkoTaishosha_8;
    @ReportItem(name = "listHakkoTaishosha_9", length = 2, order = 22)
    public RString listHakkoTaishosha_9;
    @ReportItem(name = "listHakkoTaishosha_10", length = 5, order = 23)
    public RString listHakkoTaishosha_10;
    @ReportItem(name = "listHakkoTaishosha_11", length = 9, order = 24)
    public RString listHakkoTaishosha_11;
    @ReportItem(name = "listHakkoTaishosha_12", length = 9, order = 25)
    public RString listHakkoTaishosha_12;
    @ReportItem(name = "listHakkoTaishosha_13", length = 10, order = 26)
    public RString listHakkoTaishosha_13;
    @ReportItem(name = "listHakkoTaishosha_14", length = 10, order = 27)
    public RString listHakkoTaishosha_14;
    @ReportItem(name = "listHakkoTaishosha_15", length = 1, order = 28)
    public RString listHakkoTaishosha_15;
    @ReportItem(name = "listHakkoTaishosha_16", length = 1, order = 29)
    public RString listHakkoTaishosha_16;
    @ReportItem(name = "listHakkoTaishosha_17", length = 1, order = 30)
    public RString listHakkoTaishosha_17;
    @ReportPerson(id = "X")
    public ShikibetsuCode 識別コード;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
    @ReportItem(name = "tsuchishoNo", length = 20, order = 31)
    public RString tsuchishoNo;
// </editor-fold>
}
