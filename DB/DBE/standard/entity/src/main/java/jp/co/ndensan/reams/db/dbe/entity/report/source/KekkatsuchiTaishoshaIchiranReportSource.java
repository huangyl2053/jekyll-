/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.report.source;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

public class KekkatsuchiTaishoshaIchiranReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 30, order = 1)
    public RString title;
    @ReportItem(name = "shichosonName", length = 20, order = 2)
    public RString shichosonName;
    @ReportItem(name = "chushutsuKikan", length = 19, order = 3)
    public RString chushutsuKikan;
    @ReportItem(name = "printTimeStamp", length = 34, order = 4)
    public RString printTimeStamp;
    @ReportItem(name = "listKekkatsuchi_1", length = 3, order = 5)
    public RString listKekkatsuchi_1;
    @ReportItem(name = "listKekkatsuchi_2", length = 5, order = 6)
    public RString listKekkatsuchi_2;
    @ReportItem(name = "listKekkatsuchi_3", length = 9, order = 7)
    public RString listKekkatsuchi_3;
    @ReportItem(name = "listKekkatsuchi_4", length = 9, order = 8)
    public RString listKekkatsuchi_4;
    @ReportItem(name = "listKekkatsuchi_5", length = 10, order = 9)
    public RString listKekkatsuchi_5;
    @ReportItem(name = "listKekkatsuchi_6", length = 30, order = 10)
    public RString listKekkatsuchi_6;
    @ReportItem(name = "listKekkatsuchi_7", length = 30, order = 11)
    public RString listKekkatsuchi_7;
    @ReportItem(name = "listKekkatsuchi_8", length = 9, order = 12)
    public RString listKekkatsuchi_8;
    @ReportItem(name = "listKekkatsuchi_9", length = 1, order = 13)
    public RString listKekkatsuchi_9;
    @ReportItem(name = "listKekkatsuchi_10", length = 4, order = 14)
    public RString listKekkatsuchi_10;
    @ReportItem(name = "gokei", length = 3, order = 15)
    public RString gokei;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
