package jp.co.ndensan.reams.db.dbc.entity.report.source.jukyushajyufujissekidaicho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 受給者給付実績台帳 のReportSourceです。
 *
 * @reamsid_L DBC-3080-040 dangjingjing
 */
public class JukyushaKyufuJissekidaichoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "hokenshaCd", length = 6, order = 1)
    public RString hokenshaCd;
    @ReportItem(name = "hokenshaMei", length = 12, order = 2)
    public RString hokenshaMei;
    @ReportItem(name = "pagecnt", length = 6, order = 3)
    public RString pagecnt;
    @ReportItem(name = "hihoNo", length = 10, order = 4)
    public RString hihoNo;
    @ReportItem(name = "tsuchiNoPage", length = 2, order = 5)
    public RString tsuchiNoPage;
    @ReportItem(name = "tsuchiNoAllPage", length = 2, order = 6)
    public RString tsuchiNoAllPage;
    @ReportItem(name = "hihoNameKana", length = 30, order = 7)
    public RString hihoNameKana;
    @ReportItem(name = "jissekiKbnMei", length = 2, order = 8)
    public RString jissekiKbnMei;
    @ReportItem(name = "umareYmd", length = 10, order = 9)
    public RString umareYmd;
    @ReportItem(name = "seibetsu", length = 1, order = 10)
    public RString seibetsu;
    @ReportItem(name = "youKaigoKbnMei", length = 4, order = 11)
    public RString youKaigoKbnMei;
    @ReportItem(name = "ninYmdStEd", length = 19, order = 12)
    public RString ninYmdStEd;
    @ReportItem(name = "shoHokenshaNo", length = 8, order = 13)
    public RString shoHokenshaNo;
    @ReportItem(name = "rokenCityNo", length = 8, order = 14)
    public RString rokenCityNo;
    @ReportItem(name = "rokenJukyuNo", length = 7, order = 15)
    public RString rokenJukyuNo;
    @ReportItem(name = "kyusochiKbnMei", length = 4, order = 16)
    public RString kyusochiKbnMei;
    @ReportItem(name = "keikokuKbnMei", length = 4, order = 17)
    public RString keikokuKbnMei;
    @ReportItem(name = "shinsaYmKihon", length = 6, order = 18)
    public RString shinsaYmKihon;
    @ReportItem(name = "hihoName", length = 30, order = 19)
    public RString hihoName;
    @ReportItem(name = "juminCd", length = 15, order = 20)
    public RString juminCd;
    @ReportItem(name = "jushoCd", length = 11, order = 21)
    public RString jushoCd;
    @ReportItem(name = "gyoseikuCd", length = 11, order = 22)
    public RString gyoseikuCd;
    @ReportItem(name = "serviceYm", length = 6, order = 23)
    public RString serviceYm;
    @ReportItem(name = "kokiHokenshano", length = 8, order = 24)
    public RString kokiHokenshano;
    @ReportItem(name = "kokiHihokenshano", length = 8, order = 25)
    public RString kokiHihokenshano;
    @ReportItem(name = "kokuhoHokenshano", length = 8, order = 26)
    public RString kokuhoHokenshano;
    @ReportItem(name = "kokuhoHihokenshashono", length = 20, order = 27)
    public RString kokuhoHihokenshashono;
    @ReportItem(name = "kokuhoKojinno", length = 10, order = 28)
    public RString kokuhoKojinno;
    @ReportItem(name = "setaiCd", length = 12, order = 29)
    public RString setaiCd;
    @ReportItem(name = "jusho", length = 30, order = 30)
    public RString jusho;
    @ReportItem(name = "gyoseiku", length = 13, order = 31)
    public RString gyoseiku;
    @ReportItem(name = "kihon1Hdr", length = 6, order = 32)
    public RString kihon1Hdr;
    @ReportItem(name = "kihon3Hdr", length = 6, order = 33)
    public RString kihon3Hdr;
    @ReportItem(name = "kihon2Hdr", length = 6, order = 34)
    public RString kihon2Hdr;
    @ReportItem(name = "kihon4Hdr", length = 6, order = 35)
    public RString kihon4Hdr;
    @ReportItem(name = "maeHkFutan", length = 10, order = 36)
    public RString maeHkFutan;
    @ReportItem(name = "serviceSakuseiKbn1", length = 5, order = 37)
    public RString serviceSakuseiKbn1;
    @ReportItem(name = "serviceJigyoshoNo", length = 10, order = 38)
    public RString serviceJigyoshoNo;
    @ReportItem(name = "serJigyoshoMei1", length = 14, order = 39)
    public RString serJigyoshoMei1;
    @ReportItem(name = "maeHkServiceTen", length = 10, order = 40)
    public RString maeHkServiceTen;
    @ReportItem(name = "maeHkSeikyu", length = 11, order = 41)
    public RString maeHkSeikyu;
    @ReportItem(name = "maeHkRSSeikyu", length = 11, order = 42)
    public RString maeHkRSSeikyu;
    @ReportItem(name = "maeHkTokuSeikyu", length = 11, order = 43)
    public RString maeHkTokuSeikyu;
    @ReportItem(name = "maeHkShokuSeikyu", length = 10, order = 44)
    public RString maeHkShokuSeikyu;
    @ReportItem(name = "gaihakuNissu", length = 3, order = 45)
    public RString gaihakuNissu;
    @ReportItem(name = "seiriNo", length = 10, order = 46)
    public RString seiriNo;
    @ReportItem(name = "nyushoYmdStEd", length = 19, order = 47)
    public RString nyushoYmdStEd;
    @ReportItem(name = "nyushoNissu", length = 3, order = 48)
    public RString nyushoNissu;
    @ReportItem(name = "hkKyufuRitsu", length = 3, order = 49)
    public RString hkKyufuRitsu;
    @ReportItem(name = "serviceSakuseiKbn2", length = 5, order = 50)
    public RString serviceSakuseiKbn2;
    @ReportItem(name = "serJigyoshoMei2", length = 14, order = 51)
    public RString serJigyoshoMei2;
    @ReportItem(name = "atoHkServiceTen", length = 10, order = 52)
    public RString atoHkServiceTen;
    @ReportItem(name = "atoHkSeikyu", length = 11, order = 53)
    public RString atoHkSeikyu;
    @ReportItem(name = "atoHkFutan", length = 10, order = 54)
    public RString atoHkFutan;
    @ReportItem(name = "atoHkRSSeikyu", length = 11, order = 55)
    public RString atoHkRSSeikyu;
    @ReportItem(name = "atoHkTokuSeikyu", length = 11, order = 56)
    public RString atoHkTokuSeikyu;
    @ReportItem(name = "atoHkShokuSeikyu", length = 10, order = 57)
    public RString atoHkShokuSeikyu;
    @ReportItem(name = "maeK1ServiceTen", length = 10, order = 58)
    public RString maeK1ServiceTen;
    @ReportItem(name = "maeK1Seikyu", length = 11, order = 59)
    public RString maeK1Seikyu;
    @ReportItem(name = "maeK1Futan", length = 10, order = 60)
    public RString maeK1Futan;
    @ReportItem(name = "maeK1RSSeikyu", length = 11, order = 61)
    public RString maeK1RSSeikyu;
    @ReportItem(name = "maeK1TokuSeikyu", length = 11, order = 62)
    public RString maeK1TokuSeikyu;
    @ReportItem(name = "maeK1ShokuSeikyu", length = 10, order = 63)
    public RString maeK1ShokuSeikyu;
    @ReportItem(name = "youshiki", length = 15, order = 64)
    public RString youshiki;
    @ReportItem(name = "k1JukyushaNo", length = 7, order = 65)
    public RString k1JukyushaNo;
    @ReportItem(name = "k1KyufuRitsu", length = 3, order = 66)
    public RString k1KyufuRitsu;
    @ReportItem(name = "k1FutanshaNo", length = 8, order = 67)
    public RString k1FutanshaNo;
    @ReportItem(name = "atoK1ServiceTen", length = 10, order = 68)
    public RString atoK1ServiceTen;
    @ReportItem(name = "atoK1Seikyu", length = 11, order = 69)
    public RString atoK1Seikyu;
    @ReportItem(name = "atoK1Futan", length = 10, order = 70)
    public RString atoK1Futan;
    @ReportItem(name = "atoK1RSSeikyu", length = 11, order = 71)
    public RString atoK1RSSeikyu;
    @ReportItem(name = "atoK1TokuSeikyu", length = 11, order = 72)
    public RString atoK1TokuSeikyu;
    @ReportItem(name = "atoK1ShokuSeikyu", length = 10, order = 73)
    public RString atoK1ShokuSeikyu;
    @ReportItem(name = "maeK2Seikyu", length = 11, order = 74)
    public RString maeK2Seikyu;
    @ReportItem(name = "maeK2Futan", length = 10, order = 75)
    public RString maeK2Futan;
    @ReportItem(name = "youshikiMei1", length = 20, order = 76)
    public RString youshikiMei1;
    @ReportItem(name = "jigyoshoNo", length = 10, order = 77)
    public RString jigyoshoNo;
    @ReportItem(name = "maeK2ServiceTen", length = 10, order = 78)
    public RString maeK2ServiceTen;
    @ReportItem(name = "maeK2RSSeikyu", length = 11, order = 79)
    public RString maeK2RSSeikyu;
    @ReportItem(name = "maeK2TokuSeikyu", length = 11, order = 80)
    public RString maeK2TokuSeikyu;
    @ReportItem(name = "maeK2ShokuSeikyu", length = 10, order = 81)
    public RString maeK2ShokuSeikyu;
    @ReportItem(name = "k2JukyushaNo", length = 7, order = 82)
    public RString k2JukyushaNo;
    @ReportItem(name = "k2KyufuRitsu", length = 3, order = 83)
    public RString k2KyufuRitsu;
    @ReportItem(name = "taishogoJotai", length = 10, order = 84)
    public RString taishogoJotai;
    @ReportItem(name = "k2FutanshaNo", length = 8, order = 85)
    public RString k2FutanshaNo;
    @ReportItem(name = "youshikiMei2", length = 20, order = 86)
    public RString youshikiMei2;
    @ReportItem(name = "jigyoshoMei", length = 25, order = 87)
    public RString jigyoshoMei;
    @ReportItem(name = "atoK2ServiceTen", length = 10, order = 88)
    public RString atoK2ServiceTen;
    @ReportItem(name = "atoK2Seikyu", length = 11, order = 89)
    public RString atoK2Seikyu;
    @ReportItem(name = "atoK2Futan", length = 10, order = 90)
    public RString atoK2Futan;
    @ReportItem(name = "atoK2RSSeikyu", length = 11, order = 91)
    public RString atoK2RSSeikyu;
    @ReportItem(name = "atoK2TokuSeikyu", length = 11, order = 92)
    public RString atoK2TokuSeikyu;
    @ReportItem(name = "atoK2ShokuSeikyu", length = 10, order = 93)
    public RString atoK2ShokuSeikyu;
    @ReportItem(name = "maeK3ServiceTen", length = 10, order = 94)
    public RString maeK3ServiceTen;
    @ReportItem(name = "maeK3Seikyu", length = 11, order = 95)
    public RString maeK3Seikyu;
    @ReportItem(name = "maeK3Futan", length = 10, order = 96)
    public RString maeK3Futan;
    @ReportItem(name = "maeK3RSSeikyu", length = 11, order = 97)
    public RString maeK3RSSeikyu;
    @ReportItem(name = "maeK3TokuSeikyu", length = 11, order = 98)
    public RString maeK3TokuSeikyu;
    @ReportItem(name = "maeK3ShokuSeikyu", length = 10, order = 99)
    public RString maeK3ShokuSeikyu;
    @ReportItem(name = "k3KyufuRitsu", length = 3, order = 100)
    public RString k3KyufuRitsu;
    @ReportItem(name = "serviceYmdStEd", length = 19, order = 101)
    public RString serviceYmdStEd;
    @ReportItem(name = "chushiriyuTitle", length = 9, order = 102)
    public RString chushiriyuTitle;
    @ReportItem(name = "chushiRiyu", length = 20, order = 103)
    public RString chushiRiyu;
    @ReportItem(name = "k3FutanshaNo", length = 8, order = 104)
    public RString k3FutanshaNo;
    @ReportItem(name = "k3JukyushaNo", length = 7, order = 105)
    public RString k3JukyushaNo;
    @ReportItem(name = "atoK3ServiceTen", length = 10, order = 106)
    public RString atoK3ServiceTen;
    @ReportItem(name = "atoK3Seikyu", length = 11, order = 107)
    public RString atoK3Seikyu;
    @ReportItem(name = "atoK3Futan", length = 10, order = 108)
    public RString atoK3Futan;
    @ReportItem(name = "atoK3RSSeikyu", length = 11, order = 109)
    public RString atoK3RSSeikyu;
    @ReportItem(name = "atoK3TokuSeikyu", length = 11, order = 110)
    public RString atoK3TokuSeikyu;
    @ReportItem(name = "atoK3ShokuSeikyu", length = 10, order = 111)
    public RString atoK3ShokuSeikyu;
    @ReportItem(name = "maeKaiNichi1", length = 2, order = 112)
    public RString maeKaiNichi1;
    @ReportItem(name = "maeSerTani1", length = 7, order = 113)
    public RString maeSerTani1;
    @ReportItem(name = "maeK1KaiNichi1", length = 2, order = 114)
    public RString maeK1KaiNichi1;
    @ReportItem(name = "maeK1SerTani1", length = 7, order = 115)
    public RString maeK1SerTani1;
    @ReportItem(name = "maeTanisu1", length = 5, order = 116)
    public RString maeTanisu1;
    @ReportItem(name = "maeK2KaiNichi1", length = 2, order = 117)
    public RString maeK2KaiNichi1;
    @ReportItem(name = "maeK2SerTani1", length = 7, order = 118)
    public RString maeK2SerTani1;
    @ReportItem(name = "maeK3KaiNichi1", length = 2, order = 119)
    public RString maeK3KaiNichi1;
    @ReportItem(name = "maeK3SerTani1", length = 7, order = 120)
    public RString maeK3SerTani1;
    @ReportItem(name = "serviceCd1", length = 6, order = 121)
    public RString serviceCd1;
    @ReportItem(name = "kagoKaisuD1", length = 3, order = 122)
    public RString kagoKaisuD1;
    @ReportItem(name = "serviceMei1", length = 25, order = 123)
    public RString serviceMei1;
    @ReportItem(name = "taniShikibetsu1", length = 9, order = 124)
    public RString taniShikibetsu1;
    @ReportItem(name = "tekiyo1", length = 20, order = 125)
    public RString tekiyo1;
    @ReportItem(name = "saishinKaisuD1", length = 3, order = 126)
    public RString saishinKaisuD1;
    @ReportItem(name = "shinsaYmD1", length = 6, order = 127)
    public RString shinsaYmD1;
    @ReportItem(name = "atoTanisu1", length = 5, order = 128)
    public RString atoTanisu1;
    @ReportItem(name = "atoKaiNichi1", length = 2, order = 129)
    public RString atoKaiNichi1;
    @ReportItem(name = "atoSerTani1", length = 7, order = 130)
    public RString atoSerTani1;
    @ReportItem(name = "atoK1KaiNichi1", length = 2, order = 131)
    public RString atoK1KaiNichi1;
    @ReportItem(name = "atoK1SerTani1", length = 7, order = 132)
    public RString atoK1SerTani1;
    @ReportItem(name = "atoK2KaiNichi1", length = 2, order = 133)
    public RString atoK2KaiNichi1;
    @ReportItem(name = "atoK2SerTani1", length = 7, order = 134)
    public RString atoK2SerTani1;
    @ReportItem(name = "atoK3KaiNichi1", length = 2, order = 135)
    public RString atoK3KaiNichi1;
    @ReportItem(name = "atoK3SerTani1", length = 7, order = 136)
    public RString atoK3SerTani1;
    @ReportItem(name = "maeTanisu2", length = 5, order = 137)
    public RString maeTanisu2;
    @ReportItem(name = "maeKaiNichi2", length = 2, order = 138)
    public RString maeKaiNichi2;
    @ReportItem(name = "maeSerTani2", length = 7, order = 139)
    public RString maeSerTani2;
    @ReportItem(name = "maeK1KaiNichi2", length = 2, order = 140)
    public RString maeK1KaiNichi2;
    @ReportItem(name = "maeK1SerTani2", length = 7, order = 141)
    public RString maeK1SerTani2;
    @ReportItem(name = "maeK2KaiNichi2", length = 2, order = 142)
    public RString maeK2KaiNichi2;
    @ReportItem(name = "maeK2SerTani2", length = 7, order = 143)
    public RString maeK2SerTani2;
    @ReportItem(name = "maeK3KaiNichi2", length = 2, order = 144)
    public RString maeK3KaiNichi2;
    @ReportItem(name = "maeK3SerTani2", length = 7, order = 145)
    public RString maeK3SerTani2;
    @ReportItem(name = "serviceCd2", length = 6, order = 146)
    public RString serviceCd2;
    @ReportItem(name = "serviceMei2", length = 25, order = 147)
    public RString serviceMei2;
    @ReportItem(name = "tekiyo2", length = 20, order = 148)
    public RString tekiyo2;
    @ReportItem(name = "saishinKaisuD2", length = 3, order = 149)
    public RString saishinKaisuD2;
    @ReportItem(name = "kagoKaisuD2", length = 3, order = 150)
    public RString kagoKaisuD2;
    @ReportItem(name = "shinsaYmD2", length = 6, order = 151)
    public RString shinsaYmD2;
    @ReportItem(name = "taniShikibetsu2", length = 9, order = 152)
    public RString taniShikibetsu2;
    @ReportItem(name = "atoTanisu2", length = 5, order = 153)
    public RString atoTanisu2;
    @ReportItem(name = "atoKaiNichi2", length = 2, order = 154)
    public RString atoKaiNichi2;
    @ReportItem(name = "atoSerTani2", length = 7, order = 155)
    public RString atoSerTani2;
    @ReportItem(name = "atoK1KaiNichi2", length = 2, order = 156)
    public RString atoK1KaiNichi2;
    @ReportItem(name = "atoK1SerTani2", length = 7, order = 157)
    public RString atoK1SerTani2;
    @ReportItem(name = "atoK2KaiNichi2", length = 2, order = 158)
    public RString atoK2KaiNichi2;
    @ReportItem(name = "atoK2SerTani2", length = 7, order = 159)
    public RString atoK2SerTani2;
    @ReportItem(name = "atoK3KaiNichi2", length = 2, order = 160)
    public RString atoK3KaiNichi2;
    @ReportItem(name = "atoK3SerTani2", length = 7, order = 161)
    public RString atoK3SerTani2;
    @ReportItem(name = "maeTanisu3", length = 5, order = 162)
    public RString maeTanisu3;
    @ReportItem(name = "maeKaiNichi3", length = 2, order = 163)
    public RString maeKaiNichi3;
    @ReportItem(name = "maeSerTani3", length = 7, order = 164)
    public RString maeSerTani3;
    @ReportItem(name = "maeK1KaiNichi3", length = 2, order = 165)
    public RString maeK1KaiNichi3;
    @ReportItem(name = "maeK1SerTani3", length = 7, order = 166)
    public RString maeK1SerTani3;
    @ReportItem(name = "maeK2KaiNichi3", length = 2, order = 167)
    public RString maeK2KaiNichi3;
    @ReportItem(name = "maeK2SerTani3", length = 7, order = 168)
    public RString maeK2SerTani3;
    @ReportItem(name = "maeK3KaiNichi3", length = 2, order = 169)
    public RString maeK3KaiNichi3;
    @ReportItem(name = "maeK3SerTani3", length = 7, order = 170)
    public RString maeK3SerTani3;
    @ReportItem(name = "serviceCd3", length = 6, order = 171)
    public RString serviceCd3;
    @ReportItem(name = "tekiyo3", length = 20, order = 172)
    public RString tekiyo3;
    @ReportItem(name = "saishinKaisuD3", length = 3, order = 173)
    public RString saishinKaisuD3;
    @ReportItem(name = "kagoKaisuD3", length = 3, order = 174)
    public RString kagoKaisuD3;
    @ReportItem(name = "serviceMei3", length = 25, order = 175)
    public RString serviceMei3;
    @ReportItem(name = "taniShikibetsu3", length = 9, order = 176)
    public RString taniShikibetsu3;
    @ReportItem(name = "shinsaYmD3", length = 6, order = 177)
    public RString shinsaYmD3;
    @ReportItem(name = "atoK2KaiNichi3", length = 2, order = 178)
    public RString atoK2KaiNichi3;
    @ReportItem(name = "atoK3SerTani3", length = 7, order = 179)
    public RString atoK3SerTani3;
    @ReportItem(name = "atoTanisu3", length = 5, order = 180)
    public RString atoTanisu3;
    @ReportItem(name = "atoKaiNichi3", length = 2, order = 181)
    public RString atoKaiNichi3;
    @ReportItem(name = "atoSerTani3", length = 7, order = 182)
    public RString atoSerTani3;
    @ReportItem(name = "atoK1KaiNichi3", length = 2, order = 183)
    public RString atoK1KaiNichi3;
    @ReportItem(name = "atoK1SerTani3", length = 7, order = 184)
    public RString atoK1SerTani3;
    @ReportItem(name = "atoK2SerTani3", length = 7, order = 185)
    public RString atoK2SerTani3;
    @ReportItem(name = "atoK3KaiNichi3", length = 2, order = 186)
    public RString atoK3KaiNichi3;
    @ReportItem(name = "maeKou1Nissu1", length = 2, order = 187)
    public RString maeKou1Nissu1;
    @ReportItem(name = "maeKHiyougaku1", length = 7, order = 188)
    public RString maeKHiyougaku1;
    @ReportItem(name = "kServicecd1", length = 6, order = 189)
    public RString kServicecd1;
    @ReportItem(name = "maeKTanka1", length = 5, order = 190)
    public RString maeKTanka1;
    @ReportItem(name = "maeKNissu1", length = 2, order = 191)
    public RString maeKNissu1;
    @ReportItem(name = "maeKou2Nissu1", length = 2, order = 192)
    public RString maeKou2Nissu1;
    @ReportItem(name = "maeKou3Nissu1", length = 2, order = 193)
    public RString maeKou3Nissu1;
    @ReportItem(name = "maeKHknseikyu1", length = 7, order = 194)
    public RString maeKHknseikyu1;
    @ReportItem(name = "maeK1Hutangaku1", length = 7, order = 195)
    public RString maeK1Hutangaku1;
    @ReportItem(name = "maeK2Hutangaku1", length = 7, order = 196)
    public RString maeK2Hutangaku1;
    @ReportItem(name = "maeK3Hutangaku1", length = 7, order = 197)
    public RString maeK3Hutangaku1;
    @ReportItem(name = "maeKHutangaku1", length = 7, order = 198)
    public RString maeKHutangaku1;
    @ReportItem(name = "shinsaYmK1", length = 6, order = 199)
    public RString shinsaYmK1;
    @ReportItem(name = "kBango1", length = 2, order = 200)
    public RString kBango1;
    @ReportItem(name = "futanGendo1", length = 5, order = 201)
    public RString futanGendo1;
    @ReportItem(name = "saishinKaisuK1", length = 3, order = 202)
    public RString saishinKaisuK1;
    @ReportItem(name = "kagoKaisuK1", length = 3, order = 203)
    public RString kagoKaisuK1;
    @ReportItem(name = "atoKNissu1", length = 2, order = 204)
    public RString atoKNissu1;
    @ReportItem(name = "atoKou1Nissu1", length = 2, order = 205)
    public RString atoKou1Nissu1;
    @ReportItem(name = "kServicemei1", length = 25, order = 206)
    public RString kServicemei1;
    @ReportItem(name = "atoKTanka1", length = 5, order = 207)
    public RString atoKTanka1;
    @ReportItem(name = "atoKou2Nissu1", length = 2, order = 208)
    public RString atoKou2Nissu1;
    @ReportItem(name = "atoKou3Nissu1", length = 2, order = 209)
    public RString atoKou3Nissu1;
    @ReportItem(name = "atoKHknseikyu1", length = 7, order = 210)
    public RString atoKHknseikyu1;
    @ReportItem(name = "atoK1Hutangaku1", length = 7, order = 211)
    public RString atoK1Hutangaku1;
    @ReportItem(name = "atoK2Hutangaku1", length = 7, order = 212)
    public RString atoK2Hutangaku1;
    @ReportItem(name = "atoK3Hutangaku1", length = 7, order = 213)
    public RString atoK3Hutangaku1;
    @ReportItem(name = "atoKHutangaku1", length = 7, order = 214)
    public RString atoKHutangaku1;
    @ReportItem(name = "kServicecd2", length = 6, order = 215)
    public RString kServicecd2;
    @ReportItem(name = "maeKTanka2", length = 5, order = 216)
    public RString maeKTanka2;
    @ReportItem(name = "maeKNissu2", length = 2, order = 217)
    public RString maeKNissu2;
    @ReportItem(name = "maeKou1Nissu2", length = 2, order = 218)
    public RString maeKou1Nissu2;
    @ReportItem(name = "maeKou2Nissu2", length = 2, order = 219)
    public RString maeKou2Nissu2;
    @ReportItem(name = "maeKou3Nissu2", length = 2, order = 220)
    public RString maeKou3Nissu2;
    @ReportItem(name = "maeKHiyougaku2", length = 7, order = 221)
    public RString maeKHiyougaku2;
    @ReportItem(name = "maeKHknseikyu2", length = 7, order = 222)
    public RString maeKHknseikyu2;
    @ReportItem(name = "maeK1Hutangaku2", length = 7, order = 223)
    public RString maeK1Hutangaku2;
    @ReportItem(name = "maeK2Hutangaku2", length = 7, order = 224)
    public RString maeK2Hutangaku2;
    @ReportItem(name = "maeK3Hutangaku2", length = 7, order = 225)
    public RString maeK3Hutangaku2;
    @ReportItem(name = "maeKHutangaku2", length = 7, order = 226)
    public RString maeKHutangaku2;
    @ReportItem(name = "maeKeHiyogaku", length = 7, order = 227)
    public RString maeKeHiyogaku;
    @ReportItem(name = "maeKeSeikyugaku", length = 7, order = 228)
    public RString maeKeSeikyugaku;
    @ReportItem(name = "maeKeHutangaku", length = 7, order = 229)
    public RString maeKeHutangaku;
    @ReportItem(name = "maeKe2Hiyogaku", length = 7, order = 230)
    public RString maeKe2Hiyogaku;
    @ReportItem(name = "maeKe2Seikyugaku", length = 7, order = 231)
    public RString maeKe2Seikyugaku;
    @ReportItem(name = "maeKe2Hutangaku", length = 7, order = 232)
    public RString maeKe2Hutangaku;
    @ReportItem(name = "atoKHiyougaku1", length = 7, order = 233)
    public RString atoKHiyougaku1;
    @ReportItem(name = "shinsaYmK2", length = 6, order = 234)
    public RString shinsaYmK2;
    @ReportItem(name = "kBango2", length = 2, order = 235)
    public RString kBango2;
    @ReportItem(name = "futanGendo2", length = 5, order = 236)
    public RString futanGendo2;
    @ReportItem(name = "saishinKaisuK2", length = 3, order = 237)
    public RString saishinKaisuK2;
    @ReportItem(name = "kagoKaisuK2", length = 3, order = 238)
    public RString kagoKaisuK2;
    @ReportItem(name = "atoKNissu2", length = 2, order = 239)
    public RString atoKNissu2;
    @ReportItem(name = "atoKou1Nissu2", length = 2, order = 240)
    public RString atoKou1Nissu2;
    @ReportItem(name = "kServicemei2", length = 25, order = 241)
    public RString kServicemei2;
    @ReportItem(name = "atoKTanka2", length = 5, order = 242)
    public RString atoKTanka2;
    @ReportItem(name = "atoKou2Nissu2", length = 2, order = 243)
    public RString atoKou2Nissu2;
    @ReportItem(name = "atoKou3Nissu2", length = 2, order = 244)
    public RString atoKou3Nissu2;
    @ReportItem(name = "atoKHiyougaku2", length = 7, order = 245)
    public RString atoKHiyougaku2;
    @ReportItem(name = "atoKHknseikyu2", length = 7, order = 246)
    public RString atoKHknseikyu2;
    @ReportItem(name = "atoK1Hutangaku2", length = 7, order = 247)
    public RString atoK1Hutangaku2;
    @ReportItem(name = "atoK2Hutangaku2", length = 7, order = 248)
    public RString atoK2Hutangaku2;
    @ReportItem(name = "atoK3Hutangaku2", length = 7, order = 249)
    public RString atoK3Hutangaku2;
    @ReportItem(name = "atoKHutangaku2", length = 7, order = 250)
    public RString atoKHutangaku2;
    @ReportItem(name = "atoKeHiyogaku", length = 7, order = 251)
    public RString atoKeHiyogaku;
    @ReportItem(name = "atoKeSeikyugaku", length = 7, order = 252)
    public RString atoKeSeikyugaku;
    @ReportItem(name = "atoKeHutangaku", length = 7, order = 253)
    public RString atoKeHutangaku;
    @ReportItem(name = "atoKe2Hiyogaku", length = 7, order = 254)
    public RString atoKe2Hiyogaku;
    @ReportItem(name = "atoKe2Seikyugaku", length = 7, order = 255)
    public RString atoKe2Seikyugaku;
    @ReportItem(name = "atoKe2Hutangaku", length = 7, order = 256)
    public RString atoKe2Hutangaku;
    @ReportItem(name = "kServicecd3", length = 6, order = 257)
    public RString kServicecd3;
    @ReportItem(name = "maeKTanka3", length = 5, order = 258)
    public RString maeKTanka3;
    @ReportItem(name = "maeKNissu3", length = 2, order = 259)
    public RString maeKNissu3;
    @ReportItem(name = "maeKou1Nissu3", length = 2, order = 260)
    public RString maeKou1Nissu3;
    @ReportItem(name = "maeKou2Nissu3", length = 2, order = 261)
    public RString maeKou2Nissu3;
    @ReportItem(name = "maeKou3Nissu3", length = 2, order = 262)
    public RString maeKou3Nissu3;
    @ReportItem(name = "maeKHiyougaku3", length = 7, order = 263)
    public RString maeKHiyougaku3;
    @ReportItem(name = "maeKHknseikyu3", length = 7, order = 264)
    public RString maeKHknseikyu3;
    @ReportItem(name = "maeK1Hutangaku3", length = 7, order = 265)
    public RString maeK1Hutangaku3;
    @ReportItem(name = "maeK2Hutangaku3", length = 7, order = 266)
    public RString maeK2Hutangaku3;
    @ReportItem(name = "maeK3Hutangaku3", length = 7, order = 267)
    public RString maeK3Hutangaku3;
    @ReportItem(name = "maeKHutangaku3", length = 7, order = 268)
    public RString maeKHutangaku3;
    @ReportItem(name = "maeKe1Hiyogaku", length = 7, order = 269)
    public RString maeKe1Hiyogaku;
    @ReportItem(name = "maeKe1Seikyugaku", length = 7, order = 270)
    public RString maeKe1Seikyugaku;
    @ReportItem(name = "maeKe1Hutangaku", length = 7, order = 271)
    public RString maeKe1Hutangaku;
    @ReportItem(name = "maeKe3Hiyogaku", length = 7, order = 272)
    public RString maeKe3Hiyogaku;
    @ReportItem(name = "maeKe3Seikyugaku", length = 7, order = 273)
    public RString maeKe3Seikyugaku;
    @ReportItem(name = "maeKe3Hutangaku", length = 7, order = 274)
    public RString maeKe3Hutangaku;
    @ReportItem(name = "kBango3", length = 2, order = 275)
    public RString kBango3;
    @ReportItem(name = "shinsaYmK3", length = 6, order = 276)
    public RString shinsaYmK3;
    @ReportItem(name = "futanGendo3", length = 5, order = 277)
    public RString futanGendo3;
    @ReportItem(name = "saishinKaisuK3", length = 3, order = 278)
    public RString saishinKaisuK3;
    @ReportItem(name = "kagoKaisuK3", length = 3, order = 279)
    public RString kagoKaisuK3;
    @ReportItem(name = "atoKou1Nissu3", length = 2, order = 280)
    public RString atoKou1Nissu3;
    @ReportItem(name = "atoKou2Nissu3", length = 2, order = 281)
    public RString atoKou2Nissu3;
    @ReportItem(name = "kServicemei3", length = 25, order = 282)
    public RString kServicemei3;
    @ReportItem(name = "atoKTanka3", length = 5, order = 283)
    public RString atoKTanka3;
    @ReportItem(name = "atoKNissu3", length = 2, order = 284)
    public RString atoKNissu3;
    @ReportItem(name = "atoKou3Nissu3", length = 2, order = 285)
    public RString atoKou3Nissu3;
    @ReportItem(name = "atoKHiyougaku3", length = 7, order = 286)
    public RString atoKHiyougaku3;
    @ReportItem(name = "atoKHknseikyu3", length = 7, order = 287)
    public RString atoKHknseikyu3;
    @ReportItem(name = "atoK1Hutangaku3", length = 7, order = 288)
    public RString atoK1Hutangaku3;
    @ReportItem(name = "atoK2Hutangaku3", length = 7, order = 289)
    public RString atoK2Hutangaku3;
    @ReportItem(name = "atoK3Hutangaku3", length = 7, order = 290)
    public RString atoK3Hutangaku3;
    @ReportItem(name = "atoKHutangaku3", length = 7, order = 291)
    public RString atoKHutangaku3;
    @ReportItem(name = "atoKe1Hiyogaku", length = 7, order = 292)
    public RString atoKe1Hiyogaku;
    @ReportItem(name = "atoKe1Seikyugaku", length = 7, order = 293)
    public RString atoKe1Seikyugaku;
    @ReportItem(name = "atoKe1Hutangaku", length = 7, order = 294)
    public RString atoKe1Hutangaku;
    @ReportItem(name = "atoKe3Hiyogaku", length = 7, order = 295)
    public RString atoKe3Hiyogaku;
    @ReportItem(name = "atoKe3Seikyugaku", length = 7, order = 296)
    public RString atoKe3Seikyugaku;
    @ReportItem(name = "atoKe3Hutangaku", length = 7, order = 297)
    public RString atoKe3Hutangaku;
    @ReportItem(name = "tanKeikakuNissu1", length = 4, order = 298)
    public RString tanKeikakuNissu1;
    @ReportItem(name = "tanNsJituNissu1", length = 5, order = 299)
    public RString tanNsJituNissu1;
    @ReportItem(name = "hdr1", length = 84, order = 300)
    public RString hdr1;
    @ReportItem(name = "hdr4", length = 64, order = 301)
    public RString hdr4;
    @ReportItem(name = "hdr2", length = 84, order = 302)
    public RString hdr2;
    @ReportItem(name = "hdr5", length = 64, order = 303)
    public RString hdr5;
    @ReportItem(name = "tanNsJituNissu2", length = 5, order = 304)
    public RString tanNsJituNissu2;
    @ReportItem(name = "tanKeikakuNissu2", length = 4, order = 305)
    public RString tanKeikakuNissu2;
    @ReportItem(name = "hdr3", length = 84, order = 306)
    public RString hdr3;
    @ReportItem(name = "hdr6", length = 64, order = 307)
    public RString hdr6;
    @ReportItem(name = "tanNsJituNissu3", length = 10, order = 308)
    public RString tanNsJituNissu3;
    @ReportItem(name = "serviceShuMei1", length = 10, order = 309)
    public RString serviceShuMei1;
    @ReportItem(name = "maeTankiNissu", length = 3, order = 310)
    public RString maeTankiNissu;
    @ReportItem(name = "meisai1", length = 84, order = 311)
    public RString meisai1;
    @ReportItem(name = "tekiyoS1", length = 64, order = 312)
    public RString tekiyoS1;
    @ReportItem(name = "serviceShu", length = 2, order = 313)
    public RString serviceShu;
    @ReportItem(name = "gendoTaishoTani", length = 7, order = 314)
    public RString gendoTaishoTani;
    @ReportItem(name = "gendoTaishogaiTani", length = 7, order = 315)
    public RString gendoTaishogaiTani;
    @ReportItem(name = "serviceNissu", length = 3, order = 316)
    public RString serviceNissu;
    @ReportItem(name = "keikakuTanisu", length = 7, order = 317)
    public RString keikakuTanisu;
    @ReportItem(name = "tankiNissu", length = 4, order = 318)
    public RString tankiNissu;
    @ReportItem(name = "meisai2", length = 84, order = 319)
    public RString meisai2;
    @ReportItem(name = "tekiyoS2", length = 64, order = 320)
    public RString tekiyoS2;
    @ReportItem(name = "serviceShuMei2", length = 10, order = 321)
    public RString serviceShuMei2;
    @ReportItem(name = "atoTankiNissu", length = 3, order = 322)
    public RString atoTankiNissu;
    @ReportItem(name = "meisai3", length = 84, order = 323)
    public RString meisai3;
    @ReportItem(name = "tekiyoS3", length = 64, order = 324)
    public RString tekiyoS3;
    @ReportItem(name = "meisai4", length = 84, order = 325)
    public RString meisai4;
    @ReportItem(name = "tekiyoS4", length = 64, order = 326)
    public RString tekiyoS4;
    @ReportItem(name = "meisai5", length = 84, order = 327)
    public RString meisai5;
    @ReportItem(name = "tekiyoS5", length = 64, order = 328)
    public RString tekiyoS5;
    @ReportItem(name = "meisai6", length = 84, order = 329)
    public RString meisai6;
    @ReportItem(name = "tekiyoS6", length = 64, order = 330)
    public RString tekiyoS6;
    @ReportItem(name = "maeHkTaniGokei", length = 10, order = 331)
    public RString maeHkTaniGokei;
    @ReportItem(name = "tanisuTanka", length = 5, order = 332)
    public RString tanisuTanka;
    @ReportItem(name = "maeHkSeikyuGaku", length = 11, order = 333)
    public RString maeHkSeikyuGaku;
    @ReportItem(name = "hkFutanGaku", length = 10, order = 334)
    public RString hkFutanGaku;
    @ReportItem(name = "maeHkIryoTanisu", length = 10, order = 335)
    public RString maeHkIryoTanisu;
    @ReportItem(name = "maeHkIryoSeikyu", length = 11, order = 336)
    public RString maeHkIryoSeikyu;
    @ReportItem(name = "hkIryoFutan", length = 11, order = 337)
    public RString hkIryoFutan;
    @ReportItem(name = "meisai7", length = 84, order = 338)
    public RString meisai7;
    @ReportItem(name = "tekiyoS7", length = 64, order = 339)
    public RString tekiyoS7;
    @ReportItem(name = "meisai8", length = 84, order = 340)
    public RString meisai8;
    @ReportItem(name = "tekiyoS8", length = 64, order = 341)
    public RString tekiyoS8;
    @ReportItem(name = "atoHkIryoTanisu", length = 10, order = 342)
    public RString atoHkIryoTanisu;
    @ReportItem(name = "meisai9", length = 84, order = 343)
    public RString meisai9;
    @ReportItem(name = "atoHkTaniGokei", length = 10, order = 344)
    public RString atoHkTaniGokei;
    @ReportItem(name = "atoHkSeikyuGaku", length = 11, order = 345)
    public RString atoHkSeikyuGaku;
    @ReportItem(name = "atoHkIryoSeikyu", length = 11, order = 346)
    public RString atoHkIryoSeikyu;
    @ReportItem(name = "tekiyoS9", length = 64, order = 347)
    public RString tekiyoS9;
    @ReportItem(name = "k1FutanGaku", length = 10, order = 348)
    public RString k1FutanGaku;
    @ReportItem(name = "maeK1IryoTanisu", length = 10, order = 349)
    public RString maeK1IryoTanisu;
    @ReportItem(name = "k1IryoFutan", length = 11, order = 350)
    public RString k1IryoFutan;
    @ReportItem(name = "meisai10", length = 84, order = 351)
    public RString meisai10;
    @ReportItem(name = "maeK1TaniGokei", length = 10, order = 352)
    public RString maeK1TaniGokei;
    @ReportItem(name = "maeK1SeikyuGaku", length = 11, order = 353)
    public RString maeK1SeikyuGaku;
    @ReportItem(name = "maeK1IryoSeikyu", length = 11, order = 354)
    public RString maeK1IryoSeikyu;
    @ReportItem(name = "tekiyoS10", length = 64, order = 355)
    public RString tekiyoS10;
    @ReportItem(name = "meisai11", length = 84, order = 356)
    public RString meisai11;
    @ReportItem(name = "tekiyoS11", length = 64, order = 357)
    public RString tekiyoS11;
    @ReportItem(name = "atoK1IryoTanisu", length = 10, order = 358)
    public RString atoK1IryoTanisu;
    @ReportItem(name = "meisai12", length = 84, order = 359)
    public RString meisai12;
    @ReportItem(name = "atoK1TaniGokei", length = 10, order = 360)
    public RString atoK1TaniGokei;
    @ReportItem(name = "atoK1SeikyuGaku", length = 11, order = 361)
    public RString atoK1SeikyuGaku;
    @ReportItem(name = "atoK1IryoSeikyu", length = 11, order = 362)
    public RString atoK1IryoSeikyu;
    @ReportItem(name = "tekiyoS12", length = 64, order = 363)
    public RString tekiyoS12;
    @ReportItem(name = "maeK2TaniGokei", length = 10, order = 364)
    public RString maeK2TaniGokei;
    @ReportItem(name = "maeK2SeikyuGaku", length = 11, order = 365)
    public RString maeK2SeikyuGaku;
    @ReportItem(name = "k2FutanGaku", length = 10, order = 366)
    public RString k2FutanGaku;
    @ReportItem(name = "maeK2IryoTanisu", length = 10, order = 367)
    public RString maeK2IryoTanisu;
    @ReportItem(name = "maeK2IryoSeikyu", length = 11, order = 368)
    public RString maeK2IryoSeikyu;
    @ReportItem(name = "k2IryoFutan", length = 11, order = 369)
    public RString k2IryoFutan;
    @ReportItem(name = "meisai13", length = 84, order = 370)
    public RString meisai13;
    @ReportItem(name = "tekiyoS13", length = 64, order = 371)
    public RString tekiyoS13;
    @ReportItem(name = "meisai14", length = 84, order = 372)
    public RString meisai14;
    @ReportItem(name = "tekiyoS14", length = 64, order = 373)
    public RString tekiyoS14;
    @ReportItem(name = "atoK2IryoTanisu", length = 10, order = 374)
    public RString atoK2IryoTanisu;
    @ReportItem(name = "atoK2IryoSeikyu", length = 11, order = 375)
    public RString atoK2IryoSeikyu;
    @ReportItem(name = "meisai15", length = 84, order = 376)
    public RString meisai15;
    @ReportItem(name = "tekiyoS15", length = 64, order = 377)
    public RString tekiyoS15;
    @ReportItem(name = "atoK2TaniGokei", length = 10, order = 378)
    public RString atoK2TaniGokei;
    @ReportItem(name = "atoK2SeikyuGaku", length = 11, order = 379)
    public RString atoK2SeikyuGaku;
    @ReportItem(name = "k3FutanGaku", length = 10, order = 380)
    public RString k3FutanGaku;
    @ReportItem(name = "maeK3IryoTanisu", length = 10, order = 381)
    public RString maeK3IryoTanisu;
    @ReportItem(name = "maeK3IryoSeikyu", length = 11, order = 382)
    public RString maeK3IryoSeikyu;
    @ReportItem(name = "k3IryoFutan", length = 11, order = 383)
    public RString k3IryoFutan;
    @ReportItem(name = "meisai16", length = 84, order = 384)
    public RString meisai16;
    @ReportItem(name = "tekiyoS16", length = 64, order = 385)
    public RString tekiyoS16;
    @ReportItem(name = "maeK3TaniGokei", length = 10, order = 386)
    public RString maeK3TaniGokei;
    @ReportItem(name = "maeK3SeikyuGaku", length = 11, order = 387)
    public RString maeK3SeikyuGaku;
    @ReportItem(name = "meisai17", length = 84, order = 388)
    public RString meisai17;
    @ReportItem(name = "tekiyoS17", length = 64, order = 389)
    public RString tekiyoS17;
    @ReportItem(name = "atoK3SeikyuGaku", length = 11, order = 390)
    public RString atoK3SeikyuGaku;
    @ReportItem(name = "atoK3IryoTanisu", length = 10, order = 391)
    public RString atoK3IryoTanisu;
    @ReportItem(name = "atoK3IryoSeikyu", length = 11, order = 392)
    public RString atoK3IryoSeikyu;
    @ReportItem(name = "meisai18", length = 84, order = 393)
    public RString meisai18;
    @ReportItem(name = "tekiyoS18", length = 64, order = 394)
    public RString tekiyoS18;
    @ReportItem(name = "atoK3TaniGokei", length = 10, order = 395)
    public RString atoK3TaniGokei;
    @ReportItem(name = "meisai19", length = 84, order = 396)
    public RString meisai19;
    @ReportItem(name = "tekiyoS19", length = 64, order = 397)
    public RString tekiyoS19;
    @ReportItem(name = "saishinKaisuT", length = 3, order = 398)
    public RString saishinKaisuT;
    @ReportItem(name = "kagoKaisuT", length = 3, order = 399)
    public RString kagoKaisuT;
    @ReportItem(name = "meisai20", length = 84, order = 400)
    public RString meisai20;
    @ReportItem(name = "tekiyoS20", length = 64, order = 401)
    public RString tekiyoS20;
    @ReportItem(name = "shinsaYmT", length = 6, order = 402)
    public RString shinsaYmT;
    @ReportItem(name = "meisai21", length = 84, order = 403)
    public RString meisai21;
    @ReportItem(name = "tekiyoS21", length = 64, order = 404)
    public RString tekiyoS21;
    @ReportItem(name = "shoriYmdHms", length = 21, order = 405)
    public RString shoriYmdHms;
    @ReportItem(name = "shichousonCode", length = 21, order = 406)
    public RString shichousonCode;
    @ReportItem(name = "inputShikibetsuNo", length = 22, order = 407)
    public RString inputShikibetsuNo;
    @ReportItem(name = "jigyoshoNo_No", length = 23, order = 408)
    public RString jigyoshoNo_No;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
