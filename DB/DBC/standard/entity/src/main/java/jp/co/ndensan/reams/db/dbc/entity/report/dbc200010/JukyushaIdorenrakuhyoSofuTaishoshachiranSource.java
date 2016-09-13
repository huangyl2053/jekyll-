package jp.co.ndensan.reams.db.dbc.entity.report.dbc200010;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 帳票設計_DBCMNF1001_1_受給者異動連絡票情報送付対象者リストのsource
 *
 * @reamsid_L DBC-2720-040 jiangxiaolong
 */
public class JukyushaIdorenrakuhyoSofuTaishoshachiranSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "title", length = 23, order = 2)
    public RString title;
    @ReportItem(name = "shichosonCd", length = 6, order = 3)
    public RString shichosonCd;
    @ReportItem(name = "shichosonName", length = 12, order = 4)
    public RString shichosonName;
    @ReportItem(name = "listTaishosha_1", length = 10, order = 5)
    public RString listTaishosha_1;
    @ReportItem(name = "listTaishosha_2", length = 7, order = 6)
    public RString listTaishosha_2;
    @ReportItem(name = "listTaishosha_3", length = 2, order = 7)
    public RString listTaishosha_3;
    @ReportItem(name = "listTaishosha_4", length = 10, order = 8)
    public RString listTaishosha_4;
    @ReportItem(name = "listTaishosha_5", length = 4, order = 9)
    public RString listTaishosha_5;
    @ReportItem(name = "listTaishosha_6", length = 10, order = 10)
    public RString listTaishosha_6;
    @ReportItem(name = "listTaishosha_7", length = 10, order = 11)
    public RString listTaishosha_7;
    @ReportItem(name = "listTaishosha_8", length = 46, order = 12)
    public RString listTaishosha_8;
    @ReportItem(name = "biko", length = 38, order = 13)
    public RString biko;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>

    /**
     * JukyushaIdorenrakuhyoSofuTaishoshachiranSourceのENUM
     */
    public enum ReportSourceFields {

        printTimeStamp,
        pageCount,
        title,
        shichosonCd,
        shichosonName,
        listTaishosha_1,
        listTaishosha_2,
        listTaishosha_3,
        listTaishosha_4,
        listTaishosha_5,
        listTaishosha_6,
        listTaishosha_7,
        listTaishosha_8,
        biko
    }
}
