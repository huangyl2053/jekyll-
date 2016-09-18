package jp.co.ndensan.reams.db.dba.entity.report.tashichosonjushochitokureisharenrakuhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 介護保険他市町村住所地特例者連絡票の帳票データのクラスです。
 *
 * @reamsid_L DBA-0380-080 duanzhanli
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
    @ReportItem(name = "midashi1", length = 35, order = 8)
    public RString midashi1;
    @ReportItem(name = "midashi2", length = 35, order = 9)
    public RString midashi2;
    @ReportItem(name = "midashi3", length = 35, order = 10)
    public RString midashi3;
    @ReportItem(name = "tennyuYMD", length = 16, order = 11)
    public RString tennyuYMD;
    @ReportItem(name = "nyushoYMD", length = 16, order = 12)
    public RString nyushoYMD;
    @ReportItem(name = "hihokenshaNo1", length = 1, order = 13)
    public RString hihokenshaNo1;
    @ReportItem(name = "hihokenshaNo2", length = 1, order = 14)
    public RString hihokenshaNo2;
    @ReportItem(name = "hihokenshaNo3", length = 1, order = 15)
    public RString hihokenshaNo3;
    @ReportItem(name = "hihokenshaNo4", length = 1, order = 16)
    public RString hihokenshaNo4;
    @ReportItem(name = "hihokenshaNo5", length = 1, order = 17)
    public RString hihokenshaNo5;
    @ReportItem(name = "hihokenshaNo6", length = 1, order = 18)
    public RString hihokenshaNo6;
    @ReportItem(name = "hihokenshaNo7", length = 1, order = 19)
    public RString hihokenshaNo7;
    @ReportItem(name = "hihokenshaNo8", length = 1, order = 20)
    public RString hihokenshaNo8;
    @ReportItem(name = "hihokenshaNo9", length = 1, order = 21)
    public RString hihokenshaNo9;
    @ReportItem(name = "hihokenshaNo10", length = 1, order = 22)
    public RString hihokenshaNo10;
    @ReportItem(name = "taishoshaNameKana", order = 23)
    public RString taishoshaNameKana;
    @ReportItem(name = "taishoshaName", order = 24)
    public RString taishoshaName;
    @ReportItem(name = "birthYMD", length = 16, order = 25)
    public RString birthYMD;
    @ReportItem(name = "seibetsu", length = 1, order = 26)
    public RString seibetsu;
    @ReportItem(name = "tennyumaeYubinNo", length = 11, order = 27)
    public RString tennyumaeYubinNo;
    @ReportItem(name = "tennyumaeJusho", order = 28)
    public RString tennyumaeJusho;
    @ReportItem(name = "shisetsuName", order = 29)
    public RString shisetsuName;
    @ReportItem(name = "shisetsuTelNo", length = 14, order = 30)
    public RString shisetsuTelNo;
    @ReportItem(name = "shisetsuFaxNo", length = 14, order = 31)
    public RString shisetsuFaxNo;
    @ReportItem(name = "shisetsuYubinNo", length = 11, order = 32)
    public RString shisetsuYubinNo;
    @ReportItem(name = "shisetsuJusho", order = 33)
    public RString shisetsuJusho;
    @ReportItem(name = "denshiKoin", order = 34)
    public RString denshiKoin;
    @ReportItem(name = "shomeiHakkoYMD", length = 12, order = 35)
    public RString shomeiHakkoYMD;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 36)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "ninshoshaYakushokuMei1", order = 37)
    public RString ninshoshaYakushokuMei1;
    @ReportItem(name = "koinMojiretsu", length = 4, order = 38)
    public RString koinMojiretsu;
    @ReportItem(name = "ninshoshaYakushokuMei2", order = 39)
    public RString ninshoshaYakushokuMei2;
    @ReportItem(name = "ninshoshaShimeiKakenai", order = 40)
    public RString ninshoshaShimeiKakenai;
    @ReportItem(name = "ninshoshaShimeiKakeru", order = 41)
    public RString ninshoshaShimeiKakeru;
    @ReportItem(name = "koinShoryaku", length = 15, order = 42)
    public RString koinShoryaku;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
