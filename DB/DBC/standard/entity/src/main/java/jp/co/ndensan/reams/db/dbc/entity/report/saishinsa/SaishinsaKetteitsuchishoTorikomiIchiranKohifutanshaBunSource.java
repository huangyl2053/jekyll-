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
    @ReportItem(name = "pageCount1", length = 10, order = 2)
    public RString pageCount1;
    @ReportItem(name = "torikomiYM", length = 8, order = 3)
    public RString torikomiYM;
    @ReportItem(name = "kokuhorenName", length = 15, order = 4)
    public RString kokuhorenName;
    @ReportItem(name = "shinsakaiName", length = 15, order = 5)
    public RString shinsakaiName;
    @ReportItem(name = "kohiFutanshaNo", length = 8, order = 6)
    public RString kohiFutanshaNo;
    @ReportItem(name = "kohiFutanshaName", length = 20, order = 7)
    public RString kohiFutanshaName;
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
    @ReportItem(name = "kaipage1", length = 20, order = 13)
    public RString kaipage1;
    @ReportItem(name = "kaipage2", length = 20, order = 14)
    public RString kaipage2;
    @ReportItem(name = "kaipage3", length = 20, order = 15)
    public RString kaipage3;
    @ReportItem(name = "kaipage4", length = 20, order = 16)
    public RString kaipage4;
    @ReportItem(name = "kaipage5", length = 20, order = 17)
    public RString kaipage5;
    @ReportItem(name = "listLower_1", length = 10, order = 18)
    public RString listLower_1;
    @ReportItem(name = "listLower_2", length = 20, order = 19)
    public RString listLower_2;
    @ReportItem(name = "listLower_3", length = 4, order = 20)
    public RString listLower_3;
    @ReportItem(name = "listLower_4", length = 12, order = 21)
    public RString listLower_4;
    @ReportItem(name = "listLower_5", length = 7, order = 22)
    public RString listLower_5;
    @ReportItem(name = "listLower_6", length = 15, order = 23)
    public RString listLower_6;
    @ReportItem(name = "listLower_7", length = 15, order = 24)
    public RString listLower_7;
    @ReportItem(name = "listLower_8", length = 17, order = 25)
    public RString listLower_8;
    @ReportItem(name = "listUpper_1", length = 4, order = 26)
    public RString listUpper_1;
    @ReportItem(name = "listUpper_2", length = 6, order = 27)
    public RString listUpper_2;
    @ReportItem(name = "listUpper_3", length = 10, order = 28)
    public RString listUpper_3;
    @ReportItem(name = "listUpper_4", length = 20, order = 29)
    public RString listUpper_4;
    @ReportItem(name = "listUpper_5", length = 6, order = 30)
    public RString listUpper_5;
    @ReportItem(name = "listUpper_6", length = 2, order = 31)
    public RString listUpper_6;
    @ReportItem(name = "listUpper_7", length = 12, order = 32)
    public RString listUpper_7;
    @ReportItem(name = "listUpper_8", length = 2, order = 33)
    public RString listUpper_8;
    @ReportItem(name = "listUpper_9", length = 15, order = 34)
    public RString listUpper_9;
    @ReportItem(name = "listUpper_10", length = 15, order = 35)
    public RString listUpper_10;
    @ReportItem(name = "listUpper_11", length = 17, order = 36)
    public RString listUpper_11;
    @ReportItem(name = "seikyuTitle", length = 9, order = 37)
    public RString seikyuTitle;
    @ReportItem(name = "ketteiTitle", length = 9, order = 38)
    public RString ketteiTitle;
    @ReportItem(name = "choseiTitle", length = 6, order = 39)
    public RString choseiTitle;
    @ReportItem(name = "seikyuKensuTitle", length = 2, order = 40)
    public RString seikyuKensuTitle;
    @ReportItem(name = "seikyuTanisuTitle", length = 3, order = 41)
    public RString seikyuTanisuTitle;
    @ReportItem(name = "seikyuFutangakuTitle", length = 5, order = 42)
    public RString seikyuFutangakuTitle;
    @ReportItem(name = "ketteiKensuTitle", length = 2, order = 43)
    public RString ketteiKensuTitle;
    @ReportItem(name = "ketteiTanisuTitle", length = 3, order = 44)
    public RString ketteiTanisuTitle;
    @ReportItem(name = "ketteiFutangakuTitle", length = 5, order = 45)
    public RString ketteiFutangakuTitle;
    @ReportItem(name = "choseiKensuTitle", length = 2, order = 46)
    public RString choseiKensuTitle;
    @ReportItem(name = "choseiTanisuTitle", length = 3, order = 47)
    public RString choseiTanisuTitle;
    @ReportItem(name = "choseiFutangakuTitle", length = 5, order = 48)
    public RString choseiFutangakuTitle;
    @ReportItem(name = "kaigoKyufuhiTitle", length = 5, order = 49)
    public RString kaigoKyufuhiTitle;
    @ReportItem(name = "kaigoKyufuhiSeikyuKensu", length = 7, order = 50)
    public RString kaigoKyufuhiSeikyuKensu;
    @ReportItem(name = "kaigoKyufuhiSeikyuTanisu", length = 15, order = 51)
    public RString kaigoKyufuhiSeikyuTanisu;
    @ReportItem(name = "kaigoKyufuhiSeikyuFutangaku", length = 15, order = 52)
    public RString kaigoKyufuhiSeikyuFutangaku;
    @ReportItem(name = "kaigoKyufuhiKetteiKensu", length = 7, order = 53)
    public RString kaigoKyufuhiKetteiKensu;
    @ReportItem(name = "kaigoKyufuhiKetteiTanisu", length = 15, order = 54)
    public RString kaigoKyufuhiKetteiTanisu;
    @ReportItem(name = "kaigoKyufuhiKetteiFutangaku", length = 15, order = 55)
    public RString kaigoKyufuhiKetteiFutangaku;
    @ReportItem(name = "kaigoKyufuhiChoseiKensu", length = 7, order = 56)
    public RString kaigoKyufuhiChoseiKensu;
    @ReportItem(name = "kaigoKyufuhiChoseiTanisu", length = 17, order = 57)
    public RString kaigoKyufuhiChoseiTanisu;
    @ReportItem(name = "kaigoKyufuhiChoseiFutangaku", length = 17, order = 58)
    public RString kaigoKyufuhiChoseiFutangaku;
    @ReportItem(name = "kogakuServicehiTitle", length = 9, order = 59)
    public RString kogakuServicehiTitle;
    @ReportItem(name = "kogakuServicehiSeikyuKensu", length = 7, order = 60)
    public RString kogakuServicehiSeikyuKensu;
    @ReportItem(name = "kogakuServicehiSeikyuTanisu", length = 15, order = 61)
    public RString kogakuServicehiSeikyuTanisu;
    @ReportItem(name = "kogakuServicehiSeikyuFutangaku", length = 15, order = 62)
    public RString kogakuServicehiSeikyuFutangaku;
    @ReportItem(name = "kogakuServicehiKetteiKensu", length = 7, order = 63)
    public RString kogakuServicehiKetteiKensu;
    @ReportItem(name = "kogakuServicehiKetteiTanisu", length = 15, order = 64)
    public RString kogakuServicehiKetteiTanisu;
    @ReportItem(name = "kogakuServicehiKetteiFutangaku", length = 15, order = 65)
    public RString kogakuServicehiKetteiFutangaku;
    @ReportItem(name = "kogakuServicehiChoseiKensu", length = 7, order = 66)
    public RString kogakuServicehiChoseiKensu;
    @ReportItem(name = "kogakuServicehiChoseiTanisu", length = 17, order = 67)
    public RString kogakuServicehiChoseiTanisu;
    @ReportItem(name = "kogakuServicehiChoseiFutangaku", length = 17, order = 68)
    public RString kogakuServicehiChoseiFutangaku;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>

    /**
     * SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunSourceのenum
     */
    public enum ReportSourceFields {

        printTimeStamp,
        pageCount1,
        torikomiYM,
        kokuhorenName,
        shinsakaiName,
        kohiFutanshaNo,
        kohiFutanshaName,
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
        listLower_1,
        listLower_2,
        listLower_3,
        listLower_4,
        listLower_5,
        listLower_6,
        listLower_7,
        listLower_8,
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
        seikyuTitle,
        ketteiTitle,
        choseiTitle,
        seikyuKensuTitle,
        seikyuTanisuTitle,
        seikyuFutangakuTitle,
        ketteiKensuTitle,
        ketteiTanisuTitle,
        ketteiFutangakuTitle,
        choseiKensuTitle,
        choseiTanisuTitle,
        choseiFutangakuTitle,
        kaigoKyufuhiTitle,
        kaigoKyufuhiSeikyuKensu,
        kaigoKyufuhiSeikyuTanisu,
        kaigoKyufuhiSeikyuFutangaku,
        kaigoKyufuhiKetteiKensu,
        kaigoKyufuhiKetteiTanisu,
        kaigoKyufuhiKetteiFutangaku,
        kaigoKyufuhiChoseiKensu,
        kaigoKyufuhiChoseiTanisu,
        kaigoKyufuhiChoseiFutangaku,
        kogakuServicehiTitle,
        kogakuServicehiSeikyuKensu,
        kogakuServicehiSeikyuTanisu,
        kogakuServicehiSeikyuFutangaku,
        kogakuServicehiKetteiKensu,
        kogakuServicehiKetteiTanisu,
        kogakuServicehiKetteiFutangaku,
        kogakuServicehiChoseiKensu,
        kogakuServicehiChoseiTanisu,
        kogakuServicehiChoseiFutangaku
    }
}
