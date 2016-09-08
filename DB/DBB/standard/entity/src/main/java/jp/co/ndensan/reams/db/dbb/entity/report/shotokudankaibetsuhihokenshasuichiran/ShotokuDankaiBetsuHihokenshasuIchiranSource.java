package jp.co.ndensan.reams.db.dbb.entity.report.shotokudankaibetsuhihokenshasuichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 段階別被保険者数一覧表帳票クラスです。
 *
 * @reamsid_L DBB-1820-060 zhouchuanlin
 */
public class ShotokuDankaiBetsuHihokenshasuIchiranSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "nendo", length = 9, order = 2)
    public RString nendo;
    @ReportItem(name = "hokenshaNo", length = 6, order = 3)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 12, order = 4)
    public RString hokenshaName;
    @ReportItem(name = "shikakuKijunYmd", length = 11, order = 5)
    public RString shikakuKijunYmd;
    @ReportItem(name = "choteiKijunYmd", length = 11, order = 6)
    public RString choteiKijunYmd;
    @ReportItem(name = "list_1", length = 10, order = 7)
    public RString list_1;
    @ReportItem(name = "list_2", length = 9, order = 8)
    public RString list_2;
    @ReportItem(name = "list_3", length = 10, order = 9)
    public RString list_3;
    @ReportItem(name = "list_4", length = 9, order = 10)
    public RString list_4;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>

    /**
     * ShotokuDankaiBetsuHihokenshasuIchiranSourceのENUM
     */
    public enum DBB300004_ShotokuDankaiBetsuHihokenshasuIchiran {

        printTimeStamp,
        nendo,
        hokenshaNo,
        hokenshaName,
        shikakuKijunYmd,
        choteiKijunYmd,
        list_1,
        list_2,
        list_3,
        list_4
    }

}
