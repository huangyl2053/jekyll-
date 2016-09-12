package jp.co.ndensan.reams.db.dbd.entity.report.dbd800002;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 介護保険利用者負担額減額・免除申請書のReportSource
 *
 * @reamsid_L DBA-0540-691 suguangjun
 */
public class RiyoshaFutangakuGengakuMenjyoShinseishoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 30, order = 1)
    public RString title;
    @ReportItem(name = "hokenshaNo", length = 6, order = 2)
    public RString hokenshaNo;
    @ReportItem(name = "hihokenshaNameKana", order = 3)
    public RString hihokenshaNameKana;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 4)
    public RString hihokenshaNo;
    @ReportItem(name = "hihokenshaName", order = 5)
    public RString hihokenshaName;
    @ReportItem(name = "seibetsu", length = 1, order = 6)
    public RString seibetsu;
    @ReportItem(name = "birthYMD", length = 11, order = 7)
    public RString birthYMD;
    @ReportItem(name = "hihokenshaTelNo", length = 20, order = 8)
    public RString hihokenshaTelNo;
    @ReportItem(name = "hihokenshaYubinNo", length = 8, order = 9)
    public RString hihokenshaYubinNo;
    @ReportItem(name = "hihokenJusho", order = 10)
    public RString hihokenJusho;
    @ReportItem(name = "remban", length = 4, order = 11)
    public RString remban;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 12)
    public RString ninshoshaYakushokuMei;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
