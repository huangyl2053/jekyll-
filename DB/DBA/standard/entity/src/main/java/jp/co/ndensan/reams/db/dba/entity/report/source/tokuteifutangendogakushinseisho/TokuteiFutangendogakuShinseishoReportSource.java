package jp.co.ndensan.reams.db.dba.entity.report.source.tokuteifutangendogakushinseisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 
 * 護保険特定負担限度額申請書の帳票データのクラスです。
 */
public class TokuteiFutangendogakuShinseishoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "hokenshaNo", length = 6, order = 1)
    public RString hokenshaNo;
    @ReportItem(name = "hihokenshaNameKana", order = 2)
    public RString hihokenshaNameKana;
    @ReportItem(name = "hihokenshaName", order = 3)
    public RString hihokenshaName;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 4)
    public RString hihokenshaNo;
    @ReportItem(name = "seibetsu", length = 1, order = 5)
    public RString seibetsu;
    @ReportItem(name = "birthYMD", length = 11, order = 6)
    public RString birthYMD;
    @ReportItem(name = "hihokenshaTelNo", length = 20, order = 7)
    public RString hihokenshaTelNo;
    @ReportItem(name = "hihokenshaYubinNo", length = 8, order = 8)
    public RString hihokenshaYubinNo;
    @ReportItem(name = "hihokenJusho", order = 9)
    public RString hihokenJusho;
    @ReportItem(name = "shisetsuYubinNo", length = 8, order = 10)
    public RString shisetsuYubinNo;
    @ReportItem(name = "shisetsuTelNo", length = 20, order = 11)
    public RString shisetsuTelNo;
    @ReportItem(name = "shisetsuJusho", order = 12)
    public RString shisetsuJusho;
    @ReportItem(name = "shisetsuMeisho", order = 13)
    public RString shisetsuMeisho;
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
