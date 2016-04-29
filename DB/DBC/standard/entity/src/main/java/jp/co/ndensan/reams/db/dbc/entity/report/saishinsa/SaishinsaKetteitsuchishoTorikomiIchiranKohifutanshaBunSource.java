package jp.co.ndensan.reams.db.dbc.entity.report.saishinsa;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 再審査決定通知書情報取込一覧表（公費負担者分）帳票Source
 *
 * @reamsid_L DBC-2820-050 sunhui
 */
public class SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "torikomiYM", length = 8, order = 2)
    public RString torikomiYM;
    @ReportItem(name = "kokuhorenName", length = 15, order = 3)
    public RString kokuhorenName;
    @ReportItem(name = "shinsakaiName", length = 15, order = 4)
    public RString shinsakaiName;
    @ReportItem(name = "kohiFutanshaNo", length = 8, order = 5)
    public RString kohiFutanshaNo;
    @ReportItem(name = "kohiFutanshaName", length = 20, order = 6)
    public RString kohiFutanshaName;
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
    @ReportItem(name = "listCenter_1", length = 4, order = 17)
    public RString listCenter_1;
    @ReportItem(name = "listCenter_2", length = 6, order = 18)
    public RString listCenter_2;
    @ReportItem(name = "listCenter_3", length = 6, order = 19)
    public RString listCenter_3;
    @ReportItem(name = "listLower_1", length = 10, order = 20)
    public RString listLower_1;
    @ReportItem(name = "listUpper_1", length = 10, order = 21)
    public RString listUpper_1;
    @ReportItem(name = "listLower_2", length = 20, order = 22)
    public RString listLower_2;
    @ReportItem(name = "listUpper_2", length = 20, order = 23)
    public RString listUpper_2;
    @ReportItem(name = "listLower_3", length = 4, order = 24)
    public RString listLower_3;
    @ReportItem(name = "listUpper_3", length = 2, order = 25)
    public RString listUpper_3;
    @ReportItem(name = "listLower_4", length = 12, order = 26)
    public RString listLower_4;
    @ReportItem(name = "listUpper_4", length = 12, order = 27)
    public RString listUpper_4;
    @ReportItem(name = "listLower_5", length = 7, order = 28)
    public RString listLower_5;
    @ReportItem(name = "listUpper_5", length = 2, order = 29)
    public RString listUpper_5;
    @ReportItem(name = "listLower_6", length = 15, order = 30)
    public RString listLower_6;
    @ReportItem(name = "listUpper_6", length = 15, order = 31)
    public RString listUpper_6;
    @ReportItem(name = "listLower_7", length = 15, order = 32)
    public RString listLower_7;
    @ReportItem(name = "listUpper_7", length = 15, order = 33)
    public RString listUpper_7;
    @ReportItem(name = "listLower_8", length = 15, order = 34)
    public RString listLower_8;
    @ReportItem(name = "listUpper_8", length = 15, order = 35)
    public RString listUpper_8;
    @ReportItem(name = "midashi1", length = 9, order = 36)
    public RString midashi1;
    @ReportItem(name = "midashi2", length = 9, order = 37)
    public RString midashi2;
    @ReportItem(name = "midashi3", length = 6, order = 38)
    public RString midashi3;
    @ReportItem(name = "midashi4", length = 2, order = 39)
    public RString midashi4;
    @ReportItem(name = "midashi5", length = 3, order = 40)
    public RString midashi5;
    @ReportItem(name = "midashi6", length = 6, order = 41)
    public RString midashi6;
    @ReportItem(name = "midashi7", length = 2, order = 42)
    public RString midashi7;
    @ReportItem(name = "midashi8", length = 3, order = 43)
    public RString midashi8;
    @ReportItem(name = "midashi9", length = 6, order = 44)
    public RString midashi9;
    @ReportItem(name = "midashi10", length = 2, order = 45)
    public RString midashi10;
    @ReportItem(name = "midashi11", length = 3, order = 46)
    public RString midashi11;
    @ReportItem(name = "midashi12", length = 6, order = 47)
    public RString midashi12;
    @ReportItem(name = "midashi13", length = 5, order = 48)
    public RString midashi13;
    @ReportItem(name = "kensu1", length = 7, order = 49)
    public RString kensu1;
    @ReportItem(name = "tanisu1", length = 15, order = 50)
    public RString tanisu1;
    @ReportItem(name = "futangaku1", length = 15, order = 51)
    public RString futangaku1;
    @ReportItem(name = "kensu2", length = 7, order = 52)
    public RString kensu2;
    @ReportItem(name = "tanisu2", length = 15, order = 53)
    public RString tanisu2;
    @ReportItem(name = "futangaku2", length = 15, order = 54)
    public RString futangaku2;
    @ReportItem(name = "kensu3", length = 7, order = 55)
    public RString kensu3;
    @ReportItem(name = "tanisu3", length = 17, order = 56)
    public RString tanisu3;
    @ReportItem(name = "futangaku3", length = 17, order = 57)
    public RString futangaku3;
    @ReportItem(name = "midashi14", length = 9, order = 58)
    public RString midashi14;
    @ReportItem(name = "kensu4", length = 7, order = 59)
    public RString kensu4;
    @ReportItem(name = "tanisu4", length = 15, order = 60)
    public RString tanisu4;
    @ReportItem(name = "futangaku4", length = 15, order = 61)
    public RString futangaku4;
    @ReportItem(name = "kensu5", length = 7, order = 62)
    public RString kensu5;
    @ReportItem(name = "tanisu5", length = 15, order = 63)
    public RString tanisu5;
    @ReportItem(name = "futangaku5", length = 15, order = 64)
    public RString futangaku5;
    @ReportItem(name = "kensu6", length = 7, order = 65)
    public RString kensu6;
    @ReportItem(name = "tanisu6", length = 17, order = 66)
    public RString tanisu6;
    @ReportItem(name = "futangaku6", length = 17, order = 67)
    public RString futangaku6;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
