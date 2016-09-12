/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.report.kogakusogojigyoservicehitaishoshaichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 高額総合事業サービス費対象者一覧表source
 *
 * @reamsid_L DBC-2010-120 surun
 */
public class KogakuSogoJigyoServiceHiTaishoshaIchiranSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "shinsaYMKaishi", length = 8, order = 2)
    public RString shinsaYMKaishi;
    @ReportItem(name = "shinsaYMShuryo", length = 8, order = 3)
    public RString shinsaYMShuryo;
    @ReportItem(name = "hokenshaNo", length = 6, order = 4)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 12, order = 5)
    public RString hokenshaName;
    @ReportItem(name = "shutsuryokujun1", length = 10, order = 6)
    public RString shutsuryokujun1;
    @ReportItem(name = "shutsuryokujun2", length = 10, order = 7)
    public RString shutsuryokujun2;
    @ReportItem(name = "shutsuryokujun3", length = 10, order = 8)
    public RString shutsuryokujun3;
    @ReportItem(name = "shutsuryokujun4", length = 10, order = 9)
    public RString shutsuryokujun4;
    @ReportItem(name = "shutsuryokujun5", length = 10, order = 10)
    public RString shutsuryokujun5;
    @ReportItem(name = "kaipage1", length = 20, order = 11)
    public RString kaipage1;
    @ReportItem(name = "kaipage2", length = 20, order = 12)
    public RString kaipage2;
    @ReportItem(name = "kaipage3", length = 20, order = 13)
    public RString kaipage3;
    @ReportItem(name = "kaipage4", length = 20, order = 14)
    public RString kaipage4;
    @ReportItem(name = "kaipage5", length = 20, order = 15)
    public RString kaipage5;
    @ReportItem(name = "listTaishoshaIchiran_1", length = 4, order = 16)
    public RString listTaishoshaIchiran_1;
    @ReportExpandedInfo(id = "A", code = "0003", name = "被保険者番号")
    @ReportItem(name = "listTaishoshaIchiran_2", length = 10, order = 17)
    public RString listTaishoshaIchiran_2;
    @ReportItem(name = "listTaishoshaIchiran_3", length = 6, order = 18)
    public RString listTaishoshaIchiran_3;
    @ReportItem(name = "listTaishoshaIchiran_4", length = 10, order = 19)
    public RString listTaishoshaIchiran_4;
    @ReportItem(name = "listTaishoshaIchiran_5", length = 2, order = 20)
    public RString listTaishoshaIchiran_5;
    @ReportItem(name = "listTaishoshaIchiran_6", length = 15, order = 21)
    public RString listTaishoshaIchiran_6;
    @ReportItem(name = "listTaishoshaIchiran_7", length = 1, order = 22)
    public RString listTaishoshaIchiran_7;
    @ReportItem(name = "listTaishoshaIchiran_8", length = 10, order = 23)
    public RString listTaishoshaIchiran_8;
    @ReportItem(name = "listTaishoshaIchiran_9", length = 1, order = 24)
    public RString listTaishoshaIchiran_9;
    @ReportItem(name = "listTaishoshaIchiran_10", length = 13, order = 25)
    public RString listTaishoshaIchiran_10;
    @ReportItem(name = "listTaishoshaIchiran_11", length = 85, order = 26)
    public RString listTaishoshaIchiran_11;
    @ReportPerson(id = "A")
    @ReportItem(name = "shikibetsuCode", length = 85, order = 27)
    public RString shikibetsuCode;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>

    /**
     * TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSourceのenum
     */
    public enum ReportSourceFields {

        printTimeStamp,
        shinsaYMKaishi,
        shinsaYMShuryo,
        hokenshaNo,
        hokenshaName,
        shutsuryokujun1,
        shutsuryokujun2,
        shutsuryokujun3,
        shutsuryokujun4,
        shutsuryokujun5,
        kaipage1,
        kaipage2,
        kaipage3,
        kaipage4,
        kaipage5,
        listTaishoshaIchiran_1,
        listTaishoshaIchiran_2,
        listTaishoshaIchiran_3,
        listTaishoshaIchiran_4,
        listTaishoshaIchiran_5,
        listTaishoshaIchiran_6,
        listTaishoshaIchiran_7,
        listTaishoshaIchiran_8,
        listTaishoshaIchiran_9,
        listTaishoshaIchiran_10,
        listTaishoshaIchiran_11,
        shikibetsuCode
    }
}
