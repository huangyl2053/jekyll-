package jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohikagomoshitateshojohosofuichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 帳票設計_DBC200079_総合事業費過誤申立書情報送付一覧表 のSourceクラスです。
 *
 * @author DBC-2045-042 zhengshenlei
 */
public class SogojigyohiKagoMoshitateshojohoSofuIchiranSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "sofuYM", length = 8, order = 2)
    public RString sofuYM;
    @ReportItem(name = "hokenshaNo", length = 6, order = 3)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 12, order = 4)
    public RString hokenshaName;
    @ReportItem(name = "shokisaiHokenshaNo", length = 8, order = 5)
    public RString shokisaiHokenshaNo;
    @ReportItem(name = "shokisaiHokenshaName", length = 20, order = 6)
    public RString shokisaiHokenshaName;
    @ReportItem(name = "shutsuryokujun1", length = 10, order = 7)
    public RString shutsuryokujun1;
    @ReportItem(name = "shutsuryokujun2", length = 10, order = 8)
    public RString shutsuryokujun2;
    @ReportItem(name = "shutsuryokujun3", length = 10, order = 9)
    public RString shutsuryokujun3;
    @ReportItem(name = "shutsuryokujun4", length = 10, order = 10)
    public RString shutsuryokujun4;
    @ReportItem(name = "shutsuryokujun5", length = 10, order = 11)
    public RString shutsuryokujun5;
    @ReportItem(name = "kaipage1", length = 20, order = 12)
    public RString kaipage1;
    @ReportItem(name = "kaipage2", length = 20, order = 13)
    public RString kaipage2;
    @ReportItem(name = "kaipage3", length = 20, order = 14)
    public RString kaipage3;
    @ReportItem(name = "kaipage4", length = 20, order = 15)
    public RString kaipage4;
    @ReportItem(name = "kaipage5", length = 20, order = 16)
    public RString kaipage5;
    @ReportItem(name = "listUpper_1", length = 4, order = 17)
    public RString listUpper_1;
    @ReportItem(name = "listUpper_2", length = 10, order = 18)
    public RString listUpper_2;
    @ReportItem(name = "listUpper_3", length = 20, order = 19)
    public RString listUpper_3;
    @ReportItem(name = "listUpper_4", length = 10, order = 20)
    public RString listUpper_4;
    @ReportExpandedInfo(id = "A", code = "0003", name = "被保険者番号")
    @ReportItem(name = "listUpper_5", length = 30, order = 21)
    public RString listUpper_5;
    @ReportItem(name = "listUpper_6", length = 6, order = 22)
    public RString listUpper_6;
    @ReportItem(name = "listUpper_7", length = 9, order = 23)
    public RString listUpper_7;
    @ReportItem(name = "listUpper_8", length = 4, order = 24)
    public RString listUpper_8;
    @ReportItem(name = "listUpper_9", length = 20, order = 25)
    public RString listUpper_9;
    @ReportItem(name = "listLower_1", length = 15, order = 26)
    public RString listLower_1;
    @ReportItem(name = "listLower_2", length = 20, order = 27)
    public RString listLower_2;
    @ReportItem(name = "gokeiKensuTitle", length = 4, order = 28)
    public RString gokeiKensuTitle;
    @ReportItem(name = "gokeiKensu", length = 8, order = 29)
    public RString gokeiKensu;
    @ReportPerson(id = "A")
    @ReportItem(name = "shikibetsuCode", length = 15)
    public RString shikibetsuCode;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>

    /**
     * SogojigyohiKagoMoshitateshojohoSofuIchiranSource
     */
    public enum ReportSourceFields {

        printTimeStamp,
        sofuYM,
        hokenshaNo,
        hokenshaName,
        shokisaiHokenshaNo,
        shokisaiHokenshaName,
        shutsuryokujun1,
        shutsuryokujun2,
        shutsuryokujun3,
        shutsuryokujun4,
        shutsuryokujun5,
        kaipage1,
        kaipage2,
        kaipage3,
        kaipage4,
        kaipage5,
        listUpper_1,
        listUpper_2,
        listUpper_3,
        listUpper_4,
        listUpper_5,
        listUpper_6,
        listUpper_7,
        listUpper_8,
        listUpper_9,
        listLower_1,
        listLower_2,
        gokeiKensuTitle,
        gokeiKensu
    }
}
