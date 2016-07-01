package jp.co.ndensan.reams.db.dbe.entity.report.source.gaikyotokkiichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 事務局用概況特記一覧表ののReportSourceクラスです。
 *
 * @reamsid_L DBE-0150-030 lishengli
 */
public class GaikyoTokkiIchiranReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 20, order = 1)
    public RString title;
    @ReportItem(name = "nendo", length = 4, order = 2)
    public RString nendo;
    @ReportItem(name = "shinsakaiNo", length = 3, order = 3)
    public RString shinsakaiNo;
    @ReportItem(name = "printTimeStamp", length = 34, order = 4)
    public RString printTimeStamp;
    @ReportItem(name = "listNo_1", length = 2, order = 5)
    public RString listNo_1;
    @ReportItem(name = "gaikyoTokkiText1", order = 6)
    public RString gaikyoTokkiText1;
    @ReportItem(name = "imgGaikyoTokki1", order = 7)
    public RString imgGaikyoTokki1;
    @ReportItem(name = "gaikyoTokkiText2", order = 8)
    public RString gaikyoTokkiText2;
    @ReportItem(name = "imgGaikyoTokki2", order = 9)
    public RString imgGaikyoTokki2;
    @ReportItem(name = "gaikyoTokkiText3", order = 10)
    public RString gaikyoTokkiText3;
    @ReportItem(name = "imgGaikyoTokki3", order = 11)
    public RString imgGaikyoTokki3;
    @ReportItem(name = "gaikyoTokkiText4", order = 12)
    public RString gaikyoTokkiText4;
    @ReportItem(name = "imgGaikyoTokki4", order = 13)
    public RString imgGaikyoTokki4;
    @ReportItem(name = "gaikyoTokkiText5", order = 14)
    public RString gaikyoTokkiText5;
    @ReportItem(name = "imgGaikyoTokki5", order = 15)
    public RString imgGaikyoTokki5;
    @ReportItem(name = "gaikyoTokkiText6", order = 16)
    public RString gaikyoTokkiText6;
    @ReportItem(name = "imgGaikyoTokki6", order = 17)
    public RString imgGaikyoTokki6;
    @ReportItem(name = "gaikyoTokkiText7", order = 18)
    public RString gaikyoTokkiText7;
    @ReportItem(name = "imgGaikyoTokki7", order = 19)
    public RString imgGaikyoTokki7;
    @ReportItem(name = "gaikyoTokkiText8", order = 20)
    public RString gaikyoTokkiText8;
    @ReportItem(name = "imgGaikyoTokki8", order = 21)
    public RString imgGaikyoTokki8;
    @ReportItem(name = "gaikyoTokkiText9", order = 22)
    public RString gaikyoTokkiText9;
    @ReportItem(name = "imgGaikyoTokki9", order = 23)
    public RString imgGaikyoTokki9;
    @ReportItem(name = "gaikyoTokkiText10", order = 24)
    public RString gaikyoTokkiText10;
    @ReportItem(name = "imgGaikyoTokki10", order = 25)
    public RString imgGaikyoTokki10;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>

    /**
     * 改ページ条件のキーです。
     */
    public enum ReportSourceFields {

        shinsakaiNo,

    }
}
