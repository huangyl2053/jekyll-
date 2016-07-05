package jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaikaisaioshirasetsuchi;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 介護認定審査会開催のお知らせのReportSourceです。
 *
 * @reamsid_L DBE-0150-110 lishengli
 */
public class ShinsakaiKaisaiOshiraseTsuchiReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "hakkoYMD1", length = 12, order = 1)
    public RString hakkoYMD1;
    @ReportItem(name = "denshiKoin", order = 2)
    public RString denshiKoin;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 3)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "ninshoshaYakushokuMei2", order = 4)
    public RString ninshoshaYakushokuMei2;
    @ReportItem(name = "ninshoshaYakushokuMei1", order = 5)
    public RString ninshoshaYakushokuMei1;
    @ReportItem(name = "ninshoshaShimeiKakenai", order = 6)
    public RString ninshoshaShimeiKakenai;
    @ReportItem(name = "ninshoshaShimeiKakeru", order = 7)
    public RString ninshoshaShimeiKakeru;
    @ReportItem(name = "koinMojiretsu", length = 4, order = 8)
    public RString koinMojiretsu;
    @ReportItem(name = "koinShoryaku", length = 15, order = 9)
    public RString koinShoryaku;
    @ReportItem(name = "bunshoNo", length = 35, order = 10)
    public RString bunshoNo;
    @ReportItem(name = "yubinNo", length = 8, order = 11)
    public RString yubinNo;
    @ReportItem(name = "jushoText", order = 12)
    public RString jushoText;
    @ReportItem(name = "kikanNameText", order = 13)
    public RString kikanNameText;
    @ReportItem(name = "shimeiText", order = 14)
    public RString shimeiText;
    @ReportItem(name = "meishoFuyo", length = 3, order = 15)
    public RString meishoFuyo;
    @ReportItem(name = "customerBarCode", order = 16)
    public RString customerBarCode;
    @ReportItem(name = "pageCount", length = 8, order = 17)
    public RString pageCount;
    @ReportItem(name = "title", length = 30, order = 18)
    public RString title;
    @ReportItem(name = "tsuchibun1", order = 19)
    public RString tsuchibun1;
    @ReportItem(name = "shinsakaiKaisaiYMD", length = 22, order = 20)
    public RString shinsakaiKaisaiYMD;
    @ReportItem(name = "kaisaiKaijo", length = 20, order = 21)
    public RString kaisaiKaijo;
    @ReportItem(name = "gogitaiNo", length = 3, order = 22)
    public RString gogitaiNo;
    @ReportItem(name = "tsuchibun2", order = 23)
    public RString tsuchibun2;
    @ReportItem(name = "listKaisaiJoho_1", length = 6, order = 24)
    public RString listKaisaiJoho_1;
    @ReportItem(name = "listKaisaiJoho_2", length = 11, order = 25)
    public RString listKaisaiJoho_2;
    @ReportItem(name = "listKaisaiJoho_3", length = 5, order = 26)
    public RString listKaisaiJoho_3;
    @ReportItem(name = "listKaisaiJoho_4", length = 2, order = 27)
    public RString listKaisaiJoho_4;
    @ReportItem(name = "listKaisaiJoho_5", length = 20, order = 28)
    public RString listKaisaiJoho_5;
    @ReportItem(name = "listJusho_1", length = 30, order = 29)
    public RString listJusho_1;
    @ReportItem(name = "listTelNo_1", length = 13, order = 30)
    public RString listTelNo_1;
    @ReportItem(name = "tsuchibun3", order = 31)
    public RString tsuchibun3;
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

        gogitaiNo,

    }
}
