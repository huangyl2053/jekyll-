/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.report.hanyolist;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 汎用リストのReportSourceです。
 *
 * @reamsid_L DBZ-4570-020 jinge
 */
public class HanyoListReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 30, order = 1)
    public RString title;
    @ReportItem(name = "subtitle", length = 15, order = 2)
    public RString subtitle;
    @ReportItem(name = "shichosoncode", length = 6, order = 3)
    public RString shichosoncode;
    @ReportItem(name = "shichosonmei", length = 12, order = 4)
    public RString shichosonmei;
    @ReportItem(name = "sort1", length = 10, order = 5)
    public RString sort1;
    @ReportItem(name = "sort2", length = 10, order = 6)
    public RString sort2;
    @ReportItem(name = "sort3", length = 10, order = 7)
    public RString sort3;
    @ReportItem(name = "sort4", length = 10, order = 8)
    public RString sort4;
    @ReportItem(name = "sort5", length = 10, order = 9)
    public RString sort5;
    @ReportItem(name = "sakuseiymd", length = 23, order = 10)
    public RString sakuseiymd;
    @ReportItem(name = "page1", length = 20, order = 11)
    public RString page1;
    @ReportItem(name = "page2", length = 20, order = 12)
    public RString page2;
    @ReportItem(name = "page3", length = 20, order = 13)
    public RString page3;
    @ReportItem(name = "page4", length = 20, order = 14)
    public RString page4;
    @ReportItem(name = "page5", length = 20, order = 15)
    public RString page5;
    @ReportItem(name = "listMeisaititle", length = 210, order = 16)
    public RString listMeisaititle;
    @ReportItem(name = "listMeisailist_1", length = 210, order = 17)
    public RString listMeisailist_1;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
