package jp.co.ndensan.reams.db.dbc.entity.report.furikomitsuchisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 帳票設計_DBC100060_事業合算・事業分振込明細書作成（一括） Sourceクラスです。
 *
 * @reamsid_L DBC-4870-050 lijian
 */
public class FurikomiTsuchishoSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 5, order = 1)
    public RString title;
    @ReportItem(name = "so_page", length = 4, order = 2)
    public RString so_page;
    @ReportItem(name = "page", length = 4, order = 3)
    public RString page;
    @ReportItem(name = "irai_mongon1", length = 15, order = 4)
    public RString irai_mongon1;
    @ReportItem(name = "Irai_YMD", length = 11, order = 5)
    public RString Irai_YMD;
    @ReportItem(name = "Furikomi_YMD", length = 11, order = 6)
    public RString Furikomi_YMD;
    @ReportItem(name = "tsuchi_mongon", length = 15, order = 7)
    public RString tsuchi_mongon;
    @ReportItem(name = "irai_mongon2", length = 3, order = 8)
    public RString irai_mongon2;
    @ReportItem(name = "irainin_2", length = 12, order = 9)
    public RString irainin_2;
    @ReportItem(name = "shitei_kinyu_mei_2", length = 15, order = 10)
    public RString shitei_kinyu_mei_2;
    @ReportItem(name = "irainin_1", length = 12, order = 11)
    public RString irainin_1;
    @ReportItem(name = "sama", length = 1, order = 12)
    public RString sama;
    @ReportItem(name = "furikomi_kuchisu", length = 5, order = 13)
    public RString furikomi_kuchisu;
    @ReportItem(name = "furikomi_kingaku", length = 13, order = 14)
    public RString furikomi_kingaku;
    @ReportItem(name = "shitei_kinyu_mei_1", length = 15, order = 15)
    public RString shitei_kinyu_mei_1;
    @ReportItem(name = "onchu_in", length = 2, order = 16)
    public RString onchu_in;
    @ReportItem(name = "title_yokin_shu", length = 4, order = 17)
    public RString title_yokin_shu;
    @ReportItem(name = "title_kinyu_name", length = 12, order = 18)
    public RString title_kinyu_name;
    @ReportItem(name = "title_koza_no", length = 4, order = 19)
    public RString title_koza_no;
    @ReportItem(name = "List1_1", length = 10, order = 20)
    public RString List1_1;
    @ReportItem(name = "List2_1", length = 20, order = 21)
    public RString List2_1;
    @ReportItem(name = "List1_2", length = 1, order = 22)
    public RString List1_2;
    @ReportItem(name = "List2_2", length = 6, order = 23)
    public RString List2_2;
    @ReportItem(name = "List1_3", length = 30, order = 24)
    public RString List1_3;
    @ReportItem(name = "List2_3", length = 10, order = 25)
    public RString List2_3;
    @ReportItem(name = "List1_4", length = 8, order = 26)
    public RString List1_4;
    @ReportItem(name = "List2_4", length = 10, order = 27)
    public RString List2_4;
    @ReportItem(name = "List2_5", length = 10, order = 28)
    public RString List2_5;
    @ReportItem(name = "List2_6", length = 13, order = 29)
    public RString List2_6;
    @ReportItem(name = "List2_7", length = 4, order = 30)
    public RString List2_7;
    @ReportItem(name = "kuchi_1", length = 1, order = 31)
    public RString kuchi_1;
    @ReportItem(name = "yen_1", length = 1, order = 32)
    public RString yen_1;
    @ReportItem(name = "kuchi_2", length = 1, order = 33)
    public RString kuchi_2;
    @ReportItem(name = "yen_2", length = 1, order = 34)
    public RString yen_2;
    @ReportItem(name = "ginko_kei_ft", length = 3, order = 35)
    public RString ginko_kei_ft;
    @ReportItem(name = "shiten_kei_ft", length = 3, order = 36)
    public RString shiten_kei_ft;
    @ReportItem(name = "ginko_kuchisu", length = 5, order = 37)
    public RString ginko_kuchisu;
    @ReportItem(name = "ginko_kingaku", length = 13, order = 38)
    public RString ginko_kingaku;
    @ReportItem(name = "shiten_kuchisu", length = 5, order = 39)
    public RString shiten_kuchisu;
    @ReportItem(name = "shiten_kingaku", length = 13, order = 40)
    public RString shiten_kingaku;
    @ReportItem(name = "shokei_kuchisu", length = 2, order = 41)
    public RString shokei_kuchisu;
    @ReportItem(name = "shokei_kingaku", length = 13, order = 42)
    public RString shokei_kingaku;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
