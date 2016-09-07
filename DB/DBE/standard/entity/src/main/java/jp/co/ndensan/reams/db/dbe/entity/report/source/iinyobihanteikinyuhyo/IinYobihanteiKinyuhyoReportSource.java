/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.report.source.iinyobihanteikinyuhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 委員用予備判定記入表のReportSourceクラスです。
 *
 * @reamsid_L DBE-0150-150 wangrenze
 */
public class IinYobihanteiKinyuhyoReportSource implements IReportSource {

// <editor-fold defaultstate="collapsed" desc="Generated Code">
    @ReportItem(name = "title", length = 50, order = 1)
    public RString title;
    @ReportItem(name = "shinsakaiKaisaiNo", length = 15, order = 2)
    public RString shinsakaiKaisaiNo;
    @ReportItem(name = "printTimeStamp", length = 34, order = 3)
    public RString printTimeStamp;
    @ReportItem(name = "listTokuteiShippeiCode_1", length = 2, order = 4)
    public RString listTokuteiShippeiCode_1;
    @ReportItem(name = "listTaishoshaIchiran_1", length = 3, order = 5)
    public RString listTaishoshaIchiran_1;
    @ReportItem(name = "listTaishoshaIchiran_2", length = 13, order = 6)
    public RString listTaishoshaIchiran_2;
    @ReportItem(name = "listTaishoshaIchiran_3", length = 1, order = 7)
    public RString listTaishoshaIchiran_3;
    @ReportItem(name = "listTaishoshaIchiran_4", length = 3, order = 8)
    public RString listTaishoshaIchiran_4;
    @ReportItem(name = "listTaishoshaIchiran_5", length = 3, order = 9)
    public RString listTaishoshaIchiran_5;
    @ReportItem(name = "listTaishoshaIchiran_6", length = 6, order = 10)
    public RString listTaishoshaIchiran_6;
    @ReportItem(name = "listTaishoshaIchiran_7", length = 5, order = 11)
    public RString listTaishoshaIchiran_7;
    @ReportItem(name = "listTaishoshaIchiran_8", length = 6, order = 12)
    public RString listTaishoshaIchiran_8;
    @ReportItem(name = "listTaishoshaIchiran_9", length = 6, order = 13)
    public RString listTaishoshaIchiran_9;
    @ReportItem(name = "listTaishoshaIchiran_10", length = 6, order = 14)
    public RString listTaishoshaIchiran_10;
    @ReportItem(name = "listTaishoshaIchiran_11", length = 2, order = 15)
    public RString listTaishoshaIchiran_11;
    @ReportItem(name = "listTaishoshaIchiran_12", length = 5, order = 16)
    public RString listTaishoshaIchiran_12;
    @ReportItem(name = "listTokuteiShippeiName_1", length = 30, order = 17)
    public RString listTokuteiShippeiName_1;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>

    /**
     * 改ページ条件のキーです。
     */
    public enum ReportSourceFields {

        shinsakaiKaisaiNo,
    }
}
