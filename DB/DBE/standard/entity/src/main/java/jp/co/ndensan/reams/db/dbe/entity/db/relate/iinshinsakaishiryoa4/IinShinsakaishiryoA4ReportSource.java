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
    @ReportItem(name = "one_shinsakaiNo", length = 4, order = 1)
    public RString one_shinsakaiNo;
    @ReportItem(name = "one_shinsakaiKaisaiYMD", length = 21, order = 2)
    public RString one_shinsakaiKaisaiYMD;
    @ReportItem(name = "one_ShinsainName1", length = 20, order = 3)
    public RString one_shinsainName1;
    @ReportItem(name = "one_ShinsainName2", length = 20, order = 4)
    public RString one_shinsainName2;
    @ReportItem(name = "one_gogitaiNo", length = 2, order = 5)
    public RString one_gogitaiNo;
    @ReportItem(name = "one_ShinsainName3", length = 20, order = 6)
    public RString one_shinsainName3;
    @ReportItem(name = "one_shinsaTaishoshaCount", length = 2, order = 7)
    public RString one_shinsaTaishoshaCount;
    @ReportItem(name = "one_ShinsainName4", length = 20, order = 8)
    public RString one_shinsainName4;
    @ReportItem(name = "one_ShinsainName5", length = 20, order = 9)
    public RString one_shinsainName5;
    @ReportItem(name = "one_ShinsainName6", length = 20, order = 10)
    public RString one_shinsainName6;
    @ReportItem(name = "one_ShinsainName7", length = 20, order = 11)
    public RString one_shinsainName7;
    @ReportItem(name = "one_ShinsainName8", length = 20, order = 12)
    public RString one_shinsainName8;
    @ReportItem(name = "one_listShinsei_1", length = 2, order = 13)
    public RString one_listShinsei_1;
    @ReportItem(name = "one_listShinsei_2", length = 6, order = 14)
    public RString one_listShinsei_2;
    @ReportItem(name = "one_listShinsei_3", length = 10, order = 15)
    public RString one_listShinsei_3;
    @ReportItem(name = "one_listShinsei_4", length = 30, order = 16)
    public RString one_listShinsei_4;
    @ReportItem(name = "one_listShinsei_5", length = 1, order = 17)
    public RString one_listShinsei_5;
    @ReportItem(name = "one_listShinsei_6", length = 3, order = 18)
    public RString one_listShinsei_6;
    @ReportItem(name = "one_listShinsei_7", length = 3, order = 19)
    public RString one_listShinsei_7;
    @ReportItem(name = "one_listShinsei_8", length = 4, order = 20)
    public RString one_listShinsei_8;
    @ReportItem(name = "one_listShinsei_9", length = 7, order = 21)
    public RString one_listShinsei_9;
    @ReportItem(name = "one_listShinsei_10", length = 1, order = 22)
    public RString one_listShinsei_10;
    @ReportItem(name = "one_listShinsei_11", length = 5, order = 23)
    public RString one_listShinsei_11;
    @ReportItem(name = "one_listShinsei_12", length = 3, order = 24)
    public RString one_listShinsei_12;
    @ReportItem(name = "one_listShinsei_13", length = 4, order = 25)
    public RString one_listShinsei_13;

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
    @ReportItem(name = "gogitaiNo", length = 6, order = 50)
    public RString gogitaiNo;
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
    @ReportItem(name = "two_gaikyotokkiImg", order = 201)
    public RString two_gaikyotokkiImg;
    @ReportItem(name = "two_hihokenshaName", length = 30, order = 202)
    public RString two_hihokenshaName;
    @ReportItem(name = "two_hokenshaNo", length = 6, order = 203)
    public RString two_hokenshaNo;
    @ReportItem(name = "two_shinseiYY", length = 2, order = 204)
    public RString two_shinseiYY;
    @ReportItem(name = "two_shinseiMM", length = 2, order = 205)
    public RString two_shinseiMM;
    @ReportItem(name = "two_shinseiDD", length = 2, order = 206)
    public RString two_shinseiDD;
    @ReportItem(name = "two_sakuseiGengo", length = 2, order = 207)
    public RString two_sakuseiGengo;
    @ReportItem(name = "two_chosaGengo", length = 2, order = 208)
    public RString two_chosaGengo;
    @ReportItem(name = "two_sakuseiYY", length = 2, order = 209)
    public RString two_sakuseiYY;
    @ReportItem(name = "two_sakuseiMM", length = 2, order = 210)
    public RString two_sakuseiMM;
    @ReportItem(name = "two_sakuseiDD", length = 2, order = 211)
    public RString two_sakuseiDD;
    @ReportItem(name = "two_hihokenshaNo", length = 10, order = 212)
    public RString two_hihokenshaNo;
    @ReportItem(name = "two_shinseiGengo", length = 2, order = 213)
    public RString two_shinseiGengo;
    @ReportItem(name = "two_shinsaGengo", length = 2, order = 214)
    public RString two_shinsaGengo;
    @ReportItem(name = "two_shinsaYY", length = 2, order = 215)
    public RString two_shinsaYY;
    @ReportItem(name = "two_shinsaMM", length = 2, order = 216)
    public RString two_shinsaMM;
    @ReportItem(name = "two_shinsaDD", length = 2, order = 217)
    public RString two_shinsaDD;
    @ReportItem(name = "two_chosaYY", length = 2, order = 218)
    public RString two_chosaYY;
    @ReportItem(name = "two_chosaMM", length = 2, order = 219)
    public RString two_chosaMM;
    @ReportItem(name = "two_chosaDD", length = 2, order = 220)
    public RString two_chosaDD;
    @ReportItem(name = "two_gaikyotokkiText", order = 221)
    public RString two_gaikyotokkiText;

    //DBE517131
    @ReportItem(name = "two_tokkiImg1", order = 222)
    public RString two_tokkiImg1;
    @ReportItem(name = "two_listChosa_1", length = 4, order = 223)
    public RString two_listChosa_1;
    @ReportItem(name = "two_tokkiImg2", order = 224)
    public RString two_tokkiImg2;
    @ReportItem(name = "two_tokkiImg3", order = 225)
    public RString two_tokkiImg3;
    @ReportItem(name = "two_tokkiImg4", order = 226)
    public RString two_tokkiImg4;
    @ReportItem(name = "two_tokkiImg5", order = 227)
    public RString two_tokkiImg5;
    @ReportItem(name = "two_tokkiImg6", order = 228)
    public RString two_tokkiImg6;
    @ReportItem(name = "two_tokkiImg7", order = 229)
    public RString two_tokkiImg7;
    @ReportItem(name = "two_tokkiImg8", order = 230)
    public RString two_tokkiImg8;
    @ReportItem(name = "two_tokkiImg9", order = 231)
    public RString two_tokkiImg9;
    @ReportItem(name = "two_tokkiImg10", order = 232)
    public RString two_tokkiImg10;
    @ReportItem(name = "two_tokkiImg11", order = 233)
    public RString two_tokkiImg11;
    @ReportItem(name = "two_tokkiImg12", order = 234)
    public RString two_tokkiImg12;
    @ReportItem(name = "two_tokkiImg13", order = 235)
    public RString two_tokkiImg13;
    @ReportItem(name = "two_tokkiImg14", order = 236)
    public RString two_tokkiImg14;
    @ReportItem(name = "two_tokkiImg15", order = 237)
    public RString two_tokkiImg15;
    @ReportItem(name = "two_tokkiText1", order = 238)
    public RString two_tokkiText1;
    @ReportItem(name = "two_listChosa1_1", length = 4, order = 239)
    public RString two_listChosa1_1;
    @ReportItem(name = "two_tokkiText2", order = 240)
    public RString two_tokkiText2;
    @ReportItem(name = "two_tokkiText3", order = 241)
    public RString two_tokkiText3;
    @ReportItem(name = "two_tokkiText4", order = 242)
    public RString two_tokkiText4;
    @ReportItem(name = "two_tokkiText5", order = 243)
    public RString two_tokkiText5;
    @ReportItem(name = "two_tokkiText6", order = 244)
    public RString two_tokkiText6;
    @ReportItem(name = "two_tokkiText7", order = 245)
    public RString two_tokkiText7;
    @ReportItem(name = "two_tokkiText8", order = 246)
    public RString two_tokkiText8;
    @ReportItem(name = "two_tokkiText9", order = 247)
    public RString two_tokkiText9;
    @ReportItem(name = "two_tokkiText10", order = 248)
    public RString two_tokkiText10;
    @ReportItem(name = "two_tokkiText11", order = 249)
    public RString two_tokkiText11;
    @ReportItem(name = "two_tokkiText12", order = 250)
    public RString two_tokkiText12;
    @ReportItem(name = "two_tokkiText13", order = 251)
    public RString two_tokkiText13;
    @ReportItem(name = "two_tokkiText14", order = 252)
    public RString two_tokkiText14;
    @ReportItem(name = "two_tokkiText15", order = 253)
    public RString two_tokkiText15;
    @ReportItem(name = "two_tokkiImg", order = 254)
    public RString two_tokkiImg;
    @ReportItem(name = "two_tokkiText", order = 255)
    public RString two_tokkiText;

    //DBE517134
    @ReportItem(name = "three_tokkiImg1", order = 301)
    public RString three_tokkiImg1;
    @ReportItem(name = "three_listChosa_1", length = 4, order = 302)
    public RString three_listChosa1;
    @ReportItem(name = "three_tokkiImg2", order = 303)
    public RString three_tokkiImg2;
    @ReportItem(name = "three_tokkiImg3", order = 304)
    public RString three_tokkiImg3;
    @ReportItem(name = "three_tokkiImg4", order = 305)
    public RString three_tokkiImg4;
    @ReportItem(name = "three_tokkiImg5", order = 306)
    public RString three_tokkiImg5;
    @ReportItem(name = "three_tokkiImg6", order = 307)
    public RString three_tokkiImg6;
    @ReportItem(name = "three_tokkiImg7", order = 308)
    public RString three_tokkiImg7;
    @ReportItem(name = "three_tokkiImg8", order = 309)
    public RString three_tokkiImg8;
    @ReportItem(name = "three_tokkiImg9", order = 310)
    public RString three_tokkiImg9;
    @ReportItem(name = "three_tokkiImg10", order = 311)
    public RString three_tokkiImg10;
    @ReportItem(name = "three_tokkiImg11", order = 312)
    public RString three_tokkiImg11;
    @ReportItem(name = "three_tokkiImg12", order = 313)
    public RString three_tokkiImg12;
    @ReportItem(name = "three_tokkiImg13", order = 314)
    public RString three_tokkiImg13;
    @ReportItem(name = "three_tokkiImg14", order = 315)
    public RString three_tokkiImg14;
    @ReportItem(name = "three_tokkiImg15", order = 316)
    public RString three_tokkiImg15;
    @ReportItem(name = "three_tokkiText1", order = 317)
    public RString three_tokkiText1;
    @ReportItem(name = "three_listChosa1_1", length = 4, order = 318)
    public RString three_listChosa1_1;
    @ReportItem(name = "three_tokkiText2", order = 319)
    public RString three_tokkiText2;
    @ReportItem(name = "three_tokkiText3", order = 320)
    public RString three_tokkiText3;
    @ReportItem(name = "three_tokkiText4", order = 321)
    public RString three_tokkiText4;
    @ReportItem(name = "three_tokkiText5", order = 322)
    public RString three_tokkiText5;
    @ReportItem(name = "three_tokkiText6", order = 323)
    public RString three_tokkiText6;
    @ReportItem(name = "three_tokkiText7", order = 324)
    public RString three_tokkiText7;
    @ReportItem(name = "three_tokkiText8", order = 325)
    public RString three_tokkiText8;
    @ReportItem(name = "three_tokkiText9", order = 326)
    public RString three_tokkiText9;
    @ReportItem(name = "three_tokkiText10", order = 327)
    public RString three_tokkiText10;
    @ReportItem(name = "three_tokkiText11", order = 328)
    public RString three_tokkiText11;
    @ReportItem(name = "three_tokkiText12", order = 329)
    public RString three_tokkiText12;
    @ReportItem(name = "three_tokkiText13", order = 330)
    public RString three_tokkiText13;
    @ReportItem(name = "three_tokkiText14", order = 331)
    public RString three_tokkiText14;
    @ReportItem(name = "three_tokkiText15", order = 332)
    public RString three_tokkiText15;
    @ReportItem(name = "three_tokkiImg", order = 333)
    public RString three_tokkiImg;
    @ReportItem(name = "three_hihokenshaName", length = 30, order = 334)
    public RString three_hihokenshaName;
    @ReportItem(name = "three_hokenshaNo", length = 6, order = 335)
    public RString three_hokenshaNo;
    @ReportItem(name = "three_sakuseiGengo", length = 2, order = 336)
    public RString three_sakuseiGengo;
    @ReportItem(name = "three_sakuseiYY", length = 2, order = 337)
    public RString three_sakuseiYY;
    @ReportItem(name = "three_sakuseiMM", length = 2, order = 338)
    public RString three_sakuseiMM;
    @ReportItem(name = "three_sakuseiDD", length = 2, order = 339)
    public RString three_sakuseiDD;
    @ReportItem(name = "three_chosaGengo", length = 2, order = 340)
    public RString three_chosaGengo;
    @ReportItem(name = "three_chosaYY", length = 2, order = 341)
    public RString three_chosaYY;
    @ReportItem(name = "three_chosaMM", length = 2, order = 343)
    public RString three_chosaMM;
    @ReportItem(name = "three_chosaDD", length = 2, order = 344)
    public RString three_chosaDD;
    @ReportItem(name = "three_hihokenshaNo", length = 10, order = 345)
    public RString three_hihokenshaNo;
    @ReportItem(name = "three_shinseiGengo", length = 2, order = 346)
    public RString three_shinseiGengo;
    @ReportItem(name = "three_shinseiYY", length = 2, order = 347)
    public RString three_shinseiYY;
    @ReportItem(name = "three_shinseiMM", length = 2, order = 348)
    public RString three_shinseiMM;
    @ReportItem(name = "three_shinseiDD", length = 2, order = 349)
    public RString three_shinseiDD;
    @ReportItem(name = "three_shinsaGengo", length = 2, order = 350)
    public RString three_shinsaGengo;
    @ReportItem(name = "three_shinsaYY", length = 2, order = 351)
    public RString three_shinsaYY;
    @ReportItem(name = "three_shinsaMM", length = 2, order = 352)
    public RString three_shinsaMM;
    @ReportItem(name = "three_shinsaDD", length = 2, order = 353)
    public RString three_shinsaDD;
    @ReportItem(name = "three_tokkiText", order = 354)
    public RString three_tokkiText;

    //DBE517151
    @ReportItem(name = "four_hihokenshaName", length = 30, order = 401)
    public RString four_hihokenshaName;
    @ReportItem(name = "four_hokenshaNo", length = 6, order = 402)
    public RString four_hokenshaNo;
    @ReportItem(name = "four_shinseiGengo", length = 2, order = 403)
    public RString four_shinseiGengo;
    @ReportItem(name = "four_shinseiYY", length = 2, order = 404)
    public RString four_shinseiYY;
    @ReportItem(name = "four_shinseiMM", length = 2, order = 405)
    public RString four_shinseiMM;
    @ReportItem(name = "four_shinseiDD", length = 2, order = 406)
    public RString four_shinseiDD;
    @ReportItem(name = "four_sakuseiGengo", length = 2, order = 407)
    public RString four_sakuseiGengo;
    @ReportItem(name = "four_sakuseiYY", length = 2, order = 408)
    public RString four_sakuseiYY;
    @ReportItem(name = "four_sakuseiMM", length = 2, order = 409)
    public RString four_sakuseiMM;
    @ReportItem(name = "four_sakuseiDD", length = 2, order = 410)
    public RString four_sakuseiDD;
    @ReportItem(name = "four_hihokenshaNo", length = 10, order = 411)
    public RString four_hihokenshaNo;
    @ReportItem(name = "four_chosaGengo", length = 2, order = 412)
    public RString four_chosaGengo;
    @ReportItem(name = "four_chosaYY", length = 2, order = 413)
    public RString four_chosaYY;
    @ReportItem(name = "four_chosaMM", length = 2, order = 414)
    public RString four_chosaMM;
    @ReportItem(name = "four_chosaDD", length = 2, order = 415)
    public RString four_chosaDD;
    @ReportItem(name = "four_shinsaGengo", length = 2, order = 416)
    public RString four_shinsaGengo;
    @ReportItem(name = "four_shinsaYY", length = 2, order = 417)
    public RString four_shinsaYY;
    @ReportItem(name = "four_shinsaMM", length = 2, order = 418)
    public RString four_shinsaMM;
    @ReportItem(name = "four_shinsaDD", length = 2, order = 419)
    public RString four_shinsaDD;
    @ReportItem(name = "four_imgIkensho1", order = 420)
    public RString four_imgIkensho1;

    //DBE517152
    @ReportItem(name = "five_hihokenshaName", length = 30, order = 501)
    public RString five_hihokenshaName;
    @ReportItem(name = "five_hokenshaNo", length = 6, order = 502)
    public RString five_hokenshaNo;
    @ReportItem(name = "five_shinseiGengo", length = 2, order = 503)
    public RString five_shinseiGengo;
    @ReportItem(name = "five_shinseiYY", length = 2, order = 504)
    public RString five_shinseiYY;
    @ReportItem(name = "five_shinseiMM", length = 2, order = 505)
    public RString five_shinseiMM;
    @ReportItem(name = "five_shinseiDD", length = 2, order = 506)
    public RString five_shinseiDD;
    @ReportItem(name = "five_sakuseiGengo", length = 2, order = 507)
    public RString five_sakuseiGengo;
    @ReportItem(name = "five_sakuseiYY", length = 2, order = 508)
    public RString five_sakuseiYY;
    @ReportItem(name = "five_sakuseiMM", length = 2, order = 509)
    public RString five_sakuseiMM;
    @ReportItem(name = "five_sakuseiDD", length = 2, order = 510)
    public RString five_sakuseiDD;
    @ReportItem(name = "five_hihokenshaNo", length = 10, order = 511)
    public RString five_hihokenshaNo;
    @ReportItem(name = "five_chosaGengo", length = 2, order = 512)
    public RString five_chosaGengo;
    @ReportItem(name = "five_chosaYY", length = 2, order = 513)
    public RString five_chosaYY;
    @ReportItem(name = "five_chosaMM", length = 2, order = 514)
    public RString five_chosaMM;
    @ReportItem(name = "five_chosaDD", length = 2, order = 515)
    public RString five_chosaDD;
    @ReportItem(name = "five_shinsaGengo", length = 2, order = 516)
    public RString five_shinsaGengo;
    @ReportItem(name = "five_shinsaYY", length = 2, order = 517)
    public RString five_shinsaYY;
    @ReportItem(name = "five_shinsaMM", length = 2, order = 518)
    public RString five_shinsaMM;
    @ReportItem(name = "five_shinsaDD", length = 2, order = 519)
    public RString five_shinsaDD;
    @ReportItem(name = "five_imgIkensho2", order = 520)
    public RString five_imgIkensho2;

    //DBE517016
    @ReportItem(name = "six_hihokenshaName", length = 30, order = 601)
    public RString six_hihokenshaName;
    @ReportItem(name = "six_hokenshaNo", length = 6, order = 602)
    public RString six_hokenshaNo;
    @ReportItem(name = "six_shinseiGengo", length = 2, order = 603)
    public RString six_shinseiGengo;
    @ReportItem(name = "six_shinseiYY", length = 2, order = 604)
    public RString six_shinseiYY;
    @ReportItem(name = "six_shinseiMM", length = 2, order = 605)
    public RString six_shinseiMM;
    @ReportItem(name = "six_shinseiDD", length = 2, order = 606)
    public RString six_shinseiDD;
    @ReportItem(name = "six_sakuseiGengo", length = 2, order = 607)
    public RString six_sakuseiGengo;
    @ReportItem(name = "six_sakuseiYY", length = 2, order = 608)
    public RString six_sakuseiYY;
    @ReportItem(name = "six_sakuseiMM", length = 2, order = 609)
    public RString six_sakuseiMM;
    @ReportItem(name = "six_sakuseiDD", length = 2, order = 610)
    public RString six_sakuseiDD;
    @ReportItem(name = "six_hihokenshaNo", length = 10, order = 611)
    public RString six_hihokenshaNo;
    @ReportItem(name = "six_chosaGengo", length = 2, order = 612)
    public RString six_chosaGengo;
    @ReportItem(name = "six_chosaYY", length = 2, order = 613)
    public RString six_chosaYY;
    @ReportItem(name = "six_chosaMM", length = 2, order = 614)
    public RString six_chosaMM;
    @ReportItem(name = "six_chosaDD", length = 2, order = 615)
    public RString six_chosaDD;
    @ReportItem(name = "six_shinsaGengo", length = 2, order = 616)
    public RString six_shinsaGengo;
    @ReportItem(name = "six_shinsaYY", length = 2, order = 617)
    public RString six_shinsaYY;
    @ReportItem(name = "six_shinsaMM", length = 2, order = 618)
    public RString six_shinsaMM;
    @ReportItem(name = "six_shinsaDD", length = 2, order = 619)
    public RString six_shinsaDD;
    @ReportItem(name = "six_imgSonotashiryo", order = 620)
    public RString six_imgSonotashiryo;

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

        two_tokkiText,
        two_tokkiImg,
        three_tokkiText,
        three_tokkiImg,
    }
}
