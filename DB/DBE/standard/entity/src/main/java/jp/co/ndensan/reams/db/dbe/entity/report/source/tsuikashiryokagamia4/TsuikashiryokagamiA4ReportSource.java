package jp.co.ndensan.reams.db.dbe.entity.report.source.tsuikashiryokagamia4;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 追加資料鑑のReportSource
 *
 * @reamsid_L DBE-0150-180 wangrenze
 */
public class TsuikashiryokagamiA4ReportSource implements IReportSource {

// <editor-fold defaultstate="collapsed" desc="Generated Code">
    @ReportItem(name = "shinsakaiNo", length = 4, order = 1)
    public RString shinsakaiNo;
    @ReportItem(name = "tsuchibun1", length = 35, order = 2)
    public RString tsuchibun1;
    @ReportItem(name = "tsuchibun2", length = 35, order = 3)
    public RString tsuchibun2;
    @ReportItem(name = "tsuchibun3", length = 35, order = 4)
    public RString tsuchibun3;
    @ReportItem(name = "tsuchibun4", length = 35, order = 5)
    public RString tsuchibun4;
    @ReportItem(name = "tsuchibun5", length = 35, order = 6)
    public RString tsuchibun5;
    @ReportItem(name = "shinsakaiKaisaiYMD", length = 21, order = 12)
    public RString shinsakaiKaisaiYMD;
    @ReportItem(name = "gogitaiNo", length = 2, order = 13)
    public RString gogitaiNo;
    @ReportItem(name = "shinsakaiTsuikasha", length = 2, order = 14)
    public RString shinsakaiTsuikasha;
    @ReportItem(name = "shinsainName1", length = 20, order = 15)
    public RString shinsainName1;
    @ReportItem(name = "shinsainName2", length = 20, order = 16)
    public RString shinsainName2;
    @ReportItem(name = "shinsainName3", length = 20, order = 17)
    public RString shinsainName3;
    @ReportItem(name = "shinsainName4", length = 20, order = 18)
    public RString shinsainName4;
    @ReportItem(name = "shinsainName5", length = 20, order = 19)
    public RString shinsainName5;
    @ReportItem(name = "shinsainName6", length = 20, order = 20)
    public RString shinsainName6;
    @ReportItem(name = "shinsainName7", length = 20, order = 21)
    public RString shinsainName7;
    @ReportItem(name = "shinsainName8", length = 20, order = 22)
    public RString shinsainName8;
    @ReportItem(name = "listNo_1", length = 2, order = 23)
    public RString listNo_1;
    @ReportItem(name = "listNo_2", length = 7, order = 24)
    public RString listNo_2;
    @ReportItem(name = "listhihokenshaName_1", length = 20, order = 25)
    public RString listhihokenshaName_1;
    @ReportItem(name = "listhihokenshaNo_1", length = 10, order = 26)
    public RString listhihokenshaNo_1;
    @ReportItem(name = "listSeibetsu_1", length = 1, order = 27)
    public RString listSeibetsu_1;
    @ReportItem(name = "listSeibetsu_2", length = 3, order = 28)
    public RString listSeibetsu_2;
    @ReportItem(name = "listShinseiKubun_1", length = 13, order = 29)
    public RString listShinseiKubun_1;
    @ReportItem(name = "listShinseiYMD_1", length = 9, order = 30)
    public RString listShinseiYMD_1;
    @ReportItem(name = "listShinseiKubun_2", length = 2, order = 31)
    public RString listShinseiKubun_2;
    @ReportItem(name = "listShinseiYMD_2", length = 5, order = 32)
    public RString listShinseiYMD_2;
    @ReportItem(name = "listZenkaiYukokikan_1", length = 4, order = 33)
    public RString listZenkaiYukokikan_1;
    @ReportItem(name = "listZenkaiYukokikan_2", length = 2, order = 34)
    public RString listZenkaiYukokikan_2;
    @ReportItem(name = "listZenkaiYukokikan_3", length = 2, order = 35)
    public RString listZenkaiYukokikan_3;
    @ReportItem(name = "listZenkaiYukokikan_4", length = 5, order = 36)
    public RString listZenkaiYukokikan_4;
    @ReportItem(name = "listZenkaiYukokikan_5", length = 5, order = 37)
    public RString listZenkaiYukokikan_5;
    @ReportItem(name = "listZenkaiYukokikan_6", length = 1, order = 38)
    public RString listZenkaiYukokikan_6;
    @ReportItem(name = "listZenkaiYukokikan_7", length = 3, order = 39)
    public RString listZenkaiYukokikan_7;
    @ReportItem(name = "listZenkaiYukokikan_8", length = 4, order = 40)
    public RString listZenkaiYukokikan_8;
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
