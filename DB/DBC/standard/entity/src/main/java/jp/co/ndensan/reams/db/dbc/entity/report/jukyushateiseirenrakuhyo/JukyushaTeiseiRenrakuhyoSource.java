package jp.co.ndensan.reams.db.dbc.entity.report.jukyushateiseirenrakuhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 帳票設計_DBCMN81002_受給者訂正連絡票（紙媒体）Sourceクラスです。
 *
 * @reamsid_L DBC-2101-060 lijian
 */
public class JukyushaTeiseiRenrakuhyoSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "sakuseiGG", length = 2, order = 1)
    public RString sakuseiGG;
    @ReportItem(name = "sakuseiYY", length = 2, order = 2)
    public RString sakuseiYY;
    @ReportItem(name = "sakuseiMM", length = 2, order = 3)
    public RString sakuseiMM;
    @ReportItem(name = "sakuseiDD", length = 2, order = 4)
    public RString sakuseiDD;
    @ReportItem(name = "pageCount", length = 4, order = 5)
    public RString pageCount;
    @ReportItem(name = "hokenshaName", length = 20, order = 6)
    public RString hokenshaName;
    @ReportItem(name = "shoHokenshaNo", length = 6, order = 7)
    public RString shoHokenshaNo;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 8)
    public RString hihokenshaNo;
    @ReportItem(name = "idoNengo", length = 2, order = 9)
    public RString idoNengo;
    @ReportItem(name = "idoYMD", length = 6, order = 10)
    public RString idoYMD;
    @ReportItem(name = "teiseiNengo", length = 2, order = 11)
    public RString teiseiNengo;
    @ReportItem(name = "teiseiYMD", length = 6, order = 12)
    public RString teiseiYMD;
    @ReportItem(name = "teiseiKbn1", length = 1, order = 13)
    public RString teiseiKbn1;
    @ReportItem(name = "teiseiKbn2", length = 1, order = 14)
    public RString teiseiKbn2;
    @ReportItem(name = "seibetsu1", length = 1, order = 15)
    public RString seibetsu1;
    @ReportItem(name = "idoJiyu", length = 2, order = 16)
    public RString idoJiyu;
    @ReportItem(name = "hihokenshaNamaKana", length = 25, order = 17)
    public RString hihokenshaNamaKana;
    @ReportItem(name = "birthGengo", length = 2, order = 18)
    public RString birthGengo;
    @ReportItem(name = "birthYMD", length = 6, order = 19)
    public RString birthYMD;
    @ReportItem(name = "shikakuShutokuNengo", length = 2, order = 20)
    public RString shikakuShutokuNengo;
    @ReportItem(name = "shikakuShutokuYMD", length = 6, order = 21)
    public RString shikakuShutokuYMD;
    @ReportItem(name = "shikakuSoshitsuNengo", length = 2, order = 22)
    public RString shikakuSoshitsuNengo;
    @ReportItem(name = "shiSoshitsuYMD", length = 6, order = 23)
    public RString shiSoshitsuYMD;
    @ReportItem(name = "seibetsu2", length = 1, order = 24)
    public RString seibetsu2;
    @ReportItem(name = "hyodai1_1", length = 7, order = 25)
    public RString hyodai1_1;
    @ReportItem(name = "Hyodai1_2", length = 7, order = 26)
    public RString Hyodai1_2;
    @ReportItem(name = "Hyodai2_1", length = 7, order = 27)
    public RString Hyodai2_1;
    @ReportItem(name = "minashiKbn", length = 1, order = 28)
    public RString minashiKbn;
    @ReportItem(name = "yoKaigoJotaiKbn", length = 2, order = 29)
    public RString yoKaigoJotaiKbn;
    @ReportItem(name = "yukoKikanSTNengo", length = 2, order = 30)
    public RString yukoKikanSTNengo;
    @ReportItem(name = "yukoKikanSTYMD", length = 6, order = 31)
    public RString yukoKikanSTYMD;
    @ReportItem(name = "yukoKikanEDNengo", length = 2, order = 32)
    public RString yukoKikanEDNengo;
    @ReportItem(name = "yukoKikanEDYMD", length = 6, order = 33)
    public RString yukoKikanEDYMD;
    @ReportItem(name = "kohiFutanJogenGaku", length = 1, order = 34)
    public RString kohiFutanJogenGaku;
    @ReportItem(name = "sikyuGendoKijunGaKu1", length = 6, order = 35)
    public RString sikyuGendoKijunGaKu1;
    @ReportItem(name = "jogenTekiyoSTNengo1", length = 2, order = 36)
    public RString jogenTekiyoSTNengo1;
    @ReportItem(name = "jogenKaTekiyoSTYMD1", length = 6, order = 37)
    public RString jogenKaTekiyoSTYMD1;
    @ReportItem(name = "jogenTekiyoEDNengo1", length = 2, order = 38)
    public RString jogenTekiyoEDNengo1;
    @ReportItem(name = "jogenTekiyoEDYMD1", length = 6, order = 39)
    public RString jogenTekiyoEDYMD1;
    @ReportItem(name = "Hyodai2_2", length = 7, order = 40)
    public RString Hyodai2_2;
    @ReportItem(name = "Hyodai3_1", length = 7, order = 41)
    public RString Hyodai3_1;
    @ReportItem(name = "sikyuGendoKijunGaKu2", length = 3, order = 42)
    public RString sikyuGendoKijunGaKu2;
    @ReportItem(name = "jogenTekiyoSTNengo2", length = 2, order = 43)
    public RString jogenTekiyoSTNengo2;
    @ReportItem(name = "jogenKaTekiyoSTYMD2", length = 6, order = 44)
    public RString jogenKaTekiyoSTYMD2;
    @ReportItem(name = "jogenTekiyoEDNengo2", length = 2, order = 45)
    public RString jogenTekiyoEDNengo2;
    @ReportItem(name = "jogenTekiyoEDYMD2", length = 6, order = 46)
    public RString jogenTekiyoEDYMD2;
    @ReportItem(name = "Hyodai3_2", length = 7, order = 47)
    public RString Hyodai3_2;
    @ReportItem(name = "riyoshaFutanKbn", length = 1, order = 48)
    public RString riyoshaFutanKbn;
    @ReportItem(name = "keikakuSakuseiKbn", length = 1, order = 49)
    public RString keikakuSakuseiKbn;
    @ReportItem(name = "kyotakuShienJigyoshaNO", length = 10, order = 50)
    public RString kyotakuShienJigyoshaNO;
    @ReportItem(name = "kyoTekiyoSTNengo", length = 2, order = 51)
    public RString kyoTekiyoSTNengo;
    @ReportItem(name = "kyoTekiyoSTYMD", length = 6, order = 52)
    public RString kyoTekiyoSTYMD;
    @ReportItem(name = "kyoTekiyoEDNengo", length = 2, order = 53)
    public RString kyoTekiyoEDNengo;
    @ReportItem(name = "kyoTekiyoEDYMD", length = 6, order = 54)
    public RString kyoTekiyoEDYMD;
    @ReportItem(name = "genShinseichuKbn", length = 1, order = 55)
    public RString genShinseichuKbn;
    @ReportItem(name = "riyoKyufuRitsu", length = 3, order = 56)
    public RString riyoKyufuRitsu;
    @ReportItem(name = "riyoTekiyoSTNengo", length = 2, order = 57)
    public RString riyoTekiyoSTNengo;
    @ReportItem(name = "riyoTekiyoSTYMD", length = 6, order = 58)
    public RString riyoTekiyoSTYMD;
    @ReportItem(name = "riyoTekiyoEDNengo", length = 2, order = 59)
    public RString riyoTekiyoEDNengo;
    @ReportItem(name = "riyoTekiyoEDYMD", length = 6, order = 60)
    public RString riyoTekiyoEDYMD;
    @ReportItem(name = "hyojunFutanKBN", length = 1, order = 61)
    public RString hyojunFutanKBN;
    @ReportItem(name = "hyojunFutanGaku", length = 5, order = 62)
    public RString hyojunFutanGaku;
    @ReportItem(name = "hyojunTekiyoSTNengo", length = 2, order = 63)
    public RString hyojunTekiyoSTNengo;
    @ReportItem(name = "hyojunTekiyoSTYMD", length = 6, order = 64)
    public RString hyojunTekiyoSTYMD;
    @ReportItem(name = "hyojunTekiyoEDNengo", length = 2, order = 65)
    public RString hyojunTekiyoEDNengo;
    @ReportItem(name = "hyojunTekiyoEDYMD", length = 6, order = 66)
    public RString hyojunTekiyoEDYMD;
    @ReportItem(name = "shoTekiyoSTNengo", length = 2, order = 67)
    public RString shoTekiyoSTNengo;
    @ReportItem(name = "shoTekiyoSTYMD", length = 6, order = 68)
    public RString shoTekiyoSTYMD;
    @ReportItem(name = "shoTekiyoEDNengo", length = 2, order = 69)
    public RString shoTekiyoEDNengo;
    @ReportItem(name = "shoTekiyoEDYMD", length = 6, order = 70)
    public RString shoTekiyoEDYMD;
    @ReportItem(name = "kyuTekiyoSTNengo", length = 2, order = 71)
    public RString kyuTekiyoSTNengo;
    @ReportItem(name = "kyuTekiyoSTYMD", length = 6, order = 72)
    public RString kyuTekiyoSTYMD;
    @ReportItem(name = "kyuTekiyoEDNengo", length = 2, order = 73)
    public RString kyuTekiyoEDNengo;
    @ReportItem(name = "kyuTekiyoEDYMD", length = 6, order = 74)
    public RString kyuTekiyoEDYMD;
    @ReportItem(name = "ninteiShinseiKbn", length = 1, order = 75)
    public RString ninteiShinseiKbn;
    @ReportItem(name = "serviceKbn", length = 1, order = 76)
    public RString serviceKbn;
    @ReportItem(name = "tokuGenTaisho", length = 1, order = 77)
    public RString tokuGenTaisho;
    @ReportItem(name = "shokuFutanGendoGaKu", length = 4, order = 78)
    public RString shokuFutanGendoGaKu;
    @ReportItem(name = "unitKoshitsu", length = 4, order = 79)
    public RString unitKoshitsu;
    @ReportItem(name = "unitJunKoshitsu", length = 4, order = 80)
    public RString unitJunKoshitsu;
    @ReportItem(name = "juraiKoshitsuT", length = 4, order = 81)
    public RString juraiKoshitsuT;
    @ReportItem(name = "juraiKishitsuR", length = 4, order = 82)
    public RString juraiKishitsuR;
    @ReportItem(name = "tashoshitsu", length = 4, order = 83)
    public RString tashoshitsu;
    @ReportItem(name = "shin1", length = 4, order = 84)
    public RString shin1;
    @ReportItem(name = "shin2", length = 4, order = 85)
    public RString shin2;
    @ReportItem(name = "shin3", length = 4, order = 86)
    public RString shin3;
    @ReportItem(name = "tokuTekiyoSTNengo", length = 2, order = 87)
    public RString tokuTekiyoSTNengo;
    @ReportItem(name = "tokuTekiyoSTYMD", length = 6, order = 88)
    public RString tokuTekiyoSTYMD;
    @ReportItem(name = "tokuTekiyoEDNengo", length = 2, order = 89)
    public RString tokuTekiyoEDNengo;
    @ReportItem(name = "tokuTekiyoEDYMD", length = 6, order = 90)
    public RString tokuTekiyoEDYMD;
    @ReportItem(name = "rokenShichosonNo", length = 8, order = 91)
    public RString rokenShichosonNo;
    @ReportItem(name = "rokenJukyushaNO", length = 7, order = 92)
    public RString rokenJukyushaNO;
    @ReportItem(name = "shaKyufuritsu", length = 4, order = 93)
    public RString shaKyufuritsu;
    @ReportItem(name = "koikiHokenshaNO", length = 6, order = 94)
    public RString koikiHokenshaNO;
    @ReportItem(name = "shaTekiyoSTNengo", length = 2, order = 95)
    public RString shaTekiyoSTNengo;
    @ReportItem(name = "shaTekiyoSTYMD", length = 6, order = 96)
    public RString shaTekiyoSTYMD;
    @ReportItem(name = "shaTekiyoEDNengo", length = 2, order = 97)
    public RString shaTekiyoEDNengo;
    @ReportItem(name = "shaTekiyoEDYMD", length = 6, order = 98)
    public RString shaTekiyoEDYMD;
    @ReportItem(name = "shokiboKyotakuUmu", length = 1, order = 99)
    public RString shokiboKyotakuUmu;
    @ReportItem(name = "nijiYoboTaishoKbn", length = 1, order = 100)
    public RString nijiYoboTaishoKbn;
    @ReportItem(name = "nijiYoboSTNengo", length = 2, order = 101)
    public RString nijiYoboSTNengo;
    @ReportItem(name = "nijiYoboSTYMD", length = 6, order = 102)
    public RString nijiYoboSTYMD;
    @ReportItem(name = "nijiYoboEDNengo", length = 2, order = 103)
    public RString nijiYoboEDNengo;
    @ReportItem(name = "nijiYoboEDYMD", length = 6, order = 104)
    public RString nijiYoboEDYMD;
    @ReportItem(name = "shinseiShubetsu", length = 1, order = 105)
    public RString shinseiShubetsu;
    @ReportItem(name = "henkoShinseiKbn", length = 1, order = 106)
    public RString henkoShinseiKbn;
    @ReportItem(name = "shinseiNengo", length = 2, order = 107)
    public RString shinseiNengo;
    @ReportItem(name = "shinseiYMD", length = 6, order = 108)
    public RString shinseiYMD;
    @ReportItem(name = "kokuhoHokenshaNo", length = 8, order = 109)
    public RString kokuhoHokenshaNo;
    @ReportItem(name = "kokuhoHihokenshashoNo", length = 20, order = 110)
    public RString kokuhoHihokenshashoNo;
    @ReportItem(name = "kokuhoKojinNo", length = 10, order = 111)
    public RString kokuhoKojinNo;
    @ReportItem(name = "kokiHokenshaNo", length = 8, order = 112)
    public RString kokiHokenshaNo;
    @ReportItem(name = "kokiHihokenshaNo", length = 8, order = 113)
    public RString kokiHihokenshaNo;
    @ReportItem(name = "jutokuTaishoKbn", length = 1, order = 114)
    public RString jutokuTaishoKbn;
    @ReportItem(name = "jutokuHokenshaNo", length = 6, order = 115)
    public RString jutokuHokenshaNo;
    @ReportItem(name = "jutokuTekiyoSTNengo", length = 2, order = 116)
    public RString jutokuTekiyoSTNengo;
    @ReportItem(name = "jutokuTekiyoSTYMD", length = 6, order = 117)
    public RString jutokuTekiyoSTYMD;
    @ReportItem(name = "jutokuTekiyoEDNengo", length = 2, order = 118)
    public RString jutokuTekiyoEDNengo;
    @ReportItem(name = "jutokuTekiyoEDYMD", length = 6, order = 119)
    public RString jutokuTekiyoEDYMD;
    @ReportItem(name = "niFuTekiyoSTNengo", length = 2, order = 120)
    public RString niFuTekiyoSTNengo;
    @ReportItem(name = "niFuTekiyoSTYMD", length = 6, order = 121)
    public RString niFuTekiyoSTYMD;
    @ReportItem(name = "niFuTekiyoEDNengo", length = 2, order = 122)
    public RString niFuTekiyoEDNengo;
    @ReportItem(name = "niFuTekiyoEDYMD", length = 6, order = 123)
    public RString niFuTekiyoEDYMD;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
