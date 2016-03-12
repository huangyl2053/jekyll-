package jp.co.ndensan.reams.db.dba.entity.report.source.shisetsuhenkotsuchisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 介護保険住所地特例施設変更通知書の帳票データのクラスです。
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
    @ReportItem(name = "barcode", order = 7)
    public RString barcode;
    @ReportItem(name = "midashi", order = 8)
    public RString midashi;
    @ReportItem(name = "hihokenshaNo1", length = 1, order = 9)
    public RString hihokenshaNo1;
    @ReportItem(name = "hihokenshaNo2", length = 1, order = 10)
    public RString hihokenshaNo2;
    @ReportItem(name = "hihokenshaNo3", length = 1, order = 11)
    public RString hihokenshaNo3;
    @ReportItem(name = "hihokenshaNo4", length = 1, order = 12)
    public RString hihokenshaNo4;
    @ReportItem(name = "hihokenshaNo5", length = 1, order = 13)
    public RString hihokenshaNo5;
    @ReportItem(name = "hihokenshaNo6", length = 1, order = 14)
    public RString hihokenshaNo6;
    @ReportItem(name = "hihokenshaNo7", length = 1, order = 15)
    public RString hihokenshaNo7;
    @ReportItem(name = "hihokenshaNo8", length = 1, order = 16)
    public RString hihokenshaNo8;
    @ReportItem(name = "hihokenshaNo9", length = 1, order = 17)
    public RString hihokenshaNo9;
    @ReportItem(name = "hihokenshaNo10", length = 1, order = 18)
    public RString hihokenshaNo10;
    @ReportItem(name = "taishoshaNameKana", order = 19)
    public RString taishoshaNameKana;
    @ReportItem(name = "taishoshaName", order = 20)
    public RString taishoshaName;
    @ReportItem(name = "birthYMD", length = 16, order = 21)
    public RString birthYMD;
    @ReportItem(name = "seibetsu", length = 1, order = 22)
    public RString seibetsu;
    @ReportItem(name = "henkoYMD", length = 16, order = 23)
    public RString henkoYMD;
    @ReportItem(name = "henkomaeShisetsuName", order = 24)
    public RString henkomaeShisetsuName;
    @ReportItem(name = "henkomaeShisetsuTelNo", length = 14, order = 25)
    public RString henkomaeShisetsuTelNo;
    @ReportItem(name = "henkomaeShisetsuFaxNo", length = 14, order = 26)
    public RString henkomaeShisetsuFaxNo;
    @ReportItem(name = "henkomaeShisetsuYubinNo", length = 11, order = 27)
    public RString henkomaeShisetsuYubinNo;
    @ReportItem(name = "henkomaeShisetsuJusho", order = 28)
    public RString henkomaeShisetsuJusho;
    @ReportItem(name = "henkogoShisetsuName", order = 29)
    public RString henkogoShisetsuName;
    @ReportItem(name = "henkogoShisetsuTelNo", length = 14, order = 30)
    public RString henkogoShisetsuTelNo;
    @ReportItem(name = "henkogoShisetsuFaxNo", length = 14, order = 31)
    public RString henkogoShisetsuFaxNo;
    @ReportItem(name = "henkogoShisetsuYubinNo", length = 11, order = 32)
    public RString henkogoShisetsuYubinNo;
    @ReportItem(name = "henkogoShisetsuJusho", order = 33)
    public RString henkogoShisetsuJusho;
    @ReportItem(name = "denshiKoin", order = 34)
    public RString denshiKoin;
    @ReportItem(name = "shomeiHakkoYMD", length = 22, order = 35)
    public RString shomeiHakkoYMD;
    @ReportItem(name = "shuchoMei", length = 14, order = 36)
    public RString shuchoMei;
    @ReportItem(name = "shichosonMei", length = 40, order = 37)
    public RString shichosonMei;
    @ReportItem(name = "koinShoryaku", length = 15, order = 38)
    public RString koinShoryaku;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
