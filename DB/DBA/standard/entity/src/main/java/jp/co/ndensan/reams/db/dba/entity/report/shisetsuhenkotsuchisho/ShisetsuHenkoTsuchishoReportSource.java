package jp.co.ndensan.reams.db.dba.entity.report.shisetsuhenkotsuchisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 介護保険住所地特例施設変更通知書の帳票データのクラスです。
 *
 * @reamsid_L DBA-0380-070 duanzhanli
 */
public class ShisetsuHenkoTsuchishoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "hokenshaYubinNo", length = 8, order = 1)
    public RString hokenshaYubinNo;
    @ReportItem(name = "bunshoNo", length = 36, order = 2)
    public RString bunshoNo;
    @ReportItem(name = "hokenshaJusho", order = 3)
    public RString hokenshaJusho;
    @ReportItem(name = "hakkoYMD", length = 16, order = 4)
    public RString hakkoYMD;
    @ReportItem(name = "hokenshaName", order = 5)
    public RString hokenshaName;
    @ReportItem(name = "tantoBushoName", length = 15, order = 6)
    public RString tantoBushoName;
    @ReportItem(name = "barcode", order = 8)
    public RString barcode;
    @ReportItem(name = "midashi1", length = 35, order = 9)
    public RString midashi1;
    @ReportItem(name = "midashi2", length = 35, order = 10)
    public RString midashi2;
    @ReportItem(name = "midashi3", length = 35, order = 11)
    public RString midashi3;
    @ReportItem(name = "hihokenshaNo1", length = 1, order = 12)
    public RString hihokenshaNo1;
    @ReportItem(name = "hihokenshaNo2", length = 1, order = 13)
    public RString hihokenshaNo2;
    @ReportItem(name = "hihokenshaNo3", length = 1, order = 14)
    public RString hihokenshaNo3;
    @ReportItem(name = "hihokenshaNo4", length = 1, order = 15)
    public RString hihokenshaNo4;
    @ReportItem(name = "hihokenshaNo5", length = 1, order = 16)
    public RString hihokenshaNo5;
    @ReportItem(name = "hihokenshaNo6", length = 1, order = 17)
    public RString hihokenshaNo6;
    @ReportItem(name = "hihokenshaNo7", length = 1, order = 18)
    public RString hihokenshaNo7;
    @ReportItem(name = "hihokenshaNo8", length = 1, order = 19)
    public RString hihokenshaNo8;
    @ReportItem(name = "hihokenshaNo9", length = 1, order = 20)
    public RString hihokenshaNo9;
    @ReportItem(name = "hihokenshaNo10", length = 1, order = 21)
    public RString hihokenshaNo10;
    @ReportItem(name = "taishoshaNameKana", order = 22)
    public RString taishoshaNameKana;
    @ReportItem(name = "taishoshaName", order = 23)
    public RString taishoshaName;
    @ReportItem(name = "birthYMD", length = 16, order = 24)
    public RString birthYMD;
    @ReportItem(name = "seibetsu", length = 1, order = 25)
    public RString seibetsu;
    @ReportItem(name = "henkoYMD", length = 16, order = 26)
    public RString henkoYMD;
    @ReportItem(name = "henkomaeShisetsuName", order = 27)
    public RString henkomaeShisetsuName;
    @ReportItem(name = "henkomaeShisetsuTelNo", length = 14, order = 28)
    public RString henkomaeShisetsuTelNo;
    @ReportItem(name = "henkomaeShisetsuFaxNo", length = 14, order = 29)
    public RString henkomaeShisetsuFaxNo;
    @ReportItem(name = "henkomaeShisetsuYubinNo", length = 11, order = 30)
    public RString henkomaeShisetsuYubinNo;
    @ReportItem(name = "henkomaeShisetsuJusho", order = 31)
    public RString henkomaeShisetsuJusho;
    @ReportItem(name = "henkogoShisetsuName", order = 32)
    public RString henkogoShisetsuName;
    @ReportItem(name = "henkogoShisetsuTelNo", length = 14, order = 33)
    public RString henkogoShisetsuTelNo;
    @ReportItem(name = "henkogoShisetsuFaxNo", length = 14, order = 34)
    public RString henkogoShisetsuFaxNo;
    @ReportItem(name = "henkogoShisetsuYubinNo", length = 11, order = 35)
    public RString henkogoShisetsuYubinNo;
    @ReportItem(name = "henkogoShisetsuJusho", order = 36)
    public RString henkogoShisetsuJusho;
    @ReportItem(name = "denshiKoin", order = 37)
    public RString denshiKoin;
    @ReportItem(name = "shomeiHakkoYMD", length = 12, order = 38)
    public RString shomeiHakkoYMD;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 39)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "ninshoshaYakushokuMei1", order = 40)
    public RString ninshoshaYakushokuMei1;
    @ReportItem(name = "koinMojiretsu", length = 4, order = 41)
    public RString koinMojiretsu;
    @ReportItem(name = "ninshoshaYakushokuMei2", order = 42)
    public RString ninshoshaYakushokuMei2;
    @ReportItem(name = "ninshoshaShimeiKakenai", order = 43)
    public RString ninshoshaShimeiKakenai;
    @ReportItem(name = "ninshoshaShimeiKakeru", order = 44)
    public RString ninshoshaShimeiKakeru;
    @ReportItem(name = "koinShoryaku", length = 15, order = 45)
    public RString koinShoryaku;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
