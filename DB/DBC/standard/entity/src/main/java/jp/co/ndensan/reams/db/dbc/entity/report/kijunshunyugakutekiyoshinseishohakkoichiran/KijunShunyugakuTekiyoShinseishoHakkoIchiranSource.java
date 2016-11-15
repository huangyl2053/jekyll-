package jp.co.ndensan.reams.db.dbc.entity.report.kijunshunyugakutekiyoshinseishohakkoichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 帳票設計_DBC200088_基準収入額適用申請書一覧表 Sourceクラスです。
 *
 * @reamsid_L DBC-4640-060 lijian
 */
public class KijunShunyugakuTekiyoShinseishoHakkoIchiranSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "nendo", length = 6, order = 2)
    public RString nendo;
    @ReportItem(name = "hokenshaNo", length = 6, order = 3)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 20, order = 4)
    public RString hokenshaName;
    @ReportItem(name = "shutsuryokujun1", length = 10, order = 5)
    public RString shutsuryokujun1;
    @ReportItem(name = "shutsuryokujun2", length = 10, order = 6)
    public RString shutsuryokujun2;
    @ReportItem(name = "shutsuryokujun3", length = 10, order = 7)
    public RString shutsuryokujun3;
    @ReportItem(name = "shutsuryokujun4", length = 10, order = 8)
    public RString shutsuryokujun4;
    @ReportItem(name = "shutsuryokujun5", length = 10, order = 9)
    public RString shutsuryokujun5;
    @ReportItem(name = "kaipage4", length = 20, order = 10)
    public RString kaipage4;
    @ReportItem(name = "kaipage1", length = 20, order = 11)
    public RString kaipage1;
    @ReportItem(name = "kaipage2", length = 20, order = 12)
    public RString kaipage2;
    @ReportItem(name = "kaipage5", length = 20, order = 13)
    public RString kaipage5;
    @ReportItem(name = "kaipage3", length = 20, order = 14)
    public RString kaipage3;
    @ReportItem(name = "listIchiran_1", length = 6, order = 15)
    public RString listIchiran_1;
    @ReportItem(name = "listIchiran_2", length = 15, order = 16)
    public RString listIchiran_2;
    @ReportItem(name = "listIchiran_3", length = 3, order = 17)
    public RString listIchiran_3;
    @ReportItem(name = "listIchiran_4", length = 11, order = 18)
    public RString listIchiran_4;
    @ReportItem(name = "listIchiran_5", length = 10, order = 19)
    public RString listIchiran_5;
    @ReportItem(name = "listIchiran_6", length = 12, order = 20)
    public RString listIchiran_6;
    @ReportItem(name = "listIchiran_7", length = 3, order = 21)
    public RString listIchiran_7;
    @ReportItem(name = "listIchiran_8", length = 10, order = 22)
    public RString listIchiran_8;
    @ReportItem(name = "listIchiran_9", length = 11, order = 23)
    public RString listIchiran_9;
    @ReportItem(name = "listIchiran_10", length = 11, order = 24)
    public RString listIchiran_10;
    @ReportItem(name = "listIchiran_11", length = 11, order = 25)
    public RString listIchiran_11;
    @ReportItem(name = "listIchiran_12", length = 11, order = 26)
    public RString listIchiran_12;
    @ReportItem(name = "listIchiran_13", length = 11, order = 27)
    public RString listIchiran_13;
    @ReportItem(name = "listIchiran_14", length = 4, order = 28)
    public RString listIchiran_14;
    @ReportItem(name = "listIchiran_15", length = 10, order = 29)
    public RString listIchiran_15;
    @ReportItem(name = "listIchiran_16", length = 10, order = 30)
    public RString listIchiran_16;
    @ReportPerson(id = "A")
    @ReportItem(name = "shikibetsuCode", length = 15)
    public RString shikibetsuCode;
    @ReportItem(name = "yubinNo", length = 20, order = 31)
    public RString yubinNo;
    @ReportItem(name = "choikiCode", length = 20, order = 32)
    public RString choikiCode;
    @ReportItem(name = "gyoseikuCode", length = 20, order = 33)
    public RString gyoseikuCode;
    @ReportItem(name = "setaiCode", length = 20, order = 341)
    public RString setaiCode;
    @ReportItem(name = "shichosonCode", length = 20, order = 35)
    public RString shichosonCode;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
    @ReportExpandedInfo(id = "A")
    public ExpandedInformation 拡張情報A1;
    @ReportExpandedInfo(id = "A")
    public ExpandedInformation 拡張情報A2;
}
