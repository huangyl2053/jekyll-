package jp.co.ndensan.reams.db.dbc.entity.report.source.jukyushaidorenrakuhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 帳票設計_DBCMN81001_受給者異動連絡票（紙媒体)Source
 *
 * @reamsid_L DBC-2100-040 jiangzongyue
 */
public class JukyushaIdoRenrakuhyoSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "sakuseiGG", length = 2, order = 1)
    public RString sakuseiGG;
    @ReportItem(name = "sakuseiYY", length = 2, order = 2)
    public RString sakuseiYY;
    @ReportItem(name = "sakuseiMM", length = 2, order = 3)
    public RString sakuseiMM;
    @ReportItem(name = "sakuseiDD", length = 2, order = 4)
    public RString sakuseiDD;
    @ReportItem(name = "PageCount", length = 4, order = 5)
    public RString PageCount;
    @ReportItem(name = "hokenshaName", length = 20, order = 6)
    public RString hokenshaName;
    @ReportItem(name = "idoKbn3", length = 1, order = 7)
    public RString idoKbn3;
    @ReportItem(name = "shoHokenshaNo", length = 6, order = 8)
    public RString shoHokenshaNo;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 9)
    public RString hihokenshaNo;
    @ReportItem(name = "IdoNengo", length = 2, order = 10)
    public RString IdoNengo;
    @ReportItem(name = "idoYMD", length = 6, order = 11)
    public RString idoYMD;
    @ReportItem(name = "idoKbn1", length = 1, order = 12)
    public RString idoKbn1;
    @ReportItem(name = "idoKbn2", length = 1, order = 13)
    public RString idoKbn2;
    @ReportItem(name = "seibetsu1", length = 1, order = 14)
    public RString seibetsu1;
    @ReportItem(name = "idoJiyu", length = 2, order = 15)
    public RString idoJiyu;
    @ReportItem(name = "hihokenshaNamaKana", length = 25, order = 16)
    public RString hihokenshaNamaKana;
    @ReportItem(name = "birthGengo", length = 2, order = 17)
    public RString birthGengo;
    @ReportItem(name = "birthYMD", length = 6, order = 18)
    public RString birthYMD;
    @ReportItem(name = "shikakuShutokuNengo", length = 2, order = 19)
    public RString shikakuShutokuNengo;
    @ReportItem(name = "shikakuShutokuYMD", length = 6, order = 20)
    public RString shikakuShutokuYMD;
    @ReportItem(name = "shikakuSoshitsuNengo", length = 2, order = 21)
    public RString shikakuSoshitsuNengo;
    @ReportItem(name = "shiSoshitsuYMD", length = 6, order = 22)
    public RString shiSoshitsuYMD;
    @ReportItem(name = "seibetsu2", length = 1, order = 23)
    public RString seibetsu2;
    @ReportItem(name = "hyodai1_1", length = 7, order = 24)
    public RString hyodai1_1;
    @ReportItem(name = "Hyodai1_2", length = 7, order = 25)
    public RString Hyodai1_2;
    @ReportItem(name = "Hyodai2_1", length = 7, order = 26)
    public RString Hyodai2_1;
    @ReportItem(name = "minashiKbn", length = 1, order = 27)
    public RString minashiKbn;
    @ReportItem(name = "yoKaigoJotaiKbn", length = 2, order = 28)
    public RString yoKaigoJotaiKbn;
    @ReportItem(name = "yukoKikanSTNengo", length = 2, order = 29)
    public RString yukoKikanSTNengo;
    @ReportItem(name = "yukoKikanSTYMD", length = 6, order = 30)
    public RString yukoKikanSTYMD;
    @ReportItem(name = "yukoKikanEDNengo", length = 2, order = 31)
    public RString yukoKikanEDNengo;
    @ReportItem(name = "yukoKikanEDYMD", length = 6, order = 32)
    public RString yukoKikanEDYMD;
    @ReportItem(name = "kohiFutanJogenGaku", length = 1, order = 33)
    public RString kohiFutanJogenGaku;
    @ReportItem(name = "sikyuGendoKijunGaKu1", length = 6, order = 34)
    public RString sikyuGendoKijunGaKu1;
    @ReportItem(name = "jogenTekiyoSTNengo1", length = 2, order = 35)
    public RString jogenTekiyoSTNengo1;
    @ReportItem(name = "jogenKaTekiyoSTYMD1", length = 6, order = 36)
    public RString jogenKaTekiyoSTYMD1;
    @ReportItem(name = "jogenTekiyoEDNengo1", length = 2, order = 37)
    public RString jogenTekiyoEDNengo1;
    @ReportItem(name = "jogenTekiyoEDYMD1", length = 6, order = 38)
    public RString jogenTekiyoEDYMD1;
    @ReportItem(name = "Hyodai2_2", length = 7, order = 39)
    public RString Hyodai2_2;
    @ReportItem(name = "Hyodai3_1", length = 7, order = 40)
    public RString Hyodai3_1;
    @ReportItem(name = "sikyuGendoKijunGaKu2", length = 3, order = 41)
    public RString sikyuGendoKijunGaKu2;
    @ReportItem(name = "jogenTekiyoSTNengo2", length = 2, order = 42)
    public RString jogenTekiyoSTNengo2;
    @ReportItem(name = "jogenKaTekiyoSTYMD2", length = 6, order = 43)
    public RString jogenKaTekiyoSTYMD2;
    @ReportItem(name = "jogenTekiyoEDNengo2", length = 2, order = 44)
    public RString jogenTekiyoEDNengo2;
    @ReportItem(name = "jogenTekiyoEDYMD2", length = 6, order = 45)
    public RString jogenTekiyoEDYMD2;
    @ReportItem(name = "Hyodai3_2", length = 7, order = 46)
    public RString Hyodai3_2;
    @ReportItem(name = "keikakuSakuseiKbn", length = 1, order = 47)
    public RString keikakuSakuseiKbn;
    @ReportItem(name = "kyotakuShienJigyoshaNO", length = 10, order = 48)
    public RString kyotakuShienJigyoshaNO;
    @ReportItem(name = "kyoTekiyoSTNengo", length = 2, order = 49)
    public RString kyoTekiyoSTNengo;
    @ReportItem(name = "kyoTekiyoSTYMD", length = 6, order = 50)
    public RString kyoTekiyoSTYMD;
    @ReportItem(name = "kyoTekiyoEDNengo", length = 2, order = 51)
    public RString kyoTekiyoEDNengo;
    @ReportItem(name = "kyoTekiyoEDYMD", length = 6, order = 52)
    public RString kyoTekiyoEDYMD;
    @ReportItem(name = "genShinseichuKbn", length = 1, order = 53)
    public RString genShinseichuKbn;
    @ReportItem(name = "riyoshaFutanKbn", length = 1, order = 54)
    public RString riyoshaFutanKbn;
    @ReportItem(name = "riyoKyufuRitsu", length = 3, order = 55)
    public RString riyoKyufuRitsu;
    @ReportItem(name = "riyoTekiyoSTNengo", length = 2, order = 56)
    public RString riyoTekiyoSTNengo;
    @ReportItem(name = "riyoTekiyoSTYMD", length = 6, order = 57)
    public RString riyoTekiyoSTYMD;
    @ReportItem(name = "riyoTekiyoEDNengo", length = 2, order = 58)
    public RString riyoTekiyoEDNengo;
    @ReportItem(name = "riyoTekiyoEDYMD", length = 6, order = 59)
    public RString riyoTekiyoEDYMD;
    @ReportItem(name = "hyojunFutanKBN", length = 1, order = 60)
    public RString hyojunFutanKBN;
    @ReportItem(name = "hyojunFutanGaku", length = 5, order = 61)
    public RString hyojunFutanGaku;
    @ReportItem(name = "hyojunTekiyoSTNengo", length = 2, order = 62)
    public RString hyojunTekiyoSTNengo;
    @ReportItem(name = "hyojunTekiyoSTYMD", length = 6, order = 63)
    public RString hyojunTekiyoSTYMD;
    @ReportItem(name = "hyojunTekiyoEDNengo", length = 2, order = 64)
    public RString hyojunTekiyoEDNengo;
    @ReportItem(name = "hyojunTekiyoEDYMD", length = 6, order = 65)
    public RString hyojunTekiyoEDYMD;
    @ReportItem(name = "shoTekiyoSTNengo", length = 2, order = 66)
    public RString shoTekiyoSTNengo;
    @ReportItem(name = "ShoTekiyoSTYMD", length = 6, order = 67)
    public RString ShoTekiyoSTYMD;
    @ReportItem(name = "shoTekiyoEDNengo", length = 2, order = 68)
    public RString shoTekiyoEDNengo;
    @ReportItem(name = "shoTekiyoEDYMD", length = 6, order = 69)
    public RString shoTekiyoEDYMD;
    @ReportItem(name = "kyuTekiyoSTNengo", length = 2, order = 70)
    public RString kyuTekiyoSTNengo;
    @ReportItem(name = "kyuTekiyoSTYMD", length = 6, order = 71)
    public RString kyuTekiyoSTYMD;
    @ReportItem(name = "kyuTekiyoEDNengo", length = 2, order = 72)
    public RString kyuTekiyoEDNengo;
    @ReportItem(name = "kyuTekiyoEDYMD", length = 6, order = 73)
    public RString kyuTekiyoEDYMD;
    @ReportItem(name = "ninteiShinseiKbn", length = 1, order = 74)
    public RString ninteiShinseiKbn;
    @ReportItem(name = "serviceKbn", length = 1, order = 75)
    public RString serviceKbn;
    @ReportItem(name = "tokuGenTaisho", length = 1, order = 76)
    public RString tokuGenTaisho;
    @ReportItem(name = "shokuFutanGendoGaKu", length = 4, order = 77)
    public RString shokuFutanGendoGaKu;
    @ReportItem(name = "unitKoshitsu", length = 4, order = 78)
    public RString unitKoshitsu;
    @ReportItem(name = "unitJunKoshitsu", length = 4, order = 79)
    public RString unitJunKoshitsu;
    @ReportItem(name = "juraiKoshitsuT", length = 4, order = 80)
    public RString juraiKoshitsuT;
    @ReportItem(name = "juraiKishitsuR", length = 4, order = 81)
    public RString juraiKishitsuR;
    @ReportItem(name = "tashoshitsu", length = 4, order = 82)
    public RString tashoshitsu;
    @ReportItem(name = "shin1", length = 4, order = 83)
    public RString shin1;
    @ReportItem(name = "shin2", length = 4, order = 84)
    public RString shin2;
    @ReportItem(name = "Shin3", length = 4, order = 85)
    public RString Shin3;
    @ReportItem(name = "tokuTekiyoSTNengo", length = 2, order = 86)
    public RString tokuTekiyoSTNengo;
    @ReportItem(name = "tokuTekiyoSTYMD", length = 6, order = 87)
    public RString tokuTekiyoSTYMD;
    @ReportItem(name = "tokuTekiyoEDNengo", length = 2, order = 88)
    public RString tokuTekiyoEDNengo;
    @ReportItem(name = "tokuTekiyoEDYMD", length = 6, order = 89)
    public RString tokuTekiyoEDYMD;
    @ReportItem(name = "koikiHokenshaNO", length = 6, order = 90)
    public RString koikiHokenshaNO;
    @ReportItem(name = "rokenShichosonNo", length = 8, order = 91)
    public RString rokenShichosonNo;
    @ReportItem(name = "rokenJukyushaNO", length = 7, order = 92)
    public RString rokenJukyushaNO;
    @ReportItem(name = "shaKyufuritsu", length = 4, order = 93)
    public RString shaKyufuritsu;
    @ReportItem(name = "shaTekiyoSTNengo", length = 2, order = 94)
    public RString shaTekiyoSTNengo;
    @ReportItem(name = "shaTekiyoSTYMD", length = 6, order = 95)
    public RString shaTekiyoSTYMD;
    @ReportItem(name = "shaTekiyoEDNengo", length = 2, order = 96)
    public RString shaTekiyoEDNengo;
    @ReportItem(name = "shaTekiyoEDYMD", length = 6, order = 97)
    public RString shaTekiyoEDYMD;
    @ReportItem(name = "ShokiboKyotakuUmu", length = 1, order = 98)
    public RString ShokiboKyotakuUmu;
    @ReportItem(name = "nijiYoboTaishoKbn", length = 1, order = 99)
    public RString nijiYoboTaishoKbn;
    @ReportItem(name = "nijiYoboSTNengo", length = 2, order = 100)
    public RString nijiYoboSTNengo;
    @ReportItem(name = "nijiYoboSTYMD", length = 6, order = 101)
    public RString nijiYoboSTYMD;
    @ReportItem(name = "nijiYoboEDNengo", length = 2, order = 102)
    public RString nijiYoboEDNengo;
    @ReportItem(name = "nijiYoboEDYMD", length = 6, order = 103)
    public RString nijiYoboEDYMD;
    @ReportItem(name = "shinseiShubetsu", length = 1, order = 104)
    public RString shinseiShubetsu;
    @ReportItem(name = "henkoShinseiKbn", length = 1, order = 105)
    public RString henkoShinseiKbn;
    @ReportItem(name = "shinseiNengo", length = 2, order = 106)
    public RString shinseiNengo;
    @ReportItem(name = "shinseiYMD", length = 6, order = 107)
    public RString shinseiYMD;
    @ReportItem(name = "kokuhoHokenshaNo", length = 8, order = 108)
    public RString kokuhoHokenshaNo;
    @ReportItem(name = "kokuhoHihokenshashoNo", length = 20, order = 109)
    public RString kokuhoHihokenshashoNo;
    @ReportItem(name = "kokuhoKojinNo", length = 10, order = 110)
    public RString kokuhoKojinNo;
    @ReportItem(name = "kokiHokenshaNo", length = 8, order = 111)
    public RString kokiHokenshaNo;
    @ReportItem(name = "kokiHihokenshaNo", length = 8, order = 112)
    public RString kokiHihokenshaNo;
    @ReportItem(name = "jutokuTaishoKbn", length = 1, order = 113)
    public RString jutokuTaishoKbn;
    @ReportItem(name = "jutokuHokenshaNo", length = 6, order = 114)
    public RString jutokuHokenshaNo;
    @ReportItem(name = "jutokuTekiyoSTNengo", length = 2, order = 115)
    public RString jutokuTekiyoSTNengo;
    @ReportItem(name = "jutokuTekiyoSTYMD", length = 6, order = 116)
    public RString jutokuTekiyoSTYMD;
    @ReportItem(name = "jutokuTekiyoEDNengo", length = 2, order = 117)
    public RString jutokuTekiyoEDNengo;
    @ReportItem(name = "jutokuTekiyoEDYMD", length = 6, order = 118)
    public RString jutokuTekiyoEDYMD;
    @ReportItem(name = "niFuTekiyoSTNengo", length = 2, order = 119)
    public RString niFuTekiyoSTNengo;
    @ReportItem(name = "niFuTekiyoSTYMD", length = 6, order = 120)
    public RString niFuTekiyoSTYMD;
    @ReportItem(name = "niFuTekiyoEDNengo", length = 2, order = 121)
    public RString niFuTekiyoEDNengo;
    @ReportItem(name = "niFuTekiyoEDYMD", length = 6, order = 122)
    public RString niFuTekiyoEDYMD;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
