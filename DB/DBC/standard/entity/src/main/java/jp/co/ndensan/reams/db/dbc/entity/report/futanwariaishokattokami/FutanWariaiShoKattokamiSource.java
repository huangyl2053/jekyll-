package jp.co.ndensan.reams.db.dbc.entity.report.futanwariaishokattokami;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 帳票設計_DBC100065_負担割合証（カット紙）のReportSourceクラスです。
 *
 * @reamsid_L DBC-4990-061 pengxingyi
 */
public class FutanWariaiShoKattokamiSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "kofuYmd", length = 20, order = 1)
    public RString kofuYmd;
    @ReportItem(name = "hihokenshaNo", length = 25, order = 2)
    public RString hihokenshaNo;
    @ReportItem(name = "jusho", order = 3)
    public RString jusho;
    @ReportItem(name = "kanaMei", order = 4)
    public RString kanaMei;
    @ReportItem(name = "shimei", order = 5)
    public RString shimei;
    @ReportItem(name = "umareYmd", length = 12, order = 6)
    public RString umareYmd;
    @ReportItem(name = "seibetsu", length = 1, order = 7)
    public RString seibetsu;
    @ReportItem(name = "tekiyoKaishiYmd1", length = 17, order = 8)
    public RString tekiyoKaishiYmd1;
    @ReportItem(name = "futanWariai1", length = 3, order = 9)
    public RString futanWariai1;
    @ReportItem(name = "tekiyoShuryoYmd1", length = 17, order = 10)
    public RString tekiyoShuryoYmd1;
    @ReportItem(name = "tekiyoKaishiYmd2", length = 17, order = 11)
    public RString tekiyoKaishiYmd2;
    @ReportItem(name = "futanWariai2", length = 3, order = 12)
    public RString futanWariai2;
    @ReportItem(name = "tekiyoShuryoYmd2", length = 17, order = 13)
    public RString tekiyoShuryoYmd2;
    @ReportItem(name = "hokenshaCode1", length = 1, order = 14)
    public RString hokenshaCode1;
    @ReportItem(name = "hokenshaCode2", length = 1, order = 15)
    public RString hokenshaCode2;
    @ReportItem(name = "hokenshaCode3", length = 1, order = 16)
    public RString hokenshaCode3;
    @ReportItem(name = "hokenshaCode4", length = 1, order = 17)
    public RString hokenshaCode4;
    @ReportItem(name = "hokenshaCode5", length = 1, order = 18)
    public RString hokenshaCode5;
    @ReportItem(name = "hokenshaCode6", length = 1, order = 19)
    public RString hokenshaCode6;
    @ReportItem(name = "hokenshaJusho", order = 20)
    public RString hokenshaJusho;
    @ReportItem(name = "tel", length = 20, order = 21)
    public RString tel;
    @ReportItem(name = "renban", length = 6, order = 22)
    public RString renban;
    @ReportItem(name = "ocrRenban", length = 8, order = 23)
    public RString ocrRenban;
    @ReportItem(name = "ninshosha_denshiKoin", order = 24)
    public RString ninshosha_denshiKoin;
    @ReportItem(name = "ninshosha_ninshoshaShimeiKakenai", order = 25)
    public RString ninshosha_ninshoshaShimeiKakenai;
    @ReportItem(name = "koinShoryaku", length = 15, order = 26)
    public RString koinShoryaku;
    @ReportItem(name = "koinMojiretsu", length = 4, order = 27)
    public RString koinMojiretsu;
    @ReportItem(name = "hakkoYMD", length = 12, order = 28)
    public RString hakkoYMD;
    @ReportItem(name = "ninshoshaShimeiKakeru", order = 29)
    public RString ninshoshaShimeiKakeru;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 30)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "ninshoshaYakushokuMei2", order = 31)
    public RString ninshoshaYakushokuMei2;
    @ReportItem(name = "ninshoshaYakushokuMei1", order = 32)
    public RString ninshoshaYakushokuMei1;

//    @ReportItemGroup(groupName = "CompSofubutsuAtesaki", order = 35)
//    public SofubutsuAtesakiSource compSofubutsuAtesakiSource;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
