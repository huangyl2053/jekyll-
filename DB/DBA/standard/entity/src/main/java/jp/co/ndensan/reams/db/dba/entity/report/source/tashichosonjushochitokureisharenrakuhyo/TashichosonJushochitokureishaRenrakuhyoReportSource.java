package jp.co.ndensan.reams.db.dba.entity.report.source.tashichosonjushochitokureisharenrakuhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 介護保険他市町村住所地特例者連絡票の帳票データのクラスです。
 */
public class TashichosonJushochitokureishaRenrakuhyoReportSource implements IReportSource {
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
    @ReportItem(name = "tennyuYMD", length = 16, order = 9)
    public RString tennyuYMD;
    @ReportItem(name = "nyushoYMD", length = 16, order = 10)
    public RString nyushoYMD;
    @ReportItem(name = "hihokenshaNo1", length = 1, order = 11)
    public RString hihokenshaNo1;
    @ReportItem(name = "hihokenshaNo2", length = 1, order = 12)
    public RString hihokenshaNo2;
    @ReportItem(name = "hihokenshaNo3", length = 1, order = 13)
    public RString hihokenshaNo3;
    @ReportItem(name = "hihokenshaNo4", length = 1, order = 14)
    public RString hihokenshaNo4;
    @ReportItem(name = "hihokenshaNo5", length = 1, order = 15)
    public RString hihokenshaNo5;
    @ReportItem(name = "hihokenshaNo6", length = 1, order = 16)
    public RString hihokenshaNo6;
    @ReportItem(name = "hihokenshaNo7", length = 1, order = 17)
    public RString hihokenshaNo7;
    @ReportItem(name = "hihokenshaNo8", length = 1, order = 18)
    public RString hihokenshaNo8;
    @ReportItem(name = "hihokenshaNo9", length = 1, order = 19)
    public RString hihokenshaNo9;
    @ReportItem(name = "hihokenshaNo10", length = 1, order = 20)
    public RString hihokenshaNo10;
    @ReportItem(name = "taishoshaNameKana", order = 21)
    public RString taishoshaNameKana;
    @ReportItem(name = "taishoshaName", order = 22)
    public RString taishoshaName;
    @ReportItem(name = "birthYMD", length = 16, order = 23)
    public RString birthYMD;
    @ReportItem(name = "seibetsu", length = 1, order = 24)
    public RString seibetsu;
    @ReportItem(name = "tennyumaeYubinNo", length = 11, order = 25)
    public RString tennyumaeYubinNo;
    @ReportItem(name = "tennyumaeJusho", order = 26)
    public RString tennyumaeJusho;
    @ReportItem(name = "shisetsuName", order = 27)
    public RString shisetsuName;
    @ReportItem(name = "shisetsuTelNo", length = 14, order = 28)
    public RString shisetsuTelNo;
    @ReportItem(name = "shisetsuFaxNo", length = 14, order = 29)
    public RString shisetsuFaxNo;
    @ReportItem(name = "shisetsuYubinNo", length = 11, order = 30)
    public RString shisetsuYubinNo;
    @ReportItem(name = "shisetsuJusho", order = 31)
    public RString shisetsuJusho;
    @ReportItem(name = "denshiKoin", order = 32)
    public RString denshiKoin;
    @ReportItem(name = "shomeiHakkoYMD", length = 22, order = 33)
    public RString shomeiHakkoYMD;
    @ReportItem(name = "shuchoMei", length = 14, order = 34)
    public RString shuchoMei;
    @ReportItem(name = "shichosonMei", length = 40, order = 35)
    public RString shichosonMei;
    @ReportItem(name = "koinShoryaku", length = 15, order = 36)
    public RString koinShoryaku;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
