/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.report.source.ikenshosakuseiiraiichiranhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 主治医意見書作成依頼一覧表Sourceクラスです。
 */
public class IkenshoSakuseiIraiIchiranhyoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "yubinNo", length = 8, order = 2)
    public RString yubinNo;
    @ReportItem(name = "iryokikanJusho", length = 60, order = 3)
    public RString iryokikanJusho;
    @ReportItem(name = "iryokikanName", length = 60, order = 4)
    public RString iryokikanName;
    @ReportItem(name = "listIchiranhyo_1", length = 3, order = 5)
    public RString listIchiranhyo_1;
    @ReportItem(name = "listIchiranhyo_2", length = 18, order = 6)
    public RString listIchiranhyo_2;
    @ReportItem(name = "listIchiranhyo_3", length = 10, order = 7)
    public RString listIchiranhyo_3;
    @ReportItem(name = "listIchiranhyo_4", length = 16, order = 8)
    public RString listIchiranhyo_4;
    @ReportItem(name = "listIchiranhyo_5", length = 24, order = 9)
    public RString listIchiranhyo_5;
    @ReportItem(name = "listIchiranhyo_6", length = 40, order = 10)
    public RString listIchiranhyo_6;
    @ReportItem(name = "listIchiranhyo_7", length = 10, order = 11)
    public RString listIchiranhyo_7;
    @ReportItem(name = "listIchiranhyo_8", length = 2, order = 12)
    public RString listIchiranhyo_8;
    @ReportItem(name = "listIchiranhyo_9", length = 10, order = 13)
    public RString listIchiranhyo_9;
    @ReportItem(name = "toiawasesaki", length = 30, order = 14)
    public RString toiawasesaki;
    @ReportItem(name = "denshiKoin", order = 15)
    public RString denshiKoin;
    @ReportItem(name = "shomeiHakkoYMD", length = 22, order = 16)
    public RString shomeiHakkoYMD;
    @ReportItem(name = "shuchoMei", length = 14, order = 17)
    public RString shuchoMei;
    @ReportItem(name = "shichosonMei", length = 40, order = 18)
    public RString shichosonMei;
    @ReportItem(name = "koinShoryaku", length = 15, order = 19)
    public RString koinShoryaku;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
