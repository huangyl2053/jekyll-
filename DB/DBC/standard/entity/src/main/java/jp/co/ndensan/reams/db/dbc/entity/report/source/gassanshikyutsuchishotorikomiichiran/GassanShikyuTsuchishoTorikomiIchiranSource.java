/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.report.source.gassanshikyutsuchishotorikomiichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 帳票設計_DBC200039_高額合算支給不支給決定通知書情報取込一覧表 のソースクラスです。
 *
 * @reamsid_L DBC-2690-030 qinzhen
 */
public class GassanShikyuTsuchishoTorikomiIchiranSource implements IReportSource {
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
    @ReportItem(name = "listCenter_1", length = 6, order = 15)
    public RString listCenter_1;
    @ReportItem(name = "listCenter_2", length = 3, order = 16)
    public RString listCenter_2;
    @ReportItem(name = "listCenter_3", length = 2, order = 17)
    public RString listCenter_3;
    @ReportItem(name = "listUpper_1", length = 10, order = 18)
    public RString listUpper_1;
    @ReportItem(name = "listUpper_2", length = 19, order = 19)
    public RString listUpper_2;
    @ReportItem(name = "listUpper_3", length = 17, order = 20)
    public RString listUpper_3;
    @ReportItem(name = "listUpper_4", length = 10, order = 21)
    public RString listUpper_4;
    @ReportItem(name = "listUpper_5", length = 13, order = 22)
    public RString listUpper_5;
    @ReportItem(name = "listUpper_6", length = 38, order = 23)
    public RString listUpper_6;
    @ReportItem(name = "listLower_1", length = 4, order = 24)
    public RString listLower_1;
    @ReportItem(name = "listLower_2", length = 19, order = 25)
    public RString listLower_2;
    @ReportItem(name = "listLower_3", length = 22, order = 26)
    public RString listLower_3;
    @ReportItem(name = "listLower_4", length = 9, order = 27)
    public RString listLower_4;
    @ReportItem(name = "listLower_5", length = 13, order = 28)
    public RString listLower_5;
    @ReportItem(name = "listLower_6", length = 38, order = 29)
    public RString listLower_6;
    @ReportItem(name = "yubinNo", length = 1, order = 30)
    public RString yubinNo;
    @ReportItem(name = "choikiCode", length = 1, order = 31)
    public RString choikiCode;
    @ReportItem(name = "gyoseikuCode", length = 1, order = 32)
    public RString gyoseikuCode;
    @ReportItem(name = "shimei50onKana", length = 1, order = 33)
    public RString shimei50onKana;
    @ReportItem(name = "shichosonCode", length = 1, order = 34)
    public RString shichosonCode;
    @ReportItem(name = "taishoNendo", length = 1, order = 35)
    public RString taishoNendo;
    @ReportItem(name = "shikyuKubunCode", length = 1, order = 36)
    public RString shikyuKubunCode;
    @ReportItem(name = "shoKisaiHokenshaNo", length = 10, order = 37)
    public RString shoKisaiHokenshaNo;
    @ReportPerson(id = "X")
    @ReportItem(name = "shikibetsuCode", length = 10, order = 38)
    public RString shikibetsuCode;
    @ReportExpandedInfo(id = "X")
    public ExpandedInformation expandedInformation;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
