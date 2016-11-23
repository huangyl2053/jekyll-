package jp.co.ndensan.reams.db.dba.entity.report.nenreitotatsukakuninlist;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 年齢到達者登録リストヘッダエディターの帳票項目クラスです。
 *
 * @reamsid_L DBA-0570-060 xuyue
 */
public class NenreitotatsuKakuninListReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

   @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "tyusyutsukikanF", length = 16, order = 2)
    public RString tyusyutsukikanF;
    @ReportItem(name = "tyusyutsukikanT", length = 16, order = 3)
    public RString tyusyutsukikanT;
    @ReportItem(name = "taishoJohotitle", length = 50, order = 4)
    public RString taishoJohotitle;
    @ReportItem(name = "shichosonCode", length = 6, order = 5)
    public RString shichosonCode;
    @ReportItem(name = "shichosonName", length = 12, order = 6)
    public RString shichosonName;
    @ReportItem(name = "shutsuryokujun1", length = 20, order = 7)
    public RString shutsuryokujun1;
    @ReportItem(name = "shutsuryokujun2", length = 20, order = 8)
    public RString shutsuryokujun2;
    @ReportItem(name = "shutsuryokujun3", length = 20, order = 9)
    public RString shutsuryokujun3;
    @ReportItem(name = "shutsuryokujun4", length = 20, order = 10)
    public RString shutsuryokujun4;
    @ReportItem(name = "shutsuryokujun5", length = 20, order = 11)
    public RString shutsuryokujun5;
    @ReportItem(name = "kaipage1", length = 20, order = 12)
    public RString kaipage1;
    @ReportItem(name = "kaipage2", length = 20, order = 13)
    public RString kaipage2;
    @ReportItem(name = "kaipage3", length = 20, order = 14)
    public RString kaipage3;
    @ReportItem(name = "kaipage4", length = 20, order = 15)
    public RString kaipage4;
    @ReportItem(name = "kaipage5", length = 20, order = 16)
    public RString kaipage5;
    @ReportItem(name = "kaishiTitle", length = 8, order = 17)
    public RString kaishiTitle;
    @ReportItem(name = "shuryoTitle", length = 8, order = 18)
    public RString shuryoTitle;
    @ReportItem(name = "kubunTitle", length = 4, order = 19)
    public RString kubunTitle;
    @ReportItem(name = "idoJohoTitle1", length = 10, order = 20)
    public RString idoJohoTitle1;
    @ReportItem(name = "idoJohoTitle2", length = 10, order = 21)
    public RString idoJohoTitle2;
    @ReportItem(name = "idoJohoTitle3", length = 10, order = 22)
    public RString idoJohoTitle3;
    @ReportItem(name = "kaishiYmdTitle", length = 10, order = 23)
    public RString kaishiYmdTitle;
    @ReportItem(name = "shuryoYmdTitle", length = 10, order = 24)
    public RString shuryoYmdTitle;
    @ReportItem(name = "idoJohoTitle4", length = 10, order = 25)
    public RString idoJohoTitle4;
    @ReportItem(name = "idoJohoTitle5", length = 10, order = 26)
    public RString idoJohoTitle5;
    @ReportItem(name = "idoJohoTitle6", length = 10, order = 27)
    public RString idoJohoTitle6;
    @ReportItem(name = "listUpper_1", length = 15, order = 28)
    public RString listUpper_1;
    @ReportItem(name = "listUpper_2", length = 30, order = 29)
    public RString listUpper_2;
    @ReportItem(name = "listUpper_3", length = 10, order = 30)
    public RString listUpper_3;
    @ReportItem(name = "listUpper_4", length = 10, order = 31)
    public RString listUpper_4;
    @ReportItem(name = "listUpper_5", length = 10, order = 32)
    public RString listUpper_5;
    @ReportItem(name = "listUpper_6", length = 10, order = 33)
    public RString listUpper_6;
    @ReportItem(name = "listUpper_7", length = 10, order = 34)
    public RString listUpper_7;
    @ReportItem(name = "listUpper_8", length = 10, order = 35)
    public RString listUpper_8;
    @ReportItem(name = "listUpper_9", length = 10, order = 36)
    public RString listUpper_9;
    @ReportItem(name = "listUpper_10", length = 10, order = 37)
    public RString listUpper_10;
    @ReportItem(name = "listUpper_11", length = 6, order = 38)
    public RString listUpper_11;
    @ReportItem(name = "listUpper_12", length = 10, order = 39)
    public RString listUpper_12;
    @ReportItem(name = "listUpper_13", length = 10, order = 40)
    public RString listUpper_13;
    @ReportItem(name = "listUpper_14", length = 10, order = 41)
    public RString listUpper_14;
    @ReportItem(name = "listHihokenshaNo_1", length = 10, order = 42)
    public RString listHihokenshaNo_1;
    @ReportItem(name = "listLower_1", length = 15, order = 43)
    public RString listLower_1;
    @ReportItem(name = "listLower_2", length = 30, order = 44)
    public RString listLower_2;
    @ReportItem(name = "listLower_3", length = 10, order = 45)
    public RString listLower_3;
    @ReportItem(name = "listLower_4", length = 10, order = 46)
    public RString listLower_4;
    @ReportItem(name = "listLower_5", length = 10, order = 47)
    public RString listLower_5;
    @ReportItem(name = "listLower_6", length = 10, order = 48)
    public RString listLower_6;
    @ReportItem(name = "listLower_7", length = 10, order = 49)
    public RString listLower_7;
    @ReportItem(name = "listLower_8", length = 10, order = 50)
    public RString listLower_8;
    @ReportItem(name = "listLower_9", length = 10, order = 51)
    public RString listLower_9;
    @ReportItem(name = "listLower_10", length = 10, order = 52)
    public RString listLower_10;
    @ReportItem(name = "listLower_11", length = 6, order = 53)
    public RString listLower_11;
    @ReportItem(name = "listLower_12", length = 10, order = 54)
    public RString listLower_12;
    @ReportItem(name = "listLower_13", length = 10, order = 55)
    public RString listLower_13;
    @ReportItem(name = "listLower_14", length = 10, order = 56)
    public RString listLower_14;
    @ReportItem(name = "fuseigoCountTitle", length = 20, order = 57)
    public RString fuseigoCountTitle;
    @ReportItem(name = "fuseigoCount", length = 10, order = 58)
    public RString fuseigoCount;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
    @ReportItem(name = "yubinNo", length = 10, order = 55)
    public RString yubinNo;
    @ReportItem(name = "choikiCode", length = 10, order = 56)
    public RString choikiCode;
    @ReportItem(name = "banchiCode", length = 10, order = 57)
    public RString banchiCode;
    @ReportItem(name = "gyoseikuCode", length = 10, order = 58)
    public RString gyoseikuCode;
    @ReportItem(name = "chiku1", length = 10, order = 59)
    public RString chiku1;
    @ReportItem(name = "chiku2", length = 10, order = 60)
    public RString chiku2;
    @ReportItem(name = "chiku3", length = 10, order = 61)
    public RString chiku3;
    @ReportItem(name = "shimei50onKana", length = 10, order = 62)
    public RString shimei50onKana;
    @ReportItem(name = "seinengappiYMD", length = 10, order = 63)
    public RString seinengappiYMD;
    @ReportItem(name = "gender", length = 10, order = 64)
    public RString gender;
// </editor-fold>
}
