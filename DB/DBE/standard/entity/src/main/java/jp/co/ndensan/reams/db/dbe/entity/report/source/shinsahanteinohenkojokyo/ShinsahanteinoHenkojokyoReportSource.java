package jp.co.ndensan.reams.db.dbe.entity.report.source.shinsahanteinohenkojokyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 審査判定の変更状況のReportSourceクラスです。
 *
 * @reamsid_L DBE-1450-060 dongyabin
 */
public class ShinsahanteinoHenkojokyoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 30, order = 1)
    public RString title;
    @ReportItem(name = "shichosonNo", length = 6, order = 2)
    public RString shichosonNo;
    @ReportItem(name = "gogitaiName", length = 20, order = 3)
    public RString gogitaiName;
    @ReportItem(name = "shinsakaiStartYMD", length = 11, order = 4)
    public RString shinsakaiStartYMD;
    @ReportItem(name = "shinsakaiEndYMD", length = 11, order = 5)
    public RString shinsakaiEndYMD;
    @ReportItem(name = "shichosonName", length = 7, order = 6)
    public RString shichosonName;
    @ReportItem(name = "shinsakaiKaisaiKaisu", length = 3, order = 7)
    public RString shinsakaiKaisaiKaisu;
    @ReportItem(name = "printTimeStamp", length = 34, order = 8)
    public RString printTimeStamp;
    @ReportItem(name = "listKoshinkensu_1", length = 5, order = 9)
    public RString listKoshinkensu_1;
    @ReportItem(name = "listKoshinkensu_2", length = 5, order = 10)
    public RString listKoshinkensu_2;
    @ReportItem(name = "listKoshinkensu_3", length = 5, order = 11)
    public RString listKoshinkensu_3;
    @ReportItem(name = "listKoshinkensu_4", length = 5, order = 12)
    public RString listKoshinkensu_4;
    @ReportItem(name = "listKoshinkensu_5", length = 6, order = 13)
    public RString listKoshinkensu_5;
    @ReportItem(name = "listKoshinkensu_6", length = 6, order = 14)
    public RString listKoshinkensu_6;
    @ReportItem(name = "listKoshinkensu_7", length = 6, order = 15)
    public RString listKoshinkensu_7;
    @ReportItem(name = "listKoshinkensu_8", length = 6, order = 16)
    public RString listKoshinkensu_8;
    @ReportItem(name = "listKoshinkensu_9", length = 6, order = 17)
    public RString listKoshinkensu_9;
    @ReportItem(name = "listShinkikuhenkensu_1", length = 5, order = 18)
    public RString listShinkikuhenkensu_1;
    @ReportItem(name = "listShinkikuhenkensu_2", length = 5, order = 19)
    public RString listShinkikuhenkensu_2;
    @ReportItem(name = "listShinkikuhenkensu_3", length = 5, order = 20)
    public RString listShinkikuhenkensu_3;
    @ReportItem(name = "listShinkikuhenkensu_4", length = 5, order = 21)
    public RString listShinkikuhenkensu_4;
    @ReportItem(name = "listShinkikuhenkensu_5", length = 6, order = 22)
    public RString listShinkikuhenkensu_5;
    @ReportItem(name = "listShinkikuhenkensu_6", length = 6, order = 23)
    public RString listShinkikuhenkensu_6;
    @ReportItem(name = "listShinkikuhenkensu_7", length = 6, order = 24)
    public RString listShinkikuhenkensu_7;
    @ReportItem(name = "listShinkikuhenkensu_8", length = 6, order = 25)
    public RString listShinkikuhenkensu_8;
    @ReportItem(name = "listShinkikuhenkensu_9", length = 6, order = 26)
    public RString listShinkikuhenkensu_9;
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

        gogitaiName,
        shichosonNo,

    }
}
