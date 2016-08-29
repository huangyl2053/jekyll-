package jp.co.ndensan.reams.db.dbc.entity.report.kijunshunyugakutekiyoshinseisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 帳票設計_DBC100064_基準収入額適用申請書 Sourceクラスです。
 *
 * @reamsid_L DBC-4640-040 lijian
 */
public class KijunShunyugakuTekiyoShinseishoSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "shinsenSakiDaihyo", length = 37, order = 1)
    public RString shinsenSakiDaihyo;
    @ReportItem(name = "hihokenshaKanaName1", order = 2)
    public RString hihokenshaKanaName1;
    @ReportExpandedInfo(id = "A")
    @ReportItem(name = "hihokenshaNo1", length = 10, order = 3)
    public RString hihokenshaNo1;
    @ReportExpandedInfo(id = "A")
    @ReportItem(name = "hihokenshaName1", order = 4)
    public RString hihokenshaName1;
    @ReportItem(name = "seibetsu1", length = 2, order = 5)
    public RString seibetsu1;
    @ReportItem(name = "hihokenshaBirthYMD1", length = 11, order = 6)
    public RString hihokenshaBirthYMD1;
    @ReportItem(name = "hihokenshaKanaName2", order = 7)
    public RString hihokenshaKanaName2;
    @ReportExpandedInfo(id = "B")
    @ReportItem(name = "hihokenshaNo2", length = 10, order = 8)
    public RString hihokenshaNo2;
    @ReportExpandedInfo(id = "B")
    @ReportItem(name = "hihokenshaName2", order = 9)
    public RString hihokenshaName2;
    @ReportItem(name = "seibetsu2", length = 2, order = 10)
    public RString seibetsu2;
    @ReportItem(name = "hihokenshaBirthYMD2", length = 11, order = 11)
    public RString hihokenshaBirthYMD2;
    @ReportItem(name = "hihokenshaKanaName3", order = 12)
    public RString hihokenshaKanaName3;
    @ReportExpandedInfo(id = "C")
    @ReportItem(name = "hihokenshaNo3", length = 10, order = 13)
    public RString hihokenshaNo3;
    @ReportExpandedInfo(id = "C")
    @ReportItem(name = "hihokenshaName3", order = 14)
    public RString hihokenshaName3;
    @ReportItem(name = "seibetsu3", length = 2, order = 15)
    public RString seibetsu3;
    @ReportItem(name = "hihokenshaBirthYMD3", length = 11, order = 16)
    public RString hihokenshaBirthYMD3;
    @ReportItem(name = "pagecnt", length = 9, order = 17)
    public RString pagecnt;
    @ReportItem(name = "jusho1", length = 36, order = 18)
    public RString jusho1;
    @ReportItem(name = "jusho2", length = 20, order = 19)
    public RString jusho2;
    @ReportItem(name = "renrakusaki", length = 15, order = 20)
    public RString renrakusaki;
    @ReportItem(name = "shunyuGengo", length = 2, order = 21)
    public RString shunyuGengo;
    @ReportItem(name = "shunyuNen", length = 2, order = 22)
    public RString shunyuNen;
    @ReportItem(name = "tsuchibun1", length = 42, order = 23)
    public RString tsuchibun1;
    @ReportItem(name = "tsuchibun2", length = 42, order = 24)
    public RString tsuchibun2;
    @ReportItem(name = "tsuchibun3", length = 42, order = 25)
    public RString tsuchibun3;
    @ReportItem(name = "tsuchibun4", length = 42, order = 26)
    public RString tsuchibun4;
    @ReportItem(name = "tsuchibun5", length = 42, order = 27)
    public RString tsuchibun5;
    @ReportItem(name = "tsuchibun6", length = 42, order = 28)
    public RString tsuchibun6;
    @ReportItem(name = "tsuchibun7", length = 42, order = 29)
    public RString tsuchibun7;
    @ReportItem(name = "tsuchibun8", length = 42, order = 30)
    public RString tsuchibun8;
    @ReportItem(name = "tsuchibun9", length = 42, order = 31)
    public RString tsuchibun9;
    @ReportItem(name = "tsuchibun10", length = 42, order = 32)
    public RString tsuchibun10;
    @ReportItem(name = "tsuchibun11", length = 42, order = 33)
    public RString tsuchibun11;
    @ReportItem(name = "tsuchibun12", length = 42, order = 34)
    public RString tsuchibun12;
    @ReportItem(name = "tsuchibun13", length = 42, order = 35)
    public RString tsuchibun13;
    @ReportPerson(id = "A")
    @ReportItem(name = "shikibetsuCode1", length = 15)
    public RString shikibetsuCode1;
    @ReportPerson(id = "B")
    @ReportItem(name = "shikibetsuCode2", length = 15)
    public RString shikibetsuCode2;
    @ReportPerson(id = "C")
    @ReportItem(name = "shikibetsuCode3", length = 15)
    public RString shikibetsuCode3;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
