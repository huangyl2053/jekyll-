package jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshoa3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.report.saichekkuhyo.Layouts;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 主治医意見書A4のReportSourceクラスです。
 *
 * @reamsid_L DBE-0150-380 lishengli
 */
public class Shujiiikensho1A4ReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "hihokenshaName", length = 30, order = 1)
    public RString hihokenshaName;
    @ReportItem(name = "hokenshaNo", length = 6, order = 2)
    public RString hokenshaNo;
    @ReportItem(name = "shinseiGengo", length = 2, order = 3)
    public RString shinseiGengo;
    @ReportItem(name = "shinseiYY", length = 2, order = 4)
    public RString shinseiYY;
    @ReportItem(name = "shinseiMM", length = 2, order = 5)
    public RString shinseiMM;
    @ReportItem(name = "shinseiDD", length = 2, order = 6)
    public RString shinseiDD;
    @ReportItem(name = "sakuseiGengo", length = 2, order = 7)
    public RString sakuseiGengo;
    @ReportItem(name = "sakuseiYY", length = 2, order = 8)
    public RString sakuseiYY;
    @ReportItem(name = "sakuseiMM", length = 2, order = 9)
    public RString sakuseiMM;
    @ReportItem(name = "sakuseiDD", length = 2, order = 10)
    public RString sakuseiDD;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 11)
    public RString hihokenshaNo;
    @ReportItem(name = "chosaGengo", length = 2, order = 12)
    public RString chosaGengo;
    @ReportItem(name = "chosaYY", length = 2, order = 13)
    public RString chosaYY;
    @ReportItem(name = "chosaMM", length = 2, order = 14)
    public RString chosaMM;
    @ReportItem(name = "chosaDD", length = 2, order = 15)
    public RString chosaDD;
    @ReportItem(name = "shinsaGengo", length = 2, order = 16)
    public RString shinsaGengo;
    @ReportItem(name = "shinsaYY", length = 2, order = 17)
    public RString shinsaYY;
    @ReportItem(name = "shinsaMM", length = 2, order = 18)
    public RString shinsaMM;
    @ReportItem(name = "shinsaDD", length = 2, order = 19)
    public RString shinsaDD;
    @ReportItem(name = "imgIkensho1", order = 20)
    public RString imgIkensho1;
    @ReportItem(name = "two_hihokenshaName", length = 30, order = 21)
    public RString two_hihokenshaName;
    @ReportItem(name = "two_hokenshaNo", length = 6, order = 22)
    public RString two_hokenshaNo;
    @ReportItem(name = "two_shinseiGengo", length = 2, order = 23)
    public RString two_shinseiGengo;
    @ReportItem(name = "two_shinseiYY", length = 2, order = 24)
    public RString two_shinseiYY;
    @ReportItem(name = "two_shinseiMM", length = 2, order = 25)
    public RString two_shinseiMM;
    @ReportItem(name = "two_shinseiDD", length = 2, order = 26)
    public RString two_shinseiDD;
    @ReportItem(name = "two_sakuseiGengo", length = 2, order = 27)
    public RString two_sakuseiGengo;
    @ReportItem(name = "two_sakuseiYY", length = 2, order = 28)
    public RString two_sakuseiYY;
    @ReportItem(name = "two_sakuseiMM", length = 2, order = 29)
    public RString two_sakuseiMM;
    @ReportItem(name = "two_sakuseiDD", length = 2, order = 30)
    public RString two_sakuseiDD;
    @ReportItem(name = "two_hihokenshaNo", length = 10, order = 31)
    public RString two_hihokenshaNo;
    @ReportItem(name = "two_chosaGengo", length = 2, order = 32)
    public RString two_chosaGengo;
    @ReportItem(name = "two_chosaYY", length = 2, order = 33)
    public RString two_chosaYY;
    @ReportItem(name = "two_chosaMM", length = 2, order = 34)
    public RString two_chosaMM;
    @ReportItem(name = "two_chosaDD", length = 2, order = 35)
    public RString two_chosaDD;
    @ReportItem(name = "two_shinsaGengo", length = 2, order = 36)
    public RString two_shinsaGengo;
    @ReportItem(name = "two_shinsaYY", length = 2, order = 37)
    public RString two_shinsaYY;
    @ReportItem(name = "two_shinsaMM", length = 2, order = 38)
    public RString two_shinsaMM;
    @ReportItem(name = "two_shinsaDD", length = 2, order = 39)
    public RString two_shinsaDD;
    @ReportItem(name = "two_imgIkensho2", order = 40)
    public RString two_imgIkensho2;
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

    @ReportPerson(id = "X")
    public ShikibetsuCode shikibetuCode;
    @ReportExpandedInfo(id = "X")
    public ExpandedInformation shinseishoKanriNo;

    /**
     * 改ページ条件のキーです。
     */
    public enum ReportSourceFields {

        hokenshaNo,

    }
}
