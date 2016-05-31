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

// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
