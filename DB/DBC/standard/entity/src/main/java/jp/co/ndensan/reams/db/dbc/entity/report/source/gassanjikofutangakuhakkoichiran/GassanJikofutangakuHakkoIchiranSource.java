/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.report.source.gassanjikofutangakuhakkoichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 帳票設計_DBC200035_高額合算自己負担額証明書発行一覧表 のソースクラスです。
 *
 * @reamsid_L DBC-2380-040 qinzhen
 */
public class GassanJikofutangakuHakkoIchiranSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "hokenshaNo", length = 6, order = 2)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 12, order = 3)
    public RString hokenshaName;
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
    @ReportItem(name = "list_1", length = 6, order = 14)
    public RString list_1;
    @ReportItem(name = "list_2", length = 10, order = 15)
    public RString list_2;
    @ReportItem(name = "list_3", length = 20, order = 16)
    public RString list_3;
    @ReportItem(name = "list_4", length = 11, order = 17)
    public RString list_4;
    @ReportItem(name = "list_5", length = 1, order = 18)
    public RString list_5;
    @ReportItem(name = "list_6", length = 17, order = 19)
    public RString list_6;
    @ReportItem(name = "list_7", length = 6, order = 20)
    public RString list_7;
    @ReportItem(name = "list_8", length = 21, order = 21)
    public RString list_8;
    @ReportItem(name = "list_9", length = 20, order = 22)
    public RString list_9;
    @ReportItem(name = "list_10", length = 13, order = 23)
    public RString list_10;
    @ReportItem(name = "list_11", length = 13, order = 24)
    public RString list_11;
    @ReportPerson(id = "A")
    @ReportItem(name = "shikibetsuCode", length = 15)
    public RString shikibetsuCode;
    @ReportExpandedInfo(id = "A")
    public ExpandedInformation expandedInformation;

    @ReportItem(name = "郵便番号")
    public RString 郵便番号;
    @ReportItem(name = "町域コード")
    public RString 町域コード;
    @ReportItem(name = "行政区コード")
    public RString 行政区コード;
    @ReportItem(name = "市町村コード")
    public RString 市町村コード;
    @ReportItem(name = "証記載保険者番号")
    public RString 証記載保険者番号;
    @ReportItem(name = "氏名５０音カナ")
    public RString 氏名５０音カナ;

// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
