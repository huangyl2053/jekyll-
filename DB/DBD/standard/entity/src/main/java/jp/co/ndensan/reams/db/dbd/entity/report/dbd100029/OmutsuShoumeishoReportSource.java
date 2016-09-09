/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.report.dbd100029;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * おむつ使用証明書ReportSourceです。
 *
 * @reamsid_L DBD-5780-030 donghj
 */
public class OmutsuShoumeishoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 8, order = 1)
    public RString title;
    @ReportItem(name = "jusyo1", length = 30, order = 2)
    public RString jusyo1;
    @ReportItem(name = "jusyo", length = 30, order = 3)
    public RString jusyo;
    @ReportItem(name = "jusyo2", length = 30, order = 4)
    public RString jusyo2;
    @ReportItem(name = "hihoName1", length = 20, order = 5)
    public RString hihoName1;
    @ReportItem(name = "seibetuOtoko", length = 2, order = 6)
    public RString seibetuOtoko;
    @ReportItem(name = "seibetuOnna", length = 2, order = 7)
    public RString seibetuOnna;
    @ReportItem(name = "hihoName", length = 20, order = 8)
    public RString hihoName;
    @ReportItem(name = "hihoName2", length = 20, order = 9)
    public RString hihoName2;
    @ReportItem(name = "UmareYmd", length = 12, order = 10)
    public RString umareYmd;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
