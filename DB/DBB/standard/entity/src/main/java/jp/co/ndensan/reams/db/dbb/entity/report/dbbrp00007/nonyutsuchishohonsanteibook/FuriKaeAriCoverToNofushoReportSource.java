package jp.co.ndensan.reams.db.dbb.entity.report.dbbrp00007.nonyutsuchishohonsanteibook;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 「口振依頼あり通知書(DBB100055_NonyuTsuchishoBookFuriKaeAriCover)」と「納付書(DBB100020_HokenryoNonyuTsuchishoBookNofusho)」 <br>
 * の項目を定義するクラスです。
 *
 * @reamsid_L DBB-9110-100 xuyue
 */
public class FuriKaeAriCoverToNofushoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "layoutBreakItem", length = 10, order = 999)
    public int layoutBreakItem;
    public static final RString LAYOUTBREAKITEM;

    static {
        LAYOUTBREAKITEM = new RString("layoutBreakItem");
    }

    // <DBB100055_NonyuTsuchishoBookFuriKaeAriCover.rse>
    @ReportItem(name = "ari_listList1_1", length = 1, order = 1)
    public RString ari_listList1_1;
    @ReportItem(name = "ari_keisanMeisaishoNendo", length = 4, order = 2)
    public RString ari_keisanMeisaishoNendo;
    @ReportItem(name = "ari_keisanMeisaishoNendoBun", length = 9, order = 3)
    public RString ari_keisanMeisaishoNendoBun;
    @ReportItem(name = "ari_titleNendo", length = 4, order = 4)
    public RString ari_titleNendo;
    @ReportItem(name = "ari_titleNendoBun", length = 9, order = 5)
    public RString ari_titleNendoBun;
    @ReportItem(name = "ari_HyojicodeName1", order = 6)
    public RString ari_HyojicodeName1;
    @ReportItem(name = "ari_HyojicodeName2", order = 7)
    public RString ari_HyojicodeName2;
    @ReportItem(name = "ari_HyojicodeName3", order = 8)
    public RString ari_HyojicodeName3;
    @ReportItem(name = "ari_Hyojicode1", length = 11, order = 9)
    public RString ari_Hyojicode1;
    @ReportItem(name = "ari_Hyojicode2", length = 9, order = 10)
    public RString ari_Hyojicode2;
    @ReportItem(name = "ari_Hyojicode3", length = 9, order = 11)
    public RString ari_Hyojicode3;
    @ReportItem(name = "ari_keisanMeisaishoKi1", length = 2, order = 12)
    public RString ari_keisanMeisaishoKi1;
    @ReportItem(name = "ari_keisanMeisaishoNokigenKaishi1", length = 11, order = 13)
    public RString ari_keisanMeisaishoNokigenKaishi1;
    @ReportItem(name = "ari_kaisanMeisaishoHihokenshaName", order = 14)
    public RString ari_kaisanMeisaishoHihokenshaName;
    @ReportItem(name = "ari_kaisanMeisaishoSetaiNushiName", order = 15)
    public RString ari_kaisanMeisaishoSetaiNushiName;
    @ReportItem(name = "ari_keisanMeisaishoTsuchishoNo", order = 16)
    public RString ari_keisanMeisaishoTsuchishoNo;
    @ReportItem(name = "ari_keisanMeisaishoSetaiCode", length = 15, order = 17)
    public RString ari_keisanMeisaishoSetaiCode;
    @ReportItem(name = "ari_keisanMeisaishoTsuki1", length = 2, order = 18)
    public RString ari_keisanMeisaishoTsuki1;
    @ReportItem(name = "ari_keisanMeisaishoNokigenShuryo1", length = 11, order = 19)
    public RString ari_keisanMeisaishoNokigenShuryo1;
    @ReportItem(name = "ari_keisanMeisaishoKi2", length = 2, order = 20)
    public RString ari_keisanMeisaishoKi2;
    @ReportItem(name = "ari_keisanMeisaishoNokigenKaishi2", length = 11, order = 21)
    public RString ari_keisanMeisaishoNokigenKaishi2;
    @ReportItem(name = "ari_keisanMeisaishoTsuki2", length = 2, order = 22)
    public RString ari_keisanMeisaishoTsuki2;
    @ReportItem(name = "ari_keisanMeisaishoNokigenShuryo2", length = 11, order = 23)
    public RString ari_keisanMeisaishoNokigenShuryo2;
    @ReportItem(name = "ari_tsuchishoNo", order = 24)
    public RString ari_tsuchishoNo;
    @ReportItem(name = "ari_setaiCode", length = 15, order = 25)
    public RString ari_setaiCode;
    @ReportItem(name = "ari_keisanMeisaishoKi3", length = 2, order = 26)
    public RString ari_keisanMeisaishoKi3;
    @ReportItem(name = "ari_keisanMeisaishoNokigenKaishi3", length = 11, order = 27)
    public RString ari_keisanMeisaishoNokigenKaishi3;
    @ReportItem(name = "ari_keisanMeisaishoKaishiKi", length = 16, order = 28)
    public RString ari_keisanMeisaishoKaishiKi;
    @ReportItem(name = "ari_keisanMeisaishoTsuki3", length = 2, order = 29)
    public RString ari_keisanMeisaishoTsuki3;
    @ReportItem(name = "ari_keisanMeisaishoNokigenShuryo3", length = 11, order = 30)
    public RString ari_keisanMeisaishoNokigenShuryo3;
    @ReportItem(name = "ari_keisanMeisaishoTsukiSu", length = 12, order = 31)
    public RString ari_keisanMeisaishoTsukiSu;
    @ReportItem(name = "ari_kaisanMeisaishoShuryoKi", length = 16, order = 32)
    public RString ari_kaisanMeisaishoShuryoKi;
    @ReportItem(name = "ari_keisanMeisaishoKi4", length = 2, order = 33)
    public RString ari_keisanMeisaishoKi4;
    @ReportItem(name = "ari_keisanMeisaishoNokigenKaishi4", length = 11, order = 34)
    public RString ari_keisanMeisaishoNokigenKaishi4;
    @ReportItem(name = "ari_bankCode", length = 7, order = 35)
    public RString ari_bankCode;
    @ReportItem(name = "ari_kozaShurui", length = 3, order = 36)
    public RString ari_kozaShurui;
    @ReportItem(name = "ari_kozaNo", length = 14, order = 37)
    public RString ari_kozaNo;
    @ReportItem(name = "ari_keisanMeisaishoTsuki4", length = 2, order = 38)
    public RString ari_keisanMeisaishoTsuki4;
    @ReportItem(name = "ari_keisanMeisaishoNokigenShuryo4", length = 11, order = 39)
    public RString ari_keisanMeisaishoNokigenShuryo4;
    @ReportItem(name = "ari_keisanMeisaishoShotokuDankai", length = 8, order = 40)
    public RString ari_keisanMeisaishoShotokuDankai;
    @ReportItem(name = "ari_kaisanHokenryoRitsu", length = 10, order = 41)
    public RString ari_kaisanHokenryoRitsu;
    @ReportItem(name = "ari_keisanMeisaishoKi5", length = 2, order = 42)
    public RString ari_keisanMeisaishoKi5;
    @ReportItem(name = "ari_keisanMeisaishoNokigenKaishi5", length = 11, order = 43)
    public RString ari_keisanMeisaishoNokigenKaishi5;
    @ReportItem(name = "ari_keisanMeisaishoTsuki5", length = 2, order = 44)
    public RString ari_keisanMeisaishoTsuki5;
    @ReportItem(name = "ari_keisanMeisaishoNokigenShuryo5", length = 11, order = 45)
    public RString ari_keisanMeisaishoNokigenShuryo5;
    @ReportItem(name = "ari_keisanMeisaishoCalHokenryoGaku", length = 10, order = 46)
    public RString ari_keisanMeisaishoCalHokenryoGaku;
    @ReportItem(name = "ari_keisanMeisaishoGenmenGaku", length = 10, order = 47)
    public RString ari_keisanMeisaishoGenmenGaku;
    @ReportItem(name = "ari_bankName", length = 20, order = 48)
    public RString ari_bankName;
    @ReportItem(name = "ari_keisanMeisaishoKi6", length = 2, order = 49)
    public RString ari_keisanMeisaishoKi6;
    @ReportItem(name = "ari_keisanMeisaishoNokigenKaishi6", length = 11, order = 50)
    public RString ari_keisanMeisaishoNokigenKaishi6;
    @ReportItem(name = "ari_keisanMeisaishoTsuki6", length = 2, order = 51)
    public RString ari_keisanMeisaishoTsuki6;
    @ReportItem(name = "ari_keisanMeisaishoNokigenShuryo6", length = 11, order = 52)
    public RString ari_keisanMeisaishoNokigenShuryo6;
    @ReportItem(name = "ari_keisanMeisaishoTokuchoGokeiGaku", length = 10, order = 53)
    public RString ari_keisanMeisaishoTokuchoGokeiGaku;
    @ReportItem(name = "ari_kaisanMeisaishoFuchoGokeiGaku", length = 10, order = 54)
    public RString ari_kaisanMeisaishoFuchoGokeiGaku;
    @ReportItem(name = "ari_keisanMeisaishoKi7", length = 2, order = 55)
    public RString ari_keisanMeisaishoKi7;
    @ReportItem(name = "ari_keisanMeisaishoNokigenKaishi7", length = 11, order = 56)
    public RString ari_keisanMeisaishoNokigenKaishi7;
    @ReportItem(name = "ari_kozaMeiginin", length = 20, order = 57)
    public RString ari_kozaMeiginin;
    @ReportItem(name = "ari_keisanMeisaishoTsuki7", length = 2, order = 58)
    public RString ari_keisanMeisaishoTsuki7;
    @ReportItem(name = "ari_keisanMeisaishoNokigenShuryo7", length = 11, order = 59)
    public RString ari_keisanMeisaishoNokigenShuryo7;
    @ReportItem(name = "ari_kaisanMeisaishoNofuZumiGaku", length = 10, order = 60)
    public RString ari_kaisanMeisaishoNofuZumiGaku;
    @ReportItem(name = "ari_keisanMeisaishoKongoNofuGaku", length = 10, order = 61)
    public RString ari_keisanMeisaishoKongoNofuGaku;
    @ReportItem(name = "ari_keisanMeisaishoKi8", length = 2, order = 62)
    public RString ari_keisanMeisaishoKi8;
    @ReportItem(name = "ari_keisanMeisaishoNokigenKaishi8", length = 11, order = 63)
    public RString ari_keisanMeisaishoNokigenKaishi8;
    @ReportItem(name = "ari_yen1", length = 1, order = 64)
    public RString ari_yen1;
    @ReportItem(name = "ari_yen2", length = 1, order = 65)
    public RString ari_yen2;
    @ReportItem(name = "ari_keisanMeisaishoTsuki8", length = 2, order = 66)
    public RString ari_keisanMeisaishoTsuki8;
    @ReportItem(name = "ari_keisanMeisaishoNokigenShuryo8", length = 11, order = 67)
    public RString ari_keisanMeisaishoNokigenShuryo8;
    @ReportItem(name = "ari_keisanMeisaishoKiTitle1", length = 5, order = 68)
    public RString ari_keisanMeisaishoKiTitle1;
    @ReportItem(name = "ari_keisanMeisaishoKibetsuNofuGaku1", length = 10, order = 69)
    public RString ari_keisanMeisaishoKibetsuNofuGaku1;
    @ReportItem(name = "ari_keisanMeisaishoKiTitle3", length = 5, order = 70)
    public RString ari_keisanMeisaishoKiTitle3;
    @ReportItem(name = "ari_keisanMeisaishoKibetsuNofuGaku3", length = 10, order = 71)
    public RString ari_keisanMeisaishoKibetsuNofuGaku3;
    @ReportItem(name = "ari_keisanMeisaishoKi9", length = 2, order = 72)
    public RString ari_keisanMeisaishoKi9;
    @ReportItem(name = "ari_keisanMeisaishoNokigenKaishi9", length = 11, order = 73)
    public RString ari_keisanMeisaishoNokigenKaishi9;
    @ReportItem(name = "ari_yen3", length = 1, order = 74)
    public RString ari_yen3;
    @ReportItem(name = "ari_yen4", length = 1, order = 75)
    public RString ari_yen4;
    @ReportItem(name = "ari_keisanMeisaishoTsuki9", length = 2, order = 76)
    public RString ari_keisanMeisaishoTsuki9;
    @ReportItem(name = "ari_keisanMeisaishoNokigenShuryo9", length = 11, order = 77)
    public RString ari_keisanMeisaishoNokigenShuryo9;
    @ReportItem(name = "ari_keisanMeisaishoKiTitle2", length = 5, order = 78)
    public RString ari_keisanMeisaishoKiTitle2;
    @ReportItem(name = "ari_gekihenTitle", length = 20, order = 79)
    public RString ari_gekihenTitle;
    @ReportItem(name = "ari_keisanMeisaishoKibetsuNofuGaku2", length = 10, order = 80)
    public RString ari_keisanMeisaishoKibetsuNofuGaku2;
    @ReportItem(name = "ari_keisanMeisaishoKiTitle4", length = 5, order = 81)
    public RString ari_keisanMeisaishoKiTitle4;
    @ReportItem(name = "ari_gekihenMongon", length = 20, order = 82)
    public RString ari_gekihenMongon;
    @ReportItem(name = "ari_keisanMeisaishoKibetsuNofuGaku4", length = 10, order = 83)
    public RString ari_keisanMeisaishoKibetsuNofuGaku4;
    @ReportItem(name = "ari_keisanMeisaishoKi10", length = 2, order = 84)
    public RString ari_keisanMeisaishoKi10;
    @ReportItem(name = "ari_keisanMeisaishoNokigenKaishi10", length = 11, order = 85)
    public RString ari_keisanMeisaishoNokigenKaishi10;
    @ReportItem(name = "ari_keisanmeisaishoNendo2", length = 4, order = 86)
    public RString ari_keisanmeisaishoNendo2;
    @ReportItem(name = "ari_keisanMeisaishoTsuki10", length = 2, order = 87)
    public RString ari_keisanMeisaishoTsuki10;
    @ReportItem(name = "ari_keisanMeisaishoNokigenShuryo10", length = 11, order = 88)
    public RString ari_keisanMeisaishoNokigenShuryo10;
    @ReportItem(name = "ari_keisanMeisaishoHokenryoGokeiGaku", length = 15, order = 89)
    public RString ari_keisanMeisaishoHokenryoGokeiGaku;
    @ReportItem(name = "ari_pagerenban1", length = 10, order = 90)
    public RString ari_pagerenban1;
    @ReportItem(name = "ari_pagerenban2", length = 10, order = 91)
    public RString ari_pagerenban2;
    @ReportItem(name = "ari_nokibetsuMeisaishoNendo", length = 4, order = 92)
    public RString ari_nokibetsuMeisaishoNendo;
    @ReportItem(name = "ari_nokibetsuMeisaishoNendoBun", length = 9, order = 93)
    public RString ari_nokibetsuMeisaishoNendoBun;
    @ReportItem(name = "ari_kozaIraishoLeftJusho", order = 94)
    public RString ari_kozaIraishoLeftJusho;
    @ReportItem(name = "ari_kozaIraishoRightJusho", order = 95)
    public RString ari_kozaIraishoRightJusho;
    @ReportItem(name = "ari_nokibetsuMeisaishoTokuchoNofuGaku1", length = 10, order = 96)
    public RString ari_nokibetsuMeisaishoTokuchoNofuGaku1;
    @ReportItem(name = "ari_nokibetsuMeisaishoTokuchoNofuZumiGaku1", length = 10, order = 97)
    public RString ari_nokibetsuMeisaishoTokuchoNofuZumiGaku1;
    @ReportItem(name = "ari_nokibetsuMeisaishoTsuchishoNo", order = 98)
    public RString ari_nokibetsuMeisaishoTsuchishoNo;
    @ReportItem(name = "ari_nokibetsuMeisaishoSetaiCode", length = 15, order = 99)
    public RString ari_nokibetsuMeisaishoSetaiCode;
    @ReportItem(name = "ari_nokibetsuMeisaishoTokuchoSaGaku1", length = 10, order = 100)
    public RString ari_nokibetsuMeisaishoTokuchoSaGaku1;
    @ReportItem(name = "ari_nokibetsuMeisaishoTokuchoNofuGaku2", length = 10, order = 101)
    public RString ari_nokibetsuMeisaishoTokuchoNofuGaku2;
    @ReportItem(name = "ari_nokibetsuMeisaishoTokuchoNofuZumiGaku2", length = 10, order = 102)
    public RString ari_nokibetsuMeisaishoTokuchoNofuZumiGaku2;
    @ReportItem(name = "ari_nokibetsuMeisaishoTokuchoSaGaku2", length = 10, order = 103)
    public RString ari_nokibetsuMeisaishoTokuchoSaGaku2;
    @ReportItem(name = "ari_kozaIraishoLeftHihokenshaName", order = 104)
    public RString ari_kozaIraishoLeftHihokenshaName;
    @ReportItem(name = "ari_kozaIraishoRightHihokenshaName", order = 105)
    public RString ari_kozaIraishoRightHihokenshaName;
    @ReportItem(name = "ari_nokibetsuMeisaishoHohokenshaName", order = 106)
    public RString ari_nokibetsuMeisaishoHohokenshaName;
    @ReportItem(name = "ari_nokibetsuMeisaishoTokuchoNofuGaku3", length = 10, order = 107)
    public RString ari_nokibetsuMeisaishoTokuchoNofuGaku3;
    @ReportItem(name = "ari_nokibetsuMeisaishoTokuchoNofuZumiGaku3", length = 10, order = 108)
    public RString ari_nokibetsuMeisaishoTokuchoNofuZumiGaku3;
    @ReportItem(name = "ari_nokibetsuMeisaishoTokuchoSaGaku3", length = 10, order = 109)
    public RString ari_nokibetsuMeisaishoTokuchoSaGaku3;
    @ReportItem(name = "ari_nokibetsuMeisaishoTokuchoNofuGaku4", length = 10, order = 110)
    public RString ari_nokibetsuMeisaishoTokuchoNofuGaku4;
    @ReportItem(name = "ari_nokibetsuMeisaishoTokuchoNofuZumiGaku4", length = 10, order = 111)
    public RString ari_nokibetsuMeisaishoTokuchoNofuZumiGaku4;
    @ReportItem(name = "ari_nokibetsuMeisaishoTokuchoSaGaku4", length = 10, order = 112)
    public RString ari_nokibetsuMeisaishoTokuchoSaGaku4;
    @ReportItem(name = "ari_kozaIraishoLeftShikibetsuCode", length = 15, order = 113)
    public RString ari_kozaIraishoLeftShikibetsuCode;
    @ReportItem(name = "ari_kozaIraishoRightShikibetsuCode", length = 15, order = 114)
    public RString ari_kozaIraishoRightShikibetsuCode;
    @ReportItem(name = "ari_nokibetsuMeisaishoKi1", length = 4, order = 115)
    public RString ari_nokibetsuMeisaishoKi1;
    @ReportItem(name = "ari_nokibetsuMeisaishoFuchoNofuGaku1", length = 10, order = 116)
    public RString ari_nokibetsuMeisaishoFuchoNofuGaku1;
    @ReportItem(name = "ari_nokibetsuMeisaishoFuchoNofuZumiGaku1", length = 10, order = 117)
    public RString ari_nokibetsuMeisaishoFuchoNofuZumiGaku1;
    @ReportItem(name = "ari_nokibetsuMeisaishoFuchoSaGaku1", length = 10, order = 118)
    public RString ari_nokibetsuMeisaishoFuchoSaGaku1;
    @ReportItem(name = "ari_nokibetsuMeisaishoNokigen1", length = 11, order = 119)
    public RString ari_nokibetsuMeisaishoNokigen1;
    @ReportItem(name = "ari_nokibetsuMeisaishoKi2", length = 4, order = 120)
    public RString ari_nokibetsuMeisaishoKi2;
    @ReportItem(name = "ari_nokibetsuMeisaishoFuchoNofuGaku2", length = 10, order = 121)
    public RString ari_nokibetsuMeisaishoFuchoNofuGaku2;
    @ReportItem(name = "ari_nokibetsuMeisaishoFuchoNofuZumiGaku2", length = 10, order = 122)
    public RString ari_nokibetsuMeisaishoFuchoNofuZumiGaku2;
    @ReportItem(name = "ari_nokibetsuMeisaishoFuchoSaGaku2", length = 10, order = 123)
    public RString ari_nokibetsuMeisaishoFuchoSaGaku2;
    @ReportItem(name = "ari_nokibetsuMeisaishoNokigen2", length = 11, order = 124)
    public RString ari_nokibetsuMeisaishoNokigen2;
    @ReportItem(name = "ari_nokibetsuMeisaishoKi3", length = 4, order = 125)
    public RString ari_nokibetsuMeisaishoKi3;
    @ReportItem(name = "ari_nokibetsuMeisaishoFuchoNofuGaku3", length = 10, order = 126)
    public RString ari_nokibetsuMeisaishoFuchoNofuGaku3;
    @ReportItem(name = "ari_nokibetsuMeisaishoFuchoNofuZumiGaku3", length = 10, order = 127)
    public RString ari_nokibetsuMeisaishoFuchoNofuZumiGaku3;
    @ReportItem(name = "ari_nokibetsuMeisaishoFuchoSaGaku3", length = 10, order = 128)
    public RString ari_nokibetsuMeisaishoFuchoSaGaku3;
    @ReportItem(name = "ari_nokibetsuMeisaishoNokigen3", length = 11, order = 129)
    public RString ari_nokibetsuMeisaishoNokigen3;
    @ReportItem(name = "ari_nokibetsuMeisaishoKi4", length = 4, order = 130)
    public RString ari_nokibetsuMeisaishoKi4;
    @ReportItem(name = "ari_nokibetsuMeisaishoFuchoNofuGaku4", length = 10, order = 131)
    public RString ari_nokibetsuMeisaishoFuchoNofuGaku4;
    @ReportItem(name = "ari_nokibetsuMeisaishoFuchoNofuZumiGaku4", length = 10, order = 132)
    public RString ari_nokibetsuMeisaishoFuchoNofuZumiGaku4;
    @ReportItem(name = "ari_nokibetsuMeisaishoFuchoSaGaku4", length = 10, order = 133)
    public RString ari_nokibetsuMeisaishoFuchoSaGaku4;
    @ReportItem(name = "ari_nokibetsuMeisaishoNokigen4", length = 11, order = 134)
    public RString ari_nokibetsuMeisaishoNokigen4;
    @ReportItem(name = "ari_nokibetsuMeisaishoKi5", length = 4, order = 135)
    public RString ari_nokibetsuMeisaishoKi5;
    @ReportItem(name = "ari_nokibetsuMeisaishoFuchoNofuGaku5", length = 10, order = 136)
    public RString ari_nokibetsuMeisaishoFuchoNofuGaku5;
    @ReportItem(name = "ari_nokibetsuMeisaishoFuchoNofuZumiGaku5", length = 10, order = 137)
    public RString ari_nokibetsuMeisaishoFuchoNofuZumiGaku5;
    @ReportItem(name = "ari_nokibetsuMeisaishoFuchoSaGaku5", length = 10, order = 138)
    public RString ari_nokibetsuMeisaishoFuchoSaGaku5;
    @ReportItem(name = "ari_nokibetsuMeisaishoNokigen5", length = 11, order = 139)
    public RString ari_nokibetsuMeisaishoNokigen5;
    @ReportItem(name = "ari_nokibetsuMeisaishoKi6", length = 4, order = 140)
    public RString ari_nokibetsuMeisaishoKi6;
    @ReportItem(name = "ari_nokibetsuMeisaishoFuchoNofuGaku6", length = 10, order = 141)
    public RString ari_nokibetsuMeisaishoFuchoNofuGaku6;
    @ReportItem(name = "ari_nokibetsuMeisaishoFuchoNofuZumiGaku6", length = 10, order = 142)
    public RString ari_nokibetsuMeisaishoFuchoNofuZumiGaku6;
    @ReportItem(name = "ari_nokibetsuMeisaishoFuchoSaGaku6", length = 10, order = 143)
    public RString ari_nokibetsuMeisaishoFuchoSaGaku6;
    @ReportItem(name = "ari_nokibetsuMeisaishoNokigen6", length = 11, order = 144)
    public RString ari_nokibetsuMeisaishoNokigen6;
    @ReportItem(name = "ari_nokibetsuMeisaishoKi7", length = 4, order = 145)
    public RString ari_nokibetsuMeisaishoKi7;
    @ReportItem(name = "ari_nokibetsuMeisaishoFuchoNofuGaku7", length = 10, order = 146)
    public RString ari_nokibetsuMeisaishoFuchoNofuGaku7;
    @ReportItem(name = "ari_nokibetsuMeisaishoFuchoNofuZumiGaku7", length = 10, order = 147)
    public RString ari_nokibetsuMeisaishoFuchoNofuZumiGaku7;
    @ReportItem(name = "ari_nokibetsuMeisaishoFuchoSaGaku7", length = 10, order = 148)
    public RString ari_nokibetsuMeisaishoFuchoSaGaku7;
    @ReportItem(name = "ari_nokibetsuMeisaishoNokigen7", length = 11, order = 149)
    public RString ari_nokibetsuMeisaishoNokigen7;
    @ReportItem(name = "ari_nokibetsuMeisaishoKi8", length = 4, order = 150)
    public RString ari_nokibetsuMeisaishoKi8;
    @ReportItem(name = "ari_nokibetsuMeisaishoFuchoNofuGaku8", length = 10, order = 151)
    public RString ari_nokibetsuMeisaishoFuchoNofuGaku8;
    @ReportItem(name = "ari_nokibetsuMeisaishoFuchoNofuZumiGaku8", length = 10, order = 152)
    public RString ari_nokibetsuMeisaishoFuchoNofuZumiGaku8;
    @ReportItem(name = "ari_nokibetsuMeisaishoFuchoSaGaku8", length = 10, order = 153)
    public RString ari_nokibetsuMeisaishoFuchoSaGaku8;
    @ReportItem(name = "ari_nokibetsuMeisaishoNokigen8", length = 11, order = 154)
    public RString ari_nokibetsuMeisaishoNokigen8;
    @ReportItem(name = "ari_nokibetsuMeisaishoKi9", length = 4, order = 155)
    public RString ari_nokibetsuMeisaishoKi9;
    @ReportItem(name = "ari_nokibetsuMeisaishoFuchoNofuGaku9", length = 10, order = 156)
    public RString ari_nokibetsuMeisaishoFuchoNofuGaku9;
    @ReportItem(name = "ari_nokibetsuMeisaishoFuchoNofuZumiGaku9", length = 10, order = 157)
    public RString ari_nokibetsuMeisaishoFuchoNofuZumiGaku9;
    @ReportItem(name = "ari_nokibetsuMeisaishoFuchoSaGaku9", length = 10, order = 158)
    public RString ari_nokibetsuMeisaishoFuchoSaGaku9;
    @ReportItem(name = "ari_nokibetsuMeisaishoNokigen9", length = 11, order = 159)
    public RString ari_nokibetsuMeisaishoNokigen9;
    @ReportItem(name = "ari_nokibetsuMeisaishoKi10", length = 4, order = 160)
    public RString ari_nokibetsuMeisaishoKi10;
    @ReportItem(name = "ari_nokibetsuMeisaishoFuchoNofuGaku10", length = 10, order = 161)
    public RString ari_nokibetsuMeisaishoFuchoNofuGaku10;
    @ReportItem(name = "ari_nokibetsuMeisaishoFuchoNofuZumiGaku10", length = 10, order = 162)
    public RString ari_nokibetsuMeisaishoFuchoNofuZumiGaku10;
    @ReportItem(name = "ari_nokibetsuMeisaishoFuchoSaGaku10", length = 10, order = 163)
    public RString ari_nokibetsuMeisaishoFuchoSaGaku10;
    @ReportItem(name = "ari_nokibetsuMeisaishoNokigen10", length = 11, order = 164)
    public RString ari_nokibetsuMeisaishoNokigen10;
    @ReportItem(name = "ari_nokibetsuMeisaishoFuchoNofuGaku11", length = 10, order = 165)
    public RString ari_nokibetsuMeisaishoFuchoNofuGaku11;
    @ReportItem(name = "ari_nokibetsuMeisaishoFuchoNofuZumiGaku11", length = 10, order = 166)
    public RString ari_nokibetsuMeisaishoFuchoNofuZumiGaku11;
    @ReportItem(name = "ari_nokibetsuMeisaishoFuchoSaGaku11", length = 10, order = 167)
    public RString ari_nokibetsuMeisaishoFuchoSaGaku11;
    @ReportItem(name = "ari_renban", length = 10, order = 168)
    public RString ari_renban;
    @ReportItem(name = "ari_hokenshaName", length = 10, order = 169)
    public RString ari_hokenshaName;
    @ReportItem(name = "ari_pagerenban3", length = 10, order = 170)
    public RString ari_pagerenban3;
    @ReportItem(name = "ari_pagerenban4", length = 10, order = 171)
    public RString ari_pagerenban4;
    @ReportItem(name = "ari_yubinNo", length = 8, order = 172)
    public RString ari_yubinNo;
    @ReportItem(name = "ari_gyoseiku", length = 14, order = 173)
    public RString ari_gyoseiku;
    @ReportItem(name = "ari_jushoText", order = 174)
    public RString ari_jushoText;
    @ReportItem(name = "ari_jusho3", length = 20, order = 175)
    public RString ari_jusho3;
    @ReportItem(name = "ari_jusho1", length = 20, order = 176)
    public RString ari_jusho1;
    @ReportItem(name = "ari_jusho2", length = 20, order = 177)
    public RString ari_jusho2;
    @ReportItem(name = "ari_katagakiText", order = 178)
    public RString ari_katagakiText;
    @ReportItem(name = "ari_katagaki2", length = 20, order = 179)
    public RString ari_katagaki2;
    @ReportItem(name = "ari_katagakiSmall2", length = 30, order = 180)
    public RString ari_katagakiSmall2;
    @ReportItem(name = "ari_katagaki1", length = 20, order = 181)
    public RString ari_katagaki1;
    @ReportItem(name = "ari_katagakiSmall1", length = 30, order = 182)
    public RString ari_katagakiSmall1;
    @ReportItem(name = "ari_shimei2", length = 20, order = 183)
    public RString ari_shimei2;
    @ReportItem(name = "ari_shimeiSmall2", length = 40, order = 184)
    public RString ari_shimeiSmall2;
    @ReportItem(name = "ari_shimeiText", order = 185)
    public RString ari_shimeiText;
    @ReportItem(name = "ari_meishoFuyo2", length = 3, order = 186)
    public RString ari_meishoFuyo2;
    @ReportItem(name = "ari_shimeiSmall1", length = 40, order = 187)
    public RString ari_shimeiSmall1;
    @ReportItem(name = "ari_dainoKubunMei", length = 8, order = 188)
    public RString ari_dainoKubunMei;
    @ReportItem(name = "ari_shimei1", length = 20, order = 189)
    public RString ari_shimei1;
    @ReportItem(name = "ari_meishoFuyo1", length = 3, order = 190)
    public RString ari_meishoFuyo1;
    @ReportItem(name = "ari_samabunShimeiText", order = 191)
    public RString ari_samabunShimeiText;
    @ReportItem(name = "ari_samaBun2", length = 3, order = 192)
    public RString ari_samaBun2;
    @ReportItem(name = "ari_samabunShimeiSmall2", length = 40, order = 193)
    public RString ari_samabunShimeiSmall2;
    @ReportItem(name = "ari_kakkoLeft2", length = 1, order = 194)
    public RString ari_kakkoLeft2;
    @ReportItem(name = "ari_samabunShimei2", length = 20, order = 195)
    public RString ari_samabunShimei2;
    @ReportItem(name = "ari_kakkoRight2", length = 1, order = 196)
    public RString ari_kakkoRight2;
    @ReportItem(name = "ari_kakkoLeft1", length = 1, order = 197)
    public RString ari_kakkoLeft1;
    @ReportItem(name = "ari_samabunShimei1", length = 20, order = 198)
    public RString ari_samabunShimei1;
    @ReportItem(name = "ari_samaBun1", length = 3, order = 199)
    public RString ari_samaBun1;
    @ReportItem(name = "ari_kakkoRight1", length = 1, order = 200)
    public RString ari_kakkoRight1;
    @ReportItem(name = "ari_samabunShimeiSmall1", length = 40, order = 201)
    public RString ari_samabunShimeiSmall1;
    @ReportItem(name = "ari_customerBarCode", order = 202)
    public RString ari_customerBarCode;
    @ReportItem(name = "ari_denshiKoin", order = 203)
    public RString ari_denshiKoin;
    @ReportItem(name = "ari_hakkoYMD", length = 12, order = 204)
    public RString ari_hakkoYMD;
    @ReportItem(name = "ari_ninshoshaYakushokuMei", length = 15, order = 205)
    public RString ari_ninshoshaYakushokuMei;
    @ReportItem(name = "ari_ninshoshaYakushokuMei1", order = 206)
    public RString ari_ninshoshaYakushokuMei1;
    @ReportItem(name = "ari_koinMojiretsu", length = 4, order = 207)
    public RString ari_koinMojiretsu;
    @ReportItem(name = "ari_ninshoshaYakushokuMei2", order = 208)
    public RString ari_ninshoshaYakushokuMei2;
    @ReportItem(name = "ari_ninshoshaShimeiKakenai", order = 209)
    public RString ari_ninshoshaShimeiKakenai;
    @ReportItem(name = "ari_ninshoshaShimeiKakeru", order = 210)
    public RString ari_ninshoshaShimeiKakeru;
    @ReportItem(name = "ari_koinShoryaku", length = 15, order = 211)
    public RString ari_koinShoryaku;

    // <DBB100057_NonyuTsuchishoBookFuriKaeAriRenchoCover.rse">
//    @ReportItem(name = "arirencho_listList1_1", length = 1, order = 1)
//    public RString arirencho_listList1_1;
//    @ReportItem(name = "arirencho_keisanMeisaishoNendo", length = 4, order = 2)
//    public RString arirencho_keisanMeisaishoNendo;
//    @ReportItem(name = "arirencho_keisanMeisaishoNendoBun", length = 9, order = 3)
//    public RString arirencho_keisanMeisaishoNendoBun;
//    @ReportItem(name = "arirencho_titleNendo", length = 4, order = 4)
//    public RString arirencho_titleNendo;
//    @ReportItem(name = "arirencho_titleNendoBun", length = 9, order = 5)
//    public RString arirencho_titleNendoBun;
//    @ReportItem(name = "arirencho_HyojicodeName1", order = 6)
//    public RString arirencho_HyojicodeName1;
//    @ReportItem(name = "arirencho_HyojicodeName2", order = 7)
//    public RString arirencho_HyojicodeName2;
//    @ReportItem(name = "arirencho_HyojicodeName3", order = 8)
//    public RString arirencho_HyojicodeName3;
//    @ReportItem(name = "arirencho_Hyojicode1", length = 11, order = 9)
//    public RString arirencho_Hyojicode1;
//    @ReportItem(name = "arirencho_Hyojicode2", length = 9, order = 10)
//    public RString arirencho_Hyojicode2;
//    @ReportItem(name = "arirencho_Hyojicode3", length = 9, order = 11)
//    public RString arirencho_Hyojicode3;
//    @ReportItem(name = "arirencho_keisanMeisaishoKi1", length = 2, order = 12)
//    public RString arirencho_keisanMeisaishoKi1;
//    @ReportItem(name = "arirencho_keisanMeisaishoNokigenKaishi1", length = 11, order = 13)
//    public RString arirencho_keisanMeisaishoNokigenKaishi1;
//    @ReportItem(name = "arirencho_kaisanMeisaishoHihokenshaName", order = 14)
//    public RString arirencho_kaisanMeisaishoHihokenshaName;
//    @ReportItem(name = "arirencho_kaisanMeisaishoSetaiNushiName", order = 15)
//    public RString arirencho_kaisanMeisaishoSetaiNushiName;
//    @ReportItem(name = "arirencho_keisanMeisaishoTsuchishoNo", order = 16)
//    public RString arirencho_keisanMeisaishoTsuchishoNo;
//    @ReportItem(name = "arirencho_keisanMeisaishoSetaiCode", length = 15, order = 17)
//    public RString arirencho_keisanMeisaishoSetaiCode;
//    @ReportItem(name = "arirencho_keisanMeisaishoTsuki1", length = 2, order = 18)
//    public RString arirencho_keisanMeisaishoTsuki1;
//    @ReportItem(name = "arirencho_keisanMeisaishoNokigenShuryo1", length = 11, order = 19)
//    public RString arirencho_keisanMeisaishoNokigenShuryo1;
//    @ReportItem(name = "arirencho_keisanMeisaishoKi2", length = 2, order = 20)
//    public RString arirencho_keisanMeisaishoKi2;
//    @ReportItem(name = "arirencho_keisanMeisaishoNokigenKaishi2", length = 11, order = 21)
//    public RString arirencho_keisanMeisaishoNokigenKaishi2;
//    @ReportItem(name = "arirencho_keisanMeisaishoTsuki2", length = 2, order = 22)
//    public RString arirencho_keisanMeisaishoTsuki2;
//    @ReportItem(name = "arirencho_keisanMeisaishoNokigenShuryo2", length = 11, order = 23)
//    public RString arirencho_keisanMeisaishoNokigenShuryo2;
//    @ReportItem(name = "arirencho_tsuchishoNo", order = 24)
//    public RString arirencho_tsuchishoNo;
//    @ReportItem(name = "arirencho_setaiCode", length = 15, order = 25)
//    public RString arirencho_setaiCode;
//    @ReportItem(name = "arirencho_keisanMeisaishoKi3", length = 2, order = 26)
//    public RString arirencho_keisanMeisaishoKi3;
//    @ReportItem(name = "arirencho_keisanMeisaishoNokigenKaishi3", length = 11, order = 27)
//    public RString arirencho_keisanMeisaishoNokigenKaishi3;
//    @ReportItem(name = "arirencho_keisanMeisaishoKaishiKi", length = 16, order = 28)
//    public RString arirencho_keisanMeisaishoKaishiKi;
//    @ReportItem(name = "arirencho_keisanMeisaishoTsuki3", length = 2, order = 29)
//    public RString arirencho_keisanMeisaishoTsuki3;
//    @ReportItem(name = "arirencho_keisanMeisaishoNokigenShuryo3", length = 11, order = 30)
//    public RString arirencho_keisanMeisaishoNokigenShuryo3;
//    @ReportItem(name = "arirencho_keisanMeisaishoTsukiSu", length = 12, order = 31)
//    public RString arirencho_keisanMeisaishoTsukiSu;
//    @ReportItem(name = "arirencho_kaisanMeisaishoShuryoKi", length = 16, order = 32)
//    public RString arirencho_kaisanMeisaishoShuryoKi;
//    @ReportItem(name = "arirencho_keisanMeisaishoKi4", length = 2, order = 33)
//    public RString arirencho_keisanMeisaishoKi4;
//    @ReportItem(name = "arirencho_keisanMeisaishoNokigenKaishi4", length = 11, order = 34)
//    public RString arirencho_keisanMeisaishoNokigenKaishi4;
//    @ReportItem(name = "arirencho_bankCode", length = 7, order = 35)
//    public RString arirencho_bankCode;
//    @ReportItem(name = "arirencho_kozaShurui", length = 3, order = 36)
//    public RString arirencho_kozaShurui;
//    @ReportItem(name = "arirencho_kozaNo", length = 14, order = 37)
//    public RString arirencho_kozaNo;
//    @ReportItem(name = "arirencho_keisanMeisaishoTsuki4", length = 2, order = 38)
//    public RString arirencho_keisanMeisaishoTsuki4;
//    @ReportItem(name = "arirencho_keisanMeisaishoNokigenShuryo4", length = 11, order = 39)
//    public RString arirencho_keisanMeisaishoNokigenShuryo4;
//    @ReportItem(name = "arirencho_keisanMeisaishoShotokuDankai", length = 8, order = 40)
//    public RString arirencho_keisanMeisaishoShotokuDankai;
//    @ReportItem(name = "arirencho_kaisanMeisaiHokenryoRitsu", length = 10, order = 41)
//    public RString arirencho_kaisanMeisaiHokenryoRitsu;
//    @ReportItem(name = "arirencho_keisanMeisaishoKi5", length = 2, order = 42)
//    public RString arirencho_keisanMeisaishoKi5;
//    @ReportItem(name = "arirencho_keisanMeisaishoNokigenKaishi5", length = 11, order = 43)
//    public RString arirencho_keisanMeisaishoNokigenKaishi5;
//    @ReportItem(name = "arirencho_keisanMeisaishoTsuki5", length = 2, order = 44)
//    public RString arirencho_keisanMeisaishoTsuki5;
//    @ReportItem(name = "arirencho_keisanMeisaishoNokigenShuryo5", length = 11, order = 45)
//    public RString arirencho_keisanMeisaishoNokigenShuryo5;
//    @ReportItem(name = "arirencho_keisanMeisaishoCalHokenryoGaku", length = 10, order = 46)
//    public RString arirencho_keisanMeisaishoCalHokenryoGaku;
//    @ReportItem(name = "arirencho_keisanMeisaishoGenmenGaku", length = 10, order = 47)
//    public RString arirencho_keisanMeisaishoGenmenGaku;
//    @ReportItem(name = "arirencho_bankName", length = 20, order = 48)
//    public RString arirencho_bankName;
//    @ReportItem(name = "arirencho_keisanMeisaishoKi6", length = 2, order = 49)
//    public RString arirencho_keisanMeisaishoKi6;
//    @ReportItem(name = "arirencho_keisanMeisaishoNokigenKaishi6", length = 11, order = 50)
//    public RString arirencho_keisanMeisaishoNokigenKaishi6;
//    @ReportItem(name = "arirencho_keisanMeisaishoTsuki6", length = 2, order = 51)
//    public RString arirencho_keisanMeisaishoTsuki6;
//    @ReportItem(name = "arirencho_keisanMeisaishoNokigenShuryo6", length = 11, order = 52)
//    public RString arirencho_keisanMeisaishoNokigenShuryo6;
//    @ReportItem(name = "arirencho_keisanMeisaishoTokuchoGokeiGaku", length = 10, order = 53)
//    public RString arirencho_keisanMeisaishoTokuchoGokeiGaku;
//    @ReportItem(name = "arirencho_kaisanMeisaishoFuchoGokeiGaku", length = 10, order = 54)
//    public RString arirencho_kaisanMeisaishoFuchoGokeiGaku;
//    @ReportItem(name = "arirencho_keisanMeisaishoKi7", length = 2, order = 55)
//    public RString arirencho_keisanMeisaishoKi7;
//    @ReportItem(name = "arirencho_keisanMeisaishoNokigenKaishi7", length = 11, order = 56)
//    public RString arirencho_keisanMeisaishoNokigenKaishi7;
//    @ReportItem(name = "arirencho_noutsuRenban", length = 8, order = 57)
//    public RString arirencho_noutsuRenban;
//    @ReportItem(name = "arirencho_kozaMeiginin", length = 20, order = 58)
//    public RString arirencho_kozaMeiginin;
//    @ReportItem(name = "arirencho_keisanMeisaishoTsuki7", length = 2, order = 59)
//    public RString arirencho_keisanMeisaishoTsuki7;
//    @ReportItem(name = "arirencho_keisanMeisaishoNokigenShuryo7", length = 11, order = 60)
//    public RString arirencho_keisanMeisaishoNokigenShuryo7;
//    @ReportItem(name = "arirencho_kaisanMeisaishoNofuZumiGaku", length = 10, order = 61)
//    public RString arirencho_kaisanMeisaishoNofuZumiGaku;
//    @ReportItem(name = "arirencho_keisanMeisaishoKongoNofuGaku", length = 10, order = 62)
//    public RString arirencho_keisanMeisaishoKongoNofuGaku;
//    @ReportItem(name = "arirencho_keisanMeisaishoKi8", length = 2, order = 63)
//    public RString arirencho_keisanMeisaishoKi8;
//    @ReportItem(name = "arirencho_keisanMeisaishoNokigenKaishi8", length = 11, order = 64)
//    public RString arirencho_keisanMeisaishoNokigenKaishi8;
//    @ReportItem(name = "arirencho_yen1", length = 1, order = 65)
//    public RString arirencho_yen1;
//    @ReportItem(name = "arirencho_yen2", length = 1, order = 66)
//    public RString arirencho_yen2;
//    @ReportItem(name = "arirencho_keisanMeisaishoTsuki8", length = 2, order = 67)
//    public RString arirencho_keisanMeisaishoTsuki8;
//    @ReportItem(name = "arirencho_keisanMeisaishoNokigenShuryo8", length = 11, order = 68)
//    public RString arirencho_keisanMeisaishoNokigenShuryo8;
//    @ReportItem(name = "arirencho_keisanMeisaishoKiTitle1", length = 5, order = 69)
//    public RString arirencho_keisanMeisaishoKiTitle1;
//    @ReportItem(name = "arirencho_keisanMeisaishoKibetsuNofuGaku1", length = 10, order = 70)
//    public RString arirencho_keisanMeisaishoKibetsuNofuGaku1;
//    @ReportItem(name = "arirencho_keisanMeisaishoKiTitle3", length = 5, order = 71)
//    public RString arirencho_keisanMeisaishoKiTitle3;
//    @ReportItem(name = "arirencho_keisanMeisaishoKiNofuGaku3", length = 10, order = 72)
//    public RString arirencho_keisanMeisaishoKiNofuGaku3;
//    @ReportItem(name = "arirencho_keisanMeisaishoKi9", length = 2, order = 73)
//    public RString arirencho_keisanMeisaishoKi9;
//    @ReportItem(name = "arirencho_keisanMeisaishoNokigenKaishi9", length = 11, order = 74)
//    public RString arirencho_keisanMeisaishoNokigenKaishi9;
//    @ReportItem(name = "arirencho_yen3", length = 1, order = 75)
//    public RString arirencho_yen3;
//    @ReportItem(name = "arirencho_yen4", length = 1, order = 76)
//    public RString arirencho_yen4;
//    @ReportItem(name = "arirencho_keisanMeisaishoTsuki9", length = 2, order = 77)
//    public RString arirencho_keisanMeisaishoTsuki9;
//    @ReportItem(name = "arirencho_keisanMeisaishoNokigenShuryo9", length = 11, order = 78)
//    public RString arirencho_keisanMeisaishoNokigenShuryo9;
//    @ReportItem(name = "arirencho_keisanMeisaishoKiTitle2", length = 5, order = 79)
//    public RString arirencho_keisanMeisaishoKiTitle2;
//    @ReportItem(name = "arirencho_gekihenTitle", length = 20, order = 80)
//    public RString arirencho_gekihenTitle;
//    @ReportItem(name = "arirencho_keisanMeisaishoKibetsuNofuGaku2", length = 10, order = 81)
//    public RString arirencho_keisanMeisaishoKibetsuNofuGaku2;
//    @ReportItem(name = "arirencho_keisanMeisaishoKiTitle4", length = 5, order = 82)
//    public RString arirencho_keisanMeisaishoKiTitle4;
//    @ReportItem(name = "arirencho_gekihenMongon", length = 20, order = 83)
//    public RString arirencho_gekihenMongon;
//    @ReportItem(name = "arirencho_keisanMeisaishoKiNofuGaku4", length = 10, order = 84)
//    public RString arirencho_keisanMeisaishoKiNofuGaku4;
//    @ReportItem(name = "arirencho_keisanMeisaishoKi10", length = 2, order = 85)
//    public RString arirencho_keisanMeisaishoKi10;
//    @ReportItem(name = "arirencho_keisanMeisaishoNokigenKaishi10", length = 11, order = 86)
//    public RString arirencho_keisanMeisaishoNokigenKaishi10;
//    @ReportItem(name = "arirencho_keisanmeisaishoNendo2", length = 4, order = 87)
//    public RString arirencho_keisanmeisaishoNendo2;
//    @ReportItem(name = "arirencho_keisanMeisaishoTsuki10", length = 2, order = 88)
//    public RString arirencho_keisanMeisaishoTsuki10;
//    @ReportItem(name = "arirencho_keisanMeisaishoNokigenShuryo10", length = 11, order = 89)
//    public RString arirencho_keisanMeisaishoNokigenShuryo10;
//    @ReportItem(name = "arirencho_keisanMeisaishoHokenryoGokeiGaku", length = 15, order = 90)
//    public RString arirencho_keisanMeisaishoHokenryoGokeiGaku;
//    @ReportItem(name = "arirencho_pagerenban1", length = 10, order = 91)
//    public RString arirencho_pagerenban1;
//    @ReportItem(name = "arirencho_pagerenban2", length = 10, order = 92)
//    public RString arirencho_pagerenban2;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoNendo", length = 4, order = 93)
//    public RString arirencho_nokibetsuMeisaishoNendo;
//    @ReportItem(name = "arirencho_kmNendoBun", length = 9, order = 94)
//    public RString arirencho_kmNendoBun;
//    @ReportItem(name = "arirencho_kozaIraishoLeftJusho", order = 95)
//    public RString arirencho_kozaIraishoLeftJusho;
//    @ReportItem(name = "arirencho_kozaIraishoRightJusho", order = 96)
//    public RString arirencho_kozaIraishoRightJusho;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoTokuchoNofuGaku1", length = 10, order = 97)
//    public RString arirencho_nokibetsuMeisaishoTokuchoNofuGaku1;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoTokuchoNofuZumiGaku1", length = 10, order = 98)
//    public RString arirencho_nokibetsuMeisaishoTokuchoNofuZumiGaku1;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoTokuchoSaGaku1", length = 10, order = 99)
//    public RString arirencho_nokibetsuMeisaishoTokuchoSaGaku1;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoTsuchishoNo", order = 100)
//    public RString arirencho_nokibetsuMeisaishoTsuchishoNo;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoSetaiCode", length = 15, order = 101)
//    public RString arirencho_nokibetsuMeisaishoSetaiCode;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoTokuchoNofuGaku2", length = 10, order = 102)
//    public RString arirencho_nokibetsuMeisaishoTokuchoNofuGaku2;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoTokuchoNofuZumiGaku2", length = 10, order = 103)
//    public RString arirencho_nokibetsuMeisaishoTokuchoNofuZumiGaku2;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoTokuchoSaGaku2", length = 10, order = 104)
//    public RString arirencho_nokibetsuMeisaishoTokuchoSaGaku2;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoHohokenshaName", order = 105)
//    public RString arirencho_nokibetsuMeisaishoHohokenshaName;
//    @ReportItem(name = "arirencho_Text2", order = 106)
//    public RString arirencho_Text2;
//    @ReportItem(name = "kozaIraishoLeftHihokenshaName", order = 107)
//    public RString arirencho_kozaIraishoLeftHihokenshaName;
//    @ReportItem(name = "arirencho_kozaIraishoRightHihokenshaName", order = 108)
//    public RString arirencho_kozaIraishoRightHihokenshaName;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoTokuchoNofuGaku3", length = 10, order = 109)
//    public RString arirencho_nokibetsuMeisaishoTokuchoNofuGaku3;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoTokuchoNofuZumiGaku3", length = 10, order = 110)
//    public RString arirencho_nokibetsuMeisaishoTokuchoNofuZumiGaku3;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoTokuchoSaGaku3", length = 10, order = 111)
//    public RString arirencho_nokibetsuMeisaishoTokuchoSaGaku3;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoTokuchoNofuGaku4", length = 10, order = 112)
//    public RString arirencho_nokibetsuMeisaishoTokuchoNofuGaku4;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoTokuchoNofuZumiGaku4", length = 10, order = 113)
//    public RString arirencho_nokibetsuMeisaishoTokuchoNofuZumiGaku4;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoTokuchoSaGaku4", length = 10, order = 114)
//    public RString arirencho_nokibetsuMeisaishoTokuchoSaGaku4;
//    @ReportItem(name = "arirencho_kozaIraishoLeftShikibetsuCode", length = 15, order = 115)
//    public RString arirencho_kozaIraishoLeftShikibetsuCode;
//    @ReportItem(name = "arirencho_kozaIraishoRightShikibetsuCode", length = 15, order = 116)
//    public RString arirencho_kozaIraishoRightShikibetsuCode;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoKi1", length = 4, order = 117)
//    public RString arirencho_nokibetsuMeisaishoKi1;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoFuchoNofuGaku1", length = 10, order = 118)
//    public RString arirencho_nokibetsuMeisaishoFuchoNofuGaku1;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoFuchoNofuZumiGaku1", length = 10, order = 119)
//    public RString arirencho_nokibetsuMeisaishoFuchoNofuZumiGaku1;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoFuchoSaGaku1", length = 10, order = 120)
//    public RString arirencho_nokibetsuMeisaishoFuchoSaGaku1;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoNokigen1", length = 11, order = 121)
//    public RString arirencho_nokibetsuMeisaishoNokigen1;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoKi2", length = 4, order = 122)
//    public RString arirencho_nokibetsuMeisaishoKi2;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoFuchoNofuGaku2", length = 10, order = 123)
//    public RString arirencho_nokibetsuMeisaishoFuchoNofuGaku2;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoFuchoNofuZumiGaku2", length = 10, order = 124)
//    public RString arirencho_nokibetsuMeisaishoFuchoNofuZumiGaku2;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoFuchoSaGaku2", length = 10, order = 125)
//    public RString arirencho_nokibetsuMeisaishoFuchoSaGaku2;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoNokigen2", length = 11, order = 126)
//    public RString arirencho_nokibetsuMeisaishoNokigen2;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoKi3", length = 4, order = 127)
//    public RString arirencho_nokibetsuMeisaishoKi3;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoFuchoNofuGaku3", length = 10, order = 128)
//    public RString arirencho_nokibetsuMeisaishoFuchoNofuGaku3;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoFuchoNofuZumiGaku3", length = 10, order = 129)
//    public RString arirencho_nokibetsuMeisaishoFuchoNofuZumiGaku3;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoFuchoSaGaku3", length = 10, order = 130)
//    public RString arirencho_nokibetsuMeisaishoFuchoSaGaku3;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoNokigen3", length = 11, order = 131)
//    public RString arirencho_nokibetsuMeisaishoNokigen3;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoKi4", length = 4, order = 132)
//    public RString arirencho_nokibetsuMeisaishoKi4;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoFuchoNofuGaku4", length = 10, order = 133)
//    public RString arirencho_nokibetsuMeisaishoFuchoNofuGaku4;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoFuchoNofuZumiGaku4", length = 10, order = 134)
//    public RString arirencho_nokibetsuMeisaishoFuchoNofuZumiGaku4;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoFuchoSaGaku4", length = 10, order = 135)
//    public RString arirencho_nokibetsuMeisaishoFuchoSaGaku4;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoNokigen4", length = 11, order = 136)
//    public RString arirencho_nokibetsuMeisaishoNokigen4;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoKi5", length = 4, order = 137)
//    public RString arirencho_nokibetsuMeisaishoKi5;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoFuchoNofuGaku5", length = 10, order = 138)
//    public RString arirencho_nokibetsuMeisaishoFuchoNofuGaku5;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoFuchoNofuZumiGaku5", length = 10, order = 139)
//    public RString arirencho_nokibetsuMeisaishoFuchoNofuZumiGaku5;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoFuchoSaGaku5", length = 10, order = 140)
//    public RString arirencho_nokibetsuMeisaishoFuchoSaGaku5;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoNokigen5", length = 11, order = 141)
//    public RString arirencho_nokibetsuMeisaishoNokigen5;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoKi6", length = 4, order = 142)
//    public RString arirencho_nokibetsuMeisaishoKi6;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoFuchoNofuGaku6", length = 10, order = 143)
//    public RString arirencho_nokibetsuMeisaishoFuchoNofuGaku6;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoFuchoNofuZumiGaku6", length = 10, order = 144)
//    public RString arirencho_nokibetsuMeisaishoFuchoNofuZumiGaku6;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoFuchoSaGaku6", length = 10, order = 145)
//    public RString arirencho_nokibetsuMeisaishoFuchoSaGaku6;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoNokigen6", length = 11, order = 146)
//    public RString arirencho_nokibetsuMeisaishoNokigen6;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoKi7", length = 4, order = 147)
//    public RString arirencho_nokibetsuMeisaishoKi7;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoFuchoNofuGaku7", length = 10, order = 148)
//    public RString arirencho_nokibetsuMeisaishoFuchoNofuGaku7;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoFuchoNofuZumiGaku7", length = 10, order = 149)
//    public RString arirencho_nokibetsuMeisaishoFuchoNofuZumiGaku7;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoFuchoSaGaku7", length = 10, order = 150)
//    public RString arirencho_nokibetsuMeisaishoFuchoSaGaku7;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoNokigen7", length = 11, order = 151)
//    public RString arirencho_nokibetsuMeisaishoNokigen7;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoKi8", length = 4, order = 152)
//    public RString arirencho_nokibetsuMeisaishoKi8;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoFuchoNofuGaku8", length = 10, order = 153)
//    public RString arirencho_nokibetsuMeisaishoFuchoNofuGaku8;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoFuchoNofuZumiGaku8", length = 10, order = 154)
//    public RString arirencho_nokibetsuMeisaishoFuchoNofuZumiGaku8;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoFuchoSaGaku8", length = 10, order = 155)
//    public RString arirencho_nokibetsuMeisaishoFuchoSaGaku8;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoNokigen8", length = 11, order = 156)
//    public RString arirencho_nokibetsuMeisaishoNokigen8;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoKi9", length = 4, order = 157)
//    public RString arirencho_nokibetsuMeisaishoKi9;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoFuchoNofuGaku9", length = 10, order = 158)
//    public RString arirencho_nokibetsuMeisaishoFuchoNofuGaku9;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoFuchoNofuZumiGaku9", length = 10, order = 159)
//    public RString arirencho_nokibetsuMeisaishoFuchoNofuZumiGaku9;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoFuchoSaGaku9", length = 10, order = 160)
//    public RString arirencho_nokibetsuMeisaishoFuchoSaGaku9;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoNokigen9", length = 11, order = 161)
//    public RString arirencho_nokibetsuMeisaishoNokigen9;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoKi10", length = 4, order = 162)
//    public RString arirencho_nokibetsuMeisaishoKi10;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoFuchoNofuGaku10", length = 10, order = 163)
//    public RString arirencho_nokibetsuMeisaishoFuchoNofuGaku10;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoFuchoNofuZumiGaku10", length = 10, order = 164)
//    public RString arirencho_nokibetsuMeisaishoFuchoNofuZumiGaku10;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoFuchoSaGaku10", length = 10, order = 165)
//    public RString arirencho_nokibetsuMeisaishoFuchoSaGaku10;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoNokigen10", length = 11, order = 166)
//    public RString arirencho_nokibetsuMeisaishoNokigen10;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoFuchoNofuGaku11", length = 10, order = 167)
//    public RString arirencho_nokibetsuMeisaishoFuchoNofuGaku11;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoFuchoNofuZumiGaku11", length = 10, order = 168)
//    public RString arirencho_nokibetsuMeisaishoFuchoNofuZumiGaku11;
//    @ReportItem(name = "arirencho_nokibetsuMeisaishoFuchoSaGaku11", length = 10, order = 169)
//    public RString arirencho_nokibetsuMeisaishoFuchoSaGaku11;
//    @ReportItem(name = "arirencho_pagerenban3", length = 10, order = 170)
//    public RString arirencho_pagerenban3;
//    @ReportItem(name = "arirencho_pagerenban4", length = 10, order = 171)
//    public RString arirencho_pagerenban4;
//    @ReportItem(name = "arirencho_yubinNo", length = 8, order = 172)
//    public RString arirencho_yubinNo;
//    @ReportItem(name = "arirencho_gyoseiku", length = 14, order = 173)
//    public RString arirencho_gyoseiku;
//    @ReportItem(name = "arirencho_jusho3", length = 20, order = 174)
//    public RString arirencho_jusho3;
//    @ReportItem(name = "arirencho_jushoText", order = 175)
//    public RString arirencho_jushoText;
//    @ReportItem(name = "arirencho_jusho1", length = 20, order = 176)
//    public RString arirencho_jusho1;
//    @ReportItem(name = "arirencho_jusho2", length = 20, order = 177)
//    public RString arirencho_jusho2;
//    @ReportItem(name = "arirencho_katagakiText", order = 178)
//    public RString arirencho_katagakiText;
//    @ReportItem(name = "arirencho_katagaki2", length = 20, order = 179)
//    public RString arirencho_katagaki2;
//    @ReportItem(name = "arirencho_katagakiSmall2", length = 30, order = 180)
//    public RString arirencho_katagakiSmall2;
//    @ReportItem(name = "arirencho_katagaki1", length = 20, order = 181)
//    public RString arirencho_katagaki1;
//    @ReportItem(name = "arirencho_katagakiSmall1", length = 30, order = 182)
//    public RString arirencho_katagakiSmall1;
//    @ReportItem(name = "arirencho_shimei2", length = 20, order = 183)
//    public RString arirencho_shimei2;
//    @ReportItem(name = "arirencho_shimeiSmall2", length = 40, order = 184)
//    public RString arirencho_shimeiSmall2;
//    @ReportItem(name = "arirencho_shimeiText", order = 185)
//    public RString arirencho_shimeiText;
//    @ReportItem(name = "arirencho_meishoFuyo2", length = 3, order = 186)
//    public RString arirencho_meishoFuyo2;
//    @ReportItem(name = "arirencho_shimeiSmall1", length = 40, order = 187)
//    public RString arirencho_shimeiSmall1;
//    @ReportItem(name = "arirencho_dainoKubunMei", length = 8, order = 188)
//    public RString arirencho_dainoKubunMei;
//    @ReportItem(name = "arirencho_shimei1", length = 20, order = 189)
//    public RString arirencho_shimei1;
//    @ReportItem(name = "arirencho_meishoFuyo1", length = 3, order = 190)
//    public RString arirencho_meishoFuyo1;
//    @ReportItem(name = "arirencho_samabunShimeiText", order = 191)
//    public RString arirencho_samabunShimeiText;
//    @ReportItem(name = "arirencho_samaBun2", length = 3, order = 192)
//    public RString arirencho_samaBun2;
//    @ReportItem(name = "arirencho_samabunShimeiSmall2", length = 40, order = 193)
//    public RString arirencho_samabunShimeiSmall2;
//    @ReportItem(name = "arirencho_kakkoRight2", length = 1, order = 194)
//    public RString arirencho_kakkoRight2;
//    @ReportItem(name = "arirencho_kakkoLeft2", length = 1, order = 195)
//    public RString arirencho_kakkoLeft2;
//    @ReportItem(name = "arirencho_samabunShimei2", length = 20, order = 196)
//    public RString arirencho_samabunShimei2;
//    @ReportItem(name = "arirencho_kakkoRight1", length = 1, order = 197)
//    public RString arirencho_kakkoRight1;
//    @ReportItem(name = "arirencho_kakkoLeft1", length = 1, order = 198)
//    public RString arirencho_kakkoLeft1;
//    @ReportItem(name = "arirencho_samabunShimei1", length = 20, order = 199)
//    public RString arirencho_samabunShimei1;
//    @ReportItem(name = "arirencho_samaBun1", length = 3, order = 200)
//    public RString arirencho_samaBun1;
//    @ReportItem(name = "arirencho_samabunShimeiSmall1", length = 40, order = 201)
//    public RString arirencho_samabunShimeiSmall1;
//    @ReportItem(name = "arirencho_customerBarCode", order = 202)
//    public RString arirencho_customerBarCode;
//    @ReportItem(name = "arirencho_denshiKoin", order = 203)
//    public RString arirencho_denshiKoin;
//    @ReportItem(name = "arirencho_hakkoYMD", length = 12, order = 204)
//    public RString arirencho_hakkoYMD;
//    @ReportItem(name = "arirencho_ninshoshaYakushokuMei", length = 15, order = 205)
//    public RString arirencho_ninshoshaYakushokuMei;
//    @ReportItem(name = "arirencho_ninshoshaYakushokuMei1", order = 206)
//    public RString arirencho_ninshoshaYakushokuMei1;
//    @ReportItem(name = "arirencho_koinMojiretsu", length = 4, order = 207)
//    public RString arirencho_koinMojiretsu;
//    @ReportItem(name = "arirencho_ninshoshaYakushokuMei2", order = 208)
//    public RString arirencho_ninshoshaYakushokuMei2;
//    @ReportItem(name = "arirencho_ninshoshaShimeiKakenai", order = 209)
//    public RString arirencho_ninshoshaShimeiKakenai;
//    @ReportItem(name = "arirencho_ninshoshaShimeiKakeru", order = 210)
//    public RString arirencho_ninshoshaShimeiKakeru;
//    @ReportItem(name = "arirencho_koinShoryaku", length = 15, order = 211)
//    public RString arirencho_koinShoryaku;
    // <DBB100056_HokenryoNonyuTsuchishoBookFuriKaeNashiCover.rse>
//    @ReportItem(name = "nashi_listList1_1", length = 1, order = 1)
//    public RString nashi_listList1_1;
//    @ReportItem(name = "nashi_keisanMeisaishoNendo", length = 4, order = 2)
//    public RString nashi_keisanMeisaishoNendo;
//    @ReportItem(name = "nashi_keisanMeisaishoNendoBun", length = 9, order = 3)
//    public RString nashi_keisanMeisaishoNendoBun;
//    @ReportItem(name = "nashi_titleNendo", length = 4, order = 4)
//    public RString nashi_titleNendo;
//    @ReportItem(name = "nashi_titleNendoBun", length = 9, order = 5)
//    public RString nashi_titleNendoBun;
//    @ReportItem(name = "nashi_HyojicodeName1", order = 6)
//    public RString nashi_HyojicodeName1;
//    @ReportItem(name = "nashi_HyojicodeName2", order = 7)
//    public RString nashi_HyojicodeName2;
//    @ReportItem(name = "nashi_HyojicodeName3", order = 8)
//    public RString nashi_HyojicodeName3;
//    @ReportItem(name = "nashi_Hyojicode1", length = 11, order = 9)
//    public RString nashi_Hyojicode1;
//    @ReportItem(name = "nashi_Hyojicode2", length = 9, order = 10)
//    public RString nashi_Hyojicode2;
//    @ReportItem(name = "nashi_Hyojicode3", length = 9, order = 11)
//    public RString nashi_Hyojicode3;
//    @ReportItem(name = "nashi_keisanMeisaishoKi1", length = 2, order = 12)
//    public RString nashi_keisanMeisaishoKi1;
//    @ReportItem(name = "nashi_keisanMeisaishoNokigenKaishi1", length = 11, order = 13)
//    public RString nashi_keisanMeisaishoNokigenKaishi1;
//    @ReportItem(name = "nashi_kaisanMeisaishoHihokenshaName", order = 14)
//    public RString nashi_kaisanMeisaishoHihokenshaName;
//    @ReportItem(name = "nashi_kaisanMeisaishoSetaiNushiName", order = 15)
//    public RString nashi_kaisanMeisaishoSetaiNushiName;
//    @ReportItem(name = "nashi_keisanMeisaishoTsuchishoNo", order = 16)
//    public RString nashi_keisanMeisaishoTsuchishoNo;
//    @ReportItem(name = "nashi_keisanMeisaishoSetaiCode", length = 15, order = 17)
//    public RString nashi_keisanMeisaishoSetaiCode;
//    @ReportItem(name = "nashi_keisanMeisaishoTsuki1", length = 2, order = 18)
//    public RString nashi_keisanMeisaishoTsuki1;
//    @ReportItem(name = "nashi_keisanMeisaishoNokigenShuryo1", length = 11, order = 19)
//    public RString nashi_keisanMeisaishoNokigenShuryo1;
//    @ReportItem(name = "nashi_keisanMeisaishoKi2", length = 2, order = 20)
//    public RString nashi_keisanMeisaishoKi2;
//    @ReportItem(name = "nashi_keisanMeisaishoNokigenKaishi2", length = 11, order = 21)
//    public RString nashi_keisanMeisaishoNokigenKaishi2;
//    @ReportItem(name = "nashi_keisanMeisaishoTsuki2", length = 2, order = 22)
//    public RString nashi_keisanMeisaishoTsuki2;
//    @ReportItem(name = "nashi_keisanMeisaishoNokigenShuryo2", length = 11, order = 23)
//    public RString nashi_keisanMeisaishoNokigenShuryo2;
//    @ReportItem(name = "nashi_tsuchishoNo", order = 24)
//    public RString nashi_tsuchishoNo;
//    @ReportItem(name = "nashi_setaiCode", length = 15, order = 25)
//    public RString nashi_setaiCode;
//    @ReportItem(name = "nashi_keisanMeisaishoKi3", length = 2, order = 26)
//    public RString nashi_keisanMeisaishoKi3;
//    @ReportItem(name = "nashi_keisanMeisaishoNokigenKaishi3", length = 11, order = 27)
//    public RString nashi_keisanMeisaishoNokigenKaishi3;
//    @ReportItem(name = "nashi_keisanMeisaishoKaishiKi", length = 16, order = 28)
//    public RString nashi_keisanMeisaishoKaishiKi;
//    @ReportItem(name = "nashi_keisanMeisaishoTsuki3", length = 2, order = 29)
//    public RString nashi_keisanMeisaishoTsuki3;
//    @ReportItem(name = "nashi_keisanMeisaishoNokigenShuryo3", length = 11, order = 30)
//    public RString nashi_keisanMeisaishoNokigenShuryo3;
//    @ReportItem(name = "nashi_keisanMeisaishoTsukiSu", length = 12, order = 31)
//    public RString nashi_keisanMeisaishoTsukiSu;
//    @ReportItem(name = "nashi_kaisanMeisaishoShuryoKi", length = 16, order = 32)
//    public RString nashi_kaisanMeisaishoShuryoKi;
//    @ReportItem(name = "nashi_keisanMeisaishoKi4", length = 2, order = 33)
//    public RString nashi_keisanMeisaishoKi4;
//    @ReportItem(name = "nashi_keisanMeisaishoNokigenKaishi4", length = 11, order = 34)
//    public RString nashi_keisanMeisaishoNokigenKaishi4;
//    @ReportItem(name = "nashi_keisanMeisaishoTsuki4", length = 2, order = 35)
//    public RString nashi_keisanMeisaishoTsuki4;
//    @ReportItem(name = "nashi_keisanMeisaishoNokigenShuryo4", length = 11, order = 36)
//    public RString nashi_keisanMeisaishoNokigenShuryo4;
//    @ReportItem(name = "nashi_keisanMeisaishoShotokuDankai", length = 8, order = 37)
//    public RString nashi_keisanMeisaishoShotokuDankai;
//    @ReportItem(name = "nashi_kaisanHokenryoRitsu", length = 10, order = 38)
//    public RString nashi_kaisanHokenryoRitsu;
//    @ReportItem(name = "nashi_bankCode", length = 7, order = 39)
//    public RString nashi_bankCode;
//    @ReportItem(name = "nashi_kozaShurui", length = 3, order = 40)
//    public RString nashi_kozaShurui;
//    @ReportItem(name = "nashi_kozaNo", length = 14, order = 41)
//    public RString nashi_kozaNo;
//    @ReportItem(name = "nashi_keisanMeisaishoKi5", length = 2, order = 42)
//    public RString nashi_keisanMeisaishoKi5;
//    @ReportItem(name = "nashi_keisanMeisaishoNokigenKaishi5", length = 11, order = 43)
//    public RString nashi_keisanMeisaishoNokigenKaishi5;
//    @ReportItem(name = "nashi_keisanMeisaishoTsuki5", length = 2, order = 44)
//    public RString nashi_keisanMeisaishoTsuki5;
//    @ReportItem(name = "nashi_keisanMeisaishoNokigenShuryo5", length = 11, order = 45)
//    public RString nashi_keisanMeisaishoNokigenShuryo5;
//    @ReportItem(name = "nashi_keisanMeisaishoCalHokenryoGaku", length = 10, order = 46)
//    public RString nashi_keisanMeisaishoCalHokenryoGaku;
//    @ReportItem(name = "nashi_keisanMeisaishoGenmenGaku", length = 10, order = 47)
//    public RString nashi_keisanMeisaishoGenmenGaku;
//    @ReportItem(name = "nashi_keisanMeisaishoKi6", length = 2, order = 48)
//    public RString nashi_keisanMeisaishoKi6;
//    @ReportItem(name = "nashi_keisanMeisaishoNokigenKaishi6", length = 11, order = 49)
//    public RString nashi_keisanMeisaishoNokigenKaishi6;
//    @ReportItem(name = "nashi_bankName", length = 20, order = 50)
//    public RString nashi_bankName;
//    @ReportItem(name = "nashi_keisanMeisaishoTsuki6", length = 2, order = 51)
//    public RString nashi_keisanMeisaishoTsuki6;
//    @ReportItem(name = "nashi_keisanMeisaishoNokigenShuryo6", length = 11, order = 52)
//    public RString nashi_keisanMeisaishoNokigenShuryo6;
//    @ReportItem(name = "nashi_keisanMeisaishoTokuchoGokeiGaku", length = 10, order = 53)
//    public RString nashi_keisanMeisaishoTokuchoGokeiGaku;
//    @ReportItem(name = "nashi_kaisanMeisaishoFuchoGokeiGaku", length = 10, order = 54)
//    public RString nashi_kaisanMeisaishoFuchoGokeiGaku;
//    @ReportItem(name = "nashi_keisanMeisaishoKi7", length = 2, order = 55)
//    public RString nashi_keisanMeisaishoKi7;
//    @ReportItem(name = "nashi_keisanMeisaishoNokigenKaishi7", length = 11, order = 56)
//    public RString nashi_keisanMeisaishoNokigenKaishi7;
//    @ReportItem(name = "nashi_keisanMeisaishoTsuki7", length = 2, order = 57)
//    public RString nashi_keisanMeisaishoTsuki7;
//    @ReportItem(name = "nashi_keisanMeisaishoNokigenShuryo7", length = 11, order = 58)
//    public RString nashi_keisanMeisaishoNokigenShuryo7;
//    @ReportItem(name = "nashi_kaisanMeisaishoNofuZumiGaku", length = 10, order = 59)
//    public RString nashi_kaisanMeisaishoNofuZumiGaku;
//    @ReportItem(name = "nashi_keisanMeisaishoKongoNofuGaku", length = 10, order = 60)
//    public RString nashi_keisanMeisaishoKongoNofuGaku;
//    @ReportItem(name = "nashi_kozaMeiginin", length = 20, order = 61)
//    public RString nashi_kozaMeiginin;
//    @ReportItem(name = "nashi_keisanMeisaishoKi8", length = 2, order = 62)
//    public RString nashi_keisanMeisaishoKi8;
//    @ReportItem(name = "nashi_keisanMeisaishoNokigenKaishi8", length = 11, order = 63)
//    public RString nashi_keisanMeisaishoNokigenKaishi8;
//    @ReportItem(name = "nashi_yen1", length = 1, order = 64)
//    public RString nashi_yen1;
//    @ReportItem(name = "nashi_yen2", length = 1, order = 65)
//    public RString nashi_yen2;
//    @ReportItem(name = "nashi_keisanMeisaishoTsuki8", length = 2, order = 66)
//    public RString nashi_keisanMeisaishoTsuki8;
//    @ReportItem(name = "nashi_keisanMeisaishoNokigenShuryo8", length = 11, order = 67)
//    public RString nashi_keisanMeisaishoNokigenShuryo8;
//    @ReportItem(name = "nashi_keisanMeisaishoKiTitle1", length = 5, order = 68)
//    public RString nashi_keisanMeisaishoKiTitle1;
//    @ReportItem(name = "nashi_keisanMeisaishoKibetsuNofuGaku1", length = 10, order = 69)
//    public RString nashi_keisanMeisaishoKibetsuNofuGaku1;
//    @ReportItem(name = "nashi_keisanMeisaishoKiTitle3", length = 5, order = 70)
//    public RString nashi_keisanMeisaishoKiTitle3;
//    @ReportItem(name = "nashi_keisanMeisaishoKibetsuNofuGaku3", length = 10, order = 71)
//    public RString nashi_keisanMeisaishoKibetsuNofuGaku3;
//    @ReportItem(name = "nashi_keisanMeisaishoKi9", length = 2, order = 72)
//    public RString nashi_keisanMeisaishoKi9;
//    @ReportItem(name = "nashi_keisanMeisaishoNokigenKaishi9", length = 11, order = 73)
//    public RString nashi_keisanMeisaishoNokigenKaishi9;
//    @ReportItem(name = "nashi_yen3", length = 1, order = 74)
//    public RString nashi_yen3;
//    @ReportItem(name = "nashi_yen4", length = 1, order = 75)
//    public RString nashi_yen4;
//    @ReportItem(name = "nashi_keisanMeisaishoTsuki9", length = 2, order = 76)
//    public RString nashi_keisanMeisaishoTsuki9;
//    @ReportItem(name = "nashi_keisanMeisaishoNokigenShuryo9", length = 11, order = 77)
//    public RString nashi_keisanMeisaishoNokigenShuryo9;
//    @ReportItem(name = "nashi_keisanMeisaishoKiTitle2", length = 5, order = 78)
//    public RString nashi_keisanMeisaishoKiTitle2;
//    @ReportItem(name = "nashi_gekihenTitle", length = 20, order = 79)
//    public RString nashi_gekihenTitle;
//    @ReportItem(name = "nashi_keisanMeisaishoKibetsuNofuGaku2", length = 10, order = 80)
//    public RString nashi_keisanMeisaishoKibetsuNofuGaku2;
//    @ReportItem(name = "nashi_keisanMeisaishoKiTitle4", length = 5, order = 81)
//    public RString nashi_keisanMeisaishoKiTitle4;
//    @ReportItem(name = "nashi_gekihenMongon", length = 20, order = 82)
//    public RString nashi_gekihenMongon;
//    @ReportItem(name = "nashi_keisanMeisaishoKibetsuNofuGaku4", length = 10, order = 83)
//    public RString nashi_keisanMeisaishoKibetsuNofuGaku4;
//    @ReportItem(name = "nashi_keisanMeisaishoKi10", length = 2, order = 84)
//    public RString nashi_keisanMeisaishoKi10;
//    @ReportItem(name = "nashi_keisanMeisaishoNokigenKaishi10", length = 11, order = 85)
//    public RString nashi_keisanMeisaishoNokigenKaishi10;
//    @ReportItem(name = "nashi_keisanmeisaishoNendo2", length = 4, order = 86)
//    public RString nashi_keisanmeisaishoNendo2;
//    @ReportItem(name = "nashi_keisanMeisaishoTsuki10", length = 2, order = 87)
//    public RString nashi_keisanMeisaishoTsuki10;
//    @ReportItem(name = "nashi_keisanMeisaishoNokigenShuryo10", length = 11, order = 88)
//    public RString nashi_keisanMeisaishoNokigenShuryo10;
//    @ReportItem(name = "nashi_keisanMeisaishoHokenryoGokeiGaku", length = 15, order = 89)
//    public RString nashi_keisanMeisaishoHokenryoGokeiGaku;
//    @ReportItem(name = "nashi_pagerenban1", length = 10, order = 90)
//    public RString nashi_pagerenban1;
//    @ReportItem(name = "nashi_pagerenban2", length = 10, order = 91)
//    public RString nashi_pagerenban2;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoNendo", length = 4, order = 92)
//    public RString nashi_nokibetsuMeisaishoNendo;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoNendoNendoBun", length = 9, order = 93)
//    public RString nashi_nokibetsuMeisaishoNendoNendoBun;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoTokuchoNofuGaku1", length = 10, order = 94)
//    public RString nashi_nokibetsuMeisaishoTokuchoNofuGaku1;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoTokuchoNofuZumiGaku1", length = 10, order = 95)
//    public RString nashi_nokibetsuMeisaishoTokuchoNofuZumiGaku1;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoTsuchishoNo", order = 96)
//    public RString nashi_nokibetsuMeisaishoTsuchishoNo;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoSetaiCode", length = 15, order = 97)
//    public RString nashi_nokibetsuMeisaishoSetaiCode;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoTokuchoSaGaku1", length = 10, order = 98)
//    public RString nashi_nokibetsuMeisaishoTokuchoSaGaku1;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoTokuchoNofuGaku2", length = 10, order = 99)
//    public RString nashi_nokibetsuMeisaishoTokuchoNofuGaku2;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoTokuchoNofuZumiGaku2", length = 10, order = 100)
//    public RString nashi_nokibetsuMeisaishoTokuchoNofuZumiGaku2;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoTokuchoSaGaku2", length = 10, order = 101)
//    public RString nashi_nokibetsuMeisaishoTokuchoSaGaku2;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoHohokenshaName", order = 102)
//    public RString nashi_nokibetsuMeisaishoHohokenshaName;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoTokuchoNofuGaku3", length = 10, order = 103)
//    public RString nashi_nokibetsuMeisaishoTokuchoNofuGaku3;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoTokuchoNofuZumiGaku3", length = 10, order = 104)
//    public RString nashi_nokibetsuMeisaishoTokuchoNofuZumiGaku3;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoTokuchoSaGaku3", length = 10, order = 105)
//    public RString nashi_nokibetsuMeisaishoTokuchoSaGaku3;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoTokuchoNofuGaku4", length = 10, order = 106)
//    public RString nashi_nokibetsuMeisaishoTokuchoNofuGaku4;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoTokuchoNofuZumiGaku4", length = 10, order = 107)
//    public RString nashi_nokibetsuMeisaishoTokuchoNofuZumiGaku4;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoTokuchoSaGaku4", length = 10, order = 108)
//    public RString nashi_nokibetsuMeisaishoTokuchoSaGaku4;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoKi1", length = 4, order = 109)
//    public RString nashi_nokibetsuMeisaishoKi1;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoFuchoNofuGaku1", length = 10, order = 110)
//    public RString nashi_nokibetsuMeisaishoFuchoNofuGaku1;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoFuchoNofuZumiGaku1", length = 10, order = 111)
//    public RString nashi_nokibetsuMeisaishoFuchoNofuZumiGaku1;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoFuchoSaGaku1", length = 10, order = 112)
//    public RString nashi_nokibetsuMeisaishoFuchoSaGaku1;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoNokigen1", length = 11, order = 113)
//    public RString nashi_nokibetsuMeisaishoNokigen1;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoKi2", length = 4, order = 114)
//    public RString nashi_nokibetsuMeisaishoKi2;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoFuchoNofuGaku2", length = 10, order = 115)
//    public RString nashi_nokibetsuMeisaishoFuchoNofuGaku2;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoFuchoNofuZumiGaku2", length = 10, order = 116)
//    public RString nashi_nokibetsuMeisaishoFuchoNofuZumiGaku2;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoFuchoSaGaku2", length = 10, order = 117)
//    public RString nashi_nokibetsuMeisaishoFuchoSaGaku2;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoNokigen2", length = 11, order = 118)
//    public RString nashi_nokibetsuMeisaishoNokigen2;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoKi3", length = 4, order = 119)
//    public RString nashi_nokibetsuMeisaishoKi3;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoFuchoNofuGaku3", length = 10, order = 120)
//    public RString nashi_nokibetsuMeisaishoFuchoNofuGaku3;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoFuchoNofuZumiGaku3", length = 10, order = 121)
//    public RString nashi_nokibetsuMeisaishoFuchoNofuZumiGaku3;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoFuchoSaGaku3", length = 10, order = 122)
//    public RString nashi_nokibetsuMeisaishoFuchoSaGaku3;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoNokigen3", length = 11, order = 123)
//    public RString nashi_nokibetsuMeisaishoNokigen3;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoKi4", length = 4, order = 124)
//    public RString nashi_nokibetsuMeisaishoKi4;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoFuchoNofuGaku4", length = 10, order = 125)
//    public RString nashi_nokibetsuMeisaishoFuchoNofuGaku4;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoFuchoNofuZumiGaku4", length = 10, order = 126)
//    public RString nashi_nokibetsuMeisaishoFuchoNofuZumiGaku4;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoFuchoSaGaku4", length = 10, order = 127)
//    public RString nashi_nokibetsuMeisaishoFuchoSaGaku4;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoNokigen4", length = 11, order = 128)
//    public RString nashi_nokibetsuMeisaishoNokigen4;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoKi5", length = 4, order = 129)
//    public RString nashi_nokibetsuMeisaishoKi5;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoFuchoNofuGaku5", length = 10, order = 130)
//    public RString nashi_nokibetsuMeisaishoFuchoNofuGaku5;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoFuchoNofuZumiGaku5", length = 10, order = 131)
//    public RString nashi_nokibetsuMeisaishoFuchoNofuZumiGaku5;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoFuchoSaGaku5", length = 10, order = 132)
//    public RString nashi_nokibetsuMeisaishoFuchoSaGaku5;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoNokigen5", length = 11, order = 133)
//    public RString nashi_nokibetsuMeisaishoNokigen5;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoKi6", length = 4, order = 134)
//    public RString nashi_nokibetsuMeisaishoKi6;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoFuchoNofuGaku6", length = 10, order = 135)
//    public RString nashi_nokibetsuMeisaishoFuchoNofuGaku6;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoFuchoNofuZumiGaku6", length = 10, order = 136)
//    public RString nashi_nokibetsuMeisaishoFuchoNofuZumiGaku6;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoFuchoSaGaku6", length = 10, order = 137)
//    public RString nashi_nokibetsuMeisaishoFuchoSaGaku6;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoNokigen6", length = 11, order = 138)
//    public RString nashi_nokibetsuMeisaishoNokigen6;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoKi7", length = 4, order = 139)
//    public RString nashi_nokibetsuMeisaishoKi7;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoFuchoNofuGaku7", length = 10, order = 140)
//    public RString nashi_nokibetsuMeisaishoFuchoNofuGaku7;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoFuchoNofuZumiGaku7", length = 10, order = 141)
//    public RString nashi_nokibetsuMeisaishoFuchoNofuZumiGaku7;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoFuchoSaGaku7", length = 10, order = 142)
//    public RString nashi_nokibetsuMeisaishoFuchoSaGaku7;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoNokigen7", length = 11, order = 143)
//    public RString nashi_nokibetsuMeisaishoNokigen7;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoKi8", length = 4, order = 144)
//    public RString nashi_nokibetsuMeisaishoKi8;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoFuchoNofuGaku8", length = 10, order = 145)
//    public RString nashi_nokibetsuMeisaishoFuchoNofuGaku8;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoFuchoNofuZumiGaku8", length = 10, order = 146)
//    public RString nashi_nokibetsuMeisaishoFuchoNofuZumiGaku8;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoFuchoSaGaku8", length = 10, order = 147)
//    public RString nashi_nokibetsuMeisaishoFuchoSaGaku8;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoNokigen8", length = 11, order = 148)
//    public RString nashi_nokibetsuMeisaishoNokigen8;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoKi9", length = 4, order = 149)
//    public RString nashi_nokibetsuMeisaishoKi9;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoFuchoNofuGaku9", length = 10, order = 150)
//    public RString nashi_nokibetsuMeisaishoFuchoNofuGaku9;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoFuchoNofuZumiGaku9", length = 10, order = 151)
//    public RString nashi_nokibetsuMeisaishoFuchoNofuZumiGaku9;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoFuchoSaGaku9", length = 10, order = 152)
//    public RString nashi_nokibetsuMeisaishoFuchoSaGaku9;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoNokigen9", length = 11, order = 153)
//    public RString nashi_nokibetsuMeisaishoNokigen9;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoKi10", length = 4, order = 154)
//    public RString nashi_nokibetsuMeisaishoKi10;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoFuchoNofuGaku10", length = 10, order = 155)
//    public RString nashi_nokibetsuMeisaishoFuchoNofuGaku10;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoFuchoNofuZumiGaku10", length = 10, order = 156)
//    public RString nashi_nokibetsuMeisaishoFuchoNofuZumiGaku10;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoFuchoSaGaku10", length = 10, order = 157)
//    public RString nashi_nokibetsuMeisaishoFuchoSaGaku10;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoNokigen10", length = 11, order = 158)
//    public RString nashi_nokibetsuMeisaishoNokigen10;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoFuchoNofuGaku11", length = 10, order = 159)
//    public RString nashi_nokibetsuMeisaishoFuchoNofuGaku11;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoFuchoNofuZumiGaku11", length = 10, order = 160)
//    public RString nashi_nokibetsuMeisaishoFuchoNofuZumiGaku11;
//    @ReportItem(name = "nashi_nokibetsuMeisaishoFuchoSaGaku11", length = 10, order = 161)
//    public RString nashi_nokibetsuMeisaishoFuchoSaGaku11;
//    @ReportItem(name = "nashi_renban", length = 10, order = 162)
//    public RString nashi_renban;
//    @ReportItem(name = "nashi_hokenshaName", length = 10, order = 163)
//    public RString nashi_hokenshaName;
//    @ReportItem(name = "nashi_pagerenban3", length = 10, order = 164)
//    public RString nashi_pagerenban3;
//    @ReportItem(name = "nashi_yubinNo", length = 8, order = 165)
//    public RString nashi_yubinNo;
//    @ReportItem(name = "nashi_gyoseiku", length = 14, order = 166)
//    public RString nashi_gyoseiku;
//    @ReportItem(name = "nashi_jushoText", order = 167)
//    public RString nashi_jushoText;
//    @ReportItem(name = "nashi_jusho3", length = 20, order = 168)
//    public RString nashi_jusho3;
//    @ReportItem(name = "nashi_jusho1", length = 20, order = 169)
//    public RString nashi_jusho1;
//    @ReportItem(name = "nashi_jusho2", length = 20, order = 170)
//    public RString nashi_jusho2;
//    @ReportItem(name = "nashi_katagakiText", order = 171)
//    public RString nashi_katagakiText;
//    @ReportItem(name = "nashi_katagaki2", length = 20, order = 172)
//    public RString nashi_katagaki2;
//    @ReportItem(name = "nashi_katagakiSmall2", length = 30, order = 173)
//    public RString nashi_katagakiSmall2;
//    @ReportItem(name = "nashi_katagaki1", length = 20, order = 174)
//    public RString nashi_katagaki1;
//    @ReportItem(name = "nashi_katagakiSmall1", length = 30, order = 175)
//    public RString nashi_katagakiSmall1;
//    @ReportItem(name = "nashi_shimei2", length = 20, order = 176)
//    public RString nashi_shimei2;
//    @ReportItem(name = "nashi_shimeiSmall2", length = 40, order = 177)
//    public RString nashi_shimeiSmall2;
//    @ReportItem(name = "nashi_shimeiText", order = 178)
//    public RString nashi_shimeiText;
//    @ReportItem(name = "nashi_meishoFuyo2", length = 3, order = 179)
//    public RString nashi_meishoFuyo2;
//    @ReportItem(name = "nashi_shimeiSmall1", length = 40, order = 180)
//    public RString nashi_shimeiSmall1;
//    @ReportItem(name = "nashi_dainoKubunMei", length = 8, order = 181)
//    public RString nashi_dainoKubunMei;
//    @ReportItem(name = "nashi_shimei1", length = 20, order = 182)
//    public RString nashi_shimei1;
//    @ReportItem(name = "nashi_meishoFuyo1", length = 3, order = 183)
//    public RString nashi_meishoFuyo1;
//    @ReportItem(name = "nashi_samabunShimeiText", order = 184)
//    public RString nashi_samabunShimeiText;
//    @ReportItem(name = "nashi_samaBun2", length = 3, order = 185)
//    public RString nashi_samaBun2;
//    @ReportItem(name = "nashi_samabunShimeiSmall2", length = 40, order = 186)
//    public RString nashi_samabunShimeiSmall2;
//    @ReportItem(name = "nashi_kakkoLeft2", length = 1, order = 187)
//    public RString nashi_kakkoLeft2;
//    @ReportItem(name = "nashi_samabunShimei2", length = 20, order = 188)
//    public RString nashi_samabunShimei2;
//    @ReportItem(name = "nashi_kakkoRight2", length = 1, order = 189)
//    public RString nashi_kakkoRight2;
//    @ReportItem(name = "nashi_kakkoLeft1", length = 1, order = 190)
//    public RString nashi_kakkoLeft1;
//    @ReportItem(name = "nashi_samabunShimei1", length = 20, order = 191)
//    public RString nashi_samabunShimei1;
//    @ReportItem(name = "nashi_samaBun1", length = 3, order = 192)
//    public RString nashi_samaBun1;
//    @ReportItem(name = "nashi_kakkoRight1", length = 1, order = 193)
//    public RString nashi_kakkoRight1;
//    @ReportItem(name = "nashi_samabunShimeiSmall1", length = 40, order = 194)
//    public RString nashi_samabunShimeiSmall1;
//    @ReportItem(name = "nashi_customerBarCode", order = 195)
//    public RString nashi_customerBarCode;
//    @ReportItem(name = "nashi_denshiKoin", order = 196)
//    public RString nashi_denshiKoin;
//    @ReportItem(name = "nashi_hakkoYMD", length = 12, order = 197)
//    public RString nashi_hakkoYMD;
//    @ReportItem(name = "nashi_ninshoshaYakushokuMei", length = 15, order = 198)
//    public RString nashi_ninshoshaYakushokuMei;
//    @ReportItem(name = "nashi_ninshoshaYakushokuMei1", order = 199)
//    public RString nashi_ninshoshaYakushokuMei1;
//    @ReportItem(name = "nashi_koinMojiretsu", length = 4, order = 200)
//    public RString nashi_koinMojiretsu;
//    @ReportItem(name = "nashi_ninshoshaYakushokuMei2", order = 201)
//    public RString nashi_ninshoshaYakushokuMei2;
//    @ReportItem(name = "nashi_ninshoshaShimeiKakenai", order = 202)
//    public RString nashi_ninshoshaShimeiKakenai;
//    @ReportItem(name = "nashi_ninshoshaShimeiKakeru", order = 203)
//    public RString nashi_ninshoshaShimeiKakeru;
//    @ReportItem(name = "nashi_koinShoryaku", length = 15, order = 204)
//    public RString nashi_koinShoryaku;
//    @ReportItem(name = "nashi_nofuzumishoTitleNendoBun1", length = 9, order = 205)
//    public RString nashi_nofuzumishoTitleNendoBun1;
//    @ReportItem(name = "nashi_nofuzumishoTitleKi1", length = 2, order = 206)
//    public RString nashi_nofuzumishoTitleKi1;
//    @ReportItem(name = "nashi_nofuzumishoTitleTsuki1", length = 2, order = 207)
//    public RString nashi_nofuzumishoTitleTsuki1;
//    @ReportItem(name = "nashi_nofozumishoTitleNendo1", length = 6, order = 208)
//    public RString nashi_nofozumishoTitleNendo1;
//    @ReportItem(name = "nashi_ryoshushoTitleNendo1", length = 6, order = 209)
//    public RString nashi_ryoshushoTitleNendo1;
//    @ReportItem(name = "nashi_ryoshushoTitleKi1", length = 2, order = 210)
//    public RString nashi_ryoshushoTitleKi1;
//    @ReportItem(name = "nashi_ryoshushoTitleTsuki1", length = 2, order = 211)
//    public RString nashi_ryoshushoTitleTsuki1;
//    @ReportItem(name = "nashi_nofushoTitleNendo1", length = 6, order = 212)
//    public RString nashi_nofushoTitleNendo1;
//    @ReportItem(name = "nashi_nofushoTitleKi1", length = 2, order = 213)
//    public RString nashi_nofushoTitleKi1;
//    @ReportItem(name = "nashi_nofushoTitleTsuki1", length = 2, order = 214)
//    public RString nashi_nofushoTitleTsuki1;
//    @ReportItem(name = "nashi_ryoshushoJusho1", order = 215)
//    public RString nashi_ryoshushoJusho1;
//    @ReportItem(name = "nashi_nofuzumishoTsuchishoNo1", order = 216)
//    public RString nashi_nofuzumishoTsuchishoNo1;
//    @ReportItem(name = "nashi_nofuzumishoOCR11", length = 19, order = 217)
//    public RString nashi_nofuzumishoOCR11;
//    @ReportItem(name = "nashi_ryoshushoKatagaki1", order = 218)
//    public RString nashi_ryoshushoKatagaki1;
//    @ReportItem(name = "nashi_nofuzumishoSetaiCode1", length = 15, order = 219)
//    public RString nashi_nofuzumishoSetaiCode1;
//    @ReportItem(name = "nashi_nofuzumishoOCR21", length = 20, order = 220)
//    public RString nashi_nofuzumishoOCR21;
//    @ReportItem(name = "nashi_ryoshushoHihokenshaName1", order = 221)
//    public RString nashi_ryoshushoHihokenshaName1;
//    @ReportItem(name = "nashi_nofushoHihokenshaName1", order = 222)
//    public RString nashi_nofushoHihokenshaName1;
//    @ReportItem(name = "nashi_nofuzumishoOCR31", length = 12, order = 223)
//    public RString nashi_nofuzumishoOCR31;
//    @ReportItem(name = "nashi_nofuzumishoNokigen1", length = 11, order = 224)
//    public RString nashi_nofuzumishoNokigen1;
//    @ReportItem(name = "nashi_ryoshushoTsuchishoNo1", order = 225)
//    public RString nashi_ryoshushoTsuchishoNo1;
//    @ReportItem(name = "nashi_nofushoTsuchishoNo1", order = 226)
//    public RString nashi_nofushoTsuchishoNo1;
//    @ReportItem(name = "nashi_ryoshushoHokenryoGaku1", length = 10, order = 227)
//    public RString nashi_ryoshushoHokenryoGaku1;
//    @ReportItem(name = "nashi_nofushoHokenryoGaku1", length = 10, order = 228)
//    public RString nashi_nofushoHokenryoGaku1;
//    @ReportItem(name = "nashi_nofuzumishoNofuGaku1", length = 10, order = 229)
//    public RString nashi_nofuzumishoNofuGaku1;
//    @ReportItem(name = "nashi_ryoshushoNokigen1", length = 11, order = 230)
//    public RString nashi_ryoshushoNokigen1;
//    @ReportItem(name = "nashi_nofushoNokigen1", length = 11, order = 231)
//    public RString nashi_nofushoNokigen1;
//    @ReportItem(name = "nashi_nofuzumishoJusho1", order = 232)
//    public RString nashi_nofuzumishoJusho1;
//    @ReportItem(name = "nashi_nofuzumishoKatagaki1", length = 30, order = 233)
//    public RString nashi_nofuzumishoKatagaki1;
//    @ReportItem(name = "nashi_ryoshushoNofuIn1", length = 2, order = 234)
//    public RString nashi_ryoshushoNofuIn1;
//    @ReportItem(name = "nashi_nofushoNofuIn1", length = 2, order = 235)
//    public RString nashi_nofushoNofuIn1;
//    @ReportItem(name = "nashi_nofuzumishoNofuIn1", length = 2, order = 236)
//    public RString nashi_nofuzumishoNofuIn1;
//    @ReportItem(name = "nashi_ryoshushoKozaCom1", length = 4, order = 237)
//    public RString nashi_ryoshushoKozaCom1;
//    @ReportItem(name = "nashi_nofushoKozaCom1", length = 4, order = 238)
//    public RString nashi_nofushoKozaCom1;
//    @ReportItem(name = "nashi_nofuzumishoHihokenshaName1", order = 239)
//    public RString nashi_nofuzumishoHihokenshaName1;
//    @ReportItem(name = "nashi_nofuzumishoKozaCom1", length = 4, order = 240)
//    public RString nashi_nofuzumishoKozaCom1;
//    @ReportItem(name = "nashi_ryoshushoZuiji1", length = 2, order = 241)
//    public RString nashi_ryoshushoZuiji1;
//    @ReportItem(name = "nashi_nofushoZuiji1", length = 2, order = 242)
//    public RString nashi_nofushoZuiji1;
//    @ReportItem(name = "nashi_nofuzumishoZuiji1", length = 2, order = 243)
//    public RString nashi_nofuzumishoZuiji1;
//    @ReportItem(name = "nashi_nofuzumishoshichosonName1", order = 244)
//    public RString nashi_nofuzumishoshichosonName1;
//    @ReportItem(name = "nashi_pagerenban4", length = 10, order = 245)
//    public RString nashi_pagerenban4;
    // <DBB100058_HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCover.rse>
//    @ReportItem(name = "nashirencho_listList1_1", length = 1, order = 1)
//    public RString nashirencho_listList1_1;
//    @ReportItem(name = "nashirencho_keisanMeisaishoNendo", length = 4, order = 2)
//    public RString nashirencho_keisanMeisaishoNendo;
//    @ReportItem(name = "nashirencho_keisanMeisaishoNendoBun", length = 9, order = 3)
//    public RString nashirencho_keisanMeisaishoNendoBun;
//    @ReportItem(name = "nashirencho_titleNendo", length = 4, order = 4)
//    public RString nashirencho_titleNendo;
//    @ReportItem(name = "nashirencho_titleNendoBun", length = 9, order = 5)
//    public RString nashirencho_titleNendoBun;
//    @ReportItem(name = "nashirencho_HyojicodeName1", order = 6)
//    public RString nashirencho_HyojicodeName1;
//    @ReportItem(name = "nashirencho_HyojicodeName2", order = 7)
//    public RString nashirencho_HyojicodeName2;
//    @ReportItem(name = "nashirencho_HyojicodeName3", order = 8)
//    public RString nashirencho_HyojicodeName3;
//    @ReportItem(name = "nashirencho_keisanMeisaishoNokigenKaishi1", length = 11, order = 9)
//    public RString nashirencho_keisanMeisaishoNokigenKaishi1;
//    @ReportItem(name = "nashirencho_Hyojicode1", length = 11, order = 10)
//    public RString nashirencho_Hyojicode1;
//    @ReportItem(name = "nashirencho_Hyojicode2", length = 9, order = 11)
//    public RString nashirencho_Hyojicode2;
//    @ReportItem(name = "nashirencho_Hyojicode3", length = 9, order = 12)
//    public RString nashirencho_Hyojicode3;
//    @ReportItem(name = "nashirencho_keisanMeisaishoKi1", length = 2, order = 13)
//    public RString nashirencho_keisanMeisaishoKi1;
//    @ReportItem(name = "nashirencho_kaisanMeisaishoHihokenshaName", order = 14)
//    public RString nashirencho_kaisanMeisaishoHihokenshaName;
//    @ReportItem(name = "nashirencho_kaisanMeisaishoSetaiNushiName", order = 15)
//    public RString nashirencho_kaisanMeisaishoSetaiNushiName;
//    @ReportItem(name = "nashirencho_keisanMeisaishoTsuchishoNo", order = 16)
//    public RString nashirencho_keisanMeisaishoTsuchishoNo;
//    @ReportItem(name = "nashirencho_keisanMeisaishoSetaiCode", length = 15, order = 17)
//    public RString nashirencho_keisanMeisaishoSetaiCode;
//    @ReportItem(name = "nashirencho_keisanMeisaishoTsuki1", length = 2, order = 18)
//    public RString nashirencho_keisanMeisaishoTsuki1;
//    @ReportItem(name = "nashirencho_keisanMeisaishoNokigenShuryo1", length = 11, order = 19)
//    public RString nashirencho_keisanMeisaishoNokigenShuryo1;
//    @ReportItem(name = "nashirencho_keisanMeisaishoNokigenKaishi2", length = 11, order = 20)
//    public RString nashirencho_keisanMeisaishoNokigenKaishi2;
//    @ReportItem(name = "nashirencho_keisanMeisaishoKi2", length = 2, order = 21)
//    public RString nashirencho_keisanMeisaishoKi2;
//    @ReportItem(name = "nashirencho_keisanMeisaishoTsuki2", length = 2, order = 22)
//    public RString nashirencho_keisanMeisaishoTsuki2;
//    @ReportItem(name = "nashirencho_keisanMeisaishoNokigenShuryo2", length = 11, order = 23)
//    public RString nashirencho_keisanMeisaishoNokigenShuryo2;
//    @ReportItem(name = "nashirencho_keisanMeisaishoKi3", length = 2, order = 24)
//    public RString nashirencho_keisanMeisaishoKi3;
//    @ReportItem(name = "nashirencho_keisanMeisaishoNokigenKaishi3", length = 11, order = 25)
//    public RString nashirencho_keisanMeisaishoNokigenKaishi3;
//    @ReportItem(name = "nashirencho_tsuchishoNo", order = 26)
//    public RString nashirencho_tsuchishoNo;
//    @ReportItem(name = "nashirencho_setaiCode", length = 15, order = 27)
//    public RString nashirencho_setaiCode;
//    @ReportItem(name = "nashirencho_keisanMeisaishoKaishiKi", length = 16, order = 28)
//    public RString nashirencho_keisanMeisaishoKaishiKi;
//    @ReportItem(name = "nashirencho_keisanMeisaishoTsuki3", length = 2, order = 29)
//    public RString nashirencho_keisanMeisaishoTsuki3;
//    @ReportItem(name = "nashirencho_keisanMeisaishoNokigenShuryo3", length = 11, order = 30)
//    public RString nashirencho_keisanMeisaishoNokigenShuryo3;
//    @ReportItem(name = "nashirencho_keisanMeisaishoTsukiSu", length = 12, order = 31)
//    public RString nashirencho_keisanMeisaishoTsukiSu;
//    @ReportItem(name = "nashirencho_kaisanMeisaishoShuryoKi", length = 16, order = 32)
//    public RString nashirencho_kaisanMeisaishoShuryoKi;
//    @ReportItem(name = "nashirencho_keisanMeisaishoKi4", length = 2, order = 33)
//    public RString nashirencho_keisanMeisaishoKi4;
//    @ReportItem(name = "nashirencho_keisanMeisaishoNokigenKaishi4", length = 11, order = 34)
//    public RString nashirencho_keisanMeisaishoNokigenKaishi4;
//    @ReportItem(name = "nashirencho_bankCode", length = 7, order = 35)
//    public RString nashirencho_bankCode;
//    @ReportItem(name = "nashirencho_kozaShurui", length = 3, order = 36)
//    public RString nashirencho_kozaShurui;
//    @ReportItem(name = "nashirencho_kozaNo", length = 14, order = 37)
//    public RString nashirencho_kozaNo;
//    @ReportItem(name = "nashirencho_keisanMeisaishoShotokuDankai", length = 8, order = 38)
//    public RString nashirencho_keisanMeisaishoShotokuDankai;
//    @ReportItem(name = "nashirencho_keisanMeisaishoTsuki4", length = 2, order = 39)
//    public RString nashirencho_keisanMeisaishoTsuki4;
//    @ReportItem(name = "nashirencho_keisanMeisaishoNokigenShuryo4", length = 11, order = 40)
//    public RString nashirencho_keisanMeisaishoNokigenShuryo4;
//    @ReportItem(name = "nashirencho_kaisanMeisaiHokenryoRitsu", length = 10, order = 41)
//    public RString nashirencho_kaisanMeisaiHokenryoRitsu;
//    @ReportItem(name = "nashirencho_keisanMeisaishoKi5", length = 2, order = 42)
//    public RString nashirencho_keisanMeisaishoKi5;
//    @ReportItem(name = "nashirencho_keisanMeisaishoNokigenKaishi5", length = 11, order = 43)
//    public RString nashirencho_keisanMeisaishoNokigenKaishi5;
//    @ReportItem(name = "nashirencho_keisanMeisaishoTsuki5", length = 2, order = 44)
//    public RString nashirencho_keisanMeisaishoTsuki5;
//    @ReportItem(name = "nashirencho_keisanMeisaishoNokigenShuryo5", length = 11, order = 45)
//    public RString nashirencho_keisanMeisaishoNokigenShuryo5;
//    @ReportItem(name = "nashirencho_keisanMeisaishoGenmenGaku", length = 10, order = 46)
//    public RString nashirencho_keisanMeisaishoGenmenGaku;
//    @ReportItem(name = "nashirencho_keisanMeisaishoCalHokenryoGaku", length = 10, order = 47)
//    public RString nashirencho_keisanMeisaishoCalHokenryoGaku;
//    @ReportItem(name = "nashirencho_bankName", length = 20, order = 48)
//    public RString nashirencho_bankName;
//    @ReportItem(name = "nashirencho_keisanMeisaishoKi6", length = 2, order = 49)
//    public RString nashirencho_keisanMeisaishoKi6;
//    @ReportItem(name = "nashirencho_keisanMeisaishoNokigenKaishi6", length = 11, order = 50)
//    public RString nashirencho_keisanMeisaishoNokigenKaishi6;
//    @ReportItem(name = "nashirencho_keisanMeisaishoTsuki6", length = 2, order = 51)
//    public RString nashirencho_keisanMeisaishoTsuki6;
//    @ReportItem(name = "nashirencho_keisanMeisaishoNokigenShuryo6", length = 11, order = 52)
//    public RString nashirencho_keisanMeisaishoNokigenShuryo6;
//    @ReportItem(name = "nashirencho_kaisanMeisaishoFuchoGokeiGaku", length = 10, order = 53)
//    public RString nashirencho_kaisanMeisaishoFuchoGokeiGaku;
//    @ReportItem(name = "nashirencho_keisanMeisaishoTokuchoGokeiGaku", length = 10, order = 54)
//    public RString nashirencho_keisanMeisaishoTokuchoGokeiGaku;
//    @ReportItem(name = "nashirencho_keisanMeisaishoKi7", length = 2, order = 55)
//    public RString nashirencho_keisanMeisaishoKi7;
//    @ReportItem(name = "nashirencho_keisanMeisaishoNokigenKaishi7", length = 11, order = 56)
//    public RString nashirencho_keisanMeisaishoNokigenKaishi7;
//    @ReportItem(name = "nashirencho_noutsuRenban", length = 8, order = 57)
//    public RString nashirencho_noutsuRenban;
//    @ReportItem(name = "nashirencho_kozaMeiginin", length = 20, order = 58)
//    public RString nashirencho_kozaMeiginin;
//    @ReportItem(name = "nashirencho_keisanMeisaishoTsuki7", length = 2, order = 59)
//    public RString nashirencho_keisanMeisaishoTsuki7;
//    @ReportItem(name = "nashirencho_keisanMeisaishoNokigenShuryo7", length = 11, order = 60)
//    public RString nashirencho_keisanMeisaishoNokigenShuryo7;
//    @ReportItem(name = "nashirencho_kaisanMeisaishoNofuZumiGaku", length = 10, order = 61)
//    public RString nashirencho_kaisanMeisaishoNofuZumiGaku;
//    @ReportItem(name = "nashirencho_keisanMeisaishoKongoNofuGaku", length = 10, order = 62)
//    public RString nashirencho_keisanMeisaishoKongoNofuGaku;
//    @ReportItem(name = "nashirencho_keisanMeisaishoKi8", length = 2, order = 63)
//    public RString nashirencho_keisanMeisaishoKi8;
//    @ReportItem(name = "nashirencho_keisanMeisaishoNokigenKaishi8", length = 11, order = 64)
//    public RString nashirencho_keisanMeisaishoNokigenKaishi8;
//    @ReportItem(name = "nashirencho_yen1", length = 1, order = 65)
//    public RString nashirencho_yen1;
//    @ReportItem(name = "nashirencho_yen2", length = 1, order = 66)
//    public RString nashirencho_yen2;
//    @ReportItem(name = "nashirencho_keisanMeisaishoTsuki8", length = 2, order = 67)
//    public RString nashirencho_keisanMeisaishoTsuki8;
//    @ReportItem(name = "nashirencho_keisanMeisaishoNokigenShuryo8", length = 11, order = 68)
//    public RString nashirencho_keisanMeisaishoNokigenShuryo8;
//    @ReportItem(name = "nashirencho_keisanMeisaishoKiTitle1", length = 5, order = 69)
//    public RString nashirencho_keisanMeisaishoKiTitle1;
//    @ReportItem(name = "nashirencho_keisanMeisaishoKibetsuNofuGaku1", length = 10, order = 70)
//    public RString nashirencho_keisanMeisaishoKibetsuNofuGaku1;
//    @ReportItem(name = "nashirencho_keisanMeisaishoKiTitle3", length = 5, order = 71)
//    public RString nashirencho_keisanMeisaishoKiTitle3;
//    @ReportItem(name = "nashirencho_keisanMeisaishoKiNofuGaku3", length = 10, order = 72)
//    public RString nashirencho_keisanMeisaishoKiNofuGaku3;
//    @ReportItem(name = "nashirencho_keisanMeisaishoKi9", length = 2, order = 73)
//    public RString nashirencho_keisanMeisaishoKi9;
//    @ReportItem(name = "nashirencho_keisanMeisaishoNokigenKaishi9", length = 11, order = 74)
//    public RString nashirencho_keisanMeisaishoNokigenKaishi9;
//    @ReportItem(name = "nashirencho_yen3", length = 1, order = 75)
//    public RString nashirencho_yen3;
//    @ReportItem(name = "nashirencho_yen4", length = 1, order = 76)
//    public RString nashirencho_yen4;
//    @ReportItem(name = "nashirencho_keisanMeisaishoTsuki9", length = 2, order = 77)
//    public RString nashirencho_keisanMeisaishoTsuki9;
//    @ReportItem(name = "nashirencho_keisanMeisaishoNokigenShuryo9", length = 11, order = 78)
//    public RString nashirencho_keisanMeisaishoNokigenShuryo9;
//    @ReportItem(name = "nashirencho_keisanMeisaishoKiTitle2", length = 5, order = 79)
//    public RString nashirencho_keisanMeisaishoKiTitle2;
//    @ReportItem(name = "nashirencho_gekihenTitle", length = 20, order = 80)
//    public RString nashirencho_gekihenTitle;
//    @ReportItem(name = "nashirencho_keisanMeisaishoKibetsuNofuGaku2", length = 10, order = 81)
//    public RString nashirencho_keisanMeisaishoKibetsuNofuGaku2;
//    @ReportItem(name = "nashirencho_keisanMeisaishoKiTitle4", length = 5, order = 82)
//    public RString nashirencho_keisanMeisaishoKiTitle4;
//    @ReportItem(name = "nashirencho_gekihenMongon", length = 20, order = 83)
//    public RString nashirencho_gekihenMongon;
//    @ReportItem(name = "nashirencho_keisanMeisaishoKiNofuGaku4", length = 10, order = 84)
//    public RString nashirencho_keisanMeisaishoKiNofuGaku4;
//    @ReportItem(name = "nashirencho_keisanMeisaishoKi10", length = 2, order = 85)
//    public RString nashirencho_keisanMeisaishoKi10;
//    @ReportItem(name = "nashirencho_keisanMeisaishoNokigenKaishi10", length = 11, order = 86)
//    public RString nashirencho_keisanMeisaishoNokigenKaishi10;
//    @ReportItem(name = "nashirencho_keisanmeisaishoNendo2", length = 4, order = 87)
//    public RString nashirencho_keisanmeisaishoNendo2;
//    @ReportItem(name = "nashirencho_keisanMeisaishoHokenryoGokeiGaku", length = 15, order = 88)
//    public RString nashirencho_keisanMeisaishoHokenryoGokeiGaku;
//    @ReportItem(name = "nashirencho_keisanMeisaishoTsuki10", length = 2, order = 89)
//    public RString nashirencho_keisanMeisaishoTsuki10;
//    @ReportItem(name = "nashirencho_keisanMeisaishoNokigenShuryo10", length = 11, order = 90)
//    public RString nashirencho_keisanMeisaishoNokigenShuryo10;
//    @ReportItem(name = "nashirencho_pagerenban1", length = 10, order = 91)
//    public RString nashirencho_pagerenban1;
//    @ReportItem(name = "nashirencho_pagerenban2", length = 10, order = 92)
//    public RString nashirencho_pagerenban2;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoNendo", length = 4, order = 93)
//    public RString nashirencho_nokibetsuMeisaishoNendo;
//    @ReportItem(name = "nashirencho_kmNendoBun", length = 9, order = 94)
//    public RString nashirencho_kmNendoBun;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoTokuchoSaGaku1", length = 10, order = 95)
//    public RString nashirencho_nokibetsuMeisaishoTokuchoSaGaku1;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoTsuchishoNo", order = 96)
//    public RString nashirencho_nokibetsuMeisaishoTsuchishoNo;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoTokuchoNofuGaku1", length = 10, order = 97)
//    public RString nashirencho_nokibetsuMeisaishoTokuchoNofuGaku1;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoTokuchoNofuZumiGaku1", length = 10, order = 98)
//    public RString nashirencho_nokibetsuMeisaishoTokuchoNofuZumiGaku1;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoSetaiCode", length = 15, order = 99)
//    public RString nashirencho_nokibetsuMeisaishoSetaiCode;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoTokuchoNofuGaku2", length = 10, order = 100)
//    public RString nashirencho_nokibetsuMeisaishoTokuchoNofuGaku2;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoTokuchoNofuZumiGaku2", length = 10, order = 101)
//    public RString nashirencho_nokibetsuMeisaishoTokuchoNofuZumiGaku2;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoTokuchoSaGaku2", length = 10, order = 102)
//    public RString nashirencho_nokibetsuMeisaishoTokuchoSaGaku2;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoTokuchoNofuGaku3", length = 10, order = 103)
//    public RString nashirencho_nokibetsuMeisaishoTokuchoNofuGaku3;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoTokuchoNofuZumiGaku3", length = 10, order = 104)
//    public RString nashirencho_nokibetsuMeisaishoTokuchoNofuZumiGaku3;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoTokuchoSaGaku3", length = 10, order = 105)
//    public RString nashirencho_nokibetsuMeisaishoTokuchoSaGaku3;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoHohokenshaName", order = 106)
//    public RString nashirencho_nokibetsuMeisaishoHohokenshaName;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoTokuchoNofuZumiGaku4", length = 10, order = 107)
//    public RString nashirencho_nokibetsuMeisaishoTokuchoNofuZumiGaku4;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoTokuchoSaGaku4", length = 10, order = 108)
//    public RString nashirencho_nokibetsuMeisaishoTokuchoSaGaku4;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoTokuchoNofuGaku4", length = 10, order = 109)
//    public RString nashirencho_nokibetsuMeisaishoTokuchoNofuGaku4;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoKi1", length = 4, order = 110)
//    public RString nashirencho_nokibetsuMeisaishoKi1;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoFuchoNofuGaku1", length = 10, order = 111)
//    public RString nashirencho_nokibetsuMeisaishoFuchoNofuGaku1;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoFuchoNofuZumiGaku1", length = 10, order = 112)
//    public RString nashirencho_nokibetsuMeisaishoFuchoNofuZumiGaku1;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoFuchoSaGaku1", length = 10, order = 113)
//    public RString nashirencho_nokibetsuMeisaishoFuchoSaGaku1;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoNokigen1", length = 11, order = 114)
//    public RString nashirencho_nokibetsuMeisaishoNokigen1;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoKi2", length = 4, order = 115)
//    public RString nashirencho_nokibetsuMeisaishoKi2;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoFuchoNofuGaku2", length = 10, order = 116)
//    public RString nashirencho_nokibetsuMeisaishoFuchoNofuGaku2;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoFuchoNofuZumiGaku2", length = 10, order = 117)
//    public RString nashirencho_nokibetsuMeisaishoFuchoNofuZumiGaku2;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoFuchoSaGaku2", length = 10, order = 118)
//    public RString nashirencho_nokibetsuMeisaishoFuchoSaGaku2;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoNokigen2", length = 11, order = 119)
//    public RString nashirencho_nokibetsuMeisaishoNokigen2;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoKi3", length = 4, order = 120)
//    public RString nashirencho_nokibetsuMeisaishoKi3;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoFuchoNofuGaku3", length = 10, order = 121)
//    public RString nashirencho_nokibetsuMeisaishoFuchoNofuGaku3;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoFuchoNofuZumiGaku3", length = 10, order = 122)
//    public RString nashirencho_nokibetsuMeisaishoFuchoNofuZumiGaku3;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoFuchoSaGaku3", length = 10, order = 123)
//    public RString nashirencho_nokibetsuMeisaishoFuchoSaGaku3;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoNokigen3", length = 11, order = 124)
//    public RString nashirencho_nokibetsuMeisaishoNokigen3;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoKi4", length = 4, order = 125)
//    public RString nashirencho_nokibetsuMeisaishoKi4;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoFuchoNofuGaku4", length = 10, order = 126)
//    public RString nashirencho_nokibetsuMeisaishoFuchoNofuGaku4;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoFuchoNofuZumiGaku4", length = 10, order = 127)
//    public RString nashirencho_nokibetsuMeisaishoFuchoNofuZumiGaku4;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoFuchoSaGaku4", length = 10, order = 128)
//    public RString nashirencho_nokibetsuMeisaishoFuchoSaGaku4;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoNokigen4", length = 11, order = 129)
//    public RString nashirencho_nokibetsuMeisaishoNokigen4;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoKi5", length = 4, order = 130)
//    public RString nashirencho_nokibetsuMeisaishoKi5;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoFuchoNofuGaku5", length = 10, order = 131)
//    public RString nashirencho_nokibetsuMeisaishoFuchoNofuGaku5;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoFuchoNofuZumiGaku5", length = 10, order = 132)
//    public RString nashirencho_nokibetsuMeisaishoFuchoNofuZumiGaku5;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoFuchoSaGaku5", length = 10, order = 133)
//    public RString nashirencho_nokibetsuMeisaishoFuchoSaGaku5;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoNokigen5", length = 11, order = 134)
//    public RString nashirencho_nokibetsuMeisaishoNokigen5;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoKi6", length = 4, order = 135)
//    public RString nashirencho_nokibetsuMeisaishoKi6;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoFuchoNofuGaku6", length = 10, order = 136)
//    public RString nashirencho_nokibetsuMeisaishoFuchoNofuGaku6;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoFuchoNofuZumiGaku6", length = 10, order = 137)
//    public RString nashirencho_nokibetsuMeisaishoFuchoNofuZumiGaku6;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoFuchoSaGaku6", length = 10, order = 138)
//    public RString nashirencho_nokibetsuMeisaishoFuchoSaGaku6;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoNokigen6", length = 11, order = 139)
//    public RString nashirencho_nokibetsuMeisaishoNokigen6;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoKi7", length = 4, order = 140)
//    public RString nashirencho_nokibetsuMeisaishoKi7;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoFuchoNofuGaku7", length = 10, order = 141)
//    public RString nashirencho_nokibetsuMeisaishoFuchoNofuGaku7;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoFuchoNofuZumiGaku7", length = 10, order = 142)
//    public RString nashirencho_nokibetsuMeisaishoFuchoNofuZumiGaku7;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoNokigen7", length = 11, order = 143)
//    public RString nashirencho_nokibetsuMeisaishoNokigen7;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoFuchoSaGaku7", length = 10, order = 144)
//    public RString nashirencho_nokibetsuMeisaishoFuchoSaGaku7;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoKi8", length = 4, order = 145)
//    public RString nashirencho_nokibetsuMeisaishoKi8;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoFuchoNofuGaku8", length = 10, order = 146)
//    public RString nashirencho_nokibetsuMeisaishoFuchoNofuGaku8;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoFuchoNofuZumiGaku8", length = 10, order = 147)
//    public RString nashirencho_nokibetsuMeisaishoFuchoNofuZumiGaku8;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoFuchoSaGaku8", length = 10, order = 148)
//    public RString nashirencho_nokibetsuMeisaishoFuchoSaGaku8;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoNokigen8", length = 11, order = 149)
//    public RString nashirencho_nokibetsuMeisaishoNokigen8;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoKi9", length = 4, order = 150)
//    public RString nashirencho_nokibetsuMeisaishoKi9;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoFuchoNofuGaku9", length = 10, order = 151)
//    public RString nashirencho_nokibetsuMeisaishoFuchoNofuGaku9;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoFuchoNofuZumiGaku9", length = 10, order = 152)
//    public RString nashirencho_nokibetsuMeisaishoFuchoNofuZumiGaku9;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoFuchoSaGaku9", length = 10, order = 153)
//    public RString nashirencho_nokibetsuMeisaishoFuchoSaGaku9;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoNokigen9", length = 11, order = 154)
//    public RString nashirencho_nokibetsuMeisaishoNokigen9;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoKi10", length = 4, order = 155)
//    public RString nashirencho_nokibetsuMeisaishoKi10;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoFuchoNofuGaku10", length = 10, order = 156)
//    public RString nashirencho_nokibetsuMeisaishoFuchoNofuGaku10;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoFuchoNofuZumiGaku10", length = 10, order = 157)
//    public RString nashirencho_nokibetsuMeisaishoFuchoNofuZumiGaku10;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoFuchoSaGaku10", length = 10, order = 158)
//    public RString nashirencho_nokibetsuMeisaishoFuchoSaGaku10;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoNokigen10", length = 11, order = 159)
//    public RString nashirencho_nokibetsuMeisaishoNokigen10;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoFuchoNofuGaku11", length = 10, order = 160)
//    public RString nashirencho_nokibetsuMeisaishoFuchoNofuGaku11;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoFuchoNofuZumiGaku11", length = 10, order = 161)
//    public RString nashirencho_nokibetsuMeisaishoFuchoNofuZumiGaku11;
//    @ReportItem(name = "nashirencho_nokibetsuMeisaishoFuchoSaGaku11", length = 10, order = 162)
//    public RString nashirencho_nokibetsuMeisaishoFuchoSaGaku11;
//    @ReportItem(name = "nashirencho_pagerenban3", length = 10, order = 163)
//    public RString nashirencho_pagerenban3;
//    @ReportItem(name = "nashirencho_yubinNo", length = 8, order = 164)
//    public RString nashirencho_yubinNo;
//    @ReportItem(name = "nashirencho_gyoseiku", length = 14, order = 165)
//    public RString nashirencho_gyoseiku;
//    @ReportItem(name = "nashirencho_jusho3", length = 20, order = 166)
//    public RString nashirencho_jusho3;
//    @ReportItem(name = "nashirencho_jushoText", order = 167)
//    public RString nashirencho_jushoText;
//    @ReportItem(name = "nashirencho_jusho1", length = 20, order = 168)
//    public RString nashirencho_jusho1;
//    @ReportItem(name = "nashirencho_jusho2", length = 20, order = 169)
//    public RString nashirencho_jusho2;
//    @ReportItem(name = "nashirencho_katagakiText", order = 170)
//    public RString nashirencho_katagakiText;
//    @ReportItem(name = "nashirencho_katagaki2", length = 20, order = 171)
//    public RString nashirencho_katagaki2;
//    @ReportItem(name = "nashirencho_katagakiSmall2", length = 30, order = 172)
//    public RString nashirencho_katagakiSmall2;
//    @ReportItem(name = "nashirencho_katagaki1", length = 20, order = 173)
//    public RString nashirencho_katagaki1;
//    @ReportItem(name = "nashirencho_katagakiSmall1", length = 30, order = 174)
//    public RString nashirencho_katagakiSmall1;
//    @ReportItem(name = "nashirencho_shimei2", length = 20, order = 175)
//    public RString nashirencho_shimei2;
//    @ReportItem(name = "nashirencho_shimeiSmall2", length = 40, order = 176)
//    public RString nashirencho_shimeiSmall2;
//    @ReportItem(name = "nashirencho_shimeiText", order = 177)
//    public RString nashirencho_shimeiText;
//    @ReportItem(name = "nashirencho_meishoFuyo2", length = 3, order = 178)
//    public RString nashirencho_meishoFuyo2;
//    @ReportItem(name = "nashirencho_shimeiSmall1", length = 40, order = 179)
//    public RString nashirencho_shimeiSmall1;
//    @ReportItem(name = "nashirencho_dainoKubunMei", length = 8, order = 180)
//    public RString nashirencho_dainoKubunMei;
//    @ReportItem(name = "nashirencho_shimei1", length = 20, order = 181)
//    public RString nashirencho_shimei1;
//    @ReportItem(name = "nashirencho_meishoFuyo1", length = 3, order = 182)
//    public RString nashirencho_meishoFuyo1;
//    @ReportItem(name = "nashirencho_samabunShimeiText", order = 183)
//    public RString nashirencho_samabunShimeiText;
//    @ReportItem(name = "nashirencho_samaBun2", length = 3, order = 184)
//    public RString nashirencho_samaBun2;
//    @ReportItem(name = "nashirencho_samabunShimeiSmall2", length = 40, order = 185)
//    public RString nashirencho_samabunShimeiSmall2;
//    @ReportItem(name = "nashirencho_kakkoLeft2", length = 1, order = 186)
//    public RString nashirencho_kakkoLeft2;
//    @ReportItem(name = "nashirencho_samabunShimei2", length = 20, order = 187)
//    public RString nashirencho_samabunShimei2;
//    @ReportItem(name = "nashirencho_kakkoRight2", length = 1, order = 188)
//    public RString nashirencho_kakkoRight2;
//    @ReportItem(name = "nashirencho_kakkoLeft1", length = 1, order = 189)
//    public RString nashirencho_kakkoLeft1;
//    @ReportItem(name = "nashirencho_samabunShimei1", length = 20, order = 190)
//    public RString nashirencho_samabunShimei1;
//    @ReportItem(name = "nashirencho_samaBun1", length = 3, order = 191)
//    public RString nashirencho_samaBun1;
//    @ReportItem(name = "nashirencho_kakkoRight1", length = 1, order = 192)
//    public RString nashirencho_kakkoRight1;
//    @ReportItem(name = "nashirencho_samabunShimeiSmall1", length = 40, order = 193)
//    public RString nashirencho_samabunShimeiSmall1;
//    @ReportItem(name = "nashirencho_customerBarCode", order = 194)
//    public RString nashirencho_customerBarCode;
//    @ReportItem(name = "nashirencho_denshiKoin", order = 195)
//    public RString nashirencho_denshiKoin;
//    @ReportItem(name = "nashirencho_hakkoYMD", length = 12, order = 196)
//    public RString nashirencho_hakkoYMD;
//    @ReportItem(name = "nashirencho_ninshoshaYakushokuMei", length = 15, order = 197)
//    public RString nashirencho_ninshoshaYakushokuMei;
//    @ReportItem(name = "nashirencho_ninshoshaYakushokuMei1", order = 198)
//    public RString nashirencho_ninshoshaYakushokuMei1;
//    @ReportItem(name = "nashirencho_koinMojiretsu", length = 4, order = 199)
//    public RString nashirencho_koinMojiretsu;
//    @ReportItem(name = "nashirencho_ninshoshaYakushokuMei2", order = 200)
//    public RString nashirencho_ninshoshaYakushokuMei2;
//    @ReportItem(name = "nashirencho_ninshoshaShimeiKakenai", order = 201)
//    public RString nashirencho_ninshoshaShimeiKakenai;
//    @ReportItem(name = "nashirencho_ninshoshaShimeiKakeru", order = 202)
//    public RString nashirencho_ninshoshaShimeiKakeru;
//    @ReportItem(name = "nashirencho_koinShoryaku", length = 15, order = 203)
//    public RString nashirencho_koinShoryaku;
//    @ReportItem(name = "nashirencho_nofuzumishoTitleNendoBun1", length = 9, order = 204)
//    public RString nashirencho_nofuzumishoTitleNendoBun1;
//    @ReportItem(name = "nashirencho_nofuzumishoTitleKi1", length = 2, order = 205)
//    public RString nashirencho_nofuzumishoTitleKi1;
//    @ReportItem(name = "nashirencho_nofuzumishoTitleTsuki1", length = 2, order = 206)
//    public RString nashirencho_nofuzumishoTitleTsuki1;
//    @ReportItem(name = "nashirencho_nofozumishoTitleNendo1", length = 6, order = 207)
//    public RString nashirencho_nofozumishoTitleNendo1;
//    @ReportItem(name = "nashirencho_ryoshushoTitleNendo1", length = 6, order = 208)
//    public RString nashirencho_ryoshushoTitleNendo1;
//    @ReportItem(name = "nashirencho_ryoshushoTitleTsuki1", length = 2, order = 209)
//    public RString nashirencho_ryoshushoTitleTsuki1;
//    @ReportItem(name = "nashirencho_nofushoTitleNendo1", length = 6, order = 210)
//    public RString nashirencho_nofushoTitleNendo1;
//    @ReportItem(name = "nashirencho_nofushoTitleKi1", length = 2, order = 211)
//    public RString nashirencho_nofushoTitleKi1;
//    @ReportItem(name = "nashirencho_nofushoTitleTsuki1", length = 2, order = 212)
//    public RString nashirencho_nofushoTitleTsuki1;
//    @ReportItem(name = "nashirencho_ryoshushoTitleKi1", length = 2, order = 213)
//    public RString nashirencho_ryoshushoTitleKi1;
//    @ReportItem(name = "nashirencho_ryoshushoJusho1", order = 214)
//    public RString nashirencho_ryoshushoJusho1;
//    @ReportItem(name = "nashirencho_nofuzumishoTsuchishoNo1", order = 215)
//    public RString nashirencho_nofuzumishoTsuchishoNo1;
//    @ReportItem(name = "nashirencho_nofuzumishoOCR11", length = 19, order = 216)
//    public RString nashirencho_nofuzumishoOCR11;
//    @ReportItem(name = "nashirencho_ryoshushoKatagaki1", order = 217)
//    public RString nashirencho_ryoshushoKatagaki1;
//    @ReportItem(name = "nashirencho_nofuzumishoSetaiCode1", length = 15, order = 218)
//    public RString nashirencho_nofuzumishoSetaiCode1;
//    @ReportItem(name = "nashirencho_nofuzumishoOCR21", length = 20, order = 219)
//    public RString nashirencho_nofuzumishoOCR21;
//    @ReportItem(name = "nashirencho_ryoshushoHihokenshaName1", order = 220)
//    public RString nashirencho_ryoshushoHihokenshaName1;
//    @ReportItem(name = "nashirencho_nofushoHihokenshaName1", order = 221)
//    public RString nashirencho_nofushoHihokenshaName1;
//    @ReportItem(name = "nashirencho_nofuzumishoOCR31", length = 12, order = 222)
//    public RString nashirencho_nofuzumishoOCR31;
//    @ReportItem(name = "nashirencho_nofuzumishoNokigen1", length = 11, order = 223)
//    public RString nashirencho_nofuzumishoNokigen1;
//    @ReportItem(name = "nashirencho_ryoshushoTsuchishoNo1", order = 224)
//    public RString nashirencho_ryoshushoTsuchishoNo1;
//    @ReportItem(name = "nashirencho_nofushoTsuchishoNo1", order = 225)
//    public RString nashirencho_nofushoTsuchishoNo1;
//    @ReportItem(name = "nashirencho_ryoshushoHokenryoGaku1", length = 10, order = 226)
//    public RString nashirencho_ryoshushoHokenryoGaku1;
//    @ReportItem(name = "nashirencho_nofushoHokenryoGaku1", length = 10, order = 227)
//    public RString nashirencho_nofushoHokenryoGaku1;
//    @ReportItem(name = "nashirencho_nofuzumishoNofuGaku1", length = 10, order = 228)
//    public RString nashirencho_nofuzumishoNofuGaku1;
//    @ReportItem(name = "nashirencho_ryoshushoNokigen1", length = 11, order = 229)
//    public RString nashirencho_ryoshushoNokigen1;
//    @ReportItem(name = "nashirencho_nofushoNokigen1", length = 11, order = 230)
//    public RString nashirencho_nofushoNokigen1;
//    @ReportItem(name = "nashirencho_nofuzumishoJusho1", order = 231)
//    public RString nashirencho_nofuzumishoJusho1;
//    @ReportItem(name = "nashirencho_nofuzumishoKatagaki1", length = 30, order = 232)
//    public RString nashirencho_nofuzumishoKatagaki1;
//    @ReportItem(name = "nashirencho_ryoshushoNofuIn1", length = 2, order = 233)
//    public RString nashirencho_ryoshushoNofuIn1;
//    @ReportItem(name = "nashirencho_nofushoNofuIn1", length = 2, order = 234)
//    public RString nashirencho_nofushoNofuIn1;
//    @ReportItem(name = "nashirencho_nofuzumishoNofuIn1", length = 2, order = 235)
//    public RString nashirencho_nofuzumishoNofuIn1;
//    @ReportItem(name = "nashirencho_ryoshushoKozaCom1", length = 4, order = 236)
//    public RString nashirencho_ryoshushoKozaCom1;
//    @ReportItem(name = "nashirencho_nofushoKozaCom1", length = 4, order = 237)
//    public RString nashirencho_nofushoKozaCom1;
//    @ReportItem(name = "nashirencho_nofuzumishoHihokenshaName1", order = 238)
//    public RString nashirencho_nofuzumishoHihokenshaName1;
//    @ReportItem(name = "nashirencho_nofuzumishoKozaCom1", length = 4, order = 239)
//    public RString nashirencho_nofuzumishoKozaCom1;
//    @ReportItem(name = "nashirencho_ryoshushoZuiji1", length = 2, order = 240)
//    public RString nashirencho_ryoshushoZuiji1;
//    @ReportItem(name = "nashirencho_nofushoZuiji1", length = 2, order = 241)
//    public RString nashirencho_nofushoZuiji1;
//    @ReportItem(name = "nashirencho_nofuzumishoZuiji1", length = 2, order = 242)
//    public RString nashirencho_nofuzumishoZuiji1;
//    @ReportItem(name = "nashirencho_nofuzumishoshichosonName1", order = 243)
//    public RString nashirencho_nofuzumishoshichosonName1;
//    @ReportItem(name = "nashirencho_pagerenban4", length = 10, order = 244)
//    public RString nashirencho_pagerenban4;
    // <DBB100020_HokenryoNonyuTsuchishoBookNofusho.rse>
    @ReportItem(name = "nofuzumishoTitleNendoBun1", length = 9, order = 212)
    public RString nofuzumishoTitleNendoBun1;
    @ReportItem(name = "nofuzumishoTitleKi1", length = 2, order = 213)
    public RString nofuzumishoTitleKi1;
    @ReportItem(name = "nofuzumishoTitleTsuki1", length = 2, order = 214)
    public RString nofuzumishoTitleTsuki1;
    @ReportItem(name = "nofozumishoTitleNendo1", length = 6, order = 215)
    public RString nofozumishoTitleNendo1;
    @ReportItem(name = "nofozumishoTitleNendo2", length = 6, order = 216)
    public RString nofozumishoTitleNendo2;
    @ReportItem(name = "nofuzumishoTitleNendoBun2", length = 9, order = 217)
    public RString nofuzumishoTitleNendoBun2;
    @ReportItem(name = "nofuzumishoTitleKi2", length = 2, order = 218)
    public RString nofuzumishoTitleKi2;
    @ReportItem(name = "nofuzumishoTitleTsuki2", length = 2, order = 219)
    public RString nofuzumishoTitleTsuki2;
    @ReportItem(name = "ryoshushoTitleNendo2", length = 6, order = 220)
    public RString ryoshushoTitleNendo2;
    @ReportItem(name = "ryoshushoTitleKi2", length = 2, order = 221)
    public RString ryoshushoTitleKi2;
    @ReportItem(name = "ryoshushoTitleTsuki2", length = 2, order = 222)
    public RString ryoshushoTitleTsuki2;
    @ReportItem(name = "nofushoTitleNendo2", length = 6, order = 223)
    public RString nofushoTitleNendo2;
    @ReportItem(name = "nofushoTitleKi2", length = 2, order = 224)
    public RString nofushoTitleKi2;
    @ReportItem(name = "nofushoTitleTsuki2", length = 2, order = 225)
    public RString nofushoTitleTsuki2;
    @ReportItem(name = "ryoshushoTitleNendo1", length = 6, order = 226)
    public RString ryoshushoTitleNendo1;
    @ReportItem(name = "ryoshushoTitleKi1", length = 2, order = 227)
    public RString ryoshushoTitleKi1;
    @ReportItem(name = "ryoshushoTitleTsuki1", length = 2, order = 228)
    public RString ryoshushoTitleTsuki1;
    @ReportItem(name = "nofushoTitleNendo1", length = 6, order = 229)
    public RString nofushoTitleNendo1;
    @ReportItem(name = "nofushoTitleKi1", length = 2, order = 230)
    public RString nofushoTitleKi1;
    @ReportItem(name = "nofushoTitleTsuki1", length = 2, order = 231)
    public RString nofushoTitleTsuki1;
    @ReportItem(name = "ryoshushoJusho1", order = 232)
    public RString ryoshushoJusho1;
    @ReportItem(name = "ryoshushoJusho2", order = 233)
    public RString ryoshushoJusho2;
    @ReportItem(name = "nofuzumishoTsuchishoNo1", order = 234)
    public RString nofuzumishoTsuchishoNo1;
    @ReportItem(name = "nofuzumishoTsuchishoNo2", order = 235)
    public RString nofuzumishoTsuchishoNo2;
    @ReportItem(name = "nofuzumishoOCR11", length = 19, order = 236)
    public RString nofuzumishoOCR11;
    @ReportItem(name = "nofuzumishoOCR12", length = 19, order = 237)
    public RString nofuzumishoOCR12;
    @ReportItem(name = "ryoshushoKatagaki1", order = 238)
    public RString ryoshushoKatagaki1;
    @ReportItem(name = "ryoshushoKatagaki2", order = 239)
    public RString ryoshushoKatagaki2;
    @ReportItem(name = "nofuzumishoSetaiCode1", length = 15, order = 240)
    public RString nofuzumishoSetaiCode1;
    @ReportItem(name = "nofuzumishoSetaiCode2", length = 15, order = 241)
    public RString nofuzumishoSetaiCode2;
    @ReportItem(name = "nofuzumishoOCR22", length = 20, order = 242)
    public RString nofuzumishoOCR22;
    @ReportItem(name = "nofuzumishoOCR21", length = 20, order = 243)
    public RString nofuzumishoOCR21;
    @ReportItem(name = "ryoshushoHihokenshaName1", order = 244)
    public RString ryoshushoHihokenshaName1;
    @ReportItem(name = "nofushoHihokenshaName1", order = 245)
    public RString nofushoHihokenshaName1;
    @ReportItem(name = "ryoshushoHihokenshaName2", order = 246)
    public RString ryoshushoHihokenshaName2;
    @ReportItem(name = "nofushoHihokenshaName2", order = 247)
    public RString nofushoHihokenshaName2;
    @ReportItem(name = "nofuzumishoOCR31", length = 12, order = 248)
    public RString nofuzumishoOCR31;
    @ReportItem(name = "nofuzumishoNokigen1", length = 11, order = 249)
    public RString nofuzumishoNokigen1;
    @ReportItem(name = "nofuzumishoNokigen2", length = 11, order = 250)
    public RString nofuzumishoNokigen2;
    @ReportItem(name = "nofuzumishoOCR32", length = 12, order = 251)
    public RString nofuzumishoOCR32;
    @ReportItem(name = "ryoshushoTsuchishoNo1", order = 252)
    public RString ryoshushoTsuchishoNo1;
    @ReportItem(name = "nofushoTsuchishoNo1", order = 253)
    public RString nofushoTsuchishoNo1;
    @ReportItem(name = "ryoshushoTsuchishoNo2", order = 254)
    public RString ryoshushoTsuchishoNo2;
    @ReportItem(name = "nofushoTsuchishoNo2", order = 255)
    public RString nofushoTsuchishoNo2;
    @ReportItem(name = "ryoshushoHokenryoGaku1", length = 10, order = 256)
    public RString ryoshushoHokenryoGaku1;
    @ReportItem(name = "nofushoHokenryoGaku1", length = 10, order = 257)
    public RString nofushoHokenryoGaku1;
    @ReportItem(name = "ryoshushoHokenryoGaku2", length = 10, order = 258)
    public RString ryoshushoHokenryoGaku2;
    @ReportItem(name = "nofushoHokenryoGaku2", length = 10, order = 259)
    public RString nofushoHokenryoGaku2;
    @ReportItem(name = "nofuzumishoNofuGaku1", length = 10, order = 260)
    public RString nofuzumishoNofuGaku1;
    @ReportItem(name = "nofuzumishoNofuGaku2", length = 10, order = 261)
    public RString nofuzumishoNofuGaku2;
    @ReportItem(name = "ryoshushoNokigen1", length = 11, order = 262)
    public RString ryoshushoNokigen1;
    @ReportItem(name = "nofushoNokigen1", length = 11, order = 263)
    public RString nofushoNokigen1;
    @ReportItem(name = "ryoshushoNokigen2", length = 11, order = 264)
    public RString ryoshushoNokigen2;
    @ReportItem(name = "nofushoNokigen2", length = 11, order = 265)
    public RString nofushoNokigen2;
    @ReportItem(name = "nofuzumishoJusho1", order = 266)
    public RString nofuzumishoJusho1;
    @ReportItem(name = "nofuzumishoJusho2", order = 267)
    public RString nofuzumishoJusho2;
    @ReportItem(name = "nofuzumishoKatagaki1", length = 30, order = 268)
    public RString nofuzumishoKatagaki1;
    @ReportItem(name = "nofuzumishoKatagaki2", length = 30, order = 269)
    public RString nofuzumishoKatagaki2;
    @ReportItem(name = "ryoshushoNofuIn1", length = 2, order = 270)
    public RString ryoshushoNofuIn1;
    @ReportItem(name = "nofushoNofuIn1", length = 2, order = 271)
    public RString nofushoNofuIn1;
    @ReportItem(name = "nofuzumishoNofuIn1", length = 2, order = 272)
    public RString nofuzumishoNofuIn1;
    @ReportItem(name = "ryoshushoNofuIn2", length = 2, order = 273)
    public RString ryoshushoNofuIn2;
    @ReportItem(name = "nofushoNofuIn2", length = 2, order = 274)
    public RString nofushoNofuIn2;
    @ReportItem(name = "nofuzumishoNofuIn2", length = 2, order = 275)
    public RString nofuzumishoNofuIn2;
    @ReportItem(name = "ryoshushoKozaCom1", length = 4, order = 276)
    public RString ryoshushoKozaCom1;
    @ReportItem(name = "nofushoKozaCom1", length = 4, order = 277)
    public RString nofushoKozaCom1;
    @ReportItem(name = "nofuzumishoHihokenshaName1", order = 278)
    public RString nofuzumishoHihokenshaName1;
    @ReportItem(name = "nofuzumishoKozaCom1", length = 4, order = 279)
    public RString nofuzumishoKozaCom1;
    @ReportItem(name = "ryoshushoKozaCom2", length = 4, order = 280)
    public RString ryoshushoKozaCom2;
    @ReportItem(name = "nofushoKozaCom2", length = 4, order = 281)
    public RString nofushoKozaCom2;
    @ReportItem(name = "nofuzumishoHihokenshaName2", order = 282)
    public RString nofuzumishoHihokenshaName2;
    @ReportItem(name = "nofuzumishoKozaCom2", length = 4, order = 283)
    public RString nofuzumishoKozaCom2;
    @ReportItem(name = "ryoshushoZuiji1", length = 2, order = 284)
    public RString ryoshushoZuiji1;
    @ReportItem(name = "nofushoZuiji1", length = 2, order = 285)
    public RString nofushoZuiji1;
    @ReportItem(name = "nofuzumishoZuiji1", length = 2, order = 286)
    public RString nofuzumishoZuiji1;
    @ReportItem(name = "ryoshushoZuiji2", length = 2, order = 287)
    public RString ryoshushoZuiji2;
    @ReportItem(name = "nofushoZuiji2", length = 2, order = 288)
    public RString nofushoZuiji2;
    @ReportItem(name = "nofuzumishoZuiji2", length = 2, order = 289)
    public RString nofuzumishoZuiji2;
    @ReportItem(name = "nofuzumishoshichosonName1", order = 290)
    public RString nofuzumishoshichosonName1;
    @ReportItem(name = "pagerenban1", length = 10, order = 291)
    public RString pagerenban1;
    @ReportItem(name = "nofuzumishoshichosonName2", order = 292)
    public RString nofuzumishoshichosonName2;
    @ReportItem(name = "pagerenban2", length = 10, order = 293)
    public RString pagerenban2;
    @ReportItem(name = "nofozumishoTitleNendo3", length = 6, order = 294)
    public RString nofozumishoTitleNendo3;
    @ReportItem(name = "nofuzumishoTitleNendoBun3", length = 9, order = 295)
    public RString nofuzumishoTitleNendoBun3;
    @ReportItem(name = "nofuzumishoTitleKi3", length = 2, order = 296)
    public RString nofuzumishoTitleKi3;
    @ReportItem(name = "nofuzumishoTitleTsuki3", length = 2, order = 297)
    public RString nofuzumishoTitleTsuki3;
    @ReportItem(name = "nofozumishoTitleNendo4", length = 6, order = 298)
    public RString nofozumishoTitleNendo4;
    @ReportItem(name = "nofuzumishoTitleNendoBun4", length = 9, order = 299)
    public RString nofuzumishoTitleNendoBun4;
    @ReportItem(name = "nofuzumishoTitleKi4", length = 2, order = 300)
    public RString nofuzumishoTitleKi4;
    @ReportItem(name = "nofuzumishoTitleTsuki4", length = 2, order = 301)
    public RString nofuzumishoTitleTsuki4;
    @ReportItem(name = "ryoshushoTitleNendo3", length = 6, order = 302)
    public RString ryoshushoTitleNendo3;
    @ReportItem(name = "ryoshushoTitleKi3", length = 2, order = 303)
    public RString ryoshushoTitleKi3;
    @ReportItem(name = "ryoshushoTitleTsuki3", length = 2, order = 304)
    public RString ryoshushoTitleTsuki3;
    @ReportItem(name = "nofushoTitleNendo3", length = 6, order = 305)
    public RString nofushoTitleNendo3;
    @ReportItem(name = "nofushoTitleKi3", length = 2, order = 306)
    public RString nofushoTitleKi3;
    @ReportItem(name = "nofushoTitleTsuki3", length = 2, order = 307)
    public RString nofushoTitleTsuki3;
    @ReportItem(name = "ryoshushoTitleNendo4", length = 6, order = 308)
    public RString ryoshushoTitleNendo4;
    @ReportItem(name = "ryoshushoTitleKi4", length = 2, order = 309)
    public RString ryoshushoTitleKi4;
    @ReportItem(name = "ryoshushoTitleTsuki4", length = 2, order = 310)
    public RString ryoshushoTitleTsuki4;
    @ReportItem(name = "nofushoTitleNendo4", length = 6, order = 311)
    public RString nofushoTitleNendo4;
    @ReportItem(name = "nofushoTitleKi4", length = 2, order = 312)
    public RString nofushoTitleKi4;
    @ReportItem(name = "nofushoTitleTsuki4", length = 2, order = 313)
    public RString nofushoTitleTsuki4;
    @ReportItem(name = "ryoshushoJusho3", order = 314)
    public RString ryoshushoJusho3;
    @ReportItem(name = "ryoshushoJusho4", order = 315)
    public RString ryoshushoJusho4;
    @ReportItem(name = "nofuzumishoTsuchishoNo3", order = 316)
    public RString nofuzumishoTsuchishoNo3;
    @ReportItem(name = "nofuzumishoTsuchishoNo4", order = 317)
    public RString nofuzumishoTsuchishoNo4;
    @ReportItem(name = "nofuzumishoOCR13", length = 19, order = 318)
    public RString nofuzumishoOCR13;
    @ReportItem(name = "nofuzumishoOCR14", length = 19, order = 319)
    public RString nofuzumishoOCR14;
    @ReportItem(name = "ryoshushoKatagaki3", order = 320)
    public RString ryoshushoKatagaki3;
    @ReportItem(name = "ryoshushoKatagaki4", order = 321)
    public RString ryoshushoKatagaki4;
    @ReportItem(name = "nofuzumishoSetaiCode3", length = 15, order = 322)
    public RString nofuzumishoSetaiCode3;
    @ReportItem(name = "nofuzumishoSetaiCode4", length = 15, order = 323)
    public RString nofuzumishoSetaiCode4;
    @ReportItem(name = "nofuzumishoOCR23", length = 20, order = 324)
    public RString nofuzumishoOCR23;
    @ReportItem(name = "nofuzumishoOCR24", length = 20, order = 325)
    public RString nofuzumishoOCR24;
    @ReportItem(name = "ryoshushoHihokenshaName3", order = 326)
    public RString ryoshushoHihokenshaName3;
    @ReportItem(name = "nofushoHihokenshaName3", order = 327)
    public RString nofushoHihokenshaName3;
    @ReportItem(name = "ryoshushoHihokenshaName4", order = 328)
    public RString ryoshushoHihokenshaName4;
    @ReportItem(name = "nofushoHihokenshaName4", order = 329)
    public RString nofushoHihokenshaName4;
    @ReportItem(name = "nofuzumishoNokigen3", length = 11, order = 330)
    public RString nofuzumishoNokigen3;
    @ReportItem(name = "nofuzumishoNokigen4", length = 11, order = 331)
    public RString nofuzumishoNokigen4;
    @ReportItem(name = "nofuzumishoOCR33", length = 12, order = 332)
    public RString nofuzumishoOCR33;
    @ReportItem(name = "nofuzumishoOCR34", length = 12, order = 333)
    public RString nofuzumishoOCR34;
    @ReportItem(name = "ryoshushoTsuchishoNo3", order = 334)
    public RString ryoshushoTsuchishoNo3;
    @ReportItem(name = "nofushoTsuchishoNo3", order = 335)
    public RString nofushoTsuchishoNo3;
    @ReportItem(name = "ryoshushoTsuchishoNo4", order = 336)
    public RString ryoshushoTsuchishoNo4;
    @ReportItem(name = "nofushoTsuchishoNo4", order = 337)
    public RString nofushoTsuchishoNo4;
    @ReportItem(name = "ryoshushoHokenryoGaku3", length = 10, order = 338)
    public RString ryoshushoHokenryoGaku3;
    @ReportItem(name = "nofushoHokenryoGaku3", length = 10, order = 339)
    public RString nofushoHokenryoGaku3;
    @ReportItem(name = "ryoshushoHokenryoGaku4", length = 10, order = 340)
    public RString ryoshushoHokenryoGaku4;
    @ReportItem(name = "nofushoHokenryoGaku4", length = 10, order = 341)
    public RString nofushoHokenryoGaku4;
    @ReportItem(name = "nofuzumishoNofuGaku3", length = 10, order = 342)
    public RString nofuzumishoNofuGaku3;
    @ReportItem(name = "nofuzumishoNofuGaku4", length = 10, order = 343)
    public RString nofuzumishoNofuGaku4;
    @ReportItem(name = "ryoshushoNokigen3", length = 11, order = 344)
    public RString ryoshushoNokigen3;
    @ReportItem(name = "nofushoNokigen3", length = 11, order = 345)
    public RString nofushoNokigen3;
    @ReportItem(name = "ryoshushoNokigen4", length = 11, order = 346)
    public RString ryoshushoNokigen4;
    @ReportItem(name = "nofushoNokigen4", length = 11, order = 347)
    public RString nofushoNokigen4;
    @ReportItem(name = "nofuzumishoJusho3", order = 348)
    public RString nofuzumishoJusho3;
    @ReportItem(name = "nofuzumishoJusho4", order = 349)
    public RString nofuzumishoJusho4;
    @ReportItem(name = "nofuzumishoKatagaki3", length = 30, order = 350)
    public RString nofuzumishoKatagaki3;
    @ReportItem(name = "nofuzumishoKatagaki4", length = 30, order = 351)
    public RString nofuzumishoKatagaki4;
    @ReportItem(name = "ryoshushoNofuIn3", length = 2, order = 352)
    public RString ryoshushoNofuIn3;
    @ReportItem(name = "nofushoNofuIn3", length = 2, order = 353)
    public RString nofushoNofuIn3;
    @ReportItem(name = "nofuzumishoNofuIn3", length = 2, order = 354)
    public RString nofuzumishoNofuIn3;
    @ReportItem(name = "ryoshushoNofuIn4", length = 2, order = 355)
    public RString ryoshushoNofuIn4;
    @ReportItem(name = "nofushoNofuIn4", length = 2, order = 356)
    public RString nofushoNofuIn4;
    @ReportItem(name = "nofuzumishoNofuIn4", length = 2, order = 357)
    public RString nofuzumishoNofuIn4;
    @ReportItem(name = "ryoshushoKozaCom3", length = 4, order = 358)
    public RString ryoshushoKozaCom3;
    @ReportItem(name = "nofushoKozaCom3", length = 4, order = 359)
    public RString nofushoKozaCom3;
    @ReportItem(name = "nofuzumishoHihokenshaName3", order = 360)
    public RString nofuzumishoHihokenshaName3;
    @ReportItem(name = "nofuzumishoKozaCom3", length = 4, order = 361)
    public RString nofuzumishoKozaCom3;
    @ReportItem(name = "ryoshushoKozaCom4", length = 4, order = 362)
    public RString ryoshushoKozaCom4;
    @ReportItem(name = "nofushoKozaCom4", length = 4, order = 363)
    public RString nofushoKozaCom4;
    @ReportItem(name = "nofuzumishoHihokenshaName4", order = 364)
    public RString nofuzumishoHihokenshaName4;
    @ReportItem(name = "nofuzumishoKozaCom4", length = 4, order = 365)
    public RString nofuzumishoKozaCom4;
    @ReportItem(name = "ryoshushoZuiji3", length = 2, order = 366)
    public RString ryoshushoZuiji3;
    @ReportItem(name = "nofushoZuiji3", length = 2, order = 367)
    public RString nofushoZuiji3;
    @ReportItem(name = "nofuzumishoZuiji3", length = 2, order = 368)
    public RString nofuzumishoZuiji3;
    @ReportItem(name = "ryoshushoZuiji4", length = 2, order = 369)
    public RString ryoshushoZuiji4;
    @ReportItem(name = "nofushoZuiji4", length = 2, order = 370)
    public RString nofushoZuiji4;
    @ReportItem(name = "nofuzumishoZuiji4", length = 2, order = 371)
    public RString nofuzumishoZuiji4;
    @ReportItem(name = "eRenban", length = 10, order = 372)
    public RString eRenban;
    @ReportItem(name = "ePage", length = 10, order = 373)
    public RString ePage;
    @ReportItem(name = "nofuzumishoshichosonName3", order = 374)
    public RString nofuzumishoshichosonName3;
    @ReportItem(name = "pagerenban3", length = 10, order = 375)
    public RString pagerenban3;
    @ReportItem(name = "nofuzumishoshichosonName4", order = 376)
    public RString nofuzumishoshichosonName4;
    @ReportItem(name = "pagerenban4", length = 10, order = 377)
    public RString pagerenban4;
    @ReportItem(name = "eHokensyaName", length = 10, order = 378)
    public RString eHokensyaName;

    // <DBB100022_HokenryoNonyuTsuchishoBookRenchoNofusho.rse>
//    @ReportItem(name = "rencho_nofuzumishoTitleNendoBun1", length = 9, order = 1)
//    public RString rencho_nofuzumishoTitleNendoBun1;
//    @ReportItem(name = "rencho_nofuzumishoTitleKi1", length = 2, order = 2)
//    public RString rencho_nofuzumishoTitleKi1;
//    @ReportItem(name = "rencho_nofuzumishoTitleTsuki1", length = 2, order = 3)
//    public RString rencho_nofuzumishoTitleTsuki1;
//    @ReportItem(name = "rencho_nofozumishoTitleNendo1", length = 6, order = 4)
//    public RString rencho_nofozumishoTitleNendo1;
//    @ReportItem(name = "rencho_nofozumishoTitleNendo2", length = 6, order = 5)
//    public RString rencho_nofozumishoTitleNendo2;
//    @ReportItem(name = "rencho_nofuzumishoTitleNendoBun2", length = 9, order = 6)
//    public RString rencho_nofuzumishoTitleNendoBun2;
//    @ReportItem(name = "rencho_nofuzumishoTitleKi2", length = 2, order = 7)
//    public RString rencho_nofuzumishoTitleKi2;
//    @ReportItem(name = "rencho_nofuzumishoTitleTsuki2", length = 2, order = 8)
//    public RString rencho_nofuzumishoTitleTsuki2;
//    @ReportItem(name = "rencho_ryoshushoTitleNendo2", length = 6, order = 9)
//    public RString rencho_ryoshushoTitleNendo2;
//    @ReportItem(name = "rencho_ryoshushoTitleKi2", length = 2, order = 10)
//    public RString rencho_ryoshushoTitleKi2;
//    @ReportItem(name = "rencho_ryoshushoTitleTsuki2", length = 2, order = 11)
//    public RString rencho_ryoshushoTitleTsuki2;
//    @ReportItem(name = "rencho_nofushoTitleNendo2", length = 6, order = 12)
//    public RString rencho_nofushoTitleNendo2;
//    @ReportItem(name = "rencho_nofushoTitleKi2", length = 2, order = 13)
//    public RString rencho_nofushoTitleKi2;
//    @ReportItem(name = "rencho_nofushoTitleTsuki2", length = 2, order = 14)
//    public RString rencho_nofushoTitleTsuki2;
//    @ReportItem(name = "rencho_ryoshushoTitleNendo1", length = 6, order = 15)
//    public RString rencho_ryoshushoTitleNendo1;
//    @ReportItem(name = "rencho_ryoshushoTitleKi1", length = 2, order = 16)
//    public RString rencho_ryoshushoTitleKi1;
//    @ReportItem(name = "rencho_ryoshushoTitleTsuki1", length = 2, order = 17)
//    public RString rencho_ryoshushoTitleTsuki1;
//    @ReportItem(name = "rencho_nofushoTitleNendo1", length = 6, order = 18)
//    public RString rencho_nofushoTitleNendo1;
//    @ReportItem(name = "rencho_nofushoTitleKi1", length = 2, order = 19)
//    public RString rencho_nofushoTitleKi1;
//    @ReportItem(name = "rencho_nofushoTitleTsuki1", length = 2, order = 20)
//    public RString rencho_nofushoTitleTsuki1;
//    @ReportItem(name = "rencho_listList1_1", length = 1, order = 21)
//    public RString rencho_listList1_1;
//    @ReportItem(name = "rencho_ryoshushoJusho1", order = 22)
//    public RString rencho_ryoshushoJusho1;
//    @ReportItem(name = "rencho_ryoshushoJusho2", order = 23)
//    public RString rencho_ryoshushoJusho2;
//    @ReportItem(name = "rencho_nofuzumishoTsuchishoNo1", order = 24)
//    public RString rencho_nofuzumishoTsuchishoNo1;
//    @ReportItem(name = "rencho_nofuzumishoTsuchishoNo2", order = 25)
//    public RString rencho_nofuzumishoTsuchishoNo2;
//    @ReportItem(name = "rencho_nofuzumishoOCR11", length = 19, order = 26)
//    public RString rencho_nofuzumishoOCR11;
//    @ReportItem(name = "rencho_nofuzumishoOCR12", length = 19, order = 27)
//    public RString rencho_nofuzumishoOCR12;
//    @ReportItem(name = "rencho_ryoshushoKatagaki1", order = 28)
//    public RString rencho_ryoshushoKatagaki1;
//    @ReportItem(name = "rencho_ryoshushoKatagaki2", order = 29)
//    public RString rencho_ryoshushoKatagaki2;
//    @ReportItem(name = "rencho_nofuzumishoSetaiCode1", length = 15, order = 30)
//    public RString rencho_nofuzumishoSetaiCode1;
//    @ReportItem(name = "rencho_nofuzumishoSetaiCode2", length = 15, order = 31)
//    public RString rencho_nofuzumishoSetaiCode2;
//    @ReportItem(name = "rencho_nofuzumishoOCR22", length = 20, order = 32)
//    public RString rencho_nofuzumishoOCR22;
//    @ReportItem(name = "rencho_nofuzumishoOCR21", length = 20, order = 33)
//    public RString rencho_nofuzumishoOCR21;
//    @ReportItem(name = "rencho_ryoshushoHihokenshaName1", order = 34)
//    public RString rencho_ryoshushoHihokenshaName1;
//    @ReportItem(name = "rencho_nofushoHihokenshaName1", order = 35)
//    public RString rencho_nofushoHihokenshaName1;
//    @ReportItem(name = "rencho_ryoshushoHihokenshaName2", order = 36)
//    public RString rencho_ryoshushoHihokenshaName2;
//    @ReportItem(name = "rencho_nofushoHihokenshaName2", order = 37)
//    public RString rencho_nofushoHihokenshaName2;
//    @ReportItem(name = "rencho_nofuzumishoOCR31", length = 12, order = 38)
//    public RString rencho_nofuzumishoOCR31;
//    @ReportItem(name = "rencho_nofuzumishoNokigen1", length = 11, order = 39)
//    public RString rencho_nofuzumishoNokigen1;
//    @ReportItem(name = "rencho_nofuzumishoNokigen2", length = 11, order = 40)
//    public RString rencho_nofuzumishoNokigen2;
//    @ReportItem(name = "rencho_nofuzumishoOCR32", length = 12, order = 41)
//    public RString rencho_nofuzumishoOCR32;
//    @ReportItem(name = "rencho_ryoshushoTsuchishoNo1", order = 42)
//    public RString rencho_ryoshushoTsuchishoNo1;
//    @ReportItem(name = "rencho_nofushoTsuchishoNo1", order = 43)
//    public RString rencho_nofushoTsuchishoNo1;
//    @ReportItem(name = "rencho_ryoshushoTsuchishoNo2", order = 44)
//    public RString rencho_ryoshushoTsuchishoNo2;
//    @ReportItem(name = "rencho_nofushoTsuchishoNo2", order = 45)
//    public RString rencho_nofushoTsuchishoNo2;
//    @ReportItem(name = "rencho_ryoshushoHokenryoGaku1", length = 10, order = 46)
//    public RString rencho_ryoshushoHokenryoGaku1;
//    @ReportItem(name = "rencho_nofushoHokenryoGaku1", length = 10, order = 47)
//    public RString rencho_nofushoHokenryoGaku1;
//    @ReportItem(name = "rencho_ryoshushoHokenryoGaku2", length = 10, order = 48)
//    public RString rencho_ryoshushoHokenryoGaku2;
//    @ReportItem(name = "rencho_nofushoHokenryoGaku2", length = 10, order = 49)
//    public RString rencho_nofushoHokenryoGaku2;
//    @ReportItem(name = "rencho_nofuzumishoNofuGaku1", length = 10, order = 50)
//    public RString rencho_nofuzumishoNofuGaku1;
//    @ReportItem(name = "rencho_nofuzumishoNofuGaku2", length = 10, order = 51)
//    public RString rencho_nofuzumishoNofuGaku2;
//    @ReportItem(name = "rencho_ryoshushoNokigen1", length = 11, order = 52)
//    public RString rencho_ryoshushoNokigen1;
//    @ReportItem(name = "rencho_nofushoNokigen1", length = 11, order = 53)
//    public RString rencho_nofushoNokigen1;
//    @ReportItem(name = "rencho_ryoshushoNokigen2", length = 11, order = 54)
//    public RString rencho_ryoshushoNokigen2;
//    @ReportItem(name = "rencho_nofushoNokigen2", length = 11, order = 55)
//    public RString rencho_nofushoNokigen2;
//    @ReportItem(name = "rencho_nofuzumishoJusho1", order = 56)
//    public RString rencho_nofuzumishoJusho1;
//    @ReportItem(name = "rencho_nofuzumishoJusho2", order = 57)
//    public RString rencho_nofuzumishoJusho2;
//    @ReportItem(name = "rencho_nofuzumishoKatagaki1", length = 30, order = 58)
//    public RString rencho_nofuzumishoKatagaki1;
//    @ReportItem(name = "rencho_nofuzumishoKatagaki2", length = 30, order = 59)
//    public RString rencho_nofuzumishoKatagaki2;
//    @ReportItem(name = "rencho_ryoshushoNofuIn1", length = 2, order = 60)
//    public RString rencho_ryoshushoNofuIn1;
//    @ReportItem(name = "rencho_nofushoNofuIn1", length = 2, order = 61)
//    public RString rencho_nofushoNofuIn1;
//    @ReportItem(name = "rencho_nofuzumishoNofuIn1", length = 2, order = 62)
//    public RString rencho_nofuzumishoNofuIn1;
//    @ReportItem(name = "rencho_ryoshushoNofuIn2", length = 2, order = 63)
//    public RString rencho_ryoshushoNofuIn2;
//    @ReportItem(name = "rencho_nofushoNofuIn2", length = 2, order = 64)
//    public RString rencho_nofushoNofuIn2;
//    @ReportItem(name = "rencho_nofuzumishoNofuIn2", length = 2, order = 65)
//    public RString rencho_nofuzumishoNofuIn2;
//    @ReportItem(name = "rencho_ryoshushoKozaCom1", length = 4, order = 66)
//    public RString rencho_ryoshushoKozaCom1;
//    @ReportItem(name = "rencho_nofushoKozaCom1", length = 4, order = 67)
//    public RString rencho_nofushoKozaCom1;
//    @ReportItem(name = "rencho_nofuzumishoHihokenshaName1", order = 68)
//    public RString rencho_nofuzumishoHihokenshaName1;
//    @ReportItem(name = "rencho_nofuzumishoKozaCom1", length = 4, order = 69)
//    public RString rencho_nofuzumishoKozaCom1;
//    @ReportItem(name = "rencho_ryoshushoKozaCom2", length = 4, order = 70)
//    public RString rencho_ryoshushoKozaCom2;
//    @ReportItem(name = "rencho_nofushoKozaCom2", length = 4, order = 71)
//    public RString rencho_nofushoKozaCom2;
//    @ReportItem(name = "rencho_nofuzumishoHihokenshaName2", order = 72)
//    public RString rencho_nofuzumishoHihokenshaName2;
//    @ReportItem(name = "rencho_nofuzumishoKozaCom2", length = 4, order = 73)
//    public RString rencho_nofuzumishoKozaCom2;
//    @ReportItem(name = "rencho_ryoshushoZuiji1", length = 2, order = 74)
//    public RString rencho_ryoshushoZuiji1;
//    @ReportItem(name = "rencho_nofushoZuiji1", length = 2, order = 75)
//    public RString rencho_nofushoZuiji1;
//    @ReportItem(name = "rencho_nofuzumishoZuiji1", length = 2, order = 76)
//    public RString rencho_nofuzumishoZuiji1;
//    @ReportItem(name = "rencho_ryoshushoZuiji2", length = 2, order = 77)
//    public RString rencho_ryoshushoZuiji2;
//    @ReportItem(name = "rencho_nofushoZuiji2", length = 2, order = 78)
//    public RString rencho_nofushoZuiji2;
//    @ReportItem(name = "rencho_nofuzumishoZuiji2", length = 2, order = 79)
//    public RString rencho_nofuzumishoZuiji2;
//    @ReportItem(name = "rencho_nofuzumishoshichosonName1", order = 80)
//    public RString rencho_nofuzumishoshichosonName1;
//    @ReportItem(name = "rencho_pagerenban1", length = 10, order = 81)
//    public RString rencho_pagerenban1;
//    @ReportItem(name = "rencho_nofuzumishoshichosonName2", order = 82)
//    public RString rencho_nofuzumishoshichosonName2;
//    @ReportItem(name = "rencho_pagerenban2", length = 10, order = 83)
//    public RString rencho_pagerenban2;
//    @ReportItem(name = "rencho_nofozumishoTitleNendo3", length = 6, order = 84)
//    public RString rencho_nofozumishoTitleNendo3;
//    @ReportItem(name = "rencho_nofuzumishoTitleNendoBun3", length = 9, order = 85)
//    public RString rencho_nofuzumishoTitleNendoBun3;
//    @ReportItem(name = "rencho_nofuzumishoTitleKi3", length = 2, order = 86)
//    public RString rencho_nofuzumishoTitleKi3;
//    @ReportItem(name = "rencho_nofuzumishoTitleTsuki3", length = 2, order = 87)
//    public RString rencho_nofuzumishoTitleTsuki3;
//    @ReportItem(name = "rencho_nofozumishoTitleNendo4", length = 6, order = 88)
//    public RString rencho_nofozumishoTitleNendo4;
//    @ReportItem(name = "rencho_nofuzumishoTitleNendoBun4", length = 9, order = 89)
//    public RString rencho_nofuzumishoTitleNendoBun4;
//    @ReportItem(name = "rencho_nofuzumishoTitleKi4", length = 2, order = 90)
//    public RString rencho_nofuzumishoTitleKi4;
//    @ReportItem(name = "rencho_nofuzumishoTitleTsuki4", length = 2, order = 91)
//    public RString rencho_nofuzumishoTitleTsuki4;
//    @ReportItem(name = "rencho_ryoshushoTitleNendo3", length = 6, order = 92)
//    public RString rencho_ryoshushoTitleNendo3;
//    @ReportItem(name = "rencho_ryoshushoTitleKi3", length = 2, order = 93)
//    public RString rencho_ryoshushoTitleKi3;
//    @ReportItem(name = "rencho_ryoshushoTitleTsuki3", length = 2, order = 94)
//    public RString rencho_ryoshushoTitleTsuki3;
//    @ReportItem(name = "rencho_nofushoTitleNendo3", length = 6, order = 95)
//    public RString rencho_nofushoTitleNendo3;
//    @ReportItem(name = "rencho_nofushoTitleKi3", length = 2, order = 96)
//    public RString rencho_nofushoTitleKi3;
//    @ReportItem(name = "rencho_nofushoTitleTsuki3", length = 2, order = 97)
//    public RString rencho_nofushoTitleTsuki3;
//    @ReportItem(name = "rencho_ryoshushoTitleNendo4", length = 6, order = 98)
//    public RString rencho_ryoshushoTitleNendo4;
//    @ReportItem(name = "rencho_ryoshushoTitleKi4", length = 2, order = 99)
//    public RString rencho_ryoshushoTitleKi4;
//    @ReportItem(name = "rencho_ryoshushoTitleTsuki4", length = 2, order = 100)
//    public RString rencho_ryoshushoTitleTsuki4;
//    @ReportItem(name = "rencho_nofushoTitleNendo4", length = 6, order = 101)
//    public RString rencho_nofushoTitleNendo4;
//    @ReportItem(name = "rencho_nofushoTitleKi4", length = 2, order = 102)
//    public RString rencho_nofushoTitleKi4;
//    @ReportItem(name = "rencho_nofushoTitleTsuki4", length = 2, order = 103)
//    public RString rencho_nofushoTitleTsuki4;
//    @ReportItem(name = "rencho_ryoshushoJusho3", order = 104)
//    public RString rencho_ryoshushoJusho3;
//    @ReportItem(name = "rencho_ryoshushoJusho4", order = 105)
//    public RString rencho_ryoshushoJusho4;
//    @ReportItem(name = "rencho_nofuzumishoTsuchishoNo3", order = 106)
//    public RString rencho_nofuzumishoTsuchishoNo3;
//    @ReportItem(name = "rencho_nofuzumishoTsuchishoNo4", order = 107)
//    public RString rencho_nofuzumishoTsuchishoNo4;
//    @ReportItem(name = "rencho_nofuzumishoOCR13", length = 19, order = 108)
//    public RString rencho_nofuzumishoOCR13;
//    @ReportItem(name = "rencho_nofuzumishoOCR14", length = 19, order = 109)
//    public RString rencho_nofuzumishoOCR14;
//    @ReportItem(name = "rencho_ryoshushoKatagaki3", order = 110)
//    public RString rencho_ryoshushoKatagaki3;
//    @ReportItem(name = "rencho_ryoshushoKatagaki4", order = 111)
//    public RString rencho_ryoshushoKatagaki4;
//    @ReportItem(name = "rencho_nofuzumishoSetaiCode3", length = 15, order = 112)
//    public RString rencho_nofuzumishoSetaiCode3;
//    @ReportItem(name = "rencho_nofuzumishoSetaiCode4", length = 15, order = 113)
//    public RString rencho_nofuzumishoSetaiCode4;
//    @ReportItem(name = "rencho_nofuzumishoOCR23", length = 20, order = 114)
//    public RString rencho_nofuzumishoOCR23;
//    @ReportItem(name = "rencho_nofuzumishoOCR24", length = 20, order = 115)
//    public RString rencho_nofuzumishoOCR24;
//    @ReportItem(name = "rencho_ryoshushoHihokenshaName3", order = 116)
//    public RString rencho_ryoshushoHihokenshaName3;
//    @ReportItem(name = "rencho_nofushoHihokenshaName3", order = 117)
//    public RString rencho_nofushoHihokenshaName3;
//    @ReportItem(name = "rencho_ryoshushoHihokenshaName4", order = 118)
//    public RString rencho_ryoshushoHihokenshaName4;
//    @ReportItem(name = "rencho_nofushoHihokenshaName4", order = 119)
//    public RString rencho_nofushoHihokenshaName4;
//    @ReportItem(name = "rencho_nofuzumishoNokigen3", length = 11, order = 120)
//    public RString rencho_nofuzumishoNokigen3;
//    @ReportItem(name = "rencho_nofuzumishoNokigen4", length = 11, order = 121)
//    public RString rencho_nofuzumishoNokigen4;
//    @ReportItem(name = "rencho_nofuzumishoOCR33", length = 12, order = 122)
//    public RString rencho_nofuzumishoOCR33;
//    @ReportItem(name = "rencho_nofuzumishoOCR34", length = 12, order = 123)
//    public RString rencho_nofuzumishoOCR34;
//    @ReportItem(name = "rencho_ryoshushoTsuchishoNo3", order = 124)
//    public RString rencho_ryoshushoTsuchishoNo3;
//    @ReportItem(name = "rencho_nofushoTsuchishoNo3", order = 125)
//    public RString rencho_nofushoTsuchishoNo3;
//    @ReportItem(name = "rencho_ryoshushoTsuchishoNo4", order = 126)
//    public RString rencho_ryoshushoTsuchishoNo4;
//    @ReportItem(name = "rencho_nofushoTsuchishoNo4", order = 127)
//    public RString rencho_nofushoTsuchishoNo4;
//    @ReportItem(name = "rencho_ryoshushoHokenryoGaku3", length = 10, order = 128)
//    public RString rencho_ryoshushoHokenryoGaku3;
//    @ReportItem(name = "rencho_nofushoHokenryoGaku3", length = 10, order = 129)
//    public RString rencho_nofushoHokenryoGaku3;
//    @ReportItem(name = "rencho_ryoshushoHokenryoGaku4", length = 10, order = 130)
//    public RString rencho_ryoshushoHokenryoGaku4;
//    @ReportItem(name = "rencho_nofushoHokenryoGaku4", length = 10, order = 131)
//    public RString rencho_nofushoHokenryoGaku4;
//    @ReportItem(name = "rencho_nofuzumishoNofuGaku3", length = 10, order = 132)
//    public RString rencho_nofuzumishoNofuGaku3;
//    @ReportItem(name = "rencho_nofuzumishoNofuGaku4", length = 10, order = 133)
//    public RString rencho_nofuzumishoNofuGaku4;
//    @ReportItem(name = "rencho_ryoshushoNokigen3", length = 11, order = 134)
//    public RString rencho_ryoshushoNokigen3;
//    @ReportItem(name = "rencho_nofushoNokigen3", length = 11, order = 135)
//    public RString rencho_nofushoNokigen3;
//    @ReportItem(name = "rencho_ryoshushoNokigen4", length = 11, order = 136)
//    public RString rencho_ryoshushoNokigen4;
//    @ReportItem(name = "rencho_nofushoNokigen4", length = 11, order = 137)
//    public RString rencho_nofushoNokigen4;
//    @ReportItem(name = "rencho_nofuzumishoJusho3", order = 138)
//    public RString rencho_nofuzumishoJusho3;
//    @ReportItem(name = "rencho_nofuzumishoJusho4", order = 139)
//    public RString rencho_nofuzumishoJusho4;
//    @ReportItem(name = "rencho_nofuzumishoKatagaki3", length = 30, order = 140)
//    public RString rencho_nofuzumishoKatagaki3;
//    @ReportItem(name = "rencho_nofuzumishoKatagaki4", length = 30, order = 141)
//    public RString rencho_nofuzumishoKatagaki4;
//    @ReportItem(name = "rencho_ryoshushoNofuIn3", length = 2, order = 142)
//    public RString rencho_ryoshushoNofuIn3;
//    @ReportItem(name = "rencho_nofushoNofuIn3", length = 2, order = 143)
//    public RString rencho_nofushoNofuIn3;
//    @ReportItem(name = "rencho_nofuzumishoNofuIn3", length = 2, order = 144)
//    public RString rencho_nofuzumishoNofuIn3;
//    @ReportItem(name = "rencho_ryoshushoNofuIn4", length = 2, order = 145)
//    public RString rencho_ryoshushoNofuIn4;
//    @ReportItem(name = "rencho_nofushoNofuIn4", length = 2, order = 146)
//    public RString rencho_nofushoNofuIn4;
//    @ReportItem(name = "rencho_nofuzumishoNofuIn4", length = 2, order = 147)
//    public RString rencho_nofuzumishoNofuIn4;
//    @ReportItem(name = "rencho_ryoshushoKozaCom3", length = 4, order = 148)
//    public RString rencho_ryoshushoKozaCom3;
//    @ReportItem(name = "rencho_nofushoKozaCom3", length = 4, order = 149)
//    public RString rencho_nofushoKozaCom3;
//    @ReportItem(name = "rencho_nofuzumishoHihokenshaName3", order = 150)
//    public RString rencho_nofuzumishoHihokenshaName3;
//    @ReportItem(name = "rencho_nofuzumishoKozaCom3", length = 4, order = 151)
//    public RString rencho_nofuzumishoKozaCom3;
//    @ReportItem(name = "rencho_ryoshushoKozaCom4", length = 4, order = 152)
//    public RString rencho_ryoshushoKozaCom4;
//    @ReportItem(name = "rencho_nofushoKozaCom4", length = 4, order = 153)
//    public RString rencho_nofushoKozaCom4;
//    @ReportItem(name = "rencho_nofuzumishoHihokenshaName4", order = 154)
//    public RString rencho_nofuzumishoHihokenshaName4;
//    @ReportItem(name = "rencho_nofuzumishoKozaCom4", length = 4, order = 155)
//    public RString rencho_nofuzumishoKozaCom4;
//    @ReportItem(name = "rencho_ryoshushoZuiji3", length = 2, order = 156)
//    public RString rencho_ryoshushoZuiji3;
//    @ReportItem(name = "rencho_nofushoZuiji3", length = 2, order = 157)
//    public RString rencho_nofushoZuiji3;
//    @ReportItem(name = "rencho_nofuzumishoZuiji3", length = 2, order = 158)
//    public RString rencho_nofuzumishoZuiji3;
//    @ReportItem(name = "rencho_ryoshushoZuiji4", length = 2, order = 159)
//    public RString rencho_ryoshushoZuiji4;
//    @ReportItem(name = "rencho_nofushoZuiji4", length = 2, order = 160)
//    public RString rencho_nofushoZuiji4;
//    @ReportItem(name = "rencho_nofuzumishoZuiji4", length = 2, order = 161)
//    public RString rencho_nofuzumishoZuiji4;
//    @ReportItem(name = "rencho_nofuzumishoshichosonName3", order = 162)
//    public RString rencho_nofuzumishoshichosonName3;
//    @ReportItem(name = "rencho_nofuzumishoshichosonName4", order = 163)
//    public RString rencho_nofuzumishoshichosonName4;
//    @ReportItem(name = "rencho_pagerenban3", length = 10, order = 164)
//    public RString rencho_pagerenban3;
//    @ReportItem(name = "rencho_pagerenban4", length = 10, order = 165)
//    public RString rencho_pagerenban4;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
