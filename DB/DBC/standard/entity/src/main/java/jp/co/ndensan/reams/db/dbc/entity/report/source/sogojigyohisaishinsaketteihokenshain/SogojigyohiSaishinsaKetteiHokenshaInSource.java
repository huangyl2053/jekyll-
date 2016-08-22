package jp.co.ndensan.reams.db.dbc.entity.report.source.sogojigyohisaishinsaketteihokenshain;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 総合事業費再審査決定通知書情報取込一覧表帳票Source
 *
 * @reamsid_L DBC-4680-040 wangxue
 */
public class SogojigyohiSaishinsaKetteiHokenshaInSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "torikomiYM", length = 8, order = 2)
    public RString torikomiYM;
    @ReportItem(name = "hokenshaNo", length = 6, order = 3)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 12, order = 4)
    public RString hokenshaName;
    @ReportItem(name = "shoKisaiHokenshaNo", length = 8, order = 5)
    public RString shoKisaiHokenshaNo;
    @ReportItem(name = "shoKisaiHokenshaName", length = 20, order = 6)
    public RString shoKisaiHokenshaName;
    @ReportItem(name = "kokuhorenName", length = 15, order = 7)
    public RString kokuhorenName;
    @ReportItem(name = "shutsuryokujun1", length = 10, order = 8)
    public RString shutsuryokujun1;
    @ReportItem(name = "shutsuryokujun2", length = 10, order = 9)
    public RString shutsuryokujun2;
    @ReportItem(name = "shutsuryokujun3", length = 10, order = 10)
    public RString shutsuryokujun3;
    @ReportItem(name = "shutsuryokujun4", length = 10, order = 11)
    public RString shutsuryokujun4;
    @ReportItem(name = "shutsuryokujun5", length = 10, order = 12)
    public RString shutsuryokujun5;
    @ReportItem(name = "shinsakaiName", length = 15, order = 13)
    public RString shinsakaiName;
    @ReportItem(name = "kaipage1", length = 20, order = 14)
    public RString kaipage1;
    @ReportItem(name = "kaipage2", length = 20, order = 15)
    public RString kaipage2;
    @ReportItem(name = "kaipage3", length = 20, order = 16)
    public RString kaipage3;
    @ReportItem(name = "kaipage4", length = 20, order = 17)
    public RString kaipage4;
    @ReportItem(name = "kaipage5", length = 20, order = 18)
    public RString kaipage5;
    @ReportItem(name = "listLower_1", length = 10, order = 19)
    public RString listLower_1;
    @ReportItem(name = "listLower_2", length = 20, order = 20)
    public RString listLower_2;
    @ReportItem(name = "listLower_3", length = 4, order = 21)
    public RString listLower_3;
    @ReportItem(name = "listLower_4", length = 18, order = 22)
    public RString listLower_4;
    @ReportItem(name = "listLower_5", length = 15, order = 23)
    public RString listLower_5;
    @ReportItem(name = "listLower_6", length = 17, order = 24)
    public RString listLower_6;
    @ReportItem(name = "listUpper_1", length = 4, order = 25)
    public RString listUpper_1;
    @ReportItem(name = "listUpper_2", length = 6, order = 26)
    public RString listUpper_2;
    @ReportItem(name = "listUpper_3", length = 10, order = 27)
    public RString listUpper_3;
    @ReportItem(name = "listUpper_4", length = 20, order = 28)
    public RString listUpper_4;
    @ReportItem(name = "listUpper_5", length = 6, order = 29)
    public RString listUpper_5;
    @ReportItem(name = "listUpper_6", length = 2, order = 30)
    public RString listUpper_6;
    @ReportItem(name = "listUpper_7", length = 12, order = 31)
    public RString listUpper_7;
    @ReportItem(name = "listUpper_8", length = 15, order = 32)
    public RString listUpper_8;
    @ReportItem(name = "listUpper_9", length = 15, order = 33)
    public RString listUpper_9;
    @ReportItem(name = "listUpper_10", length = 17, order = 34)
    public RString listUpper_10;
    @ReportItem(name = "ketteiTitle", length = 7, order = 35)
    public RString ketteiTitle;
    @ReportItem(name = "choseiTitle", length = 4, order = 36)
    public RString choseiTitle;
    @ReportItem(name = "ketteiKensuTitle", length = 2, order = 37)
    public RString ketteiKensuTitle;
    @ReportItem(name = "ketteiTanisuTitle", length = 3, order = 38)
    public RString ketteiTanisuTitle;
    @ReportItem(name = "ketteiFutangakuTitle", length = 6, order = 39)
    public RString ketteiFutangakuTitle;
    @ReportItem(name = "choseiKensuTitle", length = 2, order = 40)
    public RString choseiKensuTitle;
    @ReportItem(name = "choseiTanisuTitle", length = 3, order = 41)
    public RString choseiTanisuTitle;
    @ReportItem(name = "choseiFutangakuTitle", length = 6, order = 42)
    public RString choseiFutangakuTitle;
    @ReportItem(name = "sogojigyohiTitle", length = 5, order = 43)
    public RString sogojigyohiTitle;
    @ReportItem(name = "sogojigyohiKetteiKensu", length = 7, order = 44)
    public RString sogojigyohiKetteiKensu;
    @ReportItem(name = "sogojigyohiKetteiTanisu", length = 15, order = 45)
    public RString sogojigyohiKetteiTanisu;
    @ReportItem(name = "sogojigyohiKetteiFutangaku", length = 15, order = 46)
    public RString sogojigyohiKetteiFutangaku;
    @ReportItem(name = "sogojigyohiChoseiKensu", length = 7, order = 47)
    public RString sogojigyohiChoseiKensu;
    @ReportItem(name = "sogojigyohiChoseiTanisu", length = 17, order = 48)
    public RString sogojigyohiChoseiTanisu;
    @ReportItem(name = "sogojigyohiChoseiFutangaku", length = 17, order = 49)
    public RString sogojigyohiChoseiFutangaku;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>

    /**
     * SogojigyohiKagoKetteiInSourceのENUM
     */
    public enum ReportSourceFields {

        hokenshaNo,
        hokenshaName,
        shoKisaiHokenshaNo,
        shoKisaiHokenshaName,
        kokuhorenName,
        shutsuryokujun1,
        shutsuryokujun2,
        shutsuryokujun3,
        shutsuryokujun4,
        shutsuryokujun5,
        shinsakaiName,
        kaipage1,
        kaipage2,
        kaipage3,
        kaipage4,
        kaipage5,
        listLower_1,
        listLower_2,
        listLower_3,
        listLower_4,
        listLower_5,
        listLower_6,
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
        ketteiTitle,
        choseiTitle,
        ketteiKensuTitle,
        ketteiTanisuTitle,
        ketteiFutangakuTitle,
        choseiKensuTitle,
        choseiTanisuTitle,
        choseiFutangakuTitle,
        sogojigyohiTitle,
        sogojigyohiKetteiKensu,
        sogojigyohiKetteiTanisu,
        sogojigyohiKetteiFutangaku,
        sogojigyohiChoseiKensu,
        sogojigyohiChoseiTanisu,
        sogojigyohiChoseiFutangaku
    }
}
