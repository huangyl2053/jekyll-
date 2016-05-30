package jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishobook;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 *
 * 保険料納入通知書（仮算定）【ブックタイプ】（口振依頼なし）通知書帳票Sourceです。
 *
 * @reamsid_L DBB-9110-040 wangjie2
 */
public class KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "layoutBreakItem", length = 10, order = 999)
    public int layoutBreakItem;
    public static final RString LAYOUTBREAKITEM;

    static {
        LAYOUTBREAKITEM = new RString("layoutBreakItem");
    }

    // <DBB100021_KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCover.rse>
    @ReportItem(name = "cover_listList1_1", length = 1, order = 1)
    public RString listList1_1;
    @ReportItem(name = "cover_titleNendo", length = 4, order = 2)
    public RString titleNendo;
    @ReportItem(name = "cover_keisanMeisaishoNendo", length = 4, order = 3)
    public RString keisanMeisaishoNendo;
    @ReportItem(name = "cover_hyojicodeName1", order = 4)
    public RString hyojicodeName1;
    @ReportItem(name = "cover_hyojicodeName2", order = 5)
    public RString hyojicodeName2;
    @ReportItem(name = "cover_hyojicodeName3", order = 6)
    public RString hyojicodeName3;
    @ReportItem(name = "cover_hyojicode1", length = 11, order = 7)
    public RString hyojicode1;
    @ReportItem(name = "cover_hyojicode2", length = 9, order = 8)
    public RString hyojicode2;
    @ReportItem(name = "cover_hyojicode3", length = 9, order = 9)
    public RString hyojicode3;
    @ReportItem(name = "cover_keisanMeisaishoKi1", length = 2, order = 10)
    public RString keisanMeisaishoKi1;
    @ReportItem(name = "cover_keisanMeisaishoNokigenKaishi1", length = 11, order = 11)
    public RString keisanMeisaishoNokigenKaishi1;
    @ReportItem(name = "cover_kaisanMeisaishoHihokenshaName", order = 12)
    public RString kaisanMeisaishoHihokenshaName;
    @ReportItem(name = "cover_kaisanMeisaishoSetaiNushiName", order = 13)
    public RString kaisanMeisaishoSetaiNushiName;
    @ReportItem(name = "cover_keisanMeisaishoTsuchishoNo", order = 14)
    public RString keisanMeisaishoTsuchishoNo;
    @ReportItem(name = "cover_keisanMeisaishoSetaiCode", length = 15, order = 15)
    public RString keisanMeisaishoSetaiCode;
    @ReportItem(name = "cover_keisanMeisaishoTsuki1", length = 2, order = 16)
    public RString keisanMeisaishoTsuki1;
    @ReportItem(name = "cover_keisanMeisaishoNokigenShuryo1", length = 11, order = 17)
    public RString keisanMeisaishoNokigenShuryo1;
    @ReportItem(name = "cover_keisanMeisaishoKi2", length = 2, order = 18)
    public RString keisanMeisaishoKi2;
    @ReportItem(name = "cover_keisanMeisaishoNokigenKaishi2", length = 11, order = 19)
    public RString keisanMeisaishoNokigenKaishi2;
    @ReportItem(name = "cover_keisanMeisaishoTsuki2", length = 2, order = 20)
    public RString keisanMeisaishoTsuki2;
    @ReportItem(name = "cover_keisanMeisaishoNokigenShuryo2", length = 11, order = 21)
    public RString keisanMeisaishoNokigenShuryo2;
    @ReportItem(name = "cover_keisanMeisaishoKaishiKi", length = 2, order = 22)
    public RString keisanMeisaishoKaishiKi;
    @ReportItem(name = "cover_kaisanMeisaishoShuryoKi", length = 2, order = 23)
    public RString kaisanMeisaishoShuryoKi;
    @ReportItem(name = "cover_tsuchishoNo", order = 24)
    public RString tsuchishoNo;
    @ReportItem(name = "cover_setaiCode", length = 15, order = 25)
    public RString setaiCode;
    @ReportItem(name = "cover_keisanMeisaishoKi3", length = 2, order = 26)
    public RString keisanMeisaishoKi3;
    @ReportItem(name = "cover_keisanMeisaishoNokigenKaishi3", length = 11, order = 27)
    public RString keisanMeisaishoNokigenKaishi3;
    @ReportItem(name = "cover_keisanMeisaishoNendo1", length = 6, order = 28)
    public RString keisanMeisaishoNendo1;
    @ReportItem(name = "cover_keisanMeisaishoTsuki3", length = 2, order = 29)
    public RString keisanMeisaishoTsuki3;
    @ReportItem(name = "cover_keisanMeisaishoNokigenShuryo3", length = 11, order = 30)
    public RString keisanMeisaishoNokigenShuryo3;
    @ReportItem(name = "cover_keisanMeisaishoShotokuDankai", length = 5, order = 31)
    public RString keisanMeisaishoShotokuDankai;
    @ReportItem(name = "cover_keisanMeisaishoKisu", length = 2, order = 32)
    public RString keisanMeisaishoKisu;
    @ReportItem(name = "cover_keisanMeisaishoKi4", length = 2, order = 33)
    public RString keisanMeisaishoKi4;
    @ReportItem(name = "cover_keisanMeisaishoNokigenKaishi4", length = 11, order = 34)
    public RString keisanMeisaishoNokigenKaishi4;
    @ReportItem(name = "cover_bankCode", length = 7, order = 35)
    public RString bankCode;
    @ReportItem(name = "cover_kozaShurui", length = 3, order = 36)
    public RString kozaShurui;
    @ReportItem(name = "cover_kozaNo", length = 14, order = 37)
    public RString kozaNo;
    @ReportItem(name = "cover_keisanMeisaishoTsuki4", length = 2, order = 38)
    public RString keisanMeisaishoTsuki4;
    @ReportItem(name = "cover_keisanMeisaishoNokigenShuryo4", length = 11, order = 39)
    public RString keisanMeisaishoNokigenShuryo4;
    @ReportItem(name = "cover_keisanMeisaishoNendo2", length = 6, order = 40)
    public RString keisanMeisaishoNendo2;
    @ReportItem(name = "cover_keisanMeisaishoKi5", length = 2, order = 41)
    public RString keisanMeisaishoKi5;
    @ReportItem(name = "cover_keisanMeisaishoNokigenKaishi5", length = 11, order = 42)
    public RString keisanMeisaishoNokigenKaishi5;
    @ReportItem(name = "cover_keisanMeisaishoHokenryoRitsu", length = 10, order = 43)
    public RString keisanMeisaishoHokenryoRitsu;
    @ReportItem(name = "cover_keisanMeisaishoGenmenGaku", length = 10, order = 44)
    public RString keisanMeisaishoGenmenGaku;
    @ReportItem(name = "cover_keisanMeisaishoTsuki5", length = 2, order = 45)
    public RString keisanMeisaishoTsuki5;
    @ReportItem(name = "cover_keisanMeisaishoNokigenShuryo5", length = 11, order = 46)
    public RString keisanMeisaishoNokigenShuryo5;
    @ReportItem(name = "cover_bankName", length = 20, order = 47)
    public RString bankName;
    @ReportItem(name = "cover_keisanMeisaishoKi6", length = 2, order = 48)
    public RString keisanMeisaishoKi6;
    @ReportItem(name = "cover_keisanMeisaishoNokigenKaishi6", length = 11, order = 49)
    public RString keisanMeisaishoNokigenKaishi6;
    @ReportItem(name = "cover_keisanMeisaishoNendo3", length = 6, order = 50)
    public RString keisanMeisaishoNendo3;
    @ReportItem(name = "cover_kaisanMeisaishoNenGaku", length = 10, order = 51)
    public RString kaisanMeisaishoNenGaku;
    @ReportItem(name = "cover_kaisanMeisaishoTokuchoGokeiGaku", length = 10, order = 52)
    public RString kaisanMeisaishoTokuchoGokeiGaku;
    @ReportItem(name = "cover_keisanMeisaishoTsuki6", length = 2, order = 53)
    public RString keisanMeisaishoTsuki6;
    @ReportItem(name = "cover_keisanMeisaishoNokigenShuryo6", length = 11, order = 54)
    public RString keisanMeisaishoNokigenShuryo6;
    @ReportItem(name = "cover_kozaMeiginin", length = 20, order = 55)
    public RString kozaMeiginin;
    @ReportItem(name = "cover_keisanMeisaishoNendo4", length = 6, order = 56)
    public RString keisanMeisaishoNendo4;
    @ReportItem(name = "cover_keisanMeisaishoCalHokenryoGaku", length = 10, order = 57)
    public RString keisanMeisaishoCalHokenryoGaku;
    @ReportItem(name = "cover_keisanMeisaishoKiTitle1", length = 4, order = 58)
    public RString keisanMeisaishoKiTitle1;
    @ReportItem(name = "cover_keisanMeisaishoKiNofuGaku1", length = 10, order = 59)
    public RString keisanMeisaishoKiNofuGaku1;
    @ReportItem(name = "cover_keisanMeisaishoKiTitle2", length = 4, order = 60)
    public RString keisanMeisaishoKiTitle2;
    @ReportItem(name = "cover_keisanMeisaishoKiNofuGaku2", length = 10, order = 61)
    public RString keisanMeisaishoKiNofuGaku2;
    @ReportItem(name = "cover_keisanMeisaishoKarisanteiGokeiGaku", length = 15, order = 62)
    public RString keisanMeisaishoKarisanteiGokeiGaku;
    @ReportItem(name = "cover_pagerenban1", length = 10, order = 63)
    public RString pagerenban1;
    @ReportItem(name = "cover_pagerenban2", length = 10, order = 64)
    public RString pagerenban2;
    @ReportItem(name = "cover_nokibetsuMeisaishoNendo", length = 4, order = 65)
    public RString nokibetsuMeisaishoNendo;
    @ReportItem(name = "cover_nokibetsuMeisaishoTokuchoNofuGaku1", length = 10, order = 66)
    public RString nokibetsuMeisaishoTokuchoNofuGaku1;
    @ReportItem(name = "cover_nokibetsuMeisaishoTokuchoNofuZumiGaku1", length = 10, order = 67)
    public RString nokibetsuMeisaishoTokuchoNofuZumiGaku1;
    @ReportItem(name = "cover_nokibetsuMeisaishoTokuchoSaGaku1", length = 10, order = 68)
    public RString nokibetsuMeisaishoTokuchoSaGaku1;
    @ReportItem(name = "cover_nokibetsuMeisaishoTsuchishoNo", order = 69)
    public RString nokibetsuMeisaishoTsuchishoNo;
    @ReportItem(name = "cover_nokibetsuMeisaishoSetaiCode", length = 15, order = 70)
    public RString nokibetsuMeisaishoSetaiCode;
    @ReportItem(name = "cover_nokibetsuMeisaishoTokuchoNofuGaku2", length = 10, order = 71)
    public RString nokibetsuMeisaishoTokuchoNofuGaku2;
    @ReportItem(name = "cover_nokibetsuMeisaishoTokuchoNofuZumiGaku2", length = 10, order = 72)
    public RString nokibetsuMeisaishoTokuchoNofuZumiGaku2;
    @ReportItem(name = "cover_nokibetsuMeisaishoTokuchoSaGaku2", length = 10, order = 73)
    public RString nokibetsuMeisaishoTokuchoSaGaku2;
    @ReportItem(name = "cover_nokibetsuMeisaishoHohokenshaName", order = 74)
    public RString nokibetsuMeisaishoHohokenshaName;
    @ReportItem(name = "cover_nokibetsuMeisaishoTokuchoNofuGaku3", length = 10, order = 75)
    public RString nokibetsuMeisaishoTokuchoNofuGaku3;
    @ReportItem(name = "cover_nokibetsuMeisaishoTokuchoNofuZumiGaku3", length = 10, order = 76)
    public RString nokibetsuMeisaishoTokuchoNofuZumiGaku3;
    @ReportItem(name = "cover_nokibetsuMeisaishoTokuchoSaGaku3", length = 10, order = 77)
    public RString nokibetsuMeisaishoTokuchoSaGaku3;
    @ReportItem(name = "cover_nokibetsuMeisaishoTokuchoNofuGaku4", length = 10, order = 78)
    public RString nokibetsuMeisaishoTokuchoNofuGaku4;
    @ReportItem(name = "cover_nokibetsuMeisaishoTokuchoNofuZumiGaku4", length = 10, order = 79)
    public RString nokibetsuMeisaishoTokuchoNofuZumiGaku4;
    @ReportItem(name = "cover_nokibetsuMeisaishoTokuchoSaGaku4", length = 10, order = 80)
    public RString nokibetsuMeisaishoTokuchoSaGaku4;
    @ReportItem(name = "cover_nokibetsuMeisaishoKi", length = 4, order = 81)
    public RString nokibetsuMeisaishoKi;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoNofuGaku1", length = 10, order = 82)
    public RString nokibetsuMeisaishoFuchoNofuGaku1;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoNofuZumiGaku1", length = 10, order = 83)
    public RString nokibetsuMeisaishoFuchoNofuZumiGaku1;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoSaGaku1", length = 10, order = 84)
    public RString nokibetsuMeisaishoFuchoSaGaku1;
    @ReportItem(name = "cover_nokibetsuMeisaishoNokigen1", length = 11, order = 85)
    public RString nokibetsuMeisaishoNokigen1;
    @ReportItem(name = "cover_nokibetsuMeisaishoKi2", length = 4, order = 86)
    public RString nokibetsuMeisaishoKi2;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoNofuGaku2", length = 10, order = 87)
    public RString nokibetsuMeisaishoFuchoNofuGaku2;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoNofuZumiGaku2", length = 10, order = 88)
    public RString nokibetsuMeisaishoFuchoNofuZumiGaku2;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoSaGaku2", length = 10, order = 89)
    public RString nokibetsuMeisaishoFuchoSaGaku2;
    @ReportItem(name = "cover_nokibetsuMeisaishoNokigen2", length = 11, order = 90)
    public RString nokibetsuMeisaishoNokigen2;
    @ReportItem(name = "cover_nokibetsuMeisaishoKi3", length = 4, order = 91)
    public RString nokibetsuMeisaishoKi3;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoNofuGaku3", length = 10, order = 92)
    public RString nokibetsuMeisaishoFuchoNofuGaku3;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoNofuZumiGaku3", length = 10, order = 93)
    public RString nokibetsuMeisaishoFuchoNofuZumiGaku3;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoSaGaku3", length = 10, order = 94)
    public RString nokibetsuMeisaishoFuchoSaGaku3;
    @ReportItem(name = "cover_nokibetsuMeisaishoNokigen3", length = 11, order = 95)
    public RString nokibetsuMeisaishoNokigen3;
    @ReportItem(name = "cover_nokibetsuMeisaishoKi4", length = 4, order = 96)
    public RString nokibetsuMeisaishoKi4;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoNofuGaku4", length = 10, order = 97)
    public RString nokibetsuMeisaishoFuchoNofuGaku4;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoNofuZumiGaku4", length = 10, order = 98)
    public RString nokibetsuMeisaishoFuchoNofuZumiGaku4;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoSaGaku4", length = 10, order = 99)
    public RString nokibetsuMeisaishoFuchoSaGaku4;
    @ReportItem(name = "cover_nokibetsuMeisaishoNokigen4", length = 11, order = 100)
    public RString nokibetsuMeisaishoNokigen4;
    @ReportItem(name = "cover_nokibetsuMeisaishoKi5", length = 4, order = 101)
    public RString nokibetsuMeisaishoKi5;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoNofuGaku5", length = 10, order = 102)
    public RString nokibetsuMeisaishoFuchoNofuGaku5;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoNofuZumiGaku5", length = 10, order = 103)
    public RString nokibetsuMeisaishoFuchoNofuZumiGaku5;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoSaGaku5", length = 10, order = 104)
    public RString nokibetsuMeisaishoFuchoSaGaku5;
    @ReportItem(name = "cover_nokibetsuMeisaishoNokigen5", length = 11, order = 105)
    public RString nokibetsuMeisaishoNokigen5;
    @ReportItem(name = "cover_nokibetsuMeisaishoKi6", length = 4, order = 106)
    public RString nokibetsuMeisaishoKi6;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoNofuGaku6", length = 10, order = 107)
    public RString nokibetsuMeisaishoFuchoNofuGaku6;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoNofuZumiGaku6", length = 10, order = 108)
    public RString nokibetsuMeisaishoFuchoNofuZumiGaku6;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoSaGaku6", length = 10, order = 109)
    public RString nokibetsuMeisaishoFuchoSaGaku6;
    @ReportItem(name = "cover_nokibetsuMeisaishoNokigen6", length = 11, order = 110)
    public RString nokibetsuMeisaishoNokigen6;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoNofuGaku7", length = 10, order = 111)
    public RString nokibetsuMeisaishoFuchoNofuGaku7;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoNofuZumiGaku7", length = 10, order = 112)
    public RString nokibetsuMeisaishoFuchoNofuZumiGaku7;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoSaGaku7", length = 10, order = 113)
    public RString nokibetsuMeisaishoFuchoSaGaku7;
    @ReportItem(name = "cover_renban", length = 10, order = 114)
    public RString renban;
    @ReportItem(name = "cover_hokenshaName", length = 10, order = 115)
    public RString hokenshaName;
    @ReportItem(name = "cover_pagerenban3", length = 10, order = 116)
    public RString pagerenban3;
    @ReportItem(name = "cover_denshiKoin", order = 117)
    public RString denshiKoin;
    @ReportItem(name = "cover_hakkoYMD", length = 12, order = 118)
    public RString hakkoYMD;
    @ReportItem(name = "cover_ninshoshaYakushokuMei", length = 15, order = 119)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "cover_ninshoshaYakushokuMei1", order = 120)
    public RString ninshoshaYakushokuMei1;
    @ReportItem(name = "cover_koinMojiretsu", length = 4, order = 121)
    public RString koinMojiretsu;
    @ReportItem(name = "cover_ninshoshaYakushokuMei2", order = 122)
    public RString ninshoshaYakushokuMei2;
    @ReportItem(name = "cover_ninshoshaShimeiKakenai", order = 123)
    public RString ninshoshaShimeiKakenai;
    @ReportItem(name = "cover_ninshoshaShimeiKakeru", order = 124)
    public RString ninshoshaShimeiKakeru;
    @ReportItem(name = "cover_koinShoryaku", length = 15, order = 125)
    public RString koinShoryaku;
    @ReportItem(name = "cover_nofuzumishoTitleNendoBun1", length = 9, order = 126)
    public RString nofuzumishoTitleNendoBun1;
    @ReportItem(name = "cover_nofuzumishoTitleKi1", length = 2, order = 127)
    public RString nofuzumishoTitleKi1;
    @ReportItem(name = "cover_nofuzumishoTitleTsuki1", length = 2, order = 128)
    public RString nofuzumishoTitleTsuki1;
    @ReportItem(name = "cover_nofozumishoTitleNendo1", length = 6, order = 129)
    public RString nofozumishoTitleNendo1;
    @ReportItem(name = "cover_ryoshushoTitleNendo1", length = 6, order = 130)
    public RString ryoshushoTitleNendo1;
    @ReportItem(name = "cover_ryoshushoTitleKi1", length = 2, order = 131)
    public RString ryoshushoTitleKi1;
    @ReportItem(name = "cover_ryoshushoTitleTsuki1", length = 2, order = 132)
    public RString ryoshushoTitleTsuki1;
    @ReportItem(name = "cover_nofushoTitleNendo1", length = 6, order = 133)
    public RString nofushoTitleNendo1;
    @ReportItem(name = "cover_nofushoTitleKi1", length = 2, order = 134)
    public RString nofushoTitleKi1;
    @ReportItem(name = "cover_nofushoTitleTsuki1", length = 2, order = 135)
    public RString nofushoTitleTsuki1;
    @ReportItem(name = "cover_ryoshushoJusho1", order = 136)
    public RString ryoshushoJusho1;
    @ReportItem(name = "cover_nofuzumishoTsuchishoNo1", order = 137)
    public RString nofuzumishoTsuchishoNo1;
    @ReportItem(name = "cover_nofuzumishoOCR11", length = 19, order = 138)
    public RString nofuzumishoOCR11;
    @ReportItem(name = "cover_ryoshushoKatagaki1", order = 139)
    public RString ryoshushoKatagaki1;
    @ReportItem(name = "cover_nofuzumishoSetaiCode1", length = 15, order = 140)
    public RString nofuzumishoSetaiCode1;
    @ReportItem(name = "cover_nofuzumishoOCR21", length = 20, order = 141)
    public RString nofuzumishoOCR21;
    @ReportItem(name = "cover_ryoshushoHihokenshaName1", order = 142)
    public RString ryoshushoHihokenshaName1;
    @ReportItem(name = "cover_nofushoHihokenshaName1", order = 143)
    public RString nofushoHihokenshaName1;
    @ReportItem(name = "cover_nofuzumishoOCR31", length = 12, order = 144)
    public RString nofuzumishoOCR31;
    @ReportItem(name = "cover_nofuzumishoNokigen1", length = 11, order = 145)
    public RString nofuzumishoNokigen1;
    @ReportItem(name = "cover_ryoshushoTsuchishoNo1", order = 146)
    public RString ryoshushoTsuchishoNo1;
    @ReportItem(name = "cover_nofushoTsuchishoNo1", order = 147)
    public RString nofushoTsuchishoNo1;
    @ReportItem(name = "cover_ryoshushoHokenryoGaku1", length = 10, order = 148)
    public RString ryoshushoHokenryoGaku1;
    @ReportItem(name = "cover_nofushoHokenryoGaku1", length = 10, order = 149)
    public RString nofushoHokenryoGaku1;
    @ReportItem(name = "cover_nofuzumishoNofuGaku1", length = 10, order = 150)
    public RString nofuzumishoNofuGaku1;
    @ReportItem(name = "cover_ryoshushoNokigen1", length = 11, order = 151)
    public RString ryoshushoNokigen1;
    @ReportItem(name = "cover_nofushoNokigen1", length = 11, order = 152)
    public RString nofushoNokigen1;
    @ReportItem(name = "cover_nofuzumishoJusho1", order = 153)
    public RString nofuzumishoJusho1;
    @ReportItem(name = "cover_nofuzumishoKatagaki1", length = 30, order = 154)
    public RString nofuzumishoKatagaki1;
    @ReportItem(name = "cover_ryoshushoNofuIn1", length = 2, order = 155)
    public RString ryoshushoNofuIn1;
    @ReportItem(name = "cover_nofushoNofuIn1", length = 2, order = 156)
    public RString nofushoNofuIn1;
    @ReportItem(name = "cover_nofuzumishoNofuIn1", length = 2, order = 157)
    public RString nofuzumishoNofuIn1;
    @ReportItem(name = "cover_ryoshushoKozaCom1", length = 4, order = 158)
    public RString ryoshushoKozaCom1;
    @ReportItem(name = "cover_nofushoKozaCom1", length = 4, order = 159)
    public RString nofushoKozaCom1;
    @ReportItem(name = "cover_nofuzumishoHihokenshaName1", order = 160)
    public RString nofuzumishoHihokenshaName1;
    @ReportItem(name = "cover_nofuzumishoKozaCom1", length = 4, order = 161)
    public RString nofuzumishoKozaCom1;
    @ReportItem(name = "cover_ryoshushoZuiji1", length = 2, order = 162)
    public RString ryoshushoZuiji1;
    @ReportItem(name = "cover_nofushoZuiji1", length = 2, order = 163)
    public RString nofushoZuiji1;
    @ReportItem(name = "cover_nofuzumishoZuiji1", length = 2, order = 164)
    public RString nofuzumishoZuiji1;
    @ReportItem(name = "cover_nofuzumishoshichosonName1", order = 165)
    public RString nofuzumishoshichosonName1;
    @ReportItem(name = "cover_pagerenban4", length = 10, order = 166)
    public RString pagerenban4;
    @ReportItem(name = "cover_yubinNo", length = 8, order = 167)
    public RString yubinNo;
    @ReportItem(name = "cover_gyoseiku", length = 14, order = 168)
    public RString gyoseiku;
    @ReportItem(name = "cover_jusho3", length = 20, order = 169)
    public RString jusho3;
    @ReportItem(name = "cover_jushoText", order = 170)
    public RString jushoText;
    @ReportItem(name = "cover_jusho1", length = 20, order = 171)
    public RString jusho1;
    @ReportItem(name = "cover_jusho2", length = 20, order = 172)
    public RString jusho2;
    @ReportItem(name = "cover_katagakiText", order = 173)
    public RString katagakiText;
    @ReportItem(name = "cover_katagaki2", length = 20, order = 174)
    public RString katagaki2;
    @ReportItem(name = "cover_katagakiSmall2", length = 30, order = 175)
    public RString katagakiSmall2;
    @ReportItem(name = "cover_katagaki1", length = 20, order = 176)
    public RString katagaki1;
    @ReportItem(name = "cover_katagakiSmall1", length = 30, order = 177)
    public RString katagakiSmall1;
    @ReportItem(name = "cover_shimei2", length = 20, order = 178)
    public RString shimei2;
    @ReportItem(name = "cover_shimeiSmall2", length = 40, order = 179)
    public RString shimeiSmall2;
    @ReportItem(name = "cover_shimeiText", order = 180)
    public RString shimeiText;
    @ReportItem(name = "cover_meishoFuyo2", length = 3, order = 181)
    public RString meishoFuyo2;
    @ReportItem(name = "cover_shimeiSmall1", length = 40, order = 182)
    public RString shimeiSmall1;
    @ReportItem(name = "cover_dainoKubunMei", length = 8, order = 183)
    public RString dainoKubunMei;
    @ReportItem(name = "cover_shimei1", length = 20, order = 184)
    public RString shimei1;
    @ReportItem(name = "cover_meishoFuyo1", length = 3, order = 185)
    public RString meishoFuyo1;
    @ReportItem(name = "cover_samabunShimeiText", order = 186)
    public RString samabunShimeiText;
    @ReportItem(name = "cover_samaBun2", length = 3, order = 187)
    public RString samaBun2;
    @ReportItem(name = "cover_samabunShimeiSmall2", length = 40, order = 188)
    public RString samabunShimeiSmall2;
    @ReportItem(name = "cover_kakkoLeft2", length = 1, order = 189)
    public RString kakkoLeft2;
    @ReportItem(name = "cover_samabunShimei2", length = 20, order = 190)
    public RString samabunShimei2;
    @ReportItem(name = "cover_kakkoRight2", length = 1, order = 191)
    public RString kakkoRight2;
    @ReportItem(name = "cover_kakkoLeft1", length = 1, order = 192)
    public RString kakkoLeft1;
    @ReportItem(name = "cover_samabunShimei1", length = 20, order = 193)
    public RString samabunShimei1;
    @ReportItem(name = "cover_samaBun1", length = 3, order = 194)
    public RString samaBun1;
    @ReportItem(name = "cover_kakkoRight1", length = 1, order = 195)
    public RString kakkoRight1;
    @ReportItem(name = "cover_samabunShimeiSmall1", length = 40, order = 196)
    public RString samabunShimeiSmall1;
    @ReportItem(name = "cover_customerBarCode", order = 197)
    public RString customerBarCode;

    // <DBB100020_HokenryoNonyuTsuchishoBookNofusho.rse>
    @ReportItem(name = "nofuzumishoTitleNendoBun1", length = 9, order = 201)
    public RString nofuzumishoTitleNendoBun5;
    @ReportItem(name = "nofuzumishoTitleKi1", length = 2, order = 202)
    public RString nofuzumishoTitleKi5;
    @ReportItem(name = "nofuzumishoTitleTsuki1", length = 2, order = 203)
    public RString nofuzumishoTitleTsuki5;
    @ReportItem(name = "nofozumishoTitleNendo1", length = 6, order = 204)
    public RString nofozumishoTitleNendo5;
    @ReportItem(name = "nofozumishoTitleNendo2", length = 6, order = 205)
    public RString nofozumishoTitleNendo2;
    @ReportItem(name = "nofuzumishoTitleNendoBun2", length = 9, order = 206)
    public RString nofuzumishoTitleNendoBun2;
    @ReportItem(name = "nofuzumishoTitleKi2", length = 2, order = 207)
    public RString nofuzumishoTitleKi2;
    @ReportItem(name = "nofuzumishoTitleTsuki2", length = 2, order = 208)
    public RString nofuzumishoTitleTsuki2;
    @ReportItem(name = "ryoshushoTitleNendo2", length = 6, order = 209)
    public RString ryoshushoTitleNendo2;
    @ReportItem(name = "ryoshushoTitleKi2", length = 2, order = 210)
    public RString ryoshushoTitleKi2;
    @ReportItem(name = "ryoshushoTitleTsuki2", length = 2, order = 211)
    public RString ryoshushoTitleTsuki2;
    @ReportItem(name = "nofushoTitleNendo2", length = 6, order = 212)
    public RString nofushoTitleNendo2;
    @ReportItem(name = "nofushoTitleKi2", length = 2, order = 213)
    public RString nofushoTitleKi2;
    @ReportItem(name = "nofushoTitleTsuki2", length = 2, order = 214)
    public RString nofushoTitleTsuki2;
    @ReportItem(name = "ryoshushoTitleNendo1", length = 6, order = 215)
    public RString ryoshushoTitleNendo5;
    @ReportItem(name = "ryoshushoTitleKi1", length = 2, order = 216)
    public RString ryoshushoTitleKi5;
    @ReportItem(name = "ryoshushoTitleTsuki1", length = 2, order = 217)
    public RString ryoshushoTitleTsuki5;
    @ReportItem(name = "nofushoTitleNendo1", length = 6, order = 218)
    public RString nofushoTitleNendo5;
    @ReportItem(name = "nofushoTitleKi1", length = 2, order = 219)
    public RString nofushoTitleKi5;
    @ReportItem(name = "nofushoTitleTsuki1", length = 2, order = 220)
    public RString nofushoTitleTsuki5;
    @ReportItem(name = "ryoshushoJusho1", order = 221)
    public RString ryoshushoJusho5;
    @ReportItem(name = "ryoshushoJusho2", order = 222)
    public RString ryoshushoJusho2;
    @ReportItem(name = "nofuzumishoTsuchishoNo1", order = 223)
    public RString nofuzumishoTsuchishoNo5;
    @ReportItem(name = "nofuzumishoTsuchishoNo2", order = 224)
    public RString nofuzumishoTsuchishoNo2;
    @ReportItem(name = "nofuzumishoOCR11", length = 19, order = 225)
    public RString nofuzumishoOCR15;
    @ReportItem(name = "nofuzumishoOCR12", length = 19, order = 226)
    public RString nofuzumishoOCR12;
    @ReportItem(name = "ryoshushoKatagaki1", order = 227)
    public RString ryoshushoKatagaki5;
    @ReportItem(name = "ryoshushoKatagaki2", order = 228)
    public RString ryoshushoKatagaki2;
    @ReportItem(name = "nofuzumishoSetaiCode1", length = 15, order = 229)
    public RString nofuzumishoSetaiCode5;
    @ReportItem(name = "nofuzumishoSetaiCode2", length = 15, order = 230)
    public RString nofuzumishoSetaiCode2;
    @ReportItem(name = "nofuzumishoOCR22", length = 20, order = 231)
    public RString nofuzumishoOCR22;
    @ReportItem(name = "nofuzumishoOCR21", length = 20, order = 232)
    public RString nofuzumishoOCR25;
    @ReportItem(name = "ryoshushoHihokenshaName1", order = 233)
    public RString ryoshushoHihokenshaName5;
    @ReportItem(name = "nofushoHihokenshaName1", order = 234)
    public RString nofushoHihokenshaName5;
    @ReportItem(name = "ryoshushoHihokenshaName2", order = 235)
    public RString ryoshushoHihokenshaName2;
    @ReportItem(name = "nofushoHihokenshaName2", order = 236)
    public RString nofushoHihokenshaName2;
    @ReportItem(name = "nofuzumishoOCR31", length = 12, order = 237)
    public RString nofuzumishoOCR35;
    @ReportItem(name = "nofuzumishoNokigen1", length = 11, order = 238)
    public RString nofuzumishoNokigen5;
    @ReportItem(name = "nofuzumishoNokigen2", length = 11, order = 239)
    public RString nofuzumishoNokigen2;
    @ReportItem(name = "nofuzumishoOCR32", length = 12, order = 240)
    public RString nofuzumishoOCR32;
    @ReportItem(name = "ryoshushoTsuchishoNo1", order = 241)
    public RString ryoshushoTsuchishoNo5;
    @ReportItem(name = "nofushoTsuchishoNo1", order = 242)
    public RString nofushoTsuchishoNo5;
    @ReportItem(name = "ryoshushoTsuchishoNo2", order = 243)
    public RString ryoshushoTsuchishoNo2;
    @ReportItem(name = "nofushoTsuchishoNo2", order = 244)
    public RString nofushoTsuchishoNo2;
    @ReportItem(name = "ryoshushoHokenryoGaku1", length = 10, order = 245)
    public RString ryoshushoHokenryoGaku5;
    @ReportItem(name = "nofushoHokenryoGaku1", length = 10, order = 246)
    public RString nofushoHokenryoGaku5;
    @ReportItem(name = "ryoshushoHokenryoGaku2", length = 10, order = 247)
    public RString ryoshushoHokenryoGaku2;
    @ReportItem(name = "nofushoHokenryoGaku2", length = 10, order = 248)
    public RString nofushoHokenryoGaku2;
    @ReportItem(name = "nofuzumishoNofuGaku1", length = 10, order = 249)
    public RString nofuzumishoNofuGaku5;
    @ReportItem(name = "nofuzumishoNofuGaku2", length = 10, order = 250)
    public RString nofuzumishoNofuGaku2;
    @ReportItem(name = "ryoshushoNokigen1", length = 11, order = 251)
    public RString ryoshushoNokigen5;
    @ReportItem(name = "nofushoNokigen1", length = 11, order = 252)
    public RString nofushoNokigen5;
    @ReportItem(name = "ryoshushoNokigen2", length = 11, order = 253)
    public RString ryoshushoNokigen2;
    @ReportItem(name = "nofushoNokigen2", length = 11, order = 254)
    public RString nofushoNokigen2;
    @ReportItem(name = "nofuzumishoJusho1", order = 255)
    public RString nofuzumishoJusho5;
    @ReportItem(name = "nofuzumishoJusho2", order = 256)
    public RString nofuzumishoJusho2;
    @ReportItem(name = "nofuzumishoKatagaki1", length = 30, order = 257)
    public RString nofuzumishoKatagaki5;
    @ReportItem(name = "nofuzumishoKatagaki2", length = 30, order = 258)
    public RString nofuzumishoKatagaki2;
    @ReportItem(name = "ryoshushoNofuIn1", length = 2, order = 259)
    public RString ryoshushoNofuIn5;
    @ReportItem(name = "nofushoNofuIn1", length = 2, order = 260)
    public RString nofushoNofuIn5;
    @ReportItem(name = "nofuzumishoNofuIn1", length = 2, order = 261)
    public RString nofuzumishoNofuIn5;
    @ReportItem(name = "ryoshushoNofuIn2", length = 2, order = 262)
    public RString ryoshushoNofuIn2;
    @ReportItem(name = "nofushoNofuIn2", length = 2, order = 263)
    public RString nofushoNofuIn2;
    @ReportItem(name = "nofuzumishoNofuIn2", length = 2, order = 264)
    public RString nofuzumishoNofuIn2;
    @ReportItem(name = "ryoshushoKozaCom1", length = 4, order = 265)
    public RString ryoshushoKozaCom5;
    @ReportItem(name = "nofushoKozaCom1", length = 4, order = 266)
    public RString nofushoKozaCom5;
    @ReportItem(name = "nofuzumishoHihokenshaName1", order = 267)
    public RString nofuzumishoHihokenshaName5;
    @ReportItem(name = "nofuzumishoKozaCom1", length = 4, order = 268)
    public RString nofuzumishoKozaCom5;
    @ReportItem(name = "ryoshushoKozaCom2", length = 4, order = 269)
    public RString ryoshushoKozaCom2;
    @ReportItem(name = "nofushoKozaCom2", length = 4, order = 270)
    public RString nofushoKozaCom2;
    @ReportItem(name = "nofuzumishoHihokenshaName2", order = 271)
    public RString nofuzumishoHihokenshaName2;
    @ReportItem(name = "nofuzumishoKozaCom2", length = 4, order = 272)
    public RString nofuzumishoKozaCom2;
    @ReportItem(name = "ryoshushoZuiji1", length = 2, order = 273)
    public RString ryoshushoZuiji5;
    @ReportItem(name = "nofushoZuiji1", length = 2, order = 274)
    public RString nofushoZuiji5;
    @ReportItem(name = "nofuzumishoZuiji1", length = 2, order = 275)
    public RString nofuzumishoZuiji5;
    @ReportItem(name = "ryoshushoZuiji2", length = 2, order = 276)
    public RString ryoshushoZuiji2;
    @ReportItem(name = "nofushoZuiji2", length = 2, order = 277)
    public RString nofushoZuiji2;
    @ReportItem(name = "nofuzumishoZuiji2", length = 2, order = 278)
    public RString nofuzumishoZuiji2;
    @ReportItem(name = "nofuzumishoshichosonName1", order = 279)
    public RString nofuzumishoshichosonName5;
    @ReportItem(name = "pagerenban1", length = 10, order = 280)
    public RString pagerenban5;
    @ReportItem(name = "nofuzumishoshichosonName2", order = 281)
    public RString nofuzumishoshichosonName2;
    @ReportItem(name = "pagerenban2", length = 10, order = 282)
    public RString pagerenban6;
    @ReportItem(name = "nofozumishoTitleNendo3", length = 6, order = 283)
    public RString nofozumishoTitleNendo3;
    @ReportItem(name = "nofuzumishoTitleNendoBun3", length = 9, order = 284)
    public RString nofuzumishoTitleNendoBun3;
    @ReportItem(name = "nofuzumishoTitleKi3", length = 2, order = 285)
    public RString nofuzumishoTitleKi3;
    @ReportItem(name = "nofuzumishoTitleTsuki3", length = 2, order = 286)
    public RString nofuzumishoTitleTsuki3;
    @ReportItem(name = "nofozumishoTitleNendo4", length = 6, order = 287)
    public RString nofozumishoTitleNendo4;
    @ReportItem(name = "nofuzumishoTitleNendoBun4", length = 9, order = 288)
    public RString nofuzumishoTitleNendoBun4;
    @ReportItem(name = "nofuzumishoTitleKi4", length = 2, order = 289)
    public RString nofuzumishoTitleKi4;
    @ReportItem(name = "nofuzumishoTitleTsuki4", length = 2, order = 290)
    public RString nofuzumishoTitleTsuki4;
    @ReportItem(name = "ryoshushoTitleNendo3", length = 6, order = 291)
    public RString ryoshushoTitleNendo3;
    @ReportItem(name = "ryoshushoTitleKi3", length = 2, order = 292)
    public RString ryoshushoTitleKi3;
    @ReportItem(name = "ryoshushoTitleTsuki3", length = 2, order = 293)
    public RString ryoshushoTitleTsuki3;
    @ReportItem(name = "nofushoTitleNendo3", length = 6, order = 294)
    public RString nofushoTitleNendo3;
    @ReportItem(name = "nofushoTitleKi3", length = 2, order = 295)
    public RString nofushoTitleKi3;
    @ReportItem(name = "nofushoTitleTsuki3", length = 2, order = 296)
    public RString nofushoTitleTsuki3;
    @ReportItem(name = "ryoshushoTitleNendo4", length = 6, order = 297)
    public RString ryoshushoTitleNendo4;
    @ReportItem(name = "ryoshushoTitleKi4", length = 2, order = 298)
    public RString ryoshushoTitleKi4;
    @ReportItem(name = "ryoshushoTitleTsuki4", length = 2, order = 299)
    public RString ryoshushoTitleTsuki4;
    @ReportItem(name = "nofushoTitleNendo4", length = 6, order = 300)
    public RString nofushoTitleNendo4;
    @ReportItem(name = "nofushoTitleKi4", length = 2, order = 301)
    public RString nofushoTitleKi4;
    @ReportItem(name = "nofushoTitleTsuki4", length = 2, order = 302)
    public RString nofushoTitleTsuki4;
    @ReportItem(name = "ryoshushoJusho3", order = 303)
    public RString ryoshushoJusho3;
    @ReportItem(name = "ryoshushoJusho4", order = 304)
    public RString ryoshushoJusho4;
    @ReportItem(name = "nofuzumishoTsuchishoNo3", order = 305)
    public RString nofuzumishoTsuchishoNo3;
    @ReportItem(name = "nofuzumishoTsuchishoNo4", order = 306)
    public RString nofuzumishoTsuchishoNo4;
    @ReportItem(name = "nofuzumishoOCR13", length = 19, order = 307)
    public RString nofuzumishoOCR13;
    @ReportItem(name = "nofuzumishoOCR14", length = 19, order = 308)
    public RString nofuzumishoOCR14;
    @ReportItem(name = "ryoshushoKatagaki3", order = 309)
    public RString ryoshushoKatagaki3;
    @ReportItem(name = "ryoshushoKatagaki4", order = 310)
    public RString ryoshushoKatagaki4;
    @ReportItem(name = "nofuzumishoSetaiCode3", length = 15, order = 311)
    public RString nofuzumishoSetaiCode3;
    @ReportItem(name = "nofuzumishoSetaiCode4", length = 15, order = 312)
    public RString nofuzumishoSetaiCode4;
    @ReportItem(name = "nofuzumishoOCR23", length = 20, order = 313)
    public RString nofuzumishoOCR23;
    @ReportItem(name = "nofuzumishoOCR24", length = 20, order = 314)
    public RString nofuzumishoOCR24;
    @ReportItem(name = "ryoshushoHihokenshaName3", order = 315)
    public RString ryoshushoHihokenshaName3;
    @ReportItem(name = "nofushoHihokenshaName3", order = 316)
    public RString nofushoHihokenshaName3;
    @ReportItem(name = "ryoshushoHihokenshaName4", order = 317)
    public RString ryoshushoHihokenshaName4;
    @ReportItem(name = "nofushoHihokenshaName4", order = 318)
    public RString nofushoHihokenshaName4;
    @ReportItem(name = "nofuzumishoNokigen3", length = 11, order = 319)
    public RString nofuzumishoNokigen3;
    @ReportItem(name = "nofuzumishoNokigen4", length = 11, order = 320)
    public RString nofuzumishoNokigen4;
    @ReportItem(name = "nofuzumishoOCR33", length = 12, order = 321)
    public RString nofuzumishoOCR33;
    @ReportItem(name = "nofuzumishoOCR34", length = 12, order = 322)
    public RString nofuzumishoOCR34;
    @ReportItem(name = "ryoshushoTsuchishoNo3", order = 323)
    public RString ryoshushoTsuchishoNo3;
    @ReportItem(name = "nofushoTsuchishoNo3", order = 324)
    public RString nofushoTsuchishoNo3;
    @ReportItem(name = "ryoshushoTsuchishoNo4", order = 325)
    public RString ryoshushoTsuchishoNo4;
    @ReportItem(name = "nofushoTsuchishoNo4", order = 326)
    public RString nofushoTsuchishoNo4;
    @ReportItem(name = "ryoshushoHokenryoGaku3", length = 10, order = 327)
    public RString ryoshushoHokenryoGaku3;
    @ReportItem(name = "nofushoHokenryoGaku3", length = 10, order = 328)
    public RString nofushoHokenryoGaku3;
    @ReportItem(name = "ryoshushoHokenryoGaku4", length = 10, order = 329)
    public RString ryoshushoHokenryoGaku4;
    @ReportItem(name = "nofushoHokenryoGaku4", length = 10, order = 330)
    public RString nofushoHokenryoGaku4;
    @ReportItem(name = "nofuzumishoNofuGaku3", length = 10, order = 331)
    public RString nofuzumishoNofuGaku3;
    @ReportItem(name = "nofuzumishoNofuGaku4", length = 10, order = 332)
    public RString nofuzumishoNofuGaku4;
    @ReportItem(name = "ryoshushoNokigen3", length = 11, order = 333)
    public RString ryoshushoNokigen3;
    @ReportItem(name = "nofushoNokigen3", length = 11, order = 334)
    public RString nofushoNokigen3;
    @ReportItem(name = "ryoshushoNokigen4", length = 11, order = 335)
    public RString ryoshushoNokigen4;
    @ReportItem(name = "nofushoNokigen4", length = 11, order = 336)
    public RString nofushoNokigen4;
    @ReportItem(name = "nofuzumishoJusho3", order = 337)
    public RString nofuzumishoJusho3;
    @ReportItem(name = "nofuzumishoJusho4", order = 338)
    public RString nofuzumishoJusho4;
    @ReportItem(name = "nofuzumishoKatagaki3", length = 30, order = 339)
    public RString nofuzumishoKatagaki3;
    @ReportItem(name = "nofuzumishoKatagaki4", length = 30, order = 340)
    public RString nofuzumishoKatagaki4;
    @ReportItem(name = "ryoshushoNofuIn3", length = 2, order = 341)
    public RString ryoshushoNofuIn3;
    @ReportItem(name = "nofushoNofuIn3", length = 2, order = 342)
    public RString nofushoNofuIn3;
    @ReportItem(name = "nofuzumishoNofuIn3", length = 2, order = 343)
    public RString nofuzumishoNofuIn3;
    @ReportItem(name = "ryoshushoNofuIn4", length = 2, order = 344)
    public RString ryoshushoNofuIn4;
    @ReportItem(name = "nofushoNofuIn4", length = 2, order = 345)
    public RString nofushoNofuIn4;
    @ReportItem(name = "nofuzumishoNofuIn4", length = 2, order = 346)
    public RString nofuzumishoNofuIn4;
    @ReportItem(name = "ryoshushoKozaCom3", length = 4, order = 347)
    public RString ryoshushoKozaCom3;
    @ReportItem(name = "nofushoKozaCom3", length = 4, order = 348)
    public RString nofushoKozaCom3;
    @ReportItem(name = "nofuzumishoHihokenshaName3", order = 349)
    public RString nofuzumishoHihokenshaName3;
    @ReportItem(name = "nofuzumishoKozaCom3", length = 4, order = 350)
    public RString nofuzumishoKozaCom3;
    @ReportItem(name = "ryoshushoKozaCom4", length = 4, order = 351)
    public RString ryoshushoKozaCom4;
    @ReportItem(name = "nofushoKozaCom4", length = 4, order = 352)
    public RString nofushoKozaCom4;
    @ReportItem(name = "nofuzumishoHihokenshaName4", order = 353)
    public RString nofuzumishoHihokenshaName4;
    @ReportItem(name = "nofuzumishoKozaCom4", length = 4, order = 354)
    public RString nofuzumishoKozaCom4;
    @ReportItem(name = "ryoshushoZuiji3", length = 2, order = 355)
    public RString ryoshushoZuiji3;
    @ReportItem(name = "nofushoZuiji3", length = 2, order = 356)
    public RString nofushoZuiji3;
    @ReportItem(name = "nofuzumishoZuiji3", length = 2, order = 357)
    public RString nofuzumishoZuiji3;
    @ReportItem(name = "ryoshushoZuiji4", length = 2, order = 358)
    public RString ryoshushoZuiji4;
    @ReportItem(name = "nofushoZuiji4", length = 2, order = 359)
    public RString nofushoZuiji4;
    @ReportItem(name = "nofuzumishoZuiji4", length = 2, order = 360)
    public RString nofuzumishoZuiji4;
    @ReportItem(name = "eRenban", length = 10, order = 361)
    public RString eRenban;
    @ReportItem(name = "ePage", length = 10, order = 362)
    public RString ePage;
    @ReportItem(name = "nofuzumishoshichosonName3", order = 363)
    public RString nofuzumishoshichosonName3;
    @ReportItem(name = "pagerenban3", length = 10, order = 364)
    public RString pagerenban7;
    @ReportItem(name = "nofuzumishoshichosonName4", order = 365)
    public RString nofuzumishoshichosonName4;
    @ReportItem(name = "pagerenban4", length = 10, order = 366)
    public RString pagerenban8;
    @ReportItem(name = "eHokensyaName", length = 10, order = 367)
    public RString eHokensyaName;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
