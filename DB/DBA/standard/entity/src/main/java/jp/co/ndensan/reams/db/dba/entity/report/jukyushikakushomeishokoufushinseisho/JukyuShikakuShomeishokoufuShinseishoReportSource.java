package jp.co.ndensan.reams.db.dba.entity.report.jukyushikakushomeishokoufushinseisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 
 * 介護保険受給資格証明書交付申請書の帳票項目クラスです。
 * @reamsid_L DBA-0540-682 dongyabin
 */
public class JukyuShikakuShomeishokoufuShinseishoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "hihokenshaNo", length = 10, order = 1)
    public RString hihokenshaNo;
    @ReportItem(name = "hihokenshaNameKana", order = 2)
    public RString hihokenshaNameKana;
    @ReportItem(name = "hihokenshaName", order = 3)
    public RString hihokenshaName;
    @ReportItem(name = "birthYMD", length = 11, order = 4)
    public RString birthYMD;
    @ReportItem(name = "seibetsuMan", length = 1, order = 5)
    public RString seibetsuMan;
    @ReportItem(name = "hihokenshaYubinNo", length = 8, order = 6)
    public RString hihokenshaYubinNo;
    @ReportItem(name = "hihokenshaTelNo", length = 20, order = 7)
    public RString hihokenshaTelNo;
    @ReportItem(name = "hihokenJusho", order = 8)
    public RString hihokenJusho;
    @ReportItem(name = "tenshutsuMaeYubinNo", length = 8, order = 9)
    public RString tenshutsuMaeYubinNo;
    @ReportItem(name = "tenshutsuMaeTelNo", length = 20, order = 10)
    public RString tenshutsuMaeTelNo;
    @ReportItem(name = "tenshutsuMaeJusho", order = 11)
    public RString tenshutsuMaeJusho;
    @ReportItem(name = "genjushoYubinNo", length = 8, order = 12)
    public RString genjushoYubinNo;
    @ReportItem(name = "genjushoTelNo", length = 20, order = 13)
    public RString genjushoTelNo;
    @ReportItem(name = "genjusho", order = 14)
    public RString genjusho;
    @ReportItem(name = "remban", length = 4, order = 15)
    public RString remban;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 16)
    public RString ninshoshaYakushokuMei;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
