package jp.co.ndensan.reams.db.dbe.entity.report.source.jimukyokuyoyobihanteikinyuhyo;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 事務局用予備判定記入表Sourceクラスです。
 *
 * @reamsid_L DBE-0150-100 wangrenze
 */
public class JimukyokuyoYobihanteiKinyuhyoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "shinsakaiKaisaiNo", length = 4, order = 1)
    public RString shinsakaiKaisaiNo;
    @ReportItem(name = "kaisaiYMD", length = 14, order = 2)
    public RString kaisaiYMD;
    @ReportItem(name = "kaisaiHH", length = 2, order = 3)
    public RString kaisaiHH;
    @ReportItem(name = "kaisaiMM", length = 2, order = 4)
    public RString kaisaiMM;
    @ReportItem(name = "gogitaiName", length = 20, order = 5)
    public RString gogitaiName;
    @ReportItem(name = "printTimeStamp", length = 34, order = 6)
    public RString printTimeStamp;
    @ReportItem(name = "listTokuteiShippeiCode_1", length = 2, order = 7)
    public RString listTokuteiShippeiCode_1;
    @ReportItem(name = "listHokenshaName_1", length = 10, order = 8)
    public RString listHokenshaName_1;
    @ReportItem(name = "listNo_1", length = 3, order = 9)
    public RString listNo_1;
    @ReportItem(name = "listTaishoshaIchiran_1", length = 10, order = 10)
    public RString listTaishoshaIchiran_1;
    @ReportItem(name = "listTaishoshaIchiran_2", length = 200, order = 11)
    public RString listTaishoshaIchiran_2;
    @ReportItem(name = "listTaishoshaIchiran_3", length = 1, order = 12)
    public RString listTaishoshaIchiran_3;
    @ReportItem(name = "listTaishoshaIchiran_4", length = 3, order = 13)
    public RString listTaishoshaIchiran_4;
    @ReportItem(name = "listTaishoshaIchiran_5", length = 6, order = 14)
    public RString listTaishoshaIchiran_5;
    @ReportItem(name = "listTaishoshaIchiran_6", length = 5, order = 15)
    public RString listTaishoshaIchiran_6;
    @ReportItem(name = "listTaishoshaIchiran_7", length = 6, order = 16)
    public RString listTaishoshaIchiran_7;
    @ReportItem(name = "listTaishoshaIchiran_8", length = 6, order = 17)
    public RString listTaishoshaIchiran_8;
    @ReportItem(name = "listTaishoshaIchiran_9", length = 2, order = 18)
    public RString listTaishoshaIchiran_9;
    @ReportItem(name = "listTaishoshaIchiran_10", length = 5, order = 19)
    public RString listTaishoshaIchiran_10;
    @ReportItem(name = "listIchijihanteiKeikokuCode_1", length = 2, order = 20)
    public RString listIchijihanteiKeikokuCode_1;
    @ReportItem(name = "listTokuteiShippeiName_1", length = 35, order = 21)
    public RString listTokuteiShippeiName_1;
    @ReportItem(name = "listShinseiKubun_1", length = 6, order = 22)
    public RString listShinseiKubun_1;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
    @ReportPerson(id = "A")
    public ShikibetsuCode shikibetuCode;
    @ReportExpandedInfo(id = "A")
    public ExpandedInformation hishokenshaNo;

    /**
     * 改ページ条件のキーです。
     */
    public enum ReportSourceFields {

        shinsakaiKaisaiNo,
    }
}
