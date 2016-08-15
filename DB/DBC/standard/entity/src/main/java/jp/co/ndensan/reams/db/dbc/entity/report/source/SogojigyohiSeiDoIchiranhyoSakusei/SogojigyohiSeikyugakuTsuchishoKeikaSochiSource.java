package jp.co.ndensan.reams.db.dbc.entity.report.source.SogojigyohiSeiDoIchiranhyoSakusei;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 総合事業費（経過措置）請求額通知書情報取込一覧表帳票のSource
 *
 * @reamsid_L DBC_2480_DBCMNF2002-151 jiangxiaolong
 */
public class SogojigyohiSeikyugakuTsuchishoKeikaSochiSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "shinsaYM", length = 8, order = 2)
    public RString shinsaYM;
    @ReportItem(name = "hokenshaNo", length = 6, order = 3)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 12, order = 4)
    public RString hokenshaName;
    @ReportItem(name = "kokuhorenName", length = 15, order = 5)
    public RString kokuhorenName;
    @ReportItem(name = "kanName", length = 15, order = 6)
    public RString kanName;
    @ReportItem(name = "kouName", length = 15, order = 7)
    public RString kouName;
    @ReportItem(name = "shoKisaiHokenshaNo", length = 6, order = 8)
    public RString shoKisaiHokenshaNo;
    @ReportItem(name = "listMeisai_1", length = 17, order = 9)
    public RString listMeisai_1;
    @ReportItem(name = "listMeisai_2", length = 7, order = 10)
    public RString listMeisai_2;
    @ReportItem(name = "listMeisai_3", length = 10, order = 11)
    public RString listMeisai_3;
    @ReportItem(name = "listMeisai_4", length = 15, order = 12)
    public RString listMeisai_4;
    @ReportItem(name = "listMeisai_5", length = 15, order = 13)
    public RString listMeisai_5;
    @ReportItem(name = "listMeisai_6", length = 7, order = 14)
    public RString listMeisai_6;
    @ReportItem(name = "listMeisai_7", length = 17, order = 15)
    public RString listMeisai_7;
    @ReportItem(name = "listMeisai_8", length = 17, order = 16)
    public RString listMeisai_8;
    @ReportItem(name = "listMeisai_9", length = 15, order = 17)
    public RString listMeisai_9;
    @ReportItem(name = "listMeisai_10", length = 15, order = 18)
    public RString listMeisai_10;
    @ReportItem(name = "gokeiTsujoKensu", length = 10, order = 19)
    public RString gokeiTsujoKensu;
    @ReportItem(name = "gokeiTsujoTanisu", length = 17, order = 20)
    public RString gokeiTsujoTanisu;
    @ReportItem(name = "gokeiTsujoKingaku", length = 15, order = 21)
    public RString gokeiTsujoKingaku;
    @ReportItem(name = "gokeiKagoKensu", length = 10, order = 22)
    public RString gokeiKagoKensu;
    @ReportItem(name = "gokeiKagoTanisu", length = 17, order = 23)
    public RString gokeiKagoTanisu;
    @ReportItem(name = "gokeiKagoChoseigaku", length = 17, order = 24)
    public RString gokeiKagoChoseigaku;
    @ReportItem(name = "gokeiSogojigyohi", length = 15, order = 25)
    public RString gokeiSogojigyohi;
    @ReportItem(name = "gokeiRiyoshaFutangaku", length = 15, order = 26)
    public RString gokeiRiyoshaFutangaku;
    @ReportItem(name = "ruikeiTsujoKensu", length = 10, order = 27)
    public RString ruikeiTsujoKensu;
    @ReportItem(name = "ruikeiTsujoTanisu", length = 15, order = 28)
    public RString ruikeiTsujoTanisu;
    @ReportItem(name = "ruikeiTsujoKingaku", length = 15, order = 29)
    public RString ruikeiTsujoKingaku;
    @ReportItem(name = "ruikeiKagoKensu", length = 10, order = 30)
    public RString ruikeiKagoKensu;
    @ReportItem(name = "ruikeiKagoTanisu", length = 17, order = 31)
    public RString ruikeiKagoTanisu;
    @ReportItem(name = "ruikeiKagoChoseigaku", length = 17, order = 32)
    public RString ruikeiKagoChoseigaku;
    @ReportItem(name = "ruikeiSogojigyohi", length = 15, order = 33)
    public RString ruikeiSogojigyohi;
    @ReportItem(name = "ruikeiRiyoshaFutangaku", length = 15, order = 34)
    public RString ruikeiRiyoshaFutangaku;
    @ReportItem(name = "tesuryoSeikyugaku", length = 15, order = 35)
    public RString tesuryoSeikyugaku;
    @ReportItem(name = "tesuryoRuikeigaku", length = 15, order = 36)
    public RString tesuryoRuikeigaku;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>

    /**
     * KogakuKyufuTaishoshaIchiranSourceのENUM
     */
    public enum DBC200068SogojigyohiSeikyugakuFields {

        printTimeStamp,
        shinsaYM,
        hokenshaNo,
        hokenshaName,
        kokuhorenName,
        kanName,
        kouName,
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
        gokeiTsujoKensu,
        gokeiTsujoTanisu,
        gokeiTsujoKingaku,
        gokeiKagoKensu,
        gokeiKagoTanisu,
        gokeiKagoChoseigaku,
        gokeiSogojigyohi,
        gokeiRiyoshaFutangaku,
        ruikeiTsujoKensu,
        ruikeiTsujoTanisu,
        ruikeiTsujoKingaku,
        ruikeiKagoKensu,
        ruikeiKagoTanisu,
        ruikeiKagoChoseigaku,
        ruikeiSogojigyohi,
        ruikeiRiyoshaFutangaku,
        tesuryoSeikyugaku,
        tesuryoRuikeigaku
    }
}
