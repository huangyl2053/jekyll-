/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.report.source.chosahoshuichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 認定調査報酬一覧表のReportSourceクラスです。
 *
 * @reamsid_L DBE-1940-030 jinjue
 */
public class ChosahoshuichiranReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "chosaHoshuSakuseiYM", length = 10, order = 1)
    public RString chosaHoshuSakuseiYM;
    @ReportItem(name = "chushutsuKikan", length = 19, order = 2)
    public RString chushutsuKikan;
    @ReportItem(name = "chosaItakusakiNo", length = 12, order = 3)
    public RString chosaItakusakiNo;
    @ReportItem(name = "chosaItakusakiName", length = 40, order = 4)
    public RString chosaItakusakiName;
    @ReportItem(name = "printTimeStamp", length = 34, order = 5)
    public RString printTimeStamp;
    @ReportItem(name = "listchosasakuseiryo_1", length = 3, order = 6)
    public RString listchosasakuseiryo_1;
    @ReportItem(name = "listchosasakuseiryo_2", length = 8, order = 7)
    public RString listchosasakuseiryo_2;
    @ReportItem(name = "listchosasakuseiryo_3", length = 20, order = 8)
    public RString listchosasakuseiryo_3;
    @ReportItem(name = "listchosasakuseiryo_4", length = 9, order = 9)
    public RString listchosasakuseiryo_4;
    @ReportItem(name = "listchosasakuseiryo_5", length = 9, order = 10)
    public RString listchosasakuseiryo_5;
    @ReportItem(name = "listchosasakuseiryo_6", length = 9, order = 11)
    public RString listchosasakuseiryo_6;
    @ReportItem(name = "listchosasakuseiryo_7", length = 1, order = 12)
    public RString listchosasakuseiryo_7;
    @ReportItem(name = "listchosasakuseiryo_8", length = 6, order = 13)
    public RString listchosasakuseiryo_8;
    @ReportItem(name = "listchosasakuseiryo_9", length = 10, order = 14)
    public RString listchosasakuseiryo_9;
    @ReportItem(name = "listchosasakuseiryo_10", length = 30, order = 15)
    public RString listchosasakuseiryo_10;
    @ReportItem(name = "listchosasakuseiryo_11", length = 1, order = 16)
    public RString listchosasakuseiryo_11;
    @ReportItem(name = "listchosasakuseiryo_12", length = 1, order = 17)
    public RString listchosasakuseiryo_12;
    @ReportItem(name = "listchosasakuseiryo_13", length = 1, order = 18)
    public RString listchosasakuseiryo_13;
    @ReportItem(name = "listchosasakuseiryo_14", length = 1, order = 19)
    public RString listchosasakuseiryo_14;
    @ReportItem(name = "listchosasakuseiryo_15", length = 7, order = 20)
    public RString listchosasakuseiryo_15;
    @ReportItem(name = "listGokei_1", length = 4, order = 21)
    public RString listGokei_1;
    @ReportItem(name = "listGokei_2", length = 4, order = 22)
    public RString listGokei_2;
    @ReportItem(name = "listGokei_3", length = 4, order = 23)
    public RString listGokei_3;
    @ReportItem(name = "listGokei_4", length = 4, order = 24)
    public RString listGokei_4;
    @ReportItem(name = "listGokei_5", length = 11, order = 25)
    public RString listGokei_5;
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

        chosaItakusakiNo,
    }
}
