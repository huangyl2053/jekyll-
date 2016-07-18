package jp.co.ndensan.reams.db.dbe.entity.report.source.saichekkuhyo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 要介護認定調査票差異チェック票のReportSource
 *
 * @reamsid_L DBE-0080-060 xuyannan
 */
public class SaiChekkuhyoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "zenkaiIchijiHantei", length = 9, order = 2)
    public RString zenkaiIchijiHantei;
    @ReportItem(name = "hihokenshaKubun", length = 10, order = 3)
    public RString hihokenshaKubun;
    @ReportItem(name = "hokenshaName", length = 20, order = 4)
    public RString hokenshaName;
    @ReportItem(name = "listIchigun_1", length = 22, order = 5)
    public RString listIchigun_1;
    @ReportItem(name = "listYongun2_1", length = 22, order = 6)
    public RString listYongun2_1;
    @ReportItem(name = "zenkaiNijiHantei", length = 4, order = 7)
    public RString zenkaiNijiHantei;
    @ReportItem(name = "zenkaiNijihanteiYMD", length = 11, order = 8)
    public RString zenkaiNijihanteiYMD;
    @ReportItem(name = "seinengappi", length = 11, order = 9)
    public RString seinengappi;
    @ReportItem(name = "age", length = 3, order = 10)
    public RString age;
    @ReportItem(name = "listGogun_1", length = 22, order = 11)
    public RString listGogun_1;
    @ReportItem(name = "listRokugun_1", length = 22, order = 12)
    public RString listRokugun_1;
    @ReportItem(name = "listNigun_1", length = 22, order = 13)
    public RString listNigun_1;
    @ReportItem(name = "listJiritsudo_1", length = 22, order = 14)
    public RString listJiritsudo_1;
    @ReportItem(name = "listSangun_1", length = 22, order = 15)
    public RString listSangun_1;
    @ReportItem(name = "listYongun1_1", length = 22, order = 16)
    public RString listYongun1_1;
    @ReportItem(name = "listYongun_1", length = 22, order = 17)
    public RString listYongun_1;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
    @ReportItem(name = "layout", order = 999)
    public Layouts layout;

    /**
     * レイアウトブレイク用キーの一覧です。
     */
    public static final List<RString> LAYOUT_BREAK_KEYS;

    static {
        LAYOUT_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(new RString("layout")));
    }
// </editor-fold>
}
