package jp.co.ndensan.reams.db.dbc.entity.report.sogojigyohishikakushogohyokeikasochi;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 総合事業費（経過措置）資格照合表情報取込Sourceクラスです。
 *
 * @reamsid_L DBC-2890-031 wangxingpeng
 */
public class SogojigyohiShikakuShogohyoKeikaSochiSource implements IReportSource {
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
    @ReportItem(name = "listUpper_2", length = 10, order = 6)
    public RString listUpper_2;
    @ReportItem(name = "listUpper_3", length = 8, order = 7)
    public RString listUpper_3;
    @ReportItem(name = "listUpper_4", length = 2, order = 8)
    public RString listUpper_4;
    @ReportItem(name = "listUpper_5", length = 15, order = 9)
    public RString listUpper_5;
    @ReportItem(name = "listUpper_6", length = 6, order = 10)
    public RString listUpper_6;
    @ReportItem(name = "listUpper_7", length = 1, order = 11)
    public RString listUpper_7;
    @ReportItem(name = "listUpper_8", length = 10, order = 12)
    public RString listUpper_8;
    @ReportItem(name = "listUpper_9", length = 15, order = 13)
    public RString listUpper_9;
    @ReportItem(name = "listUpper_10", length = 4, order = 14)
    public RString listUpper_10;
    @ReportItem(name = "listUpper_11", length = 9, order = 15)
    public RString listUpper_11;
    @ReportItem(name = "listUpper_12", length = 1, order = 16)
    public RString listUpper_12;
    @ReportItem(name = "listUpper_13", length = 9, order = 17)
    public RString listUpper_13;
    @ReportItem(name = "listUpper_14", length = 2, order = 18)
    public RString listUpper_14;
    @ReportItem(name = "listUpper_15", length = 15, order = 19)
    public RString listUpper_15;
    @ReportItem(name = "listUpper_16", length = 15, order = 20)
    public RString listUpper_16;
    @ReportItem(name = "listLower_1", length = 12, order = 21)
    public RString listLower_1;
    @ReportItem(name = "gokeiKensuTitle", length = 4, order = 22)
    public RString gokeiKensuTitle;
    @ReportItem(name = "gokeiKensu", length = 8, order = 23)
    public RString gokeiKensu;
    @ReportPerson(id = "A")
    @ReportItem(name = "shikibetsuCode", length = 15)
    public RString shikibetsuCode;
    @ReportExpandedInfo(id = "A")
    public ExpandedInformation expandedInformation;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>

    /**
     * SogojigyohiShikakuShogohyoKeikaSochiSourceのenum
     */
    public enum ReportSourceFields {

        printTimeStamp,
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
        listLower_1,
        gokeiKensuTitle,
        gokeiKensu

    }
}
