/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.report.source.kagoketteitbun;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 過誤決定通知書情報取込一覧表（保険者分）帳票Source
 */
public class KagoKetteitsuchishoTorikomiIchiranHokenshaBunSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "torikomiYM", length = 8, order = 2)
    public RString torikomiYM;
    @ReportItem(name = "hokenshaNo", length = 6, order = 3)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 12, order = 4)
    public RString hokenshaName;
    @ReportItem(name = "shoHokenshaNoTitle", length = 9, order = 5)
    public RString shoHokenshaNoTitle;
    @ReportItem(name = "shoHokenshaNo", length = 8, order = 6)
    public RString shoHokenshaNo;
    @ReportItem(name = "shoHokenshaNameTitle", length = 9, order = 7)
    public RString shoHokenshaNameTitle;
    @ReportItem(name = "shoHokenshaName", length = 20, order = 8)
    public RString shoHokenshaName;
    @ReportItem(name = "shutsuryokujun1", length = 10, order = 9)
    public RString shutsuryokujun1;
    @ReportItem(name = "shutsuryokujun2", length = 10, order = 10)
    public RString shutsuryokujun2;
    @ReportItem(name = "shutsuryokujun3", length = 10, order = 11)
    public RString shutsuryokujun3;
    @ReportItem(name = "shutsuryokujun4", length = 10, order = 12)
    public RString shutsuryokujun4;
    @ReportItem(name = "shutsuryokujun5", length = 10, order = 13)
    public RString shutsuryokujun5;
    @ReportItem(name = "kaipage1", length = 20, order = 14)
    public RString kaipage1;
    @ReportItem(name = "kaipage2", length = 20, order = 15)
    public RString kaipage2;
    @ReportItem(name = "kaipage3", length = 20, order = 16)
    public RString kaipage3;
    @ReportItem(name = "kaipage4", length = 20, order = 17)
    public RString kaipage4;
    @ReportItem(name = "kaipage5", length = 20, order = 18)
    public RString kaipage5;
    @ReportItem(name = "listUpper_1", length = 4, order = 19)
    public RString listUpper_1;
    @ReportItem(name = "listUpper_2", length = 6, order = 20)
    public RString listUpper_2;
    @ReportItem(name = "listUpper_3", length = 10, order = 21)
    public RString listUpper_3;
    @ReportItem(name = "listUpper_4", length = 10, order = 22)
    public RString listUpper_4;
    @ReportItem(name = "listUpper_5", length = 20, order = 23)
    public RString listUpper_5;
    @ReportItem(name = "listUpper_6", length = 6, order = 24)
    public RString listUpper_6;
    @ReportItem(name = "listUpper_7", length = 2, order = 25)
    public RString listUpper_7;
    @ReportItem(name = "listUpper_8", length = 4, order = 26)
    public RString listUpper_8;
    @ReportItem(name = "listUpper_9", length = 17, order = 27)
    public RString listUpper_9;
    @ReportItem(name = "listLower1_1", length = 20, order = 28)
    public RString listLower1_1;
    @ReportItem(name = "listLower1_2", length = 12, order = 29)
    public RString listLower1_2;
    @ReportItem(name = "listLower1_3", length = 14, order = 30)
    public RString listLower1_3;
    @ReportItem(name = "listLower1_4", length = 17, order = 31)
    public RString listLower1_4;
    @ReportItem(name = "kensuTitle", length = 2, order = 32)
    public RString kensuTitle;
    @ReportItem(name = "tanisuTitle", length = 3, order = 33)
    public RString tanisuTitle;
    @ReportItem(name = "futanGakuTitle", length = 6, order = 34)
    public RString futanGakuTitle;
    @ReportItem(name = "kyufuhiTitle", length = 5, order = 35)
    public RString kyufuhiTitle;
    @ReportItem(name = "kensu1", length = 7, order = 36)
    public RString kensu1;
    @ReportItem(name = "tanisu1", length = 17, order = 37)
    public RString tanisu1;
    @ReportItem(name = "futanGaku1", length = 17, order = 38)
    public RString futanGaku1;
    @ReportItem(name = "servicehiTitle", length = 9, order = 39)
    public RString servicehiTitle;
    @ReportItem(name = "kensu2", length = 7, order = 40)
    public RString kensu2;
    @ReportItem(name = "tanisu2", length = 17, order = 41)
    public RString tanisu2;
    @ReportItem(name = "futanGaku2", length = 17, order = 42)
    public RString futanGaku2;
    @ReportItem(name = "shokujihiTitle", length = 9, order = 43)
    public RString shokujihiTitle;
    @ReportItem(name = "kensu3", length = 7, order = 44)
    public RString kensu3;
    @ReportItem(name = "tanisu3", length = 17, order = 45)
    public RString tanisu3;
    @ReportItem(name = "futanGaku3", length = 17, order = 46)
    public RString futanGaku3;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
