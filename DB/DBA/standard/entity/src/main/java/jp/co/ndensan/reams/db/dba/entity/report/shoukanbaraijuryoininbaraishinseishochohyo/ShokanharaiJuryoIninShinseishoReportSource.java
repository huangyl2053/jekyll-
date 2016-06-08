package jp.co.ndensan.reams.db.dba.entity.report.shoukanbaraijuryoininbaraishinseishochohyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 介護保険償還払受領委任払申請書のReportSource
 *
 * @reamsid_L DBA-0540-707 xuyannan
 */
public class ShokanharaiJuryoIninShinseishoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "hihokenshaNameKana", order = 1)
    public RString hihokenshaNameKana;
    @ReportItem(name = "hokenshaNo", length = 6, order = 2)
    public RString hokenshaNo;
    @ReportItem(name = "hihokenshaName", order = 3)
    public RString hihokenshaName;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 4)
    public RString hihokenshaNo;
    @ReportItem(name = "birthYMD", length = 11, order = 5)
    public RString birthYMD;
    @ReportItem(name = "seibetsu", length = 1, order = 6)
    public RString seibetsu;
    @ReportItem(name = "telNo", length = 20, order = 7)
    public RString telNo;
    @ReportItem(name = "yubinNo", length = 8, order = 8)
    public RString yubinNo;
    @ReportItem(name = "hihokenJusho", order = 9)
    public RString hihokenJusho;
    @ReportItem(name = "shiseiBun", order = 10)
    public RString shiseiBun;
    @ReportItem(name = "chuiBun", order = 11)
    public RString chuiBun;
    @ReportItem(name = "remban", length = 4, order = 12)
    public RString remban;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 13)
    public RString ninshoshaYakushokuMei;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
