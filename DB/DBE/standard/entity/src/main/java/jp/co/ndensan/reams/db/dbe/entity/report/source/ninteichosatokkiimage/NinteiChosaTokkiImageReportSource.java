package jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosatokkiimage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 特記事項Sourceクラスです。
 *
 * @reamsid_L DBE-0230-080 lizhuoxuan
 */
public class NinteiChosaTokkiImageReportSource implements IReportSource {
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
    @ReportItem(name = "tokkiPageNo", length = 1, order = 20)
    public RString tokkiPageNo;
    @ReportItem(name = "tokkiPageMax", length = 1, order = 21)
    public RString tokkiPageMax;
    @ReportItem(name = "listChosa_1", length = 4, order = 22)
    public RString listChosa_1;
    @ReportItem(name = "listChosa_2", length = 15, order = 23)
    public RString listChosa_2;
    @ReportItem(name = "listChosa_3", length = 4, order = 24)
    public RString listChosa_3;
    @ReportItem(name = "listChosa_4", length = 15, order = 25)
    public RString listChosa_4;
    @ReportItem(name = "listChosa_5", length = 4, order = 26)
    public RString listChosa_5;
    @ReportItem(name = "listChosa_6", length = 15, order = 27)
    public RString listChosa_6;
    @ReportItem(name = "tokki1", order = 28)
    public RString tokki1;
    @ReportItem(name = "tokki9", order = 29)
    public RString tokki9;
    @ReportItem(name = "tokki17", order = 30)
    public RString tokki17;
    @ReportItem(name = "tokki2", order = 31)
    public RString tokki2;
    @ReportItem(name = "tokki10", order = 32)
    public RString tokki10;
    @ReportItem(name = "tokki18", order = 33)
    public RString tokki18;
    @ReportItem(name = "tokki3", order = 34)
    public RString tokki3;
    @ReportItem(name = "tokki11", order = 35)
    public RString tokki11;
    @ReportItem(name = "tokki19", order = 36)
    public RString tokki19;
    @ReportItem(name = "tokki4", order = 37)
    public RString tokki4;
    @ReportItem(name = "tokki12", order = 38)
    public RString tokki12;
    @ReportItem(name = "tokki20", order = 39)
    public RString tokki20;
    @ReportItem(name = "tokki5", order = 40)
    public RString tokki5;
    @ReportItem(name = "tokki13", order = 41)
    public RString tokki13;
    @ReportItem(name = "tokki21", order = 42)
    public RString tokki21;
    @ReportItem(name = "tokki6", order = 43)
    public RString tokki6;
    @ReportItem(name = "tokki14", order = 44)
    public RString tokki14;
    @ReportItem(name = "tokki22", order = 45)
    public RString tokki22;
    @ReportItem(name = "tokki7", order = 46)
    public RString tokki7;
    @ReportItem(name = "tokki15", order = 47)
    public RString tokki15;
    @ReportItem(name = "tokki23", order = 48)
    public RString tokki23;
    @ReportItem(name = "tokki8", order = 49)
    public RString tokki8;
    @ReportItem(name = "tokki16", order = 50)
    public RString tokki16;
    @ReportItem(name = "tokki24", order = 51)
    public RString tokki24;
    @ReportItem(name = "gaikyotokkiImg", order = 52)
    public RString gaikyotokkiImg;
    @ReportItem(name = "gaikyotokkiText", order = 53)
    public RString gaikyotokkiText;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
    @ReportPerson(id = "X")
    public ShikibetsuCode shikibetuCode;
    @ReportExpandedInfo(id = "X")
    public ExpandedInformation hihokennshaNo;

    //レイアウトブレイク用フィールド
    @ReportItem(name = "layout", order = 999)
    public RString layout;

    //レイアウトブレイク用キーの一覧です。
    public static final List<RString> LAYOUT_BREAK_KEYS;

    static {
        LAYOUT_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(new RString("layout")));
    }
}
