package jp.co.ndensan.reams.db.dbc.entity.report.source.kyufukanrihyosofuichiran;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 帳票設計_DBC200009_給付管理票送付一覧表のReportSourceです。
 *
 * @reamsid_L DBC-2840-041 kanghongsong
 */
public class KyufuKanrihyoSofuIchiranReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "teishutsuYM", length = 8, order = 2)
    public RString teishutsuYM;
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
    @ReportItem(name = "listUpper_1", length = 6, order = 16)
    public RString listUpper_1;
    @ReportItem(name = "listUpper_2", length = 10, order = 17)
    public RString listUpper_2;
    @ReportItem(name = "listUpper_3", length = 15, order = 18)
    public RString listUpper_3;
    @ReportItem(name = "listUpper_4", length = 2, order = 19)
    public RString listUpper_4;
    @ReportItem(name = "listUpper_5", length = 5, order = 20)
    public RString listUpper_5;
    @ReportItem(name = "listUpper_6", length = 2, order = 21)
    public RString listUpper_6;
    @ReportItem(name = "listUpper_7", length = 4, order = 22)
    public RString listUpper_7;
    @ReportItem(name = "listUpper_8", length = 10, order = 23)
    public RString listUpper_8;
    @ReportItem(name = "listUpper_9", length = 7, order = 24)
    public RString listUpper_9;
    @ReportItem(name = "listUpper_10", length = 7, order = 25)
    public RString listUpper_10;
    @ReportItem(name = "listUpper_11", length = 9, order = 26)
    public RString listUpper_11;
    @ReportItem(name = "listUpper_12", length = 9, order = 27)
    public RString listUpper_12;
    @ReportItem(name = "listUpper_13", length = 9, order = 28)
    public RString listUpper_13;
    @ReportItem(name = "listUpper_14", length = 10, order = 29)
    public RString listUpper_14;
    @ReportItem(name = "listLower_1", length = 6, order = 30)
    public RString listLower_1;
    @ReportItem(name = "shinkiGokeiKensu", length = 6, order = 31)
    public RString shinkiGokeiKensu;
    @ReportItem(name = "shuseiGokeiKensu", length = 6, order = 32)
    public RString shuseiGokeiKensu;
    @ReportItem(name = "torikeshiGokeiKensu", length = 6, order = 33)
    public RString torikeshiGokeiKensu;
    @ReportItem(name = "yubinNo", length = 6, order = 34)
    public RString yubinNo;
    @ReportItem(name = "choikiCode", length = 6, order = 35)
    public RString choikiCode;
    @ReportItem(name = "gyoseikuCode", length = 6, order = 36)
    public RString gyoseikuCode;
    @ReportItem(name = "shimei50onKana", length = 6, order = 37)
    public RString shimei50onKana;
    @ReportItem(name = "shichosonCode", length = 6, order = 38)
    public RString shichosonCode;
    @ReportItem(name = "riyoYM", length = 6, order = 40)
    public RString riyoYM;
    @ReportItem(name = "yokaigoJotaiKubunCode", length = 6, order = 41)
    public RString yokaigoJotaiKubunCode;
    @ReportItem(name = "hihokenshaNo", length = 6, order = 42)
    public RString hihokenshaNo;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
    @ReportPerson(id = "X")
    public ShikibetsuCode shikibetuCode;
    @ReportExpandedInfo(id = "X")
    public ExpandedInformation hihokennshaNo;
// </editor-fold>

    /**
     * enum
     */
    public enum ReportSourceFields {

        hokenshaNo,
        yubinNo,
        choikiCode,
        gyoseikuCode,
        shimei50onKana,
        shichosonCode,
        riyoYM,
        yokaigoJotaiKubunCode
    }
}
