/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.report.source.gassanshikyugakutorikomiichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 帳票設計_DBC200037_高額合算支給額計算結果連絡票情報取込一覧表 のソースクラスです。
 *
 * @reamsid_L DBC-2680-030 qinzhen
 */
public class GassanShikyugakuTorikomiIchiranSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "torikomiYM", length = 8, order = 2)
    public RString torikomiYM;
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
    @ReportItem(name = "kaipage1", length = 20, order = 10)
    public RString kaipage1;
    @ReportItem(name = "kaipage2", length = 20, order = 11)
    public RString kaipage2;
    @ReportItem(name = "kaipage3", length = 20, order = 12)
    public RString kaipage3;
    @ReportItem(name = "kaipage4", length = 20, order = 13)
    public RString kaipage4;
    @ReportItem(name = "kaipage5", length = 20, order = 14)
    public RString kaipage5;
    @ReportItem(name = "listUpper_1", length = 6, order = 15)
    public RString listUpper_1;
    @ReportItem(name = "listUpper_2", length = 3, order = 16)
    public RString listUpper_2;
    @ReportItem(name = "listUpper_3", length = 10, order = 17)
    public RString listUpper_3;
    @ReportItem(name = "listUpper_4", length = 17, order = 18)
    public RString listUpper_4;
    @ReportItem(name = "listUpper_5", length = 21, order = 19)
    public RString listUpper_5;
    @ReportItem(name = "listUpper_6", length = 13, order = 20)
    public RString listUpper_6;
    @ReportItem(name = "listUpper_7", length = 13, order = 21)
    public RString listUpper_7;
    @ReportItem(name = "listUpper_8", length = 13, order = 22)
    public RString listUpper_8;
    @ReportItem(name = "listUpper_9", length = 13, order = 23)
    public RString listUpper_9;
    @ReportItem(name = "listLower_1", length = 13, order = 24)
    public RString listLower_1;
    @ReportItem(name = "listLower_2", length = 20, order = 25)
    public RString listLower_2;
    @ReportItem(name = "listLower_3", length = 5, order = 26)
    public RString listLower_3;
    @ReportItem(name = "listLower_4", length = 5, order = 27)
    public RString listLower_4;
    @ReportItem(name = "listLower_5", length = 13, order = 28)
    public RString listLower_5;
    @ReportItem(name = "listLower_6", length = 13, order = 29)
    public RString listLower_6;
    @ReportItem(name = "listLower_7", length = 13, order = 30)
    public RString listLower_7;
    @ReportItem(name = "listLower_8", length = 13, order = 31)
    public RString listLower_8;
    @ReportItem(name = "listLower_9", length = 13, order = 32)
    public RString listLower_9;
    @ReportItem(name = "kihonKensuTitle", length = 8, order = 33)
    public RString kihonKensuTitle;
    @ReportItem(name = "kihonKensu", length = 9, order = 34)
    public RString kihonKensu;
    @ReportItem(name = "meisaiKensuTitle", length = 4, order = 35)
    public RString meisaiKensuTitle;
    @ReportItem(name = "meisaiKensu", length = 9, order = 36)
    public RString meisaiKensu;
    @ReportItem(name = "yubinNo", length = 13, order = 37)
    public RString yubinNo;
    @ReportItem(name = "choikiCode", length = 20, order = 38)
    public RString choikiCode;
    @ReportItem(name = "gyoseikuCode", length = 20, order = 39)
    public RString gyoseikuCode;
    @ReportItem(name = "shimei50onKana", length = 30, order = 40)
    public RString shimei50onKana;
    @ReportItem(name = "shichosonCode", length = 13, order = 41)
    public RString shichosonCode;
    @ReportItem(name = "shoKisaiHokenshaNo", length = 13, order = 42)
    public RString shoKisaiHokenshaNo;
    @ReportItem(name = "hihokenshaNo", length = 15, order = 43)
    public RString hihokenshaNo;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
