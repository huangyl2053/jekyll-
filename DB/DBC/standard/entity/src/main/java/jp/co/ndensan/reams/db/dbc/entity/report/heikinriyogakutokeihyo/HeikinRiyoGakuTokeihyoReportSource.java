package jp.co.ndensan.reams.db.dbc.entity.report.heikinriyogakutokeihyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 平均利用額統計表ReportSourceです。
 *
 * @reamsid_L DBC-3490-040 sunhaidi
 */
public class HeikinRiyoGakuTokeihyoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "joken1", length = 40, order = 1)
    public RString joken1;
    @ReportItem(name = "joken2", length = 40, order = 2)
    public RString joken2;
    @ReportItem(name = "hokenshaNo", length = 6, order = 3)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 12, order = 4)
    public RString hokenshaName;
    @ReportItem(name = "printTimeStamp", length = 21, order = 5)
    public RString printTimeStamp;
    @ReportItem(name = "List1_1", length = 15, order = 6)
    public RString List1_1;
    @ReportItem(name = "List1_2", length = 15, order = 7)
    public RString List1_2;
    @ReportItem(name = "List1_3", length = 15, order = 8)
    public RString List1_3;
    @ReportItem(name = "List1_4", length = 15, order = 9)
    public RString List1_4;
    @ReportItem(name = "List1_5", length = 15, order = 10)
    public RString List1_5;
    @ReportItem(name = "List1_6", length = 15, order = 11)
    public RString List1_6;
    @ReportItem(name = "List1_7", length = 15, order = 12)
    public RString List1_7;
    @ReportItem(name = "List1_8", length = 15, order = 13)
    public RString List1_8;
    @ReportItem(name = "List1_9", length = 15, order = 14)
    public RString List1_9;
    @ReportItem(name = "List2_1", length = 15, order = 15)
    public RString List2_1;
    @ReportItem(name = "List2_2", length = 15, order = 16)
    public RString List2_2;
    @ReportItem(name = "List2_3", length = 15, order = 17)
    public RString List2_3;
    @ReportItem(name = "List2_4", length = 15, order = 18)
    public RString List2_4;
    @ReportItem(name = "List2_5", length = 15, order = 19)
    public RString List2_5;
    @ReportItem(name = "List2_6", length = 15, order = 20)
    public RString List2_6;
    @ReportItem(name = "List2_7", length = 15, order = 21)
    public RString List2_7;
    @ReportItem(name = "List2_8", length = 15, order = 22)
    public RString List2_8;
    @ReportItem(name = "List2_9", length = 15, order = 23)
    public RString List2_9;
    @ReportItem(name = "List3_1", length = 15, order = 24)
    public RString List3_1;
    @ReportItem(name = "List3_2", length = 15, order = 25)
    public RString List3_2;
    @ReportItem(name = "List3_3", length = 15, order = 26)
    public RString List3_3;
    @ReportItem(name = "List3_4", length = 15, order = 27)
    public RString List3_4;
    @ReportItem(name = "List3_5", length = 15, order = 28)
    public RString List3_5;
    @ReportItem(name = "List3_6", length = 15, order = 29)
    public RString List3_6;
    @ReportItem(name = "List3_7", length = 15, order = 30)
    public RString List3_7;
    @ReportItem(name = "List3_8", length = 15, order = 31)
    public RString List3_8;
    @ReportItem(name = "List3_9", length = 15, order = 32)
    public RString List3_9;
    @ReportItem(name = "ninzu6", length = 2, order = 33)
    public RString ninzu6;
    @ReportItem(name = "shotoku6", length = 2, order = 34)
    public RString shotoku6;
    @ReportItem(name = "hiyosogaku6", length = 4, order = 35)
    public RString hiyosogaku6;
    @ReportItem(name = "heikingaku6", length = 3, order = 36)
    public RString heikingaku6;
    @ReportItem(name = "service1", length = 16, order = 37)
    public RString service1;
    @ReportItem(name = "ninzu7", length = 2, order = 38)
    public RString ninzu7;
    @ReportItem(name = "service2", length = 16, order = 39)
    public RString service2;
    @ReportItem(name = "shotoku7", length = 2, order = 40)
    public RString shotoku7;
    @ReportItem(name = "hiyosogaku7", length = 4, order = 41)
    public RString hiyosogaku7;
    @ReportItem(name = "heikingaku7", length = 3, order = 42)
    public RString heikingaku7;
    @ReportItem(name = "service3", length = 16, order = 43)
    public RString service3;
    @ReportItem(name = "ninzu8", length = 2, order = 44)
    public RString ninzu8;
    @ReportItem(name = "shotoku8", length = 2, order = 45)
    public RString shotoku8;
    @ReportItem(name = "hiyosogaku8", length = 4, order = 46)
    public RString hiyosogaku8;
    @ReportItem(name = "heikingaku8", length = 3, order = 47)
    public RString heikingaku8;
    @ReportItem(name = "ninzu9", length = 2, order = 48)
    public RString ninzu9;
    @ReportItem(name = "shotoku9", length = 2, order = 49)
    public RString shotoku9;
    @ReportItem(name = "hiyosogaku9", length = 4, order = 50)
    public RString hiyosogaku9;
    @ReportItem(name = "heikingaku9", length = 3, order = 51)
    public RString heikingaku9;
    @ReportItem(name = "ninzu10", length = 2, order = 52)
    public RString ninzu10;
    @ReportItem(name = "shotoku10", length = 2, order = 53)
    public RString shotoku10;
    @ReportItem(name = "hiyosogaku10", length = 4, order = 54)
    public RString hiyosogaku10;
    @ReportItem(name = "heikingaku10", length = 3, order = 55)
    public RString heikingaku10;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
