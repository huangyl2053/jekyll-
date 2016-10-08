package jp.co.ndensan.reams.db.dba.entity.report.nenreitotatsuyoteishaichiranhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 *
 * 年齢到達予定者一覧表Sourceクラスです。
 *
 * @reamsid_L DBA-0580-070 yaodongsheng
 */
public class NenreitotatsuYoteishaIchiranhyoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "tyusyutsukikanF", length = 16, order = 2)
    public RString tyusyutsukikanF;
    @ReportItem(name = "tyusyutsukikanT", length = 16, order = 3)
    public RString tyusyutsukikanT;
    @ReportItem(name = "shutsuRyokuTaisho", length = 8, order = 4)
    public RString shutsuRyokuTaisho;
    @ReportItem(name = "juminShubetsu", length = 5, order = 5)
    public RString juminShubetsu;
    @ReportItem(name = "shichosonCode", length = 6, order = 6)
    public RString shichosonCode;
    @ReportItem(name = "shichosonName", length = 12, order = 7)
    public RString shichosonName;
    @ReportItem(name = "shutsuryokujun1", length = 20, order = 8)
    public RString shutsuryokujun1;
    @ReportItem(name = "shutsuryokujun2", length = 20, order = 9)
    public RString shutsuryokujun2;
    @ReportItem(name = "shutsuryokujun3", length = 20, order = 10)
    public RString shutsuryokujun3;
    @ReportItem(name = "shutsuryokujun4", length = 20, order = 11)
    public RString shutsuryokujun4;
    @ReportItem(name = "shutsuryokujun5", length = 20, order = 12)
    public RString shutsuryokujun5;
    @ReportItem(name = "kaipage1", length = 20, order = 13)
    public RString kaipage1;
    @ReportItem(name = "kaipage2", length = 20, order = 14)
    public RString kaipage2;
    @ReportItem(name = "kaipage3", length = 20, order = 15)
    public RString kaipage3;
    @ReportItem(name = "kaipage4", length = 20, order = 16)
    public RString kaipage4;
    @ReportItem(name = "kaipage5", length = 20, order = 17)
    public RString kaipage5;
    @ReportItem(name = "listUpper_1", length = 10, order = 18)
    public RString listUpper_1;
    @ReportItem(name = "listUpper_2", length = 40, order = 19)
    public RString listUpper_2;
    @ReportItem(name = "listUpper_3", length = 1, order = 20)
    public RString listUpper_3;
    @ReportItem(name = "listUpper_4", length = 10, order = 21)
    public RString listUpper_4;
    @ReportItem(name = "listUpper_5", length = 5, order = 22)
    public RString listUpper_5;
    @ReportItem(name = "listUpper_6", length = 11, order = 23)
    public RString listUpper_6;
    @ReportItem(name = "listUpper_7", length = 29, order = 24)
    public RString listUpper_7;
    @ReportItem(name = "listUpper_8", length = 2, order = 25)
    public RString listUpper_8;
    @ReportItem(name = "listLower_1", length = 15, order = 26)
    public RString listLower_1;
    @ReportItem(name = "listLower_2", length = 23, order = 27)
    public RString listLower_2;
    @ReportItem(name = "listLower_3", length = 10, order = 28)
    public RString listLower_3;
    @ReportItem(name = "listLower_4", length = 6, order = 29)
    public RString listLower_4;
    @ReportItem(name = "listLower_5", length = 9, order = 30)
    public RString listLower_5;
    @ReportItem(name = "listLower_6", length = 24, order = 31)
    public RString listLower_6;
    @ReportItem(name = "listLower_7", length = 5, order = 32)
    public RString listLower_7;
    @ReportItem(name = "listLower_8", length = 10, order = 33)
    public RString listLower_8;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
