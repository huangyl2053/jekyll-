/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.gassanshikyushinseishojohosofuichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 帳票設計_DBC200027_高額合算支給申請書情報送付一覧表 のReportSourceクラスです。
 *
 * @reamsid_L DBC-2630-040 zhengshenlei
 */
public class GassanShikyuShinseishoJohoSofuIchiranSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "sofuYM", length = 8, order = 2)
    public RString sofuYM;
    @ReportItem(name = "hokenshaNo", length = 6, order = 3)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 12, order = 4)
    public RString hokenshaName;
    @ReportItem(name = "list_1", length = 4, order = 5)
    public RString list_1;
    @ReportItem(name = "list_2", length = 5, order = 6)
    public RString list_2;
    @ReportItem(name = "list_3", length = 3, order = 7)
    public RString list_3;
    @ReportItem(name = "list_4", length = 9, order = 8)
    public RString list_4;
    @ReportItem(name = "list_5", length = 17, order = 9)
    public RString list_5;
    @ReportItem(name = "list_6", length = 15, order = 10)
    public RString list_6;
    @ReportItem(name = "list_7", length = 1, order = 11)
    public RString list_7;
    @ReportItem(name = "list_8", length = 1, order = 12)
    public RString list_8;
    @ReportExpandedInfo(id = "A", code = "0003", name = "被保険者番号")
    @ReportItem(name = "list_9", length = 10, order = 13)
    public RString list_9;
    @ReportItem(name = "list_10", length = 15, order = 14)
    public RString list_10;
    @ReportItem(name = "list_11", length = 19, order = 15)
    public RString list_11;
    @ReportItem(name = "list_12", length = 5, order = 16)
    public RString list_12;
    @ReportItem(name = "list_13", length = 5, order = 17)
    public RString list_13;
    @ReportItem(name = "list_14", length = 4, order = 18)
    public RString list_14;
    @ReportItem(name = "list_15", length = 1, order = 19)
    public RString list_15;
    @ReportItem(name = "list_16", length = 1, order = 20)
    public RString list_16;
    @ReportPerson(id = "A")
    @ReportItem(name = "shikibetsuCode", length = 15)
    public RString shikibetsuCode;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>

    /**
     * GassanShikyuShinseishoJohoSofuIchiranSourceのenum
     */
    public enum ReportSourceFields {

        printTimeStamp,
        sofuYM,
        hokenshaNo,
        hokenshaName,
        list_1,
        list_2,
        list_3,
        list_4,
        list_6,
        list_7,
        list_8,
        list_9,
        list_10,
        list_11,
        list_12,
        list_13,
        list_14,
        list_15,
        list_16
    }
}
