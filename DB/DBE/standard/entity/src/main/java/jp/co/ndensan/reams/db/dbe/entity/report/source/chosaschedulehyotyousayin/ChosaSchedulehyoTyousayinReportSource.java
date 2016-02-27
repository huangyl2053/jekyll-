/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.report.source.chosaschedulehyotyousayin;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 認定調査スケジュール表(調査員)Sourceクラスです。
 */
public class ChosaSchedulehyoTyousayinReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 30, order = 1)
    public RString title;
    @ReportItem(name = "chosaItakusakiNo", length = 12, order = 2)
    public RString chosaItakusakiNo;
    @ReportItem(name = "chosaItakusakiName", length = 30, order = 3)
    public RString chosaItakusakiName;
    @ReportItem(name = "printTimeStamp", length = 34, order = 4)
    public RString printTimeStamp;
    @ReportItem(name = "listTel1_1", length = 13, order = 5)
    public RString listTel1_1;
    @ReportItem(name = "listChosaSukejuru_1", length = 3, order = 6)
    public RString listChosaSukejuru_1;
    @ReportItem(name = "listChosaSukejuru_2", length = 8, order = 7)
    public RString listChosaSukejuru_2;
    @ReportItem(name = "listChosaSukejuru_3", length = 40, order = 8)
    public RString listChosaSukejuru_3;
    @ReportItem(name = "listChosaSukejuru_4", length = 9, order = 9)
    public RString listChosaSukejuru_4;
    @ReportItem(name = "listChosaSukejuru_5", length = 11, order = 10)
    public RString listChosaSukejuru_5;
    @ReportItem(name = "listChosaSukejuru_6", length = 4, order = 11)
    public RString listChosaSukejuru_6;
    @ReportItem(name = "listChosaSukejuru_7", length = 10, order = 12)
    public RString listChosaSukejuru_7;
    @ReportItem(name = "listChosaSukejuru_8", length = 40, order = 13)
    public RString listChosaSukejuru_8;
    @ReportItem(name = "listChosaSukejuru_9", length = 40, order = 14)
    public RString listChosaSukejuru_9;
    @ReportItem(name = "listChosaSukejuru_10", length = 40, order = 15)
    public RString listChosaSukejuru_10;
    @ReportItem(name = "listChosaSukejuru_11", length = 40, order = 16)
    public RString listChosaSukejuru_11;
    @ReportItem(name = "listTel2_1", length = 13, order = 17)
    public RString listTel2_1;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
