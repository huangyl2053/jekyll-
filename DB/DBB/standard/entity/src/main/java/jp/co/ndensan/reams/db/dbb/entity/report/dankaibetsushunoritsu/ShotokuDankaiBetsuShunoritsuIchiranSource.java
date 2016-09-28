// TODO: 業務に合わせてパスを変更してください
package jp.co.ndensan.reams.db.dbb.entity.report.dankaibetsushunoritsu;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 帳票設計_DBB300003_保険料段階別収納率一覧表作成のsource
 *
 * @reamsid_L DBB-1630-040 tianshuai
 */
public class ShotokuDankaiBetsuShunoritsuIchiranSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "choshu", length = 10, order = 2)
    public RString choshu;
    @ReportItem(name = "hokenshaNo", length = 6, order = 3)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 12, order = 4)
    public RString hokenshaName;
    @ReportItem(name = "shichosonCode", length = 6, order = 5)
    public RString shichosonCode;
    @ReportItem(name = "shichosonName", length = 12, order = 6)
    public RString shichosonName;
    @ReportItem(name = "list_1", length = 7, order = 7)
    public RString list_1;
    @ReportItem(name = "list_2", length = 3, order = 8)
    public RString list_2;
    @ReportItem(name = "list_3", length = 4, order = 9)
    public RString list_3;
    @ReportItem(name = "list_4", length = 7, order = 10)
    public RString list_4;
    @ReportItem(name = "list_5", length = 15, order = 11)
    public RString list_5;
    @ReportItem(name = "list_6", length = 7, order = 12)
    public RString list_6;
    @ReportItem(name = "list_7", length = 15, order = 13)
    public RString list_7;
    @ReportItem(name = "list_8", length = 15, order = 14)
    public RString list_8;
    @ReportItem(name = "list_9", length = 7, order = 15)
    public RString list_9;
    @ReportItem(name = "list_10", length = 15, order = 16)
    public RString list_10;
    @ReportItem(name = "list_11", length = 7, order = 17)
    public RString list_11;
    @ReportItem(name = "list_12", length = 15, order = 18)
    public RString list_12;
    @ReportItem(name = "list_13", length = 7, order = 19)
    public RString list_13;
    @ReportItem(name = "list_14", length = 15, order = 20)
    public RString list_14;
    @ReportItem(name = "list_15", length = 7, order = 21)
    public RString list_15;
    @ReportItem(name = "list_16", length = 15, order = 22)
    public RString list_16;
    @ReportItem(name = "list_17", length = 6, order = 23)
    public RString list_17;
    @ReportItem(name = "list_18", length = 6, order = 24)
    public RString kamokuCode;
    @ReportItem(name = "isPageBreaker", length = 6, order = 25)
    public RString isPageBreaker;
    @ReportItem(name = "hdn_list_1", length = 7, order = 26)
    public RString hdn_list_1;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>

    /**
     * ShotokuDankaiBetsuShunoritsuIchiranSourceのenum
     */
    public enum ReportSourceFields {

        printTimeStamp,
        choshu,
        hokenshaNo,
        hokenshaName,
        shichosonCode,
        shichosonName,
        list_1,
        list_2,
        list_3,
        list_4,
        list_5,
        list_6,
        list_7,
        list_8,
        list_9,
        list_10,
        list_11,
        list_12,
        list_13,
        list_14,
        list_15,
        list_16,
        list_17,
        KamokuCode,
        isPageBreaker,
        hdn_list_1
    }
}
