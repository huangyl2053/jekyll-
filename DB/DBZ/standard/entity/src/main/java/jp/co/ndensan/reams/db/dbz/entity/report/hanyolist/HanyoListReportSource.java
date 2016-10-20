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
    @ReportItem(name = "yubinNo", length = 20, order = 18)
    public RString yubinNo;
    @ReportItem(name = "choikiCode", length = 20, order = 19)
    public RString choikiCode;
    @ReportItem(name = "banchi", length = 20, order = 20)
    public RString banchi;
    @ReportItem(name = "gyoseikuCode", length = 20, order = 21)
    public RString gyoseikuCode;
    @ReportItem(name = "chikuCode1", length = 20, order = 22)
    public RString chikuCode1;
    @ReportItem(name = "chikuCode2", length = 20, order = 23)
    public RString chikuCode2;
    @ReportItem(name = "setaiCode", length = 20, order = 24)
    public RString setaiCode;
    @ReportItem(name = "shikibetsuCode", length = 20, order = 25)
    public RString shikibetsuCode;
    @ReportItem(name = "kanaShimei", length = 20, order = 26)
    public RString kanaShimei;
    @ReportItem(name = "seinengappiYMD", length = 20, order = 27)
    public RString seinengappiYMD;
    @ReportItem(name = "seibetsuCode", length = 20, order = 28)
    public RString seibetsuCode;
    @ReportItem(name = "shichosonCode1", length = 20, order = 29)
    public RString shichosonCode1;
    @ReportItem(name = "shoKisaiHokenshaNo", length = 20, order = 30)
    public RString shoKisaiHokenshaNo;
    @ReportItem(name = "hokenshaNo", length = 20, order = 31)
    public RString hokenshaNo;
    @ReportItem(name = "new1", length = 20, order = 32)
    public RString new1;
    @ReportItem(name = "new2", length = 20, order = 33)
    public RString new2;
    @ReportItem(name = "new3", length = 20, order = 34)
    public RString new3;
    @ReportItem(name = "new4", length = 20, order = 35)
    public RString new4;
    @ReportItem(name = "new5", length = 20, order = 36)
    public RString new5;
    @ReportItem(name = "new6", length = 20, order = 37)
    public RString new6;
    @ReportItem(name = "new7", length = 20, order = 38)
    public RString new7;

// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
