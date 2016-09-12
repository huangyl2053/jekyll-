package jp.co.ndensan.reams.db.dbc.entity.report.source.kyufukanrihyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 給付管理票取込結果一覧表Source
 *
 * @reamsid_L DBC-2450-040 zhangrui
 */
public class KyufuKanrihyoTorikomiKekkaIchiranSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "torikomiYM", length = 8, order = 2)
    public RString torikomiYM;
    @ReportItem(name = "hokenshaNo", length = 6, order = 3)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 12, order = 4)
    public RString hokenshaName;
    @ReportItem(name = "shutsuryokujun1", length = 10, order = 5)
    public RString shutsuryokujun1;
    @ReportItem(name = "shutsuryokujun2", length = 10, order = 6)
    public RString shutsuryokujun2;
    @ReportItem(name = "shutsuryokujun3", length = 10, order = 7)
    public RString shutsuryokujun3;
    @ReportItem(name = "shutsuryokujun4", length = 10, order = 8)
    public RString shutsuryokujun4;
    @ReportItem(name = "shutsuryokujun5", length = 10, order = 9)
    public RString shutsuryokujun5;
    @ReportItem(name = "kaiPege1", length = 20, order = 10)
    public RString kaiPege1;
    @ReportItem(name = "kaiPege2", length = 20, order = 11)
    public RString kaiPege2;
    @ReportItem(name = "kaiPege3", length = 20, order = 12)
    public RString kaiPege3;
    @ReportItem(name = "kaiPege4", length = 20, order = 13)
    public RString kaiPege4;
    @ReportItem(name = "kaiPege5", length = 20, order = 14)
    public RString kaiPege5;
    @ReportItem(name = "bikoTitle", length = 10, order = 15)
    public RString bikoTitle;
    @ReportItem(name = "listCenter_1", length = 4, order = 16)
    public RString listCenter_1;
    @ReportItem(name = "listCenter_2", length = 6, order = 17)
    public RString listCenter_2;
    @ReportItem(name = "listCenter_3", length = 2, order = 18)
    public RString listCenter_3;
    @ReportItem(name = "listCenter_4", length = 10, order = 19)
    public RString listCenter_4;
    @ReportItem(name = "listCenter_5", length = 2, order = 20)
    public RString listCenter_5;
    @ReportItem(name = "listCenter_6", length = 4, order = 21)
    public RString listCenter_6;
    @ReportItem(name = "listCenter_7", length = 6, order = 22)
    public RString listCenter_7;
    @ReportItem(name = "listCenter_8", length = 1, order = 23)
    public RString listCenter_8;
    @ReportItem(name = "listCenter_9", length = 6, order = 24)
    public RString listCenter_9;
    @ReportItem(name = "listCenter_10", length = 10, order = 25)
    public RString listCenter_10;
    @ReportItem(name = "listCenter_11", length = 9, order = 26)
    public RString listCenter_11;
    @ReportItem(name = "listCenter_12", length = 9, order = 27)
    public RString listCenter_12;
    @ReportItem(name = "listCenter_13", length = 9, order = 28)
    public RString listCenter_13;
    @ReportItem(name = "listUpper_1", length = 10, order = 29)
    public RString listUpper_1;
    @ReportItem(name = "listUpper_2", length = 4, order = 30)
    public RString listUpper_2;
    @ReportItem(name = "listUpper_3", length = 10, order = 31)
    public RString listUpper_3;
    @ReportItem(name = "listUpper_4", length = 8, order = 32)
    public RString listUpper_4;
    @ReportItem(name = "listLower_1", length = 15, order = 33)
    public RString listLower_1;
    @ReportItem(name = "listLower_2", length = 10, order = 34)
    public RString listLower_2;
    @ReportItem(name = "listLower_3", length = 6, order = 35)
    public RString listLower_3;
    @ReportItem(name = "kensu1Title", length = 4, order = 36)
    public RString kensu1Title;
    @ReportItem(name = "kensu1", length = 7, order = 37)
    public RString kensu1;
    @ReportItem(name = "kensu2Title", length = 4, order = 38)
    public RString kensu2Title;
    @ReportItem(name = "kensu2", length = 7, order = 39)
    public RString kensu2;
    @ReportItem(name = "kensu3Title", length = 2, order = 40)
    public RString kensu3Title;
    @ReportItem(name = "kensu3", length = 7, order = 41)
    public RString kensu3;
    @ReportItem(name = "gokeiKensuTitle", length = 2, order = 42)
    public RString gokeiKensuTitle;
    @ReportItem(name = "gokeiKensu", length = 7, order = 43)
    public RString gokeiKensu;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>

    /**
     * TokubetsuChoshuKaishiSourceのenum
     */
    public enum DBC200073SourceFields {

        printTimeStamp,
        torikomiYM,
        hokenshaNo,
        hokenshaName,
        shutsuryokujun1,
        shutsuryokujun2,
        shutsuryokujun3,
        shutsuryokujun4,
        shutsuryokujun5,
        kaiPege1,
        kaiPege2,
        kaiPege3,
        kaiPege4,
        kaiPege5,
        bikoTitle,
        listCenter_1,
        listCenter_2,
        listCenter_3,
        listCenter_4,
        listCenter_5,
        listCenter_6,
        listCenter_7,
        listCenter_8,
        listCenter_9,
        listCenter_10,
        listCenter_11,
        listCenter_12,
        listCenter_13,
        listUpper_1,
        listUpper_2,
        listUpper_3,
        listUpper_4,
        listLower_1,
        listLower_2,
        listLower_3,
        kensu1Title,
        kensu1,
        kensu2Title,
        kensu2,
        kensu3Title,
        kensu3,
        gokeiKensuTitle,
        gokeiKensu
    }

}
