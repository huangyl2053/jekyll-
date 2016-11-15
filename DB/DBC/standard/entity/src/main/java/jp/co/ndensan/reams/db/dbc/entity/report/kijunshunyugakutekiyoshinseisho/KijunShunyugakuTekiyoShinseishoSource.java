package jp.co.ndensan.reams.db.dbc.entity.report.kijunshunyugakutekiyoshinseisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
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

    public static final String ITEM_HIHOKENSHANO1 = "hihokenshaNo1";
    @ReportItem(name = "shinsenSakiDaihyo", length = 37, order = 1)
    public RString shinsenSakiDaihyo;
    @ReportItem(name = "hihokenshaKanaName1", order = 2)
    public RString hihokenshaKanaName1;
    @ReportItem(name = "hihokenshaNo1", length = 10, order = 3)
    public RString hihokenshaNo1;
    @ReportItem(name = "hihokenshaName1", order = 4)
    public RString hihokenshaName1;
    @ReportItem(name = "seibetsu1", length = 2, order = 5)
    public RString seibetsu1;
    @ReportItem(name = "hihokenshaBirthYMD1", length = 11, order = 6)
    public RString hihokenshaBirthYMD1;
    @ReportItem(name = "hihokenshaKanaName2", order = 7)
    public RString hihokenshaKanaName2;
    @ReportItem(name = "hihokenshaNo2", length = 10, order = 8)
    public RString hihokenshaNo2;
    @ReportItem(name = "hihokenshaName2", order = 9)
    public RString hihokenshaName2;
    @ReportItem(name = "seibetsu2", length = 2, order = 10)
    public RString seibetsu2;
    @ReportItem(name = "hihokenshaBirthYMD2", length = 11, order = 11)
    public RString hihokenshaBirthYMD2;
    @ReportItem(name = "hihokenshaKanaName3", order = 12)
    public RString hihokenshaKanaName3;
    @ReportItem(name = "hihokenshaNo3", length = 10, order = 13)
    public RString hihokenshaNo3;
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
    @ReportItem(name = "tsuchibun1", order = 23)
    public RString tsuchibun1;
    @ReportPerson(id = "A")
    @ReportItem(name = "shikibetsuCode1", length = 15)
    public RString shikibetsuCode1;
    @ReportPerson(id = "B")
    @ReportItem(name = "shikibetsuCode2", length = 15)
    public RString shikibetsuCode2;
    @ReportPerson(id = "C")
    @ReportItem(name = "shikibetsuCode3", length = 15)
    public RString shikibetsuCode3;
    @ReportItem(name = "jusho", length = 36, order = 24)
    public RString jusho;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
    @ReportExpandedInfo(id = "A")
    public ExpandedInformation 拡張情報A1;
    @ReportExpandedInfo(id = "A")
    public ExpandedInformation 拡張情報A2;
    @ReportExpandedInfo(id = "B")
    public ExpandedInformation 拡張情報B1;
    @ReportExpandedInfo(id = "B")
    public ExpandedInformation 拡張情報B2;
    @ReportExpandedInfo(id = "C")
    public ExpandedInformation 拡張情報C1;
    @ReportExpandedInfo(id = "C")
    public ExpandedInformation 拡張情報C2;
}
