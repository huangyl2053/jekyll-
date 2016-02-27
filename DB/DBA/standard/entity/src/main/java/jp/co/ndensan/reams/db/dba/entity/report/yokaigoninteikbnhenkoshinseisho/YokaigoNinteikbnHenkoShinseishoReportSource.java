/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.report.yokaigoninteikbnhenkoshinseisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 要介護認定区分変更申請書のReportSourceクラスです。
 */
public class YokaigoNinteikbnHenkoShinseishoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "hihokenshaNo", length = 10, order = 1)
    public RString hihokenshaNo;
    @ReportItem(name = "hihokenshaNameKana", order = 2)
    public RString hihokenshaNameKana;
    @ReportItem(name = "birthYMD", length = 11, order = 3)
    public RString birthYMD;
    @ReportItem(name = "hihokenshaName", order = 4)
    public RString hihokenshaName;
    @ReportItem(name = "seibetsu", length = 1, order = 5)
    public RString seibetsu;
    @ReportItem(name = "hihokenshaYubinNo", length = 8, order = 6)
    public RString hihokenshaYubinNo;
    @ReportItem(name = "hihokenshaTelNo", length = 20, order = 7)
    public RString hihokenshaTelNo;
    @ReportItem(name = "hihokenJusho", order = 8)
    public RString hihokenJusho;
    @ReportItem(name = "yokaigoKbn", length = 4, order = 9)
    public RString yokaigoKbn;
    @ReportItem(name = "yoshienKbn", length = 4, order = 10)
    public RString yoshienKbn;
    @ReportItem(name = "yokoKikanSTYMD", length = 11, order = 11)
    public RString yokoKikanSTYMD;
    @ReportItem(name = "yokoKikanEDYMD", length = 11, order = 12)
    public RString yokoKikanEDYMD;
    @ReportItem(name = "tsuchiBun", order = 13)
    public RString tsuchiBun;
    @ReportItem(name = "remban", length = 4, order = 14)
    public RString remban;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 15)
    public RString ninshoshaYakushokuMei;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
