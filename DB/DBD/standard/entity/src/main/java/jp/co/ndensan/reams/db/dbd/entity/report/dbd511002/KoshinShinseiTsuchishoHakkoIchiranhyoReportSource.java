/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.report.dbd511002;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 更新申請のお知らせ通知書発行一覧表ReportSourceです。
 *
 * @reamsid_L DBD-2030-040 donghj
 */
public class KoshinShinseiTsuchishoHakkoIchiranhyoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "taishoKikan", length = 23, order = 1)
    public RString taishoKikan;
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
    @ReportItem(name = "printTimeStamp", length = 34, order = 9)
    public RString printTimeStamp;
    @ReportItem(name = "listHakkoIchiranhyo_1", length = 4, order = 10)
    public RString listHakkoIchiranhyo_1;
    @ReportItem(name = "listHakkoIchiranhyo_2", length = 10, order = 11)
    @ReportExpandedInfo(id = "001", code = "0003", name = "被保険者番号")
    public RString listHakkoIchiranhyo_2;
    @ReportItem(name = "listHakkoIchiranhyo_3", length = 10, order = 12)
    public RString listHakkoIchiranhyo_3;
    @ReportItem(name = "listHakkoIchiranhyo_4", length = 4, order = 13)
    public RString listHakkoIchiranhyo_4;
    @ReportItem(name = "listHakkoIchiranhyo_5", length = 9, order = 14)
    public RString listHakkoIchiranhyo_5;
    @ReportItem(name = "listHakkoIchiranhyo_6", length = 9, order = 15)
    public RString listHakkoIchiranhyo_6;
    @ReportItem(name = "listHakkoIchiranhyo_7", length = 9, order = 16)
    public RString listHakkoIchiranhyo_7;
    @ReportItem(name = "listHakkoIchiranhyo_8", length = 9, order = 17)
    public RString listHakkoIchiranhyo_8;
    @ReportItem(name = "listHakkoIchiranhyo_9", length = 6, order = 18)
    public RString listHakkoIchiranhyo_9;
    @ReportItem(name = "listHakkoIchiranhyo_10", length = 2, order = 19)
    public RString listHakkoIchiranhyo_10;
    @ReportItem(name = "listHakkoIchiranhyo_11", length = 2, order = 20)
    public RString listHakkoIchiranhyo_11;
    @ReportItem(name = "listHakkoIchiranhyo_12", length = 10, order = 21)
    public RString listHakkoIchiranhyo_12;
    @ReportItem(name = "listHakkoIchiranhyo_13", length = 10, order = 22)
    public RString listHakkoIchiranhyo_13;
    @ReportItem(name = "listHakkoIchiranhyo_14", length = 10, order = 23)
    public RString listHakkoIchiranhyo_14;
    @ReportItem(name = "listHakkoIchiranhyo_15", length = 10, order = 24)
    public RString listHakkoIchiranhyo_15;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
    public static final RString 改頁_市町村コード;

    static {
        改頁_市町村コード = new RString("cityCode");
    }
// </editor-fold>
}
