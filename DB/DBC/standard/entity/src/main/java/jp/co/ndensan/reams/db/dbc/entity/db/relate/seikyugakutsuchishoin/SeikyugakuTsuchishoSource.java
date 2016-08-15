package jp.co.ndensan.reams.db.dbc.entity.db.relate.seikyugakutsuchishoin;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 帳票設計_DBC200066_介護給付費等請求額通知書Source
 *
 * @reamsid_L DBC-2480-030 jiangwenkai
 */
public class SeikyugakuTsuchishoSource implements IReportSource {
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
    @ReportItem(name = "listMeisai_11", length = 17, order = 19)
    public RString listMeisai_11;
    @ReportItem(name = "gokeiTsujoKensu", length = 10, order = 20)
    public RString gokeiTsujoKensu;
    @ReportItem(name = "gokeiTsujoTanisu", length = 17, order = 21)
    public RString gokeiTsujoTanisu;
    @ReportItem(name = "gokeiTsujoKingaku", length = 15, order = 22)
    public RString gokeiTsujoKingaku;
    @ReportItem(name = "gokeiSaishinsaKagoKensu", length = 10, order = 23)
    public RString gokeiSaishinsaKagoKensu;
    @ReportItem(name = "gokeiSaishinsaKagoTanisu", length = 17, order = 24)
    public RString gokeiSaishinsaKagoTanisu;
    @ReportItem(name = "gokeiSaishinsaKagoChoseigaku", length = 17, order = 25)
    public RString gokeiSaishinsaKagoChoseigaku;
    @ReportItem(name = "gokeiKaigoKyufugaku", length = 15, order = 26)
    public RString gokeiKaigoKyufugaku;
    @ReportItem(name = "gokeiRiyoshaFutangaku", length = 15, order = 27)
    public RString gokeiRiyoshaFutangaku;
    @ReportItem(name = "gokeiKohiFutangaku", length = 17, order = 28)
    public RString gokeiKohiFutangaku;
    @ReportItem(name = "ruikeiTsujoKensu", length = 10, order = 29)
    public RString ruikeiTsujoKensu;
    @ReportItem(name = "ruikeiTsujoTanisu", length = 15, order = 30)
    public RString ruikeiTsujoTanisu;
    @ReportItem(name = "ruikeiTsujoKingaku", length = 15, order = 31)
    public RString ruikeiTsujoKingaku;
    @ReportItem(name = "ruikeiSaishinsaKagoKensu", length = 10, order = 32)
    public RString ruikeiSaishinsaKagoKensu;
    @ReportItem(name = "ruikeiSaishinsaKagoTanisu", length = 17, order = 33)
    public RString ruikeiSaishinsaKagoTanisu;
    @ReportItem(name = "ruikeiSaishinsaKagoChoseigaku", length = 17, order = 34)
    public RString ruikeiSaishinsaKagoChoseigaku;
    @ReportItem(name = "ruikeiKaigoKyufugaku", length = 15, order = 35)
    public RString ruikeiKaigoKyufugaku;
    @ReportItem(name = "ruikeiRiyoshaFutangaku", length = 15, order = 36)
    public RString ruikeiRiyoshaFutangaku;
    @ReportItem(name = "ruikeiKohiFutangaku", length = 17, order = 37)
    public RString ruikeiKohiFutangaku;
    @ReportItem(name = "tesuryoSeikyugaku", length = 15, order = 38)
    public RString tesuryoSeikyugaku;
    @ReportItem(name = "tesuryoRuikeigaku", length = 15, order = 39)
    public RString tesuryoRuikeigaku;

    /**
     * SeikyugakuTsuchishoSourceSourceのENUM
     */
    public enum DBC200066SourceFields {

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
        listMeisai_11,
        gokeiTsujoKensu,
        gokeiTsujoTanisu,
        gokeiTsujoKingaku,
        gokeiSaishinsaKagoKensu,
        gokeiSaishinsaKagoTanisu,
        gokeiSaishinsaKagoChoseigaku,
        gokeiKaigoKyufugaku,
        gokeiRiyoshaFutangaku,
        gokeiKohiFutangaku,
        ruikeiTsujoKensu,
        ruikeiTsujoTanisu,
        ruikeiTsujoKingaku,
        ruikeiSaishinsaKagoKensu,
        ruikeiSaishinsaKagoTanisu,
        ruikeiSaishinsaKagoChoseigaku,
        ruikeiKaigoKyufugaku,
        ruikeiRiyoshaFutangaku,
        ruikeiKohiFutangaku,
        tesuryoSeikyugaku,
        tesuryoRuikeigaku
    }

}
