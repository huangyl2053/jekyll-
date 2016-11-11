package jp.co.ndensan.reams.db.dbc.entity.report.sogojigyoshikakushogohyoin;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 帳票設計_DBC100099_総合事業費資格照合表Source
 *
 * @reamsid_L DBC-2890-032 wangxue
 */
public class SogojigyohiShikakuShogohyoInSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "shinsaYM", length = 8, order = 2)
    public RString shinsaYM;
    @ReportItem(name = "hokenshaNo", length = 6, order = 3)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 12, order = 4)
    public RString hokenshaName;
    @ReportItem(name = "listUpper_1", length = 4, order = 5)
    public RString listUpper_1;
    @ReportPerson(id = "A")
    public ShikibetsuCode shikibetsuCode;
    @ReportItem(name = "listUpper_2", length = 10, order = 6)
    public RString listUpper_2;
    @ReportItem(name = "listUpper_3", length = 8, order = 7)
    public RString listUpper_3;
    @ReportItem(name = "listUpper_4", length = 6, order = 8)
    public RString listUpper_4;
    @ReportItem(name = "listUpper_5", length = 2, order = 9)
    public RString listUpper_5;
    @ReportItem(name = "listUpper_6", length = 1, order = 10)
    public RString listUpper_6;
    @ReportItem(name = "listUpper_7", length = 10, order = 11)
    public RString listUpper_7;
    @ReportItem(name = "listUpper_8", length = 4, order = 12)
    public RString listUpper_8;
    @ReportItem(name = "listUpper_9", length = 9, order = 13)
    public RString listUpper_9;
    @ReportItem(name = "listUpper_10", length = 1, order = 14)
    public RString listUpper_10;
    @ReportItem(name = "listUpper_11", length = 9, order = 15)
    public RString listUpper_11;
    @ReportItem(name = "listUpper_12", length = 7, order = 16)
    public RString listUpper_12;
    @ReportItem(name = "listUpper_13", length = 1, order = 17)
    public RString listUpper_13;
    @ReportItem(name = "listUpper_14", length = 5, order = 18)
    public RString listUpper_14;
    @ReportItem(name = "listUpper_15", length = 3, order = 19)
    public RString listUpper_15;
    @ReportItem(name = "listUpper_16", length = 3, order = 20)
    public RString listUpper_16;
    @ReportItem(name = "listUpper_17", length = 3, order = 21)
    public RString listUpper_17;
    @ReportItem(name = "listUpper_18", length = 3, order = 22)
    public RString listUpper_18;
    @ReportItem(name = "listUpper_19", length = 2, order = 23)
    public RString listUpper_19;
    @ReportItem(name = "listUpper_20", length = 15, order = 24)
    public RString listUpper_20;
    @ReportItem(name = "listUpper_21", length = 15, order = 25)
    public RString listUpper_21;
    @ReportItem(name = "listLower_1", length = 10, order = 26)
    public RString listLower_1;
    @ReportItem(name = "listLower_2", length = 10, order = 27)
    public RString listLower_2;
    @ReportItem(name = "listLower_3", length = 12, order = 28)
    public RString listLower_3;
    @ReportItem(name = "listLower_4", length = 9, order = 29)
    public RString listLower_4;
    @ReportItem(name = "listLower_5", length = 1, order = 30)
    public RString listLower_5;
    @ReportItem(name = "listLower_6", length = 9, order = 31)
    public RString listLower_6;
    @ReportItem(name = "listLower_7", length = 10, order = 32)
    public RString listLower_7;
    @ReportItem(name = "gokeiKensuTitle", length = 4, order = 33)
    public RString gokeiKensuTitle;
    @ReportItem(name = "gokeiKensu", length = 8, order = 34)
    public RString gokeiKensu;
    @ReportExpandedInfo(id = "A")
    public ExpandedInformation expandedInformation;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>

    /**
     * SogojigyohiShikakuShogohyoInSourceのenum
     */
    public enum ReportSourceFields {

        printTimeStamp,
        pageCount,
        shinsaYM,
        hokenshaNo,
        hokenshaName,
        listUpper_1,
        listUpper_2,
        listUpper_3,
        listUpper_4,
        listUpper_5,
        listUpper_6,
        listUpper_7,
        listUpper_8,
        listUpper_9,
        listUpper_10,
        listUpper_11,
        listUpper_12,
        listUpper_13,
        listUpper_14,
        listUpper_15,
        listUpper_16,
        listUpper_17,
        listUpper_18,
        listUpper_19,
        listUpper_20,
        listUpper_21,
        listLower_1,
        listLower_2,
        listLower_3,
        listLower_4,
        listLower_5,
        listLower_6,
        listLower_7,
        gokeiKensuTitle,
        gokeiKensu
    }
}
