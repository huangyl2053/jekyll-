package jp.co.ndensan.reams.db.dbc.entity.report.furikomimeisaiichiranjigyokogaku;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 振込明細一覧表（事業高額）Sourceクラスです。
 *
 * @reamsid_L DBC-4870-070 wangxingpeng
 */
public class FurikomiMeisaiIchiranJigyoKogakuSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "title", length = 20, order = 2)
    public RString title;
    @ReportItem(name = "hokenshaNo", length = 6, order = 3)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 12, order = 4)
    public RString hokenshaName;
    @ReportItem(name = "shutsuryokujun1", length = 10, order = 5)
    public RString shutsuryokujun1;
    @ReportItem(name = "shutsuryokujun2", length = 10, order = 6)
    public RString shutsuryokujun2;
    @ReportItem(name = "shutsuryokujun3", length = 10, order = 7)
    public RString shutsuryokujun3;
    @ReportItem(name = "shutsuryokujun4", length = 10, order = 8)
    public RString shutsuryokujun4;
    @ReportItem(name = "shutsuryokujun5", length = 10, order = 9)
    public RString shutsuryokujun5;
    @ReportItem(name = "ｌist3_1", length = 6, order = 10)
    public RString ｌist3_1;
    @ReportExpandedInfo(id = "A", code = "0003", name = "被保険者番号")
    @ReportItem(name = "list1_1", length = 10, order = 11)
    public RString list1_1;
    @ReportItem(name = "list1_2", length = 20, order = 12)
    public RString list1_2;
    @ReportItem(name = "list1_3", length = 6, order = 13)
    public RString list1_3;
    @ReportItem(name = "list1_4", length = 9, order = 14)
    public RString list1_4;
    @ReportItem(name = "list1_5", length = 4, order = 15)
    public RString list1_5;
    @ReportItem(name = "list1_6", length = 9, order = 16)
    public RString list1_6;
    @ReportItem(name = "list1_7", length = 32, order = 17)
    public RString list1_7;
    @ReportItem(name = "list2_1", length = 20, order = 18)
    public RString list2_1;
    @ReportItem(name = "list2_2", length = 3, order = 19)
    public RString list2_2;
    @ReportItem(name = "list2_3", length = 6, order = 20)
    public RString list2_3;
    @ReportItem(name = "list2_4", length = 4, order = 21)
    public RString list2_4;
    @ReportItem(name = "list2_5", length = 9, order = 22)
    public RString list2_5;
    @ReportItem(name = "list2_6", length = 13, order = 23)
    public RString list2_6;
    @ReportItem(name = "list2_7", length = 32, order = 24)
    public RString list2_7;
    @ReportItem(name = "list4_1", length = 2, order = 25)
    public RString list4_1;
    @ReportItem(name = "list5_1", length = 1, order = 26)
    public RString list5_1;
    @ReportItem(name = "ninzu_shokei", length = 9, order = 27)
    public RString ninzu_shokei;
    @ReportItem(name = "shikyu_shokei", length = 14, order = 28)
    public RString shikyu_shokei;
    @ReportItem(name = "yoshien_ninzu_gokei", length = 9, order = 29)
    public RString yoshien_ninzu_gokei;
    @ReportItem(name = "yoshien_kingaku_gokei", length = 14, order = 30)
    public RString yoshien_kingaku_gokei;
    @ReportItem(name = "jigyotaisho_ninzu_gokei", length = 9, order = 31)
    public RString jigyotaisho_ninzu_gokei;
    @ReportItem(name = "jigyotaisho_kingaku_gokei", length = 14, order = 32)
    public RString jigyotaisho_kingaku_gokei;
    @ReportItem(name = "fumei_ninzu_gokei", length = 9, order = 33)
    public RString fumei_ninzu_gokei;
    @ReportItem(name = "fumei_kingaku_gokei", length = 14, order = 34)
    public RString fumei_kingaku_gokei;
    @ReportItem(name = "ninzu_gokei", length = 9, order = 35)
    public RString ninzu_gokei;
    @ReportItem(name = "shikyu_gokei", length = 14, order = 36)
    public RString shikyu_gokei;
    @ReportPerson(id = "A")
    @ReportItem(name = "shikibetsuCode", length = 15)
    public RString shikibetsuCode;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
