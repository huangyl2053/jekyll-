/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.report.source;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 主治医医療機関・主治医一覧表Sourceクラスです。
 *
 * @reamsid_L DBE-0260-020 zuotao
 */
public class ShujiiIryokikanShujiiIchiranhyoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "iryoKikanCode", length = 21, order = 2)
    public RString iryoKikanCode;
    @ReportItem(name = "title", length = 50, order = 3)
    public RString title;
    @ReportItem(name = "shujiiCode", length = 17, order = 4)
    public RString shujiiCode;
    @ReportItem(name = "shujiiJokyo", length = 9, order = 5)
    public RString shujiiJokyo;
    @ReportItem(name = "dataShubetsu", length = 10, order = 6)
    public RString dataShubetsu;
    @ReportItem(name = "cityCode", length = 6, order = 7)
    public RString cityCode;
    @ReportItem(name = "cityName", length = 20, order = 8)
    public RString cityName;
    @ReportItem(name = "sort1", length = 10, order = 9)
    public RString sort1;
    @ReportItem(name = "sort2", length = 10, order = 10)
    public RString sort2;
    @ReportItem(name = "sort3", length = 10, order = 11)
    public RString sort3;
    @ReportItem(name = "sort4", length = 10, order = 12)
    public RString sort4;
    @ReportItem(name = "sort5", length = 10, order = 13)
    public RString sort5;
    @ReportItem(name = "page1", length = 20, order = 14)
    public RString page1;
    @ReportItem(name = "page2", length = 20, order = 15)
    public RString page2;
    @ReportItem(name = "page4", length = 20, order = 16)
    public RString page4;
    @ReportItem(name = "page5", length = 20, order = 17)
    public RString page5;
    @ReportItem(name = "page3", length = 20, order = 18)
    public RString page3;
    @ReportItem(name = "listIchiranhyoUpper_1", length = 10, order = 19)
    public RString listIchiranhyoUpper_1;
    @ReportItem(name = "listIchiranhyoUpper_2", length = 40, order = 20)
    public RString listIchiranhyoUpper_2;
    @ReportItem(name = "listIchiranhyoUpper_3", length = 20, order = 21)
    public RString listIchiranhyoUpper_3;
    @ReportItem(name = "listIchiranhyoUpper_4", length = 8, order = 22)
    public RString listIchiranhyoUpper_4;
    @ReportItem(name = "listIchiranhyoUpper_5", length = 15, order = 23)
    public RString listIchiranhyoUpper_5;
    @ReportItem(name = "listIchiranhyoUpper_6", length = 2, order = 24)
    public RString listIchiranhyoUpper_6;
    @ReportItem(name = "listIchiranhyoUpper_7", length = 8, order = 25)
    public RString listIchiranhyoUpper_7;
    @ReportItem(name = "listIchiranhyoUpper_8", length = 20, order = 26)
    public RString listIchiranhyoUpper_8;
    @ReportItem(name = "listIchiranhyoUpper_9", length = 1, order = 27)
    public RString listIchiranhyoUpper_9;
    @ReportItem(name = "listIchiranhyoUpper_10", length = 2, order = 28)
    public RString listIchiranhyoUpper_10;
    @ReportItem(name = "listIchiranhyoLower1_1", length = 20, order = 29)
    public RString listIchiranhyoLower1_1;
    @ReportItem(name = "listIchiranhyoLower1_2", length = 10, order = 30)
    public RString listIchiranhyoLower1_2;
    @ReportItem(name = "listIchiranhyoLower1_3", length = 14, order = 31)
    public RString listIchiranhyoLower1_3;
    @ReportItem(name = "listIchiranhyoLower2_1", length = 10, order = 32)
    public RString listIchiranhyoLower2_1;
    @ReportItem(name = "listIchiranhyoLower2_2", length = 12, order = 33)
    public RString listIchiranhyoLower2_2;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>

    /**
     * 主治医医療機関・主治医一覧表の改ページ項目です。
     */
    public enum ReportSourceFields {

        cityCode,
        listIchiranhyoUpper_1;
    }
}
