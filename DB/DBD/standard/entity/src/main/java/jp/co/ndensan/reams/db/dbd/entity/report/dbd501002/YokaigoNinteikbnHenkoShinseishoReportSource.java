/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.report.dbd501002;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 要介護認定区分変更申請書のReportSource
 *
 * @reamsid_L DBD-1400-030 b_zhengs
 */
public class YokaigoNinteikbnHenkoShinseishoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 1)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 2)
    @ReportExpandedInfo(code = "0003", name = "被保険者番号")
    public RString hihokenshaNo;
    @ReportItem(name = "hihokenshaNameKana", order = 3)
    public RString hihokenshaNameKana;
    @ReportItem(name = "birthYMD", length = 11, order = 4)
    public RString birthYMD;
    @ReportItem(name = "hihokenshaName", order = 5)
    public RString hihokenshaName;
    @ReportItem(name = "seibetsu", length = 1, order = 6)
    public RString seibetsu;
    @ReportItem(name = "hihokenshaYubinNo", length = 8, order = 7)
    public RString hihokenshaYubinNo;
    @ReportItem(name = "hihokenshaTelNo", length = 20, order = 8)
    public RString hihokenshaTelNo;
    @ReportItem(name = "hihokenJusho", order = 9)
    public RString hihokenJusho;
    @ReportItem(name = "yokaigoKbn", length = 4, order = 10)
    public RString yokaigoKbn;
    @ReportItem(name = "yoshienKbn", length = 4, order = 11)
    public RString yoshienKbn;
    @ReportItem(name = "yokoKikanSTYMD", length = 11, order = 12)
    public RString yokoKikanSTYMD;
    @ReportItem(name = "yokoKikanEDYMD", length = 11, order = 13)
    public RString yokoKikanEDYMD;
    @ReportItem(name = "tsuchiBun", order = 14)
    public RString tsuchiBun;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
