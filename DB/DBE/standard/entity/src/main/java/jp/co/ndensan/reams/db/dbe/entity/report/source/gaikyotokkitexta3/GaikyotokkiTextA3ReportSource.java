package jp.co.ndensan.reams.db.dbe.entity.report.source.gaikyotokkitexta3;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 事務局用概況特記のReportSourceです。
 *
 * @reamsid_L DBE-0150-070 wangrenze
 */
public class GaikyotokkiTextA3ReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "gaikyotokkiImg", order = 1)
    public RString gaikyotokkiImg;
    @ReportItem(name = "gaikyotokkiText", order = 2)
    public RString gaikyotokkiText;
    @ReportItem(name = "gaikyotokkiImg", order = 3)
    public RString two_gaikyotokkiImg;

// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
