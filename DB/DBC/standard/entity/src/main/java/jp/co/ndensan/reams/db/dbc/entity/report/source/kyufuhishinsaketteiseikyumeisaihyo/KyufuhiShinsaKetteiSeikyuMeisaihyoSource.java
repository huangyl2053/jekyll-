package jp.co.ndensan.reams.db.dbc.entity.report.source.kyufuhishinsaketteiseikyumeisaihyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 介護給付費等審査決定請求明細表のSourceクラスです。
 *
 * @reamsid_L DBC-2500-010 jiangxiaolong
 */
public class KyufuhiShinsaKetteiSeikyuMeisaihyoSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "shinsaYM", length = 8, order = 2)
    public RString shinsaYM;
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
    @ReportItem(name = "kokuhorenName", length = 15, order = 10)
    public RString kokuhorenName;
    @ReportItem(name = "kaipage1", length = 20, order = 11)
    public RString kaipage1;
    @ReportItem(name = "kaipage2", length = 20, order = 12)
    public RString kaipage2;
    @ReportItem(name = "kaipage3", length = 20, order = 13)
    public RString kaipage3;
    @ReportItem(name = "kaipage4", length = 20, order = 14)
    public RString kaipage4;
    @ReportItem(name = "kaipage5", length = 20, order = 15)
    public RString kaipage5;
    @ReportItem(name = "shoKisaiHokenshaNo", length = 6, order = 16)
    public RString shoKisaiHokenshaNo;
    @ReportItem(name = "listMeisai_1", length = 10, order = 17)
    public RString listMeisai_1;
    @ReportItem(name = "listMeisai_2", length = 20, order = 18)
    public RString listMeisai_2;
    @ReportItem(name = "listMeisai_3", length = 6, order = 19)
    public RString listMeisai_3;
    @ReportItem(name = "listMeisai_4", length = 17, order = 20)
    public RString listMeisai_4;
    @ReportItem(name = "listMeisai_5", length = 7, order = 21)
    public RString listMeisai_5;
    @ReportItem(name = "listMeisai_6", length = 10, order = 22)
    public RString listMeisai_6;
    @ReportItem(name = "listMeisai_7", length = 15, order = 23)
    public RString listMeisai_7;
    @ReportItem(name = "listMeisai_8", length = 15, order = 24)
    public RString listMeisai_8;
    @ReportItem(name = "listMeisai_9", length = 15, order = 25)
    public RString listMeisai_9;
    @ReportItem(name = "listMeisai_10", length = 15, order = 26)
    public RString listMeisai_10;
    @ReportItem(name = "listMeisai_11", length = 15, order = 27)
    public RString listMeisai_11;
    @ReportItem(name = "kogakuKensu", length = 7, order = 28)
    public RString kogakuKensu;
    @ReportItem(name = "kogakuServicegaku", length = 15, order = 29)
    public RString kogakuServicegaku;
    @ReportItem(name = "kogakuKohiFutangaku", length = 17, order = 30)
    public RString kogakuKohiFutangaku;
    @ReportItem(name = "gokeiKensu", length = 10, order = 31)
    public RString gokeiKensu;
    @ReportItem(name = "gokeiTanisu", length = 15, order = 32)
    public RString gokeiTanisu;
    @ReportItem(name = "gokeiKingaku", length = 15, order = 33)
    public RString gokeiKingaku;
    @ReportItem(name = "gokeiKaigoKyufugaku", length = 15, order = 34)
    public RString gokeiKaigoKyufugaku;
    @ReportItem(name = "gokeiRiyoshaFutangaku", length = 15, order = 35)
    public RString gokeiRiyoshaFutangaku;
    @ReportItem(name = "gokeiKohiFutangaku", length = 17, order = 36)
    public RString gokeiKohiFutangaku;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>

    /**
     * KogakuKyufuTaishoshaIchiranSourceのENUM
     */
    public enum DBC200069KyufuhiShinsaKetteiFields {

        printTimeStamp,
        shinsaYM,
        hokenshaNo,
        hokenshaName,
        shutsuryokujun1,
        shutsuryokujun2,
        shutsuryokujun3,
        shutsuryokujun4,
        shutsuryokujun5,
        kokuhorenName,
        kaipage1,
        kaipage2,
        kaipage3,
        kaipage4,
        kaipage5,
        shoKisaiHokenshaNo,
        listMeisai_1,
        listMeisai_2,
        listMeisai_3,
        listMeisai_4,
        listMeisai_5,
        listMeisai_6,
        listMeisai_7,
        listMeisai_8,
        listMeisai_9,
        listMeisai_10,
        listMeisai_11,
        kogakuKensu,
        kogakuServicegaku,
        kogakuKohiFutangaku,
        gokeiKensu,
        gokeiTanisu,
        gokeiKingaku,
        gokeiKaigoKyufugaku,
        gokeiRiyoshaFutangaku,
        gokeiKohiFutangaku
    }
}
