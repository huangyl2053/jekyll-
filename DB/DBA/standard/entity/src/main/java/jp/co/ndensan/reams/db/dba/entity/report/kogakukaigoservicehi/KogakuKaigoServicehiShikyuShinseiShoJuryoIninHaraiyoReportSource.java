package jp.co.ndensan.reams.db.dba.entity.report.kogakukaigoservicehi;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 介護保険高額介護（予防）サービス費支給（受領委任払）申請書のReportSourceクラスです。
 */
public class KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "serviceYM", length = 8, order = 1)
    public RString serviceYM;
    @ReportItem(name = "hassobiYMD", length = 11, order = 2)
    public RString hassobiYMD;
    @ReportItem(name = "hokenshaNo", length = 6, order = 3)
    public RString hokenshaNo;
    @ReportItem(name = "hihokenshaNameKana", order = 4)
    public RString hihokenshaNameKana;
    @ReportItem(name = "hihokenshaName", order = 5)
    public RString hihokenshaName;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 6)
    public RString hihokenshaNo;
    @ReportItem(name = "birthYMD", length = 11, order = 7)
    public RString birthYMD;
    @ReportItem(name = "seibetsu", length = 1, order = 8)
    public RString seibetsu;
    @ReportItem(name = "telNo", length = 20, order = 9)
    public RString telNo;
    @ReportItem(name = "yubinNo", length = 8, order = 10)
    public RString yubinNo;
    @ReportItem(name = "jusho", order = 11)
    public RString jusho;
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
