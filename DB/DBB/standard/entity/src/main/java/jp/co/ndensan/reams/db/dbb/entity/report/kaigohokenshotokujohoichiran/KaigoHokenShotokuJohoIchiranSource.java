/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.report.kaigohokenshotokujohoichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 帳票設計_DBBPR51003_介護保険所得情報一覧表のSource
 *
 * @reamsid_L DBB-1650-060 lijunjun
 */
public class KaigoHokenShotokuJohoIchiranSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "cityCode", length = 6, order = 2)
    public RString cityCode;
    @ReportItem(name = "cityName", length = 20, order = 3)
    public RString cityName;
    @ReportItem(name = "sort1", length = 10, order = 4)
    public RString sort1;
    @ReportItem(name = "sort2", length = 10, order = 5)
    public RString sort2;
    @ReportItem(name = "sort3", length = 10, order = 6)
    public RString sort3;
    @ReportItem(name = "sort4", length = 10, order = 7)
    public RString sort4;
    @ReportItem(name = "sort5", length = 10, order = 8)
    public RString sort5;
    @ReportItem(name = "page1", length = 20, order = 9)
    public RString page1;
    @ReportItem(name = "page2", length = 20, order = 10)
    public RString page2;
    @ReportItem(name = "page4", length = 20, order = 11)
    public RString page4;
    @ReportItem(name = "page5", length = 20, order = 12)
    public RString page5;
    @ReportItem(name = "page3", length = 20, order = 13)
    public RString page3;
    @ReportItem(name = "kazeiKubun", length = 7, order = 14)
    public RString kazeiKubun;
    @ReportItem(name = "kazeiKubunGemmenMae", length = 3, order = 15)
    public RString kazeiKubunGemmenMae;
    @ReportItem(name = "kazeiKubunGemmenGo", length = 3, order = 16)
    public RString kazeiKubunGemmenGo;
    @ReportItem(name = "listIchiranhyoUpper_1", length = 6, order = 17)
    public RString listIchiranhyoUpper_1;
    @ReportItem(name = "listIchiranhyoUpper_2", length = 15, order = 18)
    public RString listIchiranhyoUpper_2;
    @ReportItem(name = "listIchiranhyoUpper_3", length = 25, order = 19)
    public RString listIchiranhyoUpper_3;
    @ReportItem(name = "listIchiranhyoUpper_4", length = 6, order = 20)
    public RString listIchiranhyoUpper_4;
    @ReportItem(name = "listIchiranhyoUpper_5", length = 9, order = 21)
    public RString listIchiranhyoUpper_5;
    @ReportItem(name = "listIchiranhyoUpper_6", length = 1, order = 22)
    public RString listIchiranhyoUpper_6;
    @ReportItem(name = "listIchiranhyoUpper_7", length = 3, order = 23)
    public RString listIchiranhyoUpper_7;
    @ReportItem(name = "listIchiranhyoUpper_8", length = 3, order = 24)
    public RString listIchiranhyoUpper_8;
    @ReportItem(name = "listIchiranhyoUpper_9", length = 9, order = 25)
    public RString listIchiranhyoUpper_9;
    @ReportItem(name = "listIchiranhyoUpper_10", length = 9, order = 26)
    public RString listIchiranhyoUpper_10;
    @ReportItem(name = "listIchiranhyoUpper_11", length = 3, order = 27)
    public RString listIchiranhyoUpper_11;
    @ReportItem(name = "listIchiranhyoLower_1", length = 10, order = 28)
    public RString listIchiranhyoLower_1;
    @ReportItem(name = "listIchiranhyoLower_2", length = 10, order = 29)
    public RString listIchiranhyoLower_2;
    @ReportItem(name = "listIchiranhyoLower_3", length = 2, order = 30)
    public RString listIchiranhyoLower_3;
    @ReportItem(name = "listIchiranhyoLower_4", length = 3, order = 31)
    public RString listIchiranhyoLower_4;
    @ReportItem(name = "listIchiranhyoLower_5", length = 9, order = 32)
    public RString listIchiranhyoLower_5;
    @ReportItem(name = "listIchiranhyoLower_6", length = 9, order = 33)
    public RString listIchiranhyoLower_6;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。

    /**
     * KaigoHokenShotokuJohoIchiranSourceFields
     */
    public enum KaigoHoken {

        printTimeStamp,
        cityCode,
        cityName,
        sort1,
        sort2,
        sort3,
        sort4,
        sort5,
        page1,
        page2,
        page4,
        page5,
        page3,
        kazeiKubun,
        kazeiKubunGemmenMae,
        kazeiKubunGemmenGo,
        listIchiranhyoUpper_1,
        listIchiranhyoUpper_2,
        listIchiranhyoUpper_3,
        listIchiranhyoUpper_4,
        listIchiranhyoUpper_5,
        listIchiranhyoUpper_6,
        listIchiranhyoUpper_7,
        listIchiranhyoUpper_8,
        listIchiranhyoUpper_9,
        listIchiranhyoUpper_10,
        listIchiranhyoUpper_11,
        listIchiranhyoLower_1,
        listIchiranhyoLower_2,
        listIchiranhyoLower_3,
        listIchiranhyoLower_4,
        listIchiranhyoLower_5,
        listIchiranhyoLower_6
    }
// </editor-fold>
}
