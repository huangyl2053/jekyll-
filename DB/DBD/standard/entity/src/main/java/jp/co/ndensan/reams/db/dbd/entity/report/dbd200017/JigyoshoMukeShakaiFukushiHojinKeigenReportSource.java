/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.report.dbd200017;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 事業所向け社会福祉法人軽減対象者一覧表ReportSourceです。
 *
 * @reamsid_L DBD-3810-040 donghj
 */
public class JigyoshoMukeShakaiFukushiHojinKeigenReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "jigyoshaCd", length = 10, order = 2)
    public RString jigyoshaCd;
    @ReportItem(name = "jigyoshaName", length = 20, order = 3)
    public RString jigyoshaName;
    @ReportItem(name = "yubinNo", length = 8, order = 4)
    public RString yubinNo;
    @ReportItem(name = "jusho", length = 20, order = 5)
    public RString jusho;
    @ReportItem(name = "telNo", length = 14, order = 6)
    public RString telNo;
    @ReportItem(name = "hokenshaName", length = 12, order = 7)
    public RString hokenshaName;
    @ReportItem(name = "hokenshaNo", length = 6, order = 8)
    public RString hokenshaNo;
    @ReportItem(name = "shutsuryokujun1", length = 7, order = 9)
    public RString shutsuryokujun1;
    @ReportItem(name = "shutsuryokujun2", length = 7, order = 10)
    public RString shutsuryokujun2;
    @ReportItem(name = "shutsuryokujun3", length = 7, order = 11)
    public RString shutsuryokujun3;
    @ReportItem(name = "shutsuryokujun4", length = 7, order = 12)
    public RString shutsuryokujun4;
    @ReportItem(name = "shutsuryokujun5", length = 7, order = 13)
    public RString shutsuryokujun5;
    @ReportItem(name = "kaiPege1", length = 12, order = 14)
    public RString kaiPege1;
    @ReportItem(name = "kaiPege2", length = 12, order = 15)
    public RString kaiPege2;
    @ReportItem(name = "kaiPege3", length = 12, order = 16)
    public RString kaiPege3;
    @ReportItem(name = "kaiPege4", length = 12, order = 17)
    public RString kaiPege4;
    @ReportItem(name = "kaiPege5", length = 12, order = 18)
    public RString kaiPege5;
    @ReportItem(name = "page5", length = 6, order = 19)
    public RString page5;
    @ReportItem(name = "listShohokenshaNo_1", length = 6, order = 20)
    public RString listShohokenshaNo_1;
    @ReportItem(name = "listHihokenshaNameKana_1", length = 20, order = 21)
    public RString listHihokenshaNameKana_1;
    @ReportItem(name = "listMeisai_1", length = 4, order = 22)
    public RString listMeisai_1;
    @ReportItem(name = "listMeisai_2", length = 10, order = 23)
    @ReportExpandedInfo(id = "A", code = "0003", name = "被保険者番号")
    public RString listMeisai_2;
    @ReportItem(name = "listMeisai_3", length = 10, order = 24)
    public RString listMeisai_3;
    @ReportItem(name = "listMeisai_4", length = 1, order = 25)
    public RString listMeisai_4;
    @ReportItem(name = "listMeisai_5", length = 4, order = 26)
    public RString listMeisai_5;
    @ReportItem(name = "listMeisai_6", length = 10, order = 27)
    public RString listMeisai_6;
    @ReportItem(name = "listMeisai_7", length = 9, order = 28)
    public RString listMeisai_7;
    @ReportItem(name = "listMeisai_8", length = 9, order = 29)
    public RString listMeisai_8;
    @ReportItem(name = "listMeisai_9", length = 3, order = 30)
    public RString listMeisai_9;
    @ReportItem(name = "listShohokenshaName_1", length = 9, order = 31)
    public RString listShohokenshaName_1;
    @ReportItem(name = "listHihokenshaName_1", length = 10, order = 32)
    public RString listHihokenshaName_1;
    @ReportItem(name = "pagecnt", length = 6, order = 33)
    public RString pagecnt;
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

        jigyoshaCd,
        hokenshaNo
    }
}
