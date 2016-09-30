package jp.co.ndensan.reams.db.dbc.entity.report.furikomimeisaiichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 帳票設計_DBC200003_事業合算・事業分振込明細書作成（一括） Sourceクラスです。
 *
 * @reamsid_L DBC-4870-060 lijian
 */
public class FurikomiMeisaiIchiranSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "shiharaihoho", length = 2, order = 1)
    public RString shiharaihoho;
    @ReportItem(name = "kikan", length = 21, order = 2)
    public RString kikan;
    @ReportItem(name = "hyouzi_ymd1", length = 9, order = 3)
    public RString hyouzi_ymd1;
    @ReportItem(name = "hyouzi_ymd2", length = 9, order = 4)
    public RString hyouzi_ymd2;
    @ReportItem(name = "hyouzi_ymd3", length = 9, order = 5)
    public RString hyouzi_ymd3;
    @ReportItem(name = "hokensha_cd", length = 6, order = 6)
    public RString hokensha_cd;
    @ReportItem(name = "hokensha_name", length = 12, order = 7)
    public RString hokensha_name;
    @ReportItem(name = "pageCnt", length = 6, order = 8)
    public RString pageCnt;
    @ReportItem(name = "sort_nm3", length = 20, order = 9)
    public RString sort_nm3;
    @ReportItem(name = "sort_nm4", length = 20, order = 10)
    public RString sort_nm4;
    @ReportItem(name = "sort_nm5", length = 20, order = 11)
    public RString sort_nm5;
    @ReportItem(name = "sort_nm1", length = 20, order = 12)
    public RString sort_nm1;
    @ReportItem(name = "sort_nm2", length = 20, order = 13)
    public RString sort_nm2;
    @ReportItem(name = "shori_ymd_hms", length = 21, order = 14)
    public RString shori_ymd_hms;
    @ReportItem(name = "List3_1", length = 6, order = 15)
    public RString List3_1;
    @ReportItem(name = "List1_1", length = 10, order = 16)
    public RString List1_1;
    @ReportItem(name = "List2_1", length = 6, order = 17)
    public RString List2_1;
    @ReportItem(name = "List1_2", length = 18, order = 18)
    public RString List1_2;
    @ReportItem(name = "List2_2", length = 18, order = 19)
    public RString List2_2;
    @ReportItem(name = "List1_3", length = 17, order = 20)
    public RString List1_3;
    @ReportItem(name = "List2_3", length = 13, order = 21)
    public RString List2_3;
    @ReportItem(name = "List1_4", length = 9, order = 22)
    public RString List1_4;
    @ReportItem(name = "List2_4", length = 9, order = 23)
    public RString List2_4;
    @ReportItem(name = "List1_5", length = 13, order = 24)
    public RString List1_5;
    @ReportItem(name = "List2_5", length = 4, order = 25)
    public RString List2_5;
    @ReportItem(name = "List1_6", length = 9, order = 26)
    public RString List1_6;
    @ReportItem(name = "List2_6", length = 9, order = 27)
    public RString List2_6;
    @ReportItem(name = "List1_7", length = 13, order = 28)
    public RString List1_7;
    @ReportItem(name = "List2_7", length = 13, order = 29)
    public RString List2_7;
    @ReportItem(name = "List1_8", length = 31, order = 30)
    public RString List1_8;
    @ReportItem(name = "List2_8", length = 31, order = 31)
    public RString List2_8;
    @ReportItem(name = "List4_1", length = 2, order = 32)
    public RString List4_1;
    @ReportItem(name = "List5_1", length = 1, order = 33)
    public RString List5_1;
    @ReportItem(name = "ninzu_shokei", length = 9, order = 34)
    public RString ninzu_shokei;
    @ReportItem(name = "shikyu_shokei", length = 14, order = 35)
    public RString shikyu_shokei;
    @ReportItem(name = "yoshien_ninzu_gokei", length = 9, order = 36)
    public RString yoshien_ninzu_gokei;
    @ReportItem(name = "yoshien_kingaku_gokei", length = 14, order = 37)
    public RString yoshien_kingaku_gokei;
    @ReportItem(name = "jigyotaisho_ninzu_gokei", length = 9, order = 38)
    public RString jigyotaisho_ninzu_gokei;
    @ReportItem(name = "jigyotaisho_kingaku_gokei", length = 14, order = 39)
    public RString jigyotaisho_kingaku_gokei;
    @ReportItem(name = "fumei_ninzu_gokei", length = 9, order = 40)
    public RString fumei_ninzu_gokei;
    @ReportItem(name = "fumei_kingaku_gokei", length = 14, order = 41)
    public RString fumei_kingaku_gokei;
    @ReportItem(name = "ninzu_gokei", length = 9, order = 42)
    public RString ninzu_gokei;
    @ReportItem(name = "shikyu_gokei", length = 14, order = 43)
    public RString shikyu_gokei;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
