/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishobook;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 *
 * 保険料納入通知書（本算定）【ブックタイプ】納付書連帳 （口振依頼あり）通知書_連帳帳票Sourceです。
 *
 * @reamsid_L DBB-9110-010 huangh
 */
public class HokenryoNonyuNonyuTsuchishoBookFuriKaeAriRenchoCoverSource implements IReportSource {

    @ReportItem(name = "cover_listList1_1", length = 1, order = 1)
    public RString cover_listList1_1;
    @ReportItem(name = "cover_keisanMeisaishoNendo", length = 4, order = 2)
    public RString cover_keisanMeisaishoNendo;
    @ReportItem(name = "cover_keisanMeisaishoNendoBun", length = 9, order = 3)
    public RString cover_keisanMeisaishoNendoBun;
    @ReportItem(name = "cover_titleNendo", length = 4, order = 4)
    public RString cover_titleNendo;
    @ReportItem(name = "cover_titleNendoBun", length = 9, order = 5)
    public RString cover_titleNendoBun;
    @ReportItem(name = "cover_hyojicodeName1", order = 6)
    public RString cover_hyojicodeName1;
    @ReportItem(name = "cover_hyojicodeName2", order = 7)
    public RString cover_hyojicodeName2;
    @ReportItem(name = "cover_hyojicodeName3", order = 8)
    public RString cover_hyojicodeName3;
    @ReportItem(name = "cover_hyojicode1", length = 11, order = 9)
    public RString cover_hyojicode1;
    @ReportItem(name = "cover_hyojicode2", length = 9, order = 10)
    public RString cover_hyojicode2;
    @ReportItem(name = "cover_hyojicode3", length = 9, order = 11)
    public RString cover_hyojicode3;
    @ReportItem(name = "cover_keisanMeisaishoKi1", length = 2, order = 12)
    public RString cover_keisanMeisaishoKi1;
    @ReportItem(name = "cover_keisanMeisaishoNokigenKaishi1", length = 11, order = 13)
    public RString cover_keisanMeisaishoNokigenKaishi1;
    @ReportItem(name = "cover_kaisanMeisaishoHihokenshaName", order = 14)
    public RString cover_kaisanMeisaishoHihokenshaName;
    @ReportItem(name = "cover_kaisanMeisaishoSetaiNushiName", order = 15)
    public RString cover_kaisanMeisaishoSetaiNushiName;
    @ReportItem(name = "cover_keisanMeisaishoTsuchishoNo", order = 16)
    public RString cover_keisanMeisaishoTsuchishoNo;
    @ReportItem(name = "cover_keisanMeisaishoSetaiCode", length = 15, order = 17)
    public RString cover_keisanMeisaishoSetaiCode;
    @ReportItem(name = "cover_keisanMeisaishoTsuki1", length = 2, order = 18)
    public RString cover_keisanMeisaishoTsuki1;
    @ReportItem(name = "cover_keisanMeisaishoNokigenShuryo1", length = 11, order = 19)
    public RString cover_keisanMeisaishoNokigenShuryo1;
    @ReportItem(name = "cover_keisanMeisaishoKi2", length = 2, order = 20)
    public RString cover_keisanMeisaishoKi2;
    @ReportItem(name = "cover_keisanMeisaishoNokigenKaishi2", length = 11, order = 21)
    public RString cover_keisanMeisaishoNokigenKaishi2;
    @ReportItem(name = "cover_keisanMeisaishoTsuki2", length = 2, order = 22)
    public RString cover_keisanMeisaishoTsuki2;
    @ReportItem(name = "cover_keisanMeisaishoNokigenShuryo2", length = 11, order = 23)
    public RString cover_keisanMeisaishoNokigenShuryo2;
    @ReportItem(name = "cover_tsuchishoNo", order = 24)
    public RString cover_tsuchishoNo;
    @ReportItem(name = "cover_setaiCode", length = 15, order = 25)
    public RString cover_setaiCode;
    @ReportItem(name = "cover_keisanMeisaishoKi3", length = 2, order = 26)
    public RString cover_keisanMeisaishoKi3;
    @ReportItem(name = "cover_keisanMeisaishoNokigenKaishi3", length = 11, order = 27)
    public RString cover_keisanMeisaishoNokigenKaishi3;
    @ReportItem(name = "cover_keisanMeisaishoKaishiKi", length = 16, order = 28)
    public RString cover_keisanMeisaishoKaishiKi;
    @ReportItem(name = "cover_keisanMeisaishoTsuki3", length = 2, order = 29)
    public RString cover_keisanMeisaishoTsuki3;
    @ReportItem(name = "cover_keisanMeisaishoNokigenShuryo3", length = 11, order = 30)
    public RString cover_keisanMeisaishoNokigenShuryo3;
    @ReportItem(name = "cover_keisanMeisaishoTsukiSu", length = 12, order = 31)
    public RString cover_keisanMeisaishoTsukiSu;
    @ReportItem(name = "cover_kaisanMeisaishoShuryoKi", length = 16, order = 32)
    public RString cover_kaisanMeisaishoShuryoKi;
    @ReportItem(name = "cover_keisanMeisaishoKi4", length = 2, order = 33)
    public RString cover_keisanMeisaishoKi4;
    @ReportItem(name = "cover_keisanMeisaishoNokigenKaishi4", length = 11, order = 34)
    public RString cover_keisanMeisaishoNokigenKaishi4;
    @ReportItem(name = "cover_bankCode", length = 7, order = 35)
    public RString cover_bankCode;
    @ReportItem(name = "cover_kozaShurui", length = 3, order = 36)
    public RString cover_kozaShurui;
    @ReportItem(name = "cover_kozaNo", length = 14, order = 37)
    public RString cover_kozaNo;
    @ReportItem(name = "cover_keisanMeisaishoTsuki4", length = 2, order = 38)
    public RString cover_keisanMeisaishoTsuki4;
    @ReportItem(name = "cover_keisanMeisaishoNokigenShuryo4", length = 11, order = 39)
    public RString cover_keisanMeisaishoNokigenShuryo4;
    @ReportItem(name = "cover_keisanMeisaishoShotokuDankai", length = 8, order = 40)
    public RString cover_keisanMeisaishoShotokuDankai;
    @ReportItem(name = "cover_kaisanMeisaiHokenryoRitsu", length = 10, order = 41)
    public RString cover_kaisanMeisaiHokenryoRitsu;
    @ReportItem(name = "cover_keisanMeisaishoKi5", length = 2, order = 42)
    public RString cover_keisanMeisaishoKi5;
    @ReportItem(name = "cover_keisanMeisaishoNokigenKaishi5", length = 11, order = 43)
    public RString cover_keisanMeisaishoNokigenKaishi5;
    @ReportItem(name = "cover_keisanMeisaishoTsuki5", length = 2, order = 44)
    public RString cover_keisanMeisaishoTsuki5;
    @ReportItem(name = "cover_keisanMeisaishoNokigenShuryo5", length = 11, order = 45)
    public RString cover_keisanMeisaishoNokigenShuryo5;
    @ReportItem(name = "cover_keisanMeisaishoCalHokenryoGaku", length = 10, order = 46)
    public RString cover_keisanMeisaishoCalHokenryoGaku;
    @ReportItem(name = "cover_keisanMeisaishoGenmenGaku", length = 10, order = 47)
    public RString cover_keisanMeisaishoGenmenGaku;
    @ReportItem(name = "cover_bankName", length = 20, order = 48)
    public RString cover_bankName;
    @ReportItem(name = "cover_keisanMeisaishoKi6", length = 2, order = 49)
    public RString cover_keisanMeisaishoKi6;
    @ReportItem(name = "cover_keisanMeisaishoNokigenKaishi6", length = 11, order = 50)
    public RString cover_keisanMeisaishoNokigenKaishi6;
    @ReportItem(name = "cover_keisanMeisaishoTsuki6", length = 2, order = 51)
    public RString cover_keisanMeisaishoTsuki6;
    @ReportItem(name = "cover_keisanMeisaishoNokigenShuryo6", length = 11, order = 52)
    public RString cover_keisanMeisaishoNokigenShuryo6;
    @ReportItem(name = "cover_keisanMeisaishoTokuchoGokeiGaku", length = 10, order = 53)
    public RString cover_keisanMeisaishoTokuchoGokeiGaku;
    @ReportItem(name = "cover_kaisanMeisaishoFuchoGokeiGaku", length = 10, order = 54)
    public RString cover_kaisanMeisaishoFuchoGokeiGaku;
    @ReportItem(name = "cover_keisanMeisaishoKi7", length = 2, order = 55)
    public RString cover_keisanMeisaishoKi7;
    @ReportItem(name = "cover_keisanMeisaishoNokigenKaishi7", length = 11, order = 56)
    public RString cover_keisanMeisaishoNokigenKaishi7;
    @ReportItem(name = "cover_noutsuRenban", length = 8, order = 57)
    public RString cover_noutsuRenban;
    @ReportItem(name = "cover_kozaMeiginin", length = 20, order = 58)
    public RString cover_kozaMeiginin;
    @ReportItem(name = "cover_keisanMeisaishoTsuki7", length = 2, order = 59)
    public RString cover_keisanMeisaishoTsuki7;
    @ReportItem(name = "cover_keisanMeisaishoNokigenShuryo7", length = 11, order = 60)
    public RString cover_keisanMeisaishoNokigenShuryo7;
    @ReportItem(name = "cover_kaisanMeisaishoNofuZumiGaku", length = 10, order = 61)
    public RString cover_kaisanMeisaishoNofuZumiGaku;
    @ReportItem(name = "cover_keisanMeisaishoKongoNofuGaku", length = 10, order = 62)
    public RString cover_keisanMeisaishoKongoNofuGaku;
    @ReportItem(name = "cover_keisanMeisaishoKi8", length = 2, order = 63)
    public RString cover_keisanMeisaishoKi8;
    @ReportItem(name = "cover_keisanMeisaishoNokigenKaishi8", length = 11, order = 64)
    public RString cover_keisanMeisaishoNokigenKaishi8;
    @ReportItem(name = "cover_yen1", length = 1, order = 65)
    public RString cover_yen1;
    @ReportItem(name = "cover_yen2", length = 1, order = 66)
    public RString cover_yen2;
    @ReportItem(name = "cover_keisanMeisaishoTsuki8", length = 2, order = 67)
    public RString cover_keisanMeisaishoTsuki8;
    @ReportItem(name = "cover_keisanMeisaishoNokigenShuryo8", length = 11, order = 68)
    public RString cover_keisanMeisaishoNokigenShuryo8;
    @ReportItem(name = "cover_keisanMeisaishoKiTitle1", length = 5, order = 69)
    public RString cover_keisanMeisaishoKiTitle1;
    @ReportItem(name = "cover_keisanMeisaishoKibetsuNofuGaku1", length = 10, order = 70)
    public RString cover_keisanMeisaishoKibetsuNofuGaku1;
    @ReportItem(name = "cover_keisanMeisaishoKiTitle3", length = 5, order = 71)
    public RString cover_keisanMeisaishoKiTitle3;
    @ReportItem(name = "cover_keisanMeisaishoKiNofuGaku3", length = 10, order = 72)
    public RString cover_keisanMeisaishoKiNofuGaku3;
    @ReportItem(name = "cover_keisanMeisaishoKi9", length = 2, order = 73)
    public RString cover_keisanMeisaishoKi9;
    @ReportItem(name = "cover_keisanMeisaishoNokigenKaishi9", length = 11, order = 74)
    public RString cover_keisanMeisaishoNokigenKaishi9;
    @ReportItem(name = "cover_yen3", length = 1, order = 75)
    public RString cover_yen3;
    @ReportItem(name = "cover_yen4", length = 1, order = 76)
    public RString cover_yen4;
    @ReportItem(name = "cover_keisanMeisaishoTsuki9", length = 2, order = 77)
    public RString cover_keisanMeisaishoTsuki9;
    @ReportItem(name = "cover_keisanMeisaishoNokigenShuryo9", length = 11, order = 78)
    public RString cover_keisanMeisaishoNokigenShuryo9;
    @ReportItem(name = "cover_keisanMeisaishoKiTitle2", length = 5, order = 79)
    public RString cover_keisanMeisaishoKiTitle2;
    @ReportItem(name = "cover_gekihenTitle", length = 20, order = 80)
    public RString cover_gekihenTitle;
    @ReportItem(name = "cover_keisanMeisaishoKibetsuNofuGaku2", length = 10, order = 81)
    public RString cover_keisanMeisaishoKibetsuNofuGaku2;
    @ReportItem(name = "cover_keisanMeisaishoKiTitle4", length = 5, order = 82)
    public RString cover_keisanMeisaishoKiTitle4;
    @ReportItem(name = "cover_gekihenMongon", length = 20, order = 83)
    public RString cover_gekihenMongon;
    @ReportItem(name = "cover_keisanMeisaishoKiNofuGaku4", length = 10, order = 84)
    public RString cover_keisanMeisaishoKiNofuGaku4;
    @ReportItem(name = "cover_keisanMeisaishoKi10", length = 2, order = 85)
    public RString cover_keisanMeisaishoKi10;
    @ReportItem(name = "cover_keisanMeisaishoNokigenKaishi10", length = 11, order = 86)
    public RString cover_keisanMeisaishoNokigenKaishi10;
    @ReportItem(name = "cover_keisanmeisaishoNendo2", length = 4, order = 87)
    public RString cover_keisanmeisaishoNendo2;
    @ReportItem(name = "cover_keisanMeisaishoTsuki10", length = 2, order = 88)
    public RString cover_keisanMeisaishoTsuki10;
    @ReportItem(name = "cover_keisanMeisaishoNokigenShuryo10", length = 11, order = 89)
    public RString cover_keisanMeisaishoNokigenShuryo10;
    @ReportItem(name = "cover_keisanMeisaishoHokenryoGokeiGaku", length = 15, order = 90)
    public RString cover_keisanMeisaishoHokenryoGokeiGaku;
    @ReportItem(name = "cover_pagerenban1", length = 10, order = 91)
    public RString cover_pagerenban1;
    @ReportItem(name = "cover_pagerenban2", length = 10, order = 92)
    public RString cover_pagerenban2;
    @ReportItem(name = "cover_nokibetsuMeisaishoNendo", length = 4, order = 93)
    public RString cover_nokibetsuMeisaishoNendo;
    @ReportItem(name = "cover_kmNendoBun", length = 9, order = 94)
    public RString cover_kmNendoBun;
    @ReportItem(name = "cover_kozaIraishoLeftJusho", order = 95)
    public RString cover_kozaIraishoLeftJusho;
    @ReportItem(name = "cover_kozaIraishoRightJusho", order = 96)
    public RString cover_kozaIraishoRightJusho;
    @ReportItem(name = "cover_nokibetsuMeisaishoTokuchoNofuGaku1", length = 10, order = 97)
    public RString cover_nokibetsuMeisaishoTokuchoNofuGaku1;
    @ReportItem(name = "cover_nokibetsuMeisaishoTokuchoNofuZumiGaku1", length = 10, order = 98)
    public RString cover_nokibetsuMeisaishoTokuchoNofuZumiGaku1;
    @ReportItem(name = "cover_nokibetsuMeisaishoTokuchoSaGaku1", length = 10, order = 99)
    public RString cover_nokibetsuMeisaishoTokuchoSaGaku1;
    @ReportItem(name = "cover_nokibetsuMeisaishoTsuchishoNo", order = 100)
    public RString cover_nokibetsuMeisaishoTsuchishoNo;
    @ReportItem(name = "cover_nokibetsuMeisaishoSetaiCode", length = 15, order = 101)
    public RString cover_nokibetsuMeisaishoSetaiCode;
    @ReportItem(name = "cover_nokibetsuMeisaishoTokuchoNofuGaku2", length = 10, order = 102)
    public RString cover_nokibetsuMeisaishoTokuchoNofuGaku2;
    @ReportItem(name = "cover_nokibetsuMeisaishoTokuchoNofuZumiGaku2", length = 10, order = 103)
    public RString cover_nokibetsuMeisaishoTokuchoNofuZumiGaku2;
    @ReportItem(name = "cover_nokibetsuMeisaishoTokuchoSaGaku2", length = 10, order = 104)
    public RString cover_nokibetsuMeisaishoTokuchoSaGaku2;
    @ReportItem(name = "cover_nokibetsuMeisaishoHohokenshaName", order = 105)
    public RString cover_nokibetsuMeisaishoHohokenshaName;
    @ReportItem(name = "cover_text2", order = 106)
    public RString cover_text2;
    @ReportItem(name = "cover_kozaIraishoLeftHihokenshaName", order = 107)
    public RString cover_kozaIraishoLeftHihokenshaName;
    @ReportItem(name = "cover_kozaIraishoRightHihokenshaName", order = 108)
    public RString cover_kozaIraishoRightHihokenshaName;
    @ReportItem(name = "cover_nokibetsuMeisaishoTokuchoNofuGaku3", length = 10, order = 109)
    public RString cover_nokibetsuMeisaishoTokuchoNofuGaku3;
    @ReportItem(name = "cover_nokibetsuMeisaishoTokuchoNofuZumiGaku3", length = 10, order = 110)
    public RString cover_nokibetsuMeisaishoTokuchoNofuZumiGaku3;
    @ReportItem(name = "cover_nokibetsuMeisaishoTokuchoSaGaku3", length = 10, order = 111)
    public RString cover_nokibetsuMeisaishoTokuchoSaGaku3;
    @ReportItem(name = "cover_nokibetsuMeisaishoTokuchoNofuGaku4", length = 10, order = 112)
    public RString cover_nokibetsuMeisaishoTokuchoNofuGaku4;
    @ReportItem(name = "cover_nokibetsuMeisaishoTokuchoNofuZumiGaku4", length = 10, order = 113)
    public RString cover_nokibetsuMeisaishoTokuchoNofuZumiGaku4;
    @ReportItem(name = "cover_nokibetsuMeisaishoTokuchoSaGaku4", length = 10, order = 114)
    public RString cover_nokibetsuMeisaishoTokuchoSaGaku4;
    @ReportItem(name = "cover_kozaIraishoLeftShikibetsuCode", length = 15, order = 115)
    public RString cover_kozaIraishoLeftShikibetsuCode;
    @ReportItem(name = "cover_kozaIraishoRightShikibetsuCode", length = 15, order = 116)
    public RString cover_kozaIraishoRightShikibetsuCode;
    @ReportItem(name = "cover_nokibetsuMeisaishoKi1", length = 4, order = 117)
    public RString cover_nokibetsuMeisaishoKi1;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoNofuGaku1", length = 10, order = 118)
    public RString cover_nokibetsuMeisaishoFuchoNofuGaku1;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoNofuZumiGaku1", length = 10, order = 119)
    public RString cover_nokibetsuMeisaishoFuchoNofuZumiGaku1;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoSaGaku1", length = 10, order = 120)
    public RString cover_nokibetsuMeisaishoFuchoSaGaku1;
    @ReportItem(name = "cover_nokibetsuMeisaishoNokigen1", length = 11, order = 121)
    public RString cover_nokibetsuMeisaishoNokigen1;
    @ReportItem(name = "cover_nokibetsuMeisaishoKi2", length = 4, order = 122)
    public RString cover_nokibetsuMeisaishoKi2;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoNofuGaku2", length = 10, order = 123)
    public RString cover_nokibetsuMeisaishoFuchoNofuGaku2;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoNofuZumiGaku2", length = 10, order = 124)
    public RString cover_nokibetsuMeisaishoFuchoNofuZumiGaku2;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoSaGaku2", length = 10, order = 125)
    public RString cover_nokibetsuMeisaishoFuchoSaGaku2;
    @ReportItem(name = "cover_nokibetsuMeisaishoNokigen2", length = 11, order = 126)
    public RString cover_nokibetsuMeisaishoNokigen2;
    @ReportItem(name = "cover_nokibetsuMeisaishoKi3", length = 4, order = 127)
    public RString cover_nokibetsuMeisaishoKi3;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoNofuGaku3", length = 10, order = 128)
    public RString cover_nokibetsuMeisaishoFuchoNofuGaku3;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoNofuZumiGaku3", length = 10, order = 129)
    public RString cover_nokibetsuMeisaishoFuchoNofuZumiGaku3;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoSaGaku3", length = 10, order = 130)
    public RString cover_nokibetsuMeisaishoFuchoSaGaku3;
    @ReportItem(name = "cover_nokibetsuMeisaishoNokigen3", length = 11, order = 131)
    public RString cover_nokibetsuMeisaishoNokigen3;
    @ReportItem(name = "cover_nokibetsuMeisaishoKi4", length = 4, order = 132)
    public RString cover_nokibetsuMeisaishoKi4;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoNofuGaku4", length = 10, order = 133)
    public RString cover_nokibetsuMeisaishoFuchoNofuGaku4;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoNofuZumiGaku4", length = 10, order = 134)
    public RString cover_nokibetsuMeisaishoFuchoNofuZumiGaku4;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoSaGaku4", length = 10, order = 135)
    public RString cover_nokibetsuMeisaishoFuchoSaGaku4;
    @ReportItem(name = "cover_nokibetsuMeisaishoNokigen4", length = 11, order = 136)
    public RString cover_nokibetsuMeisaishoNokigen4;
    @ReportItem(name = "cover_nokibetsuMeisaishoKi5", length = 4, order = 137)
    public RString cover_nokibetsuMeisaishoKi5;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoNofuGaku5", length = 10, order = 138)
    public RString cover_nokibetsuMeisaishoFuchoNofuGaku5;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoNofuZumiGaku5", length = 10, order = 139)
    public RString cover_nokibetsuMeisaishoFuchoNofuZumiGaku5;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoSaGaku5", length = 10, order = 140)
    public RString cover_nokibetsuMeisaishoFuchoSaGaku5;
    @ReportItem(name = "cover_nokibetsuMeisaishoNokigen5", length = 11, order = 141)
    public RString cover_nokibetsuMeisaishoNokigen5;
    @ReportItem(name = "cover_nokibetsuMeisaishoKi6", length = 4, order = 142)
    public RString cover_nokibetsuMeisaishoKi6;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoNofuGaku6", length = 10, order = 143)
    public RString cover_nokibetsuMeisaishoFuchoNofuGaku6;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoNofuZumiGaku6", length = 10, order = 144)
    public RString cover_nokibetsuMeisaishoFuchoNofuZumiGaku6;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoSaGaku6", length = 10, order = 145)
    public RString cover_nokibetsuMeisaishoFuchoSaGaku6;
    @ReportItem(name = "cover_nokibetsuMeisaishoNokigen6", length = 11, order = 146)
    public RString cover_nokibetsuMeisaishoNokigen6;
    @ReportItem(name = "cover_nokibetsuMeisaishoKi7", length = 4, order = 147)
    public RString cover_nokibetsuMeisaishoKi7;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoNofuGaku7", length = 10, order = 148)
    public RString cover_nokibetsuMeisaishoFuchoNofuGaku7;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoNofuZumiGaku7", length = 10, order = 149)
    public RString cover_nokibetsuMeisaishoFuchoNofuZumiGaku7;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoSaGaku7", length = 10, order = 150)
    public RString cover_nokibetsuMeisaishoFuchoSaGaku7;
    @ReportItem(name = "cover_nokibetsuMeisaishoNokigen7", length = 11, order = 151)
    public RString cover_nokibetsuMeisaishoNokigen7;
    @ReportItem(name = "cover_nokibetsuMeisaishoKi8", length = 4, order = 152)
    public RString cover_nokibetsuMeisaishoKi8;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoNofuGaku8", length = 10, order = 153)
    public RString cover_nokibetsuMeisaishoFuchoNofuGaku8;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoNofuZumiGaku8", length = 10, order = 154)
    public RString cover_nokibetsuMeisaishoFuchoNofuZumiGaku8;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoSaGaku8", length = 10, order = 155)
    public RString cover_nokibetsuMeisaishoFuchoSaGaku8;
    @ReportItem(name = "cover_nokibetsuMeisaishoNokigen8", length = 11, order = 156)
    public RString cover_nokibetsuMeisaishoNokigen8;
    @ReportItem(name = "cover_nokibetsuMeisaishoKi9", length = 4, order = 157)
    public RString cover_nokibetsuMeisaishoKi9;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoNofuGaku9", length = 10, order = 158)
    public RString cover_nokibetsuMeisaishoFuchoNofuGaku9;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoNofuZumiGaku9", length = 10, order = 159)
    public RString cover_nokibetsuMeisaishoFuchoNofuZumiGaku9;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoSaGaku9", length = 10, order = 160)
    public RString cover_nokibetsuMeisaishoFuchoSaGaku9;
    @ReportItem(name = "cover_nokibetsuMeisaishoNokigen9", length = 11, order = 161)
    public RString cover_nokibetsuMeisaishoNokigen9;
    @ReportItem(name = "cover_nokibetsuMeisaishoKi10", length = 4, order = 162)
    public RString cover_nokibetsuMeisaishoKi10;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoNofuGaku10", length = 10, order = 163)
    public RString cover_nokibetsuMeisaishoFuchoNofuGaku10;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoNofuZumiGaku10", length = 10, order = 164)
    public RString cover_nokibetsuMeisaishoFuchoNofuZumiGaku10;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoSaGaku10", length = 10, order = 165)
    public RString cover_nokibetsuMeisaishoFuchoSaGaku10;
    @ReportItem(name = "cover_nokibetsuMeisaishoNokigen10", length = 11, order = 166)
    public RString cover_nokibetsuMeisaishoNokigen10;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoNofuGaku11", length = 10, order = 167)
    public RString cover_nokibetsuMeisaishoFuchoNofuGaku11;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoNofuZumiGaku11", length = 10, order = 168)
    public RString cover_nokibetsuMeisaishoFuchoNofuZumiGaku11;
    @ReportItem(name = "cover_nokibetsuMeisaishoFuchoSaGaku11", length = 10, order = 169)
    public RString cover_nokibetsuMeisaishoFuchoSaGaku11;
    @ReportItem(name = "cover_pagerenban3", length = 10, order = 170)
    public RString cover_pagerenban3;
    @ReportItem(name = "cover_pagerenban4", length = 10, order = 171)
    public RString cover_pagerenban4;
    @ReportItem(name = "cover_yubinNo", length = 8, order = 172)
    public RString cover_yubinNo;
    @ReportItem(name = "cover_gyoseiku", length = 14, order = 173)
    public RString cover_gyoseiku;
    @ReportItem(name = "cover_jusho3", length = 20, order = 174)
    public RString cover_jusho3;
    @ReportItem(name = "cover_jushoText", order = 175)
    public RString cover_jushoText;
    @ReportItem(name = "cover_jusho1", length = 20, order = 176)
    public RString cover_jusho1;
    @ReportItem(name = "cover_jusho2", length = 20, order = 177)
    public RString cover_jusho2;
    @ReportItem(name = "cover_katagakiText", order = 178)
    public RString cover_katagakiText;
    @ReportItem(name = "cover_katagaki2", length = 20, order = 179)
    public RString cover_katagaki2;
    @ReportItem(name = "cover_katagakiSmall2", length = 30, order = 180)
    public RString cover_katagakiSmall2;
    @ReportItem(name = "cover_katagaki1", length = 20, order = 181)
    public RString cover_katagaki1;
    @ReportItem(name = "cover_katagakiSmall1", length = 30, order = 182)
    public RString cover_katagakiSmall1;
    @ReportItem(name = "cover_shimei2", length = 20, order = 183)
    public RString cover_shimei2;
    @ReportItem(name = "cover_shimeiSmall2", length = 40, order = 184)
    public RString cover_shimeiSmall2;
    @ReportItem(name = "cover_shimeiText", order = 185)
    public RString cover_shimeiText;
    @ReportItem(name = "cover_meishoFuyo2", length = 3, order = 186)
    public RString cover_meishoFuyo2;
    @ReportItem(name = "cover_shimeiSmall1", length = 40, order = 187)
    public RString cover_shimeiSmall1;
    @ReportItem(name = "cover_dainoKubunMei", length = 8, order = 188)
    public RString cover_dainoKubunMei;
    @ReportItem(name = "cover_shimei1", length = 20, order = 189)
    public RString cover_shimei1;
    @ReportItem(name = "cover_meishoFuyo1", length = 3, order = 190)
    public RString cover_meishoFuyo1;
    @ReportItem(name = "cover_samabunShimeiText", order = 191)
    public RString cover_samabunShimeiText;
    @ReportItem(name = "cover_samaBun2", length = 3, order = 192)
    public RString cover_samaBun2;
    @ReportItem(name = "cover_samabunShimeiSmall2", length = 40, order = 193)
    public RString cover_samabunShimeiSmall2;
    @ReportItem(name = "cover_kakkoRight2", length = 1, order = 194)
    public RString cover_kakkoRight2;
    @ReportItem(name = "cover_kakkoLeft2", length = 1, order = 195)
    public RString cover_kakkoLeft2;
    @ReportItem(name = "cover_samabunShimei2", length = 20, order = 196)
    public RString cover_samabunShimei2;
    @ReportItem(name = "cover_kakkoRight1", length = 1, order = 197)
    public RString cover_kakkoRight1;
    @ReportItem(name = "cover_kakkoLeft1", length = 1, order = 198)
    public RString cover_kakkoLeft1;
    @ReportItem(name = "cover_samabunShimei1", length = 20, order = 199)
    public RString cover_samabunShimei1;
    @ReportItem(name = "cover_samaBun1", length = 3, order = 200)
    public RString cover_samaBun1;
    @ReportItem(name = "cover_samabunShimeiSmall1", length = 40, order = 201)
    public RString cover_samabunShimeiSmall1;
    @ReportItem(name = "cover_customerBarCode", order = 202)
    public RString cover_customerBarCode;
    @ReportItem(name = "cover_denshiKoin", order = 203)
    public RString cover_denshiKoin;
    @ReportItem(name = "cover_hakkoYMD", length = 12, order = 204)
    public RString cover_hakkoYMD;
    @ReportItem(name = "cover_ninshoshaYakushokuMei", length = 15, order = 205)
    public RString cover_ninshoshaYakushokuMei;
    @ReportItem(name = "cover_ninshoshaYakushokuMei1", order = 206)
    public RString cover_ninshoshaYakushokuMei1;
    @ReportItem(name = "cover_koinMojiretsu", length = 4, order = 207)
    public RString cover_koinMojiretsu;
    @ReportItem(name = "cover_ninshoshaYakushokuMei2", order = 208)
    public RString cover_ninshoshaYakushokuMei2;
    @ReportItem(name = "cover_ninshoshaShimeiKakenai", order = 209)
    public RString cover_ninshoshaShimeiKakenai;
    @ReportItem(name = "cover_ninshoshaShimeiKakeru", order = 210)
    public RString cover_ninshoshaShimeiKakeru;
    @ReportItem(name = "cover_koinShoryaku", length = 15, order = 211)
    public RString cover_koinShoryaku;

    //納付書
    @ReportItem(name = "nofuzumishoTitleNendoBun1", length = 9, order = 301)
    public RString nofuzumishoTitleNendoBun1;
    @ReportItem(name = "nofuzumishoTitleKi1", length = 2, order = 302)
    public RString nofuzumishoTitleKi1;
    @ReportItem(name = "nofuzumishoTitleTsuki1", length = 2, order = 303)
    public RString nofuzumishoTitleTsuki1;
    @ReportItem(name = "nofozumishoTitleNendo1", length = 6, order = 304)
    public RString nofozumishoTitleNendo1;
    @ReportItem(name = "nofozumishoTitleNendo2", length = 6, order = 305)
    public RString nofozumishoTitleNendo2;
    @ReportItem(name = "nofuzumishoTitleNendoBun2", length = 9, order = 306)
    public RString nofuzumishoTitleNendoBun2;
    @ReportItem(name = "nofuzumishoTitleKi2", length = 2, order = 307)
    public RString nofuzumishoTitleKi2;
    @ReportItem(name = "nofuzumishoTitleTsuki2", length = 2, order = 308)
    public RString nofuzumishoTitleTsuki2;
    @ReportItem(name = "ryoshushoTitleNendo2", length = 6, order = 309)
    public RString ryoshushoTitleNendo2;
    @ReportItem(name = "ryoshushoTitleKi2", length = 2, order = 310)
    public RString ryoshushoTitleKi2;
    @ReportItem(name = "ryoshushoTitleTsuki2", length = 2, order = 311)
    public RString ryoshushoTitleTsuki2;
    @ReportItem(name = "nofushoTitleNendo2", length = 6, order = 312)
    public RString nofushoTitleNendo2;
    @ReportItem(name = "nofushoTitleKi2", length = 2, order = 313)
    public RString nofushoTitleKi2;
    @ReportItem(name = "nofushoTitleTsuki2", length = 2, order = 314)
    public RString nofushoTitleTsuki2;
    @ReportItem(name = "ryoshushoTitleNendo1", length = 6, order = 315)
    public RString ryoshushoTitleNendo1;
    @ReportItem(name = "ryoshushoTitleKi1", length = 2, order = 316)
    public RString ryoshushoTitleKi1;
    @ReportItem(name = "ryoshushoTitleTsuki1", length = 2, order = 317)
    public RString ryoshushoTitleTsuki1;
    @ReportItem(name = "nofushoTitleNendo1", length = 6, order = 318)
    public RString nofushoTitleNendo1;
    @ReportItem(name = "nofushoTitleKi1", length = 2, order = 319)
    public RString nofushoTitleKi1;
    @ReportItem(name = "nofushoTitleTsuki1", length = 2, order = 320)
    public RString nofushoTitleTsuki1;
    @ReportItem(name = "listList1_1", length = 1, order = 321)
    public RString listList1_1;
    @ReportItem(name = "ryoshushoJusho1", order = 322)
    public RString ryoshushoJusho1;
    @ReportItem(name = "ryoshushoJusho2", order = 323)
    public RString ryoshushoJusho2;
    @ReportItem(name = "nofuzumishoTsuchishoNo1", order = 324)
    public RString nofuzumishoTsuchishoNo1;
    @ReportItem(name = "nofuzumishoTsuchishoNo2", order = 325)
    public RString nofuzumishoTsuchishoNo2;
    @ReportItem(name = "nofuzumishoOCR11", length = 19, order = 326)
    public RString nofuzumishoOCR11;
    @ReportItem(name = "nofuzumishoOCR12", length = 19, order = 327)
    public RString nofuzumishoOCR12;
    @ReportItem(name = "ryoshushoKatagaki1", order = 328)
    public RString ryoshushoKatagaki1;
    @ReportItem(name = "ryoshushoKatagaki2", order = 329)
    public RString ryoshushoKatagaki2;
    @ReportItem(name = "nofuzumishoSetaiCode1", length = 15, order = 330)
    public RString nofuzumishoSetaiCode1;
    @ReportItem(name = "nofuzumishoSetaiCode2", length = 15, order = 331)
    public RString nofuzumishoSetaiCode2;
    @ReportItem(name = "nofuzumishoOCR22", length = 20, order = 332)
    public RString nofuzumishoOCR22;
    @ReportItem(name = "nofuzumishoOCR21", length = 20, order = 333)
    public RString nofuzumishoOCR21;
    @ReportItem(name = "ryoshushoHihokenshaName1", order = 334)
    public RString ryoshushoHihokenshaName1;
    @ReportItem(name = "nofushoHihokenshaName1", order = 335)
    public RString nofushoHihokenshaName1;
    @ReportItem(name = "ryoshushoHihokenshaName2", order = 336)
    public RString ryoshushoHihokenshaName2;
    @ReportItem(name = "nofushoHihokenshaName2", order = 337)
    public RString nofushoHihokenshaName2;
    @ReportItem(name = "nofuzumishoOCR31", length = 12, order = 338)
    public RString nofuzumishoOCR31;
    @ReportItem(name = "nofuzumishoNokigen1", length = 11, order = 339)
    public RString nofuzumishoNokigen1;
    @ReportItem(name = "nofuzumishoNokigen2", length = 11, order = 340)
    public RString nofuzumishoNokigen2;
    @ReportItem(name = "nofuzumishoOCR32", length = 12, order = 341)
    public RString nofuzumishoOCR32;
    @ReportItem(name = "ryoshushoTsuchishoNo1", order = 342)
    public RString ryoshushoTsuchishoNo1;
    @ReportItem(name = "nofushoTsuchishoNo1", order = 343)
    public RString nofushoTsuchishoNo1;
    @ReportItem(name = "ryoshushoTsuchishoNo2", order = 344)
    public RString ryoshushoTsuchishoNo2;
    @ReportItem(name = "nofushoTsuchishoNo2", order = 345)
    public RString nofushoTsuchishoNo2;
    @ReportItem(name = "ryoshushoHokenryoGaku1", length = 10, order = 346)
    public RString ryoshushoHokenryoGaku1;
    @ReportItem(name = "nofushoHokenryoGaku1", length = 10, order = 347)
    public RString nofushoHokenryoGaku1;
    @ReportItem(name = "ryoshushoHokenryoGaku2", length = 10, order = 348)
    public RString ryoshushoHokenryoGaku2;
    @ReportItem(name = "nofushoHokenryoGaku2", length = 10, order = 349)
    public RString nofushoHokenryoGaku2;
    @ReportItem(name = "nofuzumishoNofuGaku1", length = 10, order = 350)
    public RString nofuzumishoNofuGaku1;
    @ReportItem(name = "nofuzumishoNofuGaku2", length = 10, order = 351)
    public RString nofuzumishoNofuGaku2;
    @ReportItem(name = "ryoshushoNokigen1", length = 11, order = 352)
    public RString ryoshushoNokigen1;
    @ReportItem(name = "nofushoNokigen1", length = 11, order = 353)
    public RString nofushoNokigen1;
    @ReportItem(name = "ryoshushoNokigen2", length = 11, order = 354)
    public RString ryoshushoNokigen2;
    @ReportItem(name = "nofushoNokigen2", length = 11, order = 355)
    public RString nofushoNokigen2;
    @ReportItem(name = "nofuzumishoJusho1", order = 356)
    public RString nofuzumishoJusho1;
    @ReportItem(name = "nofuzumishoJusho2", order = 357)
    public RString nofuzumishoJusho2;
    @ReportItem(name = "nofuzumishoKatagaki1", length = 30, order = 358)
    public RString nofuzumishoKatagaki1;
    @ReportItem(name = "nofuzumishoKatagaki2", length = 30, order = 359)
    public RString nofuzumishoKatagaki2;
    @ReportItem(name = "ryoshushoNofuIn1", length = 2, order = 360)
    public RString ryoshushoNofuIn1;
    @ReportItem(name = "nofushoNofuIn1", length = 2, order = 361)
    public RString nofushoNofuIn1;
    @ReportItem(name = "nofuzumishoNofuIn1", length = 2, order = 362)
    public RString nofuzumishoNofuIn1;
    @ReportItem(name = "ryoshushoNofuIn2", length = 2, order = 363)
    public RString ryoshushoNofuIn2;
    @ReportItem(name = "nofushoNofuIn2", length = 2, order = 364)
    public RString nofushoNofuIn2;
    @ReportItem(name = "nofuzumishoNofuIn2", length = 2, order = 365)
    public RString nofuzumishoNofuIn2;
    @ReportItem(name = "ryoshushoKozaCom1", length = 4, order = 366)
    public RString ryoshushoKozaCom1;
    @ReportItem(name = "nofushoKozaCom1", length = 4, order = 367)
    public RString nofushoKozaCom1;
    @ReportItem(name = "nofuzumishoHihokenshaName1", order = 368)
    public RString nofuzumishoHihokenshaName1;
    @ReportItem(name = "nofuzumishoKozaCom1", length = 4, order = 369)
    public RString nofuzumishoKozaCom1;
    @ReportItem(name = "ryoshushoKozaCom2", length = 4, order = 370)
    public RString ryoshushoKozaCom2;
    @ReportItem(name = "nofushoKozaCom2", length = 4, order = 371)
    public RString nofushoKozaCom2;
    @ReportItem(name = "nofuzumishoHihokenshaName2", order = 372)
    public RString nofuzumishoHihokenshaName2;
    @ReportItem(name = "nofuzumishoKozaCom2", length = 4, order = 373)
    public RString nofuzumishoKozaCom2;
    @ReportItem(name = "ryoshushoZuiji1", length = 2, order = 374)
    public RString ryoshushoZuiji1;
    @ReportItem(name = "nofushoZuiji1", length = 2, order = 375)
    public RString nofushoZuiji1;
    @ReportItem(name = "nofuzumishoZuiji1", length = 2, order = 376)
    public RString nofuzumishoZuiji1;
    @ReportItem(name = "ryoshushoZuiji2", length = 2, order = 377)
    public RString ryoshushoZuiji2;
    @ReportItem(name = "nofushoZuiji2", length = 2, order = 378)
    public RString nofushoZuiji2;
    @ReportItem(name = "nofuzumishoZuiji2", length = 2, order = 379)
    public RString nofuzumishoZuiji2;
    @ReportItem(name = "nofuzumishoshichosonName1", order = 380)
    public RString nofuzumishoshichosonName1;
    @ReportItem(name = "pagerenban1", length = 10, order = 381)
    public RString pagerenban1;
    @ReportItem(name = "nofuzumishoshichosonName2", order = 382)
    public RString nofuzumishoshichosonName2;
    @ReportItem(name = "pagerenban2", length = 10, order = 383)
    public RString pagerenban2;
    @ReportItem(name = "nofozumishoTitleNendo3", length = 6, order = 384)
    public RString nofozumishoTitleNendo3;
    @ReportItem(name = "nofuzumishoTitleNendoBun3", length = 9, order = 385)
    public RString nofuzumishoTitleNendoBun3;
    @ReportItem(name = "nofuzumishoTitleKi3", length = 2, order = 386)
    public RString nofuzumishoTitleKi3;
    @ReportItem(name = "nofuzumishoTitleTsuki3", length = 2, order = 387)
    public RString nofuzumishoTitleTsuki3;
    @ReportItem(name = "nofozumishoTitleNendo4", length = 6, order = 388)
    public RString nofozumishoTitleNendo4;
    @ReportItem(name = "nofuzumishoTitleNendoBun4", length = 9, order = 389)
    public RString nofuzumishoTitleNendoBun4;
    @ReportItem(name = "nofuzumishoTitleKi4", length = 2, order = 390)
    public RString nofuzumishoTitleKi4;
    @ReportItem(name = "nofuzumishoTitleTsuki4", length = 2, order = 391)
    public RString nofuzumishoTitleTsuki4;
    @ReportItem(name = "ryoshushoTitleNendo3", length = 6, order = 392)
    public RString ryoshushoTitleNendo3;
    @ReportItem(name = "ryoshushoTitleKi3", length = 2, order = 393)
    public RString ryoshushoTitleKi3;
    @ReportItem(name = "ryoshushoTitleTsuki3", length = 2, order = 394)
    public RString ryoshushoTitleTsuki3;
    @ReportItem(name = "nofushoTitleNendo3", length = 6, order = 395)
    public RString nofushoTitleNendo3;
    @ReportItem(name = "nofushoTitleKi3", length = 2, order = 396)
    public RString nofushoTitleKi3;
    @ReportItem(name = "nofushoTitleTsuki3", length = 2, order = 397)
    public RString nofushoTitleTsuki3;
    @ReportItem(name = "ryoshushoTitleNendo4", length = 6, order = 398)
    public RString ryoshushoTitleNendo4;
    @ReportItem(name = "ryoshushoTitleKi4", length = 2, order = 399)
    public RString ryoshushoTitleKi4;
    @ReportItem(name = "ryoshushoTitleTsuki4", length = 2, order = 400)
    public RString ryoshushoTitleTsuki4;
    @ReportItem(name = "nofushoTitleNendo4", length = 6, order = 401)
    public RString nofushoTitleNendo4;
    @ReportItem(name = "nofushoTitleKi4", length = 2, order = 402)
    public RString nofushoTitleKi4;
    @ReportItem(name = "nofushoTitleTsuki4", length = 2, order = 403)
    public RString nofushoTitleTsuki4;
    @ReportItem(name = "ryoshushoJusho3", order = 404)
    public RString ryoshushoJusho3;
    @ReportItem(name = "ryoshushoJusho4", order = 405)
    public RString ryoshushoJusho4;
    @ReportItem(name = "nofuzumishoTsuchishoNo3", order = 406)
    public RString nofuzumishoTsuchishoNo3;
    @ReportItem(name = "nofuzumishoTsuchishoNo4", order = 407)
    public RString nofuzumishoTsuchishoNo4;
    @ReportItem(name = "nofuzumishoOCR13", length = 19, order = 408)
    public RString nofuzumishoOCR13;
    @ReportItem(name = "nofuzumishoOCR14", length = 19, order = 409)
    public RString nofuzumishoOCR14;
    @ReportItem(name = "ryoshushoKatagaki3", order = 410)
    public RString ryoshushoKatagaki3;
    @ReportItem(name = "ryoshushoKatagaki4", order = 411)
    public RString ryoshushoKatagaki4;
    @ReportItem(name = "nofuzumishoSetaiCode3", length = 15, order = 412)
    public RString nofuzumishoSetaiCode3;
    @ReportItem(name = "nofuzumishoSetaiCode4", length = 15, order = 413)
    public RString nofuzumishoSetaiCode4;
    @ReportItem(name = "nofuzumishoOCR23", length = 20, order = 414)
    public RString nofuzumishoOCR23;
    @ReportItem(name = "nofuzumishoOCR24", length = 20, order = 415)
    public RString nofuzumishoOCR24;
    @ReportItem(name = "ryoshushoHihokenshaName3", order = 416)
    public RString ryoshushoHihokenshaName3;
    @ReportItem(name = "nofushoHihokenshaName3", order = 417)
    public RString nofushoHihokenshaName3;
    @ReportItem(name = "ryoshushoHihokenshaName4", order = 418)
    public RString ryoshushoHihokenshaName4;
    @ReportItem(name = "nofushoHihokenshaName4", order = 419)
    public RString nofushoHihokenshaName4;
    @ReportItem(name = "nofuzumishoNokigen3", length = 11, order = 420)
    public RString nofuzumishoNokigen3;
    @ReportItem(name = "nofuzumishoNokigen4", length = 11, order = 421)
    public RString nofuzumishoNokigen4;
    @ReportItem(name = "nofuzumishoOCR33", length = 12, order = 422)
    public RString nofuzumishoOCR33;
    @ReportItem(name = "nofuzumishoOCR34", length = 12, order = 423)
    public RString nofuzumishoOCR34;
    @ReportItem(name = "ryoshushoTsuchishoNo3", order = 424)
    public RString ryoshushoTsuchishoNo3;
    @ReportItem(name = "nofushoTsuchishoNo3", order = 425)
    public RString nofushoTsuchishoNo3;
    @ReportItem(name = "ryoshushoTsuchishoNo4", order = 426)
    public RString ryoshushoTsuchishoNo4;
    @ReportItem(name = "nofushoTsuchishoNo4", order = 427)
    public RString nofushoTsuchishoNo4;
    @ReportItem(name = "ryoshushoHokenryoGaku3", length = 10, order = 428)
    public RString ryoshushoHokenryoGaku3;
    @ReportItem(name = "nofushoHokenryoGaku3", length = 10, order = 429)
    public RString nofushoHokenryoGaku3;
    @ReportItem(name = "ryoshushoHokenryoGaku4", length = 10, order = 430)
    public RString ryoshushoHokenryoGaku4;
    @ReportItem(name = "nofushoHokenryoGaku4", length = 10, order = 431)
    public RString nofushoHokenryoGaku4;
    @ReportItem(name = "nofuzumishoNofuGaku3", length = 10, order = 432)
    public RString nofuzumishoNofuGaku3;
    @ReportItem(name = "nofuzumishoNofuGaku4", length = 10, order = 433)
    public RString nofuzumishoNofuGaku4;
    @ReportItem(name = "ryoshushoNokigen3", length = 11, order = 434)
    public RString ryoshushoNokigen3;
    @ReportItem(name = "nofushoNokigen3", length = 11, order = 435)
    public RString nofushoNokigen3;
    @ReportItem(name = "ryoshushoNokigen4", length = 11, order = 436)
    public RString ryoshushoNokigen4;
    @ReportItem(name = "nofushoNokigen4", length = 11, order = 437)
    public RString nofushoNokigen4;
    @ReportItem(name = "nofuzumishoJusho3", order = 438)
    public RString nofuzumishoJusho3;
    @ReportItem(name = "nofuzumishoJusho4", order = 439)
    public RString nofuzumishoJusho4;
    @ReportItem(name = "nofuzumishoKatagaki3", length = 30, order = 440)
    public RString nofuzumishoKatagaki3;
    @ReportItem(name = "nofuzumishoKatagaki4", length = 30, order = 441)
    public RString nofuzumishoKatagaki4;
    @ReportItem(name = "ryoshushoNofuIn3", length = 2, order = 442)
    public RString ryoshushoNofuIn3;
    @ReportItem(name = "nofushoNofuIn3", length = 2, order = 443)
    public RString nofushoNofuIn3;
    @ReportItem(name = "nofuzumishoNofuIn3", length = 2, order = 444)
    public RString nofuzumishoNofuIn3;
    @ReportItem(name = "ryoshushoNofuIn4", length = 2, order = 445)
    public RString ryoshushoNofuIn4;
    @ReportItem(name = "nofushoNofuIn4", length = 2, order = 446)
    public RString nofushoNofuIn4;
    @ReportItem(name = "nofuzumishoNofuIn4", length = 2, order = 447)
    public RString nofuzumishoNofuIn4;
    @ReportItem(name = "ryoshushoKozaCom3", length = 4, order = 448)
    public RString ryoshushoKozaCom3;
    @ReportItem(name = "nofushoKozaCom3", length = 4, order = 449)
    public RString nofushoKozaCom3;
    @ReportItem(name = "nofuzumishoHihokenshaName3", order = 450)
    public RString nofuzumishoHihokenshaName3;
    @ReportItem(name = "nofuzumishoKozaCom3", length = 4, order = 451)
    public RString nofuzumishoKozaCom3;
    @ReportItem(name = "ryoshushoKozaCom4", length = 4, order = 452)
    public RString ryoshushoKozaCom4;
    @ReportItem(name = "nofushoKozaCom4", length = 4, order = 453)
    public RString nofushoKozaCom4;
    @ReportItem(name = "nofuzumishoHihokenshaName4", order = 454)
    public RString nofuzumishoHihokenshaName4;
    @ReportItem(name = "nofuzumishoKozaCom4", length = 4, order = 455)
    public RString nofuzumishoKozaCom4;
    @ReportItem(name = "ryoshushoZuiji3", length = 2, order = 456)
    public RString ryoshushoZuiji3;
    @ReportItem(name = "nofushoZuiji3", length = 2, order = 457)
    public RString nofushoZuiji3;
    @ReportItem(name = "nofuzumishoZuiji3", length = 2, order = 458)
    public RString nofuzumishoZuiji3;
    @ReportItem(name = "ryoshushoZuiji4", length = 2, order = 459)
    public RString ryoshushoZuiji4;
    @ReportItem(name = "nofushoZuiji4", length = 2, order = 460)
    public RString nofushoZuiji4;
    @ReportItem(name = "nofuzumishoZuiji4", length = 2, order = 461)
    public RString nofuzumishoZuiji4;
    @ReportItem(name = "nofuzumishoshichosonName3", order = 462)
    public RString nofuzumishoshichosonName3;
    @ReportItem(name = "nofuzumishoshichosonName4", order = 463)
    public RString nofuzumishoshichosonName4;
    @ReportItem(name = "pagerenban3", length = 10, order = 464)
    public RString pagerenban3;
    @ReportItem(name = "pagerenban4", length = 10, order = 465)
    public RString pagerenban4;

    @ReportItem(name = "layoutBreakItem", length = 10, order = 999)
    public int layoutBreakItem;
    public static final RString LAYOUTBREAKITEM;

    static {
        LAYOUTBREAKITEM = new RString("layoutBreakItem");
    }

}
