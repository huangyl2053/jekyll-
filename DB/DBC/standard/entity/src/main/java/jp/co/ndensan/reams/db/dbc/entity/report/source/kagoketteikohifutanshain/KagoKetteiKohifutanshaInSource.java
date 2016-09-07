/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.report.source.kagoketteikohifutanshain;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 誤決定通知書情報取込一覧表（公費負担者分）帳票Source
 *
 * @reamsid_L DBC-0980-510 surun
 */
public class KagoKetteiKohifutanshaInSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "torikomiYM", length = 8, order = 2)
    public RString torikomiYM;
    @ReportItem(name = "kohiFutanshaNo", length = 8, order = 3)
    public RString kohiFutanshaNo;
    @ReportItem(name = "kohiFutanshaName", length = 20, order = 4)
    public RString kohiFutanshaName;
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
    @ReportItem(name = "kaipage1", length = 20, order = 10)
    public RString kaipage1;
    @ReportItem(name = "kaipage2", length = 20, order = 11)
    public RString kaipage2;
    @ReportItem(name = "kaipage3", length = 20, order = 12)
    public RString kaipage3;
    @ReportItem(name = "kaipage4", length = 20, order = 13)
    public RString kaipage4;
    @ReportItem(name = "kaipage5", length = 20, order = 14)
    public RString kaipage5;
    @ReportItem(name = "listUpper_1", length = 4, order = 15)
    public RString listUpper_1;
    @ReportItem(name = "listUpper_2", length = 6, order = 16)
    public RString listUpper_2;
    @ReportItem(name = "listUpper_3", length = 10, order = 17)
    public RString listUpper_3;
    @ReportItem(name = "listUpper_4", length = 7, order = 18)
    public RString listUpper_4;
    @ReportItem(name = "listUpper_5", length = 10, order = 19)
    public RString listUpper_5;
    @ReportItem(name = "listUpper_6", length = 6, order = 20)
    public RString listUpper_6;
    @ReportItem(name = "listUpper_7", length = 2, order = 21)
    public RString listUpper_7;
    @ReportItem(name = "listUpper_8", length = 4, order = 22)
    public RString listUpper_8;
    @ReportItem(name = "listUpper_9", length = 17, order = 23)
    public RString listUpper_9;
    @ReportItem(name = "listLower_1", length = 20, order = 24)
    public RString listLower_1;
    @ReportItem(name = "listLower_2", length = 10, order = 25)
    public RString listLower_2;
    @ReportItem(name = "listLower_3", length = 12, order = 26)
    public RString listLower_3;
    @ReportItem(name = "listLower_4", length = 14, order = 27)
    public RString listLower_4;
    @ReportItem(name = "listLower_5", length = 17, order = 28)
    public RString listLower_5;
    @ReportItem(name = "kensuTitle", length = 2, order = 29)
    public RString kensuTitle;
    @ReportItem(name = "tanisuTitle", length = 3, order = 30)
    public RString tanisuTitle;
    @ReportItem(name = "kaigoKyufuhiTitle", length = 5, order = 32)
    public RString kaigoKyufuhiTitle;
    @ReportItem(name = "kaigoKyufuhiKensu", length = 7, order = 33)
    public RString kaigoKyufuhiKensu;
    @ReportItem(name = "futangakuTitle", length = 6, order = 31)
    public RString futangakuTitle;
    @ReportItem(name = "kaigoKyufuhiTanisu", length = 17, order = 34)
    public RString kaigoKyufuhiTanisu;
    @ReportItem(name = "kaigoKyufuhiFutangaku", length = 17, order = 35)
    public RString kaigoKyufuhiFutangaku;
    @ReportItem(name = "kogakuServicehiTitle", length = 9, order = 36)
    public RString kogakuServicehiTitle;
    @ReportItem(name = "kogakuServicehiKensu", length = 7, order = 37)
    public RString kogakuServicehiKensu;
    @ReportItem(name = "kogakuServicehiTanisu", length = 17, order = 38)
    public RString kogakuServicehiTanisu;
    @ReportItem(name = "kogakuServicehiFutangaku", length = 17, order = 39)
    public RString kogakuServicehiFutangaku;
    @ReportItem(name = "tokuteiNyushoshaKaigohiTitle", length = 9, order = 40)
    public RString tokuteiNyushoshaKaigohiTitle;
    @ReportItem(name = "tokuteiNyushoshaKaigohiKensu", length = 7, order = 41)
    public RString tokuteiNyushoshaKaigohiKensu;
    @ReportItem(name = "tokuteiNyushoshaKaigohiTanisu", length = 17, order = 42)
    public RString tokuteiNyushoshaKaigohiTanisu;
    @ReportItem(name = "tokuteiNyushoshaKaigohiFutangaku", length = 17, order = 43)
    public RString tokuteiNyushoshaKaigohiFutangaku;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。

    /**
     * TokubetsuChoshuKaishiSourceのenum
     */
    public enum ReportSourceFields {

        printTimeStamp,
        torikomiYM,
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
        listLower_3,
        listLower_4,
        listLower_5,
        kensuTitle,
        tanisuTitle,
        kaigoKyufuhiTitle,
        kaigoKyufuhiKensu,
        futangakuTitle,
        kaigoKyufuhiTanisu,
        kaigoKyufuhiFutangaku,
        kogakuServicehiTitle,
        kogakuServicehiKensu,
        kogakuServicehiTanisu,
        kogakuServicehiFutangaku,
        tokuteiNyushoshaKaigohiTitle,
        tokuteiNyushoshaKaigohiKensu,
        tokuteiNyushoshaKaigohiTanisu,
        tokuteiNyushoshaKaigohiFutangaku
    }
// </editor-fold>
}
