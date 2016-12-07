/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.iinshinsakaishiryoa4;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.report.saichekkuhyo.Layouts;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 委員審査会資料組み合わせ一覧A4のReportSourceです。
 *
 * @reamsid_L DBE-0150-200 lishengli
 */
public class IinShinsakaishiryoA4ReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    //DBE517011
    @ReportItem(name = "shinsakaiNo", length = 4, order = 1)
    public RString shinsakaiNo;
    @ReportItem(name = "shinsakaiKaisaiYMD", length = 21, order = 2)
    public RString shinsakaiKaisaiYMD;
    @ReportItem(name = "ShinsainName1", length = 20, order = 3)
    public RString shinsainName1;
    @ReportItem(name = "ShinsainName2", length = 20, order = 4)
    public RString shinsainName2;
    @ReportItem(name = "gogitaiNo", length = 2, order = 5)
    public RString gogitaiNo;
    @ReportItem(name = "ShinsainName3", length = 20, order = 6)
    public RString shinsainName3;
    @ReportItem(name = "shinsaTaishoshaCount", length = 2, order = 7)
    public RString shinsaTaishoshaCount;
    @ReportItem(name = "ShinsainName4", length = 20, order = 8)
    public RString shinsainName4;
    @ReportItem(name = "ShinsainName5", length = 20, order = 9)
    public RString shinsainName5;
    @ReportItem(name = "ShinsainName6", length = 20, order = 10)
    public RString shinsainName6;
    @ReportItem(name = "ShinsainName7", length = 20, order = 11)
    public RString shinsainName7;
    @ReportItem(name = "ShinsainName8", length = 20, order = 12)
    public RString shinsainName8;
    @ReportItem(name = "listShinsei_1", length = 2, order = 13)
    public RString listShinsei_1;
    @ReportItem(name = "listShinsei_2", length = 6, order = 14)
    public RString listShinsei_2;
    @ReportItem(name = "listShinsei_3", length = 10, order = 15)
    public RString listShinsei_3;
    @ReportItem(name = "listShinsei_4", length = 30, order = 16)
    public RString listShinsei_4;
    @ReportItem(name = "listShinsei_5", length = 1, order = 17)
    public RString listShinsei_5;
    @ReportItem(name = "listShinsei_6", length = 3, order = 18)
    public RString listShinsei_6;
    @ReportItem(name = "listShinsei_7", length = 3, order = 19)
    public RString listShinsei_7;
    @ReportItem(name = "listShinsei_8", length = 4, order = 20)
    public RString listShinsei_8;
    @ReportItem(name = "listShinsei_9", length = 7, order = 21)
    public RString listShinsei_9;
    @ReportItem(name = "listShinsei_10", length = 1, order = 22)
    public RString listShinsei_10;
    @ReportItem(name = "listShinsei_11", length = 5, order = 23)
    public RString listShinsei_11;
    @ReportItem(name = "listShinsei_12", length = 3, order = 24)
    public RString listShinsei_12;
    @ReportItem(name = "listShinsei_13", length = 4, order = 25)
    public RString listShinsei_13;

    //DBE517038
    @ReportItem(name = "sakuseiGengo", length = 2, order = 26)
    public RString sakuseiGengo;
    @ReportItem(name = "sakuseiYY", length = 2, order = 27)
    public RString sakuseiYY;
    @ReportItem(name = "sakuseiMM", length = 2, order = 28)
    public RString sakuseiMM;
    @ReportItem(name = "sakuseiDD", length = 2, order = 29)
    public RString sakuseiDD;
    @ReportItem(name = "title", length = 20, order = 30)
    public RString title;
    @ReportItem(name = "shinseiGengo", length = 2, order = 31)
    public RString shinseiGengo;
    @ReportItem(name = "shinseiYY", length = 2, order = 32)
    public RString shinseiYY;
    @ReportItem(name = "shinseiMM", length = 2, order = 33)
    public RString shinseiMM;
    @ReportItem(name = "shinseiDD", length = 2, order = 34)
    public RString shinseiDD;
    @ReportItem(name = "chosaGengo", length = 2, order = 35)
    public RString chosaGengo;
    @ReportItem(name = "chosaYY", length = 2, order = 36)
    public RString chosaYY;
    @ReportItem(name = "chosaMM", length = 2, order = 37)
    public RString chosaMM;
    @ReportItem(name = "chosaDD", length = 2, order = 38)
    public RString chosaDD;
    @ReportItem(name = "shinsaGengo", length = 2, order = 39)
    public RString shinsaGengo;
    @ReportItem(name = "shinsaYY", length = 2, order = 40)
    public RString shinsaYY;
    @ReportItem(name = "shinsaMM", length = 2, order = 41)
    public RString shinsaMM;
    @ReportItem(name = "shinsaDD", length = 2, order = 42)
    public RString shinsaDD;
    @ReportItem(name = "shisetsuriyo", length = 20, order = 43)
    public RString shisetsuriyo;
    @ReportItem(name = "age", length = 5, order = 44)
    public RString age;
    @ReportItem(name = "seibetsu", length = 1, order = 45)
    public RString seibetsu;
    @ReportItem(name = "zenZenkaiNijihanteikekka", length = 4, order = 46)
    public RString zenZenkaiNijihanteikekka;
    @ReportItem(name = "zenzenkaiYukokikan", length = 4, order = 47)
    public RString zenzenkaiYukokikan;
    @ReportItem(name = "zZenkaiNijiKaishiYMD", length = 9, order = 48)
    public RString zZenkaiNijiKaishiYMD;
    @ReportItem(name = "zZenkaiNijishuryoYMD", length = 9, order = 49)
    public RString zZenkaiNijishuryoYMD;
    @ReportItem(name = "shinseiCount", length = 2, order = 51)
    public RString shinseiCount;
    @ReportItem(name = "zenkaiNijihanteikekka", length = 4, order = 52)
    public RString zenkaiNijihanteikekka;
    @ReportItem(name = "zenkaiYukokikan", length = 4, order = 53)
    public RString zenkaiYukokikan;
    @ReportItem(name = "zenkaiNijiKaishiYMD", length = 9, order = 54)
    public RString zenkaiNijiKaishiYMD;
    @ReportItem(name = "zenkaiNijishuryoYMD", length = 9, order = 55)
    public RString zenkaiNijishuryoYMD;
    @ReportItem(name = "hihokenshaKubun", length = 7, order = 56)
    public RString hihokenshaKubun;
    @ReportItem(name = "zenkaiNijihanteiDATE", length = 10, order = 57)
    public RString zenkaiNijihanteiDATE;
    @ReportItem(name = "zenkaiJotaizo", length = 10, order = 58)
    public RString zenkaiJotaizo;
    @ReportItem(name = "kanriNo", length = 20, order = 59)
    public RString kanriNo;
    @ReportItem(name = "shinseiKubun", length = 13, order = 60)
    public RString shinseiKubun;
    @ReportItem(name = "ichijiHanteiKekka", length = 12, order = 61)
    public RString ichijiHanteiKekka;
    @ReportItem(name = "listtokki1_1", length = 1, order = 62)
    public RString listtokki1_1;
    @ReportItem(name = "listIchigun_1", length = 22, order = 63)
    public RString listIchigun_1;
    @ReportItem(name = "listIchigun_2", length = 1, order = 64)
    public RString listIchigun_2;
    @ReportItem(name = "listIchigun_3", length = 1, order = 65)
    public RString listIchigun_3;
    @ReportItem(name = "listIchigun_4", length = 22, order = 66)
    public RString listIchigun_4;
    @ReportItem(name = "kijunGokeiTime", length = 30, order = 67)
    public RString kijunGokeiTime;
    @ReportItem(name = "gurafuKijunTime", order = 68)
    public RString gurafuKijunTime;
    @ReportItem(name = "listtokki2_1", length = 1, order = 69)
    public RString listtokki2_1;
    @ReportItem(name = "listNigun_1", length = 22, order = 70)
    public RString listNigun_1;
    @ReportItem(name = "listNigun_2", length = 1, order = 71)
    public RString listNigun_2;
    @ReportItem(name = "listNigun_3", length = 1, order = 72)
    public RString listNigun_3;
    @ReportItem(name = "listNigun_4", length = 22, order = 73)
    public RString listNigun_4;
    @ReportItem(name = "listkijunTime_1", length = 7, order = 74)
    public RString listkijunTime_1;
    @ReportItem(name = "listkijunTime_2", length = 7, order = 75)
    public RString listkijunTime_2;
    @ReportItem(name = "listkijunTime_3", length = 7, order = 76)
    public RString listkijunTime_3;
    @ReportItem(name = "listkijunTime_4", length = 7, order = 77)
    public RString listkijunTime_4;
    @ReportItem(name = "listkijunTime_5", length = 7, order = 78)
    public RString listkijunTime_5;
    @ReportItem(name = "listkijunTime_6", length = 7, order = 79)
    public RString listkijunTime_6;
    @ReportItem(name = "listkijunTime_7", length = 7, order = 80)
    public RString listkijunTime_7;
    @ReportItem(name = "listkijunTime_8", length = 7, order = 81)
    public RString listkijunTime_8;
    @ReportItem(name = "listkijunTime_9", length = 7, order = 82)
    public RString listkijunTime_9;
    @ReportItem(name = "tokuteishippeiName", length = 40, order = 83)
    public RString tokuteishippeiName;
    @ReportItem(name = "keikokuNo", length = 120, order = 84)
    public RString keikokuNo;
    @ReportItem(name = "listChukanhyoka_1", length = 5, order = 85)
    public RString listChukanhyoka_1;
    @ReportItem(name = "listChukanhyoka_2", length = 5, order = 86)
    public RString listChukanhyoka_2;
    @ReportItem(name = "listChukanhyoka_3", length = 5, order = 87)
    public RString listChukanhyoka_3;
    @ReportItem(name = "listChukanhyoka_4", length = 5, order = 88)
    public RString listChukanhyoka_4;
    @ReportItem(name = "listChukanhyoka_5", length = 5, order = 89)
    public RString listChukanhyoka_5;
    @ReportItem(name = "listtokki3_1", length = 1, order = 90)
    public RString listtokki3_1;
    @ReportItem(name = "listSangun_1", length = 22, order = 91)
    public RString listSangun_1;
    @ReportItem(name = "listSangun_2", length = 1, order = 92)
    public RString listSangun_2;
    @ReportItem(name = "listSangun_3", length = 1, order = 93)
    public RString listSangun_3;
    @ReportItem(name = "listSangun_4", length = 22, order = 94)
    public RString listSangun_4;
    @ReportItem(name = "ｌistNichijoseikatsujiritsudo_1", length = 2, order = 95)
    public RString ｌistNichijoseikatsujiritsudo_1;
    @ReportItem(name = "listtokki8_1", length = 1, order = 96)
    public RString listtokki8_1;
    @ReportItem(name = "chosaNinchishoJiritsudo", length = 2, order = 97)
    public RString chosaNinchishoJiritsudo;
    @ReportItem(name = "ikenNinchishoJiritsudo", length = 2, order = 98)
    public RString ikenNinchishoJiritsudo;
    @ReportItem(name = "manzensei", length = 6, order = 99)
    public RString manzensei;
    @ReportItem(name = "jotainoanteisei", length = 4, order = 100)
    public RString jotainoanteisei;
    @ReportItem(name = "kyufukubun", length = 4, order = 101)
    public RString kyufukubun;
    @ReportItem(name = "listtokki4_1", length = 1, order = 102)
    public RString listtokki4_1;
    @ReportItem(name = "listYongun_1", length = 22, order = 103)
    public RString listYongun_1;
    @ReportItem(name = "listYongun_2", length = 1, order = 104)
    public RString listYongun_2;
    @ReportItem(name = "listYongun_3", length = 1, order = 105)
    public RString listYongun_3;
    @ReportItem(name = "listYongun_4", length = 22, order = 106)
    public RString listYongun_4;
    @ReportItem(name = "sabisuKubun", length = 15, order = 107)
    public RString sabisuKubun;
    @ReportItem(name = "sabisuName1", order = 108)
    public RString sabisuName1;
    @ReportItem(name = "sabisuKaisu1", length = 11, order = 109)
    public RString sabisuKaisu1;
    @ReportItem(name = "sabisuName2", order = 110)
    public RString sabisuName2;
    @ReportItem(name = "sabisuKaisu2", length = 11, order = 111)
    public RString sabisuKaisu2;
    @ReportItem(name = "sabisuName3", order = 112)
    public RString sabisuName3;
    @ReportItem(name = "sabisuKaisu3", length = 11, order = 113)
    public RString sabisuKaisu3;
    @ReportItem(name = "sabisuName4", order = 114)
    public RString sabisuName4;
    @ReportItem(name = "sabisuKaisu4", length = 11, order = 115)
    public RString sabisuKaisu4;
    @ReportItem(name = "sabisuName5", order = 116)
    public RString sabisuName5;
    @ReportItem(name = "sabisuKaisu5", length = 11, order = 117)
    public RString sabisuKaisu5;
    @ReportItem(name = "sabisuName6", order = 118)
    public RString sabisuName6;
    @ReportItem(name = "sabisuKaisu6", length = 11, order = 119)
    public RString sabisuKaisu6;
    @ReportItem(name = "sabisuName7", order = 120)
    public RString sabisuName7;
    @ReportItem(name = "sabisuKaisu7", length = 11, order = 121)
    public RString sabisuKaisu7;
    @ReportItem(name = "sabisuName8", order = 122)
    public RString sabisuName8;
    @ReportItem(name = "sabisuKaisu8", length = 11, order = 123)
    public RString sabisuKaisu8;
    @ReportItem(name = "sabisuName9", order = 124)
    public RString sabisuName9;
    @ReportItem(name = "sabisuKaisu9", length = 11, order = 125)
    public RString sabisuKaisu9;
    @ReportItem(name = "sabisuName10", order = 126)
    public RString sabisuName10;
    @ReportItem(name = "sabisuKaisu10", length = 11, order = 127)
    public RString sabisuKaisu10;
    @ReportItem(name = "sabisuName11", order = 128)
    public RString sabisuName11;
    @ReportItem(name = "sabisuKaisu11", length = 11, order = 129)
    public RString sabisuKaisu11;
    @ReportItem(name = "sabisuName12", order = 130)
    public RString sabisuName12;
    @ReportItem(name = "sabisuKaisu12", length = 11, order = 131)
    public RString sabisuKaisu12;
    @ReportItem(name = "listtokki5_1", length = 1, order = 132)
    public RString listtokki5_1;
    @ReportItem(name = "listGogun_1", length = 22, order = 133)
    public RString listGogun_1;
    @ReportItem(name = "listGogun_2", length = 1, order = 134)
    public RString listGogun_2;
    @ReportItem(name = "listGogun_3", length = 1, order = 135)
    public RString listGogun_3;
    @ReportItem(name = "listGogun_4", length = 22, order = 136)
    public RString listGogun_4;
    @ReportItem(name = "sabisuName13", order = 137)
    public RString sabisuName13;
    @ReportItem(name = "sabisuKaisu13", length = 11, order = 138)
    public RString sabisuKaisu13;
    @ReportItem(name = "sabisuName14", order = 139)
    public RString sabisuName14;
    @ReportItem(name = "sabisuKaisu14", length = 11, order = 140)
    public RString sabisuKaisu14;
    @ReportItem(name = "sabisuName15", order = 141)
    public RString sabisuName15;
    @ReportItem(name = "sabisuKaisu15", length = 11, order = 142)
    public RString sabisuKaisu15;
    @ReportItem(name = "sabisuName16", order = 143)
    public RString sabisuName16;
    @ReportItem(name = "sabisuKaisu16", length = 11, order = 144)
    public RString sabisuKaisu16;
    @ReportItem(name = "sabisuName17", order = 145)
    public RString sabisuName17;
    @ReportItem(name = "sabisuKaisu17", length = 11, order = 146)
    public RString sabisuKaisu17;
    @ReportItem(name = "sabisuName18", order = 147)
    public RString sabisuName18;
    @ReportItem(name = "sabisuKaisu18", length = 11, order = 148)
    public RString sabisuKaisu18;
    @ReportItem(name = "listtokki6_1", length = 1, order = 149)
    public RString listtokki6_1;
    @ReportItem(name = "listtokubetsunaIryo1_1", length = 2, order = 150)
    public RString listtokubetsunaIryo1_1;
    @ReportItem(name = "listtokubetsunaIryo1_2", length = 1, order = 151)
    public RString listtokubetsunaIryo1_2;
    @ReportItem(name = "listtokki7_1", length = 1, order = 152)
    public RString listtokki7_1;
    @ReportItem(name = "listtokubetsunaIryo2_1", length = 2, order = 153)
    public RString listtokubetsunaIryo2_1;
    @ReportItem(name = "listtokubetsunaIryo2_2", length = 1, order = 154)
    public RString listtokubetsunaIryo2_2;
    @ReportItem(name = "sabisuName19", order = 155)
    public RString sabisuName19;
    @ReportItem(name = "sabisuKaisu19", length = 11, order = 156)
    public RString sabisuKaisu19;
    @ReportItem(name = "sabisuName20", order = 157)
    public RString sabisuName20;
    @ReportItem(name = "sabisuKaisu20", length = 11, order = 158)
    public RString sabisuKaisu20;
    @ReportItem(name = "sabisuName21", order = 159)
    public RString sabisuName21;
    @ReportItem(name = "sabisuKaisu21", length = 11, order = 160)
    public RString sabisuKaisu21;

    //DBE517141
    @ReportItem(name = "gaikyotokkiImg", order = 201)
    public RString gaikyotokkiImg;
    @ReportItem(name = "hihokenshaName", length = 30, order = 202)
    public RString hihokenshaName;
    @ReportItem(name = "hokenshaNo", length = 6, order = 203)
    public RString hokenshaNo;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 212)
    public RString hihokenshaNo;
    @ReportItem(name = "gaikyotokkiText", order = 221)
    public RString gaikyotokkiText;

    //DBE517131
    @ReportItem(name = "tokkiImg1", order = 222)
    public RString tokkiImg1;
    @ReportItem(name = "listChosa_1", length = 4, order = 223)
    public RString listChosa_1;
    @ReportItem(name = "tokkiImg2", order = 224)
    public RString tokkiImg2;
    @ReportItem(name = "tokkiImg3", order = 225)
    public RString tokkiImg3;
    @ReportItem(name = "tokkiImg4", order = 226)
    public RString tokkiImg4;
    @ReportItem(name = "tokkiImg5", order = 227)
    public RString tokkiImg5;
    @ReportItem(name = "tokkiImg6", order = 228)
    public RString tokkiImg6;
    @ReportItem(name = "tokkiImg7", order = 229)
    public RString tokkiImg7;
    @ReportItem(name = "tokkiImg8", order = 230)
    public RString tokkiImg8;
    @ReportItem(name = "tokkiImg9", order = 231)
    public RString tokkiImg9;
    @ReportItem(name = "tokkiImg10", order = 232)
    public RString tokkiImg10;
    @ReportItem(name = "tokkiImg11", order = 233)
    public RString tokkiImg11;
    @ReportItem(name = "tokkiImg12", order = 234)
    public RString tokkiImg12;
    @ReportItem(name = "tokkiImg13", order = 235)
    public RString tokkiImg13;
    @ReportItem(name = "tokkiImg14", order = 236)
    public RString tokkiImg14;
    @ReportItem(name = "tokkiImg15", order = 237)
    public RString tokkiImg15;
    @ReportItem(name = "tokkiText1", order = 238)
    public RString tokkiText1;
    @ReportItem(name = "listChosa1_1", length = 4, order = 239)
    public RString listChosa1_1;
    @ReportItem(name = "tokkiText2", order = 240)
    public RString tokkiText2;
    @ReportItem(name = "tokkiText3", order = 241)
    public RString tokkiText3;
    @ReportItem(name = "tokkiText4", order = 242)
    public RString tokkiText4;
    @ReportItem(name = "tokkiText5", order = 243)
    public RString tokkiText5;
    @ReportItem(name = "tokkiText6", order = 244)
    public RString tokkiText6;
    @ReportItem(name = "tokkiText7", order = 245)
    public RString tokkiText7;
    @ReportItem(name = "tokkiText8", order = 246)
    public RString tokkiText8;
    @ReportItem(name = "tokkiText9", order = 247)
    public RString tokkiText9;
    @ReportItem(name = "tokkiText10", order = 248)
    public RString tokkiText10;
    @ReportItem(name = "tokkiText11", order = 249)
    public RString tokkiText11;
    @ReportItem(name = "tokkiText12", order = 250)
    public RString tokkiText12;
    @ReportItem(name = "tokkiText13", order = 251)
    public RString tokkiText13;
    @ReportItem(name = "tokkiText14", order = 252)
    public RString tokkiText14;
    @ReportItem(name = "tokkiText15", order = 253)
    public RString tokkiText15;
    @ReportItem(name = "tokkiImg", order = 254)
    public RString tokkiImg;
    @ReportItem(name = "tokkiText", order = 255)
    public RString tokkiText;

    //DBE517134
    @ReportItem(name = "listChosa_1", length = 4, order = 302)
    public RString listChosa1;

    //DBE517151
    @ReportItem(name = "imgIkensho1", order = 420)
    public RString imgIkensho1;

    //DBE517152
    @ReportItem(name = "imgIkensho2", order = 520)
    public RString imgIkensho2;

    //DBE517016
    @ReportItem(name = "imgSonotashiryo", order = 620)
    public RString imgSonotashiryo;

// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
    @ReportItem(name = "layout", order = 999)
    public Layouts layout;

    /**
     * レイアウトブレイク用キーの一覧です。
     */
    public static final List<RString> LAYOUT_BREAK_KEYS;

    static {
        LAYOUT_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(new RString("layout")));
    }
// </editor-fold>

    /**
     * 改ページ条件のキーです。
     */
    public enum ReportSourceFields {

        tokkiText,
        tokkiImg
    }
}
